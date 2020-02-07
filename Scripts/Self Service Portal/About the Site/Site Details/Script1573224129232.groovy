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

def verData = TestDataFactory.findTestData('Data Files/Portal_Verification')

def testData = TestDataFactory.findTestData('Data Files/Site_Details')

WebUI.delay(1)

WebUI.waitForElementVisible(findTestObject('Site Details/link_Site details'), 5)

WebUI.click(findTestObject('Site Details/link_Site details'))

WebUI.waitForElementVisible(findTestObject('Site Details/question_PostCode'), 5)

WebUI.verifyElementText(findTestObject('Site Details/question_PostCode'), verData.getValue(1, 41))

WebUI.click(findTestObject('Site Details/input_Site_Postcode'))

WebUI.waitForElementVisible(findTestObject('Site Details/question_Site_Address'), 5)

WebUI.verifyElementText(findTestObject('Site Details/question_Site_Address'), verData.getValue(1, 42))

WebUI.setText(findTestObject('Site Details/input_SitePostcode'), testData.getValue(1, 1))

WebUI.click(findTestObject('Site Details/button_Find address'))

WebUI.delay(1)

WebUI.waitForElementClickable(findTestObject('Site Details/dropdown_Select address'), 5)

WebUI.selectOptionByValue(findTestObject('Site Details/dropdown_Select address'), testData.getValue(2, 1), false)

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Site Details/question_Public_Land'), 5)

WebUI.verifyElementText(findTestObject('Site Details/question_Public_Land'), verData.getValue(1, 43))

WebUI.click(findTestObject('Site Details/input_Yes_SiteSeenFromPublicLand'))

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Site Details/question_Site_Restricted'), 5)

WebUI.verifyElementText(findTestObject('Site Details/question_Site_Restricted'), verData.getValue(1, 44))

WebUI.click(findTestObject('Site Details/input_Yes_SiteRestrictedAccess'))

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Site Details/question_Health_Safety'), 5)

WebUI.verifyElementText(findTestObject('Site Details/question_Health_Safety'), verData.getValue(1, 45))

WebUI.click(findTestObject('Site Details/input_Yes_SiteHealthConcerns'))

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Site Details/question_Site_Inspector'), 5)

WebUI.verifyElementText(findTestObject('Site Details/question_Site_Inspector'), verData.getValue(1, 46))

WebUI.click(findTestObject('Site Details/input_Yes_SiteInspectorVisit'))

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Site Details/status_Completed_Site_Details'), 10)

WebUI.verifyElementText(findTestObject('Site Details/status_Completed_Site_Details'), 'COMPLETED')

