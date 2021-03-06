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
CustomKeywords.'iosCommonKeywords.commonMethods.installingAndlaunchingTheApplication'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'login function called which takes user to the accounts selection screen'
CustomKeywords.'iosLogin.loginScreen.login'(GlobalVariable.Username, GlobalVariable.Password)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'------------------------enables beta feature CSOS------------------'

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'clicks on more options, takes to beat features and enables it'
CustomKeywords.'iosCommonKeywords.commonMethods.enableBetaFeatures'()*/

'-----------------nonC2(uploadAllOrders/placeAllOrders)--------------'

'takes user to the orders tab'
CustomKeywords.'iosDashboard.dashboardScreen.clickOnOrders'()

'creates multiple orders products (eg 20) and then performs scan flow on different product'
CustomKeywords.'iosOrders.orderDetailsScreen.createMultipleOrder'(productType1,numberOfOrders,numberOfProducts)

'uploads the order by clicking on upload order button'
CustomKeywords.'iosOrders.cartScreen.uploadAllOrders'()

'uploads the order by clicking on upload order button'
CustomKeywords.'iosOrders.cartScreen.verifyUploadAllOrdersPopUp'()

'clicks on continue ordering to take user back to the search results to keep browsing'
CustomKeywords.'iosOrders.cartScreen.continueOrdersOnTheDesktop'()

'takes user back to cart'
CustomKeywords.'iosOrders.cartScreen.clickOnBackToCart'()

'verifies that the order should not be visible on the screen and takes purchase order name as the argument'
CustomKeywords.'iosOrders.cartScreen.verifyLinesCount'(lineCount)

'creates multiple orders products (eg 20) and then performs scan flow on different product'
CustomKeywords.'iosOrders.orderDetailsScreen.createMultipleOrder'(productType1,numberOfOrders,numberOfProducts)

'places all the orders by clicking on place all orders button'
CustomKeywords.'iosOrders.cartScreen.clickOnPlaceAllOrders'()

'uploads the order by clicking on upload order button'
CustomKeywords.'iosOrders.cartScreen.verifyPlaceAllOrdersPopUp'()

'confirm placing all orders by clicking on confirm place all orders button'
CustomKeywords.'iosOrders.cartScreen.confirmPlacingAllOrders'()

'takes user back to cart'
CustomKeywords.'iosOrders.cartScreen.clickOnBackToCart'()

'verifies that the order should not be visible on the screen and takes purchase order name as the argument'
CustomKeywords.'iosOrders.cartScreen.verifyLinesCount'(lineCount)

'-----------------C2(uploadOrder/placeOrder)------------------'

'creates multiple orders products (eg 20) and then performs scan flow on different product'
CustomKeywords.'iosOrders.orderDetailsScreen.createMultipleOrder'(productType2,numberOfOrders,numberOfProducts)

// need to implement looping concept for upload and place order for C2 
