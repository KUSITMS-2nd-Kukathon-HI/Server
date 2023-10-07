package com.example.kukathonhi.domain.like.repository;

import com.example.kukathonhi.domain.like.entity.Like;
import com.example.kukathonhi.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
}
