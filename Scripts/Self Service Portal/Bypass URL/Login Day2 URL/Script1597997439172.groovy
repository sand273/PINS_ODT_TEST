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

String[] values = new String[2]

def verData = TestDataFactory.findTestData('Data Files/Portal_Verification')

def testData = TestDataFactory.findTestData('Data Files/User_Profile')

CustomKeywords.'custom.WriteExcel.readValues'(GlobalVariable.UploadFilePath + '\\Bypass_Eligibility_Checker.xlsx', 'Bypass_URL',
	values)

WebUI.openBrowser('')

WebUI.deleteAllCookies()

WebUI.maximizeWindow()

WebUI.navigateToUrl((values[1]).toString())

WebUI.click(findTestObject('Frontpage/input'))

WebUI.waitForElementVisible(findTestObject('Frontpage/message_User_Name_Entry'), 5)

WebUI.verifyElementText(findTestObject('Frontpage/message_User_Name_Entry'), verData.getValue(1, 17))

WebUI.setText(findTestObject('Frontpage/input_UserName'), testData.getValue(10, 1))

WebUI.setEncryptedText(findTestObject('Frontpage/input_Password'), 'KT8JOVzAIqlDwzr433Fv5w==')

WebUI.click(findTestObject('Frontpage/button_Login'))

WebUI.waitForElementVisible(findTestObject('Bypass Eligibility Checker/title_Exemption'), 10)

WebUI.verifyElementText(findTestObject('Bypass Eligibility Checker/title_Exemption'),'Exemption validation')

WebUI.verifyElementVisible(findTestObject('Bypass Eligibility Checker/title_Error_Summary'))

WebUI.verifyElementVisible(findTestObject('Bypass Eligibility Checker/message_Error_Details1'))

WebUI.verifyElementVisible(findTestObject('Bypass Eligibility Checker/message_Error_Details2'))

WebUI.verifyElementText(findTestObject('Bypass Eligibility Checker/message_Error_Details2'), verData.getValue(1, 169))

WebUI.closeBrowser()