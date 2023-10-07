package com.example.kukathonhi.domain.user.controller;

import com.example.kukathonhi.domain.user.dto.req.DiaryRequestDto;
import com.example.kukathonhi.domain.user.dto.req.RegisterRequestDto;
import com.example.kukathonhi.domain.user.service.UserService;
import com.example.kukathonhi.global.response.BaseResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("")
    public BaseResponseDto<?> register(
            @RequestBody RegisterRequestDto requestDto
            ) {
        return userService.join(requestDto);
    }

    @GetMapping("/login")
    public BaseResponseDto<?> login(
            @RequestParam String id,
            @RequestParam String password
    ) {
        return userService.login(id, password);
    }

    @GetMapping("/{userId}")
    public BaseResponseDto<?> getUserInfo(
            @PathVariable Long userId
    ) {
        return userService.getUserInfo(userId);
    }

    @PostMapping("/diary")
    public BaseResponseDto<?> createDiary(
            @RequestBody DiaryRequestDto requestDto
    ) {
        return userService.createDiary(requestDto);
    }

    @GetMapping("/diary/{userId}")
    public BaseResponseDto<?> getDiaryList(
            @PathVariable Long userId
    ) {
        return userService.getDiaryList(userId);
    }

    @GetMapping("/diary")
    public BaseResponseDto<?> getEmotion(
            @RequestParam Long userId, @RequestParam String month
    ) {
        return userService.getEmotionList(userId, month);
    }
}
