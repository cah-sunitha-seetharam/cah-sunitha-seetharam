
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import java.lang.String



def static "ios_common_keywords.verticalSwipeRefresh.Custom"() {
    (new ios_common_keywords.verticalSwipeRefresh()).Custom()
}

 /**
	 * opens orders tab
	 */ 
def static "ios_dashboard.dashboard_details.click_On_Orders"() {
    (new ios_dashboard.dashboard_details()).click_On_Orders()
}

 /**
	 * opens home tab
	 */ 
def static "ios_dashboard.dashboard_details.click_On_HomeTab"() {
    (new ios_dashboard.dashboard_details()).click_On_HomeTab()
}

 /**
	 * opens moreOptions tab
	 */ 
def static "ios_dashboard.dashboard_details.click_On_More_Options"() {
    (new ios_dashboard.dashboard_details()).click_On_More_Options()
}

 /**
	 * changes the account
	 * @param newAccount
	 */ 
def static "ios_dashboard.dashboard_details.Change_Account"(
    	String newAccount	) {
    (new ios_dashboard.dashboard_details()).Change_Account(
        	newAccount)
}

 /**
	 * adds the product from dashboard
	 * @param productName,quantity
	 */ 
def static "ios_dashboard.dashboard_details.Adding_Product_from_Dashboard_To_Cart"(
    	String productName	
     , 	String quantity	) {
    (new ios_dashboard.dashboard_details()).Adding_Product_from_Dashboard_To_Cart(
        	productName
         , 	quantity)
}

 /**
	 * switches to another user account
	 * @param newAccount (account no to which the user should switch)
	 */ 
def static "ios_inventory.Inventory_listing_Screen.change_Account"(
    	String newAccount	) {
    (new ios_inventory.Inventory_listing_Screen()).change_Account(
        	newAccount)
}

 /**
	 * opens the particular inventory details
	 * @param inventoryName (name which was given to the inventory)
	 */ 
def static "ios_inventory.Inventory_listing_Screen.click_On_Inventory"(
    	String inventoryName	) {
    (new ios_inventory.Inventory_listing_Screen()).click_On_Inventory(
        	inventoryName)
}

 /**
	 * creates a new inventory from inventory listing screen
	 * @param inventoryName (name required for the new inventory)
	 */ 
def static "ios_inventory.Inventory_listing_Screen.create_Inventory"(
    	String inventoryName	) {
    (new ios_inventory.Inventory_listing_Screen()).create_Inventory(
        	inventoryName)
}

 /**
	 * deletes the inventory from the inventory listing screen
	 * @param inventoryName (inventory name of the inventory which needs to be deleted)
	 */ 
def static "ios_inventory.Inventory_listing_Screen.delete_Inventory"(
    	String inventoryName	) {
    (new ios_inventory.Inventory_listing_Screen()).delete_Inventory(
        	inventoryName)
}

 /**
	 * verifies details of inventory listing screen
	 */ 
def static "ios_inventory.Inventory_listing_Screen.verify_Inventory_Listing_Screen"() {
    (new ios_inventory.Inventory_listing_Screen()).verify_Inventory_Listing_Screen()
}


def static "ios_common_keywords.Inventory_Error.Custom"() {
    (new ios_common_keywords.Inventory_Error()).Custom()
}

 /**
	 * starts the application
	 */ 
def static "ios_common_keywords.Start_Application.custom"() {
    (new ios_common_keywords.Start_Application()).custom()
}

 /**
	 * this method will take the application one screen back
	 */ 
def static "ios_common_keywords.commonMethods.goOneScreenBack"() {
    (new ios_common_keywords.commonMethods()).goOneScreenBack()
}

 /**
	 * installs as well as launches the application
	 * @param Android_App_Path (Application path will be taken from the global profile and passed as a parameter to this method)
	 */ 
def static "ios_common_keywords.commonMethods.installingAndlaunchingTheApplication"() {
    (new ios_common_keywords.commonMethods()).installingAndlaunchingTheApplication()
}

 /**
	 * float value generator
	 * @param stringToBeConvertedToFloatValue 
	 * returns float value for a string by removing characters
	 */ 
def static "ios_common_keywords.commonMethods.floatValueGenerator"(
    	String stringToBeConvertedToFloatValue	) {
    (new ios_common_keywords.commonMethods()).floatValueGenerator(
        	stringToBeConvertedToFloatValue)
}

 /**
	 * generates the tap coordinate x for a test object by considering ElementLeftPosition and ElementWidth
	 * @param testObj
	 * returns int value for the xCoordinate
	 */ 
