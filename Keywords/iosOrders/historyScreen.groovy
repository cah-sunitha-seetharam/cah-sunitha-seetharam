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
import org.openqa.selenium.Keys as Keys

import com.kms.katalon.core.mobile.keyword.internal.MobileAbstractKeyword
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
import common.commonMethods


class historyScreen {

	def commonMethodsObject=new commonMethods();
	def commonIosMethodsObject=new iosCommonKeywords.commonMethods();

	@Keyword
	def verifyHistoryScreenDetails() {

		Mobile.verifyElementExist(findTestObject('iOS/Orders/History Screen/orderHistory_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/History Screen/historyScreen_Header'),  0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/History Screen/scan_Icon'),0)
	}

	/**
	 * returns quantity added
	 */
	@Keyword
	def returnQuantityForScannedResultInOfflineMode() {
		String quantityAdded = Mobile.getText(findTestObject('iOS/Orders/History Screen/quantity_Text'), 0)
	    return quantityAdded
	}

	/**
	 * opens the c2 order details, verifies the order status labels and signIns the password required for placing c2 order
	 * @param password (password-which is required for placing the c2 order)
	 */
	@Keyword
	def completeReviewSignAndPlaceAnOrderFlow(String poNumber, String signingPassword) {

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Order Details Screen/Create C2 Order/pONumber_Label',[('TEXT'):poNumber.toUpperCase()]), 0)

		Mobile.tap(findTestObject('iOS/Orders/Order Details Screen/Create C2 Order/pONumber_Label',[('TEXT'):poNumber.toUpperCase()]), 0)

		commonIosMethodsObject.waitForProgressBarToBeInvisible()

		Mobile.verifyElementExist(findTestObject('iOS/Orders/C2 Order Details Screen/Place C2 Order/orderStatus_Label'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/C2 Order Details Screen/Place C2 Order/signNow_New_Button'), 0)

		Mobile.tap(findTestObject('iOS/Orders/C2 Order Details Screen/Place C2 Order/signNow_New_Button'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/C2 Order Details Screen/Place C2 Order/signatureNeeded_Text'), 0)

		Mobile.sendKeys(findTestObject('iOS/Orders/C2 Order Details Screen/Place C2 Order/signInC2_TextField'), signingPassword)

		Mobile.delay(3)

		Mobile.sendKeys(findTestObject('iOS/Orders/C2 Order Details Screen/Place C2 Order/signInC2_TextField'), Keys.chord(Keys.RETURN))

		Mobile.delay(3)

		Mobile.tap(findTestObject('iOS/Orders/C2 Order Details Screen/Place C2 Order/placeOrder_Button'),0)

		commonIosMethodsObject.waitForProgressBarToBeInvisible()

		Mobile.tap(findTestObject('iOS/Orders/C2 Order Details Screen/Place C2 Order/goToOrderHistory_Button'), 0)

		commonIosMethodsObject.waitForProgressBarToBeInvisible()
	}



	/**
	 * clicks on history tab button to open history tab in order history screen
	 */
	@Keyword
	def clickOnHistoryTab() {

		Mobile.tap(findTestObject('iOS/Orders/History Screen/history_Text'), 0)

		commonIosMethodsObject.waitForProgressBarToBeInvisible()

		Mobile.verifyElementExist(findTestObject('iOS/Orders/History Screen/historyScreen_Header'),  0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/History Screen/scan_Icon'),0)
	}

	/**
	 * returns po number of an top most order 
	 */
	@Keyword
	def returnTopMostPoNumberOfAnOrder () {
		String PoNumberOfAnOrder = Mobile.getText(findTestObject('Object Repository/iOS/Orders/History Screen/poNumber_Text'), 0)
		return PoNumberOfAnOrder
	}

	/**
	 * opens top most order in order history
	 */
	@Keyword
	def tapOnTopMostOrderHistory(String poNumber) {
		Mobile.tap(findTestObject('iOS/Orders/History Screen/PONumberLabel_Text', [('TEXT'):poNumber]), 0)
	}

	/**
	 * verifies order status changes from held to allocated 30 seconds after successfully placing the signed order
	 */
	@Keyword
	def verifyOrderStatusInOrderHistoryList(String poNumber) {

		Mobile.verifyElementExist(findTestObject('iOS/Orders/History Screen/orderStatusAfterPlacingOrder_Label'),  0)

		String orderStatusInHistoryScreen = Mobile.getText(findTestObject('iOS/Orders/History Screen/orderStatusAfterPlacingOrder_Label'), 0)

		assert orderStatusInHistoryScreen.contains("Allocated")

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Order Details Screen/Create C2 Order/pONumber_Label',[('TEXT'):poNumber.toUpperCase()]), 0)

		Mobile.tap(findTestObject('iOS/Orders/Order Details Screen/Create C2 Order/pONumber_Label',[('TEXT'):poNumber.toUpperCase()]), 0)

		commonIosMethodsObject.waitForProgressBarToBeInvisible()

		String orderStatusInOrderDetailsScreen = Mobile.getText(findTestObject('iOS/Orders/History Screen/orderStatusInOrderDetails_Label'), 0)

		assert orderStatusInOrderDetailsScreen.contains("Allocated")
	}
	
	
	/**
	 * verifies PO Number in order history screen
	 */
	@Keyword
	def verifyPoNumberInOrderHistoryList(String poNumber) {

		String PoNumberOfAnOrder = Mobile.getText(findTestObject('iOS/Orders/History Screen/poNumber_Text'), 0)
		KeywordUtil.logInfo("Actual PO number is " + poNumber );
		KeywordUtil.logInfo("Expected PO number is " + PoNumberOfAnOrder );
		assert PoNumberOfAnOrder == ("PO #: "+poNumber)
	}
}