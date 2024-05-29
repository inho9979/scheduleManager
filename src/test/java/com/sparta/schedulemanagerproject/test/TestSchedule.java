package com.sparta.schedulemanagerproject.test;

import com.sparta.schedulemanagerproject.entity.Schedule;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class TestSchedule {

    @PersistenceContext
    EntityManager em;

    @Test
    @Transactional
    @Rollback(value = false)
    @DisplayName("생성 성공")
    void test1() {
        Schedule schedule = new Schedule();
//        schedule.setContents("생성 테스트");
//        schedule.setTitle("제목");
//        schedule.setManager("매니저");
        //schedule.setPassword(12345);

        em.persist(schedule);
    }
}
