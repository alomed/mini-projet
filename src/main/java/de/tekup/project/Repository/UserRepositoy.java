package de.tekup.project.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import de.tekup.project.models.User;

public interface UserRepositoy extends PagingAndSortingRepository<User, String>{

}
