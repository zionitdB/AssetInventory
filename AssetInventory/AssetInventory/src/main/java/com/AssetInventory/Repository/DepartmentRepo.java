package com.AssetInventory.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.AssetInventory.Model.Department;

public interface DepartmentRepo extends JpaRepository<Department, Integer> {
	@Query("from Department d where active=1")
	List<Department> getAllActiveDepartment();
	@Query("from Department d where departmentName=?1")
	Department getDepartmentByname(String departmentName);

}
