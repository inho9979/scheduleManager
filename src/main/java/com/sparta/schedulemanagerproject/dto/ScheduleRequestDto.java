package com.sparta.schedulemanagerproject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ScheduleRequestDto {

    private String title;
    private String contents;
    private String manager;
    private String password;
}
