package com.example.kukathonhi.domain.post.entity;

import com.example.kukathonhi.common.BaseEntity;
import com.example.kukathonhi.domain.like.entity.Like;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "post")
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "post_id", nullable = false)
    private Long postId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "image", nullable = false)
    private URL image;

    @Column(name = "view_count", nullable = false)
    private int viewCount;

    @Column(name = "category", nullable = false)
    private String category;

    @OneToMany(mappedBy = "post")
    @Builder.Default
    private List<Like> like=new ArrayList<>();
}
