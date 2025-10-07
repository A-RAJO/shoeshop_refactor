//package com.github.chore.web.dto;
//
//import com.github.chore.repository.entity.user.User;
//import jakarta.validation.constraints.NotEmpty;
//import lombok.*;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@Builder
//public class LoginDTO {
//
//    @NotEmpty(message = "유저 이름은 필수입니다.")
//    private String user_name;
//
//    @NotEmpty(message = "패스워드는 필수입니다.")
//    private String user_password;
//
//
//    public static User toLoginUser(LoginDTO loginDTO) {
//        return User.builder()
//                .userName(loginDTO.getUser_name())
//                .password(loginDTO.getUser_password())
//                .build();
//    }
//}
