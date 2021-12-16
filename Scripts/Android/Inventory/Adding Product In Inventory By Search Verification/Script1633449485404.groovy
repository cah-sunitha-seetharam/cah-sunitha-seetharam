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

CustomKeywords.'android_dashboard.Dashboard_details_Screen.click_On_More_Options'()

CustomKeywords.'android_more_options_screen.Go_To_Inventory_Listing_Screen.Custom'()

CustomKeywords.'androidInventory.inventoryListingScreen.create_Inventory'(Inventory_Name)

CustomKeywords.'androidInventory.inventoryDetailsScreen.search_And_Add_Product_By_Creating_New_Location'(Location_1, 
    Product_1, Cost_Type)

Mobile.pressBack()

CustomKeywords.'androidInventory.inventoryDetailsScreen.add_Location'(Location_2, Cost_Type)

CustomKeywords.'androidInventory.inventoryDetailsScreen.click_On_Location'(Location_2)

CustomKeywords.'androidInventory.locationDetailsScreen.add_Product_To_Location'(Location_2, Product_1)

Mobile.pressBack()

CustomKeywords.'androidInventory.locationDetailsScreen.upload_Location'()

Mobile.pressBack()

Mobile.pressBack()

CustomKeywords.'androidInventory.inventoryListingScreen.delete_Inventory'(Inventory_Name)

