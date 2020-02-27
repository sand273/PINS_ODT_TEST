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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

def verData = TestDataFactory.findTestData('Data Files/Portal_Verification')

WebUI.delay(1)

WebUI.waitForElementVisible(findTestObject('The Advertisement/link_Advertisement'), 5)

WebUI.click(findTestObject('The Advertisement/link_Advertisement'))

WebUI.waitForElementVisible(findTestObject('The Advertisement/question_Advertisement'), 5)

WebUI.click(findTestObject('The Advertisement/option_Advert_Yes_Place'))

WebUI.waitForElementVisible(findTestObject('The Advertisement/question_Public_Land'), 5)

WebUI.click(findTestObject('The Advertisement/option_Advert_Yes_Land'))

WebUI.waitForElementVisible(findTestObject('The Advertisement/question_Consent'), 5)

WebUI.verifyElementText(findTestObject('The Advertisement/question_Consent'), verData.getValue(1, 118))

WebUI.click(findTestObject('The Advertisement/option_Advert_Yes_Consent'))

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('The Advertisement/status_Complete'), 10)

WebUI.verifyElementText(findTestObject('The Advertisement/status_Complete'), 'COMPLETED')

