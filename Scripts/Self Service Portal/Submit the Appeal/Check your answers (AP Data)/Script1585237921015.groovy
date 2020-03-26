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

WebUI.scrollToElement(findTestObject('Check your answers/button_Save_Continue'), 5)

WebUI.delay(1)

WebUI.waitForElementClickable(findTestObject('Check your answers/button_Save_Continue'), 5)

WebUI.click(findTestObject('Check your answers/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Check your answers/message_Check_Progress'), 5)

WebUI.waitForElementClickable(findTestObject('Check your answers/button_Ready_to_Submit'), 5)

WebUI.click(findTestObject('Check your answers/button_Ready_to_Submit'))

