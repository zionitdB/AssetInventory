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
@Table(name="asset_inventory")
public class AssetInventory {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="asset_inventory_id")
	private int asset_inventory_id;
	
	@Column(name="incentory_code")
	private String incentoryCode;
	
	
	@ManyToOne
	@JoinColumn(name="material_id")
	private Material material;
	
	@Column(name="warranty_end_date")
	private Date warrantyEndDate;
	
	
	@Column(name="depreciation_end_date")
	private Date depreciationEndDate;
	
	
	@Column(name="batch_number")
	private String batchNumber;
	
	@Column(name="serial_number")
	private String serialNumber;
	
	@ManyToOne
	@JoinColumn(name="asset_inventory_registation_id")
	private AssetInventoryRegistation assetInventoryRegistation;
	
	@ManyToOne
	@JoinColumn(name="branch_id")
	private Branch branch;
	
	@Column(name="added_date")
	private Date addedDate;
	
	
	
	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	@Column(name="active")
	private int active;
	
	
	@Column(name="status")
	private int status;
	
	@Column(name="other_specification")
	private String otherSpecification;

	public int getAsset_inventory_id() {
		return asset_inventory_id;
	}

	public void setAsset_inventory_id(int asset_inventory_id) {
		this.asset_inventory_id = asset_inventory_id;
	}

	public String getIncentoryCode() {
		return incentoryCode;
	}

	public void setIncentoryCode(String incentoryCode) {
		this.incentoryCode = incentoryCode;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getOtherSpecification() {
		return otherSpecification;
	}

	public void setOtherSpecification(String otherSpecification) {
		this.otherSpecification = otherSpecification;
	}

	public Date getWarrantyEndDate() {
		return warrantyEndDate;
	}

	public void setWarrantyEndDate(Date warrantyEndDate) {
		this.warrantyEndDate = warrantyEndDate;
	}

	public Date getDepreciationEndDate() {
		return depreciationEndDate;
	}

	public void setDepreciationEndDate(Date depreciationEndDate) {
		this.depreciationEndDate = depreciationEndDate;
	}

	public String getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public AssetInventoryRegistation getAssetInventoryRegistation() {
		return assetInventoryRegistation;
	}

	public void setAssetInventoryRegistation(AssetInventoryRegistation assetInventoryRegistation) {
		this.assetInventoryRegistation = assetInventoryRegistation;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	
	
}
