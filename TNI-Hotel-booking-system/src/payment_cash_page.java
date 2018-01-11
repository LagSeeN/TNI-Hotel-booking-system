import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
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

import core.Cash;

public class payment_cash_page {

	private JFrame frmCashHotel;

	/**
	 * Launch the application.
	 */
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					payment_cash_page window = new payment_cash_page();
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
	public payment_cash_page() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCashHotel = new JFrame();
		frmCashHotel.setType(Type.POPUP);
		frmCashHotel.setTitle("Payment (Cash) | Hotel Booking System");
		frmCashHotel.setResizable(false);
		frmCashHotel.setBounds(100, 100, 415, 230);
		frmCashHotel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCashHotel.getContentPane().setLayout(null);
		
		JPanel title = new JPanel();
		title.setLayout(null);
		title.setBackground(new Color(124, 180, 212));
		title.setBounds(0, 0, 407, 50);
		frmCashHotel.getContentPane().add(title);
		
		JLabel lblCash = new JLabel("Cash");
		lblCash.setHorizontalAlignment(SwingConstants.CENTER);
		lblCash.setForeground(Color.BLACK);
		lblCash.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblCash.setBounds(0, 0, 407, 50);
		title.add(lblCash);
		
		JPanel cash = new JPanel();
		cash.setBackground(Color.WHITE);
		cash.setBounds(0, 47, 409, 154);
		frmCashHotel.getContentPane().add(cash);
		cash.setLayout(null);
		
		JLabel lblTotal = new JLabel("Total :");
		lblTotal.setBounds(10, 18, 151, 27);
		cash.add(lblTotal);
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblAcceptMoney = new JLabel("Accept money :");
		lblAcceptMoney.setBounds(10, 48, 151, 27);
		cash.add(lblAcceptMoney);
		lblAcceptMoney.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAcceptMoney.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblChange = new JLabel("Change :");
		lblChange.setBounds(10, 78, 151, 27);
		cash.add(lblChange);
		lblChange.setHorizontalAlignment(SwingConstants.RIGHT);
		lblChange.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel label = new JLabel("0.00");
		label.setBounds(171, 18, 162, 27);
		cash.add(label);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel label_1 = new JLabel("0.00");
		label_1.setBounds(171, 78, 162, 27);
		cash.add(label_1);
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblBaht = new JLabel("Baht.");
		lblBaht.setBounds(344, 18, 63, 27);
		cash.add(lblBaht);
		lblBaht.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel label_2 = new JLabel("Baht.");
		label_2.setBounds(344, 48, 63, 27);
		cash.add(label_2);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel label_3 = new JLabel("Baht.");
		label_3.setBounds(344, 78, 63, 27);
		cash.add(label_3);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnAccept = new JButton("Accept");
		btnAccept.setBounds(206, 116, 151, 27);
		cash.add(btnAccept);
		btnAccept.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCashHotel.setVisible(false);
				payment_method_page payment = new payment_method_page();
				payment.NewScreen();
			}
		});
		btnCancel.setBounds(45, 116, 151, 27);
		cash.add(btnCancel);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JFormattedTextField accept_money = new JFormattedTextField();
		accept_money.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				if (!(Character.isDigit(evt.getKeyChar()) || (evt.getKeyChar() == KeyEvent.VK_DELETE)
						|| (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)))
					evt.consume();
			}
			@Override
			public void keyReleased(KeyEvent evt) {
			}
			@Override
			public void keyPressed(KeyEvent evt) {
				if (!(Character.isDigit(evt.getKeyChar()) || (evt.getKeyChar() == KeyEvent.VK_DELETE)
						|| (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)))
					evt.consume();
			}
		});
		accept_money.setBounds(171, 48, 162, 27);
		cash.add(accept_money);
		accept_money.setFont(new Font("Tahoma", Font.PLAIN, 18));
		accept_money.setHorizontalAlignment(SwingConstants.RIGHT);
	}
}
