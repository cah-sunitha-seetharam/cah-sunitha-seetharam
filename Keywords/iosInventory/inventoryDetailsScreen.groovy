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
	def locationDetailsScreenObject=new locationDetailsScreen();


	/**
	 * adds costType based on the argument which can be current or last price paid
	 * @param costType (can be current or last price paid)
	 */
	@Keyword
	def addCostType(String costType) {

		if (costType == 'Last Price') {
			Mobile.tap(findTestObject('iOS/inventory/inventoryDetailsScreen/addLocation/lastPrice_Button'), 0)
		} else {
			Mobile.tap(findTestObject('iOS/inventory/inventoryDetailsScreen/addLocation/currentPrice_Button'), 0)
		}
	}


	/**
	 * adds location to an inventory based on the cost type of current or last price paid
	 * @param locationName (name of the location to be added)
	 * @param costType (cost type required which can be current or last price paid)
	 */
	@Keyword
	def addLocation(String locationName, String costType) {

		if(Mobile.verifyElementExist(findTestObject('iOS/inventory/inventoryDetailsScreen/addLocation/addLocation_Text'),5, FailureHandling.OPTIONAL)){

			Mobile.tap(findTestObject('iOS/inventory/inventoryDetailsScreen/addLocation/addLocation_Text'), 0)
		}

		else {
			Mobile.tap(findTestObject('iOS/inventory/inventoryDetailsScreen/addLocation/addLocation_Button'), 0)
		}

		Mobile.tap(findTestObject('iOS/inventory/inventoryDetailsScreen/addLocation/LocationName_TextField'), 0)

		Mobile.setText(findTestObject('iOS/inventory/inventoryDetailsScreen/addLocation/LocationName_TextField'), locationName, 0)

		addCostType(costType)

		Mobile.tap(findTestObject('iOS/inventory/inventoryListingScreen/createNewInventory/createNewLocation_Button'), 0)

		commonMethodsObject.waitForProgressBarToBeInvisible()

		Mobile.verifyElementExist(findTestObject('iOS/inventory/inventoryDetailsScreen/addLocation/locationNameVerification_Text', [('LName') : locationName]),0)
	}




	/**
	 * opens the particular location details
	 * @param locationName (name of the location)
	 */
	@Keyword
	def clickOnALocation(String locationName) {

		Mobile.tap(findTestObject('iOS/inventory/inventoryDetailsScreen/addLocation/tapOnLocation_Text', [('Location') : locationName]), 0)

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

		Mobile.tap(findTestObject('iOS/productSearch/scanFlow/scan_Icon'), 0)

		commonMethodsObject.waitForProgressBarToBeInvisible()

		'calling the function which selects the countType required for a product which is searched and takes countType as the argument'
		locationDetailsScreenObject.selectCountTypeForTheProductToBeAdded(countType)

		'calling the function which scans the product and adds it to the location, it takes productName/UPC/Cin/Ndc as the argument'
		locationDetailsScreenObject.scanInputEvent(productName)

		'calling the function which adds quantity required for a product to be added and takes quantity required as the argument'
		locationDetailsScreenObject.addQuantityforTheSearchedProduct(quantity)

		'waits until the progressBar is visible on the screen'
		commonMethodsObject.waitForProgressBarToBeInvisible()

		Mobile.tap(findTestObject('iOS/inventory/inventoryDetailsScreen/addProductToInventoryUsingSearchFromInventoryDetailsScreen/addItemFromAlternate_Button'), 0)

		commonMethodsObject.waitForProgressBarToBeInvisible()

		Mobile.tap(findTestObject('iOS/inventory/inventoryDetailsScreen/addProductToInventoryUsingSearchFromInventoryDetailsScreen/createLocation_Label'), 0)

		Mobile.tap(findTestObject('iOS/inventory/inventoryDetailsScreen/addProductToInventoryUsingSearchFromInventoryDetailsScreen/locationName_Button'), 0)

		Mobile.setText(findTestObject('iOS/inventory/inventoryDetailsScreen/addProductToInventoryUsingSearchFromInventoryDetailsScreen/locationName_TextField'), locationName, 0)

		addCostType(costType)

		Mobile.tapAndHold(findTestObject('iOS/inventory/inventoryListingScreen/createNewInventory/done_Keypad'), 0,0)

		Mobile.tap(findTestObject('iOS/inventory/inventoryDetailsScreen/addProductToInventoryUsingSearchFromInventoryDetailsScreen/createNewLocation_Button'), 0)

		Mobile.tap(findTestObject('iOS/inventory/inventoryDetailsScreen/addProductToInventoryUsingSearchFromInventoryDetailsScreen/createdLocation_Text',[('TEXT'):locationName]), 0)

		Mobile.tap(findTestObject('iOS/inventory/inventoryDetailsScreen/addProductToInventoryUsingSearchFromInventoryDetailsScreen/addToInventory_Button'), 0)

		commonMethodsObject.waitForProgressBarToBeInvisible()

		Mobile.tap(findTestObject('iOS/inventory/inventoryDetailsScreen/addProductToInventoryUsingSearchFromInventoryDetailsScreen/continue_Button'), 0)
	}



	/**
	 * deletes the location
	 * @param locationName (name of the location to be deleted)
	 */
	@Keyword
	def deleteLocation(String locationName) {

		commonMethodsObject.waitForProgressBarToBeInvisible()

		int ElementTopPosition = Mobile.getElementTopPosition(findTestObject('iOS/inventory/inventoryDetailsScreen/addLocation/tapOnLocation_Text', [('Location') : locationName]), 0)

		int ElementHeight=Mobile.getElementHeight(findTestObject('iOS/inventory/inventoryDetailsScreen/addLocation/tapOnLocation_Text', [('Location') : locationName]), 0)

		int y_Coordinate=(ElementHeight/2)+ElementTopPosition

		int ElementLeftPosition=Mobile.getElementLeftPosition(findTestObject('iOS/inventory/locationDetailsScreen/deleteLocation/slidePopUpForLocationDeletion_Button'), 0)

		int ElementWidth=Mobile.getElementWidth(findTestObject('iOS/inventory/locationDetailsScreen/deleteLocation/slidePopUpForLocationDeletion_Button'), 0)

		int x_Coordinate=(ElementWidth/2)+ElementLeftPosition

		Mobile.tapAtPosition(x_Coordinate, y_Coordinate)
		//Mobile.tap(findTestObject('iOS/inventory/locationDetailsScreen/deleteLocation/deleteLocation_Text'), 0)

		Mobile.tap(	findTestObject('iOS/inventory/inventoryListingScreen/deleteInventory/delete_Button'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/inventory/inventoryListingScreen/deleteInventory/selectingYesWillAlsoDeleteThisLocationsInventoryOnTheWebsiteAndCannotBeUndone_Text'),0)


		//Mobile.tap(findTestObject('iOS/inventory/locationDetailsScreen/deleteLocation/yes_Text'), 0)
		Mobile.tap(findTestObject('iOS/inventory/inventoryListingScreen/createNewInventory/yes_Button'), 0)

		commonMethodsObject.waitForProgressBarToBeInvisible()

		Mobile.verifyElementNotVisible(findTestObject('iOS/inventory/inventoryDetailsScreen/addLocation/locationNameVerification_Text', [('LName') : locationName]),0)
	}



	/**
	 * verifies the location count, cost gets updated or not, of the inventory after the location is deleted
	 * @param locationName (name of the location under verification)
	 */
	@Keyword
	def deleteLocationWithCostLocationCountVerification(String locationName) {

		int initialInventoryLocationCount=Mobile.getText(findTestObject('iOS/inventory/locationDetailsScreen/verification/inventoryLine_Text'), 0)// initial inventory location count

		String initialInventoryTotal=Mobile.getText(findTestObject('iOS/inventory/locationDetailsScreen/verification/inventoryTotal_Text'), 0)// inventory value with location added

		String locationValue=Mobile.getText(findTestObject('iOS/inventory/locationDetailsScreen/verification/locationValue_Text'), 0)//location value with added product

		float inventoryTotal_dollarSymbolRemoved_FloatValue=(new common.commonMethods()).floatValueGenerator(initialInventoryTotal)//converting initialInventoryTotal string to a float value

		float locationValue_dollarSymbolRemoved_FloatValue=(new common.commonMethods()).floatValueGenerator(locationValue)//converting locationValue string to a float value

		(new iosInventory.inventoryDetailsScreen()).deleteLocation(locationName)//calling delete location function

		Mobile.tap(findTestObject('iOS/productSearch/Back_ImageView'), 0)

		int finalInventoryLocationCount=Mobile.getText(findTestObject('iOS/inventory/locationDetailsScreen/verification/noOfLocation_Text'), 0)//final inventory location count after deleting a location

		String finalInventoryTotal=Mobile.getText(findTestObject('iOS/inventory/locationDetailsScreen/verification/locationValue_Text'), 0)//final inventory total after deleting a location

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

		Mobile.tap(findTestObject('iOS/inventory/inventoryDetailsScreen/editInventory/editInventory_Text'), 0)

		Mobile.clearText(findTestObject('iOS/inventory/inventoryDetailsScreen/addLocation/locationName_TextField'), 0)

		Mobile.setText(findTestObject('iOS/inventory/inventoryDetailsScreen/addLocation/LocationName_TextField'), newInventoryName, 0)

		Mobile.tap(findTestObject('iOS/inventory/inventoryDetailsScreen/editInventory/saveChanges_Text'), 0)
	}


	/**
	 * searches and adds the product from the inventory details screen by creating a new location
	 * @param locationName (name of the location to be created) 
	 * @param productName (name of the product to be added)
	 * @param costType (cost type required which can be current or last price paid)
	 */
	@Keyword
	def searchAndAddProductByCreatingNewLocation(String locationName, String productName,String costType, String quantity) {

		Mobile.tapAndHold(findTestObject('iOS/inventory/locationDetailsScreen/addProductToLocation/productSearch_TextField'), 0, 0)

		commonMethodsObject.waitForProgressBarToBeInvisible()

		Mobile.setText(findTestObject('iOS/inventory/locationDetailsScreen/addProductToLocation/productSearch_TextField'), productName, 0)

		Mobile.tapAndHold(findTestObject('iOS/productSearch/globalSearch/search_Keypad'), 0, 0)

		locationDetailsScreenObject.addQuantityforTheSearchedProduct(quantity)

		Mobile.tap(findTestObject('iOS/inventory/inventoryDetailsScreen/addProductToInventoryUsingSearchFromInventoryDetailsScreen/addProductToInventory_Text'), 0)

		Mobile.tap(findTestObject('iOS/inventory/locationDetailsScreen/addProductToLocation/createANewLocation_Text'), 0)

		Mobile.tap(findTestObject('iOS/inventory/inventoryDetailsScreen/addLocation/LocationName_TextField'), 0)

		Mobile.setText(findTestObject('iOS/inventory/inventoryDetailsScreen/addLocation/LocationName_TextField'), locationName, 0)

		addCostType(costType)

		Mobile.tapAndHold(findTestObject('iOS/productSearch/globalSearch/doneKeypad_Button'), 0, 0)

		Mobile.tap(findTestObject('iOS/inventory/inventoryDetailsScreen/addLocation/createNewLocation_Text'), 0)

		Mobile.tap(findTestObject('iOS/inventory/inventoryDetailsScreen/addLocation/tapOnLocation_Text',[('Location'):locationName]), 0)

		Mobile.tap(findTestObject('iOS/inventory/inventoryDetailsScreen/addProductToInventoryUsingSearchFromInventoryDetailsScreen/addProductToInventory_Text'), 0)

		Mobile.tap(findTestObject('iOS/inventory/locationDetailsScreen/copyProductFromLocation/goToLocationAfterCopyingProduct_Text',[('Location'):locationName]), 0)
	}



	/**
	 * verifies various details of the inventory details screen
	 * @param inventoryName (name of the inventory which is under verification)
	 */
	@Keyword
	def verifyInventoryDetailsScreen(String inventoryName) {

		//Mobile.verifyElementExist(findTestObject('iOS/inventory/inventoryDetailsScreen/verificationDetails/createdOnDate_Text'),0)

		Mobile.verifyElementExist(findTestObject('iOS/inventory/inventoryDetailsScreen/verificationDetails/inventoryHeader_Label'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/inventory/inventoryDetailsScreen/verificationDetails/inventoryValue_Text'),0)

		Mobile.verifyElementExist(findTestObject('iOS/productSearch/scanFlow/scan_Icon'),0)

		Mobile.verifyElementExist(findTestObject('iOS/inventory/inventoryDetailsScreen/verificationDetails/Location_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/inventory/inventoryDetailsScreen/verificationDetails/inventoryTitle_Label',[('TEXT'):inventoryName]),0)
	}


	/**
	 * this function verifies the location count
	 * @param expectedLocationCount (expected location Count)
	 */
	@Keyword
	def verifyLocationCount(String expectedLocationCount) {

		String actualLocationCount=Mobile.getText(findTestObject('iOS/inventory/locationDetailsScreen/verification/inventoryLine_Text'),0) //gets the actual Location Count on the inventory details page

		assert actualLocationCount==expectedLocationCount //actual location count has to be equal to expected lines count

	}




	/**
	 * this function verifies that the product is visible on the screen after it is searched from inventory details screen
	 * @param productIdentificationNumber (productIdentificationNumber of the product which can be NDC/Cin/UPC, which should be present on the screen)
	 */
	@Keyword
	def verifyProductIsVisibleOnScreenWhenSearchedFromInventoryDetailsScreen(productIdentificationNumber) {

		String testObj='Object Repository/iOS/inventory/inventoryDetailsScreen/addProductToInventoryUsingSearchFromInventoryDetailsScreen/alternateNDC_Text'

		commonMethodsObject.verifyProductIsVisibleOnTheScreen(testObj,productIdentificationNumber)//calling verifyProductIsVisibleOnTheScreen function and passing testObj, topProductIdentificationNumber as the arguments

	}
}