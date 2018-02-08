package core;

import java.io.*;

public class RoomService{
	private File file;
	private int RoomSize;
	private double RoomPrice;
	
	public void setRoomsize(int RoomSize){
		this.RoomSize = RoomSize;
	}
	public int getRoomsize(){
		return RoomSize;
	}
	public void setRoomprice(double RoomPrice){
		this.RoomPrice = RoomPrice;
	}
	public double getRoomprice(){
		return RoomPrice;
	}
}