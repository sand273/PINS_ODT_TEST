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

def verData = TestDataFactory.findTestData('Data Files/Portal_Verification')

WebUI.delay(1)

WebUI.waitForElementVisible(findTestObject('Environmental details/link_Environmental_Details'), 20)

WebUI.click(findTestObject('Environmental details/link_Environmental_Details'))

WebUI.waitForElementVisible(findTestObject('Environmental details/question_Environmental_Impact_Assessment'), 20)

WebUI.verifyElementText(findTestObject('Environmental details/question_Environmental_Impact_Assessment'), verData.getValue(
        1, 33))

WebUI.click(findTestObject('Environmental details/option_No_Env_Impact_Assessment'))

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Environmental details/question_Environmental_Statement'), 20)

WebUI.verifyElementText(findTestObject('Environmental details/question_Environmental_Statement'), verData.getValue(1, 34))

WebUI.click(findTestObject('Environmental details/Environment_Statement_Yes_Option'))

WebUI.click(findTestObject('Environmental details/Upload_Environment_Statement_File'))

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Upload_File'), [('exeFileName') : 'Doc_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Environmental details/Remove_Button'))

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Environmental details/status_Complete_Environment_Details'), 20)

WebUI.verifyElementText(findTestObject('Environmental details/status_Complete_Environment_Details'), 'COMPLETED')
