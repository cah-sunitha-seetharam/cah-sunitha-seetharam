package ios_dashboard
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

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile


class dashboard_details {

	/**
	 * opens orders tab
	 */
	@Keyword
	def click_On_Orders() {

		Mobile.tap(findTestObject('iOS/Dashboard/Orders_Tab'), 0)
	}


	/**
	 * opens home tab
	 */
	@Keyword
	def click_On_HomeTab() {


		Mobile.tap(findTestObject('iOS/Dashboard/Home_Tab'), 0)
	}


	/**
	 * opens moreOptions tab
	 */
	@Keyword
	def click_On_More_Options() {


		Mobile.tap(findTestObject('iOS/Dashboard/More Options_Tab'), 0)
	}



	/**
	 * changes the account
	 * @param newAccount
	 */
	@Keyword
	def Change_Account(String newAccount) {


		Mobile.tap(findTestObject('iOS/Account_Selection/Change Account_Text'), 0)

		Mobile.tap(findTestObject('iOS/Account_Selection/Change_Account_Navigation'), 0)

		Mobile.scrollToText(newAccount, FailureHandling.STOP_ON_FAILURE)

		Mobile.tap(findTestObject('iOS/Account_Selection/AccountNo_Text', [('val') : newAccount]), 0)
	}



	/**
	 * adds the product from dashboard
	 * @param productName,quantity
	 */
	@Keyword
	def Adding_Product_from_Dashboard_To_Cart(String productName, String quantity) {

		(new ios_common_keywords.wait_for_load()).waitForPageLoad()

		Mobile.tapAndHold(findTestObject('iOS/Inventory/Location Details_Screen/Add Product to Location/Product SearchField'), 0, 0)

		(new ios_common_keywords.wait_for_load()).waitForPageLoad()

		Mobile.setText(findTestObject('iOS/Product_Search/Product SearchField'), productName, 0)

		Mobile.tapAndHold(findTestObject('iOS/Product_Search/Search Key_Button'), 0, 0)

		Mobile.setText(findTestObject('iOS/Product_Search/Quantity_TextField'), quantity, 0)

		Mobile.tap(findTestObject('iOS/Orders/Cart Page/Place All Orders/Done_Keypad'), 0)

		Mobile.tap(findTestObject('iOS/Inventory/Inventory Details Screen/Add Product to Inventory using Search from Dashoboard/Add to Order_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Product_Search/Confirmation_Text'), 0)

		Mobile.tapAndHold(findTestObject('iOS/Orders/Order Details Page/Upload Order/After Adding Product Continue_Button'), 0,0)
	}
}