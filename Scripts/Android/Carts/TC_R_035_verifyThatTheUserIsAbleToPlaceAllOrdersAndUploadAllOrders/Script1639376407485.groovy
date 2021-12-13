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

'selects environment'
CustomKeywords.'androidLogin.loginScreen.selectEnvironment'()

'logins with username password and then opens account selection page'
CustomKeywords.'androidLogin.loginScreen.login'(GlobalVariable.Username, GlobalVariable.Password)

'after login, verifies page caption and selects account'
CustomKeywords.'androidAccountSelection.selectAnAccount.selectTheUserAccount'(GlobalVariable.Account)

'opens cart page'
CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnOrders'()

'verifies cart page without any added product'
CustomKeywords.'androidOrders.cartScreen.verify_Cart_Screen_Details_without_Adding_any_Product'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'-------------------------------upload all orders--------------------------------------'

'takes user to the new order screen'
CustomKeywords.'androidOrders.ordersCommonScreen.clickOnNewOrder'()

'verifies new order screen'
CustomKeywords.'androidOrders.newOrderScreen.verifyNewOrderScreenAccount'()

'take user to new order screen to enter order details'
CustomKeywords.'androidOrders.newOrderScreen.enter_Purchase_Order_Details'(poName1, poMemo1)

'clicks on create order to create an order'
CustomKeywords.'androidOrders.newOrderScreen.createOrder'()

'verifies order details screen without any added product'
CustomKeywords.'androidOrders.orderDetailsScreen.verify_Order_Screen_Details_without_any_added_product'()

'clicks on scan icon and also verifies that the default scan toggle value is at ordering'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnScanIcon'()

'reading the module test data file'
def requestObject = CustomKeywords.'common.commonMethods.readFileTypeJSON'('inventoryTestData.json')

'reading the product name of product to be added (nonC2 product)'
String productSearch = requestObject[GlobalVariable.Environment].TC_R_035.productSearchByNDC

'takes productSearch which can be productName/Cin/UPC/NDC as the input and adds it to the order by scanning the product'
CustomKeywords.'androidOrders.orderDetailsScreen.scanInputEvent'(productSearch)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'adds quantity of the product'
CustomKeywords.'androidOrders.orderDetailsScreen.addQuantityforTheSearchedProduct'(quantity1)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'returns the quantity which has been added for the product searched'
actualQuantityAdded = CustomKeywords.'androidOrders.orderDetailsScreen.returnQuantityOfTheAddedProduct'()

'verifies whether actual quantity added equals the expected quantity'
assert actualQuantityAdded == expectedQuantity1

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'takes user to the new order screen'
CustomKeywords.'androidOrders.ordersCommonScreen.clickOnNewOrder'()

'take user to new order screen to enter order details'
CustomKeywords.'androidOrders.newOrderScreen.enter_Purchase_Order_Details'(poName2, poMemo2)

'clicks on create order to create an order'
CustomKeywords.'androidOrders.newOrderScreen.createOrder'()

'clicks on scan icon and also verifies that the default scan toggle value is at ordering'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnScanIcon'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'takes productSearch which can be productName/Cin/UPC/NDC as the input and adds it to the order by scanning the product'
CustomKeywords.'androidOrders.orderDetailsScreen.scanInputEvent'(productSearch)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'adds quantity of the product'
CustomKeywords.'androidOrders.orderDetailsScreen.addQuantityforTheSearchedProduct'(quantity2)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'returns the quantity which has been added for the product searched'
actualQuantityAdded = CustomKeywords.'androidOrders.orderDetailsScreen.returnQuantityOfTheAddedProduct'()

'verifies whether actual quantity added equals the expected quantity'
assert actualQuantityAdded == expectedQuantity2

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'places all the orders by clicking on place all orders button'
CustomKeywords.'androidOrders.cartScreen.clickOnUploadAllOrders'()

