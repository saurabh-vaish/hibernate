package com.app.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable            // used at child class level it says do not use this class as independent table 
public class Address {

	// here child class will have no primary key
	
	@Column(name="ahno")
	private String hno;
	@Column(name="aloc")
	private String loc;
	
	public Address() {
		super();
	}

	public String getHno() {
		return hno;
	}

	public void setHno(String hno) {
		this.hno = hno;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "Address [hno=" + hno + ", loc=" + loc + "]";
	}
	
	
	
	
}
