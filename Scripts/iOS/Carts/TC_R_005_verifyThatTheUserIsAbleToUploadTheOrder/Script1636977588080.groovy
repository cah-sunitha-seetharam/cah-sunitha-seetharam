import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.builtin.CloseApplicationKeyword as CloseApplicationKeyword
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

'login function called which takes user to the accounts selection screen'
CustomKeywords.'iosLogin.loginScreen.login'(GlobalVariable.Username, GlobalVariable.Password)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'selects the user account from the accounts list'
CustomKeywords.'iosAccountSelection.selectAnAccount.selectTheUserAccount'(GlobalVariable.Account)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'takes user to the orders tab'
CustomKeywords.'iosDashboard.dashboardDetailsScreen.clickOnOrders'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'take user to new order screen to enter order details'
CustomKeywords.'iosOrders.ordersCommonScreen.clickOnNewOrder'()

'take user to new order screen to enter order details'
CustomKeywords.'iosOrders.newOrderScreen.enterPurchaseOrderDetails'(poName, poMemo)

'clicks on create order to create an order'
CustomKeywords.'iosOrders.newOrderScreen.createOrder'()

'clicks on create order to create an order'
CustomKeywords.'iosOrders.orderDetailsScreen.verifyOrderDetailsScreenWithoutAnyAddedProduct'(poName)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'reading the module test data file'
def requestObject = CustomKeywords.'common.commonMethods.readFileTypeJSON'('inventoryTestData.json')

'reading the product name of product to be added (nonC2 product)'
String productSearch = requestObject[GlobalVariable.Environment].TC_R_005.productSearchByName

'clicks on scan icon and also verifies that the default scan toggle value is at ordering'
CustomKeywords.'iosOrders.orderDetailsScreen.clickOnScanIcon'()

'takes productSearch which can be productName/Cin/UPC/NDC as the input and adds it to the order by scanning the product'
CustomKeywords.'iosOrders.orderDetailsScreen.scanInputEvent'(productSearch)

'adds the quantity required to be added for the scanned product'
CustomKeywords.'iosOrders.orderDetailsScreen.addQuantityforTheSearchedProduct'(quantity)

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'returns the quantity which has been added for the product searched'
actualQuantityAdded = CustomKeywords.'iosOrders.orderDetailsScreen.returnQuantityOfTheAddedProduct'()

'verifies whether actual quantity added equals the expected quantity'
assert actualQuantityAdded == expectedQuantity

'uploads the order by clicking on upload order button'
CustomKeywords.'iosOrders.orderDetailsScreen.uploadOrder'()

'verifies the pop up screen which appears after user clicks on upload order'
CustomKeywords.'iosOrders.orderDetailsScreen.verifyUploadOrderPopUp'()

'clicks on continue ordering to take user back to the search results to keep browsing'
CustomKeywords.'iosOrders.orderDetailsScreen.clickOnContinueOrderingOnDesktop'()

'takes user back to cart screen'
CustomKeywords.'iosOrders.orderDetailsScreen.clickOnBackToCart'()

'verifies that the order should not be visible on the screen and takes purchase order name as the argument'
CustomKeywords.'iosOrders.cartScreen.verifyOrderNotVisibleOnTheCartScreen'(poName)

