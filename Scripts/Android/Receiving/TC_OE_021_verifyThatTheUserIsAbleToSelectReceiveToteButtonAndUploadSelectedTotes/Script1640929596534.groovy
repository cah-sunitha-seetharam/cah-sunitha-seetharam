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

'this function will select invoices on the receiving screen'
CustomKeywords.'androidReceiving.receivingReusableMethods.selectInvoices'()

'clicks on continue button after selection of shipments or invoice by user'
CustomKeywords.'androidReceiving.receivingReusableMethods.clickOnContinue'()

'this function verifies the receiving screen details'
CustomKeywords.'androidReceiving.receivingReusableMethods.verifyReceivingScreen'()

'takes user to today from previous day screen'
CustomKeywords.'androidReceiving.receivingReusableMethods.switchToPreviousDay'()

'this method verifies the invoices detail'
CustomKeywords.'androidReceiving.receivingReusableMethods.verifyInvoicesListScreenDetails'()

'this function opens invoice details'
CustomKeywords.'androidReceiving.receivingReusableMethods.openInvoiceDetails'(invoiceNumber)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'verifies the invoices detail and takes invoice number as the argument'
CustomKeywords.'androidReceiving.receivingReusableMethods.verifyInvoicesDetails'(invoiceNumber)

'takes expected received product count as the argument and verifies that it should be same as the actual count visible'
CustomKeywords.'androidReceiving.receivingReusableMethods.verifyReceivedProductCount'(expectedReceivedProductCount_1)

'clicks on receive all totes button'
CustomKeywords.'androidReceiving.receivingReusableMethods.clickOnReceiveAllTotes'()

'takes expected received product count as the argument and verifies that it should be same as the actual count visible'
CustomKeywords.'androidReceiving.receivingReusableMethods.verifyReceivedProductCount'(expectedReceivedProductCount_2)

'uploads completed totes'
CustomKeywords.'androidReceiving.receivingReusableMethods.uploadCompletedTotes'()

'verifies the pop up after uploading totes'
CustomKeywords.'androidReceiving.receivingReusableMethods.verifyUploadTotesPopUp'()

'takes user back to receiving after uploading totes'
CustomKeywords.'androidReceiving.receivingReusableMethods.clickOnBackToReceiving'()

'verifies the invoice is not visible on the screen'
CustomKeywords.'androidReceiving.receivingReusableMethods.verifyInvoiceIsNotVisible'(invoiceNumber)

'this function will select shipments on the receiving screen'
CustomKeywords.'androidReceiving.receivingReusableMethods.selectShipments'()

'this function opens shipment details'
CustomKeywords.'androidReceiving.receivingReusableMethods.openShipmentDetails'(shipmentNumber)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'verifies shipment details'
CustomKeywords.'androidReceiving.receivingReusableMethods.verifyShipmentDetails'(shipmentNumber)

'takes expected received product count as the argument and verifies that it should be same as the actual count visible'
CustomKeywords.'androidReceiving.receivingReusableMethods.verifyReceivedProductCount'(expectedReceivedProductCount_1)

'clicks on receive all totes button'
CustomKeywords.'androidReceiving.receivingReusableMethods.clickOnReceiveAllTotes'()

'expands the view to see detailed view of_tote'
CustomKeywords.'androidReceiving.receivingReusableMethods.expandToSeeDetailedViewOfTotes'()

'uploads completed totes'
CustomKeywords.'androidReceiving.receivingReusableMethods.uploadCompletedTotes'()

'verifies the pop up after uploading totes'
CustomKeywords.'androidReceiving.receivingReusableMethods.verifyUploadTotesPopUp'()

'takes user back to receiving after uploading totes'
CustomKeywords.'androidReceiving.receivingReusableMethods.clickOnBackToReceiving'()