def static "ios_common_keywords.commonMethods.tapXCoordinateGenerator"(
    	String testObj	) {
    (new ios_common_keywords.commonMethods()).tapXCoordinateGenerator(
        	testObj)
}

 /**
	 * generates the tap coordinate y for a test object by considering ElementTopPosition and ElementHeight
	 * @param testObj
	 * returns int value for the yCoordinate
	 */ 
def static "ios_common_keywords.commonMethods.tapYCoordinateGenerator"(
    	String testObj	
     , 	String text	) {
    (new ios_common_keywords.commonMethods()).tapYCoordinateGenerator(
        	testObj
         , 	text)
}

 /**
	 * refreshes the screen by doing a vertical swipe by considering the deviceHeight and deviceWidth
	 */ 
def static "ios_common_keywords.commonMethods.verticalSwipeForRefresh"() {
    (new ios_common_keywords.commonMethods()).verticalSwipeForRefresh()
}

 /**
	 * refreshes the screen by doing a vertical swipe after waiting for 30(s) to check the changed order status of C2 order by considering the deviceHeight and deviceWidth
	 */ 
def static "ios_common_keywords.commonMethods.verticalSwipeForRefreshingC2OrderStatus"() {
    (new ios_common_keywords.commonMethods()).verticalSwipeForRefreshingC2OrderStatus()
}

 /**
	 * waits until the progressBar is visible on the screen
	 */ 
def static "ios_common_keywords.commonMethods.waitForProgressBarToBeInvisible"() {
    (new ios_common_keywords.commonMethods()).waitForProgressBarToBeInvisible()
}

 /**
	 * waits until the object is visible on the screen
	 * @param testObj (reference of the test Object),waitTime (time by which delay will be added in(s)),waitLimit (maximum limit of time for which delay can be added)
	 */ 
def static "ios_common_keywords.commonMethods.waitTimeForObjectToBeVisible"(
    	Object testObj	
     , 	int waitTime	
     , 	int waitLimit	) {
    (new ios_common_keywords.commonMethods()).waitTimeForObjectToBeVisible(
        	testObj
         , 	waitTime
         , 	waitLimit)
}


def static "ios_orders.New_Order_Screen.change_Account"(
    	String new_Account	) {
    (new ios_orders.New_Order_Screen()).change_Account(
        	new_Account)
}


def static "ios_orders.New_Order_Screen.enter_Purchase_Order_Details"(
    	String po_Name	
     , 	String po_Memo	) {
    (new ios_orders.New_Order_Screen()).enter_Purchase_Order_Details(
        	po_Name
         , 	po_Memo)
}


def static "ios_orders.New_Order_Screen.create_Order"() {
    (new ios_orders.New_Order_Screen()).create_Order()
}


def static "ios_orders.New_Order_Screen.click_On_NewOrder"() {
    (new ios_orders.New_Order_Screen()).click_On_NewOrder()
}


def static "ios_orders.New_Order_Screen.verify_NewOrder_Screen_Details"() {
    (new ios_orders.New_Order_Screen()).verify_NewOrder_Screen_Details()
}


def static "android_orders.Orders_Screen.click_On_NewOrder"() {
    (new android_orders.Orders_Screen()).click_On_NewOrder()
}


def static "android_orders.Orders_Screen.click_On_History_Tab"() {
    (new android_orders.Orders_Screen()).click_On_History_Tab()
}


def static "android_orders.Orders_Screen.click_On_Cart_Tab"() {
    (new android_orders.Orders_Screen()).click_On_Cart_Tab()
}


def static "android_orders.Orders_Screen.change_Account"(
    	String new_Account	) {
    (new android_orders.Orders_Screen()).change_Account(
        	new_Account)
}


def static "android_orders.Cart_Screen.click_On_Order"(
    	String Account_No	) {
    (new android_orders.Cart_Screen()).click_On_Order(
        	Account_No)
}


def static "android_orders.Cart_Screen.delete_Order"(
    	Object Account_No	) {
    (new android_orders.Cart_Screen()).delete_Order(
        	Account_No)
}


def static "android_orders.Cart_Screen.upload_All_Orders"() {
    (new android_orders.Cart_Screen()).upload_All_Orders()
}


