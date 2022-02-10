package iosOrders
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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile


class bcsOrders {

	def iosCommonKeywordsObject=new iosCommonKeywords.commonMethods()
	/**
	 * verifies bcs notification on the cart screen
	 */
	@Keyword
	def verifyBcsNotification() {

		Mobile.verifyElementExist(findTestObject('iOS/orders/backupCartSync/youHaveSavedOrderExpressOrdersTapToView_Text'), 0, 0)
	}


	/**
	 * opens the saved orders by tapping on the bcs notification
	 */
	@Keyword
	def openSavedOrdersList() {

		Mobile.tapAndHold(findTestObject('iOS/orders/backupCartSync/youHaveSavedOrderExpressOrdersTapToView_Text'), 0, 0)
	}


	/**
	 * verifies details related to saved orders listing screen
	 */
	@Keyword
	def verifySavedOrdersListDetails() {

		Mobile.verifyElementExist(findTestObject('iOS/orders/backupCartSync/headerLabel_Text'), 0)

		Mobile.verifyElementExist(findTestObject('iOS/orders/backupCartSync/lastUpdateLabel_Text'), 0)
	}


	/**
	 * verifies details related to saved orders listing screen
	 */
	@Keyword
	def lookforC2Orders() {

		Mobile.scrollToText("C2 orders are unavailable to copy to mobile")
	}


	/**
	 * verifies details related to c2 orders tile under orders listing screen
	 */
	@Keyword
	def verifyC2RelatedDetailsForBCS() {

		Mobile.scrollToText("C2 orders are unavailable to copy to mobile")

		String yCoordinate=Mobile.getAttribute(findTestObject('iOS/orders/backupCartSync/orderTile'), 'y',0)
		String elementHeight =Mobile.getElementHeight(findTestObject('iOS/orders/backupCartSync/orderTile'), 0)
		String elementLeftPosition =Mobile.getElementLeftPosition(findTestObject('iOS/orders/backupCartSync/orderTile'), 0)
		String elementWidth =Mobile.getElementWidth(findTestObject('iOS/orders/backupCartSync/orderTile'), 0)

		KeywordUtil.logInfo(yCoordinate)
		KeywordUtil.logInfo(elementWidth)
		KeywordUtil.logInfo(elementHeight)
		KeywordUtil.logInfo(elementLeftPosition)

		int xminBoundaryCoordinate=elementLeftPosition.toInteger()
		int yminBoundaryCoordinate=yCoordinate.toInteger()
		int xmaxBoundaryCoordinate=xminBoundaryCoordinate+elementWidth.toInteger()
		int ymaxBoundaryCoordinate=yminBoundaryCoordinate+elementHeight.toInteger()

		Mobile.verifyElementNotVisible(findTestObject('iOS/orders/backupCartSync/parametrizedSavedOrdersAmountLabel_Text',[('TEXT_1'):xminBoundaryCoordinate,('TEXT_2'):yminBoundaryCoordinate,('TEXT_3'):xmaxBoundaryCoordinate,('TEXT_4'):ymaxBoundaryCoordinate]), 5)
		Mobile.verifyElementNotVisible(findTestObject('iOS/orders/backupCartSync/parametrisedCheck_Button',[('TEXT_1'):xminBoundaryCoordinate,('TEXT_2'):yminBoundaryCoordinate,('TEXT_3'):xmaxBoundaryCoordinate,('TEXT_4'):ymaxBoundaryCoordinate]), 5)
		Mobile.verifyElementAttributeValue(findTestObject('iOS/orders/backupCartSync/copyOrdersToMobile_Button'), 'enabled','false',0)
	}


	/**
	 * copies a non c2 order from saved orders to the cart screen and verifies details related to copy button
	 */
	@Keyword
	def copyNonC2ProductFromSavedOrders() {

		Mobile.verifyElementAttributeValue(findTestObject('iOS/orders/backupCartSync/copyOrdersToMobile_Button'), 'enabled','false',0)

		Mobile.tap(findTestObject('iOS/orders/backupCartSync/check_Button'), 0)

		Mobile.verifyElementAttributeValue(findTestObject('iOS/orders/backupCartSync/copyOrdersToMobile_Button'), 'enabled','true',0)

		Mobile.tapAndHold(findTestObject('iOS/orders/backupCartSync/copyOrdersToMobile_Button'),0,0)

		Mobile.verifyElementExist(findTestObject('iOS/orders/backupCartSync/backToSavedOrders_Text'), 0)

		Mobile.tap(findTestObject('iOS/orders/backupCartSync/goToCart_Text'), 0)
	}



	/**
	 * copies topmost non c2 order to cart screen
	 * verifies details related to order name, account name, lines count 
	 * of the order which is at the top of the order list under saved orders
	 */
	@Keyword
	def copyAndVerifyTopMostOrderDetailsUnderSavedOrdersToCartScreen() {

		String orderName1=Mobile.getText(findTestObject('iOS/orders/backupCartSync/savedOrdersOrderNameLabel_Text'), 0)
		String linesCount1=Mobile.getText(findTestObject('iOS/orders/backupCartSync/savedOrdersLinesLabel_Text'), 0)
		String cost1=Mobile.getText(findTestObject('iOS/orders/backupCartSync/savedOrdersAmountLabel_Text'), 0)


		copyNonC2ProductFromSavedOrders()
		iosCommonKeywordsObject.waitForProgressBarToBeInvisible()

		String orderName2=Mobile.getText(findTestObject('iOS/orders/backupCartSync/cartScreenOrderNameLabel_Text'), 0)
		String cost2=Mobile.getText(findTestObject('iOS/orders/backupCartSync/cartScreenAmountLabel_Text'), 0)
		String linesCount2=Mobile.getText(findTestObject('iOS/orders/backupCartSync/cartScreenLinesLabel_Text'), 0)

		Float.parseFloat(linesCount1.replaceAll("[^0-9.]", ""))
		Float.parseFloat(linesCount2.replaceAll("[^0-9.]", ""))


		assert orderName1==orderName2
		assert cost1==cost2
		assert linesCount1==linesCount2
	}
}