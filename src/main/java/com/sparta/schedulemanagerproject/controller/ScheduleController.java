package com.sparta.schedulemanagerproject.controller;

import com.sparta.schedulemanagerproject.dto.ScheduleRequestDto;
import com.sparta.schedulemanagerproject.dto.ScheduleResponseDto;
import com.sparta.schedulemanagerproject.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @GetMapping("/inquiry/id/{id}")
    public ScheduleResponseDto getSchedule(@PathVariable("id") long id){
        return scheduleService.getSchedule(id);
    }

    @GetMapping("/inquiry")
    public List<ScheduleResponseDto> getSchedules() {
        return scheduleService.getSchedules();
    }

    @PutMapping("/update/id/{id}")
    public ScheduleResponseDto updateSchedule(@PathVariable("id") long id, @RequestBody ScheduleRequestDto scheduleRequestDto) {
        return scheduleService.updateSchedule(id, scheduleRequestDto);
    }

    @DeleteMapping("/delete")
    public String deleteSchedule(@RequestParam long id, @RequestParam String password){
        return scheduleService.deleteSchedule(id, password);
    }
}

