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
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

/*'starts the application'
CustomKeywords.'androidCommonKeywords.commonMethods.installingAndlaunchingTheApplication'()

'logins with username password and then opens account selection page'
CustomKeywords.'androidLogin.loginScreen.login'(GlobalVariable.Username, GlobalVariable.Password)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'after login, verifies page caption and selects account'
CustomKeywords.'androidAccountSelection.selectAnAccount.selectTheUserAccount'(GlobalVariable.Account)
*/
'-----------------------Pre-requisite(Non C2 order)---------------------------'

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'opens cart page'
CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnOrders'()

'taps on scan icon and takes user to scanning product screen and also verifies ordering and price check'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnScanIcon'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'reading the module test data file'
def requestObject = CustomKeywords.'common.commonMethods.readFileTypeJSON'('ordersData.json')

'reading the product name of product to be added (C2 product)'
String productSearch = requestObject[GlobalVariable.Environment].TC_R_058.productSearchByNDC

'takes productSearch which can be productName/Cin/UPC/NDC as the input and adds it to the order by scanning the product'
CustomKeywords.'androidOrders.orderDetailsScreen.scanInputEvent'(productSearch)

'adds quantity of the product'
CustomKeywords.'androidOrders.orderDetailsScreen.addQuantityforTheSearchedProduct'(quantity1)

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'takes the application back to login page'
CustomKeywords.'androidMoreOptions.moreOptionsScreen.signOut'()

'-----------------------------------signIn---------------------------------------'

'enters password in login page'
CustomKeywords.'androidLogin.loginScreen.enterPassword'(GlobalVariable.Password)

'clicks on sign In button'
CustomKeywords.'androidLogin.loginScreen.clickOnSignInButton'()

'after login, verifies page caption and selects account'
CustomKeywords.'androidAccountSelection.selectAnAccount.selectTheUserAccount'(GlobalVariable.Account)

'------------------------enables beta feature CSOS---------------------------'

CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnMoreOptions'()

CustomKeywords.'androidMoreOptions.moreOptionsScreen.enableBetaFeatureCSOS'()

'------------------------------------------------------------------------------'

'opens cart page'
CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnOrders'()

'this function returns the order name of the order which is at the top of the order list'
String orderName = CustomKeywords.'androidOrders.cartScreen.returnTopMostOrderName'()

'opens order details and takes order name as the argument'
CustomKeywords.'androidOrders.cartScreen.openAnOrderDetail'(orderName)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'reading the product name of product to be added (C2 product)'
String productSearchCin = requestObject[GlobalVariable.Environment].TC_R_058.productSearchCin

'searches for a product by setting product name'
CustomKeywords.'androidOrders.orderDetailsScreen.searchProductInOrderDetailPage'(productSearchCin)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'verifies the product after search'
CustomKeywords.'androidOrders.orderDetailsScreen.verifyProductAfterSearch'()

'this function returns the order name of the order which is at the top of the order list'
String productName = CustomKeywords.'androidOrders.orderDetailsScreen.returnProductNameAfterSearch'()

'opens product tile'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnProductTile'()

'verifies the product tile'
CustomKeywords.'androidOrders.orderDetailsScreen.verifyProductTile'()

'opens more details of product details'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnMoreDetails'()

'verifies the product details page'
CustomKeywords.'androidOrders.orderDetailsScreen.verifyProductDetailAfterSelectingMoreDetails'(productName)

'adds quantity of the product'
CustomKeywords.'androidOrders.orderDetailsScreen.addQuantityInProductDetailsPage'(quantity2)

'adds product in product details page'
CustomKeywords.'androidOrders.orderDetailsScreen.tapOnAddToOrderInProductDetailsPage'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'creates a new C2 order'
CustomKeywords.'androidOrders.orderDetailsScreen.createNewOrderForC2'(poName, poMemo)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'enables radio button and adds c2 product'
CustomKeywords.'androidOrders.orderDetailsScreen.enableRadioButtonForNewOrderC2Creation'(poName)

'verifies confirmation pop up after adding c2 order'
CustomKeywords.'androidOrders.orderDetailsScreen.verifyConfirmationPopUpAfterAddingC2Order'()

'takes user back to the search product results to continue browsing'
CustomKeywords.'androidOrders.orderDetailsScreen.tapOnContinueBrowsing'()

'this function verifies the product tile'
CustomKeywords.'androidOrders.orderDetailsScreen.verifyProductTile'()

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'verifies order name header label'
CustomKeywords.'androidOrders.orderDetailsScreen.verifyOrderNameHeaderLabel'(orderName)

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'opens the c2 order tab'
CustomKeywords.'androidOrders.cartScreen.clickOnC2OrdersTab'()

'uploads the order by clicking on upload order button'
CustomKeywords.'androidOrders.orderDetailsScreen.uploadOrderC2'()

'verifies the pop up screen which appears after user clicks on upload order'
CustomKeywords.'androidOrders.orderDetailsScreen.verifyUploadOrderPopUp'()

'opens order has been sent to desktop popup'
CustomKeywords.'androidOrders.cartScreen.clickOnContinueOnDesktop'()

'verifies order has been sent to desktop popup'
CustomKeywords.'androidOrders.orderDetailsScreen.verifyOrderHasbeensentToDesktopPopUp'()

'takes user back to cart screen'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnBackToCart'()

'takes expectedAnnotationCount count as the argument and verifies the same'
CustomKeywords.'androidOrders.cartScreen.verifynonC2AnnotationCount'(expectedAnnotationCount)

'opens order details and takes order name as the argument'
CustomKeywords.'androidOrders.cartScreen.openAnOrderDetail'(orderName)

'verifies c2 order is not visible under non c2 order'
CustomKeywords.'androidOrders.orderDetailsScreen.verifyC2OrderIsNotVisibleUnderNonC2Order'()

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'deletes order'
CustomKeywords.'androidOrders.cartScreen.deleteOrder'(orderName)
