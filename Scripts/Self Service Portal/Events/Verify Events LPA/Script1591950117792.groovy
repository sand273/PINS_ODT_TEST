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
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.configuration.RunConfiguration as RC

String executionProfile = RC.getExecutionProfile()

String expTableLPA

Date today = new Date()

String todaysDate = today.format('dd.MM.yyyy')

if (GlobalVariable.callTest == 'Auto-Validate')
{
	expTableLPA = todaysDate + ',Final Comments,' + todaysDate + ',Test_Final_Document,' + todaysDate + ',LPA Statement,' + todaysDate + ',Sandeep Ramchandani Interested Party Correspondence,' + 
		todaysDate + ',Complete_Statement,' + todaysDate + ',Start Notice LPA (Written Reps),' + todaysDate + ',Upload_Pdf,' + 
		todaysDate + ',Upload_Pdf,' + todaysDate + ',Upload_Pdf,' + todaysDate + ',Upload_Document,' + todaysDate + ',Appeal a planning decision'
}

def verData = TestDataFactory.findTestData('Data Files/Complete_Questionaire')

if (executionProfile == 'pre-prod')
{
	WebUI.callTestCase(findTestCase('Self Service Portal/Login/LPA User-Pre-prod'), [:], FailureHandling.STOP_ON_FAILURE)
}
else if (executionProfile == 'default')
{
	WebUI.callTestCase(findTestCase('Self Service Portal/Login/LPA User'), [:], FailureHandling.STOP_ON_FAILURE)
}

WebUI.click(findTestObject('Complete Questionaire/link_Search'))

WebUI.setText(findTestObject('Complete Questionaire/text_Appeal_Ref'), GlobalVariable.ApplicationRef)

WebUI.click(findTestObject('Complete Questionaire/button_Search'))

WebUI.waitForElementVisible(findTestObject('Submit Statement/label_Match_Found'), 5)

WebUI.click(findTestObject('Complete Questionaire/link_Appeal_Ref'))

WebUI.waitForElementVisible(findTestObject('Final Comments/status_Event'), 5)

WebUI.verifyElementText(findTestObject('Submit Statement/title_Appeal_Reference'), GlobalVariable.ApplicationRef)

WebUI.verifyElementText(findTestObject('Submit Statement/text_Case_Number'), GlobalVariable.ApplicationRef)

if (GlobalVariable.caseType == 'Written')
{
	WebUI.verifyElementVisible(findTestObject('Submit Statement/text_Written_Rep'))
}
else if (GlobalVariable.callTest == 'Hearing')
{
	WebUI.verifyElementVisible(findTestObject('Submit Statement/text_Hearing'))
}


WebUI.verifyElementVisible(findTestObject('Submit Statement/status_Appeal_Started'))

WebUI.verifyElementText(findTestObject('Submit Statement/text_Appellant_Name'), verData.getValue(1, 16))

if (GlobalVariable.callTest == 'Auto-Validate')
{
	CustomKeywords.'custom.VerifyTable.verifyValues'('Complete Questionaire/table_Documents', expTableLPA)
}
else if (GlobalVariable.callTest == 'Written')
{
	CustomKeywords.'custom.VerifyTable.verifyTableCount'('Complete Questionaire/table_Documents', '42')
}
else if (GlobalVariable.callTest == 'Hearing')
{
	CustomKeywords.'custom.VerifyTable.verifyTableCount'('Complete Questionaire/table_Documents', '22')
}
else if (GlobalVariable.callTest == 'Hearing-HAS' || GlobalVariable.callTest == 'Written-HAS')
{
	CustomKeywords.'custom.VerifyTable.verifyTableCount'('Complete Questionaire/table_Documents', '10')
}

WebUI.closeBrowser()

