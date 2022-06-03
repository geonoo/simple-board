package com.geonoo.board.controller;

import com.geonoo.board.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentController {
    final CommentRepository commentRepository;


}