def static "android_orders.Cart_Screen.place_All_Orders"() {
    (new android_orders.Cart_Screen()).place_All_Orders()
}


def static "android_orders.Cart_Screen.verify_Cart_Screen_Details_with_Added_Product"() {
    (new android_orders.Cart_Screen()).verify_Cart_Screen_Details_with_Added_Product()
}


def static "android_orders.Cart_Screen.verify_Cart_Screen_Details_without_Adding_any_Product"() {
    (new android_orders.Cart_Screen()).verify_Cart_Screen_Details_without_Adding_any_Product()
}


def static "ios_more_options_screen.moreOptionsScreen.goToInventoryListingScreen"() {
    (new ios_more_options_screen.moreOptionsScreen()).goToInventoryListingScreen()
}


def static "ios_more_options_screen.moreOptionsScreen.signOut"() {
    (new ios_more_options_screen.moreOptionsScreen()).signOut()
}


def static "android_account_selection_screen.Select_An_Account.Custom"(
    	String account	) {
    (new android_account_selection_screen.Select_An_Account()).Custom(
        	account)
}


def static "android_login.Login_Screen.login"(
    	Object password	) {
    (new android_login.Login_Screen()).login(
        	password)
}


def static "android_login.Login_Screen.select_Environment"() {
    (new android_login.Login_Screen()).select_Environment()
}


def static "android_login.Login_Screen.enter_Username"() {
    (new android_login.Login_Screen()).enter_Username()
}


def static "android_login.Login_Screen.enter_Password"(
    	String password	) {
    (new android_login.Login_Screen()).enter_Password(
        	password)
}


def static "android_login.Login_Screen.click_On_SignIn_Button"() {
    (new android_login.Login_Screen()).click_On_SignIn_Button()
}


def static "android_login.Login_Screen.click_On_Forgot_Password"() {
    (new android_login.Login_Screen()).click_On_Forgot_Password()
}


def static "android_login.Login_Screen.verify_Login_Page_Details"() {
    (new android_login.Login_Screen()).verify_Login_Page_Details()
}


def static "android_common_keywords.wait_for_load.Custom"() {
    (new android_common_keywords.wait_for_load()).Custom()
}


def static "android_orders.Order_details_Screen.upload_Order"() {
    (new android_orders.Order_details_Screen()).upload_Order()
}


def static "android_orders.Order_details_Screen.place_Order"() {
    (new android_orders.Order_details_Screen()).place_Order()
}


def static "android_orders.Order_details_Screen.add_Product_to_Order"(
    	String Product_Name	
     , 	String Quantity	) {
    (new android_orders.Order_details_Screen()).add_Product_to_Order(
        	Product_Name
         , 	Quantity)
}


def static "android_orders.Order_details_Screen.edit_PO_Name_and_Memo"(
    	String PO_Name	
     , 	String PO_Memo	
     , 	String New_po_Name	
     , 	String New_po_Memo	) {
    (new android_orders.Order_details_Screen()).edit_PO_Name_and_Memo(
        	PO_Name
         , 	PO_Memo
         , 	New_po_Name
         , 	New_po_Memo)
}


def static "android_orders.Order_details_Screen.add_ALternate_Product"(
    	String Product_Name	
     , 	String Quantity	) {
    (new android_orders.Order_details_Screen()).add_ALternate_Product(
        	Product_Name
         , 	Quantity)
}


def static "android_orders.Order_details_Screen.verify_Order_Screen_Details_without_any_added_product"() {
    (new android_orders.Order_details_Screen()).verify_Order_Screen_Details_without_any_added_product()
}


def static "android_orders.Order_details_Screen.verify_Order_Screen_Details_with_added_product"() {
    (new android_orders.Order_details_Screen()).verify_Order_Screen_Details_with_added_product()
}


def static "android_orders.History_Screen.verify_History_Screen_Details"() {
    (new android_orders.History_Screen()).verify_History_Screen_Details()
}


def static "android_common_keywords.Go_Back.Custom"() {
    (new android_common_keywords.Go_Back()).Custom()
}


def static "android_more_options.moreOptionsScreen.changeAccount"(
    	Object accountNo	) {
    (new android_more_options.moreOptionsScreen()).changeAccount(
        	accountNo)
}


