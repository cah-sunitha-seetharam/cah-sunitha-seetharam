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


class locationDetailsScreen {

	def commonMethodsObject=new commonMethods();

	/**
	 * Edit location Name
	 */
	@Keyword
	def editLocationName(String newLocationName, String costType, String previousName) {

		commonMethodsObject.waitForProgressBarToBeInvisible()

		Mobile.tapAndHold(findTestObject('Android/inventory/locationDetailsScreen/editLocation/Edit_TextView'), 0,0)

		Mobile.verifyElementExist(findTestObject('Android/inventory/locationDetailsScreen/editLocation/editLocation_TextView'), 0)

		Mobile.clearText(findTestObject('Android/inventory/locationDetailsScreen/editLocation/locationToBeEdited_TextField', [('LName') : previousName]), 0)

		Mobile.tap(findTestObject('Android/inventory/inventoryDetailScreen/addLocation/locationName_TextField'), 0)

		Mobile.setText(findTestObject('Android/inventory/inventoryDetailScreen/addLocation/locationName_TextField'), newLocationName,  0)

		if (costType == 'Last Cost Paid') {
			Mobile.tap(findTestObject('Android/inventory/inventoryDetailScreen/addLocation/lastCostPaid_RadioButton'), 0)
		} else {
			Mobile.tap(findTestObject('Android/inventory/inventoryDetailScreen/addLocation/currentPrice_RadioButton'), 0)
		}

		Mobile.tap(findTestObject('Android/inventory/locationDetailsScreen/editLocation/saveChanges_Button'), 0)

		commonMethodsObject.waitForProgressBarToBeInvisible()
	}


	/**
	 * add product to the inventory
	 */
	@Keyword
	def addProductToLocation(String locationName, String productName,String quantity) {

		commonMethodsObject.waitForProgressBarToBeInvisible()

		Mobile.tap(findTestObject('Android/productSearch/searchProductsSearchView_EditText'), 0,FailureHandling.OPTIONAL)

		commonMethodsObject.waitForProgressBarToBeInvisible()

		Mobile.setText(findTestObject('Android/productSearch/searchProductsSearchView_EditText'), productName + '\\n',0)

		commonMethodsObject.waitForProgressBarToBeInvisible()

		addQuantityforTheSearchedProduct(quantity)

		commonMethodsObject.waitForProgressBarToBeInvisible()

		Mobile.tap(findTestObject('Android/inventory/locationDetailsScreen/addProductToLocation/addProductToLocation_Button', [('Location') : locationName]),0)

		Mobile.tap(findTestObject('Android/inventory/locationDetailsScreen/addProductToLocation/continueBrowsingAfterAddingProduct_Button'), 0)
	}

	/**
	 * uploads location from the location details screen
	 */
	@Keyword
	def uploadLocation() {

		commonMethodsObject.waitForProgressBarToBeInvisible()

		Mobile.tap(findTestObject('Android/inventory/locationDetailsScreen/uploadLocation/enabledUpload_Button'), 0)

		Mobile.verifyElementExist(findTestObject('Android/inventory/locationDetailsScreen/uploadLocation/locationUploaded_TextView'), 0)

		Mobile.tap(findTestObject('Android/inventory/locationDetailsScreen/uploadLocation/gotIt_Button'), 0)

		commonMethodsObject.waitForProgressBarToBeInvisible()

		Mobile.verifyElementAttributeValue(findTestObject('Android/inventory/locationDetailsScreen/uploadLocation/enabledUpload_Button'), 'enabled','false',0)
	}


	/**
	 * taps on scan icon and takes user to scanning product screen and also verifies that the default toggle is at full count
	 */
	@Keyword
	def clickOnScanIcon() {

		Mobile.tap(findTestObject('Android/productSearch/scanFlow/scanIcon_EditText'), 0,FailureHandling.OPTIONAL)

		commonMethodsObject.waitForProgressBarToBeInvisible()

		Mobile.verifyElementExist(findTestObject('Android/productSearch/scanFlow/fullCount_Button'), 0)

		Mobile.verifyElementExist(findTestObject('Android/productSearch/scanFlow/partialCount_Button'), 0)
	}



