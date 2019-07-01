package com.app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="clinettab")
public class Client {

	@Id
	@Column(name="cid")
	private Integer clnId;
	
	@Column(name="ccode")
	private String clnCode;
	
	@Column(name="cloc")
	private String loc;
	
	
	@ManyToMany(fetch= FetchType.EAGER)		// default is Lazy , so making eager so that child will also come
	@JoinTable(name="cln_prj_tab",
		joinColumns=@JoinColumn(name="cidfk"),
		inverseJoinColumns=@JoinColumn(name="pidfk")
	)
	private Set<Project> pobs = new  HashSet<>();;
	
	public Client() {
		super();
	}

	

	public Client(Integer clnId, String clnCode, String loc, Set<Project> pobs) {
		super();
		this.clnId = clnId;
		this.clnCode = clnCode;
		this.loc = loc;
		this.pobs = pobs;
	}



	public Integer getClnId() {
		return clnId;
	}

	public void setClnId(Integer clnId) {
		this.clnId = clnId;
	}

	public String getClnCode() {
		return clnCode;
	}

	public void setClnCode(String clnCode) {
		this.clnCode = clnCode;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}



	public Set<Project> getPobs() {
		return pobs;
	}



	public void setPobs(Set<Project> pobs) {
		this.pobs = pobs;
	}



	@Override
	public String toString() {
		return "Client [clnId=" + clnId + ", clnCode=" + clnCode + ", loc=" + loc + ", pobs=" + pobs + "]";
	}

	
	
}

