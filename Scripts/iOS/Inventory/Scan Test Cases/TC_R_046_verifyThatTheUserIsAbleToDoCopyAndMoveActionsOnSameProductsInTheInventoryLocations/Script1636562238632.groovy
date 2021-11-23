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

'takes user from login to home screen and takes username, password, account no as the arguments'
CustomKeywords.'iosCommonKeywords.commonMethods.takeUserFromloginToHomeScreen'(GlobalVariable.Username, GlobalVariable.Password, 
    GlobalVariable.Account)

'takes user from home screen to inventory listing screen'
CustomKeywords.'iosCommonKeywords.commonMethods.takeUserFromHomeToInventoryListingScreen'()

'output of random string generator is stored in inventoryName which will be passed into create_Inventory function'
inventoryName = CustomKeywords.'common.commonMethods.randomStringGenerator'(inventoryNameLength)

'creates an inventory by taking inventoryName as the argument'
CustomKeywords.'iosInventory.inventoryListingScreen.createInventory'(inventoryName)

'ouput of random string generator is stored in locationName which will be passed into add_Location function'
locationName_1 = CustomKeywords.'common.commonMethods.randomStringGenerator'(locationNameLength)

'adds location in location details page and takes locationName as the argument'
CustomKeywords.'iosInventory.inventoryDetailsScreen.addLocation'(locationName_1, costType_1)

'opens the location details and takes the locationName as the argument'
CustomKeywords.'iosInventory.inventoryDetailsScreen.clickOnALocation'(locationName_1)

'reading the module test data file'
def requestObject = CustomKeywords.'common.commonMethods.readFileTypeJSON'('inventoryTestData.json')

'declaring stack for storing countType of the product needs to be added'
Stack<String> countTypeStack = new Stack<String>()

'declaring stack for storing quantity of the product needs to be added'
Stack<String> quantityStack = new Stack<String>()

'declaring stack for storing ndcNumbers of the product needs to be added'
Stack<String> ndcNumbersStack = new Stack<String>()

'declaring stack for storing unit of issue costs of the product needs to be added'
Stack<String> unitOfIssueCostStack = new Stack<String>()

'reading the upc of product to be added'
String productSearch = requestObject[GlobalVariable.Environment].TC_R_046.productSearchByUPC

'reading the ndc of product to be added'
productSearch = requestObject[GlobalVariable.Environment].TC_R_046.productSearchByNDC

'pushing the ndc of the product to be searched into the stack'
ndcNumbersStack.push(productSearch)

'taps on scan icon and takes user to scanning product screen and also verifies that the default toggle is at full count'
CustomKeywords.'iosInventory.locationDetailsScreen.clickOnScanIcon'()

'calling the function which scans the product and adds it to the location, it takes productName/UPC/Cin/Ndc as the argument'
CustomKeywords.'iosInventory.locationDetailsScreen.scanInputEvent'(productSearch)

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'taps on scan icon and takes user to scanning product screen and also verifies that the default toggle is at full count'
CustomKeywords.'iosInventory.locationDetailsScreen.clickOnScanIcon'()

'calling the function which selects the countType required for a product which is searched and takes countType as the argument'
CustomKeywords.'iosInventory.locationDetailsScreen.selectCountTypeForTheProductToBeAdded'(countType_1)

'calling the function which scans the product and adds it to the location, it takes productName/UPC/Cin/Ndc as the argument'
CustomKeywords.'iosInventory.locationDetailsScreen.scanInputEvent'(productSearch)

'calling the function which adds quantity required for a product to be added and takes quantity required as the argument'
uoiCost = CustomKeywords.'iosInventory.locationDetailsScreen.returnUOIOfTheAddedProduct'()

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'ouput of random string generator is stored in locationName which will be passed into add_Location function'
locationName_2 = CustomKeywords.'common.commonMethods.randomStringGenerator'(locationNameLength)

'adds location in location details page and takes locationName as the argument'
CustomKeywords.'iosInventory.inventoryDetailsScreen.addLocation'(locationName_2, costType_2)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'opens the location details and takes the locationName as the argument'
CustomKeywords.'iosInventory.inventoryDetailsScreen.clickOnALocation'(locationName_2)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'taps on scan icon and takes user to scanning product screen and also verifies that the default toggle is at full count'
CustomKeywords.'iosInventory.locationDetailsScreen.clickOnScanIcon'()

'calling the function which scans the product and adds it to the location, it takes productName/UPC/Cin/Ndc as the argument'
CustomKeywords.'iosInventory.locationDetailsScreen.scanInputEvent'(productSearch)

'calling the function which adds quantity required for a product to be added and takes quantity required as the argument'
float uoiCost = CustomKeywords.'iosInventory.locationDetailsScreen.returnUOIOfTheAddedProduct'()

