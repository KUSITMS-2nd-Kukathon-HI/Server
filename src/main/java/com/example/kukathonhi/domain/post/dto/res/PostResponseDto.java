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
@AllArgsConstructor
@Builder
public class PostResponseDto {
    private List<PostResponseDataDto> popular=new ArrayList<>();
    private List<PostResponseDataDto> edu=new ArrayList<>();
    private List<PostResponseDataDto> support=new ArrayList<>();
    private List<PostResponseDataDto> protect=new ArrayList<>();
    private List<PostResponseDataDto> career=new ArrayList<>();
    private List<PostResponseDataDto> etc=new ArrayList<>();

    public void addDto(String category, PostResponseDataDto dto) {
        System.out.println("category2 : "+category);
        switch (category) {
            case "popular":
                popular.add(dto);
                break;
            case "edu":
                edu.add(dto);
                break;
            case "support":
                support.add(dto);
                break;
            case "protect":
                protect.add(dto);
                break;
            case "etc":
                etc.add(dto);
                break;
        }
    }
}
