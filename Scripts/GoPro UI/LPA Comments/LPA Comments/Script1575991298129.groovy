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

WebUI.callTestCase(findTestCase('GoPro UI/Login/Case_Officer'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('GoPro UI/Generic/Search Appeal'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/dropdown_Open_for_LPA'), 'defaultSelected', 'true', 
    5)

WebUI.click(findTestObject('GoPro UI/Case Documents/tab_Case_Documents'))

WebUI.waitForElementPresent(findTestObject('GoPro UI/Case Documents/link_Folder_Your_Comments'), 5)

WebUI.scrollToPosition(9999999, 9999999)

WebUI.click(findTestObject('GoPro UI/Case Documents/link_Your_Comments'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents/link_Interested_party_pdf'), 3)

WebUI.click(findTestObject('GoPro UI/Case Documents/link_Interested_party_pdf'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents/button_Ready_for_Publish'), 3)

WebUI.click(findTestObject('GoPro UI/Case Documents/button_Ready_for_Publish'))

WebUI.closeWindowIndex(1)

WebUI.closeBrowser()

WebUI.callTestCase(findTestCase('GoPro UI/Login/Case_Officer'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('GoPro UI/Generic/Search Appeal'), [:], FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/dropdown_Open_for_LPA'), 'defaultSelected', 
    'true', 5) == true) {
    WebUI.click(findTestObject('GoPro UI/Case Summary/button_Publish_LPA_Statement'))

    WebUI.waitForElementPresent(findTestObject('GoPro UI/Case Summary/label_Processing'), 10)
}

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/dropdown_Publish_LPA_Statement'), 'defaultSelected', 
    'true', 5)

WebUI.click(findTestObject('GoPro UI/Case Documents/tab_Case_Documents'))

WebUI.callTestCase(findTestCase('GoPro UI/Generic/Publish LPA Statements - Actions Menu'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.refresh()

not_run: WebUI.click(findTestObject('GoPro UI/Case Documents/tab_Case_Documents'))

not_run: WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents/link_Folder_LPA_Statement'), 5)

not_run: WebUI.scrollToPosition(9999999, 9999999)

not_run: WebUI.click(findTestObject('GoPro UI/Case Documents/Page_pins-test viewscaseresponses/link_Verify_LPA_Statement'))

not_run: WebUI.waitForElementClickable(findTestObject('GoPro UI/Case Documents/LPA Statement/link_Expand_LPA_statement'), 
    2)

not_run: WebUI.click(findTestObject('GoPro UI/Case Documents/LPA Statement/link_Expand_LPA_statement'))

not_run: WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents/status_Document_Published'), 2)

not_run: WebUI.click(findTestObject('GoPro UI/Case Documents/Page_pins-test viewscaseresponses/link_Upload_Pdf'), FailureHandling.STOP_ON_FAILURE)

not_run: WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents/status_Document_Published'), 2)

not_run: WebUI.waitForElementClickable(findTestObject('GoPro UI/Case Documents/link_Your_Comments'), 2)

not_run: WebUI.click(findTestObject('GoPro UI/Case Documents/link_Your_Comments'))

not_run: WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents/link_Interested_party_pdf'), 3)

not_run: WebUI.click(findTestObject('GoPro UI/Case Documents/link_Interested_party_pdf'))

not_run: WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents/status_Document_Published'), 2)

WebUI.closeWindowIndex(1)

WebUI.closeBrowser()

