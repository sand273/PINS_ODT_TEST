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

WebUI.navigateToUrl('https://pins-test.gopro.net/')

WebUI.switchToWindowTitle('W/4001453 PLANNING INSPECTORATE, TEMPLE QUAY HOUSE, 2, THE SQUARE, TEMPLE QUAY, BRISTOL, BS1 6PN')

WebUI.click(findTestObject('GoPro UI/Case Summary/link_Processing'))

WebUI.click(findTestObject('null'))

WebUI.doubleClick(findTestObject('GoPro UI/Case Summary/message_Start_Case_Publish'))

WebUI.click(findTestObject('GoPro UI/Case Summary/div_Case Officer'))

WebUI.closeBrowser()

