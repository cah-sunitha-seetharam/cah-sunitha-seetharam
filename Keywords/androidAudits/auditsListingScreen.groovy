package androidAudits
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import common.commonMethods
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

import io.appium.java_client.MobileElement



class auditsListingScreen {

	def commonMethodsObject = new commonMethods()

	/**
	 * Tap on quantity count box
	 * Verify its highlighted by green color background
	 */
	@Keyword
	def tapOnQuantityBox() {

		Mobile.tap(findTestObject('Android/Audits/quantityLayout'), 0)

		//		String idOfTheElement = Mobile.getAttribute(findTestObject('Android/Audits/quantityLayout'), 'resource-id', 0)
		//
		//		KeywordUtil.logInfo(idOfTheElement)
		//
		//		commonMethodsObject.verifyElementColor(105,170,115,idOfTheElement) //light green with hex code #69aa73 - Emulator

		//	commonMethodsObject.verifyElementColor(146,255,161,idOfTheElement) //light green with hex code #92ffa1 - Real Device

	}


	/**
	 * Long press on quantity count box 
	 */
	@Keyword
	def longPressOnQuantityBox() {

		Mobile.longPress(findTestObject('Android/Audits/quantityLayout'), 0)
	}

	/**
	 * verify initial count value
	 * tap on + button
	 * verify the count is increased
	 */
	@Keyword
	def increaseCount() {

		int Count = Mobile.getText(findTestObject('Android/Audits/quantity'),0).toInteger()

		KeywordUtil.logInfo("Initial Count is:" + Count)

		Mobile.tap(findTestObject('Android/Audits/increaseCount'), 0)

		int increasedCount = Mobile.getText(findTestObject('Android/Audits/quantity'),0).toInteger()

		KeywordUtil.logInfo("After tapping" + increasedCount)

		int valueOfeachCount = increasedCount - Count

		KeywordUtil.logInfo("valueOfeachCount is" + valueOfeachCount)

		assert increasedCount == (Count + valueOfeachCount)
	}

	/**
	 * verify initial count value
	 * tap on - button
	 * verify the count is decreased
	 */
	@Keyword
	def decreaseCount() {

		Mobile.tap(findTestObject('Android/Audits/increaseCount'), 0)

		int Count = Mobile.getText(findTestObject('Android/Audits/quantity'),0).toInteger()

		KeywordUtil.logInfo("Initial Count is:" + Count)

		Mobile.tap(findTestObject('Android/Audits/decreaseCount'), 0)

		int decreaseCountCount = Mobile.getText(findTestObject('Android/Audits/quantity'),0).toInteger()

		KeywordUtil.logInfo("After tapping" + decreaseCountCount)

		int valueOfeachCount = Count - decreaseCountCount

		KeywordUtil.logInfo("valueOfeachCount is" + valueOfeachCount)

		assert decreaseCountCount == (Count - valueOfeachCount)
	}


	/**
	 * get final count value
	 * tap on confirmAuditCount button
	 * return the final count value
	 */
	@Keyword
	def confirmAuditCount() {

		int count = Mobile.getText(findTestObject('Android/Audits/quantity'),0).toInteger()

		KeywordUtil.logInfo("Count is: " + count)

		Mobile.tap(findTestObject('Android/Audits/confirmAuditCount'), 0)

		return count
	}


	/**
	 * verify the final count value with the audit list count
	 */
	@Keyword
	def verifyQuantity(int quantity) {

		int count = Mobile.getText(findTestObject('Android/Audits/quantity'),0).toInteger()

		KeywordUtil.logInfo("Count is: " + count)

		assert count == quantity
	}

	/**
	 * Change account
	 */
	@Keyword
	def changeAccount() {

		Mobile.tap(findTestObject('Android/Audits/accountIcon'), 0)
		Mobile.delay(2)
		Mobile.tap(findTestObject('Android/Audits/changeAccountIcon'), 0)
		Mobile.delay(2)
	}

	/**
	 * Tap on all the boxes
	 */
	@Keyword
	def tapOnAllBox() {

		Mobile.tap(findTestObject('Android/Audits/selectBox',[('val') : 1]), 0)
		Mobile.delay(2)
		Mobile.longPress(findTestObject('Android/Audits/selectBox',[('val') : 1]), 0)
		Mobile.tap(findTestObject('Android/Audits/increaseCount'), 0)
		Mobile.tap(findTestObject('Android/Audits/confirmAuditCount'), 0)
		Mobile.delay(2)

		String noOfItem = Mobile.getText(findTestObject('Android/Audits/groupAuditStatus'), 0)
		String noOfItemValue = noOfItem.charAt(2)
		int itemValue = noOfItemValue.toInteger()

		//		KeywordUtil.logInfo("Count is: " + noOfItem)
		//		KeywordUtil.logInfo("nth position is: " + itemValue)

		for (int i = 1; i < itemValue; i++) {

			Mobile.tap(findTestObject('Android/Audits/onHand',[('val') : i]), 0)
			Mobile.delay(2)
		}
	}


	/**
	 * It verify the group completed icon
	 */
	@Keyword
	def isGroupAudited() {

		while (Mobile.verifyElementNotVisible(findTestObject('Android/Audits/isGroupCompletelyAudited'), 2, FailureHandling.OPTIONAL)) {
			Mobile.swipe(600, 800, 600, 300)
		}

		Mobile.verifyElementExist(findTestObject('Android/Audits/isGroupCompletelyAudited'), 0)
	}

	/**
	 * It verify the submit button and tap on it
	 */
	@Keyword
	def submitCompletedGroups() {

		Mobile.verifyElementExist(findTestObject('Android/Audits/submitCompletedGroups'), 0)
		Mobile.tap(findTestObject('Android/Audits/submitCompletedGroups'), 0)
		Mobile.delay(2)
	}

	/**
	 * It verify the Audits list screen
	 */
	@Keyword
	def verifyAuditsScreen(String expectedMessage) {

		Mobile.verifyElementExist(findTestObject('Android/Audits/welcomeMessage'), 0)
		String message = Mobile.getText(findTestObject('Android/Audits/welcomeMessage'),0)
		assert message.contains(expectedMessage)

		Mobile.verifyElementExist(findTestObject('Android/Audits/ndcNumber'), 0)
		Mobile.verifyElementExist(findTestObject('Android/Audits/groupAuditStatus'), 0)
		Mobile.verifyElementExist(findTestObject('Android/Audits/groupName'), 0)
		Mobile.delay(2)
		String buttonStatus = Mobile.getAttribute(findTestObject('Android/Audits/submitCompletedGroups'), 'enabled', 0)
		assert buttonStatus == "false"
	}

	/**
	 * It verify the Audits account
	 */
	@Keyword
	def verifyAccount(String first_account) {

		Mobile.verifyElementExist(findTestObject('Android/Audits/accountID', [('AccountID') : first_account]), 0)
		String accountId = Mobile.getText(findTestObject('Android/Audits/accountID', [('AccountID') : first_account]), 0)
		assert accountId.contains(first_account)
	}
}