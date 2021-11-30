package androidOrders
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


class historyScreen {

	/**
	 * opens the c2 order details, verifies the order status labels and signIns the password required for placing c2 order
	 * @param password (password-which is required for placing the c2 order)
	 */
	@Keyword()
	def clickOnC2OrderForReviewAndSign(String signingPassword) {

		Mobile.tap(findTestObject('Android/Orders/C2 Order Details Screen/Place C2 Order/reviewAndSign_Button'), 0)

		Mobile.tap(findTestObject('Android/Orders/C2 Order Details Screen/Place C2 Order/signatureRequired_TextvVew'), 0)

		Mobile.tap(findTestObject('Android/Orders/C2 Order Details Screen/Place C2 Order/signNow_Button'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/C2 Order Details Screen/Place C2 Order/signatureNeeded_TextView'), 0)

		Mobile.tap(findTestObject('Android/Orders/C2 Order Details Screen/Place C2 Order/signingPassword_TextField'), 0)

		Mobile.setText(findTestObject('Android/Orders/C2 Order Details Screen/Place C2 Order/signingPassword_TextField'), signingPassword, 0)

		Mobile.tap(findTestObject('Android/Orders/C2 Order Details Screen/Place C2 Order/placeOrder_Button'), 0)

		Mobile.tap(findTestObject('Android/Orders/C2 Order Details Screen/Place C2 Order/goToOrderHistory_Button'), 0)
	}
	
	
	@Keyword
	def verify_History_Screen_Details() {

		Mobile.verifyElementExist(findTestObject('Android/Orders/History Screen/Order History_HeaderText'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/Order Details Screen/Verification Details/Scan_Icon'),0)

		Mobile.verifyElementExist(findTestObject('Android/Orders/History Screen/Order History_TextView'), 0)
	}
}