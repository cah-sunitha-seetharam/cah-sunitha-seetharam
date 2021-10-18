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

class  wait_for_load {

	/**
	 * waits until the page loads
	 */
	@Keyword()
	def waitForPageLoad() {

		String testObject='iOS/Product_Search/Progress_Bar'
		(new ios_common_keywords.wait_for_load()).waitTimeProgressBar(testObject,1,20)
	}


	
	/**
	 * waits until the progressBar is there
	 * @param testObj,waitTime,waitLimit
	 */
	@Keyword()
	def waitTimeProgressBar(testObj, int waitTime, int waitLimit) {

		int counter=0

		while (Mobile.verifyElementExist(findTestObject(testObj), waitTime, FailureHandling.OPTIONAL)) {
			WebUI.delay(waitTime)
			counter+=1
			assert counter<waitLimit
		}
	}
}