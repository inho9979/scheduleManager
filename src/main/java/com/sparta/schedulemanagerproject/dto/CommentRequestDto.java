package com.sparta.schedulemanagerproject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentRequestDto {

    private long scheduleId;
    private String commnets;
    private String username;
}
