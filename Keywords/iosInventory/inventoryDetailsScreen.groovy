package iosInventory
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
import iosCommonKeywords.commonMethods
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


class inventoryDetailsScreen extends inventoryListingScreen {

	def commonMethodsObject=new commonMethods();


	/**
	 * adds costType based on the argument which can be current or last price paid
	 * @param costType (can be current or last price paid)
	 */
	@Keyword
	def addCostType(String costType) {

		if (costType == 'Last Price') {
			Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/lastPrice_Button'), 0)
		} else {
			Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/currentPrice_Button'), 0)
		}
	}


	/**
	 * adds location to an inventory based on the cost type of current or last price paid
	 * @param locationName (name of the location to be added)
	 * @param costType (cost type required which can be current or last price paid)
	 */
	@Keyword
	def addLocation(String locationName, String costType) {

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/addLocation_Text'), 0)

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/LocationName_TextField'), 0)

		Mobile.setText(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/LocationName_TextField'), locationName, 0)

		(new iosInventory.inventoryDetailsScreen()).addCostType(costType)

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Listing Screen/Create New Inventory Screen/createNewLocation_Button'), 0)

		commonMethodsObject.waitForProgressBarToBeInvisible()

		Mobile.verifyElementExist(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/locationNameVerification_Text', [('LName') : locationName]),0)
	}




	/**
	 * opens the particular location details
	 * @param locationName (name of the location)
	 */
	@Keyword
	def clickOnALocation(String locationName) {

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/tapOnLocation_Text', [('Location') : locationName]), 0)

		commonMethodsObject.waitForProgressBarToBeInvisible()
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

		Mobile.tap(findTestObject('iOS/Product Search/Scan Flow/scan_Icon'), 0)

		commonMethodsObject.waitForProgressBarToBeInvisible()

		'calling the function which selects the countType required for a product which is searched and takes countType as the argument'
		(new iosInventory.locationDetailsScreen()).selectCountTypeForTheProductToBeAdded(countType)

		'calling the function which scans the product and adds it to the location, it takes productName/UPC/Cin/Ndc as the argument'
		(new iosInventory.locationDetailsScreen()).scanInputEvent(productName)

		'calling the function which adds quantity required for a product to be added and takes quantity required as the argument'
		(new iosInventory.locationDetailsScreen()).addQuantityforTheSearchedProduct(quantity)

		'waits until the progressBar is visible on the screen'
		commonMethodsObject.waitForProgressBarToBeInvisible()

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Product to Inventory using Search from Inventory Details Screen/addItemFromAlternate_Button'), 0)

		commonMethodsObject.waitForProgressBarToBeInvisible()

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Product to Inventory using Search from Inventory Details Screen/createLocation_Label'), 0)

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Product to Inventory using Search from Inventory Details Screen/locationName_Button'), 0)

		Mobile.setText(findTestObject('iOS/Inventory/Inventory Details Screen/Add Product to Inventory using Search from Inventory Details Screen/locationName_TextField'), locationName, 0)

		(new iosInventory.inventoryDetailsScreen()).addCostType(costType)

		Mobile.tapAndHold(findTestObject('iOS/Inventory/Inventory Listing Screen/Create New Inventory Screen/done_Keypad'), 0,0)

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Product to Inventory using Search from Inventory Details Screen/createNewLocation_Button'), 0)

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Product to Inventory using Search from Inventory Details Screen/createdLocation_Text',[('TEXT'):locationName]), 0)

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Product to Inventory using Search from Inventory Details Screen/addToInventory_Button'), 0)

		commonMethodsObject.waitForProgressBarToBeInvisible()

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Product to Inventory using Search from Inventory Details Screen/continue_Button'), 0)
	}





	/**
	 * deletes the location
	 * @param locationName (name of the location to be deleted)
	 */
	@Keyword
	def deleteLocation(String locationName) {

		commonMethodsObject.waitForProgressBarToBeInvisible()

		int ElementTopPosition = Mobile.getElementTopPosition(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/tapOnLocation_Text', [('Location') : locationName]), 0)

		int ElementHeight=Mobile.getElementHeight(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/tapOnLocation_Text', [('Location') : locationName]), 0)

		int y_Coordinate=(ElementHeight/2)+ElementTopPosition

		int ElementLeftPosition=Mobile.getElementLeftPosition(findTestObject('iOS/Inventory/Location Details Screen/Delete Location/slidePopUpForLocationDeletion_Button'), 0)

		int ElementWidth=Mobile.getElementWidth(findTestObject('iOS/Inventory/Location Details Screen/Delete Location/slidePopUpForLocationDeletion_Button'), 0)

		int x_Coordinate=(ElementWidth/2)+ElementLeftPosition

		Mobile.tapAtPosition(x_Coordinate, y_Coordinate)
		//Mobile.tap(findTestObject('iOS/Inventory/Location Details Screen/Delete Location/deleteLocation_Text'), 0)

		Mobile.tap(	findTestObject('iOS/Inventory/Inventory Listing Screen/Delete Inventory/delete_Button'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Inventory/Location Details Screen/Delete Location/selectingYesWillAlsoDeleteThisLocationsInventoryOnTheWebsiteAndCannotBeUndone_Text'),0)


		//Mobile.tap(findTestObject('iOS/Inventory/Location Details Screen/Delete Location/yes_Text'), 0)
		Mobile.tap(findTestObject('iOS/Inventory/Inventory Listing Screen/Create New Inventory Screen/yes_Button'), 0)

		commonMethodsObject.waitForProgressBarToBeInvisible()

		Mobile.verifyElementNotVisible(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/locationNameVerification_Text', [('LName') : locationName]),0)
	}



	/**
	 * verifies the location count, cost gets updated or not, of the inventory after the location is deleted
	 * @param locationName (name of the location under verification)
	 */
	@Keyword
	def deleteLocationWithCostLocationCountVerification(String locationName) {

		int initialInventoryLocationCount=Mobile.getText(findTestObject('iOS/Inventory/Location Details Screen/Verification Details/inventoryLine_Text'), 0)// initial inventory location count

		String initialInventoryTotal=Mobile.getText(findTestObject('iOS/Inventory/Location Details Screen/Verification Details/inventoryTotal_Text'), 0)// inventory value with location added

		String locationValue=Mobile.getText(findTestObject('iOS/Inventory/Location Details Screen/Verification Details/locationValue_Text'), 0)//location value with added product

		float inventoryTotal_dollarSymbolRemoved_FloatValue=(new common.commonMethods()).floatValueGenerator(initialInventoryTotal)//converting initialInventoryTotal string to a float value

		float locationValue_dollarSymbolRemoved_FloatValue=(new common.commonMethods()).floatValueGenerator(locationValue)//converting locationValue string to a float value

		(new iosInventory.inventoryDetailsScreen()).deleteLocation(locationName)//calling delete location function

		Mobile.tap(findTestObject('iOS/Product Search/Back_ImageView'), 0)

		int finalInventoryLocationCount=Mobile.getText(findTestObject('iOS/Inventory/Location Details Screen/Verification Details/noOfLocation_Text'), 0)//final inventory location count after deleting a location

		String finalInventoryTotal=Mobile.getText(findTestObject('iOS/Inventory/Location Details Screen/Verification Details/locationValue_Text'), 0)//final inventory total after deleting a location

		float finalInventoryTotal_charactersRemoved_FloatValue=(new common.commonMethods()).floatValueGenerator(finalInventoryTotal)///converting finalInventoryTotal string to a float value

		assert inventoryTotal_dollarSymbolRemoved_FloatValue==(finalInventoryTotal_charactersRemoved_FloatValue+locationValue_dollarSymbolRemoved_FloatValue)

		assert finalInventoryLocationCount==(initialInventoryLocationCount-1)
	}


	/**
	 * edits the inventory name
	 * @param newInventoryName (new name of the inventory)
	 */
	@Keyword
	def editInventoryName(String newInventoryName) {

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Edit Inventory/Edit Inventory_Text'), 0)

		Mobile.clearText(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/LocationName_TextField'), 0)

		Mobile.setText(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/LocationName_TextField'), newInventoryName, 0)

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Edit Inventory/saveChanges_Text'), 0)
	}


	/**
	 * searches and adds the product from the inventory details screen by creating a new location
	 * @param locationName (name of the location to be created) 
	 * @param productName (name of the product to be added)
	 * @param costType (cost type required which can be current or last price paid)
	 */
	@Keyword
	def searchAndAddProductByCreatingNewLocation(String locationName, String productName,String costType) {

		Mobile.tapAndHold(findTestObject('iOS/Inventory/Location Details Screen/Add Product to Location/productSearch_TextField'), 0, 0)

		commonMethodsObject.waitForProgressBarToBeInvisible()

		Mobile.setText(findTestObject('iOS/Inventory/Location Details Screen/Add Product to Location/productSearch_TextField'), productName, 0)

		Mobile.tapAndHold(findTestObject('iOS/Product Search/search_Keypad'), 0, 0)

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Product to Inventory using Search from Inventory Details Screen/addProductToInventory_Text'), 0)

		Mobile.tap(findTestObject('iOS/Inventory/Location Details Screen/Add Product to Location/createANewLocation_Text'), 0)

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/LocationName_TextField'), 0)

		Mobile.setText(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/LocationName_TextField'), locationName, 0)

		if (costType == 'Last Price') {
			Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/lastPrice_Button'), 0)
		} else {
			Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/currentPrice_Button'), 0)
		}
		Mobile.tapAndHold(findTestObject('iOS/Product Search/doneKeypad_Button'), 0, 0)

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/createNewLocation_Text'), 0)

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/tapOnLocation_Text',[('Location'):locationName]), 0)

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Product to Inventory using Search from Inventory Details Screen/addProductToInventory_Text'), 0)

		Mobile.tap(findTestObject('iOS/Inventory/Location Details Screen/Copy Product from Location/goToLocationAfterCopyingProduct_Text',[('Location'):locationName]), 0)
	}



	/**
	 * verifies various details of the inventory details screen
	 * @param inventoryName (name of the inventory which is under verification)
	 */
	@Keyword
	def verifyInventoryDetailsScreen(String inventoryName) {

		Mobile.verifyElementExist(findTestObject('iOS/Inventory/Inventory Details Screen/Verification Details/createdOnDate_Text'),0)

		Mobile.verifyElementExist(findTestObject('iOS/Inventory/Inventory Details Screen/Verification Details/inventoryHeader_Label'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Inventory/Inventory Details Screen/Verification Details/inventoryValue_Text'),0)

		Mobile.verifyElementExist(findTestObject('iOS/Product Search/Scan Flow/scan_Icon'),0)

		Mobile.verifyElementExist(findTestObject('iOS/Inventory/Inventory Details Screen/Verification Details/Location_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Inventory/Inventory Details Screen/Verification Details/inventoryTitle_Label',[('TEXT'):inventoryName]),0)
	}


	/**
	 * this function verifies the location count
	 * @param expectedLocationCount (expected location Count)
	 */
	@Keyword
	def verifyLocationCount(String expectedLocationCount) {

		String actualLocationCount=Mobile.getText(findTestObject('iOS/Inventory/Location Details Screen/Verification Details/inventoryLine_Text'),0) //gets the actual Location Count on the inventory details page

		assert actualLocationCount==expectedLocationCount //actual location count has to be equal to expected lines count

	}




	/**
	 * this function verifies that the product is visible on the screen after it is searched from inventory details screen
	 * @param productIdentificationNumber (productIdentificationNumber of the product which can be NDC/Cin/UPC, which should be present on the screen)
	 */
	@Keyword
	def verifyProductIsVisibleOnScreenWhenSearchedFromInventoryDetailsScreen(productIdentificationNumber) {

		String testObj='Object Repository/iOS/Inventory/Inventory Details Screen/Add Product to Inventory using Search from Inventory Details Screen/alternateNDC_Text'

		(new iosCommonKeywords.commonMethods()).verifyProductIsVisibleOnTheScreen(testObj,productIdentificationNumber)//calling verifyProductIsVisibleOnTheScreen function and passing testObj, topProductIdentificationNumber as the arguments

	}
}