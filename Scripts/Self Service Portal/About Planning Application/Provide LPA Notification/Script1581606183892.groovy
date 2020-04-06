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

WebUI.waitForElementVisible(findTestObject('LPA Notification/link_LPA_Notification'), 5)

WebUI.click(findTestObject('LPA Notification/link_LPA_Notification'))

WebUI.waitForElementVisible(findTestObject('LPA Notification/message_Provide_LPA_Notification'), 5)

WebUI.verifyElementText(findTestObject('LPA Notification/message_Provide_LPA_Notification'), verData.getValue(1, 110))

WebUI.waitForElementClickable(findTestObject('LPA Notification/button_Select_File'), 5)

WebUI.click(findTestObject('LPA Notification/button_Select_File'))

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Upload File'), [('exeFileName') : 'Pdf_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('LPA Notification/link_Help_File_Formats'))

WebUI.waitForElementVisible(findTestObject('LPA Notification/list_Help_File_Formats'), 5)

WebUI.verifyElementText(findTestObject('LPA Notification/list_Help_File_Formats'), verData.getValue(1, 32))

WebUI.waitForElementClickable(findTestObject('Planning Application details/button_Save_Continue'), 5)

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('LPA Notification/status_LPA_Notification'), 10)

WebUI.verifyElementText(findTestObject('LPA Notification/status_LPA_Notification'), 'COMPLETED')

