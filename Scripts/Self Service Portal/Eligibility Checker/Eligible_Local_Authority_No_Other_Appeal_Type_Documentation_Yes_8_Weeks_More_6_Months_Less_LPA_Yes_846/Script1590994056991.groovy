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

def testData = TestDataFactory.findTestData('Data Files/Eligibility_Data')

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Launch Portal'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Appeal planning decision/a_Start now'), 1)

while(WebUI.verifyElementVisible(findTestObject('Appeal planning decision/a_Start now'), FailureHandling.OPTIONAL)){
	WebUI.click(findTestObject('Appeal planning decision/a_Start now'),FailureHandling.OPTIONAL)
}

WebUI.waitForElementVisible(findTestObject('Appeal planning decision/end_User_Question'), 2)

WebUI.verifyElementText(findTestObject('Appeal planning decision/end_User_Question'), verData.getValue(1, 1))

WebUI.click(findTestObject('Appeal planning decision/input_Yes_option'))

WebUI.delay(1)

WebUI.waitForElementClickable(findTestObject('Appeal planning decision/button_Continue'), 2)

WebUI.click(findTestObject('Appeal planning decision/button_Continue'))

WebUI.waitForElementVisible(findTestObject('Appeal planning decision/end_User_Question'), 2)

WebUI.verifyElementText(findTestObject('Appeal planning decision/end_User_Question'), verData.getValue(1, 19))

WebUI.scrollToElement(findTestObject('Appeal planning decision/input_Yes_option'), 3)

WebUI.waitForElementClickable(findTestObject('Appeal planning decision/input_Yes_option'), 3)

WebUI.delay(1)

WebUI.click(findTestObject('Appeal planning decision/input_Yes_option'))

WebUI.waitForElementClickable(findTestObject('Appeal planning decision/button_Continue'), 2)

WebUI.click(findTestObject('Appeal planning decision/button_Continue'))

WebUI.waitForElementVisible(findTestObject('Appeal planning decision/end_User_Question'), 2)

WebUI.verifyElementText(findTestObject('Appeal planning decision/end_User_Question'), verData.getValue(1, 3))

WebUI.click(findTestObject('Appeal planning decision/input_No_option'))

WebUI.waitForElementClickable(findTestObject('Appeal planning decision/button_Continue'), 2)

WebUI.click(findTestObject('Appeal planning decision/button_Continue'))

WebUI.waitForElementVisible(findTestObject('Appeal planning decision/end_User_Question'), 2)

WebUI.verifyElementText(findTestObject('Appeal planning decision/end_User_Question'), verData.getValue(1, 104))

WebUI.click(findTestObject('Appeal planning decision/option_Other_Appeal_Type'))

WebUI.waitForElementClickable(findTestObject('Appeal planning decision/button_Continue'), 2)

WebUI.click(findTestObject('Appeal planning decision/button_Continue'))

WebUI.waitForElementVisible(findTestObject('Appeal planning decision/end_User_Question'), 2)

WebUI.verifyElementText(findTestObject('Appeal planning decision/end_User_Question'), verData.getValue(1, 13))

WebUI.click(findTestObject('Appeal planning decision/input_Yes_option'))

WebUI.click(findTestObject('Appeal planning decision/button_Continue'))

WebUI.waitForElementVisible(findTestObject('Appeal planning decision/end_User_Question'), 2)

WebUI.verifyElementText(findTestObject('Appeal planning decision/end_User_Question'), verData.getValue(1, 12))

WebUI.click(findTestObject('Appeal planning decision/input_Yes_option'))

WebUI.click(findTestObject('Appeal planning decision/button_Continue'))

WebUI.waitForElementClickable(findTestObject('Appeal planning decision/input_Day'), 1)

WebUI.setText(findTestObject('Appeal planning decision/input_Day'), testData.getValue(2, 1))

WebUI.setText(findTestObject('Appeal planning decision/input_Month'), testData.getValue(3, 1))

WebUI.setText(findTestObject('Appeal planning decision/input_Year'), testData.getValue(4, 1))

WebUI.click(findTestObject('Appeal planning decision/button_Continue'))

WebUI.waitForElementVisible(findTestObject('Appeal planning decision/end_User_Question'), 2)

WebUI.verifyElementText(findTestObject('Appeal planning decision/end_User_Question'), verData.getValue(1, 14))

WebUI.click(findTestObject('Appeal planning decision/input_Yes_option'))

WebUI.click(findTestObject('Appeal planning decision/button_Continue'))

WebUI.waitForElementClickable(findTestObject('Appeal planning decision/input_Day'), 1)

WebUI.setText(findTestObject('Appeal planning decision/input_Day'), testData.getValue(2, 1))

WebUI.setText(findTestObject('Appeal planning decision/input_Month'), testData.getValue(3, 1))

WebUI.setText(findTestObject('Appeal planning decision/input_Year'), testData.getValue(4, 1))

WebUI.click(findTestObject('Appeal planning decision/button_Continue'))

WebUI.waitForElementVisible(findTestObject('Appeal planning decision/eligibility_Confirmed'), 2)

WebUI.verifyElementText(findTestObject('Appeal planning decision/eligibility_Confirmed'), verData.getValue(1, 9))

WebUI.verifyElementText(findTestObject('Appeal planning decision/text_Appeal_Form_Name'), verData.getValue(1, 131), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Appeal planning decision/button_Appeal_Now'))

WebUI.verifyElementText(findTestObject('Appeal planning decision/list_Confirmation'), verData.getValue(1, 16))

