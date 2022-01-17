import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.util.KeywordUtil

import java.sql.Driver

import javax.swing.text.html.HTML.Tag

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.builtin.VerifyElementExistKeyword

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import io.appium.java_client.AppiumDriver
import common.commonMethods
import androidLogin.loginScreen

class BeforeAfterListeners {

	def iosLoginObject=new iosLogin.loginScreen()
	def iosCommonMethodsObject=new iosCommonKeywords.commonMethods()
	def androidCommonMethodsObject=new androidCommonKeywords.commonMethods()
	def iosOrdersCommonMethodsObject=new iosOrders.ordersCommonScreen()
	def androidOrdersCommonMethodsObject=new androidOrders.ordersCommonScreen()
	def androidLoginCommonMethodsObject=new androidLogin.loginScreen()
	def androidAccountSelectionCommonMethodsObject=new androidAccountSelection.selectAnAccount()
	def platformName = MobileDriverFactory.getDevicePlatform() // Identify the platform on which the test execution is happening



	/**
	 * Executes after every test case ends.
	 * @param testCaseContext related information of the executed test case.
	 */
	@AfterTestCase
	def afterTestCase(TestCaseContext testCaseContext) {
		if(platformName == 'Android')  // check if platform is Android
		{
			String testCaseID=testCaseContext.getTestCaseId()//get the testCaseID
			if((testCaseContext.getTestCaseStatus()=='FAILED' || testCaseContext.getTestCaseStatus()=='ERROR') && testCaseID.contains("Carts"))//if test case failed and is from orders module
			{
				androidOrdersCommonMethodsObject.clearAllOrders() //delete all the orders that were created
			}
			AppiumDriver<?> driver =  commonMethods.getCurrentSessionMobileDriver() // mobile driver value of the current session
			try {
				driver.terminateApp(GlobalVariable.appPackage) // Terminate the application(if it is running).
			}
			catch (Exception exceptionError) {
				driver.closeApp()  // Close the open app
				driver.terminateApp(GlobalVariable.appPackage)  // Terminate the application(if it is running).
			}
		}

		else  //  platform is iOS
		{

			String testCaseID=testCaseContext.getTestCaseId()// get the testCaseID
			if((testCaseContext.getTestCaseStatus()=='FAILED' || testCaseContext.getTestCaseStatus()=='ERROR') && testCaseID.contains("Carts"))//if test case failed and is from orders module
			{
				iosOrdersCommonMethodsObject.clearAllOrders()//delete all the orders that were created
			}
			AppiumDriver<?> driver =  commonMethods.getCurrentSessionMobileDriver() // mobile driver value of the current session
			try {
				driver.terminateApp(GlobalVariable.bundleID) // Terminate the application(if it is running).
			}
			catch (Exception exceptionError) {
				driver.closeApp()  // Close the open app
				driver.terminateApp(GlobalVariable.bundleID)  // Terminate the application(if it is running).
			}
		}
	}



