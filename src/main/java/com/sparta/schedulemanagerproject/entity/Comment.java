package com.sparta.schedulemanagerproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Comment extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String commnets;
    @Column
    private String username;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private  Schedule schedule;

}
