package androidAccountSelection
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


class selectAnAccount {



	/**
	 * selects the user account from the accounts list and takes user to the dashboard screen
	 * @param accountNo (user account number to be selected)
	 */
	@Keyword
	def selectTheUserAccount(String accountNo) {

		if (Mobile.waitForElementPresent(findTestObject('Android/accountSelection/youMustSelectAnAccountToContinue_TextView'), 0, FailureHandling.OPTIONAL)) {
			Mobile.scrollToText(accountNo, FailureHandling.STOP_ON_FAILURE)

			Mobile.tap(findTestObject('Android/accountSelection/accountNo_TextView',[('val') : accountNo]), 0)

			(new androidCommonKeywords.commonMethods()).waitForProgressBarToBeInvisible()
		}
	}

	/**
	 * selects the user account from the accounts list and takes user to the dashboard screen
	 * @param accountNo (user account number to be selected)
	 */
	@Keyword
	def selectAnotherAccount(String accountNo) {

		Mobile.scrollToText(accountNo, FailureHandling.STOP_ON_FAILURE)

		Mobile.tap(findTestObject('Android/accountSelection/accountNo_TextView',[('val') : accountNo]), 0)

		(new androidCommonKeywords.commonMethods()).waitForProgressBarToBeInvisible()
	}
	
	/**
	 * Change account
	 */
	@Keyword
	def changeAccount() {

		Mobile.tap(findTestObject('Android/audits/account_Icon'), 0)
		Mobile.delay(2)
		Mobile.tap(findTestObject('Android/audits/changeAccount_Icon'), 0)
		(new androidCommonKeywords.commonMethods()).waitForProgressBarToBeInvisible()
		Mobile.delay(2)
	}
	
	/**
	 * It verify the Audits account
	 */
	@Keyword
	def verifyAccount(String first_account) {

		Mobile.verifyElementExist(findTestObject('Android/audits/accountID', [('AccountID') : first_account]), 0)
		String accountId = Mobile.getText(findTestObject('Android/audits/accountID', [('AccountID') : first_account]), 0)
		assert accountId.contains(first_account)
	}
}
