package com.AssetInventory.Service;

import java.util.List;

import com.AssetInventory.Model.Complaint;
import com.AssetInventory.Model.ComplaintCategory;
import com.AssetInventory.Model.ComplaintImage;

public interface ComplaintService {

	String getComplaintNo();

	Complaint addCategory(Complaint complaint);

	Complaint getComplaintById(int complaintId);

	List<Complaint> getComplaintsByLimit(int pageNo, int perPage);

	List<Complaint> getComplaintsByLimitAndSearch(String searchText, int pageNo, int perPage);

	int getComplaintsCountAndSearch(String searchText);

	int getComplaintsCount();

	List<Complaint> getAllComplaint();

	List<ComplaintCategory> getComplaintCategories();

	List<Complaint> getAllOpenComplaint();

	List<Complaint> getAllComplaintByEngineer(int engineerId);

	List<Complaint> getAllClosedComplaintByEngineer(int engineerId);

	int getComplaintsCountByEngg(int engineerId);

	List<Complaint> getAllComplaintByEmployee(int employeeId);

	List<Complaint> getEnginnersComplaintsByLimit(int pageNo, int perPage, int engineerId);

	int getEnginnersComplaintsCount(int engineerId);

	List<Complaint> getEnginnersComplaintsByLimitAndSearch(String searchText, int pageNo, int perPage, int engineerId);

	int getEnginnersComplaintsCountAndSearch(String searchText, int engineerId);

	List<Complaint> getEmployeesComplaintsByLimit(int pageNo, int perPage, int employeeId);

	int getEmployeesComplaintsCount(int employeeId);

	List<Complaint> getEmployeesComplaintsByLimitAndSearch(String searchText, int pageNo, int perPage,int employeeId);

	int getEmployeesComplaintsCountAndSearch(String searchText,int employeeId);

	List<ComplaintImage> getAllComplaintImageByComplaintNo(String complaintNo);

}
