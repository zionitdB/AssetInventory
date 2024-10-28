package com.AssetInventory.Repository;

import java.util.List;

import com.AssetInventory.Model.Complaint;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

public class ComplaintCustomerRepoImpl implements ComplaintCustomerRepo {
	@PersistenceContext
	EntityManager entityManager;
	
	
	@Override
	public List<Complaint> getComplaintsByLimit(int pageNo, int perPage) {
		// TODO Auto-generated method stub
		try {
			long result = (long) entityManager.createQuery("SELECT count(c) FROM Complaint c").getSingleResult();
			int total_count=(int) result;
			Query q = entityManager.createQuery("from Complaint", Complaint.class);
			int firstR = total_count - (pageNo * perPage);
			int maxR = total_count - ((pageNo - 1) * perPage);
			

			if(firstR<0) {
				firstR=0;
			}
		
			q.setFirstResult(firstR); // modify this to adjust paging
			q.setMaxResults(maxR);
			
			List<Complaint> list = q.getResultList();
			return list;
		} finally {
			// TODO: handle finally clause
			entityManager.close();
		}
	}

	@Override
	public List<Complaint> getComplaintsByLimitAndSearch(String searchText, int pageNo, int perPage) {
		// TODO Auto-generated method stub
		try {
			long result = (long) entityManager.createQuery("SELECT count(m) FROM Complaint m where m.complaintNo LIKE :searchText OR  m.complaintBy.fName LIKE :searchText OR m.material.materialCode LIKE :searchText OR m.material.materialName LIKE :searchText OR m.engineer.fName LIKE :searchText OR m.engineer.lName LIKE :searchText").setParameter("searchText", "%"+searchText+"%").getSingleResult();
			int total_count=(int) result;
			Query q = entityManager.createQuery("from Complaint m where  m.complaintNo LIKE :searchText OR  m.complaintBy.fName LIKE :searchText OR m.material.materialCode LIKE :searchText OR m.material.materialName LIKE :searchText OR m.engineer.fName LIKE :searchText OR m.engineer.lName LIKE :searchText", Complaint.class);
			int firstR = total_count - (pageNo * perPage);
			int maxR = total_count - ((pageNo - 1) * perPage);
			

			if(firstR<0) {
				firstR=0;
			}
			q.setParameter("searchText", "%"+searchText+"%");
			q.setFirstResult(firstR); // modify this to adjust paging
			q.setMaxResults(maxR);
			
			List<Complaint> list = q.getResultList();
			return list;
		} finally {
			// TODO: handle finally clause
			
			entityManager.close();
		}
	}

	@Override
	public int getComplaintsCountAndSearch(String searchText) {
		// TODO Auto-generated method stub
	try {
		long result = (long) entityManager.createQuery("SELECT count(m) FROM Complaint m where m.complaintNo LIKE :searchText OR  m.complaintBy.fName LIKE :searchText OR m.material.materialCode LIKE :searchText OR m.material.materialName LIKE :searchText OR m.engineer.fName LIKE :searchText OR m.engineer.lName LIKE :searchText").setParameter("searchText", "%"+searchText+"%").getSingleResult();
		int total_count=(int) result;
		return total_count;
	} finally {
		// TODO: handle finally clause
		entityManager.close();
	}
	}
	
	
	
	
	
	
	
	

	@Override
	public List<Complaint> getEnginnersComplaintsByLimit(int pageNo, int perPage, int engineerId) {
		// TODO Auto-generated method stub
		try {
			long result = (long) entityManager.createQuery("SELECT count(c) FROM Complaint c where c.engineer.employeeId=:employeeId").setParameter("employeeId", engineerId).getSingleResult();
			int total_count=(int) result;
			System.out.println("Count :: "+total_count);
			Query q = entityManager.createQuery("from Complaint c where c.engineer.employeeId=:employeeId", Complaint.class).setParameter("employeeId", engineerId);
			int firstR = total_count - (pageNo * perPage);
			int maxR = total_count - ((pageNo - 1) * perPage);
			

			if(firstR<0) {
				firstR=0;
			}
		
			q.setFirstResult(firstR); // modify this to adjust paging
			q.setMaxResults(maxR);
			
			List<Complaint> list = q.getResultList();
			return list;
		} finally {
			// TODO: handle finally clause
			entityManager.close();
		}
	}

	
	
	
	@Override
	public int getEnginnersComplaintsCount(int engineerId) {
		// TODO Auto-generated method stub
		try {
			long result = (long) entityManager.createQuery("SELECT count(c) FROM Complaint c where c.engineer.employeeId=:employeeId").setParameter("employeeId", engineerId).getSingleResult();
			int total_count=(int) result;
			return total_count;
		} finally {
			// TODO: handle finally clause
			entityManager.close();
		}
	}

	
	
	@Override
	public List<Complaint> getEnginnersComplaintsByLimitAndSearch(String searchText, int pageNo, int perPage,
			int engineerId) {
		// TODO Auto-generated method stub
		try {
			long result = (long) entityManager.createQuery("SELECT count(m) FROM Complaint m where m.engineer.employeeId=:employeeId and (m.complaintNo LIKE :searchText OR  m.complaintBy.fName LIKE :searchText OR m.material.materialCode LIKE :searchText OR m.material.materialName LIKE :searchText OR m.engineer.fName LIKE :searchText OR m.engineer.lName LIKE :searchText)").setParameter("searchText", "%"+searchText+"%").setParameter("employeeId", engineerId).getSingleResult();
			int total_count=(int) result;
			Query q = entityManager.createQuery("from Complaint m where m.engineer.employeeId=:employeeId and ( m.complaintNo LIKE :searchText OR  m.complaintBy.fName LIKE :searchText OR m.material.materialCode LIKE :searchText OR m.material.materialName LIKE :searchText OR m.engineer.fName LIKE :searchText OR m.engineer.lName LIKE :searchText)", Complaint.class);
			int firstR = total_count - (pageNo * perPage);
			int maxR = total_count - ((pageNo - 1) * perPage);
			

			if(firstR<0) {
				firstR=0;
			}
			q.setParameter("searchText", "%"+searchText+"%");
			q.setParameter("employeeId", engineerId);
			q.setFirstResult(firstR); // modify this to adjust paging
			q.setMaxResults(maxR);
			
			List<Complaint> list = q.getResultList();
			return list;
		} finally {
			// TODO: handle finally clause
			
			entityManager.close();
		}
	}
	
	
	
	
	

