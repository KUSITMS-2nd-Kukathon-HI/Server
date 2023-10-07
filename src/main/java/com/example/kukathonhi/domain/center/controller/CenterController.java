package com.example.kukathonhi.domain.center.controller;

import com.example.kukathonhi.common.Enum.CenterCategory;
import com.example.kukathonhi.domain.center.entity.Center;
import com.example.kukathonhi.domain.center.repository.CenterRepository;
import com.example.kukathonhi.domain.center.service.CenterService;
import com.example.kukathonhi.global.response.BaseResponseDto;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("")
    public BaseResponseDto<?> getCenterList() {
        return centerService.getCenterList();
    }

    @PostMapping("/insert")
    public void insert() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        // JSON 파일 읽기

        Reader reader = new FileReader("src/main/resources/data_1.json");
        JSONArray dateArray = (JSONArray) parser.parse(reader);
        centerService.insertEn(dateArray, CenterCategory.WELFARE);

        reader = new FileReader("src/main/resources/data_2.json");
        dateArray = (JSONArray) parser.parse(reader);
        centerService.insertEn(dateArray, CenterCategory.OUTSIDE);

        reader = new FileReader("src/main/resources/1.json");
        dateArray = (JSONArray) parser.parse(reader);
        centerService.insert(dateArray, CenterCategory.PROTECTION);

        reader = new FileReader("src/main/resources/2.json");
        dateArray = (JSONArray) parser.parse(reader);
        centerService.insert(dateArray, CenterCategory.SHELTER);

        reader = new FileReader("src/main/resources/3.json");
        dateArray = (JSONArray) parser.parse(reader);
        centerService.insert(dateArray, CenterCategory.SUPPORT);
    }

}
