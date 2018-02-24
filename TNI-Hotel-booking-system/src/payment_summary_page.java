
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import Core.CardCheck;
import Core.Summary;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class payment_summary_page {

	private JFrame frmSummaryHotel;
	private JTextField NameField;
	private JLabel lblPrice;
	private JLabel lblTotal;
	private JLabel lblCouponStatus;
	private double discount;
	private double price;
	private int day;
	private boolean CouponUsed = true;

	private String username;

	/**
	 * Launch the application.
	 */
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					payment_summary_page window = new payment_summary_page(day, price, discount, username);
					window.frmSummaryHotel.setVisible(true);
					window.frmSummaryHotel.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.\
	 * 
	 * @wbp.parser.constructor
	 * 
	 */
	public payment_summary_page(int day, double price, double discount, String username) {
		this.day = day;
		this.price = price;
		this.discount = discount;
		this.username = username;
		initialize();
	}

	public payment_summary_page(int day, double price, String username) {
		this.day = day;
		this.price = price;
		this.discount = 0;
		this.username = username;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Summary sum = new Summary(price);
		frmSummaryHotel = new JFrame();
		frmSummaryHotel.setIconImage(
				Toolkit.getDefaultToolkit().getImage(payment_summary_page.class.getResource("/img/icon1.png")));
		frmSummaryHotel.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent evt) {
				lblPrice.setText(sum.getPricetoString());
				lblTotal.setText(sum.getTotaltoString());
			}
		});
		frmSummaryHotel.setResizable(false);
		frmSummaryHotel.setTitle("Summary | Hotel Booking System");
		frmSummaryHotel.setBounds(100, 100, 540, 290);
		frmSummaryHotel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSummaryHotel.getContentPane().setLayout(null);

		JPanel titlePane = new JPanel();
		titlePane.setLayout(null);
		titlePane.setBackground(new Color(124, 180, 212));
		titlePane.setBounds(0, 0, 534, 50);
		frmSummaryHotel.getContentPane().add(titlePane);

		JLabel lblSummary = new JLabel("Summary");
		lblSummary.setHorizontalAlignment(SwingConstants.CENTER);
		lblSummary.setForeground(Color.BLACK);
		lblSummary.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblSummary.setBounds(0, 0, 534, 50);
		titlePane.add(lblSummary);

		JPanel summaryPane = new JPanel();
		summaryPane.setBackground(Color.WHITE);
		summaryPane.setBounds(0, 51, 534, 210);
		frmSummaryHotel.getContentPane().add(summaryPane);
		summaryPane.setLayout(null);

		JLabel lblRoomPrice = new JLabel("Room Price : ");
		lblRoomPrice.setBounds(12, 58, 183, 27);
		summaryPane.add(lblRoomPrice);
		lblRoomPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRoomPrice.setHorizontalAlignment(SwingConstants.RIGHT);

		lblPrice = new JLabel("0.00");
		lblPrice.setBounds(205, 58, 143, 27);
		summaryPane.add(lblPrice);
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPrice.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblBaht = new JLabel("Baht.");
		lblBaht.setBounds(358, 58, 143, 27);
		summaryPane.add(lblBaht);
		lblBaht.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblCoupon = new JLabel("Coupon : ");
		lblCoupon.setBounds(12, 96, 185, 27);
		summaryPane.add(lblCoupon);
		lblCoupon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCoupon.setFont(new Font("Tahoma", Font.PLAIN, 18));

		lblCouponStatus = new JLabel("(not use)");
		lblCouponStatus.setBounds(205, 96, 143, 27);
		summaryPane.add(lblCouponStatus);
		lblCouponStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblCouponStatus.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblTotalPrice = new JLabel("Total Price : ");
		lblTotalPrice.setBounds(10, 134, 185, 27);
		summaryPane.add(lblTotalPrice);
		lblTotalPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));

		lblTotal = new JLabel("0.00");
		lblTotal.setBounds(205, 134, 143, 27);
		summaryPane.add(lblTotal);
		lblTotal.setForeground(Color.RED);
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel label_6 = new JLabel("Baht.");
		label_6.setBounds(358, 134, 64, 27);
		summaryPane.add(label_6);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnUseCoupon = new JButton("Add");
		btnUseCoupon.setBounds(358, 98, 143, 27);
		btnUseCoupon.setIcon(new ImageIcon(payment_summary_page.class.getResource("/img/coupon_add_icon.png")));
		summaryPane.add(btnUseCoupon);
		btnUseCoupon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (CouponUsed) {
					try {
						if (sum.checkCoupon(JOptionPane.showInputDialog("Input Coupon Code :"))) {
							lblTotal.setText(sum.getTotaltoString());
							lblCouponStatus.setText(sum.getDiscounttoString());
							CouponUsed = false;
							btnUseCoupon.setText("Remove");
							btnUseCoupon.setIcon(new ImageIcon(payment_summary_page.class.getResource("/img/coupon_remove_icon.png")));
						}
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Coupon System Failed.", "Error", JOptionPane.ERROR_MESSAGE);
					} catch (NullPointerException e1) {
						return;
					}
				} else {
					sum.setPrice(price);
					lblTotal.setText(sum.getPricetoString());
					btnUseCoupon.setText("Add");
					btnUseCoupon.setIcon(new ImageIcon(payment_summary_page.class.getResource("/img/coupon_add_icon.png")));
					lblCouponStatus.setText("(not use)");
					CouponUsed = true;
				}
			}
		});
		btnUseCoupon.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnNext = new JButton("Next");
		btnNext.setBounds(358, 172, 143, 27);
		btnNext.setIcon(new ImageIcon(payment_summary_page.class.getResource("/img/checkmark_icon.png")));
		summaryPane.add(btnNext);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardCheck name = new CardCheck();
				name.setName(NameField.getText());
				if (name.checkName()) {
					frmSummaryHotel.setVisible(false);
					new payment_method_page(day, price, sum.getTotal(), username, NameField.getText()).NewScreen();
				}
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 18));
		

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(52, 172, 143, 27);
		btnCancel.setIcon(new ImageIcon(payment_summary_page.class.getResource("/img/cancel_icon.png")));
		summaryPane.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSummaryHotel.setVisible(false);
				new main_hotel_page(username).NewScreen();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		

		JLabel lblCustomerName = new JLabel("Customer Name : ");
		lblCustomerName.setBounds(10, 20, 185, 27);
		summaryPane.add(lblCustomerName);
		lblCustomerName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 18));

		NameField = new JTextField();
		NameField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				if (!(Character.isAlphabetic(evt.getKeyChar()) || (evt.getKeyChar() == KeyEvent.VK_SPACE)
						|| (evt.getKeyChar() == KeyEvent.VK_DELETE) || (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE))) {
					evt.consume();
				}
			}
		});
		NameField.setBounds(205, 20, 296, 27);
		summaryPane.add(NameField);
		NameField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		NameField.setColumns(10);
	}
}
