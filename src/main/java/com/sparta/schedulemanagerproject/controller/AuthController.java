package com.sparta.schedulemanagerproject.controller;

import com.sparta.schedulemanagerproject.jwt.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {

    private final JwtUtil jwtUtil;

    @GetMapping("/jwt")
    public String createJwt(String username, HttpServletResponse res) {

        String token = jwtUtil.createToken(username);
        jwtUtil.addJwtToCookie(token, res);

        res.setStatus(201);
        return "successToken";
    }
}
