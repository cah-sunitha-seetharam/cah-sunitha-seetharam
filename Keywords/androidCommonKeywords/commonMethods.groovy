package androidCommonKeywords

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
import androidDashboard.dashboardDetailsScreen
import android_more_options.moreOptionsScreen

class  commonMethods {

	def dashboardObject=new dashboardDetailsScreen();
	def moreOptionsScreenObject=new moreOptionsScreen();


	/**
	 * this method will take the application one screen back
	 */
	@Keyword()
	def goOneScreenBack() {

		Mobile.tap(findTestObject('Android/Inventory/Location Details Screen/Add Product to_Location/Back_TextView'), 0)
	}


	/**
	 * installs as well as launches the application
	 */
	@Keyword
	def installingAndlaunchingTheApplication() {

		Mobile.startApplication(GlobalVariable.AndroidAppPath, true) //Android_App_Path (Application path will be taken from the global profile and passed as a parameter to this method)

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
	@Keyword()
	def waitForProgressBarToBeInvisible() {

		String testObject='Android/Login/Login Details Screen/Progress_Bar'
		(new androidCommonKeywords.commonMethods()).waitTimeForObjectToBeVisible(testObject,1,20) //waitTime of 1(s), waitLimit of 20(s)
	}




	/**
	 * waits until the object is visible on the screen, which will have a maximum waitLimit to be visible on the screen
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
		catch(AssertionError e){
			KeywordUtil.logInfo("waitLimit of " + waitLimit + "(s) croosed and object is still visible on the screen!!!!! " +e.toString()); //logInfo if assertion fails
		}

	}



	/**
	 * opens the inventory listing screen by firstly clicking on more options from dash-board
	 * and then clicks on inventory under more options screen which takes user to inventory listing screen
	 */
	@Keyword
	def takeUserFromHomeToInventoryListingScreen() {

		'takes user from dashboard to the moreOptions screen'
		dashboardObject.clickOnMoreOptionsTab()

		'waits until the progressBar is visible on the screen'
		waitForProgressBarToBeInvisible()

		'takes the user from moreOptions screen to the inventory listing screen'
		moreOptionsScreenObject.goToInventoryListingScreen()

		'waits until the progressBar is visible on the screen'
		waitForProgressBarToBeInvisible()
	}


	/**
	 * navigate to previous screen
	 * use this method whenever the back button is not available
	 */
	@Keyword
	def pressBacknav() {
		WebUI.delay(2)
		Mobile.pressBack()
	}

	
	/**
	 * generates the coordinate x for a test object by considering ElementLeftPosition and ElementWidth
	 * @param testObj (reference of the testObject passed as a parameter)
	 * @param text (name of the element)
	 * @return int value for the xCoordinate
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
	 * @param testObj (reference of the testObject passed as a parameter)
	 * @param text (name of the element)
	 * @return int value for the yCoordinate
	 */
	@Keyword
	def tapYCoordinateGenerator(String testObj, String text) {

		int ElementTopPosition = Mobile.getElementTopPosition(findTestObject(testObj, [('TEXT') : text]), 0)

		int ElementHeight=Mobile.getElementHeight(findTestObject(testObj, [('TEXT') : text]), 0)

		int y_Coordinate=(ElementHeight/2)+ElementTopPosition

		return y_Coordinate
	}

}
