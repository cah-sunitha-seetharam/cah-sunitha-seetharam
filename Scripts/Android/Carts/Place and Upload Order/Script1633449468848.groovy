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

CustomKeywords.'android_common_keywords.start_application.Custom'()

CustomKeywords.'android_login.Login_Screen.login'(Password)

CustomKeywords.'android_account_selection_screen.Select_An_Account.Custom'(Account)

CustomKeywords.'android_dashboard.Dashboard_details_Screen.click_On_Orders'()

CustomKeywords.'android_orders.Orders_Screen.click_On_NewOrder'()

CustomKeywords.'android_orders.New_Order_Screen.enter_Purchase_Order_Details'(PO_Name, PO_Memo)

CustomKeywords.'android_orders.New_Order_Screen.create_Order'()

CustomKeywords.'android_orders.Order_details_Screen.add_Product_to_Order'(Product_Name, quantity)

Mobile.pressBack()

CustomKeywords.'android_orders.Order_details_Screen.upload_Order'()

