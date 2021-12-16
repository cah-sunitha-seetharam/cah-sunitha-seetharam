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


	@Keyword
	def edit_LocationName(String New_Location_Name, String CostType,String Previous_Name) {

		Mobile.tap(findTestObject('Android/Inventory/Location Details Screen/Edit_Location/Edit_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Inventory/Location Details Screen/Edit_Location/editLocation_TextView'), 0)

		Mobile.clearText(findTestObject('Android/Inventory/Location Details Screen/Edit_Location/locationToBeEdited_TextField', [('LName') : Previous_Name]), 0)

		Mobile.tap(findTestObject('Android/Inventory/Inventory Detail Screen/Add Location/locationName_TextField'), 0)

		Mobile.setText(findTestObject('Android/Inventory/Inventory Detail Screen/Add Location/locationName_TextField'), New_Location_Name,  0)

		if (CostType == 'Last Cost Paid') {
			Mobile.tap(findTestObject('Android/Inventory/Inventory Detail Screen/Add Location/lastCostPaid_RadioButton'), 0)
		} else {
			Mobile.tap(findTestObject('Android/Inventory/Inventory Detail Screen/Add Location/currentPrice_RadioButton'), 0)
		}

		Mobile.tap(findTestObject('Android/Inventory/Location Details Screen/Edit_Location/saveChanges_Button'), 0)
		int w = 1

		while (Mobile.verifyElementExist(findTestObject('Android/Login/Login Details Screen/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}
	}






	@Keyword
	def add_Product_To_Location(String Location_Name, String Product_Name) {
		int w = 1

		Mobile.tap(findTestObject('Android/Product Search/Search Products_SearchView'), 0)

		WebUI.delay(2)

		Mobile.setText(findTestObject('Android/Product Search/Search Products_SearchView'), Product_Name + '\\n',
				0)
		while (Mobile.verifyElementExist(findTestObject('Android/Login/Login Details Screen/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}

		Mobile.tap(findTestObject('Android/Inventory/Location Details Screen/Add Product to_Location/addProductToLocation_Button', [('Location') : Location_Name]),0)

		Mobile.tap(findTestObject('Android/Inventory/Location Details Screen/Add Product to_Location/continueBrowsingAfterAddingProduct_Button'), 0)
	}





	@Keyword
	def move_Product_To_Another_Location(String Location_Name) {

		int w=1

		while (Mobile.verifyElementExist(findTestObject('Android/Login/Login Details Screen/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}
		Mobile.tap(findTestObject('Android/Product Details/popUP_product_menu_TextView'), 0)

		Mobile.tap(findTestObject('Android/Inventory/Location Details Screen/Move Product to Another Location/Move_TextView'), 0)

		Mobile.tap(findTestObject('Android/Inventory/Location Details Screen/Move Product to Another Location/selectLocationForMoveOrCopy_RadioButton'), 0)

		Mobile.tap(findTestObject('Android/Inventory/Location Details Screen/Move Product to Another Location/Move_Button'), 0)

		Mobile.tap(findTestObject('Android/Inventory/Location Details Screen/Copy Product to Another Location/goToLocationAfterMoveOrCopy_TextView',[('TEXT') : Location_Name]), 0)
	}





	@Keyword
	def copy_Product_To_Another_Location(String Location_Name) {

		int w=1

		while (Mobile.verifyElementExist(findTestObject('Android/Login/Login Details Screen/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}
		Mobile.tap(findTestObject('Android/Product Details/popUP_product_menu_TextView'), 0)

		Mobile.tap(findTestObject('Android/Inventory/Location Details Screen/Copy Product to Another Location/Copy_TextView'), 0)

		Mobile.tap(findTestObject('Android/Inventory/Location Details Screen/Move Product to Another Location/selectLocationForMoveOrCopy_RadioButton'), 0)

		Mobile.tap(findTestObject('Android/Inventory/Location Details Screen/Copy Product to Another Location/Copy_Button'), 0)

		Mobile.tap(findTestObject('Android/Inventory/Location Details Screen/Copy Product to Another Location/goToLocationAfterMoveOrCopy_TextView',[('TEXT') : Location_Name]), 0)
	}




	@Keyword
	def delete_Product() {

		Mobile.tap(findTestObject('Android/Inventory/Inventory Listing Screen/Delete Inventory/popup_menu'), 0)

		Mobile.tap(findTestObject('Android/Inventory/Inventory Listing Screen/Delete Inventory/Delete_Button'), 0)

		Mobile.tap(findTestObject('Android/Inventory/Inventory Listing Screen/Delete Inventory/Yes_Button'), 0)
	}



	@Keyword
	def upload_Location() {

		int w=1

		while (Mobile.verifyElementExist(findTestObject('Android/Login/Login Details Screen/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}

		Mobile.tap(findTestObject('Android/Inventory/Location Details Screen/Upload Location/enabledUpload_Button'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Inventory/Location Details Screen/Upload Location/locationUploaded_TextView'), 0)

		Mobile.tap(findTestObject('Android/Inventory/Location Details Screen/Upload Location/gotIt_Button'), 0)
	}




	@Keyword
	def share_Location() {

		Mobile.tap(findTestObject('Android/Inventory/Location Details Screen/Share Location/Share_Button'), 0)

		Mobile.tap(findTestObject('Android/Inventory/Location Details Screen/Share Location/Gmail_Text'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Inventory/Location Details Screen/Share Location/orderExpressLocationFile_TextField'),0)

		Mobile.verifyElementExist(findTestObject('Android/Inventory/Location Details Screen/Share Location/From_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Inventory/Location Details Screen/Share Location/To_TextView'), 0)
	}



	@Keyword
	def verify_Location_details_Screen(String Location_Name) {

		Mobile.verifyElementExist(findTestObject('Android/Inventory/Inventory Detail Screen/Verification Details/inventoryHeader_TextView'),0)

		Mobile.verifyElementExist(findTestObject('Android/Inventory/Location Details Screen/Verification Details/createdOnDate_TextView'),0)

		Mobile.verifyElementExist(findTestObject('Android/Inventory/Location Details Screen/Verification Details/inventoryValue_TextView'),0)

		Mobile.verifyElementExist(	findTestObject('Android/Inventory/Location Details Screen/Verification Details/createdLocationName_TextView',[('TEXT'):Location_Name]),0)
	}


	/**
	 * taps on scan icon and takes user to scanning product screen and also verifies that the default toggle is at full count
	 */
	@Keyword
	def clickOnScanIcon() {

		Mobile.tap(findTestObject('Object Repository/Android/Product Search/Scan Flow/scan_Icon'), 0)

		commonMethodsObject.waitForProgressBarToBeInvisible()

		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Product Search/Scan Flow/fullCount_Button'), 0)

		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Product Search/Scan Flow/partialCount_Button'), 0)
	}



	/**
	 * this function selects the toggle value of countType for the product to be added
	 * @param countType (countType required to be selected for the product to be added which can be full or partial count)
	 */
	@Keyword
	def selectCountTypeForTheProductToBeAdded(String countType) {
		if(countType=="Full Count") {
			Mobile.tap(findTestObject('Object Repository/Android/Product Search/Scan Flow/fullCount_Button'), 0)
		}
		else {
			Mobile.tap(findTestObject('Object Repository/Android/Product Search/Scan Flow/partialCount_Button'), 0)
		}
	}



	/**
	 * scans the product and adds it to the location
	 * @param productToBeSearched (name which can be a productName/Cin/NDC of the product to be added)
	 */
	@Keyword
	def scanInputEvent(String productToBeSearched) {

		Mobile.setText(findTestObject('Object Repository/Android/Product Search/Scan Flow/enterBarcode_TextField'), productToBeSearched, 0)

		Mobile.tap(findTestObject('Object Repository/Android/Product Search/Scan Flow/scan_Done_Button'), 0)
	}



	/**
	 * this function gets the total added quantity of the product
	 * @return quantityNumericalValue (of the product which has been added)
	 */
	@Keyword
	def returnQuantityOfTheAddedProduct() {

		String quantity= Mobile.getText(findTestObject('Android/Inventory/Location Details Screen/Add Product to_Location/quantityAdded_Text'), 0)

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

		Mobile.setText(findTestObject('Object Repository/Android/Product Search/Scan Flow/quantity_TextField'), quantity, 0)
	}


	/**
	 * this function gets the unit of issue cost(UOI) of the added product
	 * @return uoiCost_dollarSymbolRemoved_FloatValue (of the product which has been added)
	 */
	@Keyword
	def returnUOIOfTheAddedProduct() {

		String uoiCost=Mobile.getText(findTestObject('Android/Product Search/Scan Flow/unitOfIssueCost_Text'), 0)

		float uoiCost_dollarSymbolRemoved_FloatValue=(new common.commonMethods()).floatValueGenerator(uoiCost)//converting uoiCost string to a float value

		return uoiCost_dollarSymbolRemoved_FloatValue
	}

	/**
	 * this function will tap on share button and verify the Gmail option
	 */
	@Keyword
	def verifyGmailOnShareLocation() {

		Mobile.tap(findTestObject('Android/Inventory/Location Details Screen/Share Location/Share_Button'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Inventory/Location Details Screen/Share Location/Gmail_Text'), 0)

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
		String inventoryTotal=Mobile.getText(findTestObject('Object Repository/Android/Inventory/Location Details Screen/Verification Details/inventoryTotal_Text'), 0)// inventory value with location added
		float inventoryTotal_charactersRemoved_FloatValue=(new common.commonMethods()).floatValueGenerator(inventoryTotal)///converting finalInventoryTotal string to a float value
		//String actualLinesCount=Mobile.getText(findTestObject('Object Repository/Android/Inventory/Location Details Screen/Verification Details/inventoryLine_Text'),0) //gets the actualLinesCount on the location details page
		//assert actualLinesCount==(expectedLinesCount) // verifies actualLinesCount equals the expectedLinesCount
		while(!countTypeStack.isEmpty() && !quantityStack.isEmpty() && !productNdcStack.isEmpty() && !unitOfIssueCostStack.isEmpty()) //loops while countType, quantity, productNdcStack is not empty
		{
			String topProductUnitOfIssueCost=unitOfIssueCostStack.pop() //pops the top unitOfIssueCostStack from the unitOfIssueCostStack and stores value in the topProductUnitOfIssueCost
			topProductCountType=countTypeStack.pop() //pops the top countType from the countTypeStack and stores value in the topProductCountType
			topProductQuantity=quantityStack.pop() //pops the top quantity from the quantityStack and stores value in the topProductQuantity
			topProductNdc=productNdcStack.pop() //pops the top ndcNumber from the productNdcStack and stores value in the topProductNdc
			countType=Mobile.getText(findTestObject('Object Repository/Android/Inventory/Location Details Screen/Verification Details/addedProductCountType_Text'),0) //gets the countType of the top added product in the location details page
			quantity=Mobile.getText(findTestObject('Object Repository/Android/Inventory/Location Details Screen/Verification Details/addedProductQuanity_Text'),0) //gets the quantity of the top added product in the location details page
			costOfOneFullCountProduct=Mobile.getText(findTestObject('Object Repository/Android/Inventory/Location Details Screen/Verification Details/locationDetailsPrice_Label'),  0)
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
		assert inventoryTotal_charactersRemoved_FloatValue==(formattedTotalCostOfAddedProduct_FloatValue)
	}

	/**
	 * deletes a product from the added products list in a location
	 * @param productNdcNumber (using NDC of the product which is visible on the product tab)
	 * if in future upc/cin are visible then the method can be modified accordingly by passing the respective test object	 */

	@Keyword
	def deleteProduct(String productNdcNumber) {

		String testObj='Android/Inventory/Inventory Listing Screen/Delete Inventory/popup_menu'

		int x_Coordinate=(new androidCommonKeywords.commonMethods()).tapXCoordinateGenerator(testObj)

		testObj='Android/Inventory/Inventory Listing Screen/Delete Inventory/ndcNumber_Text'

		int y_Coordinate=(new androidCommonKeywords.commonMethods()).tapYCoordinateGenerator(testObj,productNdcNumber)

		Mobile.tapAtPosition(x_Coordinate, y_Coordinate)

		Mobile.tap(findTestObject('Android/Inventory/Inventory Listing Screen/Delete Inventory/Delete_Button'), 0)

		Mobile.tap(findTestObject('Android/Inventory/Inventory Listing Screen/Delete Inventory/Yes_Button'), 0)
	}
}