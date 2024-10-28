package com.AssetInventory.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.AssetInventory.DTO.ResponceObject;
import com.AssetInventory.Model.Complaint;
import com.AssetInventory.Model.ComplaintCategory;
import com.AssetInventory.Model.ComplaintImage;
import com.AssetInventory.Model.Employee;
import com.AssetInventory.Model.Material;
import com.AssetInventory.Repository.EmployeeRepo;
import com.AssetInventory.Service.ComplaintService;

@Controller
@CrossOrigin(origins = "*") 
@RequestMapping("/complaint")
public class ComplaintController {
	
@Autowired
EmployeeRepo employeeRepo;
@Autowired
ComplaintService complaintServices;
	
	@RequestMapping(value = "/addNewComplaint", method = RequestMethod.POST)
	public @ResponseBody ResponceObject addNewComplaint(@RequestBody Complaint complaint) {
		ResponceObject responceObject = new ResponceObject();
		try {
			Optional<Employee> emp1=employeeRepo.findById(complaint.getComplaintBy().getEmployeeId());
			
			String complaintNo=complaintServices.getComplaintNo();
			complaint.setComplaintNo(complaintNo);
			complaint.setComplaintStatus("Open");
			complaint.setComplaintDate(new Date());
		
			Complaint complaint2= complaintServices.addCategory(complaint);
			

			
			
			responceObject.setCode(200);
			responceObject.setMsg("Complaint Added Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.toString());
			responceObject.setCode(500);
			responceObject.setMsg("Something Wrong");
		}
		return responceObject;
	}

	
	@RequestMapping(value = "/assignEngg", method = RequestMethod.POST)
	public @ResponseBody ResponceObject assignEngg(@RequestBody Complaint complaint) {
		ResponceObject responceObject = new ResponceObject();
		try {
			complaint.setInprocessDate(new Date());
			complaint.setComplaintStatus("Pending");
			long diff=new Date().getTime()-complaint.getComplaintDate().getTime();
			int diffDay=(int) (diff/(24*60*60*1000));
			System.out.println("diffDay:: "+diffDay);
			complaint.setInprocessTimeTaken(String.valueOf(diffDay));
			Complaint complaint2= complaintServices.addCategory(complaint);
			System.out.println("INPROCESS DATE : "+complaint.getInprocessDate());
			
			responceObject.setCode(200);
			responceObject.setMsg("Employee Assigned Successfully");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.toString());
			responceObject.setCode(500);
			responceObject.setMsg("Something Wrong");
		}
		return responceObject;
	}
	
