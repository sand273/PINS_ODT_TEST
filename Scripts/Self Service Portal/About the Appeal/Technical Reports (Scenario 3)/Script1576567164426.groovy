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

WebUI.waitForElementVisible(findTestObject('Technical Reports/link_Technical_Reports'), 2)

WebUI.click(findTestObject('Technical Reports/link_Technical_Reports'))

WebUI.waitForElementVisible(findTestObject('Technical Reports/message_Technical_Reports'), 2)

WebUI.verifyElementText(findTestObject('Technical Reports/message_Technical_Reports'), verData.getValue(1, 62))

WebUI.verifyElementText(findTestObject('Technical Reports/message_Provide_Docs'), verData.getValue(1, 61))

WebUI.click(findTestObject('Technical Reports/link_Help_File_Formats'))

WebUI.waitForElementVisible(findTestObject('Technical Reports/list_Help_File_Formats'), 2)

WebUI.verifyElementText(findTestObject('Technical Reports/list_Help_File_Formats'), verData.getValue(1, 32))

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Technical Reports/status_Complete_Technical_Reports'), 5)

WebUI.verifyElementText(findTestObject('Technical Reports/status_Complete_Technical_Reports'), 'COMPLETED')
