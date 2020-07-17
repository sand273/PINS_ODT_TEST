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
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.configuration.RunConfiguration as RC

String executionProfile = RC.getExecutionProfile()

String queRefMessage

def verData = TestDataFactory.findTestData('Data Files/Complete_Questionaire')

if (executionProfile == 'pre-prod') {
    WebUI.callTestCase(findTestCase('Self Service Portal/Login/LPA User-Pre-prod'), [:], FailureHandling.STOP_ON_FAILURE)
} else if (executionProfile == 'default') {
    WebUI.callTestCase(findTestCase('Self Service Portal/Login/LPA User'), [:], FailureHandling.STOP_ON_FAILURE)
}

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Search Appeal'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Submit Statement/title_Appeal_Reference'), GlobalVariable.ApplicationRef)

WebUI.verifyElementText(findTestObject('Submit Statement/text_Case_Number'), GlobalVariable.ApplicationRef)

if (GlobalVariable.caseType == 'Written') {
    WebUI.verifyElementVisible(findTestObject('Submit Statement/text_Written_Rep'))
} else if (GlobalVariable.callTest == 'Hearing') {
    WebUI.verifyElementVisible(findTestObject('Submit Statement/text_Hearing'))
}

WebUI.verifyElementVisible(findTestObject('Submit Statement/status_Appeal_Started'))

WebUI.verifyElementText(findTestObject('Submit Statement/text_Appellant_Name'), verData.getValue(1, 16))

WebUI.waitForElementVisible(findTestObject('Complete Questionaire/button_Complete questionnaire'), 5)

WebUI.click(findTestObject('Complete Questionaire/button_Complete questionnaire'))

WebUI.waitForElementVisible(findTestObject('Complete Questionaire/button_Start now'), 5)

WebUI.click(findTestObject('Complete Questionaire/button_Start now'))

WebUI.waitForElementVisible(findTestObject('Complete Questionaire/question_Appeal_Info'), 5)

WebUI.verifyElementText(findTestObject('Complete Questionaire/question_Appeal_Info'), verData.getValue(1, 2))

WebUI.verifyElementVisible(findTestObject('Complete Questionaire/title_Appeal_Sections'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Complete Questionaire/list_Appeal_Sections'), verData.getValue(1, 18))

WebUI.click(findTestObject('Complete Questionaire/input_Yes_Option'))

WebUI.click(findTestObject('Complete Questionaire/button_Next_Page'))

WebUI.waitForElementVisible(findTestObject('Complete Questionaire/button_Appeal_Follow_Next'), 5)

WebUI.click(findTestObject('Complete Questionaire/option_Refusal_Consent'))

WebUI.click(findTestObject('Complete Questionaire/button_Appeal_Follow_Next'))

WebUI.waitForElementVisible(findTestObject('Complete Questionaire/question_Appeal_Procedure'), 5)

WebUI.click(findTestObject('Complete Questionaire/input_Yes_Appeal_Procedure'))

WebUI.click(findTestObject('Complete Questionaire/button_AppealProc_Next_page'))

WebUI.waitForElementVisible(findTestObject('Complete Questionaire/question_Upload_Policies'), 5)

WebUI.verifyElementText(findTestObject('Complete Questionaire/question_Upload_Policies'), verData.getValue(1, 4))

WebUI.click(findTestObject('Complete Questionaire/button_LocalPolicy_Next_page'))

WebUI.waitForElementVisible(findTestObject('Complete Questionaire/button_Emerging_Next_page'), 5)

WebUI.click(findTestObject('Complete Questionaire/input_Yes_EmergingPolicies'))

WebUI.click(findTestObject('Complete Questionaire/button_Emerging_Next_page'))

WebUI.waitForElementVisible(findTestObject('Complete Questionaire/button_Conditions_Next_HAS'), 5)

WebUI.click(findTestObject('Complete Questionaire/input_Yes_ConditionsSuggestions'))

WebUI.click(findTestObject('Complete Questionaire/input_Yes_ConditionsObligation'))

WebUI.click(findTestObject('Complete Questionaire/button_Conditions_Next_HAS'))

WebUI.waitForElementVisible(findTestObject('Complete Questionaire/button_Conditions_Next_Page'), 5)

WebUI.click(findTestObject('Complete Questionaire/input_Yes_ConservationSite'))

WebUI.click(findTestObject('Complete Questionaire/button_Conditions_Next_Page'))

WebUI.waitForElementVisible(findTestObject('Complete Questionaire/button_Conservative_Next_Page'), 5)

WebUI.click(findTestObject('Complete Questionaire/input_Yes_BuildingAffects'))

WebUI.click(findTestObject('Complete Questionaire/input_Yes_BuildingAffectScheduleMonument'))

WebUI.click(findTestObject('Complete Questionaire/button_Monuments_Next_HAS'))

WebUI.waitForElementVisible(findTestObject('Complete Questionaire/button_Screening_Next_HAS'), 5)

WebUI.click(findTestObject('Complete Questionaire/input_Yes_ScreeningOpinion'))

WebUI.click(findTestObject('Complete Questionaire/button_Screening_Next_HAS'))

WebUI.waitForElementVisible(findTestObject('Complete Questionaire/message_Upload_Planning'), 5)

WebUI.click(findTestObject('Complete Questionaire/button_Select_File'))

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Upload File'), [('exeFileName') : 'Pdf_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('Complete Questionaire/button_Planning_Next_Page'), 5)

WebUI.click(findTestObject('Complete Questionaire/button_Planning_Next_Page'))

WebUI.waitForElementVisible(findTestObject('Complete Questionaire/input_No_NotificationsActions'), 10)

WebUI.click(findTestObject('Complete Questionaire/input_No_NotificationsActions'))

WebUI.click(findTestObject('Complete Questionaire/button_Upload_File_Next'))

WebUI.waitForElementVisible(findTestObject('Complete Questionaire/button_Upload_File_Next_HAS'), 5)

WebUI.click(findTestObject('Complete Questionaire/button_Select_File_HAS'))

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Upload File'), [('exeFileName') : 'Doc_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('Complete Questionaire/button_Upload_File_Next_HAS'), 5)

