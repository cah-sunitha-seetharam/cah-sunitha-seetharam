package iosReceiving
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.sun.net.httpserver.Authenticator.Failure
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
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By
import org.openqa.selenium.TakesScreenshot
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.core.configuration.RunConfiguration

import groovy.json.JsonOutput as JsonOutput
import groovy.json.JsonSlurper
import java.awt.image.BufferedImage
import java.io.File
import java.math.RoundingMode
import java.text.DecimalFormat
import java.io.IOException;
import javax.imageio.ImageIO;
import org.openqa.selenium.OutputType
import org.openqa.selenium.Point
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

class receivingReusableMethods {

	/**
	 * creates a test object at run time
	 * resourceId (resource-id of the object)
	 */
	@Keyword
	static TestObject makeTestObject(String resourceId) {
		TestObject to = new TestObject()
		to.addProperty("resourceId", ConditionType.EQUALS, resourceId)
		return to
	}
	def iosCommonKeywordsObject=new iosCommonKeywords.commonMethods()



	def commonMethodsObject=new commonMethods()



	/**
	 * takes user back to receiving after uploading_totes
	 */
	@Keyword
	def clickOnBackToReceiving() {

		Mobile.tap(findTestObject('iOS/receiving/verification/backToReceiving_Text'), 0)
	}



	/**
	 * clicks on continue button after selection of shipments or invoice by user
	 */
	@Keyword
	def clickOnContinue() {

		Mobile.tap(findTestObject('iOS/receiving/verification/continue_Button'), 0)
	}



	/**
	 * clicks on got it issue
	 */
	@Keyword
	def clickOnGotItbutton() {

		iosCommonKeywordsObject.waitForProgressBarToBeInvisible()
		Mobile.tap(findTestObject('iOS/receiving/issueSubmission/gotIt_Button'), 0)
	}




	/**
	 * clicks on issue
	 */
	@Keyword
	def clickOnIssue() {

		Mobile.tapAndHold(findTestObject('iOS/receiving/issueSubmission/issue_Button'), 0,0)
	}



	/**
	 * clicks on receive all totes_button
	 */
	@Keyword
	def clickOnReceiveAllTotes() {

		Mobile.tap(findTestObject('iOS/receiving/verification/receiveTote_Button'),0)

		/*	Mobile.verifyElementExist(findTestObject('Android/Receiving/toteReceivingStatus_View'), 0)
		 String idOfTheElement=Mobile.getAttribute(findTestObject('Android/Receiving/toteReceivingStatus_View'), 'resource-id', 0)
		 KeywordUtil.logInfo(idOfTheElement)
		 commonMethodsObject.verifyElementColor(146,255,161,idOfTheElement) //light green with hex code #92ffa1
		 */
	}



	/**
	 * click on scan icon
	 */
	@Keyword
	def clickOnScanIcon() {

		//MobileElement element = MobileElementCommonHelper.findElement(findTestObject('Object Repository/Android/Receiving/scan_TextView'), 0)
		//element.click()
		Mobile.tap(findTestObject('iOS/receiving/verification/scan_Icon'), 0,FailureHandling.OPTIONAL)
	}



	/**
	 * clicks on submit issue
	 */
	@Keyword
	def clickOnSubmitIssue() {

		iosCommonKeywordsObject.waitForProgressBarToBeInvisible()
		Mobile.tap(findTestObject('iOS/receiving/issueSubmission/submitIssue_Button'), 0)
	}


	/**
	 * collapses the detailed view of_tote
	 */
	@Keyword
	def collpaseViewOfTotes() {

		Mobile.tap(findTestObject('Object Repository/Android/Receiving/collapseView_Image'), 0)
	}


	/**
	 * takes received product count as the argument and enters count in the text-field
	 * @param receivedProductCount (received product count)
	 */
	@Keyword
	def editReceivedProductCount(int receivedProductCount) {

		Mobile.tapAndHold(findTestObject('iOS/receiving/verification/receivingProduct_TextField'),0,0)
		Mobile.tapAndHold(findTestObject('iOS/receiving/verification/deleteKeypad_Button'),0,0)
		Mobile.setText(findTestObject('iOS/receiving/verification/receivingProduct_TextField'), receivedProductCount.toString(),0)
		Mobile.tap(findTestObject('iOS/receiving/verification/doneKeypad_Button'), 0)
	}



