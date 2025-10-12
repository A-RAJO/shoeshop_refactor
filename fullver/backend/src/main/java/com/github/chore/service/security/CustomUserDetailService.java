package com.github.chore.service.security;

import com.github.chore.exception.UserNotFoundException;
import com.github.chore.repository.entity.user.User;
import com.github.chore.repository.entity.user.UserRepository;
import com.github.chore.repository.entity.user_details.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Primary
@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)  // req 정보에서 DB와 일치하는 데이터 찾기(아이디-이메일로)
                .orElseThrow(() -> new UserNotFoundException("email에 해당하는 user가 없습니다."));


        return CustomUserDetails.fromUser(user); // 이메일로 찾은 user를 user_detail로 변환
    }


}
