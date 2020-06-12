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

String[] values = new String[20]

CustomKeywords.'custom.WriteExcel.readValues'(GlobalVariable.UploadFilePath + '\\AppealNumbers.xlsx', 'Appeals', values)

GlobalVariable.ApplicationRef = (values[1]).toString()

WebUI.callTestCase(findTestCase('GoPro UI/Login/Case Officer'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

WebUI.click(findTestObject('GoPro UI/My cases/link_My events_location_arrow'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Navigation/link_Cases'), 20)

WebUI.click(findTestObject('GoPro UI/Navigation/link_Cases'))

WebUI.waitForElementClickable(findTestObject('GoPro UI/Case Summary/input_Search'), 5)

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/GoPro UI/Case Summary/input_Search'))

String[] ref = GlobalVariable.ApplicationRef.split('/')

WebUI.sendKeys(findTestObject('Object Repository/GoPro UI/Case Summary/input_Search'), ref[1])

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/GoPro UI/Case Summary/button_Search'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Cases/select_First_Case'), 20)

WebUI.click(findTestObject('GoPro UI/Cases/select_First_Case'))

WebUI.verifyElementVisible(findTestObject('GoPro UI/Cases/view_Case_Details'))

WebUI.verifyElementVisible(findTestObject('GoPro UI/Case Details/label_Assigned_To'))

WebUI.verifyElementVisible(findTestObject('GoPro UI/Case Details/label_LPA_Name'))

WebUI.verifyElementVisible(findTestObject('GoPro UI/Case Details/label_Appellant'))

WebUI.verifyElementVisible(findTestObject('GoPro UI/Case Details/label_Appeal_Type'))

WebUI.verifyElementVisible(findTestObject('GoPro UI/Case Details/label_Reason_For_Refusal'))

WebUI.verifyElementVisible(findTestObject('GoPro UI/Case Details/label_Original_Development_Description'))

WebUI.verifyElementVisible(findTestObject('GoPro UI/My cases/link_My events_location_arrow'))

WebUI.verifyElementVisible(findTestObject('GoPro UI/Cases/link_Show_Calendars'))

WebUI.verifyElementVisible(findTestObject('GoPro UI/Cases/menu_Actions_Hamburger'))

WebUI.verifyElementVisible(findTestObject('GoPro UI/Cases/button_Creation_Date_Filter'))

WebUI.verifyElementVisible(findTestObject('GoPro UI/Cases/button_Assigned_Officer_Inspector_Filter'))

WebUI.verifyElementVisible(findTestObject('GoPro UI/Cases/button_Appeal_Type_Filter'))

WebUI.verifyElementVisible(findTestObject('GoPro UI/Cases/button_Case_Status_Filter'))

WebUI.verifyElementVisible(findTestObject('GoPro UI/Cases/button_Site_Postcode_Filter'))

WebUI.verifyElementVisible(findTestObject('GoPro UI/Case Summary/input_Search'))

WebUI.click(findTestObject('GoPro UI/Cases/menu_Actions_Hamburger'))

WebUI.verifyElementVisible(findTestObject('GoPro UI/Actions Menu/button_Find_and_Open'))

WebUI.verifyElementVisible(findTestObject('GoPro UI/Actions Menu/button_History'))

WebUI.verifyElementVisible(findTestObject('GoPro UI/Actions Menu/button_Download_Documents'))

WebUI.verifyElementVisible(findTestObject('GoPro UI/Actions Menu/button_Create_Case'))

WebUI.verifyElementVisible(findTestObject('GoPro UI/Actions Menu/button_Create_Individual'))

WebUI.verifyElementVisible(findTestObject('GoPro UI/Actions Menu/button_Create_Company'))

WebUI.verifyElementVisible(findTestObject('GoPro UI/Actions Menu/button_Refresh'))

WebUI.verifyElementVisible(findTestObject('GoPro UI/Actions Menu/button_Save_Filter'))

WebUI.verifyElementVisible(findTestObject('GoPro UI/Actions Menu/button_Manage_Filters'))

WebUI.verifyElementVisible(findTestObject('GoPro UI/Actions Menu/button_Export'))

WebUI.verifyElementVisible(findTestObject('GoPro UI/Actions Menu/input_Creation_Date'))

WebUI.verifyElementVisible(findTestObject('GoPro UI/Actions Menu/input_Subject'))

WebUI.verifyElementVisible(findTestObject('GoPro UI/Actions Menu/input_Case_Type'))

WebUI.verifyElementVisible(findTestObject('GoPro UI/Actions Menu/button_About_GoPro'))

WebUI.verifyElementVisible(findTestObject('GoPro UI/Actions Menu/button_Take_Tour'))

WebUI.verifyElementVisible(findTestObject('GoPro UI/Actions Menu/button_Profile'))

WebUI.verifyElementVisible(findTestObject('GoPro UI/Actions Menu/button_Logout'))

WebUI.closeBrowser()

