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

def verData = TestDataFactory.findTestData('Data Files/Complete_Questionaire')

WebUI.click(findTestObject('Complete Questionaire/link_Search'))

WebUI.setText(findTestObject('Complete Questionaire/text_Appeal_Ref'), '4001539')

WebUI.click(findTestObject('Complete Questionaire/button_Search'))

WebUI.verifyElementText(findTestObject('Complete Questionaire/label_Match_found'), verData.getValue(1, 1))

WebUI.click(findTestObject('Complete Questionaire/link_Appeal_Ref'))

WebUI.waitForElementVisible(findTestObject('Complete Questionaire/button_Complete questionnaire'), 3)

WebUI.click(findTestObject('Complete Questionaire/button_Complete questionnaire'))

WebUI.waitForElementVisible(findTestObject('Complete Questionaire/button_Start now'), 3)

WebUI.click(findTestObject('Complete Questionaire/button_Start now'))

WebUI.waitForElementVisible(findTestObject('Complete Questionaire/question_Appeal_Info'), 3)

WebUI.verifyElementText(findTestObject('Complete Questionaire/question_Appeal_Info'), verData.getValue(1, 2))

WebUI.verifyElementVisible(findTestObject('Complete Questionaire/title_Appeal_Sections'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Complete Questionaire/list_Appeal_Sections'), verData.getValue(1, 3))

WebUI.click(findTestObject('Complete Questionaire/input_Yes_Option'))

WebUI.click(findTestObject('Complete Questionaire/button_Next_Page'))

WebUI.waitForElementVisible(findTestObject('Complete Questionaire/question_Appeal_Procedure'), 3)

WebUI.click(findTestObject('Complete Questionaire/input_Yes_Appeal_Procedure'))

WebUI.click(findTestObject('Complete Questionaire/button_AppealProc_Next_page'))

WebUI.waitForElementVisible(findTestObject('Complete Questionaire/question_Upload_Policies'), 3)

WebUI.verifyElementText(findTestObject('Complete Questionaire/question_Upload_Policies'), verData.getValue(1, 4))

WebUI.click(findTestObject('Complete Questionaire/button_LocalPolicy_Next_page'))

WebUI.waitForElementVisible(findTestObject('Complete Questionaire/button_Emerging_Next_page'), 3)

WebUI.click(findTestObject('Complete Questionaire/input_Yes_EmergingPolicies'))

WebUI.click(findTestObject('Complete Questionaire/button_Emerging_Next_page'))

WebUI.waitForElementVisible(findTestObject('Complete Questionaire/button_FiveYear_Next_page'), 3)

WebUI.click(findTestObject('Complete Questionaire/input_Yes_FiveHousing'))

WebUI.click(findTestObject('Complete Questionaire/button_FiveYear_Next_page'))

WebUI.waitForElementVisible(findTestObject('Complete Questionaire/button_Conditions_Next_Page'), 3)

WebUI.click(findTestObject('Complete Questionaire/input_Yes_ConditionsSuggestions'))

WebUI.click(findTestObject('Complete Questionaire/input_Yes_ConditionsObligation'))

WebUI.click(findTestObject('Complete Questionaire/button_Conditions_Next_Page'))

WebUI.waitForElementVisible(findTestObject('Complete Questionaire/button_Conservative_Next_Page'), 3)

WebUI.click(findTestObject('Complete Questionaire/input_Yes_ConservationSite'))

WebUI.click(findTestObject('Complete Questionaire/button_Conservative_Next_Page'))

WebUI.waitForElementVisible(findTestObject('Complete Questionaire/button_Monuments_Next_Page'), 3)

WebUI.click(findTestObject('Complete Questionaire/input_Yes_BuildingAffects'))

WebUI.click(findTestObject('Complete Questionaire/input_Yes_BuildingAffectScheduleMonument'))

WebUI.click(findTestObject('Complete Questionaire/button_Monuments_Next_Page'))

WebUI.waitForElementVisible(findTestObject('Complete Questionaire/button_Screening_Next_Page'), 3)

WebUI.click(findTestObject('Complete Questionaire/input_Yes_ScreeningOpinion'))

WebUI.click(findTestObject('Complete Questionaire/button_Screening_Next_Page'))

WebUI.waitForElementVisible(findTestObject('Complete Questionaire/message_Upload_Planning'), 3)

WebUI.click(findTestObject('Complete Questionaire/button_Select_File'))

WebUI.callTestCase(findTestCase('Self Service Portal/Portal-Generic/Upload_File'), [('exeFileName') : 'Doc_Upload.exe'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Complete Questionaire/button_Upload_File_Next'))

WebUI.waitForElementVisible(findTestObject('Complete Questionaire/button_Notifications_Next'), 3)

WebUI.click(findTestObject('Complete Questionaire/input_No_Notifications'))

WebUI.click(findTestObject('Complete Questionaire/button_Notifications_Next'))

WebUI.waitForElementVisible(findTestObject('Complete Questionaire/button_Upload_Next_Page'), 3)

WebUI.click(findTestObject('Complete Questionaire/button_Upload_Next_Page'))

WebUI.waitForElementVisible(findTestObject('Complete Questionaire/message_Confirmation'), 2)

WebUI.click(findTestObject('Complete Questionaire/button_Submit_Confirmation'))

WebUI.waitForElementVisible(findTestObject('Complete Questionaire/message_Check_Answers'), 2)

not_run: WebUI.scrollToElement(findTestObject('Complete Questionaire/button_Submit_Final'), 2)

WebUI.focus(findTestObject('Complete Questionaire/message_Check_Answers'))

WebUI.scrollToPosition(9999999, 9999999)

WebUI.click(findTestObject('Complete Questionaire/button_Submit_Final'))

