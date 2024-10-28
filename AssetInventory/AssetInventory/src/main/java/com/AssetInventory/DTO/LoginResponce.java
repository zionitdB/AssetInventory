package com.AssetInventory.DTO;

import com.AssetInventory.Model.User;

public class LoginResponce {
	private int responceCode;
	private String responceMsg;
	private User data;
	public int getResponceCode() {
		return responceCode;
	}
	public void setResponceCode(int responceCode) {
		this.responceCode = responceCode;
	}
	public String getResponceMsg() {
		return responceMsg;
	}
	public void setResponceMsg(String responceMsg) {
		this.responceMsg = responceMsg;
	}
	public User getData() {
		return data;
	}
	public void setData(User data) {
		this.data = data;
	}
	
	
	
	
	
	
}
