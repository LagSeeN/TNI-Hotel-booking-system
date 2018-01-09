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

		JMenuItem mntmRoomList = new JMenuItem("Room list");
		mnCustomer.add(mntmRoomList);

		JMenu mnReport = new JMenu("Report");
		menuBar.add(mnReport);
		frmHotelBookingSystem.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		comboBox.setBounds(258, 29, 34, 20);
		frmHotelBookingSystem.getContentPane().add(comboBox);
		
		JButton btn_checkin_01 = new JButton("Check in");
		btn_checkin_01.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btn_checkin_01.setBounds(214, 177, 130, 23);
		frmHotelBookingSystem.getContentPane().add(btn_checkin_01);
		
		JButton btn_checkin_02 = new JButton("Check in");
		btn_checkin_02.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btn_checkin_02.setBounds(354, 177, 130, 23);
		frmHotelBookingSystem.getContentPane().add(btn_checkin_02);
		
		JButton btn_checkin_03 = new JButton("Check in");
		btn_checkin_03.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btn_checkin_03.setBounds(494, 177, 130, 23);
		frmHotelBookingSystem.getContentPane().add(btn_checkin_03);
		
		JButton btn_checkin_04 = new JButton("Check in");
		btn_checkin_04.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btn_checkin_04.setBounds(214, 340, 130, 23);
		frmHotelBookingSystem.getContentPane().add(btn_checkin_04);
		
		JButton btn_checkin_05 = new JButton("Check in");
		btn_checkin_05.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btn_checkin_05.setBounds(354, 340, 130, 23);
		frmHotelBookingSystem.getContentPane().add(btn_checkin_05);
		
		JButton btn_checkin_06 = new JButton("Check in");
		btn_checkin_06.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btn_checkin_06.setBounds(494, 340, 130, 23);
		frmHotelBookingSystem.getContentPane().add(btn_checkin_06);
		
		JLabel lblFloor = new JLabel("Floor : ");
		lblFloor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFloor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFloor.setBounds(214, 32, 34, 14);
		frmHotelBookingSystem.getContentPane().add(lblFloor);
		
		JLabel lblType = new JLabel("Type :");
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblType.setHorizontalAlignment(SwingConstants.RIGHT);
		lblType.setBounds(302, 32, 34, 14);
		frmHotelBookingSystem.getContentPane().add(lblType);
		
		JLabel lbltype = new JLabel("[TYPE]");
		lbltype.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbltype.setBounds(346, 32, 46, 14);
		frmHotelBookingSystem.getContentPane().add(lbltype);
		
		JLabel lblRoomId_01 = new JLabel("Room ID : ");
		lblRoomId_01.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRoomId_01.setBounds(214, 74, 59, 14);
		frmHotelBookingSystem.getContentPane().add(lblRoomId_01);
		
		JLabel lblBed_01 = new JLabel("Bed : ");
		lblBed_01.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBed_01.setBounds(214, 99, 46, 14);
		frmHotelBookingSystem.getContentPane().add(lblBed_01);
		
		JLabel lblPrice_01 = new JLabel("Price :");
		lblPrice_01.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrice_01.setBounds(214, 124, 46, 14);
		frmHotelBookingSystem.getContentPane().add(lblPrice_01);
		
		JLabel lblStatus_01 = new JLabel("Status :");
		lblStatus_01.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStatus_01.setBounds(214, 149, 46, 14);
		frmHotelBookingSystem.getContentPane().add(lblStatus_01);
		
		JLabel lblroomid_get_01 = new JLabel("[ROOMID]");
		lblroomid_get_01.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblroomid_get_01.setBounds(276, 74, 67, 14);
		frmHotelBookingSystem.getContentPane().add(lblroomid_get_01);
		
		JLabel lblbedtype_get_01 = new JLabel("[BEDTYPE]");
		lblbedtype_get_01.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblbedtype_get_01.setBounds(276, 99, 67, 14);
		frmHotelBookingSystem.getContentPane().add(lblbedtype_get_01);
		
		JLabel lblprice_get_01 = new JLabel("[PRICE]");
		lblprice_get_01.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblprice_get_01.setBounds(277, 124, 67, 14);
		frmHotelBookingSystem.getContentPane().add(lblprice_get_01);
		
		JLabel lblstatus_get_01 = new JLabel("[STATUS]");
		lblstatus_get_01.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblstatus_get_01.setBounds(277, 149, 67, 14);
		frmHotelBookingSystem.getContentPane().add(lblstatus_get_01);
		
		JLabel lblRoomId_02 = new JLabel("Room ID : ");
		lblRoomId_02.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRoomId_02.setBounds(354, 74, 59, 14);
		frmHotelBookingSystem.getContentPane().add(lblRoomId_02);
		
		JLabel lblBed_02 = new JLabel("Bed : ");
		lblBed_02.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBed_02.setBounds(354, 99, 46, 14);
		frmHotelBookingSystem.getContentPane().add(lblBed_02);
		
		JLabel lblPrice_02 = new JLabel("Price :");
		lblPrice_02.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrice_02.setBounds(354, 124, 46, 14);
		frmHotelBookingSystem.getContentPane().add(lblPrice_02);
		
		JLabel lblStatus_02 = new JLabel("Status :");
		lblStatus_02.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStatus_02.setBounds(354, 149, 46, 14);
		frmHotelBookingSystem.getContentPane().add(lblStatus_02);
		
		JLabel lblroomid_get_02 = new JLabel("[ROOMID]");
		lblroomid_get_02.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblroomid_get_02.setBounds(416, 74, 67, 14);
		frmHotelBookingSystem.getContentPane().add(lblroomid_get_02);
		
		JLabel lblbedtype_get_02 = new JLabel("[BEDTYPE]");
		lblbedtype_get_02.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblbedtype_get_02.setBounds(416, 99, 67, 14);
		frmHotelBookingSystem.getContentPane().add(lblbedtype_get_02);
		
		JLabel lblprice_get_02 = new JLabel("[PRICE]");
		lblprice_get_02.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblprice_get_02.setBounds(417, 124, 67, 14);
		frmHotelBookingSystem.getContentPane().add(lblprice_get_02);
		
		JLabel lblstatus_get_02 = new JLabel("[STATUS]");
		lblstatus_get_02.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblstatus_get_02.setBounds(417, 149, 67, 14);
		frmHotelBookingSystem.getContentPane().add(lblstatus_get_02);
		
		JLabel lblRoomId_03 = new JLabel("Room ID : ");
		lblRoomId_03.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRoomId_03.setBounds(494, 74, 59, 14);
		frmHotelBookingSystem.getContentPane().add(lblRoomId_03);
		
		JLabel lblBed_03 = new JLabel("Bed : ");
		lblBed_03.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBed_03.setBounds(494, 99, 46, 14);
		frmHotelBookingSystem.getContentPane().add(lblBed_03);
		
		JLabel lblPrice_03 = new JLabel("Price :");
		lblPrice_03.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrice_03.setBounds(494, 124, 46, 14);
		frmHotelBookingSystem.getContentPane().add(lblPrice_03);
		
		JLabel lblStatus_03 = new JLabel("Status :");
		lblStatus_03.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStatus_03.setBounds(494, 149, 46, 14);
		frmHotelBookingSystem.getContentPane().add(lblStatus_03);
		
		JLabel lblroomid_get_03 = new JLabel("[ROOMID]");
		lblroomid_get_03.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblroomid_get_03.setBounds(556, 74, 67, 14);
		frmHotelBookingSystem.getContentPane().add(lblroomid_get_03);
		
		JLabel lblbedtype_get_03 = new JLabel("[BEDTYPE]");
		lblbedtype_get_03.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblbedtype_get_03.setBounds(556, 99, 67, 14);
		frmHotelBookingSystem.getContentPane().add(lblbedtype_get_03);
		
		JLabel lblprice_get_03 = new JLabel("[PRICE]");
		lblprice_get_03.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblprice_get_03.setBounds(557, 124, 67, 14);
		frmHotelBookingSystem.getContentPane().add(lblprice_get_03);
		
		JLabel lblstatus_get_03 = new JLabel("[STATUS]");
		lblstatus_get_03.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblstatus_get_03.setBounds(557, 149, 67, 14);
		frmHotelBookingSystem.getContentPane().add(lblstatus_get_03);
		
		JLabel lblRoomId_04 = new JLabel("Room ID : ");
		lblRoomId_04.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRoomId_04.setBounds(214, 240, 59, 14);
		frmHotelBookingSystem.getContentPane().add(lblRoomId_04);
		
		JLabel lblBed_04 = new JLabel("Bed : ");
		lblBed_04.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBed_04.setBounds(214, 265, 46, 14);
		frmHotelBookingSystem.getContentPane().add(lblBed_04);
		
		JLabel lblPrice_04 = new JLabel("Price :");
		lblPrice_04.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrice_04.setBounds(214, 290, 46, 14);
		frmHotelBookingSystem.getContentPane().add(lblPrice_04);
		
		JLabel lblStatus_04 = new JLabel("Status :");
		lblStatus_04.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStatus_04.setBounds(214, 315, 46, 14);
		frmHotelBookingSystem.getContentPane().add(lblStatus_04);
		
		JLabel lblroomid_get_04 = new JLabel("[ROOMID]");
		lblroomid_get_04.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblroomid_get_04.setBounds(276, 240, 67, 14);
		frmHotelBookingSystem.getContentPane().add(lblroomid_get_04);
		
		JLabel lblbedtype_get_04 = new JLabel("[BEDTYPE]");
		lblbedtype_get_04.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblbedtype_get_04.setBounds(276, 265, 67, 14);
		frmHotelBookingSystem.getContentPane().add(lblbedtype_get_04);
		
		JLabel lblprice_get_04 = new JLabel("[PRICE]");
		lblprice_get_04.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblprice_get_04.setBounds(277, 290, 67, 14);
		frmHotelBookingSystem.getContentPane().add(lblprice_get_04);
		
		JLabel lblstatus_get_04 = new JLabel("[STATUS]");
		lblstatus_get_04.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblstatus_get_04.setBounds(277, 315, 67, 14);
		frmHotelBookingSystem.getContentPane().add(lblstatus_get_04);
		
		JLabel lblRoomId_05 = new JLabel("Room ID : ");
		lblRoomId_05.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRoomId_05.setBounds(354, 240, 59, 14);
		frmHotelBookingSystem.getContentPane().add(lblRoomId_05);
		
		JLabel lblBed_05 = new JLabel("Bed : ");
		lblBed_05.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBed_05.setBounds(354, 265, 46, 14);
		frmHotelBookingSystem.getContentPane().add(lblBed_05);
		
		JLabel lblPrice_05 = new JLabel("Price :");
		lblPrice_05.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrice_05.setBounds(354, 290, 46, 14);
		frmHotelBookingSystem.getContentPane().add(lblPrice_05);
		
		JLabel lblStatus_05 = new JLabel("Status :");
		lblStatus_05.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStatus_05.setBounds(354, 315, 46, 14);
		frmHotelBookingSystem.getContentPane().add(lblStatus_05);
		
		JLabel lblroomid_get_05 = new JLabel("[ROOMID]");
		lblroomid_get_05.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblroomid_get_05.setBounds(416, 240, 67, 14);
		frmHotelBookingSystem.getContentPane().add(lblroomid_get_05);
		
		JLabel lblbedtype_get_05 = new JLabel("[BEDTYPE]");
		lblbedtype_get_05.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblbedtype_get_05.setBounds(416, 265, 67, 14);
		frmHotelBookingSystem.getContentPane().add(lblbedtype_get_05);
		
		JLabel lblprice_get_05 = new JLabel("[PRICE]");
		lblprice_get_05.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblprice_get_05.setBounds(417, 290, 67, 14);
		frmHotelBookingSystem.getContentPane().add(lblprice_get_05);
		
		JLabel lblstatus_get_05 = new JLabel("[STATUS]");
		lblstatus_get_05.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblstatus_get_05.setBounds(417, 315, 67, 14);
		frmHotelBookingSystem.getContentPane().add(lblstatus_get_05);
		
		JLabel lblRoomId_06 = new JLabel("Room ID : ");
		lblRoomId_06.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRoomId_06.setBounds(494, 240, 59, 14);
		frmHotelBookingSystem.getContentPane().add(lblRoomId_06);
		
		JLabel lblBed_06 = new JLabel("Bed : ");
		lblBed_06.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBed_06.setBounds(494, 265, 46, 14);
		frmHotelBookingSystem.getContentPane().add(lblBed_06);
		
		JLabel lblPrice_06 = new JLabel("Price :");
		lblPrice_06.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrice_06.setBounds(494, 290, 46, 14);
		frmHotelBookingSystem.getContentPane().add(lblPrice_06);
		
		JLabel lblStatus_06 = new JLabel("Status :");
		lblStatus_06.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStatus_06.setBounds(494, 315, 46, 14);
		frmHotelBookingSystem.getContentPane().add(lblStatus_06);
		
		JLabel lblroomid_get_06 = new JLabel("[ROOMID]");
		lblroomid_get_06.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblroomid_get_06.setBounds(556, 240, 67, 14);
		frmHotelBookingSystem.getContentPane().add(lblroomid_get_06);
		
		JLabel lblbedtype_get_06 = new JLabel("[BEDTYPE]");
		lblbedtype_get_06.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblbedtype_get_06.setBounds(556, 265, 67, 14);
		frmHotelBookingSystem.getContentPane().add(lblbedtype_get_06);
		
		JLabel lblprice_get_06 = new JLabel("[PRICE]");
		lblprice_get_06.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblprice_get_06.setBounds(557, 290, 67, 14);
		frmHotelBookingSystem.getContentPane().add(lblprice_get_06);
		
		JLabel lblstatus_get_06 = new JLabel("[STATUS]");
		lblstatus_get_06.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblstatus_get_06.setBounds(557, 315, 67, 14);
		frmHotelBookingSystem.getContentPane().add(lblstatus_get_06);
		
		JLabel lblTotalRoom = new JLabel("Total : ");
		lblTotalRoom.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTotalRoom.setBounds(33, 265, 46, 14);
		frmHotelBookingSystem.getContentPane().add(lblTotalRoom);
		
		JLabel label = new JLabel("[00]");
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label.setBounds(33, 290, 63, 14);
		frmHotelBookingSystem.getContentPane().add(label);
		
		JLabel lblRooms = new JLabel("Room(s)");
		lblRooms.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblRooms.setBounds(106, 290, 46, 14);
		frmHotelBookingSystem.getContentPane().add(lblRooms);
		
		JLabel lblBaht = new JLabel("Baht.");
		lblBaht.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblBaht.setBounds(106, 315, 46, 14);
		frmHotelBookingSystem.getContentPane().add(lblBaht);
		
		JLabel lbltotalprice = new JLabel("[TOTALPRICE]");
		lbltotalprice.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbltotalprice.setBounds(33, 315, 63, 14);
		frmHotelBookingSystem.getContentPane().add(lbltotalprice);
		
		JButton btnNewButton = new JButton("Pay");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton.setBounds(33, 340, 119, 23);
		frmHotelBookingSystem.getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(175, 238, 238));
		panel.setBounds(0, 0, 191, 430);
		frmHotelBookingSystem.getContentPane().add(panel);
	}
}
