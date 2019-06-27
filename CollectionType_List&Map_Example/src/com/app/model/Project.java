package com.app.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

/**
 * For storing multiple data into one column or variable collections are used  , here one child table is created for every collection
 * 
 * 	Collections are two types --- Index based --> List ,Map ,IdBag    (3 column)
 * 								Non Index Based --> Set , Bag		  (2 column)
 * 
 * @ElementCollecton ---  specifies that it is a collection column
 *
 * @CollectionTable --  used to specify collection table 
 *
 *	Fetch type is useful in fetching data from db -- EAGER, LAZY
 *
 * */



@Entity
@Table(name="projectTab")
public class Project {

	@Id
	@Column(name="pid")
	private Integer prjId;
	@Column(name="pCode")
	private String prjCode;
	@Column(name="pCost")
	private Double prjCost;
	
	@ElementCollection
	@CollectionTable(
			name="project_version_tab",              // child table name 
			joinColumns= @JoinColumn(name="pid")     // join column name 
	)
	@OrderColumn(name="pos")                         // index column
	@Column(name="version")							// data column
	private List<String> prjVersion = new ArrayList<>();

	
	@ElementCollection
	@CollectionTable(
			name="project_Modules_tab",
			joinColumns= @JoinColumn(name="pid")
	)
	@MapKeyColumn(name="feature")					// index as key
	@Column(name="enable")							// value or data column
	private Map<String,String> prjModules = new LinkedHashMap<>();


	public Project() {
		super();
	}


	public Project(Integer prjId, String prjCode, Double prjCost, List<String> prjVersion,
			Map<String, String> prjModules) {
		super();
		this.prjId = prjId;
		this.prjCode = prjCode;
		this.prjCost = prjCost;
		this.prjVersion = prjVersion;
		this.prjModules = prjModules;
	}


	public Integer getPrjId() {
		return prjId;
	}


	public void setPrjId(Integer prjId) {
		this.prjId = prjId;
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


	public List<String> getPrjVersion() {
		return prjVersion;
	}


	public void setPrjVersion(List<String> prjVersion) {
		this.prjVersion = prjVersion;
	}


	public Map<String, String> getPrjModules() {
		return prjModules;
	}


	public void setPrjModules(Map<String, String> prjModules) {
		this.prjModules = prjModules;
	}


	@Override
	public String toString() {
		return "Project [prjId=" + prjId + ", prjCode=" + prjCode + ", prjCost=" + prjCost + ", prjVersion="
				+ prjVersion + ", prjModules=" + prjModules + "]";
	}
	
	
	
	
}