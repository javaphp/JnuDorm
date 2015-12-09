package cn.jnu.dorm.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class ExcelReader {

	public static List<String[]> readExcel(File excelFile, int rowNum) throws BiffException, IOException {
		ArrayList<String[]> list = new ArrayList<String[]>();
		Workbook rwb = null;
		Cell cell = null;
		InputStream stream = new FileInputStream(excelFile);
		rwb = Workbook.getWorkbook(stream);
		Sheet sheet = rwb.getSheet(0);
		String[] contents = new String[sheet.getColumns()];
		for(int i = rowNum-1;i<sheet.getRows(); i++) {
			for(int j = 0; j<sheet.getColumns(); j++) {
				cell = sheet.getCell(j, i);
				contents[j] = cell.getContents();
			}
			list.add(contents);
		}
		return list;
		
	}
	
}
