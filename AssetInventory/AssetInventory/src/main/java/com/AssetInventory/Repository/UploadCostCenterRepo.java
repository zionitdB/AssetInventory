package com.AssetInventory.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.AssetInventory.Model.UploadCostCenter;

public interface UploadCostCenterRepo extends JpaRepository<UploadCostCenter, Integer>{
	@Query("From UploadCostCenter where costCenterName=?1")
	UploadCostCenter getCostCenterByName(String costCenterName);
	@Query("from UploadCostCenter where uploadDetial.id=?1")
	List<UploadCostCenter> findByUserDetailsId(int id);

}
