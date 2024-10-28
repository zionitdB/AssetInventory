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
 * @author lenovo
 *
 */
@Entity
@Table(name="asset_request_detials")
public class AssetRequestDetials {
	

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="asset_request_detials_id")
	private int assetRequestDetialsId;
	
	@Column(name="token_no")
	private String tokenNo;
	
	
	@ManyToOne
	@JoinColumn(name="asset_request_id")
	private AssetRequest assetRequest;
	
	@ManyToOne
	@JoinColumn(name="employee_id")
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name="material_id")
	private Material material;
	
	@Column(name="asset_code")
	private String assetCode;
	
	@Column(name="status_bit")
	private int statusBit;
	
	@Column(name="requested_date")
	private Date requestedDate;
	
	

	@Column(name="allocate_date")
	private Date allocateDate;

	/**
	 * @return the requestedDate
	 */
	public Date getRequestedDate() {
		return requestedDate;
	}

	/**
	 * @param requestedDate the requestedDate to set
	 */
	public void setRequestedDate(Date requestedDate) {
		this.requestedDate = requestedDate;
	}

	/**
	 * @return the allocateDate
	 */
	public Date getAllocateDate() {
		return allocateDate;
	}

	/**
	 * @param allocateDate the allocateDate to set
	 */
	public void setAllocateDate(Date allocateDate) {
		this.allocateDate = allocateDate;
	}

	/**
	 * @return the assetRequestDetialsId
	 */
	public int getAssetRequestDetialsId() {
		return assetRequestDetialsId;
	}

	/**
	 * @param assetRequestDetialsId the assetRequestDetialsId to set
	 */
	public void setAssetRequestDetialsId(int assetRequestDetialsId) {
		this.assetRequestDetialsId = assetRequestDetialsId;
	}

	/**
	 * @return the tokenNo
	 */
	public String getTokenNo() {
		return tokenNo;
	}

	/**
	 * @param tokenNo the tokenNo to set
	 */
	public void setTokenNo(String tokenNo) {
		this.tokenNo = tokenNo;
	}

	/**
	 * @return the assetRequest
	 */
	public AssetRequest getAssetRequest() {
		return assetRequest;
	}

	/**
	 * @param assetRequest the assetRequest to set
	 */
	public void setAssetRequest(AssetRequest assetRequest) {
		this.assetRequest = assetRequest;
	}

	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * @return the material
	 */
	public Material getMaterial() {
		return material;
	}

	/**
	 * @param material the material to set
	 */
	public void setMaterial(Material material) {
		this.material = material;
	}

	/**
	 * @return the assetCode
	 */
	public String getAssetCode() {
		return assetCode;
	}

	/**
	 * @param assetCode the assetCode to set
	 */
	public void setAssetCode(String assetCode) {
		this.assetCode = assetCode;
	}

	/**
	 * @return the statusBit
	 */
	public int getStatusBit() {
		return statusBit;
	}

	/**
	 * @param statusBit the statusBit to set
	 */
	public void setStatusBit(int statusBit) {
		this.statusBit = statusBit;
	}
	

	
	
}
