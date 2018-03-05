package de.cultuzz.roomrateinfofetcher.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Channel_X_Communication_X_Details",catalog="cultagent4")
public class ChannelXCommunicationXDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer id;
	
	@Column
	private Integer distributorId;
	
	@Column
	private Short key;
	
	@Column
	private String value;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDistributorId() {
		return distributorId;
	}
	public void setDistributorId(Integer distributorId) {
		this.distributorId = distributorId;
	}
	public Short getKey() {
		return key;
	}
	public void setKey(Short key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
}
