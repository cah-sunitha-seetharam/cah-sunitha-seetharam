package ios_orders
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


class Cart_Screen {

	@Keyword
	def click_On_Order(String Account_No) {

		Mobile.tap(findTestObject('iOS/Orders/Order Details Page/Order Details_Text',[('TEXT'):GlobalVariable.Account]), 0)
	}



	@Keyword
	def upload_All_Orders() {

		Mobile.tap(findTestObject('iOS/Orders/Cart Page/Upload All Orders/Upload All Orders_Text'), 0)

		Mobile.tap(findTestObject('iOS/Orders/Order Details Page/Place Order/Go Back and Review My Order_Text'), 0)
	}




	@Keyword
	def place_All_Orders() {

		Mobile.tap(	findTestObject('iOS/Orders/Cart Page/Place All Orders/Place All Orders_Text'), 0)
	}




	@Keyword
	def delete_Order(String Account_No) {

		int w = 6

		while (Mobile.verifyElementExist(findTestObject('iOS/Product_Search/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}

		int ElementTopPosition=Mobile.getElementTopPosition(findTestObject('iOS/Orders/Order Details Page/Order Details_Text',[('TEXT'):GlobalVariable.Account]), 0)

		int ElementHeight=Mobile.getElementHeight(findTestObject('iOS/Orders/Order Details Page/Order Details_Text',[('TEXT'):GlobalVariable.Account]), 0)

		int y_Coordinate_To_Swipe=(ElementHeight/2)+ElementTopPosition

		Mobile.swipe(1300, y_Coordinate_To_Swipe, 0, y_Coordinate_To_Swipe)

		//	Mobile.swipe(1300, 430, 0, 430)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Cart Page/Delete_Order/Success_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Cart Page/Delete_Order/Order(s) deleted successfully_Text'),0)

		Mobile.tapAndHold(findTestObject('iOS/Orders/Cart Page/Delete_Order/OK_Button'), 0, 0)
	}



	@Keyword
	def verify_Cart_Screen_Details_without_Adding_any_Product() {

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Verification Details/Lines_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Cart Page/Place All Orders/Disabled_Place All Orders_Button'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Cart Page/Upload All Orders/Disabled_Upload All Orders_Button'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Orders_Common_Screen/Cart Page_Tab'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Verification Details/Cart Header_Label'), 0)
	}

	@Keyword
	def verify_Cart_Screen_Details_with_Added_Product() {

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Orders_Common_Screen/Cart Page_Tab'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Cart Page/Upload All Orders/Enabled_Upload All Orders_Button'),0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Verification Details/Cart Header_Label'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Verification Details/All Mobile Orders_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Verification Details/OrderList_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Verification Details/Cart Total_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Verification Details/OrderList_Amount_Text'), 0)
	}
}