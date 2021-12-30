package androidReceiving
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

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
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.core.configuration.RunConfiguration

import groovy.json.JsonOutput as JsonOutput
import groovy.json.JsonSlurper as JsonSlurper
import java.io.File
import java.math.RoundingMode
import java.text.DecimalFormat


class receivingReusableMethods {

	/**
	 * clicks on continue button after selection of shipments or invoice by user
	 */
	@Keyword
	def clickOnContinue() {

		Mobile.tap(findTestObject('Object Repository/Android/Receiving/continue_Button'), 0)
	}



	/**
	 * click on scan icon
	 */
	@Keyword
	def clickOnScanIcon() {

		//MobileElement element = MobileElementCommonHelper.findElement(findTestObject('Object Repository/Android/Receiving/scan_TextView'), 0)
		//element.click()
		Mobile.tap(findTestObject('Object Repository/Android/Receiving/scan_TextView'), 0,FailureHandling.OPTIONAL)
	}


	/**
	 * this function opens shipment details
	 * @param shipmentNumber (shipment number)
	 */
	@Keyword
	def openShipmentDetails(shipmentNumber) {

		Mobile.tap(findTestObject('Object Repository/Android/Receiving/shipment_Tile',[('TEXT'):shipmentNumber]), 0)
	}



	/**
	 * this function opens invoice details
	 * @param invoiceNumber (invoice number)
	 */
	@Keyword
	def openInvoiceDetails(invoiceNumber) {

		Mobile.tap(findTestObject('Android/Receiving/invoice_Tile',[('TEXT'):invoiceNumber]), 0)
	}




	/**
	 * takes product to be searched as the argument and searches for the product
	 * @param productToBeSearched (name which can be a productName/Cin/NDC of the product to be added)
	 */
	@Keyword
	def scanInputEvent(String productToBeSearched) {

		Mobile.setText(findTestObject('Android/Orders/Order Details Screen/Scan Order/scan_EditText'), productToBeSearched, 0)

		Mobile.tap(findTestObject('Android/Orders/Order Details Screen/Scan Order/scan_Button'), 0)
	}



	/**
	 * allows over-ages in receiving
	 */
	@Keyword
	def selectAllowOverages() {

		Mobile.tap(findTestObject('Object Repository/Android/Receiving/allowOverages_CheckBox'), 0)
	}



	/**
	 * this function will select invoices on the receiving screen
	 */
	@Keyword
	def selectInvoices() {

		Mobile.tap(findTestObject('Object Repository/Android/Receiving/invoices_TextView'), 0)
	}



	/**
	 * this function will select shipments on the receiving screen
	 */
	@Keyword
	def selectShipments() {

		Mobile.tap(findTestObject('Object Repository/Android/Receiving/shipments_TextView'), 0)
	}


	/**
	 * takes user to previous day shipments from today's shipments screen
	 */
	@Keyword
	def switchToPreviousDay() {

		Mobile.tap(findTestObject('Object Repository/Android/Receiving/switchToPreviousDayShipments_Button'), 0)
	}


	/**
	 * takes user to today's shipments from previous day shipments screen
	 */
	@Keyword
	def switchToToday() {

		Mobile.tap(findTestObject('Object Repository/Android/Receiving/switchToTodayShipments_Button'), 0)
	}



	/**
	 * verifies that over-ages are allowed
	 */
	@Keyword
	def verifyAllowedOverages() {

		Mobile.verifyElementAttributeValue(findTestObject('Object Repository/Android/Receiving/allowOverages_CheckBox'),'checked','true', 0)
	}



	/**
	 * verifies details of the instances of product associated with the account
	 * @param productNdcNumber (using NDC of the product which is visible on the product tab)
	 */
	@Keyword
	def verifyInstancesOfProductAssociatedWithAccount(productNdcNumber) {

		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Receiving/toteID_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Receiving/shipmentNumber_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Receiving/invoiceShipmentNumber_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Receiving/ndc_TextView',[('TEXT'):productNdcNumber]), 0)

		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Receiving/receiving_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Receiving/issue_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Receiving/editableQuantity_TextBox'), 0)
	}



	/**
	 * this function verifies the invoice is visible on the screen
	 * @param invoiceNumber (invoice number)
	 */
	@Keyword
	def verifyInvoiceIsVisible(invoiceNumber) {

		Mobile.verifyElementExist(findTestObject('Android/Receiving/invoice_Tile',[('TEXT'):invoiceNumber]), 0)
	}




