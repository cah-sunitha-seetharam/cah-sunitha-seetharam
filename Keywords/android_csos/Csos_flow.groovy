package android_csos
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


class Csos_flow {

	@Keyword
	def Place_C2_Order() {


		Mobile.tap(findTestObject('Android/Orders/CSOS/Place Order_Button'), 0)
	}



	@Keyword
	def vertical_swipe_refresh() {

		WebUI.delay(30)

		float device_Height = Mobile.getDeviceHeight()

		float device_Width = Mobile.getDeviceWidth()

		int startX = device_Width / 2

		int endX = startX

		int startY = device_Height * 0.50

		int endY = device_Height * 0.80

		Mobile.swipe(startX, endY, endX, startY)
	}




	@Keyword
	def select_C2_Order_for_Adding_Product(String po_Name) {

		Mobile.tap(findTestObject('Android/Orders/CSOS/c2Order_RadioButton',[('TEXT'):po_Name]),0)

		Mobile.tap(findTestObject('Android/Orders/CSOS/addToOrder_Button'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/CSOS/Item added to C2 Order_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/CSOS/cartTotal_TextView'), 0, FailureHandling.STOP_ON_FAILURE)

		Mobile.verifyElementExist(findTestObject('Android/Orders/CSOS/continueBrowsing_Button'), 0)

		Mobile.tap(findTestObject('Android/Orders/CSOS/Go to Order_TextView'), 0)
	}



	@Keyword
	def Review_and_Sign_C2_Order() {

		Mobile.tap(findTestObject('Android/Orders/CSOS/Review and Sign_Button'), 0)
	}



	@Keyword
	def Perform_Signature_and_Confirm_Order(String Signing_Password) {


		Mobile.tap(findTestObject('Android/Orders/CSOS/Sign Now_Button'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/CSOS/Signature Needed_TextView'), 0)

		Mobile.tap(findTestObject('Android/Orders/CSOS/Signing Password_TextField'), 0)

		Mobile.setText(findTestObject('Android/Orders/CSOS/Signing Password_TextField'), Signing_Password, 0)

		Mobile.tap(findTestObject('Android/Orders/CSOS/Place Order_Button'), 0)
	}



	@Keyword
	def Open_C2_Orders() {

		Mobile.tap(findTestObject('Android/Orders/CSOS/c2Orders_Tab'), 0)
	}



	@Keyword
	def Open_C2_Order_details_before_Signature() {


		Mobile.tap(findTestObject('Android/Orders/CSOS/Signature Required_TextvVew'), 0)
	}



	@Keyword
	def Go_to_Order_History() {


		Mobile.tap(findTestObject('Android/Orders/CSOS/goToOrderHistory_Button'), 0)
	}



	@Keyword
	def Create_New_C2_Order(String PO_Name, String PO_Memo) {

		Mobile.tap(findTestObject('Android/Orders/CSOS/createANewOrder_TextView'), 0)

		Mobile.setText(findTestObject('Android/Orders/New Order Page/P.O. Name (Optional)_TextField'), PO_Name, 0)

		Mobile.setText(findTestObject('Android/Orders/New Order Page/P.O. Memo (Optional)_TextField'), PO_Memo, 0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/CSOS/Cancel_Button'), 0, FailureHandling.STOP_ON_FAILURE)

		Mobile.tap(findTestObject('Android/Orders/CSOS/Create new order_Button'), 0)
	}



	@Keyword(keywordObject="android_orders_screen")
	def Check_C2_Availability() {


		Mobile.tap(findTestObject('Android/Orders/CSOS/checkAvailability_Button'), 0)
	}



	@Keyword
	def CSOS_Search_Product(String Product_Name,String Quantity) {

		int w = 1

		while (Mobile.verifyElementExist(findTestObject('Android/Login/Login Details Screen/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}

		Mobile.tap(findTestObject('Android/Product Search/Search Products_SearchView'), 0)

		Mobile.setText(findTestObject('Android/Product Search/Search Products_SearchView'), Product_Name + '\\n',
				0)

		while (Mobile.verifyElementExist(findTestObject('Android/Login/Login Details Screen/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}

		Mobile.setText(findTestObject('Android/Product Search/Quantity_TextField'), Quantity, 0)

		while (Mobile.verifyElementExist(findTestObject('Android/Login/Login Details Screen/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}

		Mobile.tap(findTestObject('Android/Product Search/Add to Order_Button'),0)
	}
}