package com.sparta.schedulemanagerproject.service;


import com.sparta.schedulemanagerproject.dto.ScheduleRequestDto;
import com.sparta.schedulemanagerproject.dto.ScheduleResponseDto;
import com.sparta.schedulemanagerproject.entity.Schedule;
import com.sparta.schedulemanagerproject.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public ScheduleResponseDto createSchedule(ScheduleRequestDto scheduleRequestDto){
        Schedule schedule = new Schedule(scheduleRequestDto);

        Schedule saveSchedule = scheduleRepository.save(schedule);

        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(saveSchedule);

        return scheduleResponseDto;
    }

    public ScheduleResponseDto getSchedule(long id) {

        Schedule schedule = findSchedule(id);
        return new ScheduleResponseDto(schedule);
    }

    public List<ScheduleResponseDto> getSchedules(){
        return scheduleRepository.findAll().stream().map(ScheduleResponseDto::new).sorted(Comparator.comparing(ScheduleResponseDto::getCreateAt).reversed()).toList();
    }

    @Transactional
    public ScheduleResponseDto updateSchedule(long id, ScheduleRequestDto scheduleRequestDto) {
        Schedule schedule =  findSchedule(id);
        if(schedule.getPassword() != scheduleRequestDto.getPassword()) {
            throw new IllegalArgumentException("비밀번호가 틀립니다");
        }

        schedule.update(scheduleRequestDto);


        return new ScheduleResponseDto(schedule);
    }

    public String deleteSchedule(long id, long password) {
        Schedule schedule = findSchedule(id);
        if(schedule.getPassword() != password){
            return "비밀번호가 틀립니다";
        }
        scheduleRepository.delete(schedule);
        return "삭제가 완료됐습니다";
    }



    public Schedule findSchedule(long id) {
        return scheduleRepository.findById(id).orElseThrow( () ->
                new IllegalArgumentException("일정이 존재하지 않습니다")
        );
    }
}
