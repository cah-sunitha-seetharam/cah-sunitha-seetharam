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

		Mobile.tapAndHold(findTestObject('iOS/inventory/locationDetailsScreen/addProductToLocation/productSearch_TextField'), 0, 0)

		(new iosCommonKeywords.commonMethods()).waitForProgressBarToBeInvisible()

		Mobile.setText(findTestObject('iOS/productSearch/globalSearch/productSearch_TextField'), productName, 0)

		Mobile.tapAndHold(findTestObject('iOS/productSearch/globalSearch/search_Keypad'), 0, 0)

		Mobile.setText(findTestObject('iOS/productSearch/globalSearch/quantity_TextField'), quantity, 0)

		Mobile.tapAndHold(findTestObject('iOS/productSearch/globalSearch/doneKeypad_Button'), 0, 0)

		Mobile.tap(findTestObject('iOS/inventory/inventoryDetailsScreen/addProductToInventoryUsingSearchFromInventoryDetailsScreen/addToOrder_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/productSearch/globalSearch/confirmation_Text'), 0)

		Mobile.tapAndHold(findTestObject('iOS/productSearch/globalSearch/afterAddingProductContinue_Button'), 0,0)
	}



	/**
	 * changes the user account
	 * @param newAccount
	 */
	@Keyword
	def changeAccount(String newAccount) {

		Mobile.tap(findTestObject('iOS/accountSelection/changeAccount_Text'), 0)

		Mobile.tap(findTestObject('iOS/accountSelection/changeAccount_Navigation'), 0)

		Mobile.scrollToText(newAccount, FailureHandling.STOP_ON_FAILURE)

		Mobile.tap(findTestObject('iOS/accountSelection/AccountNo_Text', [('val') : newAccount]), 0)
	}


	/**
	 * opens audits tab where user can perform actions related to audits
	 */
	@Keyword
	def clickOnAuditsTab() {

		Mobile.tap(findTestObject('iOS/dashboard/tabs/audits_Tab'), 0)
	}



	/**
	 * opens home tab
	 */
	@Keyword
	def clickOnHomeTab() {

		Mobile.tapAndHold(findTestObject('iOS/dashboard/tabs/home_Tab'), 0, 0)
	}



	/**
	 * opens moreOptions tab where user can perform actions like signOut, goToInventoryListing Screen etc
	 */
	@Keyword
	def clickOnMoreOptionsTab() {

		Mobile.tap(findTestObject('iOS/dashboard/tabs/moreOptions_Tab'), 0)
	}


	/**
	 * opens orders tab where user can perform actions related to orders
	 */
	@Keyword
	def clickOnOrders() {

		Mobile.tap(findTestObject('iOS/dashboard/tabs/orders_Tab'), 0)
	}


	/**
	 * opens receiving tab
	 */
	@Keyword
	def clickOnReceivingTab() {

		Mobile.tap(findTestObject('iOS/dashboard/tabs/receiving_Tab'), 0)
	}


	/**
	 * taps on scan icon and takes user to scanning product screen and also verifies that the default toggle is at ordering
	 */
	@Keyword
	def clickOnScanIcon() {

		Mobile.tap(findTestObject('iOS/productSearch/scanFlow/scan_Icon'), 0)

		Mobile.verifyElementAttributeValue(findTestObject('iOS/productSearch/scanFlow/priceCheck_Button'), 'value', '1', 0)

		Mobile.verifyElementExist(findTestObject('iOS/productSearch/scanFlow/ordering_Button'), 0)
	}


	/**
	 * this function verifies the dash-board details Screen
	 */
	@Keyword
	def verifyDashboardScreen() {

		Mobile.verifyElementExist(findTestObject('iOS/dashboard/verification/homeHeader_Label'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/dashboard/verification/homeBottomNavigationTab_Bar'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/accountSelection/changeAccount_Navigation'), 0)
	}
}