package com.geonoo.board.controller;


import com.geonoo.board.domain.Post;
import com.geonoo.board.dto.PostDto;
import com.geonoo.board.repository.PostRepository;
import com.geonoo.board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostRepository postRepository;

    private final PostService postService;

    @GetMapping("/api/post")
    public List<Post> listPost(){
        return postRepository.findAll(Sort.by(Sort.Direction.DESC, "createdDate"));
    }

    @GetMapping("/api/post/{id}")
    public Post onePost(@PathVariable Long id){
        return postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 글이 존재하지 않습니다.")
        );
    }

    @PostMapping("/api/post")
    public Post addPost(@RequestBody PostDto postDto) {

        Post post = new Post(postDto);
        return postRepository.save(post);
    }

    @PutMapping("/api/post/{id}")
    public Post putPost(@RequestBody PostDto postDto, @PathVariable Long id){

        return postService.update(id, postDto);
    }

    @DeleteMapping("/api/post/{id}")
    public Long deletePost(@PathVariable Long id){
        return postService.delete(id);
    }
}
