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
CustomKeywords.'androidCommonKeywords.commonMethods.installingAndlaunchingTheApplication'()

'login function called which takes user to the accounts selection screen'
CustomKeywords.'androidLogin.loginScreen.login'(GlobalVariable.Username, GlobalVariable.Password)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'selects the user account from the accounts list'
CustomKeywords.'androidAccountSelection.selectAnAccount.selectTheUserAccount'(GlobalVariable.Account)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'Tap on Audits icon in the bottom navigation menu'
CustomKeywords.'androidDashboard.dashboardDetailsScreen.tapOnAudits'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'tap on the count box of the Product and verify its background color'
CustomKeywords.'androidAudits.auditsListingScreen.tapOnQuantityBox'() // Check the device before executing this method

'tong press on the selected Count box of the product'
CustomKeywords.'androidAudits.auditsListingScreen.longPressOnQuantityBox'()

'tap on increment button to increase the count'
CustomKeywords.'androidAudits.auditsListingScreen.increaseCount'()

'tap on decrement button to decrease the count'
CustomKeywords.'androidAudits.auditsListingScreen.decreaseCount'()

'tap on confirm count button and returns the count which has been added for the product'
actualQuantityAdded = CustomKeywords.'androidAudits.auditsListingScreen.confirmAuditCount'()

'verify the added count in the Audit list screen'
CustomKeywords.'androidAudits.auditsListingScreen.verifyQuantity'(actualQuantityAdded)

// Change the account and verify the decimal value count

'tap on the Account Icon in the top left of the Page and Tap on Change'
CustomKeywords.'androidAudits.auditsListingScreen.changeAccount'()

'tap on any one of those account where the Existing count of products in Audit group in the form of  Decimal Value'
CustomKeywords.'androidAccountSelection.selectAnAccount.selectTheUserAccount'(second_account)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'tap on the count box of the Product and verify its background color'
CustomKeywords.'androidAudits.auditsListingScreen.tapOnQuantityBox'() // Check the device before executing this method

'long press on the selected Count box of the product'
CustomKeywords.'androidAudits.auditsListingScreen.longPressOnQuantityBox'()

'tap on increment button to increase the count'
CustomKeywords.'androidAudits.auditsListingScreen.increaseCount'()

'tap on decrement button to decrease the count'
CustomKeywords.'androidAudits.auditsListingScreen.decreaseCount'()

'tap on confirm count button and returns the count which has been added for the product'
actualQuantityAdded = CustomKeywords.'androidAudits.auditsListingScreen.confirmAuditCount'()

'verify the added count in the Audit list screen'
CustomKeywords.'androidAudits.auditsListingScreen.verifyQuantity'(actualQuantityAdded)

