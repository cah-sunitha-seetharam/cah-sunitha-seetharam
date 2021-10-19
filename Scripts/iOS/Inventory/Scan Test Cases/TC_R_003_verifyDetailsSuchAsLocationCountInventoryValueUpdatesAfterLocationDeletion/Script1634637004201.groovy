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

CustomKeywords.'ios_common_keywords.Start_Application.custom'()

CustomKeywords.'ios_login.Login_Screen.login'(GlobalVariable.Username, GlobalVariable.Password)

CustomKeywords.'ios_account_selection.Select_An_Account.Custom'(GlobalVariable.Account)

CustomKeywords.'ios_dashboard.dashboard_details.click_On_More_Options'()

CustomKeywords.'ios_more_options_screen.Go_To_Inventory_Listing_Screen.Custom'()

'output of random string generator is stored in inventoryName which will be passed into create_Inventory function'
inventoryName = CustomKeywords.'common.commonMethods.randomStringGenerator'(inventoryNameLength)

CustomKeywords.'ios_inventory.Inventory_listing_Screen.create_Inventory'(inventoryName)

'ouput of random string generator is stored in locationName which will be passed into add_Location function\n'
locationName = CustomKeywords.'common.commonMethods.randomStringGenerator'(locationNameLength)

CustomKeywords.'ios_inventory.Inventory_details_Screen.add_Location'(locationName, costType)

CustomKeywords.'ios_inventory.Inventory_details_Screen.click_On_Location'(locationName)

def requestObject = CustomKeywords.'common.commonMethods.readFileTypeJSON'('cartsData.json') // reading the module test data file 
	
String productSearch = requestObject[GlobalVariable.Environment].TC_R_003.productSearchCin //reading the cin of product to be added

CustomKeywords.'ios_inventory.Location_details_Screen.click_On_ScanIcon_And_Add_Product'(productSearch, countType, quantity)

CustomKeywords.'ios_common_keywords.Go_Back.Custom'()

CustomKeywords.'ios_common_keywords.Go_Back.Custom'()

CustomKeywords.'ios_inventory.Inventory_details_Screen.delete_Location_With_Cost_LocationCount_Verification'(locationName)

CustomKeywords.'ios_inventory.Inventory_listing_Screen.delete_Inventory'(inventoryName)

