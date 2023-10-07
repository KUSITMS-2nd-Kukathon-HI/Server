package com.example.kukathonhi.domain.post.dto.res;

import com.example.kukathonhi.domain.post.entity.Post;

import java.net.URL;

public class PostResponseDataDto {
    private String title;
    private URL image;
    private Long postId;

    public PostResponseDataDto(Post post) {
        this.title=post.getTitle();
        this.image=post.getImage();
        this.postId=post.getPostId();
    }
}
