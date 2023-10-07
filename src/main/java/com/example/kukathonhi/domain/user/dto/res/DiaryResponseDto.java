package com.example.kukathonhi.domain.user.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DiaryResponseDto {

    private Long diaryId;
    private String title;
    private String content;
    private String date;
    private String emotion;
}
