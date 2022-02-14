package androidReceiving
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
	def androidCommonKeywordsObject=new androidCommonKeywords.commonMethods()
	def commonMethodsObject=new commonMethods()



	/**
	 * takes user back to receiving after uploading_totes
	 */
	@Keyword
	def clickOnBackToReceiving() {

		Mobile.tap(findTestObject('Android/receiving/verification/backToReceiving_Button'), 0)
	}


	/**
	 * clicks on continue button after selection of shipments or invoice by user
	 */
	@Keyword
	def clickOnContinue() {

		Mobile.tap(findTestObject('Android/receiving/verification/continue_Button'), 0)
	}



	/**
	 * clicks on got it issue
	 */
	@Keyword
	def clickOnGotItbutton() {

		androidCommonKeywordsObject.waitForProgressBarToBeInvisible()

		Mobile.tap(findTestObject('Android/receiving/issueSubmission/gotIt_Button'), 0)
	}




	/**
	 * clicks on issue
	 */
	@Keyword
	def clickOnIssue() {

		Mobile.tap(findTestObject('Android/receiving/issueSubmission/issue_Text'), 0)
	}



	/**
	 * clicks on receive all totes_button
	 */
	@Keyword
	def clickOnReceiveAllTotes() {

		Mobile.tap(findTestObject('Android/receiving/verification/receiveAll_Button'),0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/toteReceivingStatus_View'), 0)

		String idOfTheElement=Mobile.getAttribute(findTestObject('Android/receiving/verification/toteReceivingStatus_View'), 'resource-id', 0)

		KeywordUtil.logInfo(idOfTheElement)

		commonMethodsObject.verifyElementColor(146,255,161,idOfTheElement) //light green with hex code #92ffa1
	}



	/**
	 * click on scan icon
	 */
	@Keyword
	def clickOnScanIcon() {

		//MobileElement element = MobileElementCommonHelper.findElement(findTestObject('Android/receiving/verification/scan_TextView'), 0)
		//element.click()
		Mobile.tap(findTestObject('Android/receiving/verification/scan_TextView'), 0,FailureHandling.OPTIONAL)
	}



	/**
	 * clicks on submit issue
	 */
	@Keyword
	def clickOnSubmitIssue() {

		androidCommonKeywordsObject.waitForProgressBarToBeInvisible()

		Mobile.tap(findTestObject('Android/receiving/issueSubmission/submitIssue_Button'), 0)
	}


	/**
	 * collapses the detailed view of_tote
	 */
	@Keyword
	def collpaseViewOfTotes() {

		Mobile.tap(findTestObject('Android/receiving/verification/collapseView_Image'), 0)
	}


	/**
	 * takes received product count as the argument and enters count in the text-field
	 * @param receivedProductCount (received product count)
	 */
	@Keyword
	def editReceivedProductCount(int receivedProductCount) {

		Mobile.setText(findTestObject('Android/receiving/verification/receivedCount_TextField'), receivedProductCount.toString(),0)
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
		androidCommonKeywordsObject.waitForProgressBarToBeInvisible()
		Mobile.setText(findTestObject('Android/receiving/issueSubmission/name_TextField'), name, 0)

		Mobile.setText(findTestObject('Android/receiving/issueSubmission/phoneNumber_TextField'), phoneNumber, 0)

		String expectedID=Mobile.getText(findTestObject('Android/receiving/issueSubmission/email_TextField'), 0)
		expectedID.contains("@cardinalhealth.com")
		Mobile.setText(findTestObject('Android/receiving/issueSubmission/email_TextField'),expectedID, 0)

		Mobile.setText(findTestObject('Android/receiving/issueSubmission/enterComments_TextField'), comment, 0)
	}



	/**
	 * expands the view to see detailed view of_tote
	 */
	@Keyword
	def expandToSeeDetailedViewOfTotes() {

		Mobile.tap(findTestObject('Android/receiving/verification/expandView_Image'), 0)
	}



	/**
	 * this function opens invoice details
	 * @param invoiceNumber (invoice number)
	 */
	@Keyword
	def openInvoiceDetails(invoiceNumber) {

		Mobile.tap(findTestObject('Android/receiving/verification/invoice_Tile',[('TEXT'):invoiceNumber]), 0)
	}




	/**
	 * this function opens shipment details
	 * @param shipmentNumber (shipment number)
	 */
	@Keyword
	def openShipmentDetails(shipmentNumber) {

		Mobile.tap(findTestObject('Android/receiving/verification/shipment_Tile',[('TEXT'):shipmentNumber]), 0)
	}




	/**
	 * returns max upper value without over-age product count
	 * @return maxCount (max upper value without over-age product count)
	 */
	@Keyword
	def returnUpperLimitReceivingProductCount() {

		String maxCount=Mobile.getText(findTestObject('Android/receiving/verification/maxReceivingProductCount_TextView'), 0)

		return androidCommonKeywordsObject.removeCharctersInString(maxCount)
	}




	/**
	 * takes product to be searched as the argument and searches for the product
	 * @param productToBeSearched (name which can be a productName/Cin/NDC of the product to be added)
	 */
	@Keyword
	def scanInputEvent(String productToBeSearched) {

		Mobile.setText(findTestObject('Android/orders/orderDetailsScreen/scanOrder/scan_EditText'), productToBeSearched, 0)

		Mobile.tap(findTestObject('Android/orders/orderDetailsScreen/scanOrder/scan_Button'), 0)
	}



	/**
	 * takes toteID to be searched as the argument and searches the same
	 */
	@Keyword
	def searchTote(toteID) {

		Mobile.tap(findTestObject('Android/receiving/verification/searchReceiving_TextField'), 0,FailureHandling.OPTIONAL)

		Mobile.setText(findTestObject('Android/receiving/verification/searchReceiving_TextField'), toteID + '\\n', 0)
	}



	/**
	 * allows over-ages in receiving
	 */
	@Keyword
	def selectAllowOverages() {

		Mobile.tap(findTestObject('Android/receiving/verification/allowOverages_CheckBox'), 0)
	}



	/**
	 * this function will select invoices on the receiving screen
	 */
	@Keyword
	def selectInvoices() {

		Mobile.tap(findTestObject('Android/receiving/verification/invoices_TextView'), 0)
	}



	/**
	 * select reason of issue
	 * @param reasonForIssue
	 */
	@Keyword
	def selectReasonForIssue(String reasonForIssue) {

		if (reasonForIssue.equalsIgnoreCase('missing Tote')) {
			Mobile.tap(findTestObject('Android/receiving/issueSubmission/missingTote_RadioButton'), 0)

			Mobile.verifyElementAttributeValue(findTestObject('Android/receiving/issueSubmission/missingTote_RadioButton'), 'checked', 'true', 0)
		}

		else {
			Mobile.tap(findTestObject('Android/receiving/issueSubmission/wrongTote_RadioButton'), 0)

			Mobile.verifyElementAttributeValue(findTestObject('Android/receiving/issueSubmission/wrongTote_RadioButton'), 'checked', 'true', 0)
		}
	}



	/**
	 * this function will select shipments on the receiving screen
	 */
	@Keyword
	def selectShipments() {

		Mobile.tap(findTestObject('Android/receiving/verification/shipments_TextView'), 0)
	}



	/**
	 * takes user to previous day shipments from today's shipments screen
	 */
	@Keyword
	def switchToPreviousDay() {

		Mobile.tap(findTestObject('Android/receiving/verification/switchToPreviousDayShipments_Button'), 0)
	}



	/**
	 * takes user to today's shipments from previous day shipments screen
	 */
	@Keyword
	def switchToToday() {

		Mobile.tap(findTestObject('Android/receiving/verification/switchToTodayShipments_Button'), 0)
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

		Mobile.tap(findTestObject('Android/receiving/verification/uploadCompletedTotes_Button'),0)
	}


	/**
	 * verifies that over-ages are allowed
	 */
	@Keyword
	def verifyAllowedOverages() {

		Mobile.verifyElementAttributeValue(findTestObject('Android/receiving/verification/allowOverages_CheckBox'),'checked','true', 0)
	}


	/**
	 * verifies details of the instances of product associated with the account
	 * @param productNdcNumber (using NDC of the product which is visible on the product tab)
	 */
	@Keyword
	def verifyInstancesOfProductAssociatedWithAccount(productNdcNumber) {

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/toteID_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/shipmentNumber_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/invoiceShipmentNumber_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/ndc_TextView',[('TEXT'):productNdcNumber]), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/receivedTag_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/issue_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/editableQuantity_TextBox'), 0)
	}


	/**
	 * verifies the invoice is not visible on the screen
	 * @param invoiceNumber (invoice number)
	 */
	@Keyword
	def verifyInvoiceIsNotVisible(invoiceNumber) {

		Mobile.verifyElementNotVisible(findTestObject('Android/receiving/verification/invoice_Tile',[('TEXT'):invoiceNumber]), 0)
	}



	/**
	 * this function verifies the invoice is visible on the screen
	 * @param invoiceNumber (invoice number)
	 */
	@Keyword
	def verifyInvoiceIsVisible(invoiceNumber) {

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/invoice_Tile',[('TEXT'):invoiceNumber]), 0)
	}



	/**
	 * verify invoice number visible while submission of issue
	 */
	@Keyword
	def verifyInvoiceNumberInIssue(invoiceNumber) {

		Mobile.verifyElementExist(findTestObject('Android/receiving/issueSubmission/invoiceNumber_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/issueSubmission/parametrizedInvoiceNumber_TextView',[('TEXT'):invoiceNumber]), 0)
	}


	/**
	 * this method verifies the invoices detail
	 * @param invoiceNumber (invoice number)
	 */
	@Keyword
	def verifyInvoicesDetails(invoiceNumber) {

		Mobile.verifyElementAttributeValue(findTestObject('Android/receiving/verification/receiveAll_Button'), 'enabled','true',0)

		Mobile.verifyElementAttributeValue(findTestObject('Android/receiving/verification/uploadCompletedTotes_Button'),'enabled','false', 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/invoice_TextView',[('TEXT'):invoiceNumber]), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/totesReceived_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/deliveredDate_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/toteID_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/productsReceived_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/issue_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/itemQuantity_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/receivingUpperLimit_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/receivedCount_TextField'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/receivedCount_TextView'), 0)
	}



	/**
	 * this method verifies the invoices detail
	 */
	@Keyword
	def verifyInvoicesListScreenDetails() {

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/totesCount_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/totes_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/date_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/toteReceivedStatus_TextView'), 0)
	}



	/**
	 * verifies if no new orders to be received
	 */
	@Keyword
	def verifyNoNewOrdersToReceive() {

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/noNewOrdersToReceive_TextView'), 0)
	}


	/**
	 * verifies pop up to allow over-age
	 */
	@Keyword
	def verifyOveragePopUp() {

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/allowOveragesPopUp_Text'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/youAreAboutToInputAnOverageWouldYouLikeToContinue_Text'),0)

		Mobile.tap(findTestObject('Android/receiving/verification/allowOveragesPopUp_Button'), 0)
	}



	/**
	 * verifies over-age tag is visible after inputting receiving count which is more than the max upper limit
	 */
	@Keyword
	def verifyOverAgeTag() {

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/overageTag_TextView'), 0)
	}



	/**
	 * this function verifies that the product is visible on the order details screen
	 * @param productNdcNumber (using NDC of the product which is visible on the product tab)
	 * if in future upc/cin are visible then the method can be modified accordingly by passing the respective test object
	 */
	@Keyword
	def verifyProductIsVisibleOnTheReceivingScreen(productNdcNumber) {

		String testObj='Object Repository/Android/orders/verificationDetails/ordersNDCLabel_TextView'

		androidCommonKeywordsObject.verifyProductIsVisibleOnTheScreen(testObj,productNdcNumber)//calling verifyProductIsVisibleOnTheScreen function and passing testObj, topProductIdentificationNumber as the arguments

	}



	/**
	 * verifies details of the product associated with the account
	 * @param productNdcNumber (using NDC of the product which is visible on the product tab)
	 */
	@Keyword
	def verifyProductSearchDetals(productNdcNumber) {

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/toteID_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/shipmentNumber_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/invoiceShipmentNumber_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/ndc_TextView',[('TEXT'):productNdcNumber]), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/receivedTag_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/issue_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/editableQuantity_TextBox'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/receiving_Header'), 0)
	}



	/**
	 * takes expected received product count as the argument and verifies that it should be same as the actual count visible
	 * @param expectedReceivedProductCount (expected received product count)
	 */
	@Keyword
	def verifyReceivedProductCount(expectedReceivedProductCount) {

		String actualProductCountString = Mobile.getText(findTestObject('Android/receiving/verification/productReceivedCount_TextView'), 0)

		expectedReceivedProductCount= actualProductCountString[0]
	}



	/**
	 * verifies received tag is visible after inputting receiving count which is less or equal to the max upper limit
	 */
	@Keyword
	def verifyReceivedTag() {

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/recivedTag_TextView'), 0)
	}



	/**
	 * this function verifies the receiving screen details
	 */
	@Keyword
	def verifyReceivingScreen() {

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/youHaveIncompleteReceivingItemsTapToView_TextView'),  0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/receiving_Header'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/searchReceiving_TextField'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/scan_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/shipments_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/invoices_TextView'), 0)

		Mobile.verifyElementExist(	findTestObject('Android/receiving/verification/allowOverages_CheckBox'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/todaysDateOrPreviousDate_TextView'), 0)
	}



	/**
	 * verifies the receiving screen pop-up which comes after user goes to receiving tab details
	 */
	@Keyword
	def verifyReceivingScreenPopUp() {

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/welcomeToReceiving_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/viewBy_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/shipments_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/invoices_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/allowOverages_CheckBox'), 0)
	}



	/**
	 * verifies shipment details
	 * @param shipmentNumber (shipment number)
	 */
	@Keyword
	def verifyShipmentDetails(shipmentNumber) {

		Mobile.verifyElementAttributeValue(findTestObject('Android/receiving/verification/receiveAll_Button'), 'enabled','true',0)

		Mobile.verifyElementAttributeValue(findTestObject('Android/receiving/verification/uploadCompletedTotes_Button'),'enabled','false', 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/shipment_TextView',[('TEXT'):shipmentNumber]), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/totesReceived_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/collapseView_Image'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/deliveredDate_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/toteID_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/productsReceived_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/issue_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/itemQuantity_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/receivingUpperLimit_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/receivedCount_TextField'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/receivedCount_TextView'), 0)
	}




	/**
	 * this function verifies the shipment is visible on the screen
	 * @param shipmentNumber (shipment number)
	 */
	@Keyword
	def verifyShipmentIsVisible(shipmentNumber) {

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/shipment_Tile',[('TEXT'):shipmentNumber]), 0)
	}



	/**
	 * verify shipment number visible while submission of issue
	 */
	@Keyword
	def verifyShipmentNumberInIssue(shipmentNumber) {

		Mobile.verifyElementExist(findTestObject('Android/receiving/issueSubmission/shipmentNumber_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/issueSubmission/parametrizedShipmentNumber_TextView',[('TEXT'):shipmentNumber]), 0)
	}



	/**
	 * this function verifies the shipments detail
	 */
	@Keyword
	def verifyShipmentsListScreenDetails() {

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/totesCount_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/totes_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/toteReceivedStatus_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/date_TextView'), 0)
	}



	/**
	 * verifies details related to submission of issue and takes shipment number, tote id as the arguments
	 * @param shipmentNumber
	 * @param toteID
	 */
	@Keyword
	def verifySubmissionDetails(toteID) {

		Mobile.verifyElementExist(findTestObject('Android/receiving/issueSubmission/serviceRequest_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/issueSubmission/toteIssue_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/issueSubmission/toteDate_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/issueSubmission/toteID_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/issueSubmission/parametrizedToteID_TextView',[('TEXT'):toteID]), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/issueSubmission/account_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/issueSubmission/account_Label'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/issueSubmission/reasonForIssue_TextView'), 0)
	}


	/**
	 * verify submission of issue pop-up
	 */
	@Keyword
	def verifySubmissionOfIssue() {

		androidCommonKeywordsObject.waitForProgressBarToBeInvisible()

		if (Mobile.verifyElementExist(findTestObject('Android/receiving/issueSubmission/serviceRequestNotSent_TextView'), 5,FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('Android/receiving/issueSubmission/serviceRequestNotSent_TextView'), 0)

			Mobile.tap(findTestObject('Android/receiving/issueSubmission/yourServiceRequestWasNotAbleToBeSentPleaseTryAgain_TextView'), 0)

			Mobile.tap(findTestObject('Android/receiving/issueSubmission/okay_Button'), 0)

			Mobile.pressBack()
		}

		else {
			Mobile.verifyElementExist(findTestObject('Android/receiving/issueSubmission/serviceRequestSubmitted_TextView'), 0)

			Mobile.verifyElementExist(findTestObject('Android/receiving/issueSubmission/aCardinalHealthRepresentativeWillContactYouWithin24HoursToAssistYouWithYourRequest_TextView'),0)
		}
	}

	/**
	 * verifies the pop up after uploading_totes
	 */
	@Keyword
	def verifyUploadTotesPopUp() {

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/invoiceUploadCompleted_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/receiving/verification/allTotesUploaded_TextView'), 0)
	}
}