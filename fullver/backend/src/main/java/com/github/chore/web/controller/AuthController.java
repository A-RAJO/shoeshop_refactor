package com.github.chore.web.controller;

import com.github.chore.config.auth.dto.TokenDTO;
import com.github.chore.repository.entity.user.User;
import com.github.chore.web.dto.ResponseDTO;
import com.github.chore.web.dto.ResponseHelper;
import com.github.chore.web.dto.SignUpDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/auth")
@Slf4j
public class AuthController {

    /**
     * 회원 가입 처리
     * @param signUpDTO 회원가입을 위한 데이터 (유효성 검사됨)
     * @return 성공 또는 실패 메시지와 상태 코드를 포함한 ResponseEntity
    {
    "user_name":"test1",
    "user_email":"test1@gmail.com",
    "user_password":"1111",
    "user_phone":"010-1111-2222",
    "user_profile":"11",
    "roles" :["BUYER", "SELLER"]
    }
     */
    // @Valid : 객체의 필드가 특정 제약 조건을 만족하는지 자동으로 검증
    // @Valid가 적용되면, DTO의 필드 검증 후 통과하지 못하면
    // MethodArgumentNotValidException 발생
    //    BindingResult는 Spring MVC에서 @Valid 또는 @ModelAttribute로 검증한 결과를 담는 객체입니다. = 유효성 검사 결과 저장
    //    즉, DTO 검증 결과를 프로그래머가 직접 확인하고 처리할 수 있게 해주는 역할을 합니다.
    @PostMapping("/sign-up")
    public ResponseEntity<?> registerUser(@Validated @RequestBody SignUpDTO signUpDTO, BindingResult bindingResult) {

        final ResponseHelper responseHelper = null;

        log.info("회원 가입 처리 요청 수신");
        try {
            // 유효성 검사 결과 처리
            if (bindingResult.hasErrors()) {
                String errorMessage = Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage();
                return responseHelper.fail(400,errorMessage, bindingResult);
            }

//            // 회원가입 DTO를 User 엔티티로 변환
//            User user = SignUpDTO.toCreateUser(signUpDTO, userRoleService);
//
//            // 회원가입 처리
//            User registeredUser = userService.registerUser(user);

            //성공응답
            return responseHelper.ok(signUpDTO,"회원가입에 성공했습니다.");

        } catch (Exception e) {
            log.error("회원가입 처리 중 오류 발생: ", e);

            return responseHelper.fail(400,"회원가입에 실패했습니다.",e);

        }
    }

//    /**
//     * 회원가입시 중복확인
//     * @param signUpDTO
//     * @return
//     */
//    @GetMapping("/duplicate")
//    public ResponseEntity<?> duplicate(@RequestBody  SignUpDTO signUpDTO){
//
//        log.info("회원가입시 중복확인 -duplicate :signUpDTO  :{} ", signUpDTO);
//
//        if(StringUtils.hasText(signUpDTO.getUser_name())){
//            boolean isDuplicate = userService.isDuplicateUserName(signUpDTO.getUser_name());
//            if(isDuplicate){
//                return ResponseEntity.ok().body(ResponseDTO.builder()
//                        .status(400)
//                        .message("유저네임이 중복되었습니다.")
//                        .build());
//            }
//        }
//
//        if(StringUtils.hasText(signUpDTO.getUser_email())){
//            boolean isDuplicate = userService.isDuplicateEmail(signUpDTO.getUser_email());
//            if(isDuplicate){
//                return  ResponseEntity.ok().body(ResponseDTO.builder()
//                        .status(400)
//                        .message("이메일이 중복되었습니다.")
//                        .build());
//            }
//        }
//
//        return ResponseEntity.ok().body(ResponseDTO.builder()
//                .status(200)
//                .message("success")
//                .build());
//
//    }
//
//
//    /** auth/login
//     * 로그인 처리
//     * @param loginDTO
//     * @param bindingResult
//     * @return
//     */
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO, BindingResult bindingResult){
//
//        // 1. 유효성 체크 메서드 호출
//        if (bindingResult.hasErrors()) {
//            String errorMessage = Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage();
//            LoginResponseDTO<Object> loginResponseDTO =  LoginResponseDTO.builder()
//                    .status(400)
//                    .message(errorMessage)
//                    .build();
//            return ResponseEntity.badRequest().body(loginResponseDTO);
//        }
//
//
//        User user=userService.getByCredentials(loginDTO.getUser_name(), loginDTO.getUser_password());
//
//
//        if(user!=null){
//            //토큰 생성
//            TokenDTO tokenDTO = jwtTokenProviderService.create(user);
//
//            //.collect(Collectors.joining(","))  // 여러 역할을 ','로 구분하여 하나의 문자열로 합침
//            //.collect(Collectors.toList())  // 리스트로 수집하여 배열 형식으로 반환
//            LoginResponseDTO<?> loginResponseDTO = LoginResponseDTO.builder()
//                    .status(200)
//                    .message("success")
//                    .data(new ResTokenDTO(
//                            tokenDTO.getAccessToken(),
//                            tokenDTO.getRefreshToken(),
//                            user.getUser_role().stream()
//                                    .map(userRole -> userRole.getRoleName().toString())  // Role 열거형을 문자열로 변환
//                                    .collect(Collectors.joining(","))  // 여러 역할을 ','로 구분하여 하나의 문자열로 합침
//                    ))
//                    .build();
//
//            return ResponseEntity.ok().body(loginResponseDTO);
//        }else{
//            LoginResponseDTO<Object> loginResponseDTO =  LoginResponseDTO.builder()
//                    .status(400)
//                    .message("로그인 실패")
//                    .build();
//            return ResponseEntity.badRequest().body(loginResponseDTO);
//        }
//    }
//
//    /**   auth/logout
//     * 로그 아웃 처리
//     * @param loginDTO
//     * @return
//     */
//    @PostMapping("/logout")
//    public ResponseEntity<?> logout(@RequestBody LoginDTO loginDTO){
//        try{
//            //DB 에서 토큰 삭제
//            userService.logout(loginDTO);
//            return ResponseEntity.ok().body(ResponseDTO.builder().status(200).message("Logout successful").build());
//        }catch (Exception e){
//            return ResponseEntity.ok().body(ResponseDTO.builder().status(400).message(e.getMessage()).build());
//        }
//    }
//
//    // auth/withdraw
//    @DeleteMapping("/withdraw")
//    public ResponseEntity<?> withdraw(@RequestBody WithdrawDTO withdrawDTO){
//        try{
//            //DB 에서 토큰 삭제
//            userService.withdraw(withdrawDTO);
//            return ResponseEntity.ok().body(ResponseDTO.builder().status(200).message("success").build());
//        }catch (Exception e){
//            return ResponseEntity.ok().body(ResponseDTO.builder().status(400).message(e.getMessage()).build());
//        }
//    }
//
//    /**
//     *  // auth/refreshToken
//     * @param refreshToken
//     * @return
//     */
//    @PostMapping("/refreshToken")
//    public ResponseEntity<?> reissue(@RequestHeader(value = "refreshToken") String refreshToken) {
//        log.info("접근 토큰 재발행");
//        try {
//            UserDTO reissue = jwtTokenProviderService.reissue(refreshToken);
//            LoginResponseDTO<?> loginResponseDTO = LoginResponseDTO.builder()
//                    .status(200)
//                    .message("success")
//                    .data(new ResTokenDTO(
//                            reissue.getToken().getAccessToken(),
//                            reissue.getToken().getRefreshToken(),
//                            String.join(",", reissue.getUser_role())
//                    ))
//                    .build();
//            return ResponseEntity.ok().body(loginResponseDTO);
//
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body(ResponseDTO.builder().status(400).message("갱신 토큰이 유효하지 않습니다.").build());
//        }
//    }
}
