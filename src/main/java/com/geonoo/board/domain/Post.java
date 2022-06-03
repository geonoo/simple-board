package com.geonoo.board.domain;


import com.geonoo.board.dto.PostDto;
import com.geonoo.board.utility.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity // 기본 테이블임을 나타낸다.
@NoArgsConstructor // 기본 생성자를 대신 생성 해준다.
public class Post extends BaseTimeEntity {

    public Post(String title, String name, String contents){
        this.title = title;
        this.name = name;
        this.contents = contents;
    }

    public Post(PostDto postDto){
        this.title = postDto.getTitle();
        this.name = postDto.getName();
        this.contents = postDto.getContents();
    }

    //먼저 기본키가 id이고, DB가 id값을 자동으로 생성해주는데 이것을 IDENTITY 전략 이라고 한다.
    //@GeneratedValue(strategy = GenerationType.AUTO) // 자동 증가 AUTO_INCREMENT
    //@GenerationType.IDENTITY id는 해당 특정 열에 대해서만 고유합니다.
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) //Null 이면 안됌
    private String title;

    private String name;

    private String contents;

    public void update(PostDto postDto) {
        this.title = postDto.getTitle();
        this.name = postDto.getName();
        this.contents = postDto.getContents();
    }
}
