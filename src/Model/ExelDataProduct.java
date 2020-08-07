package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Controller.Bed;
import Controller.Chair;
import Controller.Closet;
import Controller.ComputerChair;
import Controller.ComputerTable;
import Controller.DiningChair;
import Controller.DiningTable;
import Controller.Mattress;
import Controller.Product;
import Controller.Sofa;

public class ExelDataProduct {
    
	Connection conn = null;
    private static String[] columns  = {"שם רהיט ","מק''ט","ספק","עלות","מכירה","צבע","כמות","גובה", "אורך", "מס' גלגלים", "חומר", "בד", "מקומות ישיבה", "הזזה", "מגירות", "שולחן נפתח", "אורטופדי", "ספה נפתחת"};
    private static List<Bed> Bprod = new ArrayList<Bed>();
    private static List<Closet> Cprod = new ArrayList<Closet>();
    private static List<ComputerChair> CCprod = new ArrayList<ComputerChair>();
    private static List<ComputerTable> CTprod = new ArrayList<ComputerTable>();
    private static List<DiningChair> DCprod = new ArrayList<DiningChair>();
    private static List<DiningTable> DTprod = new ArrayList<DiningTable>();
    private static List<Mattress> Mprod = new ArrayList<Mattress>();
    private static List<Sofa> Sprod = new ArrayList<Sofa>();

	public static void main(String[] args) throws IOException, InvalidFormatException {	
		
        //Experience of the method
        ReadEcel();
       
		//Experience of the method
		WriteExel();
		
		//Experience of the method
		//DeleteExel();
	}
	
	public static void WriteExel() throws IOException{
		int rowNum = 1;
		Bprod.add(new Bed ("מיטה", 666, "ליאור סושארד", 400, 2000, "אדום", 7, 43.2, 52.1));
		Cprod.add(new Closet ("ארון", 888, "צביקה פיק", 100, 2000, "ורוד", 2, 24.3, 56.65, "True"));
		Sprod.add(new Sofa ("ספה", 2, "גוקו", 730, 2000, "תכלת מגניב", 4, 57.3, 23.4, "False"));
		CCprod.add(new ComputerChair ("כיסא מחשב", 22, "עודד מכנס", 200, 4000, "שחור", 3, 55.3, 72.4, 5));
		CTprod.add(new ComputerTable ("שולחן מחשב", 9, "מיכאלנג'לו", 700, 200, "סגול", 4, 57.3, 23.4, "True" ,"עץ"));
		DCprod.add(new DiningChair ("כיסא אוכל", 1, "אלירן עטר", 200, 4000, "שחור", 3, 55.3, 72.4, "פשתן"));
		DTprod.add(new DiningTable ("שולחן אוכל", 73, "עלי בבא", 123, 456, "לבן", 4, 57.3, 23.4, 8 , "False"));
		Mprod.add(new Mattress ("מזרון", 13, "קיפוד", 700, 200, "ירוק", 4, 57.3, 23.4, "True"));
		Sprod.add(new Sofa ("ספה", 7, "ספיידרמן", 590, 200, "תכלת מגניב", 4, 57.3, 23.4, "False"));
		DCprod.add(new DiningChair ("כיסא אוכל", 1, "שלומי סרנגה", 600, 8600, "כתום", 3, 55.3, 72.4, "גליק"));
		CTprod.add(new ComputerTable ("שולחן מחשב", 9, "דון קישוט", 7000, 22900, "ורוד", 4, 57.3, 23.4, "True" ,"עץ"));
		
	    Workbook workbook = new XSSFWorkbook();
	    Sheet sheet = workbook.createSheet("products");
		
	    Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
	
	    Row headerRow = sheet.createRow(0);

        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }

        for (Bed prod : Bprod) {
        	Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(prod.getName());
            row.createCell(1).setCellValue(prod.getID());
            row.createCell(2).setCellValue(prod.getProductProvider());
            row.createCell(3).setCellValue(prod.getCostPrice());
            row.createCell(4).setCellValue(prod.getSellingprice());
            row.createCell(5).setCellValue(prod.getColor());
            row.createCell(6).setCellValue(prod.getQuantity());
        	row.createCell(7).setCellValue(prod.getHeight());
        	row.createCell(8).setCellValue(prod.getLength());
        }
        
        for (Closet prod : Cprod) {
        	Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(prod.getName());
            row.createCell(1).setCellValue(prod.getID());
            row.createCell(2).setCellValue(prod.getProductProvider());
            row.createCell(3).setCellValue(prod.getCostPrice());
            row.createCell(4).setCellValue(prod.getSellingprice());
            row.createCell(5).setCellValue(prod.getColor());
            row.createCell(6).setCellValue(prod.getQuantity());
        	row.createCell(7).setCellValue(prod.getHeight());
        	row.createCell(8).setCellValue(prod.getLength());
        	row.createCell(13).setCellValue(prod.getisSliding());
        }
        
        for (ComputerChair prod : CCprod) {
        	Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(prod.getName());
            row.createCell(1).setCellValue(prod.getID());
            row.createCell(2).setCellValue(prod.getProductProvider());
            row.createCell(3).setCellValue(prod.getCostPrice());
            row.createCell(4).setCellValue(prod.getSellingprice());
            row.createCell(5).setCellValue(prod.getColor());
            row.createCell(6).setCellValue(prod.getQuantity());
        	row.createCell(7).setCellValue(prod.getHeight());
        	row.createCell(8).setCellValue(prod.getLength());
        	row.createCell(9).setCellValue(prod.getNumWheels());
        }
        
