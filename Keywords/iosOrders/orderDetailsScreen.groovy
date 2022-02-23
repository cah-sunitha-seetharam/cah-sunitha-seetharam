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
import io.appium.java_client.MobileElement
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
import java.math.RoundingMode;


class orderDetailsScreen {

	def commonMethodsObject=new commonMethods();
	def commonIosMethodsObject=new iosCommonKeywords.commonMethods();


	/**
	 * searches for a product by setting product name and quantity as the input
	 * @param productName (product to be added), quantity (total quantity required to be added)
	 */
	@Keyword
	def addAlternateProduct(String productName, String quantity) {

		commonIosMethodsObject.waitForProgressBarToBeInvisible()

		Mobile.tapAndHold(findTestObject('iOS/inventory/Location Details_Screen/Add Product to Location/Product SearchField'), 0, 0)

		commonIosMethodsObject.waitForProgressBarToBeInvisible()

		Mobile.setText(findTestObject('iOS/productSearch/globalSearch/productSearch_TextField'), productName, 0)

		Mobile.tapAndHold(findTestObject('iOS/productSearch/Search Key_Button'), 0, 0)

		Mobile.tap(findTestObject('iOS/productSearch/globalSearch/alternateProducts_Text'), 0)

		commonIosMethodsObject.waitForProgressBarToBeInvisible()

		Mobile.setText(findTestObject('iOS/productSearch/Quantity_TextField'), quantity, 0)

		commonIosMethodsObject.waitForProgressBarToBeInvisible()

		Mobile.tap(findTestObject('iOS/orders/cartScreen/placeAllOrders/done_Keypad'), 0)

		Mobile.tap(findTestObject('iOS/productSearch/globalSearch/addAlternateToOrder_Button'), 0)

		Mobile.tap(findTestObject('iOS/productSearch/globalSearch/continueBrowsing_Button'), 0)
	}



	/**
	 * searches for a product by setting product name and quantity as the input
	 * @param productName (product to be added), quantity (total quantity required to be added)
	 */
	@Keyword
	def addProductToOrder(String productName, String quantity) {

		Mobile.tapAndHold(findTestObject('iOS/inventory/locationDetailsScreen/addProductToLocation/productSearch_TextField'), 0, 0)

		commonIosMethodsObject.waitForProgressBarToBeInvisible()

		Mobile.setText(findTestObject('iOS/productSearch/globalSearch/productSearch_TextField'), productName, 0)

		Mobile.tapAndHold(findTestObject('iOS/productSearch/globalSearch/search_Keypad'), 0, 0)

		Mobile.setText(findTestObject('iOS/productSearch/globalSearch/quantity_TextField'), quantity, 0)

		commonIosMethodsObject.waitForProgressBarToBeInvisible()

		Mobile.tap(findTestObject('iOS/orders/cartScreen/placeAllOrders/done_Keypad'), 0)

		Mobile.tap(findTestObject('iOS/inventory/inventoryDetailsScreen/addProductToInventoryUsingSearchFromInventoryDetailsScreen/addToOrder_Text'), 0)

		Mobile.tap(findTestObject('iOS/productSearch/globalSearch/continueOrdering_Button'), 0)
	}




	/**
	 * this function adds the quantity for the product to be searched
	 * @param quantity (quantity required to be added for the product to be searched)
	 */
	@Keyword
	def addQuantityforTheSearchedProduct(String quantity) {

		Mobile.setText(findTestObject('iOS/productSearch/scanFlow/quantity_TextField'), quantity, 0)

		Mobile.tap(findTestObject('iOS/productSearch/scanFlow/done_Button'), 0)
	}

	/**
	 * this function adds the quantity in alternates page
	 * @param quantity (quantity required to add in product detail page)
	 */
	@Keyword
	def addQuantityInAlternatesPage(String quantity) {
		Mobile.setText(findTestObject('iOS/orders/alternatesScreen/quantity_TextField'), quantity, 0)
		Mobile.tap(findTestObject('iOS/productSearch/scanFlow/done_Button'), 0)
	}

	/**
	 * this function adds the quantity in product detail page
	 * @param quantity (quantity required to add in product detail page)
	 */
	@Keyword
	def addQuantityInProductDetailsPage(String quantity) {
		Mobile.setText(findTestObject('iOS/orders/productInfo/productDetails/quantity_TextField'), quantity, 0)
		Mobile.tap(findTestObject('iOS/orders/productInfo/productDetails/quantity_TextField'), 0)
	}

