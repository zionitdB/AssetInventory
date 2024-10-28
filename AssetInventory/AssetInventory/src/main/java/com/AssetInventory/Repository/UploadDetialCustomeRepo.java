package com.AssetInventory.Repository;

import java.util.List;

import com.AssetInventory.Model.UploadDetial;

public interface UploadDetialCustomeRepo {
	List<UploadDetial> getAllUploadDetialByLimit(int pageNo, int perPage);

	List<UploadDetial> getUploadDetialSByLimitAndSearch(String searchText, int pageNo, int perPage);

	int getUploadDetialsCountAndSearch(String searchText);
}
