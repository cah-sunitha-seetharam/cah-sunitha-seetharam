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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

'installs and launches the application'
CustomKeywords.'iosCommonKeywords.commonMethods.installingAndlaunchingTheApplication'()

'logins with username password and then opens account selection page'
CustomKeywords.'iosLogin.loginScreen.login'(GlobalVariable.Username, GlobalVariable.Password)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'after login, verifies page caption and selects account'
CustomKeywords.'iosAccountSelection.selectAnAccount.selectTheUserAccount'(GlobalVariable.Account)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'takes user to dashboard screen'
CustomKeywords.'iosDashboard.dashboardScreen.clickOnReceivingTab'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'clicks on continue button after selection of shipments or invoice by user'
CustomKeywords.'iosReceiving.receivingReusableMethods.clickOnContinue'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'this function will select invoices on the receiving screen'
CustomKeywords.'iosReceiving.receivingReusableMethods.selectInvoices'()

'allows over-ages in receiving'
CustomKeywords.'iosReceiving.receivingReusableMethods.selectAllowOverages'()

'takes user to today from previous day screen'
CustomKeywords.'iosReceiving.receivingReusableMethods.switchToPreviousDay'()

'this method verifies the invoices detail'
CustomKeywords.'iosReceiving.receivingReusableMethods.verifyInvoicesListScreenDetails'()

'reading the module test data file'
def requestObject = CustomKeywords.'common.commonMethods.readFileTypeJSON'('receivingTestData.json')

'reading the product name of product to be added (nonC2 product)'
String productSearch = requestObject[GlobalVariable.Environment].TC_OE_024.productSearchByNDC

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'takes toteID to be searched as the argument and searches the same'
CustomKeywords.'iosReceiving.receivingReusableMethods.searchTote'(toteID)

'verifies details of the instances of product associated with the account'
CustomKeywords.'iosReceiving.receivingReusableMethods.verifyInstancesOfProductAssociatedWithAccount'(productSearch)

'this function opens invoice details'
CustomKeywords.'iosCommonKeywords.commonMethods.searchProduct'(productSearch)

'verifies details of the product associated with the account'
CustomKeywords.'iosReceiving.receivingReusableMethods.verifyProductSearchDetails'(productSearch)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'this function will select shipments on the receiving screen'
CustomKeywords.'iosReceiving.receivingReusableMethods.selectShipments'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'takes toteID to be searched as the argument and searches the same'
CustomKeywords.'iosReceiving.receivingReusableMethods.searchTote'(toteID)

'verifies details of the instances of product associated with the account'
CustomKeywords.'iosReceiving.receivingReusableMethods.verifyInstancesOfProductAssociatedWithAccount'(productSearch)

'this function opens invoice details'
CustomKeywords.'iosCommonKeywords.commonMethods.searchProduct'(productSearch)

'verifies details of the product associated with the account'
CustomKeywords.'iosReceiving.receivingReusableMethods.verifyProductSearchDetails'(productSearch)

