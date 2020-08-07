package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.event.AncestorListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.event.AncestorEvent;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ScrollPaneConstants;

public class Watch extends JFrame {

	private JPanel contentPane;
	public JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Watch frame = new Watch();
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
	public Watch() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 150, 1100, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u05E6\u05E4\u05D9\u05D9\u05D4 \u05D5\u05D4\u05D3\u05E4\u05E1\u05D4");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(473, 21, 126, 24);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u05D7\u05D6\u05D5\u05E8");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home();
				Home.main(null);
			}
			
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton.setBounds(970, 11, 89, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
			}
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});
		scrollPane.setBounds(10, 56, 1064, 136);            
		contentPane.add(scrollPane);                       
		
		table = new JTable();
		table.addAncestorListener(new AncestorListener() {
			public void ancestorAdded() {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
			@Override
			public void ancestorAdded(AncestorEvent event) {
				// TODO Auto-generated method stub
				
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u05E1\u05E4\u05D4 \u05E0\u05E4\u05EA\u05D7\u05EA", "\u05D0\u05D5\u05E8\u05D8\u05D5\u05E4\u05D3\u05D9", "\u05E9\u05D5\u05DC\u05D7\u05DF \u05E0\u05E4\u05EA\u05D7", "\u05DE\u05D2\u05D9\u05E8\u05D5\u05EA", "\u05D4\u05D6\u05D6\u05D4", "\u05DE\u05E1 \u05DE\u05E7\u05D5\u05DE\u05D5\u05EA", "\u05D1\u05D3", "\u05D7\u05D5\u05DE\u05E8", "\u05DE\u05E1' \u05D2\u05DC\u05D2\u05DC\u05D9\u05DD", "\u05D0\u05D5\u05E8\u05DA", "\u05D2\u05D5\u05D1\u05D4", "\u05DB\u05DE\u05D5\u05EA", "\u05E6\u05D1\u05E2", "\u05DE\u05DB\u05D9\u05E8\u05D4", "\u05E7\u05E0\u05D9\u05D9\u05D4", "\u05E1\u05E4\u05E7", "\u05DE\u05E7''\u05D8", "\u05E9\u05DD"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, Integer.class, String.class, String.class, Integer.class, Integer.class, Integer.class, Integer.class, String.class, Integer.class, Integer.class, String.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
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
						DefaultTableModel model = (DefaultTableModel) table.getModel();

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
		Load.setBounds(563, 203, 126, 23);
		contentPane.add(Load);
		
		JButton Print = new JButton("\u05D4\u05D3\u05E4\u05E1\u05D4");
		Print.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table.print();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "נסה שוב !", "הדפסה  נכשלה", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		Print.setFont(new Font("Arial", Font.BOLD, 15));
		Print.setBounds(401, 203, 121, 23);
		contentPane.add(Print);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 237, 1064, 132);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u05DE\u05D7\u05D9\u05E8", "\u05D7\u05D5\u05D3\u05E9", "\u05DB\u05EA\u05D5\u05D1\u05EA", "\u05DE\u05E7''\u05D8", "\u05E9\u05DD \u05E8\u05D4\u05D9\u05D8", "\u05E9\u05DD \u05DC\u05E7\u05D5\u05D7"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, String.class, Integer.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_1.setViewportView(table_1);
		
		JButton Print2 = new JButton("\u05D4\u05D3\u05E4\u05E1\u05D4");
		Print2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table.print();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "נסה שוב !", "הדפסה  נכשלה", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		Print2.setFont(new Font("Arial", Font.BOLD, 15));
		Print2.setBounds(401, 380, 121, 23);
		contentPane.add(Print2);
		
		JButton Load2 = new JButton("\u05D8\u05E2\u05D9\u05E0\u05D4");
		Load2.setFont(new Font("Arial", Font.BOLD, 15));
		Load2.addActionListener(new ActionListener() {
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
						DefaultTableModel model = (DefaultTableModel) table_1.getModel();

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
		Load2.setBounds(563, 380, 126, 23);
		contentPane.add(Load2);
	}
}
