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


class cartScreen  {

	/**
	 * opens the c2 orders tab
	 */
	@Keyword
	def clickOnC2OrdersTab() {
		Mobile.tap(findTestObject('Android/orders/cartScreen/c2Order/c2Orders_Tab'), 0)
	}

	/**
	 * clicks on continue on desktop button on cart screen
	 */
	@Keyword
	def clickOnContinueOnDesktop() {
		Mobile.tap(findTestObject('Android/orders/cartScreen/uploadAllOrders/continueOnDesktop_Button'), 0)
	}

	/**
	 * opens the nonc2 orders tab
	 */
	@Keyword
	def clickOnNonC2OrdersTab() {
		Mobile.tap(findTestObject('Android/orders/cartScreen/nonC2Order/nonC2OrdersTab_TextView'), 0)
	}

	/**
	 * clicks on place all orders button on cart screen
	 */
	@Keyword
	def clickOnPlaceAllOrders() {
		Mobile.tap(findTestObject('Android/orders/cartScreen/placeAllOrders/placeAllOrders_Button'), 0)
	}

	/**
	 * clicks on upload all orders button on cart screen
	 */
	@Keyword
	def clickOnUploadAllOrders() {
		Mobile.tap(findTestObject('Android/orders/cartScreen/uploadAllOrders/uploadAllOrders_Button'), 0)
	}

	/**
	 * clicks on place my orders button on cart screen
	 */
	@Keyword
	def confirmPlacingAllOrders() {
		Mobile.tap(findTestObject('Android/orders/cartScreen/placeAllOrders/placeMyOrders_Button'),0)
	}

	/**
	 * delete's the order from the cart screen based on the purchase order name
	 * @param poName (purchase order name of the order)
	 */
	@Keyword
	def deleteOrder(poName) {
		int ElementTopPosition=Mobile.getElementTopPosition(findTestObject('Android/orders/ordersCommonScreen/parametrizedOrderName_TextView',[('TEXT'):poName]),  0)
		int ElementHeight=Mobile.getElementHeight(findTestObject('Android/orders/ordersCommonScreen/parametrizedOrderName_TextView',[('TEXT'):poName]),  0)
		int yCoordinateToSwipe=(ElementHeight/2)+ElementTopPosition
		Mobile.swipe(300, yCoordinateToSwipe, 0, yCoordinateToSwipe)
		Mobile.tap(findTestObject('Android/orders/cartScreen/deleteOrder/yes_Button'), 0)
	}

	/**
	 * opens the order details page
	 * @param poName (purchase order name used to create the order)
	 */
	@Keyword
	def openAnOrderDetail(String poName) {
		Mobile.tap(findTestObject('Android/orders/ordersCommonScreen/orderListOrderName_TextView',[('TEXT'):poName]), 0)
	}

	/**
	 * opens the c2 order details
	 */
	@Keyword
	def openC2OrderDetails() {
		Mobile.tap(findTestObject('Android/orders/c2OrderDetailsScreen/createdOrder_Text'), 0)
		(new androidCommonKeywords.commonMethods()).waitForProgressBarToBeInvisible()
	}

	/**
	 * opens the c2 order details
	 * @param accountNo (account no which was used to create the order)
	 */
	@Keyword
	def openC2OrderDetailScreen(String accountNo) {
		Mobile.tap(findTestObject('Android/orders/c2OrderDetailsScreen/createdOrder_TextView',[('TEXT'):accountNo]), 0)
	}

	/**
	 * this function returns the order name from confirmation pop up of upload order
	 * return orderName (returns order name)
	 */
	@Keyword
	def returnOrderNameFromConfirmationPopupOfUploadOrder() {
		String orderName=Mobile.getText(findTestObject('Android/orders/orderDetailsScreen/uploadOrder/orderNameInConfirmtionPopUp_TextView'), 0)
		return orderName
	}

