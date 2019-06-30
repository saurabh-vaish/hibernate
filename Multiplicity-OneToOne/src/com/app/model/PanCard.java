package com.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="pantab")
public class PanCard {

	@Id
	@Column(name="pid")
	private Integer panId;
	
	@Column(name="hname")
	private String nameOnPan;
	
	@Column(name="fname")
	private String fatherName;

	@Column(name="hdob")
	@Temporal(TemporalType.TIMESTAMP.DATE)
	private Date dob;
	
	@Column(name="issueDate")
	@Temporal(TemporalType.TIMESTAMP.TIMESTAMP)
	private Date issuedate;
	
	public PanCard() {
		super();
	}
	
	public PanCard(Integer panId, String nameOnPan, String fatherName, Date dob, Date issuedate) {
		super();
		this.panId = panId;
		this.nameOnPan = nameOnPan;
		this.fatherName = fatherName;
		this.dob = dob;
		this.issuedate = issuedate;
	}
	public Integer getPanId() {
		return panId;
	}
	public void setPanId(Integer panId) {
		this.panId = panId;
	}
	public String getNameOnPan() {
		return nameOnPan;
	}
	public void setNameOnPan(String nameOnPan) {
		this.nameOnPan = nameOnPan;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getIssuedate() {
		return issuedate;
	}
	public void setIssuedate(Date issuedate) {
		this.issuedate = issuedate;
	}
	@Override
	public String toString() {
		return "PanCard [panId=" + panId + ", nameOnPan=" + nameOnPan + ", fatherName=" + fatherName + ", dob=" + dob
				+ ", issuedate=" + issuedate + "]";
	}
	
	
	
	
}
