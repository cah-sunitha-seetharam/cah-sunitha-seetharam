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

//'starts the application'
//CustomKeywords.'androidCommonKeywords.commonMethods.installingAndlaunchingTheApplication'()
//
//'login function called which takes user to the accounts selection screen'
//CustomKeywords.'androidLogin.loginScreen.login'(GlobalVariable.Username, GlobalVariable.Password)
//
//'selects the user account from the accounts list'
//CustomKeywords.'androidAccountSelection.selectAnAccount.selectTheUserAccount'(GlobalVariable.Account)

//'waits until the progressBar is visible on the screen'
//CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()
//
//
//'------------------------------------C2Order--------------------------------------'
//'clicks on more options tab is dashboard'
//CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnMoreOptionsTab'()
//
//'enables csos beta feature in the account selected'
//CustomKeywords.'androidMoreOptions.moreOptionsScreen.enableBetaFeatureCSOS'()

'opens cart page'
CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnOrders'()

'opens the c2 orders tab'
CustomKeywords.'androidOrders.cartScreen.clickOnC2OrdersTab'()

'takes user to the new order screen'
CustomKeywords.'androidOrders.ordersCommonScreen.clickOnNewOrder'()

'take user to new order screen to enter order details'
CustomKeywords.'androidOrders.newOrderScreen.enterPurchaseOrderDetails'(poName1, poMemo1)

'clicks on create order to create an order'
CustomKeywords.'androidOrders.newOrderScreen.createOrder'()

'verifies order details screen without any added product'
CustomKeywords.'androidOrders.orderDetailsScreen.verifyOrderScreenDetailsWithoutAnyAddedProduct'()

'clicks on scan icon and also verifies that the default scan toggle value is at ordering'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnScanIcon'()

'reading the module test data file'
requestObject = CustomKeywords.'common.commonMethods.readFileTypeJSON'('csosData.json')

'reading the product name of product to be added (C2 product)'
productSearchC2 = requestObject[GlobalVariable.Environment].TC_EX_003.productSearchCin

'adds quantity of the product'
CustomKeywords.'androidOrders.orderDetailsScreen.addProductToOrder'(productSearchC2,quantity)

'Click on Continue Odering button'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnContinueOrdering'()

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.pressBacknav'()

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()


'---------------------------FirstNonC2Order---------------------------------------'
'opens the nonc2 orders tab'
CustomKeywords.'androidOrders.cartScreen.clickOnNonC2OrdersTab'()

'takes user to the new order screen'
CustomKeywords.'androidOrders.ordersCommonScreen.clickOnNewOrder'()

'take user to new order screen to enter order details'
CustomKeywords.'androidOrders.newOrderScreen.enterPurchaseOrderDetails'(poName2, poMemo2)

'clicks on create order to create an order'
CustomKeywords.'androidOrders.newOrderScreen.createOrder'()

'verifies order details screen without any added product'
CustomKeywords.'androidOrders.orderDetailsScreen.verifyOrderScreenDetailsWithoutAnyAddedProduct'()

'clicks on scan icon and also verifies that the default scan toggle value is at ordering'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnScanIcon'()

'reading the module test data file'
requestObject = CustomKeywords.'common.commonMethods.readFileTypeJSON'('ordersData.json')

'reading the product name of product to be added'
productSearch = requestObject[GlobalVariable.Environment].TC_EX_003.productSearchByNDC1

'adds quantity of the product'
CustomKeywords.'androidOrders.orderDetailsScreen.addProductToOrder'(productSearch,quantity)

'Click on Continue Odering button'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnContinueOrdering'()

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.pressBacknav'()

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'---------------------------SecondNonC2Order---------------------------------------'

'takes user to the new order screen'
CustomKeywords.'androidOrders.ordersCommonScreen.clickOnNewOrder'()

'take user to new order screen to enter order details'
CustomKeywords.'androidOrders.newOrderScreen.enterPurchaseOrderDetails'(poName3, poMemo3)

'clicks on create order to create an order'
CustomKeywords.'androidOrders.newOrderScreen.createOrder'()

'verifies order details screen without any added product'
CustomKeywords.'androidOrders.orderDetailsScreen.verifyOrderScreenDetailsWithoutAnyAddedProduct'()

'clicks on scan icon and also verifies that the default scan toggle value is at ordering'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnScanIcon'()

'reading the module test data file'
requestObject = CustomKeywords.'common.commonMethods.readFileTypeJSON'('ordersData.json')

'reading the product name of product to be added'
productSearch = requestObject[GlobalVariable.Environment].TC_EX_003.productSearchByNDC2

'adds quantity of the product'
CustomKeywords.'androidOrders.orderDetailsScreen.addProductToOrder'(productSearch,quantity)

'Click on Continue Odering button'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnContinueOrdering'()

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.pressBacknav'()

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()


'--------------------------------PlaceAllOder----------------------------------------'
'opens the nonc2 orders tab'
CustomKeywords.'androidOrders.cartScreen.clickOnNonC2OrdersTab'()

'places all the orders by clicking on place all orders button'
CustomKeywords.'androidOrders.cartScreen.clickOnPlaceAllOrders'()

'uploads the order by clicking on upload order button'
CustomKeywords.'androidOrders.cartScreen.verifyPlaceAllOrdersPopUp'()

'places all the orders by clicking on place all orders button'
CustomKeywords.'androidOrders.cartScreen.confirmPlacingAllOrders'()

'takes user back to cart screen'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnBackToCart'()

'opens the c2 orders tab'
CustomKeywords.'androidOrders.cartScreen.clickOnC2OrdersTab'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'verifies that the order should not be visible on the screen and takes purchase order name as the argument'
CustomKeywords.'androidOrders.cartScreen.verifyOrderVisibleOnTheCartScreen'(poName1)