'pushing the uoiCost of the product to be searched into the stack'
unitOfIssueCostStack.push(uoiCost)

'pushing the countType of the product to be searched into the stack'
countTypeStack.push(countType_1)

'pushing the quantity of the product to be added into the stack'
quantityStack.push(quantity)

'pushing the ndc of the product to be searched into the stack'
ndcNumbersStack.push(productSearch)

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'taps on scan icon and takes user to scanning product screen and also verifies that the default toggle is at full count'
CustomKeywords.'iosInventory.locationDetailsScreen.clickOnScanIcon'()

'calling the function which selects the countType required for a product which is searched and takes countType as the argument'
CustomKeywords.'iosInventory.locationDetailsScreen.selectCountTypeForTheProductToBeAdded'(countType_1)

'calling the function which scans the product and adds it to the location, it takes productName/UPC/Cin/Ndc as the argument'
CustomKeywords.'iosInventory.locationDetailsScreen.scanInputEvent'(productSearch)

'calling the function which adds quantity required for a product to be added and takes quantity required as the argument'
uoiCost = CustomKeywords.'iosInventory.locationDetailsScreen.returnUOIOfTheAddedProduct'()

'pushing the uoiCost of the product to be searched into the stack'
unitOfIssueCostStack.push(uoiCost)

'pushing the countType of the product to be searched into the stack'
countTypeStack.push(countType_2)

'pushing the quantity of the product to be added into the stack'
quantityStack.push('2')

'pushing the ndc of the product to be searched into the stack'
ndcNumbersStack.push(productSearch)

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'opens the location details and takes the locationName as the argument'
CustomKeywords.'iosInventory.inventoryDetailsScreen.clickOnALocation'(locationName_1)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'calling the function which copies a product to another location, it takes location and productName/UPC/Cin/Ndc as the argument'
CustomKeywords.'iosInventory.locationDetailsScreen.copyProductToAnotherLocation'(locationName_2, productSearch)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'calling the function which copies a product to another location, it takes location and productName/UPC/Cin/Ndc as the argument'
CustomKeywords.'iosInventory.locationDetailsScreen.verifyCountTypeOfProduct'(countType_1)

'calling the function which copies a product to another location, it takes location and productName/UPC/Cin/Ndc as the argument'
int actualQuantity = CustomKeywords.'iosInventory.locationDetailsScreen.returnQuantityOfTheAddedProduct'()

assert actualQuantity == expectedProductQuantity_1

'this function verifies that the product is visible on the location details screen'
CustomKeywords.'iosInventory.locationDetailsScreen.verifyProductIsVisibleOnTheLocationDetailsScreen'(productSearch)

'calling the function which copies a product to another location, it takes location and productName/UPC/Cin/Ndc as the argument'
CustomKeywords.'iosInventory.locationDetailsScreen.deleteProduct'(productSearch)

'calling the function which moves a product to another location, it takes location and productName/UPC/Cin/Ndc as the argument'
CustomKeywords.'iosInventory.locationDetailsScreen.moveProductToAnotherLocation'(locationName_1, productSearch)

'waits until the progressBar is visible on the screen'
CustomKeywords.'iosCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'calling the function which copies a product to another location, it takes location and productName/UPC/Cin/Ndc as the argument'
actualQuantity = CustomKeywords.'iosInventory.locationDetailsScreen.returnQuantityOfTheAddedProduct'()

actualQuantity == expectedProductQuantity_2

'calling the function which copies a product to another location, it takes location and productName/UPC/Cin/Ndc as the argument'
CustomKeywords.'iosInventory.locationDetailsScreen.verifyCountTypeOfProduct'(countType_2)

'this function verifies that the product is visible on the location details screen'
CustomKeywords.'iosInventory.locationDetailsScreen.verifyProductIsVisibleOnTheLocationDetailsScreen'(productSearch)

'verifies location details Screen elements like linesCount, countype of product added, quantity on location details screen'
CustomKeywords.'iosInventory.locationDetailsScreen.verifyLocationDetailsScreen'(countTypeStack, quantityStack, ndcNumbersStack, 
    unitOfIssueCostStack)

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'deletes the location and takes locationName as the argument'
CustomKeywords.'iosInventory.inventoryDetailsScreen.deleteLocation'(locationName_2)

'deletes the location and takes locationName as the argument'
CustomKeywords.'iosInventory.inventoryDetailsScreen.deleteLocation'(locationName_1)

'takes the application one screen back'
CustomKeywords.'iosCommonKeywords.commonMethods.goOneScreenBack'()

'deletes the inventory and takes inventoryName as the argument'
CustomKeywords.'iosInventory.inventoryListingScreen.deleteInventory'(inventoryName)

