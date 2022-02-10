package iosMoreOptions
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

import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

class moreOptionsScreen {


	/**
	 * enables beta csos feature toggle from more options
	 */
	@Keyword()
	def enableBetaFeatureCSOS() {

		Mobile.tap(findTestObject('iOS/moreOptionsScreen/betaFeature/betaFeatures_Tab'), 0)

		Mobile.tap(findTestObject('iOS/moreOptionsScreen/betaFeature/betaFeatureSwitch_Toggle'), 0)

		Mobile.tap(findTestObject('iOS/moreOptionsScreen/betaFeature/termsAgree_CheckBox'), 0)

		Mobile.tap(findTestObject('iOS/moreOptionsScreen/betaFeature/disclaimerConfirm_Button'), 0)

		(new iosCommonKeywords.commonMethods()).waitForProgressBarToBeInvisible()
	}


	/**
	 * opens the inventory listing screen from moreOptions Screen
	 */
	@Keyword()
	def goToInventoryListingScreen() {

		Mobile.tap(findTestObject('iOS/moreOptionsScreen/inventorySelection/inventorySelectionUnderMoreOptions_Text'), 0)
	}



	/**
	 * clicks on moreOptions tab, signsOut the user and takes user to the logInScreen
	 */
	@Keyword()
	def signOut() {

		(new iosCommonKeywords.commonMethods()).waitForProgressBarToBeInvisible()

		Mobile.tap(findTestObject('iOS/dashboard/tabs/moreOptions_Tab'), 0)

		Mobile.tap(findTestObject('iOS/moreOptionsScreen/signOut/signOut_Text'), 0)

		Mobile.tap(findTestObject('iOS/moreOptionsScreen/signOut/signOut_Button'), 0)
	}



	/**
	 * opens the message center
	 */
	@Keyword
	def tapMessageCentre() {
		Mobile.tapAndHold(findTestObject('iOS/moreOptionsScreen/messageCentre/messageCentre_Text'), 0, 0)
	}



	/**
	 * opens alert
	 */
	@Keyword
	def tapOnAlert () {
		Mobile.tap(findTestObject('iOS/moreOptionsScreen/messageCentre/alertSubTitle_Text'), 0)
	}



	/**
	 * opens top most message
	 */
	@Keyword
	def tapOnTopMostMessage () {
		Mobile.tap(findTestObject('iOS/moreOptionsScreen/messageCentre/topMostMessageTitle_Text'), 0)
	}



	/**
	 * verifies alert message description
	 */
	@Keyword
	def verifyAlertMessageDescription () {
		Mobile.verifyElementExist(findTestObject('iOS/moreOptionsScreen/messageCentre/alertDescription_Text'), 0)
	}



	/**
	 * verifies alert and message
	 */
	@Keyword
	def verifyMessageCentre () {
		Mobile.verifyElementExist(findTestObject('iOS/moreOptionsScreen/messageCentre/alertSubTitle_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/moreOptionsScreen/messageCentre/topMostMessageTitle_Text'), 0)
	}


	/**
	 * verifies message center in offline
	 */
	@Keyword
	def verifyMessageCentreInOffline () {
		Mobile.verifyElementExist(findTestObject('iOS/moreOptionsScreen/messageCentre/noMessageAvailableWhileOffline_Text'), 0)
	}


	/**
	 * verifies message description
	 */
	@Keyword
	def verifyMessageDescription () {
		Mobile.verifyElementExist(findTestObject('iOS/moreOptionsScreen/messageCentre/descriptionOfMessage_Text'), 0)
	}
}