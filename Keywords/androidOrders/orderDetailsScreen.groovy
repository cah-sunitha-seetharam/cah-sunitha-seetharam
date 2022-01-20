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


class orderDetailsScreen {

	/**
	 * uploads the order 
	 */
	@Keyword
	def upload_Order() {

		Mobile.tap(findTestObject('Android/Orders/Order Details Screen/Upload Order/Upload Order_button'), 0)
	}

	/**
	 * opens confirmation pop up 
	 */
	@Keyword
	def continueOnDesktop() {
		Mobile.tap(findTestObject('Android/Orders/Order Details Screen/Upload Order/Continue On Desktop_button'), 0)
	}


	/**
	 * places the order 
	 */

	@Keyword
	def clickOnPlaceOrder() {
		Mobile.tap(findTestObject('Android/Orders/Order Details Screen/Place Order/Place Order_Button'), 0, )
	}

	/**
	 * verifies place order confirmation pop up
	 */
	@Keyword
	def verifyPlaceOrderPopUp() {
		Mobile.verifyElementExist(findTestObject('Android/Orders/Order Details Screen/Place Order/goBackAndReviewMyOrder_Button'), 0)
		Mobile.verifyElementExist(findTestObject('Android/Orders/Order Details Screen/Place Order/goToDashboard_Button'), 0)
		Mobile.verifyElementExist(findTestObject('Android/Orders/Order Details Screen/Place Order/placeMyOrder_Button'), 0)
	}

	/**
	 * confirms place order by clicking on place my order button
	 */
	@Keyword
	def confirmPlaceOrder() {
		Mobile.tap(findTestObject('Android/Orders/Order Details Screen/Place Order/placeMyOrder_Button'), 0)
	}

	/**
	 * takes user back to cart
	 */
	@Keyword
	def clickOnBackToCart() {

		Mobile.tap(findTestObject('Android/Orders/Order Details Screen/Upload Order/Back to Cart_button'), 0)
	}

	/**
	 * opens alternates page
	 * @param Alternates (alternates to be selected)
	 */
	@Keyword
	def tapOnAlternatesInProductDetailsPage(String Alternates) {
		Mobile.scrollToText(Alternates, FailureHandling.STOP_ON_FAILURE)
		Mobile.tap(findTestObject('Object Repository/Android/Orders/Product Info/Product Details/alternates_TextView',[('TEXT') : Alternates]), 0)
	}

