package com.sparta.schedulemanagerproject.controller;

import com.sparta.schedulemanagerproject.dto.CommentResponseDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @PostMapping("/write/")
    public CommentResponseDto createComment() {
        return null;
    }
}
