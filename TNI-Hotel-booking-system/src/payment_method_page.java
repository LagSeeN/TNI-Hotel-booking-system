
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Toolkit;

public class payment_method_page {

	private JFrame frmPaymentMethod;
	private double total;
	private double price;
	private String name;

	private String username;

	/**
	 * Launch the application.
	 */
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					payment_method_page window = new payment_method_page(price, total, username, name);
					window.frmPaymentMethod.setVisible(true);
					window.frmPaymentMethod.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 */
	public payment_method_page(double price, double total, String username, String name) {
		this.price = price;
		this.total = total;
		this.username = username;
		this.name = name;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPaymentMethod = new JFrame();
		frmPaymentMethod.setIconImage(
				Toolkit.getDefaultToolkit().getImage(payment_method_page.class.getResource("/img/icon1.png")));
		frmPaymentMethod.setFont(new Font("Tahoma", Font.PLAIN, 11));
		frmPaymentMethod.setResizable(false);
		frmPaymentMethod.setTitle("Payment Method | Hotel Booking System");
		frmPaymentMethod.setBounds(100, 100, 380, 155);
		frmPaymentMethod.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPaymentMethod.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(124, 180, 212));
		panel.setBounds(0, 0, 374, 50);
		frmPaymentMethod.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblPressSelectPayment = new JLabel("Press select Payment method");
		lblPressSelectPayment.setBounds(0, 0, 374, 50);
		panel.add(lblPressSelectPayment);
		lblPressSelectPayment.setForeground(Color.BLACK);
		lblPressSelectPayment.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPressSelectPayment.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 47, 374, 82);
		frmPaymentMethod.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JButton btnCash = new JButton("Cash");
		btnCash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPaymentMethod.setVisible(false);
				new payment_cash_page(price, total, username, name).NewScreen();
			}
		});
		btnCash.setBounds(10, 11, 169, 27);
		panel_1.add(btnCash);
		btnCash.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnCreditCard = new JButton("Credit Card");
		btnCreditCard.setBounds(195, 11, 169, 27);
		panel_1.add(btnCreditCard);
		btnCreditCard.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmPaymentMethod.setVisible(false);
				new payment_summary_page(price, username).NewScreen();

			}
		});
		btnCancel.setBounds(10, 45, 354, 27);
		panel_1.add(btnCancel);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCreditCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmPaymentMethod.setVisible(false);
				new payment_credit_card_page(price, total, username, name).NewScreen();
			}
		});
	}

}
