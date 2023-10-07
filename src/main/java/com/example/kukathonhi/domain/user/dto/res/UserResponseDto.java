package com.example.kukathonhi.domain.user.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class UserResponseDto {

    private Long userId;
    private String username;
}
