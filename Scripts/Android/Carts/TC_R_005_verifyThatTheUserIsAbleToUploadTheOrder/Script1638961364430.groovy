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

'selects environment'
CustomKeywords.'androidLogin.loginScreen.selectEnvironment'()

'logins with username password and then opens account selection page'
CustomKeywords.'androidLogin.loginScreen.login'(username, password)

'after login, verifies page caption and selects account'
CustomKeywords.'androidAccountSelection.selectAnAccount.selectTheUserAccount'(accountNo)

'opens cart page'
CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnOrders'()

'take user to new order screen to enter order details'
CustomKeywords.'androidOrders.ordersCommonScreen.clickOnNewOrder'()

'take user to new order screen to enter order details'
CustomKeywords.'androidOrders.newOrderScreen.enter_Purchase_Order_Details'(poName, poMemo)

'clicks on create order to create an order'
CustomKeywords.'androidOrders.newOrderScreen.createOrder'()

'verifies order details screen without any added product'
CustomKeywords.'androidOrders.orderDetailsScreen.verify_Order_Screen_Details_without_any_added_product'()

'clicks on scan icon and also verifies that the default scan toggle value is at ordering'
CustomKeywords.'androidOrders.orderDetailsScreen.clickOnScanIcon'()

'takes productSearch which can be productName/Cin/UPC/NDC as the input and adds it to the order by scanning the product'
CustomKeywords.'androidOrders.orderDetailsScreen.scanInputEvent'(productToBeSearched)

CustomKeywords.'androidOrders.orderDetailsScreen.addQuantityforTheSearchedProduct'(quantity)

WebUI.delay(3)

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'returns the quantity which has been added for the product searched'
actualQuantityAdded = CustomKeywords.'androidOrders.orderDetailsScreen.returnQuantityOfTheAddedProduct'()

'verifies whether actual quantity added equals the expected quantity'
assert actualQuantityAdded == expectedQuantity

'uploads the order by clicking on upload order button'
CustomKeywords.'androidOrders.orderDetailsScreen.uploadOrder'()



