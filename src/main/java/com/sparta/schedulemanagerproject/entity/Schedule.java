package com.sparta.schedulemanagerproject.entity;

import com.sparta.schedulemanagerproject.dto.ScheduleRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;
    @Column(name = "contents")
    private String contents;
    @Column(name = "manager")
    private String manager;
    @Column(name = "password")
    private long password;
    @Column(name = "writeDate")
    private String writeDate;


    public Schedule(ScheduleRequestDto scheduleRequestDto) {
        this.contents = scheduleRequestDto.getContents();
        this.title = scheduleRequestDto.getTitle();
        this.manager = scheduleRequestDto.getManager();
        this.password = scheduleRequestDto.getPassword();
        this.writeDate = scheduleRequestDto.getWriteDate();
    }
}
