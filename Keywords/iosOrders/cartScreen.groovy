
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
import iosCommonKeywords.commonMethods
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
import java.util.regex.*
import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile


class cartScreen {

	def commonMethodsObject=new commonMethods();


	/**
	 * cancels uploading of orders and keeps orders on the application
	 */
	@Keyword
	def cancelUploadAndKeepOrdersOnTheApp() {

		Mobile.tap(findTestObject('iOS/orders/cartScreen/uploadAllOrders/cancelAndKeepOrdersOnTheApp_Button'), 0)
	}



	/**
	 * takes user back to cart screen and verifies user is on the cart screen
	 */
	@Keyword
	def clickOnBackToCart() {

		Mobile.tap(findTestObject('iOS/productSearch/globalSearch/backToCart_Text'), 0)

		Mobile.verifyElementAttributeValue(findTestObject('iOS/dashboard/tabs/orders_Tab'), 'value', '1',0)

		Mobile.verifyElementExist(findTestObject('iOS/orders/verificationDetails/cartHeader_Label'),0)
	}



	/**
	 * opens the c2 orders tab
	 */
	@Keyword
	def clickOnC2Orders() {

		Mobile.tap(findTestObject('iOS/orders/cartScreen/c2OrderDetails/c2Orders_Tab'), 0)
	}



	/**
	 * opens the non c2 orders tab
	 */
	@Keyword
	def clickOnNonC2Orders() {

		Mobile.tap(findTestObject('iOS/orders/cartScreen/nonc2Orders_Tab'), 0)
	}



	/**
	 * clicks on all place all orders button on cart screen
	 */
	@Keyword
	def clickOnPlaceAllOrders() {

		Mobile.tap(findTestObject('iOS/orders/cartScreen/placeAllOrders/placeAllOrders_Button'), 0)
	}


	/**
	 * taps on scan icon and takes user to scanning product screen and also verifies that the default toggle is at ordering
	 */
	@Keyword
	def clickOnScanIcon() {

		Mobile.tap(findTestObject('iOS/productSearch/scanFlow/scan_Icon'), 0)

		Mobile.verifyElementAttributeValue(findTestObject('iOS/productSearch/scanFlow/ordering_Button'), 'value', '1', 0)

		Mobile.verifyElementExist(findTestObject('iOS/productSearch/scanFlow/priceCheck_Button'), 0)
	}



