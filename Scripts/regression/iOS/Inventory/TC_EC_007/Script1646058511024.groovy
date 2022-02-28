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

/*
'starts the application'
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

'reading the module test data file  '
def requestObject = CustomKeywords.'common.commonMethods.readFileTypeJSON'('edgeCases.json')

'reading the ndc of nonc2 product to be added'
String[] productSearchNonC2 = requestObject.productSearchByNDC_NonC2

'count type array'
String[] countType = ['Partial Count', 'Full Count']

'calling addMultipleLocationsWithScannedProduct method to add multiple locations with multiple products'
CustomKeywords.'iosInventory.inventoryDetailsScreen.addMultipleLocationsWithScannedProduct'(locationNameLength, costType, 
    noOfLocationsRequired, countType, productSearchNonC2, noOfIterations)

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'deletes the inventory and takes inventoryName as the argument'
CustomKeywords.'iosInventory.inventoryListingScreen.deleteInventory'(inventoryName)

