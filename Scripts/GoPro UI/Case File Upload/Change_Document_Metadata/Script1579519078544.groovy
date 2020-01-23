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
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.WebElement as WebElement

def caseNumber = 'EN023012'

def rowsOnSpreadsheet = findTestData('Document_Metadata').getRowNumbers()

def i = 1

WebUI.callTestCase(findTestCase('GoPro UI/Login/Case Officer'), [:], FailureHandling.STOP_ON_FAILURE)

WebDriver driver = DriverFactory.getWebDriver()

WebUI.delay(1)

WebUI.click(findTestObject('GoPro UI/My cases/link_My events_location_arrow'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Navigation/Cases_Link'), 20)

WebUI.click(findTestObject('GoPro UI/Navigation/Cases_Link'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Summary/input_Search'), 20)

WebUI.click(findTestObject('Object Repository/GoPro UI/Case Summary/input_Search'))

WebUI.sendKeys(findTestObject('Object Repository/GoPro UI/Case Summary/input_Search'), caseNumber)

WebUI.click(findTestObject('Object Repository/GoPro UI/Case Summary/button_Search'))

WebUI.delay(1)

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Summary/Ds_Case_In_List', [('caseNumber') : caseNumber]), 20)

WebUI.doubleClick(findTestObject('GoPro UI/Case Summary/Ds_Case_In_List', [('caseNumber') : caseNumber]))

WebUI.switchToWindowIndex(1)

WebUI.click(findTestObject('GoPro UI/Case Documents/tab_Case_Documents'))

WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents/link_Documents', [('index') : i]), 20)

def numberOfDocuments = driver.findElements(By.xpath('//div[@class=\'gpview-template ng-scope\']')).size()

if (rowsOnSpreadsheet < numberOfDocuments) {
    numberOfDocuments = rowsOnSpreadsheet
}

for (def index : (i..numberOfDocuments)) {
    WebElement element = WebUiCommonHelper.findWebElement(findTestObject('GoPro UI/Case Documents/link_Documents', [('index') : i]), 
        20)

    WebUI.executeJavaScript('arguments[0].click()', Arrays.asList(element))

    WebUI.waitForElementVisible(findTestObject('Object Repository/GoPro UI/Case Documents/link_Document_Name'), 20)

    WebUI.click(findTestObject('Object Repository/GoPro UI/Case Documents/link_Document_Name'))

    WebUI.switchToWindowIndex(0)

    WebUI.switchToWindowIndex(1)

    WebUI.clearText(findTestObject('GoPro UI/Case Documents/input_Document_Name'))

    WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents/input_Document_Name_Empty'), 20)

    WebUI.click(findTestObject('GoPro UI/Case Documents/input_Document_Name_Empty'))

    WebUI.switchToWindowIndex(0)

    WebUI.switchToWindowIndex(1)

    WebUI.setText(findTestObject('GoPro UI/Case Documents/input_Document_Name_Empty'), findTestData('Document_Metadata').getValue(
            'Name', i))

    WebUI.click(findTestObject('GoPro UI/Case Documents/button_Save_Metadata'))

    WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents/link_Document_Type'), 20)

    if ((findTestData('Document_Metadata').getValue('Document Type', i) != 'NULL') && (findTestData('Document_Metadata').getValue(
        'Document Type', i) != '')) {
        try {
            WebUI.click(findTestObject('GoPro UI/Case Documents/link_Document_Type'))

            def documentType = findTestData('Document_Metadata').getValue('Document Type', i)

            WebUI.switchToWindowIndex(0)

            WebUI.switchToWindowIndex(1)

            WebUI.selectOptionByLabel(findTestObject('GoPro UI/Case Documents/select_Document_Type'), ('(?i:' + documentType) + 
                ')', true)

            WebUI.click(findTestObject('GoPro UI/Case Documents/button_Save_Metadata'))
        }
        catch (def e) {
        } 
    }
    
    WebUI.click(findTestObject('GoPro UI/Case Documents/link_Document_Status'))

    def status = findTestData('Document_Metadata').getValue('Status', i)

    WebUI.switchToWindowIndex(0)

    WebUI.switchToWindowIndex(1)

    WebUI.selectOptionByLabel(findTestObject('GoPro UI/Case Documents/select_Document_Status'), ('(?i:' + status) + ')', 
        true)

    WebUI.click(findTestObject('GoPro UI/Case Documents/button_Save_Metadata'))

    if ((findTestData('Document_Metadata').getValue('Category', i) != 'NULL') && (findTestData('Document_Metadata').getValue(
        'Category', i) != '')) {
        WebUI.scrollToElement(findTestObject('GoPro UI/Case Documents/link_Document_Category'), 20)

        WebUI.click(findTestObject('GoPro UI/Case Documents/link_Document_Category'))

        def category = findTestData('Document_Metadata').getValue('Category', i)

        WebUI.switchToWindowIndex(0)

        WebUI.switchToWindowIndex(1)

        WebUI.selectOptionByLabel(findTestObject('GoPro UI/Case Documents/select_Document_Category'), ('(?i:' + category) + 
            ')', true)

        WebUI.click(findTestObject('GoPro UI/Case Documents/button_Save_Metadata'))
    }
    
    if ((findTestData('Document_Metadata').getValue('Web Filter 1', i) != 'NULL') && (findTestData('Document_Metadata').getValue(
        'Web Filter 1', i) != '')) {
        WebUI.scrollToElement(findTestObject('GoPro UI/Case Documents/input_Document_Website_Filter_1'), 20)

        WebUI.setText(findTestObject('GoPro UI/Case Documents/input_Document_Website_Filter_1'), findTestData('Document_Metadata').getValue(
                'Web Filter 1', i), FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('GoPro UI/Case Documents/input_Document_Website_Filter_1'))

        WebUI.click(findTestObject('GoPro UI/Case Documents/button_Save_Metadata'))
    }
    
    if ((findTestData('Document_Metadata').getValue('Web Filter 2', i) != 'NULL') && (findTestData('Document_Metadata').getValue(
        'Web Filter 2', i) != '')) {
        WebUI.scrollToElement(findTestObject('GoPro UI/Case Documents/input_Document_Website_Filter_2'), 20)

        WebUI.setText(findTestObject('GoPro UI/Case Documents/input_Document_Website_Filter_2'), findTestData('Document_Metadata').getValue(
                'Web Filter 2', i), FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('GoPro UI/Case Documents/input_Document_Website_Filter_2'))

        WebUI.click(findTestObject('GoPro UI/Case Documents/button_Save_Metadata'))
    }
    
    WebUI.scrollToElement(findTestObject('GoPro UI/Case Documents/button_Document_Advanced'), 20)

    WebUI.click(findTestObject('GoPro UI/Case Documents/button_Document_Advanced'))

    WebUI.waitForElementVisible(findTestObject('GoPro UI/Case Documents/input_Document_External_Description'), 20)

    if ((findTestData('Document_Metadata').getValue('External Description', i) != 'NULL') && (findTestData('Document_Metadata').getValue(
        'External Description', i) != '')) {
        WebUI.setText(findTestObject('GoPro UI/Case Documents/input_Document_External_Description'), findTestData('Document_Metadata').getValue(
                'External Description', i), FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('GoPro UI/Case Documents/input_Document_External_Description'))

        WebUI.click(findTestObject('GoPro UI/Case Documents/button_Save_Metadata'))
    }
    
    if ((findTestData('Document_Metadata').getValue('Author', i) != 'NULL') && (findTestData('Document_Metadata').getValue(
        'Author', i) != '')) {
        WebUI.setText(findTestObject('GoPro UI/Case Documents/input_Document_Author'), findTestData('Document_Metadata').getValue(
                'Author', i), FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('GoPro UI/Case Documents/input_Document_Author'))

        WebUI.click(findTestObject('GoPro UI/Case Documents/button_Save_Metadata'))
    }
    
    if ((findTestData('Document_Metadata').getValue('Agent Name', i) != 'NULL') && (findTestData('Document_Metadata').getValue(
        'Agent Name', i) != '')) {
        WebUI.scrollToElement(findTestObject('GoPro UI/Case Documents/input_Document_Agent_Name'), 20)

        WebUI.setText(findTestObject('GoPro UI/Case Documents/input_Document_Agent_Name'), findTestData('Document_Metadata').getValue(
                'Agent Name', i), FailureHandling.STOP_ON_FAILURE)

        WebUI.click(findTestObject('GoPro UI/Case Documents/input_Document_Agent_Name'))

        WebUI.click(findTestObject('GoPro UI/Case Documents/button_Save_Metadata'))
    }
    
    i++

    WebUI.scrollToElement(findTestObject('GoPro UI/Case Documents/button_Document_Details'), 20)

    WebUI.click(findTestObject('GoPro UI/Case Documents/button_Document_Details'))
}

WebUI.closeBrowser()

