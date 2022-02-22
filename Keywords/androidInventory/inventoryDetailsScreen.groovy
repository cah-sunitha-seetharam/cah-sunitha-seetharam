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
import io.appium.java_client.MobileElement
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
	def locationDetailsScreenObject=new locationDetailsScreen();

	/**
	 * adds costType based on the argument which can be current or last price paid
	 * @param costType (can be current or last price paid)
	 */
	@Keyword
	def addCostType(String costType) {

		if (costType == 'Last Cost Paid') {
			Mobile.tap(findTestObject('Android/inventory/inventoryDetailScreen/addLocation/lastCostPaid_RadioButton'), 0)
		} else {
			Mobile.tap(findTestObject('Android/inventory/inventoryDetailScreen/addLocation/currentPrice_RadioButton'), 0)
		}
	}


	/**
	 * adds location to an inventory based on the cost type of current or last price paid
	 * @param locationName (name of the location to be added)
	 * @param costType (cost type required which can be current or last price paid)
	 */
	@Keyword
	def addLocation(String locationName, String costType) {

		Mobile.tap(findTestObject('Android/inventory/inventoryDetailScreen/addLocation/addLocation_TextView'), 0)

		Mobile.setText(findTestObject('Android/inventory/inventoryDetailScreen/addLocation/locationName_TextField'), locationName,  0)

		addCostType(costType)

		Mobile.tap(findTestObject('Android/inventory/inventoryDetailScreen/addLocation/createNewLocation_Button'), 0)

		Mobile.verifyElementExist(findTestObject('Android/inventory/inventoryDetailScreen/verificationDetails/createdLocation_TextView', [('TEXT') : locationName]),0, FailureHandling.OPTIONAL)
	}


	/**
	 * Edit an inventory name
	 * @param newInventoryName (name of the inventory to be added)
	 * @param previousName (name of the previous to be added)
	 */

	@Keyword
	def editInventoryName(String newInventoryName, String previousName) {

		commonMethodsObject.waitForProgressBarToBeInvisible()

		Mobile.tapAndHold(findTestObject('Android/inventory/locationDetailsScreen/editLocation/Edit_TextView'), 0,0)

		Mobile.clearText(findTestObject('Android/inventory/inventoryDetailScreen/editInventory/inventoryToBeEdited_TextField',[('Inv_Name') : previousName]),0)

		WebUI.delay(2)

		Mobile.setText(findTestObject('Android/inventory/inventoryDetailScreen/editInventory/inventoryName_TextField'), newInventoryName,0)

		Mobile.tap(findTestObject('Android/inventory/locationDetailsScreen/editLocation/saveChanges_Button'), 0)

		commonMethodsObject.waitForProgressBarToBeInvisible()
	}


	/**
	 * Click on the location 
	 * @param locationName (name of the location)
	 */

	@Keyword
	def clickOnLocation(String locationName) {

		Mobile.tap(findTestObject('Android/inventory/inventoryDetailScreen/verificationDetails/openLocation_TextView',[('Location') : locationName]), 0)

		commonMethodsObject.waitForProgressBarToBeInvisible()
	}


	/**
	 * Search the product 
	 * @param locationName (name of the location)
	 * @param productName (name of the product)
	 * @param costType (cost of the product)
	 * @param quantity (quantity of the product)
	 */

	@Keyword
	def searchAndAddProductByCreatingNewLocation(String locationName, String productName,String costType, String quantity) {

		if (Mobile.verifyElementExist(findTestObject('Android/inventory/inventoryDetailScreen/verificationDetails/createdLocation_TextView', [('TEXT') : locationName]),4, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Android/inventory/inventoryDetailScreen/verificationDetails/createdLocation_TextView', [('TEXT') : locationName]), 0)
		}

		Mobile.tap(findTestObject('Android/productSearch/searchProductsSearchView_EditText'), 0,FailureHandling.OPTIONAL)

		commonMethodsObject.waitForProgressBarToBeInvisible()

		Mobile.setText(findTestObject('Android/productSearch/searchProductsSearchView_EditText'), productName + '\\n',0)

		commonMethodsObject.waitForProgressBarToBeInvisible()

		locationDetailsScreenObject.addQuantityforTheSearchedProduct(quantity)

		Mobile.tap(findTestObject('Android/productSearch/addToInventory_Button'), 0)

		Mobile.tap(findTestObject('Android/inventory/locationDetailsScreen/moveProductToAnotherLocation/createANewLocation_TextView'), 0)

		Mobile.tap(findTestObject('Android/inventory/inventoryDetailScreen/addLocation/locationName_TextField'), 0)

		Mobile.setText(findTestObject('Android/inventory/inventoryDetailScreen/addLocation/locationName_TextField'), locationName,  0)

		addCostType(costType)

		Mobile.tap(findTestObject('Android/inventory/inventoryDetailScreen/addLocation/createNewLocation_Button'), 0)

		Mobile.tap(findTestObject('Android/inventory/locationDetailsScreen/copyProductToAnotherLocation/Select_location_RadioButton'), 0)

		Mobile.tap(findTestObject('Android/inventory/inventoryDetailScreen/addProductToInventoryUsingSearchFromDashoboard/addToInventory_Button'), 0)

		commonMethodsObject.waitForProgressBarToBeInvisible()

		Mobile.tapAndHold(findTestObject('Android/inventory/locationDetailsScreen/addProductToLocation/goToLocationAfterAddingProduct_TextView',[('Location') : locationName]) ,0,0)
	}


	/**
	 * Verify inventory details
	 * @param inventoryName (name of the inventory)
	 */

	@Keyword
	def verifyInventoryDetailsScreen(String inventoryName) {

		Mobile.verifyElementExist(findTestObject('Android/inventory/inventoryDetailScreen/verificationDetails/createdOnDate_TextView'),0)

		Mobile.verifyElementExist(findTestObject('Android/inventory/inventoryDetailScreen/verificationDetails/inventoryHeader_TextView'),0)

		Mobile.verifyElementExist(findTestObject('Android/inventory/inventoryDetailScreen/verificationDetails/scan_Icon'),0)

		Mobile.verifyElementExist(findTestObject('Android/inventory/inventoryDetailScreen/verificationDetails/inventoryName_TextView',[('TEXT'):inventoryName]),0)
	}

	/**
	 * verifies the location count, cost gets updated or not, of the inventory after the location is deleted
	 * @param locationName (name of the location under verification)
	 */
	@Keyword
	def deleteLocationWithCostLocationCountVerification(String locationName) {

		int initialInventoryLocationCount=Mobile.getText(findTestObject('Android/inventory/locationDetailsScreen/verificationDetails/inventoryLine_Text'), 0)// initial inventory location count

		String initialInventoryTotal=Mobile.getText(findTestObject('Android/inventory/locationDetailsScreen/verificationDetails/inventoryTotal_Text'), 0)// inventory value with location added

		String locationValue=Mobile.getText(findTestObject('Android/inventory/locationDetailsScreen/verificationDetails/locationValue_Text'), 0)//location value with added product

		float inventoryTotal_dollarSymbolRemoved_FloatValue=(new common.commonMethods()).floatValueGenerator(initialInventoryTotal)//converting initialInventoryTotal string to a float value

		float locationValue_dollarSymbolRemoved_FloatValue=(new common.commonMethods()).floatValueGenerator(locationValue)//converting locationValue string to a float value

		(new androidInventory.inventoryDetailsScreen()).deleteLocation(locationName)//calling delete location function

		commonMethodsObject.waitForProgressBarToBeInvisible()

		commonMethodsObject.pressBacknav()

		int finalInventoryLocationCount=Mobile.getText(findTestObject('Android/inventory/locationDetailsScreen/verificationDetails/noOfLocation_Text'), 0)//final inventory location count after deleting a location

		String finalInventoryTotal=Mobile.getText(findTestObject('Android/inventory/locationDetailsScreen/verificationDetails/inventoryLocationValue_Text'), 0)//final inventory total after deleting a location

		float finalInventoryTotal_charactersRemoved_FloatValue=(new common.commonMethods()).floatValueGenerator(finalInventoryTotal)///converting finalInventoryTotal string to a float value

		KeywordUtil.logInfo("initialInventoryTotal is " + initialInventoryTotal );
		KeywordUtil.logInfo("locationValue is " + locationValue );
		KeywordUtil.logInfo("inventoryTotal_dollarSymbolRemoved_FloatValue is " + inventoryTotal_dollarSymbolRemoved_FloatValue );
		KeywordUtil.logInfo("locationValue_dollarSymbolRemoved_FloatValue is " + locationValue_dollarSymbolRemoved_FloatValue );
		KeywordUtil.logInfo("finalInventoryLocationCount is " + finalInventoryLocationCount );
		KeywordUtil.logInfo("finalInventoryTotal is " + finalInventoryTotal );
		KeywordUtil.logInfo("finalInventoryTotal_charactersRemoved_FloatValue is " + finalInventoryTotal_charactersRemoved_FloatValue );


		assert inventoryTotal_dollarSymbolRemoved_FloatValue==(finalInventoryTotal_charactersRemoved_FloatValue+locationValue_dollarSymbolRemoved_FloatValue)

		assert finalInventoryLocationCount==(initialInventoryLocationCount-1)
	}

	/**
	 * deletes the location
	 * @param locationName (name of the location to be deleted)
	 */
	@Keyword
	def deleteLocation(String locationName) {

		int elementTopPosition = Mobile.getElementTopPosition(findTestObject('Android/inventory/inventoryDetailScreen/addLocation/tapOnLocation_Text', [('Location') : locationName]), 0)

		int elementHeight=Mobile.getElementHeight(findTestObject('Android/inventory/inventoryDetailScreen/addLocation/tapOnLocation_Text', [('Location') : locationName]), 0)

		int y_Coordinate=(elementHeight/2)+elementTopPosition

		int elementLeftPosition=Mobile.getElementLeftPosition(findTestObject('Android/inventory/locationDetailsScreen/deleteLocation/slidePopUpForLocationDeletion_Button'), 0)

		int elementWidth=Mobile.getElementWidth(findTestObject('Android/inventory/locationDetailsScreen/deleteLocation/slidePopUpForLocationDeletion_Button'), 0)

		int x_Coordinate=(elementWidth/2)+elementLeftPosition

		Mobile.tapAtPosition(x_Coordinate, y_Coordinate)

		Mobile.tap(	findTestObject('Android/inventory/inventoryListingScreen/deleteInventory/delete_Button'), 0)

		Mobile.verifyElementExist(findTestObject('Android/inventory/locationDetailsScreen/deleteLocation/selectingYesWillAlsoDeleteThisLocationsInventoryOnTheWebsiteAndCannotBeUndone_Text'),0)

		Mobile.tap(findTestObject('Android/inventory/inventoryListingScreen/createNewInventoryScreen/yes_Button'), 0)

		commonMethodsObject.waitForProgressBarToBeInvisible()

		Mobile.verifyElementNotVisible(findTestObject('Android/inventory/inventoryDetailScreen/addLocation/locationNameVerification_Text', [('LName') : locationName]),0)
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

		Mobile.tap(findTestObject('Android/productSearch/scanFlow/scanIcon_EditText'), 0,,FailureHandling.OPTIONAL)

		commonMethodsObject.waitForProgressBarToBeInvisible()

		'calling the function which selects the countType required for a product which is searched and takes countType as the argument'
		(new androidInventory.locationDetailsScreen()).selectCountTypeForTheProductToBeAdded(countType)

		'calling the function which scans the product and adds it to the location, it takes productName/UPC/Cin/Ndc as the argument'
		(new androidInventory.locationDetailsScreen()).scanInputEvent(productName)

		'calling the function which adds quantity required for a product to be added and takes quantity required as the argument'
		(new androidInventory.locationDetailsScreen()).addQuantityforTheSearchedProduct(quantity)

		Mobile.tap(findTestObject('Android/inventory/inventoryDetailScreen/addProductToInventoryUsingSearchFromInventoryDetailsScreen/addItemFromAlternate_Button'), 0)

		Mobile.tap(findTestObject('Android/inventory/inventoryDetailScreen/addProductToInventoryUsingSearchFromInventoryDetailsScreen/createLocation_Label'), 0)

		Mobile.tap(findTestObject('Android/inventory/inventoryDetailScreen/addProductToInventoryUsingSearchFromInventoryDetailsScreen/locationName_Button'), 0)

		Mobile.setText(findTestObject('Android/inventory/inventoryDetailScreen/addProductToInventoryUsingSearchFromInventoryDetailsScreen/locationName_TextField'), locationName, 0)

		(new androidInventory.inventoryDetailsScreen()).addCostType(costType)

		Mobile.tap(findTestObject('Android/inventory/inventoryDetailScreen/addProductToInventoryUsingSearchFromInventoryDetailsScreen/createNewLocation_Button'), 0)

		Mobile.tap(findTestObject('Android/inventory/inventoryDetailScreen/addProductToInventoryUsingSearchFromInventoryDetailsScreen/createdLocation_Text',[('TEXT'):locationName]), 0)

		Mobile.tap(findTestObject('Android/inventory/inventoryDetailScreen/addProductToInventoryUsingSearchFromInventoryDetailsScreen/location_RadioButton'), 0)

		Mobile.tap(findTestObject('Android/inventory/inventoryDetailScreen/addProductToInventoryUsingSearchFromInventoryDetailsScreen/addToInventory_Button'), 0)

		Mobile.tap(findTestObject('Android/inventory/inventoryDetailScreen/addProductToInventoryUsingSearchFromInventoryDetailsScreen/goToLocation_button'), 0)
	}


	/**
	 * this function verifies that the product is visible on the screen after it is searched from inventory details screen
	 * @param productIdentificationNumber (productIdentificationNumber of the product which can be NDC/Cin/UPC, which should be present on the screen)
	 */
	@Keyword
	def verifyProductIsVisibleOnScreenWhenSearchedFromInventoryDetailsScreen(productIdentificationNumber) {

		String testObj='Android/inventory/inventoryDetailScreen/addProductToInventoryUsingSearchFromInventoryDetailsScreen/alternateNDC_Text'

		(new androidCommonKeywords.commonMethods()).verifyProductIsVisibleOnTheScreen(testObj,productIdentificationNumber)//calling verifyProductIsVisibleOnTheScreen function and passing testObj, topProductIdentificationNumber as the arguments

	}

	/**
	 * opens the particular location details
	 * @param locationName (name of the location)
	 */
	@Keyword
	def clickOnALocation(String locationName) {

		Mobile.tap(findTestObject('Android/inventory/inventoryDetailScreen/addLocation/tapOnLocation_Text', [('Location') : locationName]), 0)

		commonMethodsObject.waitForProgressBarToBeInvisible()
	}

	/**
	 * this function verifies the location count
	 * @param expectedLocationCount (expected location Count)
	 */
	@Keyword
	def verifyLocationCount(String expectedLocationCount) {

		String actualLocationCount=Mobile.getText(findTestObject('Android/inventory/locationDetailsScreen/verificationDetails/inventoryLine_Text'),0) //gets the actual Location Count on the inventory details page

		assert actualLocationCount==expectedLocationCount //actual location count has to be equal to expected lines count

	}
}