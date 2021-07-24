package de.tekup.project.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roles")
public class User {
	
	
	  @Id
	  private String id;

	  private String name;

	 


	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public User() {
		// TODO Auto-generated constructor stub
	}

}