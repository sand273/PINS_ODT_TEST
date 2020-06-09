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

def verData = TestDataFactory.findTestData('Data Files/Portal_Verification')

def testData = TestDataFactory.findTestData('Data Files/Planning_Details')

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Launch Portal'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Self Service Portal/Eligibility Checker/Eligible_New_Appeal'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Self Service Portal/Eligibility Checker/Appeal_Now'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Self Service Portal/Login/Case Officer Appeal Now'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('Appeal planning decision/link_Planning_Application_Details'), 5)

WebUI.click(findTestObject('Appeal planning decision/link_Planning_Application_Details'))

WebUI.waitForElementVisible(findTestObject('Planning Application details/question_Statement_Applies'), 5)

WebUI.click(findTestObject('Planning Application details/option_Appeal_Decision_Received'))

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Planning Application details/question_Name_Original_Application'), 5)

WebUI.setText(findTestObject('Planning Application details/text_Name_Application'), testData.getValue(1, 1))

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Planning Application details/question_LPA_Submit'), 5)

WebUI.selectOptionByValue(findTestObject('Planning Application details/dropdown_LPA_Select'), 'C3810', true)

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Planning Application details/question_Application_Ref'), 5)

WebUI.setText(findTestObject('Planning Application details/text_Application_Ref'), testData.getValue(2, 1))

WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

WebUI.waitForElementVisible(findTestObject('Planning Application details/question_Application_Type'), 5)

WebUI.check(findTestObject('Planning Application details/check_Change_of_Use'))

WebUI.verifyElementText(findTestObject('Planning Application details/question_Any_Residential_Dwellings'), verData.getValue(
        1, 113), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Planning Application details/options_Question_4_Hidden_Options'), verData.getValue(
        1, 160), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.uncheck(findTestObject('Planning Application details/check_Change_of_Use'))

WebUI.check(findTestObject('Planning Application details/check_General_Industry'))

WebUI.verifyElementText(findTestObject('Planning Application details/question_Scale_of_the_Site'), verData.getValue(1, 150), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Planning Application details/options_Question_4_Hidden_Options'), verData.getValue(
        1, 161), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.uncheck(findTestObject('Planning Application details/check_General_Industry'))

WebUI.check(findTestObject('Planning Application details/check_Incineration'))

WebUI.verifyElementText(findTestObject('Planning Application details/question_Incinerated_Per_Year'), verData.getValue(1, 
        151), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Planning Application details/options_Question_4_Hidden_Options'), verData.getValue(
        1, 162), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.uncheck(findTestObject('Planning Application details/check_Incineration'))

WebUI.check(findTestObject('Planning Application details/check_Industrial_and_community'))

WebUI.verifyElementText(findTestObject('Planning Application details/question_Scale_of_the_Site'), verData.getValue(1, 150), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Planning Application details/options_Question_4_Hidden_Options'), verData.getValue(
	1, 161), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.uncheck(findTestObject('Planning Application details/check_Industrial_and_community'))

WebUI.check(findTestObject('Planning Application details/check_Minerals'))

WebUI.verifyElementText(findTestObject('Planning Application details/question_Mineral_Development'), verData.getValue(1, 
        152), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Planning Application details/options_Question_4_Hidden_Options'), verData.getValue(
	1, 163), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.uncheck(findTestObject('Planning Application details/check_Minerals'))

WebUI.check(findTestObject('Planning Application details/check_Waste'))

WebUI.verifyElementText(findTestObject('Planning Application details/question_Waste_Development'), verData.getValue(1, 153), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Planning Application details/options_Question_4_Hidden_Options'), verData.getValue(
	1, 163), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.uncheck(findTestObject('Planning Application details/check_Waste'))

WebUI.check(findTestObject('Planning Application details/check_Offices'))

WebUI.verifyElementText(findTestObject('Planning Application details/question_Hectares'), verData.getValue(1, 154), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Planning Application details/options_Question_4_Hidden_Options'), verData.getValue(
	1, 161), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.uncheck(findTestObject('Planning Application details/check_Offices'))

WebUI.check(findTestObject('Planning Application details/check_Renewable_Energy'))

WebUI.verifyElementText(findTestObject('Planning Application details/question_Renewable_Energy'), verData.getValue(1, 155), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Planning Application details/options_Question_4_Hidden_Options'), verData.getValue(
	1, 164), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.uncheck(findTestObject('Planning Application details/check_Renewable_Energy'))

WebUI.check(findTestObject('Planning Application details/check_Residential_Dwellings'))

WebUI.verifyElementText(findTestObject('Planning Application details/question_Housing_Land_Supply'), verData.getValue(1, 
        156), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Planning Application details/options_Question_4_Hidden_Options'), verData.getValue(
	1, 160), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Planning Application details/question_House_in_Multpile_Occupation'), verData.getValue(
        1, 157), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Planning Application details/options_Question_4_Hidden_second_Options'), verData.getValue(
	1, 160), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.uncheck(findTestObject('Planning Application details/check_Residential_Dwellings'))

WebUI.check(findTestObject('Planning Application details/check_Retail'))

WebUI.verifyElementText(findTestObject('Planning Application details/question_Scale_of_the_Site'), verData.getValue(1, 150), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Planning Application details/options_Question_4_Hidden_Options'), verData.getValue(
	1, 161), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.uncheck(findTestObject('Planning Application details/check_Retail'))

WebUI.check(findTestObject('Planning Application details/check_Telecommunications'))

WebUI.verifyElementText(findTestObject('Planning Application details/question_Tall_is_Mast'), verData.getValue(1, 158), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Planning Application details/options_Question_4_Hidden_Options'), verData.getValue(
	1, 165), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.uncheck(findTestObject('Planning Application details/check_Telecommunications'))

WebUI.check(findTestObject('Planning Application details/check_Travellers'))

WebUI.verifyElementText(findTestObject('Planning Application details/question_Traveller_Pitches'), verData.getValue(1, 159), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Planning Application details/options_Question_4_Hidden_Options'), verData.getValue(
	1, 166), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.uncheck(findTestObject('Planning Application details/check_Travellers'))

WebUI.closeBrowser()

