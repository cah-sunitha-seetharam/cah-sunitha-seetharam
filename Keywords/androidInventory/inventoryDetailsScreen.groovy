package androidInventory
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

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import androidCommonKeywords.commonMethods


class inventoryDetailsScreen {

	def commonMethodsObject=new commonMethods();

	/**
	 * adds costType based on the argument which can be current or last price paid
	 * @param costType (can be current or last price paid)
	 */
	@Keyword
	def addCostType(String costType) {

		if (costType == 'Last Cost Paid') {
			Mobile.tap(findTestObject('Android/Inventory/Inventory Detail Screen/Add Location/lastCostPaid_RadioButton'), 0)
		} else {
			Mobile.tap(findTestObject('Android/Inventory/Inventory Detail Screen/Add Location/currentPrice_RadioButton'), 0)
		}
	}


	/**
	 * adds location to an inventory based on the cost type of current or last price paid
	 * @param locationName (name of the location to be added)
	 * @param costType (cost type required which can be current or last price paid)
	 */
	@Keyword
	def addLocation(String locationName, String costType) {

		Mobile.tap(findTestObject('Android/Inventory/Inventory Detail Screen/Add Location/addLocation_TextView'), 0)

		Mobile.setText(findTestObject('Android/Inventory/Inventory Detail Screen/Add Location/locationName_TextField'), locationName,  0)

		(new androidInventory.inventoryDetailsScreen()).addCostType(costType)

		Mobile.tap(findTestObject('Android/Inventory/Inventory Detail Screen/Add Location/createNewLocation_Button'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Inventory/Inventory Detail Screen/Verification Details/createdLocation_TextView', [('TEXT') : locationName]),0, FailureHandling.OPTIONAL)
	}




	@Keyword
	def edit_InventoryName(String New_Inventory_Name, String Previous_Name) {

		Mobile.tap(findTestObject('Android/Inventory/Location Details Screen/Edit_Location/Edit_TextView'), 0)

		Mobile.clearText(findTestObject('Android/Inventory/Inventory Detail Screen/Edit Inventory/inventoryToBeEdited_TextField',[('Inv_Name') : Previous_Name]),0)

		WebUI.delay(2)

		Mobile.setText(findTestObject('Android/Inventory/Inventory Detail Screen/Edit Inventory/inventoryName_TextField'), New_Inventory_Name,0)

		Mobile.tap(findTestObject('Android/Inventory/Location Details Screen/Edit_Location/saveChanges_Button'), 0)

		commonMethodsObject.waitForProgressBarToBeInvisible()
	}





	@Keyword
	def clickOnLocation(String locationName) {

		Mobile.tap(findTestObject('Android/Inventory/Inventory Detail Screen/Verification Details/openLocation_TextView',[('Location') : locationName]), 0)

		commonMethodsObject.waitForProgressBarToBeInvisible()
	}


	/**
	 * deletes the location
	 * @param locationName (name of the location to be deleted)
	 */
	@Keyword
	def deleteLocation(String locationName) {

		Mobile.tap(findTestObject('Android/Inventory/Inventory Listing Screen/Delete Inventory/popup_menu'), 0)

		Mobile.tap(findTestObject('Android/Inventory/Inventory Listing Screen/Delete Inventory/Delete_Button'), 0)

		Mobile.tap(findTestObject('Android/Inventory/Inventory Listing Screen/Delete Inventory/Yes_Button'), 0)

		commonMethodsObject.waitForProgressBarToBeInvisible()

		Mobile.verifyElementNotVisible(findTestObject('Android/Inventory/Location Details Screen/Edit_Location/afterLocationEditVerfication_TextView',
				[('TEXT') : locationName]), 0)
	}



	@Keyword
	def search_And_Add_Product_By_Creating_New_Location(String Location_Name, String Product_Name,String CostType) {


		int w = 1

		if (Mobile.verifyElementExist(findTestObject('Android/Inventory/Inventory Detail Screen/Verification Details/createdLocation_TextView', [('TEXT') : Location_Name]),0, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Android/Inventory/Inventory Detail Screen/Verification Details/createdLocation_TextView', [('TEXT') : Location_Name]), 0)
		}

		while (Mobile.verifyElementExist(findTestObject('Android/Login/Login Details Screen/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}

		Mobile.tap(findTestObject('Android/Product Search/Search Products_SearchView'), 0)

		Mobile.setText(findTestObject('Android/Product Search/Search Products_SearchView'), Product_Name + '\\n',
				0)
		while (Mobile.verifyElementExist(findTestObject('Android/Login/Login Details Screen/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}

		Mobile.tap(findTestObject('Android/Product Search/Add to Inventory_Button'), 0)


		Mobile.tap(findTestObject('Android/Inventory/Location Details Screen/Move Product to Another Location/createANewLocation_TextView'), 0)

		Mobile.tap(findTestObject('Android/Inventory/Inventory Detail Screen/Add Location/locationName_TextField'), 0)

		Mobile.setText(findTestObject('Android/Inventory/Inventory Detail Screen/Add Location/locationName_TextField'), Location_Name,  0)

		if (CostType == 'Last Cost Paid') {
			Mobile.tap(findTestObject('Android/Inventory/Inventory Detail Screen/Add Location/lastCostPaid_RadioButton'), 0)
		} else {
			Mobile.tap(findTestObject('Android/Inventory/Inventory Detail Screen/Add Location/currentPrice_RadioButton'), 0)
		}

		Mobile.tap(findTestObject('Android/Inventory/Inventory Detail Screen/Add Location/createNewLocation_Button'), 0)

		Mobile.tap(findTestObject('Android/Inventory/Location Details Screen/Copy Product to Another Location/Select_location_RadioButton'), 0)

		Mobile.tap(	findTestObject('Android/Inventory/Inventory Detail Screen/Add Product to Inventory using Search from Dashoboard/addToInventory_Button'), 0)

		Mobile.tap(findTestObject('Android/Inventory/Location Details Screen/Add Product to_Location/goToLocationAfterAddingProduct_TextView',[('Location') : Location_Name]) ,0)
	}




	@Keyword
	def verify_Inventory_Details_Screen(String Inventory_Name) {

		Mobile.verifyElementExist(findTestObject('Android/Inventory/Inventory Detail Screen/Verification Details/createdOnDate_TextView'),0)

		Mobile.verifyElementExist(findTestObject('Android/Inventory/Inventory Detail Screen/Verification Details/inventoryHeader_TextView'),0)

		Mobile.verifyElementExist(findTestObject('Android/Inventory/Inventory Detail Screen/Verification Details/Scan_Icon'),0)

		Mobile.verifyElementExist(findTestObject('Android/Inventory/Inventory Detail Screen/Verification Details/inventoryName_TextView',[('TEXT'):Inventory_Name]),0)
	}
}