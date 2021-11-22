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
	 * @param productName (name of the product to be added),countType (count type required which can be partial or full count),quantity (quantity of the product required to be added, if quantity is passed a tag of NULL, no quantity would be entered in the quantity text-field)
	 */
	@Keyword
	def clickOnScanIconAndAddProduct(String productName, String countType, String quantity) {

		Mobile.tap(findTestObject('iOS/Orders/Order Details Screen/Scan Order/scan_Icon'), 0)

		Mobile.tap(findTestObject('iOS/Orders/Order Details Screen/Scan Order/scanGray_Image'), 0)

		Mobile.setText(findTestObject('iOS/Orders/Order Details Screen/Scan Order/enterBarcode_TextField'), productName, 0)

		Mobile.setText(findTestObject('iOS/Orders/Order Details Page/Scan Order/enterBarcode_TextField'), productName, 0)

		Mobile.verifyElementAttributeValue(findTestObject('iOS/Orders/Order Details Page/Scan Order/fullCount_Button'), 'value', '1', 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Order Details Page/Scan Order/partialCount_Button'), 0)

		Mobile.setText(findTestObject('iOS/Orders/Order Details Page/Scan Order/enterBarcode_TextField'), productName, 0)

		if(countType=="Full Count") {
			Mobile.tap(findTestObject('iOS/Orders/Order Details Screen/Scan Order/fullCount_Button'), 0)
		}
		else {
			Mobile.tap(findTestObject('iOS/Orders/Order Details Screen/Scan Order/partialCount_Button'), 0)
		}
		Mobile.tap(findTestObject('iOS/Orders/Order Details Screen/Scan Order/done_Button'), 0)

		if(quantity!="NULL") //if quantity is passed a tag of NULL, no quantity would be entered in the quantity text-field
			Mobile.setText(findTestObject('iOS/Orders/Order Details Screen/Scan Order/quantity_TextField'), quantity, 0)

		Mobile.tap(findTestObject('iOS/Orders/Order Details Screen/Scan Order/done_Button'), 0)
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
	 * this function gets the total added quantity of the product
	 * @return quantity of the product which has been added
	 */
	@Keyword
	def returnQuantityOfTheAddedProduct() {

		int quantity= Mobile.getText(findTestObject('iOS/Inventory/Location Details_Screen/Add Product to Location/quantityOfAddedProduct_Text'), 0)

		return quantity
	}



	/**
	 * taps on shares location button, verifies the pop-up screen and closes the pop-up screen
	 */
	@Keyword
	def verifyShareLocationPopUp() {

		Mobile.tap(findTestObject('iOS/Inventory/Location Details_Screen/Share Location/shareLocation_Button'), 0)

		String verifyPopUpScreentestobj='iOS/Inventory/Location Details_Screen/Share Location/sharePopUpActivity_ListView' //reference of the popUp screen object

		(new iosCommonKeywords.commonMethods()).verifyPopUpScreenExist(verifyPopUpScreentestobj) // verifies popUp screen present

		String closePopUpScreentestobj='iOS/Inventory/Location Details_Screen/Share Location/close_Button' //reference of the close popUp screen button

		(new iosCommonKeywords.commonMethods()).closePopUpScreen(closePopUpScreentestobj) // closes the popUp screen

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
	 * verifies details of location details screen (if user wants to scan a product with same count type more than once, then in the test case, only the updated quantity along with countType and ndcNumber should be pushed into the stack)
	 * @param expectedLinesCount (lines count which is expected), countTypeStack (stack of the countTypes selected for adding each product), quantityStack (stack of the quantity added for each product), productNdcStack (stack of the ndcNumbers of added products)
	 */
	@Keyword
	def verifyLocationDetailsScreen(String expectedLinesCount, Stack countTypeStack, Stack quantityStack, Stack productNdcStack) {

		String topProductCountType, topProductQuantity, topProductNdc

		String actualLinesCount=Mobile.getText(findTestObject('Object Repository/iOS/Inventory/Location Details_Screen/Verification Details/inventoryLine_Text'),0) //gets the actualLinesCount on the location details page

		assert actualLinesCount==(expectedLinesCount) // verifies actualLinesCount equals the expectedLinesCount

		while(!countTypeStack.isEmpty() && !quantityStack.isEmpty() && !productNdcStack.isEmpty()) //loops while countType, quantity, productNdcStack is not empty
		{

			topProductCountType=countTypeStack.pop() //pops the top countType from the countTypeStack and stores value in the topProductCountType

			topProductQuantity=quantityStack.pop() //pops the top quantity from the quantityStack and stores value in the topProductQuantity

			topProductNdc=productNdcStack.pop() //pops the top ndcNumber from the productNdcStack and stores value in the topProductNdc

			String countType=Mobile.getText(findTestObject('iOS/Inventory/Location Details_Screen/Verification Details/addedProductCountType_Text'),0) //gets the countType of the top added product in the location details page

			String quantity=Mobile.getText(findTestObject('iOS/Inventory/Location Details_Screen/Verification Details/addedProductQuanity_Text'),0) //gets the quantity of the top added product in the location details page

			if (topProductCountType=="Partial Count") //condition added because in case of partial count the quantity added won't end with a (.0) for e.g full count-(1.0), partial count (1)
			{
				assert quantity==(topProductQuantity) // verifies quantity equals the quantity of the topmost product in the products list
			}

			else

			{
				assert (quantity)==(topProductQuantity+".0") // verifies quantity equals the quantity of the topmost product in the products list
			}

			assert (countType+" COUNT")==(topProductCountType.toUpperCase()) // verifies countType equals the countType of the topmost product in the products list

			(new iosInventory.locationDetailsScreen()).deleteProduct(topProductNdc)//calling delete product function and passing the topProductNdc

		}

	}




	/**
	 * this function verifies that the product is not visible on the location details screen
	 * @param ndcNumber (ndcNumber of the product which should not be present on the screen)
	 */
	@Keyword
	def verifyProductIsNotVisibleOnTheLocationDetailsScreen(ndcNumber) {

		Mobile.verifyElementNotVisible(findTestObject('Object Repository/iOS/Inventory/Location Details_Screen/Delete Product/ndcNumber_Text',[('TEXT'):ndcNumber]),0)
	}


	/**
	 * this function verifies that the product is visible on the location details screen
	 * @param ndcNumber (ndcNumber of the product which should be present on the screen)
	 */
	@Keyword
	def verifyProductIsVisibleOnTheLocationDetailsScreen(ndcNumber) {

		Mobile.verifyElementExist(findTestObject('Object Repository/iOS/Inventory/Location Details_Screen/Delete Product/ndcNumber_Text',[('TEXT'):ndcNumber]),0)
	}



}