
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
import javax.swing.ButtonGroup;
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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;

public class main_hotel_page {

	private int RoomSize = 6;

	private JFrame frmHotelBookingSystem;
	private JLabel imgbanner;
	private JLabel lbltype;
	// USERNAME Display.
	private String username;
	// Format
	private DecimalFormat frm = new DecimalFormat("#,##0.00");
	// ***Room Service***
	private JLabel[] lblroomid_get_room = new JLabel[RoomSize];
	private JLabel[] lblbedtype_get_type = new JLabel[RoomSize];
	private JLabel[] lblprice_get_price = new JLabel[RoomSize];
	private JLabel[] lblstatus_get_status = new JLabel[RoomSize];
	private JButton[] btn_action = new JButton[RoomSize];
	private int[] Status = new int[RoomSize];
	//// File Reader Service
	String[] RoomID;
	String[] BedType;
	double[] Price;
	//// Action Button zone
	private JLabel lblTotalRoom_get;
	private JLabel lblTotalPrice_get;
	private ArrayList<String> RoomList = new ArrayList<String>();
	private ArrayList<Double> RoomPrice = new ArrayList<Double>();
	private Double TotalPrice;
	private int TotalRoom;

	//// Operation Text for Display
	private JLabel lbloperationmode_text;

	private JRadioButton rdbtnCheckIn;
	private JRadioButton rdbtnCheckOut;
	private JRadioButtonMenuItem rdbtnmntmMaintenance;
	private JButton btnContinue;
	private String fileroom;
	// ***End Room service***

