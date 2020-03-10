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

def testData = TestDataFactory.findTestData('Data Files/User_Profile')

WebUI.waitForElementVisible(findTestObject('Contact Details/link_Contact_Details'), 5)

WebUI.click(findTestObject('Contact Details/link_Contact_Details'))

WebUI.waitForElementVisible(findTestObject('Contact Details/message_Contact_Details'), 5)

WebUI.verifyElementAttributeValue(findTestObject('Contact Details/text_FirstName'), 'value', testData.getValue(1, 1), 0)

WebUI.verifyElementAttributeValue(findTestObject('Contact Details/text_LastName'), 'value', testData.getValue(2, 1), 0)

WebUI.verifyElementAttributeValue(findTestObject('Contact Details/text_Building'), 'value', testData.getValue(3, 1), 0)

WebUI.verifyElementAttributeValue(findTestObject('Contact Details/text_Email'), 'value', testData.getValue(9, 1), 0)

WebUI.verifyElementAttributeValue(findTestObject('Contact Details/text_Landline'), 'value', testData.getValue(7, 1), 0)

WebUI.verifyElementAttributeValue(findTestObject('Contact Details/text_Mobile'), 'value', testData.getValue(8, 1), 0)

WebUI.verifyElementAttributeValue(findTestObject('Contact Details/text_PostCode'), 'value', testData.getValue(6, 1), 0)

WebUI.verifyElementAttributeValue(findTestObject('Contact Details/text_Town'), 'value', testData.getValue(4, 1), 0)

WebUI.setText(findTestObject('Contact Details/text_County'), testData.getValue(5, 1))

WebUI.setText(findTestObject('Contact Details/text_PostCode'), testData.getValue(6, 1))

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Contact Details/status_Complete_Contact_Details'), 10)

WebUI.verifyElementText(findTestObject('Contact Details/status_Complete_Contact_Details'), 'COMPLETED')

