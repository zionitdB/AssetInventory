package com.AssetInventory.Repository;

import java.util.List;

import com.AssetInventory.Model.AssetRequest;
import com.AssetInventory.Model.Employee;

public interface AssetRequestCustomeRepo {
	String getNewTokon(String yeards);
	List<AssetRequest> getAllAssetRequestByLimitAndStatus(int pageNo, int perPage, String status);

	int getAllRequestsCountByStatus(String status);

	List<AssetRequest> getAllAssetRequestByLimitAndStatusAndSearch(String searchText, int pageNo, int perPage,
			String status);

	int getAllRequestsCountByStatusAndSearch(String searchText, String status);

	List<AssetRequest> getAssetRequestByManagerLimitAndStatus(int pageNo, int perPage, String status, int managerId);

	int getRequestsCountByManagerStatus(String status, int managerId);

	List<AssetRequest> getAssetRequestByManagerLimitAndStatusAndSearch(String searchText, int pageNo, int perPage,
			String status, int managerId);

	int getRequestsCountByManagerStatusAndSearch(String searchText, String status, int managerId);

}
