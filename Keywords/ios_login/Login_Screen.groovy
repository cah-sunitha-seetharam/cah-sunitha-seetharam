package ios_login
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
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
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile


class Login_Screen {


	/**
	 * performs login function
	 * @param username,password
	 */
	@Keyword()
	def login(username,password) {

		select_type_Of_Testing()
		select_Environment()
		enter_Username(username)
		enter_Password(password)
		click_On_SignIn_Button()
	}



	/**
	 * selects the environment
	 */
	@Keyword()
	def select_Environment() {

		if (Mobile.verifyElementExist(findTestObject('iOS/LogIn/Environment_Selection_Screen/environmentList_Button'),5, FailureHandling.OPTIONAL)) {

			Mobile.tap(findTestObject('iOS/LogIn/Environment_Selection_Screen/environmentList_Button'), 0, FailureHandling.STOP_ON_FAILURE)

			if(GlobalVariable.Environment=="PMODStg")

				Mobile.tap(findTestObject('iOS/LogIn/Environment_Selection_Screen/Environment_Button',[('TEXT'):"PMODSTG"]),0) //HardCoding because of the difference in name PMODSTG/PMODStg in iOS and Android

			else

				Mobile.tap(findTestObject('iOS/LogIn/Environment_Selection_Screen/Environment_Button',[('TEXT'):GlobalVariable.Environment]),0)

		}
	}



	/**
	 * selects type of testing
	 * @param testingType
	 */
	@Keyword()
	def select_type_Of_Testing(String testingType='Automation') {

		if (Mobile.verifyElementExist(findTestObject('iOS/LogIn/Testing Type/testingMode_Button'),5, FailureHandling.OPTIONAL)) {

			Mobile.tap(findTestObject('iOS/LogIn/Testing Type/testingMode_Button'), 0)

			Mobile.tap(findTestObject('iOS/LogIn/Testing Type/testingType_Button',[('TEXT'):testingType]), 0)
		}
	}



	/**
	 * enters the username
	 * @param username
	 */
	@Keyword()
	def enter_Username(String username) {

		Mobile.waitForElementPresent(findTestObject('iOS/LogIn/Login_Details_Screen/loginUserName_Button'), 0)

		Mobile.tap(findTestObject('iOS/LogIn/Login_Details_Screen/loginUserName_Button'), 0)

		Mobile.setText(findTestObject('iOS/LogIn/Login_Details_Screen/userName_TextField'), username, 0)

		Mobile.tap(findTestObject('iOS/LogIn/Login_Details_Screen/loginBar_buttonDown'), 0)
	}




	/**
	 * enters the password
	 * @param password
	 */
	@Keyword()
	def enter_Password(String password) {

		Mobile.tap(findTestObject('iOS/LogIn/Login_Details_Screen/password_Button'), 0)

		Mobile.setText(findTestObject('iOS/LogIn/Login_Details_Screen/passwordSecure_TextField'), password, 0)
	}



	/**
	 * clicks on signIn button
	 * @param password
	 */
	@Keyword()
	def click_On_SignIn_Button() {

		Mobile.tap(findTestObject('iOS/LogIn/Login_Details_Screen/SignIn_Button'),0)
	}



	/**
	 * clicks on forget password button
	 */
	@Keyword()
	def click_On_Forgot_Password() {

		Mobile.tap(findTestObject('Object Repository/Login/Login_Details_Screen/Forget_Password'), 0)
	}



	/**
	 * verifies the details of login Page
	 */
	@Keyword()
	def verify_LoginPage_Details() {


		Mobile.verifyElementExist(findTestObject('iOS/LogIn/Login_Details_Screen/forgetPassword_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/LogIn/Login_Details_Screen/welcome_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/LogIn/Login_Details_Screen/orderExpress_Logo'), 0)
	}
}


