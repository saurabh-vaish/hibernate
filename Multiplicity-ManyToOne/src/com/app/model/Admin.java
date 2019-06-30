package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="adminTab")
public class Admin {

	@Id
	@Column(name="aid")
	private Integer adminId;
	
	@Column(name="aname")
	private String adminName;
	
	@Column(name="serviceType")
	private String serviceType;
	
	public Admin() {
		super();
	}
	
	public Admin(Integer adminId, String adminName, String serviceType) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.serviceType = serviceType;
	}
	
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", serviceType=" + serviceType + "]";
	}
	
	
	
}
