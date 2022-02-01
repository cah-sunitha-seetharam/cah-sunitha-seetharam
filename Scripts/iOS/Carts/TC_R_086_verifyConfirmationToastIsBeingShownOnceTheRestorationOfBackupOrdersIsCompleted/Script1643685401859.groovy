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
CustomKeywords.'iosCommonKeywords.commonMethods.installingAndlaunchingTheApplication'()

'logins with username password and then opens account selection page'
CustomKeywords.'iosLogin.loginScreen.login'(username,password)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'after login, verifies page caption and selects account'
CustomKeywords.'iosAccountSelection.selectAnAccount.selectTheUserAccount'(accountNo)

'opens cart page'
CustomKeywords.'iosDashboard.dashboardScreen.clickOnOrders'()

'verifies bcs notification on the cart screen'
CustomKeywords.'iosOrders.bcsOrders.verifyBcsNotification'()

'pens the saved orders by tapping on the bcs notification'
CustomKeywords.'iosOrders.bcsOrders.openSavedOrdersList'()

'verifies details related to saved orders listing screen'
CustomKeywords.'iosOrders.bcsOrders.verifySavedOrdersListDetails'()

'copies topmost non c2 order to cart screen verifies details related to order name, account name, lines count of the order which is at the top of the order list under saved orders'
CustomKeywords.'iosOrders.bcsOrders.copyAndVerifyTopMostOrderDetailsUnderSavedOrdersToCartScreen'()





