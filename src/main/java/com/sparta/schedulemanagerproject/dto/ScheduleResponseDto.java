package com.sparta.schedulemanagerproject.dto;


import com.sparta.schedulemanagerproject.entity.Schedule;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ScheduleResponseDto {

    private long id;

    private String title;
    private String contents;
    private String manager;
    private long password;
    private String writeDate;

    public ScheduleResponseDto(Schedule saveSchedule) {
        this.id = saveSchedule.getId();
        this.title = saveSchedule.getTitle();
        this.contents = saveSchedule.getContents();
        this.manager = saveSchedule.getManager();
        this.password = saveSchedule.getPassword();
        this.writeDate = saveSchedule.getWriteDate();
    }
}
