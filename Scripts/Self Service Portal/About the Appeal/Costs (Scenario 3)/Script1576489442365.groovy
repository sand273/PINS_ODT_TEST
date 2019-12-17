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

WebUI.waitForElementVisible(findTestObject('Costs/link_Costs'), 2)

WebUI.click(findTestObject('Costs/link_Costs'))

WebUI.waitForElementVisible(findTestObject('Costs/question_Costs_Application'), 2)

WebUI.verifyElementText(findTestObject('Costs/question_Costs_Application'), verData.getValue(1, 55))

WebUI.click(findTestObject('Costs/link_Application_Costs'))

WebUI.waitForElementVisible(findTestObject('Costs/frame_Application_Costs'), 2)

WebUI.verifyElementText(findTestObject('Costs/frame_Application_Costs'), verData.getValue(1, 56))

WebUI.click(findTestObject('Costs/Application_Costs_Yes_Option'))

WebUI.click(findTestObject('Costs/Help_Formats_Link'))

WebUI.waitForElementVisible(findTestObject('Costs/Help_File_Formats'), 20)

WebUI.verifyElementText(findTestObject('Costs/Help_File_Formats'), verData.getValue(1, 32))

WebUI.click(findTestObject('Costs/Upload_App_Costs_File'))

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Upload_File'), [('exeFileName') : 'Pdf_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Costs/Remove_Button'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Costs/status_Complete_Costs'), 3)

WebUI.verifyElementText(findTestObject('Costs/status_Complete_Costs'), 'COMPLETED')