	/**
	 * Launch the application.
	 */
	public void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					main_hotel_page window = new main_hotel_page(username);
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
	public main_hotel_page(String username) {
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
			public void windowOpened(WindowEvent e) {
				TotalPrice = 0.0;
				TotalRoom = 0;
				lblTotalRoom_get.setText(String.valueOf(TotalRoom));
				lblTotalPrice_get.setText(frm.format(TotalPrice));
				lbltype.setText("Standard");
				ReadRoom("F1");
				if (rdbtnCheckIn.isSelected()) {
					OperationMode();
				}
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

		JMenu mnRoom = new JMenu("Room");
		menuBar.add(mnRoom);

		JMenuItem mntmAddCustomer = new JMenuItem("Manage");
		mntmAddCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new customer_information_page().NewScreen();
			}
		});

		rdbtnmntmMaintenance = new JRadioButtonMenuItem("Maintenance");
		rdbtnmntmMaintenance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OperationMode();
			}
		});
		mnRoom.add(rdbtnmntmMaintenance);
		mnRoom.add(mntmAddCustomer);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new about_page().newScreen();
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

		lblTotalRoom_get = new JLabel("[TOTALROOM]");
		lblTotalRoom_get.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalRoom_get.setBounds(25, 290, 117, 23);
		panel_roomlist_sum.add(lblTotalRoom_get);
		lblTotalRoom_get.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblRooms = new JLabel("Room(s)");
		lblRooms.setBounds(152, 290, 71, 23);
		panel_roomlist_sum.add(lblRooms);
		lblRooms.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblBaht = new JLabel("Baht.");
		lblBaht.setBounds(152, 315, 46, 23);
		panel_roomlist_sum.add(lblBaht);
		lblBaht.setFont(new Font("Tahoma", Font.PLAIN, 18));

		lblTotalPrice_get = new JLabel("[TOTALPRICE]");
		lblTotalPrice_get.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalPrice_get.setBounds(25, 315, 117, 23);
		panel_roomlist_sum.add(lblTotalPrice_get);
		lblTotalPrice_get.setFont(new Font("Tahoma", Font.PLAIN, 18));

		btnContinue = new JButton("Pay");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnCheckIn.isSelected()) {
					btnContinue.setEnabled(false);
					new payment_summary_page(TotalPrice, 0, username).NewScreen();
					frmHotelBookingSystem.setVisible(false);
				}
				if (rdbtnCheckOut.isSelected()) {
					System.out.println("Check out!");
				}
				if (rdbtnmntmMaintenance.isSelected()) {
					rdbtnCheckIn.setSelected(true);
					OperationMode();
					ReadRoom(fileroom);
				}

			}
		});
		btnContinue.setBounds(25, 377, 198, 31);
		panel_roomlist_sum.add(btnContinue);
		btnContinue.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JPanel panel_roomlist = new JPanel();
		panel_roomlist.setBackground(Color.WHITE);
		panel_roomlist.setBounds(250, 50, 771, 668);
		frmHotelBookingSystem.getContentPane().add(panel_roomlist);
		panel_roomlist.setLayout(null);

		JPanel panel_banner = new JPanel();
		panel_banner.setBackground(Color.WHITE);
		panel_banner.setBounds(0, 0, 771, 200);
		panel_roomlist.add(panel_banner);
		panel_banner.setLayout(null);

		imgbanner = new JLabel("");
		imgbanner.setHorizontalAlignment(SwingConstants.CENTER);
		imgbanner.setIcon(new ImageIcon(this.getClass().getResource("room01.jpg")));
		imgbanner.setBounds(0, 0, 771, 200);
		panel_banner.add(imgbanner);

		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (comboBox.getSelectedIndex() == 0) {
					lbltype.setText("Standard");
					imgbanner.setIcon(new ImageIcon(this.getClass().getResource("room01.jpg")));
					fileroom = "F1";
					ReadRoom(fileroom);
				}
				if (comboBox.getSelectedIndex() == 1) {
					lbltype.setText("Standard");
					imgbanner.setIcon(new ImageIcon(this.getClass().getResource("room01.jpg")));
					fileroom = "F2";
					ReadRoom(fileroom);
				}
				if (comboBox.getSelectedIndex() == 2) {
					lbltype.setText("Superior");
					imgbanner.setIcon(new ImageIcon(this.getClass().getResource("room02.jpg")));
					fileroom = "F3";
					ReadRoom(fileroom);
				}
				if (comboBox.getSelectedIndex() == 3) {
					lbltype.setText("Superior");
					imgbanner.setIcon(new ImageIcon(this.getClass().getResource("room02.jpg")));
					fileroom = "F4";
					ReadRoom(fileroom);
				}
				if (comboBox.getSelectedIndex() == 4) {
					lbltype.setText("Deluxe");
					imgbanner.setIcon(new ImageIcon(this.getClass().getResource("room03.jpg")));
					fileroom = "F5";
					ReadRoom(fileroom);
				}
			}
		});
		comboBox.setBounds(90, 215, 46, 20);
		panel_roomlist.add(comboBox);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));

		btn_action[0] = new JButton("Check in");
		btn_action[0].setBounds(25, 391, 209, 23);
		panel_roomlist.add(btn_action[0]);
		btn_action[0].setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_action[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RoomService(RoomID[0], Price[0]);
			}
		});

		JLabel lblFloor = new JLabel("Floor : ");
		lblFloor.setBounds(25, 215, 59, 20);
		panel_roomlist.add(lblFloor);
		lblFloor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFloor.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblType = new JLabel("Type :");
		lblType.setBounds(154, 215, 57, 20);
		panel_roomlist.add(lblType);
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblType.setHorizontalAlignment(SwingConstants.RIGHT);

		lbltype = new JLabel("[TYPE]");
		lbltype.setBounds(221, 215, 143, 20);
		panel_roomlist.add(lbltype);
		lbltype.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblRoomId_01 = new JLabel("Room ID : ");
		lblRoomId_01.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRoomId_01.setBounds(25, 288, 94, 20);
		panel_roomlist.add(lblRoomId_01);
		lblRoomId_01.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblBed_01 = new JLabel("Bed : ");
		lblBed_01.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBed_01.setBounds(25, 313, 94, 20);
		panel_roomlist.add(lblBed_01);
		lblBed_01.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblPrice_01 = new JLabel("Price : ");
		lblPrice_01.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrice_01.setBounds(25, 338, 94, 20);
		panel_roomlist.add(lblPrice_01);
		lblPrice_01.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblStatus_01 = new JLabel("Status : ");
		lblStatus_01.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStatus_01.setBounds(25, 363, 94, 20);
		panel_roomlist.add(lblStatus_01);
		lblStatus_01.setFont(new Font("Tahoma", Font.PLAIN, 18));

		lblroomid_get_room[0] = new JLabel("[ROOMID]");
		lblroomid_get_room[0].setBounds(120, 288, 114, 20);
		panel_roomlist.add(lblroomid_get_room[0]);
		lblroomid_get_room[0].setFont(new Font("Tahoma", Font.PLAIN, 18));

		lblbedtype_get_type[0] = new JLabel("[BEDTYPE]");
		lblbedtype_get_type[0].setBounds(120, 313, 114, 20);
		panel_roomlist.add(lblbedtype_get_type[0]);
		lblbedtype_get_type[0].setFont(new Font("Tahoma", Font.PLAIN, 18));

		lblprice_get_price[0] = new JLabel("[PRICE]");
		lblprice_get_price[0].setBounds(120, 338, 114, 20);
		panel_roomlist.add(lblprice_get_price[0]);
		lblprice_get_price[0].setFont(new Font("Tahoma", Font.PLAIN, 18));

		lblstatus_get_status[0] = new JLabel("[STATUS]");
		lblstatus_get_status[0].setBounds(120, 363, 114, 20);
		panel_roomlist.add(lblstatus_get_status[0]);
		lblstatus_get_status[0].setFont(new Font("Tahoma", Font.PLAIN, 18));

		btn_action[1] = new JButton("Check in");
		btn_action[1].setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_action[1].setBounds(279, 391, 209, 23);
		panel_roomlist.add(btn_action[1]);
		btn_action[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RoomService(RoomID[1], Price[1]);
			}
		});

		JLabel lblRoomId_02 = new JLabel("Room ID : ");
		lblRoomId_02.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRoomId_02.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRoomId_02.setBounds(279, 288, 94, 20);
		panel_roomlist.add(lblRoomId_02);

		JLabel lblBed_02 = new JLabel("Bed : ");
		lblBed_02.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBed_02.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBed_02.setBounds(279, 313, 94, 20);
		panel_roomlist.add(lblBed_02);

		JLabel lblPrice_02 = new JLabel("Price : ");
		lblPrice_02.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrice_02.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPrice_02.setBounds(279, 338, 94, 20);
		panel_roomlist.add(lblPrice_02);

		JLabel lblStatus_02 = new JLabel("Status : ");
		lblStatus_02.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStatus_02.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStatus_02.setBounds(279, 363, 94, 20);
		panel_roomlist.add(lblStatus_02);

		lblroomid_get_room[1] = new JLabel("[ROOMID]");
		lblroomid_get_room[1].setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblroomid_get_room[1].setBounds(374, 288, 114, 20);
		panel_roomlist.add(lblroomid_get_room[1]);

		lblbedtype_get_type[1] = new JLabel("[BEDTYPE]");
		lblbedtype_get_type[1].setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblbedtype_get_type[1].setBounds(374, 313, 114, 20);
		panel_roomlist.add(lblbedtype_get_type[1]);

		lblprice_get_price[1] = new JLabel("[PRICE]");
		lblprice_get_price[1].setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblprice_get_price[1].setBounds(374, 338, 114, 20);
		panel_roomlist.add(lblprice_get_price[1]);

		lblstatus_get_status[1] = new JLabel("[STATUS]");
		lblstatus_get_status[1].setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblstatus_get_status[1].setBounds(374, 363, 114, 20);
		panel_roomlist.add(lblstatus_get_status[1]);

		btn_action[2] = new JButton("Check in");
		btn_action[2].setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_action[2].setBounds(529, 391, 209, 23);
		panel_roomlist.add(btn_action[2]);
		btn_action[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RoomService(RoomID[2], Price[2]);
			}
		});

		JLabel lblRoomId_03 = new JLabel("Room ID : ");
		lblRoomId_03.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRoomId_03.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRoomId_03.setBounds(529, 288, 94, 20);
		panel_roomlist.add(lblRoomId_03);

		JLabel lblBed_03 = new JLabel("Bed : ");
		lblBed_03.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBed_03.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBed_03.setBounds(529, 313, 94, 20);
		panel_roomlist.add(lblBed_03);

		JLabel lblPrice_03 = new JLabel("Price : ");
		lblPrice_03.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrice_03.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPrice_03.setBounds(529, 338, 94, 20);
		panel_roomlist.add(lblPrice_03);

		JLabel lblStatus_03 = new JLabel("Status : ");
		lblStatus_03.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStatus_03.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStatus_03.setBounds(529, 363, 94, 20);
		panel_roomlist.add(lblStatus_03);

		lblroomid_get_room[2] = new JLabel("[ROOMID]");
		lblroomid_get_room[2].setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblroomid_get_room[2].setBounds(624, 288, 114, 20);
		panel_roomlist.add(lblroomid_get_room[2]);

		lblbedtype_get_type[2] = new JLabel("[BEDTYPE]");
		lblbedtype_get_type[2].setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblbedtype_get_type[2].setBounds(624, 313, 114, 20);
		panel_roomlist.add(lblbedtype_get_type[2]);

		lblprice_get_price[2] = new JLabel("[PRICE]");
		lblprice_get_price[2].setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblprice_get_price[2].setBounds(624, 338, 114, 20);
		panel_roomlist.add(lblprice_get_price[2]);

		lblstatus_get_status[2] = new JLabel("[STATUS]");
		lblstatus_get_status[2].setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblstatus_get_status[2].setBounds(624, 363, 114, 20);
		panel_roomlist.add(lblstatus_get_status[2]);

		btn_action[3] = new JButton("Check in");
		btn_action[3].setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_action[3].setBounds(25, 573, 209, 23);
		panel_roomlist.add(btn_action[3]);
		btn_action[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RoomService(RoomID[3], Price[3]);
			}
		});

		JLabel lblRoomId_04 = new JLabel("Room ID : ");
		lblRoomId_04.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRoomId_04.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRoomId_04.setBounds(25, 470, 94, 20);
		panel_roomlist.add(lblRoomId_04);

		JLabel lblBed_04 = new JLabel("Bed : ");
		lblBed_04.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBed_04.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBed_04.setBounds(25, 495, 94, 20);
		panel_roomlist.add(lblBed_04);

		JLabel lblPrice_04 = new JLabel("Price : ");
		lblPrice_04.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrice_04.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPrice_04.setBounds(25, 520, 94, 20);
		panel_roomlist.add(lblPrice_04);

		JLabel lblStatus_04 = new JLabel("Status : ");
		lblStatus_04.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStatus_04.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStatus_04.setBounds(25, 545, 94, 20);
		panel_roomlist.add(lblStatus_04);

		lblroomid_get_room[3] = new JLabel("[ROOMID]");
		lblroomid_get_room[3].setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblroomid_get_room[3].setBounds(120, 470, 114, 20);
		panel_roomlist.add(lblroomid_get_room[3]);

		lblbedtype_get_type[3] = new JLabel("[BEDTYPE]");
		lblbedtype_get_type[3].setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblbedtype_get_type[3].setBounds(120, 495, 114, 20);
		panel_roomlist.add(lblbedtype_get_type[3]);

		lblprice_get_price[3] = new JLabel("[PRICE]");
		lblprice_get_price[3].setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblprice_get_price[3].setBounds(120, 520, 114, 20);
		panel_roomlist.add(lblprice_get_price[3]);

		lblstatus_get_status[3] = new JLabel("[STATUS]");
		lblstatus_get_status[3].setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblstatus_get_status[3].setBounds(120, 545, 114, 20);
		panel_roomlist.add(lblstatus_get_status[3]);

		btn_action[4] = new JButton("Check in");
		btn_action[4].setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_action[4].setBounds(279, 573, 209, 23);
		panel_roomlist.add(btn_action[4]);
		btn_action[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RoomService(RoomID[4], Price[4]);
			}
		});

		JLabel lblRoomId_05 = new JLabel("Room ID : ");
		lblRoomId_05.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRoomId_05.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRoomId_05.setBounds(279, 470, 94, 20);
		panel_roomlist.add(lblRoomId_05);

		JLabel lblBed_05 = new JLabel("Bed : ");
		lblBed_05.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBed_05.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBed_05.setBounds(279, 495, 94, 20);
		panel_roomlist.add(lblBed_05);

		JLabel lblPrice_05 = new JLabel("Price : ");
		lblPrice_05.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrice_05.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPrice_05.setBounds(279, 520, 94, 20);
		panel_roomlist.add(lblPrice_05);

		JLabel lblStatus_05 = new JLabel("Status : ");
		lblStatus_05.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStatus_05.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStatus_05.setBounds(279, 545, 94, 20);
		panel_roomlist.add(lblStatus_05);

		lblroomid_get_room[4] = new JLabel("[ROOMID]");
		lblroomid_get_room[4].setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblroomid_get_room[4].setBounds(374, 470, 114, 20);
		panel_roomlist.add(lblroomid_get_room[4]);

		lblbedtype_get_type[4] = new JLabel("[BEDTYPE]");
		lblbedtype_get_type[4].setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblbedtype_get_type[4].setBounds(374, 495, 114, 20);
		panel_roomlist.add(lblbedtype_get_type[4]);

		lblprice_get_price[4] = new JLabel("[PRICE]");
		lblprice_get_price[4].setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblprice_get_price[4].setBounds(374, 520, 114, 20);
		panel_roomlist.add(lblprice_get_price[4]);

		lblstatus_get_status[4] = new JLabel("[STATUS]");
		lblstatus_get_status[4].setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblstatus_get_status[4].setBounds(374, 545, 114, 20);
		panel_roomlist.add(lblstatus_get_status[4]);

		btn_action[5] = new JButton("Check in");
		btn_action[5].setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_action[5].setBounds(529, 573, 209, 23);
		panel_roomlist.add(btn_action[5]);
		btn_action[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RoomService(RoomID[5], Price[5]);
			}
		});

		JLabel lblRoomId_06 = new JLabel("Room ID : ");
		lblRoomId_06.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRoomId_06.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRoomId_06.setBounds(529, 470, 94, 20);
		panel_roomlist.add(lblRoomId_06);

		JLabel lblBed_06 = new JLabel("Bed : ");
		lblBed_06.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBed_06.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBed_06.setBounds(529, 495, 94, 20);
		panel_roomlist.add(lblBed_06);

		JLabel lblPrice_06 = new JLabel("Price : ");
		lblPrice_06.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrice_06.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPrice_06.setBounds(529, 520, 94, 20);
		panel_roomlist.add(lblPrice_06);

		JLabel lblStatus_06 = new JLabel("Status : ");
		lblStatus_06.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStatus_06.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStatus_06.setBounds(529, 545, 94, 20);
		panel_roomlist.add(lblStatus_06);

		lblroomid_get_room[5] = new JLabel("[ROOMID]");
		lblroomid_get_room[5].setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblroomid_get_room[5].setBounds(624, 470, 114, 20);
		panel_roomlist.add(lblroomid_get_room[5]);

		lblbedtype_get_type[5] = new JLabel("[BEDTYPE]");
		lblbedtype_get_type[5].setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblbedtype_get_type[5].setBounds(624, 495, 114, 20);
		panel_roomlist.add(lblbedtype_get_type[5]);

		lblprice_get_price[5] = new JLabel("[PRICE]");
		lblprice_get_price[5].setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblprice_get_price[5].setBounds(624, 520, 114, 20);
		panel_roomlist.add(lblprice_get_price[5]);

		lblstatus_get_status[5] = new JLabel("[STATUS]");
		lblstatus_get_status[5].setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblstatus_get_status[5].setBounds(624, 545, 114, 20);
		panel_roomlist.add(lblstatus_get_status[5]);

		JPanel panel_operation = new JPanel();
		panel_operation.setBackground(Color.WHITE);
		panel_operation.setBounds(374, 215, 387, 27);
		panel_roomlist.add(panel_operation);
		panel_operation.setLayout(null);

		JLabel lblOperationMode = new JLabel("Operation Mode :");
		lblOperationMode.setBounds(0, 0, 138, 22);
		panel_operation.add(lblOperationMode);
		lblOperationMode.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOperationMode.setFont(new Font("Tahoma", Font.PLAIN, 18));

		rdbtnCheckIn = new JRadioButton("Check in");
		rdbtnCheckIn.setSelected(true);
		rdbtnCheckIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OperationMode();
			}
		});
		rdbtnCheckIn.setBackground(Color.GREEN);
		rdbtnCheckIn.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnCheckIn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnCheckIn.setBounds(141, 0, 93, 23);
		panel_operation.add(rdbtnCheckIn);

		rdbtnCheckOut = new JRadioButton("Check out");
		rdbtnCheckOut.setForeground(Color.WHITE);
		rdbtnCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OperationMode();
			}
		});
		rdbtnCheckOut.setBackground(Color.RED);
		rdbtnCheckOut.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnCheckOut.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnCheckOut.setBounds(236, 0, 110, 23);
		panel_operation.add(rdbtnCheckOut);

		ButtonGroup Operation = new ButtonGroup();
		Operation.add(rdbtnCheckIn);
		Operation.add(rdbtnCheckOut);
		Operation.add(rdbtnmntmMaintenance);

		lbloperationmode_text = new JLabel("[OPERATION MODE]");
		lbloperationmode_text.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbloperationmode_text.setBounds(141, 1, 205, 20);
		panel_operation.add(lbloperationmode_text);
		Operation.add(rdbtnmntmMaintenance);

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

	public void ReadRoom(String floor) {
		RoomID = new String[RoomSize];
		BedType = new String[RoomSize];
		Price = new double[RoomSize];
		File file = new File(getClass().getClassLoader().getResource("Floor/" + floor + ".txt").getFile());
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line; // Read Data from database
			int i = 0;
			while ((line = br.readLine()) != null) {
				String[] data = line.split(";");
				RoomID[i] = data[0];
				BedType[i] = data[1];
				Price[i] = Double.parseDouble(data[2]);
				Status[i] = Integer.parseInt(data[3]);
				i++;
			}
			br.close();
			for (i = 0; i < RoomSize; i++) {
				switch (Status[i]) {
				// if status 0 = Occupied, 1 = Open, 2 = M/A
				case 0:
					lblstatus_get_status[i].setText("Occupied");
					btn_action[i].setText("Check Out");
					btn_action[i].setBackground(Color.RED);
					btn_action[i].setEnabled(true);
					break;
				case 1:
					lblstatus_get_status[i].setText("Open");
					btn_action[i].setText("Check In");
					btn_action[i].setBackground(Color.GREEN);
					btn_action[i].setEnabled(true);
					break;
				case 2:
					lblstatus_get_status[i].setText("Maintenance");
					btn_action[i].setText("Not available");
					btn_action[i].setBackground(Color.BLACK);
					btn_action[i].setEnabled(false);
					break;
				}
				lblroomid_get_room[i].setText(RoomID[i]);
				lblbedtype_get_type[i].setText(BedType[i]);
				lblprice_get_price[i].setText(frm.format(Price[i]));
				OperationMode();
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "File not found");
		}
	}

	public void OperationMode() {
		if (rdbtnCheckIn.isSelected()) {
			btnContinue.setText("Pay");
			btnContinue.setBackground(Color.GREEN);
			rdbtnCheckIn.setVisible(true);
			rdbtnCheckOut.setVisible(true);
			lbloperationmode_text.setVisible(false);
			for (int i = 0; i < RoomSize; i++) {
				if (Status[i] != 1) {
					btn_action[i].setEnabled(false);
				} else {
					btn_action[i].setEnabled(true);
					btn_action[i].setText("Check In");
				}
			}
		}
		if (rdbtnCheckOut.isSelected()) {
			btnContinue.setText("Done");
			btnContinue.setBackground(Color.RED);
			rdbtnCheckIn.setVisible(true);
			rdbtnCheckOut.setVisible(true);
			lbloperationmode_text.setVisible(false);
			for (int i = 0; i < RoomSize; i++) {
				if (Status[i] != 0) {
					btn_action[i].setEnabled(false);
				} else {
					btn_action[i].setEnabled(true);
					btn_action[i].setText("Check Out");
				}
			}
		}
		if (rdbtnmntmMaintenance.isSelected()) {
			btnContinue.setText("Save");
			btnContinue.setBackground(Color.BLACK);
			rdbtnCheckIn.setVisible(false);
			rdbtnCheckOut.setVisible(false);
			lbloperationmode_text.setVisible(true);
			lbloperationmode_text.setText("Maintenance");
			for (int i = 0; i < RoomSize; i++) {
				if (Status[i] == 0) {
					btn_action[i].setEnabled(false);
				} else if (Status[i] == 1) {
					btn_action[i].setEnabled(true);
					btn_action[i].setText("Send to Maintenance");
				} else {
					btn_action[i].setEnabled(true);
					btn_action[i].setText("Send to Service");
				}
			}
		}
	}

	private void RoomService(String RoomID, double RoomPrice) {
		RoomList.add(RoomID);
		this.RoomPrice.add(RoomPrice);
		// JOptionPane.showMessageDialog(null, "DEMO:\nROOM ID : " + RoomID + "\nPRICE :
		// " + RoomPrice);
		TotalRoom++;
		lblTotalRoom_get.setText(String.valueOf(TotalRoom));
		TotalPrice += RoomPrice;
		lblTotalPrice_get.setText(frm.format(TotalPrice));
	}
}
