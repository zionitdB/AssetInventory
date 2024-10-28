package com.AssetInventory.Repository;

import java.util.List;

import com.AssetInventory.Model.Material;
import com.AssetInventory.Model.Supplier;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

public class MaterialCustomeRepoImpl implements MaterialCustomeRepo {
	@PersistenceContext
	EntityManager  entityManager;
	@Override
	public int getMaterialsCountAndSearch(String searchText) {
		// TODO Auto-generated method stub
		long result = (long) entityManager
				.createQuery(
						"SELECT count(e) FROM Material e where  e.materialCode LIKE :searchText OR  e.materialName LIKE :searchText OR e.materialSpecification LIKE :searchText OR e.brand.brandName LIKE :searchText OR e.category.categoryName LIKE :searchText ")
				.setParameter("searchText", "%" + searchText + "%").getSingleResult();
		int total_count = (int) result;
		return total_count;
	}

	@Override
	public List<Material> getlistMaterialsByLimit(int pageNo, int perPage) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
try {
			
			
			long result = (long) entityManager.createQuery("SELECT count(u) FROM Material u").getSingleResult();
			int total_count = (int) result;
			Query q = entityManager.createQuery("from Material e ", Material.class);
			int firstR = total_count - (pageNo * perPage);
			int maxR = total_count - ((pageNo - 1) * perPage);
			if (firstR < 0) {
				firstR = 0;
			}
			q.setFirstResult(firstR); // modify this to adjust paging
			q.setMaxResults(maxR);
			List<Material> list = q.getResultList();
			return list;
		
		
	} finally {
		// TODO: handle finally clause
		entityManager.close();
	}


	}

	@Override
	public List<Material> getlistMaterialByLimitAndSearch(String searchText, int pageNo, int perPage) {
		// TODO Auto-generated method stub
try {
			
			long result = (long) entityManager
					.createQuery(
							"SELECT count(e) FROM Material e where  e.materialCode LIKE :searchText OR  e.materialName LIKE :searchText OR e.materialSpecification LIKE :searchText OR e.brand.brandName LIKE :searchText OR e.category.categoryName LIKE :searchText ")
					.setParameter("searchText", "%" + searchText + "%").getSingleResult();
			int total_count = (int) result;
			Query q = entityManager.createQuery(
					"from Material e where  e.materialCode LIKE :searchText OR  e.materialName LIKE :searchText OR e.materialSpecification LIKE :searchText OR e.brand.brandName LIKE :searchText OR e.category.categoryName LIKE :searchText  ",
					Material.class);
			int firstR = total_count - (pageNo * perPage);
			int maxR = total_count - ((pageNo - 1) * perPage);
			if (firstR < 0) {
				firstR = 0;
			}
			q.setParameter("searchText", "%" + searchText + "%");
			q.setFirstResult(firstR); // modify this to adjust paging
			q.setMaxResults(maxR);
			List<Material> list = q.getResultList();
			return list;
		} finally {
			// TODO: handle finally clause
			entityManager.close();
		}
	}

}
