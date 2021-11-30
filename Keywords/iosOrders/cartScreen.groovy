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


class cartScreen {



	/**
	 * cancels uploading of orders and keeps orders on the application
	 */
	@Keyword
	def cancelUploadAndKeepOrdersOnTheApp() {

		Mobile.tap(findTestObject('iOS/Orders/Cart Screen/Upload All Orders/cancelAndKeepOrdersOnTheApp_Button'), 0)
	}



	/**
	 * takes user back to cart screen and verifies user is on the cart screen
	 */
	@Keyword
	def clickOnBackToCart() {

		Mobile.tap(findTestObject('iOS/Product_Search/backToCart_Text'), 0)

		Mobile.verifyElementAttributeValue(findTestObject('Object Repository/iOS/Dashboard/Orders_Tab'), 'value', '1',0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Verification Details/cartHeader_Label'),0)
	}



	/**
	 * opens the c2 orders tab
	 */
	@Keyword
	def clickOnC2Orders() {

		Mobile.tap(findTestObject('iOS/Orders/Cart Screen/c2Orders_Tab'), 0)
	}


	/**
	 * clicks on all place all orders button on cart screen
	 */
	@Keyword
	def clickOnPlaceAllOrders() {

		Mobile.tap(findTestObject('iOS/Orders/Cart Screen/Place All Orders/placeAllOrders_Button'), 0)
	}


	/**
	 * confirms placing all order by clicking on place all orders confirmation button and verifies details related to placed order
	 */
	@Keyword
	def confirmPlacingAllOrders() {

		Mobile.tap(findTestObject('Object Repository/iOS/Orders/Cart Screen/Place All Orders/confirmPlaceOrder_Button'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Cart Screen/Place All Orders/allOrdersInThisAccountSubmitted_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Cart Screen/Place All Orders/allNonC2OrdersHaveBeenSubmitted_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Cart Screen/Place All Orders/c2OrdersWereSentToDesktop_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Cart Screen/Place All Orders/checkTheDesktopForOrderConfirmation_Text'), 0)
	}



	/**
	 * clicks on continue orders on the desktop and verifies popUp which appears after tapping on continue on desktop
	 */
	@Keyword
	def continueOrdersOnTheDesktop() {

		Mobile.tap(findTestObject('iOS/Orders/Cart Screen/Upload All Orders/continueOnDesktop_Button'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Cart Screen/Upload All Orders/yourOrder(s)HasBeenSentToDesktop_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Cart Screen/Upload All Orders/backToCart_Button'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Cart Screen/Upload All Orders/goToDashboard_Button'), 0)
	}



	@Keyword
	def delete_Order(String Account_No) {

		int w = 6

		while (Mobile.verifyElementExist(findTestObject('iOS/Product_Search/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}

		int ElementTopPosition=Mobile.getElementTopPosition(findTestObject('iOS/Orders/Order Details Screen/Order Details_Text',[('TEXT'):GlobalVariable.Account]), 0)

		int ElementHeight=Mobile.getElementHeight(findTestObject('iOS/Orders/Order Details Screen/Order Details_Text',[('TEXT'):GlobalVariable.Account]), 0)

		int y_Coordinate_To_Swipe=(ElementHeight/2)+ElementTopPosition

		Mobile.swipe(1300, y_Coordinate_To_Swipe, 0, y_Coordinate_To_Swipe)

		//	Mobile.swipe(1300, 430, 0, 430)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Cart Screen/Delete_Order/Success_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Cart Screen/Delete_Order/Order(s) deleted successfully_Text'),0)

		Mobile.tapAndHold(findTestObject('iOS/Orders/Cart Screen/Delete_Order/OK_Button'), 0, 0)
	}


	/**
	 * takes user back to cart to review all orders
	 */
	@Keyword
	def goBackToReviewAllOrders() {

		Mobile.tap(findTestObject('iOS/Orders/Cart Screen/Place All Orders/goBackAndReviewMyOrder(s)_Button'), 0)
	}



	/**
	 * takes user to dash-board
	 */
	@Keyword
	def goToDashboard() {

		Mobile.tap(findTestObject('iOS/Orders/Cart Screen/Upload All Orders/goToDashboard_Button'), 0)
	}




	/**
	 * opens the order details page
	 * @param accountNo (accountNo used to create the order)
	 */
	@Keyword
	def openAnOrderDetails(String accountNo) {

		Mobile.tap(findTestObject('iOS/Orders/Order Details Screen/Order Details_Text',[('TEXT'):accountNo]), 0)
	}



	/**
	 * opens the c2 order details
	 */
	@Keyword
	def openC2OrderDetails() {

		Mobile.tap(findTestObject('iOS/Orders/Cart Screen/c2Order_View'), 0)
	}


	/**
	 * uploads all order by clicking on upload all orders button on cart screen
	 */
	@Keyword
	def uploadAllOrders() {

		Mobile.tap(findTestObject('iOS/Orders/Cart Screen/Upload All Orders/uploadAllOrders_Button'), 0)
	}


	@Keyword
	def verify_Cart_Screen_Details_with_Added_Product() {

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Orders Common Screen/Cart Page_Tab'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Cart Screen/Upload All Orders/Enabled_Upload All Orders_Button'),0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Verification Details/cartHeader_Label'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Verification Details/All Mobile Orders_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Verification Details/OrderList_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Verification Details/Cart Total_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Verification Details/OrderList_Amount_Text'), 0)
	}


	@Keyword
	def verify_Cart_Screen_Details_without_Adding_any_Product() {

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Verification Details/Lines_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Cart Screen/Upload All Orders/Disabled_Upload All Orders_Button'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Orders Common Screen/Cart Page_Tab'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Verification Details/cartHeader_Label'), 0)
	}



	/**
	 * verifies that the created order should not be visible on the cart screen
	 * @param poName (purchase order name used to create the order)
	 */
	@Keyword
	def verifyOrderNotVisibleOnTheCartScreen(String poName) {

		Mobile.verifyElementNotVisible(findTestObject('iOS/Orders/Cart Screen/orderName_Label',[('TEXT'):poName]),0)
	}



	/**
	 * verifies pop up screen which comes after clicking on place all orders button on cart screen
	 */
	@Keyword
	def verifyPlaceAllOrdersPopUp() {

		Mobile.verifyElementExist(findTestObject('Object Repository/iOS/Orders/Cart Screen/Place All Orders/goBackAndReviewMyOrder(s)_Button'), 0)

		Mobile.verifyElementExist(findTestObject('Object Repository/iOS/Orders/Cart Screen/Place All Orders/yourOrder(s)WillBePlaced_Text'), 0)
	}


	/**
	 * verifies pop up screen which comes after clicking on upload all orders button on cart screen
	 */
	@Keyword
	def verifyUploadAllOrdersPopUp() {

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Cart Screen/Upload All Orders/continueOnDesktop_Button'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Cart Screen/Upload All Orders/cancelAndKeepOrdersOnTheApp_Button'), 0)
	}
}