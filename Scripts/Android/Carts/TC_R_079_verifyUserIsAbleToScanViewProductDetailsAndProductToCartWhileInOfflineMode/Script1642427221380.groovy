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

'login function called which takes user to the accounts selection screen'
CustomKeywords.'androidLogin.loginScreen.login'(GlobalVariable.Username, GlobalVariable.Password)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'selects the user account from the accounts list'
CustomKeywords.'androidAccountSelection.selectAnAccount.selectTheUserAccount'(GlobalVariable.Account)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()


'------------------------enables beta feature CSOS---------------------------'

'clicks on more options tab is dashboard'
CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnMoreOptionsTab'()

'enables csos beta feature in the account selected'
CustomKeywords.'androidMoreOptions.moreOptionsScreen.enableBetaFeatureCSOS'()

'----------prerequisite(orderhistory - order with multiple products in it----------'

'opens cart page'
CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnOrders'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'clicks on scan icon and also verifies that the default scan toggle value is at ordering'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnScanIconWithoutVerification'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'reading the module test data file'
def requestObject = CustomKeywords.'common.commonMethods.readFileTypeJSON'('ordersData.json')

'reading the product name of product to be added (nonC2 product)'
String productSearch1 = requestObject[GlobalVariable.Environment].TC_R_079.productSearchByNDC1
String productSearch2 = requestObject[GlobalVariable.Environment].TC_R_079.productSearchByNDC2
String productSearch3 = requestObject[GlobalVariable.Environment].TC_R_079.productSearchByNDC3
String productSearch4 = requestObject[GlobalVariable.Environment].TC_R_079.productSearchByNDC4

'this function selects toggle value for the product to be added which can be ordering or price check)'
CustomKeywords.'androidOrders.orderDetailsScreen.selectToggleValueForTheProductToBeSearched'(toggleValue)

'scans the product'
CustomKeywords.'androidOrders.orderDetailsScreen.scanInputEventWithoutVerification'(productSearch2)

'this function adds the quantity for the product to be searched'
CustomKeywords.'androidOrders.orderDetailsScreen.addQuantityforTheSearchedProduct'(quantity)

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'taps on scan icon and takes user to scanning product screen '
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnScanIconWithoutVerification'()

'scans the product'
CustomKeywords.'androidOrders.orderDetailsScreen.scanInputEventWithoutVerification'(productSearch3)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'taps on scan icon and takes user to scanning product screen '
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnScanIconWithoutVerification'()

'scans the product'
CustomKeywords.'androidOrders.orderDetailsScreen.scanInputEventWithoutVerification'(productSearch4)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'returns the order name of the order which is at the top of the order list'
String orderName=CustomKeywords.'androidOrders.cartScreen.returnTopMostOrderName'()

'opens the order details page'
CustomKeywords.'androidOrders.cartScreen.openAnOrderDetail'(orderName)

'clicks on place order button'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnPlaceOrder'()

'clicks on place order button'
CustomKeywords.'androidOrders.orderDetailsScreen.confirmPlaceOrder'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'takes user back to cart screen and verifies user is on the cart screen or not'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnBackToCart'()

'----------------scan A product in ordering toggle and go to offline mode-------------'

'clicks on scan icon and also verifies that the default scan toggle value is at ordering'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnScanIconWithoutVerification'()

'selects toggle value for the product to be added which can be ordering or price check'
CustomKeywords.'androidOrders.orderDetailsScreen.selectToggleValueForTheProductToBeSearched'(toggleValue)

'takes productSearch which can be productName/Cin/UPC/NDC as the input and adds it to the order by scanning the product'
CustomKeywords.'androidOrders.orderDetailsScreen.scanInputEventWithoutVerification'(productSearch1)

String NDCLabelOnlineMode = CustomKeywords.'androidOrders.orderDetailsScreen.returnNDCLabelOfScannedProduct'()

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'longpress account icon to turns on airplane mode'
CustomKeywords.'androidCommonKeywords.emergencyOrderingMode.enableOrDisableEOmode'()

'Close the popup'
CustomKeywords.'androidCommonKeywords.emergencyOrderingMode.CloseFlyout'()


'---------------scan same A product in price check toggle in offline mode--------------'

'clicks on scan icon and also verifies that the default scan toggle value is at ordering'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnScanIconWithoutVerification'()

