package com.InetBanking.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class XLUtils {

	
	public static FileInputStream Fis;
	public static Workbook wb;
	public static FileOutputStream Fos;
	
	
	public static int getrowcount(String path,String Sheet) throws Throwable {
		Fis=new FileInputStream(path);
		wb=WorkbookFactory.create(Fis);
		int rowcount=wb.getSheet(Sheet).getLastRowNum();
		return rowcount;
		
	}
	
	public static int getcellcount(String path,String Sheet,int row) throws Throwable, IOException {
		Fis=new FileInputStream(path);
		wb=WorkbookFactory.create(Fis);
		int cellcount=wb.getSheet(Sheet).getRow(row).getLastCellNum();
		return cellcount;
	}
	
	public static String getcelldata(String path,String Sheet,int row, int cell) throws Throwable {
		Fis=new FileInputStream(path);
		wb=WorkbookFactory.create(Fis);
		String cellvalue=wb.getSheet(Sheet).getRow(row).getCell(cell).getStringCellValue();
		return cellvalue;
	}
	
	public static void setcelldata(String path,String Sheet,int row,int cell,String data) throws Throwable {
		Fis=new FileInputStream(path);
		wb=WorkbookFactory.create(Fis);
		wb.getSheet(Sheet).getRow(row).createCell(cell).setCellValue(data);
		Fos=new FileOutputStream(path);
		wb.write(Fos);
		wb.close();
		
		
	}
}
