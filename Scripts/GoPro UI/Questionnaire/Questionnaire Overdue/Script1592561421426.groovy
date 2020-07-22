import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('GoPro UI/Login/Case Officer'), [:], FailureHandling.STOP_ON_FAILURE)

if (GlobalVariable.caseType == 'Hearing') {
    WebUI.callTestCase(findTestCase('GoPro UI/Generic/Search Appeal - Hearing'), [:], FailureHandling.STOP_ON_FAILURE)
} else {
    WebUI.callTestCase(findTestCase('GoPro UI/Generic/Search Appeal'), [:], FailureHandling.STOP_ON_FAILURE)
}

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Summary/select_AbeyanceCase'), 5)

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/dropdown_Status_Case_Started'), 'defaultSelected', 
    'true', 2)

WebUI.click(findTestObject('GoPro UI/Case Summary/button_Question_Overdue'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Summary/select_AbeyanceCase'), 10)

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Summary/dropdown_Question_Overdue'), 10)

WebUI.delay(2)

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/dropdown_Question_Overdue'), 'defaultSelected', 
    'true', 5)

WebUI.closeWindowIndex(1)

WebUI.closeBrowser()

