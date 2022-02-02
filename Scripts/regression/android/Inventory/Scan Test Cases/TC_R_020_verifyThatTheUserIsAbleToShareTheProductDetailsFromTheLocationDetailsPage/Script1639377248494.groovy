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

'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'selects the user account from the accounts list'
CustomKeywords.'androidAccountSelection.selectAnAccount.selectTheUserAccount'(GlobalVariable.Account)

'waits for 10(s) before refreshing the page to get the updated historyCount'
*/
'waits until the progressBar is visible on the screen'
CustomKeywords.'androidCommonKeywords.commonMethods.waitForProgressBarToBeInvisible'()

'takes user from home screen to inventory listing screen'
CustomKeywords.'androidCommonKeywords.commonMethods.takeUserFromHomeToInventoryListingScreen'()

'output of random string generator is stored in inventoryName which will be passed into createInventory function'
inventoryName = CustomKeywords.'common.commonMethods.randomStringGenerator'(inventoryNameLength)

'creates an inventory by taking inventoryName as the argument'
CustomKeywords.'androidInventory.inventoryListingScreen.createInventory'(inventoryName)

'ouput of random string generator is stored in locationName which will be passed into addLocation function'
locationName = CustomKeywords.'common.commonMethods.randomStringGenerator'(locationNameLength)

'adds location in location details page and takes locationName as the argument'
CustomKeywords.'androidInventory.inventoryDetailsScreen.addLocation'(locationName, costType)

'opens the location details and takes the locationName as the argument'
CustomKeywords.'androidInventory.inventoryDetailsScreen.clickOnLocation'(locationName)

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

'declaring stack for storing unit of issue costs of the product needs to be added'
Stack<String> unitOfIssueCostStack = new Stack<String>()

'pushing the ndc of the product to be searched into the stack'
ndcNumbersStack.push(productSearch)

'taps on scan icon and takes user to scanning product screen and also verifies that the default toggle is at full count'
CustomKeywords.'androidInventory.locationDetailsScreen.clickOnScanIcon'()

'calling the function which selects the countType required for a product which is searched and takes countType as the argument'
CustomKeywords.'androidInventory.locationDetailsScreen.selectCountTypeForTheProductToBeAdded'(countType_1)

'calling the function which scans the product and adds it to the location, it takes productName/UPC/Cin/Ndc as the argument'
CustomKeywords.'androidInventory.locationDetailsScreen.scanInputEvent'(productSearch)

'calling the function which adds quantity required for a product to be added and takes quantity required as the argument'
CustomKeywords.'androidInventory.locationDetailsScreen.addQuantityforTheSearchedProduct'(quantity)

'calling the function which adds quantity required for a product to be added and takes quantity required as the argument'
float uoiCost = CustomKeywords.'androidInventory.locationDetailsScreen.returnUOIOfTheAddedProduct'()

'pushing the uoiCost of the product to be searched into the stack'
unitOfIssueCostStack.push(uoiCost)

'pushing the countType of the product to be searched into the stack'
countTypeStack.push(countType_1)

'pushing the quantity of the product to be added into the stack'
quantityStack.push(quantity)

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'waits for 10(s) to load data'
WebUI.delay(10)

'reading the ndcNumber of product to be added'
productSearch = requestObject[GlobalVariable.Environment].TC_R_020.productSearchByNDC1

'pushing the ndc of the product to be searched into the stack'
ndcNumbersStack.push(productSearch)

'taps on scan icon and takes user to scanning product screen and also verifies that the default toggle is at full count'
CustomKeywords.'androidInventory.locationDetailsScreen.clickOnScanIcon'()

'calling the function which selects the countType required for a product which is searched and takes countType as the argument'
CustomKeywords.'androidInventory.locationDetailsScreen.selectCountTypeForTheProductToBeAdded'(countType_2)

'calling the function which scans the product and adds it to the location, it takes productName/UPC/Cin/Ndc as the argument'
CustomKeywords.'androidInventory.locationDetailsScreen.scanInputEvent'(productSearch)

'waits for 10(s) for scanned product to be display'
WebUI.delay(10)

'calling the function which adds quantity required for a product to be added and takes quantity required as the argument'
CustomKeywords.'androidInventory.locationDetailsScreen.addQuantityforTheSearchedProduct'(quantity)

'calling the function which adds quantity required for a product to be added and takes quantity required as the argument'
uoiCost = CustomKeywords.'androidInventory.locationDetailsScreen.returnUOIOfTheAddedProduct'()

'pushing the uoiCost of the product to be searched into the stack'
unitOfIssueCostStack.push(uoiCost)

'pushing the countType of the product to be searched into the stack'
countTypeStack.push(countType_2)

'pushing the quantity of the product to be added into the stack'
quantityStack.push(quantity)

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.goOneScreenBack'()

'clicks on share location button and verifies the pop-up screen and then closes the pop-up screen'
CustomKeywords.'androidInventory.locationDetailsScreen.verifyGmailOnShareLocation'()

'verifies location details Screen elements like linesCount, countype of product added, quantity on location details screen'
CustomKeywords.'androidInventory.locationDetailsScreen.verifyLocationDetailsScreen'(countTypeStack, quantityStack, ndcNumbersStack,
	unitOfIssueCostStack)

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.pressBacknav'()

'deletes the location and takes locationName as the argument'
CustomKeywords.'androidInventory.inventoryDetailsScreen.deleteLocation'(locationName)

'takes the application one screen back'
CustomKeywords.'androidCommonKeywords.commonMethods.pressBacknav'()

'deletes the inventory and takes inventoryName as the argument'
CustomKeywords.'androidInventory.inventoryListingScreen.deleteInventory'(inventoryName)