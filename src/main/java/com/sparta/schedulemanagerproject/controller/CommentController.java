package com.sparta.schedulemanagerproject.controller;

import com.sparta.schedulemanagerproject.dto.CommentRequestDto;
import com.sparta.schedulemanagerproject.dto.CommentResponseDto;
import com.sparta.schedulemanagerproject.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/write")
    public CommentResponseDto createComment(@RequestBody @Valid CommentRequestDto requestDto, BindingResult bindingResult) {

        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        if(fieldErrors.size() > 0) {
            for(FieldError fieldError : bindingResult.getFieldErrors()) {
                log.error(fieldError.getField() + " 필드 : " + fieldError.getDefaultMessage());
            }
            throw new IllegalArgumentException();
        }
        return commentService.createComment(requestDto);
    }
}
