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
import java.math.RoundingMode
import java.text.DecimalFormat


class locationDetailsScreen {

	def commonMethodsObject=new commonMethods();


	/**
	 * adds products to a location
	 * @param locationName (name of the location)
	 * @param productName (name of the product to be added)
	 */
	@Keyword
	def addProducttoLocation(String locationName, String productName) {

		Mobile.tapAndHold(findTestObject('iOS/Inventory/Location Details Screen/Add Product to Location/productSearch_TextField'), 0, 0)

		commonMethodsObject.waitForProgressBarToBeInvisible()

		Mobile.setText(findTestObject('iOS/Inventory/Location Details Screen/Add Product to Location/productSearch_TextField'), productName, 0)

		Mobile.tapAndHold(findTestObject('iOS/Product Search/search_Keypad'), 0, 0)

		commonMethodsObject.waitForProgressBarToBeInvisible()

		Mobile.tap(findTestObject('iOS/Inventory/Location Details Screen/Add Product to Location/addProductToLocation_Text', [('Location') : locationName]),0)

		Mobile.tap(findTestObject('iOS/Inventory/Location Details Screen/Add Product to Location/continueBrowsingAfterAddingProduct_Text'), 0)
	}


	/**
	 * this function inputs the quantity value for the product to be searched
	 * @param quantity (quantity required to be added for the product to be searched)
	 */
	@Keyword
	def addQuantityforTheSearchedProduct(String quantity) {

		Mobile.setText(findTestObject('iOS/Product Search/Scan Flow/quantity_TextField'), quantity, 0)

		Mobile.tap(findTestObject('iOS/Product Search/Scan Flow/done_Button'), 0)
	}




	/**
	 * this function taps on remove button and then product entry should get removed from the location as well as the scan result screen
	 */
	@Keyword
	def clickOnRemoveButtonToRemoveAlreadyScannedProduct() {

		Mobile.verifyElementExist(findTestObject('iOS/Inventory/Location Details Screen/Add Product to Location/thisItemHasBeenAddedToYourLocation_Text'),0)

		Mobile.tap(findTestObject('iOS/Product Search/removeItem_Button'), 0)

		Mobile.tap(findTestObject('iOS/Product Search/yes_Text'), 0)
	}




	/**
	 * taps on scan icon and takes user to scanning product screen and also verifies that the default toggle is at full count
	 */
	@Keyword
	def clickOnScanIcon() {

		Mobile.tap(findTestObject('iOS/Product Search/Scan Flow/scan_Icon'), 0)

		commonMethodsObject.waitForProgressBarToBeInvisible()

		Mobile.verifyElementAttributeValue(findTestObject('iOS/Product Search/Scan Flow/fullCount_Button'), 'value', '1', 0)

		Mobile.verifyElementExist(findTestObject('iOS/Product Search/Scan Flow/partialCount_Button'), 0)
	}



	/**
	 * copies products from a location to another location
	 * @param locationName (name of the location to which product will be copied)
	 * @param productNdcNumber (using NDC of the product which is visible on the product tab)
	 * if in future upc/cin are visible then the method can be modified accordingly by passing the respective test object	 */
	@Keyword
	def copyProductToAnotherLocation(String locationName, String productNdcNumber) {

		//String testObj='Object Repository/iOS/Inventory/Location Details Screen/Delete Product/slidePopUpDeleteProduct_Button'
		String testObj='Object Repository/iOS/Inventory/Location Details Screen/Verification Details/slidePopUp_Button'

		int x_Coordinate=(new iosCommonKeywords.commonMethods()).tapXCoordinateGenerator(testObj)

		testObj='Object Repository/iOS/Inventory/Location Details Screen/Delete Product/ndcNumber_Text'

		int y_Coordinate=(new iosCommonKeywords.commonMethods()).tapYCoordinateGenerator(testObj,productNdcNumber)

		Mobile.tapAtPosition(x_Coordinate, y_Coordinate)

		//Mobile.tap(findTestObject('iOS/Inventory/Location Details Screen/Copy Product from Location/copyProduct_Text'), 0)

		Mobile.tap(	findTestObject('iOS/Inventory/Location Details Screen/Copy Product from Location/copy_Button'), 0)

		Mobile.tap(findTestObject('iOS/Inventory/Location Details Screen/Copy Product from Location/copyToLocation_Text', [('Location') : locationName]), 0)

		Mobile.tap(findTestObject('iOS/Inventory/Location Details Screen/Copy Product from Location/copyProduct_Text'), 0)

		commonMethodsObject.waitForProgressBarToBeInvisible()

		Mobile.verifyElementExist(findTestObject('iOS/Inventory/Location Details Screen/Copy Product from Location/copyingProductConfirmation_Text',[('TEXT'):locationName]),0)

		Mobile.verifyElementExist(findTestObject('iOS/Inventory/Location Details Screen/Verification Details/backToLocation_Button'),0)

		Mobile.verifyElementExist(findTestObject('iOS/Inventory/Location Details Screen/Verification Details/productInfo_Text'),0)

		Mobile.tap(findTestObject('iOS/Inventory/Location Details Screen/Copy Product from Location/goToLocationAfterCopyingProduct_Text', [('Location') : locationName]),0)
	}



