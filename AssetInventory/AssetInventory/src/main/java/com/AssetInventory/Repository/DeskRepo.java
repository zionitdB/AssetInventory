package com.AssetInventory.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.AssetInventory.Model.Desk;

public interface DeskRepo extends JpaRepository<Desk, Integer>{
	@Query("from Desk d where allocate=0")
	List<Desk> getAvailableDesk();
	@Query("from Desk d where deskCode=?1")

	Desk getDeskByDeskCode(String deskCode);

}
