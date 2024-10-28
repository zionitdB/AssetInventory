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
import jakarta.persistence.Table;

@Entity
@Table(name="category_mst")
public class Category {
	
	@Id
	@GeneratedValue
	@Column(name="category_id")
	private int categoryId;
	
	@Column(name="category_name")
	private String categoryName;
	
	@Column(name="added_by")
	private String addedBy;
	
	@Column(name="added_date")
	private Date addedDate;
	
	@Column(name="updated_datetime")
	private Date updatedDatetime;
	
	@Column(name="active")
	private int active;
	
	@Column(name="delet_bit")
	private Date deletBit;

	/**
	 * @return the categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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
	 * @return the deletBit
	 */
	public Date getDeletBit() {
		return deletBit;
	}

	/**
	 * @param deletBit the deletBit to set
	 */
	public void setDeletBit(Date deletBit) {
		this.deletBit = deletBit;
	}
	
	

}