	/**
	 * this function returns the order name of the order which is at the top of the order list
	 * return orderName (returns topmost order name)
	 */
	@Keyword
	def returnTopMostOrderName() {
		String orderName=Mobile.getText(findTestObject('Android/orders/cartScreen/verificationDetails/orderListOrderName_TextView'), 0)
		return orderName
	}

	/**
	 * verifies C2 annotation count
	 * @param expectedAnnotationCount (annotation count of the non c2 product)
	 */
	@Keyword
	def verifyC2AnnotationCount(String expectedAnnotationCount) {
		String actualAnnotationCount = Mobile.getText(findTestObject('Object Repository/Android/orders/cartScreen/c2Order/c2AnnotationCount_TextView'), 0)
		assert expectedAnnotationCount == actualAnnotationCount
	}

	/**
	 * verifies cart screen with added product
	 */
	@Keyword
	def verifyCartScreenDetailsWithAddedProduct() {
		Mobile.verifyElementExist(findTestObject('Android/orders/cartScreen/verificationDetails/cartHeader_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/cartScreen/verificationDetails/allMobileOrders_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/cartScreen/verificationDetails/mobileOrdersCount_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/cartScreen/verificationDetails/Lines_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/cartScreen/verificationDetails/cartTotal_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/cartScreen/verificationDetails/orderValue_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/orderDetailsScreen/verificationDetails/Scan_Icon'),0)
	}

	/**
	 * verifies the cart screen details without any product
	 */
	@Keyword
	def verifyCartScreenDetailsWithOutAddingAnyProduct() {
		Mobile.verifyElementExist(findTestObject('Android/orders/orderDetailsScreen/verificationDetails/Scan_Icon'),0)
		Mobile.verifyElementExist(findTestObject('Android/orders/cartScreen/verificationDetails/cartHeader_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/cartScreen/verificationDetails/allMobileOrders_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/cartScreen/verificationDetails/mobileOrdersCount_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/cartScreen/verificationDetails/cartTotal_TextView'), 0)
	}

	/**
	 * verifies cart screen without non c2 orders
	 */
	@Keyword
	def verifyCartScreenWithOutNonC2Orders() {
		Mobile.verifyElementNotVisible(findTestObject('Android/orders/cartScreen/verificationDetails/uploadAllOrders_Button'), 0)
	}

	/**
	 * verifies the cart value after adding products
	 * @param expectedCartValue (expected cart value which should be equal to actual cart total)
	 */
	@Keyword
	def verifyCartValue(expectedCartValue) {
		String cartTotal=Mobile.getText(findTestObject('Android/orders/cartScreen/verificationDetails/cartTotal_TextView'), 0)
		String actualCartTotal=(new androidCommonKeywords.commonMethods()).removeCharctersInString(cartTotal)
		assert expectedCartValue==actualCartTotal
	}

	/**
	 * takes expected lines count of c2 or non c2 as the argument and verifies the same
	 * @param expectedLineCount (expected total line count of non c2 or c2 after adding product to the cart)
	 */
	@Keyword
	def verifyLineCountofC2OrNonC2Product(String expectedlineCount){
		String lineCount=Mobile.getText(findTestObject('Android/orders/cartScreen/verificationDetails/lineCountC2OrNonC2Product_TextView'), 0)
		String actualLineCount = (new androidCommonKeywords.commonMethods()).removeCharctersInString(lineCount)
		assert expectedlineCount==actualLineCount
	}

	/**
	 * takes expected lines count as the argument and verifies the same
	 * @param expectedLinesCount (expected lines count after adding products to the cart)
	 */
	@Keyword
	def verifyLinesCount(String expectedLinesCount) {
		String actualLinesCount=Mobile.getText(findTestObject('Android/orders/cartScreen/verificationDetails/lineCount_TextView'), 0)
		assert actualLinesCount==expectedLinesCount
	}