	/**
	 * enters detail for contact
	 * @param name
	 * @param phoneNumber
	 * @param emailID
	 * @param comment
	 */
	@Keyword
	def enterDetailsForContact(String name, String phoneNumber, String comment) {

		Mobile.scrollToText("Enter Comments")
		iosCommonKeywordsObject.waitForProgressBarToBeInvisible()
		Mobile.verifyElementExist(findTestObject('iOS/receiving/issueSubmission/contactDetails_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/receiving/issueSubmission/name_Text'), 0)
		Mobile.tap(findTestObject('iOS/receiving/issueSubmission/name_TextField'), 0)
		Mobile.setText(findTestObject('iOS/receiving/issueSubmission/name_TextField'), name, 0)
		Mobile.tapAndHold(findTestObject('iOS/receiving/issueSubmission/doneKeypad_Button'), 0,2,FailureHandling.OPTIONAL)

		Mobile.verifyElementExist(findTestObject('iOS/receiving/issueSubmission/enterPhoneNumber_Text'), 0)
		Mobile.tap(findTestObject('iOS/receiving/issueSubmission/phoneNumber_TextField'), 0)
		Mobile.setText(findTestObject('iOS/receiving/issueSubmission/phoneNumber_TextField'), phoneNumber, 0)
		Mobile.tapAndHold(findTestObject('iOS/receiving/issueSubmission/doneKeypad_Button'), 0,2,FailureHandling.OPTIONAL)

		String expectedID=Mobile.getText(findTestObject('iOS/receiving/issueSubmission/email_TextField'), 0)
		(expectedID.contains("@cardinalhealth.com"))
		assert true

		Mobile.tap(findTestObject('iOS/receiving/issueSubmission/email_TextField'), 0)
		Mobile.setText(findTestObject('iOS/receiving/issueSubmission/email_TextField'),expectedID, 0)
		Mobile.tapAndHold(findTestObject('iOS/receiving/issueSubmission/doneKeypad_Button'), 0,2,FailureHandling.OPTIONAL)

		Mobile.verifyElementExist(findTestObject('iOS/receiving/issueSubmission/enterComments_Text'), 0)
		Mobile.tap(findTestObject('iOS/receiving/issueSubmission/enterComments_TextField'), 0)
		Mobile.setText(findTestObject('iOS/receiving/issueSubmission/enterComments_TextField'), comment, 0)
		Mobile.tapAndHold(findTestObject('iOS/receiving/issueSubmission/doneKeypad_Button'), 0,2,FailureHandling.OPTIONAL)
	}



	/**
	 * expands the view to see detailed view of_tote
	 */
	@Keyword
	def expandToSeeDetailedViewOfTotes() {

		Mobile.tap(findTestObject('Object Repository/Android/Receiving/expandView_Image'), 0)
	}



	/**
	 * this function opens invoice details
	 * @param invoiceNumber (invoice number)
	 */
	@Keyword
	def openInvoiceDetails(invoiceNumber) {

		Mobile.tap(findTestObject('iOS/receiving/verification/invoice_Tile',[('TEXT'):invoiceNumber]), 0)
	}




	/**
	 * this function opens shipment details
	 * @param shipmentNumber (shipment number)
	 */
	@Keyword
	def openShipmentDetails(shipmentNumber) {

		Mobile.tap(findTestObject('iOS/receiving/verification/shipment_Tile',[('TEXT'):shipmentNumber]), 0)
	}




