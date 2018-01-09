import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.Window.Type;

public class payment_cash_page {

	private JFrame frmCashHotel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					payment_cash_page window = new payment_cash_page();
					window.frmCashHotel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public payment_cash_page() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCashHotel = new JFrame();
		frmCashHotel.setType(Type.POPUP);
		frmCashHotel.setTitle("Paymeny (Cash) | Hotel Booking System");
		frmCashHotel.setResizable(false);
		frmCashHotel.setBounds(100, 100, 415, 190);
		frmCashHotel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCashHotel.getContentPane().setLayout(null);
		
		JLabel lblTotal = new JLabel("Total :");
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblTotal.setBounds(10, 11, 151, 27);
		frmCashHotel.getContentPane().add(lblTotal);
		
		JLabel lblAcceptMoney = new JLabel("Accept money :");
		lblAcceptMoney.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAcceptMoney.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblAcceptMoney.setBounds(10, 41, 151, 27);
		frmCashHotel.getContentPane().add(lblAcceptMoney);
		
		JLabel lblChange = new JLabel("Change :");
		lblChange.setHorizontalAlignment(SwingConstants.RIGHT);
		lblChange.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblChange.setBounds(10, 71, 151, 27);
		frmCashHotel.getContentPane().add(lblChange);
		
		JLabel label = new JLabel("0.00");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Tahoma", Font.PLAIN, 22));
		label.setBounds(171, 11, 162, 27);
		frmCashHotel.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("0.00");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		label_1.setBounds(171, 73, 162, 27);
		frmCashHotel.getContentPane().add(label_1);
		
		JLabel lblBaht = new JLabel("Baht.");
		lblBaht.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblBaht.setBounds(344, 11, 63, 27);
		frmCashHotel.getContentPane().add(lblBaht);
		
		JLabel label_2 = new JLabel("Baht.");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		label_2.setBounds(344, 41, 63, 27);
		frmCashHotel.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Baht.");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		label_3.setBounds(344, 71, 63, 27);
		frmCashHotel.getContentPane().add(label_3);
		
		JButton btnAccept = new JButton("Accept");
		btnAccept.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnAccept.setBounds(45, 109, 151, 27);
		frmCashHotel.getContentPane().add(btnAccept);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnCancel.setBounds(206, 109, 151, 27);
		frmCashHotel.getContentPane().add(btnCancel);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		formattedTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		formattedTextField.setBounds(171, 41, 162, 27);
		frmCashHotel.getContentPane().add(formattedTextField);
	}
}
