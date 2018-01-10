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

public class payment_summary_page {

	private JFrame frmSummaryHotel;
	private JTextField textField;

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
		frmSummaryHotel.setBounds(100, 100, 540, 240);
		frmSummaryHotel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSummaryHotel.getContentPane().setLayout(null);
		
		JLabel lblRoomPrice = new JLabel("Room Price : ");
		lblRoomPrice.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblRoomPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRoomPrice.setBounds(14, 57, 183, 27);
		frmSummaryHotel.getContentPane().add(lblRoomPrice);
		
		JLabel label = new JLabel("0.00");
		label.setFont(new Font("Tahoma", Font.PLAIN, 22));
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(207, 57, 143, 27);
		frmSummaryHotel.getContentPane().add(label);
		
		JLabel lblBaht = new JLabel("Baht.");
		lblBaht.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblBaht.setBounds(360, 57, 143, 27);
		frmSummaryHotel.getContentPane().add(lblBaht);
		
		JLabel lblCoupon = new JLabel("Coupon : ");
		lblCoupon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCoupon.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblCoupon.setBounds(14, 95, 185, 27);
		frmSummaryHotel.getContentPane().add(lblCoupon);
		
		JLabel lblCouponStatus = new JLabel("(not use)");
		lblCouponStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblCouponStatus.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblCouponStatus.setBounds(207, 95, 143, 27);
		frmSummaryHotel.getContentPane().add(lblCouponStatus);
		
		JLabel lblTotalPrice = new JLabel("Total Price : ");
		lblTotalPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalPrice.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblTotalPrice.setBounds(12, 133, 185, 27);
		frmSummaryHotel.getContentPane().add(lblTotalPrice);
		
		JLabel label_5 = new JLabel("0.00");
		label_5.setForeground(Color.RED);
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 22));
		label_5.setBounds(207, 133, 143, 27);
		frmSummaryHotel.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("Baht.");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 22));
		label_6.setBounds(360, 133, 64, 27);
		frmSummaryHotel.getContentPane().add(label_6);
		
		JButton btnUseCoupon = new JButton("Add");
		btnUseCoupon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showInputDialog("Input Coupon Code :");
			}
		});
		btnUseCoupon.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnUseCoupon.setBounds(360, 97, 143, 27);
		frmSummaryHotel.getContentPane().add(btnUseCoupon);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSummaryHotel.setVisible(false);
				payment_method_page payment = new payment_method_page();
				payment.NewScreen();
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNext.setBounds(360, 171, 143, 27);
		frmSummaryHotel.getContentPane().add(btnNext);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSummaryHotel.setVisible(false);
				menu_page menu = new menu_page();
				menu.NewScreen();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnCancel.setBounds(54, 171, 143, 27);
		frmSummaryHotel.getContentPane().add(btnCancel);
		
		JLabel lblCustomerName = new JLabel("Customer Name : ");
		lblCustomerName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblCustomerName.setBounds(12, 19, 185, 27);
		frmSummaryHotel.getContentPane().add(lblCustomerName);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField.setBounds(207, 19, 143, 27);
		frmSummaryHotel.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnCheck = new JButton("Check");
		btnCheck.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnCheck.setBounds(360, 19, 143, 27);
		frmSummaryHotel.getContentPane().add(btnCheck);
	}
}
