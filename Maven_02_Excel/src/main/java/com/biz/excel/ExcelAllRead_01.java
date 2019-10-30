package com.biz.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Hello world!
 *
 */
public class ExcelAllRead_01 
{
    public static void main( String[] args )
    {
    	String exFile = "src/main/java/com/biz/excel/학생정보(2019-10-10).xlsx";
    	XSSFWorkbook workBook = null;
    	try {
			FileInputStream fs = new FileInputStream(exFile);
			workBook = new XSSFWorkbook(fs);
			// 엑셀파일을 workbook으로 호칭, 시트는 worksheet
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	int rowIndex = 0;
    	int colIndex = 0;
    	XSSFSheet xSheet = workBook.getSheet("학생정보");
    	
    	// 현재 열린 sheet의 데이터가 저장된 row 개수 읽어옴
    	int rows = xSheet.getPhysicalNumberOfRows();
    	for(rowIndex = 0; rowIndex < rows; rowIndex++) {
    		// 현재 sheet에서 rowIndex 위치의 row를 읽어옴
    		XSSFRow curRow = xSheet.getRow(rowIndex);
    		// 현재 row의 데이터가 저장된 column 개수를 읽어옴
    		int cols = curRow.getPhysicalNumberOfCells();
    		for(colIndex = 0; colIndex < cols; colIndex++) {
    			// 한칸의 데이터를 읽어옴
    			XSSFCell cell = curRow.getCell(colIndex);
    			if(cell == null) continue; // 빈칸은 skip
    			else
    				System.out.print(cell.toString() + "\t");
    		}
    		System.out.println();
    	}
    	
        System.out.println( "Hello World!" );
    }
}
