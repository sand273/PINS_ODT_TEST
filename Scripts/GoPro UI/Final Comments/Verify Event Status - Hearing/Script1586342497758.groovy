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

def testData = TestDataFactory.findTestData('Data Files/GoPro_UI_Verification')

Date today = new Date()

String todaysDate = today.format('dd/MM/yyyy')

WebUI.callTestCase(findTestCase('GoPro UI/Login/Case Officer'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('GoPro UI/Generic/Search Appeal - Hearing'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/dropdown_Event_Status'), 'defaultSelected', 'true', 
    5)

not_run: WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/date_Final_Comments_Publish'), 'value', 
    todaysDate, 1)

not_run: WebUI.click(findTestObject('GoPro UI/Case Documents/tab_Case_Documents'))

not_run: WebUI.waitForElementClickable(findTestObject('GoPro UI/Case Summary/input_Search'), 10)

not_run: WebUI.click(findTestObject('GoPro UI/Case Summary/input_Search'))

not_run: WebUI.sendKeys(findTestObject('GoPro UI/Case Summary/input_Search'), testData.getValue(1, 8))

not_run: WebUI.click(findTestObject('GoPro UI/Case Summary/button_Search'))

not_run: WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents/link_LPA_Statement'), 20)

not_run: WebUI.click(findTestObject('GoPro UI/Case Documents/link_LPA_Statement'))

not_run: WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents/status_Document_Published'), 2)

not_run: WebUI.delay(1)

not_run: WebUI.waitForElementClickable(findTestObject('GoPro UI/Case Documents/button_Clear_Search'), 3)

not_run: WebUI.click(findTestObject('GoPro UI/Case Documents/button_Clear_Search'))

not_run: WebUI.sendKeys(findTestObject('GoPro UI/Case Summary/input_Search'), testData.getValue(1, 9))

not_run: WebUI.click(findTestObject('GoPro UI/Case Summary/button_Search'))

not_run: WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents/link_LPA_Statement'), 20)

not_run: WebUI.click(findTestObject('GoPro UI/Case Documents/link_LPA_Statement'))

not_run: WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents/status_Document_Published'), 2)

not_run: WebUI.delay(1)

not_run: WebUI.waitForElementClickable(findTestObject('GoPro UI/Case Documents/button_Clear_Search'), 3)

not_run: WebUI.click(findTestObject('GoPro UI/Case Documents/button_Clear_Search'))

WebUI.closeBrowser()
