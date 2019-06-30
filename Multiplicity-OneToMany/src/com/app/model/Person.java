package com.app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="persontab1")
public class Person {
	
	@Id
	@Column(name="pid")
	private Integer perosnId;
	
	@Column(name="pname")
	private String perName;
	
	@Column(name="paddr")
	private String perAddr;
	
	@OneToMany
	@JoinColumn(name="pidfk")
	private Set<Vehicle> vobs = new HashSet<>();

	public Person() {
		super();
	}

	
	public Person(Integer perosnId, String perName, String perAddr, Set<Vehicle> vobs) {
		super();
		this.perosnId = perosnId;
		this.perName = perName;
		this.perAddr = perAddr;
		this.vobs = vobs;
	}




	public Integer getPerosnId() {
		return perosnId;
	}



	public void setPerosnId(Integer perosnId) {
		this.perosnId = perosnId;
	}




	public String getPerName() {
		return perName;
	}




	public void setPerName(String perName) {
		this.perName = perName;
	}




	public String getPerAddr() {
		return perAddr;
	}




	public void setPerAddr(String perAddr) {
		this.perAddr = perAddr;
	}




	public Set<Vehicle> getVobs() {
		return vobs;
	}




	public void setVobs(Set<Vehicle> vobs) {
		this.vobs = vobs;
	}




	@Override
	public String toString() {
		return "Person [perosnId=" + perosnId + ", perName=" + perName + ", perAddr=" + perAddr + ", vobs=" + vobs
				+ "]";
	}
	
	
	
}
