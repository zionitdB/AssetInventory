package com.AssetInventory.Controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
import com.AssetInventory.Model.AssetAllocation;
import com.AssetInventory.Model.AssetInventory;
import com.AssetInventory.Model.AssetInventoryRegistation;
import com.AssetInventory.Model.Employee;
import com.AssetInventory.Model.User;
import com.AssetInventory.Repository.AssetAllocationRepo;
import com.AssetInventory.Repository.AssetInventoryRegistationRepo;
import com.AssetInventory.Repository.AssetInventoryRepo;
import com.AssetInventory.Service.AssetInventoryService;



@Controller
@CrossOrigin(origins = "*") 
@RequestMapping("inventory")
public class InventoryController {

	@Autowired
	AssetInventoryRepo assetInventoryRepo;
	
	@Autowired
	AssetInventoryService assetInventoryService;
	@Autowired
	AssetInventoryRegistationRepo assetInventoryRegistationRepo;
	@Autowired
	AssetAllocationRepo assetAllocationRepo;
	
	@RequestMapping(value = "/addNewAssetInventory", method = RequestMethod.POST)
	public @ResponseBody ResponceObject addNewAssetInventory(@RequestBody AssetInventoryRegistation assetInventoryRegistation) {
		ResponceObject responceObject = new ResponceObject();
		try {
			
			Date warrantyDate= null;
			Date DepreciationDate = null;
			String warrentyUnit=assetInventoryRegistation.getWarrantyUnit();
			String depreciationUnit=assetInventoryRegistation.getDepreciationUnit();
			
			
		
			 
			if(assetInventoryRegistation.getWarrantyUnit().equalsIgnoreCase("Year")) {
				 Calendar calendar = Calendar.getInstance();
				 calendar.setTime(assetInventoryRegistation.getInvoiceDate());
			     calendar.add(Calendar.YEAR, assetInventoryRegistation.getWarrantyValue());
			     warrantyDate = calendar.getTime();
				
			}
			if(assetInventoryRegistation.getWarrantyUnit().equalsIgnoreCase("Month")) {
				Calendar calendar = Calendar.getInstance();
				 calendar.setTime(assetInventoryRegistation.getInvoiceDate());
			     calendar.add(Calendar.MONTH, assetInventoryRegistation.getWarrantyValue());
			     warrantyDate = calendar.getTime();
							
			}
			if(assetInventoryRegistation.getWarrantyUnit().equalsIgnoreCase("Day")) {
				Calendar calendar = Calendar.getInstance();
				 calendar.setTime(assetInventoryRegistation.getInvoiceDate());
			     calendar.add(Calendar.DAY_OF_MONTH, assetInventoryRegistation.getWarrantyValue());
			     warrantyDate = calendar.getTime();			
			}
			
			
			if(assetInventoryRegistation.getDepreciationUnit().equalsIgnoreCase("Year")) {
				 Calendar calendar = Calendar.getInstance();
				 calendar.setTime(assetInventoryRegistation.getInvoiceDate());
			     calendar.add(Calendar.YEAR, assetInventoryRegistation.getDepreciationValue());
			     DepreciationDate = calendar.getTime();
				
			}
			if(assetInventoryRegistation.getDepreciationUnit().equalsIgnoreCase("Month")) {
				Calendar calendar = Calendar.getInstance();
				 calendar.setTime(assetInventoryRegistation.getInvoiceDate());
			     calendar.add(Calendar.MONTH, assetInventoryRegistation.getDepreciationValue());
			     DepreciationDate = calendar.getTime();
							
			}
			if(assetInventoryRegistation.getDepreciationUnit().equalsIgnoreCase("Day")) {
				Calendar calendar = Calendar.getInstance();
				 calendar.setTime(assetInventoryRegistation.getInvoiceDate());
			     calendar.add(Calendar.DAY_OF_MONTH, assetInventoryRegistation.getDepreciationValue());
			     DepreciationDate = calendar.getTime();			
			}
			
			
			assetInventoryRegistation.setDepreciationEndDate(DepreciationDate);
			assetInventoryRegistation.setWarrantyEndDate(warrantyDate);
			
			//String batchNumber=assetInventoryService.getBatchNumber();
			assetInventoryRegistation.setBatchNumber(assetInventoryRegistation.getBatchNumber());
			AssetInventoryRegistation assetInventoryRegistation1=assetInventoryRegistationRepo.save(assetInventoryRegistation);
			
			List<String> serialNos=assetInventoryRegistation.getSerialNo();
			String type="";
			
			if(assetInventoryRegistation.getAssetType().equals("Desktop")) {
				type="COC";
			}
			if(assetInventoryRegistation.getAssetType().equals("Laptop")) {
				type="LPC";
			}
			
			String com ="";
			if(assetInventoryRegistation.getAssetComp().equals("STP")) {
				com="S";
			}
			if(assetInventoryRegistation.getAssetComp().equals("NON-STP")) {
				com="N";		
			}
			if(assetInventoryRegistation.getAssetComp().equals("Customer")) {
				com="C";
			}
			if(assetInventoryRegistation.getAssetComp().equals("Lease")) {
				com="L";
			}
			String inventoryCode1="Z/"+assetInventoryRegistation.getBranch().getBranchCode()+"/"+com+"/"+type+"/";
			int maxNumber=assetInventoryService.getMaxInventoryNumber(inventoryCode1);
			for(int i =1;i<=assetInventoryRegistation.getNoOfAsset();i++) {
				int j=maxNumber+i;
				
				String inventoryCode=inventoryCode1+j;
				AssetInventory assetInventory= new AssetInventory();
				assetInventory.setActive(1);
				assetInventory.setAddedDate(new Date());
				assetInventory.setAssetInventoryRegistation(assetInventoryRegistation1);
				assetInventory.setBatchNumber(assetInventoryRegistation.getBatchNumber());
				assetInventory.setBranch(assetInventoryRegistation.getBranch());
				assetInventory.setDepreciationEndDate(DepreciationDate);
				assetInventory.setIncentoryCode(inventoryCode);
				assetInventory.setMaterial(assetInventoryRegistation.getMaterial());
				assetInventory.setOtherSpecification(assetInventoryRegistation.getOtherSpecification());
				assetInventory.setWarrantyEndDate(warrantyDate);
				assetInventory.setStatus(1);
				String serialNo=serialNos.get(i-1);
				assetInventory.setSerialNumber(serialNo);
				assetInventoryRepo.save(assetInventory);
			}
			
			
		
			responceObject.setCode(200);
			responceObject.setMsg("Inventory Regisration is Successfully");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.toString());
			responceObject.setCode(500);
			responceObject.setMsg("Something Wrong");
		}
		return responceObject;
	}
	
	@RequestMapping(value = "/updateInventory", method = RequestMethod.POST)
	public @ResponseBody ResponceObject updateInventory(@RequestBody AssetInventory assetInventory) {
		ResponceObject responceObject = new ResponceObject();
		try {
			
			
			assetInventoryRepo.save(assetInventory);
			responceObject.setCode(200);
			responceObject.setMsg("Inventory Detials Updated ...Successfully");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.toString());
			responceObject.setCode(500);
			responceObject.setMsg("Something Wrong");
		}
		return responceObject;
	}
	
	@RequestMapping(value = "/deleteInventory", method = RequestMethod.POST)
	public @ResponseBody ResponceObject deleteInventory(@RequestBody AssetInventory assetInventory) {
		ResponceObject responceObject = new ResponceObject();
		try {
			Optional<AssetAllocation> optional=assetAllocationRepo.getAllocatedAssetByAssetInventorytId(assetInventory.getAsset_inventory_id());
			if (optional.isPresent()) {
				responceObject.setCode(500);
				responceObject.setMsg("Can not be Deleted..............Inventory are allocated ");
			}else {
				assetInventoryRepo.delete(assetInventory);
				responceObject.setCode(200);
				responceObject.setMsg("Inventory Detials Deleted ...Successfully");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.toString());
			responceObject.setCode(500);
			responceObject.setMsg("Something Wrong");
		}
		return responceObject;
	}
	@RequestMapping(value = "/getAvailableAssetInvemtoryCode", method = RequestMethod.GET)
	public @ResponseBody Set<String> getAvailableAssetInvemtoryCode(@RequestParam("materialId") int materialId) {
		//List<AssetRequest> list= new  ArrayList<AssetRequest>();
		  Set<String> list = new HashSet<>();
		try {
			
			List<AssetInventory> stockhistories=assetInventoryRepo.getAvailableAssetInvemtoryCode(materialId);
			
			for(AssetInventory history:stockhistories){
				list.add(history.getIncentoryCode());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value = "/getAllAssetInventories", method = RequestMethod.GET)
	public @ResponseBody List<AssetInventory> getAllAssetInventories() {
		List<AssetInventory> list = null;
		try {
			list = assetInventoryRepo.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value = "/getAllAssetInventoriesByMaterialId", method = RequestMethod.GET)
	public @ResponseBody List<AssetInventory> getAllAssetInventoriesByMaterialId(@RequestParam("materialId") int materialId) {
		List<AssetInventory> list = null;
		try {
			list = assetInventoryRepo.getAssetInventoryByMaterialId(materialId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value = "/getlistAssetInventoryByLimit", method = RequestMethod.GET)
	public @ResponseBody List<AssetInventory> getlistAssetInventoryByLimit(@RequestParam("pageNo") int pageNo,@RequestParam("perPage") int perPage) {
		List<AssetInventory> list= new  ArrayList<AssetInventory>();
		try {	
			list=assetInventoryRepo.getlistAssetInventoryByLimit(pageNo,perPage);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value = "/getlistAssetInventoryByLimitAndSearch", method = RequestMethod.GET)
	public @ResponseBody List<AssetInventory> getlistAssetInventoryByLimitAndSearch(@RequestParam("searchText") String searchText,@RequestParam("pageNo") int pageNo,@RequestParam("perPage") int perPage) {
		List<AssetInventory> list= new  ArrayList<AssetInventory>();
		try {	
			
			list=assetInventoryRepo.getlistAssetInventoryByLimitAndSearch(searchText,pageNo,perPage);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@RequestMapping(value = "/getAssetInventorysCount", method = RequestMethod.GET)
	public @ResponseBody int  getAssetInventorysCount() {
		int  supplierCount= 0;
		try {
			supplierCount= (int) assetInventoryRepo.count();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return supplierCount;
	}
	@RequestMapping(value = "/getAssetInventorysCountAndSearch", method = RequestMethod.GET)
	public @ResponseBody int  getAssetInventorysCountAndSearch(@RequestParam("searchText") String searchText) {
		int  supplierCount= 0;
		try {
			supplierCount= assetInventoryRepo.getAssetInventorysCountAndSearch(searchText);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return supplierCount;
	}
	}
