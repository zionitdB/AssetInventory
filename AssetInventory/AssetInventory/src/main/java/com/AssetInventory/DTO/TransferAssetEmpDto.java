package com.AssetInventory.DTO;

import com.AssetInventory.Model.AssetAllocation;

public class TransferAssetEmpDto {
	
	private int fromEmployee;
	private int toEmployee;
	private AssetAllocation  assetAllocation;
	private String  transferBy;
	private String  remark;
	public int getFromEmployee() {
		return fromEmployee;
	}
	public void setFromEmployee(int fromEmployee) {
		this.fromEmployee = fromEmployee;
	}
	public int getToEmployee() {
		return toEmployee;
	}
	public void setToEmployee(int toEmployee) {
		this.toEmployee = toEmployee;
	}
	public AssetAllocation getAssetAllocation() {
		return assetAllocation;
	}
	public void setAssetAllocation(AssetAllocation assetAllocation) {
		this.assetAllocation = assetAllocation;
	}
	public String getTransferBy() {
		return transferBy;
	}
	public void setTransferBy(String transferBy) {
		this.transferBy = transferBy;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	

}
