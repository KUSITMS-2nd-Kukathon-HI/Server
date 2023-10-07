package com.example.kukathonhi.domain.center.repository;

import com.example.kukathonhi.domain.center.dto.res.CenterResponseDto;
import com.example.kukathonhi.domain.center.entity.Center;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CenterRepository extends JpaRepository<Center, Long> {

}