	/**
	 * takes expected mobile orders count as the argument and verifies the same
	 * @param expected mobile orders count (expected mobile orders count after adding products to the cart)
	 */
	@Keyword
	def verifyMobileOrdersCount(String expectedMobileOrdersCount) {
		String MobileOrdersCount=Mobile.getText(findTestObject('Android/orders/cartScreen/verificationDetails/mobileOrdersCount_TextView'), 0)
		String actualMobileOrdersCount = (new androidCommonKeywords.commonMethods()).removeCharctersInString(MobileOrdersCount)
		assert expectedMobileOrdersCount==actualMobileOrdersCount
	}

	/**
	 * verifies nonC2 annotation count
	 * @param expectedAnnotationCount (annotation count of the non c2 product)
	 */
	@Keyword
	def verifynonC2AnnotationCount(String expectedAnnotationCount) {
		String actualAnnotationCount = Mobile.getText(findTestObject('Object Repository/Android/orders/cartScreen/nonC2Order/nonC2AnnotationCount_TextView'), 0)
		assert expectedAnnotationCount == actualAnnotationCount
	}

	/**
	 * verifies that the created order should be visible on the cart screen
	 * @param poName (purchase order name used to create the order)
	 */
	@Keyword
	def verifyOrderIsVisibleOnTheCartScreen(String poName) {
		Mobile.verifyElementVisible(findTestObject('Android/orders/cartScreen/verificationDetails/orderName_TextView',[('TEXT'):poName]),0)
	}

	/**
	 * this function verifies the pattern required for the order which was created without giving any purchase order name
	 * @param orderName (order name which is under verification)
	 */
	@Keyword
	def verifyOrderNamePattern(final String orderName) {
		final String regex = "(Mobile)(-)([0-9]{6})(-)([0-9]{6})"
		Mobile.verifyMatch(orderName, regex, true)
		KeywordUtil.logInfo("pattern matches"); //logInfo if pattern matches
	}

	/**
	 * verifies that the created order should not be visible on the cart screen
	 * @param poName (purchase order name used to create the order)
	 */
	@Keyword
	def verifyOrderNotVisibleOnTheCartScreen(String poName) {
		Mobile.verifyElementNotVisible(findTestObject('Android/orders/cartScreen/verificationDetails/orderName_TextView',[('TEXT'):poName]),0)
	}

	/**
	 * verifies pop up screen which comes after clicking on place all orders button on cart screen
	 */
	@Keyword
	def verifyPlaceAllOrdersPopUp() {
		Mobile.verifyElementExist(findTestObject('Android/orders/cartScreen/placeAllOrders/goBackAndReviewMyOrders_Button'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/cartScreen/placeAllOrders/yourOrdersWillBePlaced_TextView'), 0)
	}

	/**
	 * takes expected lines count as the argument and verifies the same
	 * @param expectedLinesCount (expected total line count after adding products to the cart)
	 */
	@Keyword
	def verifyTotalLineCount(String expectedLineCount) {
		String LinesCount=Mobile.getText(findTestObject('Android/orders/cartScreen/verificationDetails/totalLineCount_TextView'), 0)
		String actualLineCount = (new androidCommonKeywords.commonMethods()).removeCharctersInString(LinesCount)
		assert expectedLineCount==actualLineCount
	}

	/**
	 * verifies pop up screen which comes after clicking on upload all orders button on cart screen
	 */
	@Keyword
	def verifyUploadAllOrdersPopUp() {
		Mobile.verifyElementExist(findTestObject('Android/orders/cartScreen/uploadAllOrders/continueOrdersOnTheDesktop_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/cartScreen/uploadAllOrders/continueOnDesktop_Button'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/cartScreen/uploadAllOrders/cancelAndKeepOrdersOnTheApp_Button'), 0)
	}

	/**
	 * verifies that the created order should be visible on the cart screen
	 * @param poName (purchase order name used to create the order)
	 */
	@Keyword
	def verifyOrderVisibleOnTheCartScreen(String poName) {
		Mobile.verifyElementVisible(findTestObject('Android/orders/cartScreen/c2Order/poName',[('TEXT'):poName]),0)
	}
}
