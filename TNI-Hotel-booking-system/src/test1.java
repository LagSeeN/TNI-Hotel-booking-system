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
import java.awt.event.ActionEvent;

public class test1 {

	private JFrame frame;
	private int count1;
	private JProgressBar test1;

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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton button = new JButton("5555");
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
		slider.setBounds(212, 90, 200, 26);
		frame.getContentPane().add(slider);

		JLabel img = new JLabel("");
		img.setIcon(new ImageIcon(this.getClass().getResource("AFRO.jpg")));
		img.setBounds(32, 76, 148, 174);
		frame.getContentPane().add(img);

		test1 = new JProgressBar();
		test1.setValue(count1);
		test1.setBounds(115, 36, 297, 14);
		frame.getContentPane().add(test1);

	}
}
