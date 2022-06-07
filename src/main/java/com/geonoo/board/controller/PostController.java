package com.geonoo.board.controller;


import com.geonoo.board.domain.Post;
import com.geonoo.board.dto.PostDto;
import com.geonoo.board.repository.PostRepository;
import com.geonoo.board.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController // @Controller에 @ResponseBody가 추가
@RequiredArgsConstructor //아래 의존하는 클래스를 주입하기위해 생성자 주입방법을 간략하게 사용
@Slf4j //로그
public class PostController {

    private final PostRepository postRepository;

    private final PostService postService;

    @GetMapping("/api/post")
    public List<Post> listPost(){
        return postRepository.findAll(Sort.by(Sort.Direction.DESC, "createdDate"));
    }

    @GetMapping("/api/post/{post-id}")
    public Post onePost(@PathVariable("post-id") Long id){
        return postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 글이 존재하지 않습니다.")
        );
    }

    @PostMapping("/api/post")
    public Post addPost(@Valid @RequestBody PostDto postDto) {
        Post post = new Post(postDto);
        return postRepository.save(post);
    }

    @PutMapping("/api/post/{post-id}")
    public Post putPost(@Valid @RequestBody PostDto postDto, @PathVariable("post-id") Long id){

        return postService.update(id, postDto);
    }

    @DeleteMapping("/api/post/{post-id}")
    public Long deletePost(@PathVariable("post-id") Long id){
        return postService.delete(id);
    }
}
