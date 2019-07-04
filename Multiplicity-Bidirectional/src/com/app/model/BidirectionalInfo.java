package com.app.model;

public class BidirectionalInfo {

	
	/***
	 * 
	 *  Directions in Multiplicity :-  Two types - --    a.  Unidirectional   b. Bidirectional 
	 *  
	 *    1. Unidirectional -->   In unidirectional if we select parent data then child data also come but it reverse is not possible i.e.
	 *    							if we will select child data then only child data will come not parent .
	 *    
	 *    2. Bidirectional -->  Bi-directional indicates two sides link between parent and child data . In this if we select parent then child will come
	 *    						and if we select child then parent data will come .. 
	 *    
	 *     To Implement this ----->>
	 *     	
	 *     				Step -1  Apply reverse has a relation i.e. parent should behave as child and child should behave as parent.
	 *     				
	 *     				Step -2  Make Multiplicity reverse ( do not write JoinColumn & JoinTable on child side only annotation).
	 *     				
	 *     				Step -3  Apply mappedBy = "has-A variable" at not owning side of multiplicity.  i.e. opposite side of FK created
	 *     
	 *     *** Identify Parent By @JoinColumn annotation 
	 *     	
	 * 
	 * 
	 * 				Uni 						---			Bi
	 * 			@ManyToOne								@OneToOne(mappedBy="....")
	 * 			@ManyToOne								@OneToMany(mappedBy="....")
	 * 			@OneToMany(mappedBy="....")				@ManyToOne
	 * 			@ManyToMany								@ManyToMany(mappedBy="....")
	 * 
	 * 
	 * **/
	
	
	

}
