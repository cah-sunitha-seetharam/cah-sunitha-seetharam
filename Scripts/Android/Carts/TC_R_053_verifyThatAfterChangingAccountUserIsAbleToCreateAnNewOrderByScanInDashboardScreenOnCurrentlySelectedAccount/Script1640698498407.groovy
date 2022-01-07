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

'logins with username password and then opens account selection page'
CustomKeywords.'androidLogin.loginScreen.login'(GlobalVariable.Username, GlobalVariable.Password)

'after login, verifies page caption and selects account'
CustomKeywords.'androidAccountSelection.selectAnAccount.selectTheUserAccount'(accountNo_1)

'------------------------enables beta feature CSOS---------------------------'

CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnMoreOptions'()

CustomKeywords.'androidMoreOptions.moreOptionsScreen.enableBetaFeatureCSOS'()

CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnHomeTab'()

'------------------------accountNo_1(Non C2)---------------------------'

'clicks on scan icon and also verifies that the default scan toggle value is at ordering'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnScanIcon'()

'takes productSearch which can be productName/Cin/UPC/NDC as the input and adds it to the order by scanning the product'
CustomKeywords.'androidOrders.orderDetailsScreen.selectToggleValueForTheProductToBeSearched'(toggleValue1)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'reading the module test data file'
def requestObject = CustomKeywords.'common.commonMethods.readFileTypeJSON'('ordersData.json')

'reading the product name of product to be added (nonC2 product)'
String productSearch1 = requestObject[GlobalVariable.Environment].TC_R_053.productSearchByNDC1

'scans the product while on price check, adds it to the order and also verifies some scan input details'
CustomKeywords.'androidOrders.orderDetailsScreen.scanInputEventWhileOnPriceCheck'(productSearch1)

'adds quantity of the product'
CustomKeywords.'androidOrders.orderDetailsScreen.addQuantityforTheSearchedProduct'(quantity)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'taps on add to order and shows confirmation pop up'
CustomKeywords.'androidOrders.orderDetailsScreen.tapOnAddToOrderInScanSearchResults'()

'takes user to the order details'
CustomKeywords.'androidOrders.orderDetailsScreen.tapOnGoToOrder'()

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'opens cart page'
CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnOrders'()

'this function returns the order name of the order which is at the top of the order list'
String orderName_1 = CustomKeywords.'androidOrders.cartScreen.returnTopMostOrderName'()

'opens home tab where user can perform actions related to home'
CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnHomeTab'()

'verifies the dash-board details Screen'
CustomKeywords.'androidDashboard.dashboardDetailsScreen.verifyDashboardPage'()

'----------------------accountNo_2(Non C2)---------------------------'

'selects different account'
CustomKeywords.'androidOrders.newOrderScreen.changeAccount'(accountNo_2)

'clicks on scan icon and also verifies that the default scan toggle value is at ordering'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnScanIcon'()

'takes productSearch which can be productName/Cin/UPC/NDC as the input and adds it to the order by scanning the product'
CustomKeywords.'androidOrders.orderDetailsScreen.selectToggleValueForTheProductToBeSearched'(toggleValue2)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'reading the product name of product to be added (nonC2 product)'
String productSearch2 = requestObject[GlobalVariable.Environment].TC_R_053.productSearchByNDC2

'takes productSearch which can be productName/Cin/UPC/NDC as the input and adds it to the order by scanning the product'
CustomKeywords.'androidOrders.orderDetailsScreen.scanInputEvent'(productSearch2)

'adds quantity of the product'
CustomKeywords.'androidOrders.orderDetailsScreen.addQuantityforTheSearchedProduct'(quantity)

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'opens cart page'
CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnOrders'()

'opens home tab where user can perform actions related to home'
CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnHomeTab'()

' verifies the dash-board details Screen'
CustomKeywords.'androidDashboard.dashboardDetailsScreen.verifyDashboardPage'()

'--------------------------switch back to accountNo_1-------------------------'

'change account using account selection icon'
CustomKeywords.'androidOrders.newOrderScreen.changeAccount'(accountNo_1)

'opens cart page'
CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnOrders'()

'opens an order from cart screen with order name which was created in the 1st account selection'
CustomKeywords.'androidOrders.cartScreen.openAnOrderDetail'(orderName_1)

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'verifies the dash-board details Screen'
CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnHomeTab'()

'clicks on scan icon and also verifies that the default scan toggle value is at ordering'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnScanIcon'()

'takes productSearch which can be productName/Cin/UPC/NDC as the input and adds it to the order by scanning the product'
CustomKeywords.'androidOrders.orderDetailsScreen.selectToggleValueForTheProductToBeSearched'(toggleValue2)

'reading the product name of product to be added (C2 product)'
String productSearch3 = requestObject[GlobalVariable.Environment].TC_R_053.productSearchCin

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'takes productSearch which can be productName/Cin/UPC/NDC as the input and adds it to the order by scanning the product'
CustomKeywords.'androidOrders.orderDetailsScreen.scanInputEvent'(productSearch3)

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'opens cart page'
CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnOrders'()

'verifies nonC2 annotation count'
CustomKeywords.'androidOrders.cartScreen.verifynonC2AnnotationCount'(nonC2AnnotationCount)

'opens the c2 orders tab'
CustomKeywords.'androidOrders.cartScreen.clickOnC2OrdersTab'()

'opens the c2 orders tab'
CustomKeywords.'androidOrders.cartScreen.verifyC2AnnotationCount'(c2AnnotationCount)

'-------------------------delete orders in all 2 accounts----------------------'

'deletes order'
CustomKeywords.'androidOrders.cartScreen.deleteOrder'()

'opens the nonc2 orders tab'
CustomKeywords.'androidOrders.cartScreen.clickOnNonC2OrdersTab'()

'deletes order'
CustomKeywords.'androidOrders.cartScreen.deleteOrder'()

'change account using account selection icon'
CustomKeywords.'androidOrders.newOrderScreen.changeAccount'(accountNo_2)

'deletes order'
CustomKeywords.'androidOrders.cartScreen.deleteOrder'()
