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
@Table(name="upload_room_mst")
public class UploadRoom {


	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="room_id")
	private int roomId;
	
	@Column(name="room_name")
	private String roomName;
	
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
	 * @return the roomId
	 */
	public int getRoomId() {
		return roomId;
	}

	/**
	 * @param roomId the roomId to set
	 */
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	/**
	 * @return the roomName
	 */
	public String getRoomName() {
		return roomName;
	}

	/**
	 * @param roomName the roomName to set
	 */
	public void setRoomName(String roomName) {
		this.roomName = roomName;
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
