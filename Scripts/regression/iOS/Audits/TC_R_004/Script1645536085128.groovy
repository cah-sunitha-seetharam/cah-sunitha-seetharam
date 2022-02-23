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

/*'starts the application'
CustomKeywords.'iosCommonKeywords.commonMethods.installingAndlaunchingTheApplication'()*/

'login function called which takes user to the accounts selection screen'
CustomKeywords.'iosLogin.loginScreen.login'(username, password)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'takes user to the orders tab'
CustomKeywords.'iosDashboard.dashboardScreen.clickOnOrders'()

'tap on account icon'
CustomKeywords.'iosAccountSelection.selectAnAccount.tapOnAccountIcon'()

'selects the user account from the accounts list'
CustomKeywords.'iosAccountSelection.selectAnAccount.selectAnotherAccount'(accountNo_CIM_1)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'takes user to the orders tab'
CustomKeywords.'iosDashboard.dashboardScreen.clickOnOrders'()

'clicks on audits tab to navigate to audits screen'
CustomKeywords.'iosDashboard.dashboardScreen.clickOnAuditsTab'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'verifies audits screen'
CustomKeywords.'iosAudits.auditsScreen.verifyAuditsLandingScreen'()

'taps on quantity box'
CustomKeywords.'iosAudits.auditsScreen.clickOnQuantityBox'()

'long press on the selected Count box of the product'
CustomKeywords.'iosAudits.auditsScreen.longPressOnQuantityBox'()

'tap on increment button to increase the count'
CustomKeywords.'iosAudits.auditsScreen.increaseCount'()

'tap on decrement button to decrease the count'
CustomKeywords.'iosAudits.auditsScreen.decreaseCount'()

'tap on confirm count button and returns the count which has been added for the product'
actualQuantityAdded = CustomKeywords.'iosAudits.auditsScreen.confirmAuditCount'()

'verify the added count in the Audit list screen'
CustomKeywords.'iosAudits.auditsScreen.verifyQuantity'(actualQuantityAdded)

'------------changing account selection and performing same actions in audits-----------------'

'change account using account selection icon'
CustomKeywords.'iosAudits.auditsScreen.change_Account'(accountNo_CIM_2)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'verifies audits screen'
CustomKeywords.'iosAudits.auditsScreen.verifyAuditsLandingScreen'()

'taps on quantity box'
CustomKeywords.'iosAudits.auditsScreen.clickOnQuantityBox'()

'long press on the selected Count box of the product'
CustomKeywords.'iosAudits.auditsScreen.longPressOnQuantityBox'()

'tap on increment button to increase the count'
CustomKeywords.'iosAudits.auditsScreen.increaseCount'()

'tap on decrement button to decrease the count'
CustomKeywords.'iosAudits.auditsScreen.decreaseCount'()

'tap on confirm count button and returns the count which has been added for the product'
actualQuantityAdded = CustomKeywords.'iosAudits.auditsScreen.confirmAuditCount'()

'verify the added count in the Audit list screen'
CustomKeywords.'iosAudits.auditsScreen.verifyQuantity'(actualQuantityAdded)



