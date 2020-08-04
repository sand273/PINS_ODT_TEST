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
     
    /**
     * <p></p>
     */
    public static Object AdminUrl
     
    /**
     * <p></p>
     */
    public static Object planOption
     
    /**
     * <p></p>
     */
    public static Object TestCaseStatus
     
    /**
     * <p></p>
     */
    public static Object caseType
     
    /**
     * <p></p>
     */
    public static Object callTest
     
    /**
     * <p></p>
     */
    public static Object caseSubType
     
    /**
     * <p></p>
     */
    public static Object FindCouncil
     

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
            AdminUrl = selectedVariables['AdminUrl']
            planOption = selectedVariables['planOption']
            TestCaseStatus = selectedVariables['TestCaseStatus']
            caseType = selectedVariables['caseType']
            callTest = selectedVariables['callTest']
            caseSubType = selectedVariables['caseSubType']
            FindCouncil = selectedVariables['FindCouncil']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
