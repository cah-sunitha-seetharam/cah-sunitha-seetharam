
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import java.lang.String

import java.util.Stack

import com.applitools.eyes.selenium.Eyes

import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.TestObject

import com.applitools.eyes.RectangleSize



def static "androidDashboard.dashboardDetailsScreen.change_Account"(
    	String new_Account	) {
    (new androidDashboard.dashboardDetailsScreen()).change_Account(
        	new_Account)
}


def static "androidDashboard.dashboardDetailsScreen.Adding_Product_from_Dashboard_To_Cart"(
    	String Product_Name	
     , 	String Quantity	) {
    (new androidDashboard.dashboardDetailsScreen()).Adding_Product_from_Dashboard_To_Cart(
        	Product_Name
         , 	Quantity)
}

 /**
	 * opens orders tab where user can perform actions related to orders
	 */ 
def static "androidDashboard.dashboardDetailsScreen.clickOnOrders"() {
    (new androidDashboard.dashboardDetailsScreen()).clickOnOrders()
}


def static "androidDashboard.dashboardDetailsScreen.click_On_HomeTab"() {
    (new androidDashboard.dashboardDetailsScreen()).click_On_HomeTab()
}


def static "androidDashboard.dashboardDetailsScreen.click_On_More_Options"() {
    (new androidDashboard.dashboardDetailsScreen()).click_On_More_Options()
}

 /**
	 * this method closes the popUp screen by tapping on close, cancel button
	 * @param testobj (reference of the close, cancel button)
	 */ 
def static "iosCommonKeywords.commonMethods.closePopUpScreen"(
    	Object testobj	) {
    (new iosCommonKeywords.commonMethods()).closePopUpScreen(
        	testobj)
}

 /**
	 * float value generator
	 * @param stringToBeConvertedToFloatValue 
	 * returns float value for a string by removing characters
	 */ 
def static "iosCommonKeywords.commonMethods.floatValueGenerator"(
    	String stringToBeConvertedToFloatValue	) {
    (new iosCommonKeywords.commonMethods()).floatValueGenerator(
        	stringToBeConvertedToFloatValue)
}

 /**
	 * this method will take the application one screen back
	 */ 
def static "iosCommonKeywords.commonMethods.goOneScreenBack"() {
    (new iosCommonKeywords.commonMethods()).goOneScreenBack()
}

 /**
	 * installs as well as launches the application
	 * @param iOS_App_Path (Application path will be taken from the global profile and passed as a parameter to this method)
	 */ 
def static "iosCommonKeywords.commonMethods.installingAndlaunchingTheApplication"() {
    (new iosCommonKeywords.commonMethods()).installingAndlaunchingTheApplication()
}

 /**
	 * generates the coordinate x for a test object by considering ElementLeftPosition and ElementWidth
	 * @param testObj (reference of the testObject passed as a parameter), text(name of the element)
	 * returns int value for the xCoordinate
	 */ 
def static "iosCommonKeywords.commonMethods.tapXCoordinateGenerator"(
    	String testObj	) {
    (new iosCommonKeywords.commonMethods()).tapXCoordinateGenerator(
        	testObj)
}

 /**
	 * generates the coordinate y for a test object by considering ElementTopPosition and ElementHeight
	 * @param testObj (reference of the testObject passed as a parameter), text(name of the element)
	 * returns int value for the yCoordinate
	 */ 
def static "iosCommonKeywords.commonMethods.tapYCoordinateGenerator"(
    	String testObj	
     , 	String text	) {
    (new iosCommonKeywords.commonMethods()).tapYCoordinateGenerator(
        	testObj
         , 	text)
}

 /**
	 * this method verifies the popUp screen is visible
	 * @param testobj (reference of the popUp screen object under verification)
	 */ 
def static "iosCommonKeywords.commonMethods.verifyPopUpScreenExist"(
    	Object testobj	) {
    (new iosCommonKeywords.commonMethods()).verifyPopUpScreenExist(
        	testobj)
}

 /**
	 * verifies that the latest added product is at the top of the added products list, then deletes the latest added product and continues the process to verifyReverseChronologicalOrder of the added products
	 * @param productNDC (parameter is the stack of ndcNumbers of the added products)
	 */ 
def static "iosCommonKeywords.commonMethods.verifyReverseChronologicalOrder"(
    	Stack productNdcStack	) {
    (new iosCommonKeywords.commonMethods()).verifyReverseChronologicalOrder(
        	productNdcStack)
}

 /**
	 * refreshes the screen by doing a vertical swipe by considering the deviceHeight and deviceWidth
	 */ 
def static "iosCommonKeywords.commonMethods.verticalSwipeForRefresh"() {
    (new iosCommonKeywords.commonMethods()).verticalSwipeForRefresh()
}

 /**
	 * waits until the progressBar is visible on the screen, which will have a maximum waitLimit to be visible on the screen
	 */ 
def static "iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible"() {
    (new iosCommonKeywords.commonMethods()).waitForProgressBarToBeInvisible()
}

 /**
	 * waits until the object is visible on the screen, which will have a maximum waitLimit to be visible on the screen
	 * @param testObj (reference of the test Object),waitTime (time by which delay will be added in(s)),waitLimit (maximum limit of time for which delay can be added)
	 */ 
def static "iosCommonKeywords.commonMethods.waitTimeForObjectToBeVisible"(
    	Object testObj	
     , 	int waitTime	
     , 	int waitLimit	) {
    (new iosCommonKeywords.commonMethods()).waitTimeForObjectToBeVisible(
        	testObj
         , 	waitTime
         , 	waitLimit)
}


def static "androidOrders.newOrderScreen.change_Account"(
    	String New_Account	) {
    (new androidOrders.newOrderScreen()).change_Account(
        	New_Account)
}


def static "androidOrders.newOrderScreen.enter_Purchase_Order_Details"(
    	String PO_Name	
     , 	String PO_Memo	) {
    (new androidOrders.newOrderScreen()).enter_Purchase_Order_Details(
        	PO_Name
         , 	PO_Memo)
}

 /**
	 * taps on create order button to create an order
	 */ 
