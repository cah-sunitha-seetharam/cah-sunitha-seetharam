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
import java.util.Stack

CustomKeywords.'iosCommonKeywords.commonMethods.installingAndlaunchingTheApplication'()

CustomKeywords.'iosLogin.loginScreen.login'(GlobalVariable.Username, GlobalVariable.Password)

CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

CustomKeywords.'iosAccountSelection.selectAnAccount.selectTheUserAccount'(GlobalVariable.Account)

CustomKeywords.'iosDashboard.dashboardDetailsScreen.clickOnMoreOptionsTab'()

CustomKeywords.'iosMoreOptions.moreOptionsScreen.goToInventoryListingScreen'()

CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'output of random string generator is stored in inventoryName which will be passed into create_Inventory function'
inventoryName = CustomKeywords.'common.commonMethods.randomStringGenerator'(inventoryNameLength)

CustomKeywords.'iosInventory.inventoryListingScreen.createInventory'(inventoryName)

CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'ouput of random string generator is stored in locationName which will be passed into add_Location function\n'
locationName = CustomKeywords.'common.commonMethods.randomStringGenerator'(locationNameLength)

CustomKeywords.'iosInventory.inventoryDetailsScreen.addLocation'(locationName, costType)

CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

CustomKeywords.'iosInventory.inventoryDetailsScreen.clickOnALocation'(locationName)

CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

Stack <String> ndcNumbersStack=new Stack<String>();

def requestObject = CustomKeywords.'common.commonMethods.readFileTypeJSON'('testData.json') // reading the module test data file 

String productSearch = requestObject[GlobalVariable.Environment].TC_R_010.productSearchByNDC1 //reading the cin of product to be added

ndcNumbersStack.push(productSearch)

CustomKeywords.'iosInventory.locationDetailsScreen.clickOnScanIconAndAddProduct'(productSearch, countType, quantity)

CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

productSearch = requestObject[GlobalVariable.Environment].TC_R_010.productSearchByNDC2 //reading the cin of product to be added

ndcNumbersStack.push(productSearch)

CustomKeywords.'iosInventory.locationDetailsScreen.clickOnScanIconAndAddProduct'(productSearch, countType, quantity)

CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

productSearch = requestObject[GlobalVariable.Environment].TC_R_010.productSearchByNDC3 //reading the cin of product to be added

ndcNumbersStack.push(productSearch)

CustomKeywords.'iosInventory.locationDetailsScreen.clickOnScanIconAndAddProduct'(productSearch, countType, quantity)

CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

CustomKeywords.'iosCommonKeywords.commonMethods.verifyReverseChronological'(ndcNumbersStack)

CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

CustomKeywords.'iosInventory.inventoryDetailsScreen.deleteLocation'(locationName)

CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

CustomKeywords.'iosInventory.inventoryListingScreen.deleteInventory'(inventoryName)

