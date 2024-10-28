package com.AssetInventory.Service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AssetInventory.Repository.AssetInventoryRegistationRepo;
import com.AssetInventory.Repository.AssetInventoryRepo;

@Service
public class AssetInventoryServiceImpl implements AssetInventoryService {
	
	@Autowired
	AssetInventoryRegistationRepo assetInventoryRegistationRepo; 
	@Autowired
	AssetInventoryRepo assetInventoryRepo;
	
	@Override
	public String getBatchNumber() {
		// TODO Auto-generated method stub
		
		  String newBatchQrNo = "";
		    String mnyr = "";
		    Calendar c = Calendar.getInstance();
		    int yr = c.get(1);
		    int mn = c.get(2) + 1;
		    String year = String.valueOf(yr).substring(2, 4);
		    String month = "";
		    if (mn <= 9) {
		      month = "0" + String.valueOf(mn);
		    } else {
		      month = String.valueOf(mn);
		    } 
		    mnyr = year + month;
		    int count = this.assetInventoryRegistationRepo.getBatchNumberCountByYearMonth(mnyr);
		    String newCount = "";
		    if (count == 0) {
		      newCount = mnyr + "0001";
		    } else {
		      String maxNo = "1" + this.assetInventoryRegistationRepo.getMaxBatchQrNoByYearMonth(mnyr);
		      
		      
		      int mxint = Integer.parseInt(maxNo);
		      mxint++;
		      newCount = String.valueOf(mxint).substring(1, 9);
		    } 
		    newBatchQrNo = mnyr + newCount;
		return newBatchQrNo;
	}

	@Override
	public int getMaxInventoryNumber(String inventoryCode) {
		// TODO Auto-generated method stub
		 int count = this.assetInventoryRepo.getCountInventoryNumber(inventoryCode);
		 System.out.println("inventoryCode "+inventoryCode);
		 System.out.println("COUNT "+count);
		 System.out.println("COUNT "+inventoryCode.length());
		    String newCount = "";
		    if (count == 0) {
		      newCount = "00001";
		    } else {
		     
		    } 
		    System.out.println("newCount "+newCount);
		return count;
	}

}
