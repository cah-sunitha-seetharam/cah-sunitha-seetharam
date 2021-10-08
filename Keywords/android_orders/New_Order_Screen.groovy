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


class New_Order_Screen {

	@Keyword
	def change_Account(String New_Account) {

		Mobile.tap(findTestObject('Android/Dashboard/changeAccount_Button'), 0)

		Mobile.tap(findTestObject('Android/Account Selection/ChangeAccount_TextView'), 0)

		Mobile.scrollToText(New_Account, FailureHandling.STOP_ON_FAILURE)

		Mobile.tap(findTestObject('Android/Account Selection/Accounts Listing Screen/Account_No', [('val') : New_Account]), 0)

		int w = 1

		while (Mobile.verifyElementExist(findTestObject('Android/Login/Login Details Screen/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}
	}



	@Keyword
	def enter_Purchase_Order_Details(String PO_Name,String PO_Memo) {


		Mobile.tap(findTestObject('Android/Orders/New Order Page/P.O. Name (Optional)_TextField'), 0)

		Mobile.setText(findTestObject('Android/Orders/New Order Page/P.O. Name (Optional)_TextField'), PO_Name, 0)

		Mobile.pressBack()

		Mobile.tap(findTestObject('Android/Orders/New Order Page/P.O. Memo (Optional)_TextField'), 0)

		Mobile.setText(findTestObject('Android/Orders/New Order Page/P.O. Memo (Optional)_TextField'), PO_Memo, 0)

		Mobile.pressBack()
	}



	@Keyword
	def create_Order() {

		Mobile.tap(findTestObject('Android/Orders/New Order Page/Create Order_button'), 0)
		
		int w = 2

		while (Mobile.verifyElementExist(findTestObject('Android/Login/Login Details Screen/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}
	}



	@Keyword
	def click_On_NewOrder() {

		Mobile.tap(findTestObject('Android/Orders/New Order Page/New Order_Tab'), 0)
	}



	@Keyword
	def verify_NewOrder_Screen_Details() {

		Mobile.verifyElementExist(findTestObject('Android/Orders/New Order Page/Cart Header_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/New Order Page/Create a new order_TextView'),	0)

		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Orders/New Order Page/New Order_Tab'),0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/Order Details Page/Verification Details/Scan_Icon'),0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/New Order Page/Account_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/New Order Page/Change Account_TextView'), 0)
	}
}