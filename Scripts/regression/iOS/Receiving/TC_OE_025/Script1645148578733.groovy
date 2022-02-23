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

'login function called which takes user to the accounts selection screen'
CustomKeywords.'iosLogin.loginScreen.login'(GlobalVariable.Username, GlobalVariable.Password)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'selects the user account from the accounts list'
CustomKeywords.'iosAccountSelection.selectAnAccount.selectTheUserAccount'(GlobalVariable.Account)
*/
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

'this function verifies the receiving screen details'
CustomKeywords.'iosReceiving.receivingReusableMethods.verifyReceivingScreen'()

'takes user to previous day from today screen'
CustomKeywords.'iosReceiving.receivingReusableMethods.switchToPreviousDay'()

'this function will select invoices on the receiving screen'
CustomKeywords.'iosReceiving.receivingReusableMethods.selectInvoices'()

'this method verifies the invoices detail'
CustomKeywords.'iosReceiving.receivingReusableMethods.verifyInvoicesListScreenDetails'()

'this function will select invoices on the receiving screen'
CustomKeywords.'iosReceiving.receivingReusableMethods.selectShipments'()

'this function verifies the shipments detail'
CustomKeywords.'iosReceiving.receivingReusableMethods.verifyShipmentsListScreenDetails'()

'reading the module test data file'
def requestObject = CustomKeywords.'common.commonMethods.readFileTypeJSON'('receivingTestData.json')

'reading the product name of product to be added (nonC2 product)'
String productSearch = requestObject[GlobalVariable.Environment].TC_OE_025.productSearchByNDC

'this function opens invoice details'
CustomKeywords.'iosReceiving.receivingReusableMethods.openShipmentDetails'(shipmentNumber)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'clicks on receive all totes button'
CustomKeywords.'iosReceiving.receivingReusableMethods.clickOnReceiveAllTotes'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'click on scan icon'
CustomKeywords.'iosReceiving.receivingReusableMethods.clickOnScanIcon'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'takes product to be searched as the argument and searches for the product'
CustomKeywords.'iosReceiving.receivingReusableMethods.scanInputEvent'(productSearch)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'verifies pop up to allow over-age'
CustomKeywords.'iosReceiving.receivingReusableMethods.verifyOveragePopUp'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'verifies details of the product associated with the account'
CustomKeywords.'iosReceiving.receivingReusableMethods.verifyProductSearchDetails'(productSearch)

