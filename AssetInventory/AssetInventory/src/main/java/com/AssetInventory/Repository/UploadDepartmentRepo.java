package com.AssetInventory.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.AssetInventory.Model.UploadDepartment;

public interface UploadDepartmentRepo extends JpaRepository<UploadDepartment, Integer> {
	@Query("from UploadDepartment where departmentName=?1")
	UploadDepartment getDepartmentByname(String departmentName);
	@Query("from UploadDepartment where uploadDetial.id=?1")
	List<UploadDepartment> findByUserDetailsId(int id);

}