	/**
	 * returns max upper value without over-age product count
	 * @return maxReceivingProductCountWithoutOverage (max upper value without over-age product count)
	 */
	@Keyword
	def returnUpperLimitReceivingProductCount() {

		String maxReceivingProductCountWithoutOverage=Mobile.getText(findTestObject('iOS/receiving/verification/productReceivedStatus_Label'), 0)

		maxReceivingProductCountWithoutOverage = iosCommonKeywordsObject.removeCharactersInString(maxReceivingProductCountWithoutOverage)
		int beginIndex=1
		maxReceivingProductCountWithoutOverage=maxReceivingProductCountWithoutOverage.substring(beginIndex)
		KeywordUtil.logInfo(maxReceivingProductCountWithoutOverage)

		return (maxReceivingProductCountWithoutOverage.toInteger())
	}




	/**
	 * takes product to be searched as the argument and searches for the product
	 * @param productToBeSearched (name which can be a productName/Cin/NDC of the product to be added)
	 */
	@Keyword
	def scanInputEvent(String productToBeSearched) {

		Mobile.tap(findTestObject('iOS/receiving/verification/tapToScan_Text'), 0)
		Mobile.setText(findTestObject('iOS/receiving/verification/enterBarcode_TextField'), productToBeSearched, 0)
		Mobile.tap(findTestObject('iOS/receiving/verification/scan_Button'), 0)
	}



	/**
	 * takes toteID to be searched as the argument and searches the same
	 */
	@Keyword
	def searchTote(toteID) {

		Mobile.tapAndHold(findTestObject('iOS/inventory/locationDetailsScreen/addProductToLocation/productSearch_TextField'), 0, 0)
		Mobile.setText(findTestObject('iOS/inventory/locationDetailsScreen/addProductToLocation/productSearch_TextField'), toteID, 0)
		Mobile.tapAndHold(findTestObject('iOS/productSearch/globalSearch/search_Keypad'), 0, 0)
	}



	/**
	 * allows over-ages in receiving
	 */
	@Keyword
	def selectAllowOverages() {

		//MobileElement element = MobileElementCommonHelper.findElement(findTestObject('iOS/receiving/verification/allowOverage_Button'), 0)
		//element.click()
		Mobile.tap(findTestObject('iOS/receiving/verification/allowOverage_Button'), 0)
	}



	/**
	 * this function will select invoices on the receiving screen
	 */
	@Keyword
	def selectInvoices() {

		Mobile.tap(findTestObject('iOS/receiving/verification/invoices_Button'), 0)
	}



	/**
	 * select reason of issue
	 * @param reasonForIssue
	 */
	@Keyword
	def selectReasonForIssue(String reasonForIssue) {

		if (reasonForIssue.equalsIgnoreCase('missing Tote')) {

			Mobile.verifyElementExist(findTestObject('iOS/receiving/issueSubmission/missingTote_Text'), 0)
			Mobile.tap(findTestObject('iOS/receiving/issueSubmission/missingTote_RadioButton'), 0)
		}

		else {

			Mobile.verifyElementExist(findTestObject('iOS/receiving/issueSubmission/wrongTote_Text'), 0)
			Mobile.tap(findTestObject('iOS/receiving/issueSubmission/wrongTote_RadioButton'), 0)
		}
	}



	/**
	 * this function will select shipments on the receiving screen
	 */
	@Keyword
	def selectShipments() {

		//MobileElement element = MobileElementCommonHelper.findElement(findTestObject('iOS/receiving/verification/shipments_Button'), 0)
		//element.click()
		Mobile.tap(findTestObject('iOS/receiving/verification/shipments_Button'), 0)
	}



	/**
	 * takes user to previous day shipments from today's shipments screen
	 */
	@Keyword
	def switchToPreviousDay() {

		Mobile.tap(findTestObject('iOS/receiving/verification/switchToPreviousDay_Button'), 0)
	}



	/**
	 * takes user to today's shipments from previous day shipments screen
	 */
	@Keyword
	def switchToToday() {

		Mobile.tap(findTestObject('iOS/receiving/verification/switchToToday_Button'), 0)
	}



