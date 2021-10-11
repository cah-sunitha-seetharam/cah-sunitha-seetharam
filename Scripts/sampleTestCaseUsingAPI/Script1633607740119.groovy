import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

//CustomKeywords.'api.apiCommonMethods.createCartOrder'()
String environmentValue = GlobalVariable.APIEnvironment

//String authorizationValue = apiCommonMethods.fetchAccessToken()
String authorizationValue = CustomKeywords.'api.apiCommonMethods.fetchAccessToken'()

def testDataObject = CustomKeywords.'api.apiCommonMethods.readAPITestData'( // API headerand url input objects 
    )

def requestObject = CustomKeywords.'common.commonMethods.readFileTypeJSON'('ordersData.json' // reading the module test data file
    )

String purchaseOrderNumber = CustomKeywords.'common.commonMethods.randomStringGenerator'(10)// creating a random string for po number

println('purchaseOrderNumber' + purchaseOrderNumber)

//		this.createOrder([ponumber: purchaseOrderNumber, dc: requestObject[environmentValue].Carts.distributionCenter, accountNumber: requestObject[environmentValue].Carts.customerAccountNumber, cin :requestObject[environmentValue].Carts.cin1, qty: requestObject[environmentValue].Carts.qty1)
def cartCreation = WS.sendRequest(findTestObject('API/Carts API - POST', [('carts-api-host') : testDataObject.apiHost.mobileCarts
            , ('env') : testDataObject[environmentValue].urlHeaderInput.environment, ('x-api-key') : testDataObject[environmentValue].urlHeaderInput.xApiKey
            , ('Authorization') : GlobalVariable.accessToken, ('user') : GlobalVariable.Username, ('UUID') : testDataObject[
            environmentValue].urlHeaderInput.UUID, ('distributionCenter') : requestObject[environmentValue].Carts.distributionCenter
            , ('customerNumber') : requestObject[environmentValue].Carts.customerAccountNumber, ('purchaseOrderNumber') : purchaseOrderNumber
            , ('cin1') : requestObject[environmentValue].Carts.cin1, ('qty1') : requestObject[environmentValue].Carts.qty1]))



