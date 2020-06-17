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


GlobalVariable.caseType = 'Hearing'

String[] values = new String[10]

CustomKeywords.'custom.WriteExcel.readValues'(GlobalVariable.UploadFilePath + '\\AppealNumbers.xlsx', 'Appeals', values)

for (int iRow = 1; iRow <= GlobalVariable.driverCount; iRow++) 
{
    GlobalVariable.ApplicationRef = values[iRow].toString()

    WebUI.callTestCase(findTestCase('GoPro UI/Appeal Process/Case Start'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('GoPro UI/Appeal Process/Verify Timeline'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('Self Service Portal/Appeal Started/Verify Appeal Started'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('Self Service Portal/Complete Questionaire/Complete Questionaire'), [:], FailureHandling.STOP_ON_FAILURE)

	WebUI.callTestCase(findTestCase('GoPro UI/Generic/Add wait'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('GoPro UI/Appeal Process/Verify Publish Questionaire'), [:], FailureHandling.STOP_ON_FAILURE)

	WebUI.callTestCase(findTestCase('GoPro UI/Appeal Process/Publish Questionaire'), [:], FailureHandling.STOP_ON_FAILURE)

	WebUI.callTestCase(findTestCase('Self Service Portal/LPA Statement/Verify Statement Appellant'), [:], FailureHandling.STOP_ON_FAILURE)
	
    WebUI.callTestCase(findTestCase('Self Service Portal/LPA Statement/Submit Statement'), [:], FailureHandling.STOP_ON_FAILURE)

	WebUI.callTestCase(findTestCase('GoPro UI/Generic/Add wait'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('GoPro UI/IP Comments/IP Comments'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('Self Service Portal/Third Party Comments/Third Party Comments'), [:], FailureHandling.STOP_ON_FAILURE)

	WebUI.callTestCase(findTestCase('GoPro UI/Generic/Add wait'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('GoPro UI/LPA Statement/LPA Statement'), [:], FailureHandling.STOP_ON_FAILURE)

	WebUI.callTestCase(findTestCase('GoPro UI/Generic/Add wait'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('GoPro UI/Final Comments/Verify Comments'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('GoPro UI/Generic/Add wait'), [:], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Self Service Portal/Events/Verify Events Appellant'), [:], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Self Service Portal/Events/Verify Events LPA'), [:], FailureHandling.STOP_ON_FAILURE)
	
    WebUI.callTestCase(findTestCase('GoPro UI/Final Comments/Verify Event Status - Hearing'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('GoPro UI/Event Date/Assign Date'), [:], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('GoPro UI/Decision-Review-Held/Decision-Held-Publish'), [:], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('GoPro UI/Decision Issued/Verify Decision Issued'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('Self Service Portal/Decision Issued/Verify Decision Issued'), [:], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Self Service Portal/Decision Issued/Verify Decision Appellant'), [:], FailureHandling.STOP_ON_FAILURE)

}
