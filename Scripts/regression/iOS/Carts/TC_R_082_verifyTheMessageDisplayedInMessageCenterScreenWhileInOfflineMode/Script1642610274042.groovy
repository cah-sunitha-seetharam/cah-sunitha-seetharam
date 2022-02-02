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

'opens existing testflight app and installs latest OE App'
CustomKeywords.'iosCommonKeywords.commonMethods.openTestFlightApp'(bundleID)

'logins with username password and then opens account selection page'
CustomKeywords.'iosLogin.loginScreen.login'(GlobalVariable.Username, GlobalVariable.Password)

'clicks on signIn button and takes to the dash-board of the application'
CustomKeywords.'iosLogin.loginScreen.clickOnSignInButton'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'disables touchid while using real device'
CustomKeywords.'iosCommonKeywords.commonMethods.tapOnSetupLater'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'after login, verifies page caption and selects account'
CustomKeywords.'iosAccountSelection.selectAnAccount.selectTheUserAccount'(accountNo_1)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'opens moreOptions tab where user can perform actions like signOut, goToInventoryListing Screen etc'
CustomKeywords.'iosDashboard.dashboardScreen.clickOnMoreOptionsTab'()

'waits until the progressBar is visible on the screen, which will have a maximum waitLimit to be visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'opens the message center'
CustomKeywords.'iosMoreOptions.moreOptionsScreen.tapMessageCentre'()

'verifies alert and message'
CustomKeywords.'iosMoreOptions.moreOptionsScreen.verifyMessageCentre'()

'turns on airplane mode'
Mobile.toggleAirplaneMode(Yes)

'closes the popup when user switches to offline mode'
CustomKeywords.'iosOrders.orderDetailsScreen.closeOfflinePopUp'()

'opens alert'
CustomKeywords.'iosMoreOptions.moreOptionsScreen.tapOnAlert'()

'waits until the progressBar is visible on the screen, which will have a maximum waitLimit to be visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'verifies alert message description'
CustomKeywords.'iosMoreOptions.moreOptionsScreen.verifyAlertMessageDescription'()

'this method will take the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'opens top most message'
CustomKeywords.'iosMoreOptions.moreOptionsScreen.tapOnTopMostMessage'()

'verifies message description'
CustomKeywords.'iosMoreOptions.moreOptionsScreen.verifyMessageDescription'()

'this method will take the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'change account using account selection icon'
CustomKeywords.'iosOrders.newOrderScreen.change_Account'(accountNo_2)

'waits until the progressBar is visible on the screen, which will have a maximum waitLimit to be visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'verifies message center in offline'
CustomKeywords.'iosMoreOptions.moreOptionsScreen.verifyMessageCentreInOffline'()

'turns off airplane mode'
Mobile.toggleAirplaneMode(No)