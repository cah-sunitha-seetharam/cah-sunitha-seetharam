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

*/
'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'verifies user is at the dashboard screen'
CustomKeywords.'iosDashboard.dashboardScreen.verifyDashboardScreen'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'reading the module test data file'
def requestObject = CustomKeywords.'common.commonMethods.readFileTypeJSON'('ordersData.json')

'reading the product name of product to be added (nonC2 product)'
String productSearch1 = requestObject[GlobalVariable.Environment].TC_R_053.productSearchByNDC1

'clicks on scan icon and also verifies that the default scan toggle value is at ordering'
CustomKeywords.'iosDashboard.dashboardScreen.clickOnScanIcon'()

'takes productSearch which can be productName/Cin/UPC/NDC as the input and adds it to the order by scanning the product'
CustomKeywords.'iosOrders.orderDetailsScreen.scanInputEventWhileOnPriceCheck'(productSearch1)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'adds the quantity required to be added for the scanned product'
CustomKeywords.'iosOrders.orderDetailsScreen.addQuantityforTheSearchedProduct'(quantity_2)

'clicks on add to order button to create the order'
CustomKeywords.'iosOrders.orderDetailsScreen.addToOrder'()

'clicks on go to order button'
CustomKeywords.'iosOrders.orderDetailsScreen.clickOnGoToOrder'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'this function returns the order name of the order which is at the top of the order list'
String orderName_1 = CustomKeywords.'iosOrders.orderDetailsScreen.returnOrderNameFromOrderDetailScreen'()

'this function verifies the pattern required for the order which was created without giving any purchase order name'
CustomKeywords.'iosOrders.cartScreen.verifyOrderNamePattern'(orderName_1)

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'verifies user is at the dashboard screen'
CustomKeywords.'iosDashboard.dashboardScreen.verifyDashboardScreen'()

'takes user to the orders tab'
CustomKeywords.'iosDashboard.dashboardScreen.clickOnOrders'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'this function verifies the user is navigated cart screen after tapping on back'
CustomKeywords.'iosOrders.cartScreen.verifyCartScreenWithAddedProduct'()


'clicks on home tab on cart screen'
CustomKeywords.'iosDashboard.dashboardScreen.clickOnHomeTab'()

'verifies user is at the dashboard screen'
CustomKeywords.'iosDashboard.dashboardScreen.verifyDashboardScreen'()

'change account using account selection icon'
CustomKeywords.'iosOrders.newOrderScreen.change_Account'(accountNo_2)

'reading the product name of product to be added (nonC2 product)'
String productSearch2 = requestObject[GlobalVariable.Environment].TC_R_053.productSearchByNDC2

'clicks on scan icon and also verifies that the default scan toggle value is at ordering'
CustomKeywords.'iosDashboard.dashboardScreen.clickOnScanIcon'()

'selects toggle value which can be ordering or price check'
CustomKeywords.'iosOrders.orderDetailsScreen.selectToggleValueForTheProductToBeSearched'(toggleValue)

'takes productSearch which can be productName/Cin/UPC/NDC as the input and adds it to the order by scanning the product'
CustomKeywords.'iosOrders.orderDetailsScreen.scanInputEvent'(productSearch2)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'adds the quantity required to be added for the scanned product'
CustomKeywords.'iosOrders.orderDetailsScreen.addQuantityforTheSearchedProduct'(quantity_2)

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'verifies user is at the dashboard screen'
CustomKeywords.'iosDashboard.dashboardScreen.verifyDashboardScreen'()

'takes user to the orders tab'
CustomKeywords.'iosDashboard.dashboardScreen.clickOnOrders'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'this function verifies the user is navigated cart screen after tapping on back'
CustomKeywords.'iosOrders.cartScreen.verifyCartScreenWithAddedProduct'()


'clicks on home tab on cart screen'
CustomKeywords.'iosDashboard.dashboardScreen.clickOnHomeTab'()

'verifies user is at the dashboard screen'
CustomKeywords.'iosDashboard.dashboardScreen.verifyDashboardScreen'()

'change account using account selection icon'
CustomKeywords.'iosOrders.newOrderScreen.change_Account'(accountNo_1)

'takes user to the orders tab'
CustomKeywords.'iosDashboard.dashboardScreen.clickOnOrders'()

'this function verifies if order created is visible on card screen'
CustomKeywords.'iosOrders.cartScreen.verifyOrderIsVisibleOnTheCartScreen'(orderName_1)

'opens the order from cart screen with order name which was created in the 1st account selection'
CustomKeywords.'iosOrders.cartScreen.openAnOrderDetail'(orderName_1)

'this function verifies order detail screen after an order is opened from cart screen'
CustomKeywords.'iosOrders.orderDetailsScreen.verifyOrderDetailsScreenAfterAddingAProduct'(productSearch1, expectedLinesCount)

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'this function verifies cart screen with the add to order - product being displayed'
CustomKeywords.'iosOrders.cartScreen.verifyCartScreenWithAddedProduct'()


'clicks on home tab on cart screen'
CustomKeywords.'iosDashboard.dashboardScreen.clickOnHomeTab'()

'verifies user is at the dashboard screen'
CustomKeywords.'iosDashboard.dashboardScreen.verifyDashboardScreen'()

'change account using account selection icon'
CustomKeywords.'iosOrders.newOrderScreen.change_Account'(accountNo_3)

'reading the product name of product to be added (nonC2 product)'
String productSearch3 = requestObject[GlobalVariable.Environment].TC_R_053.productSearchByNDC3

'clicks on scan icon and also verifies that the default scan toggle value is at ordering'
CustomKeywords.'iosDashboard.dashboardScreen.clickOnScanIcon'()

'selects toggle value which can be ordering or price check'
CustomKeywords.'iosOrders.orderDetailsScreen.selectToggleValueForTheProductToBeSearched'(toggleValue)

'takes productSearch which can be productName/Cin/UPC/NDC as the input and adds it to the order by scanning the product - #c2 product'
CustomKeywords.'iosOrders.orderDetailsScreen.scanInputEvent'(productSearch3)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'verifies user is at the dashboard screen'
CustomKeywords.'iosDashboard.dashboardScreen.verifyDashboardScreen'()

'takes user to the orders tab'
CustomKeywords.'iosDashboard.dashboardScreen.clickOnOrders'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'this function verifies the user is navigated cart screen after tapping on back'
CustomKeywords.'iosOrders.cartScreen.verifyCartScreenWithAddedProduct'()






