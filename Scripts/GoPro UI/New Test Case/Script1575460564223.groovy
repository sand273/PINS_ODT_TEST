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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://pins-test.gopro.net/')

WebUI.switchToWindowTitle('pins-test views.caseresponses')

WebUI.click(findTestObject('GoPro UI/Case Documents/Page_pins-test viewscaseresponses/link_LPA_Statement'))

WebUI.click(findTestObject('GoPro UI/Case Documents/Page_pins-test viewscaseresponses/link_Expand_LPA Statement'))

WebUI.click(findTestObject('GoPro UI/Case Documents/Page_pins-test viewscaseresponses/link_Upload_Pdf'))

WebUI.click(findTestObject('GoPro UI/Case Documents/Page_pins-test viewscaseresponses/link_Your_Comments'))

WebUI.click(findTestObject('GoPro UI/Case Documents/Page_pins-test viewscaseresponses/link_Interested_Party_Pdf'))

