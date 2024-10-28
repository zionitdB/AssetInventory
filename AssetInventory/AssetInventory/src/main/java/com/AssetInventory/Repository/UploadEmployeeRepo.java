package com.AssetInventory.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.AssetInventory.Model.UploadEmployee;

public interface UploadEmployeeRepo extends JpaRepository<UploadEmployee, Integer> {
	@Query("from UploadEmployee where emoloyeeCode=?1")
	UploadEmployee getEmployeeByCode(String employeeCode);
	@Query("from UploadEmployee where uploadDetial.id=?1")
	List<UploadEmployee> findByUserDetailsId(int id);

}
