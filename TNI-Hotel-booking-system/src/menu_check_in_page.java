
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class menu_check_in_page {

	private JFrame frmHotelBookingSystem;
	private JLabel imgbanner;

	/**
	 * Launch the application.
	 */
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// เปลี่ยนธีม java เป็นแบบ windows
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					menu_check_in_page window = new menu_check_in_page();
					window.frmHotelBookingSystem.setVisible(true);
					window.frmHotelBookingSystem.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public menu_check_in_page() {
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
		mntmAddCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customer_information_page customer = new customer_information_page();
				customer.NewScreen();
			}
		});
		mnCustomer.add(mntmAddCustomer);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Develop by:" + "\n 60121002-4 Sec.2 Yossapon Jantarote"
								+ "\n 60121053-7 Sec.2 Danupol Intranurux" + "\n 60121045-3 Sec.1 Thanapat Chanprasert"
								+ "\n 60121075-0 Sec.2 Prachya Khongwichayakupe",
						"About", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnHelp.add(mntmAbout);
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

		JLabel lbltotalroom = new JLabel("[TOTALROOM]");
		lbltotalroom.setHorizontalAlignment(SwingConstants.RIGHT);
		lbltotalroom.setBounds(25, 290, 117, 23);
		panel_roomlist_sum.add(lbltotalroom);
		lbltotalroom.setFont(new Font("Tahoma", Font.PLAIN, 18));

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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// เปลี่ยนรูปภาพ
				imgbanner.setIcon(new ImageIcon(this.getClass().getResource("banner02.jpg")));
				payment_summary_page summary = new payment_summary_page();
				summary.NewScreen();
				frmHotelBookingSystem.setVisible(false);

			}
		});
		btnNewButton.setBounds(25, 377, 198, 31);
		panel_roomlist_sum.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JPanel panel_roomlist = new JPanel();
		panel_roomlist.setBackground(Color.WHITE);
		panel_roomlist.setBounds(250, 50, 771, 668);
		frmHotelBookingSystem.getContentPane().add(panel_roomlist);
		panel_roomlist.setLayout(null);

		JPanel panel_banner = new JPanel();
		panel_banner.setBackground(Color.WHITE);
		panel_banner.setBounds(0, 0, 771, 304);
		panel_roomlist.add(panel_banner);
		panel_banner.setLayout(null);

		imgbanner = new JLabel("");
		imgbanner.setHorizontalAlignment(SwingConstants.CENTER);
		imgbanner.setIcon(new ImageIcon(this.getClass().getResource("banner01.jpg")));
		imgbanner.setBounds(0, 0, 771, 304);
		panel_banner.add(imgbanner);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(90, 315, 46, 20);
		panel_roomlist.add(comboBox);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));

		JButton btn_checkin_01 = new JButton("Check in");
		btn_checkin_01.setBounds(25, 466, 209, 23);
		panel_roomlist.add(btn_checkin_01);
		btn_checkin_01.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblFloor = new JLabel("Floor : ");
		lblFloor.setBounds(25, 315, 59, 20);
		panel_roomlist.add(lblFloor);
		lblFloor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFloor.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblType = new JLabel("Type :");
		lblType.setBounds(154, 315, 57, 20);
		panel_roomlist.add(lblType);
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblType.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lbltype = new JLabel("[TYPE]");
		lbltype.setBounds(221, 315, 143, 20);
		panel_roomlist.add(lbltype);
		lbltype.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblRoomId_01 = new JLabel("Room ID : ");
		lblRoomId_01.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRoomId_01.setBounds(25, 363, 94, 20);
		panel_roomlist.add(lblRoomId_01);
		lblRoomId_01.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblBed_01 = new JLabel("Bed : ");
		lblBed_01.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBed_01.setBounds(25, 388, 94, 20);
		panel_roomlist.add(lblBed_01);
		lblBed_01.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblPrice_01 = new JLabel("Price : ");
		lblPrice_01.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrice_01.setBounds(25, 413, 94, 20);
		panel_roomlist.add(lblPrice_01);
		lblPrice_01.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblStatus_01 = new JLabel("Status : ");
		lblStatus_01.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStatus_01.setBounds(25, 438, 94, 20);
		panel_roomlist.add(lblStatus_01);
		lblStatus_01.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblroomid_get_01 = new JLabel("[ROOMID]");
		lblroomid_get_01.setBounds(120, 363, 114, 20);
		panel_roomlist.add(lblroomid_get_01);
		lblroomid_get_01.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblbedtype_get_01 = new JLabel("[BEDTYPE]");
		lblbedtype_get_01.setBounds(120, 388, 114, 20);
		panel_roomlist.add(lblbedtype_get_01);
		lblbedtype_get_01.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblprice_get_01 = new JLabel("[PRICE]");
		lblprice_get_01.setBounds(120, 413, 114, 20);
		panel_roomlist.add(lblprice_get_01);
		lblprice_get_01.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblstatus_get_01 = new JLabel("[STATUS]");
		lblstatus_get_01.setBounds(120, 438, 114, 20);
		panel_roomlist.add(lblstatus_get_01);
		lblstatus_get_01.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btn_checkin_02 = new JButton("Check in");
		btn_checkin_02.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_checkin_02.setBounds(279, 466, 209, 23);
		panel_roomlist.add(btn_checkin_02);

		JLabel lblRoomId_02 = new JLabel("Room ID : ");
		lblRoomId_02.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRoomId_02.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRoomId_02.setBounds(279, 363, 94, 20);
		panel_roomlist.add(lblRoomId_02);

		JLabel lblBed_02 = new JLabel("Bed : ");
		lblBed_02.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBed_02.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBed_02.setBounds(279, 388, 94, 20);
		panel_roomlist.add(lblBed_02);

		JLabel lblPrice_02 = new JLabel("Price : ");
		lblPrice_02.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrice_02.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPrice_02.setBounds(279, 413, 94, 20);
		panel_roomlist.add(lblPrice_02);

		JLabel lblStatus_02 = new JLabel("Status : ");
		lblStatus_02.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStatus_02.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStatus_02.setBounds(279, 438, 94, 20);
		panel_roomlist.add(lblStatus_02);

		JLabel lblroomid_get_02 = new JLabel("[ROOMID]");
		lblroomid_get_02.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblroomid_get_02.setBounds(374, 363, 114, 20);
		panel_roomlist.add(lblroomid_get_02);

		JLabel lblbedtype_get_02 = new JLabel("[BEDTYPE]");
		lblbedtype_get_02.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblbedtype_get_02.setBounds(374, 388, 114, 20);
		panel_roomlist.add(lblbedtype_get_02);

		JLabel lblprice_get_02 = new JLabel("[PRICE]");
		lblprice_get_02.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblprice_get_02.setBounds(374, 413, 114, 20);
		panel_roomlist.add(lblprice_get_02);

		JLabel lblstatus_get_02 = new JLabel("[STATUS]");
		lblstatus_get_02.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblstatus_get_02.setBounds(374, 438, 114, 20);
		panel_roomlist.add(lblstatus_get_02);

		JButton btn_checkin_03 = new JButton("Check in");
		btn_checkin_03.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_checkin_03.setBounds(529, 466, 209, 23);
		panel_roomlist.add(btn_checkin_03);

		JLabel lblRoomId_03 = new JLabel("Room ID : ");
		lblRoomId_03.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRoomId_03.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRoomId_03.setBounds(529, 363, 94, 20);
		panel_roomlist.add(lblRoomId_03);

		JLabel lblBed_03 = new JLabel("Bed : ");
		lblBed_03.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBed_03.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBed_03.setBounds(529, 388, 94, 20);
		panel_roomlist.add(lblBed_03);

		JLabel lblPrice_03 = new JLabel("Price : ");
		lblPrice_03.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrice_03.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPrice_03.setBounds(529, 413, 94, 20);
		panel_roomlist.add(lblPrice_03);

		JLabel lblStatus_03 = new JLabel("Status : ");
		lblStatus_03.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStatus_03.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStatus_03.setBounds(529, 438, 94, 20);
		panel_roomlist.add(lblStatus_03);

		JLabel lblroomid_get_03 = new JLabel("[ROOMID]");
		lblroomid_get_03.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblroomid_get_03.setBounds(624, 363, 114, 20);
		panel_roomlist.add(lblroomid_get_03);

		JLabel lblbedtype_get_03 = new JLabel("[BEDTYPE]");
		lblbedtype_get_03.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblbedtype_get_03.setBounds(624, 388, 114, 20);
		panel_roomlist.add(lblbedtype_get_03);

		JLabel lblprice_get_03 = new JLabel("[PRICE]");
		lblprice_get_03.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblprice_get_03.setBounds(624, 413, 114, 20);
		panel_roomlist.add(lblprice_get_03);

		JLabel lblstatus_get_03 = new JLabel("[STATUS]");
		lblstatus_get_03.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblstatus_get_03.setBounds(624, 438, 114, 20);
		panel_roomlist.add(lblstatus_get_03);

		JButton btn_checkin_04 = new JButton("Check in");
		btn_checkin_04.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_checkin_04.setBounds(25, 603, 209, 23);
		panel_roomlist.add(btn_checkin_04);

		JLabel lblRoomId_04 = new JLabel("Room ID : ");
		lblRoomId_04.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRoomId_04.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRoomId_04.setBounds(25, 500, 94, 20);
		panel_roomlist.add(lblRoomId_04);

		JLabel lblBed_04 = new JLabel("Bed : ");
		lblBed_04.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBed_04.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBed_04.setBounds(25, 525, 94, 20);
		panel_roomlist.add(lblBed_04);

		JLabel lblPrice_04 = new JLabel("Price : ");
		lblPrice_04.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrice_04.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPrice_04.setBounds(25, 550, 94, 20);
		panel_roomlist.add(lblPrice_04);

		JLabel lblStatus_04 = new JLabel("Status : ");
		lblStatus_04.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStatus_04.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStatus_04.setBounds(25, 575, 94, 20);
		panel_roomlist.add(lblStatus_04);

		JLabel lblroomid_get_04 = new JLabel("[ROOMID]");
		lblroomid_get_04.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblroomid_get_04.setBounds(120, 500, 114, 20);
		panel_roomlist.add(lblroomid_get_04);

		JLabel lblbedtype_get_04 = new JLabel("[BEDTYPE]");
		lblbedtype_get_04.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblbedtype_get_04.setBounds(120, 525, 114, 20);
		panel_roomlist.add(lblbedtype_get_04);

		JLabel lblprice_get_04 = new JLabel("[PRICE]");
		lblprice_get_04.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblprice_get_04.setBounds(120, 550, 114, 20);
		panel_roomlist.add(lblprice_get_04);

		JLabel lblstatus_get_04 = new JLabel("[STATUS]");
		lblstatus_get_04.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblstatus_get_04.setBounds(120, 575, 114, 20);
		panel_roomlist.add(lblstatus_get_04);

		JButton btn_checkin_05 = new JButton("Check in");
		btn_checkin_05.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_checkin_05.setBounds(279, 603, 209, 23);
		panel_roomlist.add(btn_checkin_05);

		JLabel lblRoomId_05 = new JLabel("Room ID : ");
		lblRoomId_05.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRoomId_05.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRoomId_05.setBounds(279, 500, 94, 20);
		panel_roomlist.add(lblRoomId_05);

		JLabel lblBed_05 = new JLabel("Bed : ");
		lblBed_05.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBed_05.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBed_05.setBounds(279, 525, 94, 20);
		panel_roomlist.add(lblBed_05);

		JLabel lblPrice_05 = new JLabel("Price : ");
		lblPrice_05.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrice_05.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPrice_05.setBounds(279, 550, 94, 20);
		panel_roomlist.add(lblPrice_05);

		JLabel lblStatus_05 = new JLabel("Status : ");
		lblStatus_05.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStatus_05.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStatus_05.setBounds(279, 575, 94, 20);
		panel_roomlist.add(lblStatus_05);

		JLabel lblroomid_get_05 = new JLabel("[ROOMID]");
		lblroomid_get_05.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblroomid_get_05.setBounds(374, 500, 114, 20);
		panel_roomlist.add(lblroomid_get_05);

		JLabel lblbedtype_get_05 = new JLabel("[BEDTYPE]");
		lblbedtype_get_05.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblbedtype_get_05.setBounds(374, 525, 114, 20);
		panel_roomlist.add(lblbedtype_get_05);

		JLabel lblprice_get_05 = new JLabel("[PRICE]");
		lblprice_get_05.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblprice_get_05.setBounds(374, 550, 114, 20);
		panel_roomlist.add(lblprice_get_05);

		JLabel lblstatus_get_05 = new JLabel("[STATUS]");
		lblstatus_get_05.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblstatus_get_05.setBounds(374, 575, 114, 20);
		panel_roomlist.add(lblstatus_get_05);

		JButton btn_checkin_06 = new JButton("Check in");
		btn_checkin_06.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_checkin_06.setBounds(529, 603, 209, 23);
		panel_roomlist.add(btn_checkin_06);

		JLabel lblRoomId_06 = new JLabel("Room ID : ");
		lblRoomId_06.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRoomId_06.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRoomId_06.setBounds(529, 500, 94, 20);
		panel_roomlist.add(lblRoomId_06);

		JLabel lblBed_06 = new JLabel("Bed : ");
		lblBed_06.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBed_06.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBed_06.setBounds(529, 525, 94, 20);
		panel_roomlist.add(lblBed_06);

		JLabel lblPrice_06 = new JLabel("Price : ");
		lblPrice_06.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrice_06.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPrice_06.setBounds(529, 550, 94, 20);
		panel_roomlist.add(lblPrice_06);

		JLabel lblStatus_06 = new JLabel("Status : ");
		lblStatus_06.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStatus_06.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStatus_06.setBounds(529, 575, 94, 20);
		panel_roomlist.add(lblStatus_06);

		JLabel lblroomid_get_06 = new JLabel("[ROOMID]");
		lblroomid_get_06.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblroomid_get_06.setBounds(624, 500, 114, 20);
		panel_roomlist.add(lblroomid_get_06);

		JLabel lblbedtype_get_06 = new JLabel("[BEDTYPE]");
		lblbedtype_get_06.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblbedtype_get_06.setBounds(624, 525, 114, 20);
		panel_roomlist.add(lblbedtype_get_06);

		JLabel lblprice_get_06 = new JLabel("[PRICE]");
		lblprice_get_06.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblprice_get_06.setBounds(624, 550, 114, 20);
		panel_roomlist.add(lblprice_get_06);

		JLabel lblstatus_get_06 = new JLabel("[STATUS]");
		lblstatus_get_06.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblstatus_get_06.setBounds(624, 575, 114, 20);
		panel_roomlist.add(lblstatus_get_06);

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
