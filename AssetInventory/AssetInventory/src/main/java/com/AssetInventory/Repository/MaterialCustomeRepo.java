package com.AssetInventory.Repository;

import java.util.List;

import com.AssetInventory.Model.Material;

public interface MaterialCustomeRepo {
	int getMaterialsCountAndSearch(String searchText);

	List<Material> getlistMaterialsByLimit(int pageNo, int perPag);

	List<Material> getlistMaterialByLimitAndSearch(String searchText, int pageNo, int perPage);
}
