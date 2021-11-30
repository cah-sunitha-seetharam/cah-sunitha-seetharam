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


class orderDetailsScreen {


	/**
	 * this function gets the total added quantity of the product
	 * @return quantityNumericalValue (of the product which has been added)
	 */
	@Keyword
	def returnQuantityOfTheAddedProduct() {

		String quantity= Mobile.getText(findTestObject('iOS/Orders/Order Details Screen/Verification Details/quantity_TextField'), 0)

		KeywordUtil.logInfo(quantity)

		float quantityNumericalValue=Float.valueOf(quantity)

		return quantityNumericalValue
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

		Mobile.tap(findTestObject('iOS/Orders/Cart Screen/Place All Orders/Done_Keypad'), 0)

		Mobile.tap(findTestObject('iOS/Product_Search/Add Alternate To Order_Button'), 0)

		Mobile.tap(findTestObject('iOS/Product_Search/Continue_Button'), 0)
	}




	/**
	 * searches for a product by setting product name and quantity as the input
	 * @param productName (product to be added), quantity (total quantity required to be added)
	 */
	@Keyword
	def addProductToOrder(String productName, String quantity) {

		Mobile.tapAndHold(findTestObject('iOS/Inventory/Location Details_Screen/Add Product to Location/Product SearchField'), 0, 0)

		(new iosCommonKeywords.commonMethods()).waitForProgressBarToBeInvisible()

		Mobile.setText(findTestObject('iOS/Product_Search/Product SearchField'), productName, 0)

		Mobile.tapAndHold(findTestObject('iOS/Product_Search/Search Key_Button'), 0, 0)

		Mobile.setText(findTestObject('iOS/Product_Search/Quantity_TextField'), quantity, 0)

		(new iosCommonKeywords.commonMethods()).waitForProgressBarToBeInvisible()

		Mobile.tap(findTestObject('iOS/Orders/Cart Screen/Place All Orders/Done_Keypad'), 0)

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Product to Inventory using Search from Inventory Details Screen/addToOrder_Text'), 0)
	}




	/**
	 * this function adds the quantity for the product to be searched
	 * @param quantity (quantity required to be added for the product to be searched)
	 */
	@Keyword
	def addQuantityforTheSearchedProduct(String quantity) {

		Mobile.setText(findTestObject('iOS/Orders/Order Details Screen/Scan Order/quantity_TextField'), quantity, 0)

		Mobile.tap(findTestObject('iOS/Orders/Order Details Screen/Scan Order/done_Button'), 0)
	}



