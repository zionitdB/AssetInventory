package com.AssetInventory.Repository;

import java.util.List;

import com.AssetInventory.Model.AssetAllocation;

public interface AssetAllocationCustomeRepo {
	List<AssetAllocation> getAllAllocateAssetByLimit(int pageNo, int perPage);

	List<AssetAllocation> getAllAllocateAssetByLimitAndSearch(String searchText, int pageNo, int perPage);

	int getAllocatedAssetsCountAndSearch(String searchText);
	
	List<AssetAllocation> getAllReleaseRequestByLimit(int pageNo, int perPage);

	List<AssetAllocation> getAllReleaseRequestByLimitAndSearch(String searchText, int pageNo, int perPage);

	int getReleaseRequestCount();

	int getReleaseRequestCountBySearch(String searchText);
}
