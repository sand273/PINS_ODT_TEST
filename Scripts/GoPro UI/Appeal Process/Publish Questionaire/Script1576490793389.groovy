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

Date today = new Date()

String todaysDate = today.format('dd/MM/yyyy')

WebUI.callTestCase(findTestCase('GoPro UI/Login/Case Officer'), [:], FailureHandling.STOP_ON_FAILURE)

if (GlobalVariable.caseType == 'Hearing')
{
	WebUI.callTestCase(findTestCase('GoPro UI/Generic/Search Appeal - Hearing'), [:], FailureHandling.STOP_ON_FAILURE)
}
else
{
	WebUI.callTestCase(findTestCase('GoPro UI/Generic/Search Appeal'), [:], FailureHandling.STOP_ON_FAILURE)
}

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Summary/select_AbeyanceCase'), 5)

WebUI.click(findTestObject('GoPro UI/Case Documents/tab_Case_Documents'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Summary/input_Search'), 10)

WebUI.callTestCase(findTestCase('GoPro UI/Generic/Publish LPA Questionaire - Actions Menu'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents/link_folder_LPA_Questionaire'), 20)

WebUI.closeWindowIndex(1)

WebUI.switchToWindowIndex(0)

WebUI.refresh()

if (GlobalVariable.caseType == 'Hearing')
{
	WebUI.callTestCase(findTestCase('GoPro UI/Generic/Search Appeal - Hearing'), [:], FailureHandling.STOP_ON_FAILURE)
}
else
{
	WebUI.callTestCase(findTestCase('GoPro UI/Generic/Search Appeal'), [:], FailureHandling.STOP_ON_FAILURE)
}

try
{
WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/dropdown_Open_for_LPA'), 'defaultSelected', 'true', 
    5)
}
catch (Exception ex)
{
	WebUI.selectOptionByValue(findTestObject('GoPro UI/Case Summary/select_AbeyanceCase'), 'A26CF54F-19EB-45A7-BCE3-F9DBAE8A075E', true)
	WebUI.click(findTestObject('GoPro UI/Case Summary/button_Save'))
}

WebUI.refresh()

WebUI.waitForElementHasAttribute(findTestObject('GoPro UI/Case Summary/date_LPA_Questionaire_Publish'), 'value', 5)

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/date_LPA_Questionaire_Publish'), 'value', todaysDate, 
    1)

WebUI.closeWindowIndex(1)

WebUI.closeBrowser()

