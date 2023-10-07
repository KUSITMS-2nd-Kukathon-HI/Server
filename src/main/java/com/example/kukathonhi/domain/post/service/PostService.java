package com.example.kukathonhi.domain.post.service;

import com.example.kukathonhi.domain.post.dto.res.PostDetailResponseDTO;
import com.example.kukathonhi.domain.post.dto.res.PostResponseDataDto;
import com.example.kukathonhi.domain.post.dto.res.PostResponseDto;
import com.example.kukathonhi.domain.post.entity.Post;
import com.example.kukathonhi.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public PostResponseDto getPost() {
        List<Post> postList = postRepository.findAll();

        String category;
        PostResponseDataDto dto;
        PostResponseDto postResponseDto=new PostResponseDto();

        for (int i = 0; i < postList.size(); i++) {
            category = postList.get(i).getCategory();
            dto=new PostResponseDataDto(postList.get(i));

            postResponseDto.addDto(category,dto);
        }
        return postResponseDto;
    }

    public PostDetailResponseDTO getDetail(Long id) {

        Post postEntity = getPost(id);
        return new PostDetailResponseDTO(postEntity);
    }

    private Post getPost(Long id) {
        return postRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException(
                                id + "번 게시물이 존재하지 않습니다!"
                        )
                );
    }
}
