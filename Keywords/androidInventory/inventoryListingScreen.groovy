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

		String testObj='Object Repository/Android/Inventory/inventoryListingScreen/deleteInventory/slidePopUpForInventoryDeletion_Button'

		int x_Coordinate=(new androidCommonKeywords.commonMethods()).tapXCoordinateGenerator(testObj)

		testObj='Object Repository/Android/Inventory/inventoryDetailScreen/openInventoryDetails/openInventory_Text'

		int y_Coordinate=(new androidCommonKeywords.commonMethods()).tapYCoordinateGenerator(testObj,inventoryName)

		Mobile.tapAtPosition(x_Coordinate, y_Coordinate)

		Mobile.tap(findTestObject('Android/inventory/inventoryListingScreen/deleteInventory/delete_Button'), 0)

		Mobile.tap(findTestObject('Android/inventory/inventoryListingScreen/deleteInventory/yes_Button'), 0)

		commonMethodsObject.waitForProgressBarToBeInvisible()

		Mobile.verifyElementNotVisible(findTestObject('Android/inventory/inventoryDetailScreen/openInventoryDetails/openInventory_Text', [('TEXT') : inventoryName]),0)
	}

	/**
	 * creates a new inventory from inventory listing screen
	 * @param inventoryName (name required for the new inventory)
	 */

	@Keyword
	def createInventory(String inventoryName) {

		if (Mobile.verifyElementExist(findTestObject('Android/inventory/inventoryListingScreen/verificationDetails/createInventory_TextView'), 4, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Android/inventory/inventoryListingScreen/verificationDetails/createInventory_TextView'), 4, FailureHandling.OPTIONAL)
		}
		else {
			Mobile.tapAndHold(findTestObject('Android/inventory/inventoryListingScreen/createNewInventoryScreen/createNewInventory_Tab'),0,0)
		}
		Mobile.tapAndHold(findTestObject('Android/inventory/inventoryListingScreen/createNewInventoryScreen/inventoryName_TextField'), 0,0)

		Mobile.setText(findTestObject('Android/inventory/inventoryListingScreen/createNewInventoryScreen/inventoryName_TextField'), inventoryName,0)

		Mobile.tap(findTestObject('Android/inventory/inventoryListingScreen/createNewInventoryScreen/createInventory_Button'), 0)

		commonMethodsObject.waitForProgressBarToBeInvisible()
	}
}