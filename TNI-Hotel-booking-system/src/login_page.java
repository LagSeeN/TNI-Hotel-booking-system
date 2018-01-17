
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;

public class login_page {

	private JFrame login;
	private JTextField textField;
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
					window.login.setVisible(true);
					// windows set to centra
					window.login.setLocationRelativeTo(null);
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

		textField = new JTextField();
		textField.setBounds(175, 24, 155, 23);
		loginpane.add(textField);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(175, 55, 155, 20);
		loginpane.add(passwordField);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(125, 95, 89, 24);
		loginpane.add(btnLogin);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(221, 95, 89, 24);
		loginpane.add(btnExit);
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JPanel timepane = new JPanel();
		timepane.setBackground(Color.WHITE);
		timepane.setBounds(0, 50, 394, 54);
		login.getContentPane().add(timepane);
		timepane.setLayout(null);

		lblTime = new JLabel("");
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setBounds(0, 0, 394, 54);
		timepane.add(lblTime);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new menu_check_in_page().NewScreen();
				;
				login.setVisible(false);

			}
		});
		login.setBounds(100, 100, 400, 270);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void time() {
		DecimalFormat frm = new DecimalFormat("00");
		String months[] = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		Thread clock = new Thread() {
			public void run() {
				try {
					for (;;) {
						GregorianCalendar cal = new GregorianCalendar();
						int day = cal.get(Calendar.DAY_OF_MONTH);
						int month = cal.get(Calendar.MONTH);
						int year = cal.get(Calendar.YEAR);
						int sec = cal.get(Calendar.SECOND);
						int min = cal.get(Calendar.MINUTE);
						int hr = cal.get(Calendar.HOUR);
						lblTime.setText(frm.format(day) + "/" + months[month] + "/" + frm.format(year) + " "
								+ frm.format(hr) + ":" + frm.format(min) + ":" + frm.format(sec));
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
