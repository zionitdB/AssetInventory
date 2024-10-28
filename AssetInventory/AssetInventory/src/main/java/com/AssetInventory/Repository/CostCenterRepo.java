package com.AssetInventory.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.AssetInventory.Model.CostCenter;

public interface CostCenterRepo extends JpaRepository<CostCenter, Integer> {
	@Query("from CostCenter where active=1")
	List<CostCenter> getAllActiveCostCenter();
	@Query("from CostCenter where costCenterName=?1")
	CostCenter getCostCenterByName(String costCenterName);

}
