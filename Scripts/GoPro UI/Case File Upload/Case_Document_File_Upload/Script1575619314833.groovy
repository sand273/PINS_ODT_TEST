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

def caseNumber = 'EN023012'

WebUI.callTestCase(findTestCase('GoPro UI/Login/Case Officer'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

WebUI.click(findTestObject('GoPro UI/My cases/link_My events_location_arrow'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Navigation/Cases_Link'), 20)

WebUI.click(findTestObject('GoPro UI/Navigation/Cases_Link'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Summary/input_Search'), 20)

WebUI.click(findTestObject('Object Repository/GoPro UI/Case Summary/input_Search'))

WebUI.sendKeys(findTestObject('Object Repository/GoPro UI/Case Summary/input_Search'), caseNumber)

WebUI.click(findTestObject('Object Repository/GoPro UI/Case Summary/button_Search'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Summary/Ds_Case_In_List', [('caseNumber') : caseNumber]), 20)

WebUI.doubleClick(findTestObject('GoPro UI/Case Summary/Ds_Case_In_List', [('caseNumber') : caseNumber]))

WebUI.switchToWindowIndex(1)

for (def i : (1..279)) {
    WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents Actions/Actions_Link'), 20)

    WebUI.click(findTestObject('GoPro UI/Case Documents Actions/Actions_Link'))

    WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents Actions/Upload_Documents_Link'), 20)

    WebUI.click(findTestObject('GoPro UI/Case Documents Actions/Upload_Documents_Link'))

    WebUI.delay(1)

    WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents Actions/Upload_Document_Button'), 20)

    WebUI.click(findTestObject('GoPro UI/Case Documents Actions/Upload_Document_Button'), FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Upload File'), [('exeFileName') : 'Multiple_Upload.exe'], 
        FailureHandling.STOP_ON_FAILURE)

    WebUI.waitForElementClickable(findTestObject('GoPro UI/Case Documents Actions/Upload_Button'), 20)

    WebUI.click(findTestObject('GoPro UI/Case Documents Actions/Upload_Button'), FailureHandling.STOP_ON_FAILURE)

    WebUI.comment(i.toString())
}

not_run: WebUI.closeBrowser()

