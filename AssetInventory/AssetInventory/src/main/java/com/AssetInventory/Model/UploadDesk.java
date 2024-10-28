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
@Table(name="upload_desk_mst")
public class UploadDesk {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="desk_id")
	private int deskId;
	
	@Column(name="floor")
	private String floor;
	
	@Column(name="bay")
	private String bay;
	
	@Column(name="desk_code")
	private String deskCode;
	
	@Column(name="active")
	private int active;
	
	@Column(name="allocate")
	private int allocate;

	
	
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
	 * @return the deskId
	 */
	public int getDeskId() {
		return deskId;
	}

	/**
	 * @param deskId the deskId to set
	 */
	public void setDeskId(int deskId) {
		this.deskId = deskId;
	}

	/**
	 * @return the floor
	 */
	public String getFloor() {
		return floor;
	}

	/**
	 * @param floor the floor to set
	 */
	public void setFloor(String floor) {
		this.floor = floor;
	}

	/**
	 * @return the bay
	 */
	public String getBay() {
		return bay;
	}

	/**
	 * @param bay the bay to set
	 */
	public void setBay(String bay) {
		this.bay = bay;
	}

	/**
	 * @return the deskCode
	 */
	public String getDeskCode() {
		return deskCode;
	}

	/**
	 * @param deskCode the deskCode to set
	 */
	public void setDeskCode(String deskCode) {
		this.deskCode = deskCode;
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
	 * @return the allocate
	 */
	public int getAllocate() {
		return allocate;
	}

	/**
	 * @param allocate the allocate to set
	 */
	public void setAllocate(int allocate) {
		this.allocate = allocate;
	}



}
