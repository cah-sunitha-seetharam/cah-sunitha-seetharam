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
import com.kms.katalon.core.util.KeywordUtil

class  wait_for_load {

	/**
	 * waits until the page loads
	 */
	@Keyword()
	def waitForPageLoad() {

		String testObject='iOS/Product_Search/Progress_Bar'
		(new ios_common_keywords.wait_for_load()).waitTimeForObjectToBeVisible(testObject,1,20) //waitTime of 1(s), waitLimit of 20(s)
	}



	/**
	 * waits until the object is visible on the screen
	 * @param testObj (reference of the test Object),waitTime (time by which delay will be added in(s)),waitLimit (maximum limit of time for which delay can be added)
	 */
	@Keyword()
	def waitTimeForObjectToBeVisible(testObj, int waitTime, int waitLimit) {

		int counter=0 //initial count value set to be 0

		while (Mobile.verifyElementExist(findTestObject(testObj), waitTime, FailureHandling.OPTIONAL)) {
			WebUI.delay(waitTime)
			counter+=1 // count increases by 1 for each iteration
			if(counter==waitLimit)
				KeywordUtil.logInfo("waitLimt of "+ waitLimit +"(s) crossed and object is still visible") //logInfo
			assert counter<waitLimit
		}

	}
}