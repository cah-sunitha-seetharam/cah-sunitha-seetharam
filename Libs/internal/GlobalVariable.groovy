package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p>Profile Release : username is taken from the profiles and passed as a parameter in the logIn function
Profile Stage : username is taken from the profiles and passed as a parameter in the logIn function
Profile StageMock : username is taken from the profiles and passed as a parameter in the logIn function</p>
     */
    public static Object Username
     
    /**
     * <p>Profile Release : password is taken from the profiles and passed as a parameter in the logIn function
Profile Stage : password is taken from the profiles and passed as a parameter in the logIn function
Profile StageMock : password is taken from the profiles and passed as a parameter in the logIn function</p>
     */
    public static Object Password
     
    /**
     * <p>Profile Release : user account is taken from the profiles and passed as a parameter in the account selection screen
Profile Stage : user account is taken from the profiles and passed as a parameter in the account selection screen
Profile StageMock : user account is taken from the profiles and passed as a parameter in the account selection screen</p>
     */
    public static Object Account
     
    /**
     * <p>Profile Release : environment of testing is taken from profiles and used in the environment selection screen
Profile Stage : environment of testing is taken from profiles and used in the environment selection screen
Profile StageMock : environment of testing is taken from profiles and used in the environment selection screen</p>
     */
    public static Object Environment
     
    /**
     * <p>Profile Release : android application path is taken from the profiles and used in the start application under android common methods
Profile Stage : android application path is taken from the profiles and used in the start application under android common methods
Profile StageMock : android application path is taken from the profiles and used in the start application under android common methods</p>
     */
    public static Object AndroidAppPath
     
    /**
     * <p>Profile Release : iOS application path is taken from the profiles and used in the start application under android common methods
Profile Stage : iOS application path is taken from the profiles and used in the start application under android common methods
Profile StageMock : iOS application path is taken from the profiles and used in the start application under android common methods</p>
     */
    public static Object iOSAppPath
     
    /**
     * <p></p>
     */
    public static Object SmSession
     
    /**
     * <p></p>
     */
    public static Object accessToken
     
    /**
     * <p>Profile Release : Android activity that we want to wait for while opening the app
Profile Stage : Android activity that we want to wait for while opening the app
Profile StageMock : Android activity that we want to wait for while opening the app</p>
     */
    public static Object appWaitActivity
     
    /**
     * <p>Profile Release : Package value of the Android app that we need to run
Profile Stage : Package value of the Android app that we need to run
Profile StageMock : Package value of the Android app that we need to run</p>
     */
    public static Object appPackage
     
    /**
     * <p>Profile Release : bundle id for iOS application
Profile Stage : bundle id for iOS application
Profile StageMock : bundle id for iOS application</p>
     */
    public static Object bundleID
     
    /**
     * <p>Profile Release : change this to order (strictly follow the name), if test suite under execution is of orders module </p>
     */
    public static Object testSuiteModule
     
    /**
     * <p>Profile Release : if Android app is already installed then set this to true else false
Profile Stage : if Android app is already installed then set this to true else false
Profile StageMock : if Android app is already installed then set this to true else false</p>
     */
    public static Object isAndroidAppInstalled
     
    /**
     * <p>Profile Release : if iOS app is already installed then set this to true else false
Profile Stage : if iOS app is already installed then set this to true else false
Profile StageMock : if iOS app is already installed then set this to true else false</p>
     */
    public static Object isIosAppInstalled
     
    /**
     * <p></p>
     */
    public static Object a
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += TestCaseMain.getParsedValues(RunConfiguration.getOverridingParameters())
    
            Username = selectedVariables['Username']
            Password = selectedVariables['Password']
            Account = selectedVariables['Account']
            Environment = selectedVariables['Environment']
            AndroidAppPath = selectedVariables['AndroidAppPath']
            iOSAppPath = selectedVariables['iOSAppPath']
            SmSession = selectedVariables['SmSession']
            accessToken = selectedVariables['accessToken']
            appWaitActivity = selectedVariables['appWaitActivity']
            appPackage = selectedVariables['appPackage']
            bundleID = selectedVariables['bundleID']
            testSuiteModule = selectedVariables['testSuiteModule']
            isAndroidAppInstalled = selectedVariables['isAndroidAppInstalled']
            isIosAppInstalled = selectedVariables['isIosAppInstalled']
            a = selectedVariables['a']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
