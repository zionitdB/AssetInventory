package com.AssetInventory.Model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="transfer_asset")
public class TransferAsset {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="transfer_type")
	private String transferType;
	
	
	@ManyToOne
	@JoinColumn(name="from_employee")
	private Employee fromEmployee;
	
	@ManyToOne
	@JoinColumn(name="to_employee")
	private Employee toEmployee;
	
	@ManyToOne
	@JoinColumn(name="from_branch")
	private Branch fromBranch;
	
	@ManyToOne
	@JoinColumn(name="to_branch")
	private Branch toBranch;
	
	@ManyToOne
	@JoinColumn(name="material_id")
	private Material material;
	 
	
	@Column(name="asset_code")
	private String  assetCode;
	
	@Column(name="transfer_date")
	private Date  transferDate;
	
	@Column(name="transfer_by")
	private String  transferBy;
	
	@Column(name="remark")
	private String  remark;
	


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTransferType() {
		return transferType;
	}

	public void setTransferType(String transferType) {
		this.transferType = transferType;
	}

	public Employee getFromEmployee() {
		return fromEmployee;
	}

	public void setFromEmployee(Employee fromEmployee) {
		this.fromEmployee = fromEmployee;
	}

	public Employee getToEmployee() {
		return toEmployee;
	}

	public void setToEmployee(Employee toEmployee) {
		this.toEmployee = toEmployee;
	}

	public Branch getFromBranch() {
		return fromBranch;
	}

	public void setFromBranch(Branch fromBranch) {
		this.fromBranch = fromBranch;
	}

	public Branch getToBranch() {
		return toBranch;
	}

	public void setToBranch(Branch toBranch) {
		this.toBranch = toBranch;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public String getAssetCode() {
		return assetCode;
	}

	public void setAssetCode(String assetCode) {
		this.assetCode = assetCode;
	}

	public Date getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(Date transferDate) {
		this.transferDate = transferDate;
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
