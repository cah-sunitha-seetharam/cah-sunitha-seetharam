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
CustomKeywords.'iosCommonKeywords.commonMethods.installingAndlaunchingTheApplication'()

'takes user from login to home screen and takes username, password, account no as the arguments'
CustomKeywords.'iosCommonKeywords.commonMethods.takeUserFromloginToHomeScreen'(GlobalVariable.Username, GlobalVariable.Password, 
    GlobalVariable.Account)
*/
'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'takes user from home screen to inventory listing screen'
CustomKeywords.'iosCommonKeywords.commonMethods.takeUserFromHomeToInventoryListingScreen'()

'output of random string generator is stored in inventoryName which will be passed into create_Inventory function'
inventoryName = CustomKeywords.'common.commonMethods.randomStringGenerator'(inventoryNameLength)

'creates an inventory by taking inventoryName as the argument'
CustomKeywords.'iosInventory.inventoryListingScreen.createInventory'(inventoryName)

'ouput of random string generator is stored in locationName which will be passed into add_Location function'
locationName_1 = CustomKeywords.'common.commonMethods.randomStringGenerator'(locationNameLength)

'adds location in location details page and takes locationName as the argument'
CustomKeywords.'iosInventory.inventoryDetailsScreen.addLocation'(locationName_1, costType_1)

'opens the location details and takes the locationName as the argument'
CustomKeywords.'iosInventory.inventoryDetailsScreen.clickOnALocation'(locationName_1)

'reading the module test data file'
def requestObject = CustomKeywords.'common.commonMethods.readFileTypeJSON'('inventoryTestData.json')

'reading the ndc of product to be added'
productSearch_1 = requestObject[GlobalVariable.Environment].TC_OE_009.productSearchByNDC1

'reading the ndc of product to be added'
productSearch_2 = requestObject[GlobalVariable.Environment].TC_OE_009.productSearchByNDC2

'adds products to a location'
CustomKeywords.'iosInventory.locationDetailsScreen.addProducttoLocation'(locationName_1, productSearch_1,quantity_1)

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'ouput of random string generator is stored in locationName which will be passed into add_Location function'
locationName_2 = CustomKeywords.'common.commonMethods.randomStringGenerator'(locationNameLength)

'adds location in location details page and takes locationName as the argument'
CustomKeywords.'iosInventory.inventoryDetailsScreen.addLocation'(locationName_2, costType_2)

'opens the location details and takes the locationName as the argument'
CustomKeywords.'iosInventory.inventoryDetailsScreen.clickOnALocation'(locationName_2)

'adds products to a location'
CustomKeywords.'iosInventory.locationDetailsScreen.addProducttoLocation'(locationName_2, productSearch_2,quantity_2)

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'opens the location details and takes the locationName as the argument'
CustomKeywords.'iosInventory.inventoryDetailsScreen.clickOnALocation'(locationName_1)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'calling the function which copies a product to another location, it takes location and productName/UPC/Cin/Ndc as the argument'
CustomKeywords.'iosInventory.locationDetailsScreen.copyProductToAnotherLocation'(locationName_2, productSearch_1)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'this function gets the total added quantity of the product that is visible on the screen'
int actualQuantity = CustomKeywords.'iosInventory.locationDetailsScreen.returnQuantityOfTheAddedProduct'()

'assertion to verify actual quanity equals the expected quantity'
assert actualQuantity == expectedProductQuantity_1

'this function verifies that the product is visible on the location details screen'
CustomKeywords.'iosInventory.locationDetailsScreen.verifyProductIsVisibleOnTheLocationDetailsScreen'(productSearch_1)

'calling the function which moves a product to another location, it takes location and productName/UPC/Cin/Ndc as the argument'
CustomKeywords.'iosInventory.locationDetailsScreen.moveProductToAnotherLocation'(locationName_1, productSearch_2)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'this function gets the total added quantity of the product that is visible on the screen'
actualQuantity = CustomKeywords.'iosInventory.locationDetailsScreen.returnQuantityOfTheAddedProduct'()

'assertion to verify actual quanity equals the expected quantity'
actualQuantity == expectedProductQuantity_2

'this function verifies that the product is visible on the location details screen'
CustomKeywords.'iosInventory.locationDetailsScreen.verifyProductIsVisibleOnTheLocationDetailsScreen'(productSearch_2)

'calling the function which moves a product to another location, it takes location and productName/UPC/Cin/Ndc as the argument'
CustomKeywords.'iosInventory.locationDetailsScreen.moveProductToAnotherLocation'(locationName_2, productSearch_2)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'calling the function which deletes a product, it takes productName/UPC/Cin/Ndc as the argument'
CustomKeywords.'iosInventory.locationDetailsScreen.deleteProduct'(productSearch_1)

'this function verifies that the product is visible on the location details screen'
CustomKeywords.'iosInventory.locationDetailsScreen.verifyProductIsNotVisibleOnTheLocationDetailsScreen'(productSearch_1)

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'deletes the location and takes locationName as the argument'
CustomKeywords.'iosInventory.inventoryDetailsScreen.deleteLocation'(locationName_2)

'deletes the location and takes locationName as the argument'
CustomKeywords.'iosInventory.inventoryDetailsScreen.deleteLocation'(locationName_1)

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'deletes the inventory and takes inventoryName as the argument'
CustomKeywords.'iosInventory.inventoryListingScreen.deleteInventory'(inventoryName)

