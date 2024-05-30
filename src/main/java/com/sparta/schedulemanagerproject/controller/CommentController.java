package com.sparta.schedulemanagerproject.controller;

import com.sparta.schedulemanagerproject.dto.CommentRequestDto;
import com.sparta.schedulemanagerproject.dto.CommentResponseDto;
import com.sparta.schedulemanagerproject.jwt.JwtUtil;
import com.sparta.schedulemanagerproject.service.CommentService;
import io.jsonwebtoken.Claims;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private final JwtUtil jwtUtil;

    @PostMapping("/write")
    public CommentResponseDto createComment(@RequestBody @Valid CommentRequestDto requestDto, BindingResult bindingResult
    ,@CookieValue(JwtUtil.AUTHORIZATION_HEADER) String tokenValue) {

        checkError(bindingResult);
        if(!requestDto.getUsername().equals(getJwt(tokenValue))) {
            throw new IllegalArgumentException("잘못된 username");
        }
        return commentService.createComment(requestDto);
    }

    @PutMapping("/update")
    public CommentResponseDto updateComment(long commentId, @RequestBody @Valid CommentRequestDto requestDto, BindingResult bindingResult
            ,@CookieValue(JwtUtil.AUTHORIZATION_HEADER) String tokenValue)
    {
        if(commentId < 1) {
            throw new IllegalArgumentException();
        }
        checkError(bindingResult);

        if(!requestDto.getUsername().equals(getJwt(tokenValue))) {
            throw new IllegalArgumentException("잘못된 username");
        }

        return commentService.updateComment(commentId, requestDto);
    }

    @DeleteMapping
    public String deleteComment(long commentId, @RequestBody CommentRequestDto requestDto
    ,@CookieValue(JwtUtil.AUTHORIZATION_HEADER) String tokenValue) {

        commentService.deleteComment(commentId, requestDto);

        if(!requestDto.getUsername().equals(getJwt(tokenValue))) {
            throw new IllegalArgumentException("잘못된 username");
        }

        ResponseEntity.status(201);
        return "성공했습니다";
    }


    private void checkError(BindingResult bindingResult) {
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        if(fieldErrors.size() > 0) {
            for(FieldError fieldError : bindingResult.getFieldErrors()) {
                log.error(fieldError.getField() + " 필드 : " + fieldError.getDefaultMessage());
            }
            throw new IllegalArgumentException();
        }
    }

    public String getJwt(String tokenValue) {
        String token = jwtUtil.substringToken(tokenValue);

        if(!jwtUtil.validateToken(token)) {
            throw new IllegalArgumentException("Token Error");
        }

        Claims info = jwtUtil.getUserInfoFromToken(token);
        String username = info.getSubject();

        return username;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleNoSuchElementFoundException(IllegalArgumentException exception) {
        return ResponseEntity.status(400).body(exception.getMessage());
    }

}
