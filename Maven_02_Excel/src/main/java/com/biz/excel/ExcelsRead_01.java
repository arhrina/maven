package com.biz.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelsRead_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    	String exFile = "src/main/java/com/biz/excel/학생정보(2019-10-10).xlsx";
    	FileInputStream fs = null;
    	XSSFWorkbook workBook = null;
    	try {
			fs = new FileInputStream(exFile);
			workBook = new XSSFWorkbook(fs);
			// 엑셀파일을 workbook으로 호칭, 시트는 worksheet
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	// 학생정보 sheet에 5, 1(시작인 A1셀은 0, 0)의 셀 값을 읽는다
    	XSSFSheet xSheet = workBook.getSheet("학생정보");
    	XSSFRow curRow = xSheet.getRow(5);
    	XSSFCell curCell = curRow.getCell(1);
    	if(curCell != null)
    		System.out.println(curCell.toString());
	}
}