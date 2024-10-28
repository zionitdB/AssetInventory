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
@Table(name="bussiness_unit_mst")
public class BussinessUnit {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bussiness_unit_id")
	private int bussinessUnitId;
	
	@Column(name="business_unit")
	private String businessUnit;
	
	@Column(name="active")
	private int active;

	/**
	 * @return the bussinessUnitId
	 */
	public int getBussinessUnitId() {
		return bussinessUnitId;
	}

	/**
	 * @param bussinessUnitId the bussinessUnitId to set
	 */
	public void setBussinessUnitId(int bussinessUnitId) {
		this.bussinessUnitId = bussinessUnitId;
	}

	/**
	 * @return the businessUnit
	 */
	public String getBusinessUnit() {
		return businessUnit;
	}

	/**
	 * @param businessUnit the businessUnit to set
	 */
	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
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
