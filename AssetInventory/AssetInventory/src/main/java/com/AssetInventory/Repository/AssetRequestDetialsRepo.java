package com.AssetInventory.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.AssetInventory.Model.AssetRequestDetials;

public interface AssetRequestDetialsRepo extends JpaRepository<AssetRequestDetials, Integer> {
	@Query("from AssetRequestDetials a where a.assetRequest.assetRequestId=?1")
	List<AssetRequestDetials> getDetailsByRequest(int requestId);
}
