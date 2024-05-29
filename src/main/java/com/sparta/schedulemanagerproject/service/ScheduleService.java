package com.sparta.schedulemanagerproject.service;


import com.sparta.schedulemanagerproject.dto.ScheduleRequestDto;
import com.sparta.schedulemanagerproject.dto.ScheduleResponseDto;
import com.sparta.schedulemanagerproject.entity.Schedule;
import com.sparta.schedulemanagerproject.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

        //scheduleRepository.findAll().stream().map(ScheduleResponseDto::new).sorted(Comparator.comparing(ScheduleResponseDto::getCreateAt).reversed()).toList();
        return scheduleRepository.findAllByOrderByCreatedAtDesc().stream().map(ScheduleResponseDto::new).toList();
    }

    @Transactional
    public ScheduleResponseDto updateSchedule(long schedule_id, ScheduleRequestDto scheduleRequestDto) {
        Schedule schedule =  findSchedule(schedule_id);
        if(!schedule.getPassword().equals(scheduleRequestDto.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 틀립니다");
        }

        schedule.update(scheduleRequestDto);


        return new ScheduleResponseDto(schedule);
    }

    public String deleteSchedule(long id, String password) {
        Schedule schedule = findSchedule(id);
        if(!schedule.getPassword().equals(password)){
            return "비밀번호가 틀립니다";
        }
        scheduleRepository.delete(schedule);
        return "삭제가 완료됐습니다";
    }



    public Schedule findSchedule(long id) {
        return scheduleRepository.findById(id).orElseThrow( () ->
                new IllegalArgumentException("찾을 수 없습니다")
        );
    }
}
