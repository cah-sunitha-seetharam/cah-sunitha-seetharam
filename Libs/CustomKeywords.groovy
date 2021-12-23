
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import java.lang.String

import java.util.Stack

import java.lang.Float

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

 /**
	 * opens home tab where user can perform actions related to home
	 */ 
def static "androidDashboard.dashboardDetailsScreen.clickOnHomeTab"() {
    (new androidDashboard.dashboardDetailsScreen()).clickOnHomeTab()
}

 /**
	 * opens more options tab where user can perform actions related to more options
	 */ 
def static "androidDashboard.dashboardDetailsScreen.clickOnMoreOptions"() {
    (new androidDashboard.dashboardDetailsScreen()).clickOnMoreOptions()
}

 /**
	 * opens moreOptions tab where user can perform actions like signOut, goToInventoryListing Screen etc
	 */ 
def static "androidDashboard.dashboardDetailsScreen.clickOnMoreOptionsTab"() {
    (new androidDashboard.dashboardDetailsScreen()).clickOnMoreOptionsTab()
}

 /**
	 * deletes the inventory from the inventory listing screen
	 * @param inventoryName (inventory name of the inventory which needs to be deleted)
	 */ 
def static "androidInventory.inventoryListingScreen.deleteInventory"(
    	String inventoryName	) {
    (new androidInventory.inventoryListingScreen()).deleteInventory(
        	inventoryName)
}

 /**
	 * switches to another user account
	 * @param newAccount (account no to which the user should switch)
	 */ 
def static "androidInventory.inventoryListingScreen.change_Account"(
    	String new_Account	) {
    (new androidInventory.inventoryListingScreen()).change_Account(
        	new_Account)
}

 /**
	 * creates a new inventory from inventory listing screen
	 * @param inventoryName (name required for the new inventory)
	 */ 
def static "androidInventory.inventoryListingScreen.createInventory"(
    	String inventoryName	) {
    (new androidInventory.inventoryListingScreen()).createInventory(
        	inventoryName)
}

 /**
	 * verifies details of inventory listing screen
	 */ 
def static "androidInventory.inventoryListingScreen.verify_Inventory_Listing_Screen"() {
    (new androidInventory.inventoryListingScreen()).verify_Inventory_Listing_Screen()
}

 /**
	 * clicks on more options, takes to beat features and enables it
	 */ 
def static "iosCommonKeywords.commonMethods.enableBetaFeatures"() {
    (new iosCommonKeywords.commonMethods()).enableBetaFeatures()
}

 /**
	 * clicks on product search field
	 */ 
def static "iosCommonKeywords.commonMethods.clickOnProductSearchTextField"() {
    (new iosCommonKeywords.commonMethods()).clickOnProductSearchTextField()
}

 /**
	 * clicks on Search Key of the keypad
	 */ 
