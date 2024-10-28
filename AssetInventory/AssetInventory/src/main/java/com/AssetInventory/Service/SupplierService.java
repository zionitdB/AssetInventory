package com.AssetInventory.Service;

import java.util.List;

import com.AssetInventory.DTO.ResponceObject;
import com.AssetInventory.DTO.SupplierDetials;
import com.AssetInventory.Model.Material;
import com.AssetInventory.Model.Supplier;
import com.AssetInventory.Model.SupplierAccounts;

public interface SupplierService {

	ResponceObject addSupplierDetials(SupplierDetials supplierDetials);

	List<Supplier> getlistSupplierByLimit(int pageNo, int perPage);

	List<Supplier> getlistSupplierLimitAndSearch(String searchText, int pageNo, int perPage);

	int getSupplierCount();

	int getgetSupplierCountAndSearch(String searchText);

	void addSupplier(Supplier supplier);

	List<Supplier> getAllActiveSupplier();

	List<Supplier> getAllSupplier();

	List<SupplierAccounts> getSupplierAccountBySupplier(int supplierId);

	List<Material> getAllMaterialBySupplier(int supplierId);

}
