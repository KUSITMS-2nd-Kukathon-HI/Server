package com.example.kukathonhi.domain.center.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Getter
public class CenterListResponseDto {

    private List<CenterResponseDto> welfare;
    private List<CenterResponseDto> outside;
    private List<CenterResponseDto> shelter;
    private List<CenterResponseDto> support;
    private List<CenterResponseDto> protection;
}
