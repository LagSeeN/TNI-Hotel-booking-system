import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JPanel;

public class payment_summary_page {

	private JFrame frmSummaryHotel;
	private JTextField NameField;

	/**
	 * Launch the application.
	 */
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					payment_summary_page window = new payment_summary_page();
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
	 */
	public payment_summary_page() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSummaryHotel = new JFrame();
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
		
		JLabel labelPrice = new JLabel("0.00");
		labelPrice.setBounds(205, 58, 143, 27);
		summaryPane.add(labelPrice);
		labelPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblBaht = new JLabel("Baht.");
		lblBaht.setBounds(358, 58, 143, 27);
		summaryPane.add(lblBaht);
		lblBaht.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblCoupon = new JLabel("Coupon : ");
		lblCoupon.setBounds(12, 96, 185, 27);
		summaryPane.add(lblCoupon);
		lblCoupon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCoupon.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblCouponStatus = new JLabel("(not use)");
		lblCouponStatus.setBounds(205, 96, 143, 27);
		summaryPane.add(lblCouponStatus);
		lblCouponStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblCouponStatus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblTotalPrice = new JLabel("Total Price : ");
		lblTotalPrice.setBounds(10, 134, 185, 27);
		summaryPane.add(lblTotalPrice);
		lblTotalPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblTotal = new JLabel("0.00");
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
				JOptionPane.showInputDialog("Input Coupon Code :");
			}
		});
		btnUseCoupon.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(358, 172, 143, 27);
		summaryPane.add(btnNext);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSummaryHotel.setVisible(false);
				payment_method_page payment = new payment_method_page();
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
				menu_page menu = new menu_page();
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
		NameField.setBounds(205, 20, 143, 27);
		summaryPane.add(NameField);
		NameField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		NameField.setColumns(10);
		
		JButton btnCheck = new JButton("Check");
		btnCheck.setBounds(358, 20, 143, 27);
		summaryPane.add(btnCheck);
		btnCheck.setFont(new Font("Tahoma", Font.PLAIN, 18));
	}
}