'verifies the pop up screen which appears after user clicks on upload all order'
CustomKeywords.'androidOrders.cartScreen.verifyUploadAllOrdersPopUp'()

'clicks on continue ordering to take user back to the search results to keep browsing'
CustomKeywords.'androidOrders.cartScreen.clickOnContinueOnDesktop'()

'verifies order has been sent to desktop popup'
CustomKeywords.'androidOrders.orderDetailsScreen.verifyOrderHasbeensentToDesktopPopUp'()

'takes user back to cart screen'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnBackToCart'()

'verifies that the order should not be visible on the screen and takes purchase order name as the argument'
CustomKeywords.'androidOrders.cartScreen.verifyOrderNotVisibleOnTheCartScreen'(poName1)
CustomKeywords.'androidOrders.cartScreen.verifyOrderNotVisibleOnTheCartScreen'(poName2)

'-----------------------------------place all orders-------------------------------------'

'takes user to the new order screen'
CustomKeywords.'androidOrders.ordersCommonScreen.clickOnNewOrder'()

'take user to new order screen to enter order details'
CustomKeywords.'androidOrders.newOrderScreen.enter_Purchase_Order_Details'(poName1, poMemo1)

'clicks on create order to create an order'
CustomKeywords.'androidOrders.newOrderScreen.createOrder'()

'clicks on scan icon and also verifies that the default scan toggle value is at ordering'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnScanIcon'()

'takes productSearch which can be productName/Cin/UPC/NDC as the input and adds it to the order by scanning the product'
CustomKeywords.'androidOrders.orderDetailsScreen.scanInputEvent'(productSearch)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'adds quantity of the product'
CustomKeywords.'androidOrders.orderDetailsScreen.addQuantityforTheSearchedProduct'(quantity1)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'returns the quantity which has been added for the product searched'
actualQuantityAdded = CustomKeywords.'androidOrders.orderDetailsScreen.returnQuantityOfTheAddedProduct'()

'verifies whether actual quantity added equals the expected quantity'
assert actualQuantityAdded == expectedQuantity1

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'takes user to the new order screen'
CustomKeywords.'androidOrders.ordersCommonScreen.clickOnNewOrder'()

'take user to new order screen to enter order details'
CustomKeywords.'androidOrders.newOrderScreen.enter_Purchase_Order_Details'(poName2, poMemo2)

'clicks on create order to create an order'
CustomKeywords.'androidOrders.newOrderScreen.createOrder'()

'clicks on scan icon and also verifies that the default scan toggle value is at ordering'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnScanIcon'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'takes productSearch which can be productName/Cin/UPC/NDC as the input and adds it to the order by scanning the product'
CustomKeywords.'androidOrders.orderDetailsScreen.scanInputEvent'(productSearch)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'adds quantity of the product'
CustomKeywords.'androidOrders.orderDetailsScreen.addQuantityforTheSearchedProduct'(quantity2)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'returns the quantity which has been added for the product searched'
actualQuantityAdded = CustomKeywords.'androidOrders.orderDetailsScreen.returnQuantityOfTheAddedProduct'()

'verifies whether actual quantity added equals the expected quantity'
assert actualQuantityAdded == expectedQuantity2

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'places all the orders by clicking on place all orders button'
CustomKeywords.'androidOrders.cartScreen.clickOnPlaceAllOrders'()

'uploads the order by clicking on upload order button'
CustomKeywords.'androidOrders.cartScreen.verifyPlaceAllOrdersPopUp'()

'places all the orders by clicking on place all orders button'
CustomKeywords.'androidOrders.cartScreen.clickOnPlaceMyOrders'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'verifies that the order should not be visible on the screen and takes purchase order name as the argument'
CustomKeywords.'androidOrders.cartScreen.verifyOrderNotVisibleOnTheCartScreen'(poName1)
CustomKeywords.'androidOrders.cartScreen.verifyOrderNotVisibleOnTheCartScreen'(poName2)

