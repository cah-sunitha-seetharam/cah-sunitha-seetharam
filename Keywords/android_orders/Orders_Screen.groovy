package android_orders
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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile


class Orders_Screen {


	@Keyword
	def click_On_NewOrder() {

		Mobile.tap(findTestObject('Android/Orders/New Order Page/New Order_Tab'), 0)
	}



	@Keyword
	def click_On_History_Tab() {

		Mobile.tap(	findTestObject('Object Repository/Android/Orders/History Page/History_Tab'), 0)
	}




	@Keyword
	def click_On_Cart_Tab() {

		Mobile.tap(findTestObject('Android/Orders/Cart Page/Verifictaion Details/Cart_Tab'), 0)
	}


	@Keyword
	def change_Account(String new_Account) {


		Mobile.tap(findTestObject('Android/Dashboard/changeAccount_Button'), 0)

		Mobile.tap(findTestObject('Android/Account Selection/ChangeAccount_TextView'), 0)

		while (Mobile.verifyElementNotVisible(findTestObject('Android/Account Selection/AccountNo_TextView',[('val') : new_Account]), 2, FailureHandling.OPTIONAL)) {
			Mobile.swipe(600, 800, 600, 200)
		}
		Mobile.tap(findTestObject('Android/Account Selection/AccountNo_TextView',[('val') : new_Account]), 0)

		int w = 1

		while (Mobile.verifyElementExist(findTestObject('Android/Login/Login Details Screen/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}
	}
}