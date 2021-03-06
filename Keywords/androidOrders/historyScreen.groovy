package androidOrders
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

	/**
	 * opens the c2 order details, verifies the order status labels and signIns the password required for placing c2 order
	 * @param password (password-which is required for placing the c2 order)
	 */
	@Keyword()
	def clickOnC2OrderForReviewAndSign(String signingPassword) {
		Mobile.tap(findTestObject('Android/orders/c2OrderDetailsScreen/placeC2Order/reviewAndSign_Button'), 0)
		Mobile.tap(findTestObject('Android/orders/c2OrderDetailsScreen/placeC2Order/signatureRequired_TextvVew'), 0)
		Mobile.tap(findTestObject('Android/orders/c2OrderDetailsScreen/placeC2Order/signNow_Button'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/c2OrderDetailsScreen/placeC2Order/signatureNeeded_TextView'), 0)
		Mobile.tap(findTestObject('Android/orders/c2OrderDetailsScreen/placeC2Order/signingPassword_TextField'), 0)
		Mobile.setText(findTestObject('Android/orders/c2OrderDetailsScreen/placeC2Order/signingPassword_TextField'), signingPassword, 0)
		Mobile.tap(findTestObject('Android/orders/c2OrderDetailsScreen/placeC2Order/placeOrder_Button'), 0)
		Mobile.tap(findTestObject('Android/orders/c2OrderDetailsScreen/placeC2Order/goToOrderHistory_Button'), 0)
	}

	/**
	 * clicks on history tab button to open history tab in order history screen
	 */
	@Keyword
	def clickOnHistoryTab() {
		Mobile.tap(findTestObject('Android/orders/historyScreen/orderHistory_Tab'), 0)
		(new androidCommonKeywords.commonMethods()).waitForProgressBarToBeInvisible()
	}

	/**
	 * opens the c2 order details, verifies the order status labels and signIns the password required for placing c2 order
	 * @param password (password-which is required for placing the c2 order)
	 */
	@Keyword
	def completeReviewSignAndPlaceAnOrderFlow(String poNumber, String signingPassword) {
		Mobile.verifyElementExist(findTestObject('Android/orders/orderDetailsScreen/createC2Order/poNumberLabel_TextView',[('TEXT'):poNumber.toUpperCase()]), 0)
		Mobile.tap(findTestObject('Android/orders/orderDetailsScreen/createC2Order/poNumberLabel_TextView',[('TEXT'):poNumber.toUpperCase()]), 0)
		(new androidCommonKeywords.commonMethods()).waitForProgressBarToBeInvisible()
		Mobile.verifyElementExist(findTestObject('Android/orders/c2OrderDetailsScreen/placeC2Order/orderStatusHeld_TextView'), 0)
		Mobile.tap(findTestObject('Android/orders/c2OrderDetailsScreen/placeC2Order/signNow_Button'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/c2OrderDetailsScreen/placeC2Order/signatureNeeded_TextView'), 0)
		Mobile.sendKeys(findTestObject('Android/orders/c2OrderDetailsScreen/placeC2Order/signingPassword_TextField'), signingPassword)
		Mobile.delay(3)
		Mobile.tap(findTestObject('Android/orders/c2OrderDetailsScreen/placeC2Order/placeOrder_TextView'),0)
		(new androidCommonKeywords.commonMethods()).waitForProgressBarToBeInvisible()
		Mobile.verifyElementExist(findTestObject('Android/orders/c2OrderDetailsScreen/placeC2Order/OrderConfirmationMsg_TextView'), 0)
		Mobile.tap(findTestObject('Android/orders/c2OrderDetailsScreen/placeC2Order/goToOrderHistory_Button'), 0)
		(new androidCommonKeywords.commonMethods()).waitForProgressBarToBeInvisible()
	}

	/**
	 * get order count from order history badge count
	 */
	@Keyword
	def getOrderBadgeCount() {
		int orderCount = Mobile.getText(findTestObject('Android/orders/historyScreen/orderHistoryCount_Text'), 0).toInteger()
		KeywordUtil.logInfo("Count is " + orderCount )
		return orderCount
	}

	/**
	 * returns quantity added
	 */
	@Keyword
	def returnQuantityForScannedResultInOfflineMode() {
		String quantityAdded = Mobile.getText(findTestObject('Android/orders/historyScreen/quantity_EditText'), 0)
		return quantityAdded
	}

	/**
	 * returns po number of an top most order
	 */
	@Keyword
	def returnTopMostPoNumberOfAnOrder() {
		String PoNumberOfAnOrder = Mobile.getText(findTestObject('Android/orders/historyScreen/poNumberLabel_TextView'), 0)
		return PoNumberOfAnOrder
	}

	/**
	 * opens top most order in order history
	 */
	@Keyword
	def tapOnTopMostOrderHistory(String poNumber) {
		KeywordUtil.logInfo("PO number is " + poNumber );
		Mobile.tap(findTestObject('Android/orders/historyScreen/poNumber_PassText',[('TEXT'):poNumber]), 0)
	}

	/**
	 * verifies history screen details
	 */
	@Keyword
	def verifyHistoryScreenDetails() {
		Mobile.verifyElementExist(findTestObject('Android/orders/historyScreen/orderHistoryHeaderText_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/orderDetailsScreen/verificationDetails/Scan_Icon'),0)
		Mobile.verifyElementExist(findTestObject('Android/orders/historyScreen/orderHistory_TextView'), 0)
	}

	/**
	 * verifies order status changes from held to allocated 30 seconds after successfully placing the signed order
	 * @param poNumber (product number in order history)
	 */
	@Keyword
	def verifyOrderStatusInOrderHistoryList(String poNumber) {
		Mobile.verifyElementExist(findTestObject('Android/orders/historyScreen/orderStatusAfterPlacingOrderLabel_TextView'),  0)
		String orderStatusInHistoryScreen = Mobile.getText(findTestObject('Android/orders/historyScreen/orderStatusAfterPlacingOrderLabel_TextView'), 0)
		assert orderStatusInHistoryScreen.contains("Signature Processing")
		Mobile.verifyElementExist(findTestObject('Android/orders/orderDetailsScreen/createC2Order/poNumberLabel_TextView',[('TEXT'):poNumber.toUpperCase()]), 0)
		Mobile.tap(findTestObject('Android/orders/orderDetailsScreen/createC2Order/poNumberLabel_TextView',[('TEXT'):poNumber.toUpperCase()]), 0)
	}

	/**
	 * verifies PO Number in order history screen
	 * @param poNumber (product number in order history)
	 */
	@Keyword
	def verifyPoNumberInOrderHistoryList(String poNumber) {
		String PoNumberOfAnOrder = Mobile.getText(findTestObject('Android/orders/historyScreen/poNumberLabel_TextView'), 0)
		KeywordUtil.logInfo("Actual PO number is " + poNumber );
		KeywordUtil.logInfo("Expected PO number is " + PoNumberOfAnOrder );
		assert PoNumberOfAnOrder == ("PO #: "+poNumber)
	}
}