	@Override
	public int getEnginnersComplaintsCountAndSearch(String searchText, int engineerId) {
		// TODO Auto-generated method stub
	try {
		long result = (long) entityManager.createQuery("SELECT count(m) FROM Complaint m where m.engineer.employeeId=:employeeId and (m.complaintNo LIKE :searchText OR  m.complaintBy.fName LIKE :searchText OR m.material.materialCode LIKE :searchText OR m.material.materialName LIKE :searchText OR m.engineer.fName LIKE :searchText OR m.engineer.lName LIKE :searchText)").setParameter("searchText", "%"+searchText+"%").setParameter("employeeId", engineerId).getSingleResult();
		int total_count=(int) result;
		return total_count;
	} finally {
		// TODO: handle finally clause
		entityManager.close();
	}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	@Override
	public List<Complaint> getEmployeesComplaintsByLimit(int pageNo, int perPage, int employeeId) {
		// TODO Auto-generated method stub
		try {
			long result = (long) entityManager.createQuery("SELECT count(c) FROM Complaint c where c.complaintBy.employeeId=:employeeId").setParameter("employeeId", employeeId).getSingleResult();
			int total_count=(int) result;
			Query q = entityManager.createQuery("from Complaint c where c.complaintBy.employeeId=:employeeId", Complaint.class).setParameter("employeeId", employeeId);
			int firstR = total_count - (pageNo * perPage);
			int maxR = total_count - ((pageNo - 1) * perPage);
			

			if(firstR<0) {
				firstR=0;
			}
		
			q.setFirstResult(firstR); // modify this to adjust paging
			q.setMaxResults(maxR);
			
			List<Complaint> list = q.getResultList();
			return list;
		} finally {
			// TODO: handle finally clause
			entityManager.close();
		}
	}

	@Override
	public List<Complaint> getEmployeesComplaintsByLimitAndSearch(String searchText, int pageNo, int perPage,
			int employeeId) {
		// TODO Auto-generated method stub
		try {
			long result = (long) entityManager.createQuery("SELECT count(m) FROM Complaint m where m.complaintBy.employeeId=:employeeId and (m.complaintNo LIKE :searchText OR  m.complaintBy.fName LIKE :searchText OR m.material.materialCode LIKE :searchText OR m.material.materialName LIKE :searchText OR m.engineer.fName LIKE :searchText OR m.engineer.lName LIKE :searchText)").setParameter("searchText", "%"+searchText+"%").setParameter("employeeId", employeeId).getSingleResult();
			int total_count=(int) result;
			Query q = entityManager.createQuery("from Complaint m where m.complaintBy.employeeId=:employeeId and ( m.complaintNo LIKE :searchText OR  m.complaintBy.fName LIKE :searchText OR m.material.materialCode LIKE :searchText OR m.material.materialName LIKE :searchText OR m.engineer.fName LIKE :searchText OR m.engineer.lName LIKE :searchText)", Complaint.class);
			int firstR = total_count - (pageNo * perPage);
			int maxR = total_count - ((pageNo - 1) * perPage);
			

			if(firstR<0) {
				firstR=0;
			}
			q.setParameter("searchText", "%"+searchText+"%");
			q.setParameter("employeeId", employeeId);
			q.setFirstResult(firstR); // modify this to adjust paging
			q.setMaxResults(maxR);
			
			List<Complaint> list = q.getResultList();
			return list;
		} finally {
			// TODO: handle finally clause
			
			entityManager.close();
		}
	}

	@Override
	public int getEmployeesComplaintsCountAndSearch(String searchText, int employeeId) {
		// TODO Auto-generated method stub
		try {
			long result = (long) entityManager.createQuery("SELECT count(m) FROM Complaint m where m.complaintBy.employeeId=:employeeId and (m.complaintNo LIKE :searchText OR  m.complaintBy.fName LIKE :searchText OR m.material.materialCode LIKE :searchText OR m.material.materialName LIKE :searchText OR m.engineer.fName LIKE :searchText OR m.engineer.lName LIKE :searchText)").setParameter("searchText", "%"+searchText+"%").setParameter("employeeId", employeeId).getSingleResult();
			int total_count=(int) result;
			return total_count;
		} finally {
			// TODO: handle finally clause
			entityManager.close();
		}
	}
	@Override
	public String getMaxCode(String string) {
		// TODO Auto-generated method stub
		long result = (long) entityManager.createQuery("SELECT count(c) FROM Complaint c where  substr(c.complaintNo,1,4)=:complaintNo").setParameter("complaintNo", string).getSingleResult();
		int total_count=(int) result;
		if(total_count==0){
			return "0001";
		}else{
			String maxCode= (String) entityManager.createQuery("select MAX(c.complaintNo) from Complaint c where substr(c.complaintNo,1,4)=:complaintNo").setParameter("complaintNo", string).getSingleResult();
			String subCode="1"+maxCode.substring(4,8);
			int intCode=Integer.parseInt(subCode);
			intCode++;
			String code=String.valueOf(intCode).substring(1,5);
			return code;
		}
	}

}
