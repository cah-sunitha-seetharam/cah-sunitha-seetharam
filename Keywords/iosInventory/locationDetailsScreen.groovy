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

		Mobile.tapAndHold(findTestObject('iOS/Inventory/Location Details Screen/Add Product to Location/productSearch_TextField'), 0, 0)

		(new iosCommonKeywords.commonMethods()).waitForProgressBarToBeInvisible()

		Mobile.setText(findTestObject('iOS/Inventory/Location Details Screen/Add Product to Location/productSearch_TextField'), productName, 0)

		Mobile.tapAndHold(findTestObject('iOS/Product_Search/Search Key_Button'), 0, 0)

		(new iosCommonKeywords.commonMethods()).waitForProgressBarToBeInvisible()

		Mobile.tap(findTestObject('iOS/Inventory/Location Details Screen/Add Product to Location/Add Product to Location_Text', [('Location') : locationName]),0)

		Mobile.tap(findTestObject('iOS/Inventory/Location Details Screen/Add Product to Location/Continue Browsing After Adding Product_Text'), 0)
	}


	/**
	 * this function adds the quantity for the product to be searched
	 * @param quantity (quantity required to be added for the product to be searched)
	 */
	@Keyword
	def addQuantityforTheSearchedProduct(String quantity) {

		Mobile.setText(findTestObject('iOS/Orders/Order Details Page/Scan Order/quantity_TextField'), quantity, 0)

		Mobile.tap(findTestObject('iOS/Orders/Order Details Page/Scan Order/done_Button'), 0)
	}




	/**
	 * this function taps on remove button and then product entry should get removed from the location as well as the scan result screen
	 */
	@Keyword
	def clickOnRemoveButtonToRemoveAlreadyScannedProduct() {

		Mobile.verifyElementExist(findTestObject('iOS/Inventory/Location Details Screen/Add Product to Location/thisItemHasBeenAddedToYourLocation_Text'),0)

		Mobile.tap(findTestObject('iOS/Product_Search/removeItem_Button'), 0)

		Mobile.tap(findTestObject('iOS/Product_Search/yes_Text'), 0)
	}




	/**
	 * scans the product and adds it to the location 
	 * @param productToBeSearched (name which can be a productName/Cin/NDC of the product to be added)
	 */
	@Keyword
	def startScanningProduct(String productToBeSearched) {

		Mobile.tap(findTestObject('iOS/Orders/Order Details Page/Scan Order/scanGray_Image'), 0)

		Mobile.setText(findTestObject('iOS/Orders/Order Details Page/Scan Order/enterBarcode_TextField'), productToBeSearched, 0)
	}



	/**
	 * taps on scan icon and takes user to scanning product screen and also verifies that the default toggle is at full count
	 * @param productName (name which can be a productName/Cin/NDC of the product to be added)
	 */
	@Keyword
	def clickOnScanIcon() {

		Mobile.tap(findTestObject('iOS/Orders/Order Details Page/Scan Order/scan_Icon'), 0)

		Mobile.verifyElementAttributeValue(findTestObject('iOS/Orders/Order Details Page/Scan Order/fullCount_Button'), 'value', '1', 0)

		Mobile.verifyElementExist(findTestObject('iOS/Orders/Order Details Page/Scan Order/partialCount_Button'), 0)
	}



	/**
	 * this function select CountType for the product to be added 
	 * @param countType (countType required to be selected for the product to be added)
	 */
	@Keyword
	def selectCountTypeForTheProductToBeAdded(String countType) {

		if(countType=="Full Count") {
			Mobile.tap(findTestObject('iOS/Orders/Order Details Page/Scan Order/fullCount_Button'), 0)
		}
		else {
			Mobile.tap(findTestObject('iOS/Orders/Order Details Page/Scan Order/partialCount_Button'), 0)
		}
		Mobile.tap(findTestObject('iOS/Orders/Order Details Page/Scan Order/done_Button'), 0)
	}



	/**
	 * copies products to another location
	 * @param locationName (name of the location to which product will be copied)
	 */
	@Keyword
	def copyProductToAnotherLocation(String locationName, String productIdentificationNumber) {

		String testObj='Object Repository/iOS/Inventory/Location Details Screen/Delete Product/slidePopUpDeleteProduct_Button'

		int x_Coordinate=(new iosCommonKeywords.commonMethods()).tapXCoordinateGenerator(testObj)

		testObj='Object Repository/iOS/Inventory/Location Details Screen/Delete Product/ndcNumber_Text'

		int y_Coordinate=(new iosCommonKeywords.commonMethods()).tapYCoordinateGenerator(testObj,productIdentificationNumber)

		Mobile.tapAtPosition(x_Coordinate, y_Coordinate)

		Mobile.tap(findTestObject('iOS/Inventory/Location Details Screen/Copy Product from Location/copyProduct_Text'), 0)

		Mobile.tap(findTestObject('iOS/Inventory/Location Details Screen/Copy Product from Location/copyToLocation_Text', [('Location') : locationName]), 0)

		Mobile.tap(findTestObject('iOS/Inventory/Location Details Screen/Copy Product from Location/copyProduct_Text'), 0)

		(new iosCommonKeywords.commonMethods()).waitForProgressBarToBeInvisible()

		Mobile.tap(findTestObject('iOS/Inventory/Location Details Screen/Copy Product from Location/goToLocationAfterCopyingProduct_Text', [('Location') : locationName]),0)
	}




	/**
	 * deletes a product from the added products list in a location
	 * @param productIdentificationNumber (deletes the product according to the productIdentificationNumber which can be NDC/Cin/UPC)
	 */
	@Keyword
	def deleteProduct(String productIdentificationNumber) {

		String testObj='Object Repository/iOS/Inventory/Location Details Screen/Delete Product/slidePopUpDeleteProduct_Button'

		int x_Coordinate=(new iosCommonKeywords.commonMethods()).tapXCoordinateGenerator(testObj)

		testObj='Object Repository/iOS/Inventory/Location Details Screen/Delete Product/ndcNumber_Text'

		int y_Coordinate=(new iosCommonKeywords.commonMethods()).tapYCoordinateGenerator(testObj,productIdentificationNumber)

		Mobile.tapAtPosition(x_Coordinate, y_Coordinate)

		Mobile.tap(findTestObject('iOS/Inventory/Location Details Screen/Delete Product/deleteProduct_Text'), 0)

		Mobile.tap(findTestObject('iOS/Inventory/Location Details Screen/Delete Location/Yes_Text'), 0)
	}




	/**
	 * edits the location name and cost type can be changed(last price or current price paid)
	 * @param newLocationName (new name of the location),costType (cost type required which can be current or last price paid)
	 */
	@Keyword
	def edit_Location_Name(String newLocationName,String costType) {

		Mobile.tap(findTestObject('iOS/Inventory/Location Details Screen/Edit_Location Name/Edit Location_Text'), 0)

		Mobile.clearText(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/LocationName_TextField'), 0)

		Mobile.setText(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/LocationName_TextField'), newLocationName, 0)

		if (costType == 'Last Price Paid') {
			Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/lastPrice_Button'), 0)
		} else {
			Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/currentPrice_Button'), 0)
		}

		Mobile.tap(findTestObject('iOS/Inventory/Location Details Screen/Edit_Location Name/Save Changes_Text (1)'), 0)

		(new iosCommonKeywords.commonMethods()).waitForProgressBarToBeInvisible()

		Mobile.verifyElementExist(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/locationNameVerification_Text', [('LName') : newLocationName]),0)
	}



	/**
	 * moves products to another location
	 * @param locationName (name of the location to which product will be moved)
	 */
	@Keyword
	def moveProductToAnotherLocation(String locationName, String productIdentificationNumber) {

		String testObj='Object Repository/iOS/Inventory/Location Details Screen/Delete Product/slidePopUpDeleteProduct_Button'

		int x_Coordinate=(new iosCommonKeywords.commonMethods()).tapXCoordinateGenerator(testObj)

		testObj='Object Repository/iOS/Inventory/Location Details Screen/Delete Product/ndcNumber_Text'

		int y_Coordinate=(new iosCommonKeywords.commonMethods()).tapYCoordinateGenerator(testObj,productIdentificationNumber)

		Mobile.tapAtPosition(x_Coordinate, y_Coordinate)

		Mobile.tap(findTestObject('iOS/Inventory/Location Details Screen/Move Product to Another Location/moveProduct_Text'), 0)

		Mobile.tap(findTestObject('Object Repository/iOS/Inventory/Location Details Screen/Move Product to Another Location/moveToLocation_Text', [('Location') : locationName]),0)

		Mobile.tap(findTestObject('iOS/Inventory/Location Details Screen/Move Product to Another Location/moveProduct_Text'), 0)

		(new iosCommonKeywords.commonMethods()).waitForProgressBarToBeInvisible()

		Mobile.tap(findTestObject('iOS/Inventory/Location Details Screen/Move Product To Another Location/goToLocationAfterMovingProduct_Text', [('Location') : locationName]),0)

	}


	

	/**
	 * this function gets the total added quantity of the product
	 * @return quantity of the product which has been added
	 */
	@Keyword
	def returnQuantityOfTheAddedProduct() {

		int quantity= Mobile.getText(findTestObject('iOS/Inventory/Location Details Screen/Add Product to Location/quantityAdded_Text'), 0)

		return quantity
	}




	/**
	 * uploads location from the location details screen
	 */
	@Keyword
	def uploadLocation() {

		Mobile.tap(findTestObject('iOS/Inventory/Location Details Screen/Upload Location/enabledUploadLocation_Button'), 0)

		Mobile.tap(findTestObject('iOS/Inventory/Location Details Screen/Upload Location/gotIt_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Inventory/Location Details Screen/Upload Location/disbaledUploadLocation_Button'), 0)
	}




	/**
	 * verifies details of location details screen (if user wants to scan a product with same count type more than once, then in the test case, only the updated quantity along with countType and ndcNumber should be pushed into the stack)
	 * @param expectedLinesCount (lines count which is expected), countTypeStack (stack of the countTypes selected for adding each product), quantityStack (stack of the quantity added for each product), productNdcStack (stack of the ndcNumbers of added products)
	 */
	@Keyword
	def verifyLocationDetailsScreen(String expectedLinesCount, Stack countTypeStack, Stack quantityStack, Stack productNdcStack) {

		String topProductCountType, topProductQuantity, topProductNdc

		String actualLinesCount=Mobile.getText(findTestObject('iOS/Inventory/Location Details Screen/Verification Details/inventoryLine_Text'),0) //gets the actualLinesCount on the location details page

		assert actualLinesCount==(expectedLinesCount) // verifies actualLinesCount equals the expectedLinesCount

		while(!countTypeStack.isEmpty() && !quantityStack.isEmpty() && !productNdcStack.isEmpty()) //loops while countType, quantity, productNdcStack is not empty
		{

			topProductCountType=countTypeStack.pop() //pops the top countType from the countTypeStack and stores value in the topProductCountType

			topProductQuantity=quantityStack.pop() //pops the top quantity from the quantityStack and stores value in the topProductQuantity

			topProductNdc=productNdcStack.pop() //pops the top ndcNumber from the productNdcStack and stores value in the topProductNdc

			String countType=Mobile.getText(findTestObject('iOS/Inventory/Location Details Screen/Verification Details/addedProductCountType_Text'),0) //gets the countType of the top added product in the location details page

			String quantity=Mobile.getText(findTestObject('iOS/Inventory/Location Details Screen/Verification Details/addedProductQuanity_Text'),0) //gets the quantity of the top added product in the location details page

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
	 * @param productIdentificationNumber (productIdentificationNumber of the product which can be NDC/Cin/UPC, which should not be present on the screen)
	 */
	@Keyword
	def verifyProductIsNotVisibleOnTheLocationDetailsScreen(productIdentificationNumber) {

		String testObj='Object Repository/iOS/Inventory/Location Details Screen/Delete Product/ndcNumber_Text'

		Mobile.verifyElementNotVisible(findTestObject(testObj,[('TEXT'):productIdentificationNumber]),0)
	}



	/**
	 * this function verifies that the product is not visible on the location details screen
	 * @param productIdentificationNumber (productIdentificationNumber of the product which can be NDC/Cin/UPC, which should be present on the screen)
	 */
	@Keyword
	def verifyProductIsVisibleOnTheLocationDetailsScreen(productIdentificationNumber) {

		String testObj='Object Repository/iOS/Inventory/Location Details Screen/Delete Product/ndcNumber_Text'

		Mobile.verifyElementExist(findTestObject(testObj,[('TEXT'):productIdentificationNumber]),0)
	}


	/**
	 * this function verifies the location details screen without any added product
	 */
	@Keyword
	def verifyLocationDetailsScreenWithoutAddedProduct() {

		String actualLinesCount=Mobile.getText(findTestObject('iOS/Inventory/Location Details Screen/Verification Details/inventoryLine_Text'),0) //gets the actualLinesCount on the location details page

		assert actualLinesCount=='0' //line count has to be 0 without any added product in the location

		String inventoryTotal=Mobile.getText(findTestObject('iOS/Inventory/Location Details Screen/Verification Details/inventoryTotal_Text'), 0)// inventory value with location added

		float inventoryTotal_dollarSymbolRemoved_FloatValue=(new common.commonMethods()).floatValueGenerator(inventoryTotal)//converting initialInventoryTotal string to a float value

		assert inventoryTotal_dollarSymbolRemoved_FloatValue==(0.00) //without added product, inventoryTotalValue has to be 0.00

	}


	/**
	 * verifies that the latest added product is at the top of the added products list, then deletes the latest added product and continues the process to verifyReverseChronologicalOrder of the added products
	 * @param productIdentificationNumbersStack (parameter is the stack of productIdentificationNumbers of the added products)
	 */
	@Keyword
	def verifyReverseChronologicalOrder(Stack productIdentificationNumbersStack) {

		String topProductIdentificationNumber

		while(!productIdentificationNumbersStack.isEmpty()) //loops while productIdentificationNumbersStack is not empty
		{

			String actualproductIdentificationNumber, testObj='iOS/Inventory/Location Details Screen/Verification Details/ndc_Label'

			topProductIdentificationNumber=productIdentificationNumbersStack.pop() //pops the top ProductIdentificationNumber from the productNdcStack and stores value in the topProductNdc

			actualproductIdentificationNumber=Mobile.getText(findTestObject(testObj),0) //gets the ProductIdentificationNumber of the top added product in the location details page

			assert actualproductIdentificationNumber==("NDC: "+topProductIdentificationNumber) // verifies actualproductIdentificationNumber equals the ProductIdentificationNumber of the topmost product in the products list

			(new iosInventory.locationDetailsScreen()).deleteProduct(topProductIdentificationNumber)//calling delete product function and passing the topProductIdentificationNumber

		}

	}



	/**
	 * taps on shares location button, verifies the pop-up screen and closes the pop-up screen
	 */
	@Keyword
	def verifyShareLocationPopUp() {

		Mobile.tap(findTestObject('iOS/Inventory/Location Details Screen/Share Location/shareLocation_Button'), 0)

		String verifyPopUpScreentestobj='iOS/Inventory/Location Details Screen/Share Location/sharePopUpActivity_ListView' //reference of the popUp screen object

		(new iosCommonKeywords.commonMethods()).verifyPopUpScreenExist(verifyPopUpScreentestobj) // verifies popUp screen present

		String closePopUpScreentestobj='iOS/Inventory/Location Details Screen/Share Location/close_Button' //reference of the close popUp screen button

		(new iosCommonKeywords.commonMethods()).closePopUpScreen(closePopUpScreentestobj) // closes the popUp screen

	}
}