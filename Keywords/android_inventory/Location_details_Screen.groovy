package android_inventory
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


class Location_details_Screen {

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
}