package com.AssetInventory.Model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="asset_request")
public class AssetRequest {
	@Id

	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="asset_request_id")
	private int assetRequestId;
	
	@Column(name="message")
	private String message;
	
	@Column(name="token_no")
	private String tokenNo;
	
	@Column(name="request_date")
	private Date requestDate;
	
	@Column(name="status")
	private String status;
	
	@Column(name="close_date")
	private Date closeDate;
	
	
	@Column(name="requested_by")
	private int requested_by;
	
	
	@Transient
	Employee requestedEmpoyee;


	public int getAssetRequestId() {
		return assetRequestId;
	}


	public void setAssetRequestId(int assetRequestId) {
		this.assetRequestId = assetRequestId;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getTokenNo() {
		return tokenNo;
	}


	public void setTokenNo(String tokenNo) {
		this.tokenNo = tokenNo;
	}


	public Date getRequestDate() {
		return requestDate;
	}


	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Date getCloseDate() {
		return closeDate;
	}


	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}


	public int getRequested_by() {
		return requested_by;
	}


	public void setRequested_by(int requested_by) {
		this.requested_by = requested_by;
	}


	public Employee getRequestedEmpoyee() {
		return requestedEmpoyee;
	}


	public void setRequestedEmpoyee(Employee requestedEmpoyee) {
		this.requestedEmpoyee = requestedEmpoyee;
	}
	
	
	
	
	
}
