package com.ppusari.java.etc.ExalControl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelImport {

	FileInputStream fis = null;
	HSSFWorkbook wb = null;
	HSSFSheet sheet =null;
 	
	public void ImportExeclFile(String fileName){
		try {
			fis = new FileInputStream(new File(fileName));
			wb = new HSSFWorkbook(fis); // Workbook형태의 데이터로 바꿈

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		// 데이터로 바뀌었는지 확인
		if (wb != null) {		  
			sheet = wb.getSheet("uniqueKey"); // uniqueKey이라는 시트를 불러옵니다.
		}
	}
	
	
	public void print(){		
		if (sheet != null) {	// 해당 시트가 있는지 확인		    
		    Iterator<Row> rows = sheet.rowIterator();	// row의 데이터들을 들고옵니다.
		    while (rows.hasNext()) {		     
		    	Iterator<Cell> cells = rows.next().iterator(); // Cell의 데이터들을 들고옵니다.
		 
		    	while (cells.hasNext()) {
		    		System.out.print(cells.next().getStringCellValue()+ "\t"); // 출력
		    	}
		     
		    	System.out.println();
		    }
		}
	}
	
	

}
