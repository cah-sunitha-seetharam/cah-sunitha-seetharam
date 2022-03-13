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

/*'starts the application'
CustomKeywords.'iosCommonKeywords.commonMethods.installingAndlaunchingTheApplication'()

'logins with username password and then opens account selection page'
CustomKeywords.'iosLogin.loginScreen.login'(GlobalVariable.Username, GlobalVariable.Password)

'selects the user account from the accounts list'
CustomKeywords.'iosAccountSelection.selectAnAccount.selectTheUserAccount'(GlobalVariable.Account)*/

'------------------------enables beta feature CSOS---------------------------'

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'clicks on more options tab is dashboard'
CustomKeywords.'iosDashboard.dashboardScreen.clickOnMoreOptionsTab'()

'clicks on more options, takes to beat features and enables it'
CustomKeywords.'iosCommonKeywords.commonMethods.enableBetaFeatures'()


'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'opens the cart page'
CustomKeywords.'iosDashboard.dashboardScreen.clickOnOrders'()

'takes user to the new order screen'
CustomKeywords.'iosOrders.ordersCommonScreen.clickOnNewOrder'()

'take user to new order screen to enter order details'
CustomKeywords.'iosOrders.newOrderScreen.enterPurchaseOrderDetails'(poName1, poMemo1)

'clicks on create order to create an order'
CustomKeywords.'iosOrders.newOrderScreen.createOrder'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'reading the module test data file'
requestObject = CustomKeywords.'common.commonMethods.readFileTypeJSON'('csosData.json')

'reading the product name of product to be added (C2 product)'
String productSearch = requestObject[GlobalVariable.Environment].TC_EX_003.productSearchByNDC

'clicks on scan icon and also verifies that the default scan toggle value is at ordering'
CustomKeywords.'iosOrders.orderDetailsScreen.clickOnScanIcon'()

'adds product to the order by taking product and quanity as the argument'
CustomKeywords.'iosOrders.orderDetailsScreen.addProductToOrder'(productSearch, quantity)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'---------------------------FirstNonC2Order---------------------------------------'
'opens the Nonc2 orders tab'
CustomKeywords.'iosOrders.cartScreen.clickOnNonC2Orders'()

'takes user to the new order screen'
CustomKeywords.'iosOrders.ordersCommonScreen.clickOnNewOrder'()

'take user to new order screen to enter order details'
CustomKeywords.'iosOrders.newOrderScreen.enterPurchaseOrderDetails'(poName2, poMemo2)

'clicks on create order to create an order'
CustomKeywords.'iosOrders.newOrderScreen.createOrder'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'reading the module test data file'
def requestObjects = CustomKeywords.'common.commonMethods.readFileTypeJSON'('csosData.json')

'reading the product name of product to be added (C2 product)'
String productSearch1 = requestObjects[GlobalVariable.Environment].TC_EX_003.productSearchByNDC1

'clicks on scan icon and also verifies that the default scan toggle value is at ordering'
CustomKeywords.'iosOrders.orderDetailsScreen.clickOnScanIcon'()

'adds product to the order by taking product and quanity as the argument'
CustomKeywords.'iosOrders.orderDetailsScreen.addProductToOrder'(productSearch1, quantity)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'---------------------------SecondNonC2Order---------------------------------------'
'opens the Nonc2 orders tab'
CustomKeywords.'iosOrders.cartScreen.clickOnNonC2Orders'()

'takes user to the new order screen'
CustomKeywords.'iosOrders.ordersCommonScreen.clickOnNewOrder'()

'take user to new order screen to enter order details'
CustomKeywords.'iosOrders.newOrderScreen.enterPurchaseOrderDetails'(poName3, poMemo3)

'clicks on create order to create an order'
CustomKeywords.'iosOrders.newOrderScreen.createOrder'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'reading the product name of product to be added (C2 product)'
String productSearch2 = requestObjects[GlobalVariable.Environment].TC_EX_003.productSearchByNDC2

'clicks on scan icon and also verifies that the default scan toggle value is at ordering'
CustomKeywords.'iosOrders.orderDetailsScreen.clickOnScanIcon'()

'adds product to the order by taking product and quanity as the argument'
CustomKeywords.'iosOrders.orderDetailsScreen.addProductToOrder'(productSearch2, quantity)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'--------------------------------PlaceAllOder----------------------------------------'
'opens the c2 orders tab'
CustomKeywords.'iosOrders.cartScreen.clickOnNonC2Orders'()

'clicks on place order'
CustomKeywords.'iosOrders.orderDetailsScreen.clickOnPlaceAllOrder'()

'Confirm on Place all My order'
CustomKeywords.'iosOrders.orderDetailsScreen.confirmPlaceOrder'()

'takes user back to cart screen and verifies user is on the cart screen or not'
CustomKeywords.'iosOrders.orderDetailsScreen.clickOnBackToCart'()

'opens the c2 orders tab'
CustomKeywords.'iosOrders.cartScreen.clickOnC2Orders'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'opens the c2 order details'
CustomKeywords.'iosOrders.cartScreen.openC2OrderDetails'()

'this function verifies that the product is visible on the order details screen'
CustomKeywords.'iosOrders.orderDetailsScreen.verifyProductIsVisibleOnTheOrderDetailsScreen'(productSearch)


