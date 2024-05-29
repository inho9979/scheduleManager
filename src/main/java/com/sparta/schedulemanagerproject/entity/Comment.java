package com.sparta.schedulemanagerproject.entity;

import com.sparta.schedulemanagerproject.dto.CommentRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Comment extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String comments;
    @Column
    private String username;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private  Schedule schedule;

    public Comment(CommentRequestDto requestDto, Schedule schedule) {
        this.comments = requestDto.getComments();
        this.username = requestDto.getUsername();

        this.schedule = schedule;
    }

    public void updateComment(CommentRequestDto requestDto) {
        this.comments = requestDto.getComments();
    }
}
