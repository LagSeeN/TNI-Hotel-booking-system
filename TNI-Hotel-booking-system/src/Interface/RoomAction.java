package Interface;

import java.io.IOException;

public interface RoomAction {
	public void setRoom(String room);

	public void removeRoomAll();

	public void writeFile() throws IOException;
	
	//public void PrintLogs() throws IOException;

}
