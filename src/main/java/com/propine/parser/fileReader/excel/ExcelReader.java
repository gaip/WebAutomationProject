package com.propine.parser.fileReader.excel;

import com.propine.parser.constants.FilePathConstants;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {

	private static Object[][] data;

	/**
	 * Read File and store data
	 */
	public void generateTestData() {

		try {
			FileInputStream fis = new FileInputStream(new File(FilePathConstants.TESTDATA_EXCEL_FILE_PATH));

			// get workbook
			XSSFWorkbook workbook = new XSSFWorkbook(fis);

			// read first sheet
			XSSFSheet sheet = workbook.getSheetAt(0);

			// fetch first row
			XSSFRow row = sheet.getRow(0);

			// find total number of rows and column
			int rowNum = sheet.getPhysicalNumberOfRows();
			int colNum = row.getLastCellNum();

			// setting data object size
			data = new Object[rowNum - 1][colNum];

			// starting i from 1 as first row in excel contains headers
			for (int i = 1; i < rowNum; i++) {
				for (int j = 0; j < colNum; j++) {
					if (row != null) {
						XSSFCell cell = sheet.getRow(i).getCell(j);

						String value = null;

						// to handle blank values
						if (cell.getCellType() == CellType.BLANK) {
							value = "";
						} else if (cell.getCellType() == CellType.NUMERIC) {
							value = Double.toString(cell.getNumericCellValue());
						} else if (cell.getCellType() == CellType.STRING) {
							value = cell.getStringCellValue();
						}
						data[i - 1][j] = value;
					}
				}
			}
		} catch (
				FileNotFoundException fnf) {
			fnf.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		// check if data present
		if (data.length == 0) {
			throw new IllegalStateException("Test Data not initialized.");
		}
	}

	/**
	 * Return data for data provider
	 *
	 * @return data object
	 */
	public Object[][] getData() {
		return data;
	}

	/**
	 * Unit test to verify reader works properly
	 */
	@Test
	private void unitTest() {
		ExcelReader reader = new ExcelReader();
		reader.generateTestData();
	}

}
