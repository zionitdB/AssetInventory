/**
 * @Dattatray Bodhale
 */
package com.AssetInventory.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
/**
 * @author lenovo
 *
 */
@Entity
@Table(name="subsidiary_mst")
public class Subsidiary {


	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="subsidiary_id")
	private int subsidiaryId;
	
	@Column(name="subsidiary_name")
	private String subsidiaryName;
	
	@Column(name="active")
	private int active;

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