	@RequestMapping(value = "/updateComplaint", method = RequestMethod.POST)
	public @ResponseBody ResponceObject updateComplaint(@RequestBody Complaint complaint1) {
		ResponceObject responceObject = new ResponceObject();
		try {
			System.out.println("WorkDone :: "+complaint1.getWorkDone());
			System.out.println("Remark :: "+complaint1.getRemark());

			Complaint complaint= complaintServices.getComplaintById(complaint1.getComplaintId());
			complaint.setWorkDone(complaint1.getWorkDone());
			complaint.setRemark(complaint1.getRemark());
			complaint.setComplaintStatus(complaint1.getComplaintStatus());
			System.out.println("COmplaint :: "+complaint.toString());
			if(complaint.getComplaintStatus().equalsIgnoreCase("Closed")){
				System.out.println("complaint.getInprocessDate() :: "+complaint.getInprocessDate());
				long diff;
				if(complaint.getInprocessDate()==null){
					 diff=new Date().getTime()-complaint.getComplaintDate().getTime();

				}else{
					 diff=new Date().getTime()-complaint.getInprocessDate().getTime();

				}
				System.out.println("Closed :: "+complaint.getComplaintStatus());
				int diffDay=(int) (diff/(24*60*60*1000));
				complaint.setCloseTimeTaken(String.valueOf(diffDay));
				System.out.println("diffDay:: "+diffDay);
				complaint.setComplaintCloseDate(new Date());
				 complaintServices.addCategory(complaint);

				/****************************Mail for Employee**************************************/
				
			
			}else{
				complaint.setInprocessDate(new Date());
				complaint.setComplaintStatus("InProcess");
				complaintServices.addCategory(complaint);

			}
			
			
			responceObject.setCode(200);
			responceObject.setMsg("Complaint update Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.toString());
			responceObject.setCode(500);
			responceObject.setMsg("Something Wrong");
		}
		return responceObject;
	}
	
	
	
	// All Complaint By Pagination 
	@RequestMapping(value = "/getComplaintsByLimit", method = RequestMethod.GET)
	public @ResponseBody List<Complaint> getComplaintsByLimit(@RequestParam("pageNo") int pageNo,@RequestParam("perPage") int perPage) {
		List<Complaint> list= new  ArrayList<Complaint>();
		try {	
			list=complaintServices.getComplaintsByLimit(pageNo,perPage);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@RequestMapping(value = "/getComplaintsByLimitAndSearch", method = RequestMethod.GET)
	public @ResponseBody List<Complaint> getComplaintsByLimitAndSearch(@RequestParam("searchText") String searchText,@RequestParam("pageNo") int pageNo,@RequestParam("perPage") int perPage) {
		List<Complaint> list= new  ArrayList<Complaint>();
		try {	
			list=complaintServices.getComplaintsByLimitAndSearch(searchText,pageNo,perPage);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@RequestMapping(value = "/getComplaintsCountAndSearch", method = RequestMethod.GET)
	public @ResponseBody int  getComplaintsCountAndSearch(@RequestParam ("searchText") String searchText) {
		int  supplierCount= 0;
		try {
			supplierCount= complaintServices.getComplaintsCountAndSearch(searchText);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return supplierCount;
	}

	// All Complaint Count 
	@RequestMapping(value = "/getComplaintsCount", method = RequestMethod.GET)
	public @ResponseBody int  getComplaintsCount() {
		int  supplierCount= 0;
		try {
			supplierCount= complaintServices.getComplaintsCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return supplierCount;
	}
	// Get All Complaint List
	@RequestMapping(value = "/getAllComplaint", method = RequestMethod.GET)
	public @ResponseBody List<Complaint> getAllComplaint() {
		List<Complaint> complaints = null;
		try {
			complaints = complaintServices.getAllComplaint();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return complaints;
	}
	
	// Get All Complaint List
	@RequestMapping(value = "/getComplaintCategories", method = RequestMethod.GET)
	public @ResponseBody List<ComplaintCategory> getComplaintCategories() {
		List<ComplaintCategory> complaintCategories = new ArrayList<ComplaintCategory>();
		try {
			complaintCategories = complaintServices.getComplaintCategories();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return complaintCategories;
	}
	// Get All Open Complaint List
	@RequestMapping(value = "/getAllOpenComplaint", method = RequestMethod.GET)
	public @ResponseBody List<Complaint> getAllOpenComplaint() {
		List<Complaint> complaints = null;
		try {
			complaints = complaintServices.getAllOpenComplaint();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return complaints;
	}
	
	
	
	
	
	
	/*************************************************** Complaints By Engineer ************************************/	

	// Get All  Complaints ByEngineer
	@RequestMapping(value = "/getAllComplaintByEngineer", method = RequestMethod.GET)
	public @ResponseBody List<Complaint> getAllComplaintByEngineer(@RequestParam("engineerId") int engineerId) {
		List<Complaint> complaints = null;
		try {
			complaints = complaintServices.getAllComplaintByEngineer(engineerId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return complaints;
	}	
	// Get All  Complaints ByEngineer
	@RequestMapping(value = "/getAllClosedComplaintByEngineer", method = RequestMethod.GET)
	public @ResponseBody List<Complaint> getAllClosedComplaintByEngineer(@RequestParam("engineerId") int engineerId) {
		List<Complaint> complaints = null;
		try {
			complaints = complaintServices.getAllClosedComplaintByEngineer(engineerId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return complaints;
	}
	
	
	
	
	
	// All Complaint By Pagination and Engineer
	@RequestMapping(value = "/getEnginnersComplaintsByLimit", method = RequestMethod.GET)
	public @ResponseBody List<Complaint> getEnginnersComplaintsByLimit(@PathVariable("pageNo") int pageNo,@PathVariable("perPage") int perPage,@PathVariable("engineerId") int engineerId) {
		List<Complaint> list= new  ArrayList<Complaint>();
		try {	
		
			list=complaintServices.getEnginnersComplaintsByLimit(pageNo,perPage,engineerId);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	// All Complaint Count By Engineer
	@RequestMapping(value = "/getEnginnersComplaintsCount", method = RequestMethod.GET)
	public @ResponseBody int  getEnginnersComplaintsCount(@RequestParam("engineerId") int engineerId) {
		int  supplierCount= 0;
		try {
			supplierCount= complaintServices.getEnginnersComplaintsCount(engineerId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return supplierCount;
	}
	
	
	@RequestMapping(value = "/getEnginnersComplaintsByLimitAndSearch", method = RequestMethod.GET)
	public @ResponseBody List<Complaint> getEnginnersComplaintsByLimitAndSearch(@RequestParam("searchText") String searchText,@RequestParam("pageNo") int pageNo,@RequestParam("perPage") int perPage,@PathVariable("engineerId") int engineerId) {
		List<Complaint> list= new  ArrayList<Complaint>();
		try {	
			list=complaintServices.getEnginnersComplaintsByLimitAndSearch(searchText,pageNo,perPage,engineerId);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@RequestMapping(value = "/getEnginnersComplaintsCountAndSearch", method = RequestMethod.GET)
	public @ResponseBody int  getEnginnersComplaintsCountAndSearch(@RequestParam ("searchText") String searchText,@PathVariable("engineerId") int engineerId) {
		int  supplierCount= 0;
		try {
			supplierCount= complaintServices.getEnginnersComplaintsCountAndSearch(searchText,engineerId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return supplierCount;
	}
	
	
	
	
	
	
	
	
	/***************************************************************************************/

	
	
	
	// All Complaint By Pagination and Employee
		@RequestMapping(value = "/getEmployeesComplaintsByLimit", method = RequestMethod.GET)
		public @ResponseBody List<Complaint> getEmployeesComplaintsByLimit(@PathVariable("pageNo") int pageNo,@PathVariable("perPage") int perPage,@PathVariable("employeeId") int employeeId) {
			List<Complaint> list= new  ArrayList<Complaint>();
			try {	
			
				list=complaintServices.getEmployeesComplaintsByLimit(pageNo,perPage,employeeId);
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		// All Complaint Count By Engineer
		@RequestMapping(value = "/getEmployeesComplaintsCount", method = RequestMethod.GET)
		public @ResponseBody int  getEmployeesComplaintsCount(@RequestParam("employeeId") int employeeId) {
			int  supplierCount= 0;
			try {
				supplierCount= complaintServices.getEmployeesComplaintsCount(employeeId);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return supplierCount;
		}
		
		
		@RequestMapping(value = "/getEmployeesComplaintsByLimitAndSearch", method = RequestMethod.GET)
		public @ResponseBody List<Complaint> getEmployeesComplaintsByLimitAndSearch(@RequestParam("searchText") String searchText,@RequestParam("pageNo") int pageNo,@RequestParam("perPage") int perPage,@PathVariable("employeeId") int employeeId) {
			List<Complaint> list= new  ArrayList<Complaint>();
			try {	
				list=complaintServices.getEmployeesComplaintsByLimitAndSearch(searchText,pageNo,perPage,employeeId);
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		@RequestMapping(value = "/getEmployeesComplaintsCountAndSearch", method = RequestMethod.GET)
		public @ResponseBody int  getEmployeesComplaintsCountAndSearch(@RequestParam ("searchText") String searchText,@PathVariable("employeeId") int employeeId) {
			int  supplierCount= 0;
			try {
				supplierCount= complaintServices.getEmployeesComplaintsCountAndSearch(searchText,employeeId);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return supplierCount;
		}
		
	
	
	

	
	// Get All Complaint List
		@RequestMapping(value = "/getAllComplaintImageByComplaintNo", method = RequestMethod.GET)
		public @ResponseBody List<ComplaintImage> getAllComplaintImageByComplaintNo(@RequestParam("complaintNo") String complaintNo) {
			List<ComplaintImage> complaintImages = null;
			try {
				complaintImages = complaintServices.getAllComplaintImageByComplaintNo(complaintNo);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return complaintImages;
		}
		
}
