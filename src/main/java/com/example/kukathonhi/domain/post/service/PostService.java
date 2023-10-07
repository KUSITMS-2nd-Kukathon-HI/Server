package com.example.kukathonhi.domain.post.service;

import com.example.kukathonhi.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
}
