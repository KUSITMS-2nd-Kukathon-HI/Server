package com.example.kukathonhi.domain.center.repository;

import com.example.kukathonhi.domain.center.entity.Center;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CenterRepository extends JpaRepository<Center, Long> {
}
