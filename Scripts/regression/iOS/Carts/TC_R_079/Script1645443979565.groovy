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
import internal.GlobalVariable

import static org.junit.Assert.assertArrayEquals

import org.openqa.selenium.Keys as Keys
import io.appium.java_client.InteractsWithApps as InteractsWithApps

'opens existing testflight app and installs latest OE App'
CustomKeywords.'iosCommonKeywords.commonMethods.openTestFlightApp'(bundleID)

'logins with username password and then opens account selection page'
CustomKeywords.'iosLogin.loginScreen.login'(GlobalVariable.Username, GlobalVariable.Password)

'clicks on signIn button and takes to the dash-board of the application'
CustomKeywords.'iosLogin.loginScreen.clickOnSignInButton'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'disables touchid while using real device'
CustomKeywords.'iosCommonKeywords.commonMethods.tapOnSetupLater'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

//'after login, verifies page caption and selects account'
//CustomKeywords.'iosAccountSelection.selectAnAccount.selectTheUserAccount'(GlobalVariable.Account)

'------------------------enables beta feature CSOS---------------------------'

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'clicks on more options, takes to beat features and enables it'
CustomKeywords.'iosCommonKeywords.commonMethods.enableBetaFeatures'()

'----------prerequisite(orderhistory - order with multiple products in it----------'

'opens cart page'
CustomKeywords.'iosDashboard.dashboardScreen.clickOnOrders'()

'clicks on scan icon and also verifies that the default scan toggle value is at ordering'
CustomKeywords.'iosOrders.orderDetailsScreen.clickOnScanIconWithoutVerification'()

'allows camera access while using real device'
CustomKeywords.'iosOrders.orderDetailsScreen.tapOnOkForCameraAcess'()

'reading the module test data file'
def requestObject = CustomKeywords.'common.commonMethods.readFileTypeJSON'('ordersData.json')

'reading the product name of product to be added (nonC2 product)'
String productSearch1 = requestObject[GlobalVariable.Environment].TC_R_079.productSearchByNDC1
String productSearch2 = requestObject[GlobalVariable.Environment].TC_R_079.productSearchByNDC2
String productSearch3 = requestObject[GlobalVariable.Environment].TC_R_079.productSearchByNDC3
String productSearch4 = requestObject[GlobalVariable.Environment].TC_R_079.productSearchByNDC4

'this function selects toggle value for the product to be added which can be ordering or price check)'
CustomKeywords.'iosOrders.orderDetailsScreen.selectToggleValueForTheProductToBeSearched'(toggleValue)

'scans the product'
CustomKeywords.'iosOrders.orderDetailsScreen.scanInputEventWithoutVerification'(productSearch2)

'this function adds the quantity for the product to be searched'
CustomKeywords.'iosOrders.orderDetailsScreen.addQuantityforTheSearchedProduct'(quantity)

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'taps on scan icon and takes user to scanning product screen '
CustomKeywords.'iosOrders.orderDetailsScreen.clickOnScanIconWithoutVerification'()

'scans the product'
CustomKeywords.'iosOrders.orderDetailsScreen.scanInputEventWithoutVerification'(productSearch3)

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

' taps on scan icon and takes user to scanning product screen '
CustomKeywords.'iosOrders.orderDetailsScreen.clickOnScanIconWithoutVerification'()

'scans the product'
CustomKeywords.'iosOrders.orderDetailsScreen.scanInputEventWithoutVerification'(productSearch4)

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'opens cart page'
CustomKeywords.'iosDashboard.dashboardScreen.clickOnOrders'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'returns the order name of the order which is at the top of the order list'
String orderName=CustomKeywords.'iosOrders.cartScreen.returnTopMostOrderName'()

'opens the order details page'
CustomKeywords.'iosOrders.cartScreen.openAnOrderDetail'(orderName)

'clicks on place order button'
CustomKeywords.'iosOrders.orderDetailsScreen.placeOrder'()

'takes user back to cart screen and verifies user is on the cart screen or not'
CustomKeywords.'iosOrders.orderDetailsScreen.clickOnBackToCart'()

'----------------scan A product in ordering toggle and go to offline mode-------------'

'clicks on scan icon and also verifies that the default scan toggle value is at ordering'
CustomKeywords.'iosOrders.orderDetailsScreen.clickOnScanIcon'()

'selects toggle value for the product to be added which can be ordering or price check'
CustomKeywords.'iosOrders.orderDetailsScreen.selectToggleValueForTheProductToBeSearched'(toggleValue)

'takes productSearch which can be productName/Cin/UPC/NDC as the input and adds it to the order by scanning the product'
CustomKeywords.'iosOrders.orderDetailsScreen.scanInputEventWithoutVerification'(productSearch1)

String NDCLabelOnlineMode = CustomKeywords.'iosOrders.orderDetailsScreen.returnNDCLabelOfScannedProduct'()

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'turns on airplane mode'
Mobile.toggleAirplaneMode(Yes)

'closes the popup when user switches to offline mode'
CustomKeywords.'iosOrders.orderDetailsScreen.closeOfflinePopUp'()

