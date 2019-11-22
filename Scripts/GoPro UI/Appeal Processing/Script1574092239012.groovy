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

String todaysDate = today.format('dd/MM/yyyy')

use(groovy.time.TimeCategory, { 
        stDate = (today + 10.weeks)

        enDate = (today + 12.weeks)

        statDate = (today + 5.weeks)

        queDueDate = (today + 1.weeks)

        decDueDate = (today + 14.weeks)

        finalCommDate = (today + 7.weeks)
    })

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.URL)

WebUI.maximizeWindow()

WebUI.click(findTestObject('Object Repository/GoPro UI/Page_PINS Test  GoPro/a_GoPro UI'))

WebUI.waitForElementVisible(findTestObject('Object Repository/GoPro UI/Page_Login/input_User name'), 3)

WebUI.setText(findTestObject('Object Repository/GoPro UI/Page_Login/input_User name'), 'Autotest_1')

WebUI.focus(findTestObject('Object Repository/GoPro UI/Page_Login/input_Password'))

WebUI.setEncryptedText(findTestObject('Object Repository/GoPro UI/Page_Login/input_Password'), '0cU2R0tWEjl49ICU6OTr2A==')

WebUI.click(findTestObject('Object Repository/GoPro UI/Page_Login/button_Login'))

WebUI.click(findTestObject('Object Repository/GoPro UI/Page_pins My cases/link_My events_location_arrow'))

WebUI.click(findTestObject('Object Repository/GoPro UI/Page_pins My cases/link_Holding_List'))

WebUI.click(findTestObject('Object Repository/GoPro UI/Case Summary/input_Search'))

WebUI.sendKeys(findTestObject('Object Repository/GoPro UI/Case Summary/input_Search'), '4001531')

WebUI.click(findTestObject('Object Repository/GoPro UI/Case Summary/button_Search'))

WebUI.waitForElementPresent(findTestObject('GoPro UI/Case Summary/list_Case_Ref'), 5)

WebUI.doubleClick(findTestObject('GoPro UI/Case Summary/list_Case_Ref'))

WebUI.switchToWindowIndex(1)

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Summary/panel_Left_Processing_Timeline'), 5)

WebUI.verifyElementText(findTestObject('GoPro UI/Case Summary/panel_Left_Processing_Timeline'), verData.getValue(1, 1))

WebUI.verifyElementVisible(findTestObject('GoPro UI/Case Summary/select_AbeyanceCase'))

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/dropdown_Validation_Required'), 'defaultSelected', 
    'true', 5)

WebUI.verifyElementVisible(findTestObject('GoPro UI/Case Summary/input_Case Officer'))

WebUI.click(findTestObject('GoPro UI/Case Summary/button_Graph'))

WebUI.switchToWindowIndex(1)

WebUI.delay(1)

WebUI.click(findTestObject('GoPro UI/Case Summary/select_AbeyanceCase'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/dropdown_Validation_InProgress'), 'defaultSelected', 
    'true', 5)

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/input_Case Officer'), 'value', 'Autotest_1', 2)

WebUI.click(findTestObject('GoPro UI/Case Summary/icon_Validate_Case'))

WebUI.switchToWindowIndex(1)

WebUI.refresh()

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Summary/select_AbeyanceCase'), 5)

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/dropdown_Status_Ready_Programming'), 'defaultSelected', 
    'true', 5)

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/date_Validation'), 'value', todaysDate, 1)

WebUI.click(findTestObject('GoPro UI/Programming/link_Programming'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Programming/title_Programming'), 2)

WebUI.click(findTestObject('GoPro UI/Programming/field_Inspector'))

WebUI.sendKeys(findTestObject('GoPro UI/Programming/field_Inspector'), 'Autotest_1')

WebUI.delay(1)

WebUI.sendKeys(findTestObject('GoPro UI/Programming/field_Inspector'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('GoPro UI/Programming/date_Program_Start'))

WebUI.setText(findTestObject('GoPro UI/Programming/date_Program_Start'), stDate.format('dd/MM/yyyy').toString())

WebUI.setText(findTestObject('GoPro UI/Programming/date_Program_End'), enDate.format('dd/MM/yyyy').toString())

WebUI.focus(findTestObject('GoPro UI/Programming/dropdown_Program_Approval'))

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Programming/dropdown_Status_Provisional'), 'defaultSelected', 
    'true', 2)

WebUI.click(findTestObject('GoPro UI/Case Summary/button_Save'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Summary/link_Processing'), 3)

WebUI.click(findTestObject('GoPro UI/Case Summary/link_Processing'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Programming/button_Programming'), 3)

WebUI.click(findTestObject('GoPro UI/Programming/button_Programming'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Summary/select_AbeyanceCase'), 8)

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/dropdown_Status_Programmed'), 'defaultSelected', 
    'true', 5)

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/date_Programmed'), 'value', todaysDate, 1)

WebUI.click(findTestObject('GoPro UI/Case Summary/button_Start_Case'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Summary/message_Start_Case_Publish'), 8)

WebUI.verifyElementText(findTestObject('GoPro UI/Case Summary/message_Start_Case_Publish'), siteData.getValue(2, 1))

WebUI.click(findTestObject('GoPro UI/Programming/button_Publish'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Summary/select_AbeyanceCase'), 20)

WebUI.switchToWindowIndex(1)

not_run: WebUI.click(findTestObject('GoPro UI/Case Summary/select_AbeyanceCase'))

WebUI.focus(findTestObject('GoPro UI/Case Summary/frame_CaseForm'))

not_run: WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/dropdown_Status_Case_Started'), 'defaultSelected', 
    'true', 2)

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

