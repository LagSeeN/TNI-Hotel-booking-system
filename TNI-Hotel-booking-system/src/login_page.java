import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Window.Type;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JProgressBar;

public class login_page {

	private JFrame login;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					login_page window = new login_page();
					window.login.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login_page() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		login = new JFrame();
		login.setTitle("Login | Hotel Booking System");
		login.setResizable(false);
		login.getContentPane().setEnabled(false);
		login.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(124, 180, 212));
		panel.setBounds(0, 0, 394, 50);
		login.getContentPane().add(panel);
		
		JLabel lblAccount = new JLabel("Login");
		lblAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccount.setForeground(Color.BLACK);
		lblAccount.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblAccount.setBounds(0, 0, 394, 50);
		panel.add(lblAccount);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 50, 394, 141);
		login.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
				JLabel lblUsername = new JLabel("USERNAME : ");
				lblUsername.setBounds(50, 27, 115, 17);
				panel_1.add(lblUsername);
				lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
				lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
				
						JLabel lblPassword = new JLabel("PASSWORD : ");
						lblPassword.setBounds(50, 58, 115, 17);
						panel_1.add(lblPassword);
						lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
						lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
						
								textField = new JTextField();
								textField.setBounds(175, 24, 155, 23);
								panel_1.add(textField);
								textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
								textField.setColumns(10);
								
										passwordField = new JPasswordField();
										passwordField.setBounds(175, 55, 155, 20);
										panel_1.add(passwordField);
										passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
										
												JButton btnLogin = new JButton("Login");
												btnLogin.setBounds(125, 95, 89, 24);
												panel_1.add(btnLogin);
												btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
												
														JButton btnExit = new JButton("Exit");
														btnExit.setBounds(221, 95, 89, 24);
														panel_1.add(btnExit);
														btnExit.setFont(new Font("Tahoma", Font.PLAIN, 18));
														btnExit.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent e) {
																System.exit(JFrame.EXIT_ON_CLOSE);
															}
														});
												btnLogin.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {
														menu_page menu = new menu_page();
														//menu.NewScreen();
														login.setVisible(false);

													}
												});
		login.setBounds(100, 100, 400, 220);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