	/**
	 * test method for run time object creation
	 */
	@Keyword
	def testFunction() {

		//Mobile.tap(findTestObject('Android/Login/Environment Selection Screen/Environment_Spinner'), 0)
		//Mobile.tap((makeTOwithXPath("com.cardinalhealth.orderexpress.two.debug:id/serverLocationSpinner")), 0)
		// DriverFactory.getWebDriver().findElements(By.id("com.cardinalhealth.orderexpress.two.debug:id/serverLocationSpinner"));
		'com.cardinalhealth.orderexpress.two.debug:id/serverLocationSpinner'
		MobileElement element = MobileElementCommonHelper.findElement(makeTestObject("${GlobalVariable.appPackage}:id/serverLocationSpinner"), 0)
		element.click()
		String testProfile=RunConfiguration.getExecutionProfile()
		KeywordUtil.logInfo(testProfile)
		Mobile.tap(findTestObject('Android/Login/Environment Selecttion Screen/environment_Spinner',[('appPackage'):GlobalVariable.appPackage]), 0)
	}


	/**
	 * uploads completed_totes
	 */
	@Keyword
	def uploadCompletedTotes() {

		Mobile.tap(findTestObject('iOS/receiving/verification/receivingUpload_Button'),0)
	}


	/**
	 * verifies that over-ages are allowed
	 */
	@Keyword
	def verifyAllowedOverages() {

		Mobile.verifyElementAttributeValue(findTestObject('iOS/receiving/verification/receivingAllowOverage_Button'),'enabled','true', 0)
	}


