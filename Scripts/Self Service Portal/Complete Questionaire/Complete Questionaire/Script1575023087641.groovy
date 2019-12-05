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

String queRefMessage

def verData = TestDataFactory.findTestData('Data Files/Complete_Questionaire')

WebUI.callTestCase(findTestCase('Self Service Portal/Login/LPA_User'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Search_Appeal'), [:], FailureHandling.STOP_ON_FAILURE)

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

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Upload_File'), [('exeFileName') : 'Pdf_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.waitForElementVisible(findTestObject('Complete Questionaire/button_Upload_File_Next'), 3)

WebUI.click(findTestObject('Complete Questionaire/button_Upload_File_Next'))

WebUI.waitForElementVisible(findTestObject('Complete Questionaire/button_Notifications_Next'), 3)

WebUI.click(findTestObject('Complete Questionaire/input_No_Notifications'))

WebUI.click(findTestObject('Complete Questionaire/button_Notifications_Next'))

WebUI.waitForElementVisible(findTestObject('Complete Questionaire/button_Upload_Next_Page'), 3)

WebUI.click(findTestObject('Complete Questionaire/button_Upload_Next_Page'))

WebUI.waitForElementVisible(findTestObject('Complete Questionaire/message_Confirmation'), 2)

WebUI.click(findTestObject('Complete Questionaire/button_Submit_Confirmation'))

WebUI.waitForElementVisible(findTestObject('Complete Questionaire/message_Check_Answers'), 2)

WebUI.focus(findTestObject('Complete Questionaire/message_Check_Answers'))

WebUI.scrollToPosition(9999999, 9999999)

WebUI.click(findTestObject('Complete Questionaire/button_Submit_Final'))

WebUI.waitForElementVisible(findTestObject('Complete Questionaire/title_Questionaire_Received'), 3)

WebUI.verifyElementText(findTestObject('Complete Questionaire/title_Questionaire_Received'), verData.getValue(1, 5))

WebUI.verifyElementVisible(findTestObject('Complete Questionaire/message_Questionaire_Reference_Num'))

queRefMessage = WebUI.getText(findTestObject('Complete Questionaire/message_Questionaire_Reference_Num'))

WebUI.verifyMatch(queRefMessage, verData.getValue(1, 6), true)

WebUI.verifyElementText(findTestObject('Complete Questionaire/message_Ref_Num_Value'), 'W/' + GlobalVariable.ApplicationRef)

WebUI.closeBrowser()
