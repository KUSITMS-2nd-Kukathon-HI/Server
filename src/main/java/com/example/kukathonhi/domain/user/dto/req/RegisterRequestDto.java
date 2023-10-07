package com.example.kukathonhi.domain.user.dto.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDto {

    private String loginId;
    private String password;
    private String name;
    private String birth;
}
