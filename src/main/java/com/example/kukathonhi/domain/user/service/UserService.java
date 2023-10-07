package com.example.kukathonhi.domain.user.service;

import com.example.kukathonhi.domain.user.dto.req.RegisterRequestDto;
import com.example.kukathonhi.domain.user.dto.res.UserResponseDto;
import com.example.kukathonhi.domain.user.entity.User;
import com.example.kukathonhi.domain.user.repository.UserRepository;
import com.example.kukathonhi.global.response.BaseResponseDto;
import com.example.kukathonhi.global.response.ErrorMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Optional<User> getUser(Long id) {

        return userRepository.findById(id);
    }

    public BaseResponseDto<?> login(Long id) {
        Optional<User> userOptional = getUser(id);

        if (userOptional.isEmpty()) {
            log.error("User not found");
            return new BaseResponseDto<>(ErrorMessage.USER_NOT_FOUND);
        }

        User user = userOptional.get();

        return new BaseResponseDto<>(UserResponseDto.of(user.getUserId(), user.getEmail()));
    }

    public BaseResponseDto<?> join(RegisterRequestDto form) {
        User newUser = User.builder()
                .password(form.getPassword())
                .email(form.getEmail())
                .build();

        User user = userRepository.save(newUser);

        return new BaseResponseDto<>(user.getUserId());
    }
}
