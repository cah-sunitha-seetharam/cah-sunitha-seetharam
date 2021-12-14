import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

'starts the application'
CustomKeywords.'androidCommonKeywords.commonMethods.installingAndlaunchingTheApplication'()

'login function called which takes user to the accounts selection screen'
CustomKeywords.'androidLogin.loginScreen.login'(GlobalVariable.Username, GlobalVariable.Password)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'selects the user account from the accounts list'
CustomKeywords.'androidAccountSelection.selectAnAccount.selectTheUserAccount'(GlobalVariable.Account)

'waits for 30(s) before refreshing the page to get the updated historyCount'
WebUI.delay(30)

'takes user from home screen to inventory listing screen'
CustomKeywords.'androidCommonKeywords.commonMethods.takeUserFromHomeToInventoryListingScreen'()

'output of random string generator is stored in inventoryName which will be passed into createInventory function'
Inventory_Name = CustomKeywords.'common.commonMethods.randomStringGenerator'(inventoryNameLength)

'creates an inventory by taking inventoryName as the argument'
CustomKeywords.'android_inventory.Inventory_listing_Screen.create_Inventory'(Inventory_Name)

'ouput of random string generator is stored in locationName which will be passed into addLocation function'
Location_Name = CustomKeywords.'common.commonMethods.randomStringGenerator'(locationNameLength)

'adds location in location details page and takes locationName as the argument'
CustomKeywords.'android_inventory.Inventory_details_Screen.add_Location'(Location_Name, CostType)

'opens the location details and takes the locationName as the argument'
CustomKeywords.'android_inventory.Inventory_details_Screen.click_On_Location'(Location_Name)

'taps on scan icon and takes user to scanning product screen and also verifies that the default toggle is at full count'
CustomKeywords.'android_inventory.locationDetailsScreen.clickOnScanIcon'()

'reading the module test data file'
def requestObject = CustomKeywords.'common.commonMethods.readFileTypeJSON'('inventoryTestData.json')

'reading the ndcNumber of product to be added'
String productSearch = requestObject[GlobalVariable.Environment].TC_R_019.productSearchByNDC1

'calling the function which selects the countType required for a product which is searched and takes countType as the argument'
CustomKeywords.'android_inventory.locationDetailsScreen.selectCountTypeForTheProductToBeAdded'(countType)

'calling the function which scans the product and adds it to the location, it takes productName/UPC/Cin/Ndc as the argument'
CustomKeywords.'android_inventory.locationDetailsScreen.scanInputEvent'(productSearch)

'waits for 10(s) to load product'
WebUI.delay(10)

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'taps on scan icon and takes user to scanning product screen and also verifies that the default toggle is at full count'
CustomKeywords.'android_inventory.locationDetailsScreen.clickOnScanIcon'()

'calling the function which selects the countType required for a product which is searched and takes countType as the argument'
CustomKeywords.'android_inventory.locationDetailsScreen.selectCountTypeForTheProductToBeAdded'(countType)

'calling the function which scans the product and adds it to the location, it takes productName/UPC/Cin/Ndc as the argument'
CustomKeywords.'android_inventory.locationDetailsScreen.scanInputEvent'(productSearch)

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'stores the initial quantity of product added into the variable initialProductCount'
int finalProductQuantity = CustomKeywords.'android_inventory.locationDetailsScreen.returnQuantityOfTheAddedProduct'()

'verifies whether the quantity added is according to the flow expected'
assert finalProductQuantity == expectedProductQuantity

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.pressBacknav'()

'deletes the location and takes locationName as the argument'
CustomKeywords.'android_inventory.Inventory_details_Screen.delete_Location'(Location_Name)

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.pressBacknav'()

'deletes the inventory and takes inventoryName as the argument'
CustomKeywords.'android_inventory.Inventory_listing_Screen.delete_Inventory'(Inventory_Name)

