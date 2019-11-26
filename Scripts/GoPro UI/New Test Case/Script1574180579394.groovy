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

WebUI.openBrowser('')

WebUI.click(findTestObject('Complete Questionaire/Page_Local planning authority questionnaire/button_documentwrite_Next page'))

WebUI.click(findTestObject('Complete Questionaire/Page_Local planning authority questionnaire/button_documentwrite_Next page'))

WebUI.click(findTestObject('Page_Local planning authority questionnaire/input_Yes_EmergingPolicies'))

WebUI.click(findTestObject('Complete Questionaire/Page_Local planning authority questionnaire/button_documentwrite_Next page'))

WebUI.click(findTestObject('Page_Local planning authority questionnaire/input_Yes_FiveHousing'))

WebUI.click(findTestObject('Complete Questionaire/Page_Local planning authority questionnaire/button_documentwrite_Next page'))

WebUI.click(findTestObject('Page_Local planning authority questionnaire/input_Yes_ConditionsSuggestions'))

WebUI.click(findTestObject('Page_Local planning authority questionnaire/input_Yes_ConditionsObligation'))

WebUI.click(findTestObject('Complete Questionaire/Page_Local planning authority questionnaire/button_documentwrite_Next page'))

WebUI.click(findTestObject('Page_Local planning authority questionnaire/input_Yes_ConservationSite'))

WebUI.click(findTestObject('Complete Questionaire/Page_Local planning authority questionnaire/button_documentwrite_Next page'))

WebUI.click(findTestObject('Page_Local planning authority questionnaire/input_Yes_BuildingAffects'))

WebUI.click(findTestObject('Page_Local planning authority questionnaire/input_Yes_BuildingAffectScheduleMonument'))

WebUI.click(findTestObject('Complete Questionaire/Page_Local planning authority questionnaire/button_documentwrite_Next page'))

WebUI.click(findTestObject('Page_Local planning authority questionnaire/input_Yes_ScreeningOpinion'))

WebUI.click(findTestObject('Complete Questionaire/Page_Local planning authority questionnaire/button_documentwrite_Next page'))

WebUI.closeBrowser()

