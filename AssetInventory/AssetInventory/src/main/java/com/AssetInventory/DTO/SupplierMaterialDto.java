/**
 * @Dattatray Bodhale
 */
package com.AssetInventory.DTO;

import java.sql.Date;
import java.util.List;

import com.AssetInventory.Model.Material;
import com.AssetInventory.Model.Supplier;



/**
 * @author lenovo
 *
 */
public class SupplierMaterialDto {
	private Supplier supplier;
	private List<Material> materials;
	
	

	private String addedBy;
	
	

	private Date addedDate;
	

	private Date updatedDatetime;
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
	 * @return the supplier
	 */
	public Supplier getSupplier() {
		return supplier;
	}
	/**
	 * @param supplier the supplier to set
	 */
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	/**
	 * @return the materials
	 */
	public List<Material> getMaterials() {
		return materials;
	}
	/**
	 * @param materials the materials to set
	 */
	public void setMaterials(List<Material> materials) {
		this.materials = materials;
	}
	
	
	
	
	

}
