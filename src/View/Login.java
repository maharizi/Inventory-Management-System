package View;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Button;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JEditorPane;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
    private JFrame frame;
	private JPanel contentPane;
	private JTextField textUser;
	private JPasswordField passwordField;

	int xx, xy;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setUndecorated(true);
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
	public Login() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 150, 652, 398);
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int x = arg0.getXOnScreen();
				int y = arg0.getYOnScreen();
				Login.this.setLocation(x - xx, y - xy);
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx = e.getX();
				xy = e.getY();
			}
		});
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(-13, -12, 415, 382);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 11, 415, 370);
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/images/bp.jpg")));
		panel.add(lblNewLabel_2);
		
		Button button = new Button("\u05DB\u05E0\u05D9\u05E1\u05D4");
		button.setFont(new Font("Arial", Font.BOLD, 15));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String password = passwordField.getText();
				String username = textUser.getText();
				if ((username.contains("מאור") || (username.contains("מור")) && password.contains("1111"))){
					passwordField.setText(null);
					textUser.setText(null);
					Home home = new Home();
					Home.main(null);;
				}
				else
				{
					JOptionPane.showMessageDialog(null, "אחד או יותר מהפרטים שהזנת שגויים !", "כניסה נכשלה", JOptionPane.ERROR_MESSAGE);
					passwordField.setText(null);
					textUser.setText(null);
				}
			}
		});
		button.setForeground(SystemColor.controlLtHighlight);
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(412, 260, 214, 44);
		contentPane.add(button);
		
		textUser = new JTextField();
		textUser.setFont(new Font("Arial", Font.BOLD, 14));
		textUser.setHorizontalAlignment(SwingConstants.RIGHT);
		textUser.setBounds(412, 90, 214, 32);
		contentPane.add(textUser);
		textUser.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(412, 120, 214, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("\u05E9\u05DD");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(562, 59, 64, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u05E1\u05D9\u05E1\u05DE\u05D0");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(580, 153, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(412, 216, 214, 2);
		contentPane.add(separator_1);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.RIGHT);
		passwordField.setFont(new Font("Arial", Font.BOLD, 14));
		passwordField.setBounds(412, 186, 214, 32);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_3 = new JLabel("X");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setForeground(new Color(241,57,83));
		lblNewLabel_3.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(604, 0, 46, 32);
		contentPane.add(lblNewLabel_3);
	}
}
