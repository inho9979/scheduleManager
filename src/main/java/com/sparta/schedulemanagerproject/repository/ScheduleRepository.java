package com.sparta.schedulemanagerproject.repository;

import com.sparta.schedulemanagerproject.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
