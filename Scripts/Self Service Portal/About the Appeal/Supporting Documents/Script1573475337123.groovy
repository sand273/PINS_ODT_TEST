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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

def verData = TestDataFactory.findTestData('Data Files/Portal_Verification')

WebUI.waitForElementVisible(findTestObject('Supporting Grounds/link_Supporting_Grounds'), 5)

WebUI.click(findTestObject('Supporting Grounds/link_Supporting_Grounds'))

WebUI.waitForElementVisible(findTestObject('Supporting Grounds/message_Upload_File'), 5)

WebUI.verifyElementText(findTestObject('Supporting Grounds/message_Upload_File'), verData.getValue(1, 51))

WebUI.click(findTestObject('Supporting Grounds/button_Select_File'))

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Upload File'), [('exeFileName') : 'Doc_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('Supporting Grounds/button_Add_another_document'), 5)

WebUI.click(findTestObject('Supporting Grounds/button_Add_another_document'))

WebUI.click(findTestObject('Supporting Grounds/button_Select_File2'))

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Upload File'), [('exeFileName') : 'Pdf_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('Supporting Grounds/button_Add_another_document'), 5)

WebUI.click(findTestObject('Supporting Grounds/button_Add_another_document'))

WebUI.click(findTestObject('Supporting Grounds/button_Select_File3'))

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Upload File'), [('exeFileName') : 'Tiff_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('Supporting Grounds/button_Add_another_document'), 5)

WebUI.click(findTestObject('Supporting Grounds/button_Add_another_document'))

WebUI.click(findTestObject('Supporting Grounds/button_SelectFile4'))

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Upload File'), [('exeFileName') : 'Jpeg_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('Supporting Grounds/button_Add_another_document'), 5)

WebUI.click(findTestObject('Supporting Grounds/button_Add_another_document'))

WebUI.click(findTestObject('Supporting Grounds/button_Select_File5'))

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Upload File'), [('exeFileName') : 'PNG_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('Planning Application details/button_Save_Continue'), 5)

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Supporting Grounds/status_Complete_Supporting_Docs'), 10)

WebUI.verifyElementText(findTestObject('Supporting Grounds/status_Complete_Supporting_Docs'), 'COMPLETED')

