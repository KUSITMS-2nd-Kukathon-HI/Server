package com.example.kukathonhi.domain.center.service;

import com.example.kukathonhi.common.Enum.CenterCategory;
import com.example.kukathonhi.domain.center.entity.Center;
import com.example.kukathonhi.domain.center.repository.CenterRepository;
import com.example.kukathonhi.global.response.BaseResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class CenterService {

    private final CenterRepository centerRepository;

    public BaseResponseDto<?> getCenterList() {
        return new BaseResponseDto<>(centerRepository.findAll());
    }

    public void insertEn(JSONArray data, CenterCategory category) {
        for (Object o : data) {
            JSONObject jsonObject = (JSONObject) o;

            System.out.println("===== " + o + "=====");
            System.out.println("centerName : " + jsonObject.get("name:"));
            System.out.println("centerAddress : " + jsonObject.get("tel"));
            System.out.println("centerPhone : " + jsonObject.get("addr"));

            if (jsonObject.get("addr") == null || jsonObject.get("tel") == null) {
                continue;
            }

            Center newCenter = Center.builder()
                    .centerName(jsonObject.get("name:").toString())
                    .addressName(jsonObject.get("addr").toString())
                    .phoneNumber(jsonObject.get("tel").toString())
                    .category(category.name())
                    .build();

            centerRepository.save(newCenter);
        }
    }
    public void insert(JSONArray data, CenterCategory category) {
        for (Object o : data) {
            JSONObject jsonObject = (JSONObject) o;

            System.out.println("===== " + o + "=====");
            System.out.println("centerName : " + jsonObject.get("이름"));
            System.out.println("centerAddress : " + jsonObject.get("전화번호"));
            System.out.println("centerPhone : " + jsonObject.get("주소"));

            if (jsonObject.get("주소") == null || jsonObject.get("전화번호") == null) {
                continue;
            }

            Center newCenter = Center.builder()
                    .centerName(jsonObject.get("이름").toString())
                    .addressName(jsonObject.get("주소").toString())
                    .phoneNumber(jsonObject.get("전화번호").toString())
                    .category(category.name())
                    .build();

            centerRepository.save(newCenter);
        }
    }
}
