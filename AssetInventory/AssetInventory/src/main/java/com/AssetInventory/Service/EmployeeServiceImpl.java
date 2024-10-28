package com.AssetInventory.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AssetInventory.Model.Employee;
import com.AssetInventory.Repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepo employeeRepo;

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeRepo.save(employee);
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		// TODO Auto-generated method stub
		Optional<Employee> optional=employeeRepo.findById(employeeId);
		return optional.isPresent()?optional.get():null;
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepo.findAll();
	}

	@Override
	public List<Employee> getAllAvtiveEmployee() {
		// TODO Auto-generated method stub
		return employeeRepo.getAllAvtiveEmployee();
	}

	@Override
	public List<Employee> getlistEmployeeByLimit(int pageNo, int perPage) {
		// TODO Auto-generated method stub
		return employeeRepo.getlistEmployeeByLimit(pageNo,perPage);
	}

	@Override
	public List<Employee> getlistEmployeeByLimitAndSearch(String searchText, int pageNo, int perPage) {
		// TODO Auto-generated method stub
		return employeeRepo.getlistEmployeeByLimitAndSearch(searchText,pageNo,perPage);
	}

	@Override
	public int getEmployeesCount() {
		// TODO Auto-generated method stub
		return (int) employeeRepo.count();
	}

	@Override
	public int getEmployeesCountAndSearch(String searchText) {
		// TODO Auto-generated method stub
		return employeeRepo.getEmployeesCountAndSearch(searchText);
	}

	@Override
	public List<Employee> getAllEmployeeByManager(int employeeId) {
		// TODO Auto-generated method stub
		return employeeRepo.getAllEmployeeByManager();
	}

	@Override
	public List<Employee> getAllManagers() {
		// TODO Auto-generated method stub
		return employeeRepo.getAllManagers();
	}

	@Override
	public List<Employee> getAllEngineers() {
		// TODO Auto-generated method stub
		return employeeRepo.getAllEngineers();
	}

}
