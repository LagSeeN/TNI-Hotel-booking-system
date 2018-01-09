import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class payment_summary_page {

	private JFrame frmSummaryHotel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					payment_summary_page window = new payment_summary_page();
					window.frmSummaryHotel.setVisible(true);
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
		frmSummaryHotel.setBounds(100, 100, 320, 145);
		frmSummaryHotel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSummaryHotel.getContentPane().setLayout(null);
		
		JLabel lblRoomPrice = new JLabel("Room Price : ");
		lblRoomPrice.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblRoomPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRoomPrice.setBounds(12, 11, 88, 14);
		frmSummaryHotel.getContentPane().add(lblRoomPrice);
		
		JLabel label = new JLabel("0.00");
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(110, 11, 143, 14);
		frmSummaryHotel.getContentPane().add(label);
		
		JLabel lblBaht = new JLabel("Baht.");
		lblBaht.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblBaht.setBounds(263, 11, 39, 14);
		frmSummaryHotel.getContentPane().add(lblBaht);
		
		JLabel lblCoupon = new JLabel("Coupon : ");
		lblCoupon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCoupon.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCoupon.setBounds(12, 36, 88, 14);
		frmSummaryHotel.getContentPane().add(lblCoupon);
		
		JLabel lblCouponStatus = new JLabel("(not use)");
		lblCouponStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblCouponStatus.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCouponStatus.setBounds(110, 36, 88, 14);
		frmSummaryHotel.getContentPane().add(lblCouponStatus);
		
		JLabel lblTotalPrice = new JLabel("Total Price : ");
		lblTotalPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalPrice.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTotalPrice.setBounds(12, 61, 88, 14);
		frmSummaryHotel.getContentPane().add(lblTotalPrice);
		
		JLabel label_5 = new JLabel("0.00");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_5.setBounds(110, 61, 143, 14);
		frmSummaryHotel.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("Baht.");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_6.setBounds(263, 61, 39, 14);
		frmSummaryHotel.getContentPane().add(label_6);
		
		JButton btnUseCoupon = new JButton("Add");
		btnUseCoupon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showInputDialog("Input Coupon Code :");
			}
		});
		btnUseCoupon.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnUseCoupon.setBounds(213, 34, 89, 23);
		frmSummaryHotel.getContentPane().add(btnUseCoupon);
		
		JButton btnNext = new JButton("Next");
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNext.setBounds(10, 85, 89, 23);
		frmSummaryHotel.getContentPane().add(btnNext);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCancel.setBounds(212, 85, 89, 23);
		frmSummaryHotel.getContentPane().add(btnCancel);
	}

}
