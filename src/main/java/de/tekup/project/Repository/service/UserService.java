package de.tekup.project.Repository.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import de.tekup.project.Repository.UserRepositoy;
import de.tekup.project.models.User;

public class UserService  {

	
	private UserRepositoy repouser;
	
	
	
	
	@Autowired
	public UserService(UserRepositoy repouser) {
		super();
		this.repouser = repouser;
	}





	public UserService() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Optional<User> findById(String id) {
        return repouser.findById(id);
    }
	
	
	  
	    public User save(User user) {
	        return repouser.save(user);
	    }

	    
	    public Iterable<User> findAll() {
	        return repouser.findAll();
	    }
	
	
	
	
	
	
	
	
	
	

}
