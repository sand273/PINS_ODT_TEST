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

WebUI.waitForElementClickable(findTestObject('Local List Documentation/link_Local_List_Documentation'), 5)

WebUI.click(findTestObject('Local List Documentation/link_Local_List_Documentation'))

WebUI.waitForElementVisible(findTestObject('Local List Documentation/question_Local_List'), 5)

WebUI.verifyElementText(findTestObject('Local List Documentation/question_Local_List'), verData.getValue(1, 94))

WebUI.click(findTestObject('Local List Documentation/button_Local_List_Upload'))

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Upload File'), [('exeFileName') : 'Doc_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Local List Documentation/button_Remove_Button'), 5)

WebUI.click(findTestObject('Local List Documentation/link_Help_File'))

WebUI.waitForElementVisible(findTestObject('Local List Documentation/list_Help_File_Format'), 5)

WebUI.verifyElementText(findTestObject('Local List Documentation/list_Help_File_Format'), verData.getValue(1, 32))

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Local List Documentation/status_Complete_Local_List_Documents'), 10)

WebUI.verifyElementText(findTestObject('Local List Documentation/status_Complete_Local_List_Documents'), 'COMPLETED')