	/**
	 * verifies filterByOptions
	 * @param Alternates (alternates to be selected)
	 */
	@Keyword
	def verifyFilterByOptions(String Alternates) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Android/Orders/Alternates Screen/alternateHeaderName_TextView',[('TEXT') : Alternates]), 0)
		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Orders/Alternates Screen/InStockFilterByOptions_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Orders/Alternates Screen/formFilterByOptions_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Orders/Alternates Screen/sizeFilterByOptions_TextView'), 0)
		int ElementTopPosition = Mobile.getElementTopPosition(findTestObject('Object Repository/Android/Orders/Alternates Screen/InStockFilterByOptions_TextView'), 0)
		int ElementHeight=Mobile.getElementHeight(findTestObject('Object Repository/Android/Orders/Alternates Screen/InStockFilterByOptions_TextView'), 0)
		int yCoordinateToSwipe=(ElementHeight/2)+ElementTopPosition
		Mobile.swipe(500, yCoordinateToSwipe, 0, yCoordinateToSwipe)
		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Orders/Alternates Screen/contract_FilterByOptions_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Orders/Alternates Screen/manufacturerFilterByOptions_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Orders/Alternates Screen/suggestedAlternate_TextView'), 0)
	}

	/**
	 * taps on scan icon and takes user to scanning product screen and also verifies ordering and price check
	 */
	@Keyword
	def clickOnScanIcon() {

		Mobile.tap(findTestObject('Android/Orders/Order Details Screen/Scan Order/scan_Icon'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/Order Details Screen/Scan Order/ordering_Text'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/Order Details Screen/Scan Order/priceCheck_Text'), 0)
	}
	
	/**
	 *  taps on scan icon and takes user to scanning product screen
	 */
	@Keyword
	def clickOnScanIconWithoutVerification() {
		Mobile.tap(findTestObject('Android/Orders/Order Details Screen/Scan Order/scan_Icon'), 0)
	}

	/**
	 * scans the product, adds it to the order and also verifies some scan input details
	 * @param productToBeSearched (name which can be a productName/Cin/NDC of the product to be added)
	 */
	@Keyword
	def scanInputEvent(String productToBeSearched) {

		Mobile.setText(findTestObject('Android/Orders/Order Details Screen/Scan Order/scan_EditText'), productToBeSearched, 0)
		Mobile.tap(findTestObject('Android/Orders/Order Details Screen/Scan Order/scan_Button'), 0)
		Mobile.verifyElementExist(findTestObject('Android/Orders/Order Details Screen/Scan Order/thisItemHasBeenAddedToYourOrder_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/Orders/Order Details Screen/Scan Order/remove_Button'), 0)
		Mobile.verifyElementExist(findTestObject('Android/Orders/Order Details Screen/Scan Order/alternates_Text'), 0)
	}

	/**
	 * scans the product while on price check, adds it to the order and also verifies some scan input details
	 * @param productToBeSearched (name which can be a productName/Cin/NDC of the product to be added)
	 */
	@Keyword
	def scanInputEventWhileOnPriceCheck(String productToBeSearched) {
		Mobile.setText(findTestObject('Android/Orders/Order Details Screen/Scan Order/scan_EditText'), productToBeSearched, 0)
		Mobile.tap(findTestObject('Android/Orders/Order Details Screen/Scan Order/scan_Button'), 0)
		Mobile.verifyElementExist(findTestObject('Android/Orders/Order Details Screen/Scan Order/alternates_Text'), 0)
		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Orders/Order Details Screen/Scan Order/addToOrder_Button'), 0)
	}


	/**
	 * this function adds the quantity for the product to be searched
	 * @param quantity (quantity required to be added for the product to be searched)
	 */

	@Keyword
	def addQuantityforTheSearchedProduct(int quantity) {

		int i
		for (i=1; i<= quantity; i++) {
			Mobile.tap(findTestObject('Android/Orders/Order Details Screen/Scan Order/moreOperator_ImageView'),  0)
		}
	}


	/**
	 * this function adds the quantity in product detail page
	 * @param quantity (quantity required to add in product detail page)
	 */
	@Keyword
	def addQuantityInProductDetailsPage(int quantity) {

		int i
		for (i=1; i<= quantity; i++) {
			Mobile.tap(findTestObject('Android/Orders/Product Info/Product Search/increaseCount_TextView'),  0)
		}
	}


	/**
	 * this function adds the quantity in alternates page
	 * @param quantity (quantity required to add in product detail page)
	 */
	@Keyword
	def addQuantityInAlternatesPage(int quantity) {

		int i
		for (i=1; i<= quantity; i++) {
			Mobile.tap(findTestObject('Object Repository/Android/Orders/Alternates Screen/pulsButton_ImageView'),  0)
		}
	}

	/**
	 * taps on alternate to order in alternates page and opens confirmation pop up
	 */
	@Keyword
	def tapOnAddAlternateToOrderInAlternatesPage() {
		Mobile.tap(findTestObject('Object Repository/Android/Orders/Alternates Screen/addAlternateToOrder_Button'),  0)
	}

	/**
	 * verifies confirmation pop up in alternates page 
	 */
	@Keyword
	def verifyConfirmationPopUpInALternatesPage() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Orders/Alternates Screen/itemAddedConfirmation_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Orders/Alternates Screen/continueBrowsing_Button'), 0)
		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Orders/Alternates Screen/goToOrder_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Orders/Alternates Screen/newOrderCreated_TextView'), 0)
	}

	/**
	 * verifies quantity updated caption
	 */
	@Keyword
	def verifyQuantityUpdatedCaption() {
		Mobile.verifyElementExist(findTestObject('Android/Orders/Order Details Screen/Verification Details/quantityUpdated_TextView'), 0)
	}

	/**
	 * verifies order name header label
	 * @param poName (poName is the order name)
	 */
	@Keyword
	def verifyOrderNameHeaderLabel(String poName){
		Mobile.verifyElementVisible(findTestObject('Android/Orders/Order Details Screen/Verification Details/orderNameHeader_TextView',[('TEXT'):poName]),0)
	}

	/**
	 * takes expected lines count as the argument and verifies the same
	 * @param expectedLineCount (expected total line count after adding product and return to the order name page)
	 */
	@Keyword
	def verifyLineCountOfOrderNamePage(String expectedLineCount){
		String lineCount=Mobile.getText(findTestObject('Android/Orders/Order Details Screen/Verification Details/lineCountOrderPage_TextView'), 0)
		String actualLineCount = (new androidCommonKeywords.commonMethods()).removeCharctersInString(lineCount)
		assert expectedLineCount == actualLineCount
	}

	/**
	 * this function gets the total added quantity of the product
	 * @return quantityNumericalValue (of the product which has been added)
	 */

	@Keyword
	def returnQuantityOfTheAddedProduct() {

		String quantity= Mobile.getText(findTestObject('Android/Orders/Order Details Screen/Scan Order/quantityTextField_EditText'), 0)

		KeywordUtil.logInfo(quantity)

		float quantityNumericalValue=Float.valueOf(quantity)

		return quantityNumericalValue
	}

	/**
	 * uploads the order by clicking on upload order button and verifies upload order button gets disabled after uploading
	 */
	@Keyword
	def uploadOrder() {

		Mobile.tapAndHold(findTestObject('Android/Orders/Order Details Screen/Upload Order/Upload Order_Button'), 0, 0)
	}

	/**
	 * uploads the c2 order 
	 */
	@Keyword
	def uploadOrderC2() {
		Mobile.tap(findTestObject('Android/Orders/C2 Order Details Screen/Upload C2 order/uploadOrder_Button'), 0)
	}

	/**
	 * takes user back to the search product results to continue browsing
	 */
	@Keyword
	def clickOnContinueOrderingOnDesktop() {

		Mobile.tap(findTestObject('Android/Orders/Order Details Screen/Upload Order/Continue order on the desktop_TextView'), 0)
	}

	/**
	 * verifies order has been sent to desktop pop up
	 */
	@Keyword
	def verifyOrderHasbeensentToDesktopPopUp() {
		Mobile.verifyElementExist(findTestObject('Android/Orders/Order Details Screen/Verification Details/orderHasbeenSentToDesktop_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/Orders/Order Details Screen/Upload Order/Back to Cart_Button'), 0)
		Mobile.verifyElementExist(findTestObject('Android/Orders/Order Details Screen/Upload Order/Go to Dashboard_Button'), 0)
	}

	/**
	 * verifies c2 order is not visible under non c2 order
	 */
	@Keyword
	def verifyC2OrderIsNotVisibleUnderNonC2Order() {
		Mobile.verifyElementNotVisible(findTestObject('Android/Orders/C2 Order Details Screen/Upload C2 order/c2label_TextView'), 0)
	}

	/**
	 * verifies c2 label is visible or not
	 */
	@Keyword
	def verifyC2Label() {

		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Orders/C2 Order Details Screen/Place C2 Order/C2_label'), 0)
	}

	/**
	 * creates a new C2 order
	 * @param poName (poName of the order), poMemo (poMemo of the order)
	 */
	@Keyword
	def createNewC2Order(String poName, String poMemo) {

		Mobile.verifyElementExist(findTestObject('Android/Orders/C2 Order Details Screen/Place C2 Order/thisIsAC2ItemCreateAC2OrderToAddItem_TextView'), 0, FailureHandling.STOP_ON_FAILURE)

		Mobile.tap(findTestObject('Android/Orders/C2 Order Details Screen/Place C2 Order/createANewOrder_TextView'), 0)

		Mobile.setText(findTestObject('Android/Orders/New Order Screen/P.O. Name (Optional)_TextField'), poName, 0)

		Mobile.setText(findTestObject('Android/Orders/New Order Screen/P.O. Memo (Optional)_TextField'), poMemo, 0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/C2 Order Details Screen/Place C2 Order/Cancel_Button'), 0, FailureHandling.STOP_ON_FAILURE)

		Mobile.tap(findTestObject('Android/Orders/C2 Order Details Screen/Place C2 Order/createNewOrder_Button'), 0)

		Mobile.tap(findTestObject('Android/Orders/C2 Order Details Screen/Place C2 Order/c2Order_RadioButton',[('TEXT'):poName]),0)

		Mobile.tap(findTestObject('Android/Orders/C2 Order Details Screen/Place C2 Order/addToOrder_Button'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/C2 Order Details Screen/Place C2 Order/cartTotal_TextView'), 0, FailureHandling.STOP_ON_FAILURE)

		Mobile.verifyElementExist(findTestObject('Android/Orders/C2 Order Details Screen/Place C2 Order/continueBrowsing_Button'), 0)

		Mobile.tap(findTestObject('Android/Orders/C2 Order Details Screen/Place C2 Order/goToOrder_TextView'), 0)
	}


	/**
	 * verifies confirmation pop up of c2 in scan search results
	 */
	@Keyword
	def verifyConfirmationPopUpOfC2InScanSearchResults() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Orders/Order Details Screen/Scan Order/C2 Order/thisIsAC2ItemWouldYouLikeToCreateANewOrderOrAddToExistingOrder_ConfirmationPopUp_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Orders/Order Details Screen/Scan Order/C2 Order/selectOrCreateANewOrder_Button'), 0)
		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Orders/Order Details Screen/Scan Order/C2 Order/cancel_TextView'), 0)
	}


	/**
	 * scans the product, adds it to the order 
	 * @param productToBeSearched (name which can be a productName/Cin/NDC of the product to be added)
	 */
	@Keyword
	def scanInputEventWithoutVerification(String productToBeSearched) {
		Mobile.setText(findTestObject('Android/Orders/Order Details Screen/Scan Order/scan_EditText'), productToBeSearched, 0)
		Mobile.tap(findTestObject('Android/Orders/Order Details Screen/Scan Order/scan_Button'), 0)
	}

	/**
	 * opens create new order page for c2
	 */
	@Keyword
	def tapOnSelectOrCrateANewOrderInScanSearchResults() {
		Mobile.tap(findTestObject('Object Repository/Android/Orders/Order Details Screen/Scan Order/C2 Order/selectOrCreateANewOrder_Button'), 0)
	}

	/**
	 * creates a new C2 order
	 * @param poName (poName of the order), poMemo (poMemo of the order)
	 */

	@Keyword
	def createNewOrderForC2(String poName, String poMemo){
		Mobile.verifyElementExist(findTestObject('Android/Orders/C2 Order Details Screen/Place C2 Order/thisIsAC2ItemCreateAC2OrderToAddItem_TextView'), 0)
		Mobile.tap(findTestObject('Android/Orders/C2 Order Details Screen/Place C2 Order/createANewOrder_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/Orders/C2 Order Details Screen/Place C2 Order/Cancel_Button'), 0)
		Mobile.setText(findTestObject('Android/Orders/New Order Screen/P.O. Name (Optional)_TextField'), poName, 0)
		Mobile.setText(findTestObject('Android/Orders/New Order Screen/P.O. Memo (Optional)_TextField'), poMemo, 0)
		Mobile.tap(findTestObject('Android/Orders/C2 Order Details Screen/Place C2 Order/createNewOrder_Button'), 0)
	}



	@Keyword
	def createNewOrderForC2WithoutVerification(String poName, String poMemo) {
		Mobile.tap(findTestObject('Android/Orders/C2 Order Details Screen/Place C2 Order/createANewOrder_TextView'), 0)
		Mobile.setText(findTestObject('Android/Orders/New Order Screen/P.O. Name (Optional)_TextField'), poName, 0)
		Mobile.setText(findTestObject('Android/Orders/New Order Screen/P.O. Memo (Optional)_TextField'), poMemo, 0)
		Mobile.tap(findTestObject('Android/Orders/C2 Order Details Screen/Place C2 Order/createNewOrder_Button'), 0)
	}


	/**
	 * enables radio button and adds c2 product
	 * @param poName (poName of the order)
	 */
	@Keyword
	def enableRadioButtonForNewOrderC2Creation(String poName){
		Mobile.tap(findTestObject('Android/Orders/C2 Order Details Screen/Place C2 Order/c2Order_RadioButton',[('TEXT'):poName]),0)
		Mobile.tap(findTestObject('Android/Orders/C2 Order Details Screen/Place C2 Order/addToOrder_Button'), 0)
	}

	/**
	 * verifies confirmation pop up after adding c2 order 
	 */
	@Keyword
	def verifyConfirmationPopUpAfterAddingC2Order(){
		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Orders/C2 Order Details Screen/Place C2 Order/continueBrowsing_Button'), 0)
		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Orders/C2 Order Details Screen/Place C2 Order/goToOrder_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/Orders/C2 Order Details Screen/Upload C2 order/itemAddedToPoname_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/Orders/C2 Order Details Screen/Upload C2 order/CIN_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/Orders/C2 Order Details Screen/Upload C2 order/orderName_TextView'), 0)
	}


	/**
	 * this function selects toggle value for the product to be added which can be ordering or price check)
	 * @param toggleValue (toggleValue required to be selected for the product to be added which can be ordering or price check)
	 */
	@Keyword
	def selectToggleValueForTheProductToBeSearched(String toggleValue) {

		if(toggleValue=="Ordering") {
			Mobile.tap(findTestObject('Object Repository/Android/Orders/Order Details Screen/Scan Order/ordering_Text'), 0)
		}
		else {
			Mobile.tap(findTestObject('Object Repository/Android/Orders/Order Details Screen/Scan Order/priceCheck_Text'), 0)
		}
	}

	/**
	 * verifies the order value after adding a product
	 * @param quantity (quantity which was added)
	 */
	@Keyword
	def verifyOrderValue(quantity) {
		String productCost=Mobile.getText(findTestObject('Android/Orders/Verification Details/productCost_TextView'), 0)
		String removeCharctersInProductCost = (new androidCommonKeywords.commonMethods()).removeCharctersInString(productCost)
		float productCostFloatValue = (new androidCommonKeywords.commonMethods()).stringToFloatConversion(removeCharctersInProductCost)
		float totalCost=quantity*productCostFloatValue
		String expectedOrderTotal = (new androidCommonKeywords.commonMethods()).floatToStringConversionAndFormatting(totalCost)
		String OrderTotal = Mobile.getText(findTestObject('Android/Orders/Verification Details/orderTotalCost_TextView'), 0)
		String actualOrderTotal = (new androidCommonKeywords.commonMethods()).removeCharctersInString(OrderTotal)
		assert expectedOrderTotal == actualOrderTotal
	}

	/**
	 * this function returns the order value
	 * @return actualOrderTotal(order total value)
	 */
	@Keyword
	def returnOrderValue() {
		String orderTotal=Mobile.getText(findTestObject('Android/Orders/Verification Details/orderTotalCost_TextView'), 0)
		String actualOrderTotal = (new androidCommonKeywords.commonMethods()).removeCharctersInString(orderTotal)
		return actualOrderTotal
	}

	/**
	 * this function returns the cost of added product
	 * @return productCost (of the product which has been added)
	 */
	@Keyword
	def returnCostOfTheAddedProduct() {
		String testObj='Object Repository/Android/Orders/Verification Details/productCost_TextView'
		String productCost=(new androidCommonKeywords.commonMethods()).returnCostOfTheAddedProduct(testObj)//calling common method to get product cost
		KeywordUtil.logInfo(productCost)
		return productCost
	}

	/**
	 * this function returns the order name in search page
	 */
	@Keyword
	def returnProductNameAfterSearch(){
		String orderNameInSearchPage=Mobile.getText(findTestObject('Object Repository/Android/Product Details/product_description_label'), 0)
		return orderNameInSearchPage
	}

	/**
	 * this function returns the top most product name in order details page
	 */
	@Keyword
	def returnTopMostProductNameInOrderDetails(){
		String productName=Mobile.getText(findTestObject('Object Repository/Android/Orders/Order Details Screen/Verification Details/productName_TextView'), 0)
		return productName
	}

	/**
	 * verifies that the added top most product should  be visible on the order details page
	 * @param productname (top most added product name)
	 */
	@Keyword
	def verifyProductNameIsVisibleUnderOrderDetails(String productname) {

		Mobile.verifyElementVisible(findTestObject('Object Repository/Android/Orders/Order Details Screen/Verification Details/productName_TextView',[('TEXT'):productname]),0)
	}

	/**
	 * taps on add to order and shows confirmation pop up
	 */
	@Keyword
	def tapOnAddToOrderInScanSearchResults () {
		Mobile.tap(findTestObject('Object Repository/Android/Orders/Order Details Screen/Scan Order/addToOrder_Button'), 0)
	}

	/**
	 * after selecting add to order verifies item added confirmation popup in scan search results 
	 */
	@Keyword
	def verifyConfirmationPopUpInScanSearchResults() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Orders/Order Details Screen/Scan Order/itemAddedConfirmationPopUp_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Orders/Order Details Screen/Scan Order/CIN-ConfirmationPopUp_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Orders/Order Details Screen/Scan Order/goToOrder_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Orders/Order Details Screen/Scan Order/continueBrowsing_Button'), 0)
		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Orders/Order Details Screen/Scan Order/productNameConfirmationPopUp_TextView'), 0)
	}


	/**
	 * this function verifies the product details page
	 */

	@Keyword
	def verifyProductDetailAfterSelectingMoreDetails(String orderNameInSearchPage){
		String orderNameInProductDetailsPage=Mobile.getText(findTestObject('Android/Orders/Product Info/Product Details/orderName_TextView'), 0)
		assert orderNameInSearchPage== orderNameInProductDetailsPage
		Mobile.verifyElementExist(findTestObject('Android/Orders/C2 Order Details Screen/Upload C2 order/c2label_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/Orders/Product Info/Product Details/productSize_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/Orders/Product Info/Product Details/NDC_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/Orders/Product Info/Product Details/UOI_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/Orders/Product Info/Product Details/stockStatus_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/Orders/Product Info/Product Details/returnableStatus_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/Orders/Product Info/Product Details/quantityTextField_EditText'), 0)
		Mobile.verifyElementExist(findTestObject('Android/Orders/Product Info/Product Details/increaseCount_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/Orders/Product Info/Product Details/strength_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/Orders/Product Info/Product Details/form_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/Orders/Product Info/Product Details/UPC_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/Orders/Product Info/Product Details/CIN_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/Orders/Product Info/Product Details/contractAlias_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/Orders/Product Info/Product Details/retailPrice_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/Orders/Product Info/Product Details/CIN_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/Orders/Product Info/Product Details/date_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/Orders/Product Info/Product Search/addToOrder_Button'), 0)
	}

	/**
	 * this function verifies that the product is visible on the order details screen
	 * @param productNdcNumber (using NDC of the product which is visible on the product tab)
	 * if in future upc/cin are visible then the method can be modified accordingly by passing the respective test object
	 */
	@Keyword
	def verifyProductIsVisibleOnTheOrderDetailsScreen(productNdcNumber) {
		String testObj='Object Repository/Android/Orders/Verification Details/ordersNDCLabel_TextView'
		(new androidCommonKeywords.commonMethods()).verifyProductIsVisibleOnTheScreen(testObj,productNdcNumber)//calling verifyProductIsVisibleOnTheScreen function and passing testObj, topProductIdentificationNumber as the arguments

	}


	/**
	 * this function verifies the product after search
	 */
	@Keyword
	def verifyProductAfterSearch() {
		Mobile.verifyElementExist(findTestObject('Android/Orders/Product Info/Product Search/NDC_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Product Details/product_description_label'), 0)
		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Product Details/UOI Cost_Text'), 0)
		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Product Search/Quantity_TextField'), 0)
		Mobile.verifyElementExist(findTestObject('Android/Orders/Product Info/Product Search/manufacturer__TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/Orders/Product Info/Product Search/alternates_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/Orders/Product Info/Product Search/addToOrder_Button'), 0)
	}

	/**
	 * this function verifies the product tile
	 */
	@Keyword
	def verifyProductTile() {
		Mobile.verifyElementExist(findTestObject('Android/Orders/Product Info/Product Search/CIN_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/Orders/Product Info/Product Search/UPC__TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/Orders/Product Info/Product Search/retailPrice__TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/Orders/Product Info/Product Search/moreDetails__TextView'), 0)
	}
	/**
	 * clicks on c2 order availability and waits for the response while verifying the availability details for the c2 product
	 */
	@Keyword()
	def checkC2ProductAvailability() {

		Mobile.tap(findTestObject('Android/Orders/C2 Order Details Screen/Place C2 Order/checkAvailability_Button'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/C2 Order Details Screen/Place C2 Order/oneMoment_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/C2 Order Details Screen/Place C2 Order/weNeedJustAMinuteToEnsureThatWeHaveEverythingInStock_TextView'), 0)

		String testObject='Android/Orders/C2 Order Details Screen/Place C2 Order/OneMomentProgressBar'
		(new androidCommonKeywords.commonMethods()).waitTimeForObjectToBeVisible(testObject,1,20)
	}



	/**
	 * searches for a product by setting product name and quantity as the input
	 * @param productName (product to be added), quantity (total quantity required to be added)
	 */
	@Keyword
	def addProductToOrder(String productName, String quantity) {

		Mobile.tap(findTestObject('Android/Product Search/Search Products_SearchView'), 0)

		Mobile.setText(findTestObject('Android/Product Search/Search Products_SearchView'), productName + '\\n',0)

		(new androidCommonKeywords.commonMethods()).waitForProgressBarToBeInvisible()

		Mobile.setText(findTestObject('Android/Product Search/Quantity_TextField'), quantity, 0)

		Mobile.tap(findTestObject('Android/Product Search/Add to Order_Button'),0)
	}

	/**
	 * searches for a product by setting product name 
	 * @param productName (product to be added)
	 */
	@Keyword
	def searchProductInOrderDetailPage(String productName) {
		Mobile.tap(findTestObject('Android/Product Search/Search Products_SearchView'), 0)
		Mobile.setText(findTestObject('Android/Product Search/Search Products_SearchView'), productName + '\\n',0)
	}

	/**
	 * opens product tile
	 */
	@Keyword
	def clickOnProductTile() {
		Mobile.tap(findTestObject('Android/Orders/Product Info/Product Search/NDC_TextView'), 0)
	}

	/**
	 * opens more details of product details
	 */
	@Keyword
	def clickOnMoreDetails() {
		Mobile.tap(findTestObject('Android/Orders/Product Info/Product Search/moreDetails__TextView'), 0)
	}

	/**
	 * removes product from orders details
	 */
	@Keyword
	def removeProduct() {
		Mobile.tap(findTestObject('Object Repository/Android/Orders/Order Details Screen/Verification Details/Remove Product_TextView'), 0)
	}

	/**
	 * adds product in product details page
	 */
	@Keyword
	def tapOnAddToOrderInProductDetailsPage() {
		Mobile.tap(findTestObject('Android/Orders/Product Info/Product Search/addToOrder_Button'), 0)
	}

	/**
	 * takes user back to the search product results to continue ordering
	 */
	@Keyword
	def clickOnContinueOrdering() {

		Mobile.tap(findTestObject('Android/Product Search/Continue Ordering_Button') ,0)
	}

	/**
	 * takes user back to the search product results to continue browsing
	 */
	@Keyword
	def tapOnContinueBrowsing() {

		Mobile.tap(findTestObject('Object Repository/Android/Orders/C2 Order Details Screen/Place C2 Order/continueBrowsing_Button') ,0)
	}

	/**
	 * takes user to the order details
	 */
	@Keyword
	def tapOnGoToOrder() {
		Mobile.tap(findTestObject('Object Repository/Android/Orders/Alternates Screen/goToOrder_TextView') ,0)
	}

	@Keyword
	def edit_PO_Name_and_Memo(String PO_Name,String PO_Memo, String New_po_Name, String New_po_Memo ) {

		Mobile.scrollToText('Edit')

		Mobile.tap(findTestObject('Android/Orders/Order Details Screen/Edit PO Name and Memo/Edit P.O. Name and memo_TextView'), 0)

		Mobile.clearText(findTestObject('Android/Orders/Order Details Screen/Edit PO Name and Memo/po name_to_be_edited_TextField', [('po_name') : PO_Name]), 0)

		Mobile.setText(findTestObject('Android/Orders/New Order Screen/P.O. Name (Optional)_TextField'), New_po_Name, 0)

		Mobile.clearText(findTestObject('Android/Orders/Order Details Screen/Edit PO Name and Memo/po memo_to_be_edited_TextField', [('po_memo') : PO_Memo]), 0)

		Mobile.setText(findTestObject('Android/Orders/New Order Screen/P.O. Memo (Optional)_TextField'), New_po_Memo,	0)

		Mobile.tap(findTestObject('Android/Orders/Order Details Screen/Edit PO Name and Memo/Update Order_Button'), 0)
	}




	@Keyword()
	def add_ALternate_Product(String Product_Name,String Quantity) {
		int w = 1

		while (Mobile.verifyElementExist(findTestObject('Android/Login/Login Details Screen/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}

		Mobile.tap(findTestObject('Android/Product Search/Search Products_SearchView'), 0)

		Mobile.setText(findTestObject('Android/Product Search/Search Products_SearchView'), Product_Name + '\\n',0)

		while (Mobile.verifyElementExist(findTestObject('Android/Login/Login Details Screen/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}

		Mobile.setText(findTestObject('Android/Product Search/Quantity_TextField'), Quantity, 0)

		while (Mobile.verifyElementExist(findTestObject('Android/Login/Login Details Screen/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}

		Mobile.tap(findTestObject('Android/Product Search/Alternates_List'), 0)

		Mobile.tap(findTestObject('Android/Product Search/Add Alternate to Order_Button'), 0)

		Mobile.tap(findTestObject('Android/Product Search/Continue Ordering_Button'),0)
	}


	/**
	 * verifies order screen details without any added product
	 */
	@Keyword
	def verifyOrderScreenDetailsWithoutAnyAddedProduct() {
		Mobile.verifyElementExist(findTestObject('Android/Orders/Order Details Screen/Verification Details/Nothing to see here_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/Orders/Order Details Screen/Verification Details/Search products and add them to this order_TextView'),  0)
		Mobile.verifyElementExist(findTestObject('Android/Orders/Order Details Screen/Verification Details/0 lines in this order_TextView'),  0)
		Mobile.verifyElementExist(findTestObject('Android/Orders/Order Details Screen/Verification Details/Order_Name_Header'), 0)
		Mobile.verifyElementExist(findTestObject('Android/Orders/Order Details Screen/Verification Details/Scan_Icon'),0)
		Mobile.verifyElementAttributeValue(findTestObject('Android/Orders/Order Details Screen/Upload Order/Upload Order_Button'), 'enabled', 'false', 0)
		Mobile.verifyElementAttributeValue(findTestObject('Android/Orders/Order Details Screen/Place Order/Place Order_Button'), 'enabled', 'false', 0)
	}

	/**
	 * verifies order screen details with added product
	 */
	@Keyword
	def verifyOrderScreenDetailsWithAddedProduct() {

		Mobile.verifyElementExist(findTestObject('Android/Orders/Cart Screen/Verifictaion Details/Lines_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/Order Details Screen/Verification Details/Order Total_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/Order Details Screen/Verification Details/Order_Name_Header'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/Order Details Screen/Verification Details/Remove Product_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Product Details/NDC_label'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Product Details/UOI Cost_Text'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Product Details/AMU_Text'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Product Details/Manufacturer_Text'),  0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/Order Details Screen/Verification Details/Scan_Icon'),0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/Order Details Screen/Edit PO Name and Memo/Edit P.O. Name and memo_TextView'),	0)
	}

	/**
	 * verifies the pop up which appears after user clicks on upload order
	 */
	@Keyword
	def verifyUploadOrderPopUp() {
		Mobile.verifyElementExist(findTestObject('Android/Orders/Order Details Screen/Upload Order/Continue order on the desktop_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/Orders/Order Details Screen/Upload Order/Continue On Desktop_Button'), 0)
		Mobile.verifyElementExist(findTestObject('Android/Orders/Order Details Screen/Upload Order/Cancel and keep order on the app_Button'), 0)
	}

	/**
	 * this function returns the order name of the order/ title of the screen when user is on order details screen
	 * return orderName (returns order name/ title of order details screen)
	 */
	@Keyword
	def returnOrderNameFromOrderDetailScreen() {

		String orderName=Mobile.getText(findTestObject('android/Orders/Verification Details/orderDetailHeader_Label'), 0)

		return orderName
	}

	/**
	 * takes user back to history screen and verifies user is on the history screen or not
	 */
	@Keyword
	def clickOnReviewAndSignButton() {

		Mobile.tap(findTestObject('Android/Orders/C2 Order Details Screen/Place C2 Order/reviewAndSign_Button'), 0)

		(new androidCommonKeywords.commonMethods()).waitForProgressBarToBeInvisible()

		Mobile.verifyElementExist(findTestObject('Android/Orders/History Screen/Order History_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/History Screen/Order History_HeaderText'),  0)
	}

	/**
	 * Its check UTN number validation
	 */
	@Keyword
	def utnNumberValidation(int utnPrefixLength, String expectedErrorMsg, String input1, String input2) {

		Mobile.verifyElementExist(findTestObject('Android/Orders/C2 Order Details Screen/UTN Verification/POnumberTitle'), 0)
		Mobile.verifyElementExist(findTestObject('Android/Orders/C2 Order Details Screen/UTN Verification/UTNtextbox'), 0)

		// Clear text -  Last 6 characters should be deleted.
		Mobile.clearText(findTestObject('Android/Orders/C2 Order Details Screen/UTN Verification/UTNtextbox'), 0)

		// Check User should not able to remove the first  3 characters in the UTN field
		String utnNumber=Mobile.getText(findTestObject('Android/Orders/C2 Order Details Screen/UTN Verification/UTNtextbox'), 0)
		assert utnPrefixLength == (utnNumber.length())

		// Verify validation error message and error icon
		Mobile.verifyElementExist(findTestObject('Android/Orders/C2 Order Details Screen/UTN Verification/UTNerrorIcon'), 0)
		Mobile.verifyElementExist(findTestObject('Android/Orders/C2 Order Details Screen/UTN Verification/UTNerrorMessage'), 0)
		String actualErrorMsg=Mobile.getText(findTestObject('Android/Orders/C2 Order Details Screen/UTN Verification/UTNerrorMessage'), 0)
		assert expectedErrorMsg == actualErrorMsg

		// Enter 6 zeros in the UTN field (Example: 21X000000)
		Mobile.setText(findTestObject('Android/Orders/C2 Order Details Screen/UTN Verification/UTNtextbox'), input1, 0)
		Mobile.verifyElementExist(findTestObject('Android/Orders/C2 Order Details Screen/UTN Verification/UTNerrorIcon'), 0)
		Mobile.verifyElementExist(findTestObject('Android/Orders/C2 Order Details Screen/UTN Verification/UTNerrorMessage'), 0)
		Mobile.clearText(findTestObject('Android/Orders/C2 Order Details Screen/UTN Verification/UTNtextbox'), 0)

		// Enter special character in the UTN field (Example: 21X00000*)
		Mobile.setText(findTestObject('Android/Orders/C2 Order Details Screen/UTN Verification/UTNtextbox'), input2, 0)
		Mobile.verifyElementExist(findTestObject('Android/Orders/C2 Order Details Screen/UTN Verification/UTNerrorIcon'), 0)
		Mobile.verifyElementExist(findTestObject('Android/Orders/C2 Order Details Screen/UTN Verification/UTNerrorMessage'), 0)
	}


	/**
	 * Its check Duplicate utn number
	 */
	@Keyword
	def enterDuplicateUTN(String existingUTNno, String duplicateErrorMsg) {

		Mobile.setText(findTestObject('Android/Orders/C2 Order Details Screen/UTN Verification/UTNtextbox'), existingUTNno, 0)
		Mobile.tap(findTestObject('Android/Orders/C2 Order Details Screen/Place C2 Order/checkAvailability_Button'), 0)
		WebUI.delay(10)

		String actualErrorMsg = Mobile.getText(findTestObject('Android/Orders/C2 Order Details Screen/UTN Verification/duplicateUTN_message'), 0)
		assert duplicateErrorMsg == actualErrorMsg

		Mobile.verifyElementExist(findTestObject('Android/Orders/C2 Order Details Screen/UTN Verification/DuplicateUTNerror_icon'), 0)
		Mobile.verifyElementExist(findTestObject('Android/Orders/C2 Order Details Screen/UTN Verification/DuplicateUTNNumber_error'), 0)
		Mobile.verifyElementExist(findTestObject('Android/Orders/C2 Order Details Screen/UTN Verification/ReEnterUTN_Button'), 0)
		Mobile.verifyElementExist(findTestObject('Android/Orders/C2 Order Details Screen/UTN Verification/SaveforLater_Button'), 0)
	}

	/**
	 * Its save for later
	 */
	@Keyword
	def saveForLater() {

		Mobile.verifyElementExist(findTestObject('Android/Orders/C2 Order Details Screen/UTN Verification/SaveforLater_Button'), 0)
		Mobile.tap(findTestObject('Android/Orders/C2 Order Details Screen/UTN Verification/SaveforLater_Button'), 0)
	}
	
	/**
	 * this function returns the order name of the order/ title of the screen when user is on order details screen
	 * return orderName (returns order name/ title of order details screen)
	 */
	@Keyword
	def returnNDCLabelOfScannedProduct() {

		String NDCLabel = Mobile.getText(findTestObject('Android/Orders/Verification Details/ndcTextView'), 0)
		return NDCLabel
	}	
}