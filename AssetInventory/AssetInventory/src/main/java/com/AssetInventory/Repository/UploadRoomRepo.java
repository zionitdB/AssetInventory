package com.AssetInventory.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.AssetInventory.Model.UploadDesk;
import com.AssetInventory.Model.UploadRoom;

public interface UploadRoomRepo extends JpaRepository<UploadRoom, Integer> {
	@Query("from UploadRoom where roomName=?1")
	UploadRoom getRoomByname(String roomName);
	@Query("from UploadRoom where uploadDetial.id=?1")
	List<UploadRoom> findByUserDetailsId(int id);

}
