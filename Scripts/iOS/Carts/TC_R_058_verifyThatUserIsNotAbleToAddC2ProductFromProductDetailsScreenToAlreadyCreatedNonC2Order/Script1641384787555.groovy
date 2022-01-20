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

'-----------------------Pre-requisite(Non C2 order)---------------------------'

'opens cart page'
CustomKeywords.'iosDashboard.dashboardScreen.clickOnOrders'()

'taps on scan icon and takes user to scanning product screen and also verifies ordering and price check'
CustomKeywords.'iosOrders.orderDetailsScreen.clickOnScanIcon'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'reading the module test data file'
def requestObject = CustomKeywords.'common.commonMethods.readFileTypeJSON'('ordersData.json')

'reading the product name of product to be added (nonC2 product)'
String productSearch = requestObject[GlobalVariable.Environment].TC_R_058.productSearchByNDC

'takes productSearch which can be productName/Cin/UPC/NDC as the input and adds it to the order by scanning the product'
CustomKeywords.'iosOrders.orderDetailsScreen.scanInputEvent'(productSearch)

'adds quantity of the product'
CustomKeywords.'iosOrders.orderDetailsScreen.addQuantityforTheSearchedProduct'(quantity1)

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
CustomKeywords.'iosLogin.loginScreen.enterPassword'(GlobalVariable.Password)

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

'this function returns the order name of the order which is at the top of the order list'
String orderName = CustomKeywords.'iosOrders.cartScreen.returnTopMostOrderName'()

'opens order details and takes order name as the argument'
CustomKeywords.'iosOrders.cartScreen.openAnOrderDetail'(orderName)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'reading the product name of product to be added (C2 product)'
String productSearchCin = requestObject[GlobalVariable.Environment].TC_R_058.productSearchCin

'searches for a product by setting product name'
CustomKeywords.'iosOrders.orderDetailsScreen.searchProductInOrderDetailPage'(productSearchCin)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'verifies the product after search'
CustomKeywords.'iosOrders.orderDetailsScreen.verifyProductAfterSearch'()

'this function returns the order name of the order which is at the top of the order list'
String productName = CustomKeywords.'iosOrders.orderDetailsScreen.returnProductNameAfterSearch'()

'opens product tile'
CustomKeywords.'iosOrders.orderDetailsScreen.clickOnProductTile'()

'verifies the product tile'
CustomKeywords.'iosOrders.orderDetailsScreen.verifyProductTile'()

'opens more details of product details'
CustomKeywords.'iosOrders.orderDetailsScreen.clickOnMoreDetails'()

'verifies the product details page'
CustomKeywords.'iosOrders.orderDetailsScreen.verifyProductDetailAfterSelectingMoreDetails'(productName)

'adds quantity of the product'
CustomKeywords.'iosOrders.orderDetailsScreen.addQuantityInProductDetailsPage'(quantity2)

'adds product in product details page'
CustomKeywords.'iosOrders.orderDetailsScreen.tapOnAddToOrderInProductDetailsPage'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'creates a new C2 order'
CustomKeywords.'iosOrders.orderDetailsScreen.createNewC2Order'(poName, poMemo)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'this function verifies the product tile'
CustomKeywords.'iosOrders.orderDetailsScreen.verifyProductTile'()

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'verifies order name header label'
CustomKeywords.'iosOrders.orderDetailsScreen.verifyOrderNameHeaderLabel'(orderName)

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'opens the c2 order tab'
CustomKeywords.'iosOrders.cartScreen.clickOnC2Orders'()

'uploads the order by clicking on upload order button'
CustomKeywords.'iosOrders.orderDetailsScreen.uploadC2Order'()

'opens order has been sent to desktop popup'
CustomKeywords.'iosOrders.cartScreen.continueOrdersOnTheDesktop'()

'takes user back to cart screen'
CustomKeywords.'iosOrders.orderDetailsScreen.clickOnBackToCart'()

'takes expectedAnnotationCount count as the argument and verifies the same'
CustomKeywords.'iosOrders.cartScreen.verifyLinesCount'(expectedLineCount)

CustomKeywords.'iosOrders.cartScreen.clickOnNonC2Orders'()

'opens order details and takes order name as the argument'
CustomKeywords.'iosOrders.cartScreen.openAnOrderDetail'(orderName)

'verifies c2 order is not visible under non c2 order'
CustomKeywords.'iosOrders.orderDetailsScreen.verifyC2OrderIsNotVisibleUnderNonC2Order'()

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'deletes order'
CustomKeywords.'iosOrders.cartScreen.deleteOrder'(orderName)
