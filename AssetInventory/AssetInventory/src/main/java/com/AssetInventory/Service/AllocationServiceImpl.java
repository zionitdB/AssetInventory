package com.AssetInventory.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AssetInventory.Model.AssetAllocation;
import com.AssetInventory.Model.AssetAllocationHistory;
import com.AssetInventory.Model.AssetRequest;
import com.AssetInventory.Model.AssetRequestDetials;
import com.AssetInventory.Model.Employee;
import com.AssetInventory.Repository.AssetAllocationHistoryRepo;
import com.AssetInventory.Repository.AssetAllocationRepo;
import com.AssetInventory.Repository.AssetRequestDetialsRepo;
import com.AssetInventory.Repository.AssetRequestRepo;

@Service
public class AllocationServiceImpl implements AllocationService {
	@Autowired
	AssetRequestRepo assetRequestRepo;
	@Autowired
	AssetRequestDetialsRepo assetRequestDetialsRepo;
	@Autowired
	AssetAllocationRepo assetAllocationRepo;
	@Autowired
	AssetAllocationHistoryRepo assetAllocationHistoryRepo;
	
	
	@Override
	public String getNewTokenNo() {
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
			  String yeards=year+month;
		return assetRequestRepo.getNewTokon(yeards);
	}
	@Override
	public AssetRequest saveAssetRequest(AssetRequest assetRequest) {
		// TODO Auto-generated method stub
		return assetRequestRepo.save(assetRequest);
	}
	@Override
	public void saveAssetRequestDetails(AssetRequestDetials assetRequestDetials) {
		// TODO Auto-generated method stub
		assetRequestDetialsRepo.save(assetRequestDetials);
	}
	@Override
	public List<AssetRequestDetials> getDetailsByRequest(int assetRequestId) {
		// TODO Auto-generated method stub
		return assetRequestDetialsRepo.getDetailsByRequest(assetRequestId);
	}
	@Override
	public void saveAllocationHistory(AssetAllocationHistory allocationHistory) {
		// TODO Auto-generated method stub
		assetAllocationHistoryRepo.save(allocationHistory);
	}
	@Override
	public void saveAssetAllocation(AssetAllocation allocation) {
		// TODO Auto-generated method stub
		assetAllocationRepo.save(allocation);
	}
	@Override
	public List<AssetRequest> getAllAssetRequestByLimitAndStatus(int pageNo, int perPage, String status) {
		// TODO Auto-generated method stub
		return assetRequestRepo.getAllAssetRequestByLimitAndStatus(pageNo,perPage,status);
	}
	@Override
	public int getAllRequestsCountByStatus(String status) {
		// TODO Auto-generated method stub
		return assetRequestRepo.getAllRequestsCountByStatus(status);
	}
	@Override
	public List<AssetRequest> getAllAssetRequestByLimitAndStatusAndSearch(String searchText, int pageNo, int perPage,String status) {
		// TODO Auto-generated method stub
		return assetRequestRepo.getAllAssetRequestByLimitAndStatusAndSearch(searchText,pageNo,perPage,status);
	}
	@Override
	public int getAllRequestsCountByStatusAndSearch(String searchText,String status) {
		// TODO Auto-generated method stub
		return assetRequestRepo.getAllRequestsCountByStatusAndSearch(searchText,status);
	}
	@Override
	public List<AssetRequest> getAssetRequestByManagerLimitAndStatus(int pageNo, int perPage, String status,
			int managerId) {
		// TODO Auto-generated method stub
		return assetRequestRepo.getAssetRequestByManagerLimitAndStatus(pageNo,perPage,status,managerId);
	}
	@Override
	public int getRequestsCountByManagerStatus(String status, int managerId) {
		// TODO Auto-generated method stub
		return assetRequestRepo.getRequestsCountByManagerStatus(status,managerId);
	}
	@Override
	public List<AssetRequest> getAssetRequestByManagerLimitAndStatusAndSearch(String searchText, int pageNo, int perPage, String status, 
			int managerId) {
		// TODO Auto-generated method stub
		return assetRequestRepo.getAssetRequestByManagerLimitAndStatusAndSearch(searchText,pageNo,perPage,status,managerId);
	}
	@Override
	public int getRequestsCountByManagerStatusAndSearch(String searchText,  String status, int managerId) {
		// TODO Auto-generated method stub
		return assetRequestRepo.getRequestsCountByManagerStatusAndSearch(searchText,status,managerId);
	}
	@Override
	public List<AssetAllocation> getAllAllocateAssetByLimit(int pageNo, int perPage) {
		// TODO Auto-generated method stub
		return assetAllocationRepo.getAllAllocateAssetByLimit(pageNo,perPage);
	}
	@Override
	public int getAllocatedAssetsCount() {
		// TODO Auto-generated method stub
		return (int) assetAllocationRepo.count();
	}
	@Override
	public List<AssetAllocation> getAllAllocateAssetByLimitAndSearch(String searchText, int pageNo, int perPage) {
		// TODO Auto-generated method stub
		return assetAllocationRepo.getAllAllocateAssetByLimitAndSearch(searchText,pageNo,perPage);
	}
	@Override
	public int getAllocatedAssetsCountAndSearch(String searchText) {
		// TODO Auto-generated method stub
		return assetAllocationRepo.getAllocatedAssetsCountAndSearch(searchText);
	}
	@Override
	public AssetAllocation getAllocatedAssetByAsssetCode(String incentoryCode) {
		// TODO Auto-generated method stub
		return assetAllocationRepo.getAllocatedAssetByAsssetCode(incentoryCode);
	}
	@Override
	public List<AssetAllocation> getAllReleaseRequestByLimit(int pageNo, int perPage) {
		// TODO Auto-generated method stub
		return assetAllocationRepo.getAllReleaseRequestByLimit(pageNo,perPage);
	}
	@Override
	public List<AssetAllocation> getAllReleaseRequestByLimitAndSearch(String searchText, int pageNo, int perPage) {
		// TODO Auto-generated method stub
		return assetAllocationRepo.getAllReleaseRequestByLimitAndSearch(searchText,pageNo,perPage);
	}
	@Override
	public int getReleaseRequestCount() {
		// TODO Auto-generated method stub
		return assetAllocationRepo.getReleaseRequestCount();
	}
	@Override
	public int getReleaseRequestCountBySearch(String searchText) {
		// TODO Auto-generated method stub
		return assetAllocationRepo.getReleaseRequestCountBySearch(searchText);
	}

}
