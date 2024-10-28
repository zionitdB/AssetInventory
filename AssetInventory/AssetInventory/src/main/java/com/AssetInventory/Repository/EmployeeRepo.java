package com.AssetInventory.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.AssetInventory.Model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>,EmployeeCustomeRepo {
	@Query("from Employee where active =1")
	List<Employee> getAllAvtiveEmployee();
	@Query("from Employee e where e.managerId=?1")
	List<Employee> getAllEmployeeByManager();
	@Query("from Employee e where e.designation.designationId=2")
	List<Employee> getAllManagers();
	@Query("from Employee e where e.designation.designationId=3")
	List<Employee> getAllEngineers();
	@Query("from Employee e where e.emoloyeeCode=?1")
	Employee getEmployeeByCode(String employeeCode);

	
	
	


}
