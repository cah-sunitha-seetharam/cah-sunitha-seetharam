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
import com.kms.katalon.core.util.KeywordUtil

'starts the application'
CustomKeywords.'androidCommonKeywords.commonMethods.installingAndlaunchingTheApplication'()

'logins with username password and then opens account selection page'
CustomKeywords.'androidLogin.loginScreen.login'(username,password)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'after login, verifies page caption and selects account'
CustomKeywords.'androidAccountSelection.selectAnAccount.selectTheUserAccount'(accountNo)

'opens cart page'
CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnOrders'()

'enable EO mode by long pressing the account text/icon displayed on screen and then closes the opened fly-out'
CustomKeywords.'androidCommonKeywords.emergencyOrderingMode.enableEOmodeAndCloseFlyout'()

'verifies bcs notification on the cart screen'
CustomKeywords.'androidOrders.bcsOrders.verifyBcsNotification'()

'pens the saved orders by tapping on the bcs notification'
CustomKeywords.'androidOrders.bcsOrders.openSavedOrdersList'()

'verifies details related to saved orders listing screen'
CustomKeywords.'androidOrders.bcsOrders.verifySavedOrdersListDetails'()

'verifies details related to c2 orders tile under orders listing screen'
CustomKeywords.'androidOrders.bcsOrders.verifyC2RelatedDetailsForBCS'()