	/**
	 * this function adds the product to be ordered - when price check toggle is selected
	 * @param quantity (quantity required to be added for the product to be searched)
	 */
	@Keyword
	def addToOrder() {

		Mobile.tap(findTestObject('iOS/inventory/inventoryDetailsScreen/addProductToInventoryUsingSearchFromInventoryDetailsScreen/addToOrder_Text'), 0)

		(new iosCommonKeywords.commonMethods()).waitForProgressBarToBeInvisible()

		Mobile.verifyElementExist(findTestObject('iOS/orders/orderDetailsScreen/priceCheckToggleScreen/newOrderCreated_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/orders/orderDetailsScreen/priceCheckToggleScreen/goToOrder_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/orders/orderDetailsScreen/priceCheckToggleScreen/continueBrowsing_Text'), 0)
	}

	/**
	 * adds product 
	 */
	@Keyword
	def addToOrderWithoutVerify() {
		Mobile.tap(findTestObject('iOS/inventory/inventoryDetailsScreen/addProductToInventoryUsingSearchFromInventoryDetailsScreen/addToOrder_Text'), 0)
	}

	/**
	 * clicks on c2 order availability and waits for the response while verifying the availability details for the c2 product
	 */
	@Keyword
	def checkC2OrderAvailability() {

		Mobile.tap(findTestObject('iOS/orders/c2OrderDetailsScreen/placeC2Order/checkAvailabilityNew_Button'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/orders/c2OrderDetailsScreen/placeC2Order/oneMoment_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/orders/c2OrderDetailsScreen/placeC2Order/weNeedJustAMinuteToEnsureThatWeHaveEverythingInStock_Texr'),0)

		WebUI.delay(15)

		Mobile.verifyElementExist(findTestObject('iOS/orders/c2OrderDetailsScreen/placeC2Order/yourC2OrderIsReadyToSign_Text'),0)

		Mobile.verifyElementExist(findTestObject('iOS/orders/c2OrderDetailsScreen/placeC2Order/pleaseReviewAndSignYourOrder_Text'),0)

		Mobile.verifyElementExist(findTestObject('iOS/orders/c2OrderDetailsScreen/placeC2Order/reviewAndSign_Button'),0)
	}

	/**
	 * takes user back to cart screen and verifies user is on the cart screen or not
	 */
	@Keyword
	def clickOnBackToCart() {

		Mobile.tap(findTestObject('iOS/productSearch/globalSearch/backToCart_Text'), 0)

		Mobile.verifyElementAttributeValue(findTestObject('iOS/dashboard/tabs/orders_Tab'), 'value', '1',0)

		Mobile.verifyElementExist(findTestObject('iOS/orders/verificationDetails/cartHeader_Label'),0)
	}


	/**
	 * taps on continue browsing button on order confirmation screen and takes user to scan result screen
	 */
	@Keyword
	def clickOnContinueBrowsing() {

		Mobile.verifyElementExist(findTestObject('iOS/orders/orderDetailsScreen/priceCheckToggleScreen/continueBrowsing_Button'), 0)

		Mobile.tap(findTestObject('iOS/orders/orderDetailsScreen/priceCheckToggleScreen/continueBrowsing_Button'), 0)
	}

	/**
	 * taps on continue ordering button on order details screen after user has added a product to order
	 * and takes user to scan result screen
	 */
	@Keyword
	def clickOnContinueOrdering() {

		Mobile.verifyElementExist(findTestObject('iOS/orders/orderDetailsScreen/createC2Order/continueOrdering_Button'), 0)

		Mobile.tap(findTestObject('iOS/orders/orderDetailsScreen/createC2Order/continueOrdering_Button'), 0)
	}

	/**
	 * takes user back to the search product results to continue browsing
	 */
	@Keyword
	def clickOnContinueOrderingOnDesktop() {

		Mobile.tap(findTestObject('iOS/orders/orderDetailsScreen/uploadOrder/continueOnDesktop_Button'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/orders/orderDetailsScreen/verificationDetails/yourOrder(s)HasBeenSentToDesktop_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/productSearch/globalSearch/backToCart_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/orders/orderDetailsScreen/uploadOrder/goToDashboard_Button'), 0)
	}

	/**
	 * taps on go to order button on order confirmation screen and takes user to order details screen
	 */
	@Keyword
	def clickOnGoToOrder() {

		Mobile.verifyElementExist(findTestObject('iOS/orders/orderDetailsScreen/priceCheckToggleScreen/goToOrder_Button'), 0)

		Mobile.tap(findTestObject('iOS/orders/orderDetailsScreen/priceCheckToggleScreen/goToOrder_Button'), 0)
	}

	/**
	 * opens more details of product details
	 */
	@Keyword
	def clickOnMoreDetails() {
		Mobile.tap(findTestObject('iOS/orders/productInfo/productSearch/moreDetailsView_Text'), 0)
	}

	/**
	 * places the order
	 */

	@Keyword
	def clickOnPlaceOrder() {
		Mobile.tap(findTestObject('iOS/orders/orderDetailsScreen/placeOrder/placeOrder_Button'), 0)
	}

	/**
	 * opens product tile
	 */
	@Keyword
	def clickOnProductTile() {
		Mobile.tap(findTestObject('iOS/orders/productInfo/productSearch/NDC_Text'), 0)
	}

	/**
	 * takes user back to history screen and verifies user is on the history screen or not
	 */
	@Keyword
	def clickOnReviewAndSignButton() {

		Mobile.tap(findTestObject('iOS/orders/c2OrderDetailsScreen/placeC2Order/reviewAndSign_Button'), 0)

		(new iosCommonKeywords.commonMethods()).waitForProgressBarToBeInvisible()

		Mobile.verifyElementExist(findTestObject('iOS/orders/historyScreen/orderHistory_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/orders/historyScreen/historyScreen_Header'),  0)

		Mobile.verifyElementExist(findTestObject('iOS/orders/historyScreen/scan_Icon'),0)
	}


	/**
	 * taps on scan icon and takes user to scanning product screen and also verifies that the default toggle is at ordering
	 */
	@Keyword
	def clickOnScanIcon() {

		Mobile.tap(findTestObject('iOS/productSearch/scanFlow/scan_Icon'), 0)

		Mobile.verifyElementAttributeValue(findTestObject('iOS/productSearch/scanFlow/ordering_Button'), 'value', '1', 0)

		Mobile.verifyElementExist(findTestObject('iOS/productSearch/scanFlow/priceCheck_Button'), 0)
	}

	/**
	 *  taps on scan icon and takes user to scanning product screen 
	 */
	@Keyword
	def clickOnScanIconWithoutVerification() {
		Mobile.tap(findTestObject('iOS/productSearch/scanFlow/scan_Icon'), 0)
	}

	/**
	 * closes the popup when user switches to offline mode
	 */
	@Keyword
	def closeOfflinePopUp() {
		Mobile.tap(findTestObject('iOS/verification/boltTextOfflineMode_Text'), 0)
	}

	/**
	 * confirms place order by clicking on place my order button
	 */
	@Keyword
	def confirmPlaceOrder() {
		Mobile.tap(findTestObject('iOS/orders/cartScreen/placeAllOrders/placeMyOrder(s)_Text'), 0)
	}

	/**
	 * creates a new C2 order 
	 * @param poName (poName of the order), poMemo (poMemo of the order)
	 */
	@Keyword
	def createNewC2Order(String poName, String poMemo) {

		//	Mobile.verifyElementExist(findTestObject('iOS/orders/orderDetailsScreen/createC2Order/thisIsAC2ItemSelectOrCreateAC2OrderToAddItem_Text'), 0)

		Mobile.tap(findTestObject('iOS/orders/orderDetailsScreen/createC2Order/createANewOrder_Text'), 0)

		Mobile.tapAndHold(findTestObject('iOS/orders/orderDetailsScreen/createC2Order/poName_TextField'), 0, 0)

		Mobile.setText(findTestObject('iOS/orders/orderDetailsScreen/createC2Order/setText_TextField'), poName, 0)

		Mobile.tap(findTestObject('iOS/productSearch/globalSearch/returnKeypad_Button'), 0)

		Mobile.tapAndHold(findTestObject('iOS/orders/orderDetailsScreen/createC2Order/poMemo_TextField'), 0, 0)

		Mobile.setText(findTestObject('iOS/orders/orderDetailsScreen/createC2Order/setText_TextField'),poMemo, 0)

		Mobile.tap(findTestObject('iOS/productSearch/globalSearch/returnKeypad_Button'), 0)

		Mobile.tap(findTestObject('iOS/orders/orderDetailsScreen/createC2Order/createOrder_Button'), 0)

		Mobile.tap(findTestObject('iOS/orders/orderDetailsScreen/createC2Order/c2order_radioButton'), 0)

		Mobile.tap(findTestObject('iOS/productSearch/globalSearch/addToOrder_Button'), 0)

		(new iosCommonKeywords.commonMethods()).waitForProgressBarToBeInvisible()

		Mobile.tap(findTestObject('iOS/orders/orderDetailsScreen/createC2Order/continueBrowsing_Button'), 0)
	}

	/**
	 * edits the order details which are purchase order name and memo
	 * @param poName (new poName of the order)
	 * @param poMemo (new poMemo of the order)
	 */
	@Keyword
	def editPONameAndMemo(String poName,String poMemo) {

		Mobile.scrollToText('Edit')

		Mobile.tap(findTestObject('iOS/orders/orderDetailsScreen/editOrderNameAndMemo/searchEditOrder_Label'), 0)

		Mobile.tapAndHold(findTestObject('iOS/orders/orderDetailsScreen/editOrderNameAndMemo/poMemoField_TextField'), 0, 0)

		Mobile.clearText(findTestObject('iOS/orders/orderDetailsScreen/editOrderNameAndMemo/poMemoField_TextField'), 0)

		Mobile.setText(findTestObject('iOS/orders/orderDetailsScreen/editOrderNameAndMemo/poMemoField_TextField'), poName, 0)

		Mobile.tapAndHold(findTestObject('iOS/productSearch/globalSearch/returnKeypad_Button'), 0,0)

		Mobile.tapAndHold(findTestObject('iOS/orders/orderDetailsScreen/editOrderNameAndMemo/editPO_Button'), 0, 0)

		Mobile.clearText(findTestObject('iOS/orders/orderDetailsScreen/editOrderNameAndMemo/editPO_TextField'), 0)

		Mobile.setText(findTestObject('iOS/orders/orderDetailsScreen/editOrderNameAndMemo/editPO_TextField'), poName, 0)

		Mobile.tap(findTestObject('iOS/orders/orderDetailsScreen/editOrderNameAndMemo/updateOrder_Button'), 0)
	}

	/**
	 * fetch UTN number and store it in a string
	 */
	@Keyword
	def getUTNFromUTNTextField() {

		String beforeUTN = Mobile.getText(findTestObject('iOS/orders/c2OrderDetailsScreen/placeC2Order/uniqueTrackingNumber_TextField'), 0)

		return beforeUTN;
	}

	/**
	 * takes user to dash-board
	 */
	@Keyword
	def goToDashboard() {

		Mobile.tap(findTestObject('iOS/orders/orderDetailsScreen/uploadOrder/goToDashboard_Button'), 0)
	}

	/**
	 * clicks on place order button
	 */
	@Keyword
	def placeOrder() {

		Mobile.tap(findTestObject('iOS/orders/orderDetailsScreen/placeOrder/placeOrder_Button'), 0)

		Mobile.tap(findTestObject('iOS/orders/cartScreen/placeAllOrders/placeMyOrder(s)_Text'), 0)

		(new iosCommonKeywords.commonMethods()).waitForProgressBarToBeInvisible()
	}


	/**
	 * try removing all characters in UTN field
	 */
	@Keyword
	def removeCharactersInUTNField() {

		Mobile.clearText(findTestObject('iOS/orders/c2OrderDetailsScreen/placeC2Order/uniqueTrackingNumber_TextField'), 0)

		Mobile.delay(1)

		Mobile.sendKeys(findTestObject('iOS/orders/c2OrderDetailsScreen/placeC2Order/uniqueTrackingNumber_TextField'), Keys.chord(Keys.RETURN))
	}


	/**
	 * removes product from orders details
	 */
	@Keyword
	def removeProduct() {
		Mobile.tap(findTestObject('iOS/orders/orderDetailsScreen/verificationDetails/removeItem_Button'), 0)
	}

	/**
	 * this function returns the cost of added product
	 * @return productCost (of the product which has been added)
	 */
	@Keyword
	def returnCostOfTheAddedProduct() {

		String testObj='Object Repository/iOS/orders/verificationDetails/productCost_Text'

		float productCost=commonIosMethodsObject.returnCostOfTheAddedProduct(testObj)//calling common method to get product cost

		return productCost
	}

	/**
	 * returns NDC number
	 */
	@Keyword
	def returnNDCLabelOfScannedProduct () {
		String NDCLabel = Mobile.getText(findTestObject('iOS/verification/ndcLabel_Text'), 0)
		return NDCLabel
	}

	/**
	 * this function returns the order name of the order/ title of the screen when user is on order details screen
	 * return orderName (returns order name/ title of order details screen)
	 */
	@Keyword
	def returnOrderNameFromOrderDetailScreen() {

		String orderName=Mobile.getText(findTestObject('iOS/orders/verificationDetails/orderDetailHeader_Text'), 0)

		return orderName
	}

	/**
	 * this function returns the order value
	 * @return orderTotalFloatValue (order total value)
	 */
	@Keyword
	def returnOrderValue() {

		String orderTotal=Mobile.getText(findTestObject('iOS/orders/verificationDetails/orderTotal_Text'), 0)

		//float orderTotal_dollarSymbolRemoved_FloatValue=(new common.commonMethods()).floatValueGenerator(orderTotal)//converting uoiCost string to a float value
		orderTotal=orderTotal.replaceAll("[^0-9.]", "")
		float orderTotal_dollarSymbolRemoved_FloatValue=orderTotal.toFloat()

		return orderTotal_dollarSymbolRemoved_FloatValue
	}



	/**
	 * this function returns the order name in search page
	 */
	@Keyword
	def returnProductNameAfterSearch(){
		String orderNameInSearchPage=Mobile.getText(findTestObject('iOS/orders/productInfo/productSearch/productDescriptionLabel_Text'), 0)
		return orderNameInSearchPage
	}



	/**
	 * this function gets the total added quantity of the product
	 * @return quantityNumericalValue (of the product which has been added)
	 */
	@Keyword
	def returnQuantityOfTheAddedProduct() {

		String quantity= Mobile.getText(findTestObject('iOS/orders/orderDetailsScreen/verificationDetails/quantity_TextField'), 0)

		KeywordUtil.logInfo(quantity)

		float quantityNumericalValue=Float.valueOf(quantity)

		return quantityNumericalValue
	}

	/**
	 * this function returns the top most product name in order details page
	 */
	@Keyword
	def returnTopMostProductNameInOrderDetails(){
		String productName=Mobile.getText(findTestObject('iOS/orders/orderDetailsScreen/verificationDetails/productDescriptionLabel_Text'), 0)
		return productName
	}

	/**
	 * scans the product, adds it to the order and also verifies some scan input details when 'ordering' toggle is selected
	 * @param productToBeSearched (name which can be a productName/Cin/NDC of the product to be added)
	 */
	@Keyword
	def scanInputEvent(String productToBeSearched) {

		Mobile.tap(findTestObject('iOS/productSearch/scanFlow/scanGray_Image'), 0)

		Mobile.setText(findTestObject('iOS/productSearch/scanFlow/enterBarcode_TextField'), productToBeSearched, 0, FailureHandling.STOP_ON_FAILURE)

		Mobile.tap(findTestObject('iOS/productSearch/scanFlow/done_Button'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/orders/orderDetailsScreen/verificationDetails/thisItemHaBeenAddedToYourOrder_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/orders/orderDetailsScreen/verificationDetails/alternates_Text'), 0)
	}

	/**
	 * scans the product in offline mode
	 * @param productToBeSearched (name which can be a productName/Cin/NDC of the product to be added)
	 */
	@Keyword
	def scanInputEventInOfflineMode(String productToBeSearched) {
		Mobile.tap(findTestObject('iOS/productSearch/scanFlow/scanGray_Image'), 0)
		Mobile.setText(findTestObject('iOS/productSearch/scanFlow/enterBarcode_TextField'), productToBeSearched, 0)
		Mobile.tap(findTestObject('iOS/productSearch/scanFlow/done_Button'), 0)
	}



	/**
	 * scans the product, adds it to the order and also verifies some scan input details when 'price check' toggle is selected
	 * @param productToBeSearched (name which can be a productName/Cin/NDC of the product to be added)
	 */
	@Keyword
	def scanInputEventWhileOnPriceCheck(String productToBeSearched) {

		Mobile.tap(findTestObject('iOS/productSearch/scanFlow/scanGray_Image'), 0)

		Mobile.setText(findTestObject('iOS/productSearch/scanFlow/enterBarcode_TextField'), productToBeSearched, 0)

		Mobile.tap(findTestObject('iOS/productSearch/scanFlow/done_Button'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/orders/orderDetailsScreen/verificationDetails/alternates_Text'), 0)
	}


	/**
	 * scans the product
	 * @param productToBeSearched (name which can be a productName/Cin/NDC of the product to be added)
	 */
	@Keyword
	def scanInputEventWithoutVerification(String productToBeSearched) {
		Mobile.tap(findTestObject('iOS/productSearch/scanFlow/scanGray_Image'), 0)
		Mobile.setText(findTestObject('iOS/productSearch/scanFlow/enterBarcode_TextField'), productToBeSearched, 0)
		Mobile.tap(findTestObject('iOS/productSearch/scanFlow/done_Button'), 0)
		Mobile.tap(findTestObject('iOS/productSearch/globalSearch/doneKeypad_Button'), 0)
	}



	/**
	 * searches for a product by setting product name
	 * @param productName (product to be added)
	 */
	@Keyword
	def searchProductInOrderDetailPage(String productName) {
		Mobile.tap(findTestObject('iOS/productSearch/globalSearch/productSearch_TextField'), 0)
		Mobile.setText(findTestObject('iOS/productSearch/globalSearch/productSearch_TextField'), productName ,0)
		Mobile.tapAndHold(findTestObject('iOS/orders/productInfo/productSearch/search_keypad'), 0, 0)
	}

	/**
	 * searches for a product by setting product name
	 * @param productName (product to be added)
	 */
	@Keyword
	def searchProductInOrderDetailPageOfflineMode(String productName) {
		Mobile.delay(3)
		Mobile.tap(findTestObject('iOS/productSearch/globalSearch/productSearch_TextField'), 0)
		Mobile.setText(findTestObject('iOS/productSearch/globalSearch/productSearch_TextField'), productName ,0)
	}


	/**
	 * this function selects toggle value for the product to be added which can be ordering or price check)
	 * @param toggleValue (toggleValue required to be selected for the product to be added which can be ordering or price check)
	 */
	@Keyword
	def selectToggleValueForTheProductToBeSearched(String toggleValue) {

		if(toggleValue=="Ordering") {
			Mobile.tap(findTestObject('iOS/productSearch/scanFlow/ordering_Button'), 0)
		}
		else {
			Mobile.tap(findTestObject('iOS/productSearch/scanFlow/priceCheck_Button'), 0)
		}
	}

	/**
	 * takes user back to the search product results to continue browsing
	 */
	@Keyword
	def tapContinueOnDesktop() {
		Mobile.tap(findTestObject('iOS/orders/orderDetailsScreen/uploadOrder/continueOnDesktop_Button'), 0)
	}



	/**
	 * taps on alternate to order in alternates page and opens confirmation pop up
	 */
	@Keyword
	def tapOnAddAlternateToOrderInAlternatesPage() {
		Mobile.tap(findTestObject('iOS/orders/alternatesScreen/addAlternateToOrder_Text'),  0)
	}

	/**
	 * adds product in product details page
	 */
	@Keyword
	def tapOnAddToOrderInProductDetailsPage() {
		Mobile.tap(findTestObject('iOS/orders/productInfo/productDetails/AddToOrder_Button'), 0)
	}

	/**
	 * opens alternates page
	 */
	@Keyword
	def tapOnAlternatesInProductDetailsPage() {
		Mobile.tap(findTestObject('iOS/orders/productInfo/productDetails/alternates_Text'), 0)
	}



	/**
	 * takes user back to the search product results to continue browsing
	 */
	@Keyword
	def tapOnContinueBrowsing() {

		Mobile.tap(findTestObject('iOS/orders/alternatesScreen/continueBrowsing_Button') ,0)
	}



	/**
	 * allows camera access while using real device
	 */
	@Keyword
	def tapOnOkForCameraAcess() {
		Mobile.delay(1)
		Mobile.tapAndHold(findTestObject('iOS/verification/okRealDeviceCameraAccess_Button'), 0, 0)
	}


	/**
	 * taps on search key of the keyboard
	 */
	@Keyword
	def tapOnsearchKeyInOfflineMode() {
		Mobile.tapAndHold(findTestObject('iOS/orders/productInfo/productSearch/search_keypad'), 0, 0)
	}


	/**
	 * uploads the c2 order by clicking on upload order button
	 */
	@Keyword
	def uploadC2Order() {

		Mobile.tap(findTestObject('iOS/orders/cartScreen/c2OrderDetails/uploadC2Order_Button'), 0)
	}


	/**
	 * uploads the order by clicking on upload order button and verifies upload order button gets disabled after uploading
	 */
	@Keyword
	def uploadOrder() {

		Mobile.tap(findTestObject('iOS/orders/orderDetailsScreen/uploadOrder/uploadOrder_Button'), 0)
	}


	/**
	 * verifies c2 label is visible or not
	 */
	@Keyword
	def verifyC2Label() {

		Mobile.verifyElementExist(findTestObject('iOS/orders/verificationDetails/controlledItem_Text'), 0)
	}




	/**
	 * verifies c2 order is not visible under non c2 order
	 */
	@Keyword
	def verifyC2OrderIsNotVisibleUnderNonC2Order() {
		Mobile.verifyElementNotVisible(findTestObject('iOS/orders/productInfo/productDetails/c2Label_Text'), 0)
	}



	/**
	 * verifies confirmation pop up in alternates page
	 */
	@Keyword
	def verifyConfirmationPopUpInALternatesPage() {
		Mobile.verifyElementExist(findTestObject('iOS/orders/alternatesScreen/itemAddedConfirmationTitle_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/orders/alternatesScreen/continueBrowsing_Button'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/orders/alternatesScreen/goToOrder_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/orders/alternatesScreen/newOrderCreated_Text'), 0)
	}

	/**
	 * verifies filterByOptions
	 */
	@Keyword
	def verifyFilterByOptions() {
		Mobile.verifyElementExist(findTestObject('iOS/orders/alternatesScreen/stockedFilterByOptions_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/orders/alternatesScreen/formFilterByOptions_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/orders/alternatesScreen/sizeFliterByOptions_Text'), 0)
		int ElementTopPosition = Mobile.getElementTopPosition(findTestObject('iOS/orders/alternatesScreen/stockedFilterByOptions_Text'), 0)
		int ElementHeight=Mobile.getElementHeight(findTestObject('iOS/orders/alternatesScreen/stockedFilterByOptions_Text'), 0)
		int yCoordinateToSwipe=(ElementHeight/2)+ElementTopPosition
		Mobile.swipe(500, yCoordinateToSwipe, 0, yCoordinateToSwipe)
		Mobile.verifyElementExist(findTestObject('iOS/orders/alternatesScreen/contractFilterByOptions_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/orders/alternatesScreen/manufacturerFilterByOptions_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/orders/alternatesScreen/suggestedAlternate_TextView'), 0)
	}

	/**
	 * takes productSearch and expected lines count as the arguments and verifies the same
	 * @param expectedLinesCount (expected lines count after adding product to an order)
	 * @param productNdcNumber (using NDC of the product which is visible on the product tab)
	 * if in future upc/cin are visible then the method can be modified accordingly by passing the respective test object	 */
	@Keyword
	def verifyOrderDetailsScreenAfterAddingAProduct(String productNdcNumber, String expectedLinesCount) {

		(new iosOrders.orderDetailsScreen()).verifyProductIsVisibleOnTheOrderDetailsScreen(productNdcNumber)//calling verifyProductIsVisibleOnTheScreen function and passing testObj, topProductIdentificationNumber as the arguments

		Mobile.verifyElementExist(findTestObject('iOS/orders/verificationDetails/orderDetailHeader_Text'), 0)

		String linesCount=Mobile.getText(findTestObject('iOS/orders/orderDetailsScreen/verificationDetails/lines_Text'), 0)

		assert linesCount==expectedLinesCount
	}



	/**
	 * verifies order details screen when user in offline mode
	 */
	@Keyword
	def verifyOrderDetailsScreenInOfflineMode () {
		Mobile.verifyElementAttributeValue(findTestObject('iOS/orders/orderDetailsScreen/uploadOrder/uploadOrder_Button'), 'enabled', 'false', 0)
		Mobile.verifyElementAttributeValue(findTestObject('iOS/orders/orderDetailsScreen/placeOrder/placeOrder_Button'), 'enabled', 'false', 0)
	}




	/**
	 * verifies order details screen when user creates an order
	 * @param poName (purchase order name)
	 */
	@Keyword
	def verifyOrderDetailsScreenWithoutAnyAddedProduct(poName) {

		Mobile.verifyElementExist(findTestObject('iOS/orders/orderDetailsScreen/verificationDetails/orderDetailHeader_Label',[('TEXT'):poName]),0)

		Mobile.verifyElementAttributeValue(findTestObject('iOS/orders/orderDetailsScreen/uploadOrder/uploadOrder_Button'), 'enabled', 'false', 0)

		Mobile.verifyElementAttributeValue(findTestObject('iOS/orders/orderDetailsScreen/placeOrder/placeOrder_Button'), 'enabled', 'false', 0)

		Mobile.verifyElementExist(findTestObject('iOS/orders/orderDetailsScreen/verificationDetails/product_SearchField'), 0, FailureHandling.STOP_ON_FAILURE)
	}

	/**
	 * verifies order name header label
	 * @param poName (poName is the order name)
	 */
	@Keyword
	def verifyOrderNameHeaderLabel(String poName){
		Mobile.verifyElementVisible(findTestObject('iOS/orders/verificationDetails/OrderDetailHeader_Label',[('TEXT'):poName]),0)
	}


	/**
	 * verifies the order value after adding a product
	 * @param quantity (quantity which was added)
	 */
	@Keyword
	def verifyOrderValue(quantity) {

		int quantityIntegralValue=Integer.parseInt(quantity)

		String productCost=Mobile.getText(findTestObject('iOS/orders/verificationDetails/productCost_Text'), 0)
		productCost=productCost.replaceAll("[^0-9.]", "")
		float productCost_FloatValue=productCost.toFloat()
		//float productCost_dollarSymbolRemoved_FloatValue=commonMethodsObject.floatValueGenerator(productCost)//converting uoiCost string to a float value

		float expectedOrderTotal=quantityIntegralValue*productCost_FloatValue

		String formattedExpectedOrderTotal=commonMethodsObject.formatDecimalData(expectedOrderTotal,"0.00") //formatting the data to be rounded off to upper level and to two decimal places

		//float formattedExpectedOrderTotal_FloatValue=commonMethodsObject.floatValueGenerator(formattedExpectedOrderTotal)///converting formattedExpectedOrderTotal string to a float value
		float formattedExpectedOrderTotal_FloatValue=formattedExpectedOrderTotal.toFloat()

		String actualOrderTotal=Mobile.getText(findTestObject('iOS/orders/verificationDetails/orderTotal_Text'), 0)

		//float actualOrderTotal_dollarSymbolRemoved_FloatValue=commonMethodsObject.floatValueGenerator(actualOrderTotal)//converting actualOrderTotal string to a float value

		actualOrderTotal=actualOrderTotal.replaceAll("[^0-9.]", "")
		float actualOrderTotal_dollarSymbolRemoved_FloatValue=actualOrderTotal.toFloat()

		KeywordUtil.logInfo(actualOrderTotal)

		assert formattedExpectedOrderTotal_FloatValue==actualOrderTotal_dollarSymbolRemoved_FloatValue
	}

	/**
	 * verifies place order confirmation pop up
	 */
	@Keyword
	def verifyPlaceOrderPopUp() {
		Mobile.verifyElementExist(findTestObject('iOS/orders/orderDetailsScreen/placeOrder/goBackAndReviewMyOrder_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/orders/cartScreen/placeAllOrders/placeMyOrder(s)_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/orders/orderDetailsScreen/placeOrder/yourOrderWillBePlaced_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/orders/orderDetailsScreen/placeOrder/yourOrderWillGoIntoProcessingImmediately_Text'), 0)
	}

	/**
	 * this function verifies the product after search
	 */
	@Keyword
	def verifyProductAfterSearch() {
		Mobile.verifyElementExist(findTestObject('iOS/orders/productInfo/productSearch/NDC_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/orders/productInfo/productSearch/productDescriptionLabel_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/orders/productInfo/productSearch/UOI_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/orders/productInfo/productSearch/quantity_TextField'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/orders/productInfo/productSearch/manufacturer_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/orders/productInfo/productSearch/alternates_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/orders/productInfo/productSearch/addToOrder_Text'), 0)
	}


	/**
	 * this function verifies the product details page
	 */

	@Keyword
	def verifyProductDetailAfterSelectingMoreDetails(String orderNameInSearchPage){
		String orderNameInProductDetailsPage=Mobile.getText(findTestObject('iOS/orders/productInfo/productDetails/productDescriptionLabel_Text'), 0)
		assert orderNameInSearchPage== orderNameInProductDetailsPage
		Mobile.verifyElementExist(findTestObject('iOS/orders/productInfo/productDetails/c2Label_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/orders/productInfo/productDetails/productSize_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/orders/productInfo/productDetails/NDC_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/orders/productInfo/productDetails/UOI_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/orders/productInfo/productDetails/stockStatus_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/orders/productInfo/productDetails/returnable_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/orders/productInfo/productDetails/quantity_TextField'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/orders/productInfo/productDetails/less_Button'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/orders/productInfo/productDetails/more_Button'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/orders/productInfo/productDetails/strength_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/orders/productInfo/productDetails/form_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/orders/productInfo/productSearch/upc_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/orders/productInfo/productSearch/cin_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/orders/productInfo/productDetails/contractAlias_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/orders/productInfo/productDetails/retailPrice_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/orders/productInfo/productDetails/alternates_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/orders/productInfo/productDetails/AddToOrder_Button'), 0)
	}


	/**
	 * this function verifies that the product is visible on the order details screen
	 * @param productNdcNumber (using NDC of the product which is visible on the product tab)
	 * if in future upc/cin are visible then the method can be modified accordingly by passing the respective test object
	 */
	@Keyword
	def verifyProductIsVisibleOnTheOrderDetailsScreen(productNdcNumber) {

		String testObj='Object Repository/iOS/orders/verificationDetails/ordersNdc_Label'

		(new iosCommonKeywords.commonMethods()).verifyProductIsVisibleOnTheScreen(testObj,productNdcNumber)//calling verifyProductIsVisibleOnTheScreen function and passing testObj, topProductIdentificationNumber as the arguments
	}


	/**
	 * verifies that the added top most product should  be visible on the order details page
	 * @param productname (top most added product name)
	 */
	@Keyword
	def verifyProductNameIsVisibleUnderOrderDetails(String productname) {
		Mobile.verifyElementVisible(findTestObject('iOS/orders/orderDetailsScreen/verificationDetails/productDescriptionLabel_Text',[('TEXT'): productname]) ,0)
	}


	/**
	 * this function verifies the product tile
	 */
	@Keyword
	def verifyProductTile() {
		Mobile.verifyElementExist(findTestObject('iOS/orders/productInfo/productSearch/CIN_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/orders/productInfo/productSearch/UPC_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/orders/productInfo/productSearch/retailPrice_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/orders/productInfo/productSearch/moreDetailsView_Text'), 0)
	}


	/**
	 * verified user is taken to scan result screen after tapping on continue browsing button
	 */
	@Keyword
	def verifyScanResultScreenWithProduct() {

		Mobile.verifyElementExist(findTestObject('iOS/orders/orderDetailsScreen/priceCheckToggleScreen/addToOrder_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/productSearch/scanFlow/ordering_Button'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/productSearch/scanFlow/priceCheck_Button'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/productSearch/scanFlow/productDescription_Label'), 0)
	}

	/**
	 * verifies the pop up which appears after user clicks on upload order
	 */
	@Keyword
	def verifyUploadOrderPopUp() {

		Mobile.verifyElementExist(findTestObject('iOS/orders/orderDetailsScreen/verificationDetails/continueOrderOnTheDesktop_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/orders/cartScreen/uploadAllOrders/cancelAndKeepOrdersOnTheApp_Button'), 0)
	}


	/**
	 * verifies only last 6 digit got deleted, first 3 characters could not be removed & validation error displayed after removing characters
	 */
	@Keyword
	def verifyValidationErrorAfterRemovingCharactesInUTNField() {

		String actualErrorMsg = Mobile.getText(findTestObject('iOS/orders/c2OrderDetailsScreen/placeC2Order/uniqueTrackingNumberError_Label_2'), 0)

		String expectedErrorMsg = 'Please provide a Unique Tracking Number in the following format: AANNNN (two alphabetic characters followed by four numeric digits).'

		assert expectedErrorMsg.equalsIgnoreCase(actualErrorMsg)
	}
}