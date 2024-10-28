package com.AssetInventory.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.AssetInventory.Model.Material;
import com.AssetInventory.Model.SupplierMaterial;

public interface SupplierMaterialRepo extends  JpaRepository<SupplierMaterial, Integer> {
	@Query("From SupplierMaterial s where s.material.materialId=?1")
	List<SupplierMaterial> getAllMaterialBySupplier(int supplierId);

}
