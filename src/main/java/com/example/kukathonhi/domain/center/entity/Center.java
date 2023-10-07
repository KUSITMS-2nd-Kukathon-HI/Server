package com.example.kukathonhi.domain.center.entity;

import com.example.kukathonhi.common.Enum.CenterCategory;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity(name = "center")
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Center {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "center_id", nullable = false)
    private Long centerId;

    @Column(name = "center_name", nullable = false)
    private String centerName;

    @Column(name = "address_name", nullable = false)
    private String addressName;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "category", nullable = false)
    private String category;
}
