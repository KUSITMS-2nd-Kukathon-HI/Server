package com.example.kukathonhi.domain.user.dto.res;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class UserLoginResponseDto {

    private boolean isSuccess;
    private String message;
    private Long userId;
}
