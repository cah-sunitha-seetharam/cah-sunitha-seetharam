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


class Inventory_listing_Screen {

	@Keyword
	def delete_Inventory(String inventory_Name) {


		Mobile.tap(findTestObject('Android/Inventory/Inventory Listing Screen/Delete Inventory/popup_menu'), 0)

		Mobile.tap(findTestObject('Android/Inventory/Inventory Listing Screen/Delete Inventory/Delete_Button'), 0)

		Mobile.tap(findTestObject('Android/Inventory/Inventory Listing Screen/Delete Inventory/Yes_Button'), 0)

		int w = 1

		while (Mobile.verifyElementExist(findTestObject('Android/Login/Login Details Screen/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}



		Mobile.verifyElementNotVisible(findTestObject('Android/Inventory/Inventory Detail Screen/Edit Inventory/afterEditInventoryVerification_TextView',
				[('TEXT') : inventory_Name]), 0)
	}




	@Keyword
	def change_Account(String new_Account) {

		int w = 1
		
		while (Mobile.verifyElementExist(findTestObject('Android/Login/Login Details Screen/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}
		
		Mobile.tap(findTestObject('Android/Dashboard/changeAccount_Button'), 0)

		Mobile.tap(findTestObject('Android/Account Selection/ChangeAccount_TextView'), 0)

		while (Mobile.verifyElementNotVisible(findTestObject('Android/Account Selection/AccountNo_TextView',[('val') : new_Account]), 2, FailureHandling.OPTIONAL)) {
			Mobile.swipe(600, 800, 600, 300)
		}
		Mobile.tap(findTestObject('Android/Account Selection/AccountNo_TextView',[('val') : new_Account]), 0)

		while (Mobile.verifyElementExist(findTestObject('Android/Login/Login Details Screen/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}
	}




	@Keyword
	def create_Inventory(String Inventory_Name) {

		if (Mobile.verifyElementExist(findTestObject('Android/Inventory/Inventory Listing Screen/Verification Details/createInventory_TextView'), 4, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Android/Inventory/Inventory Listing Screen/Verification Details/createInventory_TextView'), 4, FailureHandling.OPTIONAL)
		}
		else {
			Mobile.tapAndHold(findTestObject('Android/Inventory/Inventory Listing Screen/Create New Inventory_Screen/createNewInventory_Tab'),0,0)
		}
		Mobile.tapAndHold(findTestObject('Android/Inventory/Inventory Listing Screen/Create New Inventory_Screen/inventoryName_TextField'), 0,0)

		Mobile.setText(findTestObject('Android/Inventory/Inventory Listing Screen/Create New Inventory_Screen/inventoryName_TextField'), Inventory_Name,0)

		Mobile.tap(findTestObject('Android/Inventory/Inventory Listing Screen/Create New Inventory_Screen/createInventory_Button'), 0)

		int w = 1

		while (Mobile.verifyElementExist(findTestObject('Android/Login/Login Details Screen/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}
	}


	@Keyword
	def verify_Inventory_Listing_Screen() {

		Mobile.verifyElementExist(findTestObject('Android/Inventory/Inventory Listing Screen/Verification Details/letsGetStartedWithYourInventory_TextView'),0)

		Mobile.verifyElementExist(findTestObject('Android/Inventory/Inventory Detail Screen/Verification Details/inventoryHeader_TextView'),0)
	}
}