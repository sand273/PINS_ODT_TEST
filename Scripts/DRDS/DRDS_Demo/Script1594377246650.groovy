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
import org.apache.commons.io.FileUtils;

def verData = TestDataFactory.findTestData('Data Files/DRDS_Case_Details')

int iCount
int iVal
int iRow
int iCases

String fileName
String newCase
String[] cmdArray = new String[2];
String[] baseVal

iRow = verData.getRowNumbers()
cmdArray[0] = GlobalVariable.UploadFilePath + "DRDS_Appeal_Decision"

String path=GlobalVariable.UploadFilePath + "\\DRDS"
File directory = new File(path)

FileUtils.cleanDirectory(directory);

try
{
	for (iCases=1; iCases<=iRow; iCases++) // Iterate all rows from Appeals Excel file
	{
		cmdArray[1] = verData.getValue(1, iCases).trim()
		
		WebUI.delay(2)
		
		Runtime.runtime.exec(cmdArray) //Execute the AutoIT script

		fileName = GlobalVariable.UploadFilePath + 'DRDS\\' + verData.getValue(1, iCases).trim() + '.txt'
		
		WebUI.delay(32)

		newCase = CustomKeywords.'custom.WriteExcel.readFileInList'(fileName) //Read text file contents

		baseVal = newCase.split(',')
		
		for (iVal=2; iVal<=14; iVal++) // Iterate all columns from Appeals Excel file
		{
			if (verData.getValue(iVal, iCases).trim()!='NA')
			{
				for(iCount = 1; iCount<baseVal.size(); iCount++) {
					if (verData.getValue(iVal, iCases).trim() == baseVal[iCount].trim()) {
						KeywordUtil.markPassed("Verification Match: " + baseVal[iCount].toString())
						break;
					}
					else if ((baseVal.size()-iCount) == 1)
					{					 
						KeywordUtil.markFailed("Verification Failed " + "Value Mismatch: " + verData.getValue(iVal, iCases).trim())
					}
				}		
			}
		}	
	}
}
catch (Exception ex) {
		KeywordUtil.logInfo("Exception encountered in DRDS Keyword Test")
}
	
	