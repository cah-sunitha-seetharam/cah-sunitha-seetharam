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
import iosAccountSelection.selectAnAccount
import iosDashboard.dashboardScreen
import iosInventory.locationDetailsScreen
import iosLogin.loginScreen
import iosMoreOptions.moreOptionsScreen
import iosOrders.cartScreen
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import java.math.RoundingMode;

class  commonMethods {

	def dashboardObject=new dashboardScreen();
	def moreOptionsScreenObject=new moreOptionsScreen();
	def loginScreenObject=new loginScreen();



	/**
	 * changes the user account
	 * @param newAccount
	 */
	@Keyword
	def changeAccount(String newAccount) {

		Mobile.tap(findTestObject('iOS/accountSelection/changeAccount_Text'), 0)

		Mobile.tap(findTestObject('iOS/accountSelection/changeAccount_Navigation'), 0)

		Mobile.scrollToText(newAccount, FailureHandling.STOP_ON_FAILURE)

		Mobile.tap(findTestObject('iOS/accountSelection/AccountNo_Text', [('val') : newAccount]), 0)
	}


	/**
	 * clicks on product search field
	 */
	@Keyword
	def clickOnProductSearchTextField() {

		Mobile.tapAndHold(findTestObject('iOS/inventory/locationDetailsScreen/addProductToLocation/productSearch_TextField'), 0, 0)
	}


	/**
	 * clicks on Search Key of the keypad
	 */
	@Keyword
	def clickOnSearchKey() {

		Mobile.tapAndHold(findTestObject('iOS/productSearch/globalSearch/search_Keypad'), 0, 0)
	}



	/**
	 * this method closes the popUp screen by tapping on close, cancel button
	 * @param testobj (reference of the close, cancel button)
	 */
	@Keyword
	def closePopUpScreen(testobj) {

		Mobile.tap(findTestObject(testobj), 0)
	}


	/**
	 * clicks on more options, takes to beat features and enables it
	 */
	@Keyword
	def enableBetaFeatures() {

		dashboardObject.clickOnMoreOptionsTab() //takes user from dash-board to the moreOptions screen'

		Mobile.tap(findTestObject('iOS/moreOptionsScreen/betaFeature/betaFeatures_Tab'), 0)

		Mobile.tap(findTestObject('iOS/moreOptionsScreen/betaFeature/betaFeatureSwitch_Toggle'), 0)

		Mobile.tap(findTestObject('iOS/moreOptionsScreen/betaFeature/termsAgree_CheckBox'), 0)

		Mobile.tap(findTestObject('iOS/moreOptionsScreen/betaFeature/disclaimerConfirm_Button'), 0)

		waitForProgressBarToBeInvisible()
	}

	/**
	 * inputs the product search which can be name/Cin/UPC/NDC in the product search-field
	 * @param productSearch (which can be name/Cin/UPC/NDC in the product search-field)
	 */
	@Keyword
	def enterProductInSearchField(productSearch) {

		Mobile.setText(findTestObject('iOS/inventory/locationDetailsScreen/addProductToLocation/productSearch_TextField'), productSearch, 0)
	}

	/**
	 * this method will take the application one screen back
	 */
	@Keyword
	def goOneScreenBack() {

		waitForProgressBarToBeInvisible()

		if (Mobile.verifyElementExist(findTestObject('iOS/productSearch/globalSearch/back_Text'), 4,FailureHandling.OPTIONAL)) {

			Mobile.tap(findTestObject('iOS/productSearch/globalSearch/back_Text'), 4,FailureHandling.OPTIONAL)
		}
		else {
			Mobile.tap(findTestObject('iOS/inventory/locationDetailsScreen/addProductToLocation/backButton_Text'), 4)
		}
		waitForProgressBarToBeInvisible()
	}



	/**
	 * reads value from the global boolean variable: isIosAppInstalled
	 * and if it is set to true, launches already installed application else installs and launches the application
	 */
	@Keyword
	def installingAndlaunchingTheApplication() {


		if (GlobalVariable.isIosAppInstalled) {
			KeywordUtil.logInfo("application is already installed")
			Mobile.startExistingApplication(GlobalVariable.bundleID,FailureHandling.OPTIONAL)
		}
		else {
			KeywordUtil.logInfo("need to install the application")
			Mobile.startApplication(GlobalVariable.iOSAppPath, true)
		}
	}


	/**
	 * opens existing testflight app and installs latest OE App
	 * @return bundleId of testflight
	 */
	@Keyword
	def openTestFlightApp(String bundleID) {
		Mobile.startExistingApplication(bundleID)
		Mobile.tap(findTestObject('iOS/testFlight/install_Button'), 0)
		Mobile.delay(2)
		Mobile.waitForElementPresent(findTestObject('iOS/testFlight/open_Button'), 0)
		Mobile.tap(findTestObject('iOS/testFlight/open_Button'), 0)
	}



	/**
	 * performs basic text management operations:Copy,Cut,Paste,Share
	 * @param operationToBePerformed (in operationToBePerformed argument all alphabets should be lower-case except the first one for e.g Copy, Cut)
	 */
	@Keyword
	def performBasicTextManagementOperation(String operationToBePerformed) {

		Mobile.tapAndHold(findTestObject('iOS/inventory/locationDetailsScreen/addProductToLocation/productSearch_TextField'), 0, 0)

		Mobile.tap(findTestObject('iOS/verification/selectAll_MenuItem'), 5,FailureHandling.OPTIONAL)

		Mobile.tap(findTestObject('iOS/verification/textOperation_MenuItem',[('TEXT'):operationToBePerformed]), 0)

		waitForProgressBarToBeInvisible()
	}


