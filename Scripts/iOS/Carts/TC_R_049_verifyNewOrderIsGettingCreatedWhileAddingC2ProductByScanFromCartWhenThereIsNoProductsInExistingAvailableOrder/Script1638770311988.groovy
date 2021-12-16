import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.builtin.CloseApplicationKeyword as CloseApplicationKeyword
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

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'this function verifies the lines count and takes expected lines count as an argument'
CustomKeywords.'iosOrders.cartScreen.verifyLinesCount'(expectedLinesCount_1)

'this function verifies the cart value and takes expected cart value as an argument'
CustomKeywords.'iosOrders.cartScreen.verifyCartValue'(0)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'reading the module test data file'
def requestObject = CustomKeywords.'common.commonMethods.readFileTypeJSON'('ordersData.json')

'reading the product name of product to be added (nonC2 product)'
String productSearch = requestObject[GlobalVariable.Environment].TC_R_049.productSearchByUPC

'clicks on scan icon and also verifies that the default scan toggle value is at ordering'
CustomKeywords.'iosOrders.cartScreen.clickOnScanIcon'()

'selects toggle value which can be ordering or price check'
CustomKeywords.'iosOrders.cartScreen.selectToggleValueForTheProductToBeSearched'(toggleValue)

'takes productSearch which can be productName/Cin/UPC/NDC as the input and adds it to the order by scanning the product'
CustomKeywords.'iosOrders.cartScreen.scanInputEvent'(productSearch)

'reading the product name of product to be added (nonC2 product)'
productSearch = requestObject[GlobalVariable.Environment].TC_R_049.productSearchByNDC

'returns product cost of the added product which would be stored in a variable'
float productCost = CustomKeywords.'iosOrders.orderDetailsScreen.returnCostOfTheAddedProduct'()

'this function returns the total expected value of a product which would be added to the carts value and takes quantity and product cost as the arguments'
float totalProductCost = CustomKeywords.'iosCommonKeywords.commonMethods.returnExpectedTotalValueForAddedProduct'(quantity, 
    productCost)

'calculating expected cart value'
float expectedValue = totalProductCost

'verifies c2 label is visible or not'
CustomKeywords.'iosOrders.orderDetailsScreen.verifyC2Label'()

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'takes user to the orders tab'
CustomKeywords.'iosDashboard.dashboardScreen.clickOnOrders'()

'verifies that the order should be visible on the screen and takes purchase order name as the argument'
CustomKeywords.'iosOrders.cartScreen.verifyOrderIsVisibleOnTheCartScreen'(poName)

'this function verifies the lines count and takes expected lines count as an argument'
CustomKeywords.'iosOrders.cartScreen.verifyLinesCount'(expectedLinesCount_2)

'this function verifies the cart value and takes expected cart value as an argument'
CustomKeywords.'iosOrders.cartScreen.verifyCartValue'(expectedValue)

'verifies the c2 orders tab annotation count and takes expected annotation count as the argument'
CustomKeywords.'iosOrders.cartScreen.verifyC2OrdersTabAnnotationCount'(expectedAnnotationCount)

'deletes the order and takes purchase order name as the argument'
CustomKeywords.'iosOrders.cartScreen.deleteOrder'(poName)

'opens the c2 order tab'
CustomKeywords.'iosOrders.cartScreen.clickOnC2Orders'()

'opens the c2 order details'
CustomKeywords.'iosOrders.cartScreen.openC2OrderDetails'()

'this function verifies that the product is visible on the order details screen'
CustomKeywords.'iosOrders.orderDetailsScreen.verifyProductIsVisibleOnTheOrderDetailsScreen'(productSearch)

'returns the quantity which has been added for the product searched'
actualQuantityAdded = CustomKeywords.'iosOrders.orderDetailsScreen.returnQuantityOfTheAddedProduct'()

'verifies whether expected and actual quantity added are same or not'
assert actualQuantityAdded == expectedQuantity

'takes productSearch and expected lines count as the arguments and verifies the same'
CustomKeywords.'iosOrders.orderDetailsScreen.verifyOrderDetailsScreenAfterAddingAProduct'(productSearch, expectedLinesCount_2)

'returns order value which would be stored in a variable'
float orderValue = CustomKeywords.'iosOrders.orderDetailsScreen.returnOrderValue'()

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'this function verifies the lines count and takes expected lines count as an argument'
CustomKeywords.'iosOrders.cartScreen.verifyLinesCount'(expectedLinesCount_2)

'this function verifies the cart value and takes expected cart value as an argument'
CustomKeywords.'iosOrders.cartScreen.verifyCartValue'(orderValue)

'deletes the order and takes purchase order name as the argument'
CustomKeywords.'iosOrders.cartScreen.deleteC2Order'()