def static "androidOrders.newOrderScreen.createOrder"() {
    (new androidOrders.newOrderScreen()).createOrder()
}


def static "androidOrders.newOrderScreen.click_On_NewOrder"() {
    (new androidOrders.newOrderScreen()).click_On_NewOrder()
}


def static "androidOrders.newOrderScreen.verify_NewOrder_Screen_Details"() {
    (new androidOrders.newOrderScreen()).verify_NewOrder_Screen_Details()
}

 /**
	 * takes user to new order screen where user can input purchase order details and can create an order
	 */ 
def static "iosOrders.ordersCommonScreen.clickOnNewOrder"() {
    (new iosOrders.ordersCommonScreen()).clickOnNewOrder()
}


def static "iosOrders.ordersCommonScreen.clickOnHistoryTab"() {
    (new iosOrders.ordersCommonScreen()).clickOnHistoryTab()
}


def static "iosOrders.ordersCommonScreen.clickOnCartTab"() {
    (new iosOrders.ordersCommonScreen()).clickOnCartTab()
}

 /**
	 * this function gets the total added quantity of the product
	 * @return quantityNumericalValue (of the product which has been added)
	 */ 
def static "iosOrders.orderDetailsScreen.returnQuantityOfTheAddedProduct"() {
    (new iosOrders.orderDetailsScreen()).returnQuantityOfTheAddedProduct()
}


def static "iosOrders.orderDetailsScreen.add_Alternate_Product"(
    	String product_Name	
     , 	String quantity	) {
    (new iosOrders.orderDetailsScreen()).add_Alternate_Product(
        	product_Name
         , 	quantity)
}

 /**
	 * searches for a product by setting product name and quantity as the input
	 * @param productName (product to be added), quantity (total quantity required to be added)
	 */ 
def static "iosOrders.orderDetailsScreen.addProductToOrder"(
    	String productName	
     , 	String quantity	) {
    (new iosOrders.orderDetailsScreen()).addProductToOrder(
        	productName
         , 	quantity)
}

 /**
	 * this function adds the quantity for the product to be searched
	 * @param quantity (quantity required to be added for the product to be searched)
	 */ 
def static "iosOrders.orderDetailsScreen.addQuantityforTheSearchedProduct"(
    	String quantity	) {
    (new iosOrders.orderDetailsScreen()).addQuantityforTheSearchedProduct(
        	quantity)
}

 /**
	 * clicks on c2 order availability and waits for the response while verifying the availability details for the c2 product
	 */ 
def static "iosOrders.orderDetailsScreen.checkC2OrderAvailability"() {
    (new iosOrders.orderDetailsScreen()).checkC2OrderAvailability()
}

 /**
	 * takes user back to cart screen and verifies user is on the cart screen
	 */ 
def static "iosOrders.orderDetailsScreen.clickOnBackToCart"() {
    (new iosOrders.orderDetailsScreen()).clickOnBackToCart()
}

 /**
	 * takes user back to the search product results to continue browsing
	 */ 
def static "iosOrders.orderDetailsScreen.clickOnContinueOrderingOnDesktop"() {
    (new iosOrders.orderDetailsScreen()).clickOnContinueOrderingOnDesktop()
}

 /**
	 * taps on scan icon and takes user to scanning product screen and also verifies that the default toggle is at ordering
	 */ 
def static "iosOrders.orderDetailsScreen.clickOnScanIcon"() {
    (new iosOrders.orderDetailsScreen()).clickOnScanIcon()
}

 /**
	 * creates a new C2 order 
	 * @param poName (poName of the order), poMemo (poMemo of the order)
	 */ 
def static "iosOrders.orderDetailsScreen.createNewC2Order"(
    	String poName	
     , 	String poMemo	) {
    (new iosOrders.orderDetailsScreen()).createNewC2Order(
        	poName
         , 	poMemo)
}


def static "iosOrders.orderDetailsScreen.edit_PO_Name_and_Memo"(
    	String po_Name	
     , 	String po_Memo	) {
    (new iosOrders.orderDetailsScreen()).edit_PO_Name_and_Memo(
        	po_Name
         , 	po_Memo)
}

 /**
	 * clicks on place order button
	 */ 
def static "iosOrders.orderDetailsScreen.placeOrder"() {
    (new iosOrders.orderDetailsScreen()).placeOrder()
}

 /**
	 * scans the product and adds it to the location
	 * @param productToBeSearched (name which can be a productName/Cin/NDC of the product to be added)
	 */ 
def static "iosOrders.orderDetailsScreen.scanInputEvent"(
    	String productToBeSearched	) {
    (new iosOrders.orderDetailsScreen()).scanInputEvent(
        	productToBeSearched)
}

 /**
	 * this function selects toggle value for the product to be added which can be ordering or price check)
	 * @param toggleValue (toggleValue required to be selected for the product to be added which can be ordering or price check)
	 */ 
def static "iosOrders.orderDetailsScreen.selectToggleValueForTheProductToBeSearched"(
    	String toggleValue	) {
    (new iosOrders.orderDetailsScreen()).selectToggleValueForTheProductToBeSearched(
        	toggleValue)
}

 /**
	 * uploads the order by clicking on upload order button
	 */ 
def static "iosOrders.orderDetailsScreen.uploadOrder"() {
    (new iosOrders.orderDetailsScreen()).uploadOrder()
}

 /**
	 * verifies the pop up which appears after user clicks on upload order
	 */ 
def static "iosOrders.orderDetailsScreen.verifyUploadOrderPopUp"() {
    (new iosOrders.orderDetailsScreen()).verifyUploadOrderPopUp()
}


def static "iosOrders.orderDetailsScreen.verify_Order_Details_Screen_Details_with_added_product"() {
    (new iosOrders.orderDetailsScreen()).verify_Order_Details_Screen_Details_with_added_product()
}

 /**
	 * verifies order details screen when user creates an order
	 */ 
def static "iosOrders.orderDetailsScreen.verifyOrderDetailsScreenWithoutAnyAddedProduct"(
    	Object poName	) {
    (new iosOrders.orderDetailsScreen()).verifyOrderDetailsScreenWithoutAnyAddedProduct(
        	poName)
}

 /**
	 * selects the user account from the accounts list and takes user to the dashboard screen
	 * @param accountNo (user account number to be selected)
	 */ 
