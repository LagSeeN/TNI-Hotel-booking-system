package Core;

public class ButtonStatus {

	public boolean[][] setDefault(boolean[][] roomcheck) {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j > 5; j++)
				roomcheck[i][j] = false;
		}
		return roomcheck;
	}

	// public void setButton(String fileroom, String RoomID) throws IOException {
	// try {
	// super.readBtnStatus(fileroom);
	// PrintStream print = new PrintStream(new File("res//Database//Floor//boolean_"
	// + fileroom + ".txt"));
	// for (int i = 0; i < super.getBtnStatus().length; i++) {
	// if (i == Integer.parseInt(RoomID.substring(1))) {
	// if (super.getBtnStatus()[i] == true)
	// print.println(false);
	// else
	// print.println(true);
	// } else {
	// print.println(super.getBtnStatus()[i]);
	// }
	// }
	// print.close();
	// } catch (IOException e) {
	// JOptionPane.showMessageDialog(null, "setButton() Error : File not found",
	// "ERROR",
	// JOptionPane.ERROR_MESSAGE);
	// }
	// }
	//
	// public boolean getButton(String fileroom, String RoomID) throws IOException {
	// try {
	// BufferedReader reader = new BufferedReader(
	// new FileReader("res//Database//Floor//boolean_" + fileroom + ".txt"));
	// boolean temp;
	// while (temp = reader.readLine() != null) {
	// for (int i = 0; i < super.getBtnStatus().length; i++) {
	// if (i == Integer.parseInt(RoomID.substring(1))) {
	// return temp;
	// }
	// }
	// }
	// reader.close();
	// } catch (IOException e) {
	// JOptionPane.showMessageDialog(null, "getButton() Error : File not found",
	// "ERROR",
	// JOptionPane.ERROR_MESSAGE);
	// }
	// return super.getBtnStatus()[0];
	// }
}
