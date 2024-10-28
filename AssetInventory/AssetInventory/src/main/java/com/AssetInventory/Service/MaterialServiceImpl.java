package com.AssetInventory.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AssetInventory.Model.AssetInventory;
import com.AssetInventory.Model.Brand;
import com.AssetInventory.Model.Category;
import com.AssetInventory.Model.Material;
import com.AssetInventory.Model.UnitOfMeasurement;
import com.AssetInventory.Repository.AssetInventoryRepo;
import com.AssetInventory.Repository.BrandRepo;
import com.AssetInventory.Repository.CategoryRepo;
import com.AssetInventory.Repository.MaterialRepo;
import com.AssetInventory.Repository.UnitOfMeasurementRepo;
@Service
public class MaterialServiceImpl implements MaterialService {
	
	
	@Autowired
	MaterialRepo materialRepo;
	@Autowired
	BrandRepo brandRepo;
	@Autowired
	CategoryRepo categoryRepo; 
	@Autowired
	UnitOfMeasurementRepo unitOfMeasurementRepo;
	@Autowired
	AssetInventoryRepo assetInventoryRepo;
	
	@Override
	public Material addMaterial(Material material) {
		// TODO Auto-generated method stub
		return materialRepo.save(material);
	}



	@Override
	public int getMaterialsCount() {
		// TODO Auto-generated method stub
		return (int) materialRepo.count();
	}



	@Override
	public int getMaterialsCountAndSearch(String searchText) {
		// TODO Auto-generated method stub
		return materialRepo.getMaterialsCountAndSearch(searchText);
	}



	@Override
	public List<Material> getlistMaterialsByLimit(int pageNo, int perPag) {
		// TODO Auto-generated method stub
		return materialRepo.getlistMaterialsByLimit(pageNo,perPag);
	}



	@Override
	public List<Material> getlistMaterialByLimitAndSearch(String searchText, int pageNo, int perPage) {
		// TODO Auto-generated method stub
		return materialRepo.getlistMaterialByLimitAndSearch(searchText,pageNo,perPage);
	}



	@Override
	public List<Material> getMaterialByCategoryAndBrand(int categoryId, int brandId) {
		// TODO Auto-generated method stub
		return materialRepo.getMaterialByCategoryAndBrand(categoryId,brandId);
	}



	@Override
	public Category addCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryRepo.save(category);
	}



	@Override
	public Brand addBrand(Brand brand) {
		// TODO Auto-generated method stub
		return brandRepo.save(brand);
	}



	@Override
	public List<Brand> getAllBrand() {
		// TODO Auto-generated method stub
		return brandRepo.findAll();
	}



	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return categoryRepo.findAll();
	}



	@Override
	public List<Material> getAllActiveMaterial() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Material> getAllMaterial() {
		// TODO Auto-generated method stub
		return materialRepo.findAll();
	}



	@Override
	public UnitOfMeasurement addUnitOfMeasurement(UnitOfMeasurement unitOfMeasurement) {
		// TODO Auto-generated method stub
		return unitOfMeasurementRepo.save(unitOfMeasurement);
	}



	@Override
	public List<UnitOfMeasurement> getAllUnitOfMeasurement() {
		// TODO Auto-generated method stub
		return unitOfMeasurementRepo.findAll();
	}





	@Override
	public void deleteMaterial(Material material) {
		// TODO Auto-generated method stub
		materialRepo.delete(material);
	}


}
