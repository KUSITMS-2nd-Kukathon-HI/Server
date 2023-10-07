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
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public PostResponseDto getPost() {
        List<Post> popularList = postRepository.findTop4ByOrderByViewCountDesc();
        List<Post> eduList = postRepository.findByCategoryContaining("edu");
        List<Post> supportList = postRepository.findByCategoryContaining("support");
        List<Post> protectList = postRepository.findByCategoryContaining("protect");
        List<Post> careerList = postRepository.findByCategoryContaining("career");
        List<Post> etcList = postRepository.findByCategoryContaining("etc");

        List<PostResponseDataDto> popularListDto = popularList.stream()
                .map(popular -> new PostResponseDataDto(popular))
                .collect(Collectors.toList());

        List<PostResponseDataDto> eduListDto = eduList.stream()
                .map(edu -> new PostResponseDataDto(edu))
                .collect(Collectors.toList());

        List<PostResponseDataDto> supportListDto = supportList.stream()
                .map(support -> new PostResponseDataDto(support))
                .collect(Collectors.toList());

        List<PostResponseDataDto> protectListDto = protectList.stream()
                .map(protect -> new PostResponseDataDto(protect))
                .collect(Collectors.toList());

        List<PostResponseDataDto> careerListDto = careerList.stream()
                .map(career -> new PostResponseDataDto(career))
                .collect(Collectors.toList());

        List<PostResponseDataDto> etcListDto = etcList.stream()
                .map(etc -> new PostResponseDataDto(etc))
                .collect(Collectors.toList());

        return new PostResponseDto(popularListDto,eduListDto,supportListDto,protectListDto,careerListDto,etcListDto);
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
