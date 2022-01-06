package iosLogin
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


class loginScreen {


	/**
	 * performs login function by selecting the type of testing (automation or manual), environment of testing(taken from the global profile), entering user-name and password
	 * @param username (it is taken from the global profile but passed as a parameter),password  (it is taken from the global profile but passed as a parameter)
	 */
	@Keyword()
	def login(username,password) {

		cancelUpdatePopUp()
		selectTypeOfTesting()
		selectEnvironment()
		enterUsername(username)
		enterPassword(password)
		clickOnSignInButton()
	}



	/**
	 * selects the environment of testing which is taken from the global profile
	 */
	@Keyword()
	def selectEnvironment() {

		if (Mobile.verifyElementExist(findTestObject('iOS/LogIn/Environment_Selection_Screen/environmentList_Button'),5, FailureHandling.OPTIONAL)) {

			Mobile.tap(findTestObject('iOS/LogIn/Environment_Selection_Screen/environmentList_Button'), 0, FailureHandling.STOP_ON_FAILURE)

			if(GlobalVariable.Environment=="PMODStg")

				Mobile.tap(findTestObject('iOS/LogIn/Environment_Selection_Screen/Environment_Button',[('TEXT'):"PMODSTG"]),0) //HardCoding because of the difference in name PMODSTG/PMODStg in iOS and Android

			else

				Mobile.tap(findTestObject('iOS/LogIn/Environment_Selection_Screen/Environment_Button',[('TEXT'):GlobalVariable.Environment]),0)

		}
	}



	/**
	 * selects type of testing which can be manual or automation
	 * @param testingType (directly passed as a parameter for automation)
	 */
	@Keyword()
	def selectTypeOfTesting(String testingType='Automation') {

		if (Mobile.verifyElementExist(findTestObject('iOS/LogIn/Testing Type/testingMode_Button'),10, FailureHandling.OPTIONAL)) {

			Mobile.tap(findTestObject('iOS/LogIn/Testing Type/testingMode_Button'), 0)

			Mobile.tap(findTestObject('iOS/LogIn/Testing Type/testingType_Button',[('TEXT'):testingType]), 0)
		}
	}



	/**
	 * enters the user-name
	 * @param username (it is taken from the global profile but passed as a parameter)
	 */
	@Keyword()
	def enterUsername(String username) {

		Mobile.waitForElementPresent(findTestObject('iOS/LogIn/Login_Details_Screen/loginUserName_Button'), 0)

		Mobile.tap(findTestObject('iOS/LogIn/Login_Details_Screen/loginUserName_Button'), 0)

		Mobile.setText(findTestObject('iOS/LogIn/Login_Details_Screen/userName_TextField'), username, 0)

		//Mobile.tap(findTestObject('iOS/LogIn/Login_Details_Screen/loginBar_buttonDown'), 0)
	}

	
	/**
	 * performs re-login with username and password
	 * @param username password (it is taken from the global profile but passed as a parameter)
	 */
	@Keyword()
	def reLogin(String username, String password ) {
		Mobile.tap(findTestObject('iOS/LogIn/Login_Details_Screen/loginUserName_Button'), 0)
		Mobile.setText(findTestObject('iOS/LogIn/Login_Details_Screen/userName_TextField'), username, 0)
		Mobile.tap(findTestObject('iOS/LogIn/Login_Details_Screen/password_Button'), 0)
		Mobile.tap(findTestObject('iOS/LogIn/Login_Details_Screen/password_Button'), 0)
		Mobile.setText(findTestObject('iOS/LogIn/Login_Details_Screen/passwordSecure_TextField'), password, 0)
		Mobile.tap(findTestObject('iOS/LogIn/Login_Details_Screen/SignIn_Button'),0)
	}


	/**
	 * enters the password
	 * @param password (it is taken from the global profile but passed as a parameter)
	 */
	@Keyword()
	def enterPassword(String password) {

		Mobile.tap(findTestObject('iOS/LogIn/Login_Details_Screen/password_Button'), 0)

		Mobile.setText(findTestObject('iOS/LogIn/Login_Details_Screen/passwordSecure_TextField'), password, 0)
	}



	/**
	 * clicks on signIn button and takes to the dash-board of the application
	 */
	@Keyword()
	def clickOnSignInButton() {

		Mobile.tap(findTestObject('iOS/LogIn/Login_Details_Screen/SignIn_Button'),0)
	}



	/**
	 * clicks on forget password button
	 */
	@Keyword()
	def clickOnForgotPassword() {

		Mobile.tap(findTestObject('Object Repository/Login/Login_Details_Screen/Forget_Password'), 0)
	}



	/**
	 * verifies the details of login Page
	 */
	@Keyword()
	def verifyLoginPageDetails() {

		Mobile.verifyElementExist(findTestObject('iOS/LogIn/Login_Details_Screen/forgetPassword_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/LogIn/Login_Details_Screen/welcome_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/LogIn/Login_Details_Screen/orderExpress_Logo'), 0)
	}
	
	
	
	/**
	 * taps on cancel button for update if popUp is visible
	 */
	@Keyword()
	def cancelUpdatePopUp() {

		Mobile.tap(findTestObject('iOS/LogIn/Login_Details_Screen/cancelUpdate_Button'), 5,FailureHandling.OPTIONAL)

	}
}