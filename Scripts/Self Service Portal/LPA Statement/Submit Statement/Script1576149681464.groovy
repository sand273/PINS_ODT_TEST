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

String statRefMessage

def verData = TestDataFactory.findTestData('Data Files/Complete_Questionaire')

WebUI.callTestCase(findTestCase('Self Service Portal/Login/LPA User'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Complete Questionaire/link_Search'))

WebUI.setText(findTestObject('Complete Questionaire/text_Appeal_Ref'), GlobalVariable.ApplicationRef)

WebUI.click(findTestObject('Complete Questionaire/button_Search'))

WebUI.waitForElementVisible(findTestObject('Submit Statement/label_Match_Found'), 2)

WebUI.click(findTestObject('Complete Questionaire/link_Appeal_Ref'))

WebUI.waitForElementVisible(findTestObject('Submit Statement/message_Appeal_Status'), 3)

WebUI.verifyElementText(findTestObject('Submit Statement/title_Appeal_Reference'), GlobalVariable.ApplicationRef)

WebUI.verifyElementVisible(findTestObject('Submit Statement/button_Make_Statement'))

WebUI.click(findTestObject('Submit Statement/button_Make_Statement'))

WebUI.waitForElementVisible(findTestObject('Submit Statement/title_Statement_Form'), 3)

WebUI.verifyElementVisible(findTestObject('Submit Statement/button_Start_Now'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Submit Statement/button_Start_Now'))

WebUI.waitForElementVisible(findTestObject('Submit Statement/message_LPA_Statement'), 3)

WebUI.click(findTestObject('Submit Statement/button_Select_File'))

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Upload File'), [('exeFileName') : 'Statement_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

WebUI.click(findTestObject('Submit Statement/button_Submit'))

WebUI.waitForElementVisible(findTestObject('Submit Statement/title_Statement_Received'), 3)

WebUI.verifyElementText(findTestObject('Submit Statement/title_Statement_Received'), verData.getValue(1, 9))

statRefMessage = WebUI.getText(findTestObject('Submit Statement/message_Statement_Ref_Number'))

WebUI.verifyMatch(statRefMessage, verData.getValue(1, 10), true)

WebUI.verifyElementText(findTestObject('Submit Statement/message_RefNumber_Value'), GlobalVariable.ApplicationRef)

WebUI.closeBrowser()

