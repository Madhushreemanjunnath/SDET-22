package com.crm.vtiger.genericUtilies;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


/**
 * to fetch the data from excel shet
 * @author Manjunath
 *
 */


public class ExcelUility {
 public String getDataFromexcel(String sheetname,int rownum ,int cellnum) throws IOException  {
	  FileInputStream fis=new FileInputStream(IPathConstant.ExcelPAth);
      Workbook w= WorkbookFactory.create(fis);
     Sheet sheet=w.getSheet(sheetname);
     Row row=sheet.getRow(rownum);
    String col=row.getCell(cellnum).getStringCellValue();
      return col;
     
      }
 public Object[][] getDataFromexcel(String sheetName) throws IOException
 {
	FileInputStream fis=new FileInputStream(IPathConstant.ExcelPAth);
	 Workbook workbook=WorkbookFactory.create(fis);
	 org.apache.poi.ss.usermodel.Sheet sheet=workbook.getSheet(sheetName);
	 int LastRow=sheet.getLastRowNum();
	 int lastCell=sheet.getRow(0).getLastCellNum();
	 Object[][] data=new Object[LastRow][lastCell];
	 for(int i=0;i<LastRow;i++)
	 { for(int j=0;j<lastCell;j++)
	 { data[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();
	 }
	 }return data;
 }
			 
 }
