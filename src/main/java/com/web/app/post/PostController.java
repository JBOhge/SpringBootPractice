//package com.web.app.post;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import java.net.URI;
//import java.util.List;
//
//@RestController
//public class PostController {
//    @Autowired
//    private PostDaoService postService;
//
//    @GetMapping("/users/{id}/posts")
//    public List<Post> getAllPosts(@PathVariable int id){
//        return postService.getAll(id);
//    }
//
//    @PostMapping("/users/{id}/posts")
//    public ResponseEntity<Object> createPost(@PathVariable int id, @RequestBody Post post){
//        Post newPost = postService.createPost(id, post);
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/users/" + id + "/post/{id}").buildAndExpand(newPost.getId()).toUri();
//
//        return ResponseEntity.created(location).build();
//    }
//
//    @GetMapping("/users/{userId}/posts/{postId}")
//    public Post getPost(@PathVariable int userId, @PathVariable int postId){
//        Post post = postService.getPost(userId, postId);
//        if(post == null){
//            throw new PostNotFoundException("Post with id: " + postId + " not found");
//        }
//        return post;
//    }
//}
