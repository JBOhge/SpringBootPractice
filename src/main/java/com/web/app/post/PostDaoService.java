package com.web.app.post;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class PostDaoService {
    private static List<Post> postList = new ArrayList<>();
    private static int postCount = 3;


    static {
        postList.add(new Post("Hello World", 1,1));
        postList.add(new Post("Goodbye World", 1,2));
        postList.add(new Post("Today is a Good Day!", 2,3));
    }

    public List<Post> getAll(int id){
        List<Post> userPostList = new ArrayList<>();
        for(Post post: postList){
            if(post.getUserId() == id){
                userPostList.add(post);
            }
        }
        return userPostList;
    }

    public Post createPost(int userId, Post post){
        post.setUserId(userId);
        post.setId(++postCount);
        postList.add(post);
        return post;
    }

    public Post getPost(int userId, int postId){
        for(Post post: postList){
            if(post.getUserId() == userId && post.getId() == postId ){
                return post;
            }
        }

        return null;
    }



}
