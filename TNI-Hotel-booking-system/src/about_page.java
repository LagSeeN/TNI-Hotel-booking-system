import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class about_page {

	private JFrame about;

	/**
	 * Launch the application.
	 */
	public void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					about_page window = new about_page();
					window.about.setLocationRelativeTo(null);
					window.about.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public about_page() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		about = new JFrame();
		about.setTitle("About | TNI Hotel Booking System 2.16");
		about.setAlwaysOnTop(true);
		about.setIconImage(Toolkit.getDefaultToolkit().getImage(about_page.class.getResource("/img/icon1.png")));
		about.setResizable(false);
		about.setBounds(100, 100, 450, 265);
		about.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 444, 90);
		about.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel ICON = new JLabel("");
		ICON.setIcon(new ImageIcon(about_page.class.getResource("/img/about_icon.png")));
		ICON.setBounds(354, 0, 90, 90);
		panel.add(ICON);

		JLabel lblNewLabel = new JLabel("Hotel Booking System");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 0, 424, 35);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u00A9 2017-2018 All rights reserved.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 31, 414, 28);
		panel.add(lblNewLabel_1);

		JLabel lblBuild = new JLabel("Build 2.16");
		lblBuild.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBuild.setBounds(10, 57, 414, 28);
		panel.add(lblBuild);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 89, 444, 147);
		about.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Developed by");
		lblNewLabel_2.setBounds(10, 0, 424, 33);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel Name1 = new JLabel("60121002-4 Sec.2 Yossapon Jantarote");
		Name1.setBounds(20, 30, 414, 25);
		panel_1.add(Name1);
		Name1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel Name2 = new JLabel("60121045-3 Sec.1 Thanapat Chanprasert");
		Name2.setBounds(20, 55, 414, 25);
		panel_1.add(Name2);
		Name2.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel Name3 = new JLabel("60121053-7 Sec.2 Danupol Intranurux");
		Name3.setBounds(20, 80, 414, 25);
		panel_1.add(Name3);
		Name3.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel Name4 = new JLabel("60121075-0 Sec.2 Prachya Khongwichayakupe");
		Name4.setBounds(20, 105, 414, 25);
		panel_1.add(Name4);
		Name4.setFont(new Font("Tahoma", Font.PLAIN, 14));
	}
}
