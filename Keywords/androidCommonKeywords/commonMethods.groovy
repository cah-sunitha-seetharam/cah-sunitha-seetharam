package androidCommonKeywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import androidAccountSelection.selectAnAccount
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
import io.appium.java_client.AppiumDriver
import io.appium.java_client.android.AndroidDriver
import androidDashboard.dashboardDetailsScreen
import androidLogin.loginScreen
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import androidMoreOptions.moreOptionsScreen

class  commonMethods {

	def dashboardObject=new dashboardDetailsScreen();
	def moreOptionsScreenObject=new moreOptionsScreen();
	def commonMethodsObject=new common.commonMethods()
	def loginScreenObject=new loginScreen();
	def selectAnAccountObject=new selectAnAccount();

	/**
	 * this method will take the application one screen back
	 */
	@Keyword()
	def goOneScreenBack() {

		Mobile.tap(findTestObject('Android/inventory/locationDetailsScreen/addProductToLocation/Back_TextView'), 0)
	}


	/**
	 * reads value from the global boolean variable: isAndroidAppInstalled
	 * and if it is set to true, launches already installed application else installs and launches the application
	 */
	@Keyword
	def installingAndlaunchingTheApplication() {


		if (GlobalVariable.isAndroidAppInstalled) {
			KeywordUtil.logInfo("application is already installed")
			Mobile.startExistingApplication(GlobalVariable.appPackage)
		}
		else {
			KeywordUtil.logInfo("need to install the application")
			RunConfiguration.setMobileDriverPreferencesProperty("appWaitActivity", GlobalVariable.appWaitActivity)   // relative reference of activity name to wait for while opening the app
			RunConfiguration.setMobileDriverPreferencesProperty("appPackage", GlobalVariable.appPackage) // this value will get from profile
			Mobile.startApplication(GlobalVariable.AndroidAppPath, true)
		}
	}


	/**
	 * @param stringCharcterToBeRemoved (Removes characters in a string)
	 */
	@Keyword
	def removeCharctersInString(String stringCharcterToBeRemoved) {
		stringCharcterToBeRemoved.replaceAll("[^0-9.]", "")
	}


	/**
	 * @param stringToBeConvertedToFloat (converts string to float)
	 */
	@Keyword
	def stringToFloatConversion(String stringToBeConvertedToFloat) {
		Float.parseFloat(stringToBeConvertedToFloat)
	}

	/**
	 * @param floatToBeConvertedToString (converts float to string and does formatting "0.00")
	 */
	@Keyword
	def floatToStringConversionAndFormatting(Float floatToBeConvertedToString) {
		String.format("%.02f", floatToBeConvertedToString)
	}

	/**
	 * this function returns the total expected value of the added product
	 * @return expectedOrderTotal (of the product which has been added)
	 */
	@Keyword
	def returnExpectedTotalValueForAddedProduct(quantity, costOfProduct) {
		float costOfProductFloatValue = (new androidCommonKeywords.commonMethods()).stringToFloatConversion(costOfProduct)
		float costOfAddedProduct=quantity*costOfProductFloatValue
		String expectedOrderTotal = (new androidCommonKeywords.commonMethods()).floatToStringConversionAndFormatting(costOfAddedProduct)
		return (expectedOrderTotal)
	}