        for (ComputerTable prod : CTprod) {
        	Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(prod.getName());
            row.createCell(1).setCellValue(prod.getID());
            row.createCell(2).setCellValue(prod.getProductProvider());
            row.createCell(3).setCellValue(prod.getCostPrice());
            row.createCell(4).setCellValue(prod.getSellingprice());
            row.createCell(5).setCellValue(prod.getColor());
            row.createCell(6).setCellValue(prod.getQuantity());
        	row.createCell(7).setCellValue(prod.getHeight());
        	row.createCell(8).setCellValue(prod.getLength());
        	row.createCell(14).setCellValue(prod.getisDrawer());
        	row.createCell(10).setCellValue(prod.getMaterial());
        }
        
        for (DiningChair prod : DCprod) {
        	Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(prod.getName());
            row.createCell(1).setCellValue(prod.getID());
            row.createCell(2).setCellValue(prod.getProductProvider());
            row.createCell(3).setCellValue(prod.getCostPrice());
            row.createCell(4).setCellValue(prod.getSellingprice());
            row.createCell(5).setCellValue(prod.getColor());
            row.createCell(6).setCellValue(prod.getQuantity());
        	row.createCell(7).setCellValue(prod.getHeight());
        	row.createCell(8).setCellValue(prod.getLength());
        	row.createCell(11).setCellValue(prod.getFabric());
        }
        
        for (DiningTable prod : DTprod) {
        	Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(prod.getName());
            row.createCell(1).setCellValue(prod.getID());
            row.createCell(2).setCellValue(prod.getProductProvider());
            row.createCell(3).setCellValue(prod.getCostPrice());
            row.createCell(4).setCellValue(prod.getSellingprice());
            row.createCell(5).setCellValue(prod.getColor());
            row.createCell(6).setCellValue(prod.getQuantity());
        	row.createCell(7).setCellValue(prod.getHeight());
        	row.createCell(8).setCellValue(prod.getLength());
        	row.createCell(12).setCellValue(prod.getNumPlaces());
        	row.createCell(15).setCellValue(prod.getisIsOpen());
        }
        
        for (Mattress prod : Mprod) {
        	Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(prod.getName());
            row.createCell(1).setCellValue(prod.getID());
            row.createCell(2).setCellValue(prod.getProductProvider());
            row.createCell(3).setCellValue(prod.getCostPrice());
            row.createCell(4).setCellValue(prod.getSellingprice());
            row.createCell(5).setCellValue(prod.getColor());
            row.createCell(6).setCellValue(prod.getQuantity());
        	row.createCell(7).setCellValue(prod.getHeight());
        	row.createCell(8).setCellValue(prod.getLength());
        	row.createCell(16).setCellValue(prod.getOrthopedic());
        }
        
        for (Sofa prod : Sprod) {
        	Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(prod.getName());
            row.createCell(1).setCellValue(prod.getID());
            row.createCell(2).setCellValue(prod.getProductProvider());
            row.createCell(3).setCellValue(prod.getCostPrice());
            row.createCell(4).setCellValue(prod.getSellingprice());
            row.createCell(5).setCellValue(prod.getColor());
            row.createCell(6).setCellValue(prod.getQuantity());
        	row.createCell(7).setCellValue(prod.getHeight());
        	row.createCell(8).setCellValue(prod.getLength());
        	row.createCell(17).setCellValue(prod.getisOpens());
        }
        
        for (int i = 0; i < columns.length; i++) {
          sheet.autoSizeColumn(i);
        }

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream("products.xlsx");
        workbook.write(fileOut);
        
        fileOut.close();
        workbook.close();
	}
	
	public static void DeleteExel() throws IOException{
		/*int rowNum = 1;
	    Workbook workbook = new XSSFWorkbook();
	    Sheet sheet = workbook.createSheet("Products");
	
	    //Row headerRow = sheet.createRow(0);
        
        //for (Product product : products) {
            Row row = sheet.createRow(rowNum);
            row.removeCell(null);
  
            
        //}

        //for (int i = 0; i < columns.length; i++) {
         // sheet.autoSizeColumn(i);
        //}

        // Write the output to a file
        
        fileOut.close();
        workbook.close();*/
		int rownum = 1;
		File exelFile = new File("products.xlsx");
		FileInputStream fis = new FileInputStream(exelFile);
		//Create XSSF workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		//First sheet
		XSSFSheet sheet = workbook.getSheetAt(0);
		//Iterator on rows
		//Iterator<Row> rowIt = sheet.iterator();
		
		Row row = sheet.getRow(rownum);
		
		for (int i = 0; i < columns.length; i++) {
            //Cell cell = row.createCell(i);
			row.removeCell(null);
        }

	}
	
	public static Connection ReadEcel() throws IOException{
		File exelFile = new File("products.xlsx");
		FileInputStream fis = new FileInputStream(exelFile);
		//Create XSSF workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		//First sheet
		XSSFSheet sheet = workbook.getSheetAt(0);
		//Iterator on rows
		Iterator<Row> rowIt = sheet.iterator();
		
		while(rowIt.hasNext()) {
			Row row = rowIt.next();
			//Iterator on cell
			Iterator<Cell> cellIterator = row.cellIterator();
			
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				System.out.print(cell.toString() + " ");
			}
			System.out.println();
		}
        fis.close();
        workbook.close();
        return null;
	}
	
}
