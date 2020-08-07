package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Button;
import java.awt.Panel;
import javax.swing.JSlider;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import javax.swing.JTextPane;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	Connection connection = null;
	
	public Home() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 150, 1100, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Button button_1 = new Button("\u05D4\u05D5\u05E1\u05E4\u05EA \u05DE\u05D5\u05E6\u05E8");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add add = new Add();
				Add.main(null);
			}
		});
		button_1.setBackground(Color.BLUE);
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Arial", Font.BOLD, 15));
		button_1.setBounds(835, 173, 149, 33);
		contentPane.add(button_1);
		
		Button button_2 = new Button("\u05E6\u05E4\u05D9\u05D9\u05D4 \u05D1\u05DE\u05DC\u05D0\u05D9");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Watch watch = new Watch();
				Watch.main(null);
			}
		});
		button_2.setBackground(Color.BLUE);
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Arial", Font.BOLD, 15));
		button_2.setBounds(835, 232, 149, 33);
		contentPane.add(button_2);
		
		Button button_3 = new Button("\u05D3\u05D5\u05D7 \u05DE\u05DB\u05D9\u05E8\u05D5\u05EA \u05DB\u05DC\u05DC\u05D9");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TotalSales totalsales = new TotalSales();
				TotalSales.main(null);
			}
		});
		button_3.setBackground(Color.BLUE);
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Arial", Font.BOLD, 15));
		button_3.setBounds(835, 293, 149, 33);
		contentPane.add(button_3);
		
		JLabel lblNewLabel = new JLabel("\u05D1\u05D7\u05E8 \u05DE\u05D4\u05E4\u05E2\u05D5\u05DC\u05D5\u05EA \u05D4\u05D1\u05D0\u05D5\u05EA :");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(798, 60, 186, 14);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 744, 386);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Home.class.getResource("/images/bp.jpg")));
		panel.add(lblNewLabel_1);
		
		Button button_1_1 = new Button("\u05D4\u05D5\u05E1\u05E4\u05EA \u05DE\u05DB\u05D9\u05E8\u05D4");
		button_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sales sale = new Sales();
				Sales.main(null);
			}
		});
		button_1_1.setForeground(Color.WHITE);
		button_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		button_1_1.setBackground(Color.BLUE);
		button_1_1.setBounds(835, 114, 149, 33);
		contentPane.add(button_1_1);
	}
}
