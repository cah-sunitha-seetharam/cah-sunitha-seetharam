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
CustomKeywords.'androidCommonKeywords.commonMethods.installingAndlaunchingTheApplication'()

'logins with username password and then opens account selection page'
CustomKeywords.'androidLogin.loginScreen.login'(GlobalVariable.Username, GlobalVariable.Password)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'after login, verifies page caption and selects account'
CustomKeywords.'androidAccountSelection.selectAnAccount.selectTheUserAccount'(GlobalVariable.Account)
*/
/*'------------------------enables beta feature CSOS---------------------------'

CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnMoreOptions'()

CustomKeywords.'androidMoreOptions.moreOptionsScreen.enableBetaFeatureCSOS'()
*/
'----------------------accountNo_1(Non C2)---------------------------'

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'opens cart page'
CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnOrders'()

'takes expected mobile orders count as the argument and verifies the same'
CustomKeywords.'androidOrders.cartScreen.verifyMobileOrdersCount'(mobileOrderCount)

'clicks on scan icon and also verifies that the default scan toggle value is at ordering'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnScanIcon'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'reading the module test data file'
def requestObject = CustomKeywords.'common.commonMethods.readFileTypeJSON'('ordersData.json')

'reading the product name of product to be added (nonC2 product)'
String productSearch1 = requestObject[GlobalVariable.Environment].TC_R_051.productSearchByNDC1

'takes productSearch which can be productName/Cin/UPC/NDC as the input and adds it to the order by scanning the product'
CustomKeywords.'androidOrders.orderDetailsScreen.scanInputEvent'(productSearch1)

'adds quantity of the product'
CustomKeywords.'androidOrders.orderDetailsScreen.addQuantityforTheSearchedProduct'(quantity1)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'verifies nonC2 annotation count'
CustomKeywords.'androidOrders.cartScreen.verifynonC2AnnotationCount'(nonC2AnnotationCount)

'this function returns the order name of the order which is at the top of the order list'
String orderName_1 = CustomKeywords.'androidOrders.cartScreen.returnTopMostOrderName'()

'verifies the pattern required for the order which was created without giving any purchase order name'
CustomKeywords.'androidOrders.cartScreen.verifyOrderNamePattern'(orderName_1)

'---------------------accountNo_2(Non C2)----------------------'

'selects different account'
CustomKeywords.'androidOrders.newOrderScreen.changeAccount'(accountNo_2)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'clicks on scan icon and also verifies that the default scan toggle value is at ordering'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnScanIcon'()

'this function selects toggle value for the product to be added which can be ordering or price check'
CustomKeywords.'androidOrders.orderDetailsScreen.selectToggleValueForTheProductToBeSearched'(toggleValue)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'reading the product name of product to be added (nonC2 product)'
String productSearch2 = requestObject[GlobalVariable.Environment].TC_R_051.productSearchByNDC2

'scans the product while on price check, adds it to the order and also verifies some scan input details'
CustomKeywords.'androidOrders.orderDetailsScreen.scanInputEventWhileOnPriceCheck'(productSearch2)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'taps on add to order and shows confirmation pop up'
CustomKeywords.'androidOrders.orderDetailsScreen.tapOnAddToOrderInScanSearchResults'()

'after selecting add to order verifies item added confirmation popup in scan search results'
CustomKeywords.'androidOrders.orderDetailsScreen.verifyConfirmationPopUpInScanSearchResults'()

'takes user to the order details'
CustomKeywords.'androidOrders.orderDetailsScreen.tapOnGoToOrder'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'verifies the order value after adding a product'
CustomKeywords.'androidOrders.orderDetailsScreen.verifyOrderValue'(expectedQuantity1)

'takes expected lines count as the argument and verifies the same'
CustomKeywords.'androidOrders.orderDetailsScreen.verifyLineCountOfOrderNamePage'(lineCountOfOrderNamePage)

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'takes expected lines count as the argument and verifies the same'
CustomKeywords.'androidOrders.cartScreen.verifynonC2AnnotationCount'(nonC2AnnotationCount)

'--------------------------switch back to accountNo_1-------------------------'

