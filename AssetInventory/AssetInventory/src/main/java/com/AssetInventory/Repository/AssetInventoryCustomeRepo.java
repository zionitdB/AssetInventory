package com.AssetInventory.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AssetInventory.Model.AssetInventory;

public interface AssetInventoryCustomeRepo {
List<AssetInventory> getlistAssetInventoryByLimit(int pageNo, int perPage);
	
	List<AssetInventory> getlistAssetInventoryByLimitAndSearch(String searchText, int pageNo, int perPage);
	int getAssetInventorysCountAndSearch(String searchText);
}
