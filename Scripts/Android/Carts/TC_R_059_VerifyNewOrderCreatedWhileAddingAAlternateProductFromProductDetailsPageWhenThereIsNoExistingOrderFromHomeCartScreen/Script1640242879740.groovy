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
CustomKeywords.'androidAccountSelection.selectAnAccount.selectTheUserAccount'(GlobalVariable.Account)

'------------------------enables beta feature CSOS---------------------------'

CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnMoreOptions'()

CustomKeywords.'androidMoreOptions.moreOptionsScreen.enableBetaFeatureCSOS'()

'----------------------------------------------------------------------------'

'opens home page'
CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnHomeTab'()

'reading the module test data file'
def requestObject = CustomKeywords.'common.commonMethods.readFileTypeJSON'('ordersData.json')

'reading the product name of product to be added (nonc2 product)'
String productSearch = requestObject[GlobalVariable.Environment].TC_R_059.productSearchByName

'searches for a product by setting product name'
CustomKeywords.'androidOrders.orderDetailsScreen.searchProductInOrderDetailPage'(productSearch)

'opens product tile'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnProductTile'()

'opens more details of product details'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnMoreDetails'()

'opens alternates page'
CustomKeywords.'androidOrders.orderDetailsScreen.tapOnAlternatesInProductDetailsPage'(alternates)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'verifies filterByOptions'
CustomKeywords.'androidOrders.orderDetailsScreen.verifyFilterByOptions'(alternates)

'this function adds the quantity in alternates page'
CustomKeywords.'androidOrders.orderDetailsScreen.addQuantityInAlternatesPage'(quantity)

'taps on alternate to order in alternates page and opens confirmation pop up'
CustomKeywords.'androidOrders.orderDetailsScreen.tapOnAddAlternateToOrderInAlternatesPage'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

CustomKeywords.'androidOrders.orderDetailsScreen.verifyConfirmationPopUpInALternatesPage'()

'takes user back to the search product results to continue browsing'
CustomKeywords.'androidOrders.orderDetailsScreen.tapOnContinueBrowsing'()

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'verifies dashboard screen'
CustomKeywords.'androidDashboard.dashboardDetailsScreen.verifyDashboardPage'()

'opens cart page'
CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnOrders'()

'this function returns the order name of the order which is at the top of the order list'
String orderName = CustomKeywords.'androidOrders.cartScreen.returnTopMostOrderName'()

'opens order details and takes order name as the argument'
CustomKeywords.'androidOrders.cartScreen.openAnOrderDetail'(orderName)

'places the order'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnPlaceOrder'()

'verifies place order confirmation pop up'
CustomKeywords.'androidOrders.orderDetailsScreen.verifyPlaceOrderPopUp'()

'confirms place order by clicking on place my order button'
CustomKeywords.'androidOrders.orderDetailsScreen.confirmPlaceOrder'()

'takes user back to cart'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnBackToCart'()

'verifies that the order should not be visible on the screen and takes purchase order name as the argument'
CustomKeywords.'androidOrders.cartScreen.verifyOrderNotVisibleOnTheCartScreen'(orderName)

