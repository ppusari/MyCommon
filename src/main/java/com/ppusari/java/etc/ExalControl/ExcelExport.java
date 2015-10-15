package com.ppusari.java.etc.ExalControl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelExport {
	
	FileOutputStream fos = null;
	HSSFWorkbook wb  = null;
	HSSFSheet sheet = null;
	HSSFRow row = null;
	HSSFCell cell = null;
	
	public ExcelExport(){				
		wb = new HSSFWorkbook();			// 엑셀을 workbook을 만듭니다.
		sheet = wb.createSheet("uniqueKey");// Sheet를 만들어요. 이름은 Name	 
	}
	
	public void CreateExcelFile(String fileName){
		try {
			fos = new FileOutputStream(new File(fileName));
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		}
	}
	
	public void WriteExcel(ArrayList<String> datas){
		for (int i=0; i<datas.size()/2; i++){
			row = sheet.createRow(i); // row를 만든다.
								
			cell = row.createCell(0);
			cell.setCellValue(datas.get(i));
			
			cell = row.createCell(1);
			cell.setCellValue(datas.get(i + (datas.size()/2) ));
		}
		
 
		
		try {
			wb.write(fos);
			if (fos != null){
				fos.close();
			}
		} catch (IOException e) {			
			e.printStackTrace();
			System.out.println("엑셀 파일 생성 실패");
		}
	}

}
