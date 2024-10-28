package com.AssetInventory.Repository;

import java.util.List;

import com.AssetInventory.Model.Supplier;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

public class SupplierCustomeRepoImpl implements SupplierCustomeRepo {
	@PersistenceContext
	EntityManager  entityManager;
	@Override
	public List<Supplier> getlistSupplierByLimit(int pageNo, int perPage) {
		// TODO Auto-generated method stub
try {
			
			
			long result = (long) entityManager.createQuery("SELECT count(u) FROM Supplier u").getSingleResult();
			int total_count = (int) result;
			Query q = entityManager.createQuery("from Supplier e ", Supplier.class);
			int firstR = total_count - (pageNo * perPage);
			int maxR = total_count - ((pageNo - 1) * perPage);
			if (firstR < 0) {
				firstR = 0;
			}
			q.setFirstResult(firstR); // modify this to adjust paging
			q.setMaxResults(maxR);
			List<Supplier> list = q.getResultList();
			return list;
		
		
	} finally {
		// TODO: handle finally clause
		entityManager.close();
	}

	}

	@Override
	public List<Supplier> getlistSupplierLimitAndSearch(String searchText, int pageNo, int perPage) {
		// TODO Auto-generated method stub
try {
			
			long result = (long) entityManager
					.createQuery(
							"SELECT count(e) FROM Supplier e where  e.supplierCode LIKE :searchText OR  e.supplierName LIKE :searchText OR e.contactPerson LIKE :searchText OR e.location LIKE :searchText ")
					.setParameter("searchText", "%" + searchText + "%").getSingleResult();
			int total_count = (int) result;
			Query q = entityManager.createQuery(
					"from Supplier e where  e.supplierCode LIKE :searchText OR  e.supplierName LIKE :searchText OR e.contactPerson LIKE :searchText OR e.location LIKE :searchText ",
					Supplier.class);
			int firstR = total_count - (pageNo * perPage);
			int maxR = total_count - ((pageNo - 1) * perPage);
			if (firstR < 0) {
				firstR = 0;
			}
			q.setParameter("searchText", "%" + searchText + "%");
			q.setFirstResult(firstR); // modify this to adjust paging
			q.setMaxResults(maxR);
			List<Supplier> list = q.getResultList();
			return list;
		} finally {
			// TODO: handle finally clause
			entityManager.close();
		}

	}

	@Override
	public int getSupplierCountAndSearch(String searchText) {
		// TODO Auto-generated method stub
		long result = (long) entityManager
				.createQuery(
						"SELECT count(e) FROM Supplier e where  e.supplierCode LIKE :searchText OR  e.supplierName LIKE :searchText OR e.contactPerson LIKE :searchText OR e.location LIKE :searchText ")
				.setParameter("searchText", "%" + searchText + "%").getSingleResult();
		int total_count = (int) result;
		return total_count;

	}

}
