package android_login
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


class Login_Screen {


	@Keyword()
	def login(password) {

		select_Environment()
		enter_Username()
		enter_Password(password)
		click_On_SignIn_Button()
	}




	@Keyword
	def select_Environment() {

		if (Mobile.verifyElementExist(findTestObject('Android/Login/Environment Selecttion Screen/Environment_Spinner'),5, FailureHandling.OPTIONAL)) {

			Mobile.tap(findTestObject('Android/Login/Environment Selecttion Screen/Environment_Spinner'), 0)

			Mobile.tap(findTestObject('Android/Login/Environment Selecttion Screen/environmentSelection_TextView',[('TEXT'):GlobalVariable.Environment]),0)

			Mobile.tap(findTestObject('Android/Login/Environment Selecttion Screen/Proceed_Button'), 0)
		}
	}




	@Keyword()
	def enter_Username() {

		Mobile.tap(findTestObject('Android/Login/Login Details Screen/Username_TextField'), 0)

		Mobile.setText(findTestObject('Android/Login/Login Details Screen/Username_TextField'), GlobalVariable.Username, 0)
	}




	@Keyword()
	def enter_Password(String password) {

		Mobile.tap(findTestObject('Android/Login/Login Details Screen/Password_TextField'), 0)

		Mobile.setText(findTestObject('Android/Login/Login Details Screen/Password_TextField'), password, 0)
	}



	@Keyword()
	def click_On_SignIn_Button() {

		int w = 1

		Mobile.tap(findTestObject('Android/Login/Login Details Screen/signIn_Button'), 0)

		while (Mobile.verifyElementExist(findTestObject('Android/Login/Login Details Screen/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}
	}




	@Keyword()
	def click_On_Forgot_Password() {

		Mobile.tap(findTestObject('Android/Login/Login Details Screen/forgotPassword_Button'), 0)
	}




	@Keyword()
	def verify_Login_Page_Details() {

		Mobile.verifyElementExist(findTestObject('Android/Login/Login Details Screen/forgotPassword_Button'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Login/Login Details Screen/cardinalHealth_Logo'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Login/Login Details Screen/welcomeBack_TextView'), 0)
	}
}


