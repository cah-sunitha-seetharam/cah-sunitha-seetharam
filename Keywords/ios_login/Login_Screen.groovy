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


	@Keyword()
	def login(password) {

		select_Environment()
		enter_Username()
		enter_Password(password)
		click_On_SignIn_Button()
	}




	@Keyword()
	def select_Environment() {

		if (Mobile.verifyElementExist(findTestObject('iOS/LogIn/Environment_Selection_Screen/Environment Selection_Text'),5, FailureHandling.OPTIONAL)) {

			Mobile.tap(findTestObject('iOS/LogIn/Environment_Selection_Screen/Environment Selection_Text'), 0, FailureHandling.STOP_ON_FAILURE)

			Mobile.tap(findTestObject('iOS/LogIn/Environment_Selection_Screen/Environment_Button',[('TEXT'):GlobalVariable.Environment]),0)
		}
	}





	@Keyword()
	def enter_Username() {

		Mobile.tap(findTestObject('iOS/LogIn/Login_Details_Screen/Login UserName_Button'), 0)

		Mobile.setText(findTestObject('iOS/LogIn/Login_Details_Screen/UserName_Text_Field'), GlobalVariable.Username, 0)

		Mobile.tap(findTestObject('iOS/LogIn/Login_Details_Screen/LoginBar-ButtonDown'), 0)
	}




	@Keyword()
	def enter_Password(String password) {

		Mobile.tap(findTestObject('iOS/LogIn/Login_Details_Screen/Password-Button'), 0)

		Mobile.setText(findTestObject('iOS/LogIn/Login_Details_Screen/Password-Secure_Text_Field'), password, 0)
	}




	@Keyword()
	def click_On_SignIn_Button() {

		Mobile.tap(findTestObject('iOS/LogIn/Login_Details_Screen/SignIn_Button'),0)
	}




	@Keyword()
	def click_On_Forgot_Password() {

		Mobile.tap(findTestObject('Object Repository/Login/Login_Details_Screen/Forget_Password'), 0)
	}




	@Keyword()
	def verify_LoginPage_Details() {


		Mobile.verifyElementExist(findTestObject('iOS/LogIn/Login_Details_Screen/Forget_Password_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/LogIn/Login_Details_Screen/Welcome_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/LogIn/Login_Details_Screen/Order Express_Logo'), 0)
	}
}


