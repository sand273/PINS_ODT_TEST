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

WebUI.waitForElementVisible(findTestObject('Check your answers/link_Check_Answers'), 5)

WebUI.click(findTestObject('Check your answers/link_Check_Answers'))

WebUI.waitForElementVisible(findTestObject('Check your answers/message_Check_Answers'), 5)

WebUI.verifyElementText(findTestObject('Check your answers/message_Check_Answers'), verData.getValue(1, 67))

WebUI.scrollToElement(findTestObject('Check your answers/button_Save_Continue'), 5)

WebUI.delay(1)

WebUI.waitForElementClickable(findTestObject('Check your answers/button_Save_Continue'), 5)

WebUI.click(findTestObject('Check your answers/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Check your answers/message_Check_Progress'), 5)

WebUI.verifyElementText(findTestObject('Check your answers/message_Check_Progress'), 'Check your progress')

WebUI.verifyElementText(findTestObject('Check your answers/status_Submit_Appeal'), verData.getValue(1, 68))

WebUI.verifyElementText(findTestObject('Check your answers/message_Submit_Appeal'), verData.getValue(1, 69))

def data = WebUI.getText(findTestObject('Check your answers/message_Appeal_Not_Change')).replaceAll('\\s+', '').trim()

WebUI.verifyMatch(data, verData.getValue(1, 70).replaceAll('\\s+', '').trim(), false, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('Check your answers/button_Ready_to_Submit'), 5)

WebUI.click(findTestObject('Check your answers/button_Ready_to_Submit'))

