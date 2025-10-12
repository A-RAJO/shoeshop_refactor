package com.github.chore.repository.entity.user_details;

import com.github.chore.repository.entity.user.User;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomUserDetails implements UserDetails {

    private Integer userId;
    private String email;
    private String password;
    private List<String> authorities;

    public static CustomUserDetails fromUser(User user){
        List<String> authorities = user.getUserRoles()
                .stream().map(userRole -> String.valueOf(userRole.getRole().getRoleType()))
                .toList();
    return CustomUserDetails.builder()
                .userId(user.getUserId())
                .email(user.getEmail())
                .authorities(authorities)
            .build();
    }

    @Override //계정이 가진 권한 목록을 리턴
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override //계정의 비밀번호를 리턴
    public String getPassword() {
        return this.password;
    }

    @Override //계정의 아이디 등 식별자 리턴
    public String getUsername() {
        return this.email;
    }

    @Override // 계정의 만료 여부 리턴
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override // 계정이 잠겨있는지 리턴
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override // 비밀번호가 만료되었는지 리턴
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override // 계정이 활성화 상태인지
    public boolean isEnabled() {
        return true;
    }
}
