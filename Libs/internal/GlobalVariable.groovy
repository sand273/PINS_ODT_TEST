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
    public static Object URL
     
    /**
     * <p></p>
     */
    public static Object element_timeout
     
    /**
     * <p></p>
     */
    public static Object UploadFilePath
     
    /**
     * <p></p>
     */
    public static Object ApplicationRef
     
    /**
     * <p></p>
     */
    public static Object driverCount
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += RunConfiguration.getOverridingParameters()
    
            URL = selectedVariables['URL']
            element_timeout = selectedVariables['element_timeout']
            UploadFilePath = selectedVariables['UploadFilePath']
            ApplicationRef = selectedVariables['ApplicationRef']
            driverCount = selectedVariables['driverCount']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
