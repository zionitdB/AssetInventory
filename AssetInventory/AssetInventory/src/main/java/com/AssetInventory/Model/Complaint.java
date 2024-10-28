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
@Table(name="complaint")
public class Complaint {

	

	
	@Id
	@GeneratedValue
	@Column(name="complaint_id")
	private int complaintId;
	

	@Column(name="complaint_no")
	private String complaintNo;
	
	@Column(name="complaint_date")
	private Date  complaintDate;
	
	@Column(name="complaint_close_date")
	private Date complaintCloseDate;
	
	
	
	@Column(name="complaint_status")
	private String complaintStatus;
	
	
	@Column(name="issue")
	private String issue;
	
	@ManyToOne
	@JoinColumn(name="complaint_by")
	private Employee complaintBy;
	
	@ManyToOne
	@JoinColumn(name="engineer_id")
	private Employee engineer;
	
	
	@ManyToOne
	@JoinColumn(name="complaint_category_id")
	private ComplaintCategory complaintCategory;
	
	
	@Transient
	private int comCatId;
	@Transient
	private int comById;
	@Transient
	private int matId;
	
	

	@ManyToOne
	@JoinColumn(name="material_id")
	private Material  material;
	
	@Column(name="asset_code")
	private String assetCode;
	
	@Column(name="priority")
	private String priority;
	
	
	@Column(name="inprocess_date")
	private Date inprocessDate;
	
	
	@Column(name="work_done")
	private String workDone;
	
	@Column(name="remark")
	private String remark;
	
	@Column(name="close_time_taken")
	private String closeTimeTaken;
	
	
	@Column(name="inprocess_time_taken")
	private String inprocessTimeTaken;


	public int getComplaintId() {
		return complaintId;
	}


	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}


	public String getComplaintNo() {
		return complaintNo;
	}


	public void setComplaintNo(String complaintNo) {
		this.complaintNo = complaintNo;
	}


	public Date getComplaintDate() {
		return complaintDate;
	}


	public void setComplaintDate(Date complaintDate) {
		this.complaintDate = complaintDate;
	}


	public Date getComplaintCloseDate() {
		return complaintCloseDate;
	}


	public void setComplaintCloseDate(Date complaintCloseDate) {
		this.complaintCloseDate = complaintCloseDate;
	}


	public String getComplaintStatus() {
		return complaintStatus;
	}


	public void setComplaintStatus(String complaintStatus) {
		this.complaintStatus = complaintStatus;
	}


	public String getIssue() {
		return issue;
	}


	public void setIssue(String issue) {
		this.issue = issue;
	}




	public Employee getComplaintBy() {
		return complaintBy;
	}


	public void setComplaintBy(Employee complaintBy) {
		this.complaintBy = complaintBy;
	}


	public Employee getEngineer() {
		return engineer;
	}


	public void setEngineer(Employee engineer) {
		this.engineer = engineer;
	}


	public ComplaintCategory getComplaintCategory() {
		return complaintCategory;
	}


	public void setComplaintCategory(ComplaintCategory complaintCategory) {
		this.complaintCategory = complaintCategory;
	}


	public Material getMaterial() {
		return material;
	}


	public void setMaterial(Material material) {
		this.material = material;
	}


	public String getPriority() {
		return priority;
	}


	public void setPriority(String priority) {
		this.priority = priority;
	}


	public Date getInprocessDate() {
		return inprocessDate;
	}


	public void setInprocessDate(Date inprocessDate) {
		this.inprocessDate = inprocessDate;
	}


	public String getWorkDone() {
		return workDone;
	}


	public void setWorkDone(String workDone) {
		this.workDone = workDone;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	public String getCloseTimeTaken() {
		return closeTimeTaken;
	}


	public void setCloseTimeTaken(String closeTimeTaken) {
		this.closeTimeTaken = closeTimeTaken;
	}


	public String getInprocessTimeTaken() {
		return inprocessTimeTaken;
	}


	public void setInprocessTimeTaken(String inprocessTimeTaken) {
		this.inprocessTimeTaken = inprocessTimeTaken;
	}


	public String getAssetCode() {
		return assetCode;
	}


	public void setAssetCode(String assetCode) {
		this.assetCode = assetCode;
	}
	
	public int getMatId() {
		return matId;
	}


	public void setMatId(int matId) {
		this.matId = matId;
	}


	public int getComCatId() {
		return comCatId;
	}


	public void setComCatId(int comCatId) {
		this.comCatId = comCatId;
	}


	public int getComById() {
		return comById;
	}


	public void setComById(int comById) {
		this.comById = comById;
	}


	@Override
	public String toString() {
		return "Complaint [complaintId=" + complaintId + ", complaintNo=" + complaintNo + ", complaintDate="
				+ complaintDate + ", complaintCloseDate=" + complaintCloseDate + ", complaintStatus=" + complaintStatus
				+ ", issue=" + issue + ", complaintBy=" + complaintBy + ", engineer=" + engineer
				+ ", complaintCategory=" + complaintCategory + ", comCatId=" + comCatId + ", comById=" + comById
				+ ", matId=" + matId + ", material=" + material + ", assetCode=" + assetCode + ", priority=" + priority
				+ ", inprocessDate=" + inprocessDate + ", workDone=" + workDone + ", remark=" + remark
				+ ", closeTimeTaken=" + closeTimeTaken + ", inprocessTimeTaken=" + inprocessTimeTaken + "]";
	}

	
	
	
}
