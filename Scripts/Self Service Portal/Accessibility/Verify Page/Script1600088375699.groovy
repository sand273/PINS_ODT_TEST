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
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory

def verData = TestDataFactory.findTestData('Data Files/Portal_Verification')

WebUI.openBrowser('')

WebUI.deleteAllCookies()

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.URL)

WebUI.click(findTestObject('PINS Test GoPro/a_Self Service'))

WebUI.waitForElementClickable(findTestObject('Accessibility/link_Accessibility'), 5)

WebUI.click(findTestObject('Accessibility/link_Accessibility'))

WebUI.waitForElementClickable(findTestObject('Accessibility/button_Accept_Cookies'), 5)

WebUI.click(findTestObject('Accessibility/button_Accept_Cookies'))

WebUI.verifyElementText(findTestObject('Accessibility/message_Appeals_CaseWork'), verData.getValue(1, 172))

WebUI.verifyElementText(findTestObject('Accessibility/message_Appeals_CaseWork_Sub'), verData.getValue(1, 172))

WebUI.verifyElementVisible(findTestObject('Accessibility/message_Documents'))

WebUI.verifyElementVisible(findTestObject('Accessibility/message_Portal_Documentation'))

WebUI.verifyElementText(findTestObject('Accessibility/link_Planning'), verData.getValue(1, 173))

WebUI.closeBrowser()