	/**
	 * clicks on c2 order availability and waits for the response while verifying the availability details for the c2 product
	 */
	@Keyword
	def checkC2OrderAvailability() {

		Mobile.tap(findTestObject('iOS/Orders/C2 Order Details Screen/Place C2 Order/checkAvailability_Button'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/C2 Order Details Screen/Place C2 Order/oneMoment_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/C2 Order Details Screen/Place C2 Order/weNeedJustAMinuteToEnsureThatWeHaveEverythingInStock_Texr'),0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/C2 Order Details Screen/Place C2 Order/yourC2OrderIsReadyToSign_Text'),0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/C2 Order Details Screen/Place C2 Order/pleaseReviewAndSignYourOrder_Text'),0)
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
	 * takes user back to the search product results to continue browsing
	 */
	@Keyword
	def clickOnContinueOrderingOnDesktop() {

		Mobile.tap(findTestObject('iOS/Orders/Order Details Screen/Upload Order/continueOnDesktop_Button'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Order Details Screen/Verification Details/yourOrder(s)HasBeenSentToDesktop_Text'), 0)
	}



	/**
	 * taps on scan icon and takes user to scanning product screen and also verifies that the default toggle is at ordering
	 */
	@Keyword
	def clickOnScanIcon() {

		Mobile.tap(findTestObject('iOS/Orders/Order Details Screen/Scan Order/scan_Icon'), 0)

		Mobile.verifyElementAttributeValue(findTestObject('iOS/Orders/Order Details Screen/Scan Order/ordering_Button'), 'value', '1', 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Order Details Screen/Scan Order/priceCheck_Button'), 0)
	}


	/**
	 * creates a new C2 order 
	 * @param poName (poName of the order), poMemo (poMemo of the order)
	 */
	@Keyword
	def createNewC2Order(String poName, String poMemo) {

		//	Mobile.verifyElementExist(findTestObject('iOS/Orders/Order Details Screen/Create C2 Order/thisIsAC2ItemSelectOrCreateAC2OrderToAddItem_Text'), 0)

		Mobile.tap(findTestObject('iOS/Orders/Order Details Screen/Create C2 Order/createANewOrder_Text'), 0)

		Mobile.tapAndHold(findTestObject('iOS/Orders/Order Details Screen/Create C2 Order/poName_TextField'), 0, 0)

		Mobile.setText(findTestObject('iOS/Orders/Order Details Screen/Create C2 Order/setText_TextField'), poName, 0)

		Mobile.tap(findTestObject('iOS/Product_Search/returnKeypad_Button'), 0)

		Mobile.tapAndHold(findTestObject('iOS/Orders/Order Details Screen/Create C2 Order/poMemo_TextField'), 0, 0)

		Mobile.setText(findTestObject('iOS/Orders/Order Details Screen/Create C2 Order/setText_TextField'),poMemo, 0)

		Mobile.tap(findTestObject('iOS/Product_Search/returnKeypad_Button'), 0)

		Mobile.tap(findTestObject('iOS/Orders/Order Details Screen/Create C2 Order/createOrder_Button'), 0)

		Mobile.tap(findTestObject('iOS/Orders/Order Details Screen/Create C2 Order/c2order_radioButton'), 0)

		Mobile.tap(findTestObject('iOS/Product_Search/addToOrder_Button'), 0)

		(new iosCommonKeywords.commonMethods()).waitForProgressBarToBeInvisible()

		Mobile.tap(findTestObject('iOS/Orders/Order Details Screen/Create C2 Order/continueBrowsing_Button'), 0)
	}



	@Keyword
	def edit_PO_Name_and_Memo(String po_Name,String po_Memo) {


		Mobile.scrollToText('Edit')

		Mobile.tap(findTestObject('iOS/Orders/Order Details Screen/Edit PO Name and Memo/SearchEditOrderLabel'), 0)

		Mobile.tapAndHold(findTestObject('iOS/Orders/Order Details Screen/Edit PO Name and Memo/poMemoField_TextField'), 0, 0)

		Mobile.clearText(findTestObject('iOS/Orders/Order Details Screen/Edit PO Name and Memo/poMemoField_TextField'), 0)

		Mobile.setText(findTestObject('iOS/Orders/Order Details Screen/Edit PO Name and Memo/poMemoField_TextField'), po_Name, 0)

		Mobile.tapAndHold(findTestObject('iOS/Product_Search/returnKeypad_Button'), 0,0)

		Mobile.tapAndHold(findTestObject('iOS/Orders/Order Details Screen/Edit PO Name and Memo/EditPOButton'), 0, 0)

		Mobile.clearText(findTestObject('iOS/Orders/Order Details Screen/Edit PO Name and Memo/Edit P.O_TextField'), 0)

		Mobile.setText(findTestObject('iOS/Orders/Order Details Screen/Edit PO Name and Memo/Edit P.O_TextField'), po_Memo, 0)

		Mobile.tap(findTestObject('iOS/Orders/Order Details Screen/Edit PO Name and Memo/Update Order_Button'), 0)
	}

	/**
	 * clicks on place order button
	 */
	@Keyword
	def placeOrder() {

		Mobile.tap(findTestObject('iOS/Orders/Order Details Screen/Place Order/placeOrder_Button'), 0)

		Mobile.tap(findTestObject('iOS/Orders/Cart Screen/Place All Orders/placeMyOrder(s)_Text'), 0)
	}


	/**
	 * scans the product and adds it to the location
	 * @param productToBeSearched (name which can be a productName/Cin/NDC of the product to be added)
	 */
	@Keyword
	def scanInputEvent(String productToBeSearched) {

		Mobile.tap(findTestObject('iOS/Orders/Order Details Screen/Scan Order/scanGray_Image'), 0)

		Mobile.setText(findTestObject('iOS/Orders/Order Details Screen/Scan Order/enterBarcode_TextField'), productToBeSearched, 0)

		Mobile.tap(findTestObject('iOS/Orders/Order Details Screen/Scan Order/done_Button'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Order Details Screen/Verification Details/thisItemHaBeenAddedToYourOrder_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Order Details Screen/Verification Details/alternates_Text'), 0)
	}



	/**
	 * this function selects toggle value for the product to be added which can be ordering or price check)
	 * @param toggleValue (toggleValue required to be selected for the product to be added which can be ordering or price check)
	 */
	@Keyword
	def selectToggleValueForTheProductToBeSearched(String toggleValue) {

		if(toggleValue=="Ordering") {
			Mobile.tap(findTestObject('iOS/Orders/Order Details Screen/Scan Order/ordering_Button'), 0)
		}
		else {
			Mobile.tap(findTestObject('iOS/Orders/Order Details Screen/Scan Order/priceCheck_Button'), 0)
		}
		Mobile.tap(findTestObject('iOS/Orders/Order Details Screen/Scan Order/done_Button'), 0)
	}




	/**
	 * uploads the order by clicking on upload order button
	 */
	@Keyword
	def uploadOrder() {

		Mobile.tap(findTestObject('iOS/Orders/Order Details Screen/Upload Order/uploadOrder_Button'), 0)
	}


	/**
	 * verifies the pop up which appears after user clicks on upload order
	 */
	@Keyword
	def verifyUploadOrderPopUp() {

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Order Details Screen/Verification Details/continueOrderOnTheDesktop_Text'), 0)
				
		Mobile.verifyElementExist(findTestObject('iOS/Orders/Cart Screen/Upload All Orders/cancelAndKeepOrdersOnTheApp_Button'), 0)
		
	}


	@Keyword
	def verify_Order_Details_Screen_Details_with_added_product() {



		Mobile.verifyElementExist(findTestObject('iOS/Orders/Order Details Screen/Verification Details/Order Total_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Order Details Screen/Verification Details/Product Cost_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Order Details Screen/Verification Details/Remove Item_Button'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Product_Details/UOI_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Product_Details/AMU_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Product_Details/NDCLabel_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Product_Details/ManufacturerName_Text'),  0)
	}



	/**
	 * verifies order details screen when user creates an order
	 */
	@Keyword
	def verifyOrderDetailsScreenWithoutAnyAddedProduct(poName) {

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Order Details Screen/Verification Details/orderDetailHeader_Label',[('TEXT'):poName]),0)

		Mobile.verifyElementAttributeValue(	findTestObject('iOS/Orders/Order Details Screen/Upload Order/uploadOrder_Button'), 'enabled', 'false', 0)

		Mobile.verifyElementAttributeValue(findTestObject('iOS/Orders/Order Details Screen/Place Order/placeOrder_Button'), 'enabled', 'false', 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Order Details Screen/Verification Details/product_SearchField'), 0, FailureHandling.STOP_ON_FAILURE)
	}
}