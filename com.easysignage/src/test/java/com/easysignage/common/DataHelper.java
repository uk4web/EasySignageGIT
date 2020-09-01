package com.easysignage.common;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataHelper {

	XSSFWorkbook esWorkBook = null;
	static DataHelper dataHelper = null;

	public static DataHelper GetDataHelper() {
		if (dataHelper == null) {
			dataHelper = new DataHelper();
		}
		return dataHelper;
	}

	private DataHelper() {
		try {

			String filePath = ConfigFileReader.getInstance().getTestDataFileLocation() + "TestData.xlsx";
			FileInputStream fs = new FileInputStream(filePath);
			esWorkBook = new XSSFWorkbook(fs);

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public String getCellData(String sheetName, int rowNum, int colNum) {

		String cellValue = null;
		try {

			XSSFSheet sheet = esWorkBook.getSheet(sheetName);
			cellValue = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return cellValue;
	}
	
	public double getCellNumberData(String sheetName, int rowNum, int colNum) {

		double cellValue = 0;
		try {

			XSSFSheet sheet = esWorkBook.getSheet(sheetName);
			cellValue = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return cellValue;
	}

}
