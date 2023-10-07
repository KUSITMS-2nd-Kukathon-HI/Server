package com.example.kukathonhi.domain.like.dto.req;

import com.example.kukathonhi.domain.like.entity.Like;
import com.example.kukathonhi.domain.post.entity.Post;
import com.example.kukathonhi.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LikeRequestDto {
    private Long userId;
    private Long postId;

    public Like toEntity(User user, Post post) {
        return Like.builder()
                .post(post)
                .user(user)
                .build();
    }
}
