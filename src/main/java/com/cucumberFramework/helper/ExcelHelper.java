package com.cucumberFramework.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {

	public static HashMap<String, String> getExcelData(String path, String sheetName) {
		FileInputStream fis;
		XSSFWorkbook workbook;
		XSSFSheet sheet;
		HashMap<String, String> map = new HashMap<>();
		try {
			fis = new FileInputStream(new File(path));
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
			int totalRows = sheet.getPhysicalNumberOfRows();
			int totalColumns = sheet.getRow(0).getLastCellNum();
			XSSFRow row = sheet.getRow(0);
			for (int i = 0; i < totalRows; i++) {
			for (int j = 0; j < totalColumns; j++) {
			map.put(row.getCell(j).getStringCellValue(), sheet.getRow(i).getCell(j).getStringCellValue());

				}
			}
			System.out.println(map);
			workbook.close();

		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("Workbook error");
			System.out.println(e.getMessage());
		}
		return map;
	}

}
