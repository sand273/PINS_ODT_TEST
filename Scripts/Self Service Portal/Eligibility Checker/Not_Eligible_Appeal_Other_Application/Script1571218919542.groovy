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
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

def verData = TestDataFactory.findTestData('Data Files/Portal_Verification')

WebUI.callTestCase(findTestCase('Self Service Portal/Portal-Generic/Launch_Self_Service_Portal'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Self Service Portal/Eligibility Checker/Appeal_Relate_Decision'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Appeal a planning decision/input_Option_Other_Application'))

WebUI.waitForElementClickable(findTestObject('Appeal a planning decision/button_Continue'), 1)

WebUI.click(findTestObject('Appeal a planning decision/button_Continue'))

WebUI.waitForElementVisible(findTestObject('Appeal a planning decision/non_Eligible_Message'), 2)

WebUI.verifyElementText(findTestObject('Appeal a planning decision/non_Eligible_Message'), verData.getValue(1, 10))

WebUI.closeBrowser()

