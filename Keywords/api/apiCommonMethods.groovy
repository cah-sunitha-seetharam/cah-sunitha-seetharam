package api

import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper
import common.commonMethods
//import io.restassured.RestAssured;
//import io.restassured.http.Method;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;


class apiCommonMethods {
	/**
	 * Send login and token generation calls(based on environment value fetched from profile, to get authorization token
	 * @return authorizationValue fetched from token generator API 
	 */
	@Keyword
	def fetchAccessToken() {
		int expectedStatusCode = 200
		String apiEnvironment = GlobalVariable.APIEnvironment
		def testDataObject = this.readAPITestData();
		ResponseObject loginResponse = WS.sendRequest(findTestObject('API/Login Request API', [('login-api-host') : testDataObject[apiEnvironment].urlHeaderInput.loginHost, ('target') : testDataObject[apiEnvironment].urlHeaderInput.target
			, ('password') : GlobalVariable.Password, ('smagentname') : testDataObject[apiEnvironment].urlHeaderInput.smagentname, ('user') : GlobalVariable.Username]))

		HashMap<String,String> headerProperties = loginResponse.getHeaderFields()
		//
		List<String> list = new ArrayList<String>(headerProperties.values());
		List<HttpCookie> cookies = HttpCookie.parse(list.get(9).toString());
		KeywordUtil.logInfo("test"+list.get(9)+"check")
		KeywordUtil.logInfo("test"+cookies+"check")
		String SmSession1 = cookies[0].value
		boolean fieldExist = false
		GlobalVariable.SmSession =  SmSession1

		//		if (loginResponse.getStatusCode() == expectedStatusCode) {
		//			HashMap < String, String > headerProperties = loginResponse.getHeaderFields()
		//			List < String > list = new ArrayList < String > (headerProperties.values());
		////			list.each {  val -> println val  }
		//			String SmSession
		//			//			print(GlobalVariable.APIEnvironment+ "modStagepmodStage")
		//			if(GlobalVariable.APIEnvironment == "pmodStage") {
		//				List < HttpCookie > cookies = HttpCookie.parse(list.get(9).toString()); // position of SMSESSION value on the header response
		//				cookies.each {  val -> println val  }
		//				SmSession = cookies[0].value
		//			}
		//			else {
		//				//				print(GlobalVariable.APIEnvironment+ "modStagepmodStage")
		//				List < HttpCookie > cookies = HttpCookie.parse(list.get(4).toString()); // position of SMSESSION value on the header response
		//				//				print(cookies+ "cookies")
		//				SmSession = cookies[0].value
		//			}
		//			boolean fieldExist = false
		//			GlobalVariable.SmSession = SmSession  // setting the smsession value to global variable for subsequent calls (scope is test suite)
		//			println('sm session+' + SmSession)
		String authorizationValue = this.tokenGenerator()

		if (authorizationValue != null) {
			return authorizationValue
			KeywordUtil.markPassed("Token generated")
		}

	}
	/**
	 * Send token generation calls to get authorization token
	 * @param environmentValue referring to test data object key e.g.pmodStage
	 * @return the access token value 
	 */
	@Keyword
	def tokenGenerator() {
		String environmentValue = GlobalVariable.APIEnvironment
		def testDataObject = this.readAPITestData()

		ResponseObject tokenGeneratorResponse = WS.sendRequest(findTestObject('API/Token Generator API', [('token-generator-api-host') : testDataObject.apiHost.tokenGenerator, ('env') : testDataObject[environmentValue].urlHeaderInput.environment, ('user') : GlobalVariable.Username
			, ('smsession') : GlobalVariable.SmSession, ('x-api-key') : testDataObject[environmentValue].urlHeaderInput.xApiKey]))

		if (tokenGeneratorResponse.getStatusCode() == 200) {
			JsonSlurper slurper = new JsonSlurper()
			Map parsedJson = slurper.parseText(tokenGeneratorResponse.getResponseText())
			String accessToken = parsedJson.values() // assigning the value property which hold the access token
			accessToken = accessToken.replaceAll("\\[", "");  // trimming the trailing characters
			accessToken = accessToken.replaceAll("\\]", "");
			GlobalVariable.accessToken = accessToken// setting the accessToken value to global variable for subsequent calls (scope is test suite)
			return accessToken;
		}
		else {
			KeywordUtil.markFailed(" tokenGenerator call failed with code:" + tokenGeneratorResponse.getStatusCode())
		}
	}
	/**
	 * Create an order using Carts Post method , the input is fetched from the (module) ordersDatajson file set on Data Files 
	 * @return an object with orderId and purchaseOrderNumber 
	 */
	@Keyword
	def createCartOrder() {
		String environmentValue = GlobalVariable.APIEnvironment
		String authorizationValue = this.fetchAccessToken()
		def testDataObject = this.readAPITestData()
		def RequestObject = commonMethods.readFileTypeJSON("ordersData.json")  // reading the module test data file
		def String purchaseOrderNumber  = commonMethods.randomStringGenerator(10)  // creating a random string for po number
		//		this.createOrder([ponumber: purchaseOrderNumber, dc: RequestObject[environmentValue].Carts.distributionCenter, accountNumber: RequestObject[environmentValue].Carts.customerAccountNumber, cin :RequestObject[environmentValue].Carts.cin1, qty: RequestObject[environmentValue].Carts.qty1)
		ResponseObject cartCreation = WS.sendRequest(findTestObject('API/Carts API - POST', [('carts-api-host') : testDataObject.apiHost.mobileCarts, ('env') : testDataObject[environmentValue].urlHeaderInput.environment, ('x-api-key') : testDataObject[environmentValue].urlHeaderInput.xApiKey, ('Authorization') : GlobalVariable.accessToken
			, ('user') : GlobalVariable.Username, ('UUID') : testDataObject[environmentValue].urlHeaderInput.UUID, ('distributionCenter') : RequestObject[environmentValue].Carts.distributionCenter, ('customerNumber') : RequestObject[environmentValue].Carts.customerAccountNumber, ('purchaseOrderNumber') : purchaseOrderNumber
			, ('cin1') : RequestObject[environmentValue].Carts.cin1, ('qty1') : RequestObject[environmentValue].Carts.qty1]))

	}
	/**
	 * Create an order using Carts Post method , the input is fetched from the (module) ordersDatajson file set on Data Files
	 * @param purchaseOrderNumber
	 * @param DC number
	 * @param Customer Account Number
	 * @param product CIN
	 * @param product quantity 
	 * @return an object with orderId and purchaseOrderNumber
	 */
	@Keyword
	//	def static createOrder(Map apiData, String poName,String dcNumber, String customerAccountNumber, String cin, String qty) {
	def static createOrder(Map requestObject, def object) {
		//			println(requestObject)
		//
		////			println(poName)
		////			println(dcNumber)
		////			println(customerAccountNumber)
		////			println(qty)
		////			println(cin)
		//			String environmentValue = GlobalVariable.APIEnvironment
		//			String poNameValue = ('MobileAutomated' + poName)
		//			def testDataObject = apiData
		//			ResponseObject cartRequestResponse = WS.sendRequest(findTestObject('API/Carts API - POST', [('carts-api-host') : testDataObject.apiHost.mobileCarts, ('env') : testDataObject[environmentValue].urlHeaderInput.environment, ('x-api-key') : testDataObject[environmentValue].urlHeaderInput.xApiKey, ('Authorization') : GlobalVariable.accessToken
		//				, ('user') : GlobalVariable.Username, ('UUID') : testDataObject[environmentValue].urlHeaderInput.UUID, ('distributionCenter') : dcNumber, ('customerNumber') : customerAccountNumber, ('purchaseOrderNumber') : poNameValue
		//				, ('cin') : cin, ('quantity') : qty]))
		//
		//
		//			if(cartRequestResponse.getStatusCode() == 200) {
		//				KeywordUtil.markPassed("cartCreation API call success")
		//				return cartRequestResponse
		//			}
		//			else {
		//				KeywordUtil.markFailed(" createCartOrder API call failed with code:" + cartRequestResponse.getStatusCode())
		//			}
	}
	/**
	 * Fetches the API test data file from project Data files path
	 * @param expectedStatusCode
	 * @return the test data JSON object
	 */
	@Keyword
	def readAPITestData() {
		def String fileName='apiData.json'
		def testDataObject= commonMethods.readFileTypeJSON(fileName.toString())
		return testDataObject
		//		return CustomKeywords.'common.commonMethods.readFileTypeJSON'(fileName.toString())
	}
}



