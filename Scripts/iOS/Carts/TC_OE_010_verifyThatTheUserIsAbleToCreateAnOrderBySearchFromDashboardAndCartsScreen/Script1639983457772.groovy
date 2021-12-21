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

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()
*/
'takes user to the orders tab'
CustomKeywords.'iosDashboard.dashboardScreen.clickOnOrders'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'take user to new order screen to enter order details'
CustomKeywords.'iosOrders.ordersCommonScreen.clickOnNewOrder'()

'take user to new order screen to enter order details'
CustomKeywords.'iosOrders.newOrderScreen.enterPurchaseOrderDetails'(poName, poMemo)

'clicks on create order to create an order'
CustomKeywords.'iosOrders.newOrderScreen.createOrder'()

'clicks on create order to create an order'
CustomKeywords.'iosOrders.orderDetailsScreen.verifyOrderDetailsScreenWithoutAnyAddedProduct'(poName)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'reading the module test data file'
def requestObject = CustomKeywords.'common.commonMethods.readFileTypeJSON'('ordersData.json')

'reading the product name of product to be added (nonC2 product)'
String productSearch = requestObject[GlobalVariable.Environment].TC_OE_010.productSearchByNDC

'clicks on scan icon and also verifies that the default scan toggle value is at ordering'
CustomKeywords.'iosOrders.orderDetailsScreen.addProductToOrder'(productSearch, quantity)

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'uploads the order by clicking on upload order button'
CustomKeywords.'iosOrders.cartScreen.deleteOrder'(poName)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'takes user to the dashboard screen'
CustomKeywords.'iosDashboard.dashboardScreen.clickOnHomeTab'()

'verifies user is at the dashboard screen'
CustomKeywords.'iosDashboard.dashboardScreen.verifyDashboardScreen'()

'adds the product from dash-board to inventory'
CustomKeywords.'iosDashboard.dashboardScreen.addingProductFromDashboardToCart'(productSearch, quantity)

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'takes user to the orders tab'
CustomKeywords.'iosDashboard.dashboardScreen.clickOnOrders'()

'this function returns the order name of the order which is at the top of the order list'
String orderName = CustomKeywords.'iosOrders.cartScreen.returnTopMostOrderName'()

'this function verifies the pattern required for the order which was created without giving any purchase order name'
CustomKeywords.'iosOrders.cartScreen.verifyOrderNamePattern'(orderName)

'opens order details and takes order name as the argument'
CustomKeywords.'iosOrders.cartScreen.openAnOrderDetail'(orderName)

'this function verifies that the product is visible on the order details screen'
CustomKeywords.'iosOrders.orderDetailsScreen.verifyProductIsVisibleOnTheOrderDetailsScreen'(productSearch)

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'uploads the order by clicking on upload order button'
CustomKeywords.'iosOrders.cartScreen.deleteOrder'(orderName)