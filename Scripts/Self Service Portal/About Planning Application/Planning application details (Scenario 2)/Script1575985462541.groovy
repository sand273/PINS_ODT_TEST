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
import org.openqa.selenium.Keys as Keys

def verData = TestDataFactory.findTestData('Data Files/Portal_Verification')

def testData = TestDataFactory.findTestData('Data Files/Planning_Details')

WebUI.waitForElementClickable(findTestObject('Appeal a planning decision/link_Planning_Application_Details'), 1)

WebUI.click(findTestObject('Appeal a planning decision/link_Planning_Application_Details'))

WebUI.waitForElementVisible(findTestObject('Planning Application details/question_Statement_Applies'), 3)

WebUI.verifyElementText(findTestObject('Planning Application details/question_Statement_Applies'), verData.getValue(1, 23))

WebUI.click(findTestObject('Planning Application details/option_Appeal_Decision_I_Received'))

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Planning Application details/question_Name_Original_Application'), 2)

WebUI.verifyElementText(findTestObject('Planning Application details/question_Name_Original_Application'), verData.getValue(
        1, 24))

WebUI.setText(findTestObject('Planning Application details/text_Name_Application'), testData.getValue(1, 1))

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Planning Application details/question_LPA_Submit'), 3)

WebUI.verifyElementText(findTestObject('Planning Application details/question_LPA_Submit'), verData.getValue(1, 25))

WebUI.selectOptionByValue(findTestObject('Planning Application details/dropdown_LPA_Select'), 'C3810', true)

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Planning Application details/question_Application_Ref'), 2)

WebUI.verifyElementText(findTestObject('Planning Application details/question_Application_Ref'), verData.getValue(1, 26))

WebUI.setText(findTestObject('Planning Application details/text_Application_Ref'), testData.getValue(2, 1))

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Planning Application details/question_Application_Type'), 2)

WebUI.verifyElementText(findTestObject('Planning Application details/question_Application_Type'), verData.getValue(1, 27))

WebUI.check(findTestObject('Planning Application details/check_Incineration'))

WebUI.check(findTestObject('Planning Application details/check_Industrial_and_community'))

WebUI.check(findTestObject('Planning Application details/check_Minerals'))

WebUI.waitForElementVisible(findTestObject('Planning Application details/question_Application_Type'), 2)

WebUI.verifyElementText(findTestObject('Planning Application details/question_Application_Type'), verData.getValue(1, 82))

WebUI.click(findTestObject('Planning Application details/input_Area'))

WebUI.waitForElementVisible(findTestObject('Planning Application details/question_Application_Type'), 2)

WebUI.verifyElementText(findTestObject('Planning Application details/question_Application_Type'), verData.getValue(1, 83))

WebUI.click(findTestObject('Planning Application details/input_Under_0.1_ha'))

WebUI.waitForElementVisible(findTestObject('Planning Application details/question_Application_Type'), 2)

WebUI.verifyElementText(findTestObject('Planning Application details/question_Application_Type'), verData.getValue(1, 84))

WebUI.click(findTestObject('Planning Application details/input_Unde_ 4_ha_50,000_tonnes_or_5_years_duration'))

WebUI.waitForElementVisible(findTestObject('Planning Application details/question_Application_Type'), 2)

WebUI.verifyElementText(findTestObject('Planning Application details/question_Application_Type'), verData.getValue(1, 85))

WebUI.click(findTestObject('Planning Application details/input_Up_to_100,000_tonnes'))

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

