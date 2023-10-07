package com.example.kukathonhi.domain.user.entity;

import com.example.kukathonhi.common.BaseEntity;
import com.example.kukathonhi.common.Enum.Emotion;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity(name = "diary")
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Diary extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "diary_id", nullable = false)
    private Long diaryId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "emotion", nullable = false)
    private String emotion;

    @Column(name = "date", nullable = false)
    private String date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public static Diary createDiaryWithUser(String title, String content, String emotion, String date, User user){
        Diary diary = Diary.builder()
                .title(title)
                .content(content)
                .emotion(emotion)
                .date(date)
                .user(user)
                .build();
        user.addDiary(diary);
        return diary;
    }
}
