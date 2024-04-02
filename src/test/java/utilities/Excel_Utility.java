package utilities;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class Excel_Utility {

 
	public static String path;
	public static FileOutputStream file;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	
	public static void openExcel() throws FileNotFoundException {
		
		path=System.getProperty("user.dir")+"\\Test_Data\\News_Around_Cognizant.xlsx";
		file=new FileOutputStream(path);
		wb=new XSSFWorkbook();
		sheet=wb.createSheet("News_Around_Cognizant");	
		
	}
	public static void enterData(List<String> header,List<String> toolTip) throws IOException {
		Excel_Utility.openExcel();
		
		XSSFRow row=sheet.createRow(0);
		CellStyle style = wb.createCellStyle();
        Font font = wb.createFont();
        font.setColor(IndexedColors.RED.getIndex());
        style.setFont(font);
        
		XSSFCell cell1 = row.createCell(0);
		cell1.setCellValue("News Header");
		cell1.setCellStyle(style);
		
		XSSFCell cell2 = row.createCell(1);
		cell2.setCellValue("Tooltip of the Header");
		cell2.setCellStyle(style);
		
		XSSFCell cell3 = row.createCell(2);
		cell3.setCellValue("Verification result");
		cell3.setCellStyle(style);

		for(int i=1;i<=header.size();i++) {
			
			XSSFRow currentRow=sheet.createRow(i);
			
			XSSFCell cell4 = currentRow.createCell(0);
			cell4.setCellValue(header.get(i-1));
			
			
			XSSFCell cell5 = currentRow.createCell(1);
			cell5.setCellValue(toolTip.get(i-1));
			
			
			if(header.get(i-1).equals(toolTip.get(i-1))) {		
				
				XSSFCell cell6 = currentRow.createCell(2);
				cell6.setCellValue("Same");
				
			}
			else {
				
				XSSFCell cell7 = currentRow.createCell(2);
				cell7.setCellValue("Not Same");
				
				
			}
		}
		
	}
	public static void enterContent(List<String> newsHeader,List<String> newsContent) throws IOException {
	
		XSSFRow row=sheet.createRow(8);
		
		CellStyle style = wb.createCellStyle();
        Font font = wb.createFont();
        font.setColor(IndexedColors.BLUE.getIndex());
        style.setFont(font);
        
		XSSFCell cell1 = row.createCell(0);
		cell1.setCellValue("Cognizant News");
		cell1.setCellStyle(style);
		
		for(int i=9;i<14;i++) {
			XSSFRow currentRow=sheet.createRow(i);
			
			currentRow.createCell(0).setCellValue(newsHeader.get(i-9));
			currentRow.createCell(1).setCellValue(newsContent.get(i-9));			
		}	
		Excel_Utility.closeExcel();
	}
 
	
	public static void closeExcel() throws IOException {
		wb.write(file);
		wb.close();
		file.close();
	}

	}
