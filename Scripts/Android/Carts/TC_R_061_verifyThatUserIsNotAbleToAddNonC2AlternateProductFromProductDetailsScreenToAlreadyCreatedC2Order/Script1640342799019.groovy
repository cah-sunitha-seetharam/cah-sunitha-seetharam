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

'-----------Pre-requisite(C2 order should be available with c2 products in it)------------'

'opens cart page'
CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnOrders'()

'clicks on scan icon and also verifies that the default scan toggle value is at ordering'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnScanIcon'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'reading the module test data file'
def requestObject = CustomKeywords.'common.commonMethods.readFileTypeJSON'('ordersData.json')

'reading the product name of product to be added (C2 product)'
String productSearch = requestObject[GlobalVariable.Environment].TC_R_061.productSearchCin

'takes productSearch which can be productName/Cin/UPC/NDC as the input and adds it to the order by scanning the product'
CustomKeywords.'androidOrders.orderDetailsScreen.scanInputEvent'(productSearch)

'adds quantity of the product'
CustomKeywords.'androidOrders.orderDetailsScreen.addQuantityforTheSearchedProduct'(quantity)

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'takes the application back to login page'
CustomKeywords.'android_more_options.moreOptionsScreen.signOut'()

'-----------------------------------signIn---------------------------------------'

'enters password in login page'
CustomKeywords.'androidLogin.loginScreen.enterPassword'(GlobalVariable.Password)

'clicks on sign In button'
CustomKeywords.'androidLogin.loginScreen.clickOnSignInButton'()

'after login, verifies page caption and selects account'
CustomKeywords.'androidAccountSelection.selectAnAccount.selectTheUserAccount'(GlobalVariable.Account)

'------------------------enables beta feature CSOS---------------------------'

CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnMoreOptions'()

CustomKeywords.'android_more_options.moreOptionsScreen.enableBetaFeatureCSOS'()

'------------------------------------------------------------------------------'

'opens cart page'
CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnOrders'()

'opens the c2 order tab'
CustomKeywords.'androidOrders.cartScreen.clickOnC2OrdersTab'()

'this function returns the order name of the order which is at the top of the order list'
String orderName = CustomKeywords.'androidOrders.cartScreen.returnTopMostOrderName'()

'opens order details and takes order name as the argument'
CustomKeywords.'androidOrders.cartScreen.openAnOrderDetail'(orderName)

'takes lines count as the argument and verifies the same'
CustomKeywords.'androidOrders.orderDetailsScreen.verifyLineCountOfOrderNamePage'(lineCountOfOrderNamePage)

'returns the top most product name in order details page'
String productName = CustomKeywords.'androidOrders.orderDetailsScreen.returnTopMostProductNameInOrderDetails'()

'reading the product name of product to be added (non C2 product)'
String productSearchByName = requestObject[GlobalVariable.Environment].TC_R_061.productSearchByName

'searches for a product by setting product name'
CustomKeywords.'androidOrders.orderDetailsScreen.searchProductInOrderDetailPage'(productSearchByName)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'opens product tile'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnProductTile'()

'opens more details of product details'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnMoreDetails'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'opens alternates page'
CustomKeywords.'androidOrders.orderDetailsScreen.tapOnAlternatesInProductDetailsPage'(alternates)

'this function adds the quantity in alternates page'
CustomKeywords.'androidOrders.orderDetailsScreen.addQuantityInAlternatesPage'(quantity)

'taps on alternate to order in alternates page and opens confirmation pop up'
CustomKeywords.'androidOrders.orderDetailsScreen.tapOnAddAlternateToOrderInAlternatesPage'()

'creates a new C2 order'
CustomKeywords.'androidOrders.orderDetailsScreen.createNewOrderForC2'(poName, poMemo)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'enables radio button and adds c2 product'
CustomKeywords.'androidOrders.orderDetailsScreen.enableRadioButtonForNewOrderC2Creation'(poName)

'takes user back to the search product results to continue browsing'
CustomKeywords.'androidOrders.orderDetailsScreen.tapOnContinueBrowsing'()

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'verifies that the added top most product should  be visible on the order details page'
CustomKeywords.'androidOrders.orderDetailsScreen.verifyProductNameIsVisibleUnderOrderDetails'(productName)

'takes lines count as the argument and verifies the same'
CustomKeywords.'androidOrders.orderDetailsScreen.verifyLineCountOfOrderNamePage'(lineCountOfOrderNamePage)