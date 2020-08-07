package View;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.TableColumnModelListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.TableView;
import javax.swing.text.TableView.TableCell;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Table;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Controller.DiningTable;
import Controller.Sale;
import Model.ExelDataProduct;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes.Name;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.event.AncestorListener;
import javax.swing.JSplitPane;
import javax.swing.JLayeredPane;

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

public class Sales extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField NameC;
	private JTextField Id;
	private JTextField Address;
	private JTextField Month;
	private JTextField Price;
	private JTextField textField_5;
	
	private static List<Sale> Sprod = new ArrayList<Sale>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sales frame = new Sales();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Sales() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 150, 1100, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 89, 1064, 192);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "\u05DE\u05D7\u05D9\u05E8", "\u05D7\u05D5\u05D3\u05E9", "\u05DB\u05EA\u05D5\u05D1\u05EA",
						"\u05DE\u05E7''\u05D8", "\u05E9\u05DD \u05E8\u05D4\u05D9\u05D8",
						"\u05E9\u05DD \u05DC\u05E7\u05D5\u05D7" }) {
			Class[] columnTypes = new Class[] { Integer.class, Integer.class, String.class, Integer.class, String.class,
					String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);

		JButton btnNewButton = new JButton("\u05D7\u05D6\u05D5\u05E8");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home();
				Home.main(null);
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton.setBounds(985, 11, 89, 23);
		contentPane.add(btnNewButton);

		JComboBox NameR = new JComboBox();
		NameR.setModel(new DefaultComboBoxModel(new String[] { "\u05D1\u05D7\u05D9\u05E8\u05D4",
				"\u05E9\u05D5\u05DC\u05D7\u05DF \u05D0\u05D5\u05DB\u05DC",
				"\u05E9\u05D5\u05DC\u05D7\u05DF \u05DE\u05D7\u05E9\u05D1", "\u05E1\u05E4\u05D4",
				"\u05DE\u05D9\u05D8\u05D4", "\u05D0\u05E8\u05D5\u05DF",
				"\u05DB\u05D9\u05E1\u05D0 \u05DE\u05D7\u05E9\u05D1",
				"\u05DB\u05D9\u05E1\u05D0 \u05D0\u05D5\u05DB\u05DC", "\u05DE\u05D6\u05E8\u05D5\u05DF" }));
		NameR.setBounds(888, 334, 86, 20);
		contentPane.add(NameR);

		JButton Reset = new JButton("\u05D0\u05D9\u05E4\u05D5\u05E1");
		Reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				NameC.setText("");
				NameR.setSelectedItem("בחירה");
				Id.setText("");
				Address.setText("");
				Month.setText("");
				Price.setText("");
			}
		});
		Reset.setFont(new Font("Arial", Font.BOLD, 15));
		Reset.setBounds(613, 377, 119, 23);
		contentPane.add(Reset);

		JButton Change = new JButton("\u05E9\u05D9\u05E0\u05D5\u05D9");
		Change.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				if (table.getSelectedRow() == -1)
					if (table.getRowCount() == 0)
						JOptionPane.showMessageDialog(null, "לא קיימים נתונים לעדכון !", "עדכון  נכשל",
								JOptionPane.ERROR_MESSAGE);
					else
						JOptionPane.showMessageDialog(null, "לחץ על שורה לעדכון !");
				else {
					JOptionPane.showMessageDialog(null, "מבצע עדכון, נא לבצע מחיקה ! ");
					try {
						model.addRow(new Object[] { Integer.parseInt(Price.getText()), Integer.parseInt(Month.getText()),
								Address.getText(), Integer.parseInt(Id.getText()), NameR.getSelectedItem(),
								NameC.getText() });
						JOptionPane.showMessageDialog(null, "הוספת נתונים הצליחה !");

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null,
								"הוספת מכירה, שדות: מק''ט, חודש ומחיר הם חובה. !" + "\n" + "ולפי הסוג !",
								"הוספה נכשלה", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		Change.setFont(new Font("Arial", Font.BOLD, 15));
		Change.setBounds(79, 349, 138, 23);
		contentPane.add(Change);

		JButton Load = new JButton("\u05D8\u05E2\u05D9\u05E0\u05D4");
		Load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				File excelfile;
				FileInputStream excelfis = null;
				BufferedInputStream excelbis = null;
				XSSFWorkbook exceljtableimport = null;
				String defaultCurrentDirectoryPath = "sales";
				JFileChooser excelFileChooser = new JFileChooser(defaultCurrentDirectoryPath);
				FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL Files", "xls", "xlsx", "xlsn");
				excelFileChooser.setFileFilter(fnef);
				excelFileChooser.setDialogTitle("Select sales excel  File");
				int excelChooser = excelFileChooser.showOpenDialog(null);
				if (excelChooser == JFileChooser.APPROVE_OPTION)
					try {
						excelfile = excelFileChooser.getSelectedFile();
						excelfis = new FileInputStream(excelfile);
						excelbis = new BufferedInputStream(excelfis);
						exceljtableimport = new XSSFWorkbook(excelbis);
						XSSFSheet excelsheet = exceljtableimport.getSheetAt(0);
						DefaultTableModel model = (DefaultTableModel) table.getModel();

						for (int row = 1; row <= excelsheet.getLastRowNum(); row++) {
							XSSFRow excelRow = excelsheet.getRow(row);

							XSSFCell excelNameC = excelRow.getCell(5);
							XSSFCell excelNameR = excelRow.getCell(4);
							XSSFCell excelId = excelRow.getCell(3);
							XSSFCell excelAddress = excelRow.getCell(2);
							XSSFCell excelMonth = excelRow.getCell(1);
							XSSFCell excelPrice = excelRow.getCell(0);

							model.addRow(new Object[] { excelNameC, excelNameR, excelId, excelAddress, excelMonth,
									excelPrice });
						}
						JOptionPane.showMessageDialog(null, "הבאת נתונים מהאקסל הצליחה !");
					} catch (FileNotFoundException ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					} catch (IOException ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					} finally {
						try {
							if (excelfis != null)
								excelfis.close();
							if (excelbis != null)
								excelfis.close();
							if (exceljtableimport != null)
								exceljtableimport.close();
						} catch (IOException iOException) {
							JOptionPane.showMessageDialog(null, iOException.getMessage());
						}
					}
			}
		});
		Load.setFont(new Font("Arial", Font.BOLD, 15));
		Load.setBounds(79, 319, 138, 23);
		contentPane.add(Load);

		JButton Delete = new JButton("\u05DE\u05D7\u05D9\u05E7\u05D4");
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				if (table.getSelectedRow() == -1)
					if (table.getRowCount() == 0)
						JOptionPane.showMessageDialog(null, "לא קיימים נתונים למחיקה !", "מחיקה  נכשלה",
								JOptionPane.ERROR_MESSAGE);
					else
						JOptionPane.showMessageDialog(null, "לחץ על שורה למחיקה !");
				else {
					JOptionPane.showMessageDialog(null, "מבצע מחיקה ! ");
					model.removeRow(table.getSelectedRow());
				}
			}
		});
		Delete.setFont(new Font("Arial", Font.BOLD, 15));
		Delete.setBounds(260, 349, 141, 23);
		contentPane.add(Delete);

		JButton Add = new JButton("\u05D4\u05D5\u05E1\u05E4\u05D4");
		Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel model = (DefaultTableModel) table.getModel();
				try {
					model.addRow(new Object[] { Integer.parseInt(Price.getText()), Integer.parseInt(Month.getText()),
							Address.getText(), Integer.parseInt(Id.getText()), NameR.getSelectedItem(),
							NameC.getText() });
					JOptionPane.showMessageDialog(null, "הוספת נתונים הצליחה !");

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,
							"הוספת מכירה, שדות: מק''ט, חודש ומחיר הם חובה. !" + "\n" + "ולפי הסוג !",
							"הוספה נכשלה", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		Add.setFont(new Font("Arial", Font.BOLD, 15));
		Add.setBounds(783, 377, 119, 23);
		contentPane.add(Add);

		JButton Save = new JButton("\u05E9\u05DE\u05D5\u05E8");
		Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				/*int rowNum = 1;
				Sprod.add(new Sale("ספיידרמן", "שולחן אוכל", 1, "הנפח 9, חולון", 1, 2000));
				Sprod.add(new Sale("מרקו", "מיטה", 1, "הנפח 9, חולון", 1, 3000));
				Sprod.add(new Sale("מרקו", "מיטה", 1, "הנפח 9, חולון", 12, 7000));

				Workbook workbook = new XSSFWorkbook();
				Sheet sheet = workbook.createSheet("sales");

				Font headerFont = workbook.createFont();
				headerFont.setBold(true);
				headerFont.setFontHeightInPoints((short) 14);
				headerFont.setColor(IndexedColors.RED.getIndex());
				CellStyle headerCellStyle = workbook.createCellStyle();
				headerCellStyle.setFont(headerFont);
				
				Row headerRow = sheet.createRow(0);

				for (Sale prod : Sprod) {
					Row row = sheet.createRow(rowNum++);
					row.createCell(0).setCellValue(prod.getName());
					row.createCell(1).setCellValue(prod.getProduct());
					row.createCell(2).setCellValue(prod.getId());
					row.createCell(3).setCellValue(prod.getAddress());
					row.createCell(4).setCellValue(prod.getMonth());
					row.createCell(5).setCellValue(prod.getPrice());
				}
				
				 for (int i = 0; i < 6; i++) {
			          sheet.autoSizeColumn(i);
				 }

				// Write the output to a file
				FileOutputStream fileOut = null;
				try {
					fileOut = new FileOutputStream("sales.xlsx");
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					workbook.write(fileOut);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				try {
					fileOut.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					workbook.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
				
				
				
				
				
				
				/*List<Sale> Sprod = new ArrayList<Sale>();
				File excelfile;
				FileInputStream excelfis = null;
				BufferedInputStream excelbis = null;
				String defaultCurrentDirectoryPath = "sales";
				JFileChooser excelFileChooser = new JFileChooser(defaultCurrentDirectoryPath);
				FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL Files", "xls", "xlsx", "xlsn");
				excelFileChooser.setFileFilter(fnef);
				excelFileChooser.setDialogTitle("Select sales excel  File");
				int excelChooser = excelFileChooser.showOpenDialog(null);
				if (excelChooser == JFileChooser.APPROVE_OPTION)
					try {
						excelfile = excelFileChooser.getSelectedFile();
						excelfis = new FileInputStream(excelfile);
						excelbis = new BufferedInputStream(excelfis);
						exceljtableimport = new XSSFWorkbook(excelbis);
						XSSFSheet sheet1 = exceljtableimport.getSheetAt(0);
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						
						int excelrow = 0; // sheet.getLastRowNum() ;
						int rowNum1 = 0;
						int colNum = 5;

						//Insert to list Sale
						for (int i = 1; i <= sheet1.getLastRowNum(); i++) {
							XSSFRow excelRow = sheet1.getRow(i);
							Sprod.add(new Sale((String) model.getValueAt(rowNum1, colNum),
									(String) model.getValueAt(rowNum1, (colNum - 1)),
									(int) model.getValueAt(rowNum1, (colNum - 2)),
									(String) model.getValueAt(rowNum1, (colNum - 3)),
									(int) model.getValueAt(rowNum1, (colNum - 4)),
									(int) model.getValueAt(rowNum1, (colNum - 5))));
							
                            //Insert to Sale excel
							for (Sale prod : Sprod) {
								Row row = sheet1.createRow(excelrow++);
								row.createCell(0).setCellValue(prod.getName());
								row.createCell(1).setCellValue(prod.getProduct());
								row.createCell(2).setCellValue(prod.getId());
								row.createCell(3).setCellValue(prod.getAddress());
								row.createCell(4).setCellValue(prod.getMonth());
								row.createCell(5).setCellValue(prod.getPrice());
							}
						}
						JOptionPane.showMessageDialog(null, "שמירת נתונים באקסל הצליחה !");
					} catch (FileNotFoundException ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					} catch (IOException ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					} finally {
						try {
							if (excelfis != null)
								excelfis.close();
							if (excelbis != null)
								excelfis.close();
							if (exceljtableimport != null)
								exceljtableimport.close();
						} catch (IOException iOException) {
							JOptionPane.showMessageDialog(null, iOException.getMessage());
						}
					}*/
				
				/*File exelFile = new File("sales.xlsx");
				FileInputStream fis = null;
				try {
					fis = new FileInputStream(exelFile);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				XSSFWorkbook workbook = null;
				try {
					workbook = new XSSFWorkbook(fis);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				XSSFSheet sheet = workbook.getSheetAt(0);
				Iterator<Row> rowIt = sheet.iterator();*/
				
				
			}
		});
		Save.setFont(new Font("Arial", Font.BOLD, 15));
		Save.setBounds(260, 319, 141, 23);
		contentPane.add(Save);

		JLabel lblNewLabel = new JLabel("\u05D4\u05D5\u05E1\u05E4\u05EA \u05DE\u05DB\u05D9\u05E8\u05D4");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(480, 45, 110, 23);
		contentPane.add(lblNewLabel);

		NameC = new JTextField();
		NameC.setBounds(888, 294, 86, 20);
		contentPane.add(NameC);
		NameC.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("\u05E9\u05DD \u05DC\u05E7\u05D5\u05D7");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBounds(990, 296, 58, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\u05E9\u05DD \u05E8\u05D4\u05D9\u05D8");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2.setBounds(990, 336, 58, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\u05DE\u05E7''\u05D8");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_3.setBounds(808, 296, 46, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("\u05DB\u05EA\u05D5\u05D1\u05EA");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_4.setBounds(808, 335, 46, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("\u05D7\u05D5\u05D3\u05E9");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_5.setBounds(652, 296, 46, 14);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("\u05DE\u05D7\u05D9\u05E8");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_6.setBounds(652, 335, 46, 14);
		contentPane.add(lblNewLabel_6);

		Id = new JTextField();
		Id.setBounds(724, 294, 86, 20);
		contentPane.add(Id);
		Id.setColumns(10);

		Address = new JTextField();
		Address.setBounds(724, 333, 86, 20);
		contentPane.add(Address);
		Address.setColumns(10);

		Month = new JTextField();
		Month.setBounds(569, 294, 86, 20);
		contentPane.add(Month);
		Month.setColumns(10);

		Price = new JTextField();
		Price.setBounds(569, 333, 86, 20);
		contentPane.add(Price);
		Price.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(474, 292, 5, 108);
		contentPane.add(textField_5);
		textField_5.setColumns(10);

	}
}
