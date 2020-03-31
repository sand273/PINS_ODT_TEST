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

WebUI.waitForElementVisible(findTestObject('Application Technical Reports/link_Technical_Reports'), 5)

WebUI.click(findTestObject('Application Technical Reports/link_Technical_Reports'))

WebUI.waitForElementVisible(findTestObject('Application Technical Reports/message_Technical_Reports'), 5)

WebUI.verifyElementText(findTestObject('Application Technical Reports/message_Technical_Reports'), verData.getValue(1, 62))

WebUI.click(findTestObject('Technical Reports Post Decision/link_Help_File_Formats'))

WebUI.waitForElementVisible(findTestObject('Technical Reports Post Decision/list_Help_File_Formats'), 5)

WebUI.verifyElementText(findTestObject('Technical Reports Post Decision/list_Help_File_Formats'), verData.getValue(1, 32))

WebUI.click(findTestObject('Application Technical Reports/message_Technical_Reports'))

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Upload File'), [('exeFileName') : 'Doc_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('Technical Reports Post Decision/button_Add_Another_File'), 5)

WebUI.waitForElementVisible(findTestObject('Technical Reports Post Decision/dropdown_Select_Report_Type'), 5)

not_run: def data = WebUI.getText(findTestObject('Technical Reports Post Decision/dropdown_Select_Report_Type')).replaceAll(
    '\\s+', '').trim()

not_run: WebUI.verifyMatch(data, verData.getValue(1, 40).replaceAll('\\s+', '').trim(), false, FailureHandling.STOP_ON_FAILURE)

WebUI.selectOptionByValue(findTestObject('Technical Reports Post Decision/dropdown_Select_Report_Type'), 'Other reports', 
    false)

WebUI.click(findTestObject('Technical Reports Post Decision/button_Add_Another_File'))

WebUI.waitForElementClickable(findTestObject('Technical Reports Post Decision/button_Select_File2'), 5)

WebUI.doubleClick(findTestObject('Technical Reports Post Decision/button_Select_File2'))

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Upload File'), [('exeFileName') : 'Pdf_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

WebUI.waitForElementClickable(findTestObject('Technical Reports Post Decision/button_Add_Another_File'), 5)

WebUI.waitForElementVisible(findTestObject('Technical Reports Post Decision/dropdown_Select_Report2'), 5)

WebUI.click(findTestObject('Technical Reports Post Decision/dropdown_Select_Report2'))

WebUI.selectOptionByValue(findTestObject('Technical Reports Post Decision/dropdown_Select_Report2'), 'Other reports', false)

WebUI.click(findTestObject('Technical Reports Post Decision/button_Add_Another_File'))

WebUI.waitForElementClickable(findTestObject('Technical Reports Post Decision/button_Select_File3'), 5)

WebUI.doubleClick(findTestObject('Technical Reports Post Decision/button_Select_File3'))

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Upload File'), [('exeFileName') : 'Tiff_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('Technical Reports Post Decision/button_Add_Another_File'), 5)

WebUI.waitForElementVisible(findTestObject('Technical Reports Post Decision/dropdown_Select_Report3'), 5)

WebUI.click(findTestObject('Technical Reports Post Decision/dropdown_Select_Report3'))

WebUI.selectOptionByValue(findTestObject('Technical Reports Post Decision/dropdown_Select_Report3'), 'Other reports', false)

WebUI.click(findTestObject('Technical Reports Post Decision/button_Add_Another_File'))

WebUI.waitForElementClickable(findTestObject('Technical Reports Post Decision/button_Select_File4'), 5)

WebUI.doubleClick(findTestObject('Technical Reports Post Decision/button_Select_File4'))

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Upload File'), [('exeFileName') : 'Jpeg_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('Technical Reports Post Decision/button_Add_Another_File'), 5)

WebUI.waitForElementVisible(findTestObject('Technical Reports Post Decision/dropdown_Select_Report4'), 5)

WebUI.click(findTestObject('Technical Reports Post Decision/dropdown_Select_Report4'))

WebUI.selectOptionByValue(findTestObject('Technical Reports Post Decision/dropdown_Select_Report4'), 'Other reports', false)

WebUI.click(findTestObject('Technical Reports Post Decision/button_Add_Another_File'))

WebUI.waitForElementClickable(findTestObject('Technical Reports Post Decision/button_Select_File5'), 5)

WebUI.doubleClick(findTestObject('Technical Reports Post Decision/button_Select_File5'))

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Upload File'), [('exeFileName') : 'PNG_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Technical Reports Post Decision/dropdown_Select_Report5'), 5)

WebUI.click(findTestObject('Technical Reports Post Decision/dropdown_Select_Report5'))

WebUI.selectOptionByValue(findTestObject('Technical Reports Post Decision/dropdown_Select_Report5'), 'Other reports', false)

WebUI.waitForElementClickable(findTestObject('Planning Application details/button_Save_Continue'), 5)

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Technical Reports Post Decision/status_Complete_Other_Documents'), 10)

WebUI.verifyElementText(findTestObject('Technical Reports Post Decision/status_Complete_Other_Documents'), 'COMPLETED')