def static "android_more_options.moreOptionsScreen.goToInventoryListingScreen"() {
    (new android_more_options.moreOptionsScreen()).goToInventoryListingScreen()
}


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


def static "ios_orders.Cart_Screen.click_On_Order"(
    	String Account_No	) {
    (new ios_orders.Cart_Screen()).click_On_Order(
        	Account_No)
}


def static "ios_orders.Cart_Screen.upload_All_Orders"() {
    (new ios_orders.Cart_Screen()).upload_All_Orders()
}


def static "ios_orders.Cart_Screen.place_All_Orders"() {
    (new ios_orders.Cart_Screen()).place_All_Orders()
}


def static "ios_orders.Cart_Screen.delete_Order"(
    	String Account_No	) {
    (new ios_orders.Cart_Screen()).delete_Order(
        	Account_No)
}


def static "ios_orders.Cart_Screen.verify_Cart_Screen_Details_without_Adding_any_Product"() {
    (new ios_orders.Cart_Screen()).verify_Cart_Screen_Details_without_Adding_any_Product()
}


def static "ios_orders.Cart_Screen.verify_Cart_Screen_Details_with_Added_Product"() {
    (new ios_orders.Cart_Screen()).verify_Cart_Screen_Details_with_Added_Product()
}


def static "ios_orders.Order_details_Screen.upload_Order"() {
    (new ios_orders.Order_details_Screen()).upload_Order()
}


def static "ios_orders.Order_details_Screen.place_Order"() {
    (new ios_orders.Order_details_Screen()).place_Order()
}


def static "ios_orders.Order_details_Screen.add_Product_to_Order"(
    	String product_Name	
     , 	String quantity	) {
    (new ios_orders.Order_details_Screen()).add_Product_to_Order(
        	product_Name
         , 	quantity)
}


def static "ios_orders.Order_details_Screen.edit_PO_Name_and_Memo"(
    	String po_Name	
     , 	String po_Memo	) {
    (new ios_orders.Order_details_Screen()).edit_PO_Name_and_Memo(
        	po_Name
         , 	po_Memo)
}


def static "ios_orders.Order_details_Screen.add_Alternate_Product"(
    	String product_Name	
     , 	String quantity	) {
    (new ios_orders.Order_details_Screen()).add_Alternate_Product(
        	product_Name
         , 	quantity)
}


def static "ios_orders.Order_details_Screen.verify_Order_Details_Screen_without_any_added_product"() {
    (new ios_orders.Order_details_Screen()).verify_Order_Details_Screen_without_any_added_product()
}


def static "ios_orders.Order_details_Screen.verify_Order_Details_Screen_Details_with_added_product"() {
    (new ios_orders.Order_details_Screen()).verify_Order_Details_Screen_Details_with_added_product()
}


def static "ios_orders.History_Screen.verify_History_Screen_Details"() {
    (new ios_orders.History_Screen()).verify_History_Screen_Details()
}


def static "ios_account_selection.Change_Account.Custom"(
    	Object New_Account	) {
    (new ios_account_selection.Change_Account()).Custom(
        	New_Account)
}


def static "ios_common_keywords.wait_for_load.waitForPageLoad"() {
    (new ios_common_keywords.wait_for_load()).waitForPageLoad()
}


def static "ios_common_keywords.wait_for_load.waitTimeForObjectToBeVisible"(
    	Object testObj	
     , 	int waitTime	
     , 	int waitLimit	) {
    (new ios_common_keywords.wait_for_load()).waitTimeForObjectToBeVisible(
        	testObj
         , 	waitTime
         , 	waitLimit)
}

 /**
	 * adds products to a location
	 * @param locationName (name of the location),productName (name of the product to be added)
	 */ 
def static "ios_inventory.Location_details_Screen.add_Product_to_Location"(
    	String locationName	
     , 	String productName	) {
    (new ios_inventory.Location_details_Screen()).add_Product_to_Location(
        	locationName
         , 	productName)
}

 /**
	 * taps on scan and adds product based on count type of partial or full count
	 * @param productName (name of the product to be added),countType (count type required which can be partial or full count),quantity (quantity of the product required to be added)
	 */ 
def static "ios_inventory.Location_details_Screen.click_On_ScanIcon_And_Add_Product"(
    	String productName	
     , 	String countType	
     , 	String quantity	) {
    (new ios_inventory.Location_details_Screen()).click_On_ScanIcon_And_Add_Product(
        	productName
         , 	countType
         , 	quantity)
}

 /**
	 * copies products to another location
	 * @param locationName (name of the location to which product will be copied)
	 */ 
