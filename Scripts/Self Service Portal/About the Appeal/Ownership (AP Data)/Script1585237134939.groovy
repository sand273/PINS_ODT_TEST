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

WebUI.click(findTestObject('Ownership/input_Yes_Option'))

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Agricultural Holding'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Ownership/status_Complete_Ownership'), 10)

WebUI.verifyElementText(findTestObject('Ownership/status_Complete_Ownership'), 'COMPLETED')

