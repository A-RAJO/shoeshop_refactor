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

    @NotEmpty
    private String userName;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String password;

    @NotEmpty
    private String phoneNum;

    private Role[] roles;
    private String userAddress;
    private Gender gender;
    private String userImg;

}


//      private String user_profile;
//
//
//
//  /**
//   * SignUpDTO를 User 엔티티로 변환하는 메서드
//   * @param signUpDTO 회원가입 DTO
//   * @return User 엔티티
//   */
//  public static User toCreateUser(SignUpDTO signUpDTO, UserRoleService userRoleService) {
//
//    List<UserRole> userRoles=null;
//    if(signUpDTO.getRoles()==null || signUpDTO.getRoles().length == 0) {
//          userRoles = new ArrayList<>();
//          UserRole userRole1 = userRoleService.findByRoleName(Role.BUYER);
//          if (userRole1 == null) {
//            userRole1 = new UserRole();
//            userRole1.setRoleName(Role.SELLER);
//            userRole1 = userRoleService.save(userRole1);
//          }
//           userRoles.add(userRole1);
////          UserRole userRole2 = userRoleService.findByRoleName(Role.SELLER);
////          if (userRole2 == null) {
////            userRole2 = new UserRole();
////            userRole2.setRoleName(Role.SELLER);
////            userRole2 = userRoleService.save(userRole2);
////          }
////          userRoles.add(userRole2);
//
//    }else{
//      userRoles = Arrays.stream(signUpDTO.getRoles())
//              .map(roleName -> {
//                UserRole userRole = userRoleService.findByRoleName(roleName); // 기존 Role을 조회
//                if (userRole == null) {
//                  userRole = new UserRole();
//                  userRole.setRoleName(roleName);
//                  userRole = userRoleService.save(userRole);
//                }
//                return userRole;
//              })
//              .collect(Collectors.toList());
//    }
//
//
//    return User.builder()
//        .userName(signUpDTO.getUser_name())
//        .email(signUpDTO.getUser_email())
//        .password(signUpDTO.getUser_password())
//        .phoneNum(signUpDTO.getUser_phone())
//        .userAddress(signUpDTO.getUser_profile())
//        .userGender("")
//        .user_role(userRoles)
//        .build();
//  }