	/**
	 * this function selects the toggle value of countType for the product to be added
	 * @param countType (countType required to be selected for the product to be added which can be full or partial count)
	 */
	@Keyword
	def selectCountTypeForTheProductToBeAdded(String countType) {
		if(countType=="Full Count") {
			Mobile.tap(findTestObject('Android/productSearch/scanFlow/fullCount_Button'), 0)
		}
		else {
			Mobile.tap(findTestObject('Android/productSearch/scanFlow/partialCount_Button'), 0)
			WebUI.delay(3)
		}
	}



	/**
	 * scans the product and adds it to the location
	 * @param productToBeSearched (name which can be a productName/Cin/NDC of the product to be added)
	 */
	@Keyword
	def scanInputEvent(String productToBeSearched) {

		Mobile.tap(findTestObject('Android/productSearch/scanFlow/searchProducts_TextView'), 0)

		Mobile.setText(findTestObject('Android/productSearch/scanFlow/searchProducts_TextView'), productToBeSearched + '\\n', 0)

		WebUI.delay(5)
	}

	
	/**
	 * scans the product and adds it to the location
	 */
	@Keyword
	def addProducToLocation() {

		Mobile.tap(findTestObject('Android/productSearch/scanFlow/addToLocation_Button'), 0)

		Mobile.tap(findTestObject('Android/productSearch/scanFlow/continueBrowsing_Button'), 0)

		WebUI.delay(5)
	}


	/**
	 * this function gets the total added quantity of the product
	 * @return quantityNumericalValue (of the product which has been added)
	 */
	@Keyword
	def returnQuantityOfTheAddedProduct() {

		String quantity= Mobile.getText(findTestObject('Android/inventory/locationDetailsScreen/addProductToLocation/quantityAdded_Text'), 0)

		KeywordUtil.logInfo(quantity)

		float quantityNumericalValue=Float.valueOf(quantity)

		return quantityNumericalValue
	}


	/**
	 * this function inputs the quantity value for the product to be searched
	 * @param quantity (quantity required to be added for the product to be searched)
	 */
	@Keyword
	def addQuantityforTheSearchedProduct(String quantity) {

		Mobile.setText(findTestObject('Android/productSearch/scanFlow/quantity_TextField'), quantity + '\\n', 0)
	}


	/**
	 * this function gets the unit of issue cost(UOI) of the added product
	 * @return uoiCost_dollarSymbolRemoved_FloatValue (of the product which has been added)
	 */
	@Keyword
	def returnUOIOfTheAddedProduct() {

		String uoiCost=Mobile.getText(findTestObject('Android/productSearch/scanFlow/unitOfIssueCost_Text'), 0)

		float uoiCost_dollarSymbolRemoved_FloatValue=(new common.commonMethods()).floatValueGenerator(uoiCost)//converting uoiCost string to a float value

		return uoiCost_dollarSymbolRemoved_FloatValue
	}

