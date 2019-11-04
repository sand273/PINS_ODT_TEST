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
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory

def verData = TestDataFactory.findTestData('Data Files/Verification')

def testData = TestDataFactory.findTestData('Data Files/Planning_Details')

WebUI.waitForElementClickable(findTestObject('Page_Appeal a planning decision/link_Planning_Application_Details'), 1)

WebUI.click(findTestObject('Page_Appeal a planning decision/link_Planning_Application_Details'))

WebUI.waitForElementVisible(findTestObject('Planning Application Details/question_Statement_Applies'), 3)

WebUI.verifyElementText(findTestObject('Planning Application Details/question_Statement_Applies'), verData.getValue(1, 23))

WebUI.click(findTestObject('Planning Application Details/option_Appeal_Decision_I_Received'))

WebUI.click(findTestObject('Planning Application Details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Planning Application Details/question_Name_Original_Application'), 2)

WebUI.verifyElementText(findTestObject('Planning Application Details/question_Name_Original_Application'), verData.getValue(
        1, 24))

WebUI.setText(findTestObject('Planning Application Details/text_Name_Application'), testData.getValue(1, 1))

WebUI.click(findTestObject('Planning Application Details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Planning Application Details/question_LPA_Submit'), 2)

WebUI.verifyElementText(findTestObject('Planning Application Details/question_LPA_Submit'), verData.getValue(1, 25))

WebUI.selectOptionByValue(findTestObject('Planning Application Details/dropdown_LPA_Select'), 'C3810', true)

WebUI.click(findTestObject('Planning Application Details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Planning Application Details/question_Application_Ref'), 2)

WebUI.verifyElementText(findTestObject('Planning Application Details/question_Application_Ref'), verData.getValue(1, 26))

WebUI.setText(findTestObject('Planning Application Details/text_Application_Ref'), testData.getValue(2, 1))

WebUI.click(findTestObject('Planning Application Details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Planning Application Details/question_Application_Type'), 2)

WebUI.verifyElementText(findTestObject('Planning Application Details/question_Application_Type'), verData.getValue(1, 27))

WebUI.check(findTestObject('Planning Application Details/check_Change_of_Use'))

WebUI.check(findTestObject('Planning Application Details/check_General_Industry'))

WebUI.check(findTestObject('Planning Application Details/check_Householder'))

WebUI.click(findTestObject('Planning Application Details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Planning Application Details/message_Development_Description'), 2)

WebUI.verifyElementText(findTestObject('Planning Application Details/message_Development_Description'), verData.getValue(
        1, 28))

WebUI.setText(findTestObject('Planning Application Details/text_Development_Description'), testData.getValue(3, 1))

WebUI.click(findTestObject('Planning Application Details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Planning Application Details/question_Description_Change'), 2)

WebUI.verifyElementText(findTestObject('Planning Application Details/question_Description_Change'), verData.getValue(1, 
        29))

WebUI.check(findTestObject('Planning Application Details/option_No_Description_Change'))

WebUI.click(findTestObject('Planning Application Details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Planning Application Details/message_Upload_Application_Form'), 2)

WebUI.verifyElementText(findTestObject('Planning Application Details/message_Upload_Application_Form'), verData.getValue(
        1, 30))

WebUI.callTestCase(findTestCase('Generic/Help_File_Formats'), [('linkHelpFormat') : 'Object Repository/Planning Application Details/link_Help_with_Formats'
        , ('listHelpFormat') : 'Object Repository/Planning Application Details/list_Help_File_Formats'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Generic/Upload_File'), [('buttonUploadFile') : 'Planning Application Details/button_Application_Form'
        , ('exeFileName') : 'Doc_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Planning Application Details/button_Remove_File'), 3)

WebUI.click(findTestObject('Planning Application Details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Planning Application Details/message_LPA_Decision_Notice'), 2)

WebUI.verifyElementText(findTestObject('Planning Application Details/message_LPA_Decision_Notice'), verData.getValue(1, 
        31))

WebUI.callTestCase(findTestCase('Generic/Help_File_Formats'), [('linkHelpFormat') : 'Object Repository/Planning Application Details/link_Help_File_Format_LPA_Notice'
        , ('listHelpFormat') : 'Object Repository/Planning Application Details/list_Help_Formats_LPA_Notice'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Generic/Upload_File'), [('buttonUploadFile') : 'Object Repository/Planning Application Details/button_LPA_Notice'
        , ('exeFileName') : 'Pdf_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Planning Application Details/button_Remove_File'), 3)

WebUI.click(findTestObject('Planning Application Details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Planning Application Details/status_Complete_App_Details'), 3)

WebUI.verifyElementText(findTestObject('Planning Application Details/status_Complete_App_Details'), 'COMPLETED')