	/**
	 * this method verifies the invoices detail
	 */
	@Keyword
	def verifyInvoicesListScreenDetails() {

		Mobile.verifyElementExist(findTestObject('Android/Receiving/totesCount_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Receiving/totes_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Receiving/date_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Receiving/toteReceivedStatus_TextView'), 0)
	}




	/**
	 * this method verifies the invoices detail
	 * @param invoiceNumber (invoice number)
	 */
	@Keyword
	def verifyInvoicesDetails(invoiceNumber) {

		Mobile.verifyElementAttributeValue(findTestObject('Android/Receiving/receiveAll_Button'), 'enabled','true',0)

		Mobile.verifyElementAttributeValue(findTestObject('Android/Receiving/uploadCompletedTotes_Button'),'enabled','false', 0)

		Mobile.verifyElementExist(findTestObject('Android/Receiving/invoice_TextView',[('TEXT'):invoiceNumber]), 0)

		Mobile.verifyElementExist(findTestObject('Android/Receiving/totesReceived_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Receiving/deliveredDate_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Receiving/toteID_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Receiving/productsReceived_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Receiving/issue_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Receiving/itemQuantity_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Receiving/receivingUpperLimit_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Receiving/receivedCount_TextField'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Receiving/receivedCount_TextView'), 0)
	}




	/**
	 * verifies if no new orders to be received
	 */
	@Keyword
	def verifyNoNewOrdersToReceive() {

		Mobile.getText(findTestObject('Android/Receiving/noNewOrdersToReceive_TextView'), 0)
	}



	/**
	 * this function verifies the receiving screen details
	 */
	@Keyword
	def verifyReceivingScreen() {

		Mobile.verifyElementExist(findTestObject('Android/Receiving/youHaveIncompleteReceivingItemsTapToView_TextView'),  0)

		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Receiving/receiving_Header'), 0)

		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Receiving/searchReceiving_TextField'), 0)

		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Receiving/scan_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Receiving/shipments_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Receiving/invoices_TextView'), 0)

		Mobile.verifyElementExist(	findTestObject('Object Repository/Android/Receiving/allowOverages_CheckBox'), 0)

		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Receiving/todaysDateOrPreviousDate_TextView'), 0)
	}



	/**
	 * verifies the receiving screen pop-up which comes after user goes to receiving tab details
	 */
	@Keyword
	def verifyReceivingScreenPopUp() {

		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Receiving/welcomeToReceiving_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Receiving/viewBy_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Receiving/shipments_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Receiving/invoices_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Receiving/allowOverages_CheckBox'), 0)
	}



	/**
	 * verifies shipment details
	 * @param shipmentNumber (shipment number)
	 */
	@Keyword
	def verifyShipmentDetails(shipmentNumber) {

		Mobile.verifyElementAttributeValue(findTestObject('Android/Receiving/receiveAll_Button'), 'enabled','true',0)

		Mobile.verifyElementAttributeValue(findTestObject('Android/Receiving/uploadCompletedTotes_Button'),'enabled','false', 0)

		Mobile.verifyElementExist(findTestObject('Android/Receiving/shipment_TextView',[('TEXT'):shipmentNumber]), 0)

		Mobile.verifyElementExist(findTestObject('Android/Receiving/totesReceived_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Receiving/deliveredDate_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Receiving/toteID_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Receiving/productsReceived_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Receiving/issue_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Receiving/itemQuantity_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Receiving/receivingUpperLimit_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Receiving/receivedCount_TextField'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Receiving/receivedCount_TextView'), 0)
	}



	/**
	 * this function verifies the shipment is visible on the screen
	 * @param shipmentNumber (shipment number)
	 */
	@Keyword
	def verifyShipmentIsVisible(shipmentNumber) {

		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Receiving/shipment_Tile',[('TEXT'):shipmentNumber]), 0)
	}



	/**
	 * this function verifies the shipments detail
	 */
	@Keyword
	def verifyShipmentsListScreenDetails() {

		Mobile.verifyElementExist(findTestObject('Android/Receiving/totesCount_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Receiving/totes_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Android/Receiving/toteReceivedStatus_TextView'), 0)

		Mobile.verifyElementExist(findTestObject('Object Repository/Android/Receiving/date_TextView'), 0)
	}
}