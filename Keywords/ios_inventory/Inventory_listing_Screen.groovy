package ios_inventory
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


class Inventory_listing_Screen {

	/**
	 * switches to another user account
	 * @param newAccount (account no to which the user should switch)
	 */
	@Keyword
	def change_Account(String newAccount) {


		Mobile.tap(findTestObject('iOS/Account_Selection/Change Account_Text'), 0)

		Mobile.tap(findTestObject('iOS/Account_Selection/Change_Account_Navigation'), 0)

		Mobile.scrollToText(newAccount, FailureHandling.STOP_ON_FAILURE)

		Mobile.tap(findTestObject('iOS/Account_Selection/AccountNo_Text', [('val') : newAccount]), 0)

		(new ios_common_keywords.wait_for_load()).waitForPageLoad()
	}



	/**
	 * opens the particular inventory details
	 * @param inventoryName (name which was given to the inventory)
	 */
	@Keyword
	def click_On_Inventory(String inventoryName) {

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Open Inventory Details/Open Inventory_Text', [('Inventory') : inventoryName]), 0)
	}



	/**
	 * creates a new inventory
	 * @param inventoryName (name required for the new inventory)
	 */
	@Keyword
	def create_Inventory(String inventoryName) {


		Mobile.tap(findTestObject('iOS/Inventory/Inventory Listing Screen/Verification Details/Create_InventorySectionHeader'), 0)

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Listing Screen/Verification Details/Inventory Name_Text'), 0)

		Mobile.setText(findTestObject('iOS/Inventory/Inventory Listing Screen/Verification Details/InventoryName TextField'), inventoryName,0)

		Mobile.tapAndHold(findTestObject('iOS/Inventory/Inventory Listing Screen/Create New Inventory_Screen/Return_Keypad_Button'), 0, 0)

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Listing Screen/Create New Inventory_Screen/Create Inventory_Text'), 0)

		(new ios_common_keywords.wait_for_load()).waitForPageLoad()
	}



	/**
	 * deletes the inventory
	 * @param inventoryName (inventory name of the inventory which needs to be deleted)
	 */
	@Keyword
	def delete_Inventory(String inventoryName) {

		(new ios_common_keywords.wait_for_load()).waitForPageLoad()

		int ElementTopPosition = Mobile.getElementTopPosition(findTestObject('iOS/Inventory/Inventory Details Screen/Open Inventory Details/Open Inventory_Text', [('Inventory') : inventoryName]), 0)

		int ElementHeight=Mobile.getElementHeight(findTestObject('iOS/Inventory/Inventory Details Screen/Open Inventory Details/Open Inventory_Text', [('Inventory') : inventoryName]), 0)

		int y_Coordinate=(ElementHeight/2)+ElementTopPosition

		int ElementLeftPosition=Mobile.getElementLeftPosition(findTestObject('iOS/Inventory/Inventory Listing Screen/Delete Inventory/Slide_PopUpButton For Inventory Deletion'), 0)

		int ElementWidth=Mobile.getElementWidth(findTestObject('iOS/Inventory/Inventory Listing Screen/Delete Inventory/Slide_PopUpButton For Inventory Deletion'), 0)

		int x_Coordinate=(ElementWidth/2)+ElementLeftPosition

		Mobile.tapAtPosition(x_Coordinate, y_Coordinate)

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Listing Screen/Delete Inventory/Delete Inventory_Text'), 0)

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Listing Screen/Delete Inventory/Yes for Deletion_Text'), 0)

		(new ios_common_keywords.wait_for_load()).waitForPageLoad()

		Mobile.verifyElementNotVisible(findTestObject('iOS/Inventory/Inventory Details Screen/Open Inventory Details/Open Inventory_Text', [('Inventory') : inventoryName]),0)
	}





	/**
	 * verifies details of inventory listing screen
	 */
	@Keyword
	def verify_Inventory_Listing_Screen() {

		Mobile.verifyElementExist(findTestObject('iOS/Inventory/Inventory Listing Screen/Verification Details/Lets get started with your inventory_Text'),0)

		Mobile.verifyElementExist(findTestObject('iOS/Inventory/Inventory Details Screen/Verification Details/Inventory Header_Label'),0)
	}
}