package com.AssetInventory.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.AssetInventory.Model.UploadSubsidiary;

public interface UploadSubsidiaryRepo extends JpaRepository<UploadSubsidiary, Integer> {
	@Query("from UploadSubsidiary  where subsidiaryName=?1")
	UploadSubsidiary getSubsidiaryByName(String subsidiaryName);
	@Query("from UploadSubsidiary where uploadDetial.id=?1")
	List<UploadSubsidiary> findByUserDetailsId(int id);

}
