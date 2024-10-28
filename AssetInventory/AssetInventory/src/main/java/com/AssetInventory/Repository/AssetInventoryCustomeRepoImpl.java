package com.AssetInventory.Repository;

import java.util.List;

import com.AssetInventory.Model.AssetInventory;
import com.AssetInventory.Model.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

public class AssetInventoryCustomeRepoImpl implements AssetInventoryCustomeRepo {
	@PersistenceContext
	EntityManager  entityManager;
	
	
	@Override
	public List<AssetInventory> getlistAssetInventoryByLimit(int pageNo, int perPage) {
		// TODO Auto-generated method stub
try {
			
			
			long result = (long) entityManager.createQuery("SELECT count(u) FROM AssetInventory u").getSingleResult();
			int total_count = (int) result;
			Query q = entityManager.createQuery("from AssetInventory e ", AssetInventory.class);
			int firstR = total_count - (pageNo * perPage);
			int maxR = total_count - ((pageNo - 1) * perPage);
			if (firstR < 0) {
				firstR = 0;
			}
			q.setFirstResult(firstR); // modify this to adjust paging
			q.setMaxResults(maxR);
			List<AssetInventory> list = q.getResultList();
			return list;
		
		
	} finally {
		// TODO: handle finally clause
		entityManager.close();
	}

	}

	@Override
	public List<AssetInventory> getlistAssetInventoryByLimitAndSearch(String searchText, int pageNo, int perPage) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
try {
			
			long result = (long) entityManager
					.createQuery(
							"SELECT count(e) FROM AssetInventory e where  e.incentoryCode LIKE :searchText OR  e.otherSpecification LIKE :searchText OR e.material.materialCode LIKE :searchText OR  e.material.materialName LIKE :searchText OR e.material.materialSpecification LIKE :searchText OR e.material.brand.brandName LIKE :searchText OR e.material.category.categoryName LIKE :searchText")
					.setParameter("searchText", "%" + searchText + "%").getSingleResult();
			int total_count = (int) result;
			Query q = entityManager.createQuery(
					"from AssetInventory e where  e.incentoryCode LIKE :searchText OR  e.otherSpecification LIKE :searchText OR e.material.materialCode LIKE :searchText OR  e.material.materialName LIKE :searchText OR e.material.materialSpecification LIKE :searchText OR e.material.brand.brandName LIKE :searchText OR e.material.category.categoryName LIKE :searchText",
					AssetInventory.class);
			int firstR = total_count - (pageNo * perPage);
			int maxR = total_count - ((pageNo - 1) * perPage);
			if (firstR < 0) {
				firstR = 0;
			}
			q.setParameter("searchText", "%" + searchText + "%");
			q.setFirstResult(firstR); // modify this to adjust paging
			q.setMaxResults(maxR);
			List<AssetInventory> list = q.getResultList();
			return list;
		} finally {
			// TODO: handle finally clause
			entityManager.close();
		}
	}

	@Override
	public int getAssetInventorysCountAndSearch(String searchText) {
		// TODO Auto-generated method stub
		long result = (long) entityManager
				.createQuery(
						"SELECT count(e) FROM AssetInventory e where  e.incentoryCode LIKE :searchText OR  e.otherSpecification LIKE :searchText OR e.material.materialCode LIKE :searchText OR  e.material.materialName LIKE :searchText OR e.material.materialSpecification LIKE :searchText OR e.material.brand.brandName LIKE :searchText OR e.material.category.categoryName LIKE :searchText")
				.setParameter("searchText", "%" + searchText + "%").getSingleResult();
		int total_count = (int) result;
		return total_count;
	}

}
