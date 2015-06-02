package com.palmetto.testautomation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.HashMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import com.palmetto.testautomation.properties.PalmettoTestAutomationProperties;

public class PalmettoTestAutomationUtilities {

	WebDriver driver;
	FileInputStream in;
	static String LogInData;

	public PalmettoTestAutomationUtilities() {

	}

	public void waitForSometime(WebDriver driver, long time)
			throws InterruptedException {
		driver.manage().timeouts().wait(time);

	}

	public void closeBrowser(WebDriver driver) {

		driver.quit();

	}

	public Properties readFromPropertiesFile() throws FileNotFoundException,
			IOException {

		File file = new File(PalmettoTestAutomationProperties.LOCATOR_PROP_FILE);
		in = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(in);

		return prop;
	}


	public static HashMap<String, HashMap<String, String>> readFromDataSheet(
			String worksheet) throws IOException {

		// Create a object of File class to open xlsx file palmetto-testdata.xlsx
		File file = new File(PalmettoTestAutomationProperties.DATASHEET_FILE_PATH);

		// Create an object of FileInputStream class to read excel file
		FileInputStream fis = new FileInputStream(file);

		HashMap<String, HashMap<String, String>> data = extractDataFromExcelSheet(worksheet, fis);
		return data;
	}

	private static HashMap<String, HashMap<String, String>> extractDataFromExcelSheet(
			String worksheet, FileInputStream fis) throws IOException {
		// Read sheet inside the workbook by its name
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet ws = wb.getSheet(worksheet);

		//Find number of rows and columns in excel file
		int rowNum = ws.getLastRowNum() + 1;
		int colNum = ws.getRow(0).getLastCellNum();

		HashMap<String, HashMap<String, String>> data = new HashMap<String, HashMap<String, String>>();
		String[] colNames = new String[colNum];

		for (int i = 0; i < 1; i++) {
			XSSFRow row = ws.getRow(i);
			for (int j = 0; j < colNum; j++) {

				XSSFCell cell = row.getCell(j);
				String value = cellToString(cell);
				colNames[j] = value;
				
			}
		}

		for (int i = 1; i < rowNum; i++) {
			XSSFRow row = ws.getRow(i);
			HashMap<String, String> cellData = new HashMap<String, String>();
			for (int j = 0; j < colNum; j++) {
				XSSFCell cell = row.getCell(j);
				String value = cellToString(cell);
				cellData.put(colNames[j], value);
			}
			data.put(Integer.toString(i), cellData);
		}
		return data;
	}

	public static String cellToString(XSSFCell cell) {

		String result;
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_NUMERIC:
			result = Double.toString(cell.getNumericCellValue());
			break;

		case Cell.CELL_TYPE_STRING:
			result = cell.getStringCellValue();
			break;

		default:
			throw new RuntimeException(
					"There is no support for this type of cell");
		}

		return result.toString();

	}

}
