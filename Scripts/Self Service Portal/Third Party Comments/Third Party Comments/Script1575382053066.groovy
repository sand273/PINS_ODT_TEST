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

def verData = TestDataFactory.findTestData('Data Files/GoPro_UI_Verification')

WebUI.callTestCase(findTestCase('Self Service Portal/Login/Third party'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Search_Appeal'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Third Party Comments/status_Open for comments'), 3)

WebUI.click(findTestObject('Third Party Comments/input_Error_agree'))

WebUI.click(findTestObject('Third Party Comments/a_Make a comment'))

WebUI.click(findTestObject('Third Party Comments/input_Which statement'))

WebUI.click(findTestObject('Third Party Comments/button_Next page'))

WebUI.setText(findTestObject('Third Party Comments/text_Enter_YourComments'), verData.getValue(1, 3))

WebUI.click(findTestObject('Third Party Comments/button_Save and continue'))

WebUI.waitForElementVisible(findTestObject('Third Party Comments/message_Comments_Confirmation'), 3)

WebUI.click(findTestObject('Third Party Comments/button_Submit'))

