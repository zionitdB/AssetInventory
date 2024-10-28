package com.AssetInventory.DTO;

import com.AssetInventory.Model.AssetInventory;

public class TransferAssetBranchDto {
	public int getTransferType() {
		return transferType;
	}
	public void setTransferType(int transferType) {
		this.transferType = transferType;
	}
	private int fromBranch;
	private int toBranch;
	private AssetInventory assetInventory;
	private String  transferBy;
	private String  reason;;
	private int  transferType;
	private boolean isAcclocated;

	public boolean isAcclocated() {
		return isAcclocated;
	}
	public void setAcclocated(boolean isAcclocated) {
		this.isAcclocated = isAcclocated;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	private int  transferWithEmp;
	
	private int employeeId;
	
	private String  remark;
	public int getFromBranch() {
		return fromBranch;
	}
	public void setFromBranch(int fromBranch) {
		this.fromBranch = fromBranch;
	}
	public int getToBranch() {
		return toBranch;
	}
	public void setToBranch(int toBranch) {
		this.toBranch = toBranch;
	}

	public AssetInventory getAssetInventory() {
		return assetInventory;
	}
	public void setAssetInventory(AssetInventory assetInventory) {
		this.assetInventory = assetInventory;
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
	public int getTransferWithEmp() {
		return transferWithEmp;
	}
	public void setTransferWithEmp(int transferWithEmp) {
		this.transferWithEmp = transferWithEmp;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
