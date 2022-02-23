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
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()\

'takes user to dashboard screen'
CustomKeywords.'iosDashboard.dashboardScreen.clickOnReceivingTab'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

/*
'clicks on continue button after selection of shipments or invoice by user'
CustomKeywords.'iosReceiving.receivingReusableMethods.clickOnContinue'()
*/
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

'returns max upper value without over-age product count'
int maxReceivingProductCountWithoutOverage = CustomKeywords.'iosReceiving.receivingReusableMethods.returnUpperLimitReceivingProductCount'()

'takes received product count as the argument and enters count in the text-field'
CustomKeywords.'iosReceiving.receivingReusableMethods.editReceivedProductCount'(maxReceivingProductCountWithoutOverage)

'verifies received tag is visible after inputting receiving count which is less or equal to the max upper limit'
CustomKeywords.'iosReceiving.receivingReusableMethods.verifyReceivedTag'()

'takes received product count as the argument and enters count in the text-field'
CustomKeywords.'iosReceiving.receivingReusableMethods.editReceivedProductCount'(++maxReceivingProductCountWithoutOverage)

' verifies pop up to allow over-age'
CustomKeywords.'iosReceiving.receivingReusableMethods.verifyOveragePopUp'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'verifies over-age tag is visible after inputting receiving count which is more than the max upper limit'
CustomKeywords.'iosReceiving.receivingReusableMethods.verifyOverAgeTag'()

