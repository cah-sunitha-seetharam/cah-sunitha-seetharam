package androidDashboard
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

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import io.appium.java_client.MobileElement


class dashboardDetailsScreen {

	@Keyword
	def change_Account(String new_Account) {


		Mobile.tap(findTestObject('Android/Dashboard/changeAccount_Button'), 0)

		Mobile.tap(findTestObject('Android/Account Selection/ChangeAccount_TextView'), 0)

		while (Mobile.verifyElementNotVisible(findTestObject('Android/Account Selection/AccountNo_TextView',[('val') : new_Account]), 2, FailureHandling.OPTIONAL)) {
			Mobile.swipe(600, 800, 600, 200)
		}
		Mobile.tap(findTestObject('Android/Account Selection/AccountNo_TextView',[('val') : new_Account]), 0)

		int w = 1

		while (Mobile.verifyElementExist(findTestObject('Android/Login/Login Details Screen/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}
	}



	@Keyword
	def Adding_Product_from_Dashboard_To_Cart(String Product_Name, String Quantity) {
		int w = 1

		while (Mobile.verifyElementExist(findTestObject('Android/Login/Login Details Screen/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}

		Mobile.tap(findTestObject('Android/Product Search/Search Products_SearchView'), 0)

		Mobile.setText(findTestObject('Android/Product Search/Search Products_SearchView'), Product_Name + '\\n',
				0)

		while (Mobile.verifyElementExist(findTestObject('Android/Login/Login Details Screen/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}

		Mobile.setText(findTestObject('Android/Product Search/Quantity_TextField'), Quantity, 0)


		Mobile.tap(	findTestObject('Object Repository/Android/Product Search/Add to Order_Button'), 0)

		Mobile.tap(findTestObject('iOS/Product_Search/Continue Browsing_Button'), 0)
	}

	/**
	 * this function verifies the dash-board details Screen
	 */
	@Keyword
	def verifyDashboardPage() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Dashboard/home_Tab'), 0)
	}

	/**
	 * opens orders tab where user can perform actions related to orders
	 */
	@Keyword
	def clickOnOrders() {

		MobileElement element = MobileElementCommonHelper.findElement(findTestObject('Object Repository/Android/Dashboard/Orders_Tab'), 10)
		element.click()
	}


	/**
	 * opens home tab where user can perform actions related to home
	 */
	@Keyword
	def clickOnHomeTab() {

		MobileElement element = MobileElementCommonHelper.findElement(findTestObject('Android/Dashboard/home_TextView'), 10)
		element.click()
	}

	/**
	 * opens more options tab where user can perform actions related to more options
	 */
	@Keyword
	def clickOnMoreOptions() {

		MobileElement element = MobileElementCommonHelper.findElement(findTestObject('Android/Dashboard/moreOptions_Tab'), 10)
		element.click()
	}


	/**
	 * opens moreOptions tab where user can perform actions like signOut, goToInventoryListing Screen etc
	 */
	@Keyword
	def clickOnMoreOptionsTab() {

		Mobile.tap(findTestObject('Android/Dashboard/moreOptions_Tab'), 0)
	}


	/**
	 * opens receiving tab
	 */
	@Keyword
	def clickOnReceivingTab() {
		MobileElement element = MobileElementCommonHelper.findElement(findTestObject('Object Repository/Android/Dashboard/receiving_Tab'), 10)
		element.click()
	}
}