package com.geonoo.board.controller;

import com.geonoo.board.domain.Comment;
import com.geonoo.board.dto.CommentDto;
import com.geonoo.board.repository.CommentRepository;
import com.geonoo.board.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentController {
  
    final CommentRepository commentRepository;
  
    final CommentService commentService;

    @GetMapping("/api/comment/{id}")
    public List<Comment> listComment(@PathVariable Long id){
        System.out.println(id);
        return commentRepository.findAllByPostId(id);
    }

    @PostMapping("/api/comment")
    public Comment saveComment(@Valid @RequestBody CommentDto commentDto){
        Comment comment = new Comment(commentDto);
        return commentRepository.save(comment);
    }

    @PutMapping("/api/comment/{id}")
    public Comment updateComment(@Valid @RequestBody CommentDto commentDto, @PathVariable Long id){
        return commentService.update(id, commentDto);
    }

    @DeleteMapping("/api/comment/{id}")
    public Long deleteComment(@PathVariable Long id){

        return commentService.delete(id);
    }
}
