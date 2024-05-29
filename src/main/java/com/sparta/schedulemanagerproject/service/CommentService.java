package com.sparta.schedulemanagerproject.service;

import com.sparta.schedulemanagerproject.dto.CommentRequestDto;
import com.sparta.schedulemanagerproject.dto.CommentResponseDto;
import com.sparta.schedulemanagerproject.entity.Comment;
import com.sparta.schedulemanagerproject.entity.Schedule;
import com.sparta.schedulemanagerproject.repository.CommentRepository;
import com.sparta.schedulemanagerproject.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;

    public CommentResponseDto createComment(CommentRequestDto requestDto) {
        Schedule schedule = scheduleRepository.findById(requestDto.getScheduleId()).orElseThrow(() ->
                new IllegalArgumentException("해당하는 일정이 존재하지 않습니다")
        );

        Comment comment = new Comment(requestDto, schedule);
        commentRepository.save(comment);

        return new CommentResponseDto(comment);
    }
}
