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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

def rowsOnSpreadsheet = findTestData('Auto_Programming_Data/Inspector_Data_AP').getRowNumbers()

def testData = findTestData('Auto_Programming_Data/Inspector_Data_AP')

def i = 1

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

for (def index : (i..rowsOnSpreadsheet)) {
    WebUI.switchToWindowIndex(0)

    WebUI.waitForElementVisible(findTestObject('Auto Programming/td_Auto_Programming'), 5)

    WebUI.click(findTestObject('Auto Programming/td_Auto_Programming'))

    WebUI.waitForElementVisible(findTestObject('Auto Programming/button_Create'), 5)

    WebUI.click(findTestObject('Auto Programming/button_Create'))

    WebUI.waitForElementVisible(findTestObject('Auto Programming/button_New_User'), 5)

    WebUI.click(findTestObject('Auto Programming/button_New_User'))

    WebUI.switchToWindowIndex(1)

    WebUI.waitForElementVisible(findTestObject('Auto Programming/input_Full_Name'), 5)

    WebUI.setText(findTestObject('Auto Programming/input_Full_Name'), testData.getValue('Full name', i))

    WebUI.setText(findTestObject('Auto Programming/input_Username'), testData.getValue('Username', i))

    WebUI.setEncryptedText(findTestObject('Auto Programming/input_Password'), '0cU2R0tWEjl49ICU6OTr2A==')

    WebUI.setText(findTestObject('Auto Programming/input_Email'), testData.getValue('Email', i))

    WebUI.setText(findTestObject('Auto Programming/input_Postion'), testData.getValue('Position', i))

    WebUI.click(findTestObject('Auto Programming/button_Search_Roles'), FailureHandling.STOP_ON_FAILURE)

    WebUI.waitForElementVisible(findTestObject('Auto Programming/table_Roles'), 5)

    WebUI.selectOptionByLabel(findTestObject('Auto Programming/table_Roles'), 'Inspector', false)

    WebUI.click(findTestObject('Auto Programming/button_Roles_OK'), FailureHandling.STOP_ON_FAILURE)

    WebUI.waitForElementVisible(findTestObject('Auto Programming/tab_Allocation'), 5)

    WebUI.click(findTestObject('Auto Programming/tab_Allocation'), FailureHandling.STOP_ON_FAILURE)

    WebUI.waitForElementVisible(findTestObject('Auto Programming/input_Postcode'), 5)

    WebUI.setText(findTestObject('Auto Programming/input_Postcode'), testData.getValue('Postcode', i))

    WebUI.setText(findTestObject('Auto Programming/input_Band'), testData.getValue('Band', i))

    WebUI.setText(findTestObject('Auto Programming/input_Grade'), testData.getValue('Grade', i))

    WebUI.setText(findTestObject('Auto Programming/input_Precluded_LPA'), testData.getValue('Precluded_LPA', i))

    WebUI.click(findTestObject('Auto Programming/button_Save_And_Close'))

    i++
}

WebUI.closeBrowser()

