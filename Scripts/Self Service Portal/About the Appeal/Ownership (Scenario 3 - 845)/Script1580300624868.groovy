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

WebUI.click(findTestObject('Ownership/input_Dont_Know_Owners'))

WebUI.waitForElementVisible(findTestObject('Ownership/message_Dont_Know_Owners'), 2)

WebUI.verifyElementText(findTestObject('Ownership/message_Dont_Know_Owners'), verData.getValue(1, 88))

WebUI.click(findTestObject('Ownership/link_Completed_Certificate'))

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Upload File'), [('exeFileName') : 'Doc_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Ownership/button_Remove_Completed_Certificate'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Ownership/link_Copy_Press_Notice'))

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Upload File'), [('exeFileName') : 'Doc_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Ownership/button_Remove_Copy_Press_Notice'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Agricultural_Holding (Scenario 4)'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Ownership/status_Complete_Ownership'), 3)

WebUI.verifyElementText(findTestObject('Ownership/status_Complete_Ownership'), 'COMPLETED')

