package androidOrders
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import androidCommonKeywords.commonMethods
import androidDashboard.dashboardDetailsScreen
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


class ordersCommonScreen {

	def commonMethodObject=new commonMethods();
	def dashboardObject=new dashboardDetailsScreen();

	/**
	 * deletes all orders from nonc2 and c2 order tab
	 */
	@Keyword
	def clearAllOrders() {
		int counter=1,waitLimit=20,elementHeight,elementTopPosition,yCoordinateToSwipe//waitLimit of 20s
		while(Mobile.verifyElementNotVisible(findTestObject('Android/dashboard/moreOptions_Tab'), 2,FailureHandling.OPTIONAL))
		{	Mobile.pressBack()
			counter+=1
			if(counter>waitLimit)
				break
		}
		while(Mobile.verifyElementNotVisible(findTestObject('Android/orders/ordersCommonScreen/cart_Tab'), 2,FailureHandling.OPTIONAL))
		{
			dashboardObject.clickOnOrders()
			counter+=1
			if(counter>waitLimit)
				break
		}
		clickOnCartTab()
		(new androidOrders.cartScreen()).clickOnNonC2OrdersTab()
		String testObj='Object Repository/Android/Orders/Orders Common Screen/orderName_TextView'
		if(Mobile.verifyElementExist(findTestObject(testObj), 2,FailureHandling.OPTIONAL))
		{

			elementHeight=Mobile.getElementHeight(findTestObject(testObj), 2,FailureHandling.CONTINUE_ON_FAILURE)
			elementTopPosition = Mobile.getElementTopPosition(findTestObject(testObj), 2,FailureHandling.CONTINUE_ON_FAILURE)
			yCoordinateToSwipe=(elementHeight/2)+elementTopPosition

		}
		while(Mobile.verifyElementExist(findTestObject(testObj), 2,FailureHandling.OPTIONAL)) //deletes orders under nonc2 orders tab
		{
			Mobile.swipe(500, yCoordinateToSwipe, 0, yCoordinateToSwipe)
			Mobile.tapAndHold(findTestObject('Android/orders/cartScreen/deleteOrder/YES_Button'), 0, 0)
			commonMethodObject.waitForProgressBarToBeInvisible()
			counter+=1
			if(counter>waitLimit)
				break
		}
		(new androidOrders.cartScreen()).clickOnC2OrdersTab()
		counter=1
		if(Mobile.verifyElementExist(findTestObject(testObj), 2,FailureHandling.OPTIONAL))
		{
			elementHeight=Mobile.getElementHeight(findTestObject(testObj), 2,FailureHandling.CONTINUE_ON_FAILURE)
			elementTopPosition = Mobile.getElementTopPosition(findTestObject(testObj), 2,FailureHandling.CONTINUE_ON_FAILURE)
			yCoordinateToSwipe=(elementHeight/2)+elementTopPosition
		}
		while(Mobile.verifyElementExist(findTestObject('Android/orders/ordersCommonScreen/orderName_TextView'), 2,FailureHandling.OPTIONAL)) //deletes orders under c2 orders tab
		{
			Mobile.swipe(500, yCoordinateToSwipe, 0, yCoordinateToSwipe)
			Mobile.tapAndHold(findTestObject('Android/orders/cartScreen/deleteOrder/YES_Button'), 0, 0)
			commonMethodObject.waitForProgressBarToBeInvisible()
			counter+=1
			if(counter>waitLimit)
				break
		}
	}

	/**
	 * takes user to cart screen
	 */
	@Keyword
	def clickOnCartTab() {
		Mobile.tap(findTestObject('Android/orders/cartScreen/verificationDetails/cart_Tab'), 0)
	}

	/**
	 * opens History page
	 */
	@Keyword
	def clickOnHistoryTab() {
		Mobile.tap(	findTestObject('Android/orders/ordersCommonScreen/History_Tab'), 0)
	}

	/**
	 * takes user to the new order screen
	 */
	@Keyword
	def clickOnNewOrder() {
		Mobile.tap(findTestObject('Android/orders/ordersCommonScreen/newOrder_Tab'), 0)
	}
}