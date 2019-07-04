package com.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


// parent class


@Entity
@Table(name="depttab121")
public class Department {

	@Id
	@Column(name="did")
	private Integer deptId;
	
	@Column(name="dcode")
	private String deptCode;
	
	@ManyToOne(cascade=CascadeType.ALL)					
	@JoinColumn(name="aidFk")	// join column
	private Admin admin;   // HAS-A

	public Department() {
		super();
	}

	public Department(Integer deptId, String deptCode, Admin admin) {
		super();
		this.deptId = deptId;
		this.deptCode = deptCode;
		this.admin = admin;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptCode=" + deptCode + ", admin=" + "]";
	}


	
	
	
	
	
	
}