	/**
	 * deletes a product from the added products list in a location
	 * @param productNdcNumber (using NDC of the product which is visible on the product tab)
	 * if in future upc/cin are visible then the method can be modified accordingly by passing the respective test object	 */
	@Keyword
	def deleteProduct(String productNdcNumber) {

		String testObj='Object Repository/iOS/Inventory/Location Details Screen/Verification Details/slidePopUp_Button'

		int x_Coordinate=(new iosCommonKeywords.commonMethods()).tapXCoordinateGenerator(testObj)

		testObj='Object Repository/iOS/Inventory/Location Details Screen/Delete Product/ndcNumber_Text'

		int y_Coordinate=(new iosCommonKeywords.commonMethods()).tapYCoordinateGenerator(testObj,productNdcNumber)

		Mobile.tapAtPosition(x_Coordinate, y_Coordinate)

		Mobile.tap(findTestObject('iOS/Inventory/Location Details Screen/Delete Product/deleteProduct_Text'), 0)

		//Mobile.tap(findTestObject('iOS/Inventory/Location Details Screen/Delete Location/Yes_Text'), 0)

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Listing Screen/Create New Inventory Screen/yes_Button'), 0)

	}



	/**
	 * edits the location name and cost type can be changed(last price or current price paid)
	 * @param newLocationName (new name of the location)
	 * @param costType (cost type required which can be current or last price paid)
	 */
	@Keyword
	def editLocationName(String newLocationName,String costType) {

		Mobile.tap(findTestObject('iOS/Inventory/Location Details Screen/Edit Location Name/editLocation_Text'), 0)

		Mobile.clearText(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/LocationName_TextField'), 0)

		Mobile.setText(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/LocationName_TextField'), newLocationName, 0)

		if (costType == 'Last Price Paid') {
			Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/lastPrice_Button'), 0)
		} else {
			Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/currentPrice_Button'), 0)
		}
		Mobile.tap(findTestObject('iOS/Inventory/Location Details Screen/Edit Location Name/saveChanges_Text'), 0)

		commonMethodsObject.waitForProgressBarToBeInvisible()

		Mobile.verifyElementExist(findTestObject('iOS/Inventory/Inventory Details Screen/Add Location/locationNameVerification_Text', [('LName') : newLocationName]),0)
	}



	/**
	 * moves products from a location to another location
	 * @param locationName (name of the location to which product will be moved)
	 * @param productNdcNumber (using NDC of the product which is visible on the product tab)
	 * if in future upc/cin are visible then the method can be modified accordingly by passing the respective test object	 */
	@Keyword
	def moveProductToAnotherLocation(String locationName, String productNdcNumber) {

		String testObj='Object Repository/iOS/Inventory/Location Details Screen/Verification Details/slidePopUp_Button'

		int x_Coordinate=(new iosCommonKeywords.commonMethods()).tapXCoordinateGenerator(testObj)

		testObj='Object Repository/iOS/Inventory/Location Details Screen/Delete Product/ndcNumber_Text'

		int y_Coordinate=(new iosCommonKeywords.commonMethods()).tapYCoordinateGenerator(testObj,productNdcNumber)

		Mobile.tapAtPosition(x_Coordinate, y_Coordinate)
		//Mobile.tap(findTestObject('iOS/Inventory/Location Details Screen/Move Product to Another Location/moveProduct_Text'), 0)
		Mobile.tap(	findTestObject('iOS/Inventory/Location Details Screen/Move Product to Another Location/move_Buton'), 0)

		Mobile.tap(findTestObject('Object Repository/iOS/Inventory/Location Details Screen/Move Product to Another Location/moveToLocation_Text', [('Location') : locationName]),0)

		Mobile.tap(findTestObject('iOS/Inventory/Location Details Screen/Move Product to Another Location/moveProduct_Text'), 0)

		commonMethodsObject.waitForProgressBarToBeInvisible()

		Mobile.verifyElementExist(findTestObject('iOS/Inventory/Location Details Screen/Move Product to Another Location/movingProductConfirmation_Text',[('TEXT'):locationName]),0)

		Mobile.verifyElementExist(findTestObject('iOS/Inventory/Location Details Screen/Verification Details/backToLocation_Button'),0)

		Mobile.verifyElementExist(findTestObject('iOS/Inventory/Location Details Screen/Verification Details/productInfo_Text'),0)

		Mobile.tap(findTestObject('iOS/Inventory/Location Details Screen/Move Product To Another Location/goToLocationAfterMovingProduct_Text', [('Location') : locationName]),0)
	}


	/**
	 * this function gets the total added quantity of the product
	 * @return quantityNumericalValue (of the product which has been added)
	 */
	@Keyword
	def returnQuantityOfTheAddedProduct() {

		String quantity= Mobile.getText(findTestObject('iOS/Inventory/Location Details Screen/Add Product to Location/quantityAdded_Text'), 0)

		KeywordUtil.logInfo(quantity)

		float quantityNumericalValue=Float.valueOf(quantity)

		return quantityNumericalValue
	}



	/**
	 * this function gets the unit of issue cost(UOI) of the added product
	 * @return uoiCost_dollarSymbolRemoved_FloatValue (of the product which has been added)
	 */
	@Keyword
	def returnUOIOfTheAddedProduct() {

		String uoiCost=Mobile.getText(findTestObject('iOS/Verification/unitOfIssueCost_Text'), 0)

		float uoiCost_dollarSymbolRemoved_FloatValue=(new common.commonMethods()).floatValueGenerator(uoiCost)//converting uoiCost string to a float value

		return uoiCost_dollarSymbolRemoved_FloatValue
	}



	/**
	 * scans the product and adds it to the location 
	 * @param productToBeSearched (name which can be a productName/Cin/NDC of the product to be added)
	 */
	@Keyword
	def scanInputEvent(String productToBeSearched) {

		Mobile.tap(findTestObject('iOS/Product Search/Scan Flow/scanGray_Image'), 0)

		Mobile.setText(findTestObject('iOS/Product Search/Scan Flow/enterBarcode_TextField'), productToBeSearched, 0)

		Mobile.tap(findTestObject('iOS/Product Search/Scan Flow/done_Button'), 0)
	}



	/**
	 * this function selects the toggle value of countType for the product to be added 
	 * @param countType (countType required to be selected for the product to be added which can be full or partial count)
	 */
	@Keyword
	def selectCountTypeForTheProductToBeAdded(String countType) {
		if(countType=="Full Count") {
			Mobile.tap(findTestObject('iOS/Product Search/Scan Flow/fullCount_Button'), 0)
		}
		else {
			Mobile.tap(findTestObject('iOS/Product Search/Scan Flow/partialCount_Button'), 0)
		}
	}



	/**
	 * uploads location from the location details screen
	 */
	@Keyword
	def uploadLocation() {

		Mobile.tap(findTestObject('iOS/Inventory/Location Details Screen/Upload Location/enabledUploadLocation_Button'), 0)

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Listing Screen/Create New Inventory Screen/yes_Button'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Inventory/Location Details Screen/Upload Location/disbaledUploadLocation_Button'), 0)
	}



