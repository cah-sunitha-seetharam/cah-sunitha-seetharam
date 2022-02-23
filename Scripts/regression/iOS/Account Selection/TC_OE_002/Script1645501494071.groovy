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

'takes user from login to home screen and takes username, password, account no as the arguments'
CustomKeywords.'iosCommonKeywords.commonMethods.takeUserFromloginToHomeScreen'(GlobalVariable.Username, GlobalVariable.Password, GlobalVariable.Account)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'changes the user account and takes account no as the input'
CustomKeywords.'iosCommonKeywords.commonMethods.changeAccount'(switchToAccount1)

'verifies whether the selected user account is same as the account required'
CustomKeywords.'iosCommonKeywords.commonMethods.verifySelectedAccount'(switchToAccount1)

'takes user to the orders tab'
CustomKeywords.'iosDashboard.dashboardScreen.clickOnOrders'()

'changes the user account and takes account no as the input'
CustomKeywords.'iosCommonKeywords.commonMethods.changeAccount'(switchToAccount2)

'verifies whether the selected user account is same as the account required'
CustomKeywords.'iosCommonKeywords.commonMethods.verifySelectedAccount'(switchToAccount2)

'takes user from home screen to inventory listing screen'
CustomKeywords.'iosCommonKeywords.commonMethods.takeUserFromHomeToInventoryListingScreen'()

'changes the user account and takes account no as the input'
CustomKeywords.'iosCommonKeywords.commonMethods.changeAccount'(switchToAccount1)

'verifies whether the selected user account is same as the account required'
CustomKeywords.'iosCommonKeywords.commonMethods.verifySelectedAccount'(switchToAccount1)