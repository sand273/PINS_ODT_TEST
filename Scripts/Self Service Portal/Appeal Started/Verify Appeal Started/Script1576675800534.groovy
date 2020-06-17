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

Date today = new Date()

String todaysDate = today.format('EEEE dd MMMMMMMM yyyy')

def testData = TestDataFactory.findTestData('Data Files/GoPro_UI_Verification')

WebUI.callTestCase(findTestCase('Self Service Portal/Login/Case Officer'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Complete Questionaire/link_Search'))

WebUI.setText(findTestObject('Complete Questionaire/text_Appeal_Ref'), GlobalVariable.ApplicationRef)

WebUI.click(findTestObject('Complete Questionaire/button_Search'))

WebUI.waitForElementVisible(findTestObject('Submit Statement/label_Match_Found'), 5)

WebUI.click(findTestObject('Complete Questionaire/link_Appeal_Ref'))

WebUI.waitForElementVisible(findTestObject('Final Comments/status_Final_Comments'), 5)

WebUI.verifyElementText(findTestObject('Final Comments/status_Final_Comments'), testData.getValue(1, 10))

WebUI.verifyElementText(findTestObject('Final Comments/date_Appeal_Started'), todaysDate)

WebUI.verifyElementText(findTestObject('Submit Statement/title_Appeal_Reference'), GlobalVariable.ApplicationRef)

WebUI.verifyElementText(findTestObject('Submit Statement/text_Case_Number'), GlobalVariable.ApplicationRef)

if (GlobalVariable.caseType == 'Hearing')
{
	WebUI.verifyElementVisible(findTestObject('Submit Statement/text_Hearing'))
}
else if (GlobalVariable.caseType == 'Written')
{
	WebUI.verifyElementVisible(findTestObject('Submit Statement/text_Written_Rep'))
}

WebUI.verifyElementVisible(findTestObject('Submit Statement/status_Appeal_Started'))

WebUI.closeBrowser()

