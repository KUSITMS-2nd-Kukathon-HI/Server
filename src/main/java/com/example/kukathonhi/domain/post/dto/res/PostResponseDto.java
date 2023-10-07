package com.example.kukathonhi.domain.post.dto.res;

import com.example.kukathonhi.domain.post.entity.Post;
import lombok.*;

import java.net.URL;
import java.util.List;
import java.util.stream.Stream;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostResponseDto {
    private List<PostResponseDataDto> popular;
    private List<PostResponseDataDto> edu;
    private List<PostResponseDataDto> support;
    private List<PostResponseDataDto> protect;
    private List<PostResponseDataDto> career;
    private List<PostResponseDataDto> etc;

    public PostResponseDto(String category,PostResponseDataDto dto) {

        switch (category){
            case "popular" : popular.add(dto);
            case "edu" : edu.add(dto);
            case "support" : support.add(dto);
            case "protect" : protect.add(dto);
            case "etc" : etc.add(dto);
        }
    }
}
