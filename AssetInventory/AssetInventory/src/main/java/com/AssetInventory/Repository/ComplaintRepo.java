package com.AssetInventory.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.AssetInventory.Model.Complaint;

public interface ComplaintRepo extends JpaRepository<Complaint, Integer>, ComplaintCustomerRepo {

	@Query("From Complaint c where c.complaintStatus='Open'")
	List<Complaint> getAllOpenComplaint();

	@Query("From Complaint c where c.engineer.employeeId=?1")
	List<Complaint> getAllComplaintByEngineer(int engineerId);

	@Query("From Complaint c where c.engineer.employeeId=?1 and c.complaintStatus='Closed'")
	List<Complaint> getAllClosedComplaintByEngineer(int engineerId);

	@Query("From Complaint c where c.complaintBy.employeeId=?1")
	List<Complaint> getAllComplaintByEmployee(int employeeId);

	@Query("select count(*) From Complaint c where c.complaintBy.employeeId=?1")

	int getEmployeesComplaintsCount(int employeeId);

	@Query("select count(*) From Complaint c where c.engineer.employeeId=?1")
	int getComplaintsCountByEngg(int engineerId);

}