def static "ios_inventory.Location_details_Screen.copy_Product_to_Another_Location"(
    	String locationName	) {
    (new ios_inventory.Location_details_Screen()).copy_Product_to_Another_Location(
        	locationName)
}

 /**
	 * deletes a product from a location
	 * @param ndcNumber (deletes the product according to the ndcNumber)
	 */ 
def static "ios_inventory.Location_details_Screen.deleteProduct"(
    	String ndcNumber	) {
    (new ios_inventory.Location_details_Screen()).deleteProduct(
        	ndcNumber)
}

 /**
	 * edits the location name and cost type can be changed(last price or current price paid)
	 * @param newLocationName (new name of the location),costType (cost type required which can be current or last price paid)
	 */ 
def static "ios_inventory.Location_details_Screen.edit_Location_Name"(
    	String newLocationName	
     , 	String costType	) {
    (new ios_inventory.Location_details_Screen()).edit_Location_Name(
        	newLocationName
         , 	costType)
}

 /**
	 * moves products to another location
	 * @param locationName (name of the location to which product will be moved)
	 */ 
def static "ios_inventory.Location_details_Screen.move_Product_to_Another_Location"(
    	String locationName	) {
    (new ios_inventory.Location_details_Screen()).move_Product_to_Another_Location(
        	locationName)
}

 /**
	 * uploads location from the location details screen
	 */ 
def static "ios_inventory.Location_details_Screen.upload_Location"() {
    (new ios_inventory.Location_details_Screen()).upload_Location()
}

 /**
	 * verifies details of location details screen
	 * @param locationName (name of the location under verification)
	 */ 
def static "ios_inventory.Location_details_Screen.verify_Location_details_Screen"(
    	String locationName	) {
    (new ios_inventory.Location_details_Screen()).verify_Location_details_Screen(
        	locationName)
}

 /**
	 * adds location to an inventory based on the cost type of current or last price paid
	 * @param locationName (name of the location to be added), costType (cost type required which can be current or last price paid)
	 */ 
def static "ios_inventory.Inventory_details_Screen.add_Location"(
    	String locationName	
     , 	String costType	) {
    (new ios_inventory.Inventory_details_Screen()).add_Location(
        	locationName
         , 	costType)
}

 /**
	 * opens the particular location details
	 * @param locationName (name of the location)
	 */ 
def static "ios_inventory.Inventory_details_Screen.click_On_Location"(
    	String locationName	) {
    (new ios_inventory.Inventory_details_Screen()).click_On_Location(
        	locationName)
}

 /**
	 * deletes the location
	 * @param locationName (name of the location to be deleted)
	 */ 
def static "ios_inventory.Inventory_details_Screen.delete_Location"(
    	String locationName	) {
    (new ios_inventory.Inventory_details_Screen()).delete_Location(
        	locationName)
}

 /**
	 * verifies the location count, cost gets updated or not, of the inventory after the location is deleted
	 * @param locationName (name of the location under verification)
	 */ 
def static "ios_inventory.Inventory_details_Screen.delete_Location_With_Cost_LocationCount_Verification"(
    	String locationName	) {
    (new ios_inventory.Inventory_details_Screen()).delete_Location_With_Cost_LocationCount_Verification(
        	locationName)
}

 /**
	 * edits the inventory name
	 * @param newInventoryName (new name of the inventory)
	 */ 
def static "ios_inventory.Inventory_details_Screen.edit_InventoryName"(
    	String newInventoryName	) {
    (new ios_inventory.Inventory_details_Screen()).edit_InventoryName(
        	newInventoryName)
}

 /**
	 * searches and adds the product from the inventory details screen by creating a new location 
	 * @param locationName (name of the location to be created),productName (name of the product to be added),costType (cost type required which can be current or last price paid)
	 */ 
def static "ios_inventory.Inventory_details_Screen.search_And_Add_Product_By_Creating_New_Location"(
    	String locationName	
     , 	String productName	
     , 	String costType	) {
    (new ios_inventory.Inventory_details_Screen()).search_And_Add_Product_By_Creating_New_Location(
        	locationName
         , 	productName
         , 	costType)
}

 /**
	 * verifies various details of the inventory details screen
	 * @param inventoryName (name of the inventory which is under verification)
	 */ 
