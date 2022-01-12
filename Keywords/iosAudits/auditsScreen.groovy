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

import common.commonMethods

import internal.GlobalVariable

public class auditsScreen {
	
	def commonMethodsObject=new commonMethods();
	def commonIosMethodsObject=new iosCommonKeywords.commonMethods();

	/**
	 * this function verifies the audits landing Screen
	 */
	@Keyword
	def verifyAuditsLandingScreen() {

		Mobile.verifyElementExist(findTestObject('iOS/Audits/auditProgressMsg_Label'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Audits/auditScreen_Header'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/Audits/submitCompletedGroups_Button'), 0)
	}
	
	/*
	 * this function taps on quantity field in audits screen for a product listed
	 */
	@Keyword
	def clickOnFirstQuantityBox() {
		
		Mobile.tap(findTestObject('iOS/Audits/quantityBox_First'), 0)
		
		String idOfTheElement = Mobile.getAttribute(findTestObject('iOS/Audits/quantityBox_First'), 'resource-id', 0)
		
		// commonMethodsObject.verifyElementColor(105,170,115,idOfTheElement) //light green with hex code #69aa73 - emulator
		
		commonMethodsObject.verifyElementColor(146,255,161,idOfTheElement) //light green with hex code #92ffa1 - device
	}
	
}
	