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

'clicks on continue button after selection of shipments or invoice by user'
CustomKeywords.'iosReceiving.receivingReusableMethods.clickOnContinue'()

'allows over-ages in receiving'
CustomKeywords.'iosReceiving.receivingReusableMethods.selectAllowOverages'()

'this function verifies the receiving screen details'
CustomKeywords.'iosReceiving.receivingReusableMethods.verifyReceivingScreen'()

'verifies that over-ages are allowed'
CustomKeywords.'iosReceiving.receivingReusableMethods.verifyAllowedOverages'()

'this function will select shipments on the receiving screen'
CustomKeywords.'iosReceiving.receivingReusableMethods.selectShipments'()

'takes user to previous day from today screen'
CustomKeywords.'iosReceiving.receivingReusableMethods.switchToPreviousDay'()

'this function verifies the shipments detail'
CustomKeywords.'iosReceiving.receivingReusableMethods.verifyShipmentsListScreenDetails'()

'this function opens shipment details'
CustomKeywords.'iosReceiving.receivingReusableMethods.openShipmentDetails'(shipmentNumber)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'verifies shipment details'
CustomKeywords.'iosReceiving.receivingReusableMethods.verifyShipmentDetails'(shipmentNumber)

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'this function will select invoices on the receiving screen'
CustomKeywords.'iosReceiving.receivingReusableMethods.selectInvoices'()

'verifies the invoice is visible on the screen'
CustomKeywords.'iosReceiving.receivingReusableMethods.verifyInvoiceIsVisible'(invoiceNumber)

'this method verifies the invoices detail'
CustomKeywords.'iosReceiving.receivingReusableMethods.verifyInvoicesListScreenDetails'()

'this function opens invoice details'
CustomKeywords.'iosReceiving.receivingReusableMethods.openInvoiceDetails'(invoiceNumber)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'verifies the invoices detail'
CustomKeywords.'iosReceiving.receivingReusableMethods.verifyInvoicesDetails'(invoiceNumber)

