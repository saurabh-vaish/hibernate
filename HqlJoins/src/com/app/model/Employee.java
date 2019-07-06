package com.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/****
 * 	Joins -- Fetching multiple tables data . ---- > Self join , Equal Join , Cross Join , Inner Join (Join) , 
 * 													Outer Join [ Left Outer Join , Right Outer Join, Full Join]
 * 
 * 	There must be has a relation between tables .
 * 
 * 
 * ****/


@Entity
@Table(name="emptabjoin")
public class Employee {

	@Id
	@Column(name="eid")
	private Integer empId;
	@Column(name="ename")
	private String empName;
	@Column(name="esal")
	private Double empSal;
	
	@OneToMany
	@JoinColumn(name="pidFk")
	private List<Project> prjs = new  ArrayList<>();   // for hql joins there must be has a relation with child table 

	public Employee() {
		super();
	}

	
	
	public Employee(Integer empId, String empName, Double empSal, List<Project> prjs) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSal = empSal;
		this.prjs = prjs;
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

	public Double getEmpSal() {
		return empSal;
	}

	public void setEmpSal(Double empSal) {
		this.empSal = empSal;
	}



	public List<Project> getPrjs() {
		return prjs;
	}



	public void setPrjs(List<Project> prjs) {
		this.prjs = prjs;
	}



	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + ", prjs=" + prjs + "]";
	}


	
}