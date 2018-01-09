import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class customer_information_page {

	private JFrame frmCustomerInformation;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					customer_information_page window = new customer_information_page();
					window.frmCustomerInformation.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public customer_information_page() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCustomerInformation = new JFrame();
		frmCustomerInformation.setTitle("Customer Information | Hotel Booking System");
		frmCustomerInformation.setResizable(false);
		frmCustomerInformation.setBounds(100, 100, 567, 357);
		frmCustomerInformation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCustomerInformation.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 71, 560, 260);
		frmCustomerInformation.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblName = new JLabel("Name : ");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setBounds(10, 11, 143, 36);
		panel.add(lblName);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBounds(163, 11, 338, 36);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblIdOrPassport = new JLabel("ID Card :");
		lblIdOrPassport.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdOrPassport.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIdOrPassport.setBounds(10, 58, 143, 36);
		panel.add(lblIdOrPassport);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(163, 58, 338, 36);
		panel.add(textField_1);
		
		JLabel lblLicensePlate = new JLabel("License Plate :");
		lblLicensePlate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLicensePlate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLicensePlate.setBounds(10, 104, 143, 36);
		panel.add(lblLicensePlate);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(163, 105, 338, 36);
		panel.add(textField_2);
		
		JLabel lblPhone = new JLabel("Phone :");
		lblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPhone.setBounds(10, 151, 143, 36);
		panel.add(lblPhone);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(163, 151, 338, 36);
		panel.add(textField_3);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSave.setBounds(304, 198, 121, 45);
		panel.add(btnSave);
		
		JButton btnCacel = new JButton("Cancel");
		btnCacel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCacel.setBounds(173, 198, 121, 45);
		panel.add(btnCacel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 561, 71);
		panel_1.setBackground(new Color(124, 180, 212));
		frmCustomerInformation.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCustomerInformation = new JLabel("Customer Information");
		lblCustomerInformation.setForeground(new Color(0, 0, 0));
		lblCustomerInformation.setBounds(173, 21, 212, 27);
		lblCustomerInformation.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel_1.add(lblCustomerInformation);
	}
}
