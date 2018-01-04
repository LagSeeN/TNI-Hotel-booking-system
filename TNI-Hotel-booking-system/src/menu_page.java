import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class menu_page {

	private JFrame frmHotelBookingSystem;

	/**
	 * Launch the application.
	 */
	public void NewScreen() {
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
		frmHotelBookingSystem.getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
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
	}
}
