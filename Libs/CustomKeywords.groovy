
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


 /**
	 * copies topmost non c2 order to cart screen
	 * verifies details related to order name, account name, lines count 
	 * of the order which is at the top of the order list under saved orders
	 */ 
def static "androidOrders.bcsOrders.copyAndVerifyTopMostOrderDetailsUnderSavedOrdersToCartScreen"() {
    (new androidOrders.bcsOrders()).copyAndVerifyTopMostOrderDetailsUnderSavedOrdersToCartScreen()
}

 /**
	 * copies a non c2 order from saved orders to the cart screen and verifies details related to copy button
	 */ 
def static "androidOrders.bcsOrders.copyNonC2ProductFromSavedOrders"() {
    (new androidOrders.bcsOrders()).copyNonC2ProductFromSavedOrders()
}

 /**
	 * opens the saved orders by tapping on the bcs notification
	 */ 
def static "androidOrders.bcsOrders.openSavedOrdersList"() {
    (new androidOrders.bcsOrders()).openSavedOrdersList()
}

 /**
	 * verifies bcs notification on the cart screen
	 */ 
def static "androidOrders.bcsOrders.verifyBcsNotification"() {
    (new androidOrders.bcsOrders()).verifyBcsNotification()
}

 /**
	 * verifies details related to c2 orders tile under orders listing screen
	 */ 
def static "androidOrders.bcsOrders.verifyC2RelatedDetailsForBCS"() {
    (new androidOrders.bcsOrders()).verifyC2RelatedDetailsForBCS()
}

 /**
	 * verifies details related to saved orders listing screen
	 */ 
