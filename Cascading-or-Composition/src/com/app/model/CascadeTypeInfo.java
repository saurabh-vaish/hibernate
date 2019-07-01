package com.app.model;


public class CascadeTypeInfo {

	/**
	 * 
	 * 
	 *  Two components(classes) are connected using Has-A relation .  
	 * 	
	 * 	Aggregation --->  It classes are loosely coupled i.e.   Child class may exist in the absent of Parent  .
	 * 						e.g. Project(c)  may exist without   Employee(P)
	 *  
	 * 	Composition --->  It classes have string has a relation   i.e.  Child class data have no meaning without Parent	.
	 * 						e.g. Address(c)  have no meaning without   Person(P)
	 * 
	 * 	*** By default every has a relation is aggregation , to make it composition we use Cascading
	 * 
	 * 
	 * 	  Cascading --   Process of apply parent operation on child class also which makes parent and child objects strongly connected .
	 * 					
	 * 					** It is applicable for non select operations only i.e. save , update ,delete 
	 * 					**  for select use fetch type 
	 * 
	 * 	CascadeType--- It is a enum provided by Jpa having values --  ALL, PERSIST, DETATCH, MERGE , REMOVE, REFRESH 
	 * 
	 * 
	 * 		e.g. 
	 * 				 class Module { }
	 * 					
	 * 				class Project {
	 * 
	 * 					@OneToMany(cascade = CascadeType.ALL)
	 * 					@JoinColumn(name = "abc")
	 * 					List<Modules> m ;
	 * 				}
	 * 
	 * 
	 * 		e.eg.      	@OneToMany(fetch= FetchType.Eager , cascade = CascadeType.ALL)
	 * 				
	 * 
	 * 
	 * **/
	
	
}
