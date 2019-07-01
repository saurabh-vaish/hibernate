package com.app.model;


public class FetchTypeInfo {

	/**
	 * 
	 *  FetchType -- is enum having to values EAGER & LAZY
	 *  			Ordinals(positions)   LAZY = 0, EAGER =1
	 * 
	 * 	Eager Loading ----   Parent with child   i.e. when parent data comes with its child data then it is called Eager Loading .
	 * 						By default One-To-One &  Many-To-One i.e.  child is one uses Eager Loading				
	 * 	
	 * 	 Lazy Loading ----   Parent without child   i.e. when parent data comes without its child data then it is called Lazy Loading .
	 * 						By default One-To-Many &  Many-To-Many i.e.  child is More than one uses Lazy Loading		
	 * 
	 * By default loading in multiplicity --
	 * 
	 * 		Non-Collection Type --
	 * 								One-To-One [1----1] , Many-To-One [*----1]  ==>  Eager Loading    (child one)
	 * 		Collection Type ---
	 * 								One-To-Many [1----*] , Many-To-Many [*----*]  ==>  Lazy Loading 	(child many)
	 * 
	 * 
	 * 		** If we want to change type of default loading then we use Fetch Type 
	 * 			
	 * 				Syntax ---   (fetch = FetchType.EAGER/LAZY)
	 * 
	 *   		-- use with multiplicity annotation of Element Collection annotation
	 * 
	 * 
	 * e.g.  
	 * 				
	 * 			class Employee 
	 * 			{
	 * 				@OneToMany(fetch=FetchType.EAGER)   // default lazy
	 * 				@JoinColoumn( name = "abc")
	 * 				Set<Project>  prjs;
	 * 			}
	 * 
	 * 			
	 * 			class Person 
	 * 			{
	 * 				@ManyToOne(fetch=FetchType.LAZY)   // default Eager
	 * 				@JoinColoumn( name = "abc",unique= true)
	 * 				Adhaar  ad;
	 * 			}
	 * 	
	 * 
	 * 
	 * 		// For Collection type  
	 *		
	 *		@ElementCollection(fetch = FetchType.EAGER)          	
	 *		
	 *		@CollectionTable(name="passenngers_names",     		
	 *			joinColumns=@JoinColumn(name="pticketid")  
	 *		)
	 *		
	 *		@Column(name="pnames")					
	 *		private Set<String> names = new HashSet<String>();  
	 *
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * **/
	
	
	
	
	
	
}
