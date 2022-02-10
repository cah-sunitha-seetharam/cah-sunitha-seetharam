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

	/**
	 * taps on create order button to create an order and takes user to the order details screen
	 */
	@Keyword
	def createOrder() {

		Mobile.tap(findTestObject('iOS/orders/newOrderScreen/createOrder_Button'), 0)
	}



	/**
	 * enters purchase order details for the order to be created
	 * @param poName (purchase order name for the order created)
	 * @param poMemo (purchase order memo for the order created)
	 */
	@Keyword
	def enterPurchaseOrderDetails(String poName,String poMemo) {

		Mobile.tap(findTestObject('iOS/orders/newOrderScreen/editPOName_Button'), 0)

		Mobile.setText(findTestObject('iOS/orders/newOrderScreen/poName_TextField'), poName, 0)

		Mobile.tapAndHold(findTestObject('iOS/productSearch/globalSearch/returnKeypad_Button'),0,0)

		Mobile.tap(findTestObject('iOS/orders/newOrderScreen/editPOMemo_Button'), 0)

		Mobile.setText(findTestObject('iOS/orders/newOrderScreen/poMemo_TextField'), poMemo,0)
	}


	/**
	 * verifies new order screen when user creates an order
	 */
	@Keyword
	def verifyNewOrderScreenDetails() {

		Mobile.verifyElementExist(findTestObject('iOS/orders/newOrderScreen/createANewOrder_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/orders/newOrderScreen/account_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/orders/newOrderScreen/purchaseOrderDetails_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/orders/newOrderScreen/changeAccount_Text'), 0)

		Mobile.verifyElementExist(findTestObject('Object Repository/iOS/orders/newOrderScreen/newOrderScreen_Header'), 0)
	}
}