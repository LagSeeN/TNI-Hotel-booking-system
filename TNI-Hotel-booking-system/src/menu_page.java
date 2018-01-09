import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JSplitPane;
import javax.swing.JDesktopPane;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class menu_page {

	private JFrame frmHotelBookingSystem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//เปลี่ยนธีม java เป็นแบบ  windows
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					menu_page window = new menu_page();
					window.frmHotelBookingSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public menu_page() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHotelBookingSystem = new JFrame();
		frmHotelBookingSystem.setResizable(false);
		frmHotelBookingSystem.setTitle("Hotel Booking System");
		frmHotelBookingSystem.setBounds(100, 100, 1024, 768);
		frmHotelBookingSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		frmHotelBookingSystem.setJMenuBar(menuBar);

		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);

		JMenuItem mntmLogout = new JMenuItem("Logout");
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		mnMenu.add(mntmLogout);

		JMenu mnCustomer = new JMenu("Customer");
		menuBar.add(mnCustomer);

		JMenuItem mntmAddCustomer = new JMenuItem("Add customer");
		mnCustomer.add(mntmAddCustomer);

		JMenu mnReport = new JMenu("Report");
		menuBar.add(mnReport);
		frmHotelBookingSystem.getContentPane().setLayout(null);
		
		JPanel panel_roomlist_sum = new JPanel();
		panel_roomlist_sum.setBackground(new Color(124, 180, 212));
		panel_roomlist_sum.setBounds(0, 250, 250, 468);
		frmHotelBookingSystem.getContentPane().add(panel_roomlist_sum);
		panel_roomlist_sum.setLayout(null);
		
		JLabel lblTotalRoom = new JLabel("Total : ");
		lblTotalRoom.setBounds(25, 265, 63, 14);
		panel_roomlist_sum.add(lblTotalRoom);
		lblTotalRoom.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel label = new JLabel("[00]");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(25, 290, 117, 23);
		panel_roomlist_sum.add(label);
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblRooms = new JLabel("Room(s)");
		lblRooms.setBounds(152, 290, 71, 23);
		panel_roomlist_sum.add(lblRooms);
		lblRooms.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblBaht = new JLabel("Baht.");
		lblBaht.setBounds(152, 315, 46, 23);
		panel_roomlist_sum.add(lblBaht);
		lblBaht.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lbltotalprice = new JLabel("[TOTALPRICE]");
		lbltotalprice.setHorizontalAlignment(SwingConstants.RIGHT);
		lbltotalprice.setBounds(25, 315, 117, 23);
		panel_roomlist_sum.add(lbltotalprice);
		lbltotalprice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnNewButton = new JButton("Pay");
		btnNewButton.setBounds(25, 377, 198, 31);
		panel_roomlist_sum.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JPanel panel_roomlist = new JPanel();
		panel_roomlist.setBackground(Color.WHITE);
		panel_roomlist.setBounds(250, 50, 771, 668);
		frmHotelBookingSystem.getContentPane().add(panel_roomlist);
		panel_roomlist.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(91, 26, 46, 20);
		panel_roomlist.add(comboBox);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		
		JButton btn_checkin_00 = new JButton("Check in");
		btn_checkin_00.setBounds(26, 177, 209, 23);
		panel_roomlist.add(btn_checkin_00);
		btn_checkin_00.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblFloor = new JLabel("Floor : ");
		lblFloor.setBounds(26, 26, 59, 20);
		panel_roomlist.add(lblFloor);
		lblFloor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFloor.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblType = new JLabel("Type :");
		lblType.setBounds(155, 26, 57, 20);
		panel_roomlist.add(lblType);
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblType.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lbltype = new JLabel("[TYPE]");
		lbltype.setBounds(222, 26, 143, 20);
		panel_roomlist.add(lbltype);
		lbltype.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblRoomId_00 = new JLabel("Room ID : ");
		lblRoomId_00.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRoomId_00.setBounds(26, 74, 94, 20);
		panel_roomlist.add(lblRoomId_00);
		lblRoomId_00.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblBed_00 = new JLabel("Bed : ");
		lblBed_00.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBed_00.setBounds(26, 99, 94, 20);
		panel_roomlist.add(lblBed_00);
		lblBed_00.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblPrice_00 = new JLabel("Price : ");
		lblPrice_00.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrice_00.setBounds(26, 124, 94, 20);
		panel_roomlist.add(lblPrice_00);
		lblPrice_00.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblStatus_00 = new JLabel("Status : ");
		lblStatus_00.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStatus_00.setBounds(26, 149, 94, 20);
		panel_roomlist.add(lblStatus_00);
		lblStatus_00.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblroomid_get_00 = new JLabel("[ROOMID]");
		lblroomid_get_00.setBounds(121, 74, 114, 20);
		panel_roomlist.add(lblroomid_get_00);
		lblroomid_get_00.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblbedtype_get_00 = new JLabel("[BEDTYPE]");
		lblbedtype_get_00.setBounds(121, 99, 114, 20);
		panel_roomlist.add(lblbedtype_get_00);
		lblbedtype_get_00.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblprice_get_00 = new JLabel("[PRICE]");
		lblprice_get_00.setBounds(121, 124, 114, 20);
		panel_roomlist.add(lblprice_get_00);
		lblprice_get_00.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblstatus_get_00 = new JLabel("[STATUS]");
		lblstatus_get_00.setBounds(121, 149, 114, 20);
		panel_roomlist.add(lblstatus_get_00);
		lblstatus_get_00.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JPanel panel_title = new JPanel();
		panel_title.setLayout(null);
		panel_title.setBackground(new Color(124, 180, 212));
		panel_title.setBounds(250, 0, 500, 50);
		frmHotelBookingSystem.getContentPane().add(panel_title);
		
		JLabel lblHotelBookingSystem = new JLabel("Hotel Booking System");
		lblHotelBookingSystem.setBounds(0, 0, 500, 50);
		panel_title.add(lblHotelBookingSystem);
		lblHotelBookingSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblHotelBookingSystem.setForeground(Color.BLACK);
		lblHotelBookingSystem.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JPanel panel_useracc = new JPanel();
		panel_useracc.setLayout(null);
		panel_useracc.setBackground(Color.BLACK);
		panel_useracc.setBounds(750, 0, 271, 50);
		frmHotelBookingSystem.getContentPane().add(panel_useracc);
		
		JLabel lblWelcome = new JLabel("Welcome :");
		lblWelcome.setBounds(0, 0, 122, 50);
		panel_useracc.add(lblWelcome);
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblusername = new JLabel("[username]");
		lblusername.setBounds(108, 0, 163, 50);
		panel_useracc.add(lblusername);
		lblusername.setHorizontalAlignment(SwingConstants.LEFT);
		lblusername.setForeground(Color.WHITE);
		lblusername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.scrollbar);
		panel.setBounds(0, 0, 250, 250);
		frmHotelBookingSystem.getContentPane().add(panel);
	}
}
