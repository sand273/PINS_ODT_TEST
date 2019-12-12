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

WebUI.waitForElementVisible(findTestObject('Appeal_Received/title_Appeal_Received'), 3)

WebUI.verifyElementText(findTestObject('Appeal_Received/title_Appeal_Received'), 'Appeal received')

GlobalVariable.ApplicationRef = WebUI.getText(findTestObject('Object Repository/Appeal_Received/label_Appeal_Received'))

WebUI.verifyElementVisible(findTestObject('Appeal_Received/message_Happens_Next'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Appeal_Received/message_Validate'), verData.getValue(1, 72))

WebUI.verifyElementText(findTestObject('Appeal_Received/message_Sign_In'), verData.getValue(1, 73))

WebUI.verifyElementVisible(findTestObject('Appeal_Received/message_More_Info'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Appeal_Received/frame_Thanks_Contents'), verData.getValue(1, 74))

WebUI.click(findTestObject('Appeal_Received/button_Appeal_Summary'))