	/**
	 * this function gets the count type of the added product and verifies whether that is equal to the expected count type
	 */
	@Keyword
	def verifyCountTypeOfProduct(String expectedCountType) {

		String countType=Mobile.getText(findTestObject('iOS/Inventory/Location Details Screen/Verification Details/addedProductCountType_Text'),0) //gets the countType of the added product in the location details page

		assert (countType+" COUNT")==(expectedCountType.toUpperCase()) // verifies countType equals the countType of the product in the products list

	}



	/**
	 * this function verifies the lines count
	 * @param expectedLinesCount (expected lines Count)
	 */
	@Keyword
	def verifyLinesCount(String expectedLinesCount) {

		String actualLinesCount=Mobile.getText(findTestObject('iOS/Inventory/Location Details Screen/Verification Details/inventoryLine_Text'),0) //gets the actualLinesCount on the location details page

		assert actualLinesCount==expectedLinesCount //actual lines count has to be equal to expected lines count
	}




	/**
	 * verifies details of location details screen (if user wants to scan a product with same count type more than once, then in the test case, only the updated quantity along with countType and ndcNumber should be pushed into the stack)
	 * @param countTypeStack (stack of the countTypes selected for adding each product)
	 * @param quantityStack (stack of the quantity added for each product) 
	 * @param productNdcStack (stack of the ndcNumbers of added products)
	 * @param unitOfIssueCostStack (stack of UOI costs of the added products)
	 */
	@Keyword
	def verifyLocationDetailsScreen(Stack countTypeStack, Stack quantityStack, Stack productNdcStack, Stack unitOfIssueCostStack) {

		String topProductCountType,topProductNdc,topProductQuantity,countType,quantity,costOfOneFullCountProduct
		float totalCostOfAddedProduct=0.00, costOfOneFullCountProduct_dollarSymbolRemoved_FloatValue, topProductUnitOfIssueCost_FloatValue, topProductQuantity_FloatValue
		String inventoryTotal=Mobile.getText(findTestObject('iOS/Inventory/Location Details Screen/Verification Details/inventoryTotal_Text'), 0)// inventory value with location added
		float inventoryTotal_charactersRemoved_FloatValue=(new common.commonMethods()).floatValueGenerator(inventoryTotal)///converting finalInventoryTotal string to a float value
		//String actualLinesCount=Mobile.getText(findTestObject('iOS/Inventory/Location Details Screen/Verification Details/inventoryLine_Text'),0) //gets the actualLinesCount on the location details page
		//assert actualLinesCount==(expectedLinesCount) // verifies actualLinesCount equals the expectedLinesCount
		while(!countTypeStack.isEmpty() && !quantityStack.isEmpty() && !productNdcStack.isEmpty() && !unitOfIssueCostStack.isEmpty()) //loops while countType, quantity, productNdcStack is not empty
		{
			String topProductUnitOfIssueCost=unitOfIssueCostStack.pop() //pops the top unitOfIssueCostStack from the unitOfIssueCostStack and stores value in the topProductUnitOfIssueCost
			topProductCountType=countTypeStack.pop() //pops the top countType from the countTypeStack and stores value in the topProductCountType
			topProductQuantity=quantityStack.pop() //pops the top quantity from the quantityStack and stores value in the topProductQuantity
			topProductNdc=productNdcStack.pop() //pops the top ndcNumber from the productNdcStack and stores value in the topProductNdc
			countType=Mobile.getText(findTestObject('iOS/Inventory/Location Details Screen/Verification Details/addedProductCountType_Text'),0) //gets the countType of the top added product in the location details page
			quantity=Mobile.getText(findTestObject('iOS/Inventory/Location Details Screen/Verification Details/addedProductQuanity_Text'),0) //gets the quantity of the top added product in the location details page
			costOfOneFullCountProduct=Mobile.getText(findTestObject('iOS/Inventory/Location Details Screen/Verification Details/locationDetailsPrice_Label'),  0)
			topProductUnitOfIssueCost_FloatValue=(new common.commonMethods()).floatValueGenerator(topProductUnitOfIssueCost)///converting topProductUnitOfIssueCost string to a float value
			topProductQuantity_FloatValue=(new common.commonMethods()).floatValueGenerator(topProductQuantity)///converting topProductQuantity string to a float value
			costOfOneFullCountProduct_dollarSymbolRemoved_FloatValue=(new common.commonMethods()).floatValueGenerator(costOfOneFullCountProduct)///converting costOfOneFullCountProduct string to a float value
			if (topProductCountType=="Partial Count") //condition added because in case of partial count the quantity added won't end with a (.0) for e.g full count-(1.0), partial count (1)
			{
				assert quantity==(topProductQuantity) // verifies quantity equals the quantity of the topmost product in the products list
				totalCostOfAddedProduct=totalCostOfAddedProduct+(topProductQuantity_FloatValue*topProductUnitOfIssueCost_FloatValue) //adding the cost of the product
			}
			else
			{
				totalCostOfAddedProduct=(totalCostOfAddedProduct+topProductQuantity_FloatValue*costOfOneFullCountProduct_dollarSymbolRemoved_FloatValue) // //adding the cost of the product
				assert (quantity)==(topProductQuantity+".0") // verifies quantity equals the quantity of the topmost product in the products list
			}
			assert (countType+" COUNT")==(topProductCountType.toUpperCase()) // verifies countType equals the countType of the topmost product in the products list
			(new iosInventory.locationDetailsScreen()).deleteProduct(topProductNdc)//calling delete product function and passing the topProductNdc
		}
		String formattedTotalCostOfAddedProduct=(new common.commonMethods()).formatDecimalData(totalCostOfAddedProduct,"0.00") //formatting the data to be rounded off to upper level and to two decimal places
		float formattedTotalCostOfAddedProduct_FloatValue=(new common.commonMethods()).floatValueGenerator(formattedTotalCostOfAddedProduct)///converting formattedTotalCostOfAddedProduct string to a float value
		assert inventoryTotal_charactersRemoved_FloatValue==(formattedTotalCostOfAddedProduct_FloatValue)
	}



