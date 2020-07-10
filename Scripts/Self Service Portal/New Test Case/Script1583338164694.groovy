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

String fileName = 'C:\\Katalon\\Test_Case123.txt'


public List<String> readFileInList(String fileName) {
		List<String> lines = Collections.emptyList();
		try {
			lines = Files.readAllLines(Paths.get(fileName), Charset.defaultCharset());
			//lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.ISO_8859_1);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}

	
	/*public static void testCharset(String fileName) {
		SortedMap<String, Charset> charsets = Charset.availableCharsets();
		for (String k : charsets.keySet()) {
			int line = 0;
			boolean success = true;
			try (BufferedReader b = Files.newBufferedReader(Paths.get(fileName), charsets.get(k))) {
				while (b.ready()) {
					b.readLine();
					line++;
				}
			} catch (IOException e) {
				success = false;
				System.out.println(k+" failed on line "+line);
			}
			if (success)
				System.out.println("*************************  Successs "+k);
		}
	}*/
	
	String newCase = readFileInList(fileName).toString()

	String[] baseVal = newCase.split(',')
		
	try {
		for (iVal=1; iVal<=12; iVal++)
		{
			for(iCount = 1; iCount<=baseVal.size(); iCount++) {
				if (verData.getValue(iVal, 1).trim() == baseVal[iCount].trim()) {
					KeywordUtil.markPassed("Verification match: " + baseVal[iCount].toString())
					break;
				}
				else if (iCount == baseVal.size())
				{
					KeywordUtil.markFailed("Verification Failed: " + "Actual: " + baseVal[iCount].trim() + " Expected: " + verData.getValue(iVal, 1).trim())
				}
			}
		}	
	}
	catch (Exception ex) {
		KeywordUtil.logInfo("Exception encountered in Custom Keyword")
	}
	
	