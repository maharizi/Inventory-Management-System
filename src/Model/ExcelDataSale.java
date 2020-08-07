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
	private static String[] columns = { "�� ���� ", "�� ����", "��''�", "�����", "����", "����" };
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
		Sprod.add(new Sale("��������", "����� ����", 1, "���� 9, �����", 1, 2000));
		Sprod.add(new Sale("����", "����", 22, "���� 9, �����", 1, 3000));
		Sprod.add(new Sale("����", "����", 45, "���� 9, �����", 12, 7000));
		Sprod.add(new Sale("�������", "���� ����", 132, "�������� 9, �� ��", 12, 10000));
		Sprod.add(new Sale("����", "����� ����", 1, "����6, �����", 8, 1000));
		Sprod.add(new Sale("���� ����", "����", 232, "����30, �����", 7, 2000));
		Sprod.add(new Sale("���� ������", "���", 445, "���� 22, �����", 2, 4000));
		Sprod.add(new Sale("���� ������", "���� ����", 1352, "�������� 78, �� ��", 7, 10000));
		Sprod.add(new Sale("��� ����", "����� ����", 21, "���� 9, �����", 1, 2000));
		Sprod.add(new Sale("���� ����", "����", 202, "���� 9, �����", 1, 3000));
		Sprod.add(new Sale("���� ���", "����", 495, "���� 9, �����", 12, 7000));
		Sprod.add(new Sale("�������", "���� ����", 1382, "�������� 9, �� ��", 12, 10000));

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