def static "androidAccountSelection.selectAnAccount.selectTheUserAccount"(
    	String accountNo	) {
    (new androidAccountSelection.selectAnAccount()).selectTheUserAccount(
        	accountNo)
}

 /**
	 * performs login function by selecting environment of testing(taken from the global profile), entering user-name and password
	 * @param username (it is taken from the global profile but passed as a parameter),password  (it is taken from the global profile but passed as a parameter)
	 */ 
def static "androidLogin.loginScreen.login"(
    	Object username	
     , 	Object password	) {
    (new androidLogin.loginScreen()).login(
        	username
         , 	password)
}

 /**
	 * selects the environment of testing which is taken from the global profile
	 */ 
def static "androidLogin.loginScreen.selectEnvironment"() {
    (new androidLogin.loginScreen()).selectEnvironment()
}

 /**
	 * enters the user-name
	 * @param username (it is taken from the global profile but passed as a parameter)
	 */ 
def static "androidLogin.loginScreen.enterUsername"(
    	String username	) {
    (new androidLogin.loginScreen()).enterUsername(
        	username)
}

 /**
	 * enters the password
	 * @param password (it is taken from the global profile but passed as a parameter)
	 */ 
def static "androidLogin.loginScreen.enterPassword"(
    	String password	) {
    (new androidLogin.loginScreen()).enterPassword(
        	password)
}

 /**
	 * clicks on signIn button and takes to the dash-board of the application
	 */ 
def static "androidLogin.loginScreen.clickOnSignInButton"() {
    (new androidLogin.loginScreen()).clickOnSignInButton()
}

 /**
	 * clicks on forget password button
	 */ 
def static "androidLogin.loginScreen.clickOnForgotPassword"() {
    (new androidLogin.loginScreen()).clickOnForgotPassword()
}

 /**
	 * verifies the details of login Page
	 */ 
def static "androidLogin.loginScreen.verifyLoginPageDetails"() {
    (new androidLogin.loginScreen()).verifyLoginPageDetails()
}


def static "iosOrders.cartScreen.cancelUploadAndKeepOrdersOnTheApp"() {
    (new iosOrders.cartScreen()).cancelUploadAndKeepOrdersOnTheApp()
}


def static "iosOrders.cartScreen.clickOnBackToCart"() {
    (new iosOrders.cartScreen()).clickOnBackToCart()
}


def static "iosOrders.cartScreen.clickOnC2Orders"() {
    (new iosOrders.cartScreen()).clickOnC2Orders()
}


def static "iosOrders.cartScreen.clickOnPlaceAllOrders"() {
    (new iosOrders.cartScreen()).clickOnPlaceAllOrders()
}


def static "iosOrders.cartScreen.confirmPlacingAllOrders"() {
    (new iosOrders.cartScreen()).confirmPlacingAllOrders()
}


def static "iosOrders.cartScreen.continueOrdersOnTheDesktop"() {
    (new iosOrders.cartScreen()).continueOrdersOnTheDesktop()
}


def static "iosOrders.cartScreen.delete_Order"(
    	String Account_No	) {
    (new iosOrders.cartScreen()).delete_Order(
        	Account_No)
}


def static "iosOrders.cartScreen.goBackToReviewAllOrders"() {
    (new iosOrders.cartScreen()).goBackToReviewAllOrders()
}


def static "iosOrders.cartScreen.goToDashboard"() {
    (new iosOrders.cartScreen()).goToDashboard()
}


def static "iosOrders.cartScreen.openAnOrderDetails"(
    	String accountNo	) {
    (new iosOrders.cartScreen()).openAnOrderDetails(
        	accountNo)
}


def static "iosOrders.cartScreen.openC2OrderDetails"() {
    (new iosOrders.cartScreen()).openC2OrderDetails()
}


def static "iosOrders.cartScreen.uploadAllOrders"() {
    (new iosOrders.cartScreen()).uploadAllOrders()
}


def static "iosOrders.cartScreen.verify_Cart_Screen_Details_with_Added_Product"() {
    (new iosOrders.cartScreen()).verify_Cart_Screen_Details_with_Added_Product()
}


def static "iosOrders.cartScreen.verify_Cart_Screen_Details_without_Adding_any_Product"() {
    (new iosOrders.cartScreen()).verify_Cart_Screen_Details_without_Adding_any_Product()
}


def static "iosOrders.cartScreen.verifyOrderNotVisibleOnTheCartScreen"(
    	String poName	) {
    (new iosOrders.cartScreen()).verifyOrderNotVisibleOnTheCartScreen(
        	poName)
}


def static "iosOrders.cartScreen.verifyPlaceAllOrdersPopUp"() {
    (new iosOrders.cartScreen()).verifyPlaceAllOrdersPopUp()
}


def static "iosOrders.cartScreen.verifyUploadAllOrdersPopUp"() {
    (new iosOrders.cartScreen()).verifyUploadAllOrdersPopUp()
}

 /**
	 * adds products to a location
	 * @param locationName (name of the location),productName (name of the product to be added)
	 */ 
def static "iosInventory.locationDetailsScreen.add_Product_to_Location"(
    	String locationName	
     , 	String productName	) {
    (new iosInventory.locationDetailsScreen()).add_Product_to_Location(
        	locationName
         , 	productName)
}

 /**
	 * this function taps on remove button and then product entry should get removed from the location as well as the scan result screen
	 */ 
def static "iosInventory.locationDetailsScreen.clickOnRemoveButtonToRemoveAlreadyScannedProduct"() {
    (new iosInventory.locationDetailsScreen()).clickOnRemoveButtonToRemoveAlreadyScannedProduct()
}

 /**
	 * taps on scan and adds product based on count type of partial or full count
	 * @param productName (name of the product to be added),countType (count type required which can be partial or full count),quantity (quantity of the product required to be added)
	 */ 
