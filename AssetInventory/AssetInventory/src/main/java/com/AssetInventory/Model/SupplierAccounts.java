package com.AssetInventory.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Table(name="supplier_account")
public class SupplierAccounts {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="supplier_account_id")
	private int supplierAccountId;
	
	@Column(name="account_holder_name")
	private String accountHolderName;

	@Column(name="account_no")
	private String accountNo;

	@Column(name="account_status")
	private int accountStatus;

	@Column(name="bank_location")
	private String bankLocation;

	@Column(name="bank_name")
	private String bankName;
	
	
	@Column(name="ifsc_code")
	private String ifscCode;
	
	
	@ManyToOne
	@JoinColumn(name="supplier_id")
	private Supplier supplier;


	public int getSupplierAccountId() {
		return supplierAccountId;
	}


	public void setSupplierAccountId(int supplierAccountId) {
		this.supplierAccountId = supplierAccountId;
	}


	public String getAccountHolderName() {
		return accountHolderName;
	}


	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}


	public String getAccountNo() {
		return accountNo;
	}


	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}


	public int getAccountStatus() {
		return accountStatus;
	}


	public void setAccountStatus(int accountStatus) {
		this.accountStatus = accountStatus;
	}


	public String getBankLocation() {
		return bankLocation;
	}


	public void setBankLocation(String bankLocation) {
		this.bankLocation = bankLocation;
	}


	public String getBankName() {
		return bankName;
	}


	public void setBankName(String bankName) {
		this.bankName = bankName;
	}


	public String getIfscCode() {
		return ifscCode;
	}


	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}


	public Supplier getSupplier() {
		return supplier;
	}


	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	
}
