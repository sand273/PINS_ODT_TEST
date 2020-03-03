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

WebUI.waitForElementVisible(findTestObject('Preferred procedure/link_Preferred_Procedure'), 5)

WebUI.click(findTestObject('Preferred procedure/link_Preferred_Procedure'))

WebUI.waitForElementVisible(findTestObject('Preferred procedure/question_Preferred_Procedure'), 5)

def data = WebUI.getText(findTestObject('Preferred procedure/message_Preferred_Procedure')).replaceAll('\\s+', '').trim()

WebUI.verifyMatch(data, verData.getValue(1, 59).replaceAll('\\s+', '').trim(), false, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Preferred procedure/input_Written_Representation'))

WebUI.click(findTestObject('Preferred procedure/link_Which_Option'))

WebUI.waitForElementVisible(findTestObject('Preferred procedure/frame_Which_Option'), 5)

WebUI.verifyElementText(findTestObject('Preferred procedure/frame_Which_Option'), verData.getValue(1, 60))

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Preferred procedure/status_Complete_Preferred'), 10)

WebUI.verifyElementText(findTestObject('Preferred procedure/status_Complete_Preferred'), 'COMPLETED')

