package androidMoreOptions
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
import io.appium.java_client.MobileElement
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


class moreOptionsScreen {

	/**
	 * switches the account of user to another account
	 * @param accountNo (accountNo which needs to be selected will be passed as a parameter)
	 */
	@Keyword()
	def changeAccount(accountNo) {

		Mobile.tap(findTestObject('Android/dashboard/changeAccount_Button'), 0)

		Mobile.tap(findTestObject('Android/Account Selection/ChangeAccount_TextView'), 0)

		Mobile.scrollToText(accountNo, FailureHandling.STOP_ON_FAILURE)

		Mobile.tap(findTestObject('Android/Account Selection/Accounts Listing Screen/Account_No', [('val') : accountNo]), 0)
	}

	/**
	 * opens the message center
	 */
	@Keyword
	def tapMessageCentre() {
		Mobile.tapAndHold(findTestObject('Android/moreOptionsScreen/messageCentre/messageCentre_Text'), 0, 0)
	}

	/**
	 * verifies message
	 */
	@Keyword
	def verifyMessageCentre () {
		Mobile.verifyElementExist(findTestObject('Android/moreOptionsScreen/messageCentre/topMostMessageTitle_Text'), 0)
	}
	
	/**
	 * verifies message description
	 */
	@Keyword
	def verifyMessageDescription () {
		Mobile.verifyElementExist(findTestObject('Android/moreOptionsScreen/messageCentre/descriptionOfMessage_Text'), 0)
	}
	
	/**
	 * opens top most message
	 */
	@Keyword
	def tapOnTopMostMessage () {
		Mobile.tapAndHold(findTestObject('Android/moreOptionsScreen/messageCentre/topMostMessageTitle_Text'), 0, 0)
	}
	
	/**
	 * enables beta csos feature
	 */
	@Keyword()
	def enableBetaFeatureCSOS() {
		Mobile.tap(findTestObject('Android/moreOptionsScreen/betaFeature/betaFeatures_TextView'), 0)
		Mobile.tap(findTestObject('Android/moreOptionsScreen/betaFeature/CSOSSubmitAndSignOff_Switch'), 0)
		Mobile.tap(findTestObject('Android/moreOptionsScreen/betaFeature/iAgreeToTheTermsOfTheBetaProgram_CheckBox'), 0)
		Mobile.tap(findTestObject('Android/moreOptionsScreen/betaFeature/confirm_Button'), 0)
		Mobile.delay(2)
	}

	/**
	 * takes the user from the the moreOptions Screen to inventory listing screen
	 */
	@Keyword()
	def goToInventoryListingScreen() {

		Mobile.tap(findTestObject('Android/Inventory/Inventory Listing Screen/Verification Details/openInventory_TextView'), 0)
	}



	/**
	 * clicks on moreOptions tab, signsOut the user and takes user to the logInScreen
	 */
	@Keyword()
	def signOut() {
		
		(new androidCommonKeywords.commonMethods()).waitForProgressBarToBeInvisible()
		
		MobileElement element = MobileElementCommonHelper.findElement(findTestObject('Android/dashboard/moreOptions_Tab'), 10)
		element.click()

		Mobile.tap(findTestObject('Android/moreOptionsScreen/signOut/signOut_TextView'), 0)

		Mobile.tap(findTestObject('Android/moreOptionsScreen/signOut/signOut_Button'), 0)
	}
}