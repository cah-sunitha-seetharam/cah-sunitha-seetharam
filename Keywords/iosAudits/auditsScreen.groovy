package iosAudits

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import com.kms.katalon.core.util.KeywordUtil

import common.commonMethods

import internal.GlobalVariable

public class auditsScreen {

	def commonMethodsObject=new commonMethods();
	def commonIosMethodsObject=new iosCommonKeywords.commonMethods();

	/**
	 * this function changes account from change account navigation in the audits landing Screen
	 */
	@Keyword
	def change_Account(String new_Account) {

		//Mobile.tap(findTestObject('iOS/Account_Selection/changeAccount_Text'), 0)

		Mobile.tap(findTestObject('iOS/Account Selection/changeAccount_Button'), 0)

		Mobile.tap(findTestObject('iOS/Account Selection/changeAccount_Navigation'), 0)

		Mobile.scrollToText(new_Account, FailureHandling.STOP_ON_FAILURE)

		Mobile.tap(findTestObject('iOS/Account Selection/accountNo_Text', [('val') : new_Account]), 0)

		int w = 1

		while (Mobile.verifyElementExist(findTestObject('iOS/Product Search/Progress_Bar'), w, FailureHandling.OPTIONAL)) {
			WebUI.delay(w)
		}
	}


	/**
	 * this function verifies the audits landing Screen
	 */
	@Keyword
	def verifyAuditsLandingScreen() {

		Mobile.verifyElementExist(findTestObject('iOS/Audits/auditProgressMsg_Label'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Audits/auditScreen_Header'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Audits/submitCompletedGroups_Button'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Account Selection/changeAccount_Button'), 0)

	}


	/**
	 * this function verifies the audits landing Screen
	 */
	@Keyword
	def closeChangeAccountPrompt() {

		if (Mobile.verifyElementVisible(findTestObject('iOS/Account Selection/changeAccount_Button'), 0) &&
		Mobile.verifyElementVisible(findTestObject('iOS/Account Selection/changeAccount_Navigation'), 0)) {

			Mobile.tap(findTestObject('iOS/Account Selection/changeAccount_Button'), 0)

		}

	}


	/*
	 * this function taps on quantity field in audits screen for a product listed
	 */
	@Keyword
	def clickOnQuantityBox() {

		Mobile.verifyElementExist(findTestObject('iOS/Audits/quantityBox_First'), 0)

		Mobile.tap(findTestObject('iOS/Audits/quantityBox_First'), 0)

		String nameOfTheElement = Mobile.getAttribute(findTestObject('iOS/Audits/quantityBox_First'), 'name', 0)

		KeywordUtil.logInfo(nameOfTheElement)

		//commonMethodsObject.verifyElementColor(105,170,115,nameOfTheElement) //light green with hex code #69aa73 - emulator

		commonMethodsObject.verifyElementColor(241, 1, 40, nameOfTheElement) //light green with hex code #92ffa1 - device
	}

	/**
	 * this function performs long press on quantity count box
	 */
	@Keyword
	def longPressOnQuantityBox() {

		Mobile.longPress(findTestObject('iOS/Audits/quantityBox_First'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Audits/editCountScreen_ProductDetails'), 0)
	}


	/**
	 * verifies initial count value
	 * taps on + button
	 * verifies the count is increased
	 */
	@Keyword
	def increaseCount() {

		int Count = Mobile.getText(findTestObject('iOS/Audits/editCount_Textbox'),0).toInteger()

		KeywordUtil.logInfo("Initial Count is:" + Count)

		Mobile.tap(findTestObject('iOS/Audits/incrementQuantinty_Button'), 0)

		int increasedCount = Mobile.getText(findTestObject('iOS/Audits/editCount_Textbox'),0).toInteger()

		KeywordUtil.logInfo("After tapping" + increasedCount)

		int valueOfeachCount = increasedCount - Count

		KeywordUtil.logInfo("valueOfeachCount is" + valueOfeachCount)

		assert increasedCount == (Count + valueOfeachCount)
	}

	/**
	 * verifies initial count value
	 * taps on - button
	 * verifies the count is decreased
	 */
	@Keyword
	def decreaseCount() {

		Mobile.tap(findTestObject('iOS/Audits/incrementQuantinty_Button'), 0)

		int Count = Mobile.getText(findTestObject('iOS/Audits/editCount_Textbox'),0).toInteger()

		KeywordUtil.logInfo("Initial Count is:" + Count)

		Mobile.tap(findTestObject('iOS/Audits/decrementQuantity_Button'), 0)

		int decreaseCountCount = Mobile.getText(findTestObject('iOS/Audits/editCount_Textbox'),0).toInteger()

		KeywordUtil.logInfo("After tapping" + decreaseCountCount)

		int valueOfeachCount = Count - decreaseCountCount

		KeywordUtil.logInfo("valueOfeachCount is" + valueOfeachCount)

		assert decreaseCountCount == (Count - valueOfeachCount)
	}

	/**
	 * gets final count value
	 * taps on confirmAuditCount button
	 * returns the final count value
	 */
	@Keyword
	def confirmAuditCount() {

		int count = Mobile.getText(findTestObject('iOS/Audits/editCount_Textbox'),0).toInteger()

		KeywordUtil.logInfo("Count is: " + count)

		Mobile.tap(findTestObject('iOS/Audits/confirmCount_Button'), 0)

		return count
	}


	/**
	 * verifies the final count value with the audit list count
	 */
	@Keyword
	def verifyQuantity(int quantity) {

		int count = Mobile.getText(findTestObject('iOS/Audits/auditQuantity_Label'),0).toInteger()

		KeywordUtil.logInfo("Count is: " + count)

		assert count == quantity
	}
	
	/**
	 * Tap on all the boxes
	 */
	@Keyword
	def clickAllQuantityBoxes() {

		String noOfItem = Mobile.getText(findTestObject('iOS/Audits/auditProductCount_Text'), 0)
		String noOfItemValue = noOfItem.charAt(2)
		int itemValue = noOfItemValue.toInteger()

		KeywordUtil.logInfo("Count is: " + noOfItem)
		KeywordUtil.logInfo("nth position is: " + itemValue)

		for (int i = 1; i <= itemValue; i++) {

			Mobile.tap(findTestObject('iOS/Audits/auditOnHand_Label', ['+ @index= +': i]), 0)
			Mobile.delay(2)
		}
	}


}
