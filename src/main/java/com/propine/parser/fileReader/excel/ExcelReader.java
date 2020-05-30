package com.propine.parser.fileReader.excel;

import com.propine.parser.constants.PathConstants;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {

    public Object[][] readFile() {

        Object[][] data = null;

        try {
            FileInputStream fis = new FileInputStream(new File(PathConstants.TESTDATA_EXCEL_FILE_PATH));

            XSSFWorkbook workbook = new XSSFWorkbook(fis);

            XSSFSheet sheet = workbook.getSheetAt(0);

            XSSFRow row = sheet.getRow(0);

            int rowNum = sheet.getPhysicalNumberOfRows();
            int colNum = row.getLastCellNum();

            data = new Object[rowNum - 1][colNum];

            for (int i = 1; i < rowNum; i++) {
                for (int j = 0; j < colNum; j++) {
                    if (row != null) {
                        XSSFCell cell = sheet.getRow(i).getCell(j);

                        String value = null;

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
        } catch (
                IOException ioe) {
            ioe.printStackTrace();
        }
        return data;
    }
}
