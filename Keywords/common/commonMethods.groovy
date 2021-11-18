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

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

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
import groovy.json.JsonSlurper as JsonSlurper
import java.io.File
import java.math.RoundingMode
import java.text.DecimalFormat


class commonMethods {


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
}