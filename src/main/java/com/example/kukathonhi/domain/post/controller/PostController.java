package com.example.kukathonhi.domain.post.controller;

import com.example.kukathonhi.domain.post.dto.res.PostResponseDto;
import com.example.kukathonhi.domain.post.service.PostService;
import com.example.kukathonhi.global.response.BaseResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping()
    public BaseResponseDto<PostResponseDto> postList(){
        PostResponseDto post = postService.getPost();

        return new BaseResponseDto<>(post);
    }

    @GetMapping("/{postId}")
    public BaseResponseDto<List<PostResponseDto>> postDetail(@PathVariable("postId") Long id){

        postService.getDetail(id);

        return null;
    }

}
