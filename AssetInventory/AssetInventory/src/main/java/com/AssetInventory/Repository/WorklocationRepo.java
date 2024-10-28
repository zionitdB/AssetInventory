package com.AssetInventory.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.AssetInventory.Model.Worklocation;

public interface WorklocationRepo extends JpaRepository<Worklocation, Integer> {
	@Query("from Worklocation d where active=1")
	List<Worklocation> getAllActiveWorklocation();
	@Query("from Worklocation d where workLocationName=?1")
	Worklocation getWorklocationByName(String workLocationName);

}
