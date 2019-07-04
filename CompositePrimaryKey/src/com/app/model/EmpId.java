package com.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

// CPK class


@Embeddable
public class EmpId implements Serializable{

	@Column(name="eid")
	private Integer empId;

	@Column(name="did")
	private Integer deptId;
	
	public EmpId() {
		super();
	}
	public EmpId(Integer empId, Integer deptId) {
		super();
		this.empId = empId;
		this.deptId = deptId;
	}
	
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	@Override
	public String toString() {
		return "EmpId [empId=" + empId + ", deptId=" + deptId + "]";
	}
	
	
	
	
	
}
