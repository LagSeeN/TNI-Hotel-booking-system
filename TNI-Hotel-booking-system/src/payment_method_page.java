import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class payment_method_page {

	private JFrame frmPaymentMethod;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					payment_method_page window = new payment_method_page();
					window.frmPaymentMethod.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public payment_method_page() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPaymentMethod = new JFrame();
		frmPaymentMethod.setFont(new Font("Tahoma", Font.PLAIN, 11));
		frmPaymentMethod.setResizable(false);
		frmPaymentMethod.setTitle("Payment Method | Hotel Booking System");
		frmPaymentMethod.setBounds(100, 100, 230, 140);
		frmPaymentMethod.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPaymentMethod.getContentPane().setLayout(null);
		
		JLabel lblPressSelectPayment = new JLabel("Press select Payment method");
		lblPressSelectPayment.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPressSelectPayment.setHorizontalAlignment(SwingConstants.CENTER);
		lblPressSelectPayment.setBounds(10, 11, 194, 14);
		frmPaymentMethod.getContentPane().add(lblPressSelectPayment);
		
		JButton btnCash = new JButton("Cash");
		btnCash.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCash.setBounds(10, 36, 100, 23);
		frmPaymentMethod.getContentPane().add(btnCash);
		
		JButton btnCreditCard = new JButton("Credit Card");
		btnCreditCard.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCreditCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				payment_credit_card_page credit = new payment_credit_card_page();
				credit.NewScreen();
				frmPaymentMethod.setVisible(false);
			}
		});
		btnCreditCard.setBounds(114, 36, 100, 23);
		frmPaymentMethod.getContentPane().add(btnCreditCard);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCancel.setBounds(10, 70, 204, 23);
		frmPaymentMethod.getContentPane().add(btnCancel);
	}

}
