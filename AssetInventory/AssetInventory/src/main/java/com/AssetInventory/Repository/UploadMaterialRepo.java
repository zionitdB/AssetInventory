package com.AssetInventory.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.AssetInventory.Model.UploadMaterial;

public interface UploadMaterialRepo extends JpaRepository<UploadMaterial, Integer>{
	@Query("from UploadMaterial where materialCode=?1")
	UploadMaterial getMaterialByCode(String materialCode);
	@Query("from UploadMaterial where uploadDetial.id=?1")
	List<UploadMaterial> findByUserDetailsId(int id);

}
