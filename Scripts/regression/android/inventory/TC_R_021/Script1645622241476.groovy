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

'selects the user account from the accounts list'
CustomKeywords.'androidAccountSelection.selectAnAccount.selectTheUserAccount'(GlobalVariable.Account)*/


'takes user from home screen to inventory listing screen'
CustomKeywords.'androidCommonKeywords.commonMethods.takeUserFromHomeToInventoryListingScreen'()

'output of random string generator is stored in inventoryName which will be passed into createInventory function'
inventoryName = CustomKeywords.'common.commonMethods.randomStringGenerator'(inventoryNameLength)

'creates an inventory by taking inventoryName as the argument'
CustomKeywords.'androidInventory.inventoryListingScreen.createInventory'(inventoryName)

'ouput of random string generator is stored in locationName which will be passed into addLocation function'
locationName = CustomKeywords.'common.commonMethods.randomStringGenerator'(locationNameLength)

'adds location in location details page and takes locationName as the argument'
CustomKeywords.'androidInventory.inventoryDetailsScreen.addLocation'(locationName, costType)

'opens the location details and takes the locationName as the argument'
CustomKeywords.'androidInventory.inventoryDetailsScreen.clickOnLocation'(locationName)

'reading the module test data file'
def requestObject = CustomKeywords.'common.commonMethods.readFileTypeJSON'('inventoryTestData.json')

'reading the upc of product to be added'
String productSearch = requestObject[GlobalVariable.Environment].TC_R_021.productSearchByUPC

'taps on scan icon and takes user to scanning product screen and also verifies that the default toggle is at full count'
CustomKeywords.'androidInventory.locationDetailsScreen.clickOnScanIcon'()

'calling the function which selects the countType required for a product which is searched and takes countType as the argument'
CustomKeywords.'androidInventory.locationDetailsScreen.selectCountTypeForTheProductToBeAdded'(countType)

'calling the function which scans the product'
CustomKeywords.'androidInventory.locationDetailsScreen.scanInputEvent'(productSearch)

'calling the function which adds the product to the location'
CustomKeywords.'androidInventory.locationDetailsScreen.addProducToLocation'()

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'reading the ndc of product to be added'
productSearch = requestObject[GlobalVariable.Environment].TC_R_021.productSearchByNDC

'this function verifies that the product is visible on the location details screen and takes productName/UPC/Cin/Ndc as the argument'
CustomKeywords.'androidInventory.locationDetailsScreen.verifyProductIsVisibleOnTheLocationDetailsScreen'(productSearch)

'deletes the product and takes productName/Cin/Ndc/UPC as the argument'
CustomKeywords.'androidInventory.locationDetailsScreen.deleteProduct'(productSearch)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'verifies expected lines count equals actual lines count'
CustomKeywords.'androidInventory.locationDetailsScreen.verifyLinesCount'(expectedLinesCount)

'this function verifies that the product is not visible on the location details screen and takes productName/UPC/Cin/Ndc as the argument'
CustomKeywords.'androidInventory.locationDetailsScreen.verifyProductIsNotVisibleOnTheLocationDetailsScreen'(productSearch)

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.pressBacknav'()

'deletes the location and takes locationName as the argument'
CustomKeywords.'androidInventory.inventoryDetailsScreen.deleteLocation'(locationName)

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.pressBacknav'()

'deletes the inventory and takes inventoryName as the argument'
CustomKeywords.'androidInventory.inventoryListingScreen.deleteInventory'(inventoryName)
