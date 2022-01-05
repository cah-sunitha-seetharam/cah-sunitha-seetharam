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

	/**
	 * verifies the location count, cost gets updated or not, of the inventory after the location is deleted
	 * @param locationName (name of the location under verification)
	 */
	@Keyword
	def deleteLocationWithCostLocationCountVerification(String locationName) {

		int initialInventoryLocationCount=Mobile.getText(findTestObject('Android/Inventory/Location Details Screen/Verification Details/inventoryLine_Text'), 0)// initial inventory location count

		String initialInventoryTotal=Mobile.getText(findTestObject('Android/Inventory/Location Details Screen/Verification Details/inventoryTotal_Text'), 0)// inventory value with location added

		String locationValue=Mobile.getText(findTestObject('Android/Inventory/Location Details Screen/Verification Details/locationValue_Text'), 0)//location value with added product

		float inventoryTotal_dollarSymbolRemoved_FloatValue=(new common.commonMethods()).floatValueGenerator(initialInventoryTotal)//converting initialInventoryTotal string to a float value

		float locationValue_dollarSymbolRemoved_FloatValue=(new common.commonMethods()).floatValueGenerator(locationValue)//converting locationValue string to a float value

		(new androidInventory.inventoryDetailsScreen()).deleteLocation(locationName)//calling delete location function

		commonMethodsObject.pressBacknav()

		int finalInventoryLocationCount=Mobile.getText(findTestObject('Android/Inventory/Location Details Screen/Verification Details/noOfLocation_Text'), 0)//final inventory location count after deleting a location

		String finalInventoryTotal=Mobile.getText(findTestObject('Android/Inventory/Location Details Screen/Verification Details/Inventory_locationValue_Text'), 0)//final inventory total after deleting a location

		float finalInventoryTotal_charactersRemoved_FloatValue=(new common.commonMethods()).floatValueGenerator(finalInventoryTotal)///converting finalInventoryTotal string to a float value

		/*	KeywordUtil.logInfo("initialInventoryTotal is " + initialInventoryTotal );
		 KeywordUtil.logInfo("locationValue is " + locationValue );
		 KeywordUtil.logInfo("inventoryTotal_dollarSymbolRemoved_FloatValue is " + inventoryTotal_dollarSymbolRemoved_FloatValue );
		 KeywordUtil.logInfo("locationValue_dollarSymbolRemoved_FloatValue is " + locationValue_dollarSymbolRemoved_FloatValue );
		 KeywordUtil.logInfo("finalInventoryLocationCount is " + finalInventoryLocationCount );
		 KeywordUtil.logInfo("finalInventoryTotal is " + finalInventoryTotal );
		 KeywordUtil.logInfo("finalInventoryTotal_charactersRemoved_FloatValue is " + finalInventoryTotal_charactersRemoved_FloatValue );
		 */

		assert inventoryTotal_dollarSymbolRemoved_FloatValue==(finalInventoryTotal_charactersRemoved_FloatValue+locationValue_dollarSymbolRemoved_FloatValue)

		assert finalInventoryLocationCount==(initialInventoryLocationCount-1)
	}

	/**
	 * deletes the location
	 * @param locationName (name of the location to be deleted)
	 */
	@Keyword
	def deleteLocation(String locationName) {

		int ElementTopPosition = Mobile.getElementTopPosition(findTestObject('Android/Inventory/Inventory Detail Screen/Add Location/tapOnLocation_Text', [('Location') : locationName]), 0)

		int ElementHeight=Mobile.getElementHeight(findTestObject('Android/Inventory/Inventory Detail Screen/Add Location/tapOnLocation_Text', [('Location') : locationName]), 0)

		int y_Coordinate=(ElementHeight/2)+ElementTopPosition

		int ElementLeftPosition=Mobile.getElementLeftPosition(findTestObject('Android/Inventory/Location Details Screen/Delete Location/slidePopUpForLocationDeletion_Button'), 0)

		int ElementWidth=Mobile.getElementWidth(findTestObject('Android/Inventory/Location Details Screen/Delete Location/slidePopUpForLocationDeletion_Button'), 0)

		int x_Coordinate=(ElementWidth/2)+ElementLeftPosition

		Mobile.tapAtPosition(x_Coordinate, y_Coordinate)

		Mobile.tap(	findTestObject('Android/Inventory/Inventory Listing Screen/Delete Inventory/delete_Button'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Inventory/Location Details Screen/Delete Location/selectingYesWillAlsoDeleteThisLocationsInventoryOnTheWebsiteAndCannotBeUndone_Text'),0)

		Mobile.tap(findTestObject('Android/Inventory/Inventory Listing Screen/Create New Inventory_Screen/yes_Button'), 0)

		commonMethodsObject.waitForProgressBarToBeInvisible()

		Mobile.verifyElementNotVisible(findTestObject('Android/Inventory/Inventory Detail Screen/Add Location/locationNameVerification_Text', [('LName') : locationName]),0)
	}


	/**
	 * searches and adds the product from the inventory details screen by creating a new location
	 * @param locationName (name of the location to be created)
	 * @param productName (name of the product to be added)
	 * @param countType (count type required which can be partial or full count)
	 * @param quantity (quantity of the product required to be added)
	 * @param costType (cost type required which can be current or last price paid)
	 */
	@Keyword
	def clickOnScanIconAndAddProductByCreatingNewLocationViaInventoryDetailsScreen(String locationName, String productName,String countType, String quantity, String costType) {

		Mobile.tap(findTestObject('Android/Product Search/Scan Flow/scan_Icon'), 0)

		commonMethodsObject.waitForProgressBarToBeInvisible()

		'calling the function which selects the countType required for a product which is searched and takes countType as the argument'
		(new androidInventory.locationDetailsScreen()).selectCountTypeForTheProductToBeAdded(countType)

		'calling the function which scans the product and adds it to the location, it takes productName/UPC/Cin/Ndc as the argument'
		(new androidInventory.locationDetailsScreen()).scanInputEvent(productName)

		'calling the function which adds quantity required for a product to be added and takes quantity required as the argument'
		(new androidInventory.locationDetailsScreen()).addQuantityforTheSearchedProduct(quantity)

		Mobile.tap(findTestObject('Android/Inventory/Inventory Detail Screen/Add Product to Inventory using Search from Inventory Details Screen/addItemFromAlternate_Button'), 0)

		Mobile.tap(findTestObject('Android/Inventory/Inventory Detail Screen/Add Product to Inventory using Search from Inventory Details Screen/createLocation_Label'), 0)

		Mobile.tap(findTestObject('Android/Inventory/Inventory Detail Screen/Add Product to Inventory using Search from Inventory Details Screen/locationName_Button'), 0)

		Mobile.setText(findTestObject('Android/Inventory/Inventory Detail Screen/Add Product to Inventory using Search from Inventory Details Screen/locationName_TextField'), locationName, 0)

		(new androidInventory.inventoryDetailsScreen()).addCostType(costType)

		Mobile.tap(findTestObject('Android/Inventory/Inventory Detail Screen/Add Product to Inventory using Search from Inventory Details Screen/createNewLocation_Button'), 0)

		Mobile.tap(findTestObject('Android/Inventory/Inventory Detail Screen/Add Product to Inventory using Search from Inventory Details Screen/createdLocation_Text',[('TEXT'):locationName]), 0)

		Mobile.tap(findTestObject('Android/Inventory/Inventory Detail Screen/Add Product to Inventory using Search from Inventory Details Screen/location_RadioButton'), 0)

		Mobile.tap(findTestObject('Android/Inventory/Inventory Detail Screen/Add Product to Inventory using Search from Inventory Details Screen/addToInventory_Button'), 0)

		Mobile.tap(findTestObject('Android/Inventory/Inventory Detail Screen/Add Product to Inventory using Search from Inventory Details Screen/goToLocation_button'), 0)
	}


	/**
	 * this function verifies that the product is visible on the screen after it is searched from inventory details screen
	 * @param productIdentificationNumber (productIdentificationNumber of the product which can be NDC/Cin/UPC, which should be present on the screen)
	 */
	@Keyword
	def verifyProductIsVisibleOnScreenWhenSearchedFromInventoryDetailsScreen(productIdentificationNumber) {

		String testObj='Android/Inventory/Inventory Detail Screen/Add Product to Inventory using Search from Inventory Details Screen/alternateNDC_Text'

		(new androidCommonKeywords.commonMethods()).verifyProductIsVisibleOnTheScreen(testObj,productIdentificationNumber)//calling verifyProductIsVisibleOnTheScreen function and passing testObj, topProductIdentificationNumber as the arguments

	}

	/**
	 * opens the particular location details
	 * @param locationName (name of the location)
	 */
	@Keyword
	def clickOnALocation(String locationName) {

		Mobile.tap(findTestObject('Android/Inventory/Inventory Detail Screen/Add Location/tapOnLocation_Text', [('Location') : locationName]), 0)

		commonMethodsObject.waitForProgressBarToBeInvisible()
	}
	
	/**
	 * this function verifies the location count
	 * @param expectedLocationCount (expected location Count)
	 */
	@Keyword
	def verifyLocationCount(String expectedLocationCount) {

		String actualLocationCount=Mobile.getText(findTestObject('Android/Inventory/Location Details Screen/Verification Details/inventoryLine_Text'),0) //gets the actual Location Count on the inventory details page

		assert actualLocationCount==expectedLocationCount //actual location count has to be equal to expected lines count

	}
}