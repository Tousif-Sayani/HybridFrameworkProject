package com.qatools.qa.utility;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.qatools.qa.baseclass.BaseClass;

public class ReadExcelData extends BaseClass {

	String filePath;
	File file;
	Workbook wb;
	Sheet sheet;

	public ReadExcelData(String sheetName) {
		try {
			filePath = prop.getProperty("testDataLocation");
			file = new File(filePath);
			wb = WorkbookFactory.create(file);
			sheet = wb.getSheet(sheetName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HashMap<String, String> getExcelData(int rowNum) {

		HashMap<String, String> hm = new HashMap<String, String>();

		for (int i = 0; i < sheet.getRow(0).getLastCellNum(); i++) {
			sheet.getRow(rowNum).getCell(i).setCellType(CellType.STRING);
			hm.put(sheet.getRow(0).getCell(i).toString(), sheet.getRow(rowNum).getCell(i).toString());
		}
		return hm;
	}

	public int getRowCount() {
		return sheet.getLastRowNum();
	}

	public int getColCount() {
		return sheet.getRow(0).getLastCellNum();
	}
}
