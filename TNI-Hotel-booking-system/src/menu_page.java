import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class menu_page {

	private JFrame HotelBookingSystem;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu_page window = new menu_page();
					window.HotelBookingSystem.setVisible(true);
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
		HotelBookingSystem = new JFrame();
		HotelBookingSystem.setResizable(false);
		HotelBookingSystem.setTitle("Hotel Booking System");
		HotelBookingSystem.setBounds(100, 100, 640, 480);
		HotelBookingSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		HotelBookingSystem.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(226, 191, 89, 23);
		HotelBookingSystem.getContentPane().add(btnNewButton);

		JMenuBar menuBar = new JMenuBar();
		HotelBookingSystem.setJMenuBar(menuBar);

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
