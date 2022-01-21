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

'installs and launches the application'
CustomKeywords.'iosCommonKeywords.commonMethods.installingAndlaunchingTheApplication'()

'logins with username password and then opens account selection page'
CustomKeywords.'iosLogin.loginScreen.login'(GlobalVariable.Username, GlobalVariable.Password)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'after login, verifies page caption and selects account'
CustomKeywords.'iosAccountSelection.selectAnAccount.selectTheUserAccount'(GlobalVariable.Account)

'takes user to dashboard screen'
CustomKeywords.'iosDashboard.dashboardScreen.clickOnReceivingTab'()

'verifies the receiving screen pop-up which comes after user goes to receiving tab details'
CustomKeywords.'iosReceiving.receivingReusableMethods.verifyReceivingScreenPopUp'()

'clicks on continue button after selection of shipments or invoice by user'
CustomKeywords.'iosReceiving.receivingReusableMethods.clickOnContinue'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'this function verifies the receiving screen details'
CustomKeywords.'iosReceiving.receivingReusableMethods.verifyReceivingScreen'()

'this function will select invoices on the receiving screen'
CustomKeywords.'iosReceiving.receivingReusableMethods.selectInvoices'()

'takes user to today from previous day screen'
CustomKeywords.'iosReceiving.receivingReusableMethods.switchToPreviousDay'()

'this method verifies the invoices detail'
CustomKeywords.'iosReceiving.receivingReusableMethods.verifyInvoicesListScreenDetails'()

'this function opens invoice details'
CustomKeywords.'iosReceiving.receivingReusableMethods.openInvoiceDetails'(invoiceNumber)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'verifies the invoices detail and takes invoice number as the argument'
CustomKeywords.'iosReceiving.receivingReusableMethods.verifyInvoicesDetails'(invoiceNumber)

'returns max upper value without over-age product count'
int maxReceivingProductCountWithoutOverage = CustomKeywords.'iosReceiving.receivingReusableMethods.returnUpperLimitReceivingProductCount'()

'takes expected received product count and maxReceivingProductCountWithoutOverage as the argument and verifies that it should be same as the actual count visible'
CustomKeywords.'iosReceiving.receivingReusableMethods.verifyReceivedProductCountUnderInvoice'(expectedReceivedProductCount_1, maxReceivingProductCountWithoutOverage)

'clicks on receive all totes button'
CustomKeywords.'iosReceiving.receivingReusableMethods.clickOnReceiveAllTotes'()

'takes maxReceivingProductCountWithoutOverage and expected received product count as the argument and verifies that it should be same as the actual count visible'
CustomKeywords.'iosReceiving.receivingReusableMethods.verifyReceivedProductCountUnderInvoice'(maxReceivingProductCountWithoutOverage.toString(), 
    maxReceivingProductCountWithoutOverage)

'uploads completed totes'
CustomKeywords.'iosReceiving.receivingReusableMethods.uploadCompletedTotes'()

'verifies the pop up after uploading totes'
CustomKeywords.'iosReceiving.receivingReusableMethods.verifyUploadTotesPopUp'()

'takes user back to receiving after uploading totes'
CustomKeywords.'iosReceiving.receivingReusableMethods.clickOnBackToReceiving'()

'verifies the invoice is not visible on the screen'
CustomKeywords.'iosReceiving.receivingReusableMethods.verifyInvoiceIsNotVisible'(invoiceNumber)

'this function will select shipments on the receiving screen'
CustomKeywords.'iosReceiving.receivingReusableMethods.selectShipments'()

'this function opens shipment details'
CustomKeywords.'iosReceiving.receivingReusableMethods.openShipmentDetails'(shipmentNumber)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'verifies shipment details'
CustomKeywords.'iosReceiving.receivingReusableMethods.verifyShipmentDetails'(shipmentNumber)

'returns max upper value without over-age product count'
maxReceivingProductCountWithoutOverage = CustomKeywords.'iosReceiving.receivingReusableMethods.returnUpperLimitReceivingProductCount'()

'takes expected received product countand maxReceivingProductCountWithoutOverage  as the argument and verifies that it should be same as the actual count visible'
CustomKeywords.'iosReceiving.receivingReusableMethods.verifyReceivedProductCountUnderShipments'(expectedReceivedProductCount_2, maxReceivingProductCountWithoutOverage)

'clicks on receive all totes button'
CustomKeywords.'iosReceiving.receivingReusableMethods.clickOnReceiveAllTotes'()

'takes expected received product count and maxReceivingProductCountWithoutOverage as the argument and verifies that it should be same as the actual count visible'
CustomKeywords.'iosReceiving.receivingReusableMethods.verifyReceivedProductCountUnderShipments'(maxReceivingProductCountWithoutOverage.toString(), 
    maxReceivingProductCountWithoutOverage)

'clicks on receive all totes button'
CustomKeywords.'iosReceiving.receivingReusableMethods.clickOnReceiveAllTotes'()

//'expands the view to see detailed view of_tote'
//CustomKeywords.'iosReceiving.receivingReusableMethods.expandToSeeDetailedViewOfTotes'()
'uploads completed totes'
CustomKeywords.'iosReceiving.receivingReusableMethods.uploadCompletedTotes'()

'verifies the pop up after uploading totes'
CustomKeywords.'iosReceiving.receivingReusableMethods.verifyUploadTotesPopUp'()

'takes user back to receiving after uploading totes'
CustomKeywords.'iosReceiving.receivingReusableMethods.clickOnBackToReceiving'()

