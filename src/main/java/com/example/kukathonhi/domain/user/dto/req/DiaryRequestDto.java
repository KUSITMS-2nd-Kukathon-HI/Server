package com.example.kukathonhi.domain.user.dto.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DiaryRequestDto {

    private Long userId;
    private String title;
    private String content;
    private String emotion;
    private String date;
}
