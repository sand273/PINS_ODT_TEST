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
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory

def verData = TestDataFactory.findTestData('Data Files/Verification')

WebUI.waitForElementVisible(findTestObject('Planning Refused/link_Planning_Refused'), 2)

WebUI.click(findTestObject('Planning Refused/link_Planning_Refused'))

WebUI.waitForElementVisible(findTestObject('Planning Refused/question_Planning_Refused'), 2)

WebUI.verifyElementText(findTestObject('Planning Refused/frame_Reasons_CheckBoxes'), verData.getValue(1, 36))

WebUI.click(findTestObject('Planning Refused/input_Select all reasons that the LPA gave when refusing planning permission_RefusalReasons'))

WebUI.click(findTestObject('Planning Refused/input_Affordable housing_RefusalReasons'))

WebUI.click(findTestObject('Planning Refused/input_Agricultural need_RefusalReasons'))

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Planning Refused/status_Completed_Refusal'), 3)

WebUI.verifyElementText(findTestObject('Planning Refused/status_Completed_Refusal'), 'COMPLETED')

