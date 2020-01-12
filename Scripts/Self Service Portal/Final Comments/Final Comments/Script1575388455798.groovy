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

String queRefMessage

def testData = TestDataFactory.findTestData('Data Files/GoPro_UI_Verification')

def verData = TestDataFactory.findTestData('Data Files/Complete_Questionaire')

WebUI.callTestCase(findTestCase('Self Service Portal/Login/Case Officer'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Search Appeal'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Final Comments/status_Final_Comments'), 3)

WebUI.verifyElementText(findTestObject('Final Comments/status_Final_Comments'), testData.getValue(1, 2))

WebUI.verifyElementVisible(findTestObject('Final Comments/message_Final_Comments'))

not_run: WebUI.verifyElementVisible(findTestObject('Final Comments/status_Days_Left'))

WebUI.click(findTestObject('Final Comments/button_Make_Final_Comment'))

WebUI.waitForElementVisible(findTestObject('Submit Statement/button_Start_Now'), 5)

WebUI.click(findTestObject('Submit Statement/button_Start_Now'))

WebUI.waitForElementVisible(findTestObject('Final Comments/message_Upload_Final'), 3)

WebUI.click(findTestObject('Final Comments/button_Upload_File'))

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Upload File'), [('exeFileName') : 'Final_Comments.exe'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Final Comments/button_Submit'))

WebUI.waitForElementVisible(findTestObject('Complete Questionaire/title_Questionaire_Received'), 3)

WebUI.verifyElementText(findTestObject('Complete Questionaire/title_Questionaire_Received'), verData.getValue(1, 7))

WebUI.verifyElementVisible(findTestObject('Complete Questionaire/message_Questionaire_Reference_Num'))

queRefMessage = WebUI.getText(findTestObject('Complete Questionaire/message_Questionaire_Reference_Num'))

WebUI.verifyMatch(queRefMessage, verData.getValue(1, 8), true)

WebUI.verifyElementText(findTestObject('Complete Questionaire/message_Ref_Num_Value'), 'W/'+GlobalVariable.ApplicationRef)

WebUI.closeBrowser()

