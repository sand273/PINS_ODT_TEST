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

WebUI.waitForElementVisible(findTestObject('Ownership/link_Ownership'), 5)

WebUI.click(findTestObject('Ownership/link_Ownership'))

WebUI.waitForElementVisible(findTestObject('Ownership/message_Sole_Owner'), 5)

WebUI.verifyElementText(findTestObject('Ownership/message_Sole_Owner'), verData.getValue(1, 58))

WebUI.click(findTestObject('Ownership/option_Own_Site_No'))

WebUI.click(findTestObject('Ownership/option_Notified_Owners_Yes'))

WebUI.click(findTestObject('Ownership/link_Help_Serving_Notice'))

WebUI.verifyElementText(findTestObject('Ownership/text_Help_Serving_Notice'), verData.getValue(1, 82))

WebUI.verifyElementText(findTestObject('Ownership/text_Certified_Noticed'), verData.getValue(1, 83))

WebUI.click(findTestObject('Ownership/link_Help_File_Formats'))

WebUI.verifyElementText(findTestObject('Ownership/text_Help_File_Formats'), verData.getValue(1, 32))

WebUI.click(findTestObject('Ownership/link_Upload_Owners_File'))

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Upload File'), [('exeFileName') : 'Doc_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Ownership/button_Remove'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Agricultural_Holding (Scenario 4)'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Ownership/status_Complete_Ownership'), 10)

WebUI.verifyElementText(findTestObject('Ownership/status_Complete_Ownership'), 'COMPLETED')

