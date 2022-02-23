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

/*'starts the application'
CustomKeywords.'androidCommonKeywords.commonMethods.installingAndlaunchingTheApplication'()

'login function called which takes user to the accounts selection screen'
CustomKeywords.'androidLogin.loginScreen.login'(GlobalVariable.Username, GlobalVariable.Password)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'selects the user account from the accounts list'
CustomKeywords.'androidAccountSelection.selectAnAccount.selectTheUserAccount'(GlobalVariable.Account)
*/
'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'takes user from home screen to inventory listing screen'
CustomKeywords.'androidCommonKeywords.commonMethods.takeUserFromHomeToInventoryListingScreen'()

'output of random string generator is stored in inventoryName which will be passed into create_Inventory function'
inventoryName_1 = CustomKeywords.'common.commonMethods.randomStringGenerator'(inventoryNameLength)

'output of random string generator is stored in inventoryName which will be passed into create_Inventory function'
inventoryName_2 = CustomKeywords.'common.commonMethods.randomStringGenerator'(inventoryNameLength)

'creates an inventory by taking inventoryName as the argument'
CustomKeywords.'androidInventory.inventoryListingScreen.createInventory'(inventoryName_1)

'ouput of random string generator is stored in locationName which will be passed into add_Location function'
locationName_1 = CustomKeywords.'common.commonMethods.randomStringGenerator'(locationNameLength)

'ouput of random string generator is stored in locationName which will be passed into add_Location function'
locationName_2 = CustomKeywords.'common.commonMethods.randomStringGenerator'(locationNameLength)

'adds location in location details page and takes locationName as the argument'
CustomKeywords.'androidInventory.inventoryDetailsScreen.addLocation'(locationName_1, costType_1)

'opens the location details and takes the locationName as the argument'
CustomKeywords.'androidInventory.inventoryDetailsScreen.clickOnALocation'(locationName_1)

'reading the module test data file'
def requestObject = CustomKeywords.'common.commonMethods.readFileTypeJSON'('inventoryTestData.json')

'reading the ndc of product to be added'
productSearch = requestObject[GlobalVariable.Environment].TC_OE_004.productSearchByNDC

'adds products to a location'
CustomKeywords.'androidInventory.locationDetailsScreen.addProductToLocation'(locationName_1, productSearch,quantity)

'takes the application one screen back'
Mobile.pressBack()

'this function verifies that the product is visible on the location details screen'
CustomKeywords.'androidInventory.locationDetailsScreen.verifyProductIsVisibleOnTheLocationDetailsScreen'(productSearch)

'searches and adds the product from the inventory details screen by creating a new location'
CustomKeywords.'androidInventory.locationDetailsScreen.editLocationName'(locationName_2, costType_2,locationName_1)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'takes the application one screen back'
Mobile.pressBack()

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'opens the location details and takes the locationName as the argument'
CustomKeywords.'androidInventory.inventoryDetailsScreen.clickOnALocation'(locationName_2)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'takes the application one screen back'
Mobile.pressBack()

'adds location in location details page and takes locationName as the argument'
CustomKeywords.'androidInventory.inventoryDetailsScreen.editInventoryName'(inventoryName_2,inventoryName_1)

'takes the application one screen back'
Mobile.pressBack()

'deletes the inventory and takes inventoryName as the argument'
CustomKeywords.'androidInventory.inventoryListingScreen.deleteInventory'(inventoryName_2)

