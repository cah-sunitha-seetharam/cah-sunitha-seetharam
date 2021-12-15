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
import iosDashboard.dashboardScreen
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

	def dashboardObject=new dashboardScreen();
	def commonMethodObject=new commonMethods();


	/**
	 * takes user to new order screen where user can input purchase order details and can create an order
	 */
	@Keyword
	def clickOnNewOrder() {

		Mobile.tap(findTestObject('iOS/Orders/Orders Common Screen/newOrder_Tab'), 0)
	}




	@Keyword
	def clickOnHistoryTab() {

		Mobile.tap(	findTestObject('iOS/Orders/Orders Common Screen/History Page_Tab'), 0)
	}



	@Keyword
	def clickOnCartTab() {

		Mobile.tap(findTestObject('iOS/Orders/Orders Common Screen/cartScreen_Tab'), 0)
	}



	/**
	 * deletes all orders from nonc2 and c2 order tab
	 */
	@Keyword
	def clearAllOrders() {
		int counter=1,waitLimit=20,elementHeight,elementTopPosition,yCoordinateToSwipe//waitLimit of 20s
		if(Mobile.verifyElementNotVisible(findTestObject('Object Repository/iOS/Dashboard/Verification/homeBottomNavigationTab_Bar'), 2,FailureHandling.OPTIONAL))
		commonMethodObject.goOneScreenBack()
		while(Mobile.verifyElementNotVisible(findTestObject('iOS/Orders/Orders Common Screen/cartScreen_Tab'), 2,FailureHandling.OPTIONAL))
		{
			dashboardObject.clickOnOrders()

		}
		clickOnCartTab()
		(new iosOrders.cartScreen()).clickOnNonC2Orders()
		String testObj='Object Repository/iOS/Orders/Cart Screen/orderListCell_View'
		if(Mobile.verifyElementExist(findTestObject(testObj), 2,FailureHandling.OPTIONAL))
		{	
		 elementHeight=Mobile.getElementHeight(findTestObject(testObj), 2,FailureHandling.CONTINUE_ON_FAILURE)
		 elementTopPosition = Mobile.getElementTopPosition(findTestObject(testObj), 2,FailureHandling.CONTINUE_ON_FAILURE)
		 yCoordinateToSwipe=(elementHeight/2)+elementTopPosition
		}
		while(Mobile.verifyElementExist(findTestObject(testObj), 2,FailureHandling.OPTIONAL)) //deletes orders under nonc2 orders tab
		{
			Mobile.swipe(1300, yCoordinateToSwipe, 0, yCoordinateToSwipe)
			Mobile.tapAndHold(findTestObject('iOS/Orders/Cart Screen/Delete Order/OK_Button'), 0, 0)
			commonMethodObject.waitForProgressBarToBeInvisible()
			counter+=1
			if(counter>waitLimit)
			break
		}
		(new iosOrders.cartScreen()).clickOnC2Orders()
		counter=1
		while(Mobile.verifyElementExist(findTestObject('iOS/Orders/Cart Screen/c2Order_View'), 2,FailureHandling.OPTIONAL)) //deletes orders under c2 orders tab
		{
			(new iosOrders.cartScreen()).deleteC2Order()
			commonMethodObject.waitForProgressBarToBeInvisible()
			counter+=1
			if(counter>waitLimit)
			break
		}
	}

}