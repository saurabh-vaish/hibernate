package com.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
 *
 *	Bag ---> Bags are non index based collections but they can store duplicate values just like List but have no index column .
 *			 Bag = List - index number (order column)
 *			 Implementation is same as List collection , except that it will not have any @Order column  
 * */


@Entity
@Table(name="ticket_tab_Bag")
public class Ticket {

	@Id
	@Column(name="tid")
	private Integer ticketId;
	@Column(name="tcost")
	private Double ticketCost;
	@Column(name="numpsngrs")
	private Integer noOfPsngrs;
	
	
	// For Collection type  
	@ElementCollection(fetch = FetchType.EAGER)          	 // fetch is not necessary it helps in fetching  data.   
	@CollectionTable(name="passenngers_names",     			// child table name
				joinColumns=@JoinColumn(name="pticketid")   // join column name , it is foreign key column ,will join parent table PK column
	)
	@Column(name="pnames")						// data column in child table , since it is set so no index column
	private List<String> names = new ArrayList<String>();   // making collection object here that later we don't need to create
	
	
	
	public Ticket() {
		super();
	}

	
	public Ticket(Integer ticketId, Double ticketCost, Integer noOfPsngrs, List<String> names) {
		super();
		this.ticketId = ticketId;
		this.ticketCost = ticketCost;
		this.noOfPsngrs = noOfPsngrs;
		this.names = names;
	}


	public Integer getTicketId() {
		return ticketId;
	}


	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}


	public Double getTicketCost() {
		return ticketCost;
	}


	public void setTicketCost(Double ticketCost) {
		this.ticketCost = ticketCost;
	}


	public Integer getNoOfPsngrs() {
		return noOfPsngrs;
	}


	public void setNoOfPsngrs(Integer noOfPsngrs) {
		this.noOfPsngrs = noOfPsngrs;
	}
	
	

	public List<String> getNames() {
		return names;
	}


	public void setNames(List<String> names) {
		this.names = names;
	}


	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", ticketCost=" + ticketCost + ", noOfPsngrs=" + noOfPsngrs + ", names="
				+ names + "]";
	}


	
	

}
