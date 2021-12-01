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


class historyScreen {

	@Keyword
	def verify_History_Screen_Details() {

		Mobile.verifyElementExist(findTestObject('iOS/Orders/History Screen/OrderHistory_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/History Screen/History Page_Header'),  0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/History Screen/Scan_Icon'),0)
	}



	/**
	 * opens the c2 order details, verifies the order status labels and signIns the password required for placing c2 order
	 * @param password (password-which is required for placing the c2 order)
	 */
	@Keyword
	def clickOnC2OrderForReviewAndSign(String signingPassword) {

		Mobile.verifyElementExist(findTestObject('iOS/Orders/C2 Order Details Screen/Place C2 Order/orderHeld_Label'), 0)

		Mobile.tap(findTestObject('iOS/Orders/Create C2 Order/pONumber_Label'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/C2 Order Details Screen/Place C2 Order/orderStatus_Label'), 0)

		Mobile.tap(findTestObject('iOS/Orders/C2 Order Details Screen/Place C2 Order/signNow_Button'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/C2 Order Details Screen/Place C2 Order/signatureNeeded_Text'), 0)

		Mobile.setText(findTestObject('iOS/Orders/C2 Order Details Screen/Place C2 Order/signInC2_TextField'), signingPassword, 0)

		Mobile.tap(findTestObject('iOS/Product Search/returnKeypad_Button'),0)

		Mobile.tap(findTestObject('iOS/Orders/C2 Order Details Screen/Place C2 Order/placeOrder_Text'),0)

		Mobile.tap(findTestObject('iOS/Orders/C2 Order Details Screen/Place C2 Order/goToOrderHistory_Button'), 0)
	}
}