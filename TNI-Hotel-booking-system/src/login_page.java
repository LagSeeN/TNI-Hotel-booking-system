import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Window.Type;

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
		login.setResizable(false);
		login.getContentPane().setEnabled(false);
		login.getContentPane().setLayout(null);

		JLabel lblUsername = new JLabel("USERNAME : ");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername.setBounds(57, 87, 89, 14);
		login.getContentPane().add(lblUsername);

		JLabel lblPassword = new JLabel("PASSWORD : ");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(57, 112, 89, 14);
		login.getContentPane().add(lblPassword);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField.setBounds(156, 84, 155, 20);
		login.getContentPane().add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		passwordField.setBounds(156, 109, 155, 20);
		login.getContentPane().add(passwordField);

		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu_page menu = new menu_page();
				//menu.NewScreen();
				login.setVisible(false);

			}
		});
		btnLogin.setBounds(106, 137, 89, 23);
		login.getContentPane().add(btnLogin);

		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnExit.setBounds(202, 137, 89, 23);
		login.getContentPane().add(btnExit);
		login.setBounds(100, 100, 400, 210);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
