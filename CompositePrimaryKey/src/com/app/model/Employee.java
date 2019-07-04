package com.app.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *  Composite Primary Key -- When in any table two column behave as primary key then we should make them as CPK
 *  						 They can't have null values 
 *  						 Duplicates are possible but only in one column , keys pair should not be duplicate ...
 *  
 *  	To implement CPK , we should take CPK as separate class that implements Serializable , Apply @Embeddable over class
 *  						In parent class make has a relation and apply @EmbddedId over has a variable   
 * 
 * **/

@Entity
@Table(name="employeeComposite")
public class Employee {

	@EmbeddedId
	private EmpId eid;
	
	@Column(name="ename")
	private String empName;

	@Column(name="dname")
	private String deptName;
	
	public Employee() {
		super();
	}
	
	public Employee(EmpId eid, String empName, String deptName) {
		super();
		this.eid = eid;
		this.empName = empName;
		this.deptName = deptName;
	}
	public EmpId getEid() {
		return eid;
	}
	public void setEid(EmpId eid) {
		this.eid = eid;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", empName=" + empName + ", deptName=" + deptName + "]";
	}
	
	
}
