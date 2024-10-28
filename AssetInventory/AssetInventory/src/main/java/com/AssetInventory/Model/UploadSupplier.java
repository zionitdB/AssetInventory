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
@Table(name="upload_supplier_mst")
public class UploadSupplier {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="supplier_id")
	private int supplierId;
	
	@Column(name="supplier_code")
	private String supplierCode;
	
	@Column(name="supplier_name")
	private String supplierName;
	
	
	@Column(name="contact_person")
	private String contactPerson;
	
	@Column(name="contacct_no_1")
	private String contactNo1;

	@Column(name="contact_no_2")
	private String contactNo2;

	@Column(name="email_id")
	private String emailId;

	@Column(name="billing_address")
	private String billingAddress;
	
	@Column(name="shipping_address")
	private String shippingAddress;

	@Column(name="location")
	private String location;

	@Column(name="gstn")
	private String gstn;
	
	@Column(name="added_by")
	private String addedBy;
	
	@Column(name="payment_mode")
	private String paymentMode;
	
	@Column(name="payment_term")
	private String paymentTerm;
	
	@Column(name="added_date")
	private Date addedDate;
	
	@Column(name="upd_datetime")
	private Date updDatetime;
	
	@Column(name="delet_bit")
	private int deletBit;
	
	@Column(name="active")
	private int active;
	
	@ManyToOne
	@JoinColumn(name="billing_city_id" ,referencedColumnName="city_id")
	private City billingCity;
	
	@ManyToOne
	@JoinColumn(name="shipping_city_id" ,referencedColumnName="city_id")
	private City shippingCity;

	@ManyToOne
	@JoinColumn(name="branch_id")
	private Branch branch;
	
	
	@Column(name="billing_pincode")
	private String billingPincode;
	
	@Column(name="shipping_pincode")
	private String shippingPincode;

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getContactNo1() {
		return contactNo1;
	}

	public void setContactNo1(String contactNo1) {
		this.contactNo1 = contactNo1;
	}

	public String getContactNo2() {
		return contactNo2;
	}

	public void setContactNo2(String contactNo2) {
		this.contactNo2 = contactNo2;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getGstn() {
		return gstn;
	}

	public void setGstn(String gstn) {
		this.gstn = gstn;
	}

	public String getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getPaymentTerm() {
		return paymentTerm;
	}

	public void setPaymentTerm(String paymentTerm) {
		this.paymentTerm = paymentTerm;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public Date getUpdDatetime() {
		return updDatetime;
	}

	public void setUpdDatetime(Date updDatetime) {
		this.updDatetime = updDatetime;
	}

	public int getDeletBit() {
		return deletBit;
	}

	public void setDeletBit(int deletBit) {
		this.deletBit = deletBit;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public City getBillingCity() {
		return billingCity;
	}

	public void setBillingCity(City billingCity) {
		this.billingCity = billingCity;
	}

	public City getShippingCity() {
		return shippingCity;
	}

	public void setShippingCity(City shippingCity) {
		this.shippingCity = shippingCity;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public String getBillingPincode() {
		return billingPincode;
	}

	public void setBillingPincode(String billingPincode) {
		this.billingPincode = billingPincode;
	}

	public String getShippingPincode() {
		return shippingPincode;
	}

	public void setShippingPincode(String shippingPincode) {
		this.shippingPincode = shippingPincode;
	}
	
	@ManyToOne
	@JoinColumn(name="upload_detials_id")
	private UploadDetial uploadDetial;

	public UploadDetial getUploadDetial() {
		return uploadDetial;
	}

	public void setUploadDetial(UploadDetial uploadDetial) {
		this.uploadDetial = uploadDetial;
	}
	
	
	
	
	
}
