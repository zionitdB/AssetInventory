package com.AssetInventory.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.AssetInventory.Model.AssetAllocation;

public interface AssetAllocationRepo extends JpaRepository<AssetAllocation, Integer>,AssetAllocationCustomeRepo{
	@Query("from AssetAllocation where assetCode=?1")
	AssetAllocation getAllocatedAssetByAsssetCode(String incentoryCode);

	



}
