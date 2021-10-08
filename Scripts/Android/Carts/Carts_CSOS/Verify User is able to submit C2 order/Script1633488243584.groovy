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

CustomKeywords.'android_orders.Order_details_Screen.add_Product_to_Order'(Non_C2_Product, Quantity)

Mobile.pressBack()

Initial_Count = Mobile.getText(findTestObject('Android/Orders/CSOS/Count_TextView'), 0)

CustomKeywords.'android_orders.Cart_Screen.click_On_Order'(Account)

Mobile.pressBack()

CustomKeywords.'android_csos.Csos_flow.CSOS_Search_Product'(C2_Product, Quantity)

CustomKeywords.'android_csos.Csos_flow.Create_New_C2_Order'(C2_PO_Name, C2_PO_Memo)

CustomKeywords.'android_csos.Csos_flow.select_C2_Order_for_Adding_Product'(PO_Name)

Mobile.pressBack()

CustomKeywords.'android_csos.Csos_flow.Open_C2_Orders'()

CustomKeywords.'android_csos.Csos_flow.Place_C2_Order'()

CustomKeywords.'android_csos.Csos_flow.Check_C2_Availability'()

CustomKeywords.'android_csos.Csos_flow.Review_and_Sign_C2_Order'()

CustomKeywords.'android_csos.Csos_flow.Open_C2_Order_details_before_Signature'()

CustomKeywords.'android_csos.Csos_flow.Perform_Signature_and_Confirm_Order'(Signing_Password)

CustomKeywords.'android_csos.Csos_flow.Go_to_Order_History'()

CustomKeywords.'android_csos.Csos_flow.vertical_swipe_refresh'()

Final_Count = Mobile.getText(findTestObject('Android/Orders/CSOS/Count_TextView'), 0)

assert Initial_Count == (Final_Count + 1)

