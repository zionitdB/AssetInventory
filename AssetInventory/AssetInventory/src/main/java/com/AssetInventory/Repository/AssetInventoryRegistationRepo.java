package com.AssetInventory.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.AssetInventory.Model.AssetInventoryRegistation;

public interface AssetInventoryRegistationRepo extends JpaRepository<AssetInventoryRegistation, Integer>{

	@Query("select count(*) from AssetInventoryRegistation m where substr(m.batchNumber,1,4)=?1")
	int getBatchNumberCountByYearMonth(String mnyr);
	@Query("select MAX(m.batchNumber) from AssetInventoryRegistation m where substr(m.batchNumber,1,4)=?1")
	String getMaxBatchQrNoByYearMonth(String mnyr);

}
