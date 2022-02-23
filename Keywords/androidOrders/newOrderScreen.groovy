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


class newOrderScreen {

	@Keyword
	def change_Account(String New_Account) {

		Mobile.tap(findTestObject('Android/Dashboard/changeAccount_Button'), 0)

		Mobile.tap(findTestObject('Android/accountSelection/ChangeAccount_TextView'), 0)

		Mobile.scrollToText(New_Account, FailureHandling.STOP_ON_FAILURE)

		Mobile.tap(findTestObject('Android/accountSelection/Accounts Listing Screen/Account_No', [('val') : New_Account]), 0)

		int w = 1

		while (Mobile.verifyElementExist(findTestObject('Android/login/loginDetailsScreen/progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}
	}

	/**
	 * selects different account
	 * @param accountNo (account number used for selection)
	 */
	@Keyword
	def changeAccount(String accountNo) {
		Mobile.tap(findTestObject('Android/Dashboard/changeAccount_Button'), 0)
		Mobile.tap(findTestObject('Android/accountSelection/ChangeAccount_TextView'), 0)
		Mobile.scrollToText(accountNo, FailureHandling.STOP_ON_FAILURE)
		Mobile.tap(findTestObject('Android/accountSelection/accountNo_TextView',[('val') : accountNo]), 0)
	}

	/**
	 * opens new order page
	 */
	@Keyword
	def clickOnNewOrder() {
		Mobile.tap(findTestObject('Android/orders/newOrderScreen/newOrder_Tab'), 0)
	}

	/**
	 * taps on create order button to create an order
	 */
	@Keyword
	def createOrder() {
		Mobile.tap(findTestObject('Android/orders/newOrderScreen/createOrder_Button'), 0)
		
		(new androidCommonKeywords.commonMethods()).waitForProgressBarToBeInvisible()
	}

	/**
	 * adds poname pomemo to textfield
	 * @param poName(purchase order name for the order created)
	 * @param poMwmo(purchase order Memo for the order created)
	 */
	@Keyword
	def enterPurchaseOrderDetails(String poName,String poMemo) {
		Mobile.tap(findTestObject('Android/orders/newOrderScreen/P.O. Name (Optional)_TextField'), 0)
		Mobile.setText(findTestObject('Android/orders/newOrderScreen/P.O. Name (Optional)_TextField'), poName, 0)
		Mobile.pressBack()
		Mobile.tap(findTestObject('Android/orders/newOrderScreen/poMemo_EditText'), 0)
		Mobile.setText(findTestObject('Android/orders/newOrderScreen/poMemo_EditText'), poMemo, 0)
		Mobile.pressBack()
	}

	/**
	 * verifies new order screen
	 */
	@Keyword
	def verifyNewOrderScreenAccount() {
		String actualAccountNumber = Mobile.getText(findTestObject('Android/orders/newOrderScreen/accountID_Textview'), 0)
		assert actualAccountNumber == GlobalVariable.Account
		Mobile.verifyElementExist(findTestObject('Android/orders/newOrderScreen/P.O. Name (Optional)_TextField'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/newOrderScreen/poMemo_EditText'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/newOrderScreen/changeAccount_TextView'), 0)
	}

	/**
	 * verifies new order screen
	 */
	@Keyword
	def verifyNewOrderScreenDetails() {
		Mobile.verifyElementExist(findTestObject('Android/orders/newOrderScreen/cartHeader_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/newOrderScreen/createAnewOrder_TextView'),	0)
		Mobile.verifyElementExist(findTestObject('Android/orders/newOrderScreen/newOrder_Tab'),0)
		Mobile.verifyElementExist(findTestObject('Android/orders/orderDetailsScreen/verificationDetails/Scan_Icon'),0)
		Mobile.verifyElementExist(findTestObject('Android/orders/newOrderScreen/Account_TextView'), 0)
		Mobile.verifyElementExist(findTestObject('Android/orders/newOrderScreen/changeAccount_TextView'), 0)
	}
}