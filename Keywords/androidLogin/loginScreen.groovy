package androidLogin
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

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
import androidCommonKeywords.commonMethods



class loginScreen {
	
//	 def commonMethodsObject=new commonMethods();
	


	/**
	 * performs login function by selecting environment of testing(taken from the global profile), entering user-name and password
	 * @param username (it is taken from the global profile but passed as a parameter),password  (it is taken from the global profile but passed as a parameter)
	 */
	@Keyword()
	def login(username,password) {

		selectEnvironment()
		enterUsername(username)
		enterPassword(password)
		clickOnSignInButton()
		(new androidCommonKeywords.commonMethods()).waitForProgressBarToBeInvisible()
//		commonMethodsObject.waitForProgressBarToBeInvisible()
//		WebUI.delay(3)	
	}



	/**
	 * selects the environment of testing which is taken from the global profile
	 */
	@Keyword
	def selectEnvironment() {

		if (Mobile.verifyElementExist(findTestObject('Android/login/environmentSelectionScreen/Environment_Spinner'),5, FailureHandling.OPTIONAL)) {

			Mobile.tap(findTestObject('Android/login/environmentSelectionScreen/Environment_Spinner'), 0)

			Mobile.tap(findTestObject('Android/login/environmentSelectionScreen/environmentSelection_TextView',[('TEXT'):GlobalVariable.Environment]),0)

			Mobile.tap(findTestObject('Android/login/environmentSelectionScreen/proceed_Button'), 0)
		}
	}



	/**
	 * enters the user-name
	 * @param username (it is taken from the global profile but passed as a parameter)
	 */
	@Keyword()
	def enterUsername(String username) {

		Mobile.tap(findTestObject('Android/login/loginDetailsScreen/username_TextField'), 0)

		Mobile.setText(findTestObject('Android/login/loginDetailsScreen/username_TextField'), username, 0)
	}



	/**
	 * enters the password
	 * @param password (it is taken from the global profile but passed as a parameter)
	 */
	@Keyword()
	def enterPassword(String password) {

		Mobile.tap(findTestObject('Android/login/loginDetailsScreen/password_TextField'), 0)

		Mobile.setText(findTestObject('Android/login/loginDetailsScreen/password_TextField'), password, 0)
	}


	/**
	 * clicks on signIn button and takes to the dash-board of the application
	 */
	@Keyword()
	def clickOnSignInButton() {

		Mobile.tap(findTestObject('Android/login/loginDetailsScreen/signIn_Button'), 0)
	}



	/**
	 * clicks on forget password button
	 */
	@Keyword()
	def clickOnForgotPassword() {

		Mobile.tap(findTestObject('Android/login/loginDetailsScreen/forgotPassword_Button'), 0)
	}



	/**
	 * verifies the details of login Page
	 */
	@Keyword()
	def verifyLoginPageDetails() {

		Mobile.verifyElementExist(findTestObject('Android/login/loginDetailsScreen/forgotPassword_Button'), 0)

		Mobile.verifyElementExist(findTestObject('Android/login/loginDetailsScreen/cardinalHealth_Logo'), 0)

		Mobile.verifyElementExist(findTestObject('Android/login/loginDetailsScreen/welcomeBack_TextView'), 0)
	}
}


