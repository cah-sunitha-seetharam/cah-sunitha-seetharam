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
import org.openqa.selenium.Keys as Keys
import java.awt.Robot as Robot

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import common.commonMethods
import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile


class orderDetailsScreen {

	def commonMethodsObject=new commonMethods();
	def commonIosMethodsObject=new iosCommonKeywords.commonMethods();


	@Keyword
	def add_Alternate_Product(String product_Name, String quantity) {

		int w = 1

		while (Mobile.verifyElementExist(findTestObject('iOS/Product Search/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}

		Mobile.tapAndHold(findTestObject('iOS/Inventory/Location Details_Screen/Add Product to Location/Product SearchField'), 0, 0)

		while (Mobile.verifyElementExist(findTestObject('iOS/Product Search/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}

		Mobile.setText(findTestObject('iOS/Product Search/productSearch_TextField'), product_Name, 0)

		Mobile.tapAndHold(findTestObject('iOS/Product Search/Search Key_Button'), 0, 0)

		Mobile.tap(findTestObject('iOS/Product Search/Alternate Products_Text'), 0)

		Mobile.setText(findTestObject('iOS/Product Search/Quantity_TextField'), quantity, 0)

		while (Mobile.verifyElementExist(findTestObject('iOS/Product Search/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}

		Mobile.tap(findTestObject('iOS/Orders/Cart Screen/Place All Orders/Done_Keypad'), 0)

		Mobile.tap(findTestObject('iOS/Product Search/Add Alternate To Order_Button'), 0)

		Mobile.tap(findTestObject('iOS/Product Search/Continue_Button'), 0)
	}



	/**
	 * searches for a product by setting product name and quantity as the input
	 * @param productName (product to be added), quantity (total quantity required to be added)
	 */
	@Keyword
	def addProductToOrder(String productName, String quantity) {

		Mobile.tapAndHold(findTestObject('iOS/Inventory/Location Details Screen/Add Product to Location/productSearch_TextField'), 0, 0)

		commonIosMethodsObject.waitForProgressBarToBeInvisible()

		Mobile.setText(findTestObject('iOS/Product Search/productSearch_TextField'), productName, 0)

		Mobile.tapAndHold(findTestObject('iOS/Product Search/search_Keypad'), 0, 0)

		Mobile.setText(findTestObject('iOS/Product Search/quantity_TextField'), quantity, 0)

		commonIosMethodsObject.waitForProgressBarToBeInvisible()

		Mobile.tap(findTestObject('iOS/Orders/Cart Screen/Place All Orders/Done_Keypad'), 0)

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Product to Inventory using Search from Inventory Details Screen/addToOrder_Text'), 0)

		Mobile.tap(findTestObject('iOS/Orders/Order Details Screen/Create C2 Order/continueOrdering_Button'), 0)

		//Mobile.tap(findTestObject('iOS/Product Search/Continue_Button'), 0)
	}




	/**
	 * this function adds the quantity for the product to be searched
	 * @param quantity (quantity required to be added for the product to be searched)
	 */
	@Keyword
	def addQuantityforTheSearchedProduct(String quantity) {

		Mobile.setText(findTestObject('iOS/Product Search/Scan Flow/quantity_TextField'), quantity, 0)

		Mobile.tap(findTestObject('iOS/Product Search/Scan Flow/done_Button'), 0)
	}

	/**
	 * this function returns the top most product name in order details page
	 */
	@Keyword
	def returnTopMostProductNameInOrderDetails(){
		String productName=Mobile.getText(findTestObject('Object Repository/iOS/Orders/Order Details Screen/Verification Details/productDescriptionLabel_Text'), 0)
		return productName
	}

	/**
	 * verifies that the added top most product should  be visible on the order details page
	 * @param productname (top most added product name)
	 */
	@Keyword
	def verifyProductNameIsVisibleUnderOrderDetails(String productname) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/iOS/Orders/Order Details Screen/Verification Details/productDescriptionLabel_Text',[('TEXT'): productname]) ,0)
	}

	/**
	 * clicks on c2 order availability and waits for the response while verifying the availability details for the c2 product
	 */
	@Keyword
	def checkC2OrderAvailability() {

		Mobile.tap(findTestObject('iOS/Orders/C2 Order Details Screen/Place C2 Order/checkAvailabilityNew_Button'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/C2 Order Details Screen/Place C2 Order/oneMoment_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/C2 Order Details Screen/Place C2 Order/weNeedJustAMinuteToEnsureThatWeHaveEverythingInStock_Texr'),0)

		WebUI.delay(15)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/C2 Order Details Screen/Place C2 Order/yourC2OrderIsReadyToSign_Text'),0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/C2 Order Details Screen/Place C2 Order/pleaseReviewAndSignYourOrder_Text'),0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/C2 Order Details Screen/Place C2 Order/reviewAndSign_Button'),0)
	}

	/**
	 * searches for a product by setting product name
	 * @param productName (product to be added)
	 */
	@Keyword
	def searchProductInOrderDetailPage(String productName) {
		Mobile.tap(findTestObject('Object Repository/iOS/Product Search/productSearch_TextField'), 0)
		Mobile.setText(findTestObject('Object Repository/iOS/Product Search/productSearch_TextField'), productName ,0)
		Mobile.tapAndHold(findTestObject('Object Repository/iOS/Orders/Product Info/Product Search/search_keypad'), 0, 0)
	}

	/**
	 * searches for a product by setting product name
	 * @param productName (product to be added)
	 */
	@Keyword
	def searchProductInOrderDetailPageOfflineMode(String productName) {
		Mobile.delay(3)
		Mobile.tap(findTestObject('Object Repository/iOS/Product Search/productSearch_TextField'), 0)
		Mobile.setText(findTestObject('Object Repository/iOS/Product Search/productSearch_TextField'), productName ,0)
	}

	/**
	 * taps on search key of the keyboard
	 */
	@Keyword
	def tapOnsearchKeyInOfflineMode() {
		Mobile.tapAndHold(findTestObject('Object Repository/iOS/Orders/Product Info/Product Search/search_keypad'), 0, 0)
	}


	/**
	 * opens product tile
	 */
	@Keyword
	def clickOnProductTile() {
		Mobile.tap(findTestObject('Object Repository/iOS/Orders/Product Info/Product Search/NDC_Text'), 0)
	}

	/**
	 * opens more details of product details
	 */
	@Keyword
	def clickOnMoreDetails() {
		Mobile.tap(findTestObject('Object Repository/iOS/Orders/Product Info/Product Search/moreDetailsView_Text'), 0)
	}

	/**
	 * opens alternates page
	 */
	@Keyword
	def tapOnAlternatesInProductDetailsPage() {
		Mobile.tap(findTestObject('iOS/Orders/Product Info/Product Details/alternates_Text'), 0)
	}

	/**
	 * verifies filterByOptions
	 */
	@Keyword
	def verifyFilterByOptions() {
		Mobile.verifyElementExist(findTestObject('iOS/Orders/Alternates Screen/stockedFilterByOptions_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/Orders/Alternates Screen/formFilterByOptions_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/Orders/Alternates Screen/sizeFliterByOptions_Text'), 0)
		int ElementTopPosition = Mobile.getElementTopPosition(findTestObject('iOS/Orders/Alternates Screen/stockedFilterByOptions_Text'), 0)
		int ElementHeight=Mobile.getElementHeight(findTestObject('iOS/Orders/Alternates Screen/stockedFilterByOptions_Text'), 0)
		int yCoordinateToSwipe=(ElementHeight/2)+ElementTopPosition
		Mobile.swipe(500, yCoordinateToSwipe, 0, yCoordinateToSwipe)
		Mobile.verifyElementExist(findTestObject('iOS/Orders/Alternates Screen/contractFilterByOptions_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/Orders/Alternates Screen/manufacturerFilterByOptions_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/Orders/Alternates Screen/suggestedAlternate_TextView'), 0)
	}

	/**
	 * this function verifies the product after search
	 */
	@Keyword
	def verifyProductAfterSearch() {
		Mobile.verifyElementExist(findTestObject('Object Repository/iOS/Orders/Product Info/Product Search/NDC_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/Orders/Product Info/Product Search/productDescriptionLabel_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/Orders/Product Info/Product Search/UOI_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/Orders/Product Info/Product Search/quantity_TextField'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/Orders/Product Info/Product Search/manufacturer_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/Orders/Product Info/Product Search/alternates_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/Orders/Product Info/Product Search/addToOrder_Text'), 0)
	}

	/**
	 * verifies c2 order is not visible under non c2 order
	 */
	@Keyword
	def verifyC2OrderIsNotVisibleUnderNonC2Order() {
		Mobile.verifyElementNotVisible(findTestObject('iOS/Orders/Product Info/Product Details/c2Label_Text'), 0)
	}

	/**
	 * this function returns the order name in search page
	 */
	@Keyword
	def returnProductNameAfterSearch(){
		String orderNameInSearchPage=Mobile.getText(findTestObject('iOS/Orders/Product Info/Product Search/productDescriptionLabel_Text'), 0)
		return orderNameInSearchPage
	}

	/**
	 * this function verifies the product tile
	 */
	@Keyword
	def verifyProductTile() {
		Mobile.verifyElementExist(findTestObject('iOS/Orders/Product Info/Product Search/CIN_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/Orders/Product Info/Product Search/UPC_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/Orders/Product Info/Product Search/retailPrice_Text'), 0)
		Mobile.verifyElementExist(findTestObject('Object Repository/iOS/Orders/Product Info/Product Search/moreDetailsView_Text'), 0)
	}


	/**
	 * removes product from orders details
	 */
	@Keyword
	def removeProduct() {
		Mobile.tap(findTestObject('Object Repository/iOS/Orders/Order Details Screen/Verification Details/Remove Item_Button'), 0)
	}

	/**
	 * this function verifies the product details page
	 */

	@Keyword
	def verifyProductDetailAfterSelectingMoreDetails(String orderNameInSearchPage){
		String orderNameInProductDetailsPage=Mobile.getText(findTestObject('iOS/Orders/Product Info/Product Details/productDescriptionLabel_Text'), 0)
		assert orderNameInSearchPage== orderNameInProductDetailsPage
		Mobile.verifyElementExist(findTestObject('iOS/Orders/Product Info/Product Details/c2Label_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/Orders/Product Info/Product Details/productSize_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/Orders/Product Info/Product Details/NDC_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/Orders/Product Info/Product Details/UOI_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/Orders/Product Info/Product Details/stockStatus_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/Orders/Product Info/Product Details/returnable_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/Orders/Product Info/Product Details/quantity_TextField'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/Orders/Product Info/Product Details/less_Button'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/Orders/Product Info/Product Details/more_Button'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/Orders/Product Info/Product Details/strength_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/Orders/Product Info/Product Details/form_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/Orders/Product Info/Product Details/UPC_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/Orders/Product Info/Product Details/CIN_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/Orders/Product Info/Product Details/contractAlias_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/Orders/Product Info/Product Details/retailPrice_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/Orders/Product Info/Product Details/CIN_Text'), 0)
		Mobile.verifyElementExist(findTestObject('Object Repository/iOS/Orders/Product Info/Product Details/alternates_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/Orders/Product Info/Product Details/AddToOrder_Button'), 0)
	}

	/**
	 * verifies order name header label
	 * @param poName (poName is the order name)
	 */
	@Keyword
	def verifyOrderNameHeaderLabel(String poName){
		Mobile.verifyElementVisible(findTestObject('Object Repository/iOS/Orders/Verification Details/OrderDetailHeader_Label',[('TEXT'):poName]),0)
	}

	/**
	 * this function adds the quantity in alternates page
	 * @param quantity (quantity required to add in product detail page)
	 */
	@Keyword
	def addQuantityInAlternatesPage(String quantity) {
		Mobile.setText(findTestObject('iOS/Orders/Alternates Screen/quantity_TextField'), quantity, 0)
		Mobile.tap(findTestObject('iOS/Product Search/Scan Flow/done_Button'), 0)
	}

	/**
	 * this function adds the quantity in product detail page
	 * @param quantity (quantity required to add in product detail page)
	 */
	@Keyword
	def addQuantityInProductDetailsPage(String quantity) {
		Mobile.setText(findTestObject('iOS/Orders/Product Info/Product Details/quantity_TextField'), quantity, 0)
		Mobile.tap(findTestObject('iOS/Orders/Product Info/Product Details/quantity_TextField'), 0)
	}

	/**
	 * adds product in product details page
	 */
	@Keyword
	def tapOnAddToOrderInProductDetailsPage() {
		Mobile.tap(findTestObject('iOS/Orders/Product Info/Product Details/AddToOrder_Button'), 0)
	}

	/**
	 * taps on alternate to order in alternates page and opens confirmation pop up
	 */
	@Keyword
	def tapOnAddAlternateToOrderInAlternatesPage() {
		Mobile.tap(findTestObject('iOS/Orders/Alternates Screen/addAlternateToOrder_Text'),  0)
	}

	/**
	 * verifies confirmation pop up in alternates page
	 */
	@Keyword
	def verifyConfirmationPopUpInALternatesPage() {
		Mobile.verifyElementExist(findTestObject('iOS/Orders/Alternates Screen/itemAddedConfirmationTitle_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/Orders/Alternates Screen/continueBrowsing_Button'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/Orders/Alternates Screen/goToOrder_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/Orders/Alternates Screen/newOrderCreated_Text'), 0)
	}

	/**
	 * takes user back to the search product results to continue browsing
	 */
	@Keyword
	def tapOnContinueBrowsing() {

		Mobile.tap(findTestObject('iOS/Orders/Alternates Screen/continueBrowsing_Button') ,0)
	}


	/**
	 * takes user back to cart screen and verifies user is on the cart screen or not
	 */
	@Keyword
	def clickOnBackToCart() {

		Mobile.tap(findTestObject('iOS/Product Search/backToCart_Text'), 0)

		Mobile.verifyElementAttributeValue(findTestObject('Object Repository/iOS/Dashboard/orders_Tab'), 'value', '1',0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Verification Details/cartHeader_Label'),0)
	}


	/**
	 * takes user back to the search product results to continue browsing
	 */
	@Keyword
	def clickOnContinueOrderingOnDesktop() {

		Mobile.tap(findTestObject('iOS/Orders/Order Details Screen/Upload Order/continueOnDesktop_Button'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Order Details Screen/Verification Details/yourOrder(s)HasBeenSentToDesktop_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Product Search/backToCart_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Cart Screen/Upload All Orders/goToDashboard_Button'), 0)
	}

	/**
	 * takes user back to the search product results to continue browsing
	 */
	@Keyword
	def tapContinueOnDesktop() {
		Mobile.tap(findTestObject('iOS/Orders/Order Details Screen/Upload Order/continueOnDesktop_Button'), 0)
	}

	/**
	 * taps on scan icon and takes user to scanning product screen and also verifies that the default toggle is at ordering
	 */
	@Keyword
	def clickOnScanIcon() {

		Mobile.tap(findTestObject('iOS/Product Search/Scan Flow/scan_Icon'), 0)

		Mobile.verifyElementAttributeValue(findTestObject('iOS/Product Search/Scan Flow/ordering_Button'), 'value', '1', 0)

		Mobile.verifyElementExist(findTestObject('iOS/Product Search/Scan Flow/priceCheck_Button'), 0)
	}

	/**
	 *  taps on scan icon and takes user to scanning product screen 
	 */
	@Keyword
	def clickOnScanIconWithoutVerification() {
		Mobile.tap(findTestObject('iOS/Product Search/Scan Flow/scan_Icon'), 0)
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

		Mobile.tap(findTestObject('iOS/Product Search/returnKeypad_Button'), 0)

		Mobile.tapAndHold(findTestObject('iOS/Orders/Order Details Screen/Create C2 Order/poMemo_TextField'), 0, 0)

		Mobile.setText(findTestObject('iOS/Orders/Order Details Screen/Create C2 Order/setText_TextField'),poMemo, 0)

		Mobile.tap(findTestObject('iOS/Product Search/returnKeypad_Button'), 0)

		Mobile.tap(findTestObject('iOS/Orders/Order Details Screen/Create C2 Order/createOrder_Button'), 0)

		Mobile.tap(findTestObject('iOS/Orders/Order Details Screen/Create C2 Order/c2order_radioButton'), 0)

		Mobile.tap(findTestObject('iOS/Product Search/addToOrder_Button'), 0)

		(new iosCommonKeywords.commonMethods()).waitForProgressBarToBeInvisible()

		Mobile.tap(findTestObject('iOS/Orders/Order Details Screen/Create C2 Order/continueBrowsing_Button'), 0)
	}



	/**
	 * edits the order details which are purchase order name and memo
	 * @param poName (new poName of the order)
	 * @param poMemo (new poMemo of the order)
	 */
	@Keyword
	def editPONameAndMemo(String poName,String poMemo) {

		Mobile.scrollToText('Edit')

		Mobile.tap(findTestObject('iOS/Orders/Order Details Screen/Edit PO Name and Memo/SearchEditOrderLabel'), 0)

		Mobile.tapAndHold(findTestObject('iOS/Orders/Order Details Screen/Edit PO Name and Memo/poMemoField_TextField'), 0, 0)

		Mobile.clearText(findTestObject('iOS/Orders/Order Details Screen/Edit PO Name and Memo/poMemoField_TextField'), 0)

		Mobile.setText(findTestObject('iOS/Orders/Order Details Screen/Edit PO Name and Memo/poMemoField_TextField'), poName, 0)

		Mobile.tapAndHold(findTestObject('iOS/Product Search/returnKeypad_Button'), 0,0)

		Mobile.tapAndHold(findTestObject('iOS/Orders/Order Details Screen/Edit PO Name and Memo/EditPOButton'), 0, 0)

		Mobile.clearText(findTestObject('iOS/Orders/Order Details Screen/Edit PO Name and Memo/Edit P.O_TextField'), 0)

		Mobile.setText(findTestObject('iOS/Orders/Order Details Screen/Edit PO Name and Memo/Edit P.O_TextField'), poName, 0)

		Mobile.tap(findTestObject('iOS/Orders/Order Details Screen/Edit PO Name and Memo/Update Order_Button'), 0)
	}



	/**
	 * clicks on place order button
	 */
	@Keyword
	def placeOrder() {

		Mobile.tap(findTestObject('iOS/Orders/Order Details Screen/Place Order/placeOrder_Button'), 0)

		Mobile.tap(findTestObject('iOS/Orders/Cart Screen/Place All Orders/placeMyOrder(s)_Text'), 0)

		(new iosCommonKeywords.commonMethods()).waitForProgressBarToBeInvisible()
	}

	/**
	 * places the order
	 */

	@Keyword
	def clickOnPlaceOrder() {
		Mobile.tap(findTestObject('iOS/Orders/Order Details Screen/Place Order/placeOrder_Button'), 0)
	}

	/**
	 * verifies place order confirmation pop up
	 */
	@Keyword
	def verifyPlaceOrderPopUp() {
		Mobile.verifyElementExist(findTestObject('Object Repository/iOS/Orders/Order Details Screen/Place Order/goBackAndReviewMyOrder_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/Orders/Cart Screen/Place All Orders/placeMyOrder(s)_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/Orders/Order Details Screen/Place Order/yourOrderWillBePlaced_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/Orders/Order Details Screen/Place Order/YourOrderWillGoIntoProcessingImmediately_Text'), 0)
	}

	/**
	 * confirms place order by clicking on place my order button
	 */
	@Keyword
	def confirmPlaceOrder() {
		Mobile.tap(findTestObject('iOS/Orders/Cart Screen/Place All Orders/placeMyOrder(s)_Text'), 0)
	}



	/**
	 * this function returns the order value
	 * @return orderTotal_dollarSymbolRemoved_FloatValue (order total value)
	 */
	@Keyword
	def returnOrderValue() {

		String orderTotal=Mobile.getText(findTestObject('iOS/Orders/Verification Details/orderTotal_Text'), 0)

		//float orderTotal_dollarSymbolRemoved_FloatValue=(new common.commonMethods()).floatValueGenerator(orderTotal)//converting uoiCost string to a float value
		orderTotal=orderTotal.replaceAll("[^0-9.]", "")
		float orderTotal_dollarSymbolRemoved_FloatValue=orderTotal.toFloat()
		
		return orderTotal_dollarSymbolRemoved_FloatValue
	}


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



	/**
	 * scans the product, adds it to the order and also verifies some scan input details when 'ordering' toggle is selected
	 * @param productToBeSearched (name which can be a productName/Cin/NDC of the product to be added)
	 */
	@Keyword
	def scanInputEvent(String productToBeSearched) {

		Mobile.tap(findTestObject('iOS/Product Search/Scan Flow/scanGray_Image'), 0)

		Mobile.setText(findTestObject('iOS/Product Search/Scan Flow/enterBarcode_TextField'), productToBeSearched, 0)

		Mobile.tap(findTestObject('iOS/Product Search/Scan Flow/done_Button'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Order Details Screen/Verification Details/thisItemHaBeenAddedToYourOrder_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Order Details Screen/Verification Details/alternates_Text'), 0)
	}

	/**
	 * scans the product
	 * @param productToBeSearched (name which can be a productName/Cin/NDC of the product to be added)
	 */
	@Keyword
	def scanInputEventWithoutVerification(String productToBeSearched) {
		Mobile.tap(findTestObject('iOS/Product Search/Scan Flow/scanGray_Image'), 0)
		Mobile.setText(findTestObject('iOS/Product Search/Scan Flow/enterBarcode_TextField'), productToBeSearched, 0)
		Mobile.tap(findTestObject('iOS/Product Search/Scan Flow/done_Button'), 0)
		Mobile.tap(findTestObject('Object Repository/iOS/Product Search/doneKeypad_Button'), 0)
	}


	/**
	 * scans the product in offline mode
	 * @param productToBeSearched (name which can be a productName/Cin/NDC of the product to be added)
	 */
	@Keyword
	def scanInputEventInOfflineMode(String productToBeSearched) {
		Mobile.tap(findTestObject('iOS/Product Search/Scan Flow/scanGray_Image'), 0)
		Mobile.setText(findTestObject('iOS/Product Search/Scan Flow/enterBarcode_TextField'), productToBeSearched, 0)
		Mobile.tap(findTestObject('iOS/Product Search/Scan Flow/done_Button'), 0)
	}

	/**
	 * retruns NDC number
	 */
	@Keyword
	def returnNDCLabelOfScannedProduct () {
		String NDCLabel = Mobile.getText(findTestObject('iOS/Verification/NDCLabel_Text'), 0)
		return NDCLabel
	}



	/**
	 * allows camera access while using real device
	 */
	@Keyword
	def tapOnOkForCameraAcess() {
		Mobile.delay(1)
		Mobile.tapAndHold(findTestObject('Object Repository/iOS/Verification/okRealDeviceCameraAccess_Button'), 0, 0)
	}

	/**
	 * closes the popup when user switches to offline mode
	 */
	@Keyword
	def closeOfflinePopUp() {
		Mobile.tap(findTestObject('iOS/Verification/boltTextOfflineMode_Text'), 0)
	}

	/**
	 * scans the product, adds it to the order and also verifies some scan input details when 'price check' toggle is selected
	 * @param productToBeSearched (name which can be a productName/Cin/NDC of the product to be added)
	 */
	@Keyword
	def scanInputEventWhileOnPriceCheck(String productToBeSearched) {

		Mobile.tap(findTestObject('iOS/Product Search/Scan Flow/scanGray_Image'), 0)

		Mobile.setText(findTestObject('iOS/Product Search/Scan Flow/enterBarcode_TextField'), productToBeSearched, 0)

		Mobile.tap(findTestObject('iOS/Product Search/Scan Flow/done_Button'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Order Details Screen/Verification Details/alternates_Text'), 0)
	}



	/**
	 * this function selects toggle value for the product to be added which can be ordering or price check)
	 * @param toggleValue (toggleValue required to be selected for the product to be added which can be ordering or price check)
	 */
	@Keyword
	def selectToggleValueForTheProductToBeSearched(String toggleValue) {

		if(toggleValue=="Ordering") {
			Mobile.tap(findTestObject('iOS/Product Search/Scan Flow/ordering_Button'), 0)
		}
		else {
			Mobile.tap(findTestObject('iOS/Product Search/Scan Flow/priceCheck_Button'), 0)
		}
	}



	/**
	 * uploads the c2 order by clicking on upload order button
	 */
	@Keyword
	def uploadC2Order() {

		Mobile.tap(findTestObject('Object Repository/iOS/Orders/Cart Screen/uploadC2Order_Button'), 0)
	}


	/**
	 * uploads the order by clicking on upload order button and verifies upload order button gets disabled after uploading
	 */
	@Keyword
	def uploadOrder() {

		Mobile.tap(findTestObject('iOS/Orders/Order Details Screen/Upload Order/uploadOrder_Button'), 0)
	}


	/**
	 * verifies c2 label is visible or not
	 */
	@Keyword
	def verifyC2Label() {

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Verification Details/controlledItem_Text'), 0)
	}


	/**
	 * takes productSearch and expected lines count as the arguments and verifies the same
	 * @param expectedLinesCount (expected lines count after adding product to an order)
	 * @param productNdcNumber (using NDC of the product which is visible on the product tab)
	 * if in future upc/cin are visible then the method can be modified accordingly by passing the respective test object	 */
	@Keyword
	def verifyOrderDetailsScreenAfterAddingAProduct(String productNdcNumber, String expectedLinesCount) {

		(new iosOrders.orderDetailsScreen()).verifyProductIsVisibleOnTheOrderDetailsScreen(productNdcNumber)//calling verifyProductIsVisibleOnTheScreen function and passing testObj, topProductIdentificationNumber as the arguments

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Verification Details/orderDetailHeader_Text'), 0)

		String linesCount=Mobile.getText(findTestObject('iOS/Orders/Order Details Screen/Verification Details/lines_Text'), 0)

		assert linesCount==expectedLinesCount
	}


	/**
	 * takes user to dash-board
	 */
	@Keyword
	def goToDashboard() {

		Mobile.tap(findTestObject('iOS/Orders/Cart Screen/Upload All Orders/goToDashboard_Button'), 0)
	}




	/**
	 * this function returns the cost of added product
	 * @return productCost (of the product which has been added)
	 */
	@Keyword
	def returnCostOfTheAddedProduct() {

		String testObj='Object Repository/iOS/Orders/Verification Details/productCost_Text'

		float productCost=(new iosCommonKeywords.commonMethods()).returnCostOfTheAddedProduct(testObj)//calling common method to get product cost

		return productCost
	}



	/**
	 * verifies order details screen when user creates an order
	 * @param poName (purchase order name)
	 */
	@Keyword
	def verifyOrderDetailsScreenWithoutAnyAddedProduct(poName) {

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Order Details Screen/Verification Details/orderDetailHeader_Label',[('TEXT'):poName]),0)

		Mobile.verifyElementAttributeValue(findTestObject('iOS/Orders/Order Details Screen/Upload Order/uploadOrder_Button'), 'enabled', 'false', 0)

		Mobile.verifyElementAttributeValue(findTestObject('iOS/Orders/Order Details Screen/Place Order/placeOrder_Button'), 'enabled', 'false', 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Order Details Screen/Verification Details/product_SearchField'), 0, FailureHandling.STOP_ON_FAILURE)
	}

	/**
	 * verifies order details screen when user in offline mode
	 */
	@Keyword
	def verifyOrderDetailsScreenInOfflineMode () {
		Mobile.verifyElementAttributeValue(findTestObject('iOS/Orders/Order Details Screen/Upload Order/uploadOrder_Button'), 'enabled', 'false', 0)
		Mobile.verifyElementAttributeValue(findTestObject('iOS/Orders/Order Details Screen/Place Order/placeOrder_Button'), 'enabled', 'false', 0)
	}

	/**
	 * verifies the order value after adding a product
	 * @param quantity (quantity which was added)
	 */
	@Keyword
	def verifyOrderValue(quantity) {

		int quantityIntegralValue=Integer.parseInt(quantity)

		String productCost=Mobile.getText(findTestObject('iOS/Orders/Verification Details/productCost_Text'), 0)
		productCost=productCost.replaceAll("[^0-9.]", "")
		float productCost_FloatValue=productCost.toFloat()
		//float productCost_dollarSymbolRemoved_FloatValue=commonMethodsObject.floatValueGenerator(productCost)//converting uoiCost string to a float value

		float expectedOrderTotal=quantityIntegralValue*productCost_FloatValue

		String formattedExpectedOrderTotal=commonMethodsObject.formatDecimalData(expectedOrderTotal,"0.00") //formatting the data to be rounded off to upper level and to two decimal places

		//float formattedExpectedOrderTotal_FloatValue=commonMethodsObject.floatValueGenerator(formattedExpectedOrderTotal)///converting formattedExpectedOrderTotal string to a float value
		float formattedExpectedOrderTotal_FloatValue=formattedExpectedOrderTotal.toFloat()

		KeywordUtil.logInfo(formattedExpectedOrderTotal)

		String actualOrderTotal=Mobile.getText(findTestObject('iOS/Orders/Verification Details/orderTotal_Text'), 0)

		//float actualOrderTotal_dollarSymbolRemoved_FloatValue=commonMethodsObject.floatValueGenerator(actualOrderTotal)//converting actualOrderTotal string to a float value

		actualOrderTotal=actualOrderTotal.replaceAll("[^0-9.]", "")
		float actualOrderTotal_dollarSymbolRemoved_FloatValue=actualOrderTotal.toFloat()

		KeywordUtil.logInfo(actualOrderTotal)

		assert formattedExpectedOrderTotal_FloatValue==actualOrderTotal_dollarSymbolRemoved_FloatValue
	}



	/**
	 * this function verifies that the product is visible on the order details screen
	 * @param productNdcNumber (using NDC of the product which is visible on the product tab)
	 * if in future upc/cin are visible then the method can be modified accordingly by passing the respective test object
	 */
	@Keyword
	def verifyProductIsVisibleOnTheOrderDetailsScreen(productNdcNumber) {

		String testObj='Object Repository/iOS/Orders/Verification Details/ordersNdc_Label'

		(new iosCommonKeywords.commonMethods()).verifyProductIsVisibleOnTheScreen(testObj,productNdcNumber)//calling verifyProductIsVisibleOnTheScreen function and passing testObj, topProductIdentificationNumber as the arguments
	}




	/**
	 * verifies the pop up which appears after user clicks on upload order
	 */
	@Keyword
	def verifyUploadOrderPopUp() {

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Order Details Screen/Verification Details/continueOrderOnTheDesktop_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Cart Screen/Upload All Orders/cancelAndKeepOrdersOnTheApp_Button'), 0)
	}

	/**
	 * this function adds the product to be ordered - when price check toggle is selected
	 * @param quantity (quantity required to be added for the product to be searched)
	 */
	@Keyword
	def addToOrder() {

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Product to Inventory using Search from Inventory Details Screen/addToOrder_Text'), 0)

		(new iosCommonKeywords.commonMethods()).waitForProgressBarToBeInvisible()

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Order Details Screen/priceCheckToggle_Screen/newOrderCreated_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Order Details Screen/priceCheckToggle_Screen/goToOrder_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Order Details Screen/priceCheckToggle_Screen/continueBrowsing_Text'), 0)
	}


	/**
	 * adds product 
	 */
	@Keyword
	def addToOrderWithoutVerify() {
		Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Product to Inventory using Search from Inventory Details Screen/addToOrder_Text'), 0)
	}

	/**
	 * taps on go to order button on order confirmation screen and takes user to order details screen
	 */
	@Keyword
	def clickOnGoToOrder() {

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Order Details Screen/priceCheckToggle_Screen/goToOrder_Button'), 0)

		Mobile.tap(findTestObject('iOS/Orders/Order Details Screen/priceCheckToggle_Screen/goToOrder_Button'), 0)
	}

	/**
	 * taps on continue browsing button on order confirmation screen and takes user to scan result screen
	 */
	@Keyword
	def clickOnContinueBrowsing() {

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Order Details Screen/priceCheckToggle_Screen/continueBrowsing_Button'), 0)

		Mobile.tap(findTestObject('iOS/Orders/Order Details Screen/priceCheckToggle_Screen/continueBrowsing_Button'), 0)
	}


	/**
	 * verified user is taken to scan result screen after tapping on continue browsing button
	 */
	@Keyword
	def verifyScanResultScreenWithProduct() {

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Order Details Screen/priceCheckToggle_Screen/addToOrder_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Product Search/Scan Flow/ordering_Button'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Product Search/Scan Flow/priceCheck_Button'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Product Search/Scan Flow/productDescription_Label'), 0)
	}


	/**
	 * this function returns the order name of the order/ title of the screen when user is on order details screen
	 * return orderName (returns order name/ title of order details screen)
	 */
	@Keyword
	def returnOrderNameFromOrderDetailScreen() {

		String orderName=Mobile.getText(findTestObject('iOS/Orders/Verification Details/orderDetailHeader_Label'), 0)

		return orderName
	}


	/**
	 * taps on continue ordering button on order details screen after user has added a product to order
	 * and takes user to scan result screen
	 */
	@Keyword
	def clickOnContinueOrdering() {

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Order Details Screen/Create C2 Order/continueOrdering_Button'), 0)

		Mobile.tap(findTestObject('iOS/Orders/Order Details Screen/Create C2 Order/continueOrdering_Button'), 0)
	}


	/**
	 * takes user back to history screen and verifies user is on the history screen or not
	 */
	@Keyword
	def clickOnReviewAndSignButton() {

		Mobile.tap(findTestObject('iOS/Orders/C2 Order Details Screen/Place C2 Order/reviewAndSign_Button'), 0)

		(new iosCommonKeywords.commonMethods()).waitForProgressBarToBeInvisible()

		Mobile.verifyElementExist(findTestObject('iOS/Orders/History Screen/orderHistory_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/History Screen/historyScreen_Header'),  0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/History Screen/scan_Icon'),0)
	}


	/**
	 * try removing all characters in UTN field
	 */
	@Keyword
	def removeCharactersInUTNField() {

		Mobile.clearText(findTestObject('iOS/Orders/C2 Order Details Screen/Place C2 Order/uniqueTrackingNumber_TextField'), 0)

		Mobile.delay(1)

		Mobile.sendKeys(findTestObject('iOS/Orders/C2 Order Details Screen/Place C2 Order/uniqueTrackingNumber_TextField'), Keys.chord(Keys.RETURN))
	}

	/**
	 * fetch UTN number and store it in a string
	 */
	@Keyword
	def getUTNFromUTNTextField() {

		String beforeUTN = Mobile.getText(findTestObject('iOS/Orders/C2 Order Details Screen/Place C2 Order/uniqueTrackingNumber_TextField'), 0)

		return beforeUTN;
	}


	/**
	 * verifies only last 6 digit got deleted, first 3 characters could not be removed & validation error displayed after removing characters
	 */
	@Keyword
	def verifyValidationErrorAfterRemovingCharactesInUTNField() {

		String actualErrorMsg = Mobile.getText(findTestObject('iOS/Orders/C2 Order Details Screen/Place C2 Order/uniqueTrackingNumberError_Label_2'), 0)

		String expectedErrorMsg = 'Please provide a Unique Tracking Number in the following format: AANNNN (two alphabetic characters followed by four numeric digits).'

		assert expectedErrorMsg.equalsIgnoreCase(actualErrorMsg)
	}
}