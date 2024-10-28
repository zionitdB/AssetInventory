package com.AssetInventory.Repository;

import java.util.List;

import com.AssetInventory.Model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

public class UserCustomeRepoImpl implements UserCustomeRepo{
	@PersistenceContext
	EntityManager  entityManager;
	@Override
	public List<User> getUsersListByPagination(int pageNo, int perPage) {
		// TODO Auto-generated method stub
		try {
			
			
			long result = (long) entityManager.createQuery("SELECT count(u) FROM User u").getSingleResult();
			int total_count = (int) result;
			Query q = entityManager.createQuery("from User e ", User.class);
			int firstR = total_count - (pageNo * perPage);
			int maxR = total_count - ((pageNo - 1) * perPage);
			if (firstR < 0) {
				firstR = 0;
			}
			q.setFirstResult(firstR); // modify this to adjust paging
			q.setMaxResults(maxR);
			List<User> list = q.getResultList();
			return list;
		
		
	} finally {
		// TODO: handle finally clause
		entityManager.close();
	}
	}

	@Override
	public List<User> getUsersListByPaginationAndSearch(String searchText, int pageNo, int perPage) {
		// TODO Auto-generated method stub
		try {
			
			long result = (long) entityManager
					.createQuery(
							"SELECT count(e) FROM User e where  e.firstName LIKE :searchText OR  e.lastName LIKE :searchText OR e.userName LIKE :searchText OR e.role.roleName LIKE :searchText OR e.branch.branchName LIKE :searchText")
					.setParameter("searchText", "%" + searchText + "%").getSingleResult();
			int total_count = (int) result;
			Query q = entityManager.createQuery(
					"from User e where  e.firstName LIKE :searchText OR  e.lastName LIKE :searchText OR e.userName LIKE :searchText OR e.role.roleName LIKE :searchText OR e.branch.branchName LIKE :searchText",
					User.class);
			int firstR = total_count - (pageNo * perPage);
			int maxR = total_count - ((pageNo - 1) * perPage);
			if (firstR < 0) {
				firstR = 0;
			}
			q.setParameter("searchText", "%" + searchText + "%");
			q.setFirstResult(firstR); // modify this to adjust paging
			q.setMaxResults(maxR);
			List<User> list = q.getResultList();
			return list;
		} finally {
			// TODO: handle finally clause
			entityManager.close();
		}
	}

	@Override
	public int getUserCountAndSearch(String searchText) {
		// TODO Auto-generated method stub
		int total_count=0;
	try {
			
			long result = (long) entityManager
					.createQuery(
							"SELECT count(e) FROM User e where  e.firstName LIKE :searchText OR  e.lastName LIKE :searchText OR e.userName LIKE :searchText OR e.role.roleName LIKE :searchText OR e.branch.branchName LIKE :searchText")
					.setParameter("searchText", "%" + searchText + "%").getSingleResult();
			 total_count = (int) result;
			
		} finally {
			// TODO: handle finally clause
			entityManager.close();
		}
	return total_count;
	}

}