def static "ios_inventory.Inventory_details_Screen.verify_Inventory_Details_Screen"(
    	String inventoryName	) {
    (new ios_inventory.Inventory_details_Screen()).verify_Inventory_Details_Screen(
        	inventoryName)
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


def static "android_common_keywords.commonMethods.goOneScreenBack"() {
    (new android_common_keywords.commonMethods()).goOneScreenBack()
}


def static "android_common_keywords.commonMethods.installingAndlaunchingTheApplication"() {
    (new android_common_keywords.commonMethods()).installingAndlaunchingTheApplication()
}


def static "android_common_keywords.commonMethods.verticalSwipeForRefresh"() {
    (new android_common_keywords.commonMethods()).verticalSwipeForRefresh()
}


def static "android_common_keywords.commonMethods.verticalSwipeForRefreshingC2OrderStatus"() {
    (new android_common_keywords.commonMethods()).verticalSwipeForRefreshingC2OrderStatus()
}


def static "android_common_keywords.commonMethods.waitForProgressBarToBeInvisible"() {
    (new android_common_keywords.commonMethods()).waitForProgressBarToBeInvisible()
}


def static "android_common_keywords.commonMethods.waitTimeForObjectToBeVisible"(
    	Object testObj	
     , 	int waitTime	
     , 	int waitLimit	) {
    (new android_common_keywords.commonMethods()).waitTimeForObjectToBeVisible(
        	testObj
         , 	waitTime
         , 	waitLimit)
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


def static "android_orders.New_Order_Screen.change_Account"(
    	String New_Account	) {
    (new android_orders.New_Order_Screen()).change_Account(
        	New_Account)
}


def static "android_orders.New_Order_Screen.enter_Purchase_Order_Details"(
    	String PO_Name	
     , 	String PO_Memo	) {
    (new android_orders.New_Order_Screen()).enter_Purchase_Order_Details(
        	PO_Name
         , 	PO_Memo)
}


def static "android_orders.New_Order_Screen.create_Order"() {
    (new android_orders.New_Order_Screen()).create_Order()
}


def static "android_orders.New_Order_Screen.click_On_NewOrder"() {
    (new android_orders.New_Order_Screen()).click_On_NewOrder()
}


def static "android_orders.New_Order_Screen.verify_NewOrder_Screen_Details"() {
    (new android_orders.New_Order_Screen()).verify_NewOrder_Screen_Details()
}


def static "ios_common_keywords.TearDown_Delete_Inventory.Custom"(
    	String Location_Name	) {
    (new ios_common_keywords.TearDown_Delete_Inventory()).Custom(
        	Location_Name)
}

 /**
	 * performs login function
	 * @param username,password
	 */ 
def static "ios_login.Login_Screen.login"(
    	Object username	
     , 	Object password	) {
    (new ios_login.Login_Screen()).login(
        	username
         , 	password)
}

 /**
	 * selects the environment
	 */ 
def static "ios_login.Login_Screen.select_Environment"() {
    (new ios_login.Login_Screen()).select_Environment()
}

 /**
	 * selects type of testing
	 * @param testingType
	 */ 
def static "ios_login.Login_Screen.select_type_Of_Testing"(
    	String testingType	) {
    (new ios_login.Login_Screen()).select_type_Of_Testing(
        	testingType)
}

 /**
	 * enters the username
	 * @param username
	 */ 
def static "ios_login.Login_Screen.enter_Username"(
    	String username	) {
    (new ios_login.Login_Screen()).enter_Username(
        	username)
}

 /**
	 * enters the password
	 * @param password
	 */ 
def static "ios_login.Login_Screen.enter_Password"(
    	String password	) {
    (new ios_login.Login_Screen()).enter_Password(
        	password)
}

 /**
	 * clicks on signIn button
	 * @param password
	 */ 
def static "ios_login.Login_Screen.click_On_SignIn_Button"() {
    (new ios_login.Login_Screen()).click_On_SignIn_Button()
}

 /**
	 * clicks on forget password button
	 */ 
def static "ios_login.Login_Screen.click_On_Forgot_Password"() {
    (new ios_login.Login_Screen()).click_On_Forgot_Password()
}

 /**
	 * verifies the details of login Page
	 */ 
def static "ios_login.Login_Screen.verify_LoginPage_Details"() {
    (new ios_login.Login_Screen()).verify_LoginPage_Details()
}


def static "ios_login.Login_Screen.select_type_Of_Testing"() {
    (new ios_login.Login_Screen()).select_type_Of_Testing()
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


def static "android_common_keywords.start_application.Custom"() {
    (new android_common_keywords.start_application()).Custom()
}


def static "ios_orders.Orders_Screen.click_On_NewOrder"() {
    (new ios_orders.Orders_Screen()).click_On_NewOrder()
}


def static "ios_orders.Orders_Screen.click_On_History_Tab"() {
    (new ios_orders.Orders_Screen()).click_On_History_Tab()
}


def static "ios_orders.Orders_Screen.click_On_Cart_Tab"() {
    (new ios_orders.Orders_Screen()).click_On_Cart_Tab()
}


def static "android_csos.Csos_flow.Place_C2_Order"() {
    (new android_csos.Csos_flow()).Place_C2_Order()
}


def static "android_csos.Csos_flow.vertical_swipe_refresh"() {
    (new android_csos.Csos_flow()).vertical_swipe_refresh()
}


def static "android_csos.Csos_flow.select_C2_Order_for_Adding_Product"(
    	String po_Name	) {
    (new android_csos.Csos_flow()).select_C2_Order_for_Adding_Product(
        	po_Name)
}


def static "android_csos.Csos_flow.Review_and_Sign_C2_Order"() {
    (new android_csos.Csos_flow()).Review_and_Sign_C2_Order()
}


def static "android_csos.Csos_flow.Perform_Signature_and_Confirm_Order"(
    	String Signing_Password	) {
    (new android_csos.Csos_flow()).Perform_Signature_and_Confirm_Order(
        	Signing_Password)
}


def static "android_csos.Csos_flow.Open_C2_Orders"() {
    (new android_csos.Csos_flow()).Open_C2_Orders()
}


def static "android_csos.Csos_flow.Open_C2_Order_details_before_Signature"() {
    (new android_csos.Csos_flow()).Open_C2_Order_details_before_Signature()
}


def static "android_csos.Csos_flow.Go_to_Order_History"() {
    (new android_csos.Csos_flow()).Go_to_Order_History()
}


def static "android_csos.Csos_flow.Create_New_C2_Order"(
    	String PO_Name	
     , 	String PO_Memo	) {
    (new android_csos.Csos_flow()).Create_New_C2_Order(
        	PO_Name
         , 	PO_Memo)
}


def static "android_csos.Csos_flow.Check_C2_Availability"() {
    (new android_csos.Csos_flow()).Check_C2_Availability()
}


def static "android_csos.Csos_flow.CSOS_Search_Product"(
    	String Product_Name	
     , 	String Quantity	) {
    (new android_csos.Csos_flow()).CSOS_Search_Product(
        	Product_Name
         , 	Quantity)
}

 /**
	 * selects the account from the accounts list
	 * @param accountNo
	 */ 
def static "ios_account_selection.Select_An_Account.selectTheUserAccount"(
    	String accountNo	) {
    (new ios_account_selection.Select_An_Account()).selectTheUserAccount(
        	accountNo)
}


def static "android_dashboard.Dashboard_details_Screen.change_Account"(
    	String new_Account	) {
    (new android_dashboard.Dashboard_details_Screen()).change_Account(
        	new_Account)
}


def static "android_dashboard.Dashboard_details_Screen.Adding_Product_from_Dashboard_To_Cart"(
    	String Product_Name	
     , 	String Quantity	) {
    (new android_dashboard.Dashboard_details_Screen()).Adding_Product_from_Dashboard_To_Cart(
        	Product_Name
         , 	Quantity)
}


def static "android_dashboard.Dashboard_details_Screen.click_On_Orders"() {
    (new android_dashboard.Dashboard_details_Screen()).click_On_Orders()
}


def static "android_dashboard.Dashboard_details_Screen.click_On_HomeTab"() {
    (new android_dashboard.Dashboard_details_Screen()).click_On_HomeTab()
}


def static "android_dashboard.Dashboard_details_Screen.click_On_More_Options"() {
    (new android_dashboard.Dashboard_details_Screen()).click_On_More_Options()
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


def static "ios_common_keywords.Go_Back.Custom"() {
    (new ios_common_keywords.Go_Back()).Custom()
}
