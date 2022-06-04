package com.geonoo.board.service;


import com.geonoo.board.domain.Post;
import com.geonoo.board.dto.PostDto;
import com.geonoo.board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor // 생성자 주입
@Service // 스프링에게 이 클래스는 서비스임을 명시
public class PostService {

    // final: 서비스에게 꼭 필요한 녀석임을 명시
    private final PostRepository postRepository;

    // 생성자를 통해, Service 클래스를 만들 때 꼭 Repository를 넣어주도록
    // 스프링에게 알려줌
//    public PostService(PostRepository postRepository) {
//        this.postRepository = postRepository;
//    }

    @Transactional // SQL 쿼리가 일어나야 함을 스프링에게 알려줌
    public Post update(Long id, PostDto postDto) {
        Post postOne = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 글이 존재하지 않습니다.")
        );
        postOne.update(postDto);
        return postOne;
    }

    @Transactional
    public Long delete(Long id){
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("글이 존재 하지 않습니다.")
        );
        postRepository.deleteById(id);
        return id;
    }
}
