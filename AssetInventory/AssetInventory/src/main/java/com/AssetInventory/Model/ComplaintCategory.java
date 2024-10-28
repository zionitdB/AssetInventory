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
@Table(name="complaint_category")
public class ComplaintCategory {
	
	
	@Id
	@GeneratedValue
	@Column(name="complaint_category_id")
	private int complaintCategoryId;
	

	@Column(name="complaint_category_name")
	private String complaintCategoryName;
	

	@Column(name="active")
	private int active;

	public int getComplaintCategoryId() {
		return complaintCategoryId;
	}

	public void setComplaintCategoryId(int complaintCategoryId) {
		this.complaintCategoryId = complaintCategoryId;
	}

	
	public String getComplaintCategoryName() {
		return complaintCategoryName;
	}

	public void setComplaintCategoryName(String complaintCategoryName) {
		this.complaintCategoryName = complaintCategoryName;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}
	
	

}
