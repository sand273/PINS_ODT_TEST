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

def testData = TestDataFactory.findTestData('Data Files/GoPro_UI_Verification')

WebUI.callTestCase(findTestCase('GoPro UI/Login/Case Officer'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('GoPro UI/Generic/Search Appeal'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

try {
    WebUI.verifyElementAttributeValue(findTestObject('GoPro UI/Case Summary/dropdown_Publish_Questionaire'), 'defaultSelected', 
        'true', 5)
}
catch (Exception ex) {
    WebUI.selectOptionByValue(findTestObject('GoPro UI/Case Summary/select_AbeyanceCase'), 'BE392705-0E9B-452A-8ED7-60EB6A708232', 
        true)

    WebUI.click(findTestObject('GoPro UI/Case Summary/button_Save'))
} 

WebUI.click(findTestObject('GoPro UI/Case Documents/tab_Case_Documents'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Summary/input_Search'), 10)

WebUI.click(findTestObject('GoPro UI/Case Summary/input_Search'))

WebUI.sendKeys(findTestObject('GoPro UI/Case Summary/input_Search'), testData.getValue(1, 11))

WebUI.click(findTestObject('GoPro UI/Case Summary/button_Search'))

if (WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents/link_LPA_Statement'), 5) == false) {
    CustomKeywords.'custom.WriteExcel.waitForObject'(150, 'GoPro UI/Case Documents/link_LPA_Statement', 'GoPro UI/Case Summary/button_Search')
}

WebUI.verifyElementText(findTestObject('GoPro UI/Case Documents/link_LPA_Statement'), testData.getValue(1, 11))

