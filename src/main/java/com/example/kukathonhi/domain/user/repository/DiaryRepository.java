package com.example.kukathonhi.domain.user.repository;


import com.example.kukathonhi.domain.user.dto.res.DiaryResponseDto;
import com.example.kukathonhi.domain.user.dto.res.EmotionResponseDto;
import com.example.kukathonhi.domain.user.entity.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DiaryRepository extends JpaRepository<Diary, Long> {

    @Query("select new com.example.kukathonhi.domain.user.dto.res.DiaryResponseDto(d.diaryId, d.title, d.content, d.date, d.emotion) from diary d where d.user.userId = :userId")
    List<DiaryResponseDto> findAllByUserId(Long userId);

    @Query("select new com.example.kukathonhi.domain.user.dto.res.EmotionResponseDto(d.emotion, d.date) from diary d where d.user.userId = :userId")
    List<EmotionResponseDto> findEmotionByUserId(Long userId);
}
