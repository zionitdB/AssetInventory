package com.AssetInventory.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AssetInventory.DTO.ResponceObject;
import com.AssetInventory.DTO.SupplierDetials;
import com.AssetInventory.Model.Material;
import com.AssetInventory.Model.Supplier;
import com.AssetInventory.Model.SupplierAccounts;
import com.AssetInventory.Model.SupplierMaterial;
import com.AssetInventory.Repository.SupplierAccountsRepo;
import com.AssetInventory.Repository.SupplierMaterialRepo;
import com.AssetInventory.Repository.SupplierRepo;

@Service
public class SupplierServiceImpl implements SupplierService {
	
	@Autowired
	SupplierRepo supplierRepo;
	@Autowired
	SupplierAccountsRepo supplierAccountsRepo;
	
	
	@Autowired
	SupplierMaterialRepo supplierMaterialRepo;
	
	
	
	@Override
	public ResponceObject addSupplierDetials(SupplierDetials supplierDetials) {
		// TODO Auto-generated method stub
		ResponceObject object = new ResponceObject();
		try { 
			Supplier supplier = supplierRepo.save(supplierDetials.getSupplier());
			List<SupplierAccounts> list=supplierDetials.getAccountDetials();
			
			if(!supplierDetials.getAccountDetials().isEmpty())  {
			for(SupplierAccounts account:supplierDetials.getAccountDetials() ){
				account.setSupplier(supplier);
				supplierAccountsRepo.save(account);
			}
			}
			object.setCode(200);
			object.setMsg("Supplier Details Saved");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			object.setCode(500);
			object.setMsg("Something wrong : Details Not Save");

		}
		
		
		return object;
	}

	@Override
	public List<Supplier> getlistSupplierByLimit(int pageNo, int perPage) {
		// TODO Auto-generated method stub
		return supplierRepo.getlistSupplierByLimit(pageNo,perPage);
	}

	@Override
	public List<Supplier> getlistSupplierLimitAndSearch(String searchText, int pageNo, int perPage) {
		// TODO Auto-generated method stub
		return supplierRepo.getlistSupplierLimitAndSearch(searchText,pageNo,perPage);
	}

	@Override
	public int getSupplierCount() {
		// TODO Auto-generated method stub
		return (int) supplierRepo.count();
	}

	@Override
	public int getgetSupplierCountAndSearch(String searchText) {
		// TODO Auto-generated method stub
		return supplierRepo.getSupplierCountAndSearch(searchText);
	}

	@Override
	public void addSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		supplierRepo.save(supplier);
	}

	@Override
	public List<Supplier> getAllActiveSupplier() {
		// TODO Auto-generated method stub
		return null;//supplierRepo.getAllActiveSupplier();
	}

	@Override
	public List<Supplier> getAllSupplier() {
		// TODO Auto-generated method stub
		return supplierRepo.findAll();
	}

	@Override
	public List<SupplierAccounts> getSupplierAccountBySupplier(int supplierId) {
		// TODO Auto-generated method stub
		return  supplierAccountsRepo.getSupplierAccountBySupplier(supplierId);
	}

	@Override
	public List<Material> getAllMaterialBySupplier(int supplierId) {
		// TODO Auto-generated method stub
		
		List<Material> list=new ArrayList<Material>();
		List<SupplierMaterial> materials=supplierMaterialRepo.findAll();
		for(SupplierMaterial material:materials) {
			list.add(material.getMaterial());
		}
		return list;
	}

}
