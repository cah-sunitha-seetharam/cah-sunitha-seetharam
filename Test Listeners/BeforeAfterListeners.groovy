import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.sql.Driver
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

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

class BeforeAfterListeners {

	def platformName = MobileDriverFactory.getDevicePlatform() // Identify the platform on which the test execution is happening
	/**
	 * Executes after every test case ends.
	 * @param testCaseContext related information of the executed test case.
	 */
	@AfterTestCase
	def afterTestCase(TestCaseContext testCaseContext) {
		if(platformName == 'Android')  // check if platform is Android
		{
			AppiumDriver<?> driver =  commonMethods.getCurrentSessionMobileDriver() // mobile driver value of the current session
			try {
				driver.terminateApp(GlobalVariable.appPackage) // Terminate the application(if it is running).
			}
			catch (Exception exceptionError) {
				driver.closeApp()  // Close the open app
				driver.terminateApp(GlobalVariable.appPackage)  // Terminate the application(if it is running).
			}
		}



		else  //  platform is Android
		{
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
	@AfterTestSuite
	def AfterTestSuite(TestSuiteContext testSuiteContext) {
		AppiumDriver<?> driver =  commonMethods.getCurrentSessionMobileDriver()
		driver.quit()   // Ends the session  / delete session
	}
	@BeforeTestCase
	def beforeTestCase(TestCaseContext testCaseContext) {
		if(platformName == 'Android')  // check if platform is Android
		{
			AppiumDriver<?> driver =  commonMethods.getCurrentSessionMobileDriver()
			driver.activateApp(GlobalVariable.appPackage)  //Activates the application if it installed, but not running or if it is running in the background.
		}


		else
		{
			AppiumDriver<?> driver =  commonMethods.getCurrentSessionMobileDriver()
			driver.activateApp(GlobalVariable.bundleID)  //Activates the application if it installed, but not running or if it is running in the background.
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
			Mobile.startApplication(GlobalVariable.Android_App_Path, true)  // Install the build file (Application)
			AppiumDriver<?> driver =  commonMethods.getCurrentSessionMobileDriver()
			CustomKeywords.'android_login.Login_Screen.login'(GlobalVariable.Password)  // Invoking the Environment selection and login method

			try {
				driver.terminateApp(GlobalVariable.appPackage) // Terminate the application(if it is running).
			}
			catch (Exception exceptionError) {
				driver.closeApp()  // Close the open app
				driver.terminateApp(GlobalVariable.appPackage)  // Terminate the application(if it is running).
			}

		}

		else

		{
			Mobile.startApplication(GlobalVariable.iOSAppPath, true)  // Install the build file (Application)
			AppiumDriver<?> driver =  commonMethods.getCurrentSessionMobileDriver()
			(new iosCommonKeywords.commonMethods()).takeUserFromloginToHomeScreen(GlobalVariable.Username, GlobalVariable.Password,GlobalVariable.Account)

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






