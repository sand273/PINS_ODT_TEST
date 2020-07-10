import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.configuration.RunConfiguration as RC
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory

def verData = TestDataFactory.findTestData('Data Files/DRDS_Case_Details')

int iCount
int iVal

String[] cmdArray = new String[2];

cmdArray[0] = GlobalVariable.UploadFilePath + "DRDS_Appeal_Decision"
cmdArray[1] = verData.getValue(1, 1).trim()

Runtime.runtime.exec(cmdArray)

String fileName = 'C:\\Katalon\\' + verData.getValue(1, 1).trim() + '.txt'

WebUI.delay(30)

String newCase = CustomKeywords.'custom.WriteExcel.readFileInList'(fileName)

String[] baseVal = newCase.split(',')
		
	try {
		for (iVal=2; iVal<=14; iVal++)
		{
			for(iCount = 1; iCount<baseVal.size(); iCount++) {
				if (verData.getValue(iVal, 1).trim() == baseVal[iCount].trim()) {
					KeywordUtil.markPassed("Verification Match: " + baseVal[iCount].toString())
					break;
				}
				else if ((baseVal.size()-iCount) == 1)
				{
					KeywordUtil.markFailed("Verification Failed " + "Value Mismatch: " + verData.getValue(iVal, 1).trim())
				}
			}
		}	
	}
	catch (Exception ex) {
		KeywordUtil.logInfo("Exception encountered in Custom Keyword")
	}
	
	