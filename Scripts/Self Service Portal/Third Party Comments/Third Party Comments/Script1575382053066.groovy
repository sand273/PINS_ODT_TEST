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
import com.kms.katalon.core.configuration.RunConfiguration as RC

String executionProfile = RC.getExecutionProfile()

String queRefMessage

def verData = TestDataFactory.findTestData('Data Files/Complete_Questionaire')

def testData = TestDataFactory.findTestData('Data Files/GoPro_UI_Verification')


if (executionProfile == 'pre-prod')
{
	WebUI.callTestCase(findTestCase('Self Service Portal/Login/Third party-Pre-prod'), [:], FailureHandling.STOP_ON_FAILURE)
}
else if (executionProfile == 'default')
{
	WebUI.callTestCase(findTestCase('Self Service Portal/Login/Third party'), [:], FailureHandling.STOP_ON_FAILURE)
}

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Search Appeal'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Third Party Comments/status_Open for comments'), 5)

WebUI.click(findTestObject('Third Party Comments/input_Error_agree'))

WebUI.click(findTestObject('Third Party Comments/button_Make a comment'))

WebUI.waitForElementVisible(findTestObject('Third Party Comments/message_Which_Statement'), 5)

WebUI.click(findTestObject('Third Party Comments/input_Which statement'))

WebUI.click(findTestObject('Third Party Comments/button_Next page'))

WebUI.waitForElementVisible(findTestObject('Third Party Comments/message_Enter_Comments'), 5)

WebUI.scrollToPosition(9999999, 9999999)

WebUI.setText(findTestObject('Third Party Comments/text_Enter_YourComments'), testData.getValue(1, 3))

WebUI.click(findTestObject('Third Party Comments/button_Save and continue'))

WebUI.waitForElementVisible(findTestObject('Third Party Comments/message_Comments_Confirmation'), 5)

WebUI.waitForElementClickable(findTestObject('Third Party Comments/button_Submit'), 5)

try {
    WebUI.click(findTestObject('Third Party Comments/button_Submit'))
}
catch (Exception ex) 
{
    WebUI.refresh()
	
	WebUI.delay(2)

	WebUI.click(findTestObject('Third Party Comments/button_Submit'))
} 

WebUI.waitForElementVisible(findTestObject('Complete Questionaire/title_Questionaire_Received'), 5)

WebUI.verifyElementText(findTestObject('Complete Questionaire/title_Questionaire_Received'), verData.getValue(1, 11))

WebUI.verifyElementVisible(findTestObject('Complete Questionaire/message_Questionaire_Reference_Num'))

queRefMessage = WebUI.getText(findTestObject('Complete Questionaire/message_Questionaire_Reference_Num'))

WebUI.verifyMatch(queRefMessage, verData.getValue(1, 12), true)

WebUI.verifyElementText(findTestObject('Complete Questionaire/message_Ref_Num_Value'), GlobalVariable.ApplicationRef)

WebUI.closeBrowser()

