package com.AssetInventory.Model;

import java.util.Date;
import java.util.List;

import com.AssetInventory.Model.Branch;
import com.AssetInventory.Model.Material;
import com.AssetInventory.Model.Supplier;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="asset_inventory_registation")
public class AssetInventoryRegistation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="asset_inventory_registation_id")
	private int asset_inventory_registation_id;
	
	
	@ManyToOne
	@JoinColumn(name="material_id")
	private Material material;
	
	
	@ManyToOne
	@JoinColumn(name="branch_id")
	private Branch branch;  
	
	@ManyToOne
	@JoinColumn(name="supplier_id")
	private Supplier supplier;
	@Transient
	private List<String> serialNo;
	
	@Column(name="asset_type")
	private String assetType;
	
	
	@Column(name="asset_omp")
	private String assetComp;
	
	@Column(name="batch_number")
	private String batchNumber;
	
	@Column(name="no_of_asset")
	private int noOfAsset;
	
	@Column(name="po_no")
	private String poNo;
	
	@Column(name="po_date")
	private Date poDate;
	
	@Column(name="invoice_no")
	private String invoiceNo;
	
	@Column(name="invoice_date")
	private Date invoiceDate;
	
	@Column(name="warranty_unit")
	private String warrantyUnit;
	
	@Column(name="warranty_value")
	private int warrantyValue;
	
	
	@Column(name="depreciation_unit")
	private String depreciationUnit;
	
	@Column(name="depreciation_value")
	private int depreciationValue;
	
	
	@Column(name="depreciation_end_date")
	private Date depreciationEndDate;
	
	
	@Column(name="warranty_end_date")
	private Date warrantyEndDate;
	
	@Column(name="register_by")
	private String registerBy;
	
	@Column(name="other_specification")
	private String  otherSpecification;

	public int getAsset_inventory_registation_id() {
		return asset_inventory_registation_id;
	}

	public void setAsset_inventory_registation_id(int asset_inventory_registation_id) {
		this.asset_inventory_registation_id = asset_inventory_registation_id;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public int getNoOfAsset() {
		return noOfAsset;
	}

	public void setNoOfAsset(int noOfAsset) {
		this.noOfAsset = noOfAsset;
	}

	public String getPoNo() {
		return poNo;
	}

	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	public Date getPoDate() {
		return poDate;
	}

	public void setPoDate(Date poDate) {
		this.poDate = poDate;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getWarrantyUnit() {
		return warrantyUnit;
	}

	public void setWarrantyUnit(String warrantyUnit) {
		this.warrantyUnit = warrantyUnit;
	}

	public int getWarrantyValue() {
		return warrantyValue;
	}

	public void setWarrantyValue(int warrantyValue) {
		this.warrantyValue = warrantyValue;
	}

	public String getDepreciationUnit() {
		return depreciationUnit;
	}

	public void setDepreciationUnit(String depreciationUnit) {
		this.depreciationUnit = depreciationUnit;
	}

	public int getDepreciationValue() {
		return depreciationValue;
	}

	public void setDepreciationValue(int depreciationValue) {
		this.depreciationValue = depreciationValue;
	}

	public Date getDepreciationEndDate() {
		return depreciationEndDate;
	}

	public void setDepreciationEndDate(Date depreciationEndDate) {
		this.depreciationEndDate = depreciationEndDate;
	}

	public Date getWarrantyEndDate() {
		return warrantyEndDate;
	}

	public void setWarrantyEndDate(Date warrantyEndDate) {
		this.warrantyEndDate = warrantyEndDate;
	}

	public String getRegisterBy() {
		return registerBy;
	}

	public void setRegisterBy(String registerBy) {
		this.registerBy = registerBy;
	}

	public String getOtherSpecification() {
		return otherSpecification;
	}

	public void setOtherSpecification(String otherSpecification) {
		this.otherSpecification = otherSpecification;
	}

	public String getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public List<String> getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(List<String> serialNo) {
		this.serialNo = serialNo;
	}

	public String getAssetType() {
		return assetType;
	}

	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}

	public String getAssetComp() {
		return assetComp;
	}

	public void setAssetComp(String assetComp) {
		this.assetComp = assetComp;
	}
	
	
	
}
