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

WebUI.verifyElementText(findTestObject('Ownership/question_Agricultural_Holding'), verData.getValue(1, 66))

WebUI.verifyElementText(findTestObject('Ownership/message_Appeal_Site_Forms'), verData.getValue(1, 57))

WebUI.click(findTestObject('Ownership/input_Agg_Holding_Yes'))

WebUI.waitForElementVisible(findTestObject('Ownership/message_Appellant_Status'), 5)

WebUI.verifyElementText(findTestObject('Ownership/message_Appellant_Status'), verData.getValue(1, 100))

WebUI.click(findTestObject('Ownership/input_Agg_Sole_Holding_No'))

WebUI.verifyElementPresent(findTestObject('Ownership/message_Owns_Holding'), 5)

WebUI.click(findTestObject('Ownership/input_No_Who_Owns_Holding'))

WebUI.waitForElementPresent(findTestObject('Ownership/message_Publish_Intention'), 5)

WebUI.verifyElementText(findTestObject('Ownership/message_Publish_Intention'), verData.getValue(1, 108))

WebUI.click(findTestObject('Ownership/option_No_Publish_Intention'))

WebUI.verifyElementNotVisible(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.verifyElementVisible(findTestObject('Planning Application details/button_Back'))

WebUI.verifyElementVisible(findTestObject('Planning Application details/button_Save_Quit'))

WebUI.verifyElementVisible(findTestObject('Ownership/message_Appeal_Alert'))

WebUI.click(findTestObject('Planning Application details/button_Save_Quit'))

