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

WebUI.waitForElementVisible(findTestObject('Other Appeal Information/link_Other_Appeal_Information'), 2)

WebUI.click(findTestObject('Other Appeal Information/link_Other_Appeal_Information'))

WebUI.waitForElementVisible(findTestObject('Other Appeal Information/message_Upload_documents'), 2)

WebUI.verifyElementText(findTestObject('Other Appeal Information/message_Upload_documents'), verData.getValue(1, 63))

WebUI.verifyElementText(findTestObject('Other Appeal Information/message_provide_documents'), verData.getValue(1, 64))

WebUI.click(findTestObject('Other Appeal Information/button_Select_File'))

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Upload File'), [('exeFileName') : 'Doc_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Other Appeal Information/button_Add_More_Files'), 2)

WebUI.click(findTestObject('Other Appeal Information/button_Add_More_Files'))

WebUI.click(findTestObject('Other Appeal Information/button_Select_File2'))

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Upload File'), [('exeFileName') : 'Pdf_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Other Appeal Information/button_Add_More_Files'), 2)

WebUI.click(findTestObject('Other Appeal Information/button_Add_More_Files'))

WebUI.click(findTestObject('Other Appeal Information/button_Select_File3'))

WebUI.delay(1)

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Upload File'), [('exeFileName') : 'Tiff_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Other Appeal Information/button_Add_More_Files'), 2)

WebUI.click(findTestObject('Other Appeal Information/button_Add_More_Files'))

WebUI.click(findTestObject('Other Appeal Information/button_Select_File4'))

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Upload File'), [('exeFileName') : 'Jpeg_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Other Appeal Information/button_Add_More_Files'), 2)

WebUI.click(findTestObject('Other Appeal Information/button_Add_More_Files'))

WebUI.click(findTestObject('Other Appeal Information/button_Select_File5'))

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Upload File'), [('exeFileName') : 'PNG_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Other Appeal Information/status_Complete_Other_Information'), 3)

WebUI.verifyElementText(findTestObject('Other Appeal Information/status_Complete_Other_Information'), 'COMPLETED')

