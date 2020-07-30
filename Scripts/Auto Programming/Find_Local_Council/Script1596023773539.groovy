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

String councilValue

def rowsOnSpreadsheet = findTestData('Auto Programming/Cases_Data_AP_LPA').getRowNumbers()

def excelData = findTestData('Auto Programming/Cases_Data_AP_LPA')

def iRow = 1

for (def index : (iRow..rowsOnSpreadsheet)) 
{
	WebUI.openBrowser('')

	WebUI.navigateToUrl(GlobalVariable.FindCouncil)

	WebUI.maximizeWindow()

	WebUI.waitForElementClickable(findTestObject('Auto Programming/button_Accept_Cookies'), 5)

	WebUI.click(findTestObject('Auto Programming/button_Accept_Cookies'))

	WebUI.sendKeys(findTestObject('Auto Programming/input_Council_PostCode'), excelData.getValue('Postcode', iRow))
	
	WebUI.delay(1)

	WebUI.waitForElementClickable(findTestObject('Auto Programming/button_Find'), 5)

	WebUI.click(findTestObject('Auto Programming/button_Find'))

	WebUI.waitForElementVisible(findTestObject('Auto Programming/label_Council'), 5)

	councilValue = WebUI.getText(findTestObject('Auto Programming/label_Council'))

	CustomKeywords.'custom.WriteExcel.APData'(councilValue, GlobalVariable.UploadFilePath + '\\Auto Programming\\Case Data for 945 Cases to change LPA.xlsx',
		'Sheet1', iRow, 4)
	
	WebUI.closeBrowser()

	iRow++

}
