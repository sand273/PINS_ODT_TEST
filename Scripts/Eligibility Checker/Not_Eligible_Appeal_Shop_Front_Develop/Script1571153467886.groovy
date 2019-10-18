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

def verData = TestDataFactory.findTestData('Data Files/Verification')

WebUI.callTestCase(findTestCase('Eligibility Checker/Appeal_Relate_Decision'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_Appeal a planning decision/input_Option_Shop_Front'))

WebUI.waitForElementClickable(findTestObject('Page_Appeal a planning decision/button_Continue'), 1)

WebUI.click(findTestObject('Object Repository/Page_Appeal a planning decision/button_Continue'))

WebUI.waitForElementPresent(findTestObject('Page_Appeal a planning decision/non_Eligible_Message'), 1)

WebUI.verifyElementText(findTestObject('Page_Appeal a planning decision/non_Eligible_Message'), verData.getValue(1, 10))

WebUI.closeBrowser()

