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


class locationDetailsScreen {


	/**
	 * adds products to a location
	 * @param locationName (name of the location),productName (name of the product to be added)
	 */
	@Keyword
	def add_Product_to_Location(String locationName, String productName) {

		Mobile.tapAndHold(findTestObject('iOS/Inventory/Location Details_Screen/Add Product to Location/Product SearchField'), 0, 0)

		(new iosCommonKeywords.commonMethods()).waitForProgressBarToBeInvisible()

		Mobile.setText(findTestObject('iOS/Inventory/Location Details_Screen/Add Product to Location/Product SearchField'), productName, 0)

		Mobile.tapAndHold(findTestObject('iOS/Product_Search/Search Key_Button'), 0, 0)

		(new iosCommonKeywords.commonMethods()).waitForProgressBarToBeInvisible()

		Mobile.tap(findTestObject('iOS/Inventory/Location Details_Screen/Add Product to Location/Add Product to Location_Text', [('Location') : locationName]),0)

		Mobile.tap(findTestObject('iOS/Inventory/Location Details_Screen/Add Product to Location/Continue Browsing After Adding Product_Text'), 0)
	}




	/**
	 * this function taps on remove button and then product entry should get removed from the location as well as the scan result screen
	 */
	@Keyword
	def clickOnRemoveButtonToRemoveAlreadyScannedProduct() {

		Mobile.verifyElementExist(findTestObject('iOS/Inventory/Location Details_Screen/Add Product to Location/thisItemHasBeenAddedToYourLocation_Text'),0)

		Mobile.tap(findTestObject('iOS/Product_Search/removeItem_Button'), 0)

		Mobile.tap(findTestObject('iOS/Product_Search/yes_Text'), 0)
	}




	/**
	 * taps on scan and adds product based on count type of partial or full count
	 * @param productName (name of the product to be added),countType (count type required which can be partial or full count),quantity (quantity of the product required to be added)
	 */
	@Keyword
	def clickOnScanIconAndAddProduct(String productName, String countType, String quantity) {

		Mobile.tap(findTestObject('iOS/Orders/Order Details Page/Scan Order/scan_Icon'), 0)

		Mobile.tap(findTestObject('iOS/Orders/Order Details Page/Scan Order/scanGray_Image'), 0)

		Mobile.setText(findTestObject('iOS/Orders/Order Details Page/Scan Order/enterBarcode_TextField'), productName, 0)

		if(countType=="Full Count") {
			Mobile.tap(findTestObject('iOS/Orders/Order Details Page/Scan Order/fullCount_Button'), 0)
		}
		else {
			Mobile.tap(findTestObject('iOS/Orders/Order Details Page/Scan Order/partialCount_Button'), 0)
		}
		Mobile.tap(findTestObject('iOS/Orders/Order Details Page/Scan Order/done_Button'), 0)

		Mobile.setText(findTestObject('iOS/Orders/Order Details Page/Scan Order/quantity_TextField'), quantity, 0)

		Mobile.tap(findTestObject('iOS/Orders/Order Details Page/Scan Order/done_Button'), 0)
	}



	/**
	 * copies products to another location
	 * @param locationName (name of the location to which product will be copied)
	 */
	@Keyword
	def copy_Product_to_Another_Location(String locationName) {

		(new iosCommonKeywords.commonMethods()).waitForProgressBarToBeInvisible()

		Mobile.tap(findTestObject('iOS/Inventory/Location Details_Screen/Delete_Location/Slide_PopUp_Button for Location Deletion'), 0)

		Mobile.tap(findTestObject('iOS/Inventory/Location Details_Screen/Copy Product from Location/Copy_Product_Text'), 0)

		Mobile.tap(findTestObject('iOS/Inventory/Location Details_Screen/Copy Product from Location/Move or Copy to Location_Text', [('Location') : locationName]), 0)

		Mobile.tap(findTestObject('iOS/Inventory/Location Details_Screen/Copy Product from Location/Copy_Product_Text'), 0)

		(new iosCommonKeywords.commonMethods()).waitForProgressBarToBeInvisible()

		Mobile.tap(findTestObject('iOS/Inventory/Location Details_Screen/Copy Product from Location/Go to Location after Move or Copy or Adding Product_Text', [('Location') : locationName]),0)
	}




