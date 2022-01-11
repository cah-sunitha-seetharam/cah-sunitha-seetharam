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

'waits for 10(s) before refreshing the page to get the updated historyCount'
WebUI.delay(10)

'clicks on more options tab is dashboard'
CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnMoreOptionsTab'()

'enables csos beta feature in the account selected'
CustomKeywords.'androidMoreOptions.moreOptionsScreen.enableBetaFeatureCSOS'()

'opens the cart page'
CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnOrders'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'takes user to the new order screen'
CustomKeywords.'androidOrders.ordersCommonScreen.clickOnNewOrder'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'verifies new order screen'
CustomKeywords.'androidOrders.newOrderScreen.verifyNewOrderScreenDetails'()

'clicks on create order to create an order'
CustomKeywords.'androidOrders.newOrderScreen.createOrder'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'reading the module test data file'
def requestObject = CustomKeywords.'common.commonMethods.readFileTypeJSON'('csosData.json')

'reading the product name of product to be added (C2 product)'
String productSearch = requestObject[GlobalVariable.Environment].TC_R_072.productSearchCin

'adds product to the order by taking product and quanity as the argument'
CustomKeywords.'androidOrders.orderDetailsScreen.addProductToOrder'(productSearch, quantity)

'click on continue ordering button'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnContinueOrdering'()

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'opens the c2 orders tab'
CustomKeywords.'androidOrders.cartScreen.clickOnC2OrdersTab'()

'opens c2 order details'
CustomKeywords.'androidOrders.cartScreen.openC2OrderDetails'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'this function returns the poName of the order which is at the top of the C2 order list'
String poNumber = CustomKeywords.'androidOrders.orderDetailsScreen.returnOrderNameFromOrderDetailScreen'()

'clicks on place order'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnPlaceOrder'()

'Confirm on place order'
CustomKeywords.'androidOrders.orderDetailsScreen.confirmPlaceOrder'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

// Below steps are blocked due to UTN textbox is not accesible after clearing the value

/*

'enter invalid utn numbers and validate the error message'
CustomKeywords.'androidOrders.orderDetailsScreen.utnNumberValidation'(utnPrefixLength,expectedErrorMsg,input1,input2)

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.pressBacknav'()

'clicks on place order'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnPlaceOrder'()

'Confirm on place order'
CustomKeywords.'androidOrders.orderDetailsScreen.confirmPlaceOrder'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'enter duplicate utn numbers and validate the error message'
CustomKeywords.'androidOrders.orderDetailsScreen.enterDuplicateUTN'(existingUTNno,duplicateErrorMsg)

'click on save for later button'
CustomKeywords.'androidOrders.orderDetailsScreen.saveForLater'()

*/



