package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object Username
     
    /**
     * <p></p>
     */
    public static Object Password
     
    /**
     * <p></p>
     */
    public static Object Account
     
    /**
     * <p></p>
     */
    public static Object Environment
     
    /**
     * <p></p>
     */
    public static Object Android_App_Path
     
    /**
     * <p></p>
     */
    public static Object iOS_App_Path
     
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
            Android_App_Path = selectedVariables['Android_App_Path']
            iOS_App_Path = selectedVariables['iOS_App_Path']
            a = selectedVariables['a']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
