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

def testData = TestDataFactory.findTestData('Data Files/GoPro_UI_Verification')

Date today = new Date()

String todaysDate = today.format('dd/MM/yyyy')

WebUI.callTestCase(findTestCase('GoPro UI/Login/Case Officer'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('GoPro UI/Generic/Search Appeal'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

try {
    WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/dropdown_Open_Final_Comments'), 'defaultSelected', 
        'true', 5)
}
catch (Exception ex) {
    WebUI.selectOptionByValue(findTestObject('GoPro UI/Case Summary/select_AbeyanceCase'), '9BB1233C-FC41-4926-AF53-7B00BFE6247D', 
        true)

    WebUI.click(findTestObject('GoPro UI/Case Summary/button_Save'))
} 

WebUI.switchToWindowIndex(1)

WebUI.refresh()

WebUI.delay(1)

WebUI.waitForElementHasAttribute(findTestObject('GoPro UI/Case Summary/date_LPA_Published'), 'value', 5)

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/date_LPA_Published'), 'value', todaysDate, 1)

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/date_IP_Published'), 'value', todaysDate, 1)

WebUI.click(findTestObject('GoPro UI/Case Documents/tab_Case_Documents'))

WebUI.waitForElementPresent(findTestObject('GoPro UI/Case Documents/link_Folder_LPA_Statement'), 20)

WebUI.click(findTestObject('GoPro UI/Case Summary/input_Search'))

WebUI.sendKeys(findTestObject('GoPro UI/Case Summary/input_Search'), testData.getValue(1, 5))

WebUI.click(findTestObject('GoPro UI/Case Summary/button_Search'))

if (WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents/link_LPA_Statement'), 5) == false) {
    CustomKeywords.'custom.WriteExcel.waitForObject'(150, 'GoPro UI/Case Documents/link_LPA_Statement', 'GoPro UI/Case Summary/button_Search')
}

WebUI.verifyElementText(findTestObject('GoPro UI/Case Documents/link_LPA_Statement'), testData.getValue(1, 5))

WebUI.click(findTestObject('GoPro UI/Case Documents/link_LPA_Statement'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents/status_Document_Published'), 5)

WebUI.delay(1)

WebUI.waitForElementClickable(findTestObject('GoPro UI/Case Documents/button_Clear_Search'), 3)

WebUI.click(findTestObject('GoPro UI/Case Documents/button_Clear_Search'))

WebUI.click(findTestObject('GoPro UI/Case Summary/input_Search'))

WebUI.sendKeys(findTestObject('GoPro UI/Case Summary/input_Search'), testData.getValue(1, 6))

WebUI.click(findTestObject('GoPro UI/Case Summary/button_Search'))

if (WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents/link_LPA_Statement'), 5) == false) {
    CustomKeywords.'custom.WriteExcel.waitForObject'(150, 'GoPro UI/Case Documents/link_LPA_Statement', 'GoPro UI/Case Summary/button_Search')
}

WebUI.verifyElementText(findTestObject('GoPro UI/Case Documents/link_LPA_Statement'), testData.getValue(1, 6))

WebUI.click(findTestObject('GoPro UI/Case Documents/link_LPA_Statement'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents/status_Document_Published'), 5)

WebUI.delay(1)

WebUI.waitForElementClickable(findTestObject('GoPro UI/Case Documents/button_Clear_Search'), 3)

WebUI.click(findTestObject('GoPro UI/Case Documents/button_Clear_Search'))

WebUI.click(findTestObject('GoPro UI/Case Summary/input_Search'))

WebUI.sendKeys(findTestObject('GoPro UI/Case Summary/input_Search'), testData.getValue(1, 7))

WebUI.click(findTestObject('GoPro UI/Case Summary/button_Search'))

if (WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents/link_LPA_Statement'), 5) == false) {
    CustomKeywords.'custom.WriteExcel.waitForObject'(150, 'GoPro UI/Case Documents/link_LPA_Statement', 'GoPro UI/Case Summary/button_Search')
}

WebUI.verifyElementText(findTestObject('GoPro UI/Case Documents/link_LPA_Statement'), testData.getValue(1, 7))

WebUI.click(findTestObject('GoPro UI/Case Documents/link_LPA_Statement'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents/status_Document_Published'), 5)

WebUI.delay(1)

WebUI.waitForElementClickable(findTestObject('GoPro UI/Case Documents/button_Clear_Search'), 3)

WebUI.click(findTestObject('GoPro UI/Case Documents/button_Clear_Search'))

WebUI.closeWindowIndex(1)

WebUI.closeBrowser()

