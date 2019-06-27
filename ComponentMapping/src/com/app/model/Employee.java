package com.app.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Component Mapping is used to connect multiple model classes to one table .  
 * Here one table behave as primary table and other table behaves as child table . 
 * 	
 * *Child table connect with parent table using has a relation 
 * 
 * @Embeddable -- Used at child class level 
 * 
 * @Embeded --- used on has-a variable  
 * 
 * **/



@Entity
@Table(name="commantab")
public class Employee {

	@Id
	@Column(name="eid")
	private Integer empId;
	
	@Column(name="ename")
	private String empName;
	
	@Embedded  				// used at HAS-A variable level  
	private Address addr;  //HAS-A   child class used as DataType and creating a variable

	public Employee() {
		super();
	}

	public Employee(Integer empId, String empName, Address addr) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.addr = addr;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", addr=" + addr + "]";
	}
	
	
}
