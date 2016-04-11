package ala.services;

import ala.entities.User;
import ala.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

/**
 * Created by Dendelion on 2016-04-11.
 */
@Transactional
@Service
public class DatabaseService {

    @Autowired //Spring is fucking awesome ^^
    private UserRepository userRepository;
    //kind of magic

    @PostConstruct
    public void init() {
        User u1 = new User();
        u1.setName("Ala");
        u1.setSurname("Musial");
        u1.setPasswd("qwerty");
        String email = "ala@gmail.com";
        u1.setEmail(email);

        userRepository.save(u1);

        User u2 = null;

        u2 = userRepository.findByEmail(email);
        System.out.println(u2.toString());
    }


}
