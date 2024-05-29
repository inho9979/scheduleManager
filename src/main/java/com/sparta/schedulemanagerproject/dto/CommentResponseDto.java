package com.sparta.schedulemanagerproject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CommentResponseDto {

    private long id;
    private int scheduleId;
    private String commnets;
    private String username;
    private LocalDateTime time;
}