	/**
	 * deletes a product from the added products list in a location
	 * @param ndcNumber (deletes the product according to the ndcNumber)
	 */
	@Keyword
	def deleteProduct(String ndcNumber) {

		String testObj='Object Repository/iOS/Inventory/Location Details_Screen/Delete Product/slidePopUpDeleteProduct_Button'

		int x_Coordinate=(new iosCommonKeywords.commonMethods()).tapXCoordinateGenerator(testObj)

		testObj='Object Repository/iOS/Inventory/Location Details_Screen/Delete Product/ndcNumber_Text'

		int y_Coordinate=(new iosCommonKeywords.commonMethods()).tapYCoordinateGenerator(testObj,ndcNumber)

		Mobile.tapAtPosition(x_Coordinate, y_Coordinate)

		Mobile.tap(findTestObject('Object Repository/iOS/Inventory/Location Details_Screen/Delete Product/deleteProduct_Text'), 0)

		Mobile.tap(findTestObject('iOS/Inventory/Location Details_Screen/Delete_Location/Yes_Text'), 0)
	}




	/**
	 * edits the location name and cost type can be changed(last price or current price paid)
	 * @param newLocationName (new name of the location),costType (cost type required which can be current or last price paid)
	 */
	@Keyword
	def edit_Location_Name(String newLocationName,String costType) {

		Mobile.tap(findTestObject('iOS/Inventory/Location Details_Screen/Edit_Location Name/Edit Location_Text'), 0)

		Mobile.clearText(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/LocationName_TextField'), 0)

		Mobile.setText(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/LocationName_TextField'), newLocationName, 0)

		if (costType == 'Last Price Paid') {
			Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/lastPrice_Button'), 0)
		} else {
			Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/currentPrice_Button'), 0)
		}

		Mobile.tap(findTestObject('iOS/Inventory/Location Details_Screen/Copy Product from Location/Save Changes_Text'), 0)

		(new iosCommonKeywords.commonMethods()).waitForProgressBarToBeInvisible()

		Mobile.verifyElementExist(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/locationNameVerification_Text', [('LName') : newLocationName]),0)
	}



	/**
	 * moves products to another location
	 * @param locationName (name of the location to which product will be moved)
	 */
	@Keyword
	def move_Product_to_Another_Location(String locationName) {


		Mobile.tap(findTestObject('iOS/Inventory/Location Details_Screen/Delete_Location/Slide_PopUp_Button for Location Deletion'), 0)

		Mobile.tap(findTestObject('iOS/Inventory/Location Details_Screen/Move Product to Another Location/Move_Product_Text'), 0)

		Mobile.tap(findTestObject('iOS/Inventory/Location Details_Screen/Copy Product from Location/Move or Copy to Location_Text', [('Location') : locationName]),0)

		Mobile.tap(findTestObject('iOS/Inventory/Location Details_Screen/Move Product to Another Location/Move_Product_Text'), 0)

		(new iosCommonKeywords.commonMethods()).waitForProgressBarToBeInvisible()

		Mobile.tap(findTestObject('iOS/Inventory/Location Details_Screen/Copy Product from Location/Go to Location after Move or Copy or Adding Product_Text', [('Location') : locationName]),0)
	}




	/**
	 * uploads location from the location details screen
	 */
	@Keyword
	def uploadLocation() {

		Mobile.tap(findTestObject('iOS/Inventory/Location Details_Screen/Upload Location/enabledUploadLocation_Button'), 0)

		Mobile.tap(findTestObject('iOS/Inventory/Location Details_Screen/Upload Location/gotIt_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Inventory/Location Details_Screen/Upload Location/disbaledUploadLocation_Button'), 0)
	}


	/**
	 * this function verifies that the product is not visible on the location details screen
	 */
	@Keyword
	def verifyProductIsNotVisibleOnTheLocationDetailsScreen(ndcNumber) {

		Mobile.verifyElementNotVisible(findTestObject('Object Repository/iOS/Inventory/Location Details_Screen/Delete Product/ndcNumber_Text',[('TEXT'):ndcNumber]),0)
	}





	/**
	 * this function verifies that the product is visible on the location details screen
	 */
	@Keyword
	def verifyProductIsVisibleOnTheLocationDetailsScreen(ndcNumber) {

		Mobile.verifyElementExist(findTestObject('Object Repository/iOS/Inventory/Location Details_Screen/Delete Product/ndcNumber_Text',[('TEXT'):ndcNumber]),0)
	}



	/**
	 * verifies details of location details screen
	 * @param locationName (name of the location under verification)
	 */
	@Keyword
	def verify_Location_details_Screen(String locationName) {

		Mobile.verifyElementExist(findTestObject('iOS/Inventory/Inventory Details Screen/Verification Details/Inventory Header_Label'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Product_Search/Scan_Icon'),0)

		Mobile.verifyElementExist(findTestObject('iOS/Inventory/Location Details_Screen/Share Location/Share Location_Text'), 0)

		//	Mobile.verifyElementExist(findTestObject('iOS/Inventory/Location Details_Screen/Verification Details/Created on Date_Text'),0)

		Mobile.verifyElementExist(findTestObject('iOS/Inventory/Location Details_Screen/Verification Details/Location Title_Label',[('TEXT'):locationName]),  0)
	}
}