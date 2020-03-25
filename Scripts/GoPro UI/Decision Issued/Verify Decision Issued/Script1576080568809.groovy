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

Date issueDate

Date today = new Date()

WebUI.callTestCase(findTestCase('GoPro UI/Login/Case Officer'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('GoPro UI/Generic/Search Appeal'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/dropdown_Decision_Issued'), 'defaultSelected', 'true', 
    5)

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/date_Decision_Issued'), 'value', today.format(
        'dd/MM/yyyy').toString(), 1)

WebUI.click(findTestObject('GoPro UI/Case Summary/button_Save'))

WebUI.closeBrowser()

