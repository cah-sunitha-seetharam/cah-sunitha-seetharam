package iosDashboard
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

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile


class dashboardScreen {


	/**
	 * adds the product from dash-board to inventory
	 * @param productName
	 * @param quantity
	 */
	@Keyword
	def addingProductFromDashboardToCart(String productName, String quantity) {

		Mobile.tapAndHold(findTestObject('iOS/Inventory/Location Details Screen/Add Product to Location/productSearch_TextField'), 0, 0)

		(new iosCommonKeywords.commonMethods()).waitForProgressBarToBeInvisible()

		Mobile.setText(findTestObject('iOS/Product Search/Product SearchField'), productName, 0)

		Mobile.tapAndHold(findTestObject('iOS/Product Search/search_Keypad'), 0, 0)

		Mobile.setText(findTestObject('iOS/Product Search/Quantity_TextField'), quantity, 0)

		Mobile.tap(findTestObject('iOS/Orders/Cart Page/Place All Orders/Done_Keypad'), 0)

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Product to Inventory using Search from Inventory Details Screen/addToOrder_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Product Search/Confirmation_Text'), 0)

		Mobile.tapAndHold(findTestObject('iOS/Orders/Order Details Page/Upload Order/After Adding Product Continue_Button'), 0,0)
	}



	/**
	 * changes the user account
	 * @param newAccount
	 */
	@Keyword
	def changeAccount(String newAccount) {

		Mobile.tap(findTestObject('iOS/Account Selection/changeAccount_Text'), 0)

		Mobile.tap(findTestObject('iOS/Account Selection/changeAccount_Navigation'), 0)

		Mobile.scrollToText(newAccount, FailureHandling.STOP_ON_FAILURE)

		Mobile.tap(findTestObject('iOS/Account Selection/AccountNo_Text', [('val') : newAccount]), 0)
	}


	/**
	 * opens home tab
	 */
	@Keyword
	def clickOnHomeTab() {

		Mobile.tap(findTestObject('iOS/Dashboard/Home_Tab'), 0)
	}



	/**
	 * opens moreOptions tab where user can perform actions like signOut, goToInventoryListing Screen etc
	 */
	@Keyword
	def clickOnMoreOptionsTab() {

		Mobile.tap(findTestObject('iOS/Dashboard/moreOptions_Tab'), 0)
	}



	/**
	 * opens orders tab where user can perform actions related to orders
	 */
	@Keyword
	def clickOnOrders() {

		Mobile.tap(findTestObject('iOS/Dashboard/Orders_Tab'), 0)
	}



	/**
	 * this function verifies the dash-board details Screen
	 */
	@Keyword
	def verifyDashboardScreen() {

		Mobile.verifyElementExist(findTestObject('iOS/Dashboard/Verification/homeHeader_Label'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Dashboard/Verification/homeBottomNavigationTab_Bar'), 0)
	}




	/**
	 * this function verifies that the product is visible on the dash-board after search
	 * @param productNdcNumber (using NDC of the product which is visible on the product tab)
	 * if in future upc/cin are visible then the method can be modified accordingly by passing the respective test object
	 */
	@Keyword
	def verifyProductIsVisibleOnTheDashboardScreen(productNdcNumber) {

		String testObj='Object Repository/iOS/Dashboard/Verification/ndc_Label'

		(new iosCommonKeywords.commonMethods()).verifyProductIsVisibleOnTheScreen(testObj,productNdcNumber)//calling verifyProductIsVisibleOnTheScreen function and passing testObj, topProductIdentificationNumber as the arguments
	}
}