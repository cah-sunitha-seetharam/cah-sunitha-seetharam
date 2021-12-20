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
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

'starts the application'
CustomKeywords.'androidCommonKeywords.commonMethods.installingAndlaunchingTheApplication'()

'logins with username password and then opens account selection page'
CustomKeywords.'androidLogin.loginScreen.login'(GlobalVariable.Username, GlobalVariable.Password)

'after login, verifies page caption and selects account'
CustomKeywords.'androidAccountSelection.selectAnAccount.selectTheUserAccount'(GlobalVariable.Account)

'------------------------enables beta feature CSOS---------------------------'

CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnMoreOptions'()
CustomKeywords.'android_more_options.moreOptionsScreen.enableBetaFeatureCSOS'()

'----------------------------------------------------------------------------'

'opens cart page'
CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnOrders'()

'--------------------------c2 order--------------------------'

'takes totalLineCount count as the argument and verifies the same'
CustomKeywords.'androidOrders.cartScreen.verifyTotalLineCount'(totalLineCount1)

'takes expected cart value as the argument and verifies the same'
CustomKeywords.'androidOrders.cartScreen.verifyCartValue'(expectedCartValue)

'takes expected mobile orders count as the argument and verifies the same'
CustomKeywords.'androidOrders.cartScreen.verifyMobileOrdersCount'(expectedMobileOrdersCount1)

'takes user to the new order screen'
CustomKeywords.'androidOrders.ordersCommonScreen.clickOnNewOrder'()

'verifies new order screen'
CustomKeywords.'androidOrders.newOrderScreen.verifyNewOrderScreenAccount'()

'take user to new order screen to enter order details'
CustomKeywords.'androidOrders.newOrderScreen.enterPurchaseOrderDetails'(poName, poMemo)

'clicks on create order to create an order'
CustomKeywords.'androidOrders.newOrderScreen.createOrder'()

'verifies order details screen without any added product'
CustomKeywords.'androidOrders.orderDetailsScreen.verifyOrderScreenDetailsWithoutAnyAddedProduct'()

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'takes totalLineCount count as the argument and verifies the same'
CustomKeywords.'androidOrders.cartScreen.verifyTotalLineCount'(totalLineCount1)

'takes  expected cart value as the argument and verifies the same'
CustomKeywords.'androidOrders.cartScreen.verifyCartValue'(expectedCartValue)

'takes expected mobile orders as the argument and verifies the same'
CustomKeywords.'androidOrders.cartScreen.verifyMobileOrdersCount'(expectedMobileOrdersCount2)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'clicks on scan icon and also verifies that the default scan toggle value is at ordering'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnScanIcon'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'reading the module test data file'
def requestObject = CustomKeywords.'common.commonMethods.readFileTypeJSON'('ordersData.json')

'reading the product name of product to be added (C2 product)'
String productSearchCin= requestObject[GlobalVariable.Environment].TC_R_049.productSearchCin

'takes productSearch which can be productName/Cin/UPC/NDC as the input and adds it to the order by scanning the product'
CustomKeywords.'androidOrders.orderDetailsScreen.scanInputEvent'(productSearchCin)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'returns product cost of the added product which would be stored in a variable'
String productCost = CustomKeywords.'androidOrders.orderDetailsScreen.returnCostOfTheAddedProduct'()

'prints product cost'
KeywordUtil.logInfo(productCost)

'this function returns the total expected value of a product which would be added to the carts value and takes quantity and product cost as the arguments'
String  totalProductCost = CustomKeywords.'androidCommonKeywords.commonMethods.returnExpectedTotalValueForAddedProduct'(quantity, productCost)

'prints total product cost'
KeywordUtil.logInfo(totalProductCost)

'calculating expected cart value'
String expectedValue = totalProductCost

'verifies c2 label is visible or not'
CustomKeywords.'androidOrders.orderDetailsScreen.verifyC2Label'()

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'verifies that the order should be visible on the screen and takes purchase order name as the argument'
CustomKeywords.'androidOrders.cartScreen.verifyOrderIsVisibleOnTheCartScreen'(poName)

'this function verifies the lines count and takes expected lines count as an argument'
CustomKeywords.'androidOrders.cartScreen.verifyTotalLineCount'(totalLineCount2)

'this function verifies the cart value and takes expected cart value as an argument'
CustomKeywords.'androidOrders.cartScreen.verifyCartValue'(expectedValue)

'verifies the c2 orders tab annotation count and takes expected annotation count as the argument'
CustomKeywords.'androidOrders.cartScreen.verifyC2AnnotationCount'(c2AnnotationCount)

'opens the c2 order tab'
CustomKeywords.'androidOrders.cartScreen.clickOnC2OrdersTab'()

'this function returns the order name of the order which is at the top of the order list'
String orderName = CustomKeywords.'androidOrders.cartScreen.returnTopMostOrderName'()

'opens order details and takes order name as the argument'
CustomKeywords.'androidOrders.cartScreen.openAnOrderDetail'(orderName)

'reading the product name of product to be added (C2 product)'
productSearch = requestObject[GlobalVariable.Environment].TC_R_049.productSearchByNDC

'this function verifies that the product is visible on the order details screen'
CustomKeywords.'androidOrders.orderDetailsScreen.verifyProductIsVisibleOnTheOrderDetailsScreen'(productSearch)

'returns the quantity which has been added for the product searched'
actualQuantityAdded = CustomKeywords.'androidOrders.orderDetailsScreen.returnQuantityOfTheAddedProduct'()

'verifies whether expected and actual quantity added are same or not'
assert actualQuantityAdded == expectedQuantity

'this function verifies the lines count of order name page and takes expected lines count as an argument'
CustomKeywords.'androidOrders.orderDetailsScreen.verifyLineCountOfOrderNamePage'(lineCountOfOrderNamePage)

'returns order value which would be stored in a variable'
String orderValue = CustomKeywords.'androidOrders.orderDetailsScreen.returnOrderValue'()

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'this function verifies the total lines count and takes expected lines count as an argument'
CustomKeywords.'androidOrders.cartScreen.verifyTotalLineCount'(totalLineCount2)

'this function verifies the cart value and takes expected cart value as an argument'
CustomKeywords.'androidOrders.cartScreen.verifyCartValue'(orderValue)

