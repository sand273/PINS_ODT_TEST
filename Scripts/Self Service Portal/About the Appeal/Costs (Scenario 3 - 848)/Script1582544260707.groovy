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

WebUI.verifyElementText(findTestObject('Costs/question_Costs_Application'), verData.getValue(1, 111))

WebUI.verifyElementText(findTestObject('Costs/message_HAS_CAS_Appeals'), verData.getValue(1, 117))

WebUI.click(findTestObject('Costs/option_Yes_Application_Costs'))

WebUI.click(findTestObject('Costs/link_Help_Formats'))

WebUI.waitForElementVisible(findTestObject('Costs/message_Help_File'), 20)

WebUI.verifyElementText(findTestObject('Costs/message_Help_File'), verData.getValue(1, 32))

WebUI.click(findTestObject('Costs/file_Upload_App_Costs'))

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Upload File'), [('exeFileName') : 'Pdf_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Costs/button_Remove'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Costs/status_Complete_Costs'), 3)

WebUI.verifyElementText(findTestObject('Costs/status_Complete_Costs'), 'COMPLETED')

