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

@Entity
@Table(name="upload_brand_mst")
public class UploadBrand {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="brand_id")
	private int brandId;
	
	@Column(name="brand_name")
	private String brandName;
	
	@Column(name="added_by")
	private String addedBy;
	
	@Column(name="added_date")
	private Date addedDate;
	
	@Column(name="upd_datetime")
	private Date updDatetime;
	
	@Column(name="active")
	private int active;
	
	@Column(name="delet_bit")
	private int deletBit;
	
	
	
	@ManyToOne
	@JoinColumn(name="upload_detials_id")
	private UploadDetial uploadDetial;
	
	

	public UploadDetial getUploadDetial() {
		return uploadDetial;
	}

	public void setUploadDetial(UploadDetial uploadDetial) {
		this.uploadDetial = uploadDetial;
	}

	/**
	 * @return the brandId
	 */
	public int getBrandId() {
		return brandId;
	}

	/**
	 * @param brandId the brandId to set
	 */
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	/**
	 * @return the brandName
	 */
	public String getBrandName() {
		return brandName;
	}

	/**
	 * @param brandName the brandName to set
	 */
	public void setBrandName(String brandName) {
		this.brandName = brandName;
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
	 * @return the updDatetime
	 */
	public Date getUpdDatetime() {
		return updDatetime;
	}

	/**
	 * @param updDatetime the updDatetime to set
	 */
	public void setUpdDatetime(Date updDatetime) {
		this.updDatetime = updDatetime;
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
	
	
	
	

}
