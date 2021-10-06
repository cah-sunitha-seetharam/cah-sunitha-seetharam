package android_orders
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


class Cart_Screen extends Order_details_Screen {

	@Keyword
	def click_On_Order(String Account_No) {

		Mobile.tap(findTestObject('Android/Orders/Cart Page/Verifictaion Details/order_details_btn',[('Order_Name') : Account_No]),  0)
	}



	@Keyword
	def delete_Order(Account_No) {

		int w = 6

		while (Mobile.verifyElementExist(findTestObject('Android/Login/Login Details Screen/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}

		int ElementTopPosition = Mobile.getElementTopPosition(findTestObject('Android/Orders/Cart Page/Verifictaion Details/order_details_btn',[('Order_Name') : Account_No]), 0)

		int ElementHeight=Mobile.getElementHeight(findTestObject('Android/Orders/Cart Page/Verifictaion Details/order_details_btn',[('Order_Name') : Account_No]), 0)

		int y_Coordinate_To_Swipe=(ElementHeight/2)+ElementTopPosition
		
		Mobile.swipe(500, y_Coordinate_To_Swipe, 0, y_Coordinate_To_Swipe)
		
		//Mobile.swipe(500, 1100, 0, 1100)
		
		println(y_Coordinate_To_Swipe)
		
		Mobile.tap(findTestObject('Android/Orders/Cart Page/Delete Order/YES_Button'), 0)

		while (Mobile.verifyElementExist(findTestObject('Android/Login/Login Details Screen/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}
	}




	@Keyword
	def upload_All_Orders() {

		int w = 1

		while (Mobile.verifyElementExist(findTestObject('Android/Login/Login Details Screen/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}
		Mobile.tap(findTestObject('Android/Orders/Cart Page/Upload All_Orders/Upload All Orders_Button'), 0)

		Mobile.tap(findTestObject('Android/Orders/Order Details Page/Upload Order/Continue On Desktop_button'), 0)

		while (Mobile.verifyElementExist(findTestObject('Android/Login/Login Details Screen/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}
	}




	@Keyword
	def place_All_Orders() {

		int w = 1

		while (Mobile.verifyElementExist(findTestObject('Android/Login/Login Details Screen/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}
		Mobile.tap(	findTestObject('Object Repository/Android/Orders/Cart Page/Place All_Orders/Place All Orders_Button'), 0)

		while (Mobile.verifyElementExist(findTestObject('Android/Login/Login Details Screen/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}


		Mobile.tap(findTestObject('Object Repository/Android/Orders/Cart Page/Place All_Orders/Place My Orders_Button'),0)
	}


	@Keyword
	def verify_Cart_Screen_Details_with_Added_Product() {

		Mobile.verifyElementExist(findTestObject('Android/Orders/Cart Page/Verifictaion Details/Cart Header_Text'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/Cart Page/Verifictaion Details/All Mobile Orders_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/Cart Page/Verifictaion Details/Mobile Orders Count_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/Cart Page/Verifictaion Details/Lines_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/Cart Page/Verifictaion Details/Cart Total_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/Cart Page/Verifictaion Details/Order Value_Text'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/Order Details Page/Verification Details/Scan_Icon'),0)
	}





	@Keyword
	def verify_Cart_Screen_Details_without_Adding_any_Product() {

		Mobile.verifyElementExist(findTestObject('Android/Orders/Order Details Page/Verification Details/Scan_Icon'),0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/Cart Page/Verifictaion Details/Cart Header_Text'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/Cart Page/Verifictaion Details/All Mobile Orders_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/Cart Page/Verifictaion Details/Mobile Orders Count_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/Cart Page/Verifictaion Details/Lines_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/Cart Page/Verifictaion Details/Cart Total_TextView'), 0)
	}
}