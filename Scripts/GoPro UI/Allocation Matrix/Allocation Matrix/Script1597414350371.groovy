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

String[] values = new String[5]

String valueScore

String insGrade

def verData = TestDataFactory.findTestData('Data Files/GoPro_UI_Allocation_Matrix')

CustomKeywords.'custom.WriteExcel.readValues'(GlobalVariable.UploadFilePath + '\\AppealNumbers.xlsx', 'Appeals', values)

for (int iRow = 1; iRow <= GlobalVariable.driverCount; iRow++) {
    WebUI.callTestCase(findTestCase('GoPro UI/Login/Case Officer'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(1)

    WebUI.click(findTestObject('GoPro UI/My cases/link_My_Events'))

    WebUI.waitForElementVisible(findTestObject('GoPro UI/Navigation/link_Cases'), 20)

    WebUI.click(findTestObject('GoPro UI/Navigation/link_Cases'))

    WebUI.waitForElementClickable(findTestObject('GoPro UI/Case Summary/input_Search'), 5)

    WebUI.click(findTestObject('Object Repository/GoPro UI/Case Summary/input_Search'))

    String[] ref = (values[iRow]).split('/')

    WebUI.sendKeys(findTestObject('Object Repository/GoPro UI/Case Summary/input_Search'), ref[1])

    WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Summary/button_Search'), 10)

    WebUI.click(findTestObject('Object Repository/GoPro UI/Case Summary/button_Search'))

    try {
        if (WebUI.verifyElementText(findTestObject('GoPro UI/Case Summary/text_Row_Total'), 'Row total: 1') == false) {
            WebUI.click(findTestObject('Object Repository/GoPro UI/Case Summary/button_Search'))
        }
    }
    catch (Exception ex) {
        WebUI.click(findTestObject('Object Repository/GoPro UI/Case Summary/button_Search'))

        WebUI.waitForElementVisible(findTestObject('GoPro UI/Cases/select_First_Case'), 20)
    } 
    
    WebUI.delay(2)

    WebUI.click(findTestObject('GoPro UI/Cases/select_First_Case'))

    WebUI.delay(2)

    WebUI.doubleClick(findTestObject('GoPro UI/Cases/select_First_Case'))

    WebUI.switchToWindowIndex(1)

    WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Summary/label_Processing'), 10)

    WebUI.click(findTestObject('Object Repository/GoPro UI/Case Summary/link_Results'))

    WebUI.delay(2)

    insGrade = WebUI.getAttribute(findTestObject('Object Repository/GoPro UI/Case Summary/field_Grade'), 'value')
	
	WebUI.verifyMatch(insGrade, 'string:' + verData.getValue(2, 3), false)
	
    WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Summary/field_Score'), 10)
	
	if (GlobalVariable.AllocationMatrix == 4)
	{
		valueScore = WebUI.getAttribute(findTestObject('Object Repository/GoPro UI/Case Summary/field_Score1'), 'value')
	}
	else
	{
		valueScore = WebUI.getAttribute(findTestObject('Object Repository/GoPro UI/Case Summary/field_Score'), 'value')
	}
	
	WebUI.verifyMatch(valueScore, verData.getValue(1, 3), false)
	
	WebUI.closeWindowIndex(1)
	
	WebUI.closeBrowser()
		
}

