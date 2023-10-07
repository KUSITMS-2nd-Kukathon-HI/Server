package com.example.kukathonhi.domain.like.service;

import com.example.kukathonhi.domain.like.dto.req.LikeRequestDto;
import com.example.kukathonhi.domain.like.entity.Like;
import com.example.kukathonhi.domain.like.repository.LikeRepository;
import com.example.kukathonhi.domain.post.entity.Post;
import com.example.kukathonhi.domain.post.repository.PostRepository;
import com.example.kukathonhi.domain.user.entity.User;
import com.example.kukathonhi.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public void clickLike(LikeRequestDto likeRequestDto) {
        Long userId = likeRequestDto.getUserId();
        Long postId = likeRequestDto.getPostId();

        User user = userRepository.findById(userId).orElseThrow();
        Post post = postRepository.findById(postId).orElseThrow();

        Like like = likeRequestDto.toEntity(user, post);

        if(likeRepository.existsById(userId)){//이미 좋아요가 눌러져 있으면
            likeRepository.delete(like);//좋아요 삭제
        }else{
            likeRepository.save(like);//좋아요 저장
        }

    }
}
