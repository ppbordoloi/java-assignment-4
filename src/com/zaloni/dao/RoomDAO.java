package com.zaloni.dao;

import java.util.List;

import com.zaloni.entity.Room;

public interface RoomDAO {

	public List<Room> getRoom();

	public void addRoom(Room theRoom);

	public Room getRoomById(int theId);
	
	public List<Room> getAllVacantRooms();
	
	public List<Room> getAllUsedRooms();
}