'selects toggle value for the product to be added which can be ordering or price check'
CustomKeywords.'androidOrders.orderDetailsScreen.selectToggleValueForTheProductToBeSearched'(toggleValue1)

'takes productSearch which can be productName/Cin/UPC/NDC as the input and adds it to the order by scanning the product'
CustomKeywords.'androidOrders.orderDetailsScreen.scanInputEventWithoutVerification'(productSearch1)

'retruns NDC number'
String NDCLabelOfflineModePriceCheck = CustomKeywords.'androidOrders.orderDetailsScreen.returnNDCLabelOfScannedProduct'()

'assertion funaction called to verify expected and actual ndc number'
assert NDCLabelOnlineMode == NDCLabelOfflineModePriceCheck

'adds product'
CustomKeywords.'androidOrders.orderDetailsScreen.tapOnAddToOrderInScanSearchResults'()

'taps on go to order button on order confirmation screen and takes user to order details screen'
CustomKeywords.'androidOrders.orderDetailsScreen.tapOnGoToOrder'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'verifies order details screen when user in offline mode'
CustomKeywords.'androidOrders.orderDetailsScreen.verifyOrderDetailsScreenInOfflineMode'()

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.pressBacknav'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'---------------scan same A product in ordering toggle in offline mode--------------'

'clicks on scan icon and also verifies that the default scan toggle value is at ordering'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnScanIconWithoutVerification'()

'selects toggle value for the product to be added which can be ordering or price check'
CustomKeywords.'androidOrders.orderDetailsScreen.selectToggleValueForTheProductToBeSearched'(toggleValue)

'takes productSearch which can be productName/Cin/UPC/NDC as the input and adds it to the order by scanning the product'
CustomKeywords.'androidOrders.orderDetailsScreen.scanInputEventWithoutVerification'(productSearch1)

String NDCLabelOfflineModeOrdering = CustomKeywords.'androidOrders.orderDetailsScreen.returnNDCLabelOfScannedProduct'()

'assertion funaction called to verify expected and actual ndc number'
assert NDCLabelOnlineMode == NDCLabelOfflineModeOrdering

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'------------------------using prerequisite---------------------------'

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'longpress account icon to turns on airplane mode'
CustomKeywords.'androidCommonKeywords.emergencyOrderingMode.enableOrDisableEOmode'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'opens orders tab where user can perform actions related to orders'
CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnHomeTab'()

'opens orders tab where user can perform actions related to orders'
CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnOrders'()

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'clicks on history tab button to open history tab in order history screen'
CustomKeywords.'androidOrders.historyScreen.clickOnHistoryTab'()

'returns po number of an top most order '
String poNumber = CustomKeywords.'androidOrders.historyScreen.returnTopMostPoNumberOfAnOrder'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'opens top most order in order history'
CustomKeywords.'androidOrders.historyScreen.tapOnTopMostOrderHistory'(poNumber)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.pressBacknav'()

'longpress account icon to turns on airplane mode'
CustomKeywords.'androidCommonKeywords.emergencyOrderingMode.enableOrDisableEOmode'()

'Close the popup'
CustomKeywords.'androidCommonKeywords.emergencyOrderingMode.CloseFlyout'()

'taps on scan icon and takes user to scanning product screen'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnScanIconWithoutVerification'()

'takes productSearch which can be productName/Cin/UPC/NDC as the input and adds it to the order by scanning the product'
CustomKeywords.'androidOrders.orderDetailsScreen.scanInputEventInOfflineMode'(productSearch2)

'returns quantity added'
String actualQuantityAdded = CustomKeywords.'androidOrders.historyScreen.returnQuantityForScannedResultInOfflineMode'()

'assertion funaction called to verify expected and actual quantity added'
assert actualQuantityAdded == expectedQuantityAdded

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'taps on scan icon and takes user to scanning product screen'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnScanIconWithoutVerification'()

'scans the product in offline mode'
CustomKeywords.'androidOrders.orderDetailsScreen.scanInputEventInOfflineMode'(productSearch3)

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'taps on scan icon and takes user to scanning product screen'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnScanIconWithoutVerification'()

'scans the product in offline mode'
CustomKeywords.'androidOrders.orderDetailsScreen.scanInputEventInOfflineMode'(productSearch4)

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