def static "iosInventory.locationDetailsScreen.clickOnScanIconAndAddProduct"(
    	String productName	
     , 	String countType	
     , 	String quantity	) {
    (new iosInventory.locationDetailsScreen()).clickOnScanIconAndAddProduct(
        	productName
         , 	countType
         , 	quantity)
}

 /**
	 * copies products to another location
	 * @param locationName (name of the location to which product will be copied)
	 */ 
def static "iosInventory.locationDetailsScreen.copy_Product_to_Another_Location"(
    	String locationName	) {
    (new iosInventory.locationDetailsScreen()).copy_Product_to_Another_Location(
        	locationName)
}

 /**
	 * deletes a product from the added products list in a location
	 * @param ndcNumber (deletes the product according to the ndcNumber)
	 */ 
def static "iosInventory.locationDetailsScreen.deleteProduct"(
    	String ndcNumber	) {
    (new iosInventory.locationDetailsScreen()).deleteProduct(
        	ndcNumber)
}

 /**
	 * edits the location name and cost type can be changed(last price or current price paid)
	 * @param newLocationName (new name of the location),costType (cost type required which can be current or last price paid)
	 */ 
def static "iosInventory.locationDetailsScreen.edit_Location_Name"(
    	String newLocationName	
     , 	String costType	) {
    (new iosInventory.locationDetailsScreen()).edit_Location_Name(
        	newLocationName
         , 	costType)
}

 /**
	 * moves products to another location
	 * @param locationName (name of the location to which product will be moved)
	 */ 
def static "iosInventory.locationDetailsScreen.move_Product_to_Another_Location"(
    	String locationName	) {
    (new iosInventory.locationDetailsScreen()).move_Product_to_Another_Location(
        	locationName)
}

 /**
	 * this function gets the total added quantity of the product
	 * @return quantity of the product which has been added
	 */ 
def static "iosInventory.locationDetailsScreen.returnQuantityOfTheAddedProduct"() {
    (new iosInventory.locationDetailsScreen()).returnQuantityOfTheAddedProduct()
}

 /**
	 * taps on shares location button, verifies the pop-up screen and closes the pop-up screen
	 */ 
def static "iosInventory.locationDetailsScreen.verifyShareLocationPopUp"() {
    (new iosInventory.locationDetailsScreen()).verifyShareLocationPopUp()
}

 /**
	 * uploads location from the location details screen
	 */ 
def static "iosInventory.locationDetailsScreen.uploadLocation"() {
    (new iosInventory.locationDetailsScreen()).uploadLocation()
}

 /**
	 * verifies details of location details screen
	 * @param locationName (name of the location under verification)
	 */ 
def static "iosInventory.locationDetailsScreen.verifyLocationDetailsScreen"(
    	String locationName	) {
    (new iosInventory.locationDetailsScreen()).verifyLocationDetailsScreen(
        	locationName)
}

 /**
	 * this function verifies that the product is not visible on the location details screen
	 * @param ndcNumber (ndcNumber of the product which should not be present on the screen)
	 */ 
def static "iosInventory.locationDetailsScreen.verifyProductIsNotVisibleOnTheLocationDetailsScreen"(
    	Object ndcNumber	) {
    (new iosInventory.locationDetailsScreen()).verifyProductIsNotVisibleOnTheLocationDetailsScreen(
        	ndcNumber)
}

 /**
	 * this function verifies that the product is visible on the location details screen
	 * @param ndcNumber (ndcNumber of the product which should be present on the screen)
	 */ 
def static "iosInventory.locationDetailsScreen.verifyProductIsVisibleOnTheLocationDetailsScreen"(
    	Object ndcNumber	) {
    (new iosInventory.locationDetailsScreen()).verifyProductIsVisibleOnTheLocationDetailsScreen(
        	ndcNumber)
}

 /**
	 * performs login function by selecting the type of testing (automation or manual), environment of testing(taken from the global profile), entering user-name and password
	 * @param username (it is taken from the global profile but passed as a parameter),password  (it is taken from the global profile but passed as a parameter)
	 */ 
def static "iosLogin.loginScreen.login"(
    	Object username	
     , 	Object password	) {
    (new iosLogin.loginScreen()).login(
        	username
         , 	password)
}

 /**
	 * selects the environment of testing which is taken from the global profile
	 */ 
def static "iosLogin.loginScreen.selectEnvironment"() {
    (new iosLogin.loginScreen()).selectEnvironment()
}

 /**
	 * selects type of testing which can be manual or automation
	 * @param testingType (directly passed as a parameter for automation)
	 */ 
def static "iosLogin.loginScreen.selectTypeOfTesting"(
    	String testingType	) {
    (new iosLogin.loginScreen()).selectTypeOfTesting(
        	testingType)
}

 /**
	 * enters the user-name
	 * @param username (it is taken from the global profile but passed as a parameter)
	 */ 
def static "iosLogin.loginScreen.enterUsername"(
    	String username	) {
    (new iosLogin.loginScreen()).enterUsername(
        	username)
}

 /**
	 * enters the password
	 * @param password (it is taken from the global profile but passed as a parameter)
	 */ 
def static "iosLogin.loginScreen.enterPassword"(
    	String password	) {
    (new iosLogin.loginScreen()).enterPassword(
        	password)
}

 /**
	 * clicks on signIn button and takes to the dash-board of the application
	 */ 
def static "iosLogin.loginScreen.clickOnSignInButton"() {
    (new iosLogin.loginScreen()).clickOnSignInButton()
}

 /**
	 * clicks on forget password button
	 */ 
def static "iosLogin.loginScreen.clickOnForgotPassword"() {
    (new iosLogin.loginScreen()).clickOnForgotPassword()
}

 /**
	 * verifies the details of login Page
	 */ 
def static "iosLogin.loginScreen.verifyLoginPageDetails"() {
    (new iosLogin.loginScreen()).verifyLoginPageDetails()
}


def static "iosLogin.loginScreen.selectTypeOfTesting"() {
    (new iosLogin.loginScreen()).selectTypeOfTesting()
}


def static "androidOrders.orderDetailsScreen.upload_Order"() {
    (new androidOrders.orderDetailsScreen()).upload_Order()
}


