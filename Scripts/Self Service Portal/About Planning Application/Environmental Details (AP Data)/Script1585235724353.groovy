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

WebUI.waitForElementClickable(findTestObject('Environmental details/link_Environmental_Details'), 5)

WebUI.click(findTestObject('Environmental details/link_Environmental_Details'))

WebUI.waitForElementVisible(findTestObject('Environmental details/question_Environmental_Impact_Assessment'), 5)

WebUI.click(findTestObject('Environmental details/option_No_Env_Impact_Assessment'))

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Environmental details/question_Environmental_Statement'), 5)

WebUI.click(findTestObject('Environmental details/option_No_Environment_Statement'))

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Environmental details/status_Complete_Environment_Details'), 10)

WebUI.verifyElementText(findTestObject('Environmental details/status_Complete_Environment_Details'), 'COMPLETED')
