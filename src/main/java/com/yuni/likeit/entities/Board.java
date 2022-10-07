package com.yuni.likeit.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "BOARD")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Board {
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "content", columnDefinition = "TEXT")
    private String content;
    @Column(name = "writer")
    private String writer;
    @Column(name = "create_date")
    private Date createDate;
    @Column(name = "watch_count")
    private long watchCount;

    @Builder
    public Board(long id, String title, String content, String writer, Date createDate, long watchCount) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.createDate = createDate;
        this.watchCount = watchCount;
    }
}