def static "androidOrders.orderDetailsScreen.placeOrder"() {
    (new androidOrders.orderDetailsScreen()).placeOrder()
}

 /**
	 * takes user back to cart
	 */ 
def static "androidOrders.orderDetailsScreen.clickOnBackToCart"() {
    (new androidOrders.orderDetailsScreen()).clickOnBackToCart()
}

 /**
	 * creates a new C2 order
	 * @param poName (poName of the order), poMemo (poMemo of the order)
	 */ 
def static "androidOrders.orderDetailsScreen.createNewC2Order"(
    	String poName	
     , 	String poMemo	) {
    (new androidOrders.orderDetailsScreen()).createNewC2Order(
        	poName
         , 	poMemo)
}

 /**
	 * clicks on c2 order availability and waits for the response while verifying the availability details for the c2 product
	 */ 
def static "androidOrders.orderDetailsScreen.checkC2ProductAvailability"() {
    (new androidOrders.orderDetailsScreen()).checkC2ProductAvailability()
}

 /**
	 * searches for a product by setting product name and quantity as the input
	 * @param productName (product to be added), quantity (total quantity required to be added)
	 */ 
def static "androidOrders.orderDetailsScreen.addProductToOrder"(
    	String productName	
     , 	String quantity	) {
    (new androidOrders.orderDetailsScreen()).addProductToOrder(
        	productName
         , 	quantity)
}

 /**
	 * takes user back to the search product results to continue browsing
	 */ 
def static "androidOrders.orderDetailsScreen.clickOnContinueOrdering"() {
    (new androidOrders.orderDetailsScreen()).clickOnContinueOrdering()
}


def static "androidOrders.orderDetailsScreen.edit_PO_Name_and_Memo"(
    	String PO_Name	
     , 	String PO_Memo	
     , 	String New_po_Name	
     , 	String New_po_Memo	) {
    (new androidOrders.orderDetailsScreen()).edit_PO_Name_and_Memo(
        	PO_Name
         , 	PO_Memo
         , 	New_po_Name
         , 	New_po_Memo)
}


def static "androidOrders.orderDetailsScreen.add_ALternate_Product"(
    	String Product_Name	
     , 	String Quantity	) {
    (new androidOrders.orderDetailsScreen()).add_ALternate_Product(
        	Product_Name
         , 	Quantity)
}


def static "androidOrders.orderDetailsScreen.verify_Order_Screen_Details_without_any_added_product"() {
    (new androidOrders.orderDetailsScreen()).verify_Order_Screen_Details_without_any_added_product()
}


def static "androidOrders.orderDetailsScreen.verify_Order_Screen_Details_with_added_product"() {
    (new androidOrders.orderDetailsScreen()).verify_Order_Screen_Details_with_added_product()
}

 /**
	 * adds location to an inventory based on the cost type of current or last price paid
	 * @param locationName (name of the location to be added), costType (cost type required which can be current or last price paid)
	 */ 
def static "iosInventory.inventoryDetailsScreen.addLocation"(
    	String locationName	
     , 	String costType	) {
    (new iosInventory.inventoryDetailsScreen()).addLocation(
        	locationName
         , 	costType)
}

 /**
	 * opens the particular location details
	 * @param locationName (name of the location)
	 */ 
def static "iosInventory.inventoryDetailsScreen.clickOnALocation"(
    	String locationName	) {
    (new iosInventory.inventoryDetailsScreen()).clickOnALocation(
        	locationName)
}

 /**
	 * searches and adds the product from the inventory details screen by creating a new location
	 * @param locationName (name of the location to be created),productName (name of the product to be added),countType (count type required which can be partial or full count),quantity (quantity of the product required to be added), costType(cost type required which can be current or last price paid)
	 */ 
def static "iosInventory.inventoryDetailsScreen.clickOnScanIconAndAddProductByCreatingNewLocationViaInventoryDetailsScreen"(
    	String locationName	
     , 	String productName	
     , 	String countType	
     , 	String quantity	
     , 	String costType	) {
    (new iosInventory.inventoryDetailsScreen()).clickOnScanIconAndAddProductByCreatingNewLocationViaInventoryDetailsScreen(
        	locationName
         , 	productName
         , 	countType
         , 	quantity
         , 	costType)
}

 /**
	 * deletes the location
	 * @param locationName (name of the location to be deleted)
	 */ 
def static "iosInventory.inventoryDetailsScreen.deleteLocation"(
    	String locationName	) {
    (new iosInventory.inventoryDetailsScreen()).deleteLocation(
        	locationName)
}

 /**
	 * verifies the location count, cost gets updated or not, of the inventory after the location is deleted
	 * @param locationName (name of the location under verification)
	 */ 
def static "iosInventory.inventoryDetailsScreen.deleteLocationWithCostLocationCountVerification"(
    	String locationName	) {
    (new iosInventory.inventoryDetailsScreen()).deleteLocationWithCostLocationCountVerification(
        	locationName)
}

 /**
	 * edits the inventory name
	 * @param newInventoryName (new name of the inventory)
	 */ 
def static "iosInventory.inventoryDetailsScreen.edit_InventoryName"(
    	String newInventoryName	) {
    (new iosInventory.inventoryDetailsScreen()).edit_InventoryName(
        	newInventoryName)
}

 /**
	 * searches and adds the product from the inventory details screen by creating a new location
	 * @param locationName (name of the location to be created),productName (name of the product to be added),costType (cost type required which can be current or last price paid)
	 */ 
def static "iosInventory.inventoryDetailsScreen.search_And_Add_Product_By_Creating_New_Location"(
    	String locationName	
     , 	String productName	
     , 	String costType	) {
    (new iosInventory.inventoryDetailsScreen()).search_And_Add_Product_By_Creating_New_Location(
        	locationName
         , 	productName
         , 	costType)
}

 /**
	 * verifies various details of the inventory details screen
	 * @param inventoryName (name of the inventory which is under verification)
	 */ 
