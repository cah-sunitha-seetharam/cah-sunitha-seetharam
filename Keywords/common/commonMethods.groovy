package common
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By
import org.openqa.selenium.TakesScreenshot
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.core.configuration.RunConfiguration

import groovy.json.JsonOutput as JsonOutput
import groovy.json.JsonSlurper
import java.awt.image.BufferedImage
import java.io.File
import java.math.RoundingMode
import java.text.DecimalFormat
import java.io.IOException;
import javax.imageio.ImageIO;
import org.openqa.selenium.OutputType
import org.openqa.selenium.Point
import io.appium.java_client.InteractsWithApps

class commonMethods {

	/**
	 * Get mobile driver for current session
	 * @return mobile driver for current session
	 */
	@Keyword

	def static WebDriver getCurrentSessionMobileDriver() {
		return MobileDriverFactory.getDriver();
	}

	/**
	 * random alpha numeric String Generator 
	 * @param length, required string length 
	 * @return alpha-numeric string  
	 */
	@Keyword
	def static randomStringGenerator(int length) {
		String alphabet = (('A'..'N') +('P'..'Z') +('a'..'k') +('m'..'z') +('2'..'9')).join()
		def randomStringValue = new Random().with {
			(1..length).collect { alphabet[nextInt(alphabet.length())] }.join()
		}
		return randomStringValue
	}

	/**
	 * Read JSON file 
	 * @param file name, Note: data files are considered to be on Data files location on project directory  
	 * @return the JSON file object 
	 */
	@Keyword


	def static readFileTypeJSON(def String fileNameValue) {
		String nameValue = fileNameValue
		if (nameValue.size() < 1) {
			println("Missing filename")
			System.exit(1)
		}

		def jsonSlurper = new JsonSlurper()
		println(RunConfiguration.getProjectDir())
		def fileReference = new File(RunConfiguration.getProjectDir() + "/Data Files/" + nameValue)
		def jsonObject = jsonSlurper.parse(fileReference)
		return jsonObject
	}


	def platformName = MobileDriverFactory.getDevicePlatform()


	MobileElement element
	/**
	 * float value generator
	 * @param stringToBeConvertedToFloatValue
	 * @return float value for a string by removing characters
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
	 * this function formats the decimal data for e.g 20.546 would be converted to 20.55 if decimalFormatRequired is 0.00
	 * @param decimalDataToBeFormatted (decimal data required to be formatted), 
	 * @param decimalFormatRequired (decimal format required for e.g 0.00 for rounding to 2 decimal places)
	 * @return formattedDecimalData (formatted decimal data)
	 */
	@Keyword
	def formatDecimalData(decimalDataToBeFormatted, String decimalFormatRequired) {
		DecimalFormat decimalFormat=new DecimalFormat (decimalFormatRequired);
		decimalFormat.setRoundingMode(RoundingMode.UP) //rounding mode set to UP
		String formattedDecimalData=decimalFormat.format(decimalDataToBeFormatted) //storing formatted value in the variable formattedDecimalData
		KeywordUtil.logInfo(formattedDecimalData)
		return formattedDecimalData // returns formattedDecimalData
	}


	/**
	 * removes existing app 
	 * @param bundleId of the App
	 */
	@Keyword
	def removeApp(String bundleID) {
		InteractsWithApps driver = MobileDriverFactory.getDriver()
		driver.removeApp(bundleID)
	}



	/**
	 * verifies element colour by taking a screenshot and comparing with colour of specific pixels
	 * @param expectedRedIntensity
	 * @param expectedGreenIntensity
	 * @param expectedBlueIntensity
	 * @param idOfTheElement
	 */
	@Keyword
	def verifyElementColor(int expectedRedIntensity, int expectedGreenIntensity, int expectedBlueIntensity, String locatorOfTheElement) {

		'mobile driver value of the current session'
		AppiumDriver<?> driver =  commonMethods.getCurrentSessionMobileDriver()

		if(platformName == 'Android') {

			'locate the element by passing the locator strategy that can be of users choice'
			element = (MobileElement) driver.findElement(By.id("${locatorOfTheElement}"))
		} else {

			'locate the element by passing the locator strategy that can be of users choice'
			element = (MobileElement) driver.findElement(By.name("${locatorOfTheElement}"))
		}

		'gets the center coordinates'
		Point point = element.getCenter()

		'stores x coordinate in Xcenter'
		int Xcenter = point.getX()

		'stores y coordinate in Ycenter'
		int Ycenter = point.getY();

		'takes screenshot as a file'
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE)

		'Returns a BufferedImage as the result of decoding a supplied File with an ImageReader chosen automatically from among those currently registered'
		BufferedImage image = ImageIO.read(file);

		'Returns an integer pixel in the default RGB color model (TYPE_INT_ARGB)'
		'TYPE_INT_ARGB: represents color as an int of 4 bytes with Blue channels in 0-7, Green channels in 8-15 and Red channels in 24-31'
		int rgbPixel=  image.getRGB(Xcenter,Ycenter);

		'as red channels in 24-31, using bitwise AND operator with hexadecimal code of color Red and right shifting by 16 bits'
		int  actualRedIntensity   = (rgbPixel & 0x00ff0000) >> 16

		'as green channels in 8-15, using bitwise AND operator with hexadecimal code of color Green and right shifting by 8 bits'
		int  actualGreenIntensity = (rgbPixel & 0x0000ff00) >> 8

		'as Blue channels in 0-7, using bitwise AND operator with hexadecimal code of Blue and no need to shift bits'
		int  actualBlueIntensity  = (rgbPixel & 0x000000ff)

		assert actualRedIntensity==expectedRedIntensity
		assert actualGreenIntensity==expectedGreenIntensity
		assert actualBlueIntensity==expectedBlueIntensity
	}
}