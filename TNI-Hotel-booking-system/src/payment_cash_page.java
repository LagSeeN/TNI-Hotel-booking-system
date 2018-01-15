
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
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
import java.text.DecimalFormat;

public class payment_cash_page {

	private JFrame frmCashHotel;
	private JLabel lblTotalMoney;
	private JPanel cashPanel;
	private JLabel lblChangeMoney;
	private JFormattedTextField accept_money;
	private JButton btnAccept;

	private double price;

	DecimalFormat frm = new DecimalFormat("#,##0.00");

	/**
	 * Launch the application.
	 */
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					payment_cash_page window = new payment_cash_page(price);
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
	public payment_cash_page(double total) {
		price = total;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCashHotel = new JFrame();
		frmCashHotel.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent evt) {
				if (accept_money.getText().isEmpty()) {
					if (checkMoney(0)) {
						accept_money.setText("Free");
						accept_money.setEnabled(false);
						lblTotalMoney.setText("Free");
						lblChangeMoney.setText("Free");
						btnAccept.setEnabled(true);
					} else
						lblTotalMoney.setText(getPricetoString());
				}
			}
		});
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
				JOptionPane.showMessageDialog(null, "Pass");
			}
		});
		btnAccept.setBounds(206, 116, 151, 27);
		cashPanel.add(btnAccept);
		btnAccept.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCashHotel.setVisible(false);
				payment_method_page payment = new payment_method_page(price);
				payment.NewScreen();
			}
		});
		btnCancel.setBounds(45, 116, 151, 27);
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

			}

			@Override
			public void keyPressed(KeyEvent evt) {
				if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
					if (accept_money.getText().isEmpty())
						return;
					else if (checkMoney(Integer.parseInt(accept_money.getText()))) {
						lblChangeMoney.setText(getChangetoString(Integer.parseInt(accept_money.getText())));
						btnAccept.setEnabled(true);
					} else {
						lblChangeMoney.setText(getChangetoString(Integer.parseInt(accept_money.getText())));
						btnAccept.setEnabled(false);
					}
				}
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

	public String getPricetoString() {
		return frm.format(price);
	}

	public boolean checkMoney(double money) {
		return (money >= price);
	}

	public String getChangetoString(double money) {
		return frm.format((money - price));
	}

}
