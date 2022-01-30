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

'login function called which takes user to the accounts selection screen'
CustomKeywords.'iosLogin.loginScreen.login'(username, password)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'selects the user account from the accounts list'
CustomKeywords.'iosAccountSelection.selectAnAccount.selectTheUserAccount'(accountNo)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'clicks on audits tab to navigate to audits screen'
CustomKeywords.'iosDashboard.dashboardScreen.clickOnAuditsTab'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'this function closes change account prompt on the audits landing Screen'
CustomKeywords.'iosAudits.auditsScreen.closeChangeAccountPrompt'()

'verifies audits screen'
CustomKeywords.'iosAudits.auditsScreen.verifyAuditsLandingScreen'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'tap on the Account Icon in the top left of the Page and Tap on Change'
CustomKeywords.'iosAudits.auditsScreen.change_Account'(switchToAccount_1)

'verify current user account number'
CustomKeywords.'iosCommonKeywords.commonMethods.verifySelectedAccount'(switchToAccount_1)

'verifies audits screen'
CustomKeywords.'iosAudits.auditsScreen.verifyAuditsLandingScreen'()

'tap on the Account Icon in the top left of the Page and Tap on Change'
CustomKeywords.'iosAudits.auditsScreen.change_Account'(switchToAccount_2)

'verify current user account number'
CustomKeywords.'iosCommonKeywords.commonMethods.verifySelectedAccount'(switchToAccount_2)

