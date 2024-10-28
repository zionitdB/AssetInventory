package com.AssetInventory.Service;

import java.util.List;

import com.AssetInventory.Model.AssetAllocation;
import com.AssetInventory.Model.AssetAllocationHistory;
import com.AssetInventory.Model.AssetRequest;
import com.AssetInventory.Model.AssetRequestDetials;
import com.AssetInventory.Model.Employee;

public interface AllocationService {

	String getNewTokenNo();

	AssetRequest saveAssetRequest(AssetRequest assetRequest);

	void saveAssetRequestDetails(AssetRequestDetials assetRequestDetials);

	List<AssetRequestDetials> getDetailsByRequest(int assetRequestId);

	void saveAllocationHistory(AssetAllocationHistory allocationHistory);

	void saveAssetAllocation(AssetAllocation allocation);
	
	
	

	List<AssetRequest> getAllAssetRequestByLimitAndStatus(int pageNo, int perPage, String status);

	int getAllRequestsCountByStatus(String status);

	List<AssetRequest> getAllAssetRequestByLimitAndStatusAndSearch(String searchText, int pageNo, int perPage, String status);

	int getAllRequestsCountByStatusAndSearch(String searchText,String statu);

	List<AssetRequest> getAssetRequestByManagerLimitAndStatus(int pageNo, int perPage, String status, int managerId);

	int getRequestsCountByManagerStatus(String status, int managerId);

	List<AssetRequest> getAssetRequestByManagerLimitAndStatusAndSearch(String searchText, int pageNo, int perPage, String status, 
			int managerId);

	int getRequestsCountByManagerStatusAndSearch(String searchText, String status,  int managerId);

	List<AssetAllocation> getAllAllocateAssetByLimit(int pageNo, int perPage);

	int getAllocatedAssetsCount();

	List<AssetAllocation> getAllAllocateAssetByLimitAndSearch(String searchText, int pageNo, int perPage);

	int getAllocatedAssetsCountAndSearch(String searchText);

	AssetAllocation getAllocatedAssetByAsssetCode(String incentoryCode);

	List<AssetAllocation> getAllReleaseRequestByLimit(int pageNo, int perPage);

	List<AssetAllocation> getAllReleaseRequestByLimitAndSearch(String searchText, int pageNo, int perPage);

	int getReleaseRequestCount();

	int getReleaseRequestCountBySearch(String searchText);

}
