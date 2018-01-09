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
import java.awt.Color;
import javax.swing.ImageIcon;

public class menu_page {

	private JFrame frmHotelBookingSystem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
		frmHotelBookingSystem.setBounds(100, 100, 640, 480);
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
		panel_roomlist_sum.setBounds(0, 0, 191, 430);
		frmHotelBookingSystem.getContentPane().add(panel_roomlist_sum);
		panel_roomlist_sum.setLayout(null);
		
		JLabel lblTotalRoom = new JLabel("Total : ");
		lblTotalRoom.setBounds(37, 265, 46, 14);
		panel_roomlist_sum.add(lblTotalRoom);
		lblTotalRoom.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel label = new JLabel("[00]");
		label.setBounds(37, 290, 63, 14);
		panel_roomlist_sum.add(label);
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblRooms = new JLabel("Room(s)");
		lblRooms.setBounds(110, 290, 46, 14);
		panel_roomlist_sum.add(lblRooms);
		lblRooms.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblBaht = new JLabel("Baht.");
		lblBaht.setBounds(110, 315, 46, 14);
		panel_roomlist_sum.add(lblBaht);
		lblBaht.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lbltotalprice = new JLabel("[TOTALPRICE]");
		lbltotalprice.setBounds(37, 315, 63, 14);
		panel_roomlist_sum.add(lbltotalprice);
		lbltotalprice.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JButton btnNewButton = new JButton("Pay");
		btnNewButton.setBounds(37, 340, 119, 23);
		panel_roomlist_sum.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JPanel panel_roomlist = new JPanel();
		panel_roomlist.setBackground(Color.WHITE);
		panel_roomlist.setBounds(188, 0, 446, 430);
		frmHotelBookingSystem.getContentPane().add(panel_roomlist);
		panel_roomlist.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(70, 29, 34, 20);
		panel_roomlist.add(comboBox);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		
		JButton btn_checkin_01 = new JButton("Check in");
		btn_checkin_01.setBounds(26, 177, 130, 23);
		panel_roomlist.add(btn_checkin_01);
		btn_checkin_01.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JButton btn_checkin_02 = new JButton("Check in");
		btn_checkin_02.setBounds(166, 177, 130, 23);
		panel_roomlist.add(btn_checkin_02);
		btn_checkin_02.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JButton btn_checkin_03 = new JButton("Check in");
		btn_checkin_03.setBounds(306, 177, 130, 23);
		panel_roomlist.add(btn_checkin_03);
		btn_checkin_03.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JButton btn_checkin_04 = new JButton("Check in");
		btn_checkin_04.setBounds(26, 340, 130, 23);
		panel_roomlist.add(btn_checkin_04);
		btn_checkin_04.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JButton btn_checkin_05 = new JButton("Check in");
		btn_checkin_05.setBounds(166, 340, 130, 23);
		panel_roomlist.add(btn_checkin_05);
		btn_checkin_05.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JButton btn_checkin_06 = new JButton("Check in");
		btn_checkin_06.setBounds(306, 340, 130, 23);
		panel_roomlist.add(btn_checkin_06);
		btn_checkin_06.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblFloor = new JLabel("Floor : ");
		lblFloor.setBounds(26, 32, 34, 14);
		panel_roomlist.add(lblFloor);
		lblFloor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFloor.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblType = new JLabel("Type :");
		lblType.setBounds(114, 32, 34, 14);
		panel_roomlist.add(lblType);
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblType.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lbltype = new JLabel("[TYPE]");
		lbltype.setBounds(158, 32, 46, 14);
		panel_roomlist.add(lbltype);
		lbltype.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblRoomId_01 = new JLabel("Room ID : ");
		lblRoomId_01.setBounds(26, 74, 59, 14);
		panel_roomlist.add(lblRoomId_01);
		lblRoomId_01.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblBed_01 = new JLabel("Bed : ");
		lblBed_01.setBounds(26, 99, 46, 14);
		panel_roomlist.add(lblBed_01);
		lblBed_01.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblPrice_01 = new JLabel("Price :");
		lblPrice_01.setBounds(26, 124, 46, 14);
		panel_roomlist.add(lblPrice_01);
		lblPrice_01.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblStatus_01 = new JLabel("Status :");
		lblStatus_01.setBounds(26, 149, 46, 14);
		panel_roomlist.add(lblStatus_01);
		lblStatus_01.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblroomid_get_01 = new JLabel("[ROOMID]");
		lblroomid_get_01.setBounds(88, 74, 67, 14);
		panel_roomlist.add(lblroomid_get_01);
		lblroomid_get_01.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblbedtype_get_01 = new JLabel("[BEDTYPE]");
		lblbedtype_get_01.setBounds(88, 99, 67, 14);
		panel_roomlist.add(lblbedtype_get_01);
		lblbedtype_get_01.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblprice_get_01 = new JLabel("[PRICE]");
		lblprice_get_01.setBounds(89, 124, 67, 14);
		panel_roomlist.add(lblprice_get_01);
		lblprice_get_01.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblstatus_get_01 = new JLabel("[STATUS]");
		lblstatus_get_01.setBounds(89, 149, 67, 14);
		panel_roomlist.add(lblstatus_get_01);
		lblstatus_get_01.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblRoomId_02 = new JLabel("Room ID : ");
		lblRoomId_02.setBounds(166, 74, 59, 14);
		panel_roomlist.add(lblRoomId_02);
		lblRoomId_02.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblPrice_02 = new JLabel("Price :");
		lblPrice_02.setBounds(166, 124, 46, 14);
		panel_roomlist.add(lblPrice_02);
		lblPrice_02.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblroomid_get_02 = new JLabel("[ROOMID]");
		lblroomid_get_02.setBounds(228, 74, 67, 14);
		panel_roomlist.add(lblroomid_get_02);
		lblroomid_get_02.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblbedtype_get_02 = new JLabel("[BEDTYPE]");
		lblbedtype_get_02.setBounds(228, 99, 67, 14);
		panel_roomlist.add(lblbedtype_get_02);
		lblbedtype_get_02.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblprice_get_02 = new JLabel("[PRICE]");
		lblprice_get_02.setBounds(229, 124, 67, 14);
		panel_roomlist.add(lblprice_get_02);
		lblprice_get_02.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblstatus_get_02 = new JLabel("[STATUS]");
		lblstatus_get_02.setBounds(229, 149, 67, 14);
		panel_roomlist.add(lblstatus_get_02);
		lblstatus_get_02.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblRoomId_03 = new JLabel("Room ID : ");
		lblRoomId_03.setBounds(306, 74, 59, 14);
		panel_roomlist.add(lblRoomId_03);
		lblRoomId_03.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblBed_03 = new JLabel("Bed : ");
		lblBed_03.setBounds(306, 99, 46, 14);
		panel_roomlist.add(lblBed_03);
		lblBed_03.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblPrice_03 = new JLabel("Price :");
		lblPrice_03.setBounds(306, 124, 46, 14);
		panel_roomlist.add(lblPrice_03);
		lblPrice_03.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblStatus_03 = new JLabel("Status :");
		lblStatus_03.setBounds(306, 149, 46, 14);
		panel_roomlist.add(lblStatus_03);
		lblStatus_03.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblroomid_get_03 = new JLabel("[ROOMID]");
		lblroomid_get_03.setBounds(368, 74, 67, 14);
		panel_roomlist.add(lblroomid_get_03);
		lblroomid_get_03.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblbedtype_get_03 = new JLabel("[BEDTYPE]");
		lblbedtype_get_03.setBounds(368, 99, 67, 14);
		panel_roomlist.add(lblbedtype_get_03);
		lblbedtype_get_03.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblprice_get_03 = new JLabel("[PRICE]");
		lblprice_get_03.setBounds(369, 124, 67, 14);
		panel_roomlist.add(lblprice_get_03);
		lblprice_get_03.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblstatus_get_03 = new JLabel("[STATUS]");
		lblstatus_get_03.setBounds(369, 149, 67, 14);
		panel_roomlist.add(lblstatus_get_03);
		lblstatus_get_03.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblRoomId_04 = new JLabel("Room ID : ");
		lblRoomId_04.setBounds(26, 240, 59, 14);
		panel_roomlist.add(lblRoomId_04);
		lblRoomId_04.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblBed_04 = new JLabel("Bed : ");
		lblBed_04.setBounds(26, 265, 46, 14);
		panel_roomlist.add(lblBed_04);
		lblBed_04.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblPrice_04 = new JLabel("Price :");
		lblPrice_04.setBounds(26, 290, 46, 14);
		panel_roomlist.add(lblPrice_04);
		lblPrice_04.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblStatus_04 = new JLabel("Status :");
		lblStatus_04.setBounds(26, 315, 46, 14);
		panel_roomlist.add(lblStatus_04);
		lblStatus_04.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblroomid_get_04 = new JLabel("[ROOMID]");
		lblroomid_get_04.setBounds(88, 240, 67, 14);
		panel_roomlist.add(lblroomid_get_04);
		lblroomid_get_04.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblbedtype_get_04 = new JLabel("[BEDTYPE]");
		lblbedtype_get_04.setBounds(88, 265, 67, 14);
		panel_roomlist.add(lblbedtype_get_04);
		lblbedtype_get_04.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblprice_get_04 = new JLabel("[PRICE]");
		lblprice_get_04.setBounds(89, 290, 67, 14);
		panel_roomlist.add(lblprice_get_04);
		lblprice_get_04.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblstatus_get_04 = new JLabel("[STATUS]");
		lblstatus_get_04.setBounds(89, 315, 67, 14);
		panel_roomlist.add(lblstatus_get_04);
		lblstatus_get_04.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblRoomId_05 = new JLabel("Room ID : ");
		lblRoomId_05.setBounds(166, 240, 59, 14);
		panel_roomlist.add(lblRoomId_05);
		lblRoomId_05.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblBed_05 = new JLabel("Bed : ");
		lblBed_05.setBounds(166, 265, 46, 14);
		panel_roomlist.add(lblBed_05);
		lblBed_05.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblPrice_05 = new JLabel("Price :");
		lblPrice_05.setBounds(166, 290, 46, 14);
		panel_roomlist.add(lblPrice_05);
		lblPrice_05.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblStatus_05 = new JLabel("Status :");
		lblStatus_05.setBounds(166, 315, 46, 14);
		panel_roomlist.add(lblStatus_05);
		lblStatus_05.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblroomid_get_05 = new JLabel("[ROOMID]");
		lblroomid_get_05.setBounds(228, 240, 67, 14);
		panel_roomlist.add(lblroomid_get_05);
		lblroomid_get_05.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblbedtype_get_05 = new JLabel("[BEDTYPE]");
		lblbedtype_get_05.setBounds(228, 265, 67, 14);
		panel_roomlist.add(lblbedtype_get_05);
		lblbedtype_get_05.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblprice_get_05 = new JLabel("[PRICE]");
		lblprice_get_05.setBounds(229, 290, 67, 14);
		panel_roomlist.add(lblprice_get_05);
		lblprice_get_05.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblstatus_get_05 = new JLabel("[STATUS]");
		lblstatus_get_05.setBounds(229, 315, 67, 14);
		panel_roomlist.add(lblstatus_get_05);
		lblstatus_get_05.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblRoomId_06 = new JLabel("Room ID : ");
		lblRoomId_06.setBounds(306, 240, 59, 14);
		panel_roomlist.add(lblRoomId_06);
		lblRoomId_06.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblBed_06 = new JLabel("Bed : ");
		lblBed_06.setBounds(306, 265, 46, 14);
		panel_roomlist.add(lblBed_06);
		lblBed_06.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblPrice_06 = new JLabel("Price :");
		lblPrice_06.setBounds(306, 290, 46, 14);
		panel_roomlist.add(lblPrice_06);
		lblPrice_06.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblStatus_06 = new JLabel("Status :");
		lblStatus_06.setBounds(306, 315, 46, 14);
		panel_roomlist.add(lblStatus_06);
		lblStatus_06.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblroomid_get_06 = new JLabel("[ROOMID]");
		lblroomid_get_06.setBounds(368, 240, 67, 14);
		panel_roomlist.add(lblroomid_get_06);
		lblroomid_get_06.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblbedtype_get_06 = new JLabel("[BEDTYPE]");
		lblbedtype_get_06.setBounds(368, 265, 67, 14);
		panel_roomlist.add(lblbedtype_get_06);
		lblbedtype_get_06.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblprice_get_06 = new JLabel("[PRICE]");
		lblprice_get_06.setBounds(369, 290, 67, 14);
		panel_roomlist.add(lblprice_get_06);
		lblprice_get_06.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblstatus_get_06 = new JLabel("[STATUS]");
		lblstatus_get_06.setBounds(369, 315, 67, 14);
		panel_roomlist.add(lblstatus_get_06);
		lblstatus_get_06.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblBed_02 = new JLabel("Bed : ");
		lblBed_02.setBounds(166, 99, 46, 14);
		panel_roomlist.add(lblBed_02);
		lblBed_02.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblStatus_02 = new JLabel("Status :");
		lblStatus_02.setBounds(166, 149, 46, 14);
		panel_roomlist.add(lblStatus_02);
		lblStatus_02.setFont(new Font("Tahoma", Font.BOLD, 11));
	}
}
