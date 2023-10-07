package com.example.kukathonhi.domain.post.dto.res;

import com.example.kukathonhi.domain.post.entity.Post;
import lombok.*;

import java.net.URL;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostResponseDataDto {
    private String title;
    private String image;
    private Long postId;

    public PostResponseDataDto(Post post) {
        this.title=post.getTitle();
        this.image= String.valueOf(post.getImage());
        this.postId=post.getPostId();
    }
    public PostResponseDataDto(String image) {
        this.image=image;
    }
}
