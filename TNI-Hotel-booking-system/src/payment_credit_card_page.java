
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import Core.CardCheck;
import Core.CheckIn;

import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

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
	private JLabel lblCardError;

	private double total;
	private double price;
	private String username;
	private String name;
	private int day;

	/**
	 * Launch the application.
	 */
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					payment_credit_card_page window = new payment_credit_card_page(day, price, total, username, name);
					window.frmCreditCardPayment.setVisible(true);
					window.frmCreditCardPayment.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public payment_credit_card_page(int day, double price, double total, String username, String name) {
		this.day = day;
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

		frmCreditCardPayment = new JFrame();
		frmCreditCardPayment.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				Name.setText(name);
			}
		});
		frmCreditCardPayment.setIconImage(
				Toolkit.getDefaultToolkit().getImage(payment_credit_card_page.class.getResource("/img/icon1.png")));
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
		CardNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				if (!(Character.isDigit(evt.getKeyChar()) || (evt.getKeyChar() == KeyEvent.VK_DELETE)
						|| (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)))
					evt.consume();
				if (CardNumber.getText().length() == 16)
					evt.consume();
			}

			@Override
			public void keyReleased(KeyEvent evt) {
				if (CardNumber.getText().length() == 16) {
					CardCheck card = new CardCheck(CardNumber.getText());
					if (!(card.checkCard())) {
						CardNumber.setBackground(new Color(255, 0, 51));
						lblCardError.setVisible(true);
						btnPay.setEnabled(false);
					} else {
						CardNumber.setBackground(new Color(51, 204, 51));
						lblCardError.setVisible(false);
						btnPay.setEnabled(true);
					}
				}
				if (CardNumber.getText().length() < 16) {
					CardNumber.setBackground(new Color(255, 255, 255));
					lblCardError.setVisible(false);
					btnPay.setEnabled(false);
				}
				if (CardNumber.getText().startsWith(""))
					lblCardicon.setVisible(false);
				if (CardNumber.getText().startsWith("4")) {
					lblCardicon.setVisible(true);
					lblCardicon.setIcon(new ImageIcon(payment_credit_card_page.class.getResource("/img/visa.png")));
				}
				if (CardNumber.getText().startsWith("51") || CardNumber.getText().startsWith("52")
						|| CardNumber.getText().startsWith("53") || CardNumber.getText().startsWith("54")
						|| CardNumber.getText().startsWith("55")) {
					lblCardicon.setVisible(true);
					lblCardicon.setIcon(new ImageIcon(payment_credit_card_page.class.getResource("/img/master.png")));
				}
			}

			@Override
			public void keyPressed(KeyEvent evt) {
				if (!(Character.isDigit(evt.getKeyChar()) || (evt.getKeyChar() == KeyEvent.VK_DELETE)
						|| (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)))
					evt.consume();
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
				CardCheck name = new CardCheck(Name.getText(), CardNumber.getText());
				int Success = 0;
				if (name.checkName()) {
					Success = JOptionPane.showConfirmDialog(null,
							"Total Price : " + (total) + "\nPlease continue at EDC machine.\n\nPayment success?",
							"Please continue at EDC machine", JOptionPane.YES_NO_OPTION,
							JOptionPane.INFORMATION_MESSAGE);
					if (Success == 0) {

						try {
							new CheckIn().PrintLogs(username, day, Name.getText(),
									"Credit Card " + CardNumber.getText().substring(12));
						} catch (IOException e) {
							JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
						}
						try {
							new CheckIn().writeFile();
						} catch (IOException e) {
							JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
						}
						frmCreditCardPayment.setVisible(false);
						JOptionPane.showMessageDialog(null, "Check In completed.", "Check In | Hotel Booking System",
								JOptionPane.INFORMATION_MESSAGE);
						new main_hotel_page(username).NewScreen();
					}
				}
			}
		});
		btnPay.setBounds(259, 90, 130, 27);
		btnPay.setIcon(new ImageIcon(payment_credit_card_page.class.getResource("/img/pay_creditcard_icon.png")));
		btnPay.setEnabled(false);
		card_input.add(btnPay);
		btnPay.setFont(new Font("Tahoma", Font.PLAIN, 18));

		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				frmCreditCardPayment.setVisible(false);
				new payment_method_page(day, price, total, username, name).NewScreen();
			}
		});
		btnCancel.setBounds(116, 90, 130, 27);
		btnCancel.setIcon(new ImageIcon(payment_credit_card_page.class.getResource("/img/cancel_icon.png")));
		card_input.add(btnCancel);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 18));

		lblCardicon = new JLabel("");
		lblCardicon.setBounds(399, 13, 50, 28);
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

		lblCardError = new JLabel("ERROR: Credit Card is invalid, Please check credit card and try again.");
		lblCardError.setForeground(new Color(204, 0, 0));
		lblCardError.setVisible(false);
		lblCardError.setHorizontalAlignment(SwingConstants.CENTER);
		lblCardError.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCardError.setBounds(27, 125, 422, 14);
		card_input.add(lblCardError);
	}

}
