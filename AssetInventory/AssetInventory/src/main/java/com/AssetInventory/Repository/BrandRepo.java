package com.AssetInventory.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.AssetInventory.Model.Brand;

public interface BrandRepo extends JpaRepository<Brand, Integer> {
	@Query("from Brand d where active=1")
	List<Brand> getAllActiveBrands();
	@Query("from Brand d where brandName=?1")
	Brand getBrandByName(String brandName);

}