	/**
	 * this function returns the cost of added product
	 * @return productCostCharcterRemoved (of the product which has been added)
	 */
	@Keyword
	def returnCostOfTheAddedProduct(String testObj) {
		String productCost= Mobile.getText(findTestObject(testObj), 0)
		KeywordUtil.logInfo(productCost)
		String productCostCharcterRemoved = (new androidCommonKeywords.commonMethods()).removeCharctersInString(productCost)
		return productCostCharcterRemoved
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

		String testObject='Android/login/loginDetailsScreen/progress_Bar'
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
	 * performs login function by selecting the type of testing (automation or manual), environment of testing(taken from the global profile), entering user-name and password
	 * and then selects the user account from the accounts list and takes user to the dash-board screen
	 * @param username
	 * @param password
	 * @param accountNo
	 */
	@Keyword
	def takeUserFromloginToHomeScreen(username,password,accountNo) {

		'login function called'
		loginScreenObject.login(username, password)

		'waits until the progressBar is visible on the screen'
		waitForProgressBarToBeInvisible()

		'selects the user account from the accounts list'
		selectAnAccountObject.selectTheUserAccount(accountNo)

		'waits until the progressBar is visible on the screen'
		waitForProgressBarToBeInvisible()
	}




	/**
	 * opens the inventory listing screen by firstly clicking on more options from dash-board
	 * and then clicks on inventory under more options screen which takes user to inventory listing screen
	 */
	@Keyword
	def takeUserFromHomeToInventoryListingScreen() {

		'takes user from dashboard to the moreOptions screen'
		dashboardObject.clickOnMoreOptionsTab()

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


	/**
	 * this function verifies that the product is visible on the screen
	 * @param productIdentificationNumber (productIdentificationNumber of the product which can be NDC/Cin/UPC, which should be present on the screen)
	 * @param testObj (test object of the element under verification)
	 */
	@Keyword
	def verifyProductIsVisibleOnTheScreen(testObj,productIdentificationNumber) {

		Mobile.verifyElementExist(findTestObject(testObj,[('TEXT'):productIdentificationNumber]),0)
	}


	/**
	 * this function verifies that the product is not visible on the screen
	 * @param productIdentificationNumber (productIdentificationNumber of the product which can be NDC/Cin/UPC, which should be present on the screen)
	 * @param testObj (test object of the element under verification)
	 */
	@Keyword
	def verifyProductIsNotVisibleOnTheScreen(testObj,productIdentificationNumber) {

		Mobile.verifyElementNotVisible(findTestObject(testObj,[('TEXT'):productIdentificationNumber]),0)
	}


	/**
	 * clicks on product search field
	 */
	@Keyword
	def clickOnProductSearchTextField() {

		Mobile.tapAndHold(findTestObject('Android/inventory/locationDetailsScreen/addProductToLocation/productSearch_TextField'), 0, 0)
	}

	/**
	 * inputs the product search which can be name/Cin/UPC/NDC in the product search-field
	 * @param productSearch (which can be name/Cin/UPC/NDC in the product search-field)
	 */
	@Keyword
	def enterProductInSearchField(productSearch) {

		Mobile.setText(findTestObject('Android/inventory/locationDetailsScreen/addProductToLocation/productSearch_TextField'), productSearch, 0)
	}


	/**
	 * performs basic text management operations:Copy,Cut,Paste,Share
	 * @param operationToBePerformed (in operationToBePerformed argument all alphabets should be lower-case except the first one for e.g Copy, Cut)
	 */
	@Keyword
	def performBasicTextManagementOperation(String operationToBePerformed) {

		Mobile.tapAndHold(findTestObject('Android/inventory/locationDetailsScreen/addProductToLocation/productSearch_TextField'), 0, 0)

		Mobile.tap(findTestObject('Object Repository/iOS/Verification/selectAll_MenuItem'), 5,FailureHandling.OPTIONAL)

		Mobile.tap(findTestObject('Object Repository/iOS/Verification/textOperation_MenuItem',[('TEXT'):operationToBePerformed]), 0)

		waitForProgressBarToBeInvisible()
	}



	/**
	 * takes product to be searched as the argument and searches the same
	 */
	@Keyword
	def searchProduct(productToBeSearched) {

		Mobile.tapAndHold(findTestObject('Android/inventory/locationDetailsScreen/addProductToLocation/productSearch_TextField'), 0, 0)

		Mobile.setText(findTestObject('Android/inventory/locationDetailsScreen/addProductToLocation/productSearch_TextField'), productToBeSearched + '\\n', 0)

	}
}
