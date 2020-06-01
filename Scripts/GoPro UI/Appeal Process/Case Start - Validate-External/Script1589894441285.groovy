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

if (GlobalVariable.caseType == 'Hearing')
{
	WebUI.callTestCase(findTestCase('GoPro UI/Generic/Search Appeal - Hearing'), [:], FailureHandling.STOP_ON_FAILURE)
}
else
{
	WebUI.callTestCase(findTestCase('GoPro UI/Generic/Search Appeal'), [:], FailureHandling.STOP_ON_FAILURE)
}

try {
    WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/dropdown_Validation_Required'), 'defaultSelected', 
        'true', 5)
}
catch (Exception ex) {
    if (WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/dropdown_Status_Ready_Programming'), 'defaultSelected', 
        'true', 5) == true) {
         continue res; //goto label res
    }
} 

WebUI.verifyElementVisible(findTestObject('GoPro UI/Case Summary/input_Case Officer'))

WebUI.click(findTestObject('GoPro UI/Case Summary/button_Graph'))

WebUI.switchToWindowIndex(1)

WebUI.delay(1)

WebUI.click(findTestObject('GoPro UI/Case Summary/select_AbeyanceCase'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Summary/dropdown_Validation_InProgress'), 5)

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/dropdown_Validation_InProgress'), 'defaultSelected', 
    'true', 5)

WebUI.click(findTestObject('GoPro UI/Case Summary/button_External_Review'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Summary/dropdown_Validation_External'), 5)

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/dropdown_Validation_External'), 'defaultSelected',
			'true', 5)

WebUI.click(findTestObject('GoPro UI/Case Summary/icon_Validate_Case'))
	
WebUI.switchToWindowIndex(1)

WebUI.refresh()

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Summary/select_AbeyanceCase'), 5)

WebUI.delay(1)

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/input_Case Officer'), 'value', 'Autotest_1', 2)

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/dropdown_Status_Ready_Programming'), 'defaultSelected', 
    'true', 5)

//label res
res: WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/date_Validation'), 'value', todaysDate, 1)

WebUI.click(findTestObject('GoPro UI/Programming/link_Programming'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Programming/title_Programming'), 5)

WebUI.click(findTestObject('GoPro UI/Programming/field_Inspector'))

WebUI.sendKeys(findTestObject('GoPro UI/Programming/field_Inspector'), 'Autotest_1')

WebUI.delay(1)

WebUI.sendKeys(findTestObject('GoPro UI/Programming/field_Inspector'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('GoPro UI/Programming/date_Program_Start'))

WebUI.setText(findTestObject('GoPro UI/Programming/date_Program_Start'), stDate.format('dd/MM/yyyy').toString())

WebUI.setText(findTestObject('GoPro UI/Programming/date_Program_End'), enDate.format('dd/MM/yyyy').toString())

WebUI.focus(findTestObject('GoPro UI/Programming/dropdown_Program_Approval'))

WebUI.delay(1)

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Programming/dropdown_Status_Provisional'), 'defaultSelected', 
    'true', 5)

WebUI.click(findTestObject('GoPro UI/Case Summary/button_Save'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Summary/link_Processing'), 5)

WebUI.click(findTestObject('GoPro UI/Case Summary/link_Processing'))

WebUI.waitForElementPresent(findTestObject('GoPro UI/Case Summary/label_Processing'), 10)

WebUI.switchToWindowIndex(1)

WebUI.waitForPageLoad(5, FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/dropdown_Status_Programmed'), 'defaultSelected', 
    'true', 5)

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/date_Programmed'), 'value', todaysDate, 1)

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/date_Target_Start'), 'value', targetStDate.format(
        'dd/MM/yyyy').toString(), 1)

WebUI.click(findTestObject('GoPro UI/Case Summary/button_Start_Case'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Summary/message_Start_Case_Publish'), 10)

WebUI.verifyElementText(findTestObject('GoPro UI/Case Summary/message_Start_Case_Publish'), siteData.getValue(2, 1))

WebUI.click(findTestObject('GoPro UI/Programming/button_Publish'))

WebUI.waitForElementPresent(findTestObject('GoPro UI/Case Summary/label_Processing'), 10)

WebUI.delay(2)

WebUI.refresh()

WebUI.closeWindowIndex(1)

WebUI.closeBrowser()

