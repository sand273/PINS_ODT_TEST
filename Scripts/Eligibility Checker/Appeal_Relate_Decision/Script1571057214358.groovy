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
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

def verData = TestDataFactory.findTestData('Data Files/Verification')

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.URL)

WebUI.click(findTestObject('Page_PINS Test  GoPro/a_Self Service'))

WebUI.click(findTestObject('Page_Frontpage/input'))

WebUI.waitForElementClickable(findTestObject('Page_Frontpage/a_Make an appeal - Beta service'), 2)

WebUI.click(findTestObject('Page_Frontpage/a_Make an appeal - Beta service'))

WebUI.waitForElementClickable(findTestObject('Page_Appeal a planning decision/a_Start now'), 2)

WebUI.click(findTestObject('Page_Appeal a planning decision/a_Start now'))

WebUI.verifyElementText(findTestObject('Page_Appeal a planning decision/endUser_Question'), verData.getValue(1, 1))

WebUI.click(findTestObject('Page_Appeal a planning decision/input_Yes_option'))

WebUI.waitForElementClickable(findTestObject('Page_Appeal a planning decision/button_Continue'), 1)

WebUI.click(findTestObject('Object Repository/Page_Appeal a planning decision/button_Continue'))

WebUI.scrollToElement(findTestObject('Page_Appeal a planning decision/input_Yes_option'), 1)

WebUI.click(findTestObject('Page_Appeal a planning decision/input_Yes_option'))

WebUI.waitForElementClickable(findTestObject('Page_Appeal a planning decision/button_Continue'), 1)

WebUI.click(findTestObject('Object Repository/Page_Appeal a planning decision/button_Continue'))

WebUI.verifyElementText(findTestObject('Page_Appeal a planning decision/endUser_Question'), verData.getValue(1, 2))

WebUI.click(findTestObject('Page_Appeal a planning decision/input_No_option'))

WebUI.waitForElementClickable(findTestObject('Page_Appeal a planning decision/button_Continue'), 1)

WebUI.click(findTestObject('Object Repository/Page_Appeal a planning decision/button_Continue'))

WebUI.verifyElementText(findTestObject('Page_Appeal a planning decision/endUser_Question'), verData.getValue(1, 3))

WebUI.click(findTestObject('Page_Appeal a planning decision/input_Yes_option'))

WebUI.waitForElementClickable(findTestObject('Page_Appeal a planning decision/button_Continue'), 1)

WebUI.click(findTestObject('Object Repository/Page_Appeal a planning decision/button_Continue'))

WebUI.verifyElementText(findTestObject('Page_Appeal a planning decision/endUser_Question'), verData.getValue(1, 4))

