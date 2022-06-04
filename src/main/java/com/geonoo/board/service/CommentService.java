package com.geonoo.board.service;

import com.geonoo.board.domain.Comment;
import com.geonoo.board.dto.CommentDto;
import com.geonoo.board.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor // 생성자 주입
public class CommentService {
    private final CommentRepository commentRepository;

    @Transactional
    public Comment update(Long id, CommentDto commentDto){
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("댓글이 존재 하지 않습니다.")
        );
        comment.update(commentDto);
        return comment;
    }

    @Transactional
    public Long delete(Long id){
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("댓글이 존재 하지 않습니다.")
        );
        commentRepository.deleteById(id);
        return id;
    }

}
