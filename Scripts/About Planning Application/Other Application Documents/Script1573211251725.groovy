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

def verData = TestDataFactory.findTestData('Data Files/Verification')

WebUI.waitForElementVisible(findTestObject('Other Application Documents/link_Other_Documents'), 2)

WebUI.click(findTestObject('Other Application Documents/link_Other_Documents'))

WebUI.waitForElementVisible(findTestObject('Other Application Documents/message_Technical_Reports'), 3)

WebUI.verifyElementText(findTestObject('Other Application Documents/message_Technical_Reports'), verData.getValue(1, 39))

WebUI.click(findTestObject('Other Application Documents/button_Select_File'))

WebUI.callTestCase(findTestCase('Generic/Upload_File'), [('exeFileName') : 'Doc_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Other Application Documents/dropdown_Select_Report_Type'), 2)

WebUI.verifyElementText(findTestObject('Other Application Documents/dropdown_Select_Report_Type'), verData.getValue(1, 40))

WebUI.waitForElementVisible(findTestObject('Other Application Documents/button_Add_Another_File'), 2)

WebUI.click(findTestObject('Other Application Documents/button_Add_Another_File'))

WebUI.click(findTestObject('Other Application Documents/button_Select_File2'))

WebUI.callTestCase(findTestCase('Generic/Upload_File'), [('exeFileName') : 'Pdf_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Other Application Documents/button_Add_Another_File'), 2)

WebUI.click(findTestObject('Other Application Documents/button_Add_Another_File'))

WebUI.click(findTestObject('Other Application Documents/button_Select_File3'))

WebUI.callTestCase(findTestCase('Generic/Upload_File'), [('exeFileName') : 'Tiff_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Other Application Documents/button_Add_Another_File'), 2)

WebUI.click(findTestObject('Other Application Documents/button_Add_Another_File'))

WebUI.click(findTestObject('Other Application Documents/button_Select_File4'))

WebUI.callTestCase(findTestCase('Generic/Upload_File'), [('exeFileName') : 'Jpeg_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Other Application Documents/button_Add_Another_File'), 2)

not_run: WebUI.scrollToElement(findTestObject('Other Application Documents/button_Add_Another_File'), 0)

WebUI.click(findTestObject('Other Application Documents/button_Add_Another_File'))

WebUI.click(findTestObject('Other Application Documents/button_Select_File5'))

WebUI.callTestCase(findTestCase('Generic/Upload_File'), [('exeFileName') : 'PNG_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Other Application Documents/status_Complete_Other_Documents'), 5)

WebUI.verifyElementText(findTestObject('Other Application Documents/status_Complete_Other_Documents'), 'COMPLETED')

