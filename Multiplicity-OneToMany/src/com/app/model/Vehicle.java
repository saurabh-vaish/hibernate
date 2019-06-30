package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vehicleTab1")
public class Vehicle {

	@Id
	@Column(name="vid")
	private Integer vehId;
	
	@Column(name="regnum")
	private String regNum;
	
	@Column(name="state")
	private String state;
	
	public Vehicle() {
		super();
	}
	
	public Vehicle(Integer vehId, String regNum, String state) {
		super();
		this.vehId = vehId;
		this.regNum = regNum;
		this.state = state;
	}
	
	public Integer getVehId() {
		return vehId;
	}
	public void setVehId(Integer vehId) {
		this.vehId = vehId;
	}
	public String getRegNum() {
		return regNum;
	}
	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Vehicle [vehId=" + vehId + ", regNum=" + regNum + ", state=" + state + "]";
	}
	
}