def static "iosInventory.inventoryDetailsScreen.verify_Inventory_Details_Screen"(
    	String inventoryName	) {
    (new iosInventory.inventoryDetailsScreen()).verify_Inventory_Details_Screen(
        	inventoryName)
}

 /**
	 * selects the user account from the accounts list and takes user to the dashboard screen
	 * @param accountNo (user account number to be selected)
	 */ 
def static "iosAccountSelection.selectAnAccount.selectTheUserAccount"(
    	String accountNo	) {
    (new iosAccountSelection.selectAnAccount()).selectTheUserAccount(
        	accountNo)
}

 /**
	 * opens the c2 order details, verifies the order status labels and signIns the password required for placing c2 order
	 * @param password (password-which is required for placing the c2 order)
	 */ 
def static "androidOrders.historyScreen.clickOnC2OrderForReviewAndSign"(
    	String signingPassword	) {
    (new androidOrders.historyScreen()).clickOnC2OrderForReviewAndSign(
        	signingPassword)
}


def static "androidOrders.historyScreen.verify_History_Screen_Details"() {
    (new androidOrders.historyScreen()).verify_History_Screen_Details()
}

 /**
	 * switches the account of user to another account
	 * @param accountNo (accountNo which needs to be selected will be passed as a parameter)
	 */ 
def static "android_more_options.moreOptionsScreen.changeAccount"(
    	Object accountNo	) {
    (new android_more_options.moreOptionsScreen()).changeAccount(
        	accountNo)
}

 /**
	 * takes the user from the the moreOptions Screen to inventory listing screen
	 */ 
def static "android_more_options.moreOptionsScreen.goToInventoryListingScreen"() {
    (new android_more_options.moreOptionsScreen()).goToInventoryListingScreen()
}

 /**
	 * clicks on moreOptions tab, signsOut the user and takes user to the logInScreen
	 */ 
def static "android_more_options.moreOptionsScreen.signOut"() {
    (new android_more_options.moreOptionsScreen()).signOut()
}


def static "android_inventory.Inventory_details_Screen.add_Location"(
    	String Location_Name	
     , 	String CostType	) {
    (new android_inventory.Inventory_details_Screen()).add_Location(
        	Location_Name
         , 	CostType)
}


def static "android_inventory.Inventory_details_Screen.edit_InventoryName"(
    	String New_Inventory_Name	
     , 	String Previous_Name	) {
    (new android_inventory.Inventory_details_Screen()).edit_InventoryName(
        	New_Inventory_Name
         , 	Previous_Name)
}


def static "android_inventory.Inventory_details_Screen.click_On_Location"(
    	String Location_Name	) {
    (new android_inventory.Inventory_details_Screen()).click_On_Location(
        	Location_Name)
}


def static "android_inventory.Inventory_details_Screen.delete_Location"(
    	String Location_Name	) {
    (new android_inventory.Inventory_details_Screen()).delete_Location(
        	Location_Name)
}


def static "android_inventory.Inventory_details_Screen.search_And_Add_Product_By_Creating_New_Location"(
    	String Location_Name	
     , 	String Product_Name	
     , 	String CostType	) {
    (new android_inventory.Inventory_details_Screen()).search_And_Add_Product_By_Creating_New_Location(
        	Location_Name
         , 	Product_Name
         , 	CostType)
}


def static "android_inventory.Inventory_details_Screen.verify_Inventory_Details_Screen"(
    	String Inventory_Name	) {
    (new android_inventory.Inventory_details_Screen()).verify_Inventory_Details_Screen(
        	Inventory_Name)
}


def static "iosOrders.newOrderScreen.change_Account"(
    	String new_Account	) {
    (new iosOrders.newOrderScreen()).change_Account(
        	new_Account)
}


def static "iosOrders.newOrderScreen.enterPurchaseOrderDetails"(
    	String poName	
     , 	String poMemo	) {
    (new iosOrders.newOrderScreen()).enterPurchaseOrderDetails(
        	poName
         , 	poMemo)
}


def static "iosOrders.newOrderScreen.createOrder"() {
    (new iosOrders.newOrderScreen()).createOrder()
}


def static "iosOrders.newOrderScreen.verify_NewOrder_Screen_Details"() {
    (new iosOrders.newOrderScreen()).verify_NewOrder_Screen_Details()
}

 /**
	 * opens orders tab where user can perform actions related to orders
	 */ 
def static "iosDashboard.dashboardDetailsScreen.clickOnOrders"() {
    (new iosDashboard.dashboardDetailsScreen()).clickOnOrders()
}

 /**
	 * opens home tab
	 */ 
def static "iosDashboard.dashboardDetailsScreen.click_On_HomeTab"() {
    (new iosDashboard.dashboardDetailsScreen()).click_On_HomeTab()
}

 /**
	 * opens moreOptions tab where user can perform actions like signOut, goToInventoryListing Screen etc
	 */ 
def static "iosDashboard.dashboardDetailsScreen.clickOnMoreOptionsTab"() {
    (new iosDashboard.dashboardDetailsScreen()).clickOnMoreOptionsTab()
}

 /**
	 * changes the account
	 * @param newAccount
	 */ 
def static "iosDashboard.dashboardDetailsScreen.Change_Account"(
    	String newAccount	) {
    (new iosDashboard.dashboardDetailsScreen()).Change_Account(
        	newAccount)
}

 /**
	 * adds the product from dashboard
	 * @param productName,quantity
	 */ 
def static "iosDashboard.dashboardDetailsScreen.Adding_Product_from_Dashboard_To_Cart"(
    	String productName	
     , 	String quantity	) {
    (new iosDashboard.dashboardDetailsScreen()).Adding_Product_from_Dashboard_To_Cart(
        	productName
         , 	quantity)
}

 /**
	 * switches to another user account
	 * @param newAccount (account no to which the user should switch)
	 */ 
def static "iosInventory.inventoryListingScreen.changeAccount"(
    	String account	) {
    (new iosInventory.inventoryListingScreen()).changeAccount(
        	account)
}

 /**
	 * opens the particular inventory details
	 * @param inventoryName (name which was given to the inventory)
	 */ 
