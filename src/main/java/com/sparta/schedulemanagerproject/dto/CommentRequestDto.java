package com.sparta.schedulemanagerproject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentRequestDto {

    @Positive
    private long scheduleId;
    @NotBlank
    private String comments;
    private String username;
}
