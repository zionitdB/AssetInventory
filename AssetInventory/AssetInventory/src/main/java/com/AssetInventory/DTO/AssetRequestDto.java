/**
 * @Dattatray Bodhale
 */
package com.AssetInventory.DTO;

import java.util.List;

import com.AssetInventory.Model.Employee;
import com.AssetInventory.Model.Material;



/**
 * @author lenovo
 *
 */
public class AssetRequestDto {
	
	private Employee employee;
	private List<Material> materials;
	private int requestedBy;
	private String message;
	private int employeeId;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
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
	 * @return the materials
	 */
	public List<Material> getMaterials() {
		return materials;
	}
	/**
	 * @param materials the materials to set
	 */
	public void setMaterials(List<Material> materials) {
		this.materials = materials;
	}
	/**
	 * @return the requestedBy
	 */
	public int getRequestedBy() {
		return requestedBy;
	}
	/**
	 * @param requestedBy the requestedBy to set
	 */
	public void setRequestedBy(int requestedBy) {
		this.requestedBy = requestedBy;
	}
	
	
	

}
