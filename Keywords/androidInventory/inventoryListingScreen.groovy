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


class inventoryListingScreen {

	def commonMethodsObject=new commonMethods();




	/**
	 * deletes the inventory from the inventory listing screen
	 * @param inventoryName (inventory name of the inventory which needs to be deleted)
	 */
	@Keyword
	def deleteInventory(String inventoryName) {

		String testObj='Android/Inventory/Inventory Listing Screen/Delete Inventory/slidePopUpForInventoryDeletion_Button'

		int x_Coordinate=(new androidCommonKeywords.commonMethods()).tapXCoordinateGenerator(testObj)
		
		testObj='Android/Inventory/Inventory Detail Screen/Open Inventory Details/openInventory_Text'

		int y_Coordinate=(new androidCommonKeywords.commonMethods()).tapYCoordinateGenerator(testObj,inventoryName)

		Mobile.tapAtPosition(x_Coordinate, y_Coordinate)

		Mobile.tap(findTestObject('Android/Inventory/Inventory Listing Screen/Delete Inventory/Delete_Button'), 0)

		Mobile.tap(findTestObject('Android/Inventory/Inventory Listing Screen/Delete Inventory/Yes_Button'), 0)

		commonMethodsObject.waitForProgressBarToBeInvisible()

		Mobile.verifyElementNotVisible(findTestObject('Android/Inventory/Inventory Detail Screen/Open Inventory Details/openInventory_Text', [('TEXT') : inventoryName]),0)
	}

	/**
	 * switches to another user account
	 * @param newAccount (account no to which the user should switch)
	 */

	@Keyword
	def change_Account(String new_Account) {

		commonMethodsObject.waitForProgressBarToBeInvisible()

		Mobile.tap(findTestObject('Android/Dashboard/changeAccount_Button'), 0)

		Mobile.tap(findTestObject('Android/Account Selection/ChangeAccount_TextView'), 0)

		while (Mobile.verifyElementNotVisible(findTestObject('Android/Account Selection/AccountNo_TextView',[('val') : new_Account]), 2, FailureHandling.OPTIONAL)) {
			Mobile.swipe(600, 800, 600, 300)
		}
		Mobile.tap(findTestObject('Android/Account Selection/AccountNo_TextView',[('val') : new_Account]), 0)

		commonMethodsObject.waitForProgressBarToBeInvisible()
	}


	/**
	 * creates a new inventory from inventory listing screen
	 * @param inventoryName (name required for the new inventory)
	 */

	@Keyword
	def createInventory(String inventoryName) {

		if (Mobile.verifyElementExist(findTestObject('Android/Inventory/Inventory Listing Screen/Verification Details/createInventory_TextView'), 4, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Android/Inventory/Inventory Listing Screen/Verification Details/createInventory_TextView'), 4, FailureHandling.OPTIONAL)
		}
		else {
			Mobile.tapAndHold(findTestObject('Android/Inventory/Inventory Listing Screen/Create New Inventory_Screen/createNewInventory_Tab'),0,0)
		}
		Mobile.tapAndHold(findTestObject('Android/Inventory/Inventory Listing Screen/Create New Inventory_Screen/inventoryName_TextField'), 0,0)

		Mobile.setText(findTestObject('Android/Inventory/Inventory Listing Screen/Create New Inventory_Screen/inventoryName_TextField'), inventoryName,0)

		Mobile.tap(findTestObject('Android/Inventory/Inventory Listing Screen/Create New Inventory_Screen/createInventory_Button'), 0)

		commonMethodsObject.waitForProgressBarToBeInvisible()
	}

	/**
	 * verifies details of inventory listing screen
	 */

	@Keyword
	def verify_Inventory_Listing_Screen() {

		Mobile.verifyElementExist(findTestObject('Android/Inventory/Inventory Listing Screen/Verification Details/letsGetStartedWithYourInventory_TextView'),0)

		Mobile.verifyElementExist(findTestObject('Android/Inventory/Inventory Detail Screen/Verification Details/inventoryHeader_TextView'),0)
	}
}