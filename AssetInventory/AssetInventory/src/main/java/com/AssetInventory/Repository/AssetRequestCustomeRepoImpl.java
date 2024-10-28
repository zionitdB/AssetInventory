package com.AssetInventory.Repository;

import java.util.List;

import com.AssetInventory.Model.AssetInventory;
import com.AssetInventory.Model.AssetRequest;
import com.AssetInventory.Model.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

public class AssetRequestCustomeRepoImpl implements AssetRequestCustomeRepo {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public String getNewTokon(String yeards) {
		try {
			long result = (long) entityManager
					.createQuery("SELECT count(a) FROM AssetRequest a where  substr(a.tokenNo,1,4)=:tokenNo")
					.setParameter("tokenNo", yeards).getSingleResult();
			int total_count = (int) result;
			if (total_count == 0) {
				return "0001";
			} else {
				String maxCode = (String) entityManager
						.createQuery("select MAX(p.tokenNo) from AssetRequest p where substr(p.tokenNo,1,4)=:tokenNo")
						.setParameter("tokenNo", yeards).getSingleResult();
				String subCode = "1" + maxCode.substring(4, 8);
				int intCode = Integer.parseInt(subCode);
				intCode++;
				String code = String.valueOf(intCode).substring(1, 5);
				return code;
			}
		} finally {
			entityManager.close();
		}
	}

	@Override
	public List<AssetRequest> getAllAssetRequestByLimitAndStatus(int pageNo, int perPage, String status) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
try {
	
	long result = 0;
	Query q = null;
			if(status.equalsIgnoreCase("All")) {
				 result = (long) entityManager.createQuery("SELECT count(u) FROM AssetRequest u").getSingleResult();
				 q = entityManager.createQuery("from AssetRequest e ", AssetRequest.class);
			}else {
				 result = (long) entityManager.createQuery("SELECT count(u) FROM AssetRequest u where u.status=:status").setParameter("status", status).getSingleResult();
				 q = entityManager.createQuery("from AssetRequest u  where u.status=:status", AssetRequest.class);
					q.setParameter("status",status);
			}
			
			
			
			int total_count = (int) result;
			int firstR = total_count - (pageNo * perPage);
			int maxR = total_count - ((pageNo - 1) * perPage);
			if (firstR < 0) {
				firstR = 0;
			}
			q.setFirstResult(firstR); // modify this to adjust paging
			q.setMaxResults(maxR);
			List<AssetRequest> list = q.getResultList();
			return list;
		
		
	} finally {
		// TODO: handle finally clause
		entityManager.close();
	}
	}

	@Override
	public int getAllRequestsCountByStatus(String status) {
		// TODO Auto-generated method stub
		
		long result = 0;
		
				if(status.equalsIgnoreCase("All")) {
					 result = (long) entityManager.createQuery("SELECT count(u) FROM AssetRequest u").getSingleResult();
				}else {
					 result = (long) entityManager.createQuery("SELECT count(u) FROM AssetRequest u where u.status=:status").setParameter("status", status).getSingleResult();
					
				}
				
				
		return (int) result;
	}

	@Override
	public List<AssetRequest> getAllAssetRequestByLimitAndStatusAndSearch(String searchText, int pageNo, int perPage,
			String status) {
		// TODO Auto-generated method stub
try {
	long result ;
	Query q;
	int total_count;
	if(searchText.equalsIgnoreCase("All")) {
		 result = (long) entityManager
					.createQuery(
							"SELECT count(e) FROM AssetRequest e where  e.message LIKE :searchText OR  e.tokenNo LIKE :searchText")
					.setParameter("searchText", "%" + searchText + "%").getSingleResult();
			 total_count = (int) result;
			 q = entityManager.createQuery(
					"from AssetRequest e  where  e.message LIKE :searchText OR  e.tokenNo LIKE :searchText",
					AssetRequest.class);
			
	}else {
		 result = (long) entityManager
					.createQuery(
							"SELECT count(e) FROM AssetRequest e where  (e.message LIKE :searchText OR  e.tokenNo LIKE :searchText)  and e.status=:status")
					.setParameter("searchText", "%" + searchText + "%").setParameter("status",status).getSingleResult();
			 total_count = (int) result;
			 q = entityManager.createQuery(
					"from AssetRequest e  where  (e.message LIKE :searchText OR  e.tokenNo LIKE :searchText)  and e.status=:status",
					AssetRequest.class);
			 q.setParameter("status",status);
			
	}
			
			
			
			
			
			
			int firstR = total_count - (pageNo * perPage);
			int maxR = total_count - ((pageNo - 1) * perPage);
			if (firstR < 0) {
				firstR = 0;
			}
			q.setParameter("searchText", "%" + searchText + "%");
			q.setFirstResult(firstR); // modify this to adjust paging
			q.setMaxResults(maxR);
			List<AssetRequest> list = q.getResultList();
			return list;
		} finally {
			// TODO: handle finally clause
			entityManager.close();
		}
	}

	@Override
	public int getAllRequestsCountByStatusAndSearch(String searchText, String status) {
		// TODO Auto-generated method stub
		
		
		try {
			long result ;
			Query q;
			int total_count;
			if(searchText.equalsIgnoreCase("All")) {
				 result = (long) entityManager
							.createQuery(
									"SELECT count(e) FROM AssetRequest e where  e.message LIKE :searchText OR  e.tokenNo LIKE :searchText")
							.setParameter("searchText", "%" + searchText + "%").getSingleResult();
					 total_count = (int) result;
				
			}else {
				 result = (long) entityManager
							.createQuery(
									"SELECT count(e) FROM AssetRequest e where  (e.message LIKE :searchText OR  e.tokenNo LIKE :searchText)  and e.status=:status")
							.setParameter("searchText", "%" + searchText + "%").setParameter("status",status).getSingleResult();
					 total_count = (int) result;
				
					
			}
					
					
					
					
					
					
					return total_count;
				} finally {
					// TODO: handle finally clause
					entityManager.close();
				}
	}

	@Override
	public List<AssetRequest> getAssetRequestByManagerLimitAndStatus(int pageNo, int perPage, String status,
			int managerId) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
try {
	
	long result = 0;
	Query q = null;
			if(status.equalsIgnoreCase("All")) {
				 result = (long) entityManager.createQuery("SELECT count(u) FROM AssetRequest u where u.requested_by=:managerId").setParameter("managerId",managerId).getSingleResult();
				 q = entityManager.createQuery("from AssetRequest u where u.requested_by=:managerId", AssetRequest.class);
				
					q.setParameter("managerId",managerId);
			}else {
				 result = (long) entityManager.createQuery("SELECT count(u) FROM AssetRequest u where u.status=:status and u.requested_by=:managerId").setParameter("status", status).setParameter("managerId",managerId).getSingleResult();
				 q = entityManager.createQuery("from AssetRequest u  where u.status=:status and u.requested_by=:managerId ", AssetRequest.class);
					q.setParameter("status",status);
					q.setParameter("managerId",managerId);
			}
			
			
			
			int total_count = (int) result;
			int firstR = total_count - (pageNo * perPage);
			int maxR = total_count - ((pageNo - 1) * perPage);
			if (firstR < 0) {
				firstR = 0;
			}
			q.setFirstResult(firstR); // modify this to adjust paging
			q.setMaxResults(maxR);
			List<AssetRequest> list = q.getResultList();
			return list;
		
		
	} finally {
		// TODO: handle finally clause
		entityManager.close();
	}
	}

	@Override
	public int getRequestsCountByManagerStatus(String status, int managerId) {
		// TODO Auto-generated method stub
		long result = 0;
		if(status.equalsIgnoreCase("All")) {
			 result = (long) entityManager.createQuery("SELECT count(u) FROM AssetRequest u where u.requested_by=:managerId").setParameter("managerId",managerId).getSingleResult();
			
		}else {
			 result = (long) entityManager.createQuery("SELECT count(u) FROM AssetRequest u where u.status=:status and u.requested_by=:managerId").setParameter("status", status).setParameter("managerId",managerId).getSingleResult();
			
		}
		
		return (int) result;
	}

	@Override
	public List<AssetRequest> getAssetRequestByManagerLimitAndStatusAndSearch(String searchText, int pageNo, int perPage,
			String status, int managerId) {
		// TODO Auto-generated method stub
		try {
			long result ;
			Query q;
			int total_count;
			if(searchText.equalsIgnoreCase("All")) {
				 result = (long) entityManager
							.createQuery(
									"SELECT count(e) FROM AssetRequest e where  (e.message LIKE :searchText OR  e.tokenNo LIKE :searchText) and e.requested_by=:managerId")
							.setParameter("searchText", "%" + searchText + "%").setParameter("managerId",managerId).getSingleResult();
					 total_count = (int) result;
					 q = entityManager.createQuery(
							"from AssetRequest e  where  (e.message LIKE :searchText OR  e.tokenNo LIKE :searchText) and e.requested_by=:managerId",
							AssetRequest.class);
					
					 q.setParameter("managerId",status);
					
			}else {
				 result = (long) entityManager
							.createQuery(
									"SELECT count(e) FROM AssetRequest e where  (e.message LIKE :searchText OR  e.tokenNo LIKE :searchText)  and e.status=:status and e.requested_by=:managerId")
							.setParameter("searchText", "%" + searchText + "%").setParameter("status",status).setParameter("status",status).getSingleResult();
					 total_count = (int) result;
					 q = entityManager.createQuery(
							"from AssetRequest e  where  (e.message LIKE :searchText OR  e.tokenNo LIKE :searchText)  and e.status=:status and e.requested_by=:managerId",
							AssetRequest.class);
					 q.setParameter("status",status);
					 q.setParameter("managerId",managerId);
					
			}
					
					
					
					
					
					
					int firstR = total_count - (pageNo * perPage);
					int maxR = total_count - ((pageNo - 1) * perPage);
					if (firstR < 0) {
						firstR = 0;
					}
					q.setParameter("searchText", "%" + searchText + "%");
					q.setFirstResult(firstR); // modify this to adjust paging
					q.setMaxResults(maxR);
					List<AssetRequest> list = q.getResultList();
					return list;
				} finally {
					// TODO: handle finally clause
					entityManager.close();
				}
	}

	@Override
	public int getRequestsCountByManagerStatusAndSearch(String searchText, String status, int managerId) {
		// TODO Auto-generated method stub
		long result ;
	
		int total_count;
		if(searchText.equalsIgnoreCase("All")) {
			 result = (long) entityManager
						.createQuery(
								"SELECT count(e) FROM AssetRequest e where  (e.message LIKE :searchText OR  e.tokenNo LIKE :searchText) and e.requested_by=:managerId")
						.setParameter("searchText", "%" + searchText + "%").setParameter("managerId",managerId).getSingleResult();
				 total_count = (int) result;
				
				
		}else {
			 result = (long) entityManager
						.createQuery(
								"SELECT count(e) FROM AssetRequest e where  (e.message LIKE :searchText OR  e.tokenNo LIKE :searchText)  and e.status=:status and e.requested_by=:managerId")
						.setParameter("searchText", "%" + searchText + "%").setParameter("status",status).setParameter("status",status).getSingleResult();
				 total_count = (int) result;
			
				
		}
		return total_count;
	}

}
