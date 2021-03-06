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

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()
*/
'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'takes user to the orders tab'
CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnOrders'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'take user to new order screen to enter order details'
CustomKeywords.'androidOrders.ordersCommonScreen.clickOnNewOrder'()

'take user to new order screen to enter order details'
CustomKeywords.'androidOrders.newOrderScreen.enterPurchaseOrderDetails'(poName, poMemo)

'clicks on create order to create an order'
CustomKeywords.'androidOrders.newOrderScreen.createOrder'()

'clicks on create order to create an order'
CustomKeywords.'androidOrders.orderDetailsScreen.verifyOrderScreenDetailsWithoutAnyAddedProduct'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'reading the module test data file'
def requestObject = CustomKeywords.'common.commonMethods.readFileTypeJSON'('ordersData.json')

'reading the UPC of product to be added (nonC2 product)'
String productSearch = requestObject[GlobalVariable.Environment].TC_OE_011.productSearchByUPC

'clicks on scan icon and also verifies that the default scan toggle value is at ordering'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnScanIcon'()

'takes productSearch which can be productName/Cin/UPC/NDC as the input and adds it to the order by scanning the product'
CustomKeywords.'androidOrders.orderDetailsScreen.scanInputEvent'(productSearch)

'reading the NDC of product to be added (nonC2 product)'
productSearch = requestObject[GlobalVariable.Environment].TC_OE_011.productSearchByNDC

'adds the quantity required to be added for the scanned product'
CustomKeywords.'androidOrders.orderDetailsScreen.addQuantityforTheSearchedProduct'(quantity_1)

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'returns the quantity which has been added for the product searched'
actualQuantityAdded = CustomKeywords.'androidOrders.orderDetailsScreen.returnQuantityOfTheAddedProduct'()

'verifies whether actual quantity added equals the expected quantity'
assert actualQuantityAdded == expectedQuantity_1

'takes productSearch and expected lines count as the arguments and verifies the same'
CustomKeywords.'androidOrders.orderDetailsScreen.verifyOrderScreenDetailsWithAddedProduct'()

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'deletes the order and takes purchase order name as the argument'
CustomKeywords.'androidOrders.cartScreen.deleteOrder'(poName)

'verifies that the order should not be visible on the screen and takes purchase order name as the argument'
CustomKeywords.'androidOrders.cartScreen.verifyOrderNotVisibleOnTheCartScreen'(poName)

'takes user to the dashboard screen'
CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnHomeTab'()

'clicks on scan icon and takes user to scanning screen'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnScanIcon'()

'selects toggle value which can be ordering or price check'
CustomKeywords.'androidOrders.orderDetailsScreen.selectToggleValueForTheProductToBeSearched'(toggleValue)

'takes productSearch which can be productName/Cin/UPC/NDC as the input and adds it to the order by scanning the product'
CustomKeywords.'androidOrders.orderDetailsScreen.scanInputEvent'(productSearch)

'adds the quantity required to be added for the scanned product'
CustomKeywords.'androidOrders.orderDetailsScreen.addQuantityforTheSearchedProduct'(quantity_2)

'returns product cost of the added product which would be stored in a variable'
float productCost = CustomKeywords.'androidOrders.orderDetailsScreen.returnCostOfTheAddedProduct'()

'this function returns the total expected value of a product which would be added to the carts value and takes quantity and product cost as the arguments'
float totalProductCost = CustomKeywords.'androidCommonKeywords.commonMethods.returnExpectedTotalValueForAddedProduct'(quantity_2, 
    productCost)

'calculating expected cart value'
float expectedValue = totalProductCost

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'takes user to the orders tab'
CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnOrders'()

'this function verifies the cart value and takes expected cart value as an argument'
CustomKeywords.'androidOrders.cartScreen.verifyCartValue'(expectedValue)

'this function returns the order name of the order which is at the top of the order list'
String orderName = CustomKeywords.'androidOrders.cartScreen.returnTopMostOrderName'()

'opens order details and takes order name as the argument'
CustomKeywords.'androidOrders.cartScreen.openAnOrderDetail'(orderName)

'returns the quantity which has been added for the product searched'
actualQuantityAdded = CustomKeywords.'androidOrders.orderDetailsScreen.returnQuantityOfTheAddedProduct'()

'verifies whether actual quantity added equals the expected quantity'
assert actualQuantityAdded == expectedQuantity_2

'takes productSearch and expected lines count as the arguments and verifies the same'
CustomKeywords.'androidOrders.orderDetailsScreen.verifyOrderScreenDetailsWithAddedProduct'()

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'deletes the order and takes purchase order name as the argument'
CustomKeywords.'androidOrders.cartScreen.deleteOrder'(orderName)
