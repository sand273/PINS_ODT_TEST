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

WebUI.callTestCase(findTestCase('GoPro UI/Login/Case_Officer'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('GoPro UI/Generic/Search Appeal'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/dropdown_Open_Final_Comments'), 'defaultSelected', 
    'true', 5)

WebUI.click(findTestObject('GoPro UI/Case Documents/tab_Case_Documents'))

WebUI.scrollToPosition(9999999, 9999999)

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents/link_Folder_Final_Comments'), 5)

WebUI.click(findTestObject('GoPro UI/Case Documents/link_Folder_Final_Comments'))

WebUI.click(findTestObject('GoPro UI/Case Documents/Final Comments/link_Final_Comment'))

WebUI.waitForElementClickable(findTestObject('GoPro UI/Case Documents/link_Upload_Document'), 2)

WebUI.scrollToPosition(9999999, 9999999)

WebUI.click(findTestObject('GoPro UI/Case Documents/link_Upload_Document'))

WebUI.waitForElementPresent(findTestObject('GoPro UI/Case Documents/button_Ready_for_Publish'), 3)

WebUI.click(findTestObject('GoPro UI/Case Documents/button_Ready_for_Publish'))

WebUI.waitForElementPresent(findTestObject('GoPro UI/Case Summary/label_Processing'), 5)

WebUI.click(findTestObject('GoPro UI/Case Documents/tab_Case_Documents'))

WebUI.scrollToPosition(9999999, 9999999)

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents/link_Folder_Final_Comments'), 5)

WebUI.click(findTestObject('GoPro UI/Case Documents/link_Folder_Final_Comments'))

WebUI.click(findTestObject('GoPro UI/Case Documents/Final Comments/link_Final_Comment'))

WebUI.scrollToPosition(9999999, 9999999)

WebUI.waitForElementClickable(findTestObject('GoPro UI/Case Documents/Final Comments/link_Final_Comments_PDF'), 2)

WebUI.click(findTestObject('GoPro UI/Case Documents/Final Comments/link_Final_Comments_PDF'))

WebUI.waitForElementPresent(findTestObject('GoPro UI/Case Documents/button_Ready_for_Publish'), 3)

WebUI.click(findTestObject('GoPro UI/Case Documents/button_Ready_for_Publish'))

WebUI.waitForElementPresent(findTestObject('GoPro UI/Case Summary/label_Processing'), 5)

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Summary/panel_Left_Processing_Timeline'), 5)

WebUI.click(findTestObject('GoPro UI/Case Summary/button_Publish_Final_Comment'))

WebUI.waitForElementPresent(findTestObject('GoPro UI/Case Summary/label_Processing'), 5)

WebUI.verifyElementVisible(findTestObject('GoPro UI/Case Summary/select_AbeyanceCase'))

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/dropdown_Publish_Final_Comments'), 'defaultSelected', 
    'true', 5)

WebUI.refresh()

WebUI.click(findTestObject('GoPro UI/Case Documents/tab_Case_Documents'))

WebUI.callTestCase(findTestCase('GoPro UI/Generic/Publish Final Comments - Actions Menu'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()

