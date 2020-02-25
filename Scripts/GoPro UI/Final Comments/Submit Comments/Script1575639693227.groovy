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

WebUI.callTestCase(findTestCase('GoPro UI/Login/Case Officer'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('GoPro UI/Generic/Search Appeal'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/dropdown_Open_Final_Comments'), 'defaultSelected', 
    'true', 5)

WebUI.click(findTestObject('GoPro UI/Case Documents/tab_Case_Documents'))

WebUI.waitForElementPresent(findTestObject('GoPro UI/Case Documents/link_Folder_Final_Comments'), 20)

WebUI.click(findTestObject('GoPro UI/Case Summary/input_Search'))

WebUI.sendKeys(findTestObject('GoPro UI/Case Summary/input_Search'), testData.getValue(1, 8))

WebUI.click(findTestObject('GoPro UI/Case Summary/button_Search'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents/link_LPA_Statement'), 20)

WebUI.verifyElementText(findTestObject('GoPro UI/Case Documents/link_LPA_Statement'), testData.getValue(1, 8))

WebUI.click(findTestObject('GoPro UI/Case Documents/link_LPA_Statement'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents/status_InReview'), 5)

WebUI.click(findTestObject('GoPro UI/Case Documents/status_InReview'))

WebUI.selectOptionByIndex(findTestObject('GoPro UI/Case Documents/dropdown_InReview'), 4, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('GoPro UI/Case Documents/button_Primary'))

WebUI.delay(1)

WebUI.waitForElementClickable(findTestObject('GoPro UI/Case Documents/button_Clear_Search'), 5)

WebUI.click(findTestObject('GoPro UI/Case Documents/button_Clear_Search'))

WebUI.waitForElementPresent(findTestObject('GoPro UI/Case Documents/status_Showing_Documents'), 5)

WebUI.click(findTestObject('GoPro UI/Case Summary/input_Search'))

WebUI.sendKeys(findTestObject('GoPro UI/Case Summary/input_Search'), testData.getValue(1, 9))

WebUI.click(findTestObject('GoPro UI/Case Summary/button_Search'))

if (WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents/link_LPA_Statement'), 5) == false) {
    CustomKeywords.'custom.WriteExcel.waitForObject'(150, 'GoPro UI/Case Documents/link_LPA_Statement', 'GoPro UI/Case Summary/button_Search')
}

WebUI.verifyElementText(findTestObject('GoPro UI/Case Documents/link_LPA_Statement'), testData.getValue(1, 9))

WebUI.click(findTestObject('GoPro UI/Case Documents/link_LPA_Statement'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents/status_InReview'), 5)

WebUI.click(findTestObject('GoPro UI/Case Documents/status_InReview'))

WebUI.selectOptionByIndex(findTestObject('GoPro UI/Case Documents/dropdown_InReview'), 4, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('GoPro UI/Case Documents/button_Primary'))

WebUI.delay(1)

WebUI.waitForElementClickable(findTestObject('GoPro UI/Case Documents/button_Clear_Search'), 5)

WebUI.click(findTestObject('GoPro UI/Case Documents/button_Clear_Search'))

WebUI.waitForElementPresent(findTestObject('GoPro UI/Case Documents/status_Showing_Documents'), 5)

WebUI.closeBrowser()

WebUI.callTestCase(findTestCase('GoPro UI/Login/Case Officer'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('GoPro UI/Generic/Search Appeal'), [:], FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/dropdown_Open_Final_Comments'), 'defaultSelected', 
    'true', 5) == true) {
    WebUI.click(findTestObject('GoPro UI/Case Summary/button_Publish_Final_Comment'))
}

WebUI.waitForElementPresent(findTestObject('GoPro UI/Case Summary/label_Processing'), 10)

WebUI.delay(1)

WebUI.verifyElementVisible(findTestObject('GoPro UI/Case Summary/select_AbeyanceCase'))

WebUI.click(findTestObject('GoPro UI/Case Summary/select_AbeyanceCase'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/dropdown_Publish_Final_Comments'), 'defaultSelected', 
    'true', 5)

WebUI.refresh()

WebUI.click(findTestObject('GoPro UI/Case Documents/tab_Case_Documents'))

WebUI.callTestCase(findTestCase('GoPro UI/Generic/Publish Final Comments - Actions Menu'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()

