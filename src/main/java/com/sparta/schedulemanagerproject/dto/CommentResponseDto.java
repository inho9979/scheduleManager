package com.sparta.schedulemanagerproject.dto;

import com.sparta.schedulemanagerproject.entity.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CommentResponseDto {

    private long id;
    private long scheduleId;
    private String comments;
    private String username;
    private LocalDateTime time;

    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.scheduleId = comment.getSchedule().getId();
        this.comments = comment.getComments();
        this.username = comment.getUsername();
        this.time = comment.getCreatedAt();
    }
}
