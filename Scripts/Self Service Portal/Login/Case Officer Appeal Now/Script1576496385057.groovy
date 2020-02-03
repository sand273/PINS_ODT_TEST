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

WebUI.waitForElementVisible(findTestObject('Frontpage/message_User_Name_Entry'), 5)

WebUI.verifyElementText(findTestObject('Frontpage/message_User_Name_Entry'), verData.getValue(1, 17))

WebUI.setText(findTestObject('Frontpage/input_UserName'), testData.getValue(10, 1))

WebUI.setEncryptedText(findTestObject('Frontpage/input_Password'), 'KT8JOVzAIqlDwzr433Fv5w==')

WebUI.click(findTestObject('Frontpage/button_Login'))

WebUI.waitForElementVisible(findTestObject('Appeal planning decision/message_Appeal_Planning_Decision'), 5)

WebUI.verifyElementText(findTestObject('Appeal planning decision/message_Appeal_Planning_Decision'), verData.getValue(1, 
        21))

WebUI.waitForElementVisible(findTestObject('Appeal planning decision/message_Check_Progress'), 5)

WebUI.verifyElementText(findTestObject('Appeal planning decision/message_Check_Progress'), verData.getValue(1, 22))

