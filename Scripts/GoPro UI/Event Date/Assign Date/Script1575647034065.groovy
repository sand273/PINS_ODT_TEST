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

def verData = TestDataFactory.findTestData('Data Files/GoPro_UI_Verification')

Date eventDate

Date today = new Date()

use(groovy.time.TimeCategory, { 
        eventDate = (today + 11.weeks)
    })

WebUI.callTestCase(findTestCase('GoPro UI/Login/Case Officer'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('GoPro UI/Generic/Search Appeal'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('GoPro UI/Programming/link_Programming'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Programming/title_Programming'), 2)

WebUI.verifyElementVisible(findTestObject('GoPro UI/Programming/dropdown_Event'))

WebUI.verifyElementText(findTestObject('GoPro UI/Programming/dropdown_Event'), verData.getValue(1, 4))

WebUI.setText(findTestObject('GoPro UI/Programming/date_Event'), eventDate.format('dd/MM/yyyy').toString())

WebUI.scrollToElement(findTestObject('GoPro UI/Case Summary/button_Save'), 3)

WebUI.click(findTestObject('GoPro UI/Case Summary/button_Save'))

WebUI.click(findTestObject('GoPro UI/Case Summary/link_Timeline'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Summary/title_Timeline'), 3)

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Programming/date_Event'), 'value', eventDate.format('dd/MM/yyyy').toString(), 
    1)

WebUI.click(findTestObject('GoPro UI/Case Summary/link_Processing'))

WebUI.waitForElementPresent(findTestObject('GoPro UI/Case Summary/label_Processing'), 5)

WebUI.click(findTestObject('GoPro UI/Case Summary/button_Decision_Pending'))

WebUI.waitForElementPresent(findTestObject('GoPro UI/Case Summary/label_Processing'), 5)

WebUI.verifyElementVisible(findTestObject('GoPro UI/Case Summary/select_AbeyanceCase'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/dropdown_Decision_Pending'), 'defaultSelected', 
    'true', 5)

WebUI.click(findTestObject('GoPro UI/Case Documents/tab_Case_Documents'))

WebUI.callTestCase(findTestCase('GoPro UI/Generic/Appeal Decision - Actions Menu'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

WebUI.refresh()

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents/tab_Case_Documents'), 5)

WebUI.click(findTestObject('GoPro UI/Case Documents/tab_Case_Documents'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents/button_External_Documents'), 5)

WebUI.click(findTestObject('GoPro UI/Case Documents/button_External_Documents'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents/check_External_Documents'), 5)

WebUI.click(findTestObject('GoPro UI/Case Documents/check_External_Documents'))

WebUI.waitForElementPresent(findTestObject('GoPro UI/Case Documents/link_Appeal_Decision'), 5)

not_run: WebUI.refresh()

WebUI.scrollToPosition(9999999, 9999999)

WebUI.click(findTestObject('GoPro UI/Case Documents/link_Appeal_Decision'))

WebUI.waitForElementPresent(findTestObject('GoPro UI/Case Documents/status_Appeal_InDraft'), 5)

WebUI.click(findTestObject('GoPro UI/Case Documents/status_Appeal_InDraft'))

WebUI.selectOptionByIndex(findTestObject('GoPro UI/Case Documents/dropdown_Status_Change'), 4, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('GoPro UI/Case Documents/button_Primary'))

WebUI.callTestCase(findTestCase('GoPro UI/Generic/Publish Decision - Actions Menu'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()

