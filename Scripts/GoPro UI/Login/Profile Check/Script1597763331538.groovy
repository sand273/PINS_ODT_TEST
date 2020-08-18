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

def testData = TestDataFactory.findTestData('Data Files/User_Profile')

def verData = TestDataFactory.findTestData('Data Files/GoPro_UI_Verification')

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.URL)

WebUI.maximizeWindow()

// Invalid User - Valid Password combination
WebUI.click(findTestObject('GoPro UI/PINS GoPro/a_GoPro UI'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Login/input_User name'), 10)

WebUI.setText(findTestObject('GoPro UI/Login/input_User name'), testData.getValue(17, 1))

WebUI.waitForElementClickable(findTestObject('GoPro UI/Login/input_Password'), 5)

WebUI.click(findTestObject('GoPro UI/Login/input_Password'))

WebUI.delay(1)

WebUI.setEncryptedText(findTestObject('GoPro UI/Login/input_Password'), '0cU2R0tWEjl49ICU6OTr2A==')

WebUI.click(findTestObject('GoPro UI/Login/button_Login'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Login/message_Invalid'), 10)

WebUI.verifyElementText(findTestObject('GoPro UI/Login/message_Invalid'), verData.getValue(1, 15))

WebUI.refresh()

// Valid User - Invalid Password Combination
WebUI.waitForElementVisible(findTestObject('GoPro UI/Login/input_User name'), 10)

WebUI.setText(findTestObject('GoPro UI/Login/input_User name'), testData.getValue(16, 1))

WebUI.waitForElementClickable(findTestObject('GoPro UI/Login/input_Password'), 5)

WebUI.click(findTestObject('GoPro UI/Login/input_Password'))

WebUI.delay(1)

WebUI.setEncryptedText(findTestObject('GoPro UI/Login/input_Password'), '0cU2R0tWEjkRBFyzLLPPuA==')

WebUI.click(findTestObject('GoPro UI/Login/button_Login'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Login/message_Invalid'), 10)

WebUI.verifyElementText(findTestObject('GoPro UI/Login/message_Invalid'), verData.getValue(1, 15))

WebUI.closeBrowser()