package com.geonoo.board.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Getter
@Setter
public class CommentDto {

    @NotBlank(message = "댓글 내용을 입력해주세요")
    private String comment;

    //@NotBlank는 String 타입 어노테이션이므로 NotNull을 해주어야 함
    @NotNull
    private Long post_id;

}
