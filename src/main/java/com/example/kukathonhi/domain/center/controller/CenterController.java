package com.example.kukathonhi.domain.center.controller;

import com.example.kukathonhi.domain.center.entity.Center;
import com.example.kukathonhi.domain.center.repository.CenterRepository;
import com.example.kukathonhi.domain.center.service.CenterService;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

@RestController
@RequestMapping("/api/center")
@RequiredArgsConstructor
public class CenterController {

    private final CenterService centerService;
    private final CenterRepository centerRepository;

    @PostMapping("/insert")
    public void insert() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        // JSON 파일 읽기
        Reader reader = new FileReader("src/main/resources/data_2.json");
        JSONArray dateArray = (JSONArray) parser.parse(reader);

        for (Object o : dateArray) {

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
                    .build();

            centerRepository.save(newCenter);
        }

    }

}
