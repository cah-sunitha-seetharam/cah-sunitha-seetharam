package ios_inventory
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile


class Inventory_details_Screen extends Inventory_listing_Screen {

	@Keyword
	def add_Location(String Location_Name, String CostType) {

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/Add location_Text'), 0)

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/LocationName_TextField'), 0)

		Mobile.setText(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/LocationName_TextField'), Location_Name, 0)

		if (CostType == 'Last Price') {
			Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/Last Price_Button'), 0)
		} else {
			Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/Current Price_Button'), 0)
		}

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/Create New Location_Text'), 0)

		int w = 1

		while (Mobile.verifyElementExist(findTestObject('iOS/Product_Search/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}

		Mobile.verifyElementExist(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/LocationName Verification_Text', [('LName') : Location_Name]),0)
	}




	@Keyword
	def click_On_Location(String Location_Name) {

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/Tap On Location_Text', [('Location') : Location_Name]), 0)
	}




	@Keyword
	def delete_Location(String Location_Name) {

		Mobile.tap(findTestObject('iOS/Inventory/Location Details_Screen/Delete_Location/Slide_PopUp_Button for Location Deletion'), 0)

		Mobile.tap(findTestObject('iOS/Inventory/Location Details_Screen/Delete_Location/Delete Location_Text'), 0)

		Mobile.tap(findTestObject('iOS/Inventory/Location Details_Screen/Delete_Location/Yes_Text'), 0)

		Mobile.verifyElementNotVisible(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/LocationName Verification_Text', [('LName') : Location_Name]),0)
	}




	@Keyword
	def edit_InventoryName(String New_Inventory_Name) {

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Edit Inventory/Edit Inventory_Text'), 0)

		Mobile.clearText(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/LocationName_TextField'), 0)

		Mobile.setText(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/LocationName_TextField'), New_Inventory_Name, 0)

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Edit Inventory/Save Changes_Text'), 0)
		int w = 1

		while (Mobile.verifyElementExist(findTestObject('iOS/Product_Search/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}
	}



	@Keyword

	def search_And_Add_Product_By_Creating_New_Location(String Location_Name, String Product_Name,String CostType) {

		int w = 1

		while (Mobile.verifyElementExist(findTestObject('iOS/Product_Search/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}
		Mobile.tapAndHold(findTestObject('iOS/Inventory/Location Details_Screen/Add Product to Location/Product SearchField'), 0, 0)

		while (Mobile.verifyElementExist(findTestObject('iOS/Product_Search/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}
		Mobile.setText(findTestObject('iOS/Inventory/Location Details_Screen/Add Product to Location/Product SearchField'), Product_Name, 0)

		Mobile.tapAndHold(findTestObject('iOS/Product_Search/Search Key_Button'), 0, 0)

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Product to Inventory using Search from Dashoboard/Add Product to Inventory_Text'), 0)

		Mobile.tap(findTestObject('iOS/Inventory/Location Details_Screen/Add Product to Location/Product_Generic_Action_Create_Location_Label'), 0)

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/LocationName_TextField'), 0)

		Mobile.setText(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/LocationName_TextField'), Location_Name, 0)

		if (CostType == 'Last Price') {
			Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/Last Price_Button'), 0)
		} else {
			Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/Current Price_Button'), 0)
		}

		Mobile.tapAndHold(findTestObject('iOS/Product_Search/Done Keypad_Text'), 0, 0)

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/Create New Location_Text'), 0)

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/Tap On Location_Text',[('Location'):Location_Name]), 0)

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Product to Inventory using Search from Dashoboard/Add Product to Inventory_Text'), 0)

		Mobile.tap(findTestObject('iOS/Inventory/Location Details_Screen/Copy Product from Location/Go to Location after Move or Copy or Adding Product_Text',[('Location'):Location_Name]), 0)
	}





	@Keyword
	def verify_Inventory_Details_Screen(String Inventory_Name) {

		Mobile.verifyElementExist(findTestObject('iOS/Inventory/Inventory Details Screen/Verification Details/Created on Date_Text'),0)

		Mobile.verifyElementExist(findTestObject('iOS/Inventory/Inventory Details Screen/Verification Details/Inventory Header_Label'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Inventory/Inventory Details Screen/Verification Details/Inventory Value_Text'),0)

		Mobile.verifyElementExist(findTestObject('iOS/Product_Search/Scan_Icon'),0)

		Mobile.verifyElementExist(findTestObject('iOS/Inventory/Inventory Details Screen/Verification Details/Location_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Inventory/Inventory Details Screen/Verification Details/Inventory Title_Label',[('TEXT'):Inventory_Name]),0)
	}
}