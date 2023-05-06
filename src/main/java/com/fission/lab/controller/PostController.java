package com.fission.lab.controller;

import com.fission.lab.model.Comment;
import com.fission.lab.model.Post;
import com.fission.lab.repository.CommentRepository;
import com.fission.lab.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@Slf4j
public class PostController {


     @Autowired
   private PostRepository postRepository;

     @Autowired
     private CommentRepository commentRepository;



      /*@PostMapping("/save/post")
     public ResponseEntity<String> savePost(@RequestBody Post post)
     {
                   Post newPost = new Post();
                   newPost.setDescription(post.getDescription());
                   newPost.setTitle(post.getTitle());
                   newPost.setContent(post.getContent());
                   newPost.setComments(post.getComments());
                   Post savePost = postRepository.save(newPost);
         if (postRepository.findById(savePost.getId()).isPresent()) {
             return ResponseEntity.accepted().body("Successfully Created Post and comments");
         } else
             return ResponseEntity.unprocessableEntity().body("Failed to Create specified post");
     }*/


    @PostMapping("/save/post")
    public ResponseEntity<String> savePost(@RequestBody Post post) {
        Post newPost = new Post();
        newPost.setDescription(post.getDescription());
        newPost.setTitle(post.getTitle());
        newPost.setContent(post.getContent());

        // Set the post field for each comment
        List<Comment> comments = post.getComments();
        for (Comment comment : comments) {
            comment.setPost(newPost);
        }
        newPost.setComments(comments);

        Post savedPost = postRepository.save(newPost);
        if (postRepository.findById(savedPost.getId()).isPresent()) {
            return ResponseEntity.accepted().body("Successfully Created Post and comments");
        } else {
            return ResponseEntity.unprocessableEntity().body("Failed to Create specified post");
        }
    }


    @GetMapping("/save/post/{id}")
    public Post getPostBasedOnId(@PathVariable("id") Long id)
    {
           Post post = postRepository.findById(id).get();

  log.info("post {} = " + post);
           return post;
    }

}
