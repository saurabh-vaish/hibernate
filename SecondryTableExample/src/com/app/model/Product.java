package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * Secondary tables used to connect one model class to  min 2 or max n tables  . i.e. multiple tables will be connected to one model class
 * 	
 * 	They all will share same primary key of parent table . 
 * 
 * */



@Entity
@Table(name="prod_aone")  // primary table 

@SecondaryTables({ 							// for secondary tables
	@SecondaryTable(name="prod_atwo"),     // first secondary table
	@SecondaryTable(name="prod_athree")		// second secondary table
})
public class Product
{
	@Id
	@Column(name="pid")
	private Integer prodId;
	@Column(name="pcode")
	private String prodCode;
	@Column(name="pcost")
	private String prodCost;
	
	@Column(name="slab",table="prod_atwo")
	private String prodSlab;
	@Column(name="get",table="prod_atwo")
	private String gstSlab;
	
	@Column(name="mrp",table="prod_athree")
	private Double mrp;
	@Column(name="disc",table="prod_athree")
	private Double disc;
	
	@Transient          // bcs it should not come in table , it will not go in any table
	private Double total;

	
	public Product() {
		super();
	}

	public Product(Integer prodId, String prodCode, String prodCost, String prodSlab, String gstSlab, Double mrp,
			Double disc, Double total) {
		super();
		this.prodId = prodId;
		this.prodCode = prodCode;
		this.prodCost = prodCost;
		this.prodSlab = prodSlab;
		this.gstSlab = gstSlab;
		this.mrp = mrp;
		this.disc = disc;
		this.total = total;
	}

	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public String getProdCode() {
		return prodCode;
	}

	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}

	public String getProdCost() {
		return prodCost;
	}

	public void setProdCost(String prodCost) {
		this.prodCost = prodCost;
	}

	public String getProdSlab() {
		return prodSlab;
	}

	public void setProdSlab(String prodSlab) {
		this.prodSlab = prodSlab;
	}

	public String getGstSlab() {
		return gstSlab;
	}

	public void setGstSlab(String gstSlab) {
		this.gstSlab = gstSlab;
	}

	public Double getMrp() {
		return mrp;
	}

	public void setMrp(Double mrp) {
		this.mrp = mrp;
	}

	public Double getDisc() {
		return disc;
	}

	public void setDisc(Double disc) {
		this.disc = disc;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", prodCode=" + prodCode + ", prodCost=" + prodCost + ", prodSlab="
				+ prodSlab + ", gstSlab=" + gstSlab + ", mrp=" + mrp + ", disc=" + disc + ", total=" + total + "]";
	}
	
	
	
	
	
}