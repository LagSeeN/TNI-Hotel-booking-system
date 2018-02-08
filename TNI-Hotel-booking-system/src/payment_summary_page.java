
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import core.Summary;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.text.DecimalFormat;
import java.awt.Toolkit;

public class payment_summary_page {

	private JFrame frmSummaryHotel;
	private JTextField NameField;
	private JLabel lblPrice;
	private JLabel lblTotal;
	private JLabel lblCouponStatus;
	private double discount;
	private double price;
	private double total;

	private String username;

	/**
	 * Launch the application.
	 */
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					payment_summary_page window = new payment_summary_page(price, discount, username);
					window.frmSummaryHotel.setVisible(true);
					window.frmSummaryHotel.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 */
	public payment_summary_page(double price, double discount, String username) {
		this.price = price;
		this.discount = discount;
		this.username = username;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Summary sum = new Summary(price);
		frmSummaryHotel = new JFrame();
		frmSummaryHotel.setIconImage(Toolkit.getDefaultToolkit().getImage(payment_summary_page.class.getResource("/img/icon1.png")));
		frmSummaryHotel.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent evt) {
				if (discount == 0) {
					lblPrice.setText(sum.getPricetoString());
				} else {
					sum.setDiscount(discount);
					lblPrice.setText(sum.getPricetoString());
					lblCouponStatus.setText(sum.getDiscounttoString());
				}
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
		summaryPane.add(btnUseCoupon);
		btnUseCoupon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean CouponUsed = true;
				if (CouponUsed) {
					try {
						if (sum.checkCoupon(JOptionPane.showInputDialog("Input Coupon Code :"))) {
							lblTotal.setText(sum.getTotaltoString());
							lblCouponStatus.setText(sum.getDiscounttoString());
							CouponUsed = false;
							btnUseCoupon.setText("Remove");
						} else
							JOptionPane.showMessageDialog(null, "Coupon invalid", "Coupon invalid",
									JOptionPane.WARNING_MESSAGE);
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
				}
				else{
					total = price;
					btnUseCoupon.setText("Add");
				}
			}
		});
		btnUseCoupon.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnNext = new JButton("Next");
		btnNext.setBounds(358, 172, 143, 27);
		summaryPane.add(btnNext);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSummaryHotel.setVisible(false);
				payment_method_page payment = new payment_method_page(sum.getTotal(), sum.getDiscount(), username);
				payment.NewScreen();
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(52, 172, 143, 27);
		summaryPane.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSummaryHotel.setVisible(false);
				main_hotel_page menu = new main_hotel_page(username);
				menu.NewScreen();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblCustomerName = new JLabel("Customer Name : ");
		lblCustomerName.setBounds(10, 20, 185, 27);
		summaryPane.add(lblCustomerName);
		lblCustomerName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 18));

		NameField = new JTextField();
		NameField.setBounds(205, 20, 296, 27);
		summaryPane.add(NameField);
		NameField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		NameField.setColumns(10);
	}
}
