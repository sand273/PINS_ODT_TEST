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

String byPassURL

def testData = TestDataFactory.findTestData('Data Files/User_Profile')

WebUI.click(findTestObject('GoPro UI/Actions Menu/menu_Actions_Icon'))

WebUI.delay(1)

WebUI.waitForElementVisible(findTestObject('GoPro UI/Actions Menu/button_Bypass_URL'), 5)

WebUI.click(findTestObject('GoPro UI/Actions Menu/button_Bypass_URL'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Actions Menu/title_Bypass_Checker'), 5)

WebUI.sendKeys(findTestObject('GoPro UI/Actions Menu/input_Email_Address'), testData.getValue(9, 1))

WebUI.click(findTestObject('GoPro UI/Actions Menu/dropdown_Appeal_Type'))

WebUI.selectOptionByValue(findTestObject('GoPro UI/Actions Menu/dropdown_Appeal_Type'), AppealType, false)

WebUI.click(findTestObject('GoPro UI/Actions Menu/dropdown_Appeal_Type'))

WebUI.delay(1)

WebUI.waitForElementClickable(findTestObject('GoPro UI/Actions Menu/button_Generate_URL'), 20)

WebUI.click(findTestObject('GoPro UI/Actions Menu/button_Generate_URL'))

WebUI.click(findTestObject('GoPro UI/Actions Menu/button_Generate_URL'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Actions Menu/field_ByPass_URL'), 60)

byPassURL = WebUI.getText(findTestObject('GoPro UI/Actions Menu/field_ByPass_URL'))

if (writeFlag == 'Y')
{
	CustomKeywords.'custom.WriteExcel.clearValues'(GlobalVariable.UploadFilePath + "\\Bypass_Eligibility_Checker.xlsx", "Bypass_URL")
	
	CustomKeywords.'custom.WriteExcel.enterValues'(byPassURL, GlobalVariable.UploadFilePath + '\\Bypass_Eligibility_Checker.xlsx',
	'Bypass_URL')
}

WebUI.click(findTestObject('GoPro UI/Actions Menu/button_Close'))
