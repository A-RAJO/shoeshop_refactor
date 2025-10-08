package com.github.chore.service;

import com.github.chore.exception.DuplicateException;

import com.github.chore.repository.entity.user.User;
import com.github.chore.repository.entity.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
//  private final RefreshTokenRepository refreshTokenRepository;
//  private final JwtTokenProviderService jwtTokenProviderService;


  //형식상 에러는 컨트롤러단에서 하고, 서비스단에서는 비즈니스로직만 검증하기
  public User registerUser(User user) throws DuplicateException {
    validateDuplicateUser(user); // 중복 검사
    userRepository.save(user); // 정상 등록

    return user;
  }

  public void validateDuplicateUser(User user) {
    if (userRepository.existsByUserName(user.getUserName())) {
      throw new DuplicateException("이미 존재하는 사용자 이름입니다.");
    }
    else if (userRepository.existsByEmail(user.getEmail())){
      throw new DuplicateException("이미 존재하는 이메일입니다.");
    }
  }


//  public User getByCredentials(String userName, String password) {
//    return userRepository.findByUserNameAndPassword(userName,password);
//  }
//
//
//  /**
//   * 로그아웃처리
//   * @param loginDTO
//   */
//  public void logout(LoginDTO loginDTO) {
//    User user = userRepository.findByUserName(loginDTO.getUser_name());
//    refreshTokenRepository.deleteByUserUserId(user.getUserId());
//  }
//
//
//  /**
//   * 회원 탈퇴 처리
//   * @param withdrawDTO
//   */
//  public void withdraw(WithdrawDTO withdrawDTO) {
//    User user = userRepository.findByEmail(withdrawDTO.getUser_email()).orElseThrow(null);
//    //1.토큰 삭제
//    refreshTokenRepository.deleteByUserUserId(user.getUserId());
//
//    //2.유저 삭제
//    userRepository.deleteById(user.getUserId());
//  }
//
//
//  /**
//   * 유저 정보 조회
//   * @param token
//   * @return
//   */
//  public UserDTO findByTokenUserInfo(String token){
//
//    try{
//      // 1. 토큰을 이용해 사용자 ID 추출
//      //log.info("1. 토큰을 이용해 사용");
//      String userId = jwtTokenProviderService.validateAndGetUserId(token);
//      //log.info("1. 토큰을 이용해 사용자 ID 추출  :   {}" , userId);
//
//      User user =userRepository.findByUserId(Integer.valueOf(userId));
//
//      // 2. 유저 정보를 반환
//      return UserDTO.of(user);
//    }catch(Exception e){
//      throw new IllegalStateException("유저 정보가 없습니다.");
//    }
//  }



}
