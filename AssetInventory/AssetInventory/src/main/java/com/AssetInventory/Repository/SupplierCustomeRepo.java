package com.AssetInventory.Repository;

import java.util.List;

import com.AssetInventory.Model.Supplier;

public interface SupplierCustomeRepo {

	List<Supplier> getlistSupplierByLimit(int pageNo, int perPage);

	List<Supplier> getlistSupplierLimitAndSearch(String searchText, int pageNo, int perPage);

	int getSupplierCountAndSearch(String searchText);
}
