package com.app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="tickettab")
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
	private Set<String> names = new HashSet<String>();   // making collection object here that later we don't need to create
	
	
	@ElementCollection
	@CollectionTable(name="passengers_seatNumbers",
			joinColumns=@JoinColumn(name="pticketid")
	)
	@Column(name="pseatnums")
	private Set<String> seatNums  = new HashSet<String>();   // making collection object here that later we don't need to create;

	
	public Ticket() {
		super();
	}

	
	public Ticket(Integer ticketId, Double ticketCost, Integer noOfPsngrs, Set<String> names, Set<String> seatNums) {
		super();
		this.ticketId = ticketId;
		this.ticketCost = ticketCost;
		this.noOfPsngrs = noOfPsngrs;
		this.names = names;
		this.seatNums = seatNums;
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


	public Set<String> getNames() {
		return names;
	}


	public void setNames(Set<String> names) {
		this.names = names;
	}


	public Set<String> getSeatNums() {
		return seatNums;
	}


	public void setSeatNums(Set<String> seatNums) {
		this.seatNums = seatNums;
	}


	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", ticketCost=" + ticketCost + ", noOfPsngrs=" + noOfPsngrs + ", names="
				+ names + ", seatNums=" + seatNums + "]";
	}

	

}