'---------------scan same A product in price check toggle in offline mode--------------'

'clicks on scan icon and also verifies that the default scan toggle value is at ordering'
CustomKeywords.'iosOrders.orderDetailsScreen.clickOnScanIcon'()

'selects toggle value for the product to be added which can be ordering or price check'
CustomKeywords.'iosOrders.orderDetailsScreen.selectToggleValueForTheProductToBeSearched'(toggleValue1)

'takes productSearch which can be productName/Cin/UPC/NDC as the input and adds it to the order by scanning the product'
CustomKeywords.'iosOrders.orderDetailsScreen.scanInputEventWithoutVerification'(productSearch1)

'retruns NDC number'
String NDCLabelOfflineModePriceCheck = CustomKeywords.'iosOrders.orderDetailsScreen.returnNDCLabelOfScannedProduct'()

'assertion funaction called to verify expected and actual ndc number'
assert NDCLabelOnlineMode == NDCLabelOfflineModePriceCheck

'adds product'
CustomKeywords.'iosOrders.orderDetailsScreen.addToOrderWithoutVerify'()

'taps on go to order button on order confirmation screen and takes user to order details screen'
CustomKeywords.'iosOrders.orderDetailsScreen.clickOnGoToOrder'()

'verifies order details screen when user in offline mode'
CustomKeywords.'iosOrders.orderDetailsScreen.verifyOrderDetailsScreenInOfflineMode'()

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'---------------scan same A product in ordering toggle in offline mode--------------'

'clicks on scan icon and also verifies that the default scan toggle value is at ordering'
CustomKeywords.'iosOrders.orderDetailsScreen.clickOnScanIcon'()

'selects toggle value for the product to be added which can be ordering or price check'
CustomKeywords.'iosOrders.orderDetailsScreen.selectToggleValueForTheProductToBeSearched'(toggleValue)

'takes productSearch which can be productName/Cin/UPC/NDC as the input and adds it to the order by scanning the product'
CustomKeywords.'iosOrders.orderDetailsScreen.scanInputEventWithoutVerification'(productSearch1)

String NDCLabelOfflineModeOrdering = CustomKeywords.'iosOrders.orderDetailsScreen.returnNDCLabelOfScannedProduct'()

'assertion funaction called to verify expected and actual ndc number'
assert NDCLabelOnlineMode == NDCLabelOfflineModeOrdering

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'------------------------using prerequisite---------------------------'

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'turns off airplane mode'
Mobile.toggleAirplaneMode(No)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'opens orders tab where user can perform actions related to orders'
CustomKeywords.'iosDashboard.dashboardScreen.clickOnOrders'()

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'clicks on history tab button to open history tab in order history screen'
CustomKeywords.'iosOrders.historyScreen.clickOnHistoryTab'()

'returns po number of an top most order '
String poNumber = CustomKeywords.'iosOrders.historyScreen.returnTopMostPoNumberOfAnOrder'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'opens top most order in order history'
CustomKeywords.'iosOrders.historyScreen.tapOnTopMostOrderHistory'(poNumber)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'turns on airplane mode'
Mobile.toggleAirplaneMode(Yes)

'closes the popup when user switches to offline mode'
CustomKeywords.'iosOrders.orderDetailsScreen.closeOfflinePopUp'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'taps on scan icon and takes user to scanning product screen'
CustomKeywords.'iosOrders.orderDetailsScreen.clickOnScanIconWithoutVerification'()

'takes productSearch which can be productName/Cin/UPC/NDC as the input and adds it to the order by scanning the product'
CustomKeywords.'iosOrders.orderDetailsScreen.scanInputEventInOfflineMode'(productSearch2)

'returns quantity added'
String actualQuantityAdded = CustomKeywords.'iosOrders.historyScreen.returnQuantityForScannedResultInOfflineMode'()

'assertion funaction called to verify expected and actual quantity added'
assert actualQuantityAdded==expectedQuantityAdded

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'taps on scan icon and takes user to scanning product screen'
CustomKeywords.'iosOrders.orderDetailsScreen.clickOnScanIconWithoutVerification'()

'scans the product in offline mode'
CustomKeywords.'iosOrders.orderDetailsScreen.scanInputEventInOfflineMode'(productSearch3)

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'taps on scan icon and takes user to scanning product screen'
CustomKeywords.'iosOrders.orderDetailsScreen.clickOnScanIconWithoutVerification'()

'scans the product in offline mode'
CustomKeywords.'iosOrders.orderDetailsScreen.scanInputEventInOfflineMode'(productSearch4)

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'opens cart tab'
CustomKeywords.'iosOrders.ordersCommonScreen.clickOnCartTab'()

'returns the order name of the order which is at the top of the order list'
String orderName1=CustomKeywords.'iosOrders.cartScreen.returnTopMostOrderName'()

'deletes order'
CustomKeywords.'iosOrders.cartScreen.deleteOrder'(orderName1)

'turns off airplane mode'
Mobile.toggleAirplaneMode(No)
