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

WebUI.waitForElementVisible(findTestObject('Listed building status/link_Listed_Building'), 5)

WebUI.click(findTestObject('Listed building status/link_Listed_Building'))

WebUI.waitForElementVisible(findTestObject('Listed building status/question_Grade_is_the_Listing'), 5)

WebUI.verifyElementText(findTestObject('Listed building status/question_Grade_is_the_Listing'), verData.getValue(1, 167))

WebUI.verifyElementAttributeValue(findTestObject('Listed building status/option_Grade_1'), 'value', 'Grade I', 20)

WebUI.verifyElementAttributeValue(findTestObject('Listed building status/option_Grade_2_Star'), 'value', 'Grade II*', 20)

WebUI.verifyElementAttributeValue(findTestObject('Listed building status/option_Grade_2'), 'value', 'Grade II', 20)

WebUI.click(findTestObject('Listed building status/option_Grade_1'))

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.setText(findTestObject('Listed building status/input_Listing_Number'), testData.getValue(1, 1))

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Listed building status/status_Complete_Listed_Building'), 10)

WebUI.verifyElementText(findTestObject('Listed building status/status_Complete_Listed_Building'), 'COMPLETED')
