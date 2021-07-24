package de.tekup.project.Controller;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.project.Repository.dto.Userdto;
import de.tekup.project.Repository.service.UserService;
import de.tekup.project.models.User;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

	private UserService userserv;
	
	
	
	public UserController(UserService userserv) {
		super();
		this.userserv = userserv;
	}

	public UserController() {
		// TODO Auto-generated constructor stub
	}

	@CrossOrigin(origins = "http://localhost:8089")    
    @GetMapping(value = "/{id}")
    public Userdto findOne(@PathVariable String id) {
        User entity;
		Optional<User> opt = userserv.findById(id);
		if(opt.isPresent())
		 entity = opt.get();
		else
			throw new NoSuchElementException("Person with this id is not found");
        return convertToDto(entity);
    }

    @GetMapping
    public Collection<Userdto> findAll() {
        Iterable<User> foos = this.userserv.findAll();
        java.util.List<Userdto> fooDtos = new ArrayList<>();
        foos.forEach(p -> fooDtos.add(convertToDto(p)));
        return fooDtos;
    }

    protected Userdto convertToDto(User entity) {
        Userdto dto = new Userdto(entity.getId(), entity.getName());

        return dto;
    }
}
