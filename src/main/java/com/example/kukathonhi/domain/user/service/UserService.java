package com.example.kukathonhi.domain.user.service;

import com.example.kukathonhi.domain.user.dto.req.DiaryRequestDto;
import com.example.kukathonhi.domain.user.dto.req.RegisterRequestDto;
import com.example.kukathonhi.domain.user.dto.res.DiaryCreateResponseDto;
import com.example.kukathonhi.domain.user.dto.res.EmotionResponseDto;
import com.example.kukathonhi.domain.user.dto.res.UserLoginResponseDto;
import com.example.kukathonhi.domain.user.dto.res.UserResponseDto;
import com.example.kukathonhi.domain.user.entity.Diary;
import com.example.kukathonhi.domain.user.entity.User;
import com.example.kukathonhi.domain.user.repository.DiaryRepository;
import com.example.kukathonhi.domain.user.repository.UserRepository;
import com.example.kukathonhi.global.response.BaseResponseDto;
import com.example.kukathonhi.global.response.ErrorMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final DiaryRepository diaryRepository;

    public Optional<User> getUser(String id) {

        return userRepository.findUserByLoginId(id);
    }

    public BaseResponseDto<?> login(String id, String password) {
        Optional<User> userOptional = getUser(id);

        if (userOptional.isEmpty()) {
            log.error("User not found");
            return new BaseResponseDto<>(UserLoginResponseDto.of(false, "존재하지 않는 아이디입니다.", null));
        }

        User user = userOptional.get();

        if (!password.equals(user.getPassword())) {
            log.error("Password not matched");
            return new BaseResponseDto<>(UserLoginResponseDto.of(false, "비밀번호가 일치하지 않습니다.", null));
        }

        return new BaseResponseDto<>(UserLoginResponseDto.of(true, "로그인 성공", user.getUserId()));
    }

    public BaseResponseDto<?> join(RegisterRequestDto form) {
        User newUser = User.builder()
                .password(form.getPassword())
                .loginId(form.getLoginId())
                .birth(form.getBirth())
                .name(form.getName())
                .build();

        User user = userRepository.save(newUser);

        return new BaseResponseDto<>(user.getUserId());
    }

    public BaseResponseDto<?> getUserInfo(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isEmpty()) {
            log.error("User not found");
            return new BaseResponseDto<>(ErrorMessage.USER_NOT_FOUND);
        }

        User user = userOptional.get();

        return new BaseResponseDto<>(UserResponseDto.of(user.getLoginId(), user.getName(), user.getBirth()));
    }

    public BaseResponseDto<?> createDiary(DiaryRequestDto request) {
        Optional<User> user = userRepository.findById(request.getUserId());

        if (user.isEmpty()) {
            log.error("User not found");
            return new BaseResponseDto<>(DiaryCreateResponseDto.of(false, "존재하지 않는 유저입니다.", null));
        }

        Diary diary = Diary.createDiaryWithUser(
                request.getTitle(),
                request.getContent(),
                request.getEmotion(),
                request.getDate(),
                user.get());

        diaryRepository.save(diary);

        return new BaseResponseDto<>(DiaryCreateResponseDto.of(true, "일기 생성 성공", diary.getDiaryId()));
    }

    public BaseResponseDto<?> getDiaryList(Long userId) {
        Optional<User> user = userRepository.findById(userId);

        if (user.isEmpty()) {
            log.error("User not found");
            return new BaseResponseDto<>(ErrorMessage.USER_NOT_FOUND);
        }

        return new BaseResponseDto<>(diaryRepository.findAllByUserId(userId));
    }

    public BaseResponseDto<?> getEmotionList(Long userId, String month) {
        List<EmotionResponseDto> emotionList = diaryRepository.findEmotionByUserId(userId);

        // get list mm == month
        emotionList.removeIf(emotion -> !emotion.getDate().substring(5, 7).equals(month));

        // yyyy.mm.dd x요일 -> dd
        emotionList.forEach(emotion -> {
            String date = emotion.getDate();
            emotion.setDate(date.substring(8, 10));
        });

        return new BaseResponseDto<>(emotionList);
    }
}