def static "iosInventory.inventoryListingScreen.click_On_Inventory"(
    	String inventoryName	) {
    (new iosInventory.inventoryListingScreen()).click_On_Inventory(
        	inventoryName)
}

 /**
	 * creates a new inventory from inventory listing screen
	 * @param inventoryName (name required for the new inventory)
	 */ 
def static "iosInventory.inventoryListingScreen.createInventory"(
    	String inventoryName	) {
    (new iosInventory.inventoryListingScreen()).createInventory(
        	inventoryName)
}

 /**
	 * deletes the inventory from the inventory listing screen
	 * @param inventoryName (inventory name of the inventory which needs to be deleted)
	 */ 
def static "iosInventory.inventoryListingScreen.deleteInventory"(
    	String inventoryName	) {
    (new iosInventory.inventoryListingScreen()).deleteInventory(
        	inventoryName)
}

 /**
	 * verifies details of inventory listing screen
	 */ 
def static "iosInventory.inventoryListingScreen.verify_Inventory_Listing_Screen"() {
    (new iosInventory.inventoryListingScreen()).verify_Inventory_Listing_Screen()
}

 /**
	 * opens the inventory listing screen from moreOptions Screen
	 */ 
def static "iosMoreOptions.moreOptionsScreen.goToInventoryListingScreen"() {
    (new iosMoreOptions.moreOptionsScreen()).goToInventoryListingScreen()
}

 /**
	 * clicks on moreOptions tab, signsOut the user and takes user to the logInScreen
	 */ 
def static "iosMoreOptions.moreOptionsScreen.signOut"() {
    (new iosMoreOptions.moreOptionsScreen()).signOut()
}


def static "iosOrders.historyScreen.verify_History_Screen_Details"() {
    (new iosOrders.historyScreen()).verify_History_Screen_Details()
}

 /**
	 * opens the c2 order details, verifies the order status labels and signIns the password required for placing c2 order
	 * @param password (password-which is required for placing the c2 order)
	 */ 
def static "iosOrders.historyScreen.clickOnC2OrderForReviewAndSign"(
    	String signingPassword	) {
    (new iosOrders.historyScreen()).clickOnC2OrderForReviewAndSign(
        	signingPassword)
}


def static "android_inventory.Inventory_listing_Screen.delete_Inventory"(
    	String inventory_Name	) {
    (new android_inventory.Inventory_listing_Screen()).delete_Inventory(
        	inventory_Name)
}


def static "android_inventory.Inventory_listing_Screen.change_Account"(
    	String new_Account	) {
    (new android_inventory.Inventory_listing_Screen()).change_Account(
        	new_Account)
}


def static "android_inventory.Inventory_listing_Screen.create_Inventory"(
    	String Inventory_Name	) {
    (new android_inventory.Inventory_listing_Screen()).create_Inventory(
        	Inventory_Name)
}


def static "android_inventory.Inventory_listing_Screen.verify_Inventory_Listing_Screen"() {
    (new android_inventory.Inventory_listing_Screen()).verify_Inventory_Listing_Screen()
}

 /**
	 * takes user to the new order screen
	 */ 
def static "androidOrders.ordersCommonScreen.clickOnNewOrder"() {
    (new androidOrders.ordersCommonScreen()).clickOnNewOrder()
}


def static "androidOrders.ordersCommonScreen.clickOnHistoryTab"() {
    (new androidOrders.ordersCommonScreen()).clickOnHistoryTab()
}


def static "androidOrders.ordersCommonScreen.click_On_Cart_Tab"() {
    (new androidOrders.ordersCommonScreen()).click_On_Cart_Tab()
}


def static "androidOrders.ordersCommonScreen.change_Account"(
    	String new_Account	) {
    (new androidOrders.ordersCommonScreen()).change_Account(
        	new_Account)
}


def static "android_inventory.Location_details_Screen.edit_LocationName"(
    	String New_Location_Name	
     , 	String CostType	
     , 	String Previous_Name	) {
    (new android_inventory.Location_details_Screen()).edit_LocationName(
        	New_Location_Name
         , 	CostType
         , 	Previous_Name)
}


def static "android_inventory.Location_details_Screen.add_Product_To_Location"(
    	String Location_Name	
     , 	String Product_Name	) {
    (new android_inventory.Location_details_Screen()).add_Product_To_Location(
        	Location_Name
         , 	Product_Name)
}


def static "android_inventory.Location_details_Screen.move_Product_To_Another_Location"(
    	String Location_Name	) {
    (new android_inventory.Location_details_Screen()).move_Product_To_Another_Location(
        	Location_Name)
}


def static "android_inventory.Location_details_Screen.copy_Product_To_Another_Location"(
    	String Location_Name	) {
    (new android_inventory.Location_details_Screen()).copy_Product_To_Another_Location(
        	Location_Name)
}


def static "android_inventory.Location_details_Screen.delete_Product"() {
    (new android_inventory.Location_details_Screen()).delete_Product()
}


def static "android_inventory.Location_details_Screen.upload_Location"() {
    (new android_inventory.Location_details_Screen()).upload_Location()
}


def static "android_inventory.Location_details_Screen.share_Location"() {
    (new android_inventory.Location_details_Screen()).share_Location()
}


def static "android_inventory.Location_details_Screen.verify_Location_details_Screen"(
    	String Location_Name	) {
    (new android_inventory.Location_details_Screen()).verify_Location_details_Screen(
        	Location_Name)
}

 /**
	 * random alpha numeric String Generator 
	 * @param length, required string length 
	 * @return alpha-numeric string  
	 */ 
def static "common.commonMethods.randomStringGenerator"(
    	int length	) {
    (new common.commonMethods()).randomStringGenerator(
        	length)
}

 /**
	 * Read JSON file 
	 * @param file name, Note: data files are considered to be on Data files location on project directory  
	 * @return the JSON file object 
	 */ 
def static "common.commonMethods.readFileTypeJSON"(
    	String fileNameValue	) {
    (new common.commonMethods()).readFileTypeJSON(
        	fileNameValue)
}

 /**
	 * opens the order details page
	 * @param accountNo (accountNo used to create the order)
	 */ 
