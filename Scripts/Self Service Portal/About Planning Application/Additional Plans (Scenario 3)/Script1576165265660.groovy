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
import org.openqa.selenium.Keys as Keys

def verData = TestDataFactory.findTestData('Data Files/Portal_Verification')

WebUI.delay(1)

WebUI.waitForElementVisible(findTestObject('Additional Plans/link_Additional_Plans'), 20)

WebUI.click(findTestObject('Additional Plans/link_Additional_Plans'))

WebUI.waitForElementVisible(findTestObject('Additional Plans/question_LPA_Plans'), 20)

WebUI.verifyElementText(findTestObject('Additional Plans/question_LPA_Plans'), verData.getValue(1, 37))

WebUI.click(findTestObject('Additional Plans/input_No_DifferentPlans'))

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Additional Plans/question_Other_Plans'), 20)

WebUI.verifyElementText(findTestObject('Additional Plans/question_Other_Plans'), verData.getValue(1, 38))

WebUI.click(findTestObject('Additional Plans/option_Yes_Other_Relevant_Plans'))

WebUI.click(findTestObject('Additional Plans/Upload_Other_Relevant_Plans_File'))

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Upload File'), [('exeFileName') : 'Tiff_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

WebUI.click(findTestObject('Additional Plans/Help_File_Formats_Link'))

WebUI.verifyElementText(findTestObject('Additional Plans/Help_File_Formats_Text'), verData.getValue(1, 32))

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Additional Plans/status_Complete_Additional_Plans'), 20)

WebUI.verifyElementText(findTestObject('Additional Plans/status_Complete_Additional_Plans'), 'COMPLETED')

