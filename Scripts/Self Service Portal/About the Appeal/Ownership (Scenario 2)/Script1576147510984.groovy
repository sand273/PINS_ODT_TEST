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

WebUI.waitForElementVisible(findTestObject('Ownership/link_Ownership'), 2)

WebUI.click(findTestObject('Ownership/link_Ownership'))

WebUI.waitForElementVisible(findTestObject('Ownership/message_Sole_Owner'), 2)

WebUI.verifyElementText(findTestObject('Ownership/message_Sole_Owner'), verData.getValue(1, 58))

WebUI.click(findTestObject('Ownership/Own_Site_No_Option'))

WebUI.click(findTestObject('Ownership/Notified_Owners_Yes_Option'))

WebUI.click(findTestObject('Ownership/Help_Serving_Notice_Link'))

WebUI.verifyElementText(findTestObject('Ownership/Help_Serving_Notice_Text'), verData.getValue(1, 82))

WebUI.verifyElementText(findTestObject('Ownership/Certified_Noticed_Text'), verData.getValue(1, 83))

WebUI.click(findTestObject('Ownership/Help_File_Formats_Link'))

WebUI.verifyElementText(findTestObject('Ownership/Help_File_Formats_Text'), verData.getValue(1, 32))

WebUI.click(findTestObject('Ownership/Upload_Owners_File_Link'))

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Upload File'), [('exeFileName') : 'Doc_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Ownership/Remove_Button'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Agricultural_Holding (Scenario 2)'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Ownership/status_Complete_Ownership'), 3)

WebUI.verifyElementText(findTestObject('Ownership/status_Complete_Ownership'), 'COMPLETED')