def static "androidOrders.bcsOrders.verifySavedOrdersListDetails"() {
    (new androidOrders.bcsOrders()).verifySavedOrdersListDetails()
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
	 * opens orders tab where user can perform actions related to orders
	 */ 
def static "androidDashboard.dashboardDetailsScreen.clickOnOrders"() {
    (new androidDashboard.dashboardDetailsScreen()).clickOnOrders()
}

 /**
	 * opens receiving tab
	 */ 
def static "androidDashboard.dashboardDetailsScreen.clickOnReceivingTab"() {
    (new androidDashboard.dashboardDetailsScreen()).clickOnReceivingTab()
}

 /**
	 * opens audits tab
	 */ 
def static "androidDashboard.dashboardDetailsScreen.tapOnAudits"() {
    (new androidDashboard.dashboardDetailsScreen()).tapOnAudits()
}

 /**
	 * this function verifies the dash-board details Screen
	 */ 
def static "androidDashboard.dashboardDetailsScreen.verifyDashboardPage"() {
    (new androidDashboard.dashboardDetailsScreen()).verifyDashboardPage()
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
	 * creates a new inventory from inventory listing screen
	 * @param inventoryName (name required for the new inventory)
	 */ 
def static "androidInventory.inventoryListingScreen.createInventory"(
    	String inventoryName	) {
    (new androidInventory.inventoryListingScreen()).createInventory(
        	inventoryName)
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
	 * clicks on more options, takes to beat features and enables it
	 */ 
def static "iosCommonKeywords.commonMethods.enableBetaFeatures"() {
    (new iosCommonKeywords.commonMethods()).enableBetaFeatures()
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
	 * reads value from the global boolean variable: isIosAppInstalled
	 * and if it is set to true, launches already installed application else installs and launches the application
	 */ 
def static "iosCommonKeywords.commonMethods.installingAndlaunchingTheApplication"() {
    (new iosCommonKeywords.commonMethods()).installingAndlaunchingTheApplication()
}

 /**
	 * opens existing testflight app and installs latest OE App
	 * @return bundleId of testflight
	 */ 
def static "iosCommonKeywords.commonMethods.openTestFlightApp"(
    	String bundleID	) {
    (new iosCommonKeywords.commonMethods()).openTestFlightApp(
        	bundleID)
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
	 * removes characters in string
	 * @param stringCharcterToBeRemoved (Removes characters in a string)
	 * @return modifiedString
	 */ 
def static "iosCommonKeywords.commonMethods.removeCharactersInString"(
    	String stringCharcterToBeRemoved	) {
    (new iosCommonKeywords.commonMethods()).removeCharactersInString(
        	stringCharcterToBeRemoved)
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
	 * takes product to be searched as the argument and searches the same
	 * @param productToBeSearched (product to be searched)
	 */ 
def static "iosCommonKeywords.commonMethods.searchProduct"(
    	Object productToBeSearched	) {
    (new iosCommonKeywords.commonMethods()).searchProduct(
        	productToBeSearched)
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
	 * disables touchid while using real device
	 */ 
def static "iosCommonKeywords.commonMethods.tapOnSetupLater"() {
    (new iosCommonKeywords.commonMethods()).tapOnSetupLater()
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
	 * verifies whether the selected user account is same as the account required
	 * @param expectedAccountNo (expected user account no)
	 */ 
def static "iosCommonKeywords.commonMethods.verifySelectedAccount"(
    	String expectedAccountNo	) {
    (new iosCommonKeywords.commonMethods()).verifySelectedAccount(
        	expectedAccountNo)
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


def static "androidOrders.newOrderScreen.change_Account"(
    	String New_Account	) {
    (new androidOrders.newOrderScreen()).change_Account(
        	New_Account)
}

 /**
	 * selects different account
	 * @param accountNo (account number used for selection)
	 */ 
def static "androidOrders.newOrderScreen.changeAccount"(
    	String accountNo	) {
    (new androidOrders.newOrderScreen()).changeAccount(
        	accountNo)
}

 /**
	 * opens new order page
	 */ 
def static "androidOrders.newOrderScreen.clickOnNewOrder"() {
    (new androidOrders.newOrderScreen()).clickOnNewOrder()
}

 /**
	 * taps on create order button to create an order
	 */ 
def static "androidOrders.newOrderScreen.createOrder"() {
    (new androidOrders.newOrderScreen()).createOrder()
}

 /**
	 * adds poname pomemo to textfield
	 * @param poName(purchase order name for the order created)
	 * @param poMwmo(purchase order Memo for the order created)
	 */ 
def static "androidOrders.newOrderScreen.enterPurchaseOrderDetails"(
    	String poName	
     , 	String poMemo	) {
    (new androidOrders.newOrderScreen()).enterPurchaseOrderDetails(
        	poName
         , 	poMemo)
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
	 * deletes all orders from nonc2 and c2 order tab
	 */ 
def static "iosOrders.ordersCommonScreen.clearAllOrders"() {
    (new iosOrders.ordersCommonScreen()).clearAllOrders()
}

 /**
	 * takes user to order screen where user can input purchase order details and can create an order
	 */ 
def static "iosOrders.ordersCommonScreen.clickOnCartTab"() {
    (new iosOrders.ordersCommonScreen()).clickOnCartTab()
}

 /**
	 * takes user to history screen where user can input purchase order details and can create an order
	 */ 
def static "iosOrders.ordersCommonScreen.clickOnHistoryTab"() {
    (new iosOrders.ordersCommonScreen()).clickOnHistoryTab()
}

 /**
	 * takes user to new order screen where user can input purchase order details and can create an order
	 */ 
def static "iosOrders.ordersCommonScreen.clickOnNewOrder"() {
    (new iosOrders.ordersCommonScreen()).clickOnNewOrder()
}

 /**
	 * searches for a product by setting product name and quantity as the input
	 * @param productName (product to be added), quantity (total quantity required to be added)
	 */ 
def static "iosOrders.orderDetailsScreen.addAlternateProduct"(
    	String productName	
     , 	String quantity	) {
    (new iosOrders.orderDetailsScreen()).addAlternateProduct(
        	productName
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
	 * this function adds the quantity in alternates page
	 * @param quantity (quantity required to add in product detail page)
	 */ 
def static "iosOrders.orderDetailsScreen.addQuantityInAlternatesPage"(
    	String quantity	) {
    (new iosOrders.orderDetailsScreen()).addQuantityInAlternatesPage(
        	quantity)
}

 /**
	 * this function adds the quantity in product detail page
	 * @param quantity (quantity required to add in product detail page)
	 */ 
def static "iosOrders.orderDetailsScreen.addQuantityInProductDetailsPage"(
    	String quantity	) {
    (new iosOrders.orderDetailsScreen()).addQuantityInProductDetailsPage(
        	quantity)
}

 /**
	 * this function adds the product to be ordered - when price check toggle is selected
	 * @param quantity (quantity required to be added for the product to be searched)
	 */ 
def static "iosOrders.orderDetailsScreen.addToOrder"() {
    (new iosOrders.orderDetailsScreen()).addToOrder()
}

 /**
	 * adds product 
	 */ 
def static "iosOrders.orderDetailsScreen.addToOrderWithoutVerify"() {
    (new iosOrders.orderDetailsScreen()).addToOrderWithoutVerify()
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
	 * taps on continue browsing button on order confirmation screen and takes user to scan result screen
	 */ 
def static "iosOrders.orderDetailsScreen.clickOnContinueBrowsing"() {
    (new iosOrders.orderDetailsScreen()).clickOnContinueBrowsing()
}

 /**
	 * taps on continue ordering button on order details screen after user has added a product to order
	 * and takes user to scan result screen
	 */ 
def static "iosOrders.orderDetailsScreen.clickOnContinueOrdering"() {
    (new iosOrders.orderDetailsScreen()).clickOnContinueOrdering()
}

 /**
	 * takes user back to the search product results to continue browsing
	 */ 
def static "iosOrders.orderDetailsScreen.clickOnContinueOrderingOnDesktop"() {
    (new iosOrders.orderDetailsScreen()).clickOnContinueOrderingOnDesktop()
}

 /**
	 * taps on go to order button on order confirmation screen and takes user to order details screen
	 */ 
def static "iosOrders.orderDetailsScreen.clickOnGoToOrder"() {
    (new iosOrders.orderDetailsScreen()).clickOnGoToOrder()
}

 /**
	 * opens more details of product details
	 */ 
def static "iosOrders.orderDetailsScreen.clickOnMoreDetails"() {
    (new iosOrders.orderDetailsScreen()).clickOnMoreDetails()
}

 /**
	 * places the order
	 */ 
def static "iosOrders.orderDetailsScreen.clickOnPlaceOrder"() {
    (new iosOrders.orderDetailsScreen()).clickOnPlaceOrder()
}

 /**
	 * opens product tile
	 */ 
def static "iosOrders.orderDetailsScreen.clickOnProductTile"() {
    (new iosOrders.orderDetailsScreen()).clickOnProductTile()
}

 /**
	 * takes user back to history screen and verifies user is on the history screen or not
	 */ 
def static "iosOrders.orderDetailsScreen.clickOnReviewAndSignButton"() {
    (new iosOrders.orderDetailsScreen()).clickOnReviewAndSignButton()
}

 /**
	 * taps on scan icon and takes user to scanning product screen and also verifies that the default toggle is at ordering
	 */ 
def static "iosOrders.orderDetailsScreen.clickOnScanIcon"() {
    (new iosOrders.orderDetailsScreen()).clickOnScanIcon()
}

 /**
	 *  taps on scan icon and takes user to scanning product screen 
	 */ 
def static "iosOrders.orderDetailsScreen.clickOnScanIconWithoutVerification"() {
    (new iosOrders.orderDetailsScreen()).clickOnScanIconWithoutVerification()
}

 /**
	 * closes the popup when user switches to offline mode
	 */ 
def static "iosOrders.orderDetailsScreen.closeOfflinePopUp"() {
    (new iosOrders.orderDetailsScreen()).closeOfflinePopUp()
}

 /**
	 * confirms place order by clicking on place my order button
	 */ 
def static "iosOrders.orderDetailsScreen.confirmPlaceOrder"() {
    (new iosOrders.orderDetailsScreen()).confirmPlaceOrder()
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
	 * fetch UTN number and store it in a string
	 */ 
def static "iosOrders.orderDetailsScreen.getUTNFromUTNTextField"() {
    (new iosOrders.orderDetailsScreen()).getUTNFromUTNTextField()
}

 /**
	 * takes user to dash-board
	 */ 
def static "iosOrders.orderDetailsScreen.goToDashboard"() {
    (new iosOrders.orderDetailsScreen()).goToDashboard()
}

 /**
	 * clicks on place order button
	 */ 
def static "iosOrders.orderDetailsScreen.placeOrder"() {
    (new iosOrders.orderDetailsScreen()).placeOrder()
}

 /**
	 * try removing all characters in UTN field
	 */ 
def static "iosOrders.orderDetailsScreen.removeCharactersInUTNField"() {
    (new iosOrders.orderDetailsScreen()).removeCharactersInUTNField()
}

 /**
	 * removes product from orders details
	 */ 
def static "iosOrders.orderDetailsScreen.removeProduct"() {
    (new iosOrders.orderDetailsScreen()).removeProduct()
}

 /**
	 * this function returns the cost of added product
	 * @return productCost (of the product which has been added)
	 */ 
def static "iosOrders.orderDetailsScreen.returnCostOfTheAddedProduct"() {
    (new iosOrders.orderDetailsScreen()).returnCostOfTheAddedProduct()
}

 /**
	 * returns NDC number
	 */ 
def static "iosOrders.orderDetailsScreen.returnNDCLabelOfScannedProduct"() {
    (new iosOrders.orderDetailsScreen()).returnNDCLabelOfScannedProduct()
}

 /**
	 * this function returns the order name of the order/ title of the screen when user is on order details screen
	 * return orderName (returns order name/ title of order details screen)
	 */ 
def static "iosOrders.orderDetailsScreen.returnOrderNameFromOrderDetailScreen"() {
    (new iosOrders.orderDetailsScreen()).returnOrderNameFromOrderDetailScreen()
}

 /**
	 * this function returns the order value
	 * @return orderTotalFloatValue (order total value)
	 */ 
def static "iosOrders.orderDetailsScreen.returnOrderValue"() {
    (new iosOrders.orderDetailsScreen()).returnOrderValue()
}

 /**
	 * this function returns the order name in search page
	 */ 
def static "iosOrders.orderDetailsScreen.returnProductNameAfterSearch"() {
    (new iosOrders.orderDetailsScreen()).returnProductNameAfterSearch()
}

 /**
	 * this function gets the total added quantity of the product
	 * @return quantityNumericalValue (of the product which has been added)
	 */ 
def static "iosOrders.orderDetailsScreen.returnQuantityOfTheAddedProduct"() {
    (new iosOrders.orderDetailsScreen()).returnQuantityOfTheAddedProduct()
}

 /**
	 * this function returns the top most product name in order details page
	 */ 
def static "iosOrders.orderDetailsScreen.returnTopMostProductNameInOrderDetails"() {
    (new iosOrders.orderDetailsScreen()).returnTopMostProductNameInOrderDetails()
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
	 * scans the product in offline mode
	 * @param productToBeSearched (name which can be a productName/Cin/NDC of the product to be added)
	 */ 
def static "iosOrders.orderDetailsScreen.scanInputEventInOfflineMode"(
    	String productToBeSearched	) {
    (new iosOrders.orderDetailsScreen()).scanInputEventInOfflineMode(
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
	 * scans the product
	 * @param productToBeSearched (name which can be a productName/Cin/NDC of the product to be added)
	 */ 
def static "iosOrders.orderDetailsScreen.scanInputEventWithoutVerification"(
    	String productToBeSearched	) {
    (new iosOrders.orderDetailsScreen()).scanInputEventWithoutVerification(
        	productToBeSearched)
}

 /**
	 * searches for a product by setting product name
	 * @param productName (product to be added)
	 */ 
def static "iosOrders.orderDetailsScreen.searchProductInOrderDetailPage"(
    	String productName	) {
    (new iosOrders.orderDetailsScreen()).searchProductInOrderDetailPage(
        	productName)
}

 /**
	 * searches for a product by setting product name
	 * @param productName (product to be added)
	 */ 
def static "iosOrders.orderDetailsScreen.searchProductInOrderDetailPageOfflineMode"(
    	String productName	) {
    (new iosOrders.orderDetailsScreen()).searchProductInOrderDetailPageOfflineMode(
        	productName)
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
	 * takes user back to the search product results to continue browsing
	 */ 
def static "iosOrders.orderDetailsScreen.tapContinueOnDesktop"() {
    (new iosOrders.orderDetailsScreen()).tapContinueOnDesktop()
}

 /**
	 * taps on alternate to order in alternates page and opens confirmation pop up
	 */ 
def static "iosOrders.orderDetailsScreen.tapOnAddAlternateToOrderInAlternatesPage"() {
    (new iosOrders.orderDetailsScreen()).tapOnAddAlternateToOrderInAlternatesPage()
}

 /**
	 * adds product in product details page
	 */ 
def static "iosOrders.orderDetailsScreen.tapOnAddToOrderInProductDetailsPage"() {
    (new iosOrders.orderDetailsScreen()).tapOnAddToOrderInProductDetailsPage()
}

 /**
	 * opens alternates page
	 */ 
def static "iosOrders.orderDetailsScreen.tapOnAlternatesInProductDetailsPage"() {
    (new iosOrders.orderDetailsScreen()).tapOnAlternatesInProductDetailsPage()
}

 /**
	 * takes user back to the search product results to continue browsing
	 */ 
def static "iosOrders.orderDetailsScreen.tapOnContinueBrowsing"() {
    (new iosOrders.orderDetailsScreen()).tapOnContinueBrowsing()
}

 /**
	 * allows camera access while using real device
	 */ 
def static "iosOrders.orderDetailsScreen.tapOnOkForCameraAcess"() {
    (new iosOrders.orderDetailsScreen()).tapOnOkForCameraAcess()
}

 /**
	 * taps on search key of the keyboard
	 */ 
def static "iosOrders.orderDetailsScreen.tapOnsearchKeyInOfflineMode"() {
    (new iosOrders.orderDetailsScreen()).tapOnsearchKeyInOfflineMode()
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
	 * verifies c2 order is not visible under non c2 order
	 */ 
def static "iosOrders.orderDetailsScreen.verifyC2OrderIsNotVisibleUnderNonC2Order"() {
    (new iosOrders.orderDetailsScreen()).verifyC2OrderIsNotVisibleUnderNonC2Order()
}

 /**
	 * verifies confirmation pop up in alternates page
	 */ 
def static "iosOrders.orderDetailsScreen.verifyConfirmationPopUpInALternatesPage"() {
    (new iosOrders.orderDetailsScreen()).verifyConfirmationPopUpInALternatesPage()
}

 /**
	 * verifies filterByOptions
	 */ 
def static "iosOrders.orderDetailsScreen.verifyFilterByOptions"() {
    (new iosOrders.orderDetailsScreen()).verifyFilterByOptions()
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
	 * verifies order details screen when user in offline mode
	 */ 
def static "iosOrders.orderDetailsScreen.verifyOrderDetailsScreenInOfflineMode"() {
    (new iosOrders.orderDetailsScreen()).verifyOrderDetailsScreenInOfflineMode()
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
	 * verifies order name header label
	 * @param poName (poName is the order name)
	 */ 
def static "iosOrders.orderDetailsScreen.verifyOrderNameHeaderLabel"(
    	String poName	) {
    (new iosOrders.orderDetailsScreen()).verifyOrderNameHeaderLabel(
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
	 * verifies place order confirmation pop up
	 */ 
def static "iosOrders.orderDetailsScreen.verifyPlaceOrderPopUp"() {
    (new iosOrders.orderDetailsScreen()).verifyPlaceOrderPopUp()
}

 /**
	 * this function verifies the product after search
	 */ 
def static "iosOrders.orderDetailsScreen.verifyProductAfterSearch"() {
    (new iosOrders.orderDetailsScreen()).verifyProductAfterSearch()
}

 /**
	 * this function verifies the product details page
	 */ 
def static "iosOrders.orderDetailsScreen.verifyProductDetailAfterSelectingMoreDetails"(
    	String orderNameInSearchPage	) {
    (new iosOrders.orderDetailsScreen()).verifyProductDetailAfterSelectingMoreDetails(
        	orderNameInSearchPage)
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
	 * verifies that the added top most product should  be visible on the order details page
	 * @param productname (top most added product name)
	 */ 
def static "iosOrders.orderDetailsScreen.verifyProductNameIsVisibleUnderOrderDetails"(
    	String productname	) {
    (new iosOrders.orderDetailsScreen()).verifyProductNameIsVisibleUnderOrderDetails(
        	productname)
}

 /**
	 * this function verifies the product tile
	 */ 
def static "iosOrders.orderDetailsScreen.verifyProductTile"() {
    (new iosOrders.orderDetailsScreen()).verifyProductTile()
}

 /**
	 * verified user is taken to scan result screen after tapping on continue browsing button
	 */ 
def static "iosOrders.orderDetailsScreen.verifyScanResultScreenWithProduct"() {
    (new iosOrders.orderDetailsScreen()).verifyScanResultScreenWithProduct()
}

 /**
	 * verifies the pop up which appears after user clicks on upload order
	 */ 
def static "iosOrders.orderDetailsScreen.verifyUploadOrderPopUp"() {
    (new iosOrders.orderDetailsScreen()).verifyUploadOrderPopUp()
}

 /**
	 * verifies only last 6 digit got deleted, first 3 characters could not be removed & validation error displayed after removing characters
	 */ 
def static "iosOrders.orderDetailsScreen.verifyValidationErrorAfterRemovingCharactesInUTNField"() {
    (new iosOrders.orderDetailsScreen()).verifyValidationErrorAfterRemovingCharactesInUTNField()
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
	 * Closes the opened fly-out
	 */ 
def static "androidCommonKeywords.emergencyOrderingMode.CloseFlyout"() {
    (new androidCommonKeywords.emergencyOrderingMode()).CloseFlyout()
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
	 * selects the user account from the accounts list and takes user to the dashboard screen
	 * @param accountNo (user account number to be selected)
	 */ 
def static "androidAccountSelection.selectAnAccount.selectAnotherAccount"(
    	String accountNo	) {
    (new androidAccountSelection.selectAnAccount()).selectAnotherAccount(
        	accountNo)
}

 /**
	 * Change account
	 */ 
def static "androidAccountSelection.selectAnAccount.changeAccount"() {
    (new androidAccountSelection.selectAnAccount()).changeAccount()
}

 /**
	 * It verify the Audits account
	 */ 
def static "androidAccountSelection.selectAnAccount.verifyAccount"(
    	String first_account	) {
    (new androidAccountSelection.selectAnAccount()).verifyAccount(
        	first_account)
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
	 * this function changes account from change account navigation in the audits landing Screen
	 */ 
def static "iosAudits.auditsScreen.change_Account"(
    	String new_Account	) {
    (new iosAudits.auditsScreen()).change_Account(
        	new_Account)
}


def static "iosAudits.auditsScreen.clickOnQuantityBox"() {
    (new iosAudits.auditsScreen()).clickOnQuantityBox()
}

 /**
	 * this function verifies the audits landing Screen
	 */ 
def static "iosAudits.auditsScreen.closeChangeAccountPrompt"() {
    (new iosAudits.auditsScreen()).closeChangeAccountPrompt()
}

 /**
	 * gets final count value
	 * taps on confirmAuditCount button
	 * returns the final count value
	 */ 
def static "iosAudits.auditsScreen.confirmAuditCount"() {
    (new iosAudits.auditsScreen()).confirmAuditCount()
}

 /**
	 * verifies initial count value
	 * taps on - button
	 * verifies the count is decreased
	 */ 
def static "iosAudits.auditsScreen.decreaseCount"() {
    (new iosAudits.auditsScreen()).decreaseCount()
}

 /**
	 * verifies initial count value
	 * taps on + button
	 * verifies the count is increased
	 */ 
def static "iosAudits.auditsScreen.increaseCount"() {
    (new iosAudits.auditsScreen()).increaseCount()
}

 /**
	 * this function performs long press on quantity count box
	 */ 
def static "iosAudits.auditsScreen.longPressOnQuantityBox"() {
    (new iosAudits.auditsScreen()).longPressOnQuantityBox()
}

 /**
	 * taps on all the quantity boxes for a product
	 */ 
def static "iosAudits.auditsScreen.selectAllQuantityBoxes"() {
    (new iosAudits.auditsScreen()).selectAllQuantityBoxes()
}

 /**
	 * verifies the submit completed groups button and taps on it
	 */ 
def static "iosAudits.auditsScreen.submitCompletedGroups"() {
    (new iosAudits.auditsScreen()).submitCompletedGroups()
}

 /**
	 * this function verifies the audits landing Screen
	 */ 
def static "iosAudits.auditsScreen.verifyAuditsLandingScreen"() {
    (new iosAudits.auditsScreen()).verifyAuditsLandingScreen()
}

 /**
	 * verifies the final count value with the audit list count
	 */ 
def static "iosAudits.auditsScreen.verifyQuantity"(
    	int quantity	) {
    (new iosAudits.auditsScreen()).verifyQuantity(
        	quantity)
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
	 * taps on scan icon and takes user to scanning product screen and also verifies that the default toggle is at ordering
	 */ 
def static "iosOrders.cartScreen.clickOnScanIcon"() {
    (new iosOrders.cartScreen()).clickOnScanIcon()
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
	 * delete's the C2 order from the cart screen based on the purchase order name
	 * seperate delete method for c2 as locators for c2 order tile not available...when done remove this method
	 */ 
def static "iosOrders.cartScreen.deleteC2Order"() {
    (new iosOrders.cartScreen()).deleteC2Order()
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
	 * opens the c2 order details
	 */ 
def static "iosOrders.cartScreen.openC2OrderDetails"() {
    (new iosOrders.cartScreen()).openC2OrderDetails()
}

 /**
	 * this function returns the order name of the order which is at the top of the order list
	 * return orderName (returns topmost order name)
	 */ 
def static "iosOrders.cartScreen.returnTopMostOrderName"() {
    (new iosOrders.cartScreen()).returnTopMostOrderName()
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
	 * uploads all order by clicking on upload all orders button on cart screen
	 */ 
def static "iosOrders.cartScreen.uploadAllOrders"() {
    (new iosOrders.cartScreen()).uploadAllOrders()
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
	 *verifies C2 order view
	 */ 
def static "iosOrders.cartScreen.verifyC2OrderViewIsNotVisible"() {
    (new iosOrders.cartScreen()).verifyC2OrderViewIsNotVisible()
}

 /**
	 * verifies cart screen with any product being added
	 */ 
def static "iosOrders.cartScreen.verifyCartScreenWithAddedProduct"() {
    (new iosOrders.cartScreen()).verifyCartScreenWithAddedProduct()
}

 /**
	 * verifies cart screen without any product being added
	 */ 
def static "iosOrders.cartScreen.verifyCartScreenWithoutAnyOrderPresent"() {
    (new iosOrders.cartScreen()).verifyCartScreenWithoutAnyOrderPresent()
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
	 * takes expected lines count as the argument and verifies the same
	 * @param expectedLinesCount (expected lines count after adding products to the cart)
	 */ 
def static "iosOrders.cartScreen.verifyLinesCount"(
    	String expectedLinesCount	) {
    (new iosOrders.cartScreen()).verifyLinesCount(
        	expectedLinesCount)
}

 /**
	 * takes expected mobile orders count as the argument and verifies the same
	 * @param expected mobile orders count (expected mobile orders count after adding products to the cart)
	 */ 
def static "iosOrders.cartScreen.verifyMobileOrdersCount"(
    	String expectedMobileOrdersCount	) {
    (new iosOrders.cartScreen()).verifyMobileOrdersCount(
        	expectedMobileOrdersCount)
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
	 * this function verifies the pattern required for the order which was created without giving any purchase order name
	 * @param orderName (order name which is under verification)
	 */ 
def static "iosOrders.cartScreen.verifyOrderNamePattern"(
    	String orderName	) {
    (new iosOrders.cartScreen()).verifyOrderNamePattern(
        	orderName)
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
	 * taps on scan icon;selects count type
	 * and inputs scan event:
	 * will keep on scanning depending on the counter value passed
	 * @param countType (array an be partial or full count)
	 * @param productSearch (NDC/CIN/UPC/NAME)
	 * @param noOfIteratoins (no of times user wants to scan the products)
	 */ 
def static "iosInventory.locationDetailsScreen.inventoryCompleteScanFlow"(
    	String[] countType	
     , 	String[] productSearch	
     , 	int noOfIteratoins	) {
    (new iosInventory.locationDetailsScreen()).inventoryCompleteScanFlow(
        	countType
         , 	productSearch
         , 	noOfIteratoins)
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

 /**
	 * taps on cancel button for update if popUp is visible
	 */ 
def static "iosLogin.loginScreen.cancelUpdatePopUp"() {
    (new iosLogin.loginScreen()).cancelUpdatePopUp()
}


def static "iosLogin.loginScreen.selectTypeOfTesting"() {
    (new iosLogin.loginScreen()).selectTypeOfTesting()
}

 /**
	 * Edit location Name
	 */ 
def static "androidInventory.locationDetailsScreen.editLocationName"(
    	String newLocationName	
     , 	String costType	
     , 	String previousName	) {
    (new androidInventory.locationDetailsScreen()).editLocationName(
        	newLocationName
         , 	costType
         , 	previousName)
}

 /**
	 * add product to the inventory
	 */ 
def static "androidInventory.locationDetailsScreen.addProductToLocation"(
    	String locationName	
     , 	String productName	
     , 	String quantity	) {
    (new androidInventory.locationDetailsScreen()).addProductToLocation(
        	locationName
         , 	productName
         , 	quantity)
}

 /**
	 * uploads location from the location details screen
	 */ 
def static "androidInventory.locationDetailsScreen.uploadLocation"() {
    (new androidInventory.locationDetailsScreen()).uploadLocation()
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
	 * scans the product and adds it to the location
	 */ 
def static "androidInventory.locationDetailsScreen.addProducToLocation"() {
    (new androidInventory.locationDetailsScreen()).addProducToLocation()
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

 /**
	 * this function verifies that the product is not visible on the location details screen
	 * @param productNdcNumber (using NDC of the product which is visible on the product tab)
	 * if in future upc/cin are visible then the method can be modified accordingly by passing the respective test object
	 */ 
def static "androidInventory.locationDetailsScreen.verifyProductIsVisibleOnTheLocationDetailsScreen"(
    	Object productNdcNumber	) {
    (new androidInventory.locationDetailsScreen()).verifyProductIsVisibleOnTheLocationDetailsScreen(
        	productNdcNumber)
}

 /**
	 * this function taps on remove button and then product entry should get removed from the location as well as the scan result screen
	 */ 
def static "androidInventory.locationDetailsScreen.clickOnRemoveButtonToRemoveAlreadyScannedProduct"() {
    (new androidInventory.locationDetailsScreen()).clickOnRemoveButtonToRemoveAlreadyScannedProduct()
}

 /**
	 * this function verifies that the product is visible on the location details screen
	 * @param productNdcNumber (using NDC of the product which is visible on the product tab)
	 * if in future upc/cin are visible then the method can be modified accordingly by passing the respective test object
	 */ 
def static "androidInventory.locationDetailsScreen.verifyProductIsNotVisibleOnTheLocationDetailsScreen"(
    	Object productNdcNumber	) {
    (new androidInventory.locationDetailsScreen()).verifyProductIsNotVisibleOnTheLocationDetailsScreen(
        	productNdcNumber)
}

 /**
	 * copies products from a location to another location
	 * @param locationName (name of the location to which product will be copied)
	 * @param productNdcNumber (using NDC of the product which is visible on the product tab)
	 * if in future upc/cin are visible then the method can be modified accordingly by passing the respective test object	 */ 
def static "androidInventory.locationDetailsScreen.copyProductToAnotherLocation"(
    	String locationName	
     , 	String productNdcNumber	) {
    (new androidInventory.locationDetailsScreen()).copyProductToAnotherLocation(
        	locationName
         , 	productNdcNumber)
}

 /**
	 * this function gets the count type of the added product and verifies whether that is equal to the expected count type
	 */ 
def static "androidInventory.locationDetailsScreen.verifyCountTypeOfProduct"(
    	String expectedCountType	) {
    (new androidInventory.locationDetailsScreen()).verifyCountTypeOfProduct(
        	expectedCountType)
}

 /**
	 * moves products from a location to another location
	 * @param locationName (name of the location to which product will be moved)
	 * @param productNdcNumber (using NDC of the product which is visible on the product tab)
	 * if in future upc/cin are visible then the method can be modified accordingly by passing the respective test object	 */ 
def static "androidInventory.locationDetailsScreen.moveProductToAnotherLocation"(
    	String locationName	
     , 	String productNdcNumber	) {
    (new androidInventory.locationDetailsScreen()).moveProductToAnotherLocation(
        	locationName
         , 	productNdcNumber)
}

 /**
	 * this function verifies the lines count
	 * @param expectedLinesCount (expected lines Count)
	 */ 
def static "androidInventory.locationDetailsScreen.verifyLinesCount"(
    	String expectedLinesCount	) {
    (new androidInventory.locationDetailsScreen()).verifyLinesCount(
        	expectedLinesCount)
}

 /**
	 * adds alternate product
	 * @param productName (name of the product)
	 * @param quantity (quantity of the product)
	 */ 
def static "androidOrders.orderDetailsScreen.addAlternateProduct"(
    	String productName	
     , 	String quantity	) {
    (new androidOrders.orderDetailsScreen()).addAlternateProduct(
        	productName
         , 	quantity)
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
	 * this function adds the quantity for the product to be searched
	 * @param quantity (quantity required to be added for the product to be searched)
	 */ 
def static "androidOrders.orderDetailsScreen.addQuantityforTheSearchedProduct"(
    	int quantity	) {
    (new androidOrders.orderDetailsScreen()).addQuantityforTheSearchedProduct(
        	quantity)
}

 /**
	 * this function adds the quantity in alternates page
	 * @param quantity (quantity required to add in product detail page)
	 */ 
def static "androidOrders.orderDetailsScreen.addQuantityInAlternatesPage"(
    	int quantity	) {
    (new androidOrders.orderDetailsScreen()).addQuantityInAlternatesPage(
        	quantity)
}

 /**
	 * this function adds the quantity in product detail page
	 * @param quantity (quantity required to add in product detail page)
	 */ 
def static "androidOrders.orderDetailsScreen.addQuantityInProductDetailsPage"(
    	int quantity	) {
    (new androidOrders.orderDetailsScreen()).addQuantityInProductDetailsPage(
        	quantity)
}

 /**
	 * adds product
	 */ 
def static "androidOrders.orderDetailsScreen.addToOrderWithoutVerify"() {
    (new androidOrders.orderDetailsScreen()).addToOrderWithoutVerify()
}

 /**
	 * clicks on c2 order availability and waits for the response while verifying the availability details for the c2 product
	 */ 
def static "androidOrders.orderDetailsScreen.checkC2ProductAvailability"() {
    (new androidOrders.orderDetailsScreen()).checkC2ProductAvailability()
}

 /**
	 * takes user back to cart
	 */ 
def static "androidOrders.orderDetailsScreen.clickOnBackToCart"() {
    (new androidOrders.orderDetailsScreen()).clickOnBackToCart()
}

 /**
	 * takes user back to the search product results to continue ordering
	 */ 
def static "androidOrders.orderDetailsScreen.clickOnContinueOrdering"() {
    (new androidOrders.orderDetailsScreen()).clickOnContinueOrdering()
}

 /**
	 * takes user back to the search product results to continue browsing
	 */ 
def static "androidOrders.orderDetailsScreen.clickOnContinueOrderingOnDesktop"() {
    (new androidOrders.orderDetailsScreen()).clickOnContinueOrderingOnDesktop()
}

 /**
	 * opens more details of product details
	 */ 
def static "androidOrders.orderDetailsScreen.clickOnMoreDetails"() {
    (new androidOrders.orderDetailsScreen()).clickOnMoreDetails()
}

 /**
	 * places the order 
	 */ 
def static "androidOrders.orderDetailsScreen.clickOnPlaceOrder"() {
    (new androidOrders.orderDetailsScreen()).clickOnPlaceOrder()
}

 /**
	 * opens product tile
	 */ 
def static "androidOrders.orderDetailsScreen.clickOnProductTile"() {
    (new androidOrders.orderDetailsScreen()).clickOnProductTile()
}

 /**
	 * takes user back to history screen and verifies user is on the history screen or not
	 */ 
def static "androidOrders.orderDetailsScreen.clickOnReviewAndSignButton"() {
    (new androidOrders.orderDetailsScreen()).clickOnReviewAndSignButton()
}

 /**
	 * taps on scan icon and takes user to scanning product screen and also verifies ordering and price check
	 */ 
def static "androidOrders.orderDetailsScreen.clickOnScanIcon"() {
    (new androidOrders.orderDetailsScreen()).clickOnScanIcon()
}

 /**
	 *  taps on scan icon and takes user to scanning product screen
	 */ 
def static "androidOrders.orderDetailsScreen.clickOnScanIconWithoutVerification"() {
    (new androidOrders.orderDetailsScreen()).clickOnScanIconWithoutVerification()
}

 /**
	 * confirms place order by clicking on place my order button
	 */ 
def static "androidOrders.orderDetailsScreen.confirmPlaceOrder"() {
    (new androidOrders.orderDetailsScreen()).confirmPlaceOrder()
}

 /**
	 * opens confirmation pop up 
	 */ 
def static "androidOrders.orderDetailsScreen.continueOnDesktop"() {
    (new androidOrders.orderDetailsScreen()).continueOnDesktop()
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
	 * creates a new C2 order
	 * @param poName (poName of the order), poMemo (poMemo of the order)
	 */ 
def static "androidOrders.orderDetailsScreen.createNewOrderForC2WithoutVerification"(
    	String poName	
     , 	String poMemo	) {
    (new androidOrders.orderDetailsScreen()).createNewOrderForC2WithoutVerification(
        	poName
         , 	poMemo)
}

 /**
	 * edits poname and pomemo
	 * @param poName (poName of the order)
	 * @param poName (poMemo of the order)
	 */ 
def static "androidOrders.orderDetailsScreen.editPONameAndMemo"(
    	String poName	
     , 	String poMemo	
     , 	String newPoName	
     , 	String newPoMemo	) {
    (new androidOrders.orderDetailsScreen()).editPONameAndMemo(
        	poName
         , 	poMemo
         , 	newPoName
         , 	newPoMemo)
}

 /**
	 * enables radio button and adds c2 product
	 * @param poName (poName of the order)
	 */ 
def static "androidOrders.orderDetailsScreen.enableRadioButtonForNewOrderC2Creation"(
    	String poName	) {
    (new androidOrders.orderDetailsScreen()).enableRadioButtonForNewOrderC2Creation(
        	poName)
}

 /**
	 * It checks Duplicate utn number
	 * @param existingUTNno (utn number)
	 * @param duplicateErrorMsg (error message)
	 */ 
def static "androidOrders.orderDetailsScreen.enterDuplicateUTN"(
    	String existingUTNno	
     , 	String duplicateErrorMsg	) {
    (new androidOrders.orderDetailsScreen()).enterDuplicateUTN(
        	existingUTNno
         , 	duplicateErrorMsg)
}

 /**
	 * removes product from orders details
	 */ 
def static "androidOrders.orderDetailsScreen.removeProduct"() {
    (new androidOrders.orderDetailsScreen()).removeProduct()
}

 /**
	 * this function returns the cost of added product
	 * @return productCost (of the product which has been added)
	 */ 
def static "androidOrders.orderDetailsScreen.returnCostOfTheAddedProduct"() {
    (new androidOrders.orderDetailsScreen()).returnCostOfTheAddedProduct()
}

 /**
	 * this function returns the order name of the order/ title of the screen when user is on order details screen
	 * return orderName (returns order name/ title of order details screen)
	 */ 
def static "androidOrders.orderDetailsScreen.returnNDCLabelOfScannedProduct"() {
    (new androidOrders.orderDetailsScreen()).returnNDCLabelOfScannedProduct()
}

 /**
	 * this function returns the order name of the order/ title of the screen when user is on order details screen
	 * return orderName (returns order name/ title of order details screen)
	 */ 
def static "androidOrders.orderDetailsScreen.returnOrderNameFromOrderDetailScreen"() {
    (new androidOrders.orderDetailsScreen()).returnOrderNameFromOrderDetailScreen()
}

 /**
	 * this function returns the order value
	 * @return actualOrderTotal(order total value)
	 */ 
def static "androidOrders.orderDetailsScreen.returnOrderValue"() {
    (new androidOrders.orderDetailsScreen()).returnOrderValue()
}

 /**
	 * this function returns the order name in search page
	 */ 
def static "androidOrders.orderDetailsScreen.returnProductNameAfterSearch"() {
    (new androidOrders.orderDetailsScreen()).returnProductNameAfterSearch()
}

 /**
	 * this function gets the total added quantity of the product
	 * @return quantityNumericalValue (of the product which has been added)
	 */ 
def static "androidOrders.orderDetailsScreen.returnQuantityOfTheAddedProduct"() {
    (new androidOrders.orderDetailsScreen()).returnQuantityOfTheAddedProduct()
}

 /**
	 * this function returns the top most product name in order details page
	 */ 
def static "androidOrders.orderDetailsScreen.returnTopMostProductNameInOrderDetails"() {
    (new androidOrders.orderDetailsScreen()).returnTopMostProductNameInOrderDetails()
}

 /**
	 * Its save for later
	 */ 
def static "androidOrders.orderDetailsScreen.saveForLater"() {
    (new androidOrders.orderDetailsScreen()).saveForLater()
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
	 * scans the product in offline mode
	 * @param productToBeSearched (name which can be a productName/Cin/NDC of the product to be added)
	 */ 
def static "androidOrders.orderDetailsScreen.scanInputEventInOfflineMode"(
    	String productToBeSearched	) {
    (new androidOrders.orderDetailsScreen()).scanInputEventInOfflineMode(
        	productToBeSearched)
}

 /**
	 * scans the product while on price check, adds it to the order and also verifies some scan input details
	 * @param productToBeSearched (name which can be a productName/Cin/NDC of the product to be added)
	 */ 
def static "androidOrders.orderDetailsScreen.scanInputEventWhileOnPriceCheck"(
    	String productToBeSearched	) {
    (new androidOrders.orderDetailsScreen()).scanInputEventWhileOnPriceCheck(
        	productToBeSearched)
}

 /**
	 * scans the product, adds it to the order 
	 * @param productToBeSearched (name which can be a productName/Cin/NDC of the product to be added)
	 */ 
def static "androidOrders.orderDetailsScreen.scanInputEventWithoutVerification"(
    	String productToBeSearched	) {
    (new androidOrders.orderDetailsScreen()).scanInputEventWithoutVerification(
        	productToBeSearched)
}

 /**
	 * searches for a product by setting product name 
	 * @param productName (product to be added)
	 */ 
def static "androidOrders.orderDetailsScreen.searchProductInOrderDetailPage"(
    	String productName	) {
    (new androidOrders.orderDetailsScreen()).searchProductInOrderDetailPage(
        	productName)
}

 /**
	 * searches for a product by setting product name
	 * @param productName (product to be added)
	 */ 
def static "androidOrders.orderDetailsScreen.searchProductInOrderDetailPageOfflineMode"(
    	String productName	) {
    (new androidOrders.orderDetailsScreen()).searchProductInOrderDetailPageOfflineMode(
        	productName)
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
	 * taps on alternate to order in alternates page and opens confirmation pop up
	 */ 
def static "androidOrders.orderDetailsScreen.tapOnAddAlternateToOrderInAlternatesPage"() {
    (new androidOrders.orderDetailsScreen()).tapOnAddAlternateToOrderInAlternatesPage()
}

 /**
	 * adds product in product details page
	 */ 
def static "androidOrders.orderDetailsScreen.tapOnAddToOrderInProductDetailsPage"() {
    (new androidOrders.orderDetailsScreen()).tapOnAddToOrderInProductDetailsPage()
}

 /**
	 * taps on add to order and shows confirmation pop up
	 */ 
def static "androidOrders.orderDetailsScreen.tapOnAddToOrderInScanSearchResults"() {
    (new androidOrders.orderDetailsScreen()).tapOnAddToOrderInScanSearchResults()
}

 /**
	 * opens alternates page
	 * @param Alternates (alternates to be selected)
	 */ 
def static "androidOrders.orderDetailsScreen.tapOnAlternatesInProductDetailsPage"(
    	String Alternates	) {
    (new androidOrders.orderDetailsScreen()).tapOnAlternatesInProductDetailsPage(
        	Alternates)
}

 /**
	 * takes user back to the search product results to continue browsing
	 */ 
def static "androidOrders.orderDetailsScreen.tapOnContinueBrowsing"() {
    (new androidOrders.orderDetailsScreen()).tapOnContinueBrowsing()
}

 /**
	 * takes user to the order details
	 */ 
def static "androidOrders.orderDetailsScreen.tapOnGoToOrder"() {
    (new androidOrders.orderDetailsScreen()).tapOnGoToOrder()
}

 /**
	 * opens create new order page for c2
	 */ 
def static "androidOrders.orderDetailsScreen.tapOnSelectOrCrateANewOrderInScanSearchResults"() {
    (new androidOrders.orderDetailsScreen()).tapOnSelectOrCrateANewOrderInScanSearchResults()
}

 /**
	 * uploads the order 
	 */ 
def static "androidOrders.orderDetailsScreen.uploadOrder"() {
    (new androidOrders.orderDetailsScreen()).uploadOrder()
}

 /**
	 * uploads the c2 order 
	 */ 
def static "androidOrders.orderDetailsScreen.uploadOrderC2"() {
    (new androidOrders.orderDetailsScreen()).uploadOrderC2()
}

 /**
	 * Its check UTN number validation
	 * @param utnPrefixLength (length of the utn prefix)
	 * @param expectedErrorMsg (error message)
	 * @param input1 (given input for utn edit text field)
	 * @param input2 (given input for utn edit text field)
	 */ 
def static "androidOrders.orderDetailsScreen.utnNumberValidation"(
    	int utnPrefixLength	
     , 	String expectedErrorMsg	
     , 	String input1	
     , 	String input2	) {
    (new androidOrders.orderDetailsScreen()).utnNumberValidation(
        	utnPrefixLength
         , 	expectedErrorMsg
         , 	input1
         , 	input2)
}

 /**
	 * verifies c2 label is visible or not
	 */ 
def static "androidOrders.orderDetailsScreen.verifyC2Label"() {
    (new androidOrders.orderDetailsScreen()).verifyC2Label()
}

 /**
	 * verifies c2 order is not visible under non c2 order
	 */ 
def static "androidOrders.orderDetailsScreen.verifyC2OrderIsNotVisibleUnderNonC2Order"() {
    (new androidOrders.orderDetailsScreen()).verifyC2OrderIsNotVisibleUnderNonC2Order()
}

 /**
	 * verifies confirmation pop up after adding c2 order 
	 */ 
def static "androidOrders.orderDetailsScreen.verifyConfirmationPopUpAfterAddingC2Order"() {
    (new androidOrders.orderDetailsScreen()).verifyConfirmationPopUpAfterAddingC2Order()
}

 /**
	 * verifies confirmation pop up in alternates page 
	 */ 
def static "androidOrders.orderDetailsScreen.verifyConfirmationPopUpInALternatesPage"() {
    (new androidOrders.orderDetailsScreen()).verifyConfirmationPopUpInALternatesPage()
}

 /**
	 * after selecting add to order verifies item added confirmation popup in scan search results 
	 */ 
def static "androidOrders.orderDetailsScreen.verifyConfirmationPopUpInScanSearchResults"() {
    (new androidOrders.orderDetailsScreen()).verifyConfirmationPopUpInScanSearchResults()
}

 /**
	 * verifies confirmation pop up of c2 in scan search results
	 */ 
def static "androidOrders.orderDetailsScreen.verifyConfirmationPopUpOfC2InScanSearchResults"() {
    (new androidOrders.orderDetailsScreen()).verifyConfirmationPopUpOfC2InScanSearchResults()
}

 /**
	 * verifies filterByOptions
	 * @param Alternates (alternates to be selected)
	 */ 
def static "androidOrders.orderDetailsScreen.verifyFilterByOptions"(
    	String Alternates	) {
    (new androidOrders.orderDetailsScreen()).verifyFilterByOptions(
        	Alternates)
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
	 * verifies order details screen when user in offline mode
	 */ 
def static "androidOrders.orderDetailsScreen.verifyOrderDetailsScreenInOfflineMode"() {
    (new androidOrders.orderDetailsScreen()).verifyOrderDetailsScreenInOfflineMode()
}

 /**
	 * verifies order has been sent to desktop pop up
	 */ 
def static "androidOrders.orderDetailsScreen.verifyOrderHasbeensentToDesktopPopUp"() {
    (new androidOrders.orderDetailsScreen()).verifyOrderHasbeensentToDesktopPopUp()
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
	 * verifies order screen details with added product
	 */ 
def static "androidOrders.orderDetailsScreen.verifyOrderScreenDetailsWithAddedProduct"() {
    (new androidOrders.orderDetailsScreen()).verifyOrderScreenDetailsWithAddedProduct()
}

 /**
	 * verifies order screen details without any added product
	 */ 
def static "androidOrders.orderDetailsScreen.verifyOrderScreenDetailsWithoutAnyAddedProduct"() {
    (new androidOrders.orderDetailsScreen()).verifyOrderScreenDetailsWithoutAnyAddedProduct()
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
	 * verifies place order confirmation pop up
	 */ 
def static "androidOrders.orderDetailsScreen.verifyPlaceOrderPopUp"() {
    (new androidOrders.orderDetailsScreen()).verifyPlaceOrderPopUp()
}

 /**
	 * this function verifies the product after search
	 */ 
def static "androidOrders.orderDetailsScreen.verifyProductAfterSearch"() {
    (new androidOrders.orderDetailsScreen()).verifyProductAfterSearch()
}

 /**
	 * this function verifies the product details page
	 * @param orderNameInSearchPage (order name of the product)
	 */ 
def static "androidOrders.orderDetailsScreen.verifyProductDetailAfterSelectingMoreDetails"(
    	String orderNameInSearchPage	) {
    (new androidOrders.orderDetailsScreen()).verifyProductDetailAfterSelectingMoreDetails(
        	orderNameInSearchPage)
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
	 * verifies that the added top most product should  be visible on the order details page
	 * @param productname (top most added product name)
	 */ 
def static "androidOrders.orderDetailsScreen.verifyProductNameIsVisibleUnderOrderDetails"(
    	String productname	) {
    (new androidOrders.orderDetailsScreen()).verifyProductNameIsVisibleUnderOrderDetails(
        	productname)
}

 /**
	 * this function verifies the product tile
	 */ 
def static "androidOrders.orderDetailsScreen.verifyProductTile"() {
    (new androidOrders.orderDetailsScreen()).verifyProductTile()
}

 /**
	 * verifies quantity updated caption
	 */ 
def static "androidOrders.orderDetailsScreen.verifyQuantityUpdatedCaption"() {
    (new androidOrders.orderDetailsScreen()).verifyQuantityUpdatedCaption()
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
	 * adds location to an inventory based on the cost type of current or last price paid
	 * @param locationName (name of the location to be added)
	 * @param costType (cost type required which can be current or last price paid)
	 * @param noOfLocationsRequired (no of locations required to be added)
	 */ 
def static "iosInventory.inventoryDetailsScreen.addMultipleLocation"(
    	String locationName	
     , 	String costType	
     , 	int noOfLocationsRequired	) {
    (new iosInventory.inventoryDetailsScreen()).addMultipleLocation(
        	locationName
         , 	costType
         , 	noOfLocationsRequired)
}

 /**
	 * adds location to an inventory based on the cost type of current or last price paid
	 * @param locationName (name of the location to be added)
	 * @param costType (cost type required which can be current or last price paid)
	 * @param noOfLocationsRequired (no of locations required to be added)
	 * @param countType (array an be partial or full count)
	 * @param productSearch (NDC/CIN/UPC/NAME)
	 * @param noOfIteratoins (no of times user wants to scan the products)
	 */ 
def static "iosInventory.inventoryDetailsScreen.addMultipleLocationsWithScannedProduct"(
    	int locationNameLength	
     , 	String costType	
     , 	int noOfLocationsRequired	
     , 	String[] countType	
     , 	String[] productSearch	
     , 	int noOfIteratoinsForScanning	) {
    (new iosInventory.inventoryDetailsScreen()).addMultipleLocationsWithScannedProduct(
        	locationNameLength
         , 	costType
         , 	noOfLocationsRequired
         , 	countType
         , 	productSearch
         , 	noOfIteratoinsForScanning)
}

 /**
	 * adds location to an inventory based on the cost type of current or last price paid
	 * @param locationName (name of the location to be added)
	 * @param costType (cost type required which can be current or last price paid)
	 * @param noOfLocationsRequired (no of locations required to be added)
	 * @param countType (array an be partial or full count)
	 * @param productSearch (NDC/CIN/UPC/NAME)
	 * @param noOfIteratoins (no of times user wants to scan the products)
	 */ 
def static "iosInventory.inventoryDetailsScreen.addAndUploadMultipleLocationsWithScannedProduct"(
    	int locationNameLength	
     , 	String costType	
     , 	int noOfLocationsRequired	
     , 	String[] countType	
     , 	String[] productSearch	
     , 	int noOfIteratoinsForScanning	) {
    (new iosInventory.inventoryDetailsScreen()).addAndUploadMultipleLocationsWithScannedProduct(
        	locationNameLength
         , 	costType
         , 	noOfLocationsRequired
         , 	countType
         , 	productSearch
         , 	noOfIteratoinsForScanning)
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
	 * selects the user account from the accounts list and takes user to the dashboard screen
	 * @param accountNo (user account number to be selected)
	 */ 
def static "iosAccountSelection.selectAnAccount.selectAnotherAccount"(
    	String accountNo	) {
    (new iosAccountSelection.selectAnAccount()).selectAnotherAccount(
        	accountNo)
}

 /**
	 * Change account
	 */ 
def static "iosAccountSelection.selectAnAccount.tapOnAccountIcon"() {
    (new iosAccountSelection.selectAnAccount()).tapOnAccountIcon()
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

 /**
	 * clicks on history tab button to open history tab in order history screen
	 */ 
def static "androidOrders.historyScreen.clickOnHistoryTab"() {
    (new androidOrders.historyScreen()).clickOnHistoryTab()
}

 /**
	 * opens the c2 order details, verifies the order status labels and signIns the password required for placing c2 order
	 * @param password (password-which is required for placing the c2 order)
	 */ 
def static "androidOrders.historyScreen.completeReviewSignAndPlaceAnOrderFlow"(
    	String poNumber	
     , 	String signingPassword	) {
    (new androidOrders.historyScreen()).completeReviewSignAndPlaceAnOrderFlow(
        	poNumber
         , 	signingPassword)
}

 /**
	 * get order count from order history badge count
	 */ 
def static "androidOrders.historyScreen.getOrderBadgeCount"() {
    (new androidOrders.historyScreen()).getOrderBadgeCount()
}

 /**
	 * returns quantity added
	 */ 
def static "androidOrders.historyScreen.returnQuantityForScannedResultInOfflineMode"() {
    (new androidOrders.historyScreen()).returnQuantityForScannedResultInOfflineMode()
}

 /**
	 * returns po number of an top most order
	 */ 
def static "androidOrders.historyScreen.returnTopMostPoNumberOfAnOrder"() {
    (new androidOrders.historyScreen()).returnTopMostPoNumberOfAnOrder()
}

 /**
	 * opens top most order in order history
	 */ 
def static "androidOrders.historyScreen.tapOnTopMostOrderHistory"(
    	String poNumber	) {
    (new androidOrders.historyScreen()).tapOnTopMostOrderHistory(
        	poNumber)
}

 /**
	 * verifies history screen details
	 */ 
def static "androidOrders.historyScreen.verifyHistoryScreenDetails"() {
    (new androidOrders.historyScreen()).verifyHistoryScreenDetails()
}

 /**
	 * verifies order status changes from held to allocated 30 seconds after successfully placing the signed order
	 * @param poNumber (product number in order history)
	 */ 
def static "androidOrders.historyScreen.verifyOrderStatusInOrderHistoryList"(
    	String poNumber	) {
    (new androidOrders.historyScreen()).verifyOrderStatusInOrderHistoryList(
        	poNumber)
}

 /**
	 * verifies PO Number in order history screen
	 * @param poNumber (product number in order history)
	 */ 
def static "androidOrders.historyScreen.verifyPoNumberInOrderHistoryList"(
    	String poNumber	) {
    (new androidOrders.historyScreen()).verifyPoNumberInOrderHistoryList(
        	poNumber)
}

 /**
	 * switches the account of user to another account
	 * @param accountNo (accountNo which needs to be selected will be passed as a parameter)
	 */ 
def static "androidMoreOptions.moreOptionsScreen.changeAccount"(
    	Object accountNo	) {
    (new androidMoreOptions.moreOptionsScreen()).changeAccount(
        	accountNo)
}

 /**
	 * enables beta csos feature
	 */ 
def static "androidMoreOptions.moreOptionsScreen.enableBetaFeatureCSOS"() {
    (new androidMoreOptions.moreOptionsScreen()).enableBetaFeatureCSOS()
}

 /**
	 * takes the user from the the moreOptions Screen to inventory listing screen
	 */ 
def static "androidMoreOptions.moreOptionsScreen.goToInventoryListingScreen"() {
    (new androidMoreOptions.moreOptionsScreen()).goToInventoryListingScreen()
}

 /**
	 * clicks on moreOptions tab, signsOut the user and takes user to the logInScreen
	 */ 
def static "androidMoreOptions.moreOptionsScreen.signOut"() {
    (new androidMoreOptions.moreOptionsScreen()).signOut()
}

 /**
	 * opens the message center
	 */ 
def static "androidMoreOptions.moreOptionsScreen.tapMessageCentre"() {
    (new androidMoreOptions.moreOptionsScreen()).tapMessageCentre()
}

 /**
	 * opens top most message
	 */ 
def static "androidMoreOptions.moreOptionsScreen.tapOnTopMostMessage"() {
    (new androidMoreOptions.moreOptionsScreen()).tapOnTopMostMessage()
}

 /**
	 * verifies message
	 */ 
def static "androidMoreOptions.moreOptionsScreen.verifyMessageCentre"() {
    (new androidMoreOptions.moreOptionsScreen()).verifyMessageCentre()
}

 /**
	 * verifies message description
	 */ 
def static "androidMoreOptions.moreOptionsScreen.verifyMessageDescription"() {
    (new androidMoreOptions.moreOptionsScreen()).verifyMessageDescription()
}

 /**
	 * creates a test object at run time
	 * resourceId (resource-id of the object)
	 */ 
def static "androidReceiving.receivingReusableMethods.makeTestObject"(
    	String resourceId	) {
    (new androidReceiving.receivingReusableMethods()).makeTestObject(
        	resourceId)
}

 /**
	 * takes user back to receiving after uploading_totes
	 */ 
def static "androidReceiving.receivingReusableMethods.clickOnBackToReceiving"() {
    (new androidReceiving.receivingReusableMethods()).clickOnBackToReceiving()
}

 /**
	 * clicks on continue button after selection of shipments or invoice by user
	 */ 
def static "androidReceiving.receivingReusableMethods.clickOnContinue"() {
    (new androidReceiving.receivingReusableMethods()).clickOnContinue()
}

 /**
	 * clicks on got it issue
	 */ 
def static "androidReceiving.receivingReusableMethods.clickOnGotItbutton"() {
    (new androidReceiving.receivingReusableMethods()).clickOnGotItbutton()
}

 /**
	 * clicks on issue
	 */ 
def static "androidReceiving.receivingReusableMethods.clickOnIssue"() {
    (new androidReceiving.receivingReusableMethods()).clickOnIssue()
}

 /**
	 * clicks on receive all totes_button
	 */ 
def static "androidReceiving.receivingReusableMethods.clickOnReceiveAllTotes"() {
    (new androidReceiving.receivingReusableMethods()).clickOnReceiveAllTotes()
}

 /**
	 * click on scan icon
	 */ 
def static "androidReceiving.receivingReusableMethods.clickOnScanIcon"() {
    (new androidReceiving.receivingReusableMethods()).clickOnScanIcon()
}

 /**
	 * clicks on submit issue
	 */ 
def static "androidReceiving.receivingReusableMethods.clickOnSubmitIssue"() {
    (new androidReceiving.receivingReusableMethods()).clickOnSubmitIssue()
}

 /**
	 * collapses the detailed view of_tote
	 */ 
def static "androidReceiving.receivingReusableMethods.collpaseViewOfTotes"() {
    (new androidReceiving.receivingReusableMethods()).collpaseViewOfTotes()
}

 /**
	 * takes received product count as the argument and enters count in the text-field
	 * @param receivedProductCount (received product count)
	 */ 
def static "androidReceiving.receivingReusableMethods.editReceivedProductCount"(
    	int receivedProductCount	) {
    (new androidReceiving.receivingReusableMethods()).editReceivedProductCount(
        	receivedProductCount)
}

 /**
	 * enters detail for contact
	 * @param name
	 * @param phoneNumber
	 * @param emailID
	 * @param comment
	 */ 
def static "androidReceiving.receivingReusableMethods.enterDetailsForContact"(
    	String name	
     , 	String phoneNumber	
     , 	String comment	) {
    (new androidReceiving.receivingReusableMethods()).enterDetailsForContact(
        	name
         , 	phoneNumber
         , 	comment)
}

 /**
	 * expands the view to see detailed view of_tote
	 */ 
def static "androidReceiving.receivingReusableMethods.expandToSeeDetailedViewOfTotes"() {
    (new androidReceiving.receivingReusableMethods()).expandToSeeDetailedViewOfTotes()
}

 /**
	 * this function opens invoice details
	 * @param invoiceNumber (invoice number)
	 */ 
def static "androidReceiving.receivingReusableMethods.openInvoiceDetails"(
    	Object invoiceNumber	) {
    (new androidReceiving.receivingReusableMethods()).openInvoiceDetails(
        	invoiceNumber)
}

 /**
	 * this function opens shipment details
	 * @param shipmentNumber (shipment number)
	 */ 
def static "androidReceiving.receivingReusableMethods.openShipmentDetails"(
    	Object shipmentNumber	) {
    (new androidReceiving.receivingReusableMethods()).openShipmentDetails(
        	shipmentNumber)
}

 /**
	 * returns max upper value without over-age product count
	 * @return maxCount (max upper value without over-age product count)
	 */ 
def static "androidReceiving.receivingReusableMethods.returnUpperLimitReceivingProductCount"() {
    (new androidReceiving.receivingReusableMethods()).returnUpperLimitReceivingProductCount()
}

 /**
	 * takes product to be searched as the argument and searches for the product
	 * @param productToBeSearched (name which can be a productName/Cin/NDC of the product to be added)
	 */ 
def static "androidReceiving.receivingReusableMethods.scanInputEvent"(
    	String productToBeSearched	) {
    (new androidReceiving.receivingReusableMethods()).scanInputEvent(
        	productToBeSearched)
}

 /**
	 * takes toteID to be searched as the argument and searches the same
	 */ 
def static "androidReceiving.receivingReusableMethods.searchTote"(
    	Object toteID	) {
    (new androidReceiving.receivingReusableMethods()).searchTote(
        	toteID)
}

 /**
	 * allows over-ages in receiving
	 */ 
def static "androidReceiving.receivingReusableMethods.selectAllowOverages"() {
    (new androidReceiving.receivingReusableMethods()).selectAllowOverages()
}

 /**
	 * this function will select invoices on the receiving screen
	 */ 
def static "androidReceiving.receivingReusableMethods.selectInvoices"() {
    (new androidReceiving.receivingReusableMethods()).selectInvoices()
}

 /**
	 * select reason of issue
	 * @param reasonForIssue
	 */ 
def static "androidReceiving.receivingReusableMethods.selectReasonForIssue"(
    	String reasonForIssue	) {
    (new androidReceiving.receivingReusableMethods()).selectReasonForIssue(
        	reasonForIssue)
}

 /**
	 * this function will select shipments on the receiving screen
	 */ 
def static "androidReceiving.receivingReusableMethods.selectShipments"() {
    (new androidReceiving.receivingReusableMethods()).selectShipments()
}

 /**
	 * takes user to previous day shipments from today's shipments screen
	 */ 
def static "androidReceiving.receivingReusableMethods.switchToPreviousDay"() {
    (new androidReceiving.receivingReusableMethods()).switchToPreviousDay()
}

 /**
	 * takes user to today's shipments from previous day shipments screen
	 */ 
def static "androidReceiving.receivingReusableMethods.switchToToday"() {
    (new androidReceiving.receivingReusableMethods()).switchToToday()
}

 /**
	 * test method for run time object creation
	 */ 
def static "androidReceiving.receivingReusableMethods.testFunction"() {
    (new androidReceiving.receivingReusableMethods()).testFunction()
}

 /**
	 * uploads completed_totes
	 */ 
def static "androidReceiving.receivingReusableMethods.uploadCompletedTotes"() {
    (new androidReceiving.receivingReusableMethods()).uploadCompletedTotes()
}

 /**
	 * verifies that over-ages are allowed
	 */ 
def static "androidReceiving.receivingReusableMethods.verifyAllowedOverages"() {
    (new androidReceiving.receivingReusableMethods()).verifyAllowedOverages()
}

 /**
	 * verifies details of the instances of product associated with the account
	 * @param productNdcNumber (using NDC of the product which is visible on the product tab)
	 */ 
def static "androidReceiving.receivingReusableMethods.verifyInstancesOfProductAssociatedWithAccount"(
    	Object productNdcNumber	) {
    (new androidReceiving.receivingReusableMethods()).verifyInstancesOfProductAssociatedWithAccount(
        	productNdcNumber)
}

 /**
	 * verifies the invoice is not visible on the screen
	 * @param invoiceNumber (invoice number)
	 */ 
def static "androidReceiving.receivingReusableMethods.verifyInvoiceIsNotVisible"(
    	Object invoiceNumber	) {
    (new androidReceiving.receivingReusableMethods()).verifyInvoiceIsNotVisible(
        	invoiceNumber)
}

 /**
	 * this function verifies the invoice is visible on the screen
	 * @param invoiceNumber (invoice number)
	 */ 
def static "androidReceiving.receivingReusableMethods.verifyInvoiceIsVisible"(
    	Object invoiceNumber	) {
    (new androidReceiving.receivingReusableMethods()).verifyInvoiceIsVisible(
        	invoiceNumber)
}

 /**
	 * verify invoice number visible while submission of issue
	 */ 
def static "androidReceiving.receivingReusableMethods.verifyInvoiceNumberInIssue"(
    	Object invoiceNumber	) {
    (new androidReceiving.receivingReusableMethods()).verifyInvoiceNumberInIssue(
        	invoiceNumber)
}

 /**
	 * this method verifies the invoices detail
	 * @param invoiceNumber (invoice number)
	 */ 
def static "androidReceiving.receivingReusableMethods.verifyInvoicesDetails"(
    	Object invoiceNumber	) {
    (new androidReceiving.receivingReusableMethods()).verifyInvoicesDetails(
        	invoiceNumber)
}

 /**
	 * this method verifies the invoices detail
	 */ 
def static "androidReceiving.receivingReusableMethods.verifyInvoicesListScreenDetails"() {
    (new androidReceiving.receivingReusableMethods()).verifyInvoicesListScreenDetails()
}

 /**
	 * verifies if no new orders to be received
	 */ 
def static "androidReceiving.receivingReusableMethods.verifyNoNewOrdersToReceive"() {
    (new androidReceiving.receivingReusableMethods()).verifyNoNewOrdersToReceive()
}

 /**
	 * verifies pop up to allow over-age
	 */ 
def static "androidReceiving.receivingReusableMethods.verifyOveragePopUp"() {
    (new androidReceiving.receivingReusableMethods()).verifyOveragePopUp()
}

 /**
	 * verifies over-age tag is visible after inputting receiving count which is more than the max upper limit
	 */ 
def static "androidReceiving.receivingReusableMethods.verifyOverAgeTag"() {
    (new androidReceiving.receivingReusableMethods()).verifyOverAgeTag()
}

 /**
	 * this function verifies that the product is visible on the order details screen
	 * @param productNdcNumber (using NDC of the product which is visible on the product tab)
	 * if in future upc/cin are visible then the method can be modified accordingly by passing the respective test object
	 */ 
def static "androidReceiving.receivingReusableMethods.verifyProductIsVisibleOnTheReceivingScreen"(
    	Object productNdcNumber	) {
    (new androidReceiving.receivingReusableMethods()).verifyProductIsVisibleOnTheReceivingScreen(
        	productNdcNumber)
}

 /**
	 * verifies details of the product associated with the account
	 * @param productNdcNumber (using NDC of the product which is visible on the product tab)
	 */ 
def static "androidReceiving.receivingReusableMethods.verifyProductSearchDetals"(
    	Object productNdcNumber	) {
    (new androidReceiving.receivingReusableMethods()).verifyProductSearchDetals(
        	productNdcNumber)
}

 /**
	 * takes expected received product count as the argument and verifies that it should be same as the actual count visible
	 * @param expectedReceivedProductCount (expected received product count)
	 */ 
def static "androidReceiving.receivingReusableMethods.verifyReceivedProductCount"(
    	Object expectedReceivedProductCount	) {
    (new androidReceiving.receivingReusableMethods()).verifyReceivedProductCount(
        	expectedReceivedProductCount)
}

 /**
	 * verifies received tag is visible after inputting receiving count which is less or equal to the max upper limit
	 */ 
def static "androidReceiving.receivingReusableMethods.verifyReceivedTag"() {
    (new androidReceiving.receivingReusableMethods()).verifyReceivedTag()
}

 /**
	 * this function verifies the receiving screen details
	 */ 
def static "androidReceiving.receivingReusableMethods.verifyReceivingScreen"() {
    (new androidReceiving.receivingReusableMethods()).verifyReceivingScreen()
}

 /**
	 * verifies the receiving screen pop-up which comes after user goes to receiving tab details
	 */ 
def static "androidReceiving.receivingReusableMethods.verifyReceivingScreenPopUp"() {
    (new androidReceiving.receivingReusableMethods()).verifyReceivingScreenPopUp()
}

 /**
	 * verifies shipment details
	 * @param shipmentNumber (shipment number)
	 */ 
def static "androidReceiving.receivingReusableMethods.verifyShipmentDetails"(
    	Object shipmentNumber	) {
    (new androidReceiving.receivingReusableMethods()).verifyShipmentDetails(
        	shipmentNumber)
}

 /**
	 * this function verifies the shipment is visible on the screen
	 * @param shipmentNumber (shipment number)
	 */ 
def static "androidReceiving.receivingReusableMethods.verifyShipmentIsVisible"(
    	Object shipmentNumber	) {
    (new androidReceiving.receivingReusableMethods()).verifyShipmentIsVisible(
        	shipmentNumber)
}

 /**
	 * verify shipment number visible while submission of issue
	 */ 
def static "androidReceiving.receivingReusableMethods.verifyShipmentNumberInIssue"(
    	Object shipmentNumber	) {
    (new androidReceiving.receivingReusableMethods()).verifyShipmentNumberInIssue(
        	shipmentNumber)
}

 /**
	 * this function verifies the shipments detail
	 */ 
def static "androidReceiving.receivingReusableMethods.verifyShipmentsListScreenDetails"() {
    (new androidReceiving.receivingReusableMethods()).verifyShipmentsListScreenDetails()
}

 /**
	 * verifies details related to submission of issue and takes shipment number, tote id as the arguments
	 * @param shipmentNumber
	 * @param toteID
	 */ 
def static "androidReceiving.receivingReusableMethods.verifySubmissionDetails"(
    	Object toteID	) {
    (new androidReceiving.receivingReusableMethods()).verifySubmissionDetails(
        	toteID)
}

 /**
	 * verify submission of issue pop-up
	 */ 
def static "androidReceiving.receivingReusableMethods.verifySubmissionOfIssue"() {
    (new androidReceiving.receivingReusableMethods()).verifySubmissionOfIssue()
}

 /**
	 * verifies the pop up after uploading_totes
	 */ 
def static "androidReceiving.receivingReusableMethods.verifyUploadTotesPopUp"() {
    (new androidReceiving.receivingReusableMethods()).verifyUploadTotesPopUp()
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

 /**
	 * Edit an inventory name
	 * @param newInventoryName (name of the inventory to be added)
	 * @param previousName (name of the previous to be added)
	 */ 
def static "androidInventory.inventoryDetailsScreen.editInventoryName"(
    	String newInventoryName	
     , 	String previousName	) {
    (new androidInventory.inventoryDetailsScreen()).editInventoryName(
        	newInventoryName
         , 	previousName)
}

 /**
	 * Click on the location 
	 * @param locationName (name of the location)
	 */ 
def static "androidInventory.inventoryDetailsScreen.clickOnLocation"(
    	String locationName	) {
    (new androidInventory.inventoryDetailsScreen()).clickOnLocation(
        	locationName)
}

 /**
	 * Search the product 
	 * @param locationName (name of the location)
	 * @param productName (name of the product)
	 * @param costType (cost of the product)
	 * @param quantity (quantity of the product)
	 */ 
def static "androidInventory.inventoryDetailsScreen.searchAndAddProductByCreatingNewLocation"(
    	String locationName	
     , 	String productName	
     , 	String costType	
     , 	String quantity	) {
    (new androidInventory.inventoryDetailsScreen()).searchAndAddProductByCreatingNewLocation(
        	locationName
         , 	productName
         , 	costType
         , 	quantity)
}

 /**
	 * Verify inventory details
	 * @param inventoryName (name of the inventory)
	 */ 
def static "androidInventory.inventoryDetailsScreen.verifyInventoryDetailsScreen"(
    	String inventoryName	) {
    (new androidInventory.inventoryDetailsScreen()).verifyInventoryDetailsScreen(
        	inventoryName)
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

 /**
	 * searches and adds the product from the inventory details screen by creating a new location
	 * @param locationName (name of the location to be created)
	 * @param productName (name of the product to be added)
	 * @param countType (count type required which can be partial or full count)
	 * @param quantity (quantity of the product required to be added)
	 * @param costType (cost type required which can be current or last price paid)
	 */ 
def static "androidInventory.inventoryDetailsScreen.clickOnScanIconAndAddProductByCreatingNewLocationViaInventoryDetailsScreen"(
    	String locationName	
     , 	String productName	
     , 	String countType	
     , 	String quantity	
     , 	String costType	) {
    (new androidInventory.inventoryDetailsScreen()).clickOnScanIconAndAddProductByCreatingNewLocationViaInventoryDetailsScreen(
        	locationName
         , 	productName
         , 	countType
         , 	quantity
         , 	costType)
}

 /**
	 * this function verifies that the product is visible on the screen after it is searched from inventory details screen
	 * @param productIdentificationNumber (productIdentificationNumber of the product which can be NDC/Cin/UPC, which should be present on the screen)
	 */ 
def static "androidInventory.inventoryDetailsScreen.verifyProductIsVisibleOnScreenWhenSearchedFromInventoryDetailsScreen"(
    	Object productIdentificationNumber	) {
    (new androidInventory.inventoryDetailsScreen()).verifyProductIsVisibleOnScreenWhenSearchedFromInventoryDetailsScreen(
        	productIdentificationNumber)
}

 /**
	 * opens the particular location details
	 * @param locationName (name of the location)
	 */ 
def static "androidInventory.inventoryDetailsScreen.clickOnALocation"(
    	String locationName	) {
    (new androidInventory.inventoryDetailsScreen()).clickOnALocation(
        	locationName)
}

 /**
	 * this function verifies the location count
	 * @param expectedLocationCount (expected location Count)
	 */ 
def static "androidInventory.inventoryDetailsScreen.verifyLocationCount"(
    	String expectedLocationCount	) {
    (new androidInventory.inventoryDetailsScreen()).verifyLocationCount(
        	expectedLocationCount)
}

 /**
	 * taps on create order button to create an order and takes user to the order details screen
	 */ 
def static "iosOrders.newOrderScreen.createOrder"() {
    (new iosOrders.newOrderScreen()).createOrder()
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
	 * verifies new order screen when user creates an order
	 */ 
def static "iosOrders.newOrderScreen.verifyNewOrderScreenDetails"() {
    (new iosOrders.newOrderScreen()).verifyNewOrderScreenDetails()
}

 /**
	 * creates a test object at run time
	 * resourceId (resource-id of the object)
	 */ 
def static "iosReceiving.receivingReusableMethods.makeTestObject"(
    	String resourceId	) {
    (new iosReceiving.receivingReusableMethods()).makeTestObject(
        	resourceId)
}

 /**
	 * takes user back to receiving after uploading_totes
	 */ 
def static "iosReceiving.receivingReusableMethods.clickOnBackToReceiving"() {
    (new iosReceiving.receivingReusableMethods()).clickOnBackToReceiving()
}

 /**
	 * clicks on continue button after selection of shipments or invoice by user
	 */ 
def static "iosReceiving.receivingReusableMethods.clickOnContinue"() {
    (new iosReceiving.receivingReusableMethods()).clickOnContinue()
}

 /**
	 * clicks on got it issue
	 */ 
def static "iosReceiving.receivingReusableMethods.clickOnGotItbutton"() {
    (new iosReceiving.receivingReusableMethods()).clickOnGotItbutton()
}

 /**
	 * clicks on issue
	 */ 
def static "iosReceiving.receivingReusableMethods.clickOnIssue"() {
    (new iosReceiving.receivingReusableMethods()).clickOnIssue()
}

 /**
	 * clicks on receive all totes_button
	 */ 
def static "iosReceiving.receivingReusableMethods.clickOnReceiveAllTotes"() {
    (new iosReceiving.receivingReusableMethods()).clickOnReceiveAllTotes()
}

 /**
	 * click on scan icon
	 */ 
def static "iosReceiving.receivingReusableMethods.clickOnScanIcon"() {
    (new iosReceiving.receivingReusableMethods()).clickOnScanIcon()
}

 /**
	 * clicks on submit issue
	 */ 
def static "iosReceiving.receivingReusableMethods.clickOnSubmitIssue"() {
    (new iosReceiving.receivingReusableMethods()).clickOnSubmitIssue()
}

 /**
	 * collapses the detailed view of_tote
	 */ 
def static "iosReceiving.receivingReusableMethods.collpaseViewOfTotes"() {
    (new iosReceiving.receivingReusableMethods()).collpaseViewOfTotes()
}

 /**
	 * takes received product count as the argument and enters count in the text-field
	 * @param receivedProductCount (received product count)
	 */ 
def static "iosReceiving.receivingReusableMethods.editReceivedProductCount"(
    	int receivedProductCount	) {
    (new iosReceiving.receivingReusableMethods()).editReceivedProductCount(
        	receivedProductCount)
}

 /**
	 * enters detail for contact
	 * @param name
	 * @param phoneNumber
	 * @param emailID
	 * @param comment
	 */ 
def static "iosReceiving.receivingReusableMethods.enterDetailsForContact"(
    	String name	
     , 	String phoneNumber	
     , 	String comment	) {
    (new iosReceiving.receivingReusableMethods()).enterDetailsForContact(
        	name
         , 	phoneNumber
         , 	comment)
}

 /**
	 * expands the view to see detailed view of_tote
	 */ 
def static "iosReceiving.receivingReusableMethods.expandToSeeDetailedViewOfTotes"() {
    (new iosReceiving.receivingReusableMethods()).expandToSeeDetailedViewOfTotes()
}

 /**
	 * this function opens invoice details
	 * @param invoiceNumber (invoice number)
	 */ 
def static "iosReceiving.receivingReusableMethods.openInvoiceDetails"(
    	Object invoiceNumber	) {
    (new iosReceiving.receivingReusableMethods()).openInvoiceDetails(
        	invoiceNumber)
}

 /**
	 * this function opens shipment details
	 * @param shipmentNumber (shipment number)
	 */ 
def static "iosReceiving.receivingReusableMethods.openShipmentDetails"(
    	Object shipmentNumber	) {
    (new iosReceiving.receivingReusableMethods()).openShipmentDetails(
        	shipmentNumber)
}

 /**
	 * returns max upper value without over-age product count
	 * @return maxReceivingProductCountWithoutOverage (max upper value without over-age product count)
	 */ 
def static "iosReceiving.receivingReusableMethods.returnUpperLimitReceivingProductCount"() {
    (new iosReceiving.receivingReusableMethods()).returnUpperLimitReceivingProductCount()
}

 /**
	 * takes product to be searched as the argument and searches for the product
	 * @param productToBeSearched (name which can be a productName/Cin/NDC of the product to be added)
	 */ 
def static "iosReceiving.receivingReusableMethods.scanInputEvent"(
    	String productToBeSearched	) {
    (new iosReceiving.receivingReusableMethods()).scanInputEvent(
        	productToBeSearched)
}

 /**
	 * takes toteID to be searched as the argument and searches the same
	 */ 
def static "iosReceiving.receivingReusableMethods.searchTote"(
    	Object toteID	) {
    (new iosReceiving.receivingReusableMethods()).searchTote(
        	toteID)
}

 /**
	 * allows over-ages in receiving
	 */ 
def static "iosReceiving.receivingReusableMethods.selectAllowOverages"() {
    (new iosReceiving.receivingReusableMethods()).selectAllowOverages()
}

 /**
	 * this function will select invoices on the receiving screen
	 */ 
def static "iosReceiving.receivingReusableMethods.selectInvoices"() {
    (new iosReceiving.receivingReusableMethods()).selectInvoices()
}

 /**
	 * select reason of issue
	 * @param reasonForIssue
	 */ 
def static "iosReceiving.receivingReusableMethods.selectReasonForIssue"(
    	String reasonForIssue	) {
    (new iosReceiving.receivingReusableMethods()).selectReasonForIssue(
        	reasonForIssue)
}

 /**
	 * this function will select shipments on the receiving screen
	 */ 
def static "iosReceiving.receivingReusableMethods.selectShipments"() {
    (new iosReceiving.receivingReusableMethods()).selectShipments()
}

 /**
	 * takes user to previous day shipments from today's shipments screen
	 */ 
def static "iosReceiving.receivingReusableMethods.switchToPreviousDay"() {
    (new iosReceiving.receivingReusableMethods()).switchToPreviousDay()
}

 /**
	 * takes user to today's shipments from previous day shipments screen
	 */ 
def static "iosReceiving.receivingReusableMethods.switchToToday"() {
    (new iosReceiving.receivingReusableMethods()).switchToToday()
}

 /**
	 * test method for run time object creation
	 */ 
def static "iosReceiving.receivingReusableMethods.testFunction"() {
    (new iosReceiving.receivingReusableMethods()).testFunction()
}

 /**
	 * uploads completed_totes
	 */ 
def static "iosReceiving.receivingReusableMethods.uploadCompletedTotes"() {
    (new iosReceiving.receivingReusableMethods()).uploadCompletedTotes()
}

 /**
	 * verifies that over-ages are allowed
	 */ 
def static "iosReceiving.receivingReusableMethods.verifyAllowedOverages"() {
    (new iosReceiving.receivingReusableMethods()).verifyAllowedOverages()
}

 /**
	 * verifies details of the instances of product associated with the account
	 * @param productNdcNumber (using NDC of the product which is visible on the product tab)
	 */ 
def static "iosReceiving.receivingReusableMethods.verifyInstancesOfProductAssociatedWithAccount"(
    	Object productNdcNumber	) {
    (new iosReceiving.receivingReusableMethods()).verifyInstancesOfProductAssociatedWithAccount(
        	productNdcNumber)
}

 /**
	 * verifies the invoice is not visible on the screen
	 * @param invoiceNumber (invoice number)
	 */ 
def static "iosReceiving.receivingReusableMethods.verifyInvoiceIsNotVisible"(
    	Object invoiceNumber	) {
    (new iosReceiving.receivingReusableMethods()).verifyInvoiceIsNotVisible(
        	invoiceNumber)
}

 /**
	 * this function verifies the invoice is visible on the screen
	 * @param invoiceNumber (invoice number)
	 */ 
def static "iosReceiving.receivingReusableMethods.verifyInvoiceIsVisible"(
    	Object invoiceNumber	) {
    (new iosReceiving.receivingReusableMethods()).verifyInvoiceIsVisible(
        	invoiceNumber)
}

 /**
	 * verify invoice number visible while submission of issue
	 */ 
def static "iosReceiving.receivingReusableMethods.verifyInvoiceNumberInIssue"(
    	Object invoiceNumber	) {
    (new iosReceiving.receivingReusableMethods()).verifyInvoiceNumberInIssue(
        	invoiceNumber)
}

 /**
	 * this method verifies the invoices detail
	 * @param invoiceNumber (invoice number)
	 */ 
def static "iosReceiving.receivingReusableMethods.verifyInvoicesDetails"(
    	Object invoiceNumber	) {
    (new iosReceiving.receivingReusableMethods()).verifyInvoicesDetails(
        	invoiceNumber)
}

 /**
	 * this method verifies the invoices detail
	 */ 
def static "iosReceiving.receivingReusableMethods.verifyInvoicesListScreenDetails"() {
    (new iosReceiving.receivingReusableMethods()).verifyInvoicesListScreenDetails()
}

 /**
	 * verifies details related to submission of issue and takes shipment number, tote id as the arguments
	 * @param toteID
	 */ 
def static "iosReceiving.receivingReusableMethods.verifyIssueSubmissionDetails"(
    	Object toteID	) {
    (new iosReceiving.receivingReusableMethods()).verifyIssueSubmissionDetails(
        	toteID)
}

 /**
	 * verifies if no new orders to be received
	 */ 
def static "iosReceiving.receivingReusableMethods.verifyNoNewOrdersToReceive"() {
    (new iosReceiving.receivingReusableMethods()).verifyNoNewOrdersToReceive()
}

 /**
	 * verifies pop up to allow over-age
	 */ 
def static "iosReceiving.receivingReusableMethods.verifyOveragePopUp"() {
    (new iosReceiving.receivingReusableMethods()).verifyOveragePopUp()
}

 /**
	 * verifies over-age tag is visible after inputting receiving count which is more than the max upper limit
	 */ 
def static "iosReceiving.receivingReusableMethods.verifyOverAgeTag"() {
    (new iosReceiving.receivingReusableMethods()).verifyOverAgeTag()
}

 /**
	 * this function verifies that the product is visible on the order details screen
	 * @param productNdcNumber (using NDC of the product which is visible on the product tab)
	 * if in future upc/cin are visible then the method can be modified accordingly by passing the respective test object
	 */ 
def static "iosReceiving.receivingReusableMethods.verifyProductIsVisibleOnTheReceivingScreen"(
    	Object productNdcNumber	) {
    (new iosReceiving.receivingReusableMethods()).verifyProductIsVisibleOnTheReceivingScreen(
        	productNdcNumber)
}

 /**
	 * verifies details of the product associated with the account
	 * @param productNdcNumber (using NDC of the product which is visible on the product tab)
	 */ 
def static "iosReceiving.receivingReusableMethods.verifyProductSearchDetails"(
    	Object productNdcNumber	) {
    (new iosReceiving.receivingReusableMethods()).verifyProductSearchDetails(
        	productNdcNumber)
}

 /**
	 * takes expected received product count and maxReceivingProductCountWithoutOverage as the argument
	 * and verifies that it should be as expected for invoice screen
	 * @param expectedReceivedProductCount (expected received product count)
	 * @param maxReceivingProductCountWithoutOverage (maxReceiving product count without over-age)
	 */ 
def static "iosReceiving.receivingReusableMethods.verifyReceivedProductCountUnderInvoice"(
    	Object expectedReceivedProductCount	
     , 	Object maxReceivingProductCountWithoutOverage	) {
    (new iosReceiving.receivingReusableMethods()).verifyReceivedProductCountUnderInvoice(
        	expectedReceivedProductCount
         , 	maxReceivingProductCountWithoutOverage)
}

 /**
	 * takes expected received product count and maxReceivingProductCountWithoutOverage as the argument
	 * and verifies that it should be as expected for shipments screen
	 * @param expectedReceivedProductCount (expected received product count)
	 * @param maxReceivingProductCountWithoutOverage (maxReceiving product count without over-age)
	 */ 
def static "iosReceiving.receivingReusableMethods.verifyReceivedProductCountUnderShipments"(
    	Object expectedReceivedProductCount	
     , 	Object maxReceivingProductCountWithoutOverage	) {
    (new iosReceiving.receivingReusableMethods()).verifyReceivedProductCountUnderShipments(
        	expectedReceivedProductCount
         , 	maxReceivingProductCountWithoutOverage)
}

 /**
	 * verifies received tag is visible after inputting receiving count which is less or equal to the max upper limit
	 */ 
def static "iosReceiving.receivingReusableMethods.verifyReceivedTag"() {
    (new iosReceiving.receivingReusableMethods()).verifyReceivedTag()
}

 /**
	 * this function verifies the receiving screen details
	 */ 
def static "iosReceiving.receivingReusableMethods.verifyReceivingScreen"() {
    (new iosReceiving.receivingReusableMethods()).verifyReceivingScreen()
}

 /**
	 * verifies the receiving screen pop-up which comes after user goes to receiving tab details
	 */ 
def static "iosReceiving.receivingReusableMethods.verifyReceivingScreenPopUp"() {
    (new iosReceiving.receivingReusableMethods()).verifyReceivingScreenPopUp()
}

 /**
	 * verifies shipment details
	 * @param shipmentNumber (shipment number)
	 */ 
def static "iosReceiving.receivingReusableMethods.verifyShipmentDetails"(
    	Object shipmentNumber	) {
    (new iosReceiving.receivingReusableMethods()).verifyShipmentDetails(
        	shipmentNumber)
}

 /**
	 * this function verifies the shipment is visible on the screen
	 * @param shipmentNumber (shipment number)
	 */ 
def static "iosReceiving.receivingReusableMethods.verifyShipmentIsVisible"(
    	Object shipmentNumber	) {
    (new iosReceiving.receivingReusableMethods()).verifyShipmentIsVisible(
        	shipmentNumber)
}

 /**
	 * verify shipment number visible while submission of issue
	 */ 
def static "iosReceiving.receivingReusableMethods.verifyShipmentNumberInIssue"(
    	Object shipmentNumber	) {
    (new iosReceiving.receivingReusableMethods()).verifyShipmentNumberInIssue(
        	shipmentNumber)
}

 /**
	 * this function verifies the shipments detail
	 */ 
def static "iosReceiving.receivingReusableMethods.verifyShipmentsListScreenDetails"() {
    (new iosReceiving.receivingReusableMethods()).verifyShipmentsListScreenDetails()
}

 /**
	 * verify submission of issue pop-up
	 */ 
def static "iosReceiving.receivingReusableMethods.verifySubmissionOfIssue"() {
    (new iosReceiving.receivingReusableMethods()).verifySubmissionOfIssue()
}

 /**
	 * verifies the pop up after uploading_totes
	 */ 
def static "iosReceiving.receivingReusableMethods.verifyUploadTotesPopUp"() {
    (new iosReceiving.receivingReusableMethods()).verifyUploadTotesPopUp()
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
	 * returns top most inventory
	 */ 
def static "iosInventory.inventoryListingScreen.returnTopMostInventoryName"() {
    (new iosInventory.inventoryListingScreen()).returnTopMostInventoryName()
}

 /**
	 * verifies details of inventory listing screen
	 */ 
def static "iosInventory.inventoryListingScreen.verifyInventoryListingScreen"() {
    (new iosInventory.inventoryListingScreen()).verifyInventoryListingScreen()
}

 /**
	 * enables beta csos feature toggle from more options
	 */ 
def static "iosMoreOptions.moreOptionsScreen.enableBetaFeatureCSOS"() {
    (new iosMoreOptions.moreOptionsScreen()).enableBetaFeatureCSOS()
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

 /**
	 * opens the message center
	 */ 
def static "iosMoreOptions.moreOptionsScreen.tapMessageCentre"() {
    (new iosMoreOptions.moreOptionsScreen()).tapMessageCentre()
}

 /**
	 * opens alert
	 */ 
def static "iosMoreOptions.moreOptionsScreen.tapOnAlert"() {
    (new iosMoreOptions.moreOptionsScreen()).tapOnAlert()
}

 /**
	 * opens top most message
	 */ 
def static "iosMoreOptions.moreOptionsScreen.tapOnTopMostMessage"() {
    (new iosMoreOptions.moreOptionsScreen()).tapOnTopMostMessage()
}

 /**
	 * verifies alert message description
	 */ 
def static "iosMoreOptions.moreOptionsScreen.verifyAlertMessageDescription"() {
    (new iosMoreOptions.moreOptionsScreen()).verifyAlertMessageDescription()
}

 /**
	 * verifies alert and message
	 */ 
def static "iosMoreOptions.moreOptionsScreen.verifyMessageCentre"() {
    (new iosMoreOptions.moreOptionsScreen()).verifyMessageCentre()
}

 /**
	 * verifies message center in offline
	 */ 
def static "iosMoreOptions.moreOptionsScreen.verifyMessageCentreInOffline"() {
    (new iosMoreOptions.moreOptionsScreen()).verifyMessageCentreInOffline()
}

 /**
	 * verifies message description
	 */ 
def static "iosMoreOptions.moreOptionsScreen.verifyMessageDescription"() {
    (new iosMoreOptions.moreOptionsScreen()).verifyMessageDescription()
}

 /**
	 * clicks on history tab button to open history tab in order history screen
	 */ 
def static "iosOrders.historyScreen.clickOnHistoryTab"() {
    (new iosOrders.historyScreen()).clickOnHistoryTab()
}

 /**
	 * opens the c2 order details, verifies the order status labels and signIns the password required for placing c2 order
	 * @param password (password-which is required for placing the c2 order)
	 */ 
def static "iosOrders.historyScreen.completeReviewSignAndPlaceAnOrderFlow"(
    	String poNumber	
     , 	String signingPassword	) {
    (new iosOrders.historyScreen()).completeReviewSignAndPlaceAnOrderFlow(
        	poNumber
         , 	signingPassword)
}

 /**
	 * returns quantity added
	 */ 
def static "iosOrders.historyScreen.returnQuantityForScannedResultInOfflineMode"() {
    (new iosOrders.historyScreen()).returnQuantityForScannedResultInOfflineMode()
}

 /**
	 * returns po number of an top most order 
	 */ 
def static "iosOrders.historyScreen.returnTopMostPoNumberOfAnOrder"() {
    (new iosOrders.historyScreen()).returnTopMostPoNumberOfAnOrder()
}

 /**
	 * opens top most order in order history
	 */ 
def static "iosOrders.historyScreen.tapOnTopMostOrderHistory"(
    	String poNumber	) {
    (new iosOrders.historyScreen()).tapOnTopMostOrderHistory(
        	poNumber)
}

 /**
	 * verifies history screen when user creates an order
	 */ 
def static "iosOrders.historyScreen.verifyHistoryScreenDetails"() {
    (new iosOrders.historyScreen()).verifyHistoryScreenDetails()
}

 /**
	 * verifies order status changes from held to allocated 30 seconds after successfully placing the signed order
	 */ 
def static "iosOrders.historyScreen.verifyOrderStatusInOrderHistoryList"(
    	String poNumber	) {
    (new iosOrders.historyScreen()).verifyOrderStatusInOrderHistoryList(
        	poNumber)
}

 /**
	 * verifies PO Number in order history screen
	 */ 
def static "iosOrders.historyScreen.verifyPoNumberInOrderHistoryList"(
    	String poNumber	) {
    (new iosOrders.historyScreen()).verifyPoNumberInOrderHistoryList(
        	poNumber)
}

 /**
	 * deletes all orders from nonc2 and c2 order tab
	 */ 
def static "androidOrders.ordersCommonScreen.clearAllOrders"() {
    (new androidOrders.ordersCommonScreen()).clearAllOrders()
}

 /**
	 * takes user to cart screen
	 */ 
def static "androidOrders.ordersCommonScreen.clickOnCartTab"() {
    (new androidOrders.ordersCommonScreen()).clickOnCartTab()
}

 /**
	 * opens History page
	 */ 
def static "androidOrders.ordersCommonScreen.clickOnHistoryTab"() {
    (new androidOrders.ordersCommonScreen()).clickOnHistoryTab()
}

 /**
	 * takes user to the new order screen
	 */ 
def static "androidOrders.ordersCommonScreen.clickOnNewOrder"() {
    (new androidOrders.ordersCommonScreen()).clickOnNewOrder()
}

 /**
	 * Tap on quantity count box
	 * Verify its highlighted by green color background
	 */ 
def static "androidAudits.auditsListingScreen.tapOnQuantityBox"() {
    (new androidAudits.auditsListingScreen()).tapOnQuantityBox()
}

 /**
	 * Long press on quantity count box 
	 */ 
def static "androidAudits.auditsListingScreen.longPressOnQuantityBox"() {
    (new androidAudits.auditsListingScreen()).longPressOnQuantityBox()
}

 /**
	 * verify initial count value
	 * tap on + button
	 * verify the count is increased
	 */ 
def static "androidAudits.auditsListingScreen.increaseCount"() {
    (new androidAudits.auditsListingScreen()).increaseCount()
}

 /**
	 * verify initial count value
	 * tap on - button
	 * verify the count is decreased
	 */ 
def static "androidAudits.auditsListingScreen.decreaseCount"() {
    (new androidAudits.auditsListingScreen()).decreaseCount()
}

 /**
	 * get final count value
	 * tap on confirmAuditCount button
	 * return the final count value
	 */ 
def static "androidAudits.auditsListingScreen.confirmAuditCount"() {
    (new androidAudits.auditsListingScreen()).confirmAuditCount()
}

 /**
	 * verify the final count value with the audit list count
	 */ 
def static "androidAudits.auditsListingScreen.verifyQuantity"(
    	int quantity	) {
    (new androidAudits.auditsListingScreen()).verifyQuantity(
        	quantity)
}

 /**
	 * Change account
	 */ 
def static "androidAudits.auditsListingScreen.changeAccount"() {
    (new androidAudits.auditsListingScreen()).changeAccount()
}

 /**
	 * Tap on all the boxes
	 */ 
def static "androidAudits.auditsListingScreen.tapOnAllBox"() {
    (new androidAudits.auditsListingScreen()).tapOnAllBox()
}

 /**
	 * It verify the group completed icon
	 */ 
def static "androidAudits.auditsListingScreen.isGroupAudited"() {
    (new androidAudits.auditsListingScreen()).isGroupAudited()
}

 /**
	 * It verify the submit button and tap on it
	 */ 
def static "androidAudits.auditsListingScreen.submitCompletedGroups"() {
    (new androidAudits.auditsListingScreen()).submitCompletedGroups()
}

 /**
	 * It verify the Audits list screen
	 */ 
def static "androidAudits.auditsListingScreen.verifyAuditsScreen"(
    	String expectedMessage	) {
    (new androidAudits.auditsListingScreen()).verifyAuditsScreen(
        	expectedMessage)
}

 /**
	 * It verify the Audits account
	 */ 
def static "androidAudits.auditsListingScreen.verifyAccount"(
    	String first_account	) {
    (new androidAudits.auditsListingScreen()).verifyAccount(
        	first_account)
}

 /**
	 * Get mobile driver for current session
	 * @return mobile driver for current session
	 */ 
def static "common.commonMethods.getCurrentSessionMobileDriver"() {
    (new common.commonMethods()).getCurrentSessionMobileDriver()
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
	 * removes existing app 
	 * @param bundleId of the App
	 */ 
def static "common.commonMethods.removeApp"(
    	String bundleID	) {
    (new common.commonMethods()).removeApp(
        	bundleID)
}

 /**
	 * verifies element colour by taking a screenshot and comparing with colour of specific pixels
	 * @param expectedRedIntensity
	 * @param expectedGreenIntensity
	 * @param expectedBlueIntensity
	 * @param idOfTheElement
	 */ 
def static "common.commonMethods.verifyElementColor"(
    	int expectedRedIntensity	
     , 	int expectedGreenIntensity	
     , 	int expectedBlueIntensity	
     , 	String locatorOfTheElement	) {
    (new common.commonMethods()).verifyElementColor(
        	expectedRedIntensity
         , 	expectedGreenIntensity
         , 	expectedBlueIntensity
         , 	locatorOfTheElement)
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
	 * opens audits tab where user can perform actions related to audits
	 */ 
def static "iosDashboard.dashboardScreen.clickOnAuditsTab"() {
    (new iosDashboard.dashboardScreen()).clickOnAuditsTab()
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
	 * opens receiving tab
	 */ 
def static "iosDashboard.dashboardScreen.clickOnReceivingTab"() {
    (new iosDashboard.dashboardScreen()).clickOnReceivingTab()
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
	 * opens the c2 orders tab
	 */ 
def static "androidOrders.cartScreen.clickOnC2OrdersTab"() {
    (new androidOrders.cartScreen()).clickOnC2OrdersTab()
}

 /**
	 * clicks on continue on desktop button on cart screen
	 */ 
def static "androidOrders.cartScreen.clickOnContinueOnDesktop"() {
    (new androidOrders.cartScreen()).clickOnContinueOnDesktop()
}

 /**
	 * opens the nonc2 orders tab
	 */ 
def static "androidOrders.cartScreen.clickOnNonC2OrdersTab"() {
    (new androidOrders.cartScreen()).clickOnNonC2OrdersTab()
}

 /**
	 * clicks on place all orders button on cart screen
	 */ 
def static "androidOrders.cartScreen.clickOnPlaceAllOrders"() {
    (new androidOrders.cartScreen()).clickOnPlaceAllOrders()
}

 /**
	 * clicks on upload all orders button on cart screen
	 */ 
def static "androidOrders.cartScreen.clickOnUploadAllOrders"() {
    (new androidOrders.cartScreen()).clickOnUploadAllOrders()
}

 /**
	 * clicks on place my orders button on cart screen
	 */ 
def static "androidOrders.cartScreen.confirmPlacingAllOrders"() {
    (new androidOrders.cartScreen()).confirmPlacingAllOrders()
}

 /**
	 * delete's the order from the cart screen based on the purchase order name
	 * @param poName (purchase order name of the order)
	 */ 
def static "androidOrders.cartScreen.deleteOrder"(
    	Object poName	) {
    (new androidOrders.cartScreen()).deleteOrder(
        	poName)
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
	 * opens the c2 order details
	 */ 
def static "androidOrders.cartScreen.openC2OrderDetails"() {
    (new androidOrders.cartScreen()).openC2OrderDetails()
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

 /**
	 * this function returns the order name from confirmation pop up of upload order
	 * return orderName (returns order name)
	 */ 
def static "androidOrders.cartScreen.returnOrderNameFromConfirmationPopupOfUploadOrder"() {
    (new androidOrders.cartScreen()).returnOrderNameFromConfirmationPopupOfUploadOrder()
}

 /**
	 * this function returns the order name of the order which is at the top of the order list
	 * return orderName (returns topmost order name)
	 */ 
def static "androidOrders.cartScreen.returnTopMostOrderName"() {
    (new androidOrders.cartScreen()).returnTopMostOrderName()
}

 /**
	 * verifies C2 annotation count
	 * @param expectedAnnotationCount (annotation count of the non c2 product)
	 */ 
def static "androidOrders.cartScreen.verifyC2AnnotationCount"(
    	String expectedAnnotationCount	) {
    (new androidOrders.cartScreen()).verifyC2AnnotationCount(
        	expectedAnnotationCount)
}

 /**
	 * verifies cart screen with added product
	 */ 
def static "androidOrders.cartScreen.verifyCartScreenDetailsWithAddedProduct"() {
    (new androidOrders.cartScreen()).verifyCartScreenDetailsWithAddedProduct()
}

 /**
	 * verifies the cart screen details without any product
	 */ 
def static "androidOrders.cartScreen.verifyCartScreenDetailsWithOutAddingAnyProduct"() {
    (new androidOrders.cartScreen()).verifyCartScreenDetailsWithOutAddingAnyProduct()
}

 /**
	 * verifies cart screen without non c2 orders
	 */ 
def static "androidOrders.cartScreen.verifyCartScreenWithOutNonC2Orders"() {
    (new androidOrders.cartScreen()).verifyCartScreenWithOutNonC2Orders()
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
	 * takes expected lines count of c2 or non c2 as the argument and verifies the same
	 * @param expectedLineCount (expected total line count of non c2 or c2 after adding product to the cart)
	 */ 
def static "androidOrders.cartScreen.verifyLineCountofC2OrNonC2Product"(
    	String expectedlineCount	) {
    (new androidOrders.cartScreen()).verifyLineCountofC2OrNonC2Product(
        	expectedlineCount)
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
	 * takes expected mobile orders count as the argument and verifies the same
	 * @param expected mobile orders count (expected mobile orders count after adding products to the cart)
	 */ 
def static "androidOrders.cartScreen.verifyMobileOrdersCount"(
    	String expectedMobileOrdersCount	) {
    (new androidOrders.cartScreen()).verifyMobileOrdersCount(
        	expectedMobileOrdersCount)
}

 /**
	 * verifies nonC2 annotation count
	 * @param expectedAnnotationCount (annotation count of the non c2 product)
	 */ 
def static "androidOrders.cartScreen.verifynonC2AnnotationCount"(
    	String expectedAnnotationCount	) {
    (new androidOrders.cartScreen()).verifynonC2AnnotationCount(
        	expectedAnnotationCount)
}

 /**
	 * verifies that the created order should be visible on the cart screen
	 * @param poName (purchase order name used to create the order)
	 */ 
def static "androidOrders.cartScreen.verifyOrderIsVisibleOnTheCartScreen"(
    	String poName	) {
    (new androidOrders.cartScreen()).verifyOrderIsVisibleOnTheCartScreen(
        	poName)
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
	 * verifies that the created order should not be visible on the cart screen
	 * @param poName (purchase order name used to create the order)
	 */ 
def static "androidOrders.cartScreen.verifyOrderNotVisibleOnTheCartScreen"(
    	String poName	) {
    (new androidOrders.cartScreen()).verifyOrderNotVisibleOnTheCartScreen(
        	poName)
}

 /**
	 * verifies pop up screen which comes after clicking on place all orders button on cart screen
	 */ 
def static "androidOrders.cartScreen.verifyPlaceAllOrdersPopUp"() {
    (new androidOrders.cartScreen()).verifyPlaceAllOrdersPopUp()
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
	 * verifies pop up screen which comes after clicking on upload all orders button on cart screen
	 */ 
def static "androidOrders.cartScreen.verifyUploadAllOrdersPopUp"() {
    (new androidOrders.cartScreen()).verifyUploadAllOrdersPopUp()
}

 /**
	 * this method will take the application one screen back
	 */ 
def static "androidCommonKeywords.commonMethods.goOneScreenBack"() {
    (new androidCommonKeywords.commonMethods()).goOneScreenBack()
}

 /**
	 * reads value from the global boolean variable: isAndroidAppInstalled
	 * and if it is set to true, launches already installed application else installs and launches the application
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
	 * performs login function by selecting the type of testing (automation or manual), environment of testing(taken from the global profile), entering user-name and password
	 * and then selects the user account from the accounts list and takes user to the dash-board screen
	 * @param username
	 * @param password
	 * @param accountNo
	 */ 
def static "androidCommonKeywords.commonMethods.takeUserFromloginToHomeScreen"(
    	Object username	
     , 	Object password	
     , 	Object accountNo	) {
    (new androidCommonKeywords.commonMethods()).takeUserFromloginToHomeScreen(
        	username
         , 	password
         , 	accountNo)
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
	 * this function verifies that the product is not visible on the screen
	 * @param productIdentificationNumber (productIdentificationNumber of the product which can be NDC/Cin/UPC, which should be present on the screen)
	 * @param testObj (test object of the element under verification)
	 */ 
def static "androidCommonKeywords.commonMethods.verifyProductIsNotVisibleOnTheScreen"(
    	Object testObj	
     , 	Object productIdentificationNumber	) {
    (new androidCommonKeywords.commonMethods()).verifyProductIsNotVisibleOnTheScreen(
        	testObj
         , 	productIdentificationNumber)
}

 /**
	 * clicks on product search field
	 */ 
def static "androidCommonKeywords.commonMethods.clickOnProductSearchTextField"() {
    (new androidCommonKeywords.commonMethods()).clickOnProductSearchTextField()
}

 /**
	 * inputs the product search which can be name/Cin/UPC/NDC in the product search-field
	 * @param productSearch (which can be name/Cin/UPC/NDC in the product search-field)
	 */ 
def static "androidCommonKeywords.commonMethods.enterProductInSearchField"(
    	Object productSearch	) {
    (new androidCommonKeywords.commonMethods()).enterProductInSearchField(
        	productSearch)
}

 /**
	 * performs basic text management operations:Copy,Cut,Paste,Share
	 * @param operationToBePerformed (in operationToBePerformed argument all alphabets should be lower-case except the first one for e.g Copy, Cut)
	 */ 
def static "androidCommonKeywords.commonMethods.performBasicTextManagementOperation"(
    	String operationToBePerformed	) {
    (new androidCommonKeywords.commonMethods()).performBasicTextManagementOperation(
        	operationToBePerformed)
}

 /**
	 * takes product to be searched as the argument and searches the same
	 */ 
def static "androidCommonKeywords.commonMethods.searchProduct"(
    	Object productToBeSearched	) {
    (new androidCommonKeywords.commonMethods()).searchProduct(
        	productToBeSearched)
}

 /**
	 * selects different account
	 * @param accountNo (account number used for selection)
	 */ 
def static "androidCommonKeywords.commonMethods.changeAccount"(
    	String accountNo	) {
    (new androidCommonKeywords.commonMethods()).changeAccount(
        	accountNo)
}

 /**
	 * verifies new order screen
	 */ 
def static "androidCommonKeywords.commonMethods.verifyAccount"(
    	Object account	) {
    (new androidCommonKeywords.commonMethods()).verifyAccount(
        	account)
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

 /**
	 * copies topmost non c2 order to cart screen
	 * verifies details related to order name, account name, lines count 
	 * of the order which is at the top of the order list under saved orders
	 */ 
def static "iosOrders.bcsOrders.copyAndVerifyTopMostOrderDetailsUnderSavedOrdersToCartScreen"() {
    (new iosOrders.bcsOrders()).copyAndVerifyTopMostOrderDetailsUnderSavedOrdersToCartScreen()
}

 /**
	 * copies a non c2 order from saved orders to the cart screen and verifies details related to copy button
	 */ 
def static "iosOrders.bcsOrders.copyNonC2ProductFromSavedOrders"() {
    (new iosOrders.bcsOrders()).copyNonC2ProductFromSavedOrders()
}

 /**
	 * verifies details related to saved orders listing screen
	 */ 
def static "iosOrders.bcsOrders.lookforC2Orders"() {
    (new iosOrders.bcsOrders()).lookforC2Orders()
}

 /**
	 * opens the saved orders by tapping on the bcs notification
	 */ 
def static "iosOrders.bcsOrders.openSavedOrdersList"() {
    (new iosOrders.bcsOrders()).openSavedOrdersList()
}

 /**
	 * verifies bcs notification on the cart screen
	 */ 
def static "iosOrders.bcsOrders.verifyBcsNotification"() {
    (new iosOrders.bcsOrders()).verifyBcsNotification()
}

 /**
	 * verifies details related to c2 orders tile under orders listing screen
	 */ 
def static "iosOrders.bcsOrders.verifyC2RelatedDetailsForBCS"() {
    (new iosOrders.bcsOrders()).verifyC2RelatedDetailsForBCS()
}

 /**
	 * verifies details related to saved orders listing screen
	 */ 
def static "iosOrders.bcsOrders.verifySavedOrdersListDetails"() {
    (new iosOrders.bcsOrders()).verifySavedOrdersListDetails()
}


def static "com.kms.katalon.keyword.applitools.BasicKeywords.checkElement"(
    	Eyes eyes	
     , 	WebElement element	) {
    (new com.kms.katalon.keyword.applitools.BasicKeywords()).checkElement(
        	eyes
         , 	element)
}


def static "com.kms.katalon.keyword.applitools.BasicKeywords.checkTestObject"(
    	TestObject testObject	
     , 	String testName	) {
    (new com.kms.katalon.keyword.applitools.BasicKeywords()).checkTestObject(
        	testObject
         , 	testName)
}


def static "com.kms.katalon.keyword.applitools.BasicKeywords.checkWindow"(
    	String testName	) {
    (new com.kms.katalon.keyword.applitools.BasicKeywords()).checkWindow(
        	testName)
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
