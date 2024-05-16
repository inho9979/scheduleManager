package com.sparta.schedulemanagerproject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ScheduleRequestDto {

    private long id;

    private String title;
    private String contents;
    private String manager;
    private long password;
    private String writeDate;


    public ScheduleRequestDto(String title, String contents, String manager, long password, String writeDate) {
        this.title = title;
        this.contents = contents;
        this.manager = manager;
        this.password = password;
        this.writeDate = writeDate;
    }
}
