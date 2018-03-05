package de.cultuzz.roomrateinfofetcher.dto;

import org.springframework.stereotype.Component;

@Component
public class CommunicationDTO {
	
	private String hotelKey;
	
	private String userName;
	
	private String password;
	
	private String channeKey;
	
	private String gmUrl;
	
	private Integer distributorId;
	
	public Integer getDistributorId() {
		return distributorId;
	}
	public void setDistributorId(Integer distributorId) {
		this.distributorId = distributorId;
	}
	public String getGmUrl() {
		return gmUrl;
	}
	public void setGmUrl(String gmUrl) {
		this.gmUrl = gmUrl;
	}
	public String getChanneKey() {
		return channeKey;
	}
	public void setChanneKey(String channeKey) {
		this.channeKey = channeKey;
	}
	public String getHotelKey() {
		return hotelKey;
	}
	public void setHotelKey(String hotelKey) {
		this.hotelKey = hotelKey;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
