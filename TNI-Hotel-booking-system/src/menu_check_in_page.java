
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
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class menu_check_in_page {

	private JFrame frmHotelBookingSystem;
	private JLabel imgbanner;
	private JComboBox comboBox;
	private JLabel lbltype;
	// USERNAME Display.
	private String username;
	// Room Service
	private JLabel[] lblroomid_get_room = new JLabel[6];
	private JLabel[] lblbedtype_get_type = new JLabel[6];
	private JLabel[] lblprice_get_price = new JLabel[6];
	private JLabel[] lblstatus_get_status = new JLabel[6];
	// End Room service

	/**
	 * Launch the application.
	 */
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// ����¹��� java ��Ẻ windows
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					menu_check_in_page window = new menu_check_in_page(username);
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
	public menu_check_in_page(String username) {
		this.username = username;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHotelBookingSystem = new JFrame();
		frmHotelBookingSystem.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent evt) {
				lbltype.setText("Normal");
				Room(100, 500);

			}
		});
		frmHotelBookingSystem
				.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("icon1.png")));
		frmHotelBookingSystem.setResizable(false);
		frmHotelBookingSystem.setTitle("Hotel Booking System");
		frmHotelBookingSystem.setBounds(100, 100, 1024, 768);
		frmHotelBookingSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Room service
		// End Room service

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
								+ "\n 60121045-3 Sec.1 Thanapat Chanprasert" + "\n 60121053-7 Sec.2 Danupol Intranurux"
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
				// ����¹�ٻ�Ҿ
				imgbanner.setIcon(new ImageIcon(this.getClass().getResource("banner02.jpg")));
				payment_summary_page summary = new payment_summary_page(0.0,username);
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

		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (comboBox.getSelectedIndex() == 0) {
					lbltype.setText("Normal");
					Room(100, 500);
				}
				if (comboBox.getSelectedIndex() == 1) {
					lbltype.setText("Normal");
					Room(200, 500);
				}
				if (comboBox.getSelectedIndex() == 2) {
					lbltype.setText("VIP");
					Room(300, 1500);
				}
				if (comboBox.getSelectedIndex() == 3) {
					lbltype.setText("VIP");
					Room(400, 1500);
				}
				if (comboBox.getSelectedIndex() == 4) {
					lbltype.setText("Deluxe");
					Room(500, 15000);
				}
			}
		});
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

		lbltype = new JLabel("[TYPE]");
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

		lblroomid_get_room[0] = new JLabel("[ROOMID]");
		lblroomid_get_room[0].setBounds(120, 363, 114, 20);
		panel_roomlist.add(lblroomid_get_room[0]);
		lblroomid_get_room[0].setFont(new Font("Tahoma", Font.PLAIN, 18));

		lblbedtype_get_type[0] = new JLabel("[BEDTYPE]");
		lblbedtype_get_type[0].setBounds(120, 388, 114, 20);
		panel_roomlist.add(lblbedtype_get_type[0]);
		lblbedtype_get_type[0].setFont(new Font("Tahoma", Font.PLAIN, 18));

		lblprice_get_price[0] = new JLabel("[PRICE]");
		lblprice_get_price[0].setBounds(120, 413, 114, 20);
		panel_roomlist.add(lblprice_get_price[0]);
		lblprice_get_price[0].setFont(new Font("Tahoma", Font.PLAIN, 18));

		lblstatus_get_status[0] = new JLabel("[STATUS]");
		lblstatus_get_status[0].setBounds(120, 438, 114, 20);
		panel_roomlist.add(lblstatus_get_status[0]);
		lblstatus_get_status[0].setFont(new Font("Tahoma", Font.PLAIN, 18));

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

		lblroomid_get_room[1] = new JLabel("[ROOMID]");
		lblroomid_get_room[1].setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblroomid_get_room[1].setBounds(374, 363, 114, 20);
		panel_roomlist.add(lblroomid_get_room[1]);

		lblbedtype_get_type[1] = new JLabel("[BEDTYPE]");
		lblbedtype_get_type[1].setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblbedtype_get_type[1].setBounds(374, 388, 114, 20);
		panel_roomlist.add(lblbedtype_get_type[1]);

		lblprice_get_price[1] = new JLabel("[PRICE]");
		lblprice_get_price[1].setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblprice_get_price[1].setBounds(374, 413, 114, 20);
		panel_roomlist.add(lblprice_get_price[1]);

		lblstatus_get_status[1] = new JLabel("[STATUS]");
		lblstatus_get_status[1].setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblstatus_get_status[1].setBounds(374, 438, 114, 20);
		panel_roomlist.add(lblstatus_get_status[1]);

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

		lblroomid_get_room[2] = new JLabel("[ROOMID]");
		lblroomid_get_room[2].setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblroomid_get_room[2].setBounds(624, 363, 114, 20);
		panel_roomlist.add(lblroomid_get_room[2]);

		lblbedtype_get_type[2] = new JLabel("[BEDTYPE]");
		lblbedtype_get_type[2].setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblbedtype_get_type[2].setBounds(624, 388, 114, 20);
		panel_roomlist.add(lblbedtype_get_type[2]);

		lblprice_get_price[2] = new JLabel("[PRICE]");
		lblprice_get_price[2].setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblprice_get_price[2].setBounds(624, 413, 114, 20);
		panel_roomlist.add(lblprice_get_price[2]);

		lblstatus_get_status[2] = new JLabel("[STATUS]");
		lblstatus_get_status[2].setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblstatus_get_status[2].setBounds(624, 438, 114, 20);
		panel_roomlist.add(lblstatus_get_status[2]);

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

		lblroomid_get_room[3] = new JLabel("[ROOMID]");
		lblroomid_get_room[3].setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblroomid_get_room[3].setBounds(120, 500, 114, 20);
		panel_roomlist.add(lblroomid_get_room[3]);

		lblbedtype_get_type[3] = new JLabel("[BEDTYPE]");
		lblbedtype_get_type[3].setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblbedtype_get_type[3].setBounds(120, 525, 114, 20);
		panel_roomlist.add(lblbedtype_get_type[3]);

		lblprice_get_price[3] = new JLabel("[PRICE]");
		lblprice_get_price[3].setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblprice_get_price[3].setBounds(120, 550, 114, 20);
		panel_roomlist.add(lblprice_get_price[3]);

		lblstatus_get_status[3] = new JLabel("[STATUS]");
		lblstatus_get_status[3].setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblstatus_get_status[3].setBounds(120, 575, 114, 20);
		panel_roomlist.add(lblstatus_get_status[3]);

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

		lblroomid_get_room[4] = new JLabel("[ROOMID]");
		lblroomid_get_room[4].setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblroomid_get_room[4].setBounds(374, 500, 114, 20);
		panel_roomlist.add(lblroomid_get_room[4]);

		lblbedtype_get_type[4] = new JLabel("[BEDTYPE]");
		lblbedtype_get_type[4].setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblbedtype_get_type[4].setBounds(374, 525, 114, 20);
		panel_roomlist.add(lblbedtype_get_type[4]);

		lblprice_get_price[4] = new JLabel("[PRICE]");
		lblprice_get_price[4].setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblprice_get_price[4].setBounds(374, 550, 114, 20);
		panel_roomlist.add(lblprice_get_price[4]);

		lblstatus_get_status[4] = new JLabel("[STATUS]");
		lblstatus_get_status[4].setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblstatus_get_status[4].setBounds(374, 575, 114, 20);
		panel_roomlist.add(lblstatus_get_status[4]);

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

		lblroomid_get_room[5] = new JLabel("[ROOMID]");
		lblroomid_get_room[5].setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblroomid_get_room[5].setBounds(624, 500, 114, 20);
		panel_roomlist.add(lblroomid_get_room[5]);

		lblbedtype_get_type[5] = new JLabel("[BEDTYPE]");
		lblbedtype_get_type[5].setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblbedtype_get_type[5].setBounds(624, 525, 114, 20);
		panel_roomlist.add(lblbedtype_get_type[5]);

		lblprice_get_price[5] = new JLabel("[PRICE]");
		lblprice_get_price[5].setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblprice_get_price[5].setBounds(624, 550, 114, 20);
		panel_roomlist.add(lblprice_get_price[5]);

		lblstatus_get_status[5] = new JLabel("[STATUS]");
		lblstatus_get_status[5].setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblstatus_get_status[5].setBounds(624, 575, 114, 20);
		panel_roomlist.add(lblstatus_get_status[5]);

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

		JLabel lblusername = new JLabel(this.username);
		lblusername.setBounds(108, 0, 163, 50);
		panel_useracc.add(lblusername);
		lblusername.setHorizontalAlignment(SwingConstants.LEFT);
		lblusername.setForeground(Color.WHITE);
		lblusername.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JPanel panel_icon = new JPanel();
		panel_icon.setBackground(SystemColor.scrollbar);
		panel_icon.setBounds(0, 0, 250, 250);
		frmHotelBookingSystem.getContentPane().add(panel_icon);
		panel_icon.setLayout(null);

		JLabel icon_hotel = new JLabel("");
		icon_hotel.setIcon(new ImageIcon(this.getClass().getResource("main_icon.png")));
		icon_hotel.setBounds(0, 0, 250, 250);
		panel_icon.add(icon_hotel);
	}

	private void Room(int room, double price) {
		DecimalFormat frm = new DecimalFormat("#,##0.00");
		int RoomSize = 6;
		String[] RoomID = new String[RoomSize];
		String[] BedType = new String[RoomSize];
		double[] Price = new double[RoomSize];
		String[] Status = new String[RoomSize];

		for (int i = 0; i < RoomSize; i++) {
			RoomID[i] = "" + (room + (i + 1));
			BedType[i] = "Double";
			Price[i] = price;
			Status[i] = "ready";
		}
		for (int i = 0; i < RoomSize; i++) {
			lblroomid_get_room[i].setText(RoomID[i]);
			lblbedtype_get_type[i].setText(BedType[i]);
			lblprice_get_price[i].setText(frm.format(Price[i]));
			lblstatus_get_status[i].setText(Status[i]);
		}

	}
}
