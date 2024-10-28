package com.AssetInventory.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.AssetInventory.Model.Room;

public interface RoomRepo  extends JpaRepository<Room, Integer>{
	@Query("from Room d where active=1")
	List<Room> getAllActiveRoom();
	@Query("from Room d where roomName=?1")
	Room getRoomByname(String roomName);

}