	/**
	 * Executes after every test suite.
	 * Ends the session
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	@AfterTestSuite
	def AfterTestSuite(TestSuiteContext testSuiteContext) {
		AppiumDriver<?> driver =  commonMethods.getCurrentSessionMobileDriver()
		driver.quit()   // Ends the session  / delete session
	}



	/**
	 * Executes before every test case.
	 * Activates the application if it installed, but not running or if it is running in the background
	 * @param testCaseContext related information of the executed test case.
	 */
	@BeforeTestCase
	def beforeTestCase(TestCaseContext testCaseContext) {
		String testCaseID=testCaseContext.getTestCaseId()
		if(platformName == 'Android')  // check if platform is Android
		{
			AppiumDriver<?> driver =  commonMethods.getCurrentSessionMobileDriver()
			driver.activateApp(GlobalVariable.appPackage)  //Activates the application if it installed, but not running or if it is running in the background.


			if((testCaseID.contains("TC_OE_021") || testCaseID.contains("TC_OE_022")))//if test case if from receiving module and have specific test id (data dependency so again installation is required)
			{
				RunConfiguration.setMobileDriverPreferencesProperty("appWaitActivity", GlobalVariable.appWaitActivity)   // relative reference of activity name to wait for while opening the app
				RunConfiguration.setMobileDriverPreferencesProperty("appPackage", GlobalVariable.appPackage) // this value will get from profile
				Mobile.startApplication(GlobalVariable.AndroidAppPath, true)  // Install the build file (Application)
				androidCommonMethodsObject.takeUserFromloginToHomeScreen(GlobalVariable.Username, GlobalVariable.Password,GlobalVariable.Account)  // Invoking the Environment selection and login method
				CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnMoreOptions'() //clicks on more option
				CustomKeywords.'androidMoreOptions.moreOptionsScreen.enableBetaFeatureCSOS'()// enables beta features
			}

			if (Mobile.verifyElementExist(findTestObject('Android/Login/Login Details Screen/Password_TextField'),2, FailureHandling.OPTIONAL)) //if login session expired and user is back to the login screen
			{
				androidCommonMethodsObject.takeUserFromloginToHomeScreen(GlobalVariable.Username, GlobalVariable.Password,GlobalVariable.Account)  // Invoking the Environment selection and login method

			}

			if(testCaseID.contains("CSOS"))//if test case if from CSOS module, first step is to sign-out and login using specific account for csos
			{
				CustomKeywords.'androidMoreOptions.moreOptionsScreen.signOut'()//takes the application back to login page
				androidCommonMethodsObject.takeUserFromloginToHomeScreen(GlobalVariable.Username, GlobalVariable.Password,GlobalVariable.Account)  // Invoking the Environment selection and login method
				CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnMoreOptions'()//clicks on more option
				CustomKeywords.'androidMoreOptions.moreOptionsScreen.enableBetaFeatureCSOS'()// enables beta features
			}
		}


		else//  platform is iOS
		{
			AppiumDriver<?> driver =  commonMethods.getCurrentSessionMobileDriver()
			driver.activateApp(GlobalVariable.bundleID)  //Activates the application if it installed, but not running or if it is running in the background.

			if (Mobile.verifyElementExist(findTestObject('iOS/LogIn/Login_Details_Screen/cancelUpdate_Button'),2, FailureHandling.OPTIONAL))//cancel update pop up is visible
			{

				Mobile.tap(findTestObject('iOS/LogIn/Login_Details_Screen/cancelUpdate_Button'), 5,FailureHandling.OPTIONAL) //closes the pop up
			}

			if(testCaseID.contains("CSOS"))//if test case if from CSOS module, first step is to sign-out and login using specific account for csos
			{
				CustomKeywords.'iosMoreOptions.moreOptionsScreen.signOut'()//takes the application back to login page
				iosCommonMethodsObject.takeUserFromloginToHomeScreen(GlobalVariable.Username, GlobalVariable.Password,GlobalVariable.Account) //takes user from login to home screen
				(new iosCommonKeywords.commonMethods()).enableBetaFeatures()
			}

		}
	}



	/**
	 * Executes before every test suite starts.
	 *  Application will get installed using the build file given on the app path reference (global variable)
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	@BeforeTestSuite
	def beforeTestSuite(TestSuiteContext testSuiteContext) {
		if(platformName == 'Android')  // check if platform is Android
		{
			RunConfiguration.setMobileDriverPreferencesProperty("appWaitActivity", GlobalVariable.appWaitActivity)   // relative reference of activity name to wait for while opening the app
			RunConfiguration.setMobileDriverPreferencesProperty("appPackage", GlobalVariable.appPackage) // this value will get from profile
			Mobile.startApplication(GlobalVariable.AndroidAppPath, true)  // Install the build file (Application)
			AppiumDriver<?> driver =  commonMethods.getCurrentSessionMobileDriver()
			androidCommonMethodsObject.takeUserFromloginToHomeScreen(GlobalVariable.Username, GlobalVariable.Password,GlobalVariable.Account)  // Invoking the Environment selection and login method
			CustomKeywords.'androidDashboard.dashboardDetailsScreen.clickOnMoreOptions'()
			CustomKeywords.'androidMoreOptions.moreOptionsScreen.enableBetaFeatureCSOS'()
			try {
				driver.terminateApp(GlobalVariable.appPackage) // Terminate the application(if it is running).
			}
			catch (Exception exceptionError) {
				driver.closeApp()  // Close the open app
				driver.terminateApp(GlobalVariable.appPackage)  // Terminate the application(if it is running).
			}
		}

		else//  platform is iOS

		{
			Mobile.startApplication(GlobalVariable.iOSAppPath, true)  // Install the build file (Application)
			AppiumDriver<?> driver =  commonMethods.getCurrentSessionMobileDriver()
			iosCommonMethodsObject.takeUserFromloginToHomeScreen(GlobalVariable.Username, GlobalVariable.Password,GlobalVariable.Account)
			(new iosCommonKeywords.commonMethods()).enableBetaFeatures()

			try {
				driver.terminateApp(GlobalVariable.bundleID) // Terminate the application(if it is running).
			}
			catch (Exception exceptionError) {
				driver.closeApp()  // Close the open app
				driver.terminateApp(GlobalVariable.bundleID)  // Terminate the application(if it is running).
			}
		}
	}
}






