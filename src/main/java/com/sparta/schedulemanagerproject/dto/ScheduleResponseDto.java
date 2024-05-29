package com.sparta.schedulemanagerproject.dto;


import com.sparta.schedulemanagerproject.entity.Schedule;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ScheduleResponseDto {

    private long id;
    private String title;
    private String contents;
    private String manager;
    private String password;
    private LocalDateTime createAt;

    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.contents = schedule.getContents();
        this.manager = schedule.getManager();
        this.password = schedule.getPassword();
        this.createAt = schedule.getCreatedAt();
    }
}
