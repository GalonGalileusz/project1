package ala.services;

import ala.entities.Post;
import ala.entities.User;
import ala.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

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

        Post post = new Post();
        post.setTitle("Post 1");
        post.setText("Hello Elo Melo");

        Post post2 = new Post();
        post2.setTitle("Post 2");
        post2.setText("Hello ");

        List<Post> posts = new ArrayList<>();
        posts.add(post);
        posts.add(post2);

        u1.setPosts(posts);

        userRepository.save(u1);

        User u2 = null;

        u2 = userRepository.findByEmail(email);
        System.out.println(u2.toString());
    }

    public User findById(long id) {
        return userRepository.findOne(id);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
