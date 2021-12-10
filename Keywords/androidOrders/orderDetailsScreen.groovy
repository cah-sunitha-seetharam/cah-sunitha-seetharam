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

	@Keyword
	def upload_Order() {

		Mobile.tap(findTestObject('Android/Orders/Order Details Screen/Upload Order/Upload Order_button'), 0)

		Mobile.tap(findTestObject('Android/Orders/Order Details Screen/Upload Order/Continue On Desktop_button'), 0)
	}



	@Keyword
	def placeOrder() {

		Mobile.tap(findTestObject('Android/Orders/Order Details Screen/Place Order/Place Order_Button'), 0, )

		Mobile.tap(findTestObject('Android/Orders/Order Details Screen/Place Order/Place My Order_Button'), 0)
	}



	/**
	 * takes user back to cart
	 */
	@Keyword
	def clickOnBackToCart() {

		Mobile.tap(findTestObject('Android/Orders/Order Details Screen/Upload Order/Back to Cart_button'), 0)
	}
	
	
	/**
	 * taps on scan icon and takes user to scanning product screen and also verifies that the default toggle is at ordering
	 */
	@Keyword
	def clickOnScanIcon() {

		Mobile.tap(findTestObject('Android/Orders/Order Details Screen/Scan Order/scan_Icon'), 0)

		Mobile.verifyElementAttributeValue(findTestObject('Android/Orders/Order Details Screen/Scan Order/ordering_Text'), 'text', 'Ordering', 0)

		Mobile.verifyElementAttributeValue(findTestObject('Android/Orders/Order Details Screen/Scan Order/priceCheck_Text'), 'text', 'Price Check', 0)
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
	 * this function adds the quantity for the product to be searched
	 * @param quantity (quantity required to be added for the product to be searched)
	 */
	
	@Keyword
	def addQuantityforTheSearchedProduct(String quantity) {

//		Mobile.setText(findTestObject('Android/Orders/Order Details Screen/Scan Order/quantityTextField_EditText'), quantity, 0)
		Mobile.tap(findTestObject('Android/Orders/Order Details Screen/Scan Order/moreOperator.ImageView'), 0)

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

		Mobile.tapAndHold(findTestObject('Android/Orders/Order Details Screen/Scan Order/android.widget.Button - Upload Order'), 0, 0)

	}
	
	
	/**
	 * takes user back to the search product results to continue browsing
	 */
	@Keyword
	def clickOnContinueOrderingOnDesktop() {

		Mobile.tap(findTestObject('Android/Orders/Order Details Screen/Scan Order/android.widget.Button - Continue On Desktop'), 0)
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
	 * clicks on c2 order availability and waits for the response while verifying the availability details for the c2 product
	 */
	@Keyword()
	def checkC2ProductAvailability() {

		Mobile.tap(findTestObject('Android/Orders/C2 Order Details Screen/Place C2 Order/checkAvailability_Button'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/C2 Order Details Screen/Place C2 Order/oneMoment_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/C2 Order Details Screen/Place C2 Order/weNeedJustAMinuteToEnsureThatWeHaveEverythingInStock_TextView'), 0)
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
	 * takes user back to the search product results to continue browsing
	 */
	@Keyword
	def clickOnContinueOrdering() {

		Mobile.tap(findTestObject('Android/Product Search/Continue Ordering_Button') ,0)
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



	@Keyword
	def verify_Order_Screen_Details_without_any_added_product() {

		Mobile.verifyElementExist(findTestObject('Android/Orders/Order Details Screen/Verification Details/Nothing to see here_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/Order Details Screen/Verification Details/Search products and add them to this order_TextView'),  0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/Order Details Screen/Verification Details/0 lines in this order_TextView'),  0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/Order Details Screen/Verification Details/Order_Name_Header'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/Order Details Screen/Verification Details/Scan_Icon'),0)
	}


	@Keyword
	def verify_Order_Screen_Details_with_added_product() {

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
}