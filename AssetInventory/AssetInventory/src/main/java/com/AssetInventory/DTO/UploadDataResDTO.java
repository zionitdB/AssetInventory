package com.AssetInventory.DTO;

import java.util.List;

import com.AssetInventory.Model.UploadBranch;
import com.AssetInventory.Model.UploadBrand;
import com.AssetInventory.Model.UploadCostCenter;
import com.AssetInventory.Model.UploadDepartment;
import com.AssetInventory.Model.UploadDesignation;
import com.AssetInventory.Model.UploadDesk;
import com.AssetInventory.Model.UploadEmployee;
import com.AssetInventory.Model.UploadMaterial;
import com.AssetInventory.Model.UploadProject;
import com.AssetInventory.Model.UploadRoom;
import com.AssetInventory.Model.UploadSpare;
import com.AssetInventory.Model.UploadSubsidiary;
import com.AssetInventory.Model.UploadSupplier;
import com.AssetInventory.Model.UploadWorklocation;

public class UploadDataResDTO {
	private int code;
	private String message;
	private List<UploadSpare> spares;
	private List<UploadDesk> desks;
	private List<UploadProject> projects;
	private List<UploadRoom> rooms;
	private List<UploadDepartment> departments;
	
	private List<UploadBranch> branchs;
	private List<UploadBrand> brands;
	private List<UploadDesignation> designations;
	private List<UploadCostCenter> costCenters;
	private List<UploadWorklocation> worklocations;
	private List<UploadSubsidiary> subsidiaries;
	
	
	private List<UploadSupplier> suppliers;
	private List<UploadMaterial> materials;
	private List<UploadEmployee> employees;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<UploadSpare> getSpares() {
		return spares;
	}
	public void setSpares(List<UploadSpare> spares) {
		this.spares = spares;
	}
	public List<UploadDesk> getDesks() {
		return desks;
	}
	public void setDesks(List<UploadDesk> desks) {
		this.desks = desks;
	}
	public List<UploadProject> getProjects() {
		return projects;
	}
	public void setProjects(List<UploadProject> projects) {
		this.projects = projects;
	}
	public List<UploadRoom> getRooms() {
		return rooms;
	}
	public void setRooms(List<UploadRoom> rooms) {
		this.rooms = rooms;
	}
	public List<UploadDepartment> getDepartments() {
		return departments;
	}
	public void setDepartments(List<UploadDepartment> departments) {
		this.departments = departments;
	}
	public List<UploadBranch> getBranchs() {
		return branchs;
	}
	public void setBranchs(List<UploadBranch> branchs) {
		this.branchs = branchs;
	}
	public List<UploadBrand> getBrands() {
		return brands;
	}
	public void setBrands(List<UploadBrand> brands) {
		this.brands = brands;
	}
	public List<UploadDesignation> getDesignations() {
		return designations;
	}
	public void setDesignations(List<UploadDesignation> designations) {
		this.designations = designations;
	}
	public List<UploadCostCenter> getCostCenters() {
		return costCenters;
	}
	public void setCostCenters(List<UploadCostCenter> costCenters) {
		this.costCenters = costCenters;
	}
	public List<UploadWorklocation> getWorklocations() {
		return worklocations;
	}
	public void setWorklocations(List<UploadWorklocation> worklocations) {
		this.worklocations = worklocations;
	}
	public List<UploadSubsidiary> getSubsidiaries() {
		return subsidiaries;
	}
	public void setSubsidiaries(List<UploadSubsidiary> subsidiaries) {
		this.subsidiaries = subsidiaries;
	}
	public List<UploadSupplier> getSuppliers() {
		return suppliers;
	}
	public void setSuppliers(List<UploadSupplier> suppliers) {
		this.suppliers = suppliers;
	}
	public List<UploadMaterial> getMaterials() {
		return materials;
	}
	public void setMaterials(List<UploadMaterial> materials) {
		this.materials = materials;
	}
	public List<UploadEmployee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<UploadEmployee> employees) {
		this.employees = employees;
	}

	
}
