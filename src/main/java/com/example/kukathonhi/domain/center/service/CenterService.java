package com.example.kukathonhi.domain.center.service;

import com.example.kukathonhi.domain.center.repository.CenterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CenterService {

    private final CenterRepository centerRepository;
}
