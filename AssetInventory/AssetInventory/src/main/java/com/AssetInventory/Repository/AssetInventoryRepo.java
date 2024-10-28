package com.AssetInventory.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.AssetInventory.Model.AssetInventory;

public interface AssetInventoryRepo extends JpaRepository<AssetInventory, Integer>,AssetInventoryCustomeRepo{
	@Query("from AssetInventory a where a.material.id=?1")
	List<AssetInventory> getAssetInventoryByMaterialId(int materialId);
	@Query("from AssetInventory a where a.incentoryCode=?1")
	Optional<AssetInventory> findByInventoryCode(String incentoryCode);
	@Query("from AssetInventory a where a.status=1")
	List<AssetInventory> getAvailableAssetInvemtoryCode(int materialId);

	@Query("select count(*) from AssetInventory m where substr(m.incentoryCode,1,14)=?1")
	int getCountInventoryNumber(String inventoryCode);
	
	@Query("select MAX(m.incentoryCode) from AssetInventory m where substr(m.incentoryCode,1,14)=?1")
	String getMaxInventoryNumber(String inventoryCode);
	
	
	

}
