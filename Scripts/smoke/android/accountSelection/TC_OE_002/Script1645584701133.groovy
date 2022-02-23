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

'tap on the Account Icon in the top left of the Page and Tap on Change'
CustomKeywords.'androidCommonKeywords.commonMethods.changeAccount'()

'verify current user account number'
CustomKeywords.'androidCommonKeywords.commonMethods.verifyAccount'(GlobalVariable.Account)

'tap on user account from the account list'
CustomKeywords.'androidAccountSelection.selectAnAccount.selectTheUserAccount'(switchToAccount1)

'takes user to the orders tab'
CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnOrders'()

'tap on the Account Icon in the top left of the Page and Tap on Change'
CustomKeywords.'androidCommonKeywords.commonMethods.changeAccount'()

'verify current user account number'
CustomKeywords.'androidCommonKeywords.commonMethods.verifyAccount'(switchToAccount1)

'tap on user account from the account list'
CustomKeywords.'androidAccountSelection.selectAnAccount.selectTheUserAccount'(switchToAccount2)

'takes user from home screen to inventory listing screen'
CustomKeywords.'androidCommonKeywords.commonMethods.takeUserFromHomeToInventoryListingScreen'()

'tap on the Account Icon in the top left of the Page and Tap on Change'
CustomKeywords.'androidCommonKeywords.commonMethods.changeAccount'()

'verify current user account number'
CustomKeywords.'androidCommonKeywords.commonMethods.verifyAccount'(switchToAccount2)

'tap on user account from the account list'
CustomKeywords.'androidAccountSelection.selectAnAccount.selectTheUserAccount'(switchToAccount1)

'verify current user account number'
CustomKeywords.'androidCommonKeywords.commonMethods.verifyAccount'(switchToAccount1)
