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

'takes user from login to home screen and takes username, password, account no as the arguments'
CustomKeywords.'iosCommonKeywords.commonMethods.takeUserFromloginToHomeScreen'(GlobalVariable.Username, GlobalVariable.Password, 
    GlobalVariable.Account)

'reading the module test data file'
def requestObject = CustomKeywords.'common.commonMethods.readFileTypeJSON'('inventoryTestData.json')

'reading the productName(first three alphabets) of product to be added'
String productSearch = requestObject[GlobalVariable.Environment].TC_R_024.productSearchByName

'clicks on search text field'
CustomKeywords.'iosCommonKeywords.commonMethods.clickOnProductSearchTextField'()

'clicks on search text field'
CustomKeywords.'iosCommonKeywords.commonMethods.enterProductInSearchField'(productSearch)

'performs basic text opertions like copy, cut, paste and takes textOperation as the argument'
CustomKeywords.'iosCommonKeywords.commonMethods.performBasicTextManagementOperation'(textOperation_1)

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'takes the application one screen back'
CustomKeywords.'iosDashboard.dashboardScreen.verifyDashboardScreen'()

'clicks on search text field'
CustomKeywords.'iosCommonKeywords.commonMethods.clickOnProductSearchTextField'()

'performs basic text opertions like copy, cut, paste and takes textOperation as the argument'
CustomKeywords.'iosCommonKeywords.commonMethods.performBasicTextManagementOperation'(textOperation_2)

'taps on keypad Search key'
CustomKeywords.'iosCommonKeywords.commonMethods.clickOnSearchKey'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'reading the ndc of product to be added'
productSearch = requestObject[GlobalVariable.Environment].TC_R_024.productSearchByNDC

'this function verifies that the product is visible on the product search screen'
CustomKeywords.'iosCommonKeywords.commonMethods.verifyProductIsVisibleOnTheProductSearchScreen'(productSearch)

