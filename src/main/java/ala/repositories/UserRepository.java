package ala.repositories;

import ala.entities.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Dendelion on 2016-04-11.
 */
public interface UserRepository extends CrudRepository<User, Long> /*1-content, 2- primary key */ {
    User findByEmail(String email);
}