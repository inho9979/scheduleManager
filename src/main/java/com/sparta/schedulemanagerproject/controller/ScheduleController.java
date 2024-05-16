package com.sparta.schedulemanagerproject.controller;

import com.sparta.schedulemanagerproject.dto.ScheduleRequestDto;
import com.sparta.schedulemanagerproject.dto.ScheduleResponseDto;
import com.sparta.schedulemanagerproject.service.ScheduleService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class ScheduleController {

    private final ScheduleService scheduleService;
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }


    @PostMapping("/write")
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto scheduleRequestDto){

        return scheduleService.createSchedule(scheduleRequestDto);
    }
}
