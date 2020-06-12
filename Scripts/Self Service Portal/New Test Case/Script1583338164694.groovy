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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW

Date today = new Date()

String todaysDate = today.format('dd.MM.yyyy')

//String[] expVal = new String[20]
//W/4009642

String expTableLPA = todaysDate + ',Start Notice LPA (Written Reps),' + todaysDate + ',Upload_Pdf,' + todaysDate +  ',Upload_Pdf,' + todaysDate + ',Upload_Pdf,' + todaysDate + ',Upload_Document,' + todaysDate + ',Appeal a planning decision'

//String[] testVal = GlobalVariable.expTableList.split(',')


String expTableAppellant = todaysDate + ',LPA Questionnaire,' + todaysDate + ',Upload_Pdf,' + todaysDate + ',Start Notice Appellant (Written Reps),' + todaysDate + ',Upload_Pdf,' + todaysDate + ',Upload_Pdf,' + todaysDate + ',Upload_Pdf,' + todaysDate + ',Upload_Document,' + todaysDate + ',Appeal a planning decision'

// Appellant Login
WebUI.callTestCase(findTestCase('Self Service Portal/Login/Case Officer'), [:], FailureHandling.STOP_ON_FAILURE)

// LPA Login
//WebUI.callTestCase(findTestCase('Self Service Portal/Login/LPA User'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Search Appeal'), [:], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'custom.VerifyTable.verifyValues'('Complete Questionaire/table_Documents', expTableAppellant)


