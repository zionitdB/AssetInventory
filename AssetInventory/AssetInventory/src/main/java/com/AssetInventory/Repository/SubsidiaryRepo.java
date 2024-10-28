package com.AssetInventory.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.AssetInventory.Model.Subsidiary;

public interface SubsidiaryRepo extends JpaRepository<Subsidiary, Integer>{
	@Query("from Subsidiary d where active=1")
	List<Subsidiary> getAllActiveSubsidiary();
	@Query("from Subsidiary d where subsidiaryName=?1")
	Subsidiary getSubsidiaryByName(String subsidiaryName);

}
