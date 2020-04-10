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

WebUI.waitForElementVisible(findTestObject('Technical Reports Post Decision/link_Application_Technical_Reports'), 5)

WebUI.click(findTestObject('Technical Reports Post Decision/link_Application_Technical_Reports'))

WebUI.waitForElementVisible(findTestObject('Technical Reports Post Decision/message_Technical_Reports'), 5)

WebUI.verifyElementText(findTestObject('Technical Reports Post Decision/message_Technical_Reports'), verData.getValue(1, 
        39))

not_run: def data = WebUI.getText(findTestObject('Application Technical Reports/message_Provide_Docs')).replaceAll('\\s+', 
    '').trim()

not_run: WebUI.verifyMatch(data, verData.getValue(1, 61).replaceAll('\\s+', '').trim(), false, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('Planning Application details/button_Save_Continue'), 5)

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Application Technical Reports/status_Complete_Application_Technical_Reports'), 
    10)

WebUI.verifyElementText(findTestObject('Application Technical Reports/status_Complete_Application_Technical_Reports'), 'COMPLETED')

