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

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.URL)

WebUI.maximizeWindow()

WebUI.click(findTestObject('GoPro UI/PINS GoPro/a_GoPro UI'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Login/input_User name'), 3)

WebUI.setText(findTestObject('GoPro UI/Login/input_User name'), 'Autotest_1')

WebUI.focus(findTestObject('GoPro UI/Login/input_Password'))

WebUI.waitForElementClickable(findTestObject('GoPro UI/Login/input_Password'), 2)

WebUI.click(findTestObject('GoPro UI/Login/input_Password'))

WebUI.setEncryptedText(findTestObject('GoPro UI/Login/input_Password'), '0cU2R0tWEjl49ICU6OTr2A==')

WebUI.click(findTestObject('GoPro UI/Login/button_Login'))

