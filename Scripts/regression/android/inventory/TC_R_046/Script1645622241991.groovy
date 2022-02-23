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

/*'starts the application'
CustomKeywords.'androidCommonKeywords.commonMethods.installingAndlaunchingTheApplication'()

'login function called which takes user to the accounts selection screen'
CustomKeywords.'androidLogin.loginScreen.login'(GlobalVariable.Username, GlobalVariable.Password)

'selects the user account from the accounts list'
CustomKeywords.'androidAccountSelection.selectAnAccount.selectTheUserAccount'(GlobalVariable.Account)*/

'takes user from home screen to inventory listing screen'
CustomKeywords.'androidCommonKeywords.commonMethods.takeUserFromHomeToInventoryListingScreen'()

'output of random string generator is stored in inventoryName which will be passed into createInventory function'
inventoryName = CustomKeywords.'common.commonMethods.randomStringGenerator'(inventoryNameLength)

'creates an inventory by taking inventoryName as the argument'
CustomKeywords.'androidInventory.inventoryListingScreen.createInventory'(inventoryName)

'ouput of random string generator is stored in locationName which will be passed into addLocation function'
locationName_1 = CustomKeywords.'common.commonMethods.randomStringGenerator'(locationNameLength)

'adds location in location details page and takes locationName as the argument'
CustomKeywords.'androidInventory.inventoryDetailsScreen.addLocation'(locationName_1, costType_1)

'opens the location details and takes the locationName as the argument'
CustomKeywords.'androidInventory.inventoryDetailsScreen.clickOnLocation'(locationName_1)

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
productNDC = requestObject[GlobalVariable.Environment].TC_R_046.productSearchByNDC

'pushing the ndc of the product to be searched into the stack'
ndcNumbersStack.push(productNDC)

'taps on scan icon and takes user to scanning product screen and also verifies that the default toggle is at full count'
CustomKeywords.'androidInventory.locationDetailsScreen.clickOnScanIcon'()

'calling the function which scans the product'
CustomKeywords.'androidInventory.locationDetailsScreen.scanInputEvent'(productSearch)

'calling the function which adds the product to the location'
CustomKeywords.'androidInventory.locationDetailsScreen.addProducToLocation'()

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.pressBacknav'()

'waits for 5(s) to load the content'
WebUI.delay(5)

'taps on scan icon and takes user to scanning product screen and also verifies that the default toggle is at full count'
CustomKeywords.'androidInventory.locationDetailsScreen.clickOnScanIcon'()

'calling the function which selects the countType required for a product which is searched and takes countType as the argument'
CustomKeywords.'androidInventory.locationDetailsScreen.selectCountTypeForTheProductToBeAdded'(countType_1)

'calling the function which scans the product'
CustomKeywords.'androidInventory.locationDetailsScreen.scanInputEvent'(productSearch)

'calling the function which adds the product to the location'
CustomKeywords.'androidInventory.locationDetailsScreen.addProducToLocation'()


'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.pressBacknav'()

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.pressBacknav'()

'ouput of random string generator is stored in locationName which will be passed into add_Location function'
locationName_2 = CustomKeywords.'common.commonMethods.randomStringGenerator'(locationNameLength)

'adds location in location details page and takes locationName as the argument'
CustomKeywords.'androidInventory.inventoryDetailsScreen.addLocation'(locationName_2, costType_2)

'opens the location details and takes the locationName as the argument'
CustomKeywords.'androidInventory.inventoryDetailsScreen.clickOnALocation'(locationName_2)

'taps on scan icon and takes user to scanning product screen and also verifies that the default toggle is at full count'
CustomKeywords.'androidInventory.locationDetailsScreen.clickOnScanIcon'()

'calling the function which scans the product'
CustomKeywords.'androidInventory.locationDetailsScreen.scanInputEvent'(productSearch)

'calling the function which adds the product to the location'
CustomKeywords.'androidInventory.locationDetailsScreen.addProducToLocation'()

'calling the function which gets the unit of issue cost(UOI) of the added product'
float uoiCost = CustomKeywords.'androidInventory.locationDetailsScreen.returnUOIOfTheAddedProduct'()

'pushing the uoiCost of the product to be searched into the stack'
unitOfIssueCostStack.push(uoiCost)

'pushing the countType of the product to be searched into the stack'
countTypeStack.push(countType_1)

'pushing the quantity of the product to be added into the stack'
quantityStack.push(quantity_1)

'pushing the ndc of the product to be searched into the stack'
ndcNumbersStack.push(productNDC)

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.pressBacknav'()

