/**
 * @Dattatray Bodhale
 */
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
import jakarta.persistence.Transient;



@Entity
@Table(name="material_mst")
public class Material {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="material_id")
	private int materialId;
	
	@Column(name="material_code")
	private String materialCode;
	
	@Column(name="material_name")
	private String materialName;
	
	@Column(name="material_specification")
	private String materialSpecification;

	@Column(name="added_by")
	private String addedBy;
	
	
	@Column(name="added_date")
	private Date addedDate;
	
	@Column(name="updated_datetime")
	private Date updatedDatetime;
	
	@Column(name="active")
	private int active;
	
	@Column(name="delet_bit")
	private int deletBit;
	
	@ManyToOne
	@JoinColumn(name="brand_id")
	private Brand brand;
	
	
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="unit_of_measurement_id")
	private UnitOfMeasurement unitOfMeasurement;
	


	private int process_bit;
	
	@Transient
	private double quantity;
	@Transient
	private double unitPrice;

	/**
	 * @return the quantity
	 */
	public double getQuantity() {
		return quantity;
	}



	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}



	/**
	 * @return the unitPrice
	 */
	public double getUnitPrice() {
		return unitPrice;
	}



	/**
	 * @param unitPrice the unitPrice to set
	 */
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}



	/**
	 * @return the materialId
	 */
	public int getMaterialId() {
		return materialId;
	}



	/**
	 * @param materialId the materialId to set
	 */
	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}



	/**
	 * @return the materialCode
	 */
	public String getMaterialCode() {
		return materialCode;
	}



	/**
	 * @param materialCode the materialCode to set
	 */
	public void setMaterialCode(String materialCode) {
		this.materialCode = materialCode;
	}



	/**
	 * @return the materialName
	 */
	public String getMaterialName() {
		return materialName;
	}



	/**
	 * @param materialName the materialName to set
	 */
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}



	/**
	 * @return the materialSpecification
	 */
	public String getMaterialSpecification() {
		return materialSpecification;
	}



	/**
	 * @param materialSpecification the materialSpecification to set
	 */
	public void setMaterialSpecification(String materialSpecification) {
		this.materialSpecification = materialSpecification;
	}



	/**
	 * @return the addedBy
	 */
	public String getAddedBy() {
		return addedBy;
	}



	/**
	 * @param addedBy the addedBy to set
	 */
	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}



	/**
	 * @return the addedDate
	 */
	public Date getAddedDate() {
		return addedDate;
	}



	/**
	 * @param addedDate the addedDate to set
	 */
	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}



	/**
	 * @return the updatedDatetime
	 */
	public Date getUpdatedDatetime() {
		return updatedDatetime;
	}



	/**
	 * @param updatedDatetime the updatedDatetime to set
	 */
	public void setUpdatedDatetime(Date updatedDatetime) {
		this.updatedDatetime = updatedDatetime;
	}



	/**
	 * @return the active
	 */
	public int getActive() {
		return active;
	}



	/**
	 * @param active the active to set
	 */
	public void setActive(int active) {
		this.active = active;
	}



	/**
	 * @return the deletBit
	 */
	public int getDeletBit() {
		return deletBit;
	}



	/**
	 * @param deletBit the deletBit to set
	 */
	public void setDeletBit(int deletBit) {
		this.deletBit = deletBit;
	}



	/**
	 * @return the brand
	 */
	public Brand getBrand() {
		return brand;
	}



	/**
	 * @param brand the brand to set
	 */
	public void setBrand(Brand brand) {
		this.brand = brand;
	}



	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}



	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}



	

	public UnitOfMeasurement getUnitOfMeasurement() {
		return unitOfMeasurement;
	}



	public void setUnitOfMeasurement(UnitOfMeasurement unitOfMeasurement) {
		this.unitOfMeasurement = unitOfMeasurement;
	}



	/**
	 * @return the process_bit
	 */
	public int getProcess_bit() {
		return process_bit;
	}



	/**
	 * @param process_bit the process_bit to set
	 */
	public void setProcess_bit(int process_bit) {
		this.process_bit = process_bit;
	}



	
	
}
