package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="projtabjoin")
public class Project{

	@Id
	@Column(name="pid")
	private Integer projId;
	@Column(name="pcode")
	private String prjCode;
	@Column(name="pcost")
	private Double prjCost;
	
	public Project() {
		super();
	}

	public Project(Integer projId, String prjCode, Double prjCost) {
		super();
		this.projId = projId;
		this.prjCode = prjCode;
		this.prjCost = prjCost;
	}

	public Integer getProjId() {
		return projId;
	}

	public void setProjId(Integer projId) {
		this.projId = projId;
	}

	public String getPrjCode() {
		return prjCode;
	}

	public void setPrjCode(String prjCode) {
		this.prjCode = prjCode;
	}

	public Double getPrjCost() {
		return prjCost;
	}

	public void setPrjCost(Double prjCost) {
		this.prjCost = prjCost;
	}

	@Override
	public String toString() {
		return "Project [projId=" + projId + ", prjCode=" + prjCode + ", prjCost=" + prjCost + "]";
	}
	
	
	
}
