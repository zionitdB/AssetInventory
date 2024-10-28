package com.AssetInventory.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.AssetInventory.Model.SupplierAccounts;

public interface SupplierAccountsRepo extends JpaRepository<SupplierAccounts, Integer> {
	@Query("From SupplierAccounts s where s.supplier.supplierId=?1")
	List<SupplierAccounts> getSupplierAccountBySupplier(int supplierId);

}
