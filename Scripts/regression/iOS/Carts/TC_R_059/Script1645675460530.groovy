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

'login function called which takes user to the accounts selection screen'
CustomKeywords.'iosLogin.loginScreen.login'(GlobalVariable.Username, GlobalVariable.Password)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'selects the user account from the accounts list'
CustomKeywords.'iosAccountSelection.selectAnAccount.selectTheUserAccount'(GlobalVariable.Account)

'clicks on more options, takes to beat features and enables it'
CustomKeywords.'iosCommonKeywords.commonMethods.enableBetaFeatures'()

'opens home page'
CustomKeywords.'iosDashboard.dashboardScreen.clickOnHomeTab'()
*/

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'reading the module test data file'
def requestObject = CustomKeywords.'common.commonMethods.readFileTypeJSON'('ordersData.json')

'reading the product name of product to be added (nonc2 product)'
String productSearch = requestObject[GlobalVariable.Environment].TC_R_059.productSearchByName

'searches for a product by setting product name'
CustomKeywords.'iosOrders.orderDetailsScreen.searchProductInOrderDetailPage'(productSearch)

'opens product tile'
CustomKeywords.'iosOrders.orderDetailsScreen.clickOnProductTile'()

'opens more details of product details'
CustomKeywords.'iosOrders.orderDetailsScreen.clickOnMoreDetails'()

'opens alternates page'
CustomKeywords.'iosOrders.orderDetailsScreen.tapOnAlternatesInProductDetailsPage'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'verifies filterByOptions'
CustomKeywords.'iosOrders.orderDetailsScreen.verifyFilterByOptions'()

'this function adds the quantity in alternates page'
CustomKeywords.'iosOrders.orderDetailsScreen.addQuantityInAlternatesPage'(quantity)

'taps on alternate to order in alternates page and opens confirmation pop up'
CustomKeywords.'iosOrders.orderDetailsScreen.tapOnAddAlternateToOrderInAlternatesPage'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'verifies confirmation pop up in alternates page'
CustomKeywords.'iosOrders.orderDetailsScreen.verifyConfirmationPopUpInALternatesPage'()

'takes user back to the search product results to continue browsing'
CustomKeywords.'iosOrders.orderDetailsScreen.tapOnContinueBrowsing'()

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'verifies dashboard screen'
CustomKeywords.'iosDashboard.dashboardScreen.verifyDashboardScreen'()

'opens cart page'
CustomKeywords.'iosDashboard.dashboardScreen.clickOnOrders'()

'this function returns the order name of the order which is at the top of the order list'
String orderName = CustomKeywords.'iosOrders.cartScreen.returnTopMostOrderName'()

'opens order details and takes order name as the argument'
CustomKeywords.'iosOrders.cartScreen.openAnOrderDetail'(orderName)

'places the order'
CustomKeywords.'iosOrders.orderDetailsScreen.clickOnPlaceOrder'()

'verifies place order confirmation pop up'
CustomKeywords.'iosOrders.orderDetailsScreen.verifyPlaceOrderPopUp'()

'confirms place order by clicking on place my order button'
CustomKeywords.'iosOrders.orderDetailsScreen.confirmPlaceOrder'()

'takes user back to cart'
CustomKeywords.'iosOrders.orderDetailsScreen.clickOnBackToCart'()

'verifies that the order should not be visible on the screen and takes purchase order name as the argument'
CustomKeywords.'iosOrders.cartScreen.verifyOrderNotVisibleOnTheCartScreen'(orderName)




