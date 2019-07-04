package com.app.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// child class 


@Entity
@Table(name="adminTab121")
public class Admin {

	@Id
	@Column(name="aid")
	private Integer adminId;
	
	@Column(name="aname")
	private String adminName;
	
	@Column(name="serviceType")
	private String serviceType;
	
	@OneToMany(mappedBy="admin")    // opposite of parent
	List<Department> deps;
	
	public Admin() {
		super();
	}

	public Admin(Integer adminId, String adminName, String serviceType, List<Department> deps) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.serviceType = serviceType;
		this.deps = deps;
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

	public List<Department> getDeps() {
		return deps;
	}

	public void setDeps(List<Department> deps) {
		this.deps = deps;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", serviceType=" + serviceType + ", deps="
				+ deps + "]";
	}

	
	
}
