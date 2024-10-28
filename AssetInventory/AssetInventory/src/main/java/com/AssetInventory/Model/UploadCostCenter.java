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
@Table(name="upload_cost_center_mst")
public class UploadCostCenter {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cost_center_id")
	private int costCenterId;
	
	@Column(name="cost_center_name")
	private String costCenterName;
	
	@Column(name="active")
	private int active;
	
	
	@ManyToOne
	@JoinColumn(name="upload_detials_id")
	private UploadDetial uploadDetial;

	/**
	 * @return the costCenterId
	 */
	public int getCostCenterId() {
		return costCenterId;
	}

	/**
	 * @param costCenterId the costCenterId to set
	 */
	public void setCostCenterId(int costCenterId) {
		this.costCenterId = costCenterId;
	}

	/**
	 * @return the costCenterName
	 */
	public String getCostCenterName() {
		return costCenterName;
	}

	/**
	 * @param costCenterName the costCenterName to set
	 */
	public void setCostCenterName(String costCenterName) {
		this.costCenterName = costCenterName;
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

	public UploadDetial getUploadDetial() {
		return uploadDetial;
	}

	public void setUploadDetial(UploadDetial uploadDetial) {
		this.uploadDetial = uploadDetial;
	}
	
	

}
