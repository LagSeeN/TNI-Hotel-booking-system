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
		frmCreditCardPayment.setBounds(100, 100, 500, 180);
		frmCreditCardPayment.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCreditCardPayment.getContentPane().setLayout(null);

		JLabel lblCardNumber = new JLabel("Card Number : ");
		lblCardNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCardNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCardNumber.setBounds(10, 22, 167, 27);
		frmCreditCardPayment.getContentPane().add(lblCardNumber);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBounds(187, 22, 202, 27);
		frmCreditCardPayment.getContentPane().add(textField);
		textField.setColumns(10);

		lblName = new JLabel("Name : ");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(27, 60, 150, 27);
		frmCreditCardPayment.getContentPane().add(lblName);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(187, 60, 202, 27);
		frmCreditCardPayment.getContentPane().add(textField_1);

		btnPay = new JButton("Pay");
		btnPay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPay.setBounds(259, 98, 130, 27);
		frmCreditCardPayment.getContentPane().add(btnPay);

		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancel.setBounds(116, 98, 130, 27);
		frmCreditCardPayment.getContentPane().add(btnCancel);

		lblVisa = new JLabel("VISA");
		lblVisa.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblVisa.setIcon(new ImageIcon(this.getClass().getResource("visa.jpg")));
		lblVisa.setBounds(424, 21, 50, 28);
		frmCreditCardPayment.getContentPane().add(lblVisa);
	}
}
