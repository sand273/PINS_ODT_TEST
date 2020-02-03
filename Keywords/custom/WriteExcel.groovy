package custom

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import internal.GlobalVariable
import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;

public class WriteExcel {

	@Keyword
	public void enterValues(String value, String fileName, String sheetName) throws IOException {
		FileInputStream fis = new FileInputStream(fileName);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();

		Row row = sheet.createRow(rowCount+1);
		Cell cell = row.createCell(0);
		cell.setCellType(cell.CELL_TYPE_STRING);
		cell.setCellValue(value);

		FileOutputStream fos = new FileOutputStream(fileName);
		workbook.write(fos);
		fos.close();
	}

	@Keyword
	public String readValues (String fileName, String sheetName, String[] values) throws IOException {

		int iRow=0;
		FileInputStream fis = new FileInputStream(fileName);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet(sheetName);
		GlobalVariable.driverCount = sheet.getLastRowNum()-sheet.getFirstRowNum();

		for(Row row : sheet) {
			for (Cell cell : row) {
				values[iRow] = cell.getStringCellValue();
				iRow++;
			}
		}
	}

	@Keyword
	public void clearValues(String fileName, String sheetName) throws IOException {

		int rowIndex
		FileInputStream fis = new FileInputStream(fileName);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();

		for (rowIndex=1;rowIndex<=rowCount;rowIndex++) {

			sheet.removeRow(sheet.getRow(rowIndex))
		}

		FileOutputStream fos = new FileOutputStream(fileName);
		workbook.write(fos);
		fos.close();
	}

	@Keyword
	def waitForObject(int timeOut, String object, String clickObj) {
		long timestart
		timestart = (System.currentTimeMillis() / 1000)

		while (WebUI.verifyElementNotPresent(findTestObject(object), 10, FailureHandling.OPTIONAL)) {

			long currenttime = System.currentTimeMillis() / 1000

			if (currenttime > (timestart + timeOut)) {
				WebUI.takeScreenshot()
				break
			}
			WebUI.waitForElementVisible(findTestObject(object), 20)
			WebUI.click(findTestObject(clickObj))
			WebUI.delay(1)
		}
	}
}