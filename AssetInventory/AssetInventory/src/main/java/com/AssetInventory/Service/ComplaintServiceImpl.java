package com.AssetInventory.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AssetInventory.Model.Complaint;
import com.AssetInventory.Model.ComplaintCategory;
import com.AssetInventory.Model.ComplaintImage;
import com.AssetInventory.Repository.ComplaintCategoryRepo;
import com.AssetInventory.Repository.ComplaintRepo;

@Service
public class ComplaintServiceImpl implements ComplaintService {
	
	@Autowired
	ComplaintRepo complaintRepo;
	@Autowired
	ComplaintCategoryRepo complaintCategoryRepo;

	@Override
	public String getComplaintNo() {
		// TODO Auto-generated method stub
		 LocalDate currentdate = LocalDate.now();
		  int currentYear = currentdate.getYear();
		  int currentMonth=currentdate.getMonthValue();
		  String month; 
		  if(currentMonth<9){
			  month ="0"+Integer.toString(currentMonth);
		  }else{
			  month=Integer.toString(currentMonth);
		  }
		  String year=Integer.toString(currentYear).substring(2,4);
		String maxCode=complaintRepo.getMaxCode(year+month);
	
		String complaintNo=year+month+maxCode;
		System.out.println("complaintNo :: "+complaintNo);
		return complaintNo;
	}

	@Override
	public Complaint addCategory(Complaint complaint) {
		// TODO Auto-generated method stub
		return complaintRepo.save(complaint);
	}

	@Override
	public Complaint getComplaintById(int complaintId) {
		// TODO Auto-generated method stub
		Optional<Complaint> optional= complaintRepo.findById(complaintId);
		return optional.isPresent()?optional.get():null;
	}

	@Override
	public List<Complaint> getComplaintsByLimit(int pageNo, int perPage) {
		// TODO Auto-generated method stub
		return complaintRepo.getComplaintsByLimit(pageNo,perPage);
	}

	@Override
	public List<Complaint> getComplaintsByLimitAndSearch(String searchText, int pageNo, int perPage) {
		// TODO Auto-generated method stub
		return complaintRepo.getComplaintsByLimitAndSearch(searchText,pageNo,perPage);
	}

	@Override
	public int getComplaintsCountAndSearch(String searchText) {
		// TODO Auto-generated method stub
		return complaintRepo.getComplaintsCountAndSearch(searchText);
	}

	@Override
	public int getComplaintsCount() {
		// TODO Auto-generated method stub
		return (int) complaintRepo.count();
	}

	@Override
	public List<Complaint> getAllComplaint() {
		// TODO Auto-generated method stub
		return complaintRepo.findAll();
	}

	@Override
	public List<ComplaintCategory> getComplaintCategories() {
		// TODO Auto-generated method stub
		return complaintCategoryRepo.findAll();
	}

	@Override
	public List<Complaint> getAllOpenComplaint() {
		// TODO Auto-generated method stub
		return complaintRepo.getAllOpenComplaint();
	}

	@Override
	public List<Complaint> getAllComplaintByEngineer(int engineerId) {
		// TODO Auto-generated method stub
		return complaintRepo.getAllComplaintByEngineer(engineerId);
	}

	@Override
	public List<Complaint> getAllClosedComplaintByEngineer(int engineerId) {
		// TODO Auto-generated method stub
		return complaintRepo.getAllClosedComplaintByEngineer(engineerId);
	}

	
	

	@Override
	public List<Complaint> getEnginnersComplaintsByLimit(int pageNo, int perPage, int engineerId) {
		// TODO Auto-generated method stub
		return complaintRepo.getEnginnersComplaintsByLimit(pageNo,perPage,engineerId);
	}

	@Override
	public int getEnginnersComplaintsCount(int engineerId) {
		// TODO Auto-generated method stub
		return complaintRepo.getEnginnersComplaintsCount(engineerId);
	}

	@Override
	public List<Complaint> getEnginnersComplaintsByLimitAndSearch(String searchText, int pageNo, int perPage, int engineerId) {
		// TODO Auto-generated method stub
		return complaintRepo.getEnginnersComplaintsByLimitAndSearch(searchText,pageNo,perPage,engineerId);
	}

	@Override
	public int getEnginnersComplaintsCountAndSearch(String searchText, int engineerId) {
		// TODO Auto-generated method stub
		return complaintRepo.getEnginnersComplaintsCountAndSearch(searchText,engineerId);
	}

	
	
	
	@Override
	public List<Complaint> getAllComplaintByEmployee(int employeeId) {
		// TODO Auto-generated method stub
		return complaintRepo.getAllComplaintByEmployee(employeeId);
	}
	@Override
	public List<Complaint> getEmployeesComplaintsByLimit(int pageNo, int perPage, int employeeId) {
		// TODO Auto-generated method stub
		return complaintRepo.getEmployeesComplaintsByLimit(pageNo,perPage,employeeId);
	}

	@Override
	public int getEmployeesComplaintsCount(int employeeId) {
		// TODO Auto-generated method stub
		return complaintRepo.getEmployeesComplaintsCount(employeeId);
	}

	@Override
	public List<Complaint> getEmployeesComplaintsByLimitAndSearch(String searchText, int pageNo, int perPage,int employeeId) {
		// TODO Auto-generated method stub
		return complaintRepo.getEmployeesComplaintsByLimitAndSearch(searchText,pageNo,perPage,employeeId);
	}

	@Override
	public int getEmployeesComplaintsCountAndSearch(String searchText,int employeeId) {
		// TODO Auto-generated method stub
		return complaintRepo.getEmployeesComplaintsCountAndSearch(searchText,employeeId);
	}

	@Override
	public List<ComplaintImage> getAllComplaintImageByComplaintNo(String complaintNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getComplaintsCountByEngg(int engineerId) {
		// TODO Auto-generated method stub
		return complaintRepo.getComplaintsCountByEngg(engineerId);
	}

	

}
