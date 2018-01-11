import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import core.credit_card;

public class payment_credit_card_page {

	private JFrame frmCreditCardPayment;
	private JTextField CardNumber;
	private JLabel lblName;
	private JTextField Name;
	private JButton btnPay;
	private JButton btnCancel;
	private JLabel lblCardicon;
	private JPanel title;
	private JLabel lblCreditCardInformation;
	private JPanel card_input;

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
					window.frmCreditCardPayment.setLocationRelativeTo(null);
					;
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

		title = new JPanel();
		title.setLayout(null);
		title.setBackground(new Color(124, 180, 212));
		title.setBounds(0, 0, 478, 50);
		frmCreditCardPayment.getContentPane().add(title);

		lblCreditCardInformation = new JLabel("Credit Card Information");
		lblCreditCardInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreditCardInformation.setForeground(Color.BLACK);
		lblCreditCardInformation.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblCreditCardInformation.setBounds(0, 0, 480, 50);
		title.add(lblCreditCardInformation);

		card_input = new JPanel();
		card_input.setBackground(Color.WHITE);
		card_input.setBounds(0, 51, 478, 150);
		frmCreditCardPayment.getContentPane().add(card_input);
		card_input.setLayout(null);

		CardNumber = new JTextField();
		credit_card card = new credit_card();
		CardNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				if (!(Character.isDigit(evt.getKeyChar()) || (evt.getKeyChar() == KeyEvent.VK_DELETE)
						|| (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)))
					evt.consume();
				if (CardNumber.getText().length() == 16)
					evt.consume();
				if (CardNumber.getText().startsWith(""))
					lblCardicon.setVisible(false);
				if (CardNumber.getText().startsWith("4")) {
					lblCardicon.setVisible(true);
					lblCardicon.setIcon(new ImageIcon(this.getClass().getResource("visa.jpeg")));
				}
				if (CardNumber.getText().startsWith("51") || CardNumber.getText().startsWith("52")
						|| CardNumber.getText().startsWith("53") || CardNumber.getText().startsWith("54")
						|| CardNumber.getText().startsWith("55")) {
					lblCardicon.setVisible(true);
					lblCardicon.setIcon(new ImageIcon(this.getClass().getResource("master.jpeg")));
				}
			}
		});
		CardNumber.setBounds(187, 14, 202, 27);
		card_input.add(CardNumber);
		CardNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		CardNumber.setColumns(10);

		Name = new JTextField();
		Name.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				if (!(Character.isAlphabetic(evt.getKeyChar()) || (evt.getKeyChar() == KeyEvent.VK_SPACE)
						|| (evt.getKeyChar() == KeyEvent.VK_DELETE) || (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE))) {
					evt.consume();
				}
			}
		});
		Name.setBounds(187, 52, 202, 27);
		card_input.add(Name);
		Name.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Name.setColumns(10);

		btnPay = new JButton("Pay");
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Pay
				credit_card check = new credit_card();
				if (!(check.checkName(Name.getText()))) {
					JOptionPane.showMessageDialog(null, "ERROR Name");
					Name.setText(null);
				} else if (!(card.checkCard(CardNumber.getText())))
					JOptionPane.showMessageDialog(null, "ERROR Card"+CardNumber.getText());
				else
					JOptionPane.showMessageDialog(null, "PASS");
			}
		});
		btnPay.setBounds(259, 90, 130, 27);
		card_input.add(btnPay);
		btnPay.setFont(new Font("Tahoma", Font.PLAIN, 18));

		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCreditCardPayment.setVisible(false);
				payment_method_page payment = new payment_method_page();
				payment.NewScreen();
			}
		});
		btnCancel.setBounds(116, 90, 130, 27);
		card_input.add(btnCancel);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 18));

		lblCardicon = new JLabel("");
		lblCardicon.setBounds(399, 11, 50, 28);
		card_input.add(lblCardicon);
		lblCardicon.setVisible(false);
		lblCardicon.setFont(new Font("Tahoma", Font.PLAIN, 22));

		JLabel lblCardNumber = new JLabel("Card Number : ");
		lblCardNumber.setBounds(10, 14, 167, 27);
		card_input.add(lblCardNumber);
		lblCardNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCardNumber.setHorizontalAlignment(SwingConstants.RIGHT);

		lblName = new JLabel("Name : ");
		lblName.setBounds(27, 52, 150, 27);
		card_input.add(lblName);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
	}
}
