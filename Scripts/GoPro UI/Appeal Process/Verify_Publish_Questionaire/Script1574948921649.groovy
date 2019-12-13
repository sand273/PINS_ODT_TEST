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
import groovy.time.TimeCategory as TimeCategory
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory

WebUI.callTestCase(findTestCase('GoPro UI/Login/Case_Officer'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('GoPro UI/Generic/Search Appeal'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/dropdown_Publish_Questionaire'), 'defaultSelected', 
    'true', 5)

WebUI.click(findTestObject('GoPro UI/Case Documents/tab_Case_Documents'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents/link_folder_LPA_Questionaire'), 5)

WebUI.scrollToPosition(9999999, 9999999)

WebUI.click(findTestObject('GoPro UI/Case Documents/link_LPA_Questionaire'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents/link_File_LPA_Questionaire'), 5)

