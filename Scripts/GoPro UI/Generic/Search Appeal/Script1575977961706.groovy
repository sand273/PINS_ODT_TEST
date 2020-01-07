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

WebUI.click(findTestObject('GoPro UI/My cases/link_My events_location_arrow'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/My cases/link_Holding_List'), 20)

WebUI.waitForElementClickable(findTestObject('GoPro UI/My cases/link_Holding_List'), 2)

WebUI.click(findTestObject('GoPro UI/My cases/link_Holding_List'))

WebUI.waitForElementClickable(findTestObject('GoPro UI/Case Summary/input_Search'), 2)

WebUI.click(findTestObject('Object Repository/GoPro UI/Case Summary/input_Search'))

String[] ref = GlobalVariable.ApplicationRef.split('/')

WebUI.sendKeys(findTestObject('Object Repository/GoPro UI/Case Summary/input_Search'), ref[0])

WebUI.click(findTestObject('Object Repository/GoPro UI/Case Summary/button_Search'))

WebUI.waitForElementClickable(findTestObject('GoPro UI/Case Summary/list_Case_Ref'), 5)

WebUI.doubleClick(findTestObject('GoPro UI/Case Summary/list_Case_Ref'))

WebUI.switchToWindowIndex(1)

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Summary/panel_Left_Processing_Timeline'), 5)

WebUI.verifyElementText(findTestObject('GoPro UI/Case Summary/panel_Left_Processing_Timeline'), UIData.getValue(1, 1))

WebUI.verifyElementVisible(findTestObject('GoPro UI/Case Summary/select_AbeyanceCase'))

