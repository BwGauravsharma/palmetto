package com.palmetto.testautomation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.palmetto.testautomation.properties.PalmettoTestAutomationProperties;

public class ReadExcel {
	
	public static String[][] readFromDataSheet(String worksheet)
			throws IOException {

		// Create a object of File class to open xlsx file palmetto-testdata.xlsx
		File file = new File(PalmettoTestAutomationProperties.DATASHEET_FILE_PATH);

		// Create an object of FileInputStream class to read excel file
		FileInputStream fis = new FileInputStream(file);

		String[][] data = extractDataFromExcelSheet(worksheet, fis);
		return data;
	}

	private static String[][] extractDataFromExcelSheet(String worksheet,
			FileInputStream fis) throws IOException {
		// Read sheet inside the workbook by its name
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet ws = wb.getSheet(worksheet);

		// Find number of rows and columns in excel file
		int rowNum = ws.getLastRowNum() + 1;
		int colNum = ws.getRow(0).getLastCellNum();

		String[][] data = new String[rowNum][colNum];

		for (int i = 0; i < rowNum; i++) {

			XSSFRow row = ws.getRow(i);
			for (int j = 0; j < colNum; j++) {

				XSSFCell cell = row.getCell(j);
				String value = cellToString(cell);
				data[i][j] = value;
				System.out.println("The Value is " + value);
				
			}

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
			throw new RuntimeException("There is no support for this type of cell");
		}

		return result.toString();

	}
	
	public static void main(String[] args) throws Exception {
		
		ReadExcel obj = new ReadExcel();
		
		obj.readFromDataSheet("LogIn");
		
	}


}
