import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class payment_credit_card_page {

	private JFrame frmCreditCardPayment;
	private JTextField textField;
	private JLabel lblName;
	private JTextField textField_1;
	private JLabel lblExpires;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel label;
	private JLabel lblCcv;
	private JTextField textField_4;
	private JButton btnPay;
	private JButton btnCancel;
	private JLabel lblVisa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		frmCreditCardPayment.setTitle("Credit Card Payment");
		frmCreditCardPayment.setBounds(100, 100, 330, 230);
		frmCreditCardPayment.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCreditCardPayment.getContentPane().setLayout(null);

		JLabel lblCardNumber = new JLabel("Card Number");
		lblCardNumber.setBounds(10, 22, 70, 14);
		frmCreditCardPayment.getContentPane().add(lblCardNumber);

		textField = new JTextField();
		textField.setBounds(87, 19, 217, 20);
		frmCreditCardPayment.getContentPane().add(textField);
		textField.setColumns(10);

		lblName = new JLabel("Name");
		lblName.setBounds(10, 50, 70, 14);
		frmCreditCardPayment.getContentPane().add(lblName);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(87, 47, 217, 20);
		frmCreditCardPayment.getContentPane().add(textField_1);

		lblExpires = new JLabel("Expires");
		lblExpires.setBounds(10, 78, 70, 14);
		frmCreditCardPayment.getContentPane().add(lblExpires);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(87, 75, 76, 20);
		frmCreditCardPayment.getContentPane().add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(193, 75, 76, 20);
		frmCreditCardPayment.getContentPane().add(textField_3);

		label = new JLabel("/");
		label.setBounds(173, 78, 18, 14);
		frmCreditCardPayment.getContentPane().add(label);

		lblCcv = new JLabel("CCV");
		lblCcv.setBounds(10, 104, 70, 14);
		frmCreditCardPayment.getContentPane().add(lblCcv);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(87, 101, 76, 20);
		frmCreditCardPayment.getContentPane().add(textField_4);

		btnPay = new JButton("Pay");
		btnPay.setBounds(42, 157, 89, 23);
		frmCreditCardPayment.getContentPane().add(btnPay);

		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(162, 157, 89, 23);
		frmCreditCardPayment.getContentPane().add(btnCancel);

		lblVisa = new JLabel("VISA");
		lblVisa.setIcon(new ImageIcon(this.getClass().getResource("visa.jpg")));
		lblVisa.setBounds(167, 97, 50, 28);
		frmCreditCardPayment.getContentPane().add(lblVisa);
	}
}
