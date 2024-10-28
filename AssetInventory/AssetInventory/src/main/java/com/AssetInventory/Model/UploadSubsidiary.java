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
@Table(name="upload_subsidiary_mst")
public class UploadSubsidiary {


	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="subsidiary_id")
	private int subsidiaryId;
	
	@Column(name="subsidiary_name")
	private String subsidiaryName;
	
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
	 * @return the subsidiaryId
	 */
	public int getSubsidiaryId() {
		return subsidiaryId;
	}

	/**
	 * @param subsidiaryId the subsidiaryId to set
	 */
	public void setSubsidiaryId(int subsidiaryId) {
		this.subsidiaryId = subsidiaryId;
	}

	/**
	 * @return the subsidiaryName
	 */
	public String getSubsidiaryName() {
		return subsidiaryName;
	}

	/**
	 * @param subsidiaryName the subsidiaryName to set
	 */
	public void setSubsidiaryName(String subsidiaryName) {
		this.subsidiaryName = subsidiaryName;
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
