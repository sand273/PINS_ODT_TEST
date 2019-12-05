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

WebUI.click(findTestObject('Object Repository/GoPro UI/Page_pins My cases/link_My events_location_arrow'))

WebUI.click(findTestObject('Object Repository/GoPro UI/Page_pins My cases/link_Holding_List'))

WebUI.click(findTestObject('Object Repository/GoPro UI/Case Summary/input_Search'))

WebUI.sendKeys(findTestObject('Object Repository/GoPro UI/Case Summary/input_Search'), GlobalVariable.ApplicationRef)

WebUI.click(findTestObject('Object Repository/GoPro UI/Case Summary/button_Search'))

WebUI.waitForElementPresent(findTestObject('GoPro UI/Case Summary/list_Case_Ref'), 5)

WebUI.doubleClick(findTestObject('GoPro UI/Case Summary/list_Case_Ref'))

WebUI.switchToWindowIndex(1)

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Summary/panel_Left_Processing_Timeline'), 5)

WebUI.verifyElementVisible(findTestObject('GoPro UI/Case Summary/select_AbeyanceCase'))

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/dropdown_Open_for_LPA'), 'defaultSelected', 'true', 
    5)

WebUI.click(findTestObject('GoPro UI/Case Documents/tab_Case_Documents'))

WebUI.scrollToPosition(9999999, 9999999)

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents/link_Folder_Your_Comments'), 5)

not_run: WebUI.waitForElementClickable(findTestObject('GoPro UI/Case Documents/Page_pins-test viewscaseresponses/link_Your_Comments'), 
    2)

WebUI.click(findTestObject('GoPro UI/Case Documents/link_Folder_Your_Comments'))

WebUI.sendKeys(findTestObject('GoPro UI/Case Documents/link_Folder_Your_Comments'), Keys.chord(Keys.ARROW_RIGHT))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents/Page_pins-test viewscaseresponses/link_Interested_Party_Pdf'), 
    3)

WebUI.click(findTestObject('GoPro UI/Case Documents/Page_pins-test viewscaseresponses/link_Interested_Party_Pdf'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents/button_Ready_for_Publish'), 3)

WebUI.click(findTestObject('GoPro UI/Case Documents/button_Ready_for_Publish'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Summary/label_Processing'), 5)

WebUI.click(findTestObject('GoPro UI/Case Summary/button_Publish_LPA_Statement'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Summary/label_Processing'), 5)

WebUI.verifyElementVisible(findTestObject('GoPro UI/Case Summary/select_AbeyanceCase'))

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/dropdown_Publish_LPA_Statement'), 'defaultSelected', 
    'true', 5)

WebUI.click(findTestObject('GoPro UI/Case Documents/tab_Case_Documents'))

WebUI.callTestCase(findTestCase('GoPro UI/Generic/Publish LPA Statements - Actions Menu'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Summary/label_Processing'), 5)

WebUI.click(findTestObject('GoPro UI/Case Documents/tab_Case_Documents'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents/link_Folder_LPA_Statement'), 5)

WebUI.scrollToPosition(9999999, 9999999)

WebUI.click(findTestObject('GoPro UI/Case Documents/Page_pins-test viewscaseresponses/link_LPA_Statement'))

WebUI.waitForElementClickable(findTestObject('GoPro UI/Case Documents/Page_pins-test viewscaseresponses/link_Expand_LPA Statement'), 
    2)

WebUI.click(findTestObject('GoPro UI/Case Documents/Page_pins-test viewscaseresponses/link_Expand_LPA Statement'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents/status_Document_Published'), 2)

WebUI.click(findTestObject('GoPro UI/Case Documents/Page_pins-test viewscaseresponses/link_Upload_Pdf'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents/status_Document_Published'), 2)

WebUI.waitForElementClickable(findTestObject('GoPro UI/Case Documents/Page_pins-test viewscaseresponses/link_Your_Comments'), 
    2)

WebUI.click(findTestObject('GoPro UI/Case Documents/Page_pins-test viewscaseresponses/link_Your_Comments'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents/link_Interested_party_pdf'), 3)

WebUI.click(findTestObject('GoPro UI/Case Documents/link_Interested_party_pdf'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents/status_Document_Published'), 2)