'change account using account selection icon'
CustomKeywords.'androidOrders.newOrderScreen.changeAccount'(accountNo_1)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'verifies nonC2 annotation count'
CustomKeywords.'androidOrders.cartScreen.verifynonC2AnnotationCount'(nonC2AnnotationCount)

'verifies the pattern required for the order which was created without giving any purchase order name'
CustomKeywords.'androidOrders.cartScreen.verifyOrderNamePattern'(orderName_1)

'opens an order from cart screen with order name which was created in the 1st account selection'
CustomKeywords.'androidOrders.cartScreen.openAnOrderDetail'(orderName_1)

Mobile.pressBack()

'verifies nonC2 annotation count'
CustomKeywords.'androidOrders.cartScreen.verifynonC2AnnotationCount'(nonC2AnnotationCount)

'--------------------------accountNo_3(NonC2)------------------------------'

'selects different account'
CustomKeywords.'androidOrders.newOrderScreen.changeAccount'(accountNo_3)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'clicks on scan icon and also verifies that the default scan toggle value is at ordering'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnScanIcon'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'takes productSearch which can be productName/Cin/UPC/NDC as the input and adds it to the order by scanning the product'
CustomKeywords.'androidOrders.orderDetailsScreen.selectToggleValueForTheProductToBeSearched'(toggleValue)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'reading the product name of product to be added (nonC2 product)'
String productSearch3 = requestObject[GlobalVariable.Environment].TC_R_051.productSearchByNDC3

'scans the product while on price check, adds it to the order and also verifies some scan input details'
CustomKeywords.'androidOrders.orderDetailsScreen.scanInputEventWhileOnPriceCheck'(productSearch3)

'adds quantity of the product'
CustomKeywords.'androidOrders.orderDetailsScreen.addQuantityforTheSearchedProduct'(quantity2)

'taps on add to order and shows confirmation pop up'
CustomKeywords.'androidOrders.orderDetailsScreen.tapOnAddToOrderInScanSearchResults'()

'takes user back to the search product results to continue browsing'
CustomKeywords.'androidOrders.orderDetailsScreen.tapOnContinueBrowsing'()

'verifies the previous scanned product'
CustomKeywords.'androidOrders.orderDetailsScreen.verifyProductAfterSearch'()

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'verifies nonC2 annotation count'
CustomKeywords.'androidOrders.cartScreen.verifynonC2AnnotationCount'(nonC2AnnotationCount)

'this function returns the order name of the order which is at the top of the order list'
String orderName_3 = CustomKeywords.'androidOrders.cartScreen.returnTopMostOrderName'()

'verifies the pattern required for the order which was created without giving any purchase order name'
CustomKeywords.'androidOrders.cartScreen.verifyOrderNamePattern'(orderName_3)

'opens the order details page'
CustomKeywords.'androidOrders.cartScreen.openAnOrderDetail'(orderName_3)

'verifies the order value after adding a product'
CustomKeywords.'androidOrders.orderDetailsScreen.verifyOrderValue'(expectedQuantity2)

'takes expected lines count as the argument and verifies the same'
CustomKeywords.'androidOrders.orderDetailsScreen.verifyLineCountOfOrderNamePage'(lineCountOfOrderNamePage)

'-------------------------delete orders in all 3 accounts----------------------'

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'change account using account selection icon'
CustomKeywords.'androidOrders.newOrderScreen.changeAccount'(GlobalVariable.Account)

'deletes order'
CustomKeywords.'androidOrders.cartScreen.deleteOrder'(orderName_1)

'change account using account selection icon'
CustomKeywords.'androidOrders.newOrderScreen.changeAccount'(accountNo_2)

'this function returns the order name of the order which is at the top of the order list'
orderName_2 = CustomKeywords.'androidOrders.cartScreen.returnTopMostOrderName'()

'deletes order'
CustomKeywords.'androidOrders.cartScreen.deleteOrder'(orderName_2)

'change account using account selection icon'
CustomKeywords.'androidOrders.newOrderScreen.changeAccount'(accountNo_3)

'deletes order'
CustomKeywords.'androidOrders.cartScreen.deleteOrder'(orderName_3)

