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



/**
 * @author Dattatray 
 *
 */
@Entity
@Table(name="upload_branch_mst")
public class UploadBranch {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="branch_id")
	private int branchId;
	
	@Column(name="branch_code")
	private String branchCode;
	
	@Column(name="branch_name")
	private String branchName;
	
	@Column(name="location")
	private String location;
	
	@Column(name="branchAddress")
	private String branchAddress;
	
	
	@Column(name="added_by")
	private String addedBy;
	
	@Column(name="added_date")
	private Date addedDate;
	
	@Column(name="upd_datetime")
	private Date updDatetime;
	
	@Column(name="active")
	private int active;
	
	@Column(name="delet_bit")
	private int delet_bit;
	
	
	
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
	 * @return the branchId
	 */
	public int getBranchId() {
		return branchId;
	}

	/**
	 * @param branchId the branchId to set
	 */
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	/**
	 * @return the branchCode
	 */
	public String getBranchCode() {
		return branchCode;
	}

	/**
	 * @param branchCode the branchCode to set
	 */
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	/**
	 * @return the branchName
	 */
	public String getBranchName() {
		return branchName;
	}

	/**
	 * @param branchName the branchName to set
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the branchAddress
	 */
	public String getBranchAddress() {
		return branchAddress;
	}

	/**
	 * @param branchAddress the branchAddress to set
	 */
	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
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
	 * @return the delet_bit
	 */
	public int getDelet_bit() {
		return delet_bit;
	}

	/**
	 * @param delet_bit the delet_bit to set
	 */
	public void setDelet_bit(int delet_bit) {
		this.delet_bit = delet_bit;
	}
	
	

}
