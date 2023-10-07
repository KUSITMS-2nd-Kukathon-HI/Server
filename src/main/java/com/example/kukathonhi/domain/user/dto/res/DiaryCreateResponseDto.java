package com.example.kukathonhi.domain.user.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Getter
public class DiaryCreateResponseDto {

    private boolean isSuccess;
    private String message;
    private Long diaryId;
}
