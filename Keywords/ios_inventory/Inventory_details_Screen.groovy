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


	/**
	 * adds location to an inventory based on the cost type of current or last price 
	 * @param locationName, costType
	 */
	@Keyword
	def add_Location(String locationName, String costType) {

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/Add location_Text'), 0)

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/LocationName_TextField'), 0)

		Mobile.setText(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/LocationName_TextField'), locationName, 0)

		if (costType == 'Last Price') {
			Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/Last Price_Button'), 0)
		} else {
			Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/Current Price_Button'), 0)
		}

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/Create New Location_Text'), 0)

		(new ios_common_keywords.wait_for_load()).waitForPageLoad()

		Mobile.verifyElementExist(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/LocationName Verification_Text', [('LName') : locationName]),0)
	}



	/**
	 * opens the particular location details
	 * @param locationName
	 */
	@Keyword
	def click_On_Location(String locationName) {

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/Tap On Location_Text', [('Location') : locationName]), 0)
	}



	/**
	 * deletes the location
	 * @param locationName
	 */
	@Keyword
	def delete_Location(String locationName) {

		int ElementTopPosition = Mobile.getElementTopPosition(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/Tap On Location_Text', [('Location') : locationName]), 0)

		int ElementHeight=Mobile.getElementHeight(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/Tap On Location_Text', [('Location') : locationName]), 0)

		int y_Coordinate=(ElementHeight/2)+ElementTopPosition

		int ElementLeftPosition=Mobile.getElementLeftPosition(findTestObject('iOS/Inventory/Location Details_Screen/Delete_Location/Slide_PopUp_Button for Location Deletion'), 0)

		int ElementWidth=Mobile.getElementWidth(findTestObject('iOS/Inventory/Location Details_Screen/Delete_Location/Slide_PopUp_Button for Location Deletion'), 0)

		int x_Coordinate=(ElementWidth/2)+ElementLeftPosition

		Mobile.tapAtPosition(x_Coordinate, y_Coordinate)

		Mobile.tap(findTestObject('iOS/Inventory/Location Details_Screen/Delete_Location/Delete Location_Text'), 0)

		Mobile.tap(findTestObject('iOS/Inventory/Location Details_Screen/Delete_Location/Yes_Text'), 0)

		(new ios_common_keywords.wait_for_load()).waitForPageLoad()

		Mobile.verifyElementNotVisible(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/LocationName Verification_Text', [('LName') : locationName]),0)
	}




	/**
	 * verifies the location count, cost gets updated or not of the inventory after the location is deleted
	 * @param locationName
	 */
	@Keyword
	def delete_Location_With_Cost_LocationCount_Verification(String locationName) {

		int initialInventoryLocationCount=Mobile.getText(findTestObject('iOS/Inventory/Location Details_Screen/Verification Details/inventoryLine_Text'), 0)

		String initialInventoryTotal=Mobile.getText(findTestObject('iOS/Inventory/Location Details_Screen/Verification Details/inventoryTotal_Text'), 0)

		String locationValue=Mobile.getText(findTestObject('iOS/Inventory/Location Details_Screen/Verification Details/locationValue_Text'), 0)

		int counter_1=0

		while(initialInventoryTotal[counter_1]!='0' && initialInventoryTotal[counter_1]!='1' && initialInventoryTotal[counter_1]!='2' && initialInventoryTotal[counter_1]!='3' && initialInventoryTotal[counter_1]!='4' && initialInventoryTotal[counter_1]!='5' && initialInventoryTotal[counter_1]!='6' && initialInventoryTotal[counter_1]!='7' && initialInventoryTotal[counter_1]!='8' && initialInventoryTotal[counter_1]!='9' ) {
			counter_1++
		}

		int counter_2=0

		while(locationValue[counter_2]!='0' && locationValue[counter_2]!='1' && locationValue[counter_2]!='2' && locationValue[counter_2]!='3' && locationValue[counter_2]!='4' && locationValue[counter_2]!='5' && locationValue[counter_2]!='6' && locationValue[counter_2]!='7' && locationValue[counter_2]!='8' && locationValue[counter_2]!='9' ) {
			counter_2++
		}

		String inventoryTotal_dollarSymbolRemoved=initialInventoryTotal.substring(counter_1)

		String locationValue_charactersRemoved=locationValue.substring(counter_2)

		float inventoryTotal_dollarSymbolRemoved_FloatValue=Float.parseFloat(inventoryTotal_dollarSymbolRemoved)

		float locationValue_dollarSymbolRemoved_FloatValue=Float.parseFloat(locationValue_charactersRemoved)

		(new ios_inventory.Inventory_details_Screen()).delete_Location(locationName)

		Mobile.tap(findTestObject('Object Repository/iOS/Product_Search/Back_ImageView'), 0)

		int finalInventoryLocationCount=Mobile.getText(findTestObject('iOS/Inventory/Location Details_Screen/Verification Details/noOfLocation_Text'), 0)

		String finalInventoryTotal=Mobile.getText(findTestObject('iOS/Inventory/Location Details_Screen/Verification Details/locationValue_Text'), 0)

		int counter_3=0

		while(finalInventoryTotal[counter_3]!='0' && finalInventoryTotal[counter_3]!='1' && finalInventoryTotal[counter_3]!='2' && finalInventoryTotal[counter_3]!='3' && finalInventoryTotal[counter_3]!='4' && finalInventoryTotal[counter_3]!='5' && finalInventoryTotal[counter_3]!='6' && finalInventoryTotal[counter_3]!='7' && finalInventoryTotal[counter_3]!='8' && finalInventoryTotal[counter_3]!='9' ) {
			counter_3++
		}

		String finalInventoryTotal_charactersRemoved=finalInventoryTotal.substring(counter_3)

		float finalInventoryTotal_charactersRemoved_FloatValue=Float.parseFloat(finalInventoryTotal_charactersRemoved)

		assert inventoryTotal_dollarSymbolRemoved_FloatValue==(finalInventoryTotal_charactersRemoved_FloatValue+locationValue_dollarSymbolRemoved_FloatValue)

		assert finalInventoryLocationCount==(initialInventoryLocationCount-1)
	}




	/**
	 * edits the inventory name
	 * @param newInventoryName
	 */
	@Keyword
	def edit_InventoryName(String newInventoryName) {

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Edit Inventory/Edit Inventory_Text'), 0)

		Mobile.clearText(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/LocationName_TextField'), 0)

		Mobile.setText(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/LocationName_TextField'), newInventoryName, 0)

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Edit Inventory/Save Changes_Text'), 0)

		(new ios_common_keywords.wait_for_load()).waitForPageLoad()
	}




	/**
	 * searches and adds the product from the inventory details screen by creating a new location 
	 * @param locationName,productName,costType
	 */
	@Keyword
	def search_And_Add_Product_By_Creating_New_Location(String locationName, String productName,String costType) {

		(new ios_common_keywords.wait_for_load()).waitForPageLoad()

		Mobile.tapAndHold(findTestObject('iOS/Inventory/Location Details_Screen/Add Product to Location/Product SearchField'), 0, 0)

		(new ios_common_keywords.wait_for_load()).waitForPageLoad()

		Mobile.setText(findTestObject('iOS/Inventory/Location Details_Screen/Add Product to Location/Product SearchField'), productName, 0)

		Mobile.tapAndHold(findTestObject('iOS/Product_Search/Search Key_Button'), 0, 0)

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Product to Inventory using Search from Dashoboard/Add Product to Inventory_Text'), 0)

		Mobile.tap(findTestObject('iOS/Inventory/Location Details_Screen/Add Product to Location/Product_Generic_Action_Create_Location_Label'), 0)

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/LocationName_TextField'), 0)

		Mobile.setText(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/LocationName_TextField'), locationName, 0)

		if (costType == 'Last Price') {
			Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/Last Price_Button'), 0)
		} else {
			Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/Current Price_Button'), 0)
		}

		Mobile.tapAndHold(findTestObject('iOS/Product_Search/Done Keypad_Text'), 0, 0)

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/Create New Location_Text'), 0)

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/Tap On Location_Text',[('Location'):locationName]), 0)

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Product to Inventory using Search from Dashoboard/Add Product to Inventory_Text'), 0)

		Mobile.tap(findTestObject('iOS/Inventory/Location Details_Screen/Copy Product from Location/Go to Location after Move or Copy or Adding Product_Text',[('Location'):locationName]), 0)

		(new ios_common_keywords.wait_for_load()).waitForPageLoad()
	}




	/**
	 * verifies various details of the inventory details screen
	 * @param inventoryName
	 */
	@Keyword
	def verify_Inventory_Details_Screen(String inventoryName) {

		Mobile.verifyElementExist(findTestObject('iOS/Inventory/Inventory Details Screen/Verification Details/Created on Date_Text'),0)

		Mobile.verifyElementExist(findTestObject('iOS/Inventory/Inventory Details Screen/Verification Details/Inventory Header_Label'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Inventory/Inventory Details Screen/Verification Details/Inventory Value_Text'),0)

		Mobile.verifyElementExist(findTestObject('iOS/Product_Search/Scan_Icon'),0)

		Mobile.verifyElementExist(findTestObject('iOS/Inventory/Inventory Details Screen/Verification Details/Location_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Inventory/Inventory Details Screen/Verification Details/Inventory Title_Label',[('TEXT'):inventoryName]),0)
	}
}