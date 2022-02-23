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

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'selects the user account from the accounts list'
CustomKeywords.'androidAccountSelection.selectAnAccount.selectTheUserAccount'(GlobalVariable.Account)
*/
'-------------enables beta feature CSOS-------------'

/*CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnMoreOptions'()

CustomKeywords.'androidMoreOptions.moreOptionsScreen.enableBetaFeatureCSOS'()
*/
'---------------------------------------------------'

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'opens cart page'
CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnOrders'()

'takes user to the new order screen'
CustomKeywords.'androidOrders.ordersCommonScreen.clickOnNewOrder'()

'take user to new order screen to enter order details'
CustomKeywords.'androidOrders.newOrderScreen.enterPurchaseOrderDetails'(poName, poMemo)

'clicks on create order to create an order'
CustomKeywords.'androidOrders.newOrderScreen.createOrder'()

'verifies order screen details without any added product'
CustomKeywords.'androidOrders.orderDetailsScreen.verifyOrderScreenDetailsWithoutAnyAddedProduct'()

'-----------------search non c2 product------------------'

'reading the module test data file'
def requestObject = CustomKeywords.'common.commonMethods.readFileTypeJSON'('ordersData.json')

'reading the product name of product to be added (nonC2 product)'
String productSearch1 = requestObject[GlobalVariable.Environment].TC_OE_010.productSearchByName

'searches for a product by setting product name and quantity as the input'
CustomKeywords.'androidOrders.orderDetailsScreen.addProductToOrder'(productSearch1, quantity1)

'takes user back to the search product results to continue ordering'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnContinueOrdering'()

'takes the application one screen back'
Mobile.pressBack()

'---------------search c2 product----------------'

'reading the product name of product to be added (C2 product)'
String productSearch2 = requestObject[GlobalVariable.Environment].TC_OE_010.productSearchByNDC

'searches for a product by setting product name and quantity as the input'
CustomKeywords.'androidOrders.orderDetailsScreen.addProductToOrder'(productSearch2, quantity2)

'takes user back to the search product results to continue ordering'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnContinueOrdering'()

'takes the application one screen back'
Mobile.pressBack()

'takes the application one screen back'
Mobile.pressBack()

'deletes the order from the cart screen based on the purchase order name'
CustomKeywords.'androidOrders.cartScreen.deleteOrder'(poName)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'takes user to the dashboard screen'
CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnHomeTab'()

'verifies user is at the dashboard screen'
CustomKeywords.'androidDashboard.dashboardDetailsScreen.verifyDashboardPage'()

'---------search nonc2 product-----------'

'searches for a product by setting product name and quantity as the input'
CustomKeywords.'androidOrders.orderDetailsScreen.addProductToOrder'(productSearch1, quantity1)

'takes user to the order details'
CustomKeywords.'androidOrders.orderDetailsScreen.tapOnGoToOrder'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'takes the application one screen back'
Mobile.pressBack()

'opens cart page'
CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnOrders'()

'this function returns the order name of the order which is at the top of the order list'
String orderName = CustomKeywords.'androidOrders.cartScreen.returnTopMostOrderName'()

'this function verifies the pattern required for the order which was created without giving any purchase order name'
CustomKeywords.'androidOrders.cartScreen.verifyOrderNamePattern'(orderName)

'searches for a product by setting product name and quantity as the input'
CustomKeywords.'androidCommonKeywords.commonMethods.searchProduct'(productSearch2)

'returns the order name in search page'
String productName = CustomKeywords.'androidOrders.orderDetailsScreen.returnProductNameAfterSearch'()

'adds the quantity for the product to be searched'
CustomKeywords.'androidOrders.orderDetailsScreen.addQuantityforTheSearchedProduct'(quantity3)

'adds product in product details page'
CustomKeywords.'androidOrders.orderDetailsScreen.tapOnAddToOrderInProductDetailsPage'()

'takes user to the order details'
CustomKeywords.'androidOrders.orderDetailsScreen.tapOnGoToOrder'()

'this function verifies that the product is visible on the order details screen'
CustomKeywords.'androidOrders.orderDetailsScreen.verifyProductNameIsVisibleUnderOrderDetails'(productName)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'takes the application one screen back'
Mobile.pressBack()

'deletes the order from the cart screen based on the purchase order name'
CustomKeywords.'androidOrders.cartScreen.deleteOrder'(orderName)