	/**
	 * this function will tap on share button and verify the Gmail option
	 */
	@Keyword
	def verifyGmailOnShareLocation() {

		Mobile.tap(findTestObject('Android/inventory/locationDetailsScreen/shareLocation/share_Button'), 0)

		Mobile.verifyElementExist(findTestObject('Android/inventory/locationDetailsScreen/shareLocation/gmail_Text'), 0)

		Mobile.pressBack()
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
		String inventoryTotal=Mobile.getText(findTestObject('Android/inventory/locationDetailsScreen/verificationDetails/inventoryTotal_Text'), 0)// inventory value with location added
		float inventoryTotal_charactersRemoved_FloatValue=(new common.commonMethods()).floatValueGenerator(inventoryTotal)///converting finalInventoryTotal string to a float value
		//String actualLinesCount=Mobile.getText(findTestObject('Android/inventory/locationDetailsScreen/verificationDetails/inventoryLine_Text'),0) //gets the actualLinesCount on the location details page
		//assert actualLinesCount==(expectedLinesCount) // verifies actualLinesCount equals the expectedLinesCount
		while(!countTypeStack.isEmpty() && !quantityStack.isEmpty() && !productNdcStack.isEmpty() && !unitOfIssueCostStack.isEmpty()) //loops while countType, quantity, productNdcStack is not empty
		{
			String topProductUnitOfIssueCost=unitOfIssueCostStack.pop() //pops the top unitOfIssueCostStack from the unitOfIssueCostStack and stores value in the topProductUnitOfIssueCost
			topProductCountType=countTypeStack.pop() //pops the top countType from the countTypeStack and stores value in the topProductCountType
			topProductQuantity=quantityStack.pop() //pops the top quantity from the quantityStack and stores value in the topProductQuantity
			topProductNdc=productNdcStack.pop() //pops the top ndcNumber from the productNdcStack and stores value in the topProductNdc
			countType=Mobile.getText(findTestObject('Android/inventory/locationDetailsScreen/verificationDetails/addedProductCountType_Text'),0) //gets the countType of the top added product in the location details page
			quantity=Mobile.getText(findTestObject('Android/inventory/locationDetailsScreen/verificationDetails/addedProductQuanity_Text'),0) //gets the quantity of the top added product in the location details page
			costOfOneFullCountProduct=Mobile.getText(findTestObject('Android/inventory/locationDetailsScreen/verificationDetails/locationDetailsPrice_Label'),  0)
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
			(new androidInventory.locationDetailsScreen()).deleteProduct(topProductNdc) //calling delete product function and passing the topProductNdc delete_Product
		}
		String formattedTotalCostOfAddedProduct=(new common.commonMethods()).formatDecimalData(totalCostOfAddedProduct,"0.00") //formatting the data to be rounded off to upper level and to two decimal places
		float formattedTotalCostOfAddedProduct_FloatValue=(new common.commonMethods()).floatValueGenerator(formattedTotalCostOfAddedProduct)///converting formattedTotalCostOfAddedProduct string to a float value

		// assert inventoryTotal_charactersRemoved_FloatValue==(formattedTotalCostOfAddedProduct_FloatValue)
		KeywordUtil.logInfo("expected is " + Math.round(inventoryTotal_charactersRemoved_FloatValue) );
		KeywordUtil.logInfo("actual is " + Math.round(formattedTotalCostOfAddedProduct_FloatValue) );
		assert Math.round(inventoryTotal_charactersRemoved_FloatValue) == Math.round(formattedTotalCostOfAddedProduct_FloatValue) // Changed to round value to avoid decimal difference on float conversion
	}

	/**
	 * deletes a product from the added products list in a location
	 * @param productNdcNumber (using NDC of the product which is visible on the product tab)
	 * if in future upc/cin are visible then the method can be modified accordingly by passing the respective test object	 */

