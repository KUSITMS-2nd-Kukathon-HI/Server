package com.example.kukathonhi.domain.like.controller;

import com.example.kukathonhi.domain.like.dto.req.LikeRequestDto;
import com.example.kukathonhi.domain.like.service.LikeService;
import com.example.kukathonhi.domain.user.dto.req.RegisterRequestDto;
import com.example.kukathonhi.global.response.BaseResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/like")
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;
    @PostMapping
    public BaseResponseDto<?> like(
            @RequestBody LikeRequestDto likeRequestDto
    ) {
        likeService.clickLike(likeRequestDto);
        return null;
    }
}
