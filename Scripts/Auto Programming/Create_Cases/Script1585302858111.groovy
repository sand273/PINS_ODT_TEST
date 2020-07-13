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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory

def rowsOnSpreadsheet = findTestData('Auto_Programming_Data/Cases_Data_AP').getRowNumbers()

def excelData = findTestData('Auto_Programming_Data/Cases_Data_AP')

def verData = TestDataFactory.findTestData('Data Files/Portal_Verification')

def i = 1

for (def index : (i..rowsOnSpreadsheet)) {
    WebUI.openBrowser('')

    WebUI.deleteAllCookies()

    WebUI.maximizeWindow()

    WebUI.navigateToUrl(GlobalVariable.URL)

    WebUI.click(findTestObject('PINS Test GoPro/a_Self Service'))

    WebUI.waitForElementVisible(findTestObject('Frontpage/button_Make an appeal - Beta service'), 3)

    WebUI.delay(1)

    WebUI.click(findTestObject('Frontpage/input'))

    WebUI.click(findTestObject('Frontpage/button_Make an appeal - Beta service'))

    def testData = TestDataFactory.findTestData('Data Files/Eligibility_Data')

    WebUI.callTestCase(findTestCase('Self Service Portal/Eligibility Checker/Appeal_Relate_Decision'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Appeal planning decision/input_Planning_Application'))

    WebUI.waitForElementClickable(findTestObject('Appeal planning decision/button_Continue'), 1)

    WebUI.click(findTestObject('Appeal planning decision/button_Continue'))

    WebUI.waitForElementVisible(findTestObject('Appeal planning decision/end_User_Question'), 2)

    WebUI.verifyElementText(findTestObject('Appeal planning decision/end_User_Question'), verData.getValue(1, 5))

    WebUI.click(findTestObject('Appeal planning decision/input_No_option'))

    WebUI.click(findTestObject('Appeal planning decision/button_Continue'))

    WebUI.waitForElementVisible(findTestObject('Appeal planning decision/end_User_Question'), 2)

    WebUI.verifyElementText(findTestObject('Appeal planning decision/end_User_Question'), verData.getValue(1, 6))

    WebUI.click(findTestObject('Appeal planning decision/input_Yes_option'))

    WebUI.waitForElementClickable(findTestObject('Appeal planning decision/button_Continue'), 1)

    WebUI.click(findTestObject('Appeal planning decision/button_Continue'))

    WebUI.waitForElementVisible(findTestObject('Appeal planning decision/end_User_Question'), 2)

    WebUI.verifyElementText(findTestObject('Appeal planning decision/end_User_Question'), verData.getValue(1, 7))

    WebUI.click(findTestObject('Appeal planning decision/input_No_option'))

    WebUI.click(findTestObject('Appeal planning decision/button_Continue'))

    WebUI.waitForElementVisible(findTestObject('Appeal planning decision/end_User_Question'), 2)

    WebUI.verifyElementText(findTestObject('Appeal planning decision/end_User_Question'), verData.getValue(1, 8))

    WebUI.setText(findTestObject('Appeal planning decision/input_Day'), testData.getValue(2, 1))

    WebUI.setText(findTestObject('Appeal planning decision/input_Month'), testData.getValue(3, 1))

    WebUI.setText(findTestObject('Appeal planning decision/input_Year'), testData.getValue(4, 1))

    WebUI.click(findTestObject('Appeal planning decision/button_Continue'))

    WebUI.waitForElementVisible(findTestObject('Appeal planning decision/eligibility_Confirmed'), 2)

    WebUI.verifyElementText(findTestObject('Appeal planning decision/eligibility_Confirmed'), verData.getValue(1, 9))

    WebUI.verifyElementVisible(findTestObject('Appeal planning decision/button_Appeal_Now'))

    WebUI.verifyElementText(findTestObject('Appeal planning decision/list_Confirmation'), verData.getValue(1, 16))

    WebUI.delay(1)

    WebUI.waitForElementVisible(findTestObject('Appeal planning decision/button_Appeal_Now'), 20)

    WebUI.click(findTestObject('Appeal planning decision/button_Appeal_Now'))

    WebUI.waitForElementVisible(findTestObject('Appeal planning decision/account_User_Question'), 2)

    WebUI.verifyElementText(findTestObject('Appeal planning decision/account_User_Question'), verData.getValue(1, 20))

    WebUI.click(findTestObject('Appeal planning decision/input_Account_Yes'))

    WebUI.click(findTestObject('Appeal planning decision/button_Account_Continue'))

    testData = TestDataFactory.findTestData('Data Files/User_Profile')

    //WebUI.waitForElementVisible(findTestObject('Frontpage/message_User_Name_Entry'), 5)
    //WebUI.verifyElementText(findTestObject('Frontpage/message_User_Name_Entry'), verData.getValue(1, 17))
    WebUI.setText(findTestObject('Frontpage/input_UserName'), testData.getValue(10, 1))

    WebUI.setEncryptedText(findTestObject('Frontpage/input_Password'), 'KT8JOVzAIqlDwzr433Fv5w==')

    WebUI.click(findTestObject('Frontpage/button_Login'))

    WebUI.waitForElementVisible(findTestObject('Appeal planning decision/message_Appeal_Planning_Decision'), 5)

    WebUI.verifyElementText(findTestObject('Appeal planning decision/message_Appeal_Planning_Decision'), verData.getValue(
            1, 21))

    WebUI.waitForElementVisible(findTestObject('Appeal planning decision/message_Check_Progress'), 5)

    WebUI.verifyElementText(findTestObject('Appeal planning decision/message_Check_Progress'), verData.getValue(1, 22))

    testData = TestDataFactory.findTestData('Data Files/Planning_Details')

    WebUI.waitForElementClickable(findTestObject('Appeal planning decision/link_Planning_Application_Details'), 1)

    WebUI.click(findTestObject('Appeal planning decision/link_Planning_Application_Details'))

    WebUI.waitForElementVisible(findTestObject('Planning Application details/question_Statement_Applies'), 3)

    WebUI.click(findTestObject('Planning Application details/option_Appeal_Decision_Received'))

    WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

    WebUI.waitForElementVisible(findTestObject('Planning Application details/question_Name_Original_Application'), 2)

    WebUI.setText(findTestObject('Planning Application details/text_Name_Application'), (('BAP' + i) + '_') + testData.getValue(
            1, 1))

    WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

    WebUI.waitForElementVisible(findTestObject('Planning Application details/question_LPA_Submit'), 3)

    WebUI.selectOptionByValue(findTestObject('Planning Application details/dropdown_LPA_Select'), 'C3810', true)

    WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

    WebUI.waitForElementVisible(findTestObject('Planning Application details/question_Application_Ref'), 2)

    WebUI.setText(findTestObject('Planning Application details/text_Application_Ref'), (('BAP' + i) + '_') + testData.getValue(
            2, 1))

    WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

    WebUI.waitForElementVisible(findTestObject('Planning Application details/question_Application_Type'), 2)

    WebUI.check(findTestObject('Planning Application details/check_Householder'))

    WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

    WebUI.waitForElementVisible(findTestObject('Planning Application details/message_Development_Description'), 2)

    WebUI.setText(findTestObject('Planning Application details/text_Development_Description'), testData.getValue(3, 1))

    WebUI.delay(1)

    WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

    WebUI.waitForElementVisible(findTestObject('Planning Application details/question_Description_Change'), 2)

    WebUI.check(findTestObject('Planning Application details/option_No_Description_Change'))

    WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

    WebUI.waitForElementVisible(findTestObject('Planning Application details/message_Upload_Application_Form'), 2)

    WebUI.click(findTestObject('Planning Application details/button_Application_Form'))

    WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Upload File'), [('exeFileName') : 'Doc_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

    WebUI.waitForElementVisible(findTestObject('Planning Application details/message_LPA_Decision_Notice'), 3)

    WebUI.click(findTestObject('Planning Application details/button_LPA_Notice'))

    WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Upload File'), [('exeFileName') : 'Pdf_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

    WebUI.waitForElementVisible(findTestObject('Planning Application details/message_Application'), 3)

    WebUI.click(findTestObject('Planning Application details/button_Outline_Planning'))

    WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

    WebUI.waitForElementVisible(findTestObject('Planning Application details/status_Complete_App_Details'), 3)

    WebUI.verifyElementText(findTestObject('Planning Application details/status_Complete_App_Details'), 'COMPLETED')

    WebUI.waitForElementClickable(findTestObject('Environmental details/link_Environmental_Details'), 5)

    WebUI.click(findTestObject('Environmental details/link_Environmental_Details'))

    WebUI.waitForElementVisible(findTestObject('Environmental details/question_Environmental_Impact_Assessment'), 5)

    WebUI.click(findTestObject('Environmental details/option_No_Env_Impact_Assessment'))

    WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

    WebUI.waitForElementVisible(findTestObject('Environmental details/question_Environmental_Statement'), 5)

    WebUI.click(findTestObject('Environmental details/option_No_Environment_Statement'))

    WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

    WebUI.waitForElementVisible(findTestObject('Environmental details/status_Complete_Environment_Details'), 10)

    WebUI.verifyElementText(findTestObject('Environmental details/status_Complete_Environment_Details'), 'COMPLETED')

    WebUI.waitForElementVisible(findTestObject('Planning Refused/link_Planning_Refused'), 2)

    WebUI.click(findTestObject('Planning Refused/link_Planning_Refused'))

    WebUI.waitForElementVisible(findTestObject('Planning Refused/question_Planning_Refused'), 2)

    WebUI.click(findTestObject('Planning Refused/input_Select all reasons'))

    WebUI.click(findTestObject('Planning Refused/input_Affordable housing_RefusalReasons'))

    WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

    WebUI.waitForElementVisible(findTestObject('Planning Refused/status_Completed_Refusal'), 10)

    WebUI.verifyElementText(findTestObject('Planning Refused/status_Completed_Refusal'), 'COMPLETED')

    WebUI.waitForElementVisible(findTestObject('Plans/link_Plans'), 5)

    WebUI.click(findTestObject('Plans/link_Plans'))

    WebUI.waitForElementVisible(findTestObject('Plans/message_Plan document'), 5)

    WebUI.click(findTestObject('Plans/button_Select_File'))

    WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Upload File'), [('exeFileName') : 'Pdf_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

    WebUI.waitForElementVisible(findTestObject('Plans/status_Complete_Plan_details'), 10)

    WebUI.verifyElementText(findTestObject('Plans/status_Complete_Plan_details'), 'COMPLETED')

    WebUI.waitForElementVisible(findTestObject('Additional Plans/link_Additional_Plans'), 5)

    WebUI.click(findTestObject('Additional Plans/link_Additional_Plans'))

    WebUI.waitForElementVisible(findTestObject('Additional Plans/question_LPA_Plans'), 5)

    WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

    WebUI.waitForElementVisible(findTestObject('Additional Plans/status_Complete_Additional_Plans'), 10)

    WebUI.verifyElementText(findTestObject('Additional Plans/status_Complete_Additional_Plans'), 'COMPLETED')

    WebUI.waitForElementVisible(findTestObject('Relevant Plans/link_Relevant_Plans'), 5)

    WebUI.click(findTestObject('Relevant Plans/link_Relevant_Plans'))

    WebUI.waitForElementVisible(findTestObject('Relevant Plans/question_Other_Plans'), 5)

    WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

    WebUI.waitForElementVisible(findTestObject('Relevant Plans/status_Complete_Relevant_Plans'), 10)

    WebUI.verifyElementText(findTestObject('Relevant Plans/status_Complete_Relevant_Plans'), 'COMPLETED')

    WebUI.waitForElementVisible(findTestObject('Application Technical Reports/link_Application_Technical_Reports'), 5)

    WebUI.click(findTestObject('Application Technical Reports/link_Application_Technical_Reports'))

    WebUI.waitForElementVisible(findTestObject('Application Technical Reports/question_Technical_Reports'), 5)

    WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

    WebUI.waitForElementVisible(findTestObject('Application Technical Reports/status_Complete_Application_Technical_Reports'), 
        10)

    WebUI.verifyElementText(findTestObject('Application Technical Reports/status_Complete_Application_Technical_Reports'), 
        'COMPLETED')

    WebUI.waitForElementVisible(findTestObject('Other Submitted Documents/link_Other_Submitted_Documents'), 5)

    WebUI.click(findTestObject('Other Submitted Documents/link_Other_Submitted_Documents'))

    WebUI.waitForElementClickable(findTestObject('Planning Application details/button_Save_Continue'), 5)

    WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

    WebUI.waitForElementVisible(findTestObject('Other Submitted Documents/status_Complete_Submitted_Documents'), 10)

    WebUI.verifyElementText(findTestObject('Other Submitted Documents/status_Complete_Submitted_Documents'), 'COMPLETED')

    testData = TestDataFactory.findTestData('Data Files/Site_Details')

    WebUI.waitForElementVisible(findTestObject('Site Details/link_Site details'), 5)

    WebUI.click(findTestObject('Site Details/link_Site details'))

    WebUI.waitForElementVisible(findTestObject('Site Details/question_PostCode'), 5)

    WebUI.click(findTestObject('Site Details/input_Site_Postcode'))

    WebUI.waitForElementVisible(findTestObject('Site Details/question_Site_Address'), 5)

    WebUI.setText(findTestObject('Site Details/input_SitePostcode'), excelData.getValue('Postcode', i))

    WebUI.click(findTestObject('Site Details/button_Find address'))

    WebUI.delay(1)

    WebUI.waitForElementClickable(findTestObject('Site Details/dropdown_Select address'), 5)

    WebUI.selectOptionByIndex(findTestObject('Site Details/dropdown_Select address'), 1, FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

    WebUI.waitForElementVisible(findTestObject('Site Details/message_Green_Belt'), 5)

    WebUI.click(findTestObject('Site Details/button_No'))

    WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

    WebUI.waitForElementVisible(findTestObject('Site Details/question_Public_Land'), 5)

    WebUI.click(findTestObject('Site Details/input_Yes_SiteSeenFromPublicLand'))

    WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

    WebUI.waitForElementVisible(findTestObject('Site Details/question_Site_Restricted'), 5)

    WebUI.click(findTestObject('Site Details/input_Yes_SiteRestrictedAccess'))

    WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

    WebUI.waitForElementVisible(findTestObject('Site Details/question_Health_Safety'), 5)

    WebUI.click(findTestObject('Site Details/input_Yes_SiteHealthConcerns'))

    WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

    WebUI.waitForElementVisible(findTestObject('Site Details/question_Site_Inspector'), 5)

    WebUI.click(findTestObject('Site Details/input_Yes_SiteInspectorVisit'))

    WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

    WebUI.waitForElementVisible(findTestObject('Site Details/status_Completed_Site_Details'), 10)

    WebUI.verifyElementText(findTestObject('Site Details/status_Completed_Site_Details'), 'COMPLETED')

    WebUI.waitForElementVisible(findTestObject('Listed building status/link_Listed_Building'), 5)

    WebUI.click(findTestObject('Listed building status/link_Listed_Building'))

    WebUI.waitForElementVisible(findTestObject('Listed building status/question_Listed_Building'), 5)

    WebUI.click(findTestObject('Listed building status/input_No_Listed_Building'))

    WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

    WebUI.waitForElementVisible(findTestObject('Listed building status/status_Complete_Listed_Building'), 10)

    WebUI.verifyElementText(findTestObject('Listed building status/status_Complete_Listed_Building'), 'COMPLETED')

    WebUI.waitForElementVisible(findTestObject('Main grounds of Appeal/link_Main_grounds'), 5)

    WebUI.click(findTestObject('Main grounds of Appeal/link_Main_grounds'))

    WebUI.waitForElementVisible(findTestObject('Main grounds of Appeal/message_special_category_information'), 5)

    WebUI.click(findTestObject('Main grounds of Appeal/input_Yes_AppealSpecialCategory'))

    WebUI.click(findTestObject('Main grounds of Appeal/button_Select_File'))

    WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Upload File'), [('exeFileName') : 'Pdf_Upload.exe'], FailureHandling.STOP_ON_FAILURE)

    WebUI.waitForElementClickable(findTestObject('Main grounds of Appeal/input_understand_AppealAgreement'), 5)

    WebUI.click(findTestObject('Main grounds of Appeal/input_understand_AppealAgreement'))

    WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

    WebUI.waitForElementVisible(findTestObject('Main grounds of Appeal/status_Complete_Grounds'), 10)

    WebUI.verifyElementText(findTestObject('Main grounds of Appeal/status_Complete_Grounds'), 'COMPLETED')

    WebUI.waitForElementVisible(findTestObject('Supporting Grounds/link_Supporting_Grounds'), 5)

    WebUI.click(findTestObject('Supporting Grounds/link_Supporting_Grounds'))

    WebUI.waitForElementVisible(findTestObject('Supporting Grounds/message_Upload_File'), 5)

    WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

    WebUI.waitForElementVisible(findTestObject('Supporting Grounds/status_Complete_Supporting_Docs'), 10)

    WebUI.verifyElementText(findTestObject('Supporting Grounds/status_Complete_Supporting_Docs'), 'COMPLETED')

    WebUI.waitForElementVisible(findTestObject('Other Appeals/link_Other_Appeals'), 5)

    WebUI.click(findTestObject('Other Appeals/link_Other_Appeals'))

    WebUI.waitForElementVisible(findTestObject('Other Appeals/question_Another_Appeal'), 5)

    WebUI.click(findTestObject('Other Appeals/input_No_Another_Appeal'))

    WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

    WebUI.waitForElementVisible(findTestObject('Other Appeals/question_Submit_Another_Appeal'), 5)

    WebUI.click(findTestObject('Other Appeals/input_No_Submit_Another'))

    WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

    WebUI.waitForElementVisible(findTestObject('Other Appeals/status_Complete_Another_Appeal'), 10)

    WebUI.verifyElementText(findTestObject('Other Appeals/status_Complete_Another_Appeal'), 'COMPLETED')

    WebUI.waitForElementVisible(findTestObject('Costs/link_Costs'), 5)

    WebUI.click(findTestObject('Costs/link_Costs'))

    WebUI.waitForElementVisible(findTestObject('Costs/question_Costs_Application'), 5)

    WebUI.click(findTestObject('Costs/input_No_Costs'))

    WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

    WebUI.waitForElementVisible(findTestObject('Costs/status_Complete_Costs'), 10)

    WebUI.verifyElementText(findTestObject('Costs/status_Complete_Costs'), 'COMPLETED')

    WebUI.waitForElementVisible(findTestObject('Ownership/link_Ownership'), 5)

    WebUI.click(findTestObject('Ownership/link_Ownership'))

    WebUI.waitForElementVisible(findTestObject('Ownership/message_Sole_Owner'), 5)

    WebUI.click(findTestObject('Ownership/input_Yes_Option'))

    WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

    WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Agricultural Holding'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.waitForElementVisible(findTestObject('Ownership/status_Complete_Ownership'), 10)

    WebUI.verifyElementText(findTestObject('Ownership/status_Complete_Ownership'), 'COMPLETED')

    WebUI.waitForElementVisible(findTestObject('Preferred procedure/link_Preferred_Procedure'), 5)

    WebUI.click(findTestObject('Preferred procedure/link_Preferred_Procedure'))

    WebUI.waitForElementVisible(findTestObject('Preferred procedure/question_Preferred_Procedure'), 5)

    WebUI.click(findTestObject('Preferred procedure/input_Written_Representation'))

    WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

    WebUI.waitForElementVisible(findTestObject('Preferred procedure/status_Complete_Preferred'), 10)

    WebUI.verifyElementText(findTestObject('Preferred procedure/status_Complete_Preferred'), 'COMPLETED')

    WebUI.waitForElementVisible(findTestObject('Application Technical Reports/link_Technical_Reports'), 5)

    WebUI.click(findTestObject('Application Technical Reports/link_Technical_Reports'))

    WebUI.waitForElementVisible(findTestObject('Application Technical Reports/message_Technical_Reports', [('index') : 1]), 
        5)

    WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

    WebUI.waitForElementVisible(findTestObject('Technical Reports Post Decision/status_Complete_Technical_Reports'), 10)

    WebUI.verifyElementText(findTestObject('Technical Reports Post Decision/status_Complete_Technical_Reports'), 'COMPLETED')

    WebUI.waitForElementVisible(findTestObject('Other Appeal Information/link_Other_Appeal_Information'), 5)

    WebUI.click(findTestObject('Other Appeal Information/link_Other_Appeal_Information'))

    WebUI.waitForElementVisible(findTestObject('Other Appeal Information/message_Upload_documents'), 5)

    WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

    WebUI.waitForElementVisible(findTestObject('Other Appeal Information/status_Complete_Other_Information'), 10)

    WebUI.verifyElementText(findTestObject('Other Appeal Information/status_Complete_Other_Information'), 'COMPLETED')

    testData = TestDataFactory.findTestData('Data Files/User_Profile')

    WebUI.waitForElementVisible(findTestObject('Contact Details/link_Contact_Details'), 5)

    WebUI.click(findTestObject('Contact Details/link_Contact_Details'))

    WebUI.waitForElementVisible(findTestObject('Contact Details/message_Contact_Details'), 5)

    not_run: WebUI.setText(findTestObject('Contact Details/text_County'), testData.getValue(5, 1))

    not_run: WebUI.setText(findTestObject('Contact Details/text_PostCode'), testData.getValue(6, 1))

    WebUI.click(findTestObject('Planning Application details/button_Save_Continue'))

    WebUI.waitForElementVisible(findTestObject('Contact Details/status_Complete_Contact_Details'), 10)

    WebUI.verifyElementText(findTestObject('Contact Details/status_Complete_Contact_Details'), 'COMPLETED')

    WebUI.waitForElementVisible(findTestObject('Check your answers/link_Check_Answers'), 5)

    WebUI.click(findTestObject('Check your answers/link_Check_Answers'))

    WebUI.waitForElementVisible(findTestObject('Check your answers/message_Check_Answers'), 5)

    WebUI.scrollToElement(findTestObject('Check your answers/button_Save_Continue'), 5)

    WebUI.delay(1)

    WebUI.waitForElementClickable(findTestObject('Check your answers/button_Save_Continue'), 5)

    WebUI.click(findTestObject('Check your answers/button_Save_Continue'))

    WebUI.waitForElementVisible(findTestObject('Check your answers/message_Check_Progress'), 5)

    WebUI.waitForElementClickable(findTestObject('Check your answers/button_Ready_to_Submit'), 5)

    WebUI.click(findTestObject('Check your answers/button_Ready_to_Submit'))

    WebUI.delay(1)

    WebUI.waitForElementVisible(findTestObject('Terms and Conditions/message_Terms_Conditions'), 3)

    WebUI.click(findTestObject('Terms and Conditions/checkBox_Agree'))

    WebUI.click(findTestObject('Terms and Conditions/button_Submit_Appeal'))

    WebUI.waitForElementVisible(findTestObject('Appeal Received/title_Appeal_Received'), 5)

    WebUI.refresh()

    GlobalVariable.ApplicationRef = WebUI.getText(findTestObject('Appeal Received/label_Appeal_Received'))

    CustomKeywords.'custom.WriteExcel.enterValues'(GlobalVariable.ApplicationRef, GlobalVariable.UploadFilePath + '\\AppealNumbers.xlsx', 
        'Appeals')

    CustomKeywords.'custom.WriteExcel.APData'(GlobalVariable.ApplicationRef, 'C:\\Katalon\\Data-Files\\Auto Programming\\Case Data for 14 Cases.xlsx', 
        'Sheet1', i, 1)

    WebUI.click(findTestObject('Appeal Received/button_Appeal_Summary'))

    def planData = TestDataFactory.findTestData('Data Files/Planning_Details')

    def siteData = TestDataFactory.findTestData('Data Files/Site_Details')

    WebUI.waitForElementVisible(findTestObject('Appeal Summary/status_Submitted'), 5)

    WebUI.verifyElementText(findTestObject('Appeal Summary/status_Submitted'), verData.getValue(1, 77))

    WebUI.callTestCase(findTestCase('Self Service Portal/Generic/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

    i++
}

