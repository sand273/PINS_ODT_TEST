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

def UIData = TestDataFactory.findTestData('Data Files/GoPro_UI_Verification')

WebUI.click(findTestObject('GoPro UI/My cases/link_My_Events'))

WebUI.delay(1)

WebUI.waitForElementVisible(findTestObject('GoPro UI/My cases/link_Holding_List'), 10)

WebUI.waitForElementClickable(findTestObject('GoPro UI/My cases/link_Holding_List'), 5)

WebUI.click(findTestObject('GoPro UI/My cases/link_Holding_List'))

WebUI.waitForElementClickable(findTestObject('GoPro UI/Case Summary/input_Search'), 5)

WebUI.click(findTestObject('Object Repository/GoPro UI/Case Summary/input_Search'))

String[] ref = GlobalVariable.ApplicationRef.split('/')

WebUI.sendKeys(findTestObject('Object Repository/GoPro UI/Case Summary/input_Search'), ref[1])

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/GoPro UI/Case Summary/button_Search'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Summary/text_Row_Total'), 10)

try
{
	if (WebUI.verifyElementText(findTestObject('GoPro UI/Case Summary/text_Row_Total'), 'Row total: 1') == false) {
		WebUI.click(findTestObject('Object Repository/GoPro UI/Case Summary/button_Search'))
	}
}
catch (Exception ex)
{
	WebUI.click(findTestObject('Object Repository/GoPro UI/Case Summary/button_Search'))
}

WebUI.waitForElementClickable(findTestObject('GoPro UI/Case Summary/list_Case_Ref'), 10)

try {
    WebUI.click(findTestObject('GoPro UI/Case Summary/list_Case_Ref'))
	WebUI.delay(2)
    WebUI.doubleClick(findTestObject('GoPro UI/Case Summary/list_Case_Ref'))
}
catch (Exception ex) {

	WebUI.click(findTestObject('Object Repository/GoPro UI/Case Summary/button_Search'))

    WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Summary/text_Row_Total'), 10)

    WebUI.verifyElementText(findTestObject('GoPro UI/Case Summary/text_Row_Total'), 'Row total: 1')

    WebUI.waitForElementClickable(findTestObject('GoPro UI/Case Summary/list_Case_Ref'), 10)

    WebUI.click(findTestObject('GoPro UI/Case Summary/list_Case_Ref'))
	
	WebUI.delay(2)
	
    WebUI.doubleClick(findTestObject('GoPro UI/Case Summary/list_Case_Ref'))
} 

WebUI.delay(1)

WebUI.switchToWindowIndex(1)

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Summary/panel_Left_Processing_Timeline'), 10)

WebUI.delay(2)

WebUI.verifyElementText(findTestObject('GoPro UI/Case Summary/panel_Left_Processing_Timeline'), UIData.getValue(1, 1))

WebUI.verifyElementVisible(findTestObject('GoPro UI/Case Summary/select_AbeyanceCase'))

