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

Date today = new Date()

String todaysDate = today.format('dd.MM.yyyy')
String expTableAppellant

if (GlobalVariable.callTest == 'Written')
{
	expTableAppellant = todaysDate + ',LPA Questionnaire,' + todaysDate + ',Upload_Pdf,' + todaysDate + ',Start Notice Appellant (Written Reps),' + todaysDate + ',Upload_Pdf,' + todaysDate +
	',Upload_PNG,' + todaysDate + ',Upload_Document,' + todaysDate + ',Upload_Jpeg,' + todaysDate + ',Upload_Tiff,' + todaysDate + ',Upload_Tiff,' + todaysDate + ',Upload_Jpeg,' + todaysDate + ',Upload_Pdf,' + todaysDate + ',Upload_PNG,' + todaysDate + ',Upload_Document,' + todaysDate + ',Upload_Tiff,' + todaysDate + ',Upload_Document,' +  todaysDate + ',Upload_Pdf,' + todaysDate + ',Upload_PNG,' + todaysDate + ',Upload_Jpeg,' + todaysDate + ',Upload_Pdf,' + todaysDate + ',Upload_Document,' + todaysDate + ',Upload_Document,' + todaysDate + ',Upload_Jpeg,'+ todaysDate + ',Upload_PNG,' + todaysDate + ',Upload_Pdf,' + todaysDate + ',Upload_Tiff,' + todaysDate + ',Upload_Document,' + todaysDate + ',Upload_PNG,' + todaysDate + ',Upload_Jpeg,' + todaysDate + ',Upload_Pdf,' + todaysDate + ',Upload_Tiff,' + todaysDate + ',Upload_Tiff,' + todaysDate + ',Upload_Jpeg,'+ todaysDate + ',Upload_Document,'+ todaysDate + ',Upload_PNG,'+ todaysDate + ',Upload_Pdf,' + todaysDate + ',Upload_Pdf,'+ todaysDate + ',Upload_Pdf,'+ todaysDate + ',Upload_Document,'+ ',Appeal a planning decision'

}
else if (GlobalVariable.callTest == 'Auto-Validate')
{

	expTableAppellant = todaysDate + ',LPA Questionnaire,' + todaysDate + ',Upload_Pdf,' + todaysDate + ',Start Notice Appellant (Written Reps),' + todaysDate + ',Upload_Pdf,' + todaysDate + ',Upload_Pdf,' + todaysDate + ',Upload_Pdf,' + todaysDate + ',Upload_Document,' + todaysDate + ',Appeal a planning decision'
}

def verData = TestDataFactory.findTestData('Data Files/Complete_Questionaire')

WebUI.callTestCase(findTestCase('Self Service Portal/Login/Case Officer'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Complete Questionaire/link_Search'))

WebUI.setText(findTestObject('Complete Questionaire/text_Appeal_Ref'), GlobalVariable.ApplicationRef)

WebUI.click(findTestObject('Complete Questionaire/button_Search'))

WebUI.waitForElementVisible(findTestObject('Submit Statement/label_Match_Found'), 5)

WebUI.click(findTestObject('Complete Questionaire/link_Appeal_Ref'))

WebUI.waitForElementVisible(findTestObject('Submit Statement/status_Appellant'), 5)

WebUI.verifyElementText(findTestObject('Submit Statement/status_Appellant'), verData.getValue(1, 17))

WebUI.verifyElementText(findTestObject('Submit Statement/title_Appeal_Reference'), GlobalVariable.ApplicationRef)

WebUI.verifyElementText(findTestObject('Submit Statement/text_Case_Number'), GlobalVariable.ApplicationRef)

WebUI.verifyElementVisible(findTestObject('Submit Statement/text_Written_Rep'))

WebUI.verifyElementVisible(findTestObject('Submit Statement/status_Appeal_Started'))

WebUI.verifyElementText(findTestObject('Submit Statement/text_Appellant_Name'), verData.getValue(1, 16))

CustomKeywords.'custom.VerifyTable.verifyValues'('Complete Questionaire/table_Documents', expTableAppellant)

//WebUI.closeBrowser()
