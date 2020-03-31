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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

def verData = TestDataFactory.findTestData('Data Files/Portal_Verification')

def testData = TestDataFactory.findTestData('Data Files/Planning_Details')

WebUI.waitForElementClickable(findTestObject('Appeal planning decision/link_Planning_Application_Details'), 5)

WebUI.click(findTestObject('Appeal planning decision/link_Planning_Application_Details'))

WebUI.waitForElementVisible(findTestObject('Planning Application details/question_Statement_Applies'), 5)

WebUI.verifyElementText(findTestObject('Planning Application details/question_Statement_Applies'), verData.getValue(1, 23))

WebUI.click(findTestObject('Planning Application details/option_Appeal_Decision_Received'))

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Planning Application details/question_Name_Original_Application'), 5)

WebUI.verifyElementText(findTestObject('Planning Application details/question_Name_Original_Application'), verData.getValue(
        1, 24))

WebUI.setText(findTestObject('Planning Application details/text_Name_Application'), testData.getValue(1, 1))

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Planning Application details/question_LPA_Submit'), 5)

WebUI.verifyElementText(findTestObject('Planning Application details/question_LPA_Submit'), verData.getValue(1, 25))

WebUI.selectOptionByValue(findTestObject('Planning Application details/dropdown_LPA_Select'), 'C3810', true)

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Planning Application details/question_Application_Ref'), 5)

WebUI.verifyElementText(findTestObject('Planning Application details/question_Application_Ref'), verData.getValue(1, 26))

WebUI.setText(findTestObject('Planning Application details/text_Application_Ref'), testData.getValue(2, 1))

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Planning Application details/question_Application_Type'), 5)

WebUI.verifyElementText(findTestObject('Planning Application details/question_Application_Type'), verData.getValue(1, 27))

WebUI.check(findTestObject('Planning Application details/check_Change_of_Use'))

WebUI.check(findTestObject('Planning Application details/check_General_Industry'))

WebUI.check(findTestObject('Planning Application details/check_Householder'))

WebUI.click(findTestObject('Planning Application details/option_Yes_Residential_Dwellings'))

WebUI.click(findTestObject('Appeal planning decision/input_Area_Measurement'))

WebUI.click(findTestObject('Appeal planning decision/input_Area_Development'))

WebUI.click(findTestObject('Planning Application details/option_Yes_Proposed_Amount_Of_Dwellings'))

WebUI.setText(findTestObject('Planning Application details/input_Number_Of_Dwellings'), '1')

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Planning Application details/message_Development_Description'), 5)

WebUI.verifyElementText(findTestObject('Planning Application details/message_Development_Description'), verData.getValue(
        1, 28))

WebUI.setText(findTestObject('Planning Application details/text_Development_Description'), testData.getValue(3, 1))

WebUI.delay(1)

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Planning Application details/question_Description_Change'), 5)

WebUI.verifyElementText(findTestObject('Planning Application details/question_Description_Change'), verData.getValue(1, 
        29))

WebUI.check(findTestObject('Planning Application details/option_No_Description_Change'))

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Appeal planning decision/message_Grant_Permission'), 5)

WebUI.verifyElementText(findTestObject('Appeal planning decision/message_Grant_Permission'), verData.getValue(1, 120))

WebUI.click(findTestObject('Planning Application details/label_Permission_Principle'))

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Upload File'), [('exeFileName') : 'Doc_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Planning Application details/button_Remove_File'), 5)

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Planning Application details/message_Upload_Application_Form'), 5)

WebUI.verifyElementText(findTestObject('Planning Application details/message_Upload_Application_Form'), verData.getValue(
        1, 105))

WebUI.click(findTestObject('Planning Application details/link_Help_Format_Planning'))

WebUI.waitForElementVisible(findTestObject('Planning Application details/list_Help_Format_Planning'), 5)

WebUI.verifyElementText(findTestObject('Planning Application details/list_Help_Format_Planning'), verData.getValue(1, 32))

WebUI.click(findTestObject('Planning Application details/button_Application_Form'))

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Upload File'), [('exeFileName') : 'Doc_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Planning Application details/button_Remove_File'), 5)

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Planning Application details/message_LPA_Original_Planning_Decision'), 5)

WebUI.verifyElementText(findTestObject('Planning Application details/message_LPA_Original_Planning_Decision'), verData.getValue(
        1, 106))

WebUI.click(findTestObject('Planning Application details/link_Help_Format_LPA'))

WebUI.waitForElementVisible(findTestObject('Planning Application details/list_Help_Formats_LPA_Notice'), 5)

WebUI.verifyElementText(findTestObject('Planning Application details/list_Help_Formats_LPA_Notice'), verData.getValue(1, 
        32))

WebUI.click(findTestObject('Planning Application details/message_LPA_Original_Planning_Decision'))

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Upload File'), [('exeFileName') : 'Doc_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Planning Application details/button_Remove_LPA_Original_Planning_Decision'), 
    5)

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Application_Permission'), [('planOption') : 'Full'], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Planning Application details/status_Complete_App_Details'), 10)

WebUI.verifyElementText(findTestObject('Planning Application details/status_Complete_App_Details'), 'COMPLETED')

