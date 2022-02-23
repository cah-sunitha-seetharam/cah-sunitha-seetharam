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
CustomKeywords.'androidCommonKeywords.commonMethods.installingAndlaunchingTheApplication'()

'login function called which takes user to the accounts selection screen'
CustomKeywords.'androidLogin.loginScreen.login'(GlobalVariable.Username, GlobalVariable.Password)

'selects the user account from the accounts list'
CustomKeywords.'androidAccountSelection.selectAnAccount.selectTheUserAccount'(GlobalVariable.Account)*/

'clicks on more options tab is dashboard'
CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnMoreOptionsTab'()

'enables csos beta feature in the account selected'
CustomKeywords.'androidMoreOptions.moreOptionsScreen.enableBetaFeatureCSOS'()


'opens the cart page'
CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnOrders'()

'takes user to the new order screen'
CustomKeywords.'androidOrders.ordersCommonScreen.clickOnNewOrder'()

'verifies new order screen'
CustomKeywords.'androidOrders.newOrderScreen.verifyNewOrderScreenDetails'()

'clicks on create order to create an order'
CustomKeywords.'androidOrders.newOrderScreen.createOrder'()

'reading the module test data file'
def requestObject = CustomKeywords.'common.commonMethods.readFileTypeJSON'('csosData.json')

'reading the product name of product to be added (C2 product)'
String productSearch = requestObject[GlobalVariable.Environment].TC_R_071.productSearchCin

'adds product to the order by taking product and quanity as the argument'
CustomKeywords.'androidOrders.orderDetailsScreen.addProductToOrder'(productSearch, quantity)

'click on continue ordering button'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnContinueOrdering'()

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'opens the c2 orders tab'
CustomKeywords.'androidOrders.cartScreen.clickOnC2OrdersTab'()

'opens c2 order details'
CustomKeywords.'androidOrders.cartScreen.openC2OrderDetails'()

'this function returns the poName of the order which is at the top of the C2 order list'
String poNumber = CustomKeywords.'androidOrders.orderDetailsScreen.returnOrderNameFromOrderDetailScreen'()

'clicks on place order'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnPlaceOrder'()

'Confirm on place order'
CustomKeywords.'androidOrders.orderDetailsScreen.confirmPlaceOrder'()

'clicks on c2 order availability and waits for the response while verifying the availability details for the c2 product\n'
CustomKeywords.'androidOrders.orderDetailsScreen.checkC2ProductAvailability'()

'takes user back to cart'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnReviewAndSignButton'()

'gets the initials historyCount before review and sign of c2 order and stores value in variable initialCount'
int initialCount = CustomKeywords.'androidOrders.historyScreen.getOrderBadgeCount'()

'reviews and signs the c2 order by taking signingPassword as the argument'
CustomKeywords.'androidOrders.historyScreen.completeReviewSignAndPlaceAnOrderFlow'(poNumber,signingPassword)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'clicks on history to refresh history tab - work around if vertical swipe does not work'
CustomKeywords.'androidOrders.historyScreen.clickOnHistoryTab'()

'gets the final historyCount after review and sign of c2 order which should be one less than the initial count and stores value in the variable finalCount'
int finalCount = CustomKeywords.'androidOrders.historyScreen.getOrderBadgeCount'()

'asserts that the final historyCount should be one less than the initial historyCount after signing the password for c2order'
assert finalCount == (initialCount - 1)

'verifies order status after signature is successfully processed'
CustomKeywords.'androidOrders.historyScreen.verifyOrderStatusInOrderHistoryList'(poNumber)

