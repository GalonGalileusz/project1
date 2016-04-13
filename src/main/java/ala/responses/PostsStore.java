package ala.responses;

import ala.entities.Post;

import java.util.List;

/**
 * Created by Dendelion on 2016-04-13.
 */
public class PostsStore {
    private String userName = null;
    private List<Post> posts = null;

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "PostsStore{" +
                "userName='" + userName + '\'' +
                ", posts=" + posts.toString() +
                '}';
    }
}
