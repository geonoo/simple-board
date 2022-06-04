package com.geonoo.board.domain;

import com.geonoo.board.dto.CommentDto;
import com.geonoo.board.utility.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter @NoArgsConstructor @Entity
public class Comment extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private Long postId;

    public Comment(CommentDto commentDto){
        this.comment = commentDto.getComment();
        this.postId = commentDto.getPost_id();
    }

    public void update(CommentDto commentDto){
        this.comment = commentDto.getComment();
    }

}
