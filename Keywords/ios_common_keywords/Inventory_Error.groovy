package ios_common_keywords

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

import internal.GlobalVariable

class  Inventory_Error {

	@Keyword(keywordObject="common_keywords")
	def Custom() {


		while (Mobile.verifyElementExist(findTestObject('iOS/Verification/We were not able to search products. Please try again_Text'),2, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('iOS/Verification/OK_Button'), 0,0)
		}


		while (Mobile.verifyElementExist(findTestObject('iOS/Verification/We were not able to capture your Inventory. Please try again_Text'),2, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('iOS/Verification/Try Again_Button'), 0,FailureHandling.OPTIONAL)
		}
		while (Mobile.verifyElementExist(findTestObject('iOS/Verification/Something went wrong_Text'),2, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('iOS/Verification/Okay_Button'), 0,FailureHandling.OPTIONAL)
			Mobile.tap(findTestObject('iOS/Verification/Try Again_Button'), 0,FailureHandling.OPTIONAL)
		}

		while (Mobile.verifyElementExist(findTestObject('iOS/Product_Search/Back_ImageView'),2, FailureHandling.OPTIONAL)) {
			Mobile.tap(findTestObject('iOS/Product_Search/Back_ImageView'), 0)
		}
	}
}
