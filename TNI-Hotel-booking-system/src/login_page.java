
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Toolkit;
import core.LoginManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;

public class login_page {

	private JFrame login;
	private JTextField text_username;
	private JPasswordField passwordField;
	private JLabel lblTime;

	/**
	 * Launch the application.
	 */
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					login_page window = new login_page();
					window.login.setLocationRelativeTo(null);
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
		time();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		login = new JFrame();
		login.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("icon1.png")));
		login.setTitle("Login | Hotel Booking System");
		login.setResizable(false);
		login.getContentPane().setEnabled(false);
		login.getContentPane().setLayout(null);

		JPanel title = new JPanel();
		title.setLayout(null);
		title.setBackground(new Color(124, 180, 212));
		title.setBounds(0, 0, 394, 50);
		login.getContentPane().add(title);

		JLabel lblAccount = new JLabel("Login");
		lblAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccount.setForeground(Color.BLACK);
		lblAccount.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblAccount.setBounds(0, 0, 394, 50);
		title.add(lblAccount);

		JPanel loginpane = new JPanel();
		loginpane.setBackground(Color.WHITE);
		loginpane.setBounds(0, 104, 394, 137);
		login.getContentPane().add(loginpane);
		loginpane.setLayout(null);

		JLabel lblUsername = new JLabel("USERNAME : ");
		lblUsername.setBounds(50, 27, 115, 17);
		loginpane.add(lblUsername);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblPassword = new JLabel("PASSWORD : ");
		lblPassword.setBounds(50, 58, 115, 17);
		loginpane.add(lblPassword);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);

		text_username = new JTextField();
		text_username.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				if (!(Character.isAlphabetic(evt.getKeyChar()) || (evt.getKeyChar() == KeyEvent.VK_DELETE)
						|| (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)))
					evt.consume();
			}

			@Override
			public void keyTyped(KeyEvent evt) {
				if (!(Character.isAlphabetic(evt.getKeyChar()) || (evt.getKeyChar() == KeyEvent.VK_DELETE)
						|| (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)))
					evt.consume();
			}
		});
		text_username.setBounds(175, 24, 155, 23);
		loginpane.add(text_username);
		text_username.setFont(new Font("Tahoma", Font.PLAIN, 16));
		text_username.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				if (!(Character.isAlphabetic(evt.getKeyChar()) || (Character.isDigit(evt.getKeyChar())
						|| (evt.getKeyChar() == KeyEvent.VK_DELETE) || (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE))))
					evt.consume();
			}

			@Override
			public void keyPressed(KeyEvent evt) {
				if (!(Character.isAlphabetic(evt.getKeyChar()) || (Character.isDigit(evt.getKeyChar())
						|| (evt.getKeyChar() == KeyEvent.VK_DELETE) || (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE))))
					evt.consume();
			}
		});
		passwordField.setBounds(175, 55, 155, 20);
		loginpane.add(passwordField);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = new String(text_username.getText());
				String password = new String(passwordField.getPassword());
				LoginManager LoginSys = new LoginManager(username, password);
				if (username.isEmpty() || password.isEmpty())
					JOptionPane.showMessageDialog(null, "please enter username or password", "Message",
							JOptionPane.WARNING_MESSAGE);
				else if (!(LoginSys.LoginCheck())) {
					JOptionPane.showMessageDialog(null, "username or password is incorrect.", "Message",
							JOptionPane.WARNING_MESSAGE);
				} else {
					new main_hotel_page(LoginSys.getUsername()).NewScreen();
					login.setVisible(false);
				}
			}
		});
		btnLogin.setBounds(125, 95, 89, 24);
		loginpane.add(btnLogin);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnExit.setBounds(221, 95, 89, 24);
		loginpane.add(btnExit);
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JPanel timepane = new JPanel();
		timepane.setBackground(Color.WHITE);
		timepane.setBounds(0, 50, 394, 54);
		login.getContentPane().add(timepane);
		timepane.setLayout(null);

		lblTime = new JLabel("");
		lblTime.setFont(new Font("Sitka Display", Font.PLAIN, 22));
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setBounds(0, 0, 394, 54);
		timepane.add(lblTime);

		login.setBounds(100, 100, 400, 270);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void time() {
		Thread clock = new Thread() {
			public void run() {
				try {
					Font digital = Font
							.createFont(Font.TRUETYPE_FONT,
									new FileInputStream(
											new File(this.getClass().getResource("digital-7.ttf").getFile())))
							.deriveFont(Font.PLAIN, 22);
					lblTime.setFont(digital);
					for (;;) {
						DateFormat dateFormat = new SimpleDateFormat("EEE/MMM/YYYY HH:mm:ss", Locale.ENGLISH);
						Date date = new Date();
						lblTime.setText(dateFormat.format(date).toString());
						sleep(1000);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		clock.start();

	}
}