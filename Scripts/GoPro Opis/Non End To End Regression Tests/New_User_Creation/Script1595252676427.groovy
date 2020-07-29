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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

def randomNumber = CustomKeywords.'custom.RandomNumberGenerator.randomNumber'(10, 999999)

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.URL)

WebUI.maximizeWindow()

WebUI.click(findTestObject('Auto Programming/button_GoPro_Opis'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Login/input_User name'), 3)

WebUI.setText(findTestObject('GoPro UI/Login/input_User name'), 'Autotest_1')

WebUI.waitForElementClickable(findTestObject('GoPro UI/Login/input_Password'), 2)

WebUI.click(findTestObject('GoPro UI/Login/input_Password'))

WebUI.delay(1)

WebUI.setEncryptedText(findTestObject('GoPro UI/Login/input_Password'), '0cU2R0tWEjl49ICU6OTr2A==')

WebUI.click(findTestObject('Auto Programming/button_Login'))

WebUI.waitForElementVisible(findTestObject('Auto Programming/button_Invalid_Licence_OK'), 5)

WebUI.click(findTestObject('Auto Programming/button_Invalid_Licence_OK'))

WebUI.waitForElementVisible(findTestObject('Auto Programming/tab_Setup'), 5)

WebUI.click(findTestObject('Auto Programming/tab_Setup'))

WebUI.switchToWindowIndex(0)

WebUI.waitForElementVisible(findTestObject('GoPro Opis/Setup/td_PINS'), 5)

WebUI.click(findTestObject('GoPro Opis/Setup/td_PINS'))

WebUI.waitForElementVisible(findTestObject('Auto Programming/button_Create'), 5)

WebUI.click(findTestObject('Auto Programming/button_Create'))

WebUI.waitForElementVisible(findTestObject('Auto Programming/button_New_User'), 5)

WebUI.click(findTestObject('Auto Programming/button_New_User'))

WebUI.switchToWindowIndex(1)

WebUI.waitForElementVisible(findTestObject('Auto Programming/input_Full_Name'), 5)

WebUI.setText(findTestObject('Auto Programming/input_Full_Name'), 'AutoTest_' + randomNumber)

WebUI.setText(findTestObject('Auto Programming/input_Username'), 'AutoTest_' + randomNumber)

WebUI.setText(findTestObject('Auto Programming/input_Email'), ('AutoTest_' + randomNumber) + '@test.com')

WebUI.setText(findTestObject('Auto Programming/input_Postion'), 'Autotest_1')

WebUI.click(findTestObject('Auto Programming/button_Save_And_Close'))

WebUI.switchToWindowIndex(0)

WebUI.waitForElementVisible(findTestObject('GoPro Opis/Setup/td_PINS'), 20)

WebUI.click(findTestObject('GoPro Opis/Setup/img_PINS_Expand'))

def text = WebUI.getText(findTestObject('GoPro Opis/Setup/div_PINS_Users'))

if (text.contains(('AutoTest_' + randomNumber) + '@test.com')) {
    KeywordUtil.markPassed(('AutoTest_' + randomNumber) + '@test.com has been created')
} else {
    KeywordUtil.markFailed(('AutoTest_' + randomNumber) + '@test.com has not been created')
}

WebUI.closeBrowser()
