import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;

public class test1 {

	private JFrame frame;
	private int count1;
	private JProgressBar test1;
	private JLabel Date;
	private JLabel Time;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					test1 window = new test1();
					window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public test1() {
		initialize();
		clock();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 741, 517);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton button = new JButton("5555");
		button.setForeground(Color.GREEN);
		button.setBackground(Color.RED);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (count1 < 100) {
					count1 += 10;
					test1.setValue(count1);
				} else {
					JOptionPane.showMessageDialog(null, "Noob");
					count1 = 0;
					test1.setValue(count1);
				}

			}
		});
		button.setBounds(10, 11, 95, 25);
		frame.getContentPane().add(button);

		JProgressBar progressBar = new JProgressBar();
		progressBar.setIndeterminate(true);
		progressBar.setBounds(115, 11, 297, 14);
		frame.getContentPane().add(progressBar);
		progressBar.setValue(50);

		JSlider slider = new JSlider();
		slider.setBounds(422, 11, 200, 26);
		frame.getContentPane().add(slider);

		test1 = new JProgressBar();
		test1.setMaximum(60);
		test1.setValue(count1);
		test1.setBounds(115, 36, 297, 14);
		frame.getContentPane().add(test1);

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Noob why you click");
			}
		});
		btnNewButton.setIcon(new ImageIcon(this.getClass().getResource("main_icon.png")));
		btnNewButton.setBounds(10, 61, 250, 250);
		frame.getContentPane().add(btnNewButton);

		Date = new JLabel("");
		Date.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Date.setBounds(323, 85, 351, 25);
		frame.getContentPane().add(Date);

		Time = new JLabel("");
		Time.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Time.setBounds(323, 121, 351, 25);
		frame.getContentPane().add(Time);

	}

	public void clock() {
		DecimalFormat frm = new DecimalFormat("00");
		Thread clock = new Thread() {
			public void run() {
				try {
					for (;;) {
						GregorianCalendar cal = new GregorianCalendar();
						int day = cal.get(Calendar.DAY_OF_MONTH);
						int month = cal.get(Calendar.MONTH) + 1;
						int year = cal.get(Calendar.YEAR);
						int sec = cal.get(Calendar.SECOND);
						int min = cal.get(Calendar.MINUTE);
						int hr = cal.get(Calendar.HOUR);
						Date.setText(frm.format(day) + "/" + frm.format(month) + "/" + frm.format(year));
						Time.setText(frm.format(hr) + ":" + frm.format(min) + ":" + frm.format(sec));
						test1.setValue(cal.get(Calendar.SECOND));
						sleep(1000);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		clock.start();

	}
}
