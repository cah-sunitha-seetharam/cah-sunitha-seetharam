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
CustomKeywords.'iosCommonKeywords.commonMethods.installingAndlaunchingTheApplication'()

'logins with username password and then opens account selection page'
CustomKeywords.'iosLogin.loginScreen.login'(GlobalVariable.Username, GlobalVariable.Password)

'after login, verifies page caption and selects account'
CustomKeywords.'iosAccountSelection.selectAnAccount.selectTheUserAccount'(GlobalVariable.Account)

'-----------Pre-requisite(C2 order should be available with c2 products in it)------------'

'opens cart page'
CustomKeywords.'iosDashboard.dashboardScreen.clickOnOrders'()

'clicks on scan icon and also verifies that the default scan toggle value is at ordering'
CustomKeywords.'iosOrders.orderDetailsScreen.clickOnScanIcon'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'reading the module test data file'
def requestObject = CustomKeywords.'common.commonMethods.readFileTypeJSON'('ordersData.json')

'reading the product name of product to be added (C2 product)'
String productSearch = requestObject[GlobalVariable.Environment].TC_R_061.productSearchByNDC

'takes productSearch which can be productName/Cin/UPC/NDC as the input and adds it to the order by scanning the product'
CustomKeywords.'iosOrders.orderDetailsScreen.scanInputEvent'(productSearch)

'adds quantity of the product'
CustomKeywords.'iosOrders.orderDetailsScreen.addQuantityforTheSearchedProduct'(quantity)

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'takes the application back to login page'
CustomKeywords.'iosMoreOptions.moreOptionsScreen.signOut'()

'-----------------------------------signIn---------------------------------------'

'taps on cancel button for update if popUp is visible'
CustomKeywords.'iosLogin.loginScreen.cancelUpdatePopUp'()

'logins with username then opens account selection page'
CustomKeywords.'iosLogin.loginScreen.enterUsername'(GlobalVariable.Username)

'enters the password'
CustomKeywords.'iosLogin.loginScreen.enterPassword_2'(GlobalVariable.Password)

'clicks on signIn button and takes to the dash-board of the application'
CustomKeywords.'iosLogin.loginScreen.clickOnSignInButton'()

'------------------------enables beta feature CSOS---------------------------'

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'clicks on more options, takes to beat features and enables it'
CustomKeywords.'iosCommonKeywords.commonMethods.enableBetaFeatures'()

'------------------------------------------------------------------------------'

'opens cart page'
CustomKeywords.'iosDashboard.dashboardScreen.clickOnOrders'()

'opens the c2 orders tab'
CustomKeywords.'iosOrders.cartScreen.clickOnC2Orders'()

'opens the c2 order details'
CustomKeywords.'iosOrders.cartScreen.openC2OrderDetails'()

'takes productSearch and expected lines count as the arguments and verifies the same'
CustomKeywords.'iosOrders.orderDetailsScreen.verifyOrderDetailsScreenAfterAddingAProduct'(productSearch, expectedLineCount)

'returns the top most product name in order details page'
String productName = CustomKeywords.'iosOrders.orderDetailsScreen.returnTopMostProductNameInOrderDetails'()

'reading the product name of product to be added (nonc2 product)'
String productSearchByName = requestObject[GlobalVariable.Environment].TC_R_061.productSearchByName

'searches for a product by setting product name'
CustomKeywords.'iosOrders.orderDetailsScreen.searchProductInOrderDetailPage'(productSearchByName)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'opens product tile'
CustomKeywords.'iosOrders.orderDetailsScreen.clickOnProductTile'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'opens more details of product details'
CustomKeywords.'iosOrders.orderDetailsScreen.clickOnMoreDetails'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'opens alternates page'
CustomKeywords.'iosOrders.orderDetailsScreen.tapOnAlternatesInProductDetailsPage'()

'this function adds the quantity in alternates page'
CustomKeywords.'iosOrders.orderDetailsScreen.addQuantityInAlternatesPage'(quantity)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'taps on alternate to order in alternates page and opens confirmation pop up'
CustomKeywords.'iosOrders.orderDetailsScreen.tapOnAddAlternateToOrderInAlternatesPage'()

'creates a new C2 order'
CustomKeywords.'iosOrders.orderDetailsScreen.createNewC2Order'(poName, poMemo)

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'verifies that the added top most product should  be visible on the order details page'
CustomKeywords.'iosOrders.orderDetailsScreen.verifyProductNameIsVisibleUnderOrderDetails'(productName)

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'deletes order'
CustomKeywords.'iosOrders.cartScreen.deleteC2Order'()

'opens the non c2 orders tab'
CustomKeywords.'iosOrders.cartScreen.clickOnNonC2Orders'()

'returns the order name of the order which is at the top of the order list'
String orderName=CustomKeywords.'iosOrders.cartScreen.returnTopMostOrderName'()

'deletes order'
CustomKeywords.'iosOrders.cartScreen.deleteOrder'(orderName)
