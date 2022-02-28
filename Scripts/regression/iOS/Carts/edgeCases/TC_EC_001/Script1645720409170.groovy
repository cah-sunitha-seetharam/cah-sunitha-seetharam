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

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'login function called which takes user to the accounts selection screen'
CustomKeywords.'iosLogin.loginScreen.login'(GlobalVariable.Username, GlobalVariable.Password)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'------------------------enables beta feature CSOS---------------------------'

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'clicks on more options, takes to beat features and enables it'
CustomKeywords.'iosCommonKeywords.commonMethods.enableBetaFeatures'()

'---------------------------nonC2_UploadOrder/PlaceOrder---------------------------------'

'takes user to the orders tab'
CustomKeywords.'iosDashboard.dashboardScreen.clickOnHomeTab'()

'scans multiple different products (eg 50 or 80), adds it to the order'
CustomKeywords.'iosOrders.orderDetailsScreen.performScanFlowDifferentProducts'(productType1, numberOfProducts)

'takes user to the orders tab'
CustomKeywords.'iosDashboard.dashboardScreen.clickOnOrders'()

'this function returns the order name of the order which is at the top of the order list'
String orderName1 = CustomKeywords.'iosOrders.cartScreen.returnTopMostOrderName'()

'opens order details and takes order name as the argument'
CustomKeywords.'iosOrders.cartScreen.openAnOrderDetail'(orderName1)

'uploads the order by clicking on upload order button'
CustomKeywords.'iosOrders.orderDetailsScreen.uploadOrder'()

'verifies the pop up screen which appears after user clicks on upload order'
CustomKeywords.'iosOrders.orderDetailsScreen.verifyUploadOrderPopUp'()

'clicks on continue ordering to take user back to the search results to keep browsing'
CustomKeywords.'iosOrders.orderDetailsScreen.clickOnContinueOrderingOnDesktop'()

'takes user back to cart screen'
CustomKeywords.'iosOrders.orderDetailsScreen.clickOnBackToCart'()

'verifies that the order should not be visible on the screen and takes purchase order name as the argument'
CustomKeywords.'iosOrders.cartScreen.verifyOrderNotVisibleOnTheCartScreen'(orderName1)

'takes user to the orders tab'
CustomKeywords.'iosDashboard.dashboardScreen.clickOnHomeTab'()

'scans multiple different products (eg 50 or 80), adds it to the order'
CustomKeywords.'iosOrders.orderDetailsScreen.performScanFlowDifferentProducts'(productType1, count)

'takes user to the orders tab'
CustomKeywords.'iosDashboard.dashboardScreen.clickOnOrders'()

'this function returns the order name of the order which is at the top of the order list'
String orderName2 = CustomKeywords.'iosOrders.cartScreen.returnTopMostOrderName'()

'opens order details and takes order name as the argument'
CustomKeywords.'iosOrders.cartScreen.openAnOrderDetail'(orderName2)

'places the order'
CustomKeywords.'iosOrders.orderDetailsScreen.clickOnPlaceOrder'()

'confirms place order by clicking on place my order button'
CustomKeywords.'iosOrders.orderDetailsScreen.confirmPlaceOrder'()

'takes user back to cart'
CustomKeywords.'iosOrders.orderDetailsScreen.clickOnBackToCart'()

'verifies that the order should not be visible on the screen and takes purchase order name as the argument'
CustomKeywords.'iosOrders.cartScreen.verifyOrderNotVisibleOnTheCartScreen'(orderName2)

'---------------------------C2_UploadOrder/PlaceOrder---------------------------------'

'takes user to the orders tab'
CustomKeywords.'iosDashboard.dashboardScreen.clickOnHomeTab'()

'scans multiple different products (eg 50 or 80), adds it to the order'
CustomKeywords.'iosOrders.orderDetailsScreen.performScanFlowDifferentProducts'(productType2, count)

'takes user to the orders tab'
CustomKeywords.'iosDashboard.dashboardScreen.clickOnOrders'()

'opens the c2 orders tab'
CustomKeywords.'iosOrders.cartScreen.clickOnC2Orders'()

'opens the c2 order details'
 CustomKeywords.'iosOrders.cartScreen.openC2OrderDetails'()

'uploads the order by clicking on upload order button'
CustomKeywords.'iosOrders.orderDetailsScreen.uploadOrder'()

'verifies the pop up screen which appears after user clicks on upload order'
CustomKeywords.'iosOrders.orderDetailsScreen.verifyUploadOrderPopUp'()

'clicks on continue ordering to take user back to the search results to keep browsing'
CustomKeywords.'iosOrders.orderDetailsScreen.clickOnContinueOrderingOnDesktop'()

'takes user back to cart screen'
CustomKeywords.'iosOrders.orderDetailsScreen.clickOnBackToCart'()

'verifies that the order should not be visible on the screen and takes purchase order name as the argument'
CustomKeywords.'iosOrders.cartScreen.verifyLinesCount'(lineCount)

'takes user to the orders tab'
CustomKeywords.'iosDashboard.dashboardScreen.clickOnHomeTab'()

'scans multiple different products (eg 50 or 80), adds it to the order'
CustomKeywords.'iosOrders.orderDetailsScreen.performScanFlowDifferentProducts'(productType2, count)

'takes user to the orders tab'
CustomKeywords.'iosDashboard.dashboardScreen.clickOnOrders'()

'opens the c2 orders tab'
CustomKeywords.'iosOrders.cartScreen.clickOnC2Orders'()

'opens c2 order details'
CustomKeywords.'iosOrders.cartScreen.openC2OrderDetails'()

'this function returns the poName of the order which is at the top of the C2 order list'
String poNumber = CustomKeywords.'iosOrders.orderDetailsScreen.returnOrderNameFromOrderDetailScreen'()

'clicks on place order'
CustomKeywords.'iosOrders.orderDetailsScreen.placeOrder'()

'clicks on c2 order availability and waits for the response while verifying the availability details for the c2 product\n'
CustomKeywords.'iosOrders.orderDetailsScreen.checkC2OrderAvailability'()

'takes user back to cart'
CustomKeywords.'iosOrders.orderDetailsScreen.clickOnReviewAndSignButton'()

'verifies order status after signature is successfully processed'
CustomKeywords.'iosOrders.historyScreen.verifyPoNumberInOrderHistoryList'(poNumber)



