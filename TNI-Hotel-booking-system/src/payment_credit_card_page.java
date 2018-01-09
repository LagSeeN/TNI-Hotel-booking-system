import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;

public class payment_credit_card_page {

	private JFrame frmCreditCardPayment;
	private JTextField textField;
	private JLabel lblName;
	private JTextField textField_1;
	private JButton btnPay;
	private JButton btnCancel;
	private JLabel lblVisa;

	/**
	 * Launch the application.
	 */
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					payment_credit_card_page window = new payment_credit_card_page();
					window.frmCreditCardPayment.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public payment_credit_card_page() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCreditCardPayment = new JFrame();
		frmCreditCardPayment.setFont(new Font("Tahoma", Font.PLAIN, 11));
		frmCreditCardPayment.setTitle("Credit Card Payment");
		frmCreditCardPayment.setBounds(100, 100, 330, 150);
		frmCreditCardPayment.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCreditCardPayment.getContentPane().setLayout(null);

		JLabel lblCardNumber = new JLabel("Card Number : ");
		lblCardNumber.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCardNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCardNumber.setBounds(10, 22, 82, 14);
		frmCreditCardPayment.getContentPane().add(lblCardNumber);

		textField = new JTextField();
		textField.setBounds(102, 19, 150, 20);
		frmCreditCardPayment.getContentPane().add(textField);
		textField.setColumns(10);

		lblName = new JLabel("Name : ");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(20, 47, 70, 14);
		frmCreditCardPayment.getContentPane().add(lblName);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(102, 47, 150, 20);
		frmCreditCardPayment.getContentPane().add(textField_1);

		btnPay = new JButton("Pay");
		btnPay.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnPay.setBounds(64, 78, 89, 23);
		frmCreditCardPayment.getContentPane().add(btnPay);

		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCancel.setBounds(184, 78, 89, 23);
		frmCreditCardPayment.getContentPane().add(btnCancel);

		lblVisa = new JLabel("VISA");
		lblVisa.setIcon(new ImageIcon(this.getClass().getResource("visa.jpg")));
		lblVisa.setBounds(254, 15, 50, 28);
		frmCreditCardPayment.getContentPane().add(lblVisa);
	}
}
