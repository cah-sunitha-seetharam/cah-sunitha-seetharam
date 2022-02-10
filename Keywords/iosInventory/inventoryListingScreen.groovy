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


class inventoryListingScreen {

	def commonMethodsObject=new commonMethods();


	/**
	 * switches to another user account
	 * @param newAccount (account no to which the user should switch)
	 */
	@Keyword
	def changeAccount(String account) {

		Mobile.tap(findTestObject('iOS/accountSelection/changeAccount_Text'), 0)

		Mobile.tap(findTestObject('iOS/accountSelection/changeAccount_Navigation'), 0)

		Mobile.scrollToText(account, FailureHandling.STOP_ON_FAILURE)

		Mobile.tap(findTestObject('iOS/accountSelection/AccountNo_Text', [('val') : account]), 0)

		commonMethodsObject.waitForProgressBarToBeInvisible()
	}

	/**
	 * returns top most inventory
	 */
	@Keyword
	def returnTopMostInventoryName () {
		String topMostInventoryName = Mobile.getText(findTestObject('iOS/inventory/inventoryDetailsScreen/openInventoryDetails/topMostInventoryName_Text'), 0)
		return topMostInventoryName
	}

	/**
	 * opens the particular inventory details
	 * @param inventoryName (name which was given to the inventory)
	 */
	@Keyword
	def clickOnInventory(String inventoryName) {
		Mobile.tap(findTestObject('iOS/inventory/inventoryDetailsScreen/openInventoryDetails/openInventory_Text', [('TEXT') : inventoryName]), 0)
	}



	/**
	 * creates a new inventory from inventory listing screen
	 * @param inventoryName (name required for the new inventory)
	 */
	@Keyword
	def createInventory(String inventoryName) {

		if(Mobile.verifyElementExist(findTestObject('iOS/inventory/inventoryListingScreen/verification/createInventorySection_Header'),0, FailureHandling.OPTIONAL)){

			Mobile.tap(findTestObject('iOS/inventory/inventoryListingScreen/verification/createInventorySection_Header'), 0)
		}

		else {
			Mobile.tap(findTestObject('iOS/inventory/inventoryListingScreen/createNewInventory/createNewInventory_Text'), 0)
		}
		Mobile.tap(findTestObject('iOS/inventory/inventoryListingScreen/createNewInventory/inventoryName_Text'), 0)

		Mobile.setText(findTestObject('iOS/inventory/inventoryListingScreen/createNewInventory/inventoryName_TextField'), inventoryName,0)

		Mobile.tapAndHold(findTestObject('iOS/inventory/inventoryListingScreen/createNewInventory/returnKeypad_Button'), 0, 0)

		Mobile.tap(findTestObject('iOS/inventory/inventoryListingScreen/createNewInventory/createInventory_Text'), 0)

		commonMethodsObject.waitForProgressBarToBeInvisible()

		Mobile.verifyElementExist(findTestObject('iOS/inventory/inventoryDetailsScreen/openInventoryDetails/openInventory_Text', [('TEXT') : inventoryName]),0)
	}



	/**
	 * deletes the inventory from the inventory listing screen
	 * @param inventoryName (inventory name of the inventory which needs to be deleted)
	 */
	@Keyword
	def deleteInventory(String inventoryName) {

		String testObj='Object Repository/iOS/inventory/inventoryListingScreen/deleteInventory/slidePopUpForInventoryDeletion_Button'

		int x_Coordinate=(new iosCommonKeywords.commonMethods()).tapXCoordinateGenerator(testObj)

		testObj='Object Repository/iOS/inventory/inventoryDetailsScreen/openInventoryDetails/openInventory_Text'

		int y_Coordinate=(new iosCommonKeywords.commonMethods()).tapYCoordinateGenerator(testObj,inventoryName)

		Mobile.tapAtPosition(x_Coordinate, y_Coordinate)

		Mobile.tap(findTestObject('iOS/inventory/inventoryListingScreen/deleteInventory/delete_Button'), 0)

		Mobile.tap(findTestObject('iOS/inventory/inventoryListingScreen/createNewInventory/yes_Button'), 0)

		commonMethodsObject.waitForProgressBarToBeInvisible()

		Mobile.verifyElementNotVisible(findTestObject('iOS/inventory/inventoryDetailsScreen/openInventoryDetails/openInventory_Text', [('TEXT') : inventoryName]),0)
	}



	/**
	 * verifies details of inventory listing screen
	 */
	@Keyword
	def verifyInventoryListingScreen() {

		Mobile.verifyElementExist(findTestObject('iOS/inventory/inventoryListingScreen/verification/letsGetStartedWithYourInventory_Text'),0)

		Mobile.verifyElementExist(findTestObject('iOS/inventory/inventoryDetailsScreen/verificationDetails/inventoryHeader_Label'),0)
	}
}