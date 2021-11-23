package iosCommonKeywords
import java.util.Stack
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

import internal.GlobalVariable

class  commonMethods {


	/**
	 * this method closes the popUp screen by tapping on close, cancel button
	 * @param testobj (reference of the close, cancel button)
	 */
	@Keyword
	def closePopUpScreen(testobj) {

		Mobile.tap(findTestObject(testobj), 0)
	}



	/**
	 * clicks on Search Key of the keypad
	 */
	@Keyword
	def clickOnSearchKey() {

		Mobile.tapAndHold(findTestObject('iOS/Product_Search/Search Key_Button'), 0, 0)
	}


	/**
	 * this method will take the application one screen back
	 */
	@Keyword
	def goOneScreenBack() {

		(new iosCommonKeywords.commonMethods()).waitForProgressBarToBeInvisible()

		if (Mobile.verifyElementExist(findTestObject('iOS/Product_Search/Back_Text'), 4,FailureHandling.OPTIONAL)) {

			Mobile.tap(findTestObject('iOS/Product_Search/Back_Text'), 4,FailureHandling.OPTIONAL)
		}
		else {
			Mobile.tap(findTestObject('iOS/Inventory/Location Details Screen/Add Product to Location/Back Button_Text'), 4)
		}

		(new iosCommonKeywords.commonMethods()).waitForProgressBarToBeInvisible()
	}



	/**
	 * installs as well as launches the application
	 */
	@Keyword
	def installingAndlaunchingTheApplication() {

		Mobile.startApplication(GlobalVariable.iOS_App_Path, true) //iOS_App_Path (Application path will be taken from the global profile and passed as a parameter to startApplication method)

	}




	/**
	 * performs basic text management operations
	 * @param operationToBePerformed (in operationToBePerformed argument all alphabets should be lower-case except the first one for e.g Copy, Cut)
	 */
	@Keyword
	def performBasicTextManagementOperation(String operationToBePerformed) {

		String textFieldTestObj='Object Repository/iOS/Inventory/Location Details Screen/Add Product to Location/productSearch_TextField'

		String selectTextTestObj='Object Repository/iOS/Verification/selectAll_MenuItem'

		String operationToBePerformedTestObject='Object Repository/iOS/Verification/textOperation_MenuItem'

		(new common.commonMethods()).performBasicTextManagementOperation(operationToBePerformed,textFieldTestObj,selectTextTestObj,operationToBePerformedTestObject)
	}



	/**
	 * generates the coordinate x for a test object by considering ElementLeftPosition and ElementWidth
	 * @param testObj (reference of the testObject passed as a parameter), text(name of the element)
	 * returns int value for the xCoordinate
	 */
	@Keyword
	def tapXCoordinateGenerator(String testObj) {

		int ElementLeftPosition=Mobile.getElementLeftPosition(findTestObject(testObj), 0)

		int ElementWidth=Mobile.getElementWidth(findTestObject(testObj), 0)

		int x_Coordinate=(ElementWidth/2)+ElementLeftPosition

		return x_Coordinate
	}




	/**
	 * generates the coordinate y for a test object by considering ElementTopPosition and ElementHeight
	 * @param testObj (reference of the testObject passed as a parameter), text(name of the element)
	 * returns int value for the yCoordinate
	 */
	@Keyword
	def tapYCoordinateGenerator(String testObj, String text) {

		int ElementTopPosition = Mobile.getElementTopPosition(findTestObject(testObj, [('TEXT') : text]), 0)

		int ElementHeight=Mobile.getElementHeight(findTestObject(testObj, [('TEXT') : text]), 0)

		int y_Coordinate=(ElementHeight/2)+ElementTopPosition

		return y_Coordinate
	}



	/**
	 * this function verifies that the product is not visible on the screen
	 * @param ndcNumber(ndcNumber of the product to be verified)
	 */
	@Keyword
	def verifyProductIsNotVisibleOnTheScreen(ndcNumber) {

		Mobile.verifyElementNotVisible(findTestObject('Object Repository/iOS/Product_Details/ndcNumber_Text',[('TEXT'):ndcNumber]),0)
	}





	/**
	 * this function verifies that the product is visible on the screen
	 * @param ndcNumber(ndcNumber of the product to be verified)
	 */
	@Keyword
	def verifyProductIsVisibleOnTheScreen(ndcNumber) {

		Mobile.verifyElementExist(findTestObject('Object Repository/iOS/Product_Details/ndcNumber_Text',[('TEXT'):ndcNumber]),0)
	}





	/**
	 * this method verifies the popUp screen is visible
	 * @param testobj (reference of the popUp screen object under verification)
	 */
	@Keyword
	def verifyPopUpScreenExist(testobj) {

		Mobile.verifyElementExist(findTestObject(testobj), 0)
	}


	/**
	 * refreshes the screen by doing a vertical swipe by considering the deviceHeight and deviceWidth
	 */
	@Keyword
	def verticalSwipeForRefresh() {

		float device_Height = Mobile.getDeviceHeight()

		float device_Width = Mobile.getDeviceWidth()

		int startX = device_Width / 2

		int endX = startX

		int startY = device_Height * 0.50

		int endY = device_Height * 0.80

		Mobile.swipe(startX, endY, endX, startY)
	}



	/**
	 * waits until the progressBar is visible on the screen, which will have a maximum waitLimit to be visible on the screen
	 */
	@Keyword
	def waitForProgressBarToBeInvisible() {

		String testObject='iOS/Product_Search/Progress_Bar'
		(new iosCommonKeywords.commonMethods()).waitTimeForObjectToBeVisible(testObject,1,20) //waitTime of 1(s), waitLimit of 20(s)
	}



	/**
	 * waits until the object is visible on the screen, which will have a maximum waitLimit to be visible on the screen
	 * @param testObj (reference of the test Object),waitTime (time by which delay will be added in(s)),waitLimit (maximum limit of time for which delay can be added)
	 */
	@Keyword
	def waitTimeForObjectToBeVisible(testObj, int waitTime, int waitLimit) {

		try {
			int counter=0 //initial count value set to be 0

			while (Mobile.verifyElementExist(findTestObject(testObj), waitTime, FailureHandling.OPTIONAL)) {
				WebUI.delay(waitTime)
				counter+=1 // count increases by 1 for each iteration
				assert counter<waitLimit
			}
		}
		catch(AssertionError e){
			KeywordUtil.logInfo("waitLimit of " + waitLimit + "(s) croosed and object is still visible on the screen!!!!! " +e.toString()); //logInfo if assertion fails
		}

	}
}
