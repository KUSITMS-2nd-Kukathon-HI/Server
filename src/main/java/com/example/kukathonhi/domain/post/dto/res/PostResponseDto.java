package com.example.kukathonhi.domain.post.dto.res;

import com.example.kukathonhi.domain.post.entity.Post;
import lombok.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Builder
public class PostResponseDto {
    private List<PostResponseDataDto> popular=new ArrayList<>();
    private List<PostResponseDataDto> edu=new ArrayList<>();
    private List<PostResponseDataDto> support=new ArrayList<>();
    private List<PostResponseDataDto> protect=new ArrayList<>();
    private List<PostResponseDataDto> career=new ArrayList<>();
    private List<PostResponseDataDto> etc=new ArrayList<>();

    public PostResponseDto(List<PostResponseDataDto> popular ,List<PostResponseDataDto> edu,
        List<PostResponseDataDto> support ,List<PostResponseDataDto> protect,
        List<PostResponseDataDto> career, List<PostResponseDataDto> etc){
            this.popular = popular;
            this.edu = edu;
            this.support = support;
            this.protect = protect;
            this.career = career;
            this.etc = etc;
    }

}