	@Keyword
	def deleteProduct(String productNdcNumber) {

		String testObj='Android/inventory/inventoryListingScreen/deleteInventory/popUp_Menu'

		int x_Coordinate=(new androidCommonKeywords.commonMethods()).tapXCoordinateGenerator(testObj)

		testObj='Android/inventory/inventoryListingScreen/deleteInventory/ndcNumber_Text'

		int y_Coordinate=(new androidCommonKeywords.commonMethods()).tapYCoordinateGenerator(testObj,productNdcNumber)

		Mobile.tapAtPosition(x_Coordinate, y_Coordinate)

	//	Mobile.tap(findTestObject('Android/inventory/inventoryListingScreen/deleteInventory/Delete_Button'), 0)
		
		if(Mobile.verifyElementExist(findTestObject('Android/inventory/inventoryListingScreen/deleteInventory/Delete_Button'), 2,FailureHandling.OPTIONAL))
			{
				Mobile.tap(findTestObject('Android/inventory/inventoryListingScreen/deleteInventory/Delete_Button'), 0)
				Mobile.tap(findTestObject('Android/inventory/inventoryListingScreen/deleteInventory/Yes_Button'), 0)
			
			}
			else
			{
				Mobile.tapAtPosition(x_Coordinate, y_Coordinate)
				Mobile.tap(findTestObject('Android/inventory/inventoryListingScreen/deleteInventory/Delete_Button'), 0)
				Mobile.tap(findTestObject('Android/inventory/inventoryListingScreen/deleteInventory/Yes_Button'), 0)
			}
		
		WebUI.delay(3)

		// Mobile.tap(findTestObject('Android/inventory/inventoryListingScreen/deleteInventory/Yes_Button'), 0)
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
			String actualproductIdentificationNumber, testObj='Android/inventory/locationDetailsScreen/verificationDetails/ndc_Label'

			topProductIdentificationNumber=productNdcNumber.pop() //pops the top ProductIdentificationNumber from the productNdcStack and stores value in the topProductNdc

			actualproductIdentificationNumber=Mobile.getText(findTestObject(testObj),0) //gets the ProductIdentificationNumber of the top added product in the location details page

			assert actualproductIdentificationNumber==("NDC: "+topProductIdentificationNumber) // verifies actualproductIdentificationNumber equals the ProductIdentificationNumber of the topmost product in the products list

			KeywordUtil.logInfo("actualproductIdentificationNumber is " + actualproductIdentificationNumber );
			KeywordUtil.logInfo("topProductIdentificationNumber is " + topProductIdentificationNumber );

			(new androidInventory.locationDetailsScreen()).deleteProduct("NDC: "+topProductIdentificationNumber)//calling delete product function and passing the topProductIdentificationNumber

		}
	}


	/**
	 * this function verifies that the product is not visible on the location details screen
	 * @param productNdcNumber (using NDC of the product which is visible on the product tab)
	 * if in future upc/cin are visible then the method can be modified accordingly by passing the respective test object
	 */
	@Keyword
	def verifyProductIsVisibleOnTheLocationDetailsScreen(productNdcNumber) {

		String testObj='Android/inventory/locationDetailsScreen/deleteProduct/ndcNumber_Text'

		(new androidCommonKeywords.commonMethods()).verifyProductIsVisibleOnTheScreen(testObj,productNdcNumber)//calling verifyProductIsVisibleOnTheScreen function and passing testObj, topProductIdentificationNumber as the arguments
	}


	/**
	 * this function taps on remove button and then product entry should get removed from the location as well as the scan result screen
	 */
	@Keyword
	def clickOnRemoveButtonToRemoveAlreadyScannedProduct() {

		Mobile.verifyElementExist(findTestObject('Android/inventory/locationDetailsScreen/addProductToLocation/thisItemHasBeenAddedToYourLocation_Text'),0)

		String testObj='Remove'

		Mobile.scrollToText(testObj, FailureHandling.STOP_ON_FAILURE)

		Mobile.tap(findTestObject('Android/productSearch/removeItem_Button'), 0)
	}

	/**
	 * this function verifies that the product is visible on the location details screen
	 * @param productNdcNumber (using NDC of the product which is visible on the product tab)
	 * if in future upc/cin are visible then the method can be modified accordingly by passing the respective test object
	 */
	@Keyword
	def verifyProductIsNotVisibleOnTheLocationDetailsScreen(productNdcNumber) {

		String testObj='Android/inventory/locationDetailsScreen/deleteProduct/ndcNumber_Text'

		(new androidCommonKeywords.commonMethods()).verifyProductIsNotVisibleOnTheScreen(testObj,productNdcNumber)//calling verifyProductIsNotVisibleOnTheScreen function and passing testObj, topProductIdentificationNumber as the arguments
	}


	/**
	 * copies products from a location to another location
	 * @param locationName (name of the location to which product will be copied)
	 * @param productNdcNumber (using NDC of the product which is visible on the product tab)
	 * if in future upc/cin are visible then the method can be modified accordingly by passing the respective test object	 */
	@Keyword
	def copyProductToAnotherLocation(String locationName, String productNdcNumber) {

		String testObj='Android/inventory/locationDetailsScreen/verificationDetails/slidePopUp_Button'

		int x_Coordinate=(new androidCommonKeywords.commonMethods()).tapXCoordinateGenerator(testObj)

		testObj='Android/inventory/locationDetailsScreen/deleteProduct/ndcNumber_Text'

		int y_Coordinate=(new androidCommonKeywords.commonMethods()).tapYCoordinateGenerator(testObj,productNdcNumber)

		Mobile.tapAtPosition(x_Coordinate, y_Coordinate)

		Mobile.tap(	findTestObject('Android/inventory/locationDetailsScreen/copyProductFromLocation/copy_Button'), 0)

		Mobile.tap(findTestObject('Android/inventory/locationDetailsScreen/copyProductFromLocation/copyToLocation_Text', [('Location') : locationName]), 0)


		Mobile.tap(findTestObject('Android/inventory/locationDetailsScreen/copyProductFromLocation/selectLocation'), 0)

		commonMethodsObject.waitForProgressBarToBeInvisible()
		
		Mobile.tap(findTestObject('Android/inventory/locationDetailsScreen/copyProductFromLocation/copyProduct_Text'), 0)

		Mobile.verifyElementExist(findTestObject('Android/inventory/locationDetailsScreen/copyProductFromLocation/copyingProductConfirmation_Text',[('TEXT'):locationName]),0)

		Mobile.verifyElementExist(findTestObject('Android/inventory/locationDetailsScreen/verificationDetails/backToLocation_Button'),0)

		Mobile.verifyElementExist(findTestObject('Android/inventory/locationDetailsScreen/verificationDetails/productInfo_Text'),0)

		Mobile.tap(findTestObject('Android/inventory/locationDetailsScreen/copyProductFromLocation/goToLocationAfterCopyingProduct_Text', [('Location') : locationName]),0)
	}

	/**
	 * this function gets the count type of the added product and verifies whether that is equal to the expected count type
	 */
	@Keyword
	def verifyCountTypeOfProduct(String expectedCountType) {

		String countType=Mobile.getText(findTestObject('Android/inventory/locationDetailsScreen/verificationDetails/addedProductCountType_Text'),0) //gets the countType of the added product in the location details page

		assert (countType+" COUNT")==(expectedCountType.toUpperCase()) // verifies countType equals the countType of the product in the products list

	}


	/**
	 * moves products from a location to another location
	 * @param locationName (name of the location to which product will be moved)
	 * @param productNdcNumber (using NDC of the product which is visible on the product tab)
	 * if in future upc/cin are visible then the method can be modified accordingly by passing the respective test object	 */
	@Keyword
	def moveProductToAnotherLocation(String locationName, String productNdcNumber) {

		KeywordUtil.logInfo("locationName is " + locationName );
		KeywordUtil.logInfo("productNdcNumber is " + productNdcNumber );

		String testObj='Android/inventory/locationDetailsScreen/verificationDetails/slidePopUp_Button'

		int x_Coordinate=(new androidCommonKeywords.commonMethods()).tapXCoordinateGenerator(testObj)

		testObj='Android/inventory/locationDetailsScreen/deleteProduct/ndcNumber_Text'

		int y_Coordinate=(new androidCommonKeywords.commonMethods()).tapYCoordinateGenerator(testObj,productNdcNumber)

		Mobile.tapAtPosition(x_Coordinate, y_Coordinate)

		Mobile.tap(findTestObject('Android/inventory/locationDetailsScreen/copyProductFromLocation/move_Button'), 0)

		Mobile.tap(findTestObject('Android/inventory/locationDetailsScreen/moveProductToAnotherLocation/moveToLocation_Text', [('Location') : locationName]),0)

		Mobile.tap(findTestObject('Android/inventory/locationDetailsScreen/copyProductFromLocation/selectLocation'), 0)

		commonMethodsObject.waitForProgressBarToBeInvisible()
		
		Mobile.tap(findTestObject('Android/inventory/locationDetailsScreen/moveProductToAnotherLocation/moveProduct_Text'), 0)

		Mobile.verifyElementExist(findTestObject('Android/inventory/locationDetailsScreen/moveProductToAnotherLocation/movingProductConfirmation_Text',[('TEXT'):locationName]),0)

		Mobile.verifyElementExist(findTestObject('Android/inventory/locationDetailsScreen/verificationDetails/backToLocation_Button'),0)

		Mobile.verifyElementExist(findTestObject('Android/inventory/locationDetailsScreen/verificationDetails/productInfo_Text'),0)

		Mobile.tap(findTestObject('Android/inventory/locationDetailsScreen/moveProductToAnotherLocation/goToLocationAfterMovingProduct_Text', [('Location') : locationName]),0)
	}

	/**
	 * this function verifies the lines count
	 * @param expectedLinesCount (expected lines Count)
	 */
	@Keyword
	def verifyLinesCount(String expectedLinesCount) {

		String actualLinesCount=Mobile.getText(findTestObject('Android/inventory/locationDetailsScreen/verificationDetails/inventoryLine_Text'),0) //gets the actualLinesCount on the location details page

		assert actualLinesCount==expectedLinesCount //actual lines count has to be equal to expected lines count
	}


}