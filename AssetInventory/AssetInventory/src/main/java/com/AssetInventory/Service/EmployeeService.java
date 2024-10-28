package com.AssetInventory.Service;

import java.util.List;

import com.AssetInventory.Model.Employee;

public interface EmployeeService {

	void addEmployee(Employee employee);

	Employee getEmployeeById(int employeeId);

	List<Employee> getAllEmployee();

	List<Employee> getAllAvtiveEmployee();

	List<Employee> getlistEmployeeByLimit(int pageNo, int perPage);

	List<Employee> getlistEmployeeByLimitAndSearch(String searchText, int pageNo, int perPage);

	int getEmployeesCount();

	int getEmployeesCountAndSearch(String searchText);

	List<Employee> getAllEmployeeByManager(int employeeId);

	List<Employee> getAllManagers();

	List<Employee> getAllEngineers();

}