def static "androidOrders.cartScreen.openAnOrderDetails"(
    	String accountNo	) {
    (new androidOrders.cartScreen()).openAnOrderDetails(
        	accountNo)
}

 /**
	 * opens the c2 orders tab
	 */ 
def static "androidOrders.cartScreen.clickOnC2OrdersTab"() {
    (new androidOrders.cartScreen()).clickOnC2OrdersTab()
}

 /**
	 * opens the c2 order details
	 * @param accountNo (account no which was used to create the order)
	 */ 
def static "androidOrders.cartScreen.openC2OrderDetailScreen"(
    	String accountNo	) {
    (new androidOrders.cartScreen()).openC2OrderDetailScreen(
        	accountNo)
}


def static "androidOrders.cartScreen.delete_Order"(
    	Object Account_No	) {
    (new androidOrders.cartScreen()).delete_Order(
        	Account_No)
}


def static "androidOrders.cartScreen.upload_All_Orders"() {
    (new androidOrders.cartScreen()).upload_All_Orders()
}


def static "androidOrders.cartScreen.place_All_Orders"() {
    (new androidOrders.cartScreen()).place_All_Orders()
}


def static "androidOrders.cartScreen.verify_Cart_Screen_Details_with_Added_Product"() {
    (new androidOrders.cartScreen()).verify_Cart_Screen_Details_with_Added_Product()
}


def static "androidOrders.cartScreen.verify_Cart_Screen_Details_without_Adding_any_Product"() {
    (new androidOrders.cartScreen()).verify_Cart_Screen_Details_without_Adding_any_Product()
}

 /**
	 * this method will take the application one screen back
	 */ 
def static "androidCommonKeywords.commonMethods.goOneScreenBack"() {
    (new androidCommonKeywords.commonMethods()).goOneScreenBack()
}

 /**
	 * installs as well as launches the application
	 */ 
def static "androidCommonKeywords.commonMethods.installingAndlaunchingTheApplication"() {
    (new androidCommonKeywords.commonMethods()).installingAndlaunchingTheApplication()
}

 /**
	 * refreshes the screen by doing a vertical swipe by considering the deviceHeight and deviceWidth
	 */ 
def static "androidCommonKeywords.commonMethods.verticalSwipeForRefresh"() {
    (new androidCommonKeywords.commonMethods()).verticalSwipeForRefresh()
}

 /**
	 * waits until the progressBar is visible on the screen, which will have a maximum waitLimit to be visible on the screen
	 */ 
def static "androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible"() {
    (new androidCommonKeywords.commonMethods()).waitForProgressBarToBeInvisible()
}

 /**
	 * waits until the object is visible on the screen, which will have a maximum waitLimit to be visible on the screen
	 * @param testObj (reference of the test Object),waitTime (time by which delay will be added in(s)),waitLimit (maximum limit of time for which delay can be added)
	 */ 
def static "androidCommonKeywords.commonMethods.waitTimeForObjectToBeVisible"(
    	Object testObj	
     , 	int waitTime	
     , 	int waitLimit	) {
    (new androidCommonKeywords.commonMethods()).waitTimeForObjectToBeVisible(
        	testObj
         , 	waitTime
         , 	waitLimit)
}

 /**
	 * Create an order using Carts Post method , the input is fetched from the (module) ordersDatajson file set on Data Files 
	 * @return an object with orderId and purchaseOrderNumber 
	 */ 
def static "api.apiCommonMethods.createCartOrder"() {
    (new api.apiCommonMethods()).createCartOrder()
}

 /**
	 * Send login and token generation calls(based on environment value fetched from profile, to get authorization token
	 * @return authorizationValue fetched from token generator API 
	 */ 
def static "api.apiCommonMethods.fetchAccessToken"() {
    (new api.apiCommonMethods()).fetchAccessToken()
}

 /**
	 * Fetches the API test data file from project Data files path
	 * @param expectedStatusCode
	 * @return the test data JSON object
	 */ 
def static "api.apiCommonMethods.readAPITestData"() {
    (new api.apiCommonMethods()).readAPITestData()
}

 /**
	 * Send token generation calls to get authorization token
	 * @param environmentValue referring to test data object key e.g.pmodStage
	 * @return the access token value 
	 */ 
def static "api.apiCommonMethods.tokenGenerator"() {
    (new api.apiCommonMethods()).tokenGenerator()
}


def static "com.kms.katalon.keyword.applitools.BasicKeywords.checkElement"(
    	Eyes eyes	
     , 	WebElement element	) {
    (new com.kms.katalon.keyword.applitools.BasicKeywords()).checkElement(
        	eyes
         , 	element)
}


def static "com.kms.katalon.keyword.applitools.BasicKeywords.checkWindow"(
    	String testName	) {
    (new com.kms.katalon.keyword.applitools.BasicKeywords()).checkWindow(
        	testName)
}


def static "com.kms.katalon.keyword.applitools.BasicKeywords.checkTestObject"(
    	TestObject testObject	
     , 	String testName	) {
    (new com.kms.katalon.keyword.applitools.BasicKeywords()).checkTestObject(
        	testObject
         , 	testName)
}


def static "com.kms.katalon.keyword.applitools.EyesKeywords.eyesInit"() {
    (new com.kms.katalon.keyword.applitools.EyesKeywords()).eyesInit()
}


def static "com.kms.katalon.keyword.applitools.EyesKeywords.eyesOpen"(
    	String testName	
     , 	RectangleSize viewportSize	) {
    (new com.kms.katalon.keyword.applitools.EyesKeywords()).eyesOpen(
        	testName
         , 	viewportSize)
}


def static "com.kms.katalon.keyword.applitools.EyesKeywords.eyesOpenWithBaseline"(
    	String baselineName	
     , 	String testName	
     , 	RectangleSize viewportSize	) {
    (new com.kms.katalon.keyword.applitools.EyesKeywords()).eyesOpenWithBaseline(
        	baselineName
         , 	testName
         , 	viewportSize)
}


def static "com.kms.katalon.keyword.applitools.EyesKeywords.eyesClose"(
    	Eyes eyes	) {
    (new com.kms.katalon.keyword.applitools.EyesKeywords()).eyesClose(
        	eyes)
}
