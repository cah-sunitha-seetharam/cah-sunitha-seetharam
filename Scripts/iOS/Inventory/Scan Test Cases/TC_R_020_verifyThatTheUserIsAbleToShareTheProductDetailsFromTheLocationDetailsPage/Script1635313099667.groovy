import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

'starts the application'
CustomKeywords.'iosCommonKeywords.commonMethods.installingAndlaunchingTheApplication'()

'login function called which takes user to the accounts selection screen'
CustomKeywords.'iosLogin.loginScreen.login'(GlobalVariable.Username, GlobalVariable.Password)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'selects the user account from the accounts list'
CustomKeywords.'iosAccountSelection.selectAnAccount.selectTheUserAccount'(GlobalVariable.Account)

'takes user to the moreOptions screen'
CustomKeywords.'iosDashboard.dashboardDetailsScreen.clickOnMoreOptionsTab'()

'takes the user from moreOptions screen to the inventory listing screen'
CustomKeywords.'iosMoreOptions.moreOptionsScreen.goToInventoryListingScreen'()

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'output of random string generator is stored in inventoryName which will be passed into create_Inventory function'
inventoryName = CustomKeywords.'common.commonMethods.randomStringGenerator'(inventoryNameLength)

'creates an inventory by taking inventoryName as the argument'
CustomKeywords.'iosInventory.inventoryListingScreen.createInventory'(inventoryName)

'adds location in location details page and takes locationName as the argument'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'ouput of random string generator is stored in locationName which will be passed into add_Location function\n'
locationName = CustomKeywords.'common.commonMethods.randomStringGenerator'(locationNameLength)

'adds location in location details page and takes locationName as the argument'
CustomKeywords.'iosInventory.inventoryDetailsScreen.addLocation'(locationName, costType)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'opens the location details and takes the locationName as the argument'
CustomKeywords.'iosInventory.inventoryDetailsScreen.clickOnALocation'(locationName)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'reading the module test data file'
def requestObject = CustomKeywords.'common.commonMethods.readFileTypeJSON'('inventoryTestData.json')

'reading the ndcNumber of product to be added'
String productSearch = requestObject[GlobalVariable.Environment].TC_R_020.productSearchByNDC1

'declaring stack for storing countType of the product needs to be added'
Stack<String> countTypeStack = new Stack<String>()

'declaring stack for storing quantity of the product needs to be added'
Stack<String> quantityStack = new Stack<String>()

'declaring stack for storing ndcNumbers of the product needs to be added'
Stack<String> ndcNumbersStack = new Stack<String>()

'pushing the ndc of the product to be searched into the stack'
ndcNumbersStack.push(productSearch)

'calling the function which adds a product by clicking on scan and takes productNdc,countType and quantity required as thee arguments'
CustomKeywords.'iosInventory.locationDetailsScreen.clickOnScanIconAndAddProduct'(productSearch, countType_1, quantity)

'pushing the countType of the product to be searched into the stack'
countTypeStack.push(countType_1)

'pushing the quantity of the product to be added into the stack'
quantityStack.push(quantity)

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'reading the ndcNumber of product to be added'
productSearch = requestObject[GlobalVariable.Environment].TC_R_020.productSearchByNDC1

'pushing the ndc of the product to be searched into the stack'
ndcNumbersStack.push(productSearch)

'calling the function which adds a product by clicking on scan and takes productNdc,countType and quantity required as thee arguments'
CustomKeywords.'iosInventory.locationDetailsScreen.clickOnScanIconAndAddProduct'(productSearch, countType_2, quantity)

'pushing the countType of the product to be searched into the stack'
countTypeStack.push(countType_2)

'pushing the quantity of the product to be added into the stack'
quantityStack.push(quantity)

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'clicks on share location button and verifies the pop-up screen and then closes the pop-up screen'
CustomKeywords.'iosInventory.locationDetailsScreen.verifyShareLocationPopUp'()

'verifies location details Screen elements like linesCount, countype of product added, quantity on location details screen'
CustomKeywords.'iosInventory.locationDetailsScreen.verifyLocationDetailsScreen'(expectedLinesCount, countTypeStack, quantityStack, 
    ndcNumbersStack)

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'deletes the location and takes locationName as the argument'
CustomKeywords.'iosInventory.inventoryDetailsScreen.deleteLocation'(locationName)

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'deletes the inventory and takes inventoryName as the argument'
CustomKeywords.'iosInventory.inventoryListingScreen.deleteInventory'(inventoryName)