WebUI.click(findTestObject('Complete Questionaire/button_Upload_File_Next_HAS'))

WebUI.waitForElementVisible(findTestObject('Complete Questionaire/button_Additional_Info_Next'), 5)

WebUI.click(findTestObject('Complete Questionaire/option_Special_Control_No'))

WebUI.click(findTestObject('Complete Questionaire/button_Additional_Info_Next'))

WebUI.waitForElementClickable(findTestObject('Complete Questionaire/button_Bulk_Upload_Next_HAS'), 5)

try {
    WebUI.click(findTestObject('Complete Questionaire/button_Bulk_Upload_Next_HAS'))
}
catch (Exception ex) {
    WebUI.refresh()

	WebUI.acceptAlert()
	
	WebUI.switchToDefaultContent()

    WebUI.waitForElementClickable(findTestObject('Complete Questionaire/button_Bulk_Upload_Next_HAS'), 20)

    WebUI.click(findTestObject('Complete Questionaire/button_Bulk_Upload_Next_HAS'))
} 

WebUI.waitForElementVisible(findTestObject('Complete Questionaire/message_Confirmation'), 5)

WebUI.click(findTestObject('Complete Questionaire/button_Submit_Confirmation'))

WebUI.waitForElementVisible(findTestObject('Complete Questionaire/message_Check_Answers'), 5)

WebUI.focus(findTestObject('Complete Questionaire/message_Check_Answers'))

WebUI.delay(1)

WebUI.scrollToPosition(9999999, 9999999)

WebUI.waitForElementClickable(findTestObject('Complete Questionaire/button_Submit_Final'), 5)

WebUI.click(findTestObject('Complete Questionaire/button_Submit_Final'))

WebUI.waitForElementVisible(findTestObject('Complete Questionaire/title_Questionaire_Received'), 10)

WebUI.verifyElementText(findTestObject('Complete Questionaire/title_Questionaire_Received'), verData.getValue(1, 5))

WebUI.verifyElementVisible(findTestObject('Complete Questionaire/message_Questionaire_Reference_Num'))

queRefMessage = WebUI.getText(findTestObject('Complete Questionaire/message_Questionaire_Reference_Num'))

WebUI.verifyMatch(queRefMessage, verData.getValue(1, 6), true)

WebUI.verifyElementText(findTestObject('Complete Questionaire/message_Ref_Num_Value'), GlobalVariable.ApplicationRef)

WebUI.closeBrowser()

