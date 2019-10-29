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

def verData = TestDataFactory.findTestData('Data Files/Verification')

WebUI.waitForElementVisible(findTestObject('Page_Frontpage/message_User_Name_Entry'), 2)

WebUI.verifyElementText(findTestObject('Page_Frontpage/message_User_Name_Entry'), verData.getValue(1, 17))

WebUI.setText(findTestObject('Page_Frontpage/input_UserName'), 'Auto_Test1')

WebUI.setEncryptedText(findTestObject('Page_Frontpage/input_Password'), 'KT8JOVzAIqlDwzr433Fv5w==')

WebUI.click(findTestObject('Page_Frontpage/button_Login'))

WebUI.waitForElementVisible(findTestObject('Page_Appeal a planning decision/message_Appeal_Planning_Decision'), 2)

WebUI.verifyElementText(findTestObject('Page_Appeal a planning decision/message_Appeal_Planning_Decision'), verData.getValue(
        1, 21))

WebUI.waitForElementVisible(findTestObject('Page_Appeal a planning decision/message_Check_Progress'), 4)

WebUI.verifyElementText(findTestObject('Page_Appeal a planning decision/message_Check_Progress'), verData.getValue(1, 22))

