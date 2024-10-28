package com.AssetInventory.Repository;

import java.util.List;

import com.AssetInventory.Model.Employee;
import com.AssetInventory.Model.Material;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

public class EmployeeCustomeRepoImpl implements EmployeeCustomeRepo {
	@PersistenceContext
	EntityManager  entityManager;
	@Override
	public List<Employee> getlistEmployeeByLimit(int pageNo, int perPage) {
		// TODO Auto-generated method stub
try {
			
			
			long result = (long) entityManager.createQuery("SELECT count(u) FROM Employee u").getSingleResult();
			int total_count = (int) result;
			Query q = entityManager.createQuery("from Employee e ", Employee.class);
			int firstR = total_count - (pageNo * perPage);
			int maxR = total_count - ((pageNo - 1) * perPage);
			if (firstR < 0) {
				firstR = 0;
			}
			q.setFirstResult(firstR); // modify this to adjust paging
			q.setMaxResults(maxR);
			List<Employee> list = q.getResultList();
			return list;
		
		
	} finally {
		// TODO: handle finally clause
		entityManager.close();
	}

	}

	@Override
	public List<Employee> getlistEmployeeByLimitAndSearch(String searchText, int pageNo, int perPage) {
		// TODO Auto-generated method stub
try {
			
			long result = (long) entityManager
					.createQuery(
							"SELECT count(e) FROM Employee e where  e.emoloyeeCode LIKE :searchText OR  e.fName LIKE :searchText OR e.lName LIKE :searchText OR e.department.departmentName LIKE :searchText OR e.branch.branchName LIKE :searchText OR e.workLocation LIKE :searchText")
					.setParameter("searchText", "%" + searchText + "%").getSingleResult();
			int total_count = (int) result;
			Query q = entityManager.createQuery(
					"from Employee e where where  e.emoloyeeCode LIKE :searchText OR  e.fName LIKE :searchText OR e.lName LIKE :searchText OR e.department.departmentName LIKE :searchText OR e.branch.branchName LIKE :searchText OR e.workLocation LIKE :searchText",
					Employee.class);
			int firstR = total_count - (pageNo * perPage);
			int maxR = total_count - ((pageNo - 1) * perPage);
			if (firstR < 0) {
				firstR = 0;
			}
			q.setParameter("searchText", "%" + searchText + "%");
			q.setFirstResult(firstR); // modify this to adjust paging
			q.setMaxResults(maxR);
			List<Employee> list = q.getResultList();
			return list;
		} finally {
			// TODO: handle finally clause
			entityManager.close();
		}
	}

	@Override
	public int getEmployeesCountAndSearch(String searchText) {
		// TODO Auto-generated method stub
		long result = (long) entityManager
				.createQuery(
						"SELECT count(e) FROM Employee e where  e.emoloyeeCode LIKE :searchText OR  e.fName LIKE :searchText OR e.lName LIKE :searchText OR e.department.departmentName LIKE :searchText OR e.branch.branchName LIKE :searchText OR e.workLocation LIKE :searchText")
				.setParameter("searchText", "%" + searchText + "%").getSingleResult();
		int total_count = (int) result;
		return total_count;
	}

}
