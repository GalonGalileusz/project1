package ala.controllers;

import ala.entities.Post;
import ala.entities.User;
import ala.responses.PostsStore;
import ala.services.DatabaseService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Dendelion on 2016-04-13.
 */

@RestController
@RequestMapping("/posts")
public class PostController {

    private static final Logger logger = Logger.getLogger(PostController.class);

    @Autowired
    private DatabaseService databaseService;

    @RequestMapping(value = "/getposts", method = RequestMethod.POST)
    public ResponseEntity<PostsStore> getUserPosts(@RequestBody String email) {

        User user = databaseService.findByEmail(email);
        ResponseEntity<PostsStore> response;

        PostsStore postsStore = new PostsStore();

        if (user != null) {
            logger.info("User has been found");
            List<Post> posts = user.getPosts();
            postsStore.setUserName(user.getEmail());
            postsStore.setPosts(posts);
            response = new ResponseEntity<PostsStore>(postsStore, HttpStatus.OK);
        } else {
            logger.error("NOPE NOPE NOPE");
            response = new ResponseEntity<PostsStore>(postsStore, HttpStatus.NOT_FOUND);
        }

        return response;

    }
}
