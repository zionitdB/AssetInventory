/**
 * @Dattatray Bodhale
 */
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

/**
 * @author lenovo
 *
 */
@Entity
@Table(name="asset_allocation_history")
public class AssetAllocationHistory {
	
	
	@Id
	@GeneratedValue
	@Column(name="asset_allocation_history")
	private int asset_allocation_history;
	
	
	@ManyToOne
	@JoinColumn(name="material_id")
	private Material material;
	
	@Column(name="allocation_to")
	private String allocationTo;
	
	@Column(name="allocation_to_spec")
	private int allocationToSpec;
	
	@Column(name="asset_code")
	private String assetCode;
	
	public String getAssetCode() {
		return assetCode;
	}

	public void setAssetCode(String assetCode) {
		this.assetCode = assetCode;
	}

	@Column(name="allocation_date")
	private Date allocationDate;
	
	@Column(name="allocation_token_no")
	private String allocationTokenNo;

	/**
	 * @return the asset_allocation_history
	 */
	public int getAsset_allocation_history() {
		return asset_allocation_history;
	}

	/**
	 * @param asset_allocation_history the asset_allocation_history to set
	 */
	public void setAsset_allocation_history(int asset_allocation_history) {
		this.asset_allocation_history = asset_allocation_history;
	}



	/**
	 * @return the material
	 */
	public Material getMaterial() {
		return material;
	}

	/**
	 * @param material the material to set
	 */
	public void setMaterial(Material material) {
		this.material = material;
	}

	/**
	 * @return the allocationTo
	 */
	public String getAllocationTo() {
		return allocationTo;
	}

	/**
	 * @param allocationTo the allocationTo to set
	 */
	public void setAllocationTo(String allocationTo) {
		this.allocationTo = allocationTo;
	}



	

	/**
	 * @return the allocationToSpec
	 */
	public int getAllocationToSpec() {
		return allocationToSpec;
	}

	/**
	 * @param allocationToSpec the allocationToSpec to set
	 */
	public void setAllocationToSpec(int allocationToSpec) {
		this.allocationToSpec = allocationToSpec;
	}

	/**
	 * @return the allocationDate
	 */
	public Date getAllocationDate() {
		return allocationDate;
	}

	/**
	 * @param allocationDate the allocationDate to set
	 */
	public void setAllocationDate(Date allocationDate) {
		this.allocationDate = allocationDate;
	}

	/**
	 * @return the allocationTokenNo
	 */
	public String getAllocationTokenNo() {
		return allocationTokenNo;
	}

	/**
	 * @param allocationTokenNo the allocationTokenNo to set
	 */
	public void setAllocationTokenNo(String allocationTokenNo) {
		this.allocationTokenNo = allocationTokenNo;
	}
	
	
	
	
}
