/**
 * @Dattatray Bodhale
 */
package com.AssetInventory.Model;

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
@Table(name="upload_work_location_mst")
public class UploadWorklocation {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="work_location_id")
	private int workLocationId;
	
	@Column(name="work_location_name")
	private String workLocationName;
	
	@Column(name="active")
	private int active;
	
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
	 * @return the workLocationId
	 */
	public int getWorkLocationId() {
		return workLocationId;
	}

	/**
	 * @param workLocationId the workLocationId to set
	 */
	public void setWorkLocationId(int workLocationId) {
		this.workLocationId = workLocationId;
	}

	/**
	 * @return the workLocationName
	 */
	public String getWorkLocationName() {
		return workLocationName;
	}

	/**
	 * @param workLocationName the workLocationName to set
	 */
	public void setWorkLocationName(String workLocationName) {
		this.workLocationName = workLocationName;
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
	
	
	
	
}
