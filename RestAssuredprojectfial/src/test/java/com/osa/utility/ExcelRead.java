package com.osa.utility;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelRead {
	public static void main(String[] args) {
		String data=ExcelRead.dataRead("B2");		
	}
	public static String dataRead(String cellNumber) {	
		String cellValue=null;			
		try {	
			DataFormatter format=new DataFormatter();
		FileInputStream inputstream=new FileInputStream("\\src\\test\\resources\\Drivers\\RestAssuredData.xlsx");		
			XSSFWorkbook book= new XSSFWorkbook(inputstream);
			XSSFSheet sheet=book.getSheetAt(0);
			CellReference Cellref=new CellReference(cellNumber);
			Row row=sheet.getRow(Cellref.getRow());
			Cell cell=row.getCell(Cellref.getCol());			
			cellValue=format.formatCellValue(cell).trim();
			
		} catch (Exception e) {			
			System.out.println(e.getMessage());
			
		}
		return cellValue;
		}
}