'waits for 5(s) to load the content'
WebUI.delay(5)

'taps on scan icon and takes user to scanning product screen and also verifies that the default toggle is at full count'
CustomKeywords.'androidInventory.locationDetailsScreen.clickOnScanIcon'()

'calling the function which selects the countType required for a product which is searched and takes countType as the argument'
CustomKeywords.'androidInventory.locationDetailsScreen.selectCountTypeForTheProductToBeAdded'(countType_1)

'calling the function which scans the product and adds it to the location, it takes productName/UPC/Cin/Ndc as the argument'
CustomKeywords.'androidInventory.locationDetailsScreen.scanInputEvent'(productSearch)

'calling the function which adds the product to the location'
CustomKeywords.'androidInventory.locationDetailsScreen.addProducToLocation'()

'calling the function which gets the unit of issue cost(UOI) of the added product'
uoiCost = CustomKeywords.'androidInventory.locationDetailsScreen.returnUOIOfTheAddedProduct'()

'pushing the uoiCost of the product to be searched into the stack'
unitOfIssueCostStack.push(uoiCost)

'pushing the countType of the product to be searched into the stack'
countTypeStack.push(countType_2)

'pushing the total quantity of the product which should be there after is moved to another location'
quantityStack.push(quantity_2)

'pushing the ndc of the product to be searched into the stack'
ndcNumbersStack.push(productNDC)

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.pressBacknav'()

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.pressBacknav'()

'opens the location details and takes the locationName as the argument'
CustomKeywords.'androidInventory.inventoryDetailsScreen.clickOnALocation'(locationName_1)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'calling the function which copies a product to another location, it takes location and productName/UPC/Cin/Ndc as the argument'
CustomKeywords.'androidInventory.locationDetailsScreen.copyProductToAnotherLocation'(locationName_2, productNDC)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'calling the function which gets the count type of the added product and verifies whether that is equal to the expected count type which will be passed as an argument'
CustomKeywords.'androidInventory.locationDetailsScreen.verifyCountTypeOfProduct'(countType_1)

'this function gets the total added quantity of the product that is visible on the screen'
int actualQuantity = CustomKeywords.'androidInventory.locationDetailsScreen.returnQuantityOfTheAddedProduct'()

//'assertion to verify actual quanity equals the expected quantity'
//assert actualQuantity == expectedProductQuantity_1

'this function verifies that the product is visible on the location details screen'
CustomKeywords.'androidInventory.locationDetailsScreen.verifyProductIsVisibleOnTheLocationDetailsScreen'(productNDC)

//'calling the function which deletes a product, it takes productName/UPC/Cin/Ndc as the argument'
//CustomKeywords.'androidInventory.locationDetailsScreen.deleteProduct'(productNDC)

'calling the function which moves a product to another location, it takes location and productName/UPC/Cin/Ndc as the argument'
CustomKeywords.'androidInventory.locationDetailsScreen.moveProductToAnotherLocation'(locationName_1, productNDC)

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'this function gets the total added quantity of the product that is visible on the screen'
actualQuantity = CustomKeywords.'androidInventory.locationDetailsScreen.returnQuantityOfTheAddedProduct'()

'assertion to verify actual quanity equals the expected quantity'
actualQuantity == expectedProductQuantity_2

'function gets the count type of the added product and verifies whether that is equal to the expected count type which will be passed as an argument'
CustomKeywords.'androidInventory.locationDetailsScreen.verifyCountTypeOfProduct'(countType_2)

'this function verifies that the product is visible on the location details screen'
CustomKeywords.'androidInventory.locationDetailsScreen.verifyProductIsVisibleOnTheLocationDetailsScreen'(productNDC)

//'verifies location details Screen elements like countype of product added, quantity, invenntory cost on location details screen'
//CustomKeywords.'androidInventory.locationDetailsScreen.verifyLocationDetailsScreen'(countTypeStack, quantityStack, ndcNumbersStack,
//	unitOfIssueCostStack)

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.pressBacknav'()

'deletes the location and takes locationName as the argument'
CustomKeywords.'androidInventory.inventoryDetailsScreen.deleteLocation'(locationName_2)

'deletes the location and takes locationName as the argument'
CustomKeywords.'androidInventory.inventoryDetailsScreen.deleteLocation'(locationName_1)

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.pressBacknav'()

'deletes the inventory and takes inventoryName as the argument'
CustomKeywords.'androidInventory.inventoryListingScreen.deleteInventory'(inventoryName)