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

WebUI.verifyElementText(findTestObject('Ownership/question_Agricultural_Holding'), verData.getValue(1, 66))

WebUI.verifyElementText(findTestObject('Ownership/message_Appeal_Site_Forms'), verData.getValue(1, 57))

WebUI.click(findTestObject('Ownership/input_Agg_Holding_Yes'))

WebUI.waitForElementVisible(findTestObject('Ownership/message_Appellant_Status'), 5)

WebUI.verifyElementText(findTestObject('Ownership/message_Appellant_Status'), verData.getValue(1, 100))

WebUI.click(findTestObject('Ownership/input_Agg_Sole_Holding_No'))

WebUI.click(findTestObject('Ownership/input_No_Who_Owns_Holding'))

WebUI.click(findTestObject('Ownership/option_Yes_Publish_Intention'))

WebUI.click(findTestObject('Ownership/link_Agg_Copy_Press_Notice'))

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Upload File'), [('exeFileName') : 'Pdf_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Ownership/button_Remove_Agg_Copy_Press_Notice'))

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

