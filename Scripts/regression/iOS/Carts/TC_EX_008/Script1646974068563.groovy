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

def requestObject
String productSearch

/*'starts the application'
CustomKeywords.'iosCommonKeywords.commonMethods.installingAndlaunchingTheApplication'()

'logins with username password and then opens account selection page'
CustomKeywords.'iosLogin.loginScreen.login'(GlobalVariable.Username, GlobalVariable.Password)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'selects the user account from the accounts list'
CustomKeywords.'iosAccountSelection.selectAnAccount.selectTheUserAccount'(GlobalVariable.Account)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()*/

'opens the cart page'
CustomKeywords.'iosDashboard.dashboardScreen.clickOnOrders'()

'takes user to the new order screen'
CustomKeywords.'iosOrders.ordersCommonScreen.clickOnNewOrder'()


'take user to new order screen to enter order details'
CustomKeywords.'iosOrders.newOrderScreen.enterPurchaseOrderDetails'(poName, poMemo)

'clicks on create order to create an order'
CustomKeywords.'iosOrders.newOrderScreen.createOrder'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'clicks on scan icon and also verifies that the default scan toggle value is at ordering'
CustomKeywords.'iosOrders.orderDetailsScreen.clickOnScanIcon'()

'reading the module test data file'
requestObjects = CustomKeywords.'common.commonMethods.readFileTypeJSON'('ordersData.json')

'reading the product name of product to be added'
productSearch = requestObjects[GlobalVariable.Environment].TC_EX_008.productSearchByNDC

'searches for a product by setting product name'
CustomKeywords.'iosOrders.orderDetailsScreen.searchProductInOrderDetailPage'(productSearch)

'opens product tile'
CustomKeywords.'iosOrders.orderDetailsScreen.clickOnProductTile'()

'opens more details of product details'
CustomKeywords.'iosOrders.orderDetailsScreen.clickOnMoreDetails'()

'adds quantity of the product'
CustomKeywords.'iosOrders.orderDetailsScreen.addQuantityInProductDetailsPage'(quantity)

'adds product in product details page'
CustomKeywords.'iosOrders.orderDetailsScreen.tapOnAddToOrderInProductDetailsPage'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'click on continue ordering button'
CustomKeywords.'iosOrders.orderDetailsScreen.clickOnContinueOrdering'()

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'takes expectedAnnotationCount count as the argument and verifies the same'
CustomKeywords.'iosOrders.cartScreen.verifyLinesCount'(totalLineCount)

'this function verifies if order created is visible on card screen'
CustomKeywords.'iosOrders.cartScreen.verifyOrderIsVisibleOnTheCartScreen'(poName)

