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

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Table;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Controller.DiningTable;
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

public class Add extends JFrame {

	private JPanel contentPane;
	private JTextField ID;
	private JTextField Provider;
	private JTextField Buy;
	private JTextField Sale;
	private JTextField Color;
	private JTextField Amount;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add frame = new Add();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection = null;
	private JTextField NumWeels;
	private JTextField Length;
	private JTextField Hight;
	private JTextField NumCites;
	private JTextField Fabic;
	private JTextField Material;

	private JTextField Sliding;
	private JTextField Drawer;
	private JTextField TOpen;
	private JTextField Ortoped;
	private JTextField SOpen;
	private JButton Save;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public Add() {

		try {
			connection = ExelDataProduct.ReadEcel();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 150, 1100, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u05D4\u05D5\u05E1\u05E4\u05EA \u05DE\u05D5\u05E6\u05E8");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(442, 25, 140, 24);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u05E9\u05DD \u05E8\u05D4\u05D9\u05D8");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(996, 238, 78, 24);
		contentPane.add(lblNewLabel_1);

		JComboBox Name = new JComboBox();
		Name.setModel(new DefaultComboBoxModel(new String[] { "\u05D1\u05D7\u05D9\u05E8\u05D4",
				"\u05E9\u05D5\u05DC\u05D7\u05DF \u05D0\u05D5\u05DB\u05DC",
				"\u05E9\u05D5\u05DC\u05D7\u05DF \u05DE\u05D7\u05E9\u05D1", "\u05E1\u05E4\u05D4",
				"\u05DE\u05D9\u05D8\u05D4", "\u05D0\u05E8\u05D5\u05DF",
				"\u05DB\u05D9\u05E1\u05D0 \u05DE\u05D7\u05E9\u05D1",
				"\u05DB\u05D9\u05E1\u05D0 \u05D0\u05D5\u05DB\u05DC", "\u05DE\u05D6\u05E8\u05D5\u05DF" }));
		Name.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Name.setBounds(920, 241, 86, 20);
		contentPane.add(Name);

		JButton btnNewButton = new JButton("\u05D7\u05D6\u05D5\u05E8");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Home home = new Home();
				Home.main(null);
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton.setBounds(962, 11, 89, 23);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("\u05DE\u05E7''\u05D8");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2.setBounds(1028, 273, 46, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\u05E1\u05E4\u05E7");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_3.setBounds(1028, 298, 46, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("\u05E1\u05DB\u05D5\u05DD \u05E7\u05E0\u05D9\u05D9\u05D4");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(1005, 323, 69, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("\u05E1\u05DB\u05D5\u05DD \u05DE\u05DB\u05D9\u05E8\u05D4");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_5.setBounds(1005, 350, 69, 14);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("\u05E6\u05D1\u05E2");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_6.setBounds(858, 273, 46, 14);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("\u05DB\u05DE\u05D5\u05EA");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_7.setBounds(852, 298, 52, 14);
		contentPane.add(lblNewLabel_7);

		ID = new JTextField();
		ID.setBounds(920, 271, 86, 20);
		contentPane.add(ID);
		ID.setColumns(10);

		Provider = new JTextField();
		Provider.setBounds(920, 296, 86, 20);
		contentPane.add(Provider);
		Provider.setColumns(10);

		Buy = new JTextField();
		Buy.setBounds(920, 321, 86, 20);
		contentPane.add(Buy);
		Buy.setColumns(10);

		Sale = new JTextField();
		Sale.setBounds(920, 348, 86, 20);
		contentPane.add(Sale);
		Sale.setColumns(10);

		Color = new JTextField();
		Color.setBounds(762, 271, 86, 20);
		contentPane.add(Color);
		Color.setColumns(10);

		Amount = new JTextField();
		Amount.setBounds(762, 296, 86, 20);
		contentPane.add(Amount);
		Amount.setColumns(10);

		JButton Add = new JButton("\u05D4\u05D5\u05E1\u05E4\u05D4");
		Add.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table_1.getModel();
				try {
					String name = (String) Name.getSelectedItem();
					switch (name) {
					case "שולחן אוכל":
						model.addRow(new Object[] { null, null, TOpen.getText(), null, null,
								Integer.parseInt(NumCites.getText()), null, null, null,
								Double.parseDouble(Length.getText()), Double.parseDouble(Hight.getText()),
								Integer.parseInt(Amount.getText()), Color.getText(), Double.parseDouble(Sale.getText()),
								Double.parseDouble(Buy.getText()), Provider.getText(), Integer.parseInt(ID.getText()),
								Name.getSelectedItem() });
						JOptionPane.showMessageDialog(null, "הוספת נתונים הצליחה !");
					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,
							"שולחן אוכל, שדות: מק''ט, סכום קניה, סכום  מכירה, כמות, גובה, אורך ומקומות ישיבה הם חובה. !"
									+ "\n" + "ולפי הסוג !",
							"הוספה נכשלה", JOptionPane.ERROR_MESSAGE);
				}

				try {
					String name = (String) Name.getSelectedItem();
					switch (name) {
					case "שולחן מחשב":
						model.addRow(new Object[] { null, null, null, Drawer.getText(), null, null, null,
								Material.getText(), null, Double.parseDouble(Length.getText()),
								Double.parseDouble(Hight.getText()), Integer.parseInt(Amount.getText()),
								Color.getText(), Double.parseDouble(Sale.getText()), Double.parseDouble(Buy.getText()),
								Provider.getText(), Integer.parseInt(ID.getText()), Name.getSelectedItem() });
						JOptionPane.showMessageDialog(null, "הוספת נתונים הצליחה !");
					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,
							"שולחן מחשב, שדות: מק''ט, סכום קניה, סכום  מכירה, כמות, גובה ואורך הם חובה !" + "\n"
									+ "ולפי הסוג !",
							"הוספה נכשלה", JOptionPane.ERROR_MESSAGE);
				}

				try {
					String name = (String) Name.getSelectedItem();
					switch (name) {
					case "ספה":
						model.addRow(new Object[] { SOpen.getText(), null, null, null, null, null, null, null, null,
								Double.parseDouble(Length.getText()), Double.parseDouble(Hight.getText()),
								Integer.parseInt(Amount.getText()), Color.getText(), Double.parseDouble(Sale.getText()),
								Double.parseDouble(Buy.getText()), Provider.getText(), Integer.parseInt(ID.getText()),
								Name.getSelectedItem() });
						JOptionPane.showMessageDialog(null, "הוספת נתונים הצליחה !");
					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,
							"ספה, שדות: מק''ט, סכום קניה, סכום  מכירה, כמות, גובה, ואורך הם חובה !" + "\n"
									+ "ולפי הסוג !",
							"הוספה נכשלה", JOptionPane.ERROR_MESSAGE);
				}

				try {
					String name = (String) Name.getSelectedItem();
					switch (name) {
					case "מיטה":
						model.addRow(new Object[] { null, null, null, null, null, null, null, null, null,
								Double.parseDouble(Length.getText()), Double.parseDouble(Hight.getText()),
								Integer.parseInt(Amount.getText()), Color.getText(), Double.parseDouble(Sale.getText()),
								Double.parseDouble(Buy.getText()), Provider.getText(), Integer.parseInt(ID.getText()),
								Name.getSelectedItem() });
						JOptionPane.showMessageDialog(null, "הוספת נתונים הצליחה !");
					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,
							"מיטה, שדות: מק''ט, סכום קניה, סכום  מכירה, כמות, גובה, ואורך הם חובה !" + "\n"
									+ "ולפי הסוג !",
							"הוספה נכשלה", JOptionPane.ERROR_MESSAGE);
				}

				try {
					String name = (String) Name.getSelectedItem();
					switch (name) {
					case "ארון":
						model.addRow(new Object[] { null, null, null, null, Sliding.getText(), null, null, null, null,
								Double.parseDouble(Length.getText()), Double.parseDouble(Hight.getText()),
								Integer.parseInt(Amount.getText()), Color.getText(), Double.parseDouble(Sale.getText()),
								Double.parseDouble(Buy.getText()), Provider.getText(), Integer.parseInt(ID.getText()),
								Name.getSelectedItem() });
						JOptionPane.showMessageDialog(null, "הוספת נתונים הצליחה !");
					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,
							"ארון, שדות: מק''ט, סכום קניה, סכום  מכירה, כמות, גובה, ואורך הם חובה !" + "\n"
									+ "ולפי הסוג !",
							"הוספה נכשלה", JOptionPane.ERROR_MESSAGE);
				}

				try {
					String name = (String) Name.getSelectedItem();
					switch (name) {
					case "כיסא מחשב":
						model.addRow(new Object[] { null, null, null, null, null, null, null, null,
								Integer.parseInt(NumWeels.getText()), Double.parseDouble(Length.getText()),
								Double.parseDouble(Hight.getText()), Integer.parseInt(Amount.getText()),
								Color.getText(), Double.parseDouble(Sale.getText()), Double.parseDouble(Buy.getText()),
								Provider.getText(), Integer.parseInt(ID.getText()), Name.getSelectedItem() });
						JOptionPane.showMessageDialog(null, "הוספת נתונים הצליחה !");
					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,
							"כיסא מחשב, שדות: מק''ט, סכום קניה, סכום  מכירה, כמות, גובה, ואורך הם חובה !" + "\n"
									+ "ולפי הסוג !",
							"הוספה נכשלה", JOptionPane.ERROR_MESSAGE);
				}

				try {
					String name = (String) Name.getSelectedItem();
					switch (name) {
					case "כיסא אוכל":
						model.addRow(new Object[] { null, null, null, null, null, null, Fabic.getText(), null, null,
								Double.parseDouble(Length.getText()), Double.parseDouble(Hight.getText()),
								Integer.parseInt(Amount.getText()), Color.getText(), Double.parseDouble(Sale.getText()),
								Double.parseDouble(Buy.getText()), Provider.getText(), Integer.parseInt(ID.getText()),
								Name.getSelectedItem() });
						JOptionPane.showMessageDialog(null, "הוספת נתונים הצליחה !");
					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,
							"כיסא אוכל, שדות: מק''ט, סכום קניה, סכום  מכירה, כמות, גובה, ואורך הם חובה !" + "\n"
									+ "ולפי הסוג !",
							"הוספה נכשלה", JOptionPane.ERROR_MESSAGE);
				}

				try {
					String name = (String) Name.getSelectedItem();
					switch (name) {
					case "מזרון":
						model.addRow(new Object[] { null, null, null, null, Sliding.getText(), null, null, null, null,
								Double.parseDouble(Length.getText()), Double.parseDouble(Hight.getText()),
								Integer.parseInt(Amount.getText()), Color.getText(), Double.parseDouble(Sale.getText()),
								Double.parseDouble(Buy.getText()), Provider.getText(), Integer.parseInt(ID.getText()),
								Name.getSelectedItem() });
						JOptionPane.showMessageDialog(null, "הוספת נתונים הצליחה !");
					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,
							"מזרון, שדות: מק''ט, סכום קניה, סכום  מכירה, כמות, גובה, ואורך הם חובה !" + "\n"
									+ "ולפי הסוג !",
							"הוספה נכשלה", JOptionPane.ERROR_MESSAGE);
				}
				String name = (String) Name.getSelectedItem();
				switch (name) {
				case "בחירה":
					JOptionPane.showMessageDialog(null, "יש לבחור שם רהיט !");
				}

			}
		});

		Add.setFont(new Font("Arial", Font.BOLD, 15));
		Add.setBounds(569, 377, 89, 23);
		contentPane.add(Add);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 58, 1074, 169);
		contentPane.add(scrollPane);

		table_1 = new JTable();
		table_1.setFont(new Font("Arial", Font.BOLD, 13));
		table_1.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
				"\u05E1\u05E4\u05D4 \u05E0\u05E4\u05EA\u05D7\u05EA", "\u05D0\u05D5\u05E8\u05D8\u05D5\u05E4\u05D3\u05D9",
				"\u05E9\u05D5\u05DC\u05D7\u05DF \u05E0\u05E4\u05EA\u05D7", "\u05DE\u05D2\u05D9\u05E8\u05D5\u05EA",
				"\u05D4\u05D6\u05D6\u05D4",
				"\u05DE\u05E1' \u05DE\u05E7\u05D5\u05DE\u05D5\u05EA \u05D9\u05E9\u05D9\u05D1\u05D4", "\u05D1\u05D3",
				"\u05D7\u05D5\u05DE\u05E8", "\u05DE\u05E1' \u05D2\u05DC\u05D2\u05DC\u05D9\u05DD",
				"\u05D0\u05D5\u05E8\u05DA", "\u05D2\u05D5\u05D1\u05D4", "\u05DB\u05DE\u05D5\u05EA",
				"\u05E6\u05D1\u05E2", "\u05DE\u05DB\u05D9\u05E8\u05D4", "\u05E7\u05E0\u05D9\u05D9\u05D4",
				"\u05E1\u05E4\u05E7", "\u05DE\u05E7''\u05D8", "\u05E9\u05DD" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, String.class,
					Integer.class, String.class, String.class, Integer.class, Object.class, Object.class, Integer.class,
					String.class, Object.class, Object.class, String.class, Integer.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table_1);

		JButton Load = new JButton("\u05D8\u05E2\u05D9\u05E0\u05D4");
		Load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				File excelfile;
				FileInputStream excelfis = null;
				BufferedInputStream excelbis = null;
				XSSFWorkbook exceljtableimport = null;
				String defaultCurrentDirectoryPath = "products";
				JFileChooser excelFileChooser = new JFileChooser(defaultCurrentDirectoryPath);
				FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL Files", "xls", "xlsx", "xlsn");
				excelFileChooser.setFileFilter(fnef);
				excelFileChooser.setDialogTitle("Select products excel File");
				int excelChooser = excelFileChooser.showOpenDialog(null);
				if (excelChooser == JFileChooser.APPROVE_OPTION)
					try {
						excelfile = excelFileChooser.getSelectedFile();
						excelfis = new FileInputStream(excelfile);
						excelbis = new BufferedInputStream(excelfis);
						exceljtableimport = new XSSFWorkbook(excelbis);
						XSSFSheet excelsheet = exceljtableimport.getSheetAt(0);
						DefaultTableModel model = (DefaultTableModel) table_1.getModel();

						for (int row = 1; row <= excelsheet.getLastRowNum(); row++) {
							XSSFRow excelRow = excelsheet.getRow(row);

							XSSFCell excelName = excelRow.getCell(17);
							XSSFCell excelID = excelRow.getCell(16);
							XSSFCell excelProductProvider = excelRow.getCell(15);
							XSSFCell excelBuy = excelRow.getCell(14);
							XSSFCell excelSale = excelRow.getCell(13);
							XSSFCell excelColor = excelRow.getCell(12);
							XSSFCell excelAmount = excelRow.getCell(11);
							XSSFCell excelHeight = excelRow.getCell(10);
							XSSFCell excelLength = excelRow.getCell(9);
							XSSFCell excelNumWheels = excelRow.getCell(8);
							XSSFCell excelMaterial = excelRow.getCell(7);
							XSSFCell excelFabric = excelRow.getCell(6);
							XSSFCell excelNumPlaces = excelRow.getCell(5);
							XSSFCell excelisSliding = excelRow.getCell(4);
							XSSFCell excelisDrawer = excelRow.getCell(3);
							XSSFCell excelisOpen = excelRow.getCell(2);
							XSSFCell excelOrthopedic = excelRow.getCell(1);
							XSSFCell excelisIsOpen = excelRow.getCell(0);

							model.addRow(new Object[] { excelName, excelID, excelProductProvider, excelBuy, excelSale,
									excelColor, excelAmount, excelHeight, excelLength, excelNumWheels, excelMaterial,
									excelFabric, excelNumPlaces, excelisSliding, excelisDrawer, excelisOpen,
									excelOrthopedic, excelisIsOpen });
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
		Load.setBounds(15, 294, 89, 23);
		contentPane.add(Load);

		JButton Reset = new JButton("\u05D0\u05D9\u05E4\u05D5\u05E1");
		Reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Name.setSelectedItem("בחירה");
				ID.setText("");
				Provider.setText("");
				Buy.setText("");
				Sale.setText("");
				Color.setText("");
				Amount.setText("");
				NumCites.setText("");
				Fabic.setText("");
				Material.setText("");
				NumWeels.setText("");
				Hight.setText("");
				Length.setText("");
				Sliding.setText("");
				Drawer.setText("");
				TOpen.setText("");
				Ortoped.setText("");
				SOpen.setText("");
			}
		});
		Reset.setFont(new Font("Arial", Font.BOLD, 15));
		Reset.setBounds(386, 377, 89, 23);
		contentPane.add(Reset);

		JButton Delete = new JButton("\u05DE\u05D7\u05D9\u05E7\u05D4");
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table_1.getModel();
				if (table_1.getSelectedRow() == -1)
					if (table_1.getRowCount() == 0)
						JOptionPane.showMessageDialog(null, "לא קיימים נתונים למחיקה !", "מחיקה  נכשלה",
								JOptionPane.ERROR_MESSAGE);
					else
						JOptionPane.showMessageDialog(null, "לחץ על שורה למחיקה !");
				else {
					JOptionPane.showMessageDialog(null, "מבצע מחיקה ! ");
					model.removeRow(table_1.getSelectedRow());
				}
			}
		});
		Delete.setFont(new Font("Arial", Font.BOLD, 15));
		Delete.setBounds(114, 346, 89, 23);
		contentPane.add(Delete);

		JButton Change = new JButton("\u05E9\u05D9\u05E0\u05D5\u05D9");
		Change.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table_1.getModel();
				if (table_1.getSelectedRow() == -1)
					if (table_1.getRowCount() == 0)
						JOptionPane.showMessageDialog(null, "לא קיימים נתונים לעדכון !", "עדכון  נכשל",
								JOptionPane.ERROR_MESSAGE);
					else
						JOptionPane.showMessageDialog(null, "לחץ על שורה לעדכון !");
				else {
					JOptionPane.showMessageDialog(null, "מבצע עדכון, נא לבצע מחיקה ! ");
					try {
						String name = (String) Name.getSelectedItem();
						switch (name) {
						case "שולחן אוכל":
							model.addRow(new Object[] { null, null, TOpen.getText(), null, null,
									Integer.parseInt(NumCites.getText()), null, null, null,
									Double.parseDouble(Length.getText()), Double.parseDouble(Hight.getText()),
									Integer.parseInt(Amount.getText()), Color.getText(), Double.parseDouble(Sale.getText()),
									Double.parseDouble(Buy.getText()), Provider.getText(), Integer.parseInt(ID.getText()),
									Name.getSelectedItem() });
							JOptionPane.showMessageDialog(null, "הוספת נתונים הצליחה !");
						}

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null,
								"שולחן אוכל, שדות: מק''ט, סכום קניה, סכום  מכירה, כמות, גובה, אורך ומקומות ישיבה הם חובה. !"
										+ "\n" + "ולפי הסוג !",
								"הוספה נכשלה", JOptionPane.ERROR_MESSAGE);
					}

					try {
						String name = (String) Name.getSelectedItem();
						switch (name) {
						case "שולחן מחשב":
							model.addRow(new Object[] { null, null, null, Drawer.getText(), null, null, null,
									Material.getText(), null, Double.parseDouble(Length.getText()),
									Double.parseDouble(Hight.getText()), Integer.parseInt(Amount.getText()),
									Color.getText(), Double.parseDouble(Sale.getText()), Double.parseDouble(Buy.getText()),
									Provider.getText(), Integer.parseInt(ID.getText()), Name.getSelectedItem() });
							JOptionPane.showMessageDialog(null, "הוספת נתונים הצליחה !");
						}

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null,
								"שולחן מחשב, שדות: מק''ט, סכום קניה, סכום  מכירה, כמות, גובה ואורך הם חובה !" + "\n"
										+ "ולפי הסוג !",
								"הוספה נכשלה", JOptionPane.ERROR_MESSAGE);
					}

					try {
						String name = (String) Name.getSelectedItem();
						switch (name) {
						case "ספה":
							model.addRow(new Object[] { SOpen.getText(), null, null, null, null, null, null, null, null,
									Double.parseDouble(Length.getText()), Double.parseDouble(Hight.getText()),
									Integer.parseInt(Amount.getText()), Color.getText(), Double.parseDouble(Sale.getText()),
									Double.parseDouble(Buy.getText()), Provider.getText(), Integer.parseInt(ID.getText()),
									Name.getSelectedItem() });
							JOptionPane.showMessageDialog(null, "הוספת נתונים הצליחה !");
						}

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null,
								"ספה, שדות: מק''ט, סכום קניה, סכום  מכירה, כמות, גובה, ואורך הם חובה !" + "\n"
										+ "ולפי הסוג !",
								"הוספה נכשלה", JOptionPane.ERROR_MESSAGE);
					}

					try {
						String name = (String) Name.getSelectedItem();
						switch (name) {
						case "מיטה":
							model.addRow(new Object[] { null, null, null, null, null, null, null, null, null,
									Double.parseDouble(Length.getText()), Double.parseDouble(Hight.getText()),
									Integer.parseInt(Amount.getText()), Color.getText(), Double.parseDouble(Sale.getText()),
									Double.parseDouble(Buy.getText()), Provider.getText(), Integer.parseInt(ID.getText()),
									Name.getSelectedItem() });
							JOptionPane.showMessageDialog(null, "הוספת נתונים הצליחה !");
						}

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null,
								"מיטה, שדות: מק''ט, סכום קניה, סכום  מכירה, כמות, גובה, ואורך הם חובה !" + "\n"
										+ "ולפי הסוג !",
								"הוספה נכשלה", JOptionPane.ERROR_MESSAGE);
					}

					try {
						String name = (String) Name.getSelectedItem();
						switch (name) {
						case "ארון":
							model.addRow(new Object[] { null, null, null, null, Sliding.getText(), null, null, null, null,
									Double.parseDouble(Length.getText()), Double.parseDouble(Hight.getText()),
									Integer.parseInt(Amount.getText()), Color.getText(), Double.parseDouble(Sale.getText()),
									Double.parseDouble(Buy.getText()), Provider.getText(), Integer.parseInt(ID.getText()),
									Name.getSelectedItem() });
							JOptionPane.showMessageDialog(null, "הוספת נתונים הצליחה !");
						}

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null,
								"ארון, שדות: מק''ט, סכום קניה, סכום  מכירה, כמות, גובה, ואורך הם חובה !" + "\n"
										+ "ולפי הסוג !",
								"הוספה נכשלה", JOptionPane.ERROR_MESSAGE);
					}

					try {
						String name = (String) Name.getSelectedItem();
						switch (name) {
						case "כיסא מחשב":
							model.addRow(new Object[] { null, null, null, null, null, null, null, null,
									Integer.parseInt(NumWeels.getText()), Double.parseDouble(Length.getText()),
									Double.parseDouble(Hight.getText()), Integer.parseInt(Amount.getText()),
									Color.getText(), Double.parseDouble(Sale.getText()), Double.parseDouble(Buy.getText()),
									Provider.getText(), Integer.parseInt(ID.getText()), Name.getSelectedItem() });
							JOptionPane.showMessageDialog(null, "הוספת נתונים הצליחה !");
						}

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null,
								"כיסא מחשב, שדות: מק''ט, סכום קניה, סכום  מכירה, כמות, גובה, ואורך הם חובה !" + "\n"
										+ "ולפי הסוג !",
								"הוספה נכשלה", JOptionPane.ERROR_MESSAGE);
					}

					try {
						String name = (String) Name.getSelectedItem();
						switch (name) {
						case "כיסא אוכל":
							model.addRow(new Object[] { null, null, null, null, null, null, Fabic.getText(), null, null,
									Double.parseDouble(Length.getText()), Double.parseDouble(Hight.getText()),
									Integer.parseInt(Amount.getText()), Color.getText(), Double.parseDouble(Sale.getText()),
									Double.parseDouble(Buy.getText()), Provider.getText(), Integer.parseInt(ID.getText()),
									Name.getSelectedItem() });
							JOptionPane.showMessageDialog(null, "הוספת נתונים הצליחה !");
						}

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null,
								"כיסא אוכל, שדות: מק''ט, סכום קניה, סכום  מכירה, כמות, גובה, ואורך הם חובה !" + "\n"
										+ "ולפי הסוג !",
								"הוספה נכשלה", JOptionPane.ERROR_MESSAGE);
					}

					try {
						String name = (String) Name.getSelectedItem();
						switch (name) {
						case "מזרון":
							model.addRow(new Object[] { null, null, null, null, Sliding.getText(), null, null, null, null,
									Double.parseDouble(Length.getText()), Double.parseDouble(Hight.getText()),
									Integer.parseInt(Amount.getText()), Color.getText(), Double.parseDouble(Sale.getText()),
									Double.parseDouble(Buy.getText()), Provider.getText(), Integer.parseInt(ID.getText()),
									Name.getSelectedItem() });
							JOptionPane.showMessageDialog(null, "הוספת נתונים הצליחה !");
						}

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null,
								"מזרון, שדות: מק''ט, סכום קניה, סכום  מכירה, כמות, גובה, ואורך הם חובה !" + "\n"
										+ "ולפי הסוג !",
								"הוספה נכשלה", JOptionPane.ERROR_MESSAGE);
					}
					String name = (String) Name.getSelectedItem();
					switch (name) {
					case "בחירה":
						JOptionPane.showMessageDialog(null, "יש לבחור שם רהיט !");
					}

				}
			}
		});
		Change.setFont(new Font("Arial", Font.BOLD, 15));
		Change.setBounds(15, 346, 89, 23);
		contentPane.add(Change);

		JLabel lblNewLabel_8 = new JLabel("\u05D2\u05D5\u05D1\u05D4");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_8.setBounds(858, 324, 46, 14);
		contentPane.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("\u05D0\u05D5\u05E8\u05DA");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_9.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_9.setBounds(858, 350, 46, 14);
		contentPane.add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("\u05DE\u05E1' \u05D2\u05DC\u05D2\u05DC\u05D9\u05DD");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_10.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_10.setBounds(685, 273, 67, 14);
		contentPane.add(lblNewLabel_10);

		NumWeels = new JTextField();
		NumWeels.setBounds(560, 271, 86, 20);
		contentPane.add(NumWeels);
		NumWeels.setColumns(10);

		Length = new JTextField();
		Length.setBounds(762, 348, 86, 20);
		contentPane.add(Length);
		Length.setColumns(10);

		Hight = new JTextField();
		Hight.setBounds(762, 321, 86, 20);
		contentPane.add(Hight);
		Hight.setColumns(10);

		JLabel lblNewLabel_11 = new JLabel(
				"\u05DE\u05E1' \u05DE\u05E7\u05D5\u05DE\u05D5\u05EA \u05D9\u05E9\u05D9\u05D1\u05D4");
		lblNewLabel_11.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_11.setBounds(646, 351, 106, 14);
		contentPane.add(lblNewLabel_11);

		JLabel lblNewLabel_12 = new JLabel("\u05D1\u05D3");
		lblNewLabel_12.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_12.setBounds(706, 326, 46, 14);
		contentPane.add(lblNewLabel_12);

		JLabel lblNewLabel_13 = new JLabel("\u05D7\u05D5\u05DE\u05E8");
		lblNewLabel_13.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_13.setBounds(706, 301, 46, 14);
		contentPane.add(lblNewLabel_13);

		NumCites = new JTextField();
		NumCites.setBounds(560, 348, 86, 20);
		contentPane.add(NumCites);
		NumCites.setColumns(10);

		Fabic = new JTextField();
		Fabic.setBounds(560, 323, 86, 20);
		contentPane.add(Fabic);
		Fabic.setColumns(10);

		Material = new JTextField();
		Material.setBounds(560, 298, 86, 20);
		contentPane.add(Material);
		Material.setColumns(10);

		JLabel lblNewLabel_14 = new JLabel("\u05D4\u05D6\u05D6\u05D4");
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_14.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_14.setBounds(487, 277, 46, 14);
		contentPane.add(lblNewLabel_14);

		JLabel lblNewLabel_15 = new JLabel("\u05DE\u05D2\u05D9\u05E8\u05D5\u05EA");
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_15.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_15.setBounds(487, 298, 46, 14);
		contentPane.add(lblNewLabel_15);

		JLabel lblNewLabel_16 = new JLabel("\u05E9\u05D5\u05DC\u05D7\u05DF \u05E0\u05E4\u05EA\u05D7");
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_16.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_16.setBounds(467, 323, 66, 14);
		contentPane.add(lblNewLabel_16);

		JLabel lblNewLabel_17 = new JLabel("\u05E1\u05E4\u05D4 \u05E0\u05E4\u05EA\u05D7\u05EA");
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_17.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_17.setBounds(300, 273, 69, 14);
		contentPane.add(lblNewLabel_17);

		JLabel lblNewLabel_18 = new JLabel("\u05D0\u05D5\u05E8\u05D8\u05D5\u05E4\u05D3\u05D9");
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_18.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_18.setBounds(474, 350, 59, 14);
		contentPane.add(lblNewLabel_18);

		Sliding = new JTextField();
		Sliding.setBounds(379, 271, 78, 20);
		contentPane.add(Sliding);
		Sliding.setColumns(10);

		Drawer = new JTextField();
		Drawer.setBounds(379, 296, 78, 20);
		contentPane.add(Drawer);
		Drawer.setColumns(10);

		TOpen = new JTextField();
		TOpen.setBounds(379, 321, 78, 20);
		contentPane.add(TOpen);
		TOpen.setColumns(10);

		Ortoped = new JTextField();
		Ortoped.setBounds(379, 348, 78, 20);
		contentPane.add(Ortoped);
		Ortoped.setColumns(10);

		SOpen = new JTextField();
		SOpen.setText("");
		SOpen.setBounds(231, 271, 59, 20);
		contentPane.add(SOpen);
		SOpen.setColumns(10);
		SOpen.setColumns(10);

		JButton Save = new JButton("\u05E9\u05DE\u05D5\u05E8");
		Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				List<DiningTable> DTprod = new ArrayList<DiningTable>();

			//	FileOutputStream excelFOU = null;
			//	BufferedOutputStream excelBOU = null;
				int rownum = 1;
				File exelFile = new File("sales.xlsx"); 
				FileInputStream fis = null;
				try {
					fis = new FileInputStream(exelFile);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// Create XSSF workbook
				XSSFWorkbook workbook = null;
				try {
					workbook = new XSSFWorkbook(fis);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// First sheet
				XSSFSheet sheet = workbook.getSheetAt(0);
				// Iterator on rows
				// Iterator<Row> rowIt = sheet.iterator();

				Row row = sheet.getRow(rownum);
				String defaultCurrentDirectoryPath = "products";
				JFileChooser excelFileChooser = new JFileChooser(defaultCurrentDirectoryPath);
				FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL Files", "xls", "xlsx", "xlsn");
				excelFileChooser.setFileFilter(fnef);
				excelFileChooser.setDialogTitle("Select products File");
				int excelChooser = excelFileChooser.showOpenDialog(null);
				DefaultTableModel model = (DefaultTableModel) table_1.getModel();

				//Workbook workbook = new XSSFWorkbook();
				//Sheet sheet = workbook.createSheet();

				if (excelChooser == JFileChooser.APPROVE_OPTION)
					try {


						int excelrow = 0; // sheet.getLastRowNum() ;
						int rowNum = 0;
						int colNum = 17;

						for (int i = 0; i < model.getRowCount(); i++) { // model.getRowCount()
							XSSFRow excelRow = (XSSFRow) sheet.createRow(i);

							String name = (String) Name.getSelectedItem();

							switch (name) {
							case "שולחן אוכל":
								DTprod.add(new DiningTable((String) model.getValueAt(rowNum, colNum),
										(int) model.getValueAt(rowNum, (colNum - 1)),
										(String) model.getValueAt(rowNum, colNum - 2),
										(Double) model.getValueAt(rowNum, colNum - 3),
										(Double) model.getValueAt(rowNum, colNum - 4),
										(String) model.getValueAt(rowNum, colNum - 5),
										(int) model.getValueAt(rowNum, colNum - 6),
										(Double) model.getValueAt(rowNum, colNum - 7),
										(Double) model.getValueAt(rowNum, colNum - 8),
										(int) model.getValueAt(rowNum, (colNum - 12)),
										(String) model.getValueAt(rowNum, (colNum - 15))));

								for (DiningTable prod : DTprod) {
									Row row1 = sheet.createRow(excelrow++);
									row1.createCell(0).setCellValue(prod.getName());
									row1.createCell(1).setCellValue(prod.getID());
									row1.createCell(2).setCellValue(prod.getProductProvider());
									row1.createCell(3).setCellValue(prod.getCostPrice());
									row1.createCell(4).setCellValue(prod.getSellingprice());
									row1.createCell(5).setCellValue(prod.getColor());
									row1.createCell(6).setCellValue(prod.getQuantity());
									row1.createCell(7).setCellValue(prod.getHeight());
									row1.createCell(8).setCellValue(prod.getLength());
									row1.createCell(12).setCellValue(prod.getNumPlaces());
									row1.createCell(15).setCellValue(prod.getisIsOpen());
								}
							}
							
					//		excelFOU = new FileOutputStream(excelFileChooser.getSelectedFile());
					//		excelBOU = new BufferedOutputStream(excelFOU);
					//		workbook.write(excelBOU);
							JOptionPane.showMessageDialog(null, "נשמר בהצלחה באקסל !");
						}
			//		} catch (FileNotFoundException ex) {
			//			ex.printStackTrace();
			//		} catch (IOException ex) {
			//			ex.printStackTrace();
					} finally {
					//	try {
					//		if (excelFOU != null)
					//			excelFOU.close();
					//		if (excelBOU != null)
					//			excelBOU.close();
					//		if (workbook != null)
					//			workbook.close();
					//	} catch (IOException ex) {
					//		ex.printStackTrace();
					//	}
					}
				try {
					workbook.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Save.setFont(new Font("Arial", Font.BOLD, 15));
		Save.setBounds(114, 294, 89, 23);
		contentPane.add(Save);

		textField = new JTextField();
		textField.setBounds(213, 241, 3, 159);
		contentPane.add(textField);
		textField.setColumns(10);

	}
}
