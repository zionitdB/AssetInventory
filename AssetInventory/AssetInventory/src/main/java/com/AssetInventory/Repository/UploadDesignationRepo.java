package com.AssetInventory.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.AssetInventory.Model.UploadDesignation;

public interface UploadDesignationRepo extends JpaRepository<UploadDesignation, Integer> {
	@Query("from UploadDesignation where designationName=?1")
	UploadDesignation getDesignationByName(String designationName);
	@Query("from UploadDesignation where uploadDetial.id=?1")
	List<UploadDesignation> findByUserDetailsId(int id);

}
