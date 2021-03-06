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

/*'installs and launches the application'
CustomKeywords.'androidCommonKeywords.commonMethods.installingAndlaunchingTheApplication'()

'logins with username password and then opens account selection page'
CustomKeywords.'androidLogin.loginScreen.login'(GlobalVariable.Username, GlobalVariable.Password)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'after login, verifies page caption and selects account'
CustomKeywords.'androidAccountSelection.selectAnAccount.selectTheUserAccount'(GlobalVariable.Account)
*/
'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'takes user to dashboard screen'
CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnReceivingTab'()

'this function will select shipments on the receiving screen'
CustomKeywords.'androidReceiving.receivingReusableMethods.selectShipments'()

'allows over-ages in receiving'
CustomKeywords.'androidReceiving.receivingReusableMethods.selectAllowOverages'()

'this function will select shipments on the receiving screen'
CustomKeywords.'androidReceiving.receivingReusableMethods.selectInvoices'()

'this function will select shipments on the receiving screen'
CustomKeywords.'androidReceiving.receivingReusableMethods.selectShipments'()

'verifies that over-ages are allowed'
CustomKeywords.'androidReceiving.receivingReusableMethods.verifyAllowedOverages'()

/*'clicks on continue button after selection of shipments or invoice by user'
CustomKeywords.'androidReceiving.receivingReusableMethods.clickOnContinue'()
*/

'this function verifies the receiving screen details'
CustomKeywords.'androidReceiving.receivingReusableMethods.verifyReceivingScreen'()

'verifies that over-ages are allowed'
CustomKeywords.'androidReceiving.receivingReusableMethods.verifyAllowedOverages'()

'takes user to previous day from today screen'
CustomKeywords.'androidReceiving.receivingReusableMethods.switchToPreviousDay'()

'this function verifies the shipments detail'
CustomKeywords.'androidReceiving.receivingReusableMethods.verifyShipmentsListScreenDetails'()

'reading the module test data file'
def requestObject = CustomKeywords.'common.commonMethods.readFileTypeJSON'('receivingTestData.json')

'reading the product name of product to be added (nonC2 product)'
String productSearch = requestObject[GlobalVariable.Environment].TC_R_001.productSearchByNDC

'click on scan icon'
CustomKeywords.'androidReceiving.receivingReusableMethods.clickOnScanIcon'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'takes product to be searched as the argument and searches for the product'
CustomKeywords.'androidReceiving.receivingReusableMethods.scanInputEvent'(productSearch)

'verifies details of the instances of product associated with the account'
CustomKeywords.'androidReceiving.receivingReusableMethods.verifyInstancesOfProductAssociatedWithAccount'(productSearch)