	/**
	 * confirms placing all order by clicking on place all orders confirmation button and verifies details related to placed order
	 */
	@Keyword
	def confirmPlacingAllOrders() {

		Mobile.tap(findTestObject('iOS/orders/cartScreen/placeAllOrders/confirmPlaceOrder_Button'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/orders/cartScreen/placeAllOrders/allOrdersInThisAccountSubmitted_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/orders/cartScreen/placeAllOrders/allNonC2OrdersHaveBeenSubmitted_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/orders/cartScreen/placeAllOrders/c2OrdersWereSentToDesktop_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/orders/cartScreen/placeAllOrders/checkTheDesktopForOrderConfirmation_Text'), 0)
	}


	/**
	 * clicks on continue orders on the desktop and verifies popUp which appears after tapping on continue on desktop
	 */
	@Keyword
	def continueOrdersOnTheDesktop() {

		Mobile.tap(findTestObject('iOS/orders/cartScreen/uploadAllOrders/continueOnDesktop_Button'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/orders/cartScreen/uploadAllOrders/yourOrder(s)HasBeenSentToDesktop_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/orders/cartScreen/uploadAllOrders/backToCart_Button'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/orders/cartScreen/uploadAllOrders/goToDashboard_Button'), 0)
	}



	/**
	 * delete's the C2 order from the cart screen based on the purchase order name
	 * seperate delete method for c2 as locators for c2 order tile not available...when done remove this method
	 */
	@Keyword
	def deleteC2Order() {

		commonMethodsObject.waitForProgressBarToBeInvisible()

		String testObj='Object Repository/iOS/orders/cartScreen/c2OrderDetails/c2Order_View'

		int elementHeight=Mobile.getElementHeight(findTestObject(testObj), 2)

		int elementTopPosition = Mobile.getElementTopPosition(findTestObject(testObj), 0)

		int yCoordinateToSwipe=(elementHeight/2)+elementTopPosition

		Mobile.swipe(1300, yCoordinateToSwipe, 0, yCoordinateToSwipe)

		Mobile.verifyElementExist(findTestObject('iOS/orders/cartScreen/deleteOrder/success_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/orders/cartScreen/deleteOrder/orderDeletedSuccessfully_Text'),0)

		Mobile.tapAndHold(findTestObject('iOS/orders/cartScreen/deleteOrder/ok_Button'), 0, 0)
	}



	/**
	 * delete's the order from the cart screen based on the purchase order name
	 * @param poName (purchase order name of the order)
	 */
	@Keyword
	def deleteOrder(String poName) {

		commonMethodsObject.waitForProgressBarToBeInvisible()

		String testObj='Object Repository/iOS/orders/ordersCommonScreen/orderListOrderName_Label'

		int yCoordinateToSwipe=commonMethodsObject.tapYCoordinateGenerator(testObj,poName)

		Mobile.swipe(1300, yCoordinateToSwipe, 0, yCoordinateToSwipe)

		Mobile.verifyElementExist(findTestObject('iOS/orders/cartScreen/deleteOrder/success_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/orders/cartScreen/deleteOrder/orderDeletedSuccessfully_Text'),0)

		Mobile.tapAndHold(findTestObject('iOS/orders/cartScreen/deleteOrder/ok_Button'), 0, 0)
	}



	/**
	 * takes user back to cart to review all orders
	 */
	@Keyword
	def goBackToReviewAllOrders() {

		Mobile.tap(findTestObject('iOS/orders/cartScreen/placeAllOrders/goBackAndReviewMyOrder(s)_Button'), 0)
	}



	/**
	 * takes user to dash-board
	 */
	@Keyword
	def goToDashboard() {

		Mobile.tap(findTestObject('iOS/orders/cartScreen/uploadAllOrders/goToDashboard_Button'), 0)
	}



	/**
	 * opens the order details page
	 * @param poName (purchase order name used to create the order)
	 */
	@Keyword
	def openAnOrderDetail(String poName) {

		Mobile.tap(findTestObject('iOS/orders/ordersCommonScreen/orderListOrderName_Label',[('TEXT'):poName]), 0)
	}



	/**
	 * opens the c2 order details
	 */
	@Keyword
	def openC2OrderDetails() {

		Mobile.tap(findTestObject('iOS/orders/cartScreen/c2OrderDetails/c2Order_View'), 0)

		(new iosCommonKeywords.commonMethods()).waitForProgressBarToBeInvisible()

		Mobile.verifyElementAttributeValue(findTestObject('iOS/orders/cartScreen/c2OrderDetails/uploadC2Order_Button'), 'enabled', 'true', 0)

		Mobile.verifyElementAttributeValue(findTestObject('iOS/orders/c2OrderDetailsScreen/placeC2Order/placeC2Order_Button'), 'enabled', 'true', 0)
	}



	/**
	 * this function returns the order name of the order which is at the top of the order list
	 * return orderName (returns topmost order name)
	 */
	@Keyword
	def returnTopMostOrderName() {

		String orderName=Mobile.getText(findTestObject('iOS/orders/cartScreen/nonC2OrderDetails/orderListOrderName_Label'), 0)

		return orderName
	}



	/**
	 * scans the product, adds it to the order and also verifies some scan input details
	 * @param productToBeSearched (name which can be a productName/Cin/NDC of the product to be added)
	 */
	@Keyword
	def scanInputEvent(String productToBeSearched) {

		Mobile.tap(findTestObject('iOS/productSearch/scanFlow/scanGray_Image'), 0)

		Mobile.setText(findTestObject('iOS/productSearch/scanFlow/enterBarcode_TextField'), productToBeSearched, 0)

		Mobile.tap(findTestObject('iOS/productSearch/scanFlow/done_Button'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/orders/orderDetailsScreen/verificationDetails/thisItemHaBeenAddedToYourOrder_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/orders/orderDetailsScreen/verificationDetails/alternates_Text'), 0)
	}



	/**
	 * this function selects toggle value for the product to be added which can be ordering or price check)
	 * @param toggleValue (toggleValue required to be selected for the product to be added which can be ordering or price check)
	 */
	@Keyword
	def selectToggleValueForTheProductToBeSearched(String toggleValue) {

		if(toggleValue=="Ordering") {
			Mobile.tap(findTestObject('iOS/productSearch/scanFlow/ordering_Button'), 0)
		}
		else {
			Mobile.tap(findTestObject('iOS/productSearch/scanFlow/priceCheck_Button'), 0)
		}
	}



	/**
	 * uploads all order by clicking on upload all orders button on cart screen
	 */
	@Keyword
	def uploadAllOrders() {

		Mobile.tap(findTestObject('iOS/orders/cartScreen/uploadAllOrders/uploadAllOrders_Button'), 0)
	}



	/**
	 * verifies c2 orders annotation count
	 * @param expectedCount (expected annotation count)
	 */
	@Keyword
	def verifyC2OrdersTabAnnotationCount(int expectedAnnotationCount) {

		Mobile.verifyElementExist(findTestObject('iOS/orders/cartScreen/c2OrderDetails/c2OrdersAnnotationCount_Text',[('TEXT'):expectedAnnotationCount]), 0)
	}



	/**
	 *verifies C2 order view
	 */
	@Keyword
	def verifyC2OrderViewIsNotVisible() {
		Mobile.verifyElementNotVisible(findTestObject('iOS/orders/cartScreen/c2OrderDetails/c2Order_View'), 0)
	}



	/**
	 * verifies cart screen with any product being added
	 */
	@Keyword
	def verifyCartScreenWithAddedProduct() {

		Mobile.verifyElementAttributeValue(findTestObject('iOS/dashboard/tabs/orders_Tab'), 'value', '1',0)

		Mobile.verifyElementExist(findTestObject('iOS/orders/ordersCommonScreen/cartScreen_Tab'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/orders/cartScreen/uploadAllOrders/enabledUploadAllOrders_Button'),0)

		Mobile.verifyElementExist(findTestObject('iOS/orders/verificationDetails/cartHeader_Label'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/orders/verificationDetails/allMobileOrders_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/orders/verificationDetails/OrderList_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/orders/verificationDetails/cartTotal_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/orders/verificationDetails/orderListAmount_Text'), 0)
	}



	/**
	 * verifies cart screen without any product being added
	 */
	@Keyword
	def verifyCartScreenWithoutAnyOrderPresent() {

		Mobile.verifyElementExist(findTestObject('iOS/orders/verificationDetails/Lines_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/orders/cartScreen/uploadAllOrders/disabledUploadAllOrders_Button'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/orders/verificationDetails/cartHeader_Label'), 0)
	}



	/**
	 * verifies the cart value after adding products
	 * @param expectedCartValue (expected cart value which should be equal to actual cart total)
	 */
	@Keyword
	def verifyCartValue(float expectedCartValue) {

		String actualCartTotal=Mobile.getText(findTestObject('iOS/orders/verificationDetails/cartValue_Text'), 0)

		actualCartTotal=actualCartTotal.replaceAll("[^0-9.]", "")
		float actualCartTotal_dollarSymbolRemoved_FloatValue=actualCartTotal.toFloat()

		//	float actualCartTotal_dollarSymbolRemoved_FloatValue=(new common.commonMethods()).floatValueGenerator(actualCartTotal)//converting actualCartTotal string to a float value

		KeywordUtil.logInfo(actualCartTotal)

		assert expectedCartValue==actualCartTotal_dollarSymbolRemoved_FloatValue
	}



	/**
	 * takes expected lines count as the argument and verifies the same
	 * @param expectedLinesCount (expected lines count after adding products to the cart)
	 */
	@Keyword
	def verifyLinesCount(String expectedLinesCount) {

		String actualLinesCount=Mobile.getText(findTestObject('iOS/orders/cartScreen/verification/linesCount_Text'), 0)

		assert actualLinesCount==expectedLinesCount
	}



	/**
	 * takes expected mobile orders count as the argument and verifies the same
	 * @param expected mobile orders count (expected mobile orders count after adding products to the cart)
	 */
	@Keyword
	def verifyMobileOrdersCount(String expectedMobileOrdersCount) {
		String actualMobileOrdersCount=Mobile.getText(findTestObject('iOS/orders/cartScreen/verification/mobileOrdersCount_Text'), 0)
		assert expectedMobileOrdersCount==actualMobileOrdersCount
	}



	/**
	 * verifies that the created order should be visible on the cart screen
	 * @param poName (purchase order name used to create the order)
	 */
	@Keyword
	def verifyOrderIsVisibleOnTheCartScreen(String poName) {

		Mobile.verifyElementExist(findTestObject('iOS/orders/cartScreen/nonC2OrderDetails/orderName_Label',[('TEXT'):poName]),0)
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

		Mobile.verifyElementNotVisible(findTestObject('iOS/orders/cartScreen/nonC2OrderDetails/orderName_Label',[('TEXT'):poName]),0)
	}



	/**
	 * verifies pop up screen which comes after clicking on place all orders button on cart screen
	 */
	@Keyword
	def verifyPlaceAllOrdersPopUp() {

		Mobile.verifyElementExist(findTestObject('iOS/orders/cartScreen/placeAllOrders/goBackAndReviewMyOrder(s)_Button'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/orders/cartScreen/placeAllOrders/yourOrder(s)WillBePlaced_Text'), 0)
	}



	/**
	 * verifies pop up screen which comes after clicking on upload all orders button on cart screen
	 */
	@Keyword
	def verifyUploadAllOrdersPopUp() {

		Mobile.verifyElementExist(findTestObject('iOS/orders/cartScreen/uploadAllOrders/continueOnDesktop_Button'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/orders/cartScreen/uploadAllOrders/cancelAndKeepOrdersOnTheApp_Button'), 0)
	}
}