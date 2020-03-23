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
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

def verData = TestDataFactory.findTestData('Data Files/Portal_Verification')

def testData = TestDataFactory.findTestData('Data Files/Eligibility_Data')

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Launch Portal'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Self Service Portal/Eligibility Checker/Appeal_Relate_Decision'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Appeal planning decision/end_User_Question'), verData.getValue(1, 4))

WebUI.click(findTestObject('Appeal planning decision/input_Conditions_attached_option'))

WebUI.waitForElementClickable(findTestObject('Appeal planning decision/button_Continue'), 1)

WebUI.click(findTestObject('Appeal planning decision/button_Continue'))

WebUI.waitForElementVisible(findTestObject('Appeal planning decision/end_User_Question'), 2)

WebUI.verifyElementText(findTestObject('Appeal planning decision/end_User_Question'), verData.getValue(1, 6))

WebUI.click(findTestObject('Appeal planning decision/input_Full_Planning_option'))

WebUI.click(findTestObject('Appeal planning decision/button_Continue'))

WebUI.waitForElementVisible(findTestObject('Appeal planning decision/end_User_Question'), 2)

WebUI.verifyElementText(findTestObject('Appeal planning decision/end_User_Question'), verData.getValue(1, 81))

WebUI.click(findTestObject('Appeal planning decision/input_Refused_permission_option'))

WebUI.click(findTestObject('Appeal planning decision/button_Continue'))

WebUI.waitForElementVisible(findTestObject('Appeal planning decision/end_User_Question'), 2)

not_run: WebUI.verifyElementText(findTestObject('Appeal planning decision/end_User_Question'), verData.getValue(1, 7))

WebUI.click(findTestObject('Appeal planning decision/input_No_option'))

WebUI.click(findTestObject('Appeal planning decision/button_Continue'))

WebUI.waitForElementVisible(findTestObject('Appeal planning decision/end_User_Question'), 2)

WebUI.verifyElementText(findTestObject('Appeal planning decision/end_User_Question'), verData.getValue(1, 78))

WebUI.waitForElementClickable(findTestObject('Appeal planning decision/input_Day'), 1)

WebUI.setText(findTestObject('Appeal planning decision/input_Day'), testData.getValue(2, 1))

WebUI.setText(findTestObject('Appeal planning decision/input_Month'), testData.getValue(3, 1))

WebUI.setText(findTestObject('Appeal planning decision/input_Year'), testData.getValue(4, 1))

WebUI.click(findTestObject('Appeal planning decision/button_Continue'))

WebUI.waitForElementVisible(findTestObject('Appeal planning decision/eligibility_Confirmed'), 2)

WebUI.verifyElementText(findTestObject('Appeal planning decision/eligibility_Confirmed'), verData.getValue(1, 9))

WebUI.verifyElementText(findTestObject('Appeal planning decision/text_Appeal_Form_Name'), verData.getValue(1, 127))

WebUI.verifyElementVisible(findTestObject('Appeal planning decision/button_Appeal_Now'))

WebUI.verifyElementText(findTestObject('Appeal planning decision/list_Confirmation'), verData.getValue(1, 16))

not_run: WebUI.closeBrowser()

