package com.sparta.schedulemanagerproject.service;

import com.sparta.schedulemanagerproject.dto.CommentRequestDto;
import com.sparta.schedulemanagerproject.dto.CommentResponseDto;
import com.sparta.schedulemanagerproject.entity.Comment;
import com.sparta.schedulemanagerproject.entity.Schedule;
import com.sparta.schedulemanagerproject.repository.CommentRepository;
import com.sparta.schedulemanagerproject.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


    @Transactional
    public CommentResponseDto updateComment(long commentId, CommentRequestDto requestDto) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() ->
                new IllegalArgumentException("ID에 해당하는 댓글이 없습니다"));

        if(!comment.getUsername().equals(requestDto.getUsername())) {
            throw new IllegalArgumentException("사용자가 일치하지 않습니다");
        }

        Schedule schedule = scheduleRepository.findById(requestDto.getScheduleId()).orElseThrow(() ->
                new IllegalArgumentException("해당하는 일정이 없습니다"));

        if(comment.getSchedule().getId() != schedule.getId()){
            throw new IllegalArgumentException("선택한 일정과 다른 댓글입니다");
        }

        comment.updateComment(requestDto);
        return new CommentResponseDto(comment);
    }
}
