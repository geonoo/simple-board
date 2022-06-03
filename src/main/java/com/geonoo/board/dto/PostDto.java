package com.geonoo.board.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
public class PostDto {

    public PostDto(String title, String name, String contents){
        this.title = title;
        this.name = name;
        this.contents = contents;
    }

    private String title;
    private String name;
    private String contents;
    private Date createdDate;

}
