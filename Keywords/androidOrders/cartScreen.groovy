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
	 * opens the order details page
	 * @param accountNo (accountNo used to create the order)
	 */
	@Keyword
	def openAnOrderDetails(String accountNo) {

		Mobile.tap(findTestObject('Android/Orders/Cart Screen/Verifictaion Details/orderDetails_button',[('Order_Name') : accountNo]),  0)
	}


	/**
	 * opens the c2 orders tab
	 */
	@Keyword
	def clickOnC2OrdersTab() {

		Mobile.tap(findTestObject('Android/Orders/Cart Screen/c2Orders_Tab'), 0)
	}



	/**
	 * opens the c2 order details
	 * @param accountNo (account no which was used to create the order)
	 */
	@Keyword
	def openC2OrderDetailScreen(String accountNo) {

		Mobile.tap(findTestObject('Object Repository/Android/Orders/C2 Order Details Screen/createdOrder_TextView',[('TEXT'):accountNo]), 0)
	}



	@Keyword
	def delete_Order(Account_No) {

		int w = 6

		while (Mobile.verifyElementExist(findTestObject('Android/Login/Login Details Screen/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}

		int ElementTopPosition = Mobile.getElementTopPosition(findTestObject('Android/Orders/Cart Screen/Verifictaion Details/orderDetails_button',[('Order_Name') : GlobalVariable.Account]), 0)

		int ElementHeight=Mobile.getElementHeight(findTestObject('Android/Orders/Cart Screen/Verifictaion Details/orderDetails_button',[('Order_Name') : GlobalVariable.Account]), 0)

		int y_Coordinate_To_Swipe=(ElementHeight/2)+ElementTopPosition

		Mobile.swipe(500, y_Coordinate_To_Swipe, 0, y_Coordinate_To_Swipe)

		//Mobile.swipe(500, 1100, 0, 1100)

		println(y_Coordinate_To_Swipe)

		Mobile.tap(findTestObject('Android/Orders/Cart Screen/Delete Order/YES_Button'), 0)

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
		Mobile.tap(findTestObject('Android/Orders/Cart Screen/Upload All_Orders/uploadAllOrders_Button'), 0)

		Mobile.tap(findTestObject('Android/Orders/Order Details Screen/Upload Order/Continue On Desktop_button'), 0)

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
		Mobile.tap(	findTestObject('Android/Orders/Cart Screen/Place All_Orders/placeAllOrders_Button'), 0)

		while (Mobile.verifyElementExist(findTestObject('Android/Login/Login Details Screen/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}


		Mobile.tap(findTestObject('Android/Orders/Cart Screen/Place All_Orders/placeMyOrders_Button'),0)
	}


	@Keyword
	def verify_Cart_Screen_Details_with_Added_Product() {

		Mobile.verifyElementExist(findTestObject('Android/Orders/Cart Screen/Verifictaion Details/cartHeader_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/Cart Screen/Verifictaion Details/allMobileOrders_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/Cart Screen/Verifictaion Details/mobileOrdersCount_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/Cart Screen/Verifictaion Details/Lines_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/Cart Screen/Verifictaion Details/cartTotal_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/Cart Screen/Verifictaion Details/orderValue_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/Order Details Screen/Verification Details/Scan_Icon'),0)
	}





	@Keyword
	def verify_Cart_Screen_Details_without_Adding_any_Product() {

		Mobile.verifyElementExist(findTestObject('Android/Orders/Order Details Screen/Verification Details/Scan_Icon'),0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/Cart Screen/Verifictaion Details/cartHeader_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/Cart Screen/Verifictaion Details/allMobileOrders_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/Cart Screen/Verifictaion Details/mobileOrdersCount_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/Cart Screen/Verifictaion Details/Lines_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/Cart Screen/Verifictaion Details/cartTotal_TextView'), 0)

		int w = 2

		while (Mobile.verifyElementExist(findTestObject('Android/Login/Login Details Screen/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}
	}
}