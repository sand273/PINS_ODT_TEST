package custom

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.util.KeywordUtil
import internal.GlobalVariable

public class VerifyTable {

	@Keyword
	public void verifyValues(String tableObj, String expTable) {

		String rowText
		int iCount

		WebUI.waitForElementVisible(findTestObject(tableObj), 10)

		rowText = WebUI.getAttribute(findTestObject(tableObj),'innerText')

		String[] testSplit = rowText.split('	')
		String[] baseVal = expTable.split(',')

		try {
			for(iCount = 0; iCount<testSplit.size(); iCount++) {
				if (testSplit[iCount].trim() == baseVal[iCount].trim()) {
					KeywordUtil.markPassed("Table verification match: " + testSplit[iCount].toString())
				}
				else {
					KeywordUtil.markFailed("Table value mismtach: " + "Actual: " + testSplit[iCount].toString() + " Expected: " + baseVal[iCount].toString())
				}
			}
		}
		catch (Exception ex) {
			KeywordUtil.logInfo("Exception encountered in Custom Keyword verifyValues")
		}
	}


	@Keyword
	public void verifyTableCount(String tableObj, String expCount) {

		String rowCount

		WebUI.waitForElementVisible(findTestObject(tableObj), 10)

		rowCount = WebUI.getAttribute(findTestObject(tableObj),'childElementCount').toString()

		if (expCount == rowCount) {
			KeywordUtil.markPassed("Table rows count match: " + expCount.toString())
		}
		else {
			KeywordUtil.markFailed("Table rows count mismtach: " + "Actual: " + rowCount.toString() + " Expected: " + expCount.toString())
		}
	}
}
