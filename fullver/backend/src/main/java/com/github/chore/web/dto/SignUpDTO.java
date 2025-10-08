package com.github.chore.web.dto;

import com.github.chore.repository.entity.role.Role;
import com.github.chore.repository.entity.user.Gender;
import com.github.chore.repository.entity.user.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;




@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignUpDTO {

    public interface Create {}
    public interface Update {}

    @NotEmpty(groups = {Create.class, Update.class})
    private String userName;

    @NotEmpty(groups = {Create.class, Update.class})
    @Email
    private String email;

    @NotEmpty(groups = {Create.class, Update.class})
    private String password;

    @NotEmpty(groups = {Create.class, Update.class})
    private String phoneNum;

    private Role role; // 일대일관계
    private String userAddress;
    private Gender gender;
    private String userImg;


    public static User from(SignUpDTO dto) {
        return User
                .builder()
                .role(dto.getRole()) // enum 타입 그대로 받아옴. 프론트와 role 타입 공유.
                .userName(dto.getUserName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .phoneNum(dto.getPhoneNum())
                .userAddress(dto.getUserAddress())
                .gender(dto.getGender())
                .userImg(dto.getUserImg())
                .build();
    }

}