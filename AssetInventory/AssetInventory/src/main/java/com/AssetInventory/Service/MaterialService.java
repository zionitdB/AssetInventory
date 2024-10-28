package com.AssetInventory.Service;

import java.util.List;

import com.AssetInventory.Model.Brand;
import com.AssetInventory.Model.Category;
import com.AssetInventory.Model.Material;
import com.AssetInventory.Model.UnitOfMeasurement;

public interface MaterialService {

	Material addMaterial(Material material);

	int getMaterialsCount();

	int getMaterialsCountAndSearch(String searchText);

	List<Material> getlistMaterialsByLimit(int pageNo, int perPag);

	List<Material> getlistMaterialByLimitAndSearch(String searchText, int pageNo, int perPage);

	List<Material> getMaterialByCategoryAndBrand(int categoryId, int brandId);

	Category addCategory(Category category);

	Brand addBrand(Brand brand);

	List<Brand> getAllBrand();

	List<Category> getAllCategory();

	List<Material> getAllActiveMaterial();

	List<Material> getAllMaterial();

	UnitOfMeasurement addUnitOfMeasurement(UnitOfMeasurement unitOfMeasurement);

	List<UnitOfMeasurement> getAllUnitOfMeasurement();


	void deleteMaterial(Material material);

}
