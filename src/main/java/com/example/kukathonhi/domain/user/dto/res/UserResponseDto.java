package com.example.kukathonhi.domain.user.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class UserResponseDto {

    private String loginId;
    private String name;
    private String birth;
}
