
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import Core.Cash;
import Core.CheckIn;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.Window.Type;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.awt.Toolkit;

public class payment_cash_page {

	private JFrame frmCashHotel;
	private JLabel lblTotalMoney;
	private JPanel cashPanel;
	private JLabel lblChangeMoney;
	private JFormattedTextField accept_money;
	private JButton btnAccept;

	private double price;
	private double total;
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
					payment_cash_page window = new payment_cash_page(day, price, total, username, name);
					window.frmCashHotel.setVisible(true);
					window.frmCashHotel.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public payment_cash_page(int day, double price, double total, String username, String name) {
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
		Cash cash = new Cash(total);
		frmCashHotel = new JFrame();
		frmCashHotel.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				if (accept_money.getText().isEmpty()) {
					if (cash.checkMoney(0)) {
						accept_money.setText("Free");
						accept_money.setEnabled(false);
						lblTotalMoney.setText("Free");
						lblChangeMoney.setText("Free");
						btnAccept.setEnabled(true);
					} else
						lblTotalMoney.setText(cash.getPricetoString());
				}
			}
		});
		frmCashHotel.setIconImage(
				Toolkit.getDefaultToolkit().getImage(payment_cash_page.class.getResource("/img/icon1.png")));
		frmCashHotel.setType(Type.POPUP);
		frmCashHotel.setTitle("Payment (Cash) | Hotel Booking System");
		frmCashHotel.setResizable(false);
		frmCashHotel.setBounds(100, 100, 415, 230);
		frmCashHotel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCashHotel.getContentPane().setLayout(null);

		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(null);
		titlePanel.setBackground(new Color(124, 180, 212));
		titlePanel.setBounds(0, 0, 409, 50);
		frmCashHotel.getContentPane().add(titlePanel);

		JLabel lblCash = new JLabel("Cash");
		lblCash.setHorizontalAlignment(SwingConstants.CENTER);
		lblCash.setForeground(Color.BLACK);
		lblCash.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblCash.setBounds(0, 0, 407, 50);
		titlePanel.add(lblCash);

		cashPanel = new JPanel();
		cashPanel.setBackground(Color.WHITE);
		cashPanel.setBounds(0, 47, 409, 154);
		frmCashHotel.getContentPane().add(cashPanel);
		cashPanel.setLayout(null);

		JLabel lblTotal = new JLabel("Total :");
		lblTotal.setBounds(10, 18, 151, 27);
		cashPanel.add(lblTotal);
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblAcceptMoney = new JLabel("Accept money :");
		lblAcceptMoney.setBounds(10, 48, 151, 27);
		cashPanel.add(lblAcceptMoney);
		lblAcceptMoney.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAcceptMoney.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblChange = new JLabel("Change :");
		lblChange.setBounds(10, 78, 151, 27);
		cashPanel.add(lblChange);
		lblChange.setHorizontalAlignment(SwingConstants.RIGHT);
		lblChange.setFont(new Font("Tahoma", Font.PLAIN, 18));

		lblTotalMoney = new JLabel("0.00");
		lblTotalMoney.setBounds(171, 18, 162, 27);
		cashPanel.add(lblTotalMoney);
		lblTotalMoney.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalMoney.setFont(new Font("Tahoma", Font.PLAIN, 18));

		lblChangeMoney = new JLabel("0.00");
		lblChangeMoney.setBounds(171, 78, 162, 27);
		cashPanel.add(lblChangeMoney);
		lblChangeMoney.setHorizontalAlignment(SwingConstants.RIGHT);
		lblChangeMoney.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblBaht = new JLabel("Baht.");
		lblBaht.setBounds(344, 18, 63, 27);
		cashPanel.add(lblBaht);
		lblBaht.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel label_2 = new JLabel("Baht.");
		label_2.setBounds(344, 48, 63, 27);
		cashPanel.add(label_2);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel label_3 = new JLabel("Baht.");
		label_3.setBounds(344, 78, 63, 27);
		cashPanel.add(label_3);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 18));

		btnAccept = new JButton("Accept");
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					new CheckIn().writeFile();
					new CheckIn().PrintLogs(username, day, name,
							((total == 0) ? "Free by Coupon" : "Cash " + accept_money.getText() + " Baht"));
					frmCashHotel.setVisible(false);
					JOptionPane.showMessageDialog(null, "Check In completed.", "Check In | Hotel Booking System",
							JOptionPane.INFORMATION_MESSAGE);
					new main_hotel_page(username).NewScreen();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAccept.setBounds(206, 116, 151, 27);
		btnAccept.setIcon(new ImageIcon(payment_cash_page.class.getResource("/img/pay_cash_icon.png")));
		cashPanel.add(btnAccept);
		btnAccept.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCashHotel.setVisible(false);
				new payment_method_page(day, price, total, username, name).NewScreen();
			}
		});
		btnCancel.setBounds(45, 116, 151, 27);
		btnCancel.setIcon(new ImageIcon(payment_cash_page.class.getResource("/img/cancel_icon.png")));
		cashPanel.add(btnCancel);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 18));

		accept_money = new JFormattedTextField();
		accept_money.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				if (!(Character.isDigit(evt.getKeyChar()) || (evt.getKeyChar() == KeyEvent.VK_DELETE)
						|| (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)))
					evt.consume();

				if (accept_money.getText().length() == 9)
					evt.consume();
				if (accept_money.getText().startsWith("0"))
					accept_money.setText("" + accept_money.getText().substring(0, accept_money.getText().length() - 1));
			}

			@Override
			public void keyReleased(KeyEvent evt) {
				if (accept_money.getText().isEmpty() || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
					lblChangeMoney.setText("0.00");
					btnAccept.setEnabled(false);
				}
				if (accept_money.getText().startsWith("0")) {
					lblChangeMoney.setText("0.00");
					accept_money.setText("");
				}
				if (accept_money.getText().isEmpty())
					return;
				else if (cash.checkMoney(Integer.parseInt(accept_money.getText()))) {
					lblChangeMoney.setText(cash.getChangetoString(Integer.parseInt(accept_money.getText())));
					btnAccept.setEnabled(true);
				} else {
					lblChangeMoney.setText(cash.getChangetoString(Integer.parseInt(accept_money.getText())));
					btnAccept.setEnabled(false);
				}
			}

			@Override
			public void keyPressed(KeyEvent evt) {
				if (!(Character.isDigit(evt.getKeyChar()) || (evt.getKeyChar() == KeyEvent.VK_DELETE)
						|| (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)))
					evt.consume();
			}
		});
		accept_money.setBounds(171, 48, 166, 27);
		cashPanel.add(accept_money);
		btnAccept.setEnabled(false);
		accept_money.setFont(new Font("Tahoma", Font.PLAIN, 18));
		accept_money.setHorizontalAlignment(SwingConstants.RIGHT);
	}

}