	/**
	 * verifies details of the instances of product associated with the account
	 * @param productNdcNumber (using NDC of the product which is visible on the product tab)
	 */
	@Keyword
	def verifyInstancesOfProductAssociatedWithAccount(productNdcNumber) {

		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/searchResult_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/toteID_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/toteNumber_Label'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/shipment_Label'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/shipmentNumber_Label'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/parametrizedNdc_Label',[('TEXT'):productNdcNumber]), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/productIssue_Button'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/receivedProduct_Label'), 0)
	}


	/**
	 * verifies the invoice is not visible on the screen
	 * @param invoiceNumber (invoice number)
	 */
	@Keyword
	def verifyInvoiceIsNotVisible(invoiceNumber) {

		Mobile.verifyElementNotVisible(findTestObject('iOS/receiving/verification/invoice_Tile',[('TEXT'):invoiceNumber]), 0)
	}


	/**
	 * this function verifies the invoice is visible on the screen
	 * @param invoiceNumber (invoice number)
	 */
	@Keyword
	def verifyInvoiceIsVisible(invoiceNumber) {

		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/invoice_Tile',[('TEXT'):invoiceNumber]), 0)
	}



	/**
	 * verify invoice number visible while submission of issue
	 */
	@Keyword
	def verifyInvoiceNumberInIssue(invoiceNumber) {

		Mobile.verifyElementExist(findTestObject('iOS/receiving/issueSubmission/invoiceNumber_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/issueSubmission/parametrizedInvoiceNumber_Text',[('TEXT'):invoiceNumber]), 0)
	}



	/**
	 * this method verifies the invoices detail
	 * @param invoiceNumber (invoice number)
	 */
	@Keyword
	def verifyInvoicesDetails(invoiceNumber) {

		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/invoice_Label',[('TEXT'):invoiceNumber]), 0)
		Mobile.verifyElementAttributeValue(findTestObject('iOS/receiving/verification/receivingUpload_Button'),'enabled','false', 0)
		Mobile.verifyElementAttributeValue(findTestObject('iOS/receiving/verification/receiveTote_Button'),'enabled','true', 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/toteReceivedCount_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/deliveredDate_Label'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/toteId_Label'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/productReceivedStatus_Label'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/issueSubmission/issue_Button'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/ndc_Label'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/productIssue_Button'), 0)
	}


	/**
	 * this method verifies the invoices detail
	 */
	@Keyword
	def verifyInvoicesListScreenDetails() {

		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/receivingTitle_Label'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/receivedTote_Label'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/toteCountLabel'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/totes_Count'), 0)
	}



	/**
	 * verifies details related to submission of issue and takes shipment number, tote id as the arguments
	 * @param toteID
	 */
	@Keyword
	def verifyIssueSubmissionDetails(toteID) {

		Mobile.verifyElementExist(findTestObject('iOS/receiving/issueSubmission/serviceRequest_Header'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/issueSubmission/toteIssue_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/issueSubmission/toteID_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/issueSubmission/parametrizedToteID_Text',[('TEXT'):toteID]), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/issueSubmission/account_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/issueSubmission/reasonForIssue_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/issueSubmission/cancelIssueSubmission_Text'), 0)
	}



	/**
	 * verifies if no new orders to be received
	 */
	@Keyword
	def verifyNoNewOrdersToReceive() {

		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/noNewOrdersToReceiveToday_Text'), 0)
	}


	/**
	 * verifies pop up to allow over-age
	 */
	@Keyword
	def verifyOveragePopUp() {

		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/allowOveragePopUp_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/youAreAboutToInputAnOverageWouldYouLikeToContinue_Text'), 0)
		Mobile.tap(findTestObject('iOS/receiving/verification/allowOveragePopUp_Button'), 0)
	}



	/**
	 * verifies over-age tag is visible after inputting receiving count which is more than the max upper limit
	 */
	@Keyword
	def verifyOverAgeTag() {

		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/overage_Tag'), 0)
	}



	/**
	 * this function verifies that the product is visible on the order details screen
	 * @param productNdcNumber (using NDC of the product which is visible on the product tab)
	 * if in future upc/cin are visible then the method can be modified accordingly by passing the respective test object
	 */
	@Keyword
	def verifyProductIsVisibleOnTheReceivingScreen(productNdcNumber) {

		String testObj='Object Repository/iOS/receiving/verification/parametrizedNdc_Label'
		iosCommonKeywordsObject.verifyProductIsVisibleOnTheScreen(testObj,productNdcNumber)//calling verifyProductIsVisibleOnTheScreen function and passing testObj, topProductIdentificationNumber as the arguments

	}



	/**
	 * verifies details of the product associated with the account
	 * @param productNdcNumber (using NDC of the product which is visible on the product tab)
	 */
	@Keyword
	def verifyProductSearchDetails(productNdcNumber) {

		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/parametrizedNdc_Label',[('TEXT'):productNdcNumber]), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/searchResult_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/toteID_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/toteNumber_Label'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/shipment_Label'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/shipmentNumber_Label'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/productIssue_Button'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/receivedProduct_Label'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/receivingeader_Label'), 0)
	}



	/**
	 * takes expected received product count and maxReceivingProductCountWithoutOverage as the argument
	 * and verifies that it should be as expected for invoice screen
	 * @param expectedReceivedProductCount (expected received product count)
	 * @param maxReceivingProductCountWithoutOverage (maxReceiving product count without over-age)
	 */
	@Keyword
	def verifyReceivedProductCountUnderInvoice(expectedReceivedProductCount,maxReceivingProductCountWithoutOverage) {

		maxReceivingProductCountWithoutOverage.toString()
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/parametrizedInvoiceItemReceivedStatus_Label',[('TEXT_1'):expectedReceivedProductCount, ,('TEXT_2'):maxReceivingProductCountWithoutOverage]), 0)
	}



	/**
	 * takes expected received product count and maxReceivingProductCountWithoutOverage as the argument
	 * and verifies that it should be as expected for shipments screen
	 * @param expectedReceivedProductCount (expected received product count)
	 * @param maxReceivingProductCountWithoutOverage (maxReceiving product count without over-age)
	 */
	@Keyword
	def verifyReceivedProductCountUnderShipments(expectedReceivedProductCount,maxReceivingProductCountWithoutOverage) {

		maxReceivingProductCountWithoutOverage.toString()
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/parametrizedShipmentItemReceivedStatus_Label',[('TEXT_1'):expectedReceivedProductCount, ,('TEXT_2'):maxReceivingProductCountWithoutOverage]), 0)
	}



	/**
	 * verifies received tag is visible after inputting receiving count which is less or equal to the max upper limit
	 */
	@Keyword
	def verifyReceivedTag() {

		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/received_Tag'), 0)
	}



	/**
	 * this function verifies the receiving screen details
	 */
	@Keyword
	def verifyReceivingScreen() {

		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/receivingeader_Label'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/product_SearchField'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/scan_Icon'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/receivingScreenViewBy_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/incompleteRecevingView_Button'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/receivingScreenAllowOverages_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/receivingAllowOverage_Button'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/noNewOrdersToReceiveToday_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/today_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/switchToPreviousDay_Button'), 0)
	}



	/**
	 * verifies the receiving screen pop-up which comes after user goes to receiving tab details
	 */
	@Keyword
	def verifyReceivingScreenPopUp() {

		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/welcomeToReceiving_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/viewBy_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/allowOverages_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/shipments_Button'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/allowOverage_Button'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/invoices_Button'), 0)
	}




	/**
	 * verifies shipment details
	 * @param shipmentNumber (shipment number)
	 */
	@Keyword
	def verifyShipmentDetails(shipmentNumber) {

		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/parametrizedShipment_Label',[('TEXT'):shipmentNumber]), 0)
		Mobile.verifyElementAttributeValue(findTestObject('iOS/receiving/verification/receivingUpload_Button'),'enabled','false', 0)
		Mobile.verifyElementAttributeValue(findTestObject('iOS/receiving/verification/receiveTote_Button'),'enabled','true', 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/toteReceivedCount_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/deliveredDate_Label'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/toteId_Label'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/productReceivedStatus_Label'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/issueSubmission/issue_Button'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/ndc_Label'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/productIssue_Button'), 0)
	}



	/**
	 * this function verifies the shipment is visible on the screen
	 * @param shipmentNumber (shipment number)
	 */
	@Keyword
	def verifyShipmentIsVisible(shipmentNumber) {

		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/shipment_Tile',[('TEXT'):shipmentNumber]), 0)
	}



	/**
	 * verify shipment number visible while submission of issue
	 */
	@Keyword
	def verifyShipmentNumberInIssue(shipmentNumber) {

		Mobile.verifyElementExist(findTestObject('iOS/receiving/issueSubmission/shipmentNumber_Text'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/issueSubmission/parametrizedshipmentNumber_Text',[('TEXT'):shipmentNumber]), 0)
	}



	/**
	 * this function verifies the shipments detail
	 */
	@Keyword
	def verifyShipmentsListScreenDetails() {

		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/receivingTitle_Label'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/receivedTote_Label'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/toteCountLabel'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/totes_Count'), 0)
	}


	/**
	 * verify submission of issue pop-up
	 */
	@Keyword
	def verifySubmissionOfIssue() {

		iosCommonKeywordsObject.waitForProgressBarToBeInvisible()

		if (Mobile.verifyElementExist(findTestObject('iOS/receiving/issueSubmission/serviceRequestSubmitted_Text'), 5,FailureHandling.OPTIONAL)) {
			Mobile.verifyElementExist(findTestObject('iOS/receiving/issueSubmission/serviceRequestSubmitted_Text'), 0)
			Mobile.verifyElementExist(findTestObject('iOS/receiving/issueSubmission/aCardinalHealthRepresentativeWillContactYouWithin24HoursToAssistYouWithYourRequest_Text'),0)
			clickOnGotItbutton()
		}

		else {

			Mobile.verifyElementExist(findTestObject('iOS/receiving/issueSubmission/yourServiceRequestWasNotAbleToBeSentPleaseTryAgain_Text'),0)
			Mobile.verifyElementExist(findTestObject('iOS/receiving/issueSubmission/serviceRequestNotSent_Text'), 0)
			Mobile.tap(findTestObject('iOS/receiving/issueSubmission/ok_Button'), 0)
			Mobile.tap(findTestObject('iOS/receiving/issueSubmission/cancelIssueSubmission_Text'), 0)
		}
	}


	/**
	 * verifies the pop up after uploading_totes
	 */
	@Keyword
	def verifyUploadTotesPopUp() {

		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/uploadingToteComplete_Label'), 0)
		Mobile.verifyElementExist(findTestObject('iOS/receiving/verification/allTotesUploaded_Text'), 0)
	}
}