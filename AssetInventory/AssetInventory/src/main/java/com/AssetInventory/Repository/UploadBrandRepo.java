package com.AssetInventory.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.AssetInventory.Model.UploadBrand;

public interface UploadBrandRepo extends JpaRepository<UploadBrand, Integer>{
	@Query("from UploadBrand where brandName=?1")
	UploadBrand getBrandByName(String brandName);
	@Query("from UploadBrand where uploadDetial.id=?1")
	List<UploadBrand> findByUserDetailsId(int id);

}
