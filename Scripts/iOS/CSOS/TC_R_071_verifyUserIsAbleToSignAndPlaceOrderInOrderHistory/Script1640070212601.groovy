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

'logins with username password and then opens account selection page'
CustomKeywords.'iosLogin.loginScreen.login'(GlobalVariable.Username, GlobalVariable.Password)

'after login, verifies page caption and selects account'
CustomKeywords.'iosAccountSelection.selectAnAccount.selectTheUserAccount'(accountNo)

'clicks on more options tab is dashboard'
CustomKeywords.'iosDashboard.dashboardScreen.clickOnMoreOptionsTab'()

'enables csos beta feature in the account selected'
CustomKeywords.'iosMoreOptions.moreOptionsScreen.enableBetaFeatureCSOS'()

'opens the cart page'
CustomKeywords.'iosDashboard.dashboardScreen.clickOnOrders'()

'takes user to the new order screen'
CustomKeywords.'iosOrders.ordersCommonScreen.clickOnNewOrder'()

'verifies new order screen'
CustomKeywords.'iosOrders.newOrderScreen.verifyNewOrderScreenDetails'()

'clicks on create order to create an order'
CustomKeywords.'iosOrders.newOrderScreen.createOrder'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'reading the module test data file'
def requestObject = CustomKeywords.'common.commonMethods.readFileTypeJSON'('csosData.json')

'reading the product name of product to be added (C2 product)'
String productSearch = requestObject[GlobalVariable.Environment].TC_R_071.productSearchCin

'adds product to the order by taking product and quanity as the argument'
CustomKeywords.'iosOrders.orderDetailsScreen.addProductToOrder'(productSearch, quantity)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'opens the c2 orders tab'
CustomKeywords.'iosOrders.cartScreen.clickOnC2Orders'()

'opens c2 order details'
CustomKeywords.'iosOrders.cartScreen.openC2OrderDetails'()

'this function returns the poName of the order which is at the top of the C2 order list'
String poNumber = CustomKeywords.'iosOrders.orderDetailsScreen.returnOrderNameFromOrderDetailScreen'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'clicks on place order'
CustomKeywords.'iosOrders.orderDetailsScreen.placeOrder'()

WebUI.delay(15)

'clicks on c2 order availability and waits for the response while verifying the availability details for the c2 product\n'
CustomKeywords.'iosOrders.orderDetailsScreen.checkC2OrderAvailability'()

'takes user back to cart'
CustomKeywords.'iosOrders.orderDetailsScreen.clickOnReviewAndSignButton'()

'gets the initials historyCount before review and sign of c2 order and stores value in variable initialCount'
int initialCount = Mobile.getText(findTestObject('iOS/Orders/History Screen/orderHistoryCount_Text'), 0).toInteger()

'reviews and signs the c2 order by taking signingPassword as the argument'
CustomKeywords.'iosOrders.historyScreen.completeReviewSignAndPlaceAnOrderFlow'(poNumber,signingPassword)

'waits for 30 secs for the order status to be updated'
WebUI.delay(30)

//'performs a vertical swipe to refresh the screen - does not work'
//CustomKeywords.'iosCommonKeywords.commonMethods.verticalSwipeForRefresh'()

'clicks on history to refresh history tab - work around if vertical swipe does not work'
CustomKeywords.'iosOrders.historyScreen.clickOnHistoryTab'()

'gets the final historyCount after review and sign of c2 order which should be one less than the initial count and stores value in the variable finalCount'
int finalCount = Mobile.getText(findTestObject('iOS/Orders/History Screen/orderHistoryCount_Text'), 0).toInteger()

'asserts that the final historyCount should be one less than the initial historyCount after signing the password for c2order'
assert finalCount == (initialCount - 1)

'verifies order status after signature is successfully processed'
CustomKeywords.'iosOrders.historyScreen.verifyOrderStatusInOrderHistoryList'(poNumber)

