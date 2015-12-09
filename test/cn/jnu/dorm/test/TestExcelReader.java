package cn.jnu.dorm.test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import jxl.read.biff.BiffException;

import cn.jnu.dorm.utils.ExcelReader;

public class TestExcelReader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir")); 
		String fileName = System.getProperty("user.dir") + "/WebRoot/excelFiles/test.xls";
		try {
			List<String[]> list = ExcelReader.readExcel(new File(fileName), 1);
			for(int i=0;i<list.size();i++) {
				String[] result = list.get(i);
				for(int j = 0; j < result.length; j++) {
					System.out.println(result[j]);
				}
			}
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
