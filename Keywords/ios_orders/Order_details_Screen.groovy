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


class Order_details_Screen {

	@Keyword
	def upload_Order() {

		int w=1

		while (Mobile.verifyElementExist(findTestObject('iOS/Product_Search/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}

		Mobile.tap(	findTestObject('Object Repository/iOS/Orders/Order Details Page/Upload Order/Upload Order_Button'), 0)

		Mobile.tap(findTestObject('Homepage After LogIn/Carts_Screen/Continue on Desktop'), 0)
	}


	@Keyword
	def place_Order() {

		int w=1

		while (Mobile.verifyElementExist(findTestObject('iOS/Product_Search/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}

		Mobile.tap(findTestObject('iOS/Orders/Cart Page/Place All Orders/OrderDetail_PlaceOrder_Button'), 0)

		Mobile.tap(findTestObject('iOS/Orders/Cart Page/Place All Orders/Place My Order(s)_Text'), 0)

		Mobile.tap(findTestObject('iOS/Orders/Order Details Page/Place Order/Back to Cart_Text'), 0)
	}



	@Keyword
	def add_Product_to_Order(String product_Name, String quantity) {

		int w = 1

		while (Mobile.verifyElementExist(findTestObject('iOS/Product_Search/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}

		Mobile.tapAndHold(findTestObject('iOS/Inventory/Location Details_Screen/Add Product to Location/Product SearchField'), 0, 0)

		while (Mobile.verifyElementExist(findTestObject('iOS/Product_Search/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}

		Mobile.setText(findTestObject('iOS/Product_Search/Product SearchField'), product_Name, 0)

		Mobile.tapAndHold(findTestObject('iOS/Product_Search/Search Key_Button'), 0, 0)

		Mobile.setText(findTestObject('iOS/Product_Search/Quantity_TextField'), quantity, 0)

		while (Mobile.verifyElementExist(findTestObject('iOS/Product_Search/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}

		Mobile.tap(findTestObject('iOS/Orders/Cart Page/Place All Orders/Done_Keypad'), 0)

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Product to Inventory using Search from Dashoboard/Add to Order_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Product_Search/Confirmation_Text'), 0)

		Mobile.tap(findTestObject('iOS/Orders/Order Details Page/Upload Order/Continue Ordering_Text'), 0)
	}




	@Keyword
	def edit_PO_Name_and_Memo(String po_Name,String po_Memo) {


		Mobile.scrollToText('Edit')

		Mobile.tap(findTestObject('iOS/Orders/Order Details Page/Edit PO Name and Memo/SearchEditOrderLabel'), 0)

		Mobile.tapAndHold(findTestObject('iOS/Orders/Order Details Page/Edit PO Name and Memo/poMemoField_TextField'), 0, 0)

		Mobile.clearText(findTestObject('iOS/Orders/Order Details Page/Edit PO Name and Memo/poMemoField_TextField'), 0)

		Mobile.setText(findTestObject('iOS/Orders/Order Details Page/Edit PO Name and Memo/poMemoField_TextField'), po_Name, 0)

		Mobile.tapAndHold(findTestObject('iOS/Product_Search/Return Keypad_Button'), 0,0)

		Mobile.tapAndHold(findTestObject('iOS/Orders/Order Details Page/Edit PO Name and Memo/EditPOButton'), 0, 0)

		Mobile.clearText(findTestObject('iOS/Orders/Order Details Page/Edit PO Name and Memo/Edit P.O_TextField'), 0)

		Mobile.setText(findTestObject('iOS/Orders/Order Details Page/Edit PO Name and Memo/Edit P.O_TextField'), po_Memo, 0)

		Mobile.tap(findTestObject('iOS/Orders/Order Details Page/Edit PO Name and Memo/Update Order_Button'), 0)
	}




	@Keyword
	def add_Alternate_Product(String product_Name, String quantity) {

		int w = 1

		while (Mobile.verifyElementExist(findTestObject('iOS/Product_Search/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}

		Mobile.tapAndHold(findTestObject('iOS/Inventory/Location Details_Screen/Add Product to Location/Product SearchField'), 0, 0)

		while (Mobile.verifyElementExist(findTestObject('iOS/Product_Search/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}

		Mobile.setText(findTestObject('iOS/Product_Search/Product SearchField'), product_Name, 0)

		Mobile.tapAndHold(findTestObject('iOS/Product_Search/Search Key_Button'), 0, 0)

		Mobile.tap(findTestObject('iOS/Product_Search/Alternate Products_Text'), 0)

		Mobile.setText(findTestObject('iOS/Product_Search/Quantity_TextField'), quantity, 0)

		while (Mobile.verifyElementExist(findTestObject('iOS/Product_Search/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}

		Mobile.tap(findTestObject('iOS/Orders/Cart Page/Place All Orders/Done_Keypad'), 0)

		Mobile.tap(findTestObject('iOS/Product_Search/Add Alternate To Order_Button'), 0)

		Mobile.tap(findTestObject('iOS/Product_Search/Continue_Button'), 0)
	}





	@Keyword
	def verify_Order_Details_Screen_without_any_added_product() {

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Order Details Page/Verification Details/Nothing Header_Label'),  0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Order Details Page/Verification Details/welcome Order Detail_Text'),  0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Order Details Page/Verification Details/0 lines in this order_Text'),   0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Order Details Page/Verification Details/Order Detail Header_Label'),   0)
	}


	@Keyword
	def verify_Order_Details_Screen_Details_with_added_product() {



		Mobile.verifyElementExist(findTestObject('iOS/Orders/Order Details Page/Verification Details/Order Total_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Order Details Page/Verification Details/Product Cost_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Order Details Page/Verification Details/Remove Item_Button'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Product_Details/UOI_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Product_Details/AMU_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Product_Details/NDCLabel_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Product_Details/ManufacturerName_Text'),  0)
	}
}