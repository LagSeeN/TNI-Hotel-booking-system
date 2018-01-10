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
		frmSummaryHotel.setBounds(100, 100, 540, 290);
		frmSummaryHotel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSummaryHotel.getContentPane().setLayout(null);
		
		JPanel panel_title = new JPanel();
		panel_title.setLayout(null);
		panel_title.setBackground(new Color(124, 180, 212));
		panel_title.setBounds(0, 0, 534, 50);
		frmSummaryHotel.getContentPane().add(panel_title);
		
		JLabel lblSummary = new JLabel("Summary");
		lblSummary.setHorizontalAlignment(SwingConstants.CENTER);
		lblSummary.setForeground(Color.BLACK);
		lblSummary.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblSummary.setBounds(0, 0, 534, 50);
		panel_title.add(lblSummary);
		
		JPanel panel_item = new JPanel();
		panel_item.setBackground(Color.WHITE);
		panel_item.setBounds(0, 51, 534, 210);
		frmSummaryHotel.getContentPane().add(panel_item);
		panel_item.setLayout(null);
		
		JLabel lblRoomPrice = new JLabel("Room Price : ");
		lblRoomPrice.setBounds(12, 58, 183, 27);
		panel_item.add(lblRoomPrice);
		lblRoomPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRoomPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel label = new JLabel("0.00");
		label.setBounds(205, 58, 143, 27);
		panel_item.add(label);
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblBaht = new JLabel("Baht.");
		lblBaht.setBounds(358, 58, 143, 27);
		panel_item.add(lblBaht);
		lblBaht.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblCoupon = new JLabel("Coupon : ");
		lblCoupon.setBounds(12, 96, 185, 27);
		panel_item.add(lblCoupon);
		lblCoupon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCoupon.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblCouponStatus = new JLabel("(not use)");
		lblCouponStatus.setBounds(205, 96, 143, 27);
		panel_item.add(lblCouponStatus);
		lblCouponStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblCouponStatus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblTotalPrice = new JLabel("Total Price : ");
		lblTotalPrice.setBounds(10, 134, 185, 27);
		panel_item.add(lblTotalPrice);
		lblTotalPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel label_5 = new JLabel("0.00");
		label_5.setBounds(205, 134, 143, 27);
		panel_item.add(label_5);
		label_5.setForeground(Color.RED);
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel label_6 = new JLabel("Baht.");
		label_6.setBounds(358, 134, 64, 27);
		panel_item.add(label_6);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnUseCoupon = new JButton("Add");
		btnUseCoupon.setBounds(358, 98, 143, 27);
		panel_item.add(btnUseCoupon);
		btnUseCoupon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showInputDialog("Input Coupon Code :");
			}
		});
		btnUseCoupon.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(358, 172, 143, 27);
		panel_item.add(btnNext);
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
		panel_item.add(btnCancel);
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
		panel_item.add(lblCustomerName);
		lblCustomerName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		textField = new JTextField();
		textField.setBounds(205, 20, 143, 27);
		panel_item.add(textField);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		
		JButton btnCheck = new JButton("Check");
		btnCheck.setBounds(358, 20, 143, 27);
		panel_item.add(btnCheck);
		btnCheck.setFont(new Font("Tahoma", Font.PLAIN, 18));
	}
}
