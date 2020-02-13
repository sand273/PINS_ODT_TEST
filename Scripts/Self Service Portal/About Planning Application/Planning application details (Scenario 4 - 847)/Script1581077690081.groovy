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
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.WebElement as WebElement

def verData = TestDataFactory.findTestData('Data Files/Portal_Verification')

def testData = TestDataFactory.findTestData('Data Files/Planning_Details')

WebUI.waitForElementClickable(findTestObject('Appeal planning decision/link_Planning_Application_Details'), 20)

WebUI.click(findTestObject('Appeal planning decision/link_Planning_Application_Details'))

WebUI.waitForElementVisible(findTestObject('Planning Application details/question_Statement_Applies'), 20)

WebUI.verifyElementText(findTestObject('Planning Application details/question_Statement_Applies'), verData.getValue(1, 23))

WebUI.click(findTestObject('Planning Application details/option_Appeal_Decision_Received'))

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Planning Application details/question_Name_Original_Application'), 2)

WebUI.verifyElementText(findTestObject('Planning Application details/question_Name_Original_Application'), verData.getValue(
        1, 24))

WebUI.setText(findTestObject('Planning Application details/text_Name_Application'), testData.getValue(1, 1))

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Planning Application details/question_LPA_Submit'), 3)

WebUI.verifyElementText(findTestObject('Planning Application details/question_LPA_Submit'), verData.getValue(1, 25))

WebUI.selectOptionByValue(findTestObject('Planning Application details/dropdown_LPA_Select'), 'C3810', true)

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Planning Application details/question_Application_Ref'), 2)

WebUI.verifyElementText(findTestObject('Planning Application details/question_Application_Ref'), verData.getValue(1, 26))

WebUI.setText(findTestObject('Planning Application details/text_Application_Ref'), testData.getValue(2, 1))

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Planning Application details/question_Application_Type'), 2)

WebUI.verifyElementText(findTestObject('Planning Application details/question_Application_Type'), verData.getValue(1, 27))

WebUI.check(findTestObject('Planning Application details/check_Change_of_Use'))

WebUI.check(findTestObject('Planning Application details/check_General_Industry'))

WebUI.check(findTestObject('Planning Application details/check_Householder'))

WebUI.click(findTestObject('Appeal planning decision/input_No_residential_dwellings'))

not_run: WebUI.click(findTestObject('Appeal planning decision/input_Area_Measurement'))

not_run: WebUI.click(findTestObject('Appeal planning decision/input_Area_Development'))

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Planning Application details/message_Development_Description'), 2)

WebUI.verifyElementText(findTestObject('Planning Application details/message_Development_Description'), verData.getValue(
        1, 28))

WebUI.setText(findTestObject('Planning Application details/text_Development_Description'), testData.getValue(3, 1))

WebUI.delay(1)

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Planning Application details/question_Description_Change'), 20)

WebUI.verifyElementText(findTestObject('Planning Application details/question_Description_Change'), verData.getValue(1, 
        29))

WebUI.check(findTestObject('Planning Application details/input_Yes_Description_Change'))

WebUI.setText(findTestObject('Planning Application details/field_Revised_Description'), testData.getValue(4, 1))

WebUI.setText(findTestObject('Planning Application details/field_Reason_Changed_Description'), testData.getValue(5, 1))

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Planning Application details/message_Upload_Application_Form'), 20)

WebUI.verifyElementText(findTestObject('Planning Application details/message_Upload_Application_Form'), verData.getValue(
        1, 30))

WebUI.click(findTestObject('Planning Application details/link_Help_File_Format'))

WebUI.waitForElementVisible(findTestObject('Planning Application details/list_Help_File_Formats'), 20)

WebUI.verifyElementText(findTestObject('Planning Application details/list_Help_File_Formats'), verData.getValue(1, 32))

WebUI.click(findTestObject('Planning Application details/button_Application_Form'), FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Upload File'), [('exeFileName') : 'Doc_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Planning Application details/button_Remove_File'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Planning Application details/message_LPA_Decision_Notice'), 20)

WebUI.verifyElementText(findTestObject('Planning Application details/message_LPA_Decision_Notice'), verData.getValue(1, 
        31))

WebUI.click(findTestObject('Planning Application details/link_Help_Format_LPA'))

WebUI.waitForElementVisible(findTestObject('Planning Application details/list_Help_Formats_LPA_Notice'), 20)

WebUI.verifyElementText(findTestObject('Planning Application details/list_Help_Formats_LPA_Notice'), verData.getValue(1, 
        32))

WebUI.click(findTestObject('Planning Application details/button_LPA_Notice'))

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Upload File'), [('exeFileName') : 'Pdf_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Planning Application details/button_Remove_LPA_Notice'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Planning Application details/message_Planning_Obligation_Evidence'), 5)

WebUI.verifyElementText(findTestObject('Planning Application details/message_Planning_Obligation_Evidence'), verData.getValue(
        1, 97))

WebUI.click(findTestObject('Planning Application details/button_Obligation_Upload'))

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Upload File'), [('exeFileName') : 'Doc_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Planning Application details/button_Remove_Planning_Obligation'), 5)

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Planning Application details/message_Regulation_4_Certificate'), 5)

WebUI.verifyElementText(findTestObject('Planning Application details/message_Regulation_4_Certificate'), verData.getValue(
        1, 99))

WebUI.click(findTestObject('Planning Application details/button_Regulation_4_Upload'))

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Upload File'), [('exeFileName') : 'Pdf_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Planning Application details/button_Remove_Regulation_4'), 5)

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Planning Application details/message_List_Regulation_4'), 5)

WebUI.verifyElementText(findTestObject('Planning Application details/message_List_Regulation_4'), verData.getValue(1, 103))

WebUI.click(findTestObject('Planning Application details/button_List_Regulation_4_Upload'))

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Upload File'), [('exeFileName') : 'PNG_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Planning Application details/button_Remove_Regulation_4'), 5)

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Planning Application details/status_Complete_App_Details'), 20)

WebUI.verifyElementText(findTestObject('Planning Application details/status_Complete_App_Details'), 'COMPLETED')

