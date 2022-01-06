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

'opens cart page'
CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnOrders'()

'--------------------------c2 order--------------------------'

'takes user to the new order screen'
CustomKeywords.'androidOrders.ordersCommonScreen.clickOnNewOrder'()

'verifies new order screen'
CustomKeywords.'androidOrders.newOrderScreen.verifyNewOrderScreenAccount'()

'take user to new order screen to enter order details'
CustomKeywords.'androidOrders.newOrderScreen.enterPurchaseOrderDetails'(poName, poMemo)

'clicks on create order to create an order'
CustomKeywords.'androidOrders.newOrderScreen.createOrder'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'clicks on scan icon and also verifies that the default scan toggle value is at ordering'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnScanIcon'()

'reading the module test data file'
def requestObject = CustomKeywords.'common.commonMethods.readFileTypeJSON'('ordersData.json')

'reading the product name of product to be added (C2 product)'
String productSearchCin= requestObject[GlobalVariable.Environment].TC_R_045.productSearchCin

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'takes productSearch which can be productName/Cin/UPC/NDC as the input and adds it to the order by scanning the product'
CustomKeywords.'androidOrders.orderDetailsScreen.scanInputEvent'(productSearchCin)

'adds quantity of the product'
CustomKeywords.'androidOrders.orderDetailsScreen.addQuantityforTheSearchedProduct'(quantity)

'verifies quantity updated caption'
CustomKeywords.'androidOrders.orderDetailsScreen.verifyQuantityUpdatedCaption'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'returns the quantity which has been added for the product searched'
actualQuantityAdded = CustomKeywords.'androidOrders.orderDetailsScreen.returnQuantityOfTheAddedProduct'()

'verifies wheather actual quantity added equals the expected quantity'
assert actualQuantityAdded == expectedQuantity

'verifies the order value after adding a product'
CustomKeywords.'androidOrders.orderDetailsScreen.verifyOrderValue'(expectedQuantity)

'verifies Total line count in order name page'
CustomKeywords.'androidOrders.orderDetailsScreen.verifyLineCountOfOrderNamePage'(lineCountOfOrderName)

'verifies c2 label is visible or not'
CustomKeywords.'androidOrders.orderDetailsScreen.verifyC2Label'()

'verifies order name header label'
CustomKeywords.'androidOrders.orderDetailsScreen.verifyOrderNameHeaderLabel'(poName)

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'opens the c2 order tab'
CustomKeywords.'androidOrders.cartScreen.clickOnC2OrdersTab'()

'takes totalLineCount count as the argument and verifies the same'
CustomKeywords.'androidOrders.cartScreen.verifyTotalLineCount'(totalLineCount)

'takes c2LineCount count as the argument and verifies the same'
CustomKeywords.'androidOrders.cartScreen.verifyLineCountofC2OrNonC2Product'(c2LineCount)

'takes expectedAnnotationCount count as the argument and verifies the same'
CustomKeywords.'androidOrders.cartScreen.verifyC2AnnotationCount'(expectedAnnotationCount)

'opens c2 order details'
CustomKeywords.'androidOrders.cartScreen.openAnOrderDetail'(poName)

'verifies the order value after adding a product'
CustomKeywords.'androidOrders.orderDetailsScreen.verifyOrderValue'(expectedQuantity)

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'takes user to the dashboard screen'
CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnHomeTab'()

'-----------------------nonc2 order------------------------'

'reading the product name of product to be added (nonC2 product)'
String productSearchByNDC = requestObject[GlobalVariable.Environment].TC_R_045.productSearchByNDC

'clicks on scan icon and also verifies that the default scan toggle value is at ordering'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnScanIcon'()

'selects toggle value which can be ordering or price check'
CustomKeywords.'androidOrders.orderDetailsScreen.selectToggleValueForTheProductToBeSearched'(toggleValue)

'takes productSearch which can be productName/Cin/UPC/NDC as the input and adds it to the order by scanning the product'
CustomKeywords.'androidOrders.orderDetailsScreen.scanInputEvent'(productSearchByNDC)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'opens cart page'
CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnOrders'()

'takes nonc2LineCount count as the argument and verifies the same'
CustomKeywords.'androidOrders.cartScreen.verifyLineCountofC2OrNonC2Product'(nonc2LineCount)

'takes expectedAnnotationCount count as the argument and verifies the same'
CustomKeywords.'androidOrders.cartScreen.verifynonC2AnnotationCount'(expectedAnnotationCount)

'this function returns the order name of the order which is at the top of the order list'
String orderName = CustomKeywords.'androidOrders.cartScreen.returnTopMostOrderName'()

'this function verifies the pattern required for the order which was created without giving any purchase order name'
CustomKeywords.'androidOrders.cartScreen.verifyOrderNamePattern'(orderName)

'opens order details and takes order name as the argument'
CustomKeywords.'androidOrders.cartScreen.openAnOrderDetail'(orderName)

'-------------------------upload order non c2----------------------------'

'uploads the order by clicking on upload order button'
CustomKeywords.'androidOrders.orderDetailsScreen.uploadOrder'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'verifies the pop up screen which appears after user clicks on upload order'
CustomKeywords.'androidOrders.orderDetailsScreen.verifyUploadOrderPopUp'()

'opens order has been sent to desktop popup'
CustomKeywords.'androidOrders.cartScreen.clickOnContinueOnDesktop'()

'verifies order has been sent to desktop popup'
CustomKeywords.'androidOrders.orderDetailsScreen.verifyOrderHasbeensentToDesktopPopUp'()

'takes user back to cart screen'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnBackToCart'()

'verifies cart screen without non c2 orders'
CustomKeywords.'androidOrders.cartScreen.verifyCartScreenWithOutNonC2Orders'()

'opens the c2 order tab'
CustomKeywords.'androidOrders.cartScreen.clickOnC2OrdersTab'()

'takes c2LineCount count as the argument and verifies the same'
CustomKeywords.'androidOrders.cartScreen.verifyLineCountofC2OrNonC2Product'(c2LineCount)

'takes expectedAnnotationCount count as the argument and verifies the same'
CustomKeywords.'androidOrders.cartScreen.verifyC2AnnotationCount'(expectedAnnotationCount)

'---------------deletes order------------------'

'opens the c2 orders tab'
CustomKeywords.'androidOrders.cartScreen.clickOnC2OrdersTab'()

'deletes order'
CustomKeywords.'androidOrders.cartScreen.deleteOrder'()