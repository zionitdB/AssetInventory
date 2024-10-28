package com.AssetInventory.Repository;

import java.util.List;

import com.AssetInventory.Model.AssetInventory;
import com.AssetInventory.Model.UploadDetial;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

public class UploadDetialCustomeRepoImpl implements UploadDetialCustomeRepo {
	@PersistenceContext
	EntityManager entityManager;
	@Override
	public List<UploadDetial> getAllUploadDetialByLimit(int pageNo, int perPage) {
		// TODO Auto-generated method stub
try {
			
			
			long result = (long) entityManager.createQuery("SELECT count(u) FROM UploadDetial u").getSingleResult();
			int total_count = (int) result;
			Query q = entityManager.createQuery("from UploadDetial e ", UploadDetial.class);
			int firstR = total_count - (pageNo * perPage);
			int maxR = total_count - ((pageNo - 1) * perPage);
			if (firstR < 0) {
				firstR = 0;
			}
			q.setFirstResult(firstR); // modify this to adjust paging
			q.setMaxResults(maxR);
			List<UploadDetial> list = q.getResultList();
			return list;
		
		
	} finally {
		// TODO: handle finally clause
		entityManager.close();
	}
	}

	@Override
	public List<UploadDetial> getUploadDetialSByLimitAndSearch(String searchText, int pageNo, int perPage) {
		// TODO Auto-generated method stub
try {
			
			long result = (long) entityManager
					.createQuery(
							"SELECT count(e) FROM UploadDetial e where  e.moduleName LIKE :searchText OR  e.fileName LIKE :searchText OR e.uploadedBy.firstName LIKE :searchText OR  e.uploadedBy.lastName LIKE :searchText OR e.approveBy.firstName LIKE :searchText OR  e.approveBy.lastName LIKE :searchText")
					.setParameter("searchText", "%" + searchText + "%").getSingleResult();
			int total_count = (int) result;
			Query q = entityManager.createQuery(
					"from UploadDetial e where  e.moduleName LIKE :searchText OR  e.fileName LIKE :searchText OR e.uploadedBy.firstName LIKE :searchText OR  e.uploadedBy.lastName LIKE :searchText OR e.approveBy.firstName LIKE :searchText OR  e.approveBy.lastName LIKE :searchText",
					UploadDetial.class);
			int firstR = total_count - (pageNo * perPage);
			int maxR = total_count - ((pageNo - 1) * perPage);
			if (firstR < 0) {
				firstR = 0;
			}
			q.setParameter("searchText", "%" + searchText + "%");
			q.setFirstResult(firstR); // modify this to adjust paging
			q.setMaxResults(maxR);
			List<UploadDetial> list = q.getResultList();
			return list;
		} finally {
			// TODO: handle finally clause
			entityManager.close();
		}
	}

	@Override
	public int getUploadDetialsCountAndSearch(String searchText) {
		// TODO Auto-generated method stub
try {
			
			long result = (long) entityManager
					.createQuery(
							"SELECT count(e) FROM UploadDetial e where  e.moduleName LIKE :searchText OR  e.fileName LIKE :searchText OR e.uploadedBy.firstName LIKE :searchText OR  e.uploadedBy.lastName LIKE :searchText OR e.approveBy.firstName LIKE :searchText OR  e.approveBy.lastName LIKE :searchText")
					.setParameter("searchText", "%" + searchText + "%").getSingleResult();
			int total_count = (int) result;
			
			return total_count;
		} finally {
			// TODO: handle finally clause
			entityManager.close();
		}
	}

}
