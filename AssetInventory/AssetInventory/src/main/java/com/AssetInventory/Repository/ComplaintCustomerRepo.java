package com.AssetInventory.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AssetInventory.Model.Complaint;

public interface ComplaintCustomerRepo {
	List<Complaint> getComplaintsByLimit(int pageNo, int perPage);

	List<Complaint> getComplaintsByLimitAndSearch(String searchText, int pageNo, int perPage);

	int getComplaintsCountAndSearch(String searchText);
	
	List<Complaint> getEnginnersComplaintsByLimit(int pageNo, int perPage, int engineerId);

	int getEnginnersComplaintsCount(int engineerId);
	List<Complaint> getEnginnersComplaintsByLimitAndSearch(String searchText, int pageNo, int perPage, int engineerId);

	int getEnginnersComplaintsCountAndSearch(String searchText, int engineerId);
	
	List<Complaint> getEmployeesComplaintsByLimitAndSearch(String searchText, int pageNo, int perPage, int employeeId);

	int getEmployeesComplaintsCountAndSearch(String searchText, int employeeId);

	
	List<Complaint> getEmployeesComplaintsByLimit(int pageNo, int perPage, int employeeId);
	
	String getMaxCode(String string);


}
