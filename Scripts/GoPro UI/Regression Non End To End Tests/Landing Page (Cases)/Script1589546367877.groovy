import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('GoPro UI/Login/Case Officer'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

WebUI.click(findTestObject('GoPro UI/My cases/link_My events_location_arrow'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Navigation/link_Cases'), 20)

WebUI.click(findTestObject('GoPro UI/Navigation/link_Cases'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/My cases/link_My events_location_arrow'), 20)

WebUI.click(findTestObject('GoPro UI/Cases/select_First_Case'))

WebUI.verifyElementVisible(findTestObject('GoPro UI/Cases/view_Case_Details'))

WebUI.verifyElementVisible(findTestObject('GoPro UI/My cases/link_My events_location_arrow'))

WebUI.verifyElementVisible(findTestObject('GoPro UI/Cases/link_Show_Calendars'))

WebUI.verifyElementVisible(findTestObject('GoPro UI/Cases/menu_Actions_Hamburger'))

WebUI.verifyElementVisible(findTestObject('GoPro UI/Cases/button_Creation_Date_Filter'))

WebUI.verifyElementVisible(findTestObject('GoPro UI/Cases/button_Assigned_Officer_Inspector_Filter'))

WebUI.verifyElementVisible(findTestObject('GoPro UI/Cases/button_Appeal_Type_Filter'))

WebUI.verifyElementVisible(findTestObject('GoPro UI/Cases/button_Case_Status_Filter'))

WebUI.verifyElementVisible(findTestObject('GoPro UI/Cases/button_Site_Postcode_Filter'))

WebUI.verifyElementVisible(findTestObject('GoPro UI/Case Summary/input_Search'))

WebUI.closeBrowser()

