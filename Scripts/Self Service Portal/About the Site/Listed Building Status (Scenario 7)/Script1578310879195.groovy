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

def verData = TestDataFactory.findTestData('Data Files/Portal_Verification')

def testData = TestDataFactory.findTestData('Listed_Building_Status')

WebUI.delay(1)

WebUI.waitForElementVisible(findTestObject('Listed building status/link_Listed_Building'), 2)

WebUI.click(findTestObject('Listed building status/link_Listed_Building'))

WebUI.waitForElementVisible(findTestObject('Listed building status/question_Listed_Building'), 2)

WebUI.verifyElementText(findTestObject('Listed building status/question_Listed_Building'), verData.getValue(1, 47))

WebUI.click(findTestObject('Listed building status/option_Yes_Listed_Building_Status'))

WebUI.verifyElementAttributeValue(findTestObject('Listed building status/option_Grade_1'), 'value', 'Grade I', 20)

WebUI.verifyElementAttributeValue(findTestObject('Listed building status/option_Grade_2_Star'), 'value', 'Grade II*', 20)

WebUI.verifyElementAttributeValue(findTestObject('Listed building status/option_Grade_2'), 'value', 'Grade II', 20)

WebUI.click(findTestObject('Listed building status/option_Grade_2'))

WebUI.setText(findTestObject('Listed building status/input_Listing_Number'), testData.getValue(1, 1))

WebUI.click(findTestObject('Listed building status/option_Yes_Applied_Listed_Consent'))

WebUI.click(findTestObject('Listed building status/option_Not_Granted'))

WebUI.click(findTestObject('Listed building status/option_No_Appeal_Listed_Consent'))

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Listed building status/status_Complete_Listed_Building'), 3)

WebUI.verifyElementText(findTestObject('Listed building status/status_Complete_Listed_Building'), 'COMPLETED')

