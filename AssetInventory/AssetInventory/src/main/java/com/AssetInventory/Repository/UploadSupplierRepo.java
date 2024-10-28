package com.AssetInventory.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.AssetInventory.Model.UploadSupplier;

public interface UploadSupplierRepo extends JpaRepository<UploadSupplier, Integer> {
	@Query("From UploadSupplier where supplierCode=?1")
	UploadSupplier getSupplierByCode(String supplierCode);
	@Query("from UploadSupplier where uploadDetial.id=?1")
	List<UploadSupplier> findByUserDetailsId(int id);

}
