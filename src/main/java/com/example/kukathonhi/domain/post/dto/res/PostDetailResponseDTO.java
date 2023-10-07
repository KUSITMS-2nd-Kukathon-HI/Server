package com.example.kukathonhi.domain.post.dto.res;

import com.example.kukathonhi.domain.post.entity.Post;
import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDetailResponseDTO {

    private String title;

    public PostDetailResponseDTO(Post postEntity) {

    }
}
