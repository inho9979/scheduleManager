package com.sparta.schedulemanagerproject.entity;

import com.sparta.schedulemanagerproject.dto.ScheduleRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Schedule extends Timestamped {

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
    private String password;

//    @OneToMany(mappedBy = "schedule")
//    private List<Comment> commentList = new ArrayList<>();

    public Schedule(ScheduleRequestDto scheduleRequestDto) {
        this.contents = scheduleRequestDto.getContents();
        this.title = scheduleRequestDto.getTitle();
        this.manager = scheduleRequestDto.getManager();
        this.password = scheduleRequestDto.getPassword();
    }

    public void update(ScheduleRequestDto scheduleRequestDto)
    {
        this.title = scheduleRequestDto.getTitle();
        this.contents = scheduleRequestDto.getContents();
        this.manager = scheduleRequestDto.getManager();
    }
}
