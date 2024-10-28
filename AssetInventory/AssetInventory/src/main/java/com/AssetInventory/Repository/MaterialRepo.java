package com.AssetInventory.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.AssetInventory.Model.Material;

public interface MaterialRepo extends JpaRepository<Material, Integer>,MaterialCustomeRepo{
	@Query("from Material where category.categoryId=?1 and brand.brandId=?2")
	List<Material> getMaterialByCategoryAndBrand(int categoryId, int brandId);
	@Query("from Material where active=1")

	List<Material> getAllActiveMaterial();
	@Query("from Material where materialCode=?1")
	Material getMaterialByCode(String materialCode);

	

	


	

}
