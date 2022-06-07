package com.geonoo.board.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class PostDto {

    public PostDto(String title, String name, String contents){
        this.title = title;
        this.name = name;
        this.contents = contents;
    }

    @NotEmpty(message = "제목을 입력해주세요")
    private String title;
    @NotBlank(message = "작성자 이름을 입력해주세요")
    @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-z-_]{1,100}$", message = "이름은 한글 또는 영어 1~100자리여야 합니다")
    private String name;
    @NotEmpty(message = "게시물 내용을 입력해주세요")
    private String contents;
    private Date createdDate;

}
