package com.AssetInventory.Repository;

import java.util.List;

import com.AssetInventory.Model.AssetAllocation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

public class AssetAllocationCustomeRepoImpl implements AssetAllocationCustomeRepo {
	@PersistenceContext
	EntityManager  entityManager;
	@Override
	public List<AssetAllocation> getAllAllocateAssetByLimit(int pageNo, int perPage) {
		// TODO Auto-generated method stub
		try {
			long result = (long) entityManager.createQuery("SELECT count(e) FROM AssetAllocation e where e.isReleased=0 ").getSingleResult();
			int total_count=(int) result;
			Query q = entityManager.createQuery("from AssetAllocation e where e.isReleased=0 ", AssetAllocation.class);
			int firstR = total_count - (pageNo * perPage);
			int maxR = total_count - ((pageNo - 1) * perPage);
			

			if(firstR<0) {
				firstR=0;
			}
		
			q.setFirstResult(firstR); // modify this to adjust paging
			q.setMaxResults(maxR);
			
			List<AssetAllocation> list = q.getResultList();
			return list;
		} finally {
			// TODO: handle finally clause
			entityManager.close();
		}
	}

	@Override
	public List<AssetAllocation> getAllAllocateAssetByLimitAndSearch(String searchText, int pageNo, int perPage) {
		// TODO Auto-generated method stub
		try {
			long result = (long) entityManager.createQuery("SELECT count(e) FROM AssetAllocation e where e.isReleased=0 and (e.requestedtokenNo LIKE :searchText OR  e.allocationTo LIKE :searchText OR e.employee.fName LIKE :searchText OR e.project.projectName LIKE :searchText OR e.department.departmentName LIKE :searchText OR e.room.roomName LIKE :searchText OR e.desk.deskCode LIKE :searchText OR e.material.materialName LIKE :searchText OR e.assetCode LIKE :searchText OR e.material.materialCode LIKE :searchText)").setParameter("searchText", "%"+searchText+"%").getSingleResult();

			
			int total_count=(int) result;
			Query q = entityManager.createQuery("from AssetAllocation e where e.isReleased=0 and ( e.requestedtokenNo LIKE :searchText OR  e.allocationTo LIKE :searchText OR e.employee.fName LIKE :searchText OR e.project.projectName LIKE :searchText OR e.department.departmentName LIKE :searchText OR e.room.roomName LIKE :searchText OR e.desk.deskCode LIKE :searchText OR e.material.materialName LIKE :searchText OR e.assetCode LIKE :searchText OR e.material.materialCode LIKE :searchText)", AssetAllocation.class);
			int firstR = total_count - (pageNo * perPage);
			int maxR = total_count - ((pageNo - 1) * perPage);
			

			if(firstR<0) {
				firstR=0;
			}
			q.setParameter("searchText", "%"+searchText+"%");
			q.setFirstResult(firstR); // modify this to adjust paging
			q.setMaxResults(maxR);
			
			List<AssetAllocation> list = q.getResultList();
			return list;
		} finally {
			// TODO: handle finally clause
			entityManager.close();
		}
	}

	@Override
	public int getAllocatedAssetsCountAndSearch(String searchText) {
		// TODO Auto-generated method stub
		try {
	long result = (long) entityManager.createQuery("SELECT count(e) FROM AssetAllocation e where e.isReleased=0 and (e.requestedtokenNo LIKE :searchText OR  e.allocationTo LIKE :searchText OR e.employee.fName LIKE :searchText OR e.project.projectName LIKE :searchText OR e.department.departmentName LIKE :searchText OR e.room.roomName LIKE :searchText OR e.desk.deskCode LIKE :searchText OR e.material.materialName LIKE :searchText OR e.assetCode LIKE :searchText OR e.material.materialCode LIKE :searchText)").setParameter("searchText", "%"+searchText+"%").getSingleResult();

			
			int total_count=(int) result;
			return total_count;
		} finally {
			// TODO: handle finally clause
			entityManager.close();
		}
		
	}

	@Override
	public List<AssetAllocation> getAllReleaseRequestByLimit(int pageNo, int perPage) {
		// TODO Auto-generated method stub
		try {
			long result = (long) entityManager.createQuery("SELECT count(e) FROM AssetAllocation e where e.releaseRequest=1").getSingleResult();
			int total_count=(int) result;
			Query q = entityManager.createQuery("from AssetAllocation e where e.releaseRequest=1 ", AssetAllocation.class);
			int firstR = total_count - (pageNo * perPage);
			int maxR = total_count - ((pageNo - 1) * perPage);
			

			if(firstR<0) {
				firstR=0;
			}
		
			q.setFirstResult(firstR); // modify this to adjust paging
			q.setMaxResults(maxR);
			
			List<AssetAllocation> list = q.getResultList();
			return list;
		} finally {
			// TODO: handle finally clause
			entityManager.close();
		}
	}

	@Override
	public List<AssetAllocation> getAllReleaseRequestByLimitAndSearch(String searchText, int pageNo, int perPage) {
		// TODO Auto-generated method stub
		try {
			long result = (long) entityManager.createQuery("SELECT count(e) FROM AssetAllocation e where e.releaseRequest=1 and (e.requestedtokenNo LIKE :searchText OR  e.allocationTo LIKE :searchText)").setParameter("searchText", "%"+searchText+"%").getSingleResult();

			
			int total_count=(int) result;
			Query q = entityManager.createQuery("from AssetAllocation e where e.releaseRequest=1 and (e.requestedtokenNo LIKE :searchText OR  e.allocationTo LIKE :searchText)", AssetAllocation.class);
				
			
			int firstR = total_count - (pageNo * perPage);
			int maxR = total_count - ((pageNo - 1) * perPage);
			

			if(firstR<0) {
				firstR=0;
			}
			q.setParameter("searchText", "%"+searchText+"%");
			q.setFirstResult(firstR); // modify this to adjust paging
			q.setMaxResults(maxR);
			
			List<AssetAllocation> list = q.getResultList();
			
			
			return list;
			
		} finally {
			// TODO: handle finally clause
			entityManager.close();
		}
	}

	@Override
	public int getReleaseRequestCount() {
		// TODO Auto-generated method stub
		int total_count;
		try {
			long result = (long) entityManager.createQuery("SELECT count(e) FROM AssetAllocation e where e.releaseRequest=1").getSingleResult();
			 total_count=(int) result;
		} finally {
			// TODO: handle finally clause
		}
		return total_count;
	}

	@Override
	public int getReleaseRequestCountBySearch(String searchText) {
		// TODO Auto-generated method stub
		try {
	long result = (long) entityManager.createQuery("SELECT count(e) FROM AssetAllocation e where e.releaseRequest=1 and (e.requestedtokenNo LIKE :searchText OR  e.allocationTo LIKE :searchText) ").setParameter("searchText", "%"+searchText+"%").getSingleResult();

			
			int total_count=(int) result;
			
			return total_count;
		} finally {
			// TODO: handle finally clause
			entityManager.close();
		}
		
	}

}
