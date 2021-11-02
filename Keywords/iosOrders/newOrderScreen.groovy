package iosOrders
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


class newOrderScreen {

	@Keyword
	def change_Account(String new_Account) {


		Mobile.tap(findTestObject('iOS/Account_Selection/Change Account_Text'), 0)

		Mobile.tap(findTestObject('iOS/Account_Selection/Change_Account_Navigation'), 0)

		Mobile.scrollToText(New_Account, FailureHandling.STOP_ON_FAILURE)

		Mobile.tap(findTestObject('iOS/Account_Selection/AccountNo_Text', [('val') : new_Account]), 0)

		int w = 1

		while (Mobile.verifyElementExist(findTestObject('iOS/Product_Search/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}
	}




	@Keyword
	def enter_Purchase_Order_Details(String po_Name,String po_Memo) {


		Mobile.tapAndHold(findTestObject('iOS/Orders/Order Details Screen/Edit PO Name and Memo/PO Name_TextField'), 0, 0)

		Mobile.setText(findTestObject('iOS/Orders/Order Details Screen/Edit PO Name and Memo/PO Name_TextField'), po_Name, 0)

		Mobile.tap(findTestObject('iOS/Product_Search/Return Keypad_Button'), 0)

		Mobile.tapAndHold(findTestObject('iOS/Orders/Order Details Screen/Edit PO Name and Memo/poMemo Field_Button'), 0, 0)

		Mobile.setText(	findTestObject('iOS/Orders/Order Details Screen/Edit PO Name and Memo/poMemoField_TextField'),po_Memo, 0)

		Mobile.tap(findTestObject('iOS/Product_Search/Return Keypad_Button'), 0)
	}



	/**
	 * taps on create order button to create an order
	 */
	@Keyword
	def createOrder() {

		Mobile.tap(	findTestObject('iOS/Orders/New Order Screen/Create Order_Button'), 0)
	}




	@Keyword
	def verify_NewOrder_Screen_Details() {

		Mobile.verifyElementExist(findTestObject('iOS/Orders/New Order Screen/Create a new order_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/New Order Screen/Account_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/New Order Screen/Purchase Order Details_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/New Order Screen/Change Account_Text'), 0)
	}
}