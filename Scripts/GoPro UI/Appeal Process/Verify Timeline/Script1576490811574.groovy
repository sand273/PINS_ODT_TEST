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

def testData = TestDataFactory.findTestData('Data Files/User_Profile')

def siteData = TestDataFactory.findTestData('Data Files/Site_Details')

Date today = new Date()

Date stDate

Date enDate

Date statDate

Date queDueDate

Date decDueDate

Date finalCommDate

Date targetStDate

String todaysDate = today.format('dd/MM/yyyy')

use(groovy.time.TimeCategory, { 
        stDate = (today + 10.weeks)

        enDate = (today + 12.weeks)

        statDate = (today + 5.weeks)

        queDueDate = (today + 1.weeks)

        decDueDate = (today + 14.weeks)

        finalCommDate = (today + 7.weeks)

        targetStDate = (stDate - 8.weeks)
    })

WebUI.callTestCase(findTestCase('GoPro UI/Login/Case Officer'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('GoPro UI/Generic/Search Appeal'), [:], FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/dropdown_Status_Programmed'), 'defaultSelected', 
    'true', 5) == true) {
    WebUI.selectOptionByValue(findTestObject('GoPro UI/Case Summary/select_AbeyanceCase'), '702A622C-E990-473D-B462-751ECE315DCF', 
        true)

    WebUI.click(findTestObject('GoPro UI/Case Summary/button_Save'))
}

WebUI.switchToWindowIndex(1)

WebUI.refresh()

WebUI.delay(1)

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/dropdown_Status_Case_Started'), 'defaultSelected', 
    'true', 2)

WebUI.waitForElementHasAttribute(findTestObject('GoPro UI/Case Summary/date_Case_Start'), 'value', 5)

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/date_Case_Start'), 'value', todaysDate, 1)

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/date_LPA_Statement'), 'value', statDate.format('dd/MM/yyyy').toString(), 
    1)

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/date_Decision_Due'), 'value', decDueDate.format(
        'dd/MM/yyyy').toString(), 1)

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/date_LPA_Questionaire_Due'), 'value', queDueDate.format(
        'dd/MM/yyyy').toString(), 1)

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/date_Final_Comments'), 'value', finalCommDate.format(
        'dd/MM/yyyy').toString(), 1)

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/date_Final_Comments_Publish'), 'value', '', 1)

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/date_LPA_Questionaire_Publish'), 'value', '', 1)

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/date_Event'), 'value', '', 1)

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/date_LPA_Published'), 'value', '', 1)

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/date_IP_Published'), 'value', '', 1)

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/date_LPA_Application'), 'value', '', 1)

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/date_LPA_Application_Decision'), 'value', '', 1)

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/date_Case_Turned_Away'), 'value', '', 1)

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/date_Case_Withdrawn'), 'value', '', 1)

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/date_Decision_Issued'), 'value', '', 1)

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/date_Abeyance_Start'), 'value', '', 1)

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/date_Abeyance_End'), 'value', '', 1)

WebUI.closeBrowser()

