package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

@Entity
@Table(name="emp_prs_tab")     // primary table

@SecondaryTables({				// for secondary tables
	@SecondaryTable(name="emp_prof_tab"),  
	@SecondaryTable(name="emp_exp_tab")
})
public class Employee {

	@Id
	@Column(name="eid")
	private Integer empId;
	@Column(name="ename")
	private String empName;
	@Column(name="erole")
	private String empRole;
	
	@Column(name="edept",table="emp_prof_tab")
	private String empDept;
	@Column(name="eprj",table="emp_prof_tab")
	private String empPrj;
	@Column(name="eexp",table="emp_exp_tab")
	private String empExp;
	
	public Employee() {
		super();
	}

	public Employee(Integer empId, String empName, String empRole, String empDept, String empPrj, String empExp) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empRole = empRole;
		this.empDept = empDept;
		this.empPrj = empPrj;
		this.empExp = empExp;
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

	public String getEmpRole() {
		return empRole;
	}

	public void setEmpRole(String empRole) {
		this.empRole = empRole;
	}

	public String getEmpDept() {
		return empDept;
	}

	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}

	public String getEmpPrj() {
		return empPrj;
	}

	public void setEmpPrj(String empPrj) {
		this.empPrj = empPrj;
	}

	public String getEmpExp() {
		return empExp;
	}

	public void setEmpExp(String empExp) {
		this.empExp = empExp;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empRole=" + empRole + ", empDept=" + empDept
				+ ", empPrj=" + empPrj + ", empExp=" + empExp + "]";
	}
	
	
	
	
	
}
