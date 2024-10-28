package com.AssetInventory.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.AssetInventory.DTO.AssetRequestDto;
import com.AssetInventory.DTO.ResponceObject;
import com.AssetInventory.DTO.TransferAssetBranchDto;
import com.AssetInventory.DTO.TransferAssetEmpDto;
import com.AssetInventory.Model.AssetAllocation;
import com.AssetInventory.Model.AssetAllocationHistory;
import com.AssetInventory.Model.AssetInventory;
import com.AssetInventory.Model.AssetRequest;
import com.AssetInventory.Model.AssetRequestDetials;
import com.AssetInventory.Model.Branch;
import com.AssetInventory.Model.Employee;
import com.AssetInventory.Model.Material;
import com.AssetInventory.Model.TransferAsset;
import com.AssetInventory.Repository.AssetInventoryRepo;
import com.AssetInventory.Repository.BranchRepo;
import com.AssetInventory.Repository.EmployeeRepo;
import com.AssetInventory.Repository.TransferAssetRepo;
import com.AssetInventory.Service.AllocationService;
import com.fasterxml.jackson.annotation.OptBoolean;

@Controller
@CrossOrigin(origins = "*") 
@RequestMapping("allocation")
public class AllocationController {
	
	@Autowired
	AllocationService allocationService;
	@Autowired
	EmployeeRepo employeeRepo;
	@Autowired
	AssetInventoryRepo assetInventoryRepo;
	@Autowired
	TransferAssetRepo transferAssetRepo;
	@Autowired
	BranchRepo branchRepo;
	
	@RequestMapping(value = "/addAssetRequest", method = RequestMethod.POST)
	public @ResponseBody ResponceObject addBussinessUnit(@RequestBody List<AssetRequestDto> assetRequestDtos) {
		ResponceObject responceObject = new ResponceObject();
		try {
			String tokenNo=allocationService.getNewTokenNo();
					
			AssetRequest  assetRequest=new AssetRequest();
			assetRequest.setMessage(assetRequestDtos.get(0).getMessage());
			assetRequest.setRequestDate(new Date());
			assetRequest.setRequested_by(assetRequestDtos.get(0).getRequestedBy());
			assetRequest.setStatus("Open");
			assetRequest.setTokenNo(tokenNo);
			assetRequest.setStatus("Raised");
			assetRequest=allocationService.saveAssetRequest(assetRequest);
		
			for(AssetRequestDto assetRequestDto:assetRequestDtos){
					int mat=0;
				for(Material material:assetRequestDto.getMaterials()){
					mat++;
					AssetRequestDetials assetRequestDetials= new AssetRequestDetials();
					assetRequestDetials.setAssetRequest(assetRequest);
					assetRequestDetials.setEmployee(assetRequestDto.getEmployee());
					assetRequestDetials.setMaterial(material);
					assetRequestDetials.setStatusBit(1);
					assetRequestDetials.setRequestedDate(new Date());
					assetRequestDetials.setTokenNo(tokenNo);
					allocationService.saveAssetRequestDetails(assetRequestDetials);
					
				}
				
			}
			
		
			
			responceObject.setCode(200);
			responceObject.setMsg("Asset request added Successfully");
		} catch (Exception e) {
			System.err.println(e.toString());
			responceObject.setCode(500);
			responceObject.setMsg("Something Wrong");
		}
		return responceObject;
	}
	@RequestMapping(value = "/approveAssetRequest", method = RequestMethod.POST)
	public @ResponseBody ResponceObject approveAssetRequest(@RequestBody AssetRequestDetials assetRequestDetials) {
		ResponceObject responceObject = new ResponceObject();
				
		try {
			AssetAllocation allocation= new AssetAllocation();
			allocation.setAllocationTo("Employee");
			allocation.setAllocationDate(new Date());
			allocation.setAllocationStatus(1);
			allocation.setAssetCode(assetRequestDetials.getAssetCode());
			allocation.setEmployee(assetRequestDetials.getEmployee());
			allocation.setRequestedtokenNo(assetRequestDetials.getTokenNo());
			allocation.setMaterial(assetRequestDetials.getMaterial());
			allocation.setIsReleased(0);
			AssetAllocationHistory allocationHistory= new AssetAllocationHistory();
			allocationHistory.setAllocationDate(new Date());
			allocationHistory.setAllocationTo("Employee");
			allocationHistory.setAllocationTokenNo(allocation.getRequestedtokenNo());
			allocationHistory.setAllocationToSpec(allocation.getEmployee().getEmployeeId());
			allocationHistory.setMaterial(allocation.getMaterial());
			allocationHistory.setAssetCode(allocation.getAssetCode());
			
			Optional<AssetInventory>  inventoryOp =assetInventoryRepo.findByInventoryCode(allocation.getAssetCode());
			
			if(inventoryOp.isPresent()) {
				AssetInventory 	inventory=inventoryOp.get();
				inventory.setStatus(0);
				assetInventoryRepo.save(inventory);
			}
			assetRequestDetials.setAllocateDate(new Date());
			assetRequestDetials.setAssetCode(assetRequestDetials.getAssetCode());
			assetRequestDetials.setStatusBit(0);

		
			allocationService.saveAssetRequestDetails(assetRequestDetials);
			List<AssetRequestDetials>	list=allocationService.getDetailsByRequest(assetRequestDetials.getAssetRequest().getAssetRequestId());
			int i=0;
			for(AssetRequestDetials detials:list){
				
				if(detials.getStatusBit()==0){
					i++;
				}
				
			}
			
			if(i==list.size()){
				assetRequestDetials.getAssetRequest().setCloseDate(new Date());
				assetRequestDetials.getAssetRequest().setStatus("Closed");
				
			}
			
			allocationService.saveAssetAllocation(allocation);
			allocationService.saveAllocationHistory(allocationHistory);
			
			allocationService.saveAssetRequest(assetRequestDetials.getAssetRequest());
			
			responceObject.setCode(200);
			responceObject.setMsg("Asset allocation added Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.toString());
			responceObject.setCode(500);
			responceObject.setMsg("Something Wrong");
		}
		return responceObject;
	}
	
	
	
	@RequestMapping(value = "/getDetailsByRequest", method = RequestMethod.GET)
	public @ResponseBody List<AssetRequestDetials> getDetailsByRequest(@RequestParam("requestId") int requestId) {
		List<AssetRequestDetials> list= new  ArrayList<AssetRequestDetials>();
		try {	
		list=allocationService.getDetailsByRequest(requestId);
		//AssetRequestDetials detials=assetTransactionServices.getDetailsByRequestId(requestId);
		
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	
	
	
	@RequestMapping(value = "/getAllAssetRequestByLimitAndStatus", method = RequestMethod.GET)
	public @ResponseBody List<AssetRequest> getAllAssetRequestByLimitAndStatus(@RequestParam("pageNo") int pageNo,@RequestParam("perPage") int perPage,@RequestParam("status") String status) {
		List<AssetRequest> list= new  ArrayList<AssetRequest>();
		try {	
			list=allocationService.getAllAssetRequestByLimitAndStatus(pageNo,perPage,status);
			for(AssetRequest assetRequest:list){
				Optional<Employee> optional=employeeRepo.findById(assetRequest.getRequested_by());
				
				assetRequest.setRequestedEmpoyee(optional.get());
				list.add(assetRequest);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@RequestMapping(value = "/getAllRequestsCountByStatus", method = RequestMethod.GET)
	public @ResponseBody int  getAllRequestsCountByStatus(@RequestParam("status") String status) {
		int  supplierCount= 0;
		try {
			supplierCount= allocationService.getAllRequestsCountByStatus(status);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return supplierCount;
	}
	
	@RequestMapping(value = "/getAllAssetRequestByLimitAndStatusAndSearch", method = RequestMethod.GET)
	public @ResponseBody List<AssetRequest> getAllAssetRequestByLimitAndStatusAndSearch(@RequestParam("searchText") String searchText,@RequestParam("pageNo") int pageNo,@RequestParam("perPage") int perPage,@RequestParam("status") String status) {
		List<AssetRequest> list= new  ArrayList<AssetRequest>();
		try {	
			
			list=allocationService.getAllAssetRequestByLimitAndStatusAndSearch(searchText,pageNo,perPage,status);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value = "/getAllRequestsCountByStatusAndSearch", method = RequestMethod.GET)
	public @ResponseBody int  getAllRequestsCountByStatusAndSearch(@RequestParam("searchText") String searchText,@RequestParam("status") String status) {
		int  supplierCount= 0;
		try {
			supplierCount= allocationService.getAllRequestsCountByStatusAndSearch(searchText,status);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return supplierCount;
	}
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/getAssetRequestByManagerLimitAndStatus", method = RequestMethod.GET)
	public @ResponseBody List<AssetRequest> getAssetRequestByManagerLimitAndStatus(@RequestParam("pageNo") int pageNo,@RequestParam("perPage") int perPage,@RequestParam("status") String status,@RequestParam("managerId") int managerId) {
		List<AssetRequest> list= new  ArrayList<AssetRequest>();
		try {	
			list=allocationService.getAssetRequestByManagerLimitAndStatus(pageNo,perPage,status,managerId);
			for(AssetRequest assetRequest:list){
				Optional<Employee> optional=employeeRepo.findById(assetRequest.getRequested_by());
				
				assetRequest.setRequestedEmpoyee(optional.get());
				list.add(assetRequest);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@RequestMapping(value = "/getRequestsCountByManagerStatus", method = RequestMethod.GET)
	public @ResponseBody int  getRequestsCountByManagerStatus(@RequestParam("status") String status,@RequestParam("managerId") int managerId) {
		int  supplierCount= 0;
		try {
			supplierCount= allocationService.getRequestsCountByManagerStatus(status,managerId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return supplierCount;
	}
	
	@RequestMapping(value = "/getAssetRequestByManagerLimitAndStatusAndSearch", method = RequestMethod.GET)
	public @ResponseBody List<AssetRequest> getAssetRequestByManagerLimitAndStatusAndSearch(@RequestParam("searchText") String searchText,@RequestParam("pageNo") int pageNo,@RequestParam("perPage") int perPage,@RequestParam("status") String status,@RequestParam("managerId") int managerId) {
		List<AssetRequest> list= new  ArrayList<AssetRequest>();
		try {	
			
			list=allocationService.getAssetRequestByManagerLimitAndStatusAndSearch(searchText,pageNo,perPage,status,managerId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value = "/getRequestsCountByManagerStatusAndSearch", method = RequestMethod.GET)
	public @ResponseBody int  getRequestsCountByManagerStatusAndSearch(@RequestParam("searchText") String searchText,@RequestParam("status") String status,@RequestParam("managerId") int managerId) {
		int  supplierCount= 0;
		try {
			supplierCount= allocationService.getRequestsCountByManagerStatusAndSearch(searchText,status,managerId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return supplierCount;
	}
	
	
	
	@RequestMapping(value = "/getAllAllocateAssetByLimit", method = RequestMethod.GET)
	public @ResponseBody List<AssetAllocation> getAllAllocateAssetByLimit(@RequestParam("pageNo") int pageNo,@RequestParam("perPage") int perPage) {
		List<AssetAllocation> list= new  ArrayList<AssetAllocation>();
		try {	
		list=allocationService.getAllAllocateAssetByLimit(pageNo,perPage);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@RequestMapping(value = "/getAllAllocateAssetByLimitAndSearch", method = RequestMethod.GET)
	public @ResponseBody List<AssetAllocation> getAllAllocateAssetByLimitAndSearch(@RequestParam("searchText") String searchText,@RequestParam("pageNo") int pageNo,@RequestParam("perPage") int perPage) {
			List<AssetAllocation> list= new  ArrayList<AssetAllocation>();
			try {	
				list=allocationService.getAllAllocateAssetByLimitAndSearch(searchText,pageNo,perPage);
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
	
	@RequestMapping(value = "/getAllocatedAssetsCount", method = RequestMethod.GET)
	public @ResponseBody int  getAllocatedAssetsCount() {
		int  supplierCount= 0;
		try {
			supplierCount= allocationService.getAllocatedAssetsCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return supplierCount;
	}
	@RequestMapping(value = "/getAllocatedAssetsCountAndSearch", method = RequestMethod.GET)
	public @ResponseBody int  getAllocatedAssetsCountAndSearch(@RequestParam ("searchText") String searchText) {
		int  materialCount= 0;
		try {
			materialCount= allocationService.getAllocatedAssetsCountAndSearch(searchText);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return materialCount;
	}
	
	//********************************************************************************* Transfer ******************************************************************//
	@RequestMapping(value = "/transferAssetEmptoEmp", method = RequestMethod.POST)
	public @ResponseBody ResponceObject transferAssetEmptoEmp(@RequestBody List<TransferAssetEmpDto> assetEmpDtos) {
		ResponceObject responceObject = new ResponceObject();
		try {
			for(TransferAssetEmpDto assetEmpDto:assetEmpDtos){
				TransferAsset transferAsset = new TransferAsset();
				Optional<Employee> fromEmp=employeeRepo.findById(assetEmpDto.getFromEmployee());
				Optional<Employee> toEmp=employeeRepo.findById(assetEmpDto.getToEmployee());
				
				transferAsset.setAssetCode(assetEmpDto.getAssetAllocation().getAssetCode());
				transferAsset.setFromEmployee(fromEmp.get());
				transferAsset.setMaterial(assetEmpDto.getAssetAllocation().getMaterial());
				transferAsset.setRemark(assetEmpDto.getRemark());
				transferAsset.setToEmployee(toEmp.get());
				transferAsset.setTransferBy(assetEmpDto.getTransferBy());
				transferAsset.setTransferDate(new Date());
				transferAsset.setTransferType("Employee To Employee");
				transferAssetRepo.save(transferAsset);
				AssetAllocation allocation= assetEmpDto.getAssetAllocation();
				allocation.setEmployee(toEmp.get());
				allocationService.saveAssetAllocation(allocation);
			}
			
			responceObject.setCode(200);
			responceObject.setMsg("Asset Transfer  Successfully");
		} catch (Exception e) {
			System.err.println(e.toString());
			responceObject.setCode(500);
			responceObject.setMsg("Something Wrong");
		}
return responceObject;
}
	@RequestMapping(value = "/transferAssetBranchtoBranch", method = RequestMethod.POST)
	public @ResponseBody ResponceObject transferAssetEmptoEmp(@RequestBody TransferAssetBranchDto transferAssetBranchDto) {
		ResponceObject responceObject = new ResponceObject();
		try {
			TransferAsset transferAsset = new TransferAsset();
			Optional<Branch> fromBranch=branchRepo.findById(transferAssetBranchDto.getFromBranch());
			Optional<Branch> toBranch=branchRepo.findById(transferAssetBranchDto.getToBranch());
			//
			AssetInventory assetInventory=transferAssetBranchDto.getAssetInventory();
			
			transferAsset.setToBranch(toBranch.get());
			transferAsset.setFromBranch(fromBranch.get());
			transferAsset.setAssetCode(assetInventory.getIncentoryCode());
			transferAsset.setMaterial(assetInventory.getMaterial());
			transferAsset.setRemark(transferAssetBranchDto.getRemark());
			transferAsset.setTransferBy(transferAssetBranchDto.getTransferBy());
			transferAsset.setTransferDate(new Date());
			transferAsset.setTransferType("Branch To Branch");
			transferAssetRepo.save(transferAsset);
			assetInventory.setBranch(toBranch.get());
			assetInventoryRepo.save(assetInventory);
			
			if(transferAssetBranchDto.isAcclocated()){
				if(transferAssetBranchDto.getTransferType()==1){
					AssetAllocation assetAllocation =allocationService.getAllocatedAssetByAsssetCode(assetInventory.getIncentoryCode());
					assetAllocation.setIsReleased(1);
					allocationService.saveAssetAllocation(assetAllocation);
					System.out.println("ASSET TRANSFER WITH RELEASE");
				}
				/*if(transferAssetBranchDto.getTransferType()==2){
					Employee employee=employeeService.getEmployeeById(transferAssetBranchDto.getEmployeeId());
					TransferEmployee transferEmployee = new TransferEmployee();
					transferEmployee.setFromBranch(employee.getBranch());
					transferEmployee.setToBranch(toBranch);
					transferEmployee.setReanferRef(transferAsset.getId());
					transferEmployee.setEmployee(employee);
					transferEmployee.setTransferBy(transferAssetBranchDto.getTransferBy());
					transferEmployee.setTransferDate(new Date());
					transferEmployee.setRemark("Asset Transfer");
					transferEmployee.setTransferReason(transferAssetBranchDto.getReason());
					employee.setBranch(toBranch);
					employeeService.addEmployee(employee);
					System.out.println("ASSET TRANSFER WITH EMPLOYEE TRASFER ");
				}*/
				
			}else{
				AssetAllocation assetAllocation = allocationService.getAllocatedAssetByAsssetCode(assetInventory.getIncentoryCode());
				assetAllocation.setIsReleased(1);
				assetAllocation.setAllocationStatus(0);
				allocationService.saveAssetAllocation(assetAllocation);
				
			}
			
			responceObject.setCode(200);
			responceObject.setMsg("TRANSFER Asset Successfully");
		} catch (Exception e) {
			System.err.println(e.toString());
			responceObject.setCode(500);
			responceObject.setMsg("Something Wrong");
		}
return responceObject;
}
	@RequestMapping(value = "/addReleaseRequest", method = RequestMethod.POST)
	public @ResponseBody ResponceObject addReleaseRequest(@RequestBody AssetAllocation assetAllocation) {
		ResponceObject responceObject = new ResponceObject();
		try {
			assetAllocation.setReleaseRequest(1);
			allocationService.saveAssetAllocation(assetAllocation);
			responceObject.setCode(200);
			responceObject.setMsg("Release Request Successfully");
		} catch (Exception e) {
			System.err.println(e.toString());
			responceObject.setCode(500);
			responceObject.setMsg("Something Wrong");
		}
return responceObject;
}
	@RequestMapping(value = "/releaseAsset", method = RequestMethod.POST)
	public @ResponseBody ResponceObject releaseAsset(@RequestBody AssetAllocation allocation) {
		ResponceObject responceObject = new ResponceObject();
		try {
			allocation.setReleaseRequest(0);
			allocation.setIsReleased(1);
			allocation.setReleasedDate(new Date());
			Optional<AssetInventory>  inventoryOp =assetInventoryRepo.findByInventoryCode(allocation.getAssetInventory().getIncentoryCode());
			if(inventoryOp.isPresent()) {
				AssetInventory assetInventory=inventoryOp.get();
				assetInventory.setStatus(1);
				assetInventoryRepo.save(assetInventory);
			}
			
			
		
			allocationService.saveAssetAllocation(allocation);
		
			responceObject.setCode(200);
			responceObject.setMsg("Asset Release Successfully");
		} catch (Exception e) {
			System.err.println(e.toString());
			responceObject.setCode(500);
			responceObject.setMsg("Something Wrong");
		}
		return responceObject;
	}
	@RequestMapping(value = "/getAllReleaseRequestByLimit", method = RequestMethod.GET)
	public @ResponseBody List<AssetAllocation> getAllReleaseRequestByLimit(@RequestParam("pageNo") int pageNo,@RequestParam("perPage") int perPage) {
		List<AssetAllocation> list= new  ArrayList<AssetAllocation>();
		try {	
		list=allocationService.getAllReleaseRequestByLimit(pageNo,perPage);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	@RequestMapping(value = "/getAllReleaseRequestByLimitAndSearch", method = RequestMethod.GET)
	public @ResponseBody List<AssetAllocation> getAllReleaseRequestByLimitAndSearch(@RequestParam("searchText") String searchText,@RequestParam("pageNo1") int pageNo,@RequestParam("perPage1") int perPage) {
			List<AssetAllocation> list= new  ArrayList<AssetAllocation>();
			try {	
			
				list=allocationService.getAllReleaseRequestByLimitAndSearch(searchText,pageNo,perPage);
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
	
	@RequestMapping(value = "/getReleaseRequestCount", method = RequestMethod.GET)
	public @ResponseBody int  getReleaseRequestCount() {
		int  supplierCount= 0;
		try {
			supplierCount= allocationService.getReleaseRequestCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return supplierCount;
	}
	
/*************************************getAllocatedAssetsCountRelAndSearch****************************/
	@RequestMapping(value = "/getReleaseRequestCountBySearch", method = RequestMethod.GET)
	public @ResponseBody int  getReleaseRequestCountBySearch(@RequestParam ("searchText") String searchText) {
		int  materialCount= 0;
		try {
			materialCount= allocationService.getReleaseRequestCountBySearch(searchText);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return materialCount;
	}
}
