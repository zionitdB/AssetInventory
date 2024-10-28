package com.AssetInventory.Repository;

import java.util.List;

import com.AssetInventory.Model.Employee;

public interface EmployeeCustomeRepo {
	List<Employee> getlistEmployeeByLimit(int pageNo, int perPage);
	List<Employee> getlistEmployeeByLimitAndSearch(String searchText, int pageNo, int perPage);
	int getEmployeesCountAndSearch(String searchText);
}
