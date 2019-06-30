package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="persontab")
public class Person {

	@Id
	@Column(name="pid")
	private Integer perId;
	
	@Column(name="pname")
	private String perName;
	
	@Column(name="ploc")
	private String perLoc;
	
	@ManyToOne								// 1...1
	@JoinColumn(name="panidFk",unique=true)   // true to make it as 1...1
	private PanCard pob; //HAS-A   (i.e. using child class as datatype in parent class)

	public Person() {
		super();
	}

	public Person(Integer perId, String perName, String perLoc, PanCard pob) {
		super();
		this.perId = perId;
		this.perName = perName;
		this.perLoc = perLoc;
		this.pob = pob;
	}

	public Integer getPerId() {
		return perId;
	}

	public void setPerId(Integer perId) {
		this.perId = perId;
	}

	public String getPerName() {
		return perName;
	}

	public void setPerName(String perName) {
		this.perName = perName;
	}

	public String getPerLoc() {
		return perLoc;
	}

	public void setPerLoc(String perLoc) {
		this.perLoc = perLoc;
	}

	public PanCard getPob() {
		return pob;
	}

	public void setPob(PanCard pob) {
		this.pob = pob;
	}

	@Override
	public String toString() {
		return "Person [perId=" + perId + ", perName=" + perName + ", perLoc=" + perLoc + ", pob=" + pob + "]";
	}
	
	
}
