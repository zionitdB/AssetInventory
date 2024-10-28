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
import jakarta.persistence.Transient;
/**
 * @author lenovo
 *
 */
@Entity
@Table(name="asset_allocation")
public class AssetAllocation {
		
	@Id
	@GeneratedValue
	@Column(name="asset_allocation_id")
	private int assetAllocationId;
	
	@Column(name="requested_token_no")
	private String requestedtokenNo;
	
	@ManyToOne
	@JoinColumn(name="employee_id")
	private Employee employee;
	@ManyToOne
	@JoinColumn(name="room_id")
	private Room room;
	
	
	@ManyToOne
	@JoinColumn(name="deaprtment_id")
	private Department department;
	
	
	
	@ManyToOne
	@JoinColumn(name="desk_id")
	private Desk desk;
	
	
	@ManyToOne
	@JoinColumn(name="project_id")
	private Project project;
	
	@ManyToOne
	@JoinColumn(name="material_id")
	private Material material;
	
	
	@ManyToOne
	@JoinColumn(name="asset_inventory_id")
	private AssetInventory assetInventory;
	
	
	@Column(name="asset_code")
	private String assetCode;
	
	@Column(name="allocation_status")
	private int allocationStatus;
	
	@Column(name="allocation_date")
	private Date allocationDate;
	
	@Column(name="allocation_to")
	private String allocationTo;

	@Column(name="release_request")
	private int releaseRequest;
	
	@Column(name="allocate_by")
	private int allocateBy;
	
	@Column(name="is_released")
	private int isReleased;
	
	@Column(name="released_date")
	private Date releasedDate;
	
	@Transient
	private int releaseRequstBit;

	/**
	 * @return the assetAllocationId
	 */
	public int getAssetAllocationId() {
		return assetAllocationId;
	}

	/**
	 * @param assetAllocationId the assetAllocationId to set
	 */
	public void setAssetAllocationId(int assetAllocationId) {
		this.assetAllocationId = assetAllocationId;
	}

	/**
	 * @return the requestedtokenNo
	 */
	public String getRequestedtokenNo() {
		return requestedtokenNo;
	}

	/**
	 * @param requestedtokenNo the requestedtokenNo to set
	 */
	public void setRequestedtokenNo(String requestedtokenNo) {
		this.requestedtokenNo = requestedtokenNo;
	}

	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * @return the room
	 */
	public Room getRoom() {
		return room;
	}

	/**
	 * @return the isReleased
	 */
	public int getIsReleased() {
		return isReleased;
	}

	/**
	 * @param isReleased the isReleased to set
	 */
	public void setIsReleased(int isReleased) {
		this.isReleased = isReleased;
	}

	/**
	 * @return the releasedDate
	 */
	public Date getReleasedDate() {
		return releasedDate;
	}

	/**
	 * @param releasedDate the releasedDate to set
	 */
	public void setReleasedDate(Date releasedDate) {
		this.releasedDate = releasedDate;
	}

	/**
	 * @param room the room to set
	 */
	public void setRoom(Room room) {
		this.room = room;
	}

	/**
	 * @return the department
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

	/**
	 * @return the desk
	 */
	public Desk getDesk() {
		return desk;
	}

	public AssetInventory getAssetInventory() {
		return assetInventory;
	}

	public void setAssetInventory(AssetInventory assetInventory) {
		this.assetInventory = assetInventory;
	}

	/**
	 * @param desk the desk to set
	 */
	public void setDesk(Desk desk) {
		this.desk = desk;
	}

	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * @param project the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
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
	 * @return the assetCode
	 */
	public String getAssetCode() {
		return assetCode;
	}

	/**
	 * @param assetCode the assetCode to set
	 */
	public void setAssetCode(String assetCode) {
		this.assetCode = assetCode;
	}

	/**
	 * @return the allocationStatus
	 */
	public int getAllocationStatus() {
		return allocationStatus;
	}

	/**
	 * @param allocationStatus the allocationStatus to set
	 */
	public void setAllocationStatus(int allocationStatus) {
		this.allocationStatus = allocationStatus;
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
	 * @return the releaseRequest
	 */
	public int getReleaseRequest() {
		return releaseRequest;
	}

	/**
	 * @param releaseRequest the releaseRequest to set
	 */
	public void setReleaseRequest(int releaseRequest) {
		this.releaseRequest = releaseRequest;
	}

	
	public int getAllocateBy() {
		return allocateBy;
	}

	public void setAllocateBy(int allocateBy) {
		this.allocateBy = allocateBy;
	}

	public int getReleaseRequstBit() {
		return releaseRequstBit;
	}

	public void setReleaseRequstBit(int releaseRequstBit) {
		this.releaseRequstBit = releaseRequstBit;
	}

	
	
}
