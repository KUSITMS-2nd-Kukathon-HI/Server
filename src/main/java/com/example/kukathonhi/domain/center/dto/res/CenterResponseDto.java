package com.example.kukathonhi.domain.center.dto.res;

import com.example.kukathonhi.domain.center.entity.Center;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CenterResponseDto {

    private String category;
    private String centerName;
    private String addressName;
    private String phoneNumber;

    public CenterResponseDto(String category, String centerName, String addressName, String phoneNumber) {
        this.category = category;
        this.centerName = centerName;
        this.addressName = addressName;
        this.phoneNumber = phoneNumber;
    }
}
