package com.AssetInventory.DTO;

import java.util.List;

import com.AssetInventory.Model.Supplier;
import com.AssetInventory.Model.SupplierAccounts;

public class SupplierDetials {
	private Supplier supplier;
	private List<SupplierAccounts> accountDetials;
	
	
	
	
	
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public List<SupplierAccounts> getAccountDetials() {
		return accountDetials;
	}
	public void setAccountDetials(List<SupplierAccounts> accountDetials) {
		this.accountDetials = accountDetials;
	}
	
	
	
}
