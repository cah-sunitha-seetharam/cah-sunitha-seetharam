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

'waits for 30(s) before refreshing the page to get the updated hstoryCount '
WebUI.delay(30)

'takes user to the orders tab'
CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnOrders'()

'take user to new order screen to enter order details'
CustomKeywords.'androidOrders.ordersCommonScreen.clickOnNewOrder'()

'clicks on create order to create an order'
CustomKeywords.'androidOrders.newOrderScreen.createOrder'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'reading the module test data file'
def requestObject = CustomKeywords.'common.commonMethods.readFileTypeJSON'('inventoryTestData.json')

'reading the product name of product to be added (nonC2 product)'
String productSearch = requestObject[GlobalVariable.Environment].TC_JT_CSOS_001.productSearchByName

'adds product to the order by taking product and quanity as the argument'
CustomKeywords.'androidOrders.orderDetailsScreen.addProductToOrder'(productSearch, quantity)

'clicks on continue ordering to take user back to the search results to keep browsing'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnContinueOrdering'()

'takes the application one screen back'
Mobile.pressBack()

'takes the application one screen back'
Mobile.pressBack()

'opens order details by taking argument as the account number which was used to create the order'
CustomKeywords.'androidOrders.cartScreen.openAnOrderDetails'(GlobalVariable.Account)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'reading the cin of product to be added (c2 product)'
productSearch = requestObject[GlobalVariable.Environment].TC_JT_CSOS_001.productSearchCin

'adds product to the order by taking product and quanity as the argument'
CustomKeywords.'androidOrders.orderDetailsScreen.addProductToOrder'(productSearch, quantity)

'creates a new c2 order by taking poName and poMemo as the arguments'
CustomKeywords.'androidOrders.orderDetailsScreen.createNewC2Order'(poName, poMemo)

'takes the application one screen back'
Mobile.pressBack()

'takes the application one screen back'
Mobile.pressBack()

'opens the c2 orders tab'
CustomKeywords.'androidOrders.cartScreen.clickOnC2OrdersTab'()

'opens order details by taking argument as the account number which was used to create the order'
CustomKeywords.'androidOrders.cartScreen.openAnOrderDetails'(GlobalVariable.Account)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'clicks on place order'
CustomKeywords.'androidOrders.orderDetailsScreen.placeOrder'()

'clicks on c2 order availability and waits for the response while verifying the availability details for the c2 product'
CustomKeywords.'androidOrders.orderDetailsScreen.checkC2ProductAvailability'()

'takes user back to cart'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnBackToCart'()

'takes user to history screen'
CustomKeywords.'androidOrders.ordersCommonScreen.clickOnHistoryTab'()

'gets the initials historyCount before review and sign of c2 order and stores value in variable initialCount'
initialCount = Mobile.getText(findTestObject('Android/orders/ordersCommonScreen/historyCount_TextView'), 0)

'reviews and signs the c2 order by taking signingPassword as the argument'
CustomKeywords.'androidOrders.historyScreen.clickOnC2OrderForReviewAndSign'(signingPassword)

'waits for 30(s) before refreshing the page to get the updated hstoryCount '
WebUI.delay(30)

'performs a vertical swipe to refresh the screen'
CustomKeywords.'android_common_keywords.commonMethods.verticalSwipeForRefresh'()

'gets the final historyCount after review and sign of c2 order which should be one less than the initial count and stores value in the variable finalCount'
finalCount = Mobile.getText(findTestObject('Android/orders/ordersCommonScreen/historyCount_TextView'), 0)

'asserts that the final historyCount should be one less than the initial historyCount after signing the password for c2order'
assert initialCount == (finalCount + 1)

