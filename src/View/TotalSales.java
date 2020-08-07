package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TotalSales extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TotalSales frame = new TotalSales();
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
	public TotalSales() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 150, 1100, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u05D3\u05D5\u05D7 \u05DE\u05DB\u05D9\u05E8\u05D5\u05EA");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(466, 31, 107, 24);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("\u05D7\u05D6\u05D5\u05E8");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home();
				Home.main(null);
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton.setBounds(962, 11, 89, 23);
		contentPane.add(btnNewButton);

		JButton Money = new JButton("\u05D3\u05D5\u05D7 \u05DB\u05E1\u05E4\u05D9");
		Money.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel model = (DefaultTableModel) table.getModel();
				DefaultTableModel model_1 = (DefaultTableModel) table_1.getModel();

				File exelFile = new File("sales.xlsx");
				FileInputStream fis = null;
				try {
					fis = new FileInputStream(exelFile);
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				// Create XSSF workbook
				XSSFWorkbook workbook = null;
				try {
					workbook = new XSSFWorkbook(fis);
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				// First sheet
				XSSFSheet sheet = workbook.getSheetAt(0);
				// Iterator on rows
				Iterator<Row> rowIt = sheet.iterator();

				double data1 = 0, data2 = 0, data3 = 0, data4 = 0, data5 = 0, data6 = 0, data7 = 0, data8 = 0,
						data9 = 0, data10 = 0, data11 = 0, data12 = 0;
				for (int i = 0; i < model.getRowCount(); i++) {
					// double data = sheet.getRow(i+1).getCell(5).getNumericCellValue();
					int month = (int) sheet.getRow(i + 1).getCell(4).getNumericCellValue();

					// Sum money to each month
					switch (month) {
					case 1:
						data1 += sheet.getRow(i + 1).getCell(5).getNumericCellValue();
					}
					switch (month) {
					case 2:
						data2 += sheet.getRow(i + 1).getCell(5).getNumericCellValue();
					}
					switch (month) {
					case 3:
						data3 += sheet.getRow(i + 1).getCell(5).getNumericCellValue();
					}
					switch (month) {
					case 4:
						data4 += sheet.getRow(i + 1).getCell(5).getNumericCellValue();
					}
					switch (month) {
					case 5:
						data5 += sheet.getRow(i + 1).getCell(5).getNumericCellValue();
					}
					switch (month) {
					case 6:
						data6 += sheet.getRow(i + 1).getCell(5).getNumericCellValue();
					}
					switch (month) {
					case 7:
						data7 += sheet.getRow(i + 1).getCell(5).getNumericCellValue();
					}
					switch (month) {
					case 8:
						data8 += sheet.getRow(i + 1).getCell(5).getNumericCellValue();
					}
					switch (month) {
					case 9:
						data9 += sheet.getRow(i + 1).getCell(5).getNumericCellValue();
					}
					switch (month) {
					case 10:
						data10 += sheet.getRow(i + 1).getCell(5).getNumericCellValue();
					}
					switch (month) {
					case 11:
						data11 += sheet.getRow(i + 1).getCell(5).getNumericCellValue();
					}
					switch (month) {
					case 12:
						data12 += sheet.getRow(i + 1).getCell(5).getNumericCellValue();
					}

				}
				// Insert Money to table
				model_1.setValueAt(1, 0, 1);
				model_1.setValueAt(data1, 0, 0);
				model_1.setValueAt(2, 1, 1);
				model_1.setValueAt(data2, 1, 0);
				model_1.setValueAt(3, 2, 1);
				model_1.setValueAt(data3, 2, 0);
				model_1.setValueAt(4, 3, 1);
				model_1.setValueAt(data4, 3, 0);
				model_1.setValueAt(5, 4, 1);
				model_1.setValueAt(data5, 4, 0);
				model_1.setValueAt(6, 5, 1);
				model_1.setValueAt(data6, 5, 0);
				model_1.setValueAt(7, 6, 1);
				model_1.setValueAt(data7, 6, 0);
				model_1.setValueAt(8, 7, 1);
				model_1.setValueAt(data8, 7, 0);
				model_1.setValueAt(9, 8, 1);
				model_1.setValueAt(data9, 8, 0);
				model_1.setValueAt(10, 9, 1);
				model_1.setValueAt(data10, 9, 0);
				model_1.setValueAt(11, 10, 1);
				model_1.setValueAt(data11, 10, 0);
				model_1.setValueAt(12, 11, 1);
				model_1.setValueAt(data12, 11, 0);

				try {
					fis.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					workbook.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		Money.setFont(new Font("Arial", Font.BOLD, 15));
		Money.setBounds(815, 281, 89, 23);
		contentPane.add(Money);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(271, 66, 533, 148);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "\u05DE\u05D7\u05D9\u05E8", "\u05D7\u05D5\u05D3\u05E9", "\u05DB\u05EA\u05D5\u05D1\u05EA",
						"\u05DE\u05E7''\u05D8", "\u05E9\u05DD \u05E8\u05D4\u05D9\u05D8",
						"\u05E9\u05DD \u05DC\u05E7\u05D5\u05D7" }) {
			Class[] columnTypes = new Class[] { Short.class, Object.class, String.class, Integer.class, String.class,
					String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);

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
		Load.setBounds(484, 225, 89, 23);
		contentPane.add(Load);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(365, 259, 345, 141);
		contentPane.add(scrollPane_1);

		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
				new Object[][] { { null, null }, { null, null }, { null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null }, { null, null }, { null, null }, { null, null },
						{ null, null }, },
				new String[] { "\u05E8\u05D5\u05D5\u05D7 \u05D7\u05D5\u05D3\u05E9\u05D9",
						"\u05D7\u05D5\u05D3\u05E9" }) {
			Class[] columnTypes = new Class[] { Double.class, Integer.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_1.setViewportView(table_1);
		
		JButton btnNewButton_1 = new JButton("\u05D4\u05D3\u05E4\u05E1\u05D4");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					table.print();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "נסה שוב !", "הדפסה  נכשלה", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton_1.setBounds(815, 323, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
