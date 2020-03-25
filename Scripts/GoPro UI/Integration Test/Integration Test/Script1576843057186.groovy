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

String[] values = new String[25]

CustomKeywords.'custom.WriteExcel.readValues'(GlobalVariable.UploadFilePath + '\\AppealNumbers.xlsx', 'Appeals', values)

for (int iRow = 1; iRow <= GlobalVariable.driverCount; iRow++) 
{
    GlobalVariable.ApplicationRef = values[iRow].toString()

    WebUI.callTestCase(findTestCase('GoPro UI/Appeal Process/Case Start'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('GoPro UI/Appeal Process/Verify Timeline'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('Self Service Portal/Appeal Started/Verify Appeal Started'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('Self Service Portal/Complete Questionaire/Complete Questionaire'), [:], FailureHandling.STOP_ON_FAILURE)
}

WebUI.callTestCase(findTestCase('GoPro UI/Generic/Add wait'), [:], FailureHandling.STOP_ON_FAILURE)

for (int iVal = 1; iVal <= GlobalVariable.driverCount; iVal++) 
{
    GlobalVariable.ApplicationRef = values[iVal].toString()

    WebUI.callTestCase(findTestCase('GoPro UI/Appeal Process/Verify Publish Questionaire'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('GoPro UI/Appeal Process/Publish Questionaire'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('Self Service Portal/LPA Statement/Submit Statement'), [:], FailureHandling.STOP_ON_FAILURE)
}

WebUI.callTestCase(findTestCase('GoPro UI/Generic/Add wait'), [:], FailureHandling.STOP_ON_FAILURE)

for (int iCount = 1; iCount <= GlobalVariable.driverCount; iCount++) 
{
    GlobalVariable.ApplicationRef = values[iCount].toString()

    WebUI.callTestCase(findTestCase('GoPro UI/IP Comments/IP Comments'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('Self Service Portal/Third Party Comments/Third Party Comments'), [:], FailureHandling.STOP_ON_FAILURE)
}

WebUI.callTestCase(findTestCase('GoPro UI/Generic/Add wait'), [:], FailureHandling.STOP_ON_FAILURE)

for (int index = 1; index <= GlobalVariable.driverCount; index++) 
{
    GlobalVariable.ApplicationRef = values[index].toString()

    WebUI.callTestCase(findTestCase('GoPro UI/LPA Comments/LPA Comments'), [:], FailureHandling.STOP_ON_FAILURE)
}

WebUI.callTestCase(findTestCase('GoPro UI/Generic/Add wait'), [:], FailureHandling.STOP_ON_FAILURE)

for (int iMax = 1; iMax <= GlobalVariable.driverCount; iMax++) 
{
    GlobalVariable.ApplicationRef = values[iMax].toString()

    WebUI.callTestCase(findTestCase('GoPro UI/Final Comments/Verify Comments'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('Self Service Portal/Final Comments/Final Comments'), [:], FailureHandling.STOP_ON_FAILURE)
}

WebUI.callTestCase(findTestCase('GoPro UI/Generic/Add wait'), [:], FailureHandling.STOP_ON_FAILURE)

// runs fine till here

for (int iLoop = 1; iLoop <= GlobalVariable.driverCount; iLoop++) 
{
    GlobalVariable.ApplicationRef = values[iLoop].toString()

    WebUI.callTestCase(findTestCase('GoPro UI/Final Comments/Submit Comments'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('GoPro UI/Final Comments/Verify Event Status'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('GoPro UI/Event Date/Assign Date'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('Self Service Portal/Decision Issued/Verify Decision Issued'), [:], FailureHandling.STOP_ON_FAILURE)
}
