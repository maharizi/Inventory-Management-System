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
import Controller.Sale;
import Controller.Sofa;

public class ExcelDataSale {

	Connection conn = null;
	private static String[] columns = { "שם לקוח ", "שם רהיט", "מק''ט", "כתובת", "חודש", "מחיר" };
	private static List<Sale> Sprod = new ArrayList<Sale>();

	public static void main(String[] args) throws IOException, InvalidFormatException {

		// Experience of the method
	    ReadEcel();

		// Experience of the method
		WriteExel();

		// Experience of the method
		// DeleteExel();
	}

	public static void WriteExel() throws IOException {
		int rowNum = 1;
		Sprod.add(new Sale("ספיידרמן", "שולחן אוכל", 1, "הנפח 9, חולון", 1, 2000));
		Sprod.add(new Sale("מרקו", "מיטה", 22, "הנפח 9, חולון", 1, 3000));
		Sprod.add(new Sale("מרקו", "ארון", 45, "הנפח 9, חולון", 12, 7000));
		Sprod.add(new Sale("בובספוג", "כיסא מחשב", 132, "ההסתדרות 9, בת ים", 12, 10000));
		Sprod.add(new Sale("ביבי", "שולחן אוכל", 1, "הנפח6, חולון", 8, 1000));
		Sprod.add(new Sale("אייל גולן", "מיטה", 232, "הנפח30, חולון", 7, 2000));
		Sprod.add(new Sale("רבקה מיכאלי", "ספה", 445, "הנפח 22, חולון", 2, 4000));
		Sprod.add(new Sale("גילה אלמגור", "כיסא מחשב", 1352, "ההסתדרות 78, בת ים", 7, 10000));
		Sprod.add(new Sale("שחר חסון", "שולחן מחשב", 21, "שנקר 9, חולון", 1, 2000));
		Sprod.add(new Sale("ציפי שביט", "מיטה", 202, "הנפח 9, חולון", 1, 3000));
		Sprod.add(new Sale("עומר אדם", "ארון", 495, "הנפח 9, חולון", 12, 7000));
		Sprod.add(new Sale("בובספוג", "כיסא מחשב", 1382, "ההסתדרות 9, בת ים", 12, 10000));

		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("sales");

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

		for (Sale prod : Sprod) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(prod.getName());
			row.createCell(1).setCellValue(prod.getProduct());
			row.createCell(2).setCellValue(prod.getId());
			row.createCell(3).setCellValue(prod.getAddress());
			row.createCell(4).setCellValue(prod.getMonth());
			row.createCell(5).setCellValue(prod.getPrice());
		}
		
		 for (int i = 0; i < columns.length; i++) {
	          sheet.autoSizeColumn(i);
		 }

		// Write the output to a file
		FileOutputStream fileOut = new FileOutputStream("sales.xlsx");
		workbook.write(fileOut);

		fileOut.close();
		workbook.close();

	}

	public static void DeleteExel() throws IOException {
		/*
		 * int rowNum = 1; Workbook workbook = new XSSFWorkbook(); Sheet sheet =
		 * workbook.createSheet("Products");
		 * 
		 * //Row headerRow = sheet.createRow(0);
		 * 
		 * //for (Product product : products) { Row row = sheet.createRow(rowNum);
		 * row.removeCell(null);
		 * 
		 * 
		 * //}
		 * 
		 * //for (int i = 0; i < columns.length; i++) { // sheet.autoSizeColumn(i); //}
		 * 
		 * // Write the output to a file
		 * 
		 * fileOut.close(); workbook.close();
		 */
		int rownum = 1;
		File exelFile = new File("sales.xlsx");
		FileInputStream fis = new FileInputStream(exelFile);
		// Create XSSF workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		// First sheet
		XSSFSheet sheet = workbook.getSheetAt(0);
		// Iterator on rows
		// Iterator<Row> rowIt = sheet.iterator();

		Row row = sheet.getRow(rownum);

		for (int i = 0; i < columns.length; i++) {
			// Cell cell = row.createCell(i);
			row.removeCell(null);
		}

	}

	public static Connection ReadEcel() throws IOException {
		File exelFile = new File("sales.xlsx");
		FileInputStream fis = new FileInputStream(exelFile);
		// Create XSSF workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		// First sheet
		XSSFSheet sheet = workbook.getSheetAt(0);
		// Iterator on rows
		Iterator<Row> rowIt = sheet.iterator();

		while (rowIt.hasNext()) {
			Row row = rowIt.next();
			// Iterator on cell
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