	/**
	 * removes characters in string
	 * @param stringCharcterToBeRemoved (Removes characters in a string)
	 * @return modifiedString
	 */
	@Keyword
	def removeCharactersInString(String stringCharcterToBeRemoved) {
		String modifiedString=stringCharcterToBeRemoved.replaceAll("[^0-9.]", "")
		return modifiedString
	}



	/**
	 * this function returns the cost of added product
	 * @return productCost_dollarSymbolRemoved_FloatValue (of the product which has been added)
	 */
	@Keyword
	def returnCostOfTheAddedProduct(String testObj) {

		String productCost= Mobile.getText(findTestObject(testObj), 0)

		KeywordUtil.logInfo(productCost)

		productCost=productCost.replaceAll("[^0-9.]", "")
		float productCost_dollarSymbolRemoved_FloatValue=productCost.toFloat()

		//float productCost_dollarSymbolRemoved_FloatValue=(new common.commonMethods()).floatValueGenerator(productCost)//converting productCost string to a float value

		return productCost_dollarSymbolRemoved_FloatValue
	}



	/**
	 * this function returns the total expected value of the added product
	 * @return productCost_dollarSymbolRemoved_FloatValue (of the product which has been added)
	 */
	@Keyword
	def returnExpectedTotalValueForAddedProduct(quantity,costOfProduct) {

		int quantityIntegralValue=Integer.parseInt(quantity)

		float costOfAddedProduct=quantityIntegralValue*costOfProduct

		//BigDecimal costOfAddedProductObject = new BigDecimal(costOfAddedProduct)
		// round to 2 decimal places
		//BigDecimal costOfAddedProductRounded = costOfAddedProductObject.setScale(2, RoundingMode.CEILING)
		//KeywordUtil.logInfo("expected value" +costOfAddedProductRounded)
		return (costOfAddedProduct)
	}




	/**
	 * takes product to be searched as the argument and searches the same
	 * @param productToBeSearched (product to be searched)
	 */
	@Keyword
	def searchProduct(productToBeSearched) {

		waitForProgressBarToBeInvisible()

		clickOnProductSearchTextField()

		enterProductInSearchField(productToBeSearched)

		clickOnSearchKey()
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
	 * performs login function by selecting the type of testing (automation or manual), environment of testing(taken from the global profile), entering user-name and password
	 * and then selects the user account from the accounts list and takes user to the dash-board screen
	 * @param username
	 * @param password
	 * @param accountNo
	 */
	@Keyword
	def takeUserFromloginToHomeScreen(username,password,accountNo) {

		'waits until the progressBar is visible on the screen'
		waitForProgressBarToBeInvisible()

		'login function called'
		loginScreenObject.login(username, password)

		'waits until the progressBar is visible on the screen'
		waitForProgressBarToBeInvisible()

		'selects the user account from the accounts list'
		(new iosAccountSelection.selectAnAccount()).selectTheUserAccount(accountNo)

		'waits until the progressBar is visible on the screen'
		waitForProgressBarToBeInvisible()
	}



	/**
	 * disables touchid while using real device
	 */
	@Keyword
	def tapOnSetupLater() {
		Mobile.tap(findTestObject('iOS/verification/disableTouchIDRealDevice_Button'), 0)
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
	 * this method verifies the popUp screen is visible
	 * @param testobj (reference of the popUp screen object under verification)
	 */
	@Keyword
	def verifyPopUpScreenExist(testobj) {

		Mobile.verifyElementExist(findTestObject(testobj), 0)
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
	 * this function verifies that the product is visible on the product search screen after search
	 * @param productNdcNumber (using NDC of the product which is visible on the product tab)
	 * if in future upc/cin are visible then the method can be modified accordingly by passing the respective test object
	 */
	@Keyword
	def verifyProductIsVisibleOnTheProductSearchScreen(productNdcNumber) {

		String testObj='Object Repository/iOS/productSearch/globalSearch/ndcNumber_Text'

		verifyProductIsVisibleOnTheScreen(testObj,productNdcNumber)//calling verifyProductIsVisibleOnTheScreen function and passing testObj, productNdcNumber as the arguments
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
	 * verifies whether the selected user account is same as the account required
	 * @param expectedAccountNo (expected user account no)
	 */
	@Keyword
	def verifySelectedAccount(String expectedAccountNo) {

		Mobile.tap(findTestObject('iOS/accountSelection/changeAccount_Text'), 0)

		String actualAccountNo=Mobile.getText(findTestObject('iOS/accountSelection/selectedAccount_Label'), 0)

		assert expectedAccountNo==actualAccountNo

		Mobile.tap(findTestObject('iOS/accountSelection/changeAccount_Text'), 0)
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

		String testObject='Object Repository/iOS/productSearch/globalSearch/progress_Bar'

		waitTimeForObjectToBeVisible(testObject,1,20) //waitTime of 1(s), waitLimit of 20(s)
	}



	/**
	 * waits until the object is visible on the screen, which will have a maximum waitLimit to be visible on the screen
	 * @param testObj (reference of the test Object)
	 * @param waitTime (time by which delay will be added in(s))
	 * @param waitLimit (maximum limit of time for which delay can be added)
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
			KeywordUtil.markFailedAndStop("waitLimit of " + waitLimit + "(s) croosed and object is still visible on the screen!!!!! " +e.toString()); //logInfo if assertion fails
		}

	}
}