	/**
	 * this function verifies that the product is visible on the location details screen
	 * @param productNdcNumber (using NDC of the product which is visible on the product tab)
	 * if in future upc/cin are visible then the method can be modified accordingly by passing the respective test object
	 */
	@Keyword
	def verifyProductIsNotVisibleOnTheLocationDetailsScreen(productNdcNumber) {

		String testObj='Object Repository/iOS/Inventory/Location Details Screen/Delete Product/ndcNumber_Text'

		(new iosCommonKeywords.commonMethods()).verifyProductIsNotVisibleOnTheScreen(testObj,productNdcNumber)//calling verifyProductIsNotVisibleOnTheScreen function and passing testObj, topProductIdentificationNumber as the arguments
	}



	/**
	 * this function verifies that the product is not visible on the location details screen
	 * @param productNdcNumber (using NDC of the product which is visible on the product tab)
	 * if in future upc/cin are visible then the method can be modified accordingly by passing the respective test object
	 */
	@Keyword
	def verifyProductIsVisibleOnTheLocationDetailsScreen(productNdcNumber) {

		String testObj='Object Repository/iOS/Inventory/Location Details Screen/Delete Product/ndcNumber_Text'

		(new iosCommonKeywords.commonMethods()).verifyProductIsVisibleOnTheScreen(testObj,productNdcNumber)//calling verifyProductIsVisibleOnTheScreen function and passing testObj, topProductIdentificationNumber as the arguments
	}





	/**
	 * verifies that the latest added product is at the top of the added products list, then deletes the latest added product and continues the process to verifyReverseChronologicalOrder of the added products
	 * @param productNdcNumber (using NDC of the product which is visible on the product tab)
	 * if in future upc/cin are visible then the method can be modified accordingly by passing the respective test object
	 */
	@Keyword
	def verifyReverseChronologicalOrder(Stack productNdcNumber) {

		String topProductIdentificationNumber
		while(!productNdcNumber.isEmpty()) //loops while productIdentificationNumbersStack is not empty
		{
			String actualproductIdentificationNumber, testObj='iOS/Inventory/Location Details Screen/Verification Details/ndc_Label'

			topProductIdentificationNumber=productNdcNumber.pop() //pops the top ProductIdentificationNumber from the productNdcStack and stores value in the topProductNdc

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