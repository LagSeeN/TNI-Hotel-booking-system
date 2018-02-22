package Core;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JOptionPane;

public class TimeSystem {

	public Font getFont() {
		Font digital = null;
		try {
			// เรียก Font ขึ้นมา
			digital = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("Font//digital-7.ttf"))
					.deriveFont(Font.PLAIN, 22);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Font not foud", "ERROR", JOptionPane.ERROR_MESSAGE);
		} catch (FontFormatException e) {
			JOptionPane.showMessageDialog(null, "Font Format ERROR", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		return digital;
	}

	public String getDate() {
		// รูปแบบเวลา
		DateFormat dateFormat = new SimpleDateFormat("EEE/MMM/YYYY HH:mm:ss", Locale.ENGLISH);
		// ประกาศ obj เวลา
		Date date = new Date();
		return dateFormat.format(date).toString();
	}
}
