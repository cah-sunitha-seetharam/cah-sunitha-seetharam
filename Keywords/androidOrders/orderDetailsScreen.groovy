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
	 * adds alternate product
	 * @param productName (name of the product)
	 * @param quantity (quantity of the product)
	 */
	@Keyword()
	def addAlternateProduct(String productName,String quantity) {
		Mobile.tap(findTestObject('Android/productSearch/searchProductsSearchView_EditText'), 0)
		Mobile.setText(findTestObject('Android/productSearch/searchProductsSearchView_EditText'), productName + '\\n',0)
		Mobile.setText(findTestObject('Android/productSearch/Quantity_TextField'), quantity, 0)
		Mobile.tap(findTestObject('Android/productSearch/alternatesList_TextView'), 0)
		Mobile.tap(findTestObject('Android/productSearch/addAlternateToOrder_Button'), 0)
		Mobile.tap(findTestObject('Android/productSearch/continueOrdering_Button'),0)
	}

	/**
	 * searches for a product by setting product name and quantity as the input
	 * @param productName (product to be added), quantity (total quantity required to be added)
	 */
	@Keyword
	def addProductToOrder(String productName, String quantity) {
		Mobile.tap(findTestObject('Android/productSearch/searchProductsSearchView_EditText'), 0)
		Mobile.setText(findTestObject('Android/productSearch/searchProductsSearchView_EditText'), productName + '\\n',0)
		(new androidCommonKeywords.commonMethods()).waitForProgressBarToBeInvisible()
		Mobile.setText(findTestObject('Android/productSearch/Quantity_TextField'), quantity, 0)
		Mobile.tap(findTestObject('Android/productSearch/addToOrder_Button'),0)
	}

	/**
	 * this function adds the quantity for the product to be searched
	 * @param quantity (quantity required to be added for the product to be searched)
	 */
	@Keyword
	def addQuantityforTheSearchedProduct(int quantity) {
		int i
		for (i=1; i<= quantity; i++) {
			Mobile.tap(findTestObject('Android/orders/orderDetailsScreen/scanOrder/moreOperator_ImageView'),  0)
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
			Mobile.tap(findTestObject('Android/orders/alternatesScreen/plusButton_ImageView'),  0)
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
			Mobile.tap(findTestObject('Android/orders/productInfo/productSearch/increaseCount_TextView'),  0)
		}
	}

	/**
	 * adds product
	 */
	@Keyword
	def addToOrderWithoutVerify() {
		Mobile.tap(findTestObject('Android/orders/productInfo/productSearch/addToOrder_Button'), 0)
	}

	/**
	 * clicks on c2 order availability and waits for the response while verifying the availability details for the c2 product
	 */
	@Keyword()
	def checkC2ProductAvailability() {
		Mobile.tap(findTestObject('Android/orders/c2OrderDetailsScreen/placeC2Order/checkAvailability_Button'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/c2OrderDetailsScreen/placeC2Order/oneMoment_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/c2OrderDetailsScreen/placeC2Order/weNeedJustAMinuteToEnsureThatWeHaveEverythingInStock_TextView'), 0)
		String testObject='Android/Orders/C2 Order Details Screen/Place C2 Order/OneMomentProgressBar'
		(new androidCommonKeywords.commonMethods()).waitTimeForObjectToBeVisible(testObject,1,20)
	}

	/**
	 * takes user back to cart
	 */
	@Keyword
	def clickOnBackToCart() {
		Mobile.tap(findTestObject('Android/orders/orderDetailsScreen/uploadOrder/backToCart_Button'), 0)
	}

	/**
	 * takes user back to the search product results to continue ordering
	 */
	@Keyword
	def clickOnContinueOrdering() {
		Mobile.tap(findTestObject('Android/productSearch/continueOrdering_Button') ,0)
	}

	/**
	 * takes user back to the search product results to continue browsing
	 */
	@Keyword
	def clickOnContinueOrderingOnDesktop() {
		Mobile.tap(findTestObject('Android/orders/orderDetailsScreen/uploadOrder/continueOrderOnTheDesktop_TextView'), 0)
	}

	/**
	 * opens more details of product details
	 */
	@Keyword
	def clickOnMoreDetails() {
		Mobile.tap(findTestObject('Android/orders/productInfo/productSearch/moreDetails__TextView'), 0)
	}

	/**
	 * places the order 
	 */

	@Keyword
	def clickOnPlaceOrder() {
		Mobile.tap(findTestObject('Android/orders/orderDetailsScreen/placeOrder/placeOrder_Button'), 0, )
	}

	/**
	 * opens product tile
	 */
	@Keyword
	def clickOnProductTile() {
		Mobile.tap(findTestObject('Android/orders/productInfo/productSearch/NDC_TextView'), 0)
	}

	/**
	 * takes user back to history screen and verifies user is on the history screen or not
	 */
	@Keyword
	def clickOnReviewAndSignButton() {
		Mobile.tap(findTestObject('Android/orders/c2OrderDetailsScreen/placeC2Order/reviewAndSign_Button'), 0)
		(new androidCommonKeywords.commonMethods()).waitForProgressBarToBeInvisible()
		Mobile.verifyElementExist(findTestObject('Android/orders/historyScreen/orderHistory_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/historyScreen/orderHistoryHeaderText_TextView'),  0)
	}

	/**
	 * taps on scan icon and takes user to scanning product screen and also verifies ordering and price check
	 */
	@Keyword
	def clickOnScanIcon() {
		Mobile.delay(2)
		Mobile.tap(findTestObject('Android/orders/orderDetailsScreen/scanOrder/scan_Icon'), 0,FailureHandling.OPTIONAL)
		Mobile.verifyElementExist(findTestObject('Android/orders/orderDetailsScreen/scanOrder/ordering_Text'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/orderDetailsScreen/scanOrder/priceCheck_Text'), 0)
	}

	/**
	 *  taps on scan icon and takes user to scanning product screen
	 */
	@Keyword
	def clickOnScanIconWithoutVerification() {
		Mobile.tap(findTestObject('Android/orders/orderDetailsScreen/scanOrder/scan_Icon'), 0)
	}

	/**
	 * confirms place order by clicking on place my order button
	 */
	@Keyword
	def confirmPlaceOrder() {
		Mobile.tap(findTestObject('Android/orders/orderDetailsScreen/placeOrder/placeMyOrder_Button'), 0)
	}

	/**
	 * opens confirmation pop up 
	 */
	@Keyword
	def continueOnDesktop() {
		Mobile.tap(findTestObject('Android/orders/orderDetailsScreen/uploadOrder/continueOnDesktop_Button'), 0)
	}

	/**
	 * creates a new C2 order
	 * @param poName (poName of the order), poMemo (poMemo of the order)
	 */
	@Keyword
	def createNewC2Order(String poName, String poMemo) {
		Mobile.verifyElementExist(findTestObject('Android/orders/c2OrderDetailsScreen/placeC2Order/thisIsAC2ItemCreateAC2OrderToAddItem_TextView'), 0, FailureHandling.STOP_ON_FAILURE)
		Mobile.tap(findTestObject('Android/orders/c2OrderDetailsScreen/placeC2Order/createANewOrder_TextView'), 0)
		Mobile.setText(findTestObject('Android/orders/newOrderScreen/P.O. Name (Optional)_TextField'), poName, 0)
		Mobile.setText(findTestObject('Android/orders/newOrderScreen/poMemo_EditText'), poMemo, 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/c2OrderDetailsScreen/placeC2Order/Cancel_Button'), 0, FailureHandling.STOP_ON_FAILURE)
		Mobile.tap(findTestObject('Android/orders/c2OrderDetailsScreen/placeC2Order/createNewOrder_Button'), 0)
		Mobile.tap(findTestObject('Android/orders/c2OrderDetailsScreen/placeC2Order/c2Order_RadioButton',[('TEXT'):poName]),0)
		Mobile.tap(findTestObject('Android/orders/c2OrderDetailsScreen/placeC2Order/addToOrder_Button'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/c2OrderDetailsScreen/placeC2Order/cartTotal_TextView'), 0, FailureHandling.STOP_ON_FAILURE)
		Mobile.verifyElementExist(findTestObject('Android/orders/c2OrderDetailsScreen/placeC2Order/continueBrowsing_Button'), 0)
		Mobile.tap(findTestObject('Android/orders/c2OrderDetailsScreen/placeC2Order/goToOrder_TextView'), 0)
	}

	/**
	 * creates a new C2 order
	 * @param poName (poName of the order), poMemo (poMemo of the order)
	 */
	@Keyword
	def createNewOrderForC2WithoutVerification(String poName, String poMemo) {
		Mobile.tap(findTestObject('Android/orders/c2OrderDetailsScreen/placeC2Order/createANewOrder_TextView'), 0)
		Mobile.setText(findTestObject('Android/orders/newOrderScreen/P.O. Name (Optional)_TextField'), poName, 0)
		Mobile.setText(findTestObject('Android/orders/newOrderScreen/poMemo_EditText'), poMemo, 0)
		Mobile.tap(findTestObject('Android/orders/c2OrderDetailsScreen/placeC2Order/createNewOrder_Button'), 0)
	}

	/**
	 * edits poname and pomemo
	 * @param poName (poName of the order)
	 * @param poName (poMemo of the order)
	 */
	@Keyword
	def editPONameAndMemo(String poName,String poMemo, String newPoName, String newPoMemo ) {
		Mobile.scrollToText('Edit')
		Mobile.tap(findTestObject('Android/orders/orderDetailsScreen/editPoNameAndMemo/editPOnameAndMemo_TextView'), 0)
		Mobile.clearText(findTestObject('Android/orders/orderDetailsScreen/editPoNameAndMemo/poNameToBeEdited_TextField', [('po_name') : poName]), 0)
		Mobile.setText(findTestObject('Android/orders/newOrderScreen/P.O. Name (Optional)_TextField'), newPoName, 0)
		Mobile.clearText(findTestObject('Android/orders/orderDetailsScreen/editPoNameAndMemo/poMemoToBeEdited_TextField', [('po_memo') : poMemo]), 0)
		Mobile.setText(findTestObject('Android/orders/newOrderScreen/poMemo_EditText'), newPoMemo,	0)
		Mobile.tap(findTestObject('Android/orders/orderDetailsScreen/editPoNameAndMemo/updateOrder_Button'), 0)
	}

	/**
	 * enables radio button and adds c2 product
	 * @param poName (poName of the order)
	 */
	@Keyword
	def enableRadioButtonForNewOrderC2Creation(String poName){
		Mobile.tap(findTestObject('Android/orders/c2OrderDetailsScreen/placeC2Order/c2Order_RadioButton',[('TEXT'):poName]),0)
		Mobile.tap(findTestObject('Android/orders/c2OrderDetailsScreen/placeC2Order/addToOrder_Button'), 0)
	}

	/**
	 * It checks Duplicate utn number
	 * @param existingUTNno (utn number)
	 * @param duplicateErrorMsg (error message)
	 */
	@Keyword
	def enterDuplicateUTN(String existingUTNno, String duplicateErrorMsg) {
		Mobile.setText(findTestObject('Android/orders/c2OrderDetailsScreen/UTNverification/UTNTextBox_EditText'), existingUTNno, 0)
		Mobile.tap(findTestObject('Android/orders/c2OrderDetailsScreen/placeC2Order/checkAvailability_Button'), 0)
		WebUI.delay(10)
		String actualErrorMsg = Mobile.getText(findTestObject('Android/orders/c2OrderDetailsScreen/UTNverification/duplicateUTNMessage_TextView'), 0)
		assert duplicateErrorMsg == actualErrorMsg
		Mobile.verifyElementExist(findTestObject('Android/orders/c2OrderDetailsScreen/UTNverification/duplicateUTNerrorIcon_ImageView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/c2OrderDetailsScreen/UTNverification/duplicateUTNNumberError_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/c2OrderDetailsScreen/UTNverification/ReEnterUTN_Button'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/c2OrderDetailsScreen/UTNverification/SaveforLater_Button'), 0)
	}

	/**
	 * removes product from orders details
	 */
	@Keyword
	def removeProduct() {
		Mobile.tap(findTestObject('Android/orders/orderDetailsScreen/verificationDetails/removeProduct_TextView'), 0)
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
	 * this function returns the order name of the order/ title of the screen when user is on order details screen
	 * return orderName (returns order name/ title of order details screen)
	 */
	@Keyword
	def returnNDCLabelOfScannedProduct() {
		String NDCLabel = Mobile.getText(findTestObject('Android/orders/verificationDetails/ndc_TextView'), 0)
		return NDCLabel
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
	 * this function returns the order value
	 * @return actualOrderTotal(order total value)
	 */
	@Keyword
	def returnOrderValue() {
		String orderTotal=Mobile.getText(findTestObject('Android/orders/verificationDetails/orderTotalCost_TextView'), 0)
		String actualOrderTotal = (new androidCommonKeywords.commonMethods()).removeCharctersInString(orderTotal)
		return actualOrderTotal
	}

	/**
	 * this function returns the order name in search page
	 */
	@Keyword
	def returnProductNameAfterSearch(){
		String orderNameInSearchPage=Mobile.getText(findTestObject('Android/productDetails/productDescriptionLabel_TextView'), 0)
		return orderNameInSearchPage
	}

	/**
	 * this function gets the total added quantity of the product
	 * @return quantityNumericalValue (of the product which has been added)
	 */
	@Keyword
	def returnQuantityOfTheAddedProduct() {
		String quantity= Mobile.getText(findTestObject('Android/orders/orderDetailsScreen/scanOrder/quantityTextField_EditText'), 0)
		KeywordUtil.logInfo(quantity)
		float quantityNumericalValue=Float.valueOf(quantity)
		return quantityNumericalValue
	}

	/**
	 * this function returns the top most product name in order details page
	 */
	@Keyword
	def returnTopMostProductNameInOrderDetails(){
		String productName=Mobile.getText(findTestObject('Android/orders/orderDetailsScreen/verificationDetails/productName_TextView'), 0)
		return productName
	}

	/**
	 * Its save for later
	 */
	@Keyword
	def saveForLater() {
		Mobile.verifyElementExist(findTestObject('Android/orders/c2OrderDetailsScreen/UTNverification/SaveforLater_Button'), 0)
		Mobile.tap(findTestObject('Android/orders/c2OrderDetailsScreen/UTNverification/SaveforLater_Button'), 0)
	}

	/**
	 * scans the product, adds it to the order and also verifies some scan input details
	 * @param productToBeSearched (name which can be a productName/Cin/NDC of the product to be added)
	 */
	@Keyword
	def scanInputEvent(String productToBeSearched) {
		Mobile.setText(findTestObject('Android/orders/orderDetailsScreen/scanOrder/scan_EditText'), productToBeSearched, 0)
		Mobile.tap(findTestObject('Android/orders/orderDetailsScreen/scanOrder/scan_Button'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/orderDetailsScreen/scanOrder/thisItemHasBeenAddedToYourOrder_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/orderDetailsScreen/scanOrder/remove_Button'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/orderDetailsScreen/scanOrder/alternates_Text'), 0)
	}

	/**
	 * scans the product in offline mode
	 * @param productToBeSearched (name which can be a productName/Cin/NDC of the product to be added)
	 */
	@Keyword
	def scanInputEventInOfflineMode(String productToBeSearched) {
		Mobile.tap(findTestObject('Android/orders/orderDetailsScreen/scanOrder/scan_Icon'), 0)
		Mobile.setText(findTestObject('Android/orders/orderDetailsScreen/scanOrder/scan_EditText'), productToBeSearched, 0)
		Mobile.tap(findTestObject('Android/orders/orderDetailsScreen/scanOrder/scan_Button'), 0)
	}

	/**
	 * scans the product while on price check, adds it to the order and also verifies some scan input details
	 * @param productToBeSearched (name which can be a productName/Cin/NDC of the product to be added)
	 */
	@Keyword
	def scanInputEventWhileOnPriceCheck(String productToBeSearched) {
		Mobile.setText(findTestObject('Android/orders/orderDetailsScreen/scanOrder/scan_EditText'), productToBeSearched, 0)
		Mobile.tap(findTestObject('Android/orders/orderDetailsScreen/scanOrder/scan_Button'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/orderDetailsScreen/scanOrder/alternates_Text'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/orderDetailsScreen/scanOrder/addToOrder_Button'), 0)
	}

	/**
	 * scans the product, adds it to the order 
	 * @param productToBeSearched (name which can be a productName/Cin/NDC of the product to be added)
	 */
	@Keyword
	def scanInputEventWithoutVerification(String productToBeSearched) {
		Mobile.setText(findTestObject('Android/orders/orderDetailsScreen/scanOrder/scan_EditText'), productToBeSearched, 0)
		Mobile.tap(findTestObject('Android/orders/orderDetailsScreen/scanOrder/scan_Button'), 0)
	}

	/**
	 * searches for a product by setting product name 
	 * @param productName (product to be added)
	 */
	@Keyword
	def searchProductInOrderDetailPage(String productName) {
		Mobile.tap(findTestObject('Android/productSearch/searchProductsSearchView_EditText'), 0)
		Mobile.setText(findTestObject('Android/productSearch/searchProductsSearchView_EditText'), productName + '\\n',0)
	}

	/**
	 * searches for a product by setting product name
	 * @param productName (product to be added)
	 */
	@Keyword
	def searchProductInOrderDetailPageOfflineMode(String productName) {
		Mobile.delay(3)
		Mobile.tap(findTestObject('Android/productSearch/searchProducts_EditText'), 0)
		Mobile.setText(findTestObject('Android/productSearch/searchProducts_EditText'), productName + '\\n',0)
	}

	/**
	 * this function selects toggle value for the product to be added which can be ordering or price check)
	 * @param toggleValue (toggleValue required to be selected for the product to be added which can be ordering or price check)
	 */
	@Keyword
	def selectToggleValueForTheProductToBeSearched(String toggleValue) {
		if(toggleValue=="Ordering") {
			Mobile.tap(findTestObject('Android/orders/orderDetailsScreen/scanOrder/ordering_Text'), 0)
		}
		else {
			Mobile.tap(findTestObject('Android/orders/orderDetailsScreen/scanOrder/priceCheck_Text'), 0)
		}
	}

	/**
	 * taps on alternate to order in alternates page and opens confirmation pop up
	 */
	@Keyword
	def tapOnAddAlternateToOrderInAlternatesPage() {
		Mobile.tap(findTestObject('Android/orders/alternatesScreen/addAlternateToOrder_Button'),  0)
	}

	/**
	 * adds product in product details page
	 */
	@Keyword
	def tapOnAddToOrderInProductDetailsPage() {
		Mobile.tap(findTestObject('Android/orders/productInfo/productSearch/addToOrder_Button'), 0)
	}

	/**
	 * taps on add to order and shows confirmation pop up
	 */
	@Keyword
	def tapOnAddToOrderInScanSearchResults() {
		Mobile.tap(findTestObject('Android/orders/orderDetailsScreen/scanOrder/addToOrder_Button'), 0)
	}

	/**
	 * opens alternates page
	 * @param Alternates (alternates to be selected)
	 */
	@Keyword
	def tapOnAlternatesInProductDetailsPage(String Alternates) {
		Mobile.scrollToText(Alternates, FailureHandling.STOP_ON_FAILURE)
		Mobile.tap(findTestObject('Android/orders/productInfo/productDetails/alternates_TextView',[('TEXT') : Alternates]), 0)
	}

	/**
	 * takes user back to the search product results to continue browsing
	 */
	@Keyword
	def tapOnContinueBrowsing() {
		Mobile.tap(findTestObject('Android/orders/c2OrderDetailsScreen/placeC2Order/continueBrowsing_Button') ,0)
	}

	/**
	 * takes user to the order details
	 */
	@Keyword
	def tapOnGoToOrder() {
		Mobile.tap(findTestObject('Android/orders/alternatesScreen/goToOrder_TextView') ,0)
	}

	/**
	 * opens create new order page for c2
	 */
	@Keyword
	def tapOnSelectOrCrateANewOrderInScanSearchResults() {
		Mobile.tap(findTestObject('Android/orders/orderDetailsScreen/scanOrder/c2Order/selectOrCreateANewOrder_Button'), 0)
	}

	/**
	 * uploads the order 
	 */
	@Keyword
	def uploadOrder() {
		Mobile.tap(findTestObject('Android/orders/orderDetailsScreen/uploadOrder/uploadOrder_Button'), 0)
	}

	/**
	 * uploads the c2 order 
	 */
	@Keyword
	def uploadOrderC2() {
		Mobile.tap(findTestObject('Android/orders/c2OrderDetailsScreen/uploadC2Order/uploadOrder_Button'), 0)
	}

	/**
	 * Its check UTN number validation
	 * @param utnPrefixLength (length of the utn prefix)
	 * @param expectedErrorMsg (error message)
	 * @param input1 (given input for utn edit text field)
	 * @param input2 (given input for utn edit text field)
	 */
	@Keyword
	def utnNumberValidation(int utnPrefixLength, String expectedErrorMsg, String input1, String input2) {
		Mobile.verifyElementExist(findTestObject('Android/orders/c2OrderDetailsScreen/UTNverification/poNumberTitle_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/c2OrderDetailsScreen/UTNverification/UTNTextBox_EditText'), 0)

		// Clear text -  Last 6 characters should be deleted.
		Mobile.clearText(findTestObject('Android/orders/c2OrderDetailsScreen/UTNverification/UTNTextBox_EditText'), 0)

		// Check User should not able to remove the first  3 characters in the UTN field
		String utnNumber=Mobile.getText(findTestObject('Android/orders/c2OrderDetailsScreen/UTNverification/UTNTextBox_EditText'), 0)
		assert utnPrefixLength == (utnNumber.length())

		// Verify validation error message and error icon
		Mobile.verifyElementExist(findTestObject('Android/orders/c2OrderDetailsScreen/UTNverification/UTNerrorIcon_ImageButton'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/c2OrderDetailsScreen/UTNverification/UTNErrorMessage_TextView'), 0)
		String actualErrorMsg=Mobile.getText(findTestObject('Android/orders/c2OrderDetailsScreen/UTNverification/UTNErrorMessage_TextView'), 0)
		assert expectedErrorMsg == actualErrorMsg

		// Enter 6 zeros in the UTN field (Example: 21X000000)
		Mobile.setText(findTestObject('Android/orders/c2OrderDetailsScreen/UTNverification/UTNTextBox_EditText'), input1, 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/c2OrderDetailsScreen/UTNverification/UTNerrorIcon_ImageButton'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/c2OrderDetailsScreen/UTNverification/UTNErrorMessage_TextView'), 0)
		Mobile.clearText(findTestObject('Android/orders/c2OrderDetailsScreen/UTNverification/UTNTextBox_EditText'), 0)

		// Enter special character in the UTN field (Example: 21X00000*)
		Mobile.setText(findTestObject('Android/orders/c2OrderDetailsScreen/UTNverification/UTNTextBox_EditText'), input2, 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/c2OrderDetailsScreen/UTNverification/UTNerrorIcon_ImageButton'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/c2OrderDetailsScreen/UTNverification/UTNErrorMessage_TextView'), 0)
	}

	/**
	 * verifies c2 label is visible or not
	 */
	@Keyword
	def verifyC2Label() {
		Mobile.verifyElementExist(findTestObject('Android/orders/c2OrderDetailsScreen/placeC2Order/c2Label_TextView'), 0)
	}

	/**
	 * verifies c2 order is not visible under non c2 order
	 */
	@Keyword
	def verifyC2OrderIsNotVisibleUnderNonC2Order() {
		Mobile.verifyElementNotVisible(findTestObject('Android/orders/c2OrderDetailsScreen/uploadC2Order/c2label_TextView'), 0)
	}

	/**
	 * verifies confirmation pop up after adding c2 order 
	 */
	@Keyword
	def verifyConfirmationPopUpAfterAddingC2Order(){
		Mobile.verifyElementExist(findTestObject('Android/orders/c2OrderDetailsScreen/placeC2Order/continueBrowsing_Button'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/c2OrderDetailsScreen/placeC2Order/goToOrder_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/c2OrderDetailsScreen/uploadC2Order/itemAddedToPoname_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/c2OrderDetailsScreen/uploadC2Order/CIN_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/c2OrderDetailsScreen/uploadC2Order/orderName_TextView'), 0)
	}

	/**
	 * verifies confirmation pop up in alternates page 
	 */
	@Keyword
	def verifyConfirmationPopUpInALternatesPage() {
		Mobile.verifyElementExist(findTestObject('Android/orders/alternatesScreen/itemAddedConfirmation_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/alternatesScreen/continueBrowsing_Button'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/alternatesScreen/goToOrder_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/alternatesScreen/newOrderCreated_TextView'), 0)
	}

	/**
	 * after selecting add to order verifies item added confirmation popup in scan search results 
	 */
	@Keyword
	def verifyConfirmationPopUpInScanSearchResults() {
		Mobile.verifyElementExist(findTestObject('Android/orders/orderDetailsScreen/scanOrder/itemAddedConfirmationPopUp_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/orderDetailsScreen/scanOrder/CINconfirmationPopUp_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/orderDetailsScreen/scanOrder/goToOrder_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/orderDetailsScreen/scanOrder/continueBrowsing_Button'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/orderDetailsScreen/scanOrder/productNameConfirmationPopUp_TextView'), 0)
	}

	/**
	 * verifies confirmation pop up of c2 in scan search results
	 */
	@Keyword
	def verifyConfirmationPopUpOfC2InScanSearchResults() {
		Mobile.verifyElementExist(findTestObject('Android/orders/orderDetailsScreen/scanOrder/c2Order/thisIsAC2ItemWouldYouLikeToCreateANewOrderOrAddToExistingOrderConfirmationPopUp_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/orderDetailsScreen/scanOrder/c2Order/selectOrCreateANewOrder_Button'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/orderDetailsScreen/scanOrder/c2Order/cancel_TextView'), 0)
	}

	/**
	 * verifies filterByOptions
	 * @param Alternates (alternates to be selected)
	 */
	@Keyword
	def verifyFilterByOptions(String Alternates) {
		Mobile.verifyElementVisible(findTestObject('Android/orders/alternatesScreen/alternateHeaderName_TextView',[('TEXT') : Alternates]), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/alternatesScreen/InStockFilterByOptions_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/alternatesScreen/formFilterByOptions_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/alternatesScreen/sizeFilterByOptions_TextView'), 0)
		int ElementTopPosition = Mobile.getElementTopPosition(findTestObject('Android/orders/alternatesScreen/InStockFilterByOptions_TextView'), 0)
		int ElementHeight=Mobile.getElementHeight(findTestObject('Android/orders/alternatesScreen/InStockFilterByOptions_TextView'), 0)
		int yCoordinateToSwipe=(ElementHeight/2)+ElementTopPosition
		Mobile.swipe(500, yCoordinateToSwipe, 0, yCoordinateToSwipe)
		Mobile.verifyElementExist(findTestObject('Android/orders/alternatesScreen/contractFilterByOptions_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/alternatesScreen/manufacturerFilterByOptions_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/alternatesScreen/suggestedAlternate_TextView'), 0)
	}

	/**
	 * takes expected lines count as the argument and verifies the same
	 * @param expectedLineCount (expected total line count after adding product and return to the order name page)
	 */
	@Keyword
	def verifyLineCountOfOrderNamePage(String expectedLineCount){
		String lineCount=Mobile.getText(findTestObject('Android/orders/orderDetailsScreen/verificationDetails/lineCountOrderPage_TextView'), 0)
		String actualLineCount = (new androidCommonKeywords.commonMethods()).removeCharctersInString(lineCount)
		assert expectedLineCount == actualLineCount
	}

	/**
	 * verifies order details screen when user in offline mode
	 */
	@Keyword
	def verifyOrderDetailsScreenInOfflineMode () {
		Mobile.verifyElementAttributeValue(findTestObject('Android/orders/orderDetailsScreen/uploadOrder/Upload Order_Button'), 'enabled', 'false', 0)
		Mobile.verifyElementAttributeValue(findTestObject('Android/orders/orderDetailsScreen/placeOrder/placeOrder_Button'), 'enabled', 'false', 0)
	}

	/**
	 * verifies order has been sent to desktop pop up
	 */
	@Keyword
	def verifyOrderHasbeensentToDesktopPopUp() {
		Mobile.verifyElementExist(findTestObject('Android/orders/orderDetailsScreen/verificationDetails/orderHasbeenSentToDesktop_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/orderDetailsScreen/uploadOrder/Back to Cart_Button'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/orderDetailsScreen/uploadOrder/Go to Dashboard_Button'), 0)
	}

	/**
	 * verifies order name header label
	 * @param poName (poName is the order name)
	 */
	@Keyword
	def verifyOrderNameHeaderLabel(String poName){
		Mobile.verifyElementVisible(findTestObject('Android/orders/orderDetailsScreen/verificationDetails/orderNameHeader_TextView',[('TEXT'):poName]),0)
	}

	/**
	 * verifies order screen details with added product
	 */
	@Keyword
	def verifyOrderScreenDetailsWithAddedProduct() {
		Mobile.verifyElementExist(findTestObject('Android/orders/cartScreen/verificationDetails/Lines_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/orderDetailsScreen/verificationDetails/orderTotal_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/orderDetailsScreen/verificationDetails/orderNameInHeader_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/orderDetailsScreen/verificationDetails/removeProduct_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/productDetails/NDClabel_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/productDetails/UOIcost_Text'), 0)
		Mobile.verifyElementExist(findTestObject('Android/productDetails/AMU_Text'), 0)
		Mobile.verifyElementExist(findTestObject('Android/productDetails/Manufacturer_Text'),  0)
		Mobile.verifyElementExist(findTestObject('Android/orders/orderDetailsScreen/verificationDetails/Scan_Icon'),0)
		Mobile.verifyElementExist(findTestObject('Android/orders/orderDetailsScreen/editPoNameAndMemo/editPOnameAndMemo_TextView'),	0)
	}

	/**
	 * verifies order screen details without any added product
	 */
	@Keyword
	def verifyOrderScreenDetailsWithoutAnyAddedProduct() {
		Mobile.verifyElementExist(findTestObject('Android/orders/orderDetailsScreen/verificationDetails/nothingToSeeHere_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/orderDetailsScreen/verificationDetails/searchProductsAndAddThemToThisOrder_TextView'),  0)
		Mobile.verifyElementExist(findTestObject('Android/orders/orderDetailsScreen/verificationDetails/zeroLinesInThisOrder_TextView'),  0)
		Mobile.verifyElementExist(findTestObject('Android/orders/orderDetailsScreen/verificationDetails/orderNameInHeader_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/orderDetailsScreen/verificationDetails/Scan_Icon'),0)
		Mobile.verifyElementAttributeValue(findTestObject('Android/orders/orderDetailsScreen/uploadOrder/Upload Order_Button'), 'enabled', 'false', 0)
		Mobile.verifyElementAttributeValue(findTestObject('Android/orders/orderDetailsScreen/placeOrder/placeOrder_Button'), 'enabled', 'false', 0)
	}

	/**
	 * verifies the order value after adding a product
	 * @param quantity (quantity which was added)
	 */
	@Keyword
	def verifyOrderValue(quantity) {
		String productCost=Mobile.getText(findTestObject('Android/orders/verificationDetails/productCost_TextView'), 0)
		String removeCharctersInProductCost = (new androidCommonKeywords.commonMethods()).removeCharctersInString(productCost)
		float productCostFloatValue = (new androidCommonKeywords.commonMethods()).stringToFloatConversion(removeCharctersInProductCost)
		float totalCost=quantity*productCostFloatValue
		String expectedOrderTotal = (new androidCommonKeywords.commonMethods()).floatToStringConversionAndFormatting(totalCost)
		String OrderTotal = Mobile.getText(findTestObject('Android/orders/verificationDetails/orderTotalCost_TextView'), 0)
		String actualOrderTotal = (new androidCommonKeywords.commonMethods()).removeCharctersInString(OrderTotal)
		assert expectedOrderTotal == actualOrderTotal
	}

	/**
	 * verifies place order confirmation pop up
	 */
	@Keyword
	def verifyPlaceOrderPopUp() {
		Mobile.verifyElementExist(findTestObject('Android/orders/orderDetailsScreen/placeOrder/goBackAndReviewMyOrder_Button'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/orderDetailsScreen/placeOrder/goToDashboard_Button'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/orderDetailsScreen/placeOrder/placeMyOrder_Button'), 0)
	}

	/**
	 * this function verifies the product after search
	 */
	@Keyword
	def verifyProductAfterSearch() {
		Mobile.verifyElementExist(findTestObject('Android/orders/productInfo/productSearch/NDC_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/productDetails/productDescriptionLabel_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/productDetails/UOIcost_Text'), 0)
		Mobile.verifyElementExist(findTestObject('Android/productSearch/Quantity_TextField'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/productInfo/productSearch/manufacturer__TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/productInfo/productSearch/alternates_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/productInfo/productSearch/addToOrder_Button'), 0)
	}

	/**
	 * this function verifies the product details page
	 * @param orderNameInSearchPage (order name of the product)
	 */
	@Keyword
	def verifyProductDetailAfterSelectingMoreDetails(String orderNameInSearchPage){
		String orderNameInProductDetailsPage=Mobile.getText(findTestObject('Android/orders/productInfo/productDetails/orderName_TextView'), 0)
		assert orderNameInSearchPage== orderNameInProductDetailsPage
		Mobile.verifyElementExist(findTestObject('Android/orders/c2OrderDetailsScreen/uploadC2Order/c2label_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/productInfo/productDetails/productSize_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/productInfo/productDetails/NDC_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/productInfo/productDetails/UOI_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/productInfo/productDetails/stockStatus_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/productInfo/productDetails/returnableStatus_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/productInfo/productDetails/quantityTextField_EditText'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/productInfo/productDetails/increaseCount_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/productInfo/productDetails/strength_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/productInfo/productDetails/form_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/productInfo/productDetails/UPC_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/productInfo/productDetails/CIN_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/productInfo/productDetails/contractAlias_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/productInfo/productDetails/retailPrice_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/productInfo/productDetails/CIN_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/productInfo/productDetails/date_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/productInfo/productSearch/addToOrder_Button'), 0)
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
	 * verifies that the added top most product should  be visible on the order details page
	 * @param productname (top most added product name)
	 */
	@Keyword
	def verifyProductNameIsVisibleUnderOrderDetails(String productname) {
		Mobile.verifyElementVisible(findTestObject('Android/orders/orderDetailsScreen/verificationDetails/productName_TextView',[('TEXT'):productname]),0)
	}

	/**
	 * this function verifies the product tile
	 */
	@Keyword
	def verifyProductTile() {
		Mobile.verifyElementExist(findTestObject('Android/orders/productInfo/productSearch/CIN_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/productInfo/productSearch/UPC__TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/productInfo/productSearch/retailPrice__TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/productInfo/productSearch/moreDetails__TextView'), 0)
	}

	/**
	 * verifies quantity updated caption
	 */
	@Keyword
	def verifyQuantityUpdatedCaption() {
		Mobile.verifyElementExist(findTestObject('Android/orders/orderDetailsScreen/verificationDetails/quantityUpdated_TextView'), 0)
	}

	/**
	 * verifies the pop up which appears after user clicks on upload order
	 */
	@Keyword
	def verifyUploadOrderPopUp() {
		Mobile.verifyElementExist(findTestObject('Android/orders/orderDetailsScreen/uploadOrder/continueOrderOnTheDesktop_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/orderDetailsScreen/uploadOrder/Continue On Desktop_Button'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/orderDetailsScreen/uploadOrder/cancelAndKeepOrderOnTheApp_Button'), 0)
	}
}