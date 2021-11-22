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
CustomKeywords.'iosCommonKeywords.commonMethods.installingAndlaunchingTheApplication'()

'login function called'
CustomKeywords.'iosLogin.loginScreen.login'(GlobalVariable.Username, GlobalVariable.Password)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'selects the user account from the accounts list'
CustomKeywords.'iosAccountSelection.selectAnAccount.selectTheUserAccount'(GlobalVariable.Account)

'takes user to the moreOptions screen'
CustomKeywords.'iosDashboard.dashboardDetailsScreen.clickOnMoreOptionsTab'()

'takes the user from moreOptions screen to the invemtory listing screen'
CustomKeywords.'iosMoreOptions.moreOptionsScreen.goToInventoryListingScreen'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'output of random string generator is stored in inventoryName which will be passed into create_Inventory function'
inventoryName = CustomKeywords.'common.commonMethods.randomStringGenerator'(inventoryNameLength)

'creates an inventory by taking inventoryName as the argument'
CustomKeywords.'iosInventory.inventoryListingScreen.createInventory'(inventoryName)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'ouput of random string generator is stored in locationName which will be passed into add_Location function\n'
locationName = CustomKeywords.'common.commonMethods.randomStringGenerator'(locationNameLength)

'adds location in location details page and takes locationName as the argument'
CustomKeywords.'iosInventory.inventoryDetailsScreen.addLocation'(locationName, costType)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'opens the location details and takes the locationName as the argument'
CustomKeywords.'iosInventory.inventoryDetailsScreen.clickOnALocation'(locationName)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'reading the module test data file  '
def requestObject = CustomKeywords.'common.commonMethods.readFileTypeJSON'('inventoryTestData.json')

'reading the cin of product to be added'
String productSearch = requestObject[GlobalVariable.Environment].TC_R_007.productSearchCin

'calls the function which adds the product by clicking on the scan icon and takes productCin, quantity, countType as the arguments'
CustomKeywords.'iosInventory.locationDetailsScreen.clickOnScanIconAndAddProduct'(productSearch, countType, quantity)

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'uploads the location from location details screen'
CustomKeywords.'iosInventory.locationDetailsScreen.uploadLocation'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'deletes the inventory and takes inventoryName as the argument'
CustomKeywords.'iosInventory.inventoryListingScreen.deleteInventory'(inventoryName)

