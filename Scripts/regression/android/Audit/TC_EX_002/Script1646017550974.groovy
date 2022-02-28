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

//'starts the application'
//CustomKeywords.'androidCommonKeywords.commonMethods.installingAndlaunchingTheApplication'()
//
//'login function called which takes user to the accounts selection screen'
//CustomKeywords.'androidLogin.loginScreen.login'(username, password)
//
//'selects the user account from the accounts list'
//CustomKeywords.'androidAccountSelection.selectAnAccount.selectTheUserAccount'(accountNo)

//'waits until the progressBar is visible on the screen'
//CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'---------------Audit screen by check toggle in offline mode--------------'

'longpress account icon to turns on airplane mode'
CustomKeywords.'androidCommonKeywords.emergencyOrderingMode.enableOrDisableEOmode'()

'Close the popup'
CustomKeywords.'androidCommonKeywords.emergencyOrderingMode.CloseFlyout'()

'Tap on Audits icon in the bottom navigation menu'
CustomKeywords.'androidDashboard.dashboardDetailsScreen.tapOnAudits'()

'Verify on Audits screen offline mode message'
CustomKeywords.'androidAudits.auditsListingScreen.verifyMessageOffline'(expectedMessage)

'longpress account icon to turns on airplane mode'
CustomKeywords.'androidCommonKeywords.emergencyOrderingMode.enableOrDisableEOmode'()

'Tap on Audits icon in the bottom navigation menu'
CustomKeywords.'androidDashboard.dashboardDetailsScreen.tapOnAudits'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'verify Audits screen - welcome note, product group, hand count, collapse button'
CustomKeywords.'androidAudits.auditsListingScreen.verifyAuditsScreen'(expectedMessage2)








