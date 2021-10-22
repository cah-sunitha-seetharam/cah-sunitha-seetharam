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
import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable

class  commonMethods {

	/**
	 * this method will take the application one screen back
	 */
	@Keyword()
	def goOneScreenBack() {

		(new ios_common_keywords.wait_for_load()).waitForPageLoad()


		if (Mobile.verifyElementExist(findTestObject('iOS/Product_Search/Back_Text'), 4,FailureHandling.OPTIONAL)) {

			Mobile.tap(findTestObject('iOS/Product_Search/Back_Text'), 4,FailureHandling.OPTIONAL)
		}
		else {
			Mobile.tap(findTestObject('iOS/Inventory/Location Details_Screen/Add Product to Location/Back Button_Text'), 4)
		}

		(new ios_common_keywords.wait_for_load()).waitForPageLoad()
	}


	/**
	 * installs as well as launches the application
	 * @param Android_App_Path (Application path will be taken from the global profile and passed as a parameter to this method)
	 */
	@Keyword
	def installingAndlaunchingTheApplication() {

		Mobile.startApplication(GlobalVariable.iOS_App_Path, true)
	}




	/**
	 * float value generator
	 * @param stringToBeConvertedToFloatValue 
	 * returns float value for a string by removing characters
	 */
	@Keyword
	def floatValueGenerator(String stringToBeConvertedToFloatValue) {

		int counter=0

		while(stringToBeConvertedToFloatValue[counter]!='0' && stringToBeConvertedToFloatValue[counter]!='1' && stringToBeConvertedToFloatValue[counter]!='2' && stringToBeConvertedToFloatValue[counter]!='3' && stringToBeConvertedToFloatValue[counter]!='4' && stringToBeConvertedToFloatValue[counter]!='5' && stringToBeConvertedToFloatValue[counter]!='6' && stringToBeConvertedToFloatValue[counter]!='7' && stringToBeConvertedToFloatValue[counter]!='8' && stringToBeConvertedToFloatValue[counter]!='9' ) {
			counter++
		}

		String stringWithoutCharacters=stringToBeConvertedToFloatValue.substring(counter)

		float stringWithoutCharactersFloatValue=Float.parseFloat(stringWithoutCharacters)

		return stringWithoutCharactersFloatValue
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
	 * refreshes the screen by doing a vertical swipe after waiting for 30(s) to check the changed order status of C2 order by considering the deviceHeight and deviceWidth
	 */
	@Keyword
	def verticalSwipeForRefreshingC2OrderStatus() {

		WebUI.delay(30)

		(new ios_common_keywords.commonMethods()).verticalSwipeForRefresh() //waitTime of 1(s), waitLimit of 20(s)

	}



	/**
	 * waits until the progressBar is visible on the screen
	 */
	@Keyword()
	def waitForProgressBarToBeInvisible() {

		String testObject='iOS/Product_Search/Progress_Bar'
		(new ios_common_keywords.wait_for_load()).waitTimeForObjectToBeVisible(testObject,1,20) //waitTime of 1(s), waitLimit of 20(s)
	}



	/**
	 * waits until the object is visible on the screen
	 * @param testObj (reference of the test Object),waitTime (time by which delay will be added in(s)),waitLimit (maximum limit of time for which delay can be added)
	 */
	@Keyword()
	def waitTimeForObjectToBeVisible(testObj, int waitTime, int waitLimit) {

		try {
			int counter=0 //initial count value set to be 0

			while (Mobile.verifyElementExist(findTestObject(testObj), waitTime, FailureHandling.OPTIONAL)) {
				WebUI.delay(waitTime)
				counter+=1 // count increases by 1 for each iteration
				assert counter<waitLimit
			}
		}
		catch (Exception e) {
			KeywordUtil.markFailed("waitLimt of "+ waitLimit +"(s) crossed and object is still visible") //logInfo
		}

	}
}
