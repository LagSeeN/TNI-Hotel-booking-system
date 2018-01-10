import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class payment_credit_card_page {

	private JFrame frmCreditCardPayment;
	private JTextField textField;
	private JLabel lblName;
	private JTextField textField_1;
	private JButton btnPay;
	private JButton btnCancel;
	private JLabel lblVisa;
	private JPanel panel;
	private JLabel lblCreditCardInformation;
	private JPanel panel_1;

	/**
	 * Launch the application.
	 */
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); 
					payment_credit_card_page window = new payment_credit_card_page();
					window.frmCreditCardPayment.setVisible(true);
					window.frmCreditCardPayment.setLocationRelativeTo(null);;
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
		frmCreditCardPayment.setResizable(false);
		frmCreditCardPayment.setFont(new Font("Tahoma", Font.PLAIN, 11));
		frmCreditCardPayment.setTitle("Payment (Credit Card) | Hotel Booking System");
		frmCreditCardPayment.setBounds(100, 100, 484, 230);
		frmCreditCardPayment.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCreditCardPayment.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(124, 180, 212));
		panel.setBounds(0, 0, 478, 50);
		frmCreditCardPayment.getContentPane().add(panel);
		
		lblCreditCardInformation = new JLabel("Credit Card Information");
		lblCreditCardInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreditCardInformation.setForeground(Color.BLACK);
		lblCreditCardInformation.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblCreditCardInformation.setBounds(0, 0, 480, 50);
		panel.add(lblCreditCardInformation);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 51, 478, 150);
		frmCreditCardPayment.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
				textField = new JTextField();
				textField.setBounds(187, 14, 202, 27);
				panel_1.add(textField);
				textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
				textField.setColumns(10);
				
						textField_1 = new JTextField();
						textField_1.setBounds(187, 52, 202, 27);
						panel_1.add(textField_1);
						textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
						textField_1.setColumns(10);
						
								btnPay = new JButton("Pay");
								btnPay.setBounds(259, 90, 130, 27);
								panel_1.add(btnPay);
								btnPay.setFont(new Font("Tahoma", Font.PLAIN, 18));
								
										btnCancel = new JButton("Cancel");
										btnCancel.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												frmCreditCardPayment.setVisible(false);
												payment_method_page payment = new payment_method_page();
												//payment.NewScreen();
											}
										});
										btnCancel.setBounds(116, 90, 130, 27);
										panel_1.add(btnCancel);
										btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 18));
										
												lblVisa = new JLabel("VISA");
												lblVisa.setBounds(399, 11, 50, 28);
												panel_1.add(lblVisa);
												lblVisa.setFont(new Font("Tahoma", Font.PLAIN, 22));
												lblVisa.setIcon(new ImageIcon(this.getClass().getResource("visa.jpg")));
												
														JLabel lblCardNumber = new JLabel("Card Number : ");
														lblCardNumber.setBounds(10, 14, 167, 27);
														panel_1.add(lblCardNumber);
														lblCardNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
														lblCardNumber.setHorizontalAlignment(SwingConstants.RIGHT);
														
																lblName = new JLabel("Name : ");
																lblName.setBounds(27, 52, 150, 27);
																panel_1.add(lblName);
																lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
																lblName.setHorizontalAlignment(SwingConstants.RIGHT);
	}
}
