package ala;

import ala.entities.Post;
import ala.entities.User;
import ala.services.DatabaseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Project1Application.class)
@WebAppConfiguration
public class Project1ApplicationTests {

    @Autowired
    private DatabaseService databaseService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void dbTest() {
        User user = new User();
        String email = "test@email.com";
        user.setEmail(email);

        Post post = new Post();
        post.setTitle("Post 1");
        post.setText("Hello Elo Melo");

        Post post2 = new Post();
        post2.setTitle("Post 2");
        post2.setText("Hello ");

        List<Post> posts = new ArrayList<>();
        posts.add(post);
        posts.add(post2);

        user.setPosts(posts);

        databaseService.saveUser(user);

        User user2 = null;

        user2 = databaseService.findByEmail(email);
        assertNotNull(user2);

        assertEquals(2, user2.getPosts().size());
        System.out.println(user2.toString());

        System.out.println(user2.getPosts().toString());


    }

}