def static "iosCommonKeywords.commonMethods.clickOnSearchKey"() {
    (new iosCommonKeywords.commonMethods()).clickOnSearchKey()
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
	 * this function returns the cost of added product
	 * @return productCost_dollarSymbolRemoved_FloatValue (of the product which has been added)
	 */ 
def static "iosCommonKeywords.commonMethods.returnCostOfTheAddedProduct"(
    	String testObj	) {
    (new iosCommonKeywords.commonMethods()).returnCostOfTheAddedProduct(
        	testObj)
}

 /**
	 * this function returns the total expected value of the added product
	 * @return productCost_dollarSymbolRemoved_FloatValue (of the product which has been added)
	 */ 
def static "iosCommonKeywords.commonMethods.returnExpectedTotalValueForAddedProduct"(
    	Object quantity	
     , 	Object costOfProduct	) {
    (new iosCommonKeywords.commonMethods()).returnExpectedTotalValueForAddedProduct(
        	quantity
         , 	costOfProduct)
}

 /**
	 * inputs the product search which can be name/Cin/UPC/NDC in the product search-field
	 * @param productSearch (which can be name/Cin/UPC/NDC in the product search-field)
	 */ 
def static "iosCommonKeywords.commonMethods.enterProductInSearchField"(
    	Object productSearch	) {
    (new iosCommonKeywords.commonMethods()).enterProductInSearchField(
        	productSearch)
}

 /**
	 * this method will take the application one screen back
	 */ 
def static "iosCommonKeywords.commonMethods.goOneScreenBack"() {
    (new iosCommonKeywords.commonMethods()).goOneScreenBack()
}

 /**
	 * installs as well as launches the application
	 */ 
def static "iosCommonKeywords.commonMethods.installingAndlaunchingTheApplication"() {
    (new iosCommonKeywords.commonMethods()).installingAndlaunchingTheApplication()
}

 /**
	 * performs basic text management operations:Copy,Cut,Paste,Share
	 * @param operationToBePerformed (in operationToBePerformed argument all alphabets should be lower-case except the first one for e.g Copy, Cut)
	 */ 
def static "iosCommonKeywords.commonMethods.performBasicTextManagementOperation"(
    	String operationToBePerformed	) {
    (new iosCommonKeywords.commonMethods()).performBasicTextManagementOperation(
        	operationToBePerformed)
}

 /**
	 * opens the inventory listing screen by firstly clicking on more options from dash-board 
	 * and then clicks on inventory under more options screen which takes user to inventory listing screen
	 */ 
def static "iosCommonKeywords.commonMethods.takeUserFromHomeToInventoryListingScreen"() {
    (new iosCommonKeywords.commonMethods()).takeUserFromHomeToInventoryListingScreen()
}

 /**
	 * performs login function by selecting the type of testing (automation or manual), environment of testing(taken from the global profile), entering user-name and password
	 * and then selects the user account from the accounts list and takes user to the dash-board screen
	 * @param username
	 * @param password
	 * @param accountNo
	 */ 
def static "iosCommonKeywords.commonMethods.takeUserFromloginToHomeScreen"(
    	Object username	
     , 	Object password	
     , 	Object accountNo	) {
    (new iosCommonKeywords.commonMethods()).takeUserFromloginToHomeScreen(
        	username
         , 	password
         , 	accountNo)
}

 /**
	 * generates the coordinate x for a test object by considering ElementLeftPosition and ElementWidth
	 * @param testObj (reference of the testObject passed as a parameter)
	 * @param text (name of the element)
	 * @return int value for the xCoordinate
	 */ 
def static "iosCommonKeywords.commonMethods.tapXCoordinateGenerator"(
    	String testObj	) {
    (new iosCommonKeywords.commonMethods()).tapXCoordinateGenerator(
        	testObj)
}

 /**
	 * generates the coordinate y for a test object by considering ElementTopPosition and ElementHeight
	 * @param testObj (reference of the testObject passed as a parameter)
	 * @param text (name of the element)
	 * @return int value for the yCoordinate
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
	 * this function verifies that the product is not visible on the screen
	 * @param productIdentificationNumber (productIdentificationNumber of the product which can be NDC/Cin/UPC, which should be present on the screen)
	 * @param testObj (test object of the element under verification)
	 */ 
def static "iosCommonKeywords.commonMethods.verifyProductIsNotVisibleOnTheScreen"(
    	Object testObj	
     , 	Object productIdentificationNumber	) {
    (new iosCommonKeywords.commonMethods()).verifyProductIsNotVisibleOnTheScreen(
        	testObj
         , 	productIdentificationNumber)
}

 /**
	 * this function verifies that the product is visible on the screen
	 * @param productIdentificationNumber (productIdentificationNumber of the product which can be NDC/Cin/UPC, which should be present on the screen)
	 * @param testObj (test object of the element under verification)
	 */ 
def static "iosCommonKeywords.commonMethods.verifyProductIsVisibleOnTheScreen"(
    	Object testObj	
     , 	Object productIdentificationNumber	) {
    (new iosCommonKeywords.commonMethods()).verifyProductIsVisibleOnTheScreen(
        	testObj
         , 	productIdentificationNumber)
}

 /**
	 * refreshes the screen by doing a vertical swipe by considering the deviceHeight and deviceWidth
	 */ 
def static "iosCommonKeywords.commonMethods.verticalSwipeForRefresh"() {
    (new iosCommonKeywords.commonMethods()).verticalSwipeForRefresh()
}

 /**
	 * this function verifies that the product is visible on the product search screen after search
	 * @param productNdcNumber (using NDC of the product which is visible on the product tab)
	 * if in future upc/cin are visible then the method can be modified accordingly by passing the respective test object
	 */ 
def static "iosCommonKeywords.commonMethods.verifyProductIsVisibleOnTheProductSearchScreen"(
    	Object productNdcNumber	) {
    (new iosCommonKeywords.commonMethods()).verifyProductIsVisibleOnTheProductSearchScreen(
        	productNdcNumber)
}

 /**
	 * waits until the progressBar is visible on the screen, which will have a maximum waitLimit to be visible on the screen
	 */ 
def static "iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible"() {
    (new iosCommonKeywords.commonMethods()).waitForProgressBarToBeInvisible()
}

 /**
	 * waits until the object is visible on the screen, which will have a maximum waitLimit to be visible on the screen
	 * @param testObj (reference of the test Object)
	 * @param waitTime (time by which delay will be added in(s))
	 * @param waitLimit (maximum limit of time for which delay can be added)
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

 /**
	 * changes the user account
	 * @param newAccount
	 */ 
def static "iosCommonKeywords.commonMethods.changeAccount"(
    	String newAccount	) {
    (new iosCommonKeywords.commonMethods()).changeAccount(
        	newAccount)
}

 /**
	 * verifies whether the selected user account is same as the account required
	 * @param expectedAccountNo (expected user account no)
	 */ 
def static "iosCommonKeywords.commonMethods.verifySelectedAccount"(
    	String expectedAccountNo	) {
    (new iosCommonKeywords.commonMethods()).verifySelectedAccount(
        	expectedAccountNo)
}


def static "androidOrders.newOrderScreen.change_Account"(
    	String New_Account	) {
    (new androidOrders.newOrderScreen()).change_Account(
        	New_Account)
}

 /**
	 * adds poname pomemo to textfield
	 * @param PO_Name (purchase order name for the order created)
	 * @param PO_Memo (purchase order Memo for the order created)
	 */ 
def static "androidOrders.newOrderScreen.enterPurchaseOrderDetails"(
    	String PO_Name	
     , 	String PO_Memo	) {
    (new androidOrders.newOrderScreen()).enterPurchaseOrderDetails(
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

 /**
	 * verifies new order screen
	 */ 
def static "androidOrders.newOrderScreen.verifyNewOrderScreenAccount"() {
    (new androidOrders.newOrderScreen()).verifyNewOrderScreenAccount()
}

 /**
	 * verifies new order screen
	 */ 
def static "androidOrders.newOrderScreen.verifyNewOrderScreenDetails"() {
    (new androidOrders.newOrderScreen()).verifyNewOrderScreenDetails()
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
	 * deletes all orders from nonc2 and c2 order tab
	 */ 
def static "iosOrders.ordersCommonScreen.clearAllOrders"() {
    (new iosOrders.ordersCommonScreen()).clearAllOrders()
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
	 * takes user back to cart screen and verifies user is on the cart screen or not
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

 /**
	 * edits the order details which are purchase order name and memo
	 * @param poName (new poName of the order)
	 * @param poMemo (new poMemo of the order)
	 */ 
def static "iosOrders.orderDetailsScreen.editPONameAndMemo"(
    	String poName	
     , 	String poMemo	) {
    (new iosOrders.orderDetailsScreen()).editPONameAndMemo(
        	poName
         , 	poMemo)
}

 /**
	 * clicks on place order button
	 */ 
def static "iosOrders.orderDetailsScreen.placeOrder"() {
    (new iosOrders.orderDetailsScreen()).placeOrder()
}

 /**
	 * this function returns the order value
	 * @return orderTotal_dollarSymbolRemoved_FloatValue (order total value)
	 */ 
def static "iosOrders.orderDetailsScreen.returnOrderValue"() {
    (new iosOrders.orderDetailsScreen()).returnOrderValue()
}

 /**
	 * this function gets the total added quantity of the product
	 * @return quantityNumericalValue (of the product which has been added)
	 */ 
def static "iosOrders.orderDetailsScreen.returnQuantityOfTheAddedProduct"() {
    (new iosOrders.orderDetailsScreen()).returnQuantityOfTheAddedProduct()
}

 /**
	 * scans the product, adds it to the order and also verifies some scan input details when 'ordering' toggle is selected
	 * @param productToBeSearched (name which can be a productName/Cin/NDC of the product to be added)
	 */ 
def static "iosOrders.orderDetailsScreen.scanInputEvent"(
    	String productToBeSearched	) {
    (new iosOrders.orderDetailsScreen()).scanInputEvent(
        	productToBeSearched)
}

 /**
	 * scans the product, adds it to the order and also verifies some scan input details when 'price check' toggle is selected
	 * @param productToBeSearched (name which can be a productName/Cin/NDC of the product to be added)
	 */ 
def static "iosOrders.orderDetailsScreen.scanInputEventWhileOnPriceCheck"(
    	String productToBeSearched	) {
    (new iosOrders.orderDetailsScreen()).scanInputEventWhileOnPriceCheck(
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
	 * uploads the c2 order by clicking on upload order button
	 */ 
def static "iosOrders.orderDetailsScreen.uploadC2Order"() {
    (new iosOrders.orderDetailsScreen()).uploadC2Order()
}

 /**
	 * uploads the order by clicking on upload order button and verifies upload order button gets disabled after uploading
	 */ 
def static "iosOrders.orderDetailsScreen.uploadOrder"() {
    (new iosOrders.orderDetailsScreen()).uploadOrder()
}

 /**
	 * verifies c2 label is visible or not
	 */ 
def static "iosOrders.orderDetailsScreen.verifyC2Label"() {
    (new iosOrders.orderDetailsScreen()).verifyC2Label()
}

 /**
	 * takes productSearch and expected lines count as the arguments and verifies the same
	 * @param expectedLinesCount (expected lines count after adding product to an order)
	 * @param productNdcNumber (using NDC of the product which is visible on the product tab)
	 * if in future upc/cin are visible then the method can be modified accordingly by passing the respective test object	 */ 
def static "iosOrders.orderDetailsScreen.verifyOrderDetailsScreenAfterAddingAProduct"(
    	String productNdcNumber	
     , 	String expectedLinesCount	) {
    (new iosOrders.orderDetailsScreen()).verifyOrderDetailsScreenAfterAddingAProduct(
        	productNdcNumber
         , 	expectedLinesCount)
}

 /**
	 * takes user to dash-board
	 */ 
def static "iosOrders.orderDetailsScreen.goToDashboard"() {
    (new iosOrders.orderDetailsScreen()).goToDashboard()
}

 /**
	 * this function returns the cost of added product
	 * @return productCost (of the product which has been added)
	 */ 
def static "iosOrders.orderDetailsScreen.returnCostOfTheAddedProduct"() {
    (new iosOrders.orderDetailsScreen()).returnCostOfTheAddedProduct()
}

 /**
	 * verifies order details screen when user creates an order
	 * @param poName (purchase order name)
	 */ 
def static "iosOrders.orderDetailsScreen.verifyOrderDetailsScreenWithoutAnyAddedProduct"(
    	Object poName	) {
    (new iosOrders.orderDetailsScreen()).verifyOrderDetailsScreenWithoutAnyAddedProduct(
        	poName)
}

 /**
	 * verifies the order value after adding a product
	 * @param quantity (quantity which was added)
	 */ 
def static "iosOrders.orderDetailsScreen.verifyOrderValue"(
    	Object quantity	) {
    (new iosOrders.orderDetailsScreen()).verifyOrderValue(
        	quantity)
}

 /**
	 * this function verifies that the product is visible on the order details screen
	 * @param productNdcNumber (using NDC of the product which is visible on the product tab)
	 * if in future upc/cin are visible then the method can be modified accordingly by passing the respective test object
	 */ 
def static "iosOrders.orderDetailsScreen.verifyProductIsVisibleOnTheOrderDetailsScreen"(
    	Object productNdcNumber	) {
    (new iosOrders.orderDetailsScreen()).verifyProductIsVisibleOnTheOrderDetailsScreen(
        	productNdcNumber)
}

 /**
	 * verifies the pop up which appears after user clicks on upload order
	 */ 
def static "iosOrders.orderDetailsScreen.verifyUploadOrderPopUp"() {
    (new iosOrders.orderDetailsScreen()).verifyUploadOrderPopUp()
}

 /**
	 * this function adds the product to be ordered - when price check toggle is selected
	 * @param quantity (quantity required to be added for the product to be searched)
	 */ 
def static "iosOrders.orderDetailsScreen.addToOrder"() {
    (new iosOrders.orderDetailsScreen()).addToOrder()
}

 /**
	 * taps on go to order button on order confirmation screen and takes user to order details screen
	 */ 
def static "iosOrders.orderDetailsScreen.clickOnGoToOrder"() {
    (new iosOrders.orderDetailsScreen()).clickOnGoToOrder()
}

 /**
	 * taps on continue browsing button on order confirmation screen and takes user to scan result screen
	 */ 
def static "iosOrders.orderDetailsScreen.clickOnContinueBrowsing"() {
    (new iosOrders.orderDetailsScreen()).clickOnContinueBrowsing()
}

 /**
	 * verified user is taken to scan result screen after tapping on continue browsing button
	 */ 
def static "iosOrders.orderDetailsScreen.verifyScanResultScreenWithProduct"() {
    (new iosOrders.orderDetailsScreen()).verifyScanResultScreenWithProduct()
}

 /**
	 * this function returns the order name of the order/ title of the screen when user is on order details screen
	 * return orderName (returns order name/ title of order details screen)
	 */ 
def static "iosOrders.orderDetailsScreen.returnOrderNameFromOrderDetailScreen"() {
    (new iosOrders.orderDetailsScreen()).returnOrderNameFromOrderDetailScreen()
}

 /**
	 * enable EO mode by long pressing the account text/icon displayed on screen and then closes the opened fly-out
	 */ 
def static "androidCommonKeywords.emergencyOrderingMode.enableEOmodeAndCloseFlyout"() {
    (new androidCommonKeywords.emergencyOrderingMode()).enableEOmodeAndCloseFlyout()
}

 /**
	 * enable/disable EO mode by long pressing the account text/icon displayed on screen
	 */ 
def static "androidCommonKeywords.emergencyOrderingMode.enableOrDisableEOmode"() {
    (new androidCommonKeywords.emergencyOrderingMode()).enableOrDisableEOmode()
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

 /**
	 * cancels uploading of orders and keeps orders on the application
	 */ 
def static "iosOrders.cartScreen.cancelUploadAndKeepOrdersOnTheApp"() {
    (new iosOrders.cartScreen()).cancelUploadAndKeepOrdersOnTheApp()
}

 /**
	 * takes user back to cart screen and verifies user is on the cart screen
	 */ 
def static "iosOrders.cartScreen.clickOnBackToCart"() {
    (new iosOrders.cartScreen()).clickOnBackToCart()
}

 /**
	 * opens the c2 orders tab
	 */ 
def static "iosOrders.cartScreen.clickOnC2Orders"() {
    (new iosOrders.cartScreen()).clickOnC2Orders()
}

 /**
	 * opens the non c2 orders tab
	 */ 
def static "iosOrders.cartScreen.clickOnNonC2Orders"() {
    (new iosOrders.cartScreen()).clickOnNonC2Orders()
}

 /**
	 * clicks on all place all orders button on cart screen
	 */ 
def static "iosOrders.cartScreen.clickOnPlaceAllOrders"() {
    (new iosOrders.cartScreen()).clickOnPlaceAllOrders()
}

 /**
	 * confirms placing all order by clicking on place all orders confirmation button and verifies details related to placed order
	 */ 
def static "iosOrders.cartScreen.confirmPlacingAllOrders"() {
    (new iosOrders.cartScreen()).confirmPlacingAllOrders()
}

 /**
	 * clicks on continue orders on the desktop and verifies popUp which appears after tapping on continue on desktop
	 */ 
def static "iosOrders.cartScreen.continueOrdersOnTheDesktop"() {
    (new iosOrders.cartScreen()).continueOrdersOnTheDesktop()
}

 /**
	 * delete's the order from the cart screen based on the purchase order name
	 * @param poName (purchase order name of the order)
	 */ 
def static "iosOrders.cartScreen.deleteOrder"(
    	String poName	) {
    (new iosOrders.cartScreen()).deleteOrder(
        	poName)
}

 /**
	 * delete's the C2 order from the cart screen based on the purchase order name
	 * seperate delete method for c2 as locators for c2 order tile not available...when done remove this method
	 */ 
def static "iosOrders.cartScreen.deleteC2Order"() {
    (new iosOrders.cartScreen()).deleteC2Order()
}

 /**
	 * takes user back to cart to review all orders
	 */ 
def static "iosOrders.cartScreen.goBackToReviewAllOrders"() {
    (new iosOrders.cartScreen()).goBackToReviewAllOrders()
}

 /**
	 * takes user to dash-board
	 */ 
def static "iosOrders.cartScreen.goToDashboard"() {
    (new iosOrders.cartScreen()).goToDashboard()
}

 /**
	 * opens the order details page
	 * @param poName (purchase order name used to create the order)
	 */ 
def static "iosOrders.cartScreen.openAnOrderDetail"(
    	String poName	) {
    (new iosOrders.cartScreen()).openAnOrderDetail(
        	poName)
}

 /**
	 * this function returns the order name of the order which is at the top of the order list
	 * return orderName (returns topmost order name)
	 */ 
def static "iosOrders.cartScreen.returnTopMostOrderName"() {
    (new iosOrders.cartScreen()).returnTopMostOrderName()
}

 /**
	 * this function verifies the pattern required for the order which was created without giving any purchase order name
	 * @param orderName (order name which is under verification)
	 */ 
def static "iosOrders.cartScreen.verifyOrderNamePattern"(
    	String orderName	) {
    (new iosOrders.cartScreen()).verifyOrderNamePattern(
        	orderName)
}

 /**
	 * opens the c2 order details
	 */ 
def static "iosOrders.cartScreen.openC2OrderDetails"() {
    (new iosOrders.cartScreen()).openC2OrderDetails()
}

 /**
	 * uploads all order by clicking on upload all orders button on cart screen
	 */ 
def static "iosOrders.cartScreen.uploadAllOrders"() {
    (new iosOrders.cartScreen()).uploadAllOrders()
}


def static "iosOrders.cartScreen.verifyCartScreenWithAddedProduct"() {
    (new iosOrders.cartScreen()).verifyCartScreenWithAddedProduct()
}


def static "iosOrders.cartScreen.verifyCartScreenWithoutAnyOrderPresent"() {
    (new iosOrders.cartScreen()).verifyCartScreenWithoutAnyOrderPresent()
}

 /**
	 * verifies that the created order should be visible on the cart screen
	 * @param poName (purchase order name used to create the order)
	 */ 
def static "iosOrders.cartScreen.verifyOrderIsVisibleOnTheCartScreen"(
    	String poName	) {
    (new iosOrders.cartScreen()).verifyOrderIsVisibleOnTheCartScreen(
        	poName)
}

 /**
	 * verifies that the created order should not be visible on the cart screen
	 * @param poName (purchase order name used to create the order)
	 */ 
def static "iosOrders.cartScreen.verifyOrderNotVisibleOnTheCartScreen"(
    	String poName	) {
    (new iosOrders.cartScreen()).verifyOrderNotVisibleOnTheCartScreen(
        	poName)
}

 /**
	 * takes expected lines count as the argument and verifies the same
	 * @param expectedLinesCount (expected lines count after adding products to the cart)
	 */ 
def static "iosOrders.cartScreen.verifyLinesCount"(
    	String expectedLinesCount	) {
    (new iosOrders.cartScreen()).verifyLinesCount(
        	expectedLinesCount)
}

 /**
	 * verifies the cart value after adding products
	 * @param expectedCartValue (expected cart value which should be equal to actual cart total)
	 */ 
def static "iosOrders.cartScreen.verifyCartValue"(
    	float expectedCartValue	) {
    (new iosOrders.cartScreen()).verifyCartValue(
        	expectedCartValue)
}

 /**
	 * verifies c2 orders annotation count
	 * @param expectedCount (expected annotation count)
	 */ 
def static "iosOrders.cartScreen.verifyC2OrdersTabAnnotationCount"(
    	int expectedAnnotationCount	) {
    (new iosOrders.cartScreen()).verifyC2OrdersTabAnnotationCount(
        	expectedAnnotationCount)
}

 /**
	 * taps on scan icon and takes user to scanning product screen and also verifies that the default toggle is at ordering
	 */ 
def static "iosOrders.cartScreen.clickOnScanIcon"() {
    (new iosOrders.cartScreen()).clickOnScanIcon()
}

 /**
	 * scans the product, adds it to the order and also verifies some scan input details
	 * @param productToBeSearched (name which can be a productName/Cin/NDC of the product to be added)
	 */ 
def static "iosOrders.cartScreen.scanInputEvent"(
    	String productToBeSearched	) {
    (new iosOrders.cartScreen()).scanInputEvent(
        	productToBeSearched)
}

 /**
	 * this function selects toggle value for the product to be added which can be ordering or price check)
	 * @param toggleValue (toggleValue required to be selected for the product to be added which can be ordering or price check)
	 */ 
def static "iosOrders.cartScreen.selectToggleValueForTheProductToBeSearched"(
    	String toggleValue	) {
    (new iosOrders.cartScreen()).selectToggleValueForTheProductToBeSearched(
        	toggleValue)
}

 /**
	 * verifies pop up screen which comes after clicking on place all orders button on cart screen
	 */ 
def static "iosOrders.cartScreen.verifyPlaceAllOrdersPopUp"() {
    (new iosOrders.cartScreen()).verifyPlaceAllOrdersPopUp()
}

 /**
	 * verifies pop up screen which comes after clicking on upload all orders button on cart screen
	 */ 
def static "iosOrders.cartScreen.verifyUploadAllOrdersPopUp"() {
    (new iosOrders.cartScreen()).verifyUploadAllOrdersPopUp()
}

 /**
	 * adds products to a location
	 * @param locationName (name of the location)
	 * @param productName (name of the product to be added)
	 */ 
def static "iosInventory.locationDetailsScreen.addProducttoLocation"(
    	String locationName	
     , 	String productName	
     , 	String quantity	) {
    (new iosInventory.locationDetailsScreen()).addProducttoLocation(
        	locationName
         , 	productName
         , 	quantity)
}

 /**
	 * this function inputs the quantity value for the product to be searched
	 * @param quantity (quantity required to be added for the product to be searched)
	 */ 
def static "iosInventory.locationDetailsScreen.addQuantityforTheSearchedProduct"(
    	String quantity	) {
    (new iosInventory.locationDetailsScreen()).addQuantityforTheSearchedProduct(
        	quantity)
}

 /**
	 * this function taps on remove button and then product entry should get removed from the location as well as the scan result screen
	 */ 
def static "iosInventory.locationDetailsScreen.clickOnRemoveButtonToRemoveAlreadyScannedProduct"() {
    (new iosInventory.locationDetailsScreen()).clickOnRemoveButtonToRemoveAlreadyScannedProduct()
}

 /**
	 * taps on scan icon and takes user to scanning product screen and also verifies that the default toggle is at full count
	 */ 
def static "iosInventory.locationDetailsScreen.clickOnScanIcon"() {
    (new iosInventory.locationDetailsScreen()).clickOnScanIcon()
}

 /**
	 * copies products from a location to another location
	 * @param locationName (name of the location to which product will be copied)
	 * @param productNdcNumber (using NDC of the product which is visible on the product tab)
	 * if in future upc/cin are visible then the method can be modified accordingly by passing the respective test object	 */ 
def static "iosInventory.locationDetailsScreen.copyProductToAnotherLocation"(
    	String locationName	
     , 	String productNdcNumber	) {
    (new iosInventory.locationDetailsScreen()).copyProductToAnotherLocation(
        	locationName
         , 	productNdcNumber)
}

 /**
	 * deletes a product from the added products list in a location
	 * @param productNdcNumber (using NDC of the product which is visible on the product tab)
	 * if in future upc/cin are visible then the method can be modified accordingly by passing the respective test object	 */ 
def static "iosInventory.locationDetailsScreen.deleteProduct"(
    	String productNdcNumber	) {
    (new iosInventory.locationDetailsScreen()).deleteProduct(
        	productNdcNumber)
}

 /**
	 * edits the location name and cost type can be changed(last price or current price paid)
	 * @param newLocationName (new name of the location)
	 * @param costType (cost type required which can be current or last price paid)
	 */ 
def static "iosInventory.locationDetailsScreen.editLocationName"(
    	String newLocationName	
     , 	String costType	) {
    (new iosInventory.locationDetailsScreen()).editLocationName(
        	newLocationName
         , 	costType)
}

 /**
	 * moves products from a location to another location
	 * @param locationName (name of the location to which product will be moved)
	 * @param productNdcNumber (using NDC of the product which is visible on the product tab)
	 * if in future upc/cin are visible then the method can be modified accordingly by passing the respective test object	 */ 
def static "iosInventory.locationDetailsScreen.moveProductToAnotherLocation"(
    	String locationName	
     , 	String productNdcNumber	) {
    (new iosInventory.locationDetailsScreen()).moveProductToAnotherLocation(
        	locationName
         , 	productNdcNumber)
}

 /**
	 * this function gets the total added quantity of the product
	 * @return quantityNumericalValue (of the product which has been added)
	 */ 
def static "iosInventory.locationDetailsScreen.returnQuantityOfTheAddedProduct"() {
    (new iosInventory.locationDetailsScreen()).returnQuantityOfTheAddedProduct()
}

 /**
	 * this function gets the unit of issue cost(UOI) of the added product
	 * @return uoiCost_dollarSymbolRemoved_FloatValue (of the product which has been added)
	 */ 
def static "iosInventory.locationDetailsScreen.returnUOIOfTheAddedProduct"() {
    (new iosInventory.locationDetailsScreen()).returnUOIOfTheAddedProduct()
}

 /**
	 * scans the product and adds it to the location 
	 * @param productToBeSearched (name which can be a productName/Cin/NDC of the product to be added)
	 */ 
def static "iosInventory.locationDetailsScreen.scanInputEvent"(
    	String productToBeSearched	) {
    (new iosInventory.locationDetailsScreen()).scanInputEvent(
        	productToBeSearched)
}

 /**
	 * this function selects the toggle value of countType for the product to be added 
	 * @param countType (countType required to be selected for the product to be added which can be full or partial count)
	 */ 
def static "iosInventory.locationDetailsScreen.selectCountTypeForTheProductToBeAdded"(
    	String countType	) {
    (new iosInventory.locationDetailsScreen()).selectCountTypeForTheProductToBeAdded(
        	countType)
}

 /**
	 * uploads location from the location details screen
	 */ 
def static "iosInventory.locationDetailsScreen.uploadLocation"() {
    (new iosInventory.locationDetailsScreen()).uploadLocation()
}

 /**
	 * this function gets the count type of the added product and verifies whether that is equal to the expected count type
	 */ 
def static "iosInventory.locationDetailsScreen.verifyCountTypeOfProduct"(
    	String expectedCountType	) {
    (new iosInventory.locationDetailsScreen()).verifyCountTypeOfProduct(
        	expectedCountType)
}

 /**
	 * this function verifies the lines count
	 * @param expectedLinesCount (expected lines Count)
	 */ 
def static "iosInventory.locationDetailsScreen.verifyLinesCount"(
    	String expectedLinesCount	) {
    (new iosInventory.locationDetailsScreen()).verifyLinesCount(
        	expectedLinesCount)
}

 /**
	 * verifies details of location details screen (if user wants to scan a product with same count type more than once, then in the test case, only the updated quantity along with countType and ndcNumber should be pushed into the stack)
	 * @param countTypeStack (stack of the countTypes selected for adding each product)
	 * @param quantityStack (stack of the quantity added for each product) 
	 * @param productNdcStack (stack of the ndcNumbers of added products)
	 * @param unitOfIssueCostStack (stack of UOI costs of the added products)
	 */ 
def static "iosInventory.locationDetailsScreen.verifyLocationDetailsScreen"(
    	Stack countTypeStack	
     , 	Stack quantityStack	
     , 	Stack productNdcStack	
     , 	Stack unitOfIssueCostStack	) {
    (new iosInventory.locationDetailsScreen()).verifyLocationDetailsScreen(
        	countTypeStack
         , 	quantityStack
         , 	productNdcStack
         , 	unitOfIssueCostStack)
}

 /**
	 * this function verifies that the product is visible on the location details screen
	 * @param productNdcNumber (using NDC of the product which is visible on the product tab)
	 * if in future upc/cin are visible then the method can be modified accordingly by passing the respective test object
	 */ 
def static "iosInventory.locationDetailsScreen.verifyProductIsNotVisibleOnTheLocationDetailsScreen"(
    	Object productNdcNumber	) {
    (new iosInventory.locationDetailsScreen()).verifyProductIsNotVisibleOnTheLocationDetailsScreen(
        	productNdcNumber)
}

 /**
	 * this function verifies that the product is not visible on the location details screen
	 * @param productNdcNumber (using NDC of the product which is visible on the product tab)
	 * if in future upc/cin are visible then the method can be modified accordingly by passing the respective test object
	 */ 
def static "iosInventory.locationDetailsScreen.verifyProductIsVisibleOnTheLocationDetailsScreen"(
    	Object productNdcNumber	) {
    (new iosInventory.locationDetailsScreen()).verifyProductIsVisibleOnTheLocationDetailsScreen(
        	productNdcNumber)
}

 /**
	 * verifies that the latest added product is at the top of the added products list, then deletes the latest added product and continues the process to verifyReverseChronologicalOrder of the added products
	 * @param productNdcNumber (using NDC of the product which is visible on the product tab)
	 * if in future upc/cin are visible then the method can be modified accordingly by passing the respective test object
	 */ 
def static "iosInventory.locationDetailsScreen.verifyReverseChronologicalOrder"(
    	Stack productNdcNumber	) {
    (new iosInventory.locationDetailsScreen()).verifyReverseChronologicalOrder(
        	productNdcNumber)
}

 /**
	 * taps on shares location button, verifies the pop-up screen and closes the pop-up screen
	 */ 
def static "iosInventory.locationDetailsScreen.verifyShareLocationPopUp"() {
    (new iosInventory.locationDetailsScreen()).verifyShareLocationPopUp()
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


def static "androidInventory.locationDetailsScreen.edit_LocationName"(
    	String New_Location_Name	
     , 	String CostType	
     , 	String Previous_Name	) {
    (new androidInventory.locationDetailsScreen()).edit_LocationName(
        	New_Location_Name
         , 	CostType
         , 	Previous_Name)
}


def static "androidInventory.locationDetailsScreen.add_Product_To_Location"(
    	String Location_Name	
     , 	String Product_Name	) {
    (new androidInventory.locationDetailsScreen()).add_Product_To_Location(
        	Location_Name
         , 	Product_Name)
}


def static "androidInventory.locationDetailsScreen.move_Product_To_Another_Location"(
    	String Location_Name	) {
    (new androidInventory.locationDetailsScreen()).move_Product_To_Another_Location(
        	Location_Name)
}


def static "androidInventory.locationDetailsScreen.copy_Product_To_Another_Location"(
    	String Location_Name	) {
    (new androidInventory.locationDetailsScreen()).copy_Product_To_Another_Location(
        	Location_Name)
}


def static "androidInventory.locationDetailsScreen.delete_Product"() {
    (new androidInventory.locationDetailsScreen()).delete_Product()
}

 /**
	 * uploads location from the location details screen
	 */ 
def static "androidInventory.locationDetailsScreen.uploadLocation"() {
    (new androidInventory.locationDetailsScreen()).uploadLocation()
}


def static "androidInventory.locationDetailsScreen.share_Location"() {
    (new androidInventory.locationDetailsScreen()).share_Location()
}


def static "androidInventory.locationDetailsScreen.verify_Location_details_Screen"(
    	String Location_Name	) {
    (new androidInventory.locationDetailsScreen()).verify_Location_details_Screen(
        	Location_Name)
}

 /**
	 * taps on scan icon and takes user to scanning product screen and also verifies that the default toggle is at full count
	 */ 
def static "androidInventory.locationDetailsScreen.clickOnScanIcon"() {
    (new androidInventory.locationDetailsScreen()).clickOnScanIcon()
}

 /**
	 * this function selects the toggle value of countType for the product to be added
	 * @param countType (countType required to be selected for the product to be added which can be full or partial count)
	 */ 
def static "androidInventory.locationDetailsScreen.selectCountTypeForTheProductToBeAdded"(
    	String countType	) {
    (new androidInventory.locationDetailsScreen()).selectCountTypeForTheProductToBeAdded(
        	countType)
}

 /**
	 * scans the product and adds it to the location
	 * @param productToBeSearched (name which can be a productName/Cin/NDC of the product to be added)
	 */ 
def static "androidInventory.locationDetailsScreen.scanInputEvent"(
    	String productToBeSearched	) {
    (new androidInventory.locationDetailsScreen()).scanInputEvent(
        	productToBeSearched)
}

 /**
	 * this function gets the total added quantity of the product
	 * @return quantityNumericalValue (of the product which has been added)
	 */ 
def static "androidInventory.locationDetailsScreen.returnQuantityOfTheAddedProduct"() {
    (new androidInventory.locationDetailsScreen()).returnQuantityOfTheAddedProduct()
}

 /**
	 * this function inputs the quantity value for the product to be searched
	 * @param quantity (quantity required to be added for the product to be searched)
	 */ 
def static "androidInventory.locationDetailsScreen.addQuantityforTheSearchedProduct"(
    	String quantity	) {
    (new androidInventory.locationDetailsScreen()).addQuantityforTheSearchedProduct(
        	quantity)
}

 /**
	 * this function gets the unit of issue cost(UOI) of the added product
	 * @return uoiCost_dollarSymbolRemoved_FloatValue (of the product which has been added)
	 */ 
def static "androidInventory.locationDetailsScreen.returnUOIOfTheAddedProduct"() {
    (new androidInventory.locationDetailsScreen()).returnUOIOfTheAddedProduct()
}

 /**
	 * this function will tap on share button and verify the Gmail option
	 */ 
def static "androidInventory.locationDetailsScreen.verifyGmailOnShareLocation"() {
    (new androidInventory.locationDetailsScreen()).verifyGmailOnShareLocation()
}

 /**
	 * verifies details of location details screen (if user wants to scan a product with same count type more than once, then in the test case, only the updated quantity along with countType and ndcNumber should be pushed into the stack)
	 * @param countTypeStack (stack of the countTypes selected for adding each product)
	 * @param quantityStack (stack of the quantity added for each product)
	 * @param productNdcStack (stack of the ndcNumbers of added products)
	 * @param unitOfIssueCostStack (stack of UOI costs of the added products)
	 */ 
def static "androidInventory.locationDetailsScreen.verifyLocationDetailsScreen"(
    	Stack countTypeStack	
     , 	Stack quantityStack	
     , 	Stack productNdcStack	
     , 	Stack unitOfIssueCostStack	) {
    (new androidInventory.locationDetailsScreen()).verifyLocationDetailsScreen(
        	countTypeStack
         , 	quantityStack
         , 	productNdcStack
         , 	unitOfIssueCostStack)
}

 /**
	 * deletes a product from the added products list in a location
	 * @param productNdcNumber (using NDC of the product which is visible on the product tab)
	 * if in future upc/cin are visible then the method can be modified accordingly by passing the respective test object	 */ 
def static "androidInventory.locationDetailsScreen.deleteProduct"(
    	String productNdcNumber	) {
    (new androidInventory.locationDetailsScreen()).deleteProduct(
        	productNdcNumber)
}

 /**
	 * verifies that the latest added product is at the top of the added products list, then deletes the latest added product and continues the process to verifyReverseChronologicalOrder of the added products
	 * @param productNdcNumber (using NDC of the product which is visible on the product tab)
	 * if in future upc/cin are visible then the method can be modified accordingly by passing the respective test object
	 */ 
def static "androidInventory.locationDetailsScreen.verifyReverseChronologicalOrder"(
    	Stack productNdcNumber	) {
    (new androidInventory.locationDetailsScreen()).verifyReverseChronologicalOrder(
        	productNdcNumber)
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
	 * taps on scan icon and takes user to scanning product screen and also verifies that the default toggle is at ordering
	 */ 
def static "androidOrders.orderDetailsScreen.clickOnScanIcon"() {
    (new androidOrders.orderDetailsScreen()).clickOnScanIcon()
}

 /**
	 * scans the product, adds it to the order and also verifies some scan input details
	 * @param productToBeSearched (name which can be a productName/Cin/NDC of the product to be added)
	 */ 
def static "androidOrders.orderDetailsScreen.scanInputEvent"(
    	String productToBeSearched	) {
    (new androidOrders.orderDetailsScreen()).scanInputEvent(
        	productToBeSearched)
}

 /**
	 * this function adds the quantity for the product to be searched
	 * @param quantity (quantity required to be added for the product to be searched)
	 */ 
def static "androidOrders.orderDetailsScreen.addQuantityforTheSearchedProduct"(
    	int quantity	) {
    (new androidOrders.orderDetailsScreen()).addQuantityforTheSearchedProduct(
        	quantity)
}

 /**
	 * verifies quantity updated caption
	 */ 
def static "androidOrders.orderDetailsScreen.verifyQuantityUpdatedCaption"() {
    (new androidOrders.orderDetailsScreen()).verifyQuantityUpdatedCaption()
}

 /**
	 * verifies order name header label
	 * @param poName (poName is the order name)
	 */ 
def static "androidOrders.orderDetailsScreen.verifyOrderNameHeaderLabel"(
    	String poName	) {
    (new androidOrders.orderDetailsScreen()).verifyOrderNameHeaderLabel(
        	poName)
}

 /**
	 * takes expected lines count as the argument and verifies the same
	 * @param expectedLineCount (expected total line count after adding product and return to the order name page)
	 */ 
def static "androidOrders.orderDetailsScreen.verifyLineCountOfOrderNamePage"(
    	String expectedLineCount	) {
    (new androidOrders.orderDetailsScreen()).verifyLineCountOfOrderNamePage(
        	expectedLineCount)
}

 /**
	 * this function gets the total added quantity of the product
	 * @return quantityNumericalValue (of the product which has been added)
	 */ 
def static "androidOrders.orderDetailsScreen.returnQuantityOfTheAddedProduct"() {
    (new androidOrders.orderDetailsScreen()).returnQuantityOfTheAddedProduct()
}

 /**
	 * uploads the order by clicking on upload order button and verifies upload order button gets disabled after uploading
	 */ 
def static "androidOrders.orderDetailsScreen.uploadOrder"() {
    (new androidOrders.orderDetailsScreen()).uploadOrder()
}

 /**
	 * takes user back to the search product results to continue browsing
	 */ 
def static "androidOrders.orderDetailsScreen.clickOnContinueOrderingOnDesktop"() {
    (new androidOrders.orderDetailsScreen()).clickOnContinueOrderingOnDesktop()
}

 /**
	 * verifies order has been sent to desktop pop up
	 */ 
def static "androidOrders.orderDetailsScreen.verifyOrderHasbeensentToDesktopPopUp"() {
    (new androidOrders.orderDetailsScreen()).verifyOrderHasbeensentToDesktopPopUp()
}

 /**
	 * verifies c2 label is visible or not
	 */ 
def static "androidOrders.orderDetailsScreen.verifyC2Label"() {
    (new androidOrders.orderDetailsScreen()).verifyC2Label()
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
	 * this function selects toggle value for the product to be added which can be ordering or price check)
	 * @param toggleValue (toggleValue required to be selected for the product to be added which can be ordering or price check)
	 */ 
def static "androidOrders.orderDetailsScreen.selectToggleValueForTheProductToBeSearched"(
    	String toggleValue	) {
    (new androidOrders.orderDetailsScreen()).selectToggleValueForTheProductToBeSearched(
        	toggleValue)
}

 /**
	 * verifies the order value after adding a product
	 * @param quantity (quantity which was added)
	 */ 
def static "androidOrders.orderDetailsScreen.verifyOrderValue"(
    	Object quantity	) {
    (new androidOrders.orderDetailsScreen()).verifyOrderValue(
        	quantity)
}

 /**
	 * this function returns the order value
	 * @return actualOrderTotal(order total value)
	 */ 
def static "androidOrders.orderDetailsScreen.returnOrderValue"() {
    (new androidOrders.orderDetailsScreen()).returnOrderValue()
}

 /**
	 * this function returns the cost of added product
	 * @return productCost (of the product which has been added)
	 */ 
def static "androidOrders.orderDetailsScreen.returnCostOfTheAddedProduct"() {
    (new androidOrders.orderDetailsScreen()).returnCostOfTheAddedProduct()
}

 /**
	 * this function verifies that the product is visible on the order details screen
	 * @param productNdcNumber (using NDC of the product which is visible on the product tab)
	 * if in future upc/cin are visible then the method can be modified accordingly by passing the respective test object
	 */ 
def static "androidOrders.orderDetailsScreen.verifyProductIsVisibleOnTheOrderDetailsScreen"(
    	Object productNdcNumber	) {
    (new androidOrders.orderDetailsScreen()).verifyProductIsVisibleOnTheOrderDetailsScreen(
        	productNdcNumber)
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

 /**
	 * verifies order screen details without any added product
	 */ 
def static "androidOrders.orderDetailsScreen.verifyOrderScreenDetailsWithoutAnyAddedProduct"() {
    (new androidOrders.orderDetailsScreen()).verifyOrderScreenDetailsWithoutAnyAddedProduct()
}

 /**
	 * verifies order screen details with added product
	 */ 
def static "androidOrders.orderDetailsScreen.verifyOrderScreenDetailsWithAddedProduct"() {
    (new androidOrders.orderDetailsScreen()).verifyOrderScreenDetailsWithAddedProduct()
}

 /**
	 * verifies the pop up which appears after user clicks on upload order
	 */ 
def static "androidOrders.orderDetailsScreen.verifyUploadOrderPopUp"() {
    (new androidOrders.orderDetailsScreen()).verifyUploadOrderPopUp()
}

 /**
	 * adds costType based on the argument which can be current or last price paid
	 * @param costType (can be current or last price paid)
	 */ 
def static "iosInventory.inventoryDetailsScreen.addCostType"(
    	String costType	) {
    (new iosInventory.inventoryDetailsScreen()).addCostType(
        	costType)
}

 /**
	 * adds location to an inventory based on the cost type of current or last price paid
	 * @param locationName (name of the location to be added)
	 * @param costType (cost type required which can be current or last price paid)
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
	 * @param locationName (name of the location to be created) 
	 * @param productName (name of the product to be added) 
	 * @param countType (count type required which can be partial or full count) 
	 * @param quantity (quantity of the product required to be added)
	 * @param costType (cost type required which can be current or last price paid)
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
def static "iosInventory.inventoryDetailsScreen.editInventoryName"(
    	String newInventoryName	) {
    (new iosInventory.inventoryDetailsScreen()).editInventoryName(
        	newInventoryName)
}

 /**
	 * searches and adds the product from the inventory details screen by creating a new location
	 * @param locationName (name of the location to be created) 
	 * @param productName (name of the product to be added)
	 * @param costType (cost type required which can be current or last price paid)
	 */ 
def static "iosInventory.inventoryDetailsScreen.searchAndAddProductByCreatingNewLocation"(
    	String locationName	
     , 	String productName	
     , 	String costType	
     , 	String quantity	) {
    (new iosInventory.inventoryDetailsScreen()).searchAndAddProductByCreatingNewLocation(
        	locationName
         , 	productName
         , 	costType
         , 	quantity)
}

 /**
	 * verifies various details of the inventory details screen
	 * @param inventoryName (name of the inventory which is under verification)
	 */ 
def static "iosInventory.inventoryDetailsScreen.verifyInventoryDetailsScreen"(
    	String inventoryName	) {
    (new iosInventory.inventoryDetailsScreen()).verifyInventoryDetailsScreen(
        	inventoryName)
}

 /**
	 * this function verifies the location count
	 * @param expectedLocationCount (expected location Count)
	 */ 
def static "iosInventory.inventoryDetailsScreen.verifyLocationCount"(
    	String expectedLocationCount	) {
    (new iosInventory.inventoryDetailsScreen()).verifyLocationCount(
        	expectedLocationCount)
}

 /**
	 * this function verifies that the product is visible on the screen after it is searched from inventory details screen
	 * @param productIdentificationNumber (productIdentificationNumber of the product which can be NDC/Cin/UPC, which should be present on the screen)
	 */ 
def static "iosInventory.inventoryDetailsScreen.verifyProductIsVisibleOnScreenWhenSearchedFromInventoryDetailsScreen"(
    	Object productIdentificationNumber	) {
    (new iosInventory.inventoryDetailsScreen()).verifyProductIsVisibleOnScreenWhenSearchedFromInventoryDetailsScreen(
        	productIdentificationNumber)
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
	 * enables beta csos feature
	 */ 
def static "android_more_options.moreOptionsScreen.enableBetaFeatureCSOS"() {
    (new android_more_options.moreOptionsScreen()).enableBetaFeatureCSOS()
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

 /**
	 * adds costType based on the argument which can be current or last price paid
	 * @param costType (can be current or last price paid)
	 */ 
def static "androidInventory.inventoryDetailsScreen.addCostType"(
    	String costType	) {
    (new androidInventory.inventoryDetailsScreen()).addCostType(
        	costType)
}

 /**
	 * adds location to an inventory based on the cost type of current or last price paid
	 * @param locationName (name of the location to be added)
	 * @param costType (cost type required which can be current or last price paid)
	 */ 
def static "androidInventory.inventoryDetailsScreen.addLocation"(
    	String locationName	
     , 	String costType	) {
    (new androidInventory.inventoryDetailsScreen()).addLocation(
        	locationName
         , 	costType)
}


def static "androidInventory.inventoryDetailsScreen.edit_InventoryName"(
    	String New_Inventory_Name	
     , 	String Previous_Name	) {
    (new androidInventory.inventoryDetailsScreen()).edit_InventoryName(
        	New_Inventory_Name
         , 	Previous_Name)
}


def static "androidInventory.inventoryDetailsScreen.clickOnLocation"(
    	String locationName	) {
    (new androidInventory.inventoryDetailsScreen()).clickOnLocation(
        	locationName)
}


def static "androidInventory.inventoryDetailsScreen.search_And_Add_Product_By_Creating_New_Location"(
    	String Location_Name	
     , 	String Product_Name	
     , 	String CostType	) {
    (new androidInventory.inventoryDetailsScreen()).search_And_Add_Product_By_Creating_New_Location(
        	Location_Name
         , 	Product_Name
         , 	CostType)
}


def static "androidInventory.inventoryDetailsScreen.verify_Inventory_Details_Screen"(
    	String Inventory_Name	) {
    (new androidInventory.inventoryDetailsScreen()).verify_Inventory_Details_Screen(
        	Inventory_Name)
}

 /**
	 * verifies the location count, cost gets updated or not, of the inventory after the location is deleted
	 * @param locationName (name of the location under verification)
	 */ 
def static "androidInventory.inventoryDetailsScreen.deleteLocationWithCostLocationCountVerification"(
    	String locationName	) {
    (new androidInventory.inventoryDetailsScreen()).deleteLocationWithCostLocationCountVerification(
        	locationName)
}

 /**
	 * deletes the location
	 * @param locationName (name of the location to be deleted)
	 */ 
def static "androidInventory.inventoryDetailsScreen.deleteLocation"(
    	String locationName	) {
    (new androidInventory.inventoryDetailsScreen()).deleteLocation(
        	locationName)
}


def static "iosOrders.newOrderScreen.change_Account"(
    	String new_Account	) {
    (new iosOrders.newOrderScreen()).change_Account(
        	new_Account)
}

 /**
	 * enters purchase order details for the order to be created
	 * @param poName (purchase order name for the order created)
	 * @param poMemo (purchase order memo for the order created)
	 */ 
def static "iosOrders.newOrderScreen.enterPurchaseOrderDetails"(
    	String poName	
     , 	String poMemo	) {
    (new iosOrders.newOrderScreen()).enterPurchaseOrderDetails(
        	poName
         , 	poMemo)
}

 /**
	 * taps on create order button to create an order and takes user to the order details screen
	 */ 
def static "iosOrders.newOrderScreen.createOrder"() {
    (new iosOrders.newOrderScreen()).createOrder()
}


def static "iosOrders.newOrderScreen.verify_NewOrder_Screen_Details"() {
    (new iosOrders.newOrderScreen()).verify_NewOrder_Screen_Details()
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
def static "iosInventory.inventoryListingScreen.clickOnInventory"(
    	String inventoryName	) {
    (new iosInventory.inventoryListingScreen()).clickOnInventory(
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
def static "iosInventory.inventoryListingScreen.verifyInventoryListingScreen"() {
    (new iosInventory.inventoryListingScreen()).verifyInventoryListingScreen()
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

 /**
	 * float value generator
	 * @param stringToBeConvertedToFloatValue
	 * @return float value for a string by removing characters
	 */ 
def static "common.commonMethods.floatValueGenerator"(
    	String stringToBeConvertedToFloatValue	) {
    (new common.commonMethods()).floatValueGenerator(
        	stringToBeConvertedToFloatValue)
}

 /**
	 * this function formats the decimal data for e.g 20.546 would be converted to 20.55 if decimalFormatRequired is 0.00
	 * @param decimalDataToBeFormatted (decimal data required to be formatted), 
	 * @param decimalFormatRequired (decimal format required for e.g 0.00 for rounding to 2 decimal places)
	 * @return formattedDecimalData (formatted decimal data)
	 */ 
def static "common.commonMethods.formatDecimalData"(
    	Object decimalDataToBeFormatted	
     , 	String decimalFormatRequired	) {
    (new common.commonMethods()).formatDecimalData(
        	decimalDataToBeFormatted
         , 	decimalFormatRequired)
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
	 * Get mobile driver for current session
	 * @return mobile driver for current session
	 */ 
def static "common.commonMethods.getCurrentSessionMobileDriver"() {
    (new common.commonMethods()).getCurrentSessionMobileDriver()
}

 /**
	 * adds the product from dash-board to inventory
	 * @param productName
	 * @param quantity
	 */ 
def static "iosDashboard.dashboardScreen.addingProductFromDashboardToCart"(
    	String productName	
     , 	String quantity	) {
    (new iosDashboard.dashboardScreen()).addingProductFromDashboardToCart(
        	productName
         , 	quantity)
}

 /**
	 * changes the user account
	 * @param newAccount
	 */ 
def static "iosDashboard.dashboardScreen.changeAccount"(
    	String newAccount	) {
    (new iosDashboard.dashboardScreen()).changeAccount(
        	newAccount)
}

 /**
	 * opens home tab
	 */ 
def static "iosDashboard.dashboardScreen.clickOnHomeTab"() {
    (new iosDashboard.dashboardScreen()).clickOnHomeTab()
}

 /**
	 * opens moreOptions tab where user can perform actions like signOut, goToInventoryListing Screen etc
	 */ 
def static "iosDashboard.dashboardScreen.clickOnMoreOptionsTab"() {
    (new iosDashboard.dashboardScreen()).clickOnMoreOptionsTab()
}

 /**
	 * opens orders tab where user can perform actions related to orders
	 */ 
def static "iosDashboard.dashboardScreen.clickOnOrders"() {
    (new iosDashboard.dashboardScreen()).clickOnOrders()
}

 /**
	 * taps on scan icon and takes user to scanning product screen and also verifies that the default toggle is at ordering
	 */ 
def static "iosDashboard.dashboardScreen.clickOnScanIcon"() {
    (new iosDashboard.dashboardScreen()).clickOnScanIcon()
}

 /**
	 * this function verifies the dash-board details Screen
	 */ 
def static "iosDashboard.dashboardScreen.verifyDashboardScreen"() {
    (new iosDashboard.dashboardScreen()).verifyDashboardScreen()
}

 /**
	 * opens the order details page
	 * @param poName (purchase order name used to create the order)
	 */ 
def static "androidOrders.cartScreen.openAnOrderDetail"(
    	String poName	) {
    (new androidOrders.cartScreen()).openAnOrderDetail(
        	poName)
}

 /**
	 * opens the c2 orders tab
	 */ 
def static "androidOrders.cartScreen.clickOnC2OrdersTab"() {
    (new androidOrders.cartScreen()).clickOnC2OrdersTab()
}


def static "androidOrders.cartScreen.delete_Order"(
    	Object Account_No	) {
    (new androidOrders.cartScreen()).delete_Order(
        	Account_No)
}

 /**
	 * clicks on upload all orders button on cart screen
	 */ 
def static "androidOrders.cartScreen.clickOnUploadAllOrders"() {
    (new androidOrders.cartScreen()).clickOnUploadAllOrders()
}

 /**
	 * verifies cart screen without non c2 orders
	 */ 
def static "androidOrders.cartScreen.verifyCartScreenWithOutNonC2Orders"() {
    (new androidOrders.cartScreen()).verifyCartScreenWithOutNonC2Orders()
}

 /**
	 * verifies pop up screen which comes after clicking on upload all orders button on cart screen
	 */ 
def static "androidOrders.cartScreen.verifyUploadAllOrdersPopUp"() {
    (new androidOrders.cartScreen()).verifyUploadAllOrdersPopUp()
}

 /**
	 * clicks on continue on desktop button on cart screen
	 */ 
def static "androidOrders.cartScreen.clickOnContinueOnDesktop"() {
    (new androidOrders.cartScreen()).clickOnContinueOnDesktop()
}

 /**
	 * clicks on place all orders button on cart screen
	 */ 
def static "androidOrders.cartScreen.clickOnPlaceAllOrders"() {
    (new androidOrders.cartScreen()).clickOnPlaceAllOrders()
}

 /**
	 * verifies pop up screen which comes after clicking on place all orders button on cart screen
	 */ 
def static "androidOrders.cartScreen.verifyPlaceAllOrdersPopUp"() {
    (new androidOrders.cartScreen()).verifyPlaceAllOrdersPopUp()
}

 /**
	 * clicks on place my orders button on cart screen
	 */ 
def static "androidOrders.cartScreen.confirmPlacingAllOrders"() {
    (new androidOrders.cartScreen()).confirmPlacingAllOrders()
}

 /**
	 * verifies cart screen with added product
	 */ 
def static "androidOrders.cartScreen.verifyCartScreenDetailsWithAddedProduct"() {
    (new androidOrders.cartScreen()).verifyCartScreenDetailsWithAddedProduct()
}

 /**
	 * verifies that the created order should not be visible on the cart screen
	 * @param poName (purchase order name used to create the order)
	 */ 
def static "androidOrders.cartScreen.verifyOrderNotVisibleOnTheCartScreen"(
    	String poName	) {
    (new androidOrders.cartScreen()).verifyOrderNotVisibleOnTheCartScreen(
        	poName)
}

 /**
	 * verifies nonC2 annotation count
	 */ 
def static "androidOrders.cartScreen.verifynonC2AnnotationCount"(
    	String expectedAnnotationCount	) {
    (new androidOrders.cartScreen()).verifynonC2AnnotationCount(
        	expectedAnnotationCount)
}

 /**
	 * verifies C2 annotation count
	 */ 
def static "androidOrders.cartScreen.verifyC2AnnotationCount"(
    	String expectedAnnotationCount	) {
    (new androidOrders.cartScreen()).verifyC2AnnotationCount(
        	expectedAnnotationCount)
}

 /**
	 * takes expected lines count as the argument and verifies the same
	 * @param expectedLinesCount (expected lines count after adding products to the cart)
	 */ 
def static "androidOrders.cartScreen.verifyLinesCount"(
    	String expectedLinesCount	) {
    (new androidOrders.cartScreen()).verifyLinesCount(
        	expectedLinesCount)
}

 /**
	 * verifies that the created order should not be visible on the cart screen
	 * @param poName (purchase order name used to create the order)
	 */ 
def static "androidOrders.cartScreen.verifyOrderIsVisibleOnTheCartScreen"(
    	String poName	) {
    (new androidOrders.cartScreen()).verifyOrderIsVisibleOnTheCartScreen(
        	poName)
}

 /**
	 * takes expected lines count of c2 or non c2 as the argument and verifies the same
	 * @param expectedLineCount (expected total line count of non c2 or c2 after adding product to the cart)
	 */ 
def static "androidOrders.cartScreen.verifyLineCountofC2OrNonC2Product"(
    	String expectedlineCount	) {
    (new androidOrders.cartScreen()).verifyLineCountofC2OrNonC2Product(
        	expectedlineCount)
}

 /**
	 * this function returns the order name of the order which is at the top of the order list
	 * return orderName (returns topmost order name)
	 */ 
def static "androidOrders.cartScreen.returnTopMostOrderName"() {
    (new androidOrders.cartScreen()).returnTopMostOrderName()
}

 /**
	 * this function verifies the pattern required for the order which was created without giving any purchase order name
	 * @param orderName (order name which is under verification)
	 */ 
def static "androidOrders.cartScreen.verifyOrderNamePattern"(
    	String orderName	) {
    (new androidOrders.cartScreen()).verifyOrderNamePattern(
        	orderName)
}

 /**
	 * takes expected lines count as the argument and verifies the same
	 * @param expectedLinesCount (expected total line count after adding products to the cart)
	 */ 
def static "androidOrders.cartScreen.verifyTotalLineCount"(
    	String expectedLineCount	) {
    (new androidOrders.cartScreen()).verifyTotalLineCount(
        	expectedLineCount)
}

 /**
	 * takes expected mobile orders count as the argument and verifies the same
	 * @param expected mobile orders count (expected mobile orders count after adding products to the cart)
	 */ 
def static "androidOrders.cartScreen.verifyMobileOrdersCount"(
    	String expectedMobileOrdersCount	) {
    (new androidOrders.cartScreen()).verifyMobileOrdersCount(
        	expectedMobileOrdersCount)
}

 /**
	 * verifies the cart value after adding products
	 * @param expectedCartValue (expected cart value which should be equal to actual cart total)
	 */ 
def static "androidOrders.cartScreen.verifyCartValue"(
    	Object expectedCartValue	) {
    (new androidOrders.cartScreen()).verifyCartValue(
        	expectedCartValue)
}

 /**
	 * verifies the cart screen details without any product
	 */ 
def static "androidOrders.cartScreen.verifyCartScreenDetailsWithOutAddingAnyProduct"() {
    (new androidOrders.cartScreen()).verifyCartScreenDetailsWithOutAddingAnyProduct()
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
	 * @param stringCharcterToBeRemoved (Removes characters in a string)
	 */ 
def static "androidCommonKeywords.commonMethods.removeCharctersInString"(
    	String stringCharcterToBeRemoved	) {
    (new androidCommonKeywords.commonMethods()).removeCharctersInString(
        	stringCharcterToBeRemoved)
}

 /**
	 * @param stringToBeConvertedToFloat (converts string to float)
	 */ 
def static "androidCommonKeywords.commonMethods.stringToFloatConversion"(
    	String stringToBeConvertedToFloat	) {
    (new androidCommonKeywords.commonMethods()).stringToFloatConversion(
        	stringToBeConvertedToFloat)
}

 /**
	 * @param floatToBeConvertedToString (converts float to string and does formatting "0.00")
	 */ 
def static "androidCommonKeywords.commonMethods.floatToStringConversionAndFormatting"(
    	Float floatToBeConvertedToString	) {
    (new androidCommonKeywords.commonMethods()).floatToStringConversionAndFormatting(
        	floatToBeConvertedToString)
}

 /**
	 * this function returns the total expected value of the added product
	 * @return expectedOrderTotal (of the product which has been added)
	 */ 
def static "androidCommonKeywords.commonMethods.returnExpectedTotalValueForAddedProduct"(
    	Object quantity	
     , 	Object costOfProduct	) {
    (new androidCommonKeywords.commonMethods()).returnExpectedTotalValueForAddedProduct(
        	quantity
         , 	costOfProduct)
}

 /**
	 * this function returns the cost of added product
	 * @return productCostCharcterRemoved (of the product which has been added)
	 */ 
def static "androidCommonKeywords.commonMethods.returnCostOfTheAddedProduct"(
    	String testObj	) {
    (new androidCommonKeywords.commonMethods()).returnCostOfTheAddedProduct(
        	testObj)
}

 /**
	 * this function verifies that the product is visible on the screen
	 * @param productIdentificationNumber (productIdentificationNumber of the product which can be NDC/Cin/UPC, which should be present on the screen)
	 * @param testObj (test object of the element under verification)
	 */ 
def static "androidCommonKeywords.commonMethods.verifyProductIsVisibleOnTheScreen"(
    	Object testObj	
     , 	Object productIdentificationNumber	) {
    (new androidCommonKeywords.commonMethods()).verifyProductIsVisibleOnTheScreen(
        	testObj
         , 	productIdentificationNumber)
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
	 * opens the inventory listing screen by firstly clicking on more options from dash-board
	 * and then clicks on inventory under more options screen which takes user to inventory listing screen
	 */ 
def static "androidCommonKeywords.commonMethods.takeUserFromHomeToInventoryListingScreen"() {
    (new androidCommonKeywords.commonMethods()).takeUserFromHomeToInventoryListingScreen()
}

 /**
	 * navigate to previous screen
	 * use this method whenever the back button is not available
	 */ 
def static "androidCommonKeywords.commonMethods.pressBacknav"() {
    (new androidCommonKeywords.commonMethods()).pressBacknav()
}

 /**
	 * generates the coordinate x for a test object by considering ElementLeftPosition and ElementWidth
	 * @param testObj (reference of the testObject passed as a parameter)
	 * @param text (name of the element)
	 * @return int value for the xCoordinate
	 */ 
def static "androidCommonKeywords.commonMethods.tapXCoordinateGenerator"(
    	String testObj	) {
    (new androidCommonKeywords.commonMethods()).tapXCoordinateGenerator(
        	testObj)
}

 /**
	 * generates the coordinate y for a test object by considering ElementTopPosition and ElementHeight
	 * @param testObj (reference of the testObject passed as a parameter)
	 * @param text (name of the element)
	 * @return int value for the yCoordinate
	 */ 
def static "androidCommonKeywords.commonMethods.tapYCoordinateGenerator"(
    	String testObj	
     , 	String text	) {
    (new androidCommonKeywords.commonMethods()).tapYCoordinateGenerator(
        	testObj
         , 	text)
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


def static "com.kms.katalon.keyword.applitools.EyesKeywords.eyesOpen"(
    	String testName	
     , 	RectangleSize viewportSize	) {
    (new com.kms.katalon.keyword.applitools.EyesKeywords()).eyesOpen(
        	testName
         , 	viewportSize)
}


def static "com.kms.katalon.keyword.applitools.EyesKeywords.eyesInit"() {
    (new com.kms.katalon.keyword.applitools.EyesKeywords()).eyesInit()
}


def static "com.kms.katalon.keyword.applitools.EyesKeywords.eyesClose"(
    	Eyes eyes	) {
    (new com.kms.katalon.keyword.applitools.EyesKeywords()).eyesClose(
        	eyes)
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
