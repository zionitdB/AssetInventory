package com.AssetInventory.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.AssetInventory.Model.AssetAllocation;

public interface AssetAllocationRepo extends JpaRepository<AssetAllocation, Integer>,AssetAllocationCustomeRepo{
	@Query("from AssetAllocation where assetCode=?1")
	AssetAllocation getAllocatedAssetByAsssetCode(String incentoryCode);
	@Query("from AssetAllocation where assetInventory.asset_inventory_id=?1")
	Optional<AssetAllocation> getAllocatedAssetByAssetInventorytId(int asset_inventory_id);

	



}
