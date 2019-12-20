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
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory

def verData = TestDataFactory.findTestData('Data Files/Portal_Verification')

WebUI.waitForElementVisible(findTestObject('Main grounds of Appeal/link_Main_grounds'), 2)

WebUI.click(findTestObject('Main grounds of Appeal/link_Main_grounds'))

WebUI.waitForElementVisible(findTestObject('Main grounds of Appeal/message_special_category_information'), 2)

WebUI.verifyElementText(findTestObject('Main grounds of Appeal/message_special_category_information'), verData.getValue(
        1, 48))

WebUI.click(findTestObject('Main grounds of Appeal/link_Help_with_Preparing'))

WebUI.waitForElementVisible(findTestObject('Main grounds of Appeal/frame_Prepare_Statement'), 2)

WebUI.verifyElementText(findTestObject('Main grounds of Appeal/frame_Prepare_Statement'), verData.getValue(1, 54))

WebUI.click(findTestObject('Main grounds of Appeal/input_Yes_AppealSpecialCategory'))

WebUI.verifyElementText(findTestObject('Main grounds of Appeal/frame_Grounds_of_Appeal'), verData.getValue(1, 50))

WebUI.verifyElementText(findTestObject('Main grounds of Appeal/message_ submit_grounds_of_appeal'), verData.getValue(1, 
        49))

WebUI.click(findTestObject('Main grounds of Appeal/button_Select_File'))

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Upload File'), [('exeFileName') : 'Pdf_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Main grounds of Appeal/input_understand_AppealAgreement'))

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Main grounds of Appeal/status_Complete_Grounds'), 3)

WebUI.verifyElementText(findTestObject('Main grounds of Appeal/status_Complete_Grounds'), 'COMPLETED')

