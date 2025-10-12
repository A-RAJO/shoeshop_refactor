package com.github.chore.config.auth.jwt;

import com.github.chore.config.auth.dto.JwtProperties;
import com.github.chore.exception.JwtExpiredException;
import com.github.chore.exception.JwtNotFoundEmailException;
import com.github.chore.exception.JwtNotValidException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private final UserDetailsService userDetailsService;
    private final JwtProperties jwtProperties;


    private final String secretKey= Base64.getEncoder()
            .encodeToString("{secretKey}".getBytes());
    SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes());

//    private final long ACCESS_TOKEN_EXPIRE_TIME = 1000 * 60 * 60 * 24; // 24시간
//    private final long REFRESH_TOKEN_EXPIRE_TIME = 1000 * 60 * 60 * 24 * 14; // 14일

    public String createAccessToken(String email, List<String> roles) {
        log.info("[createAccessToken] 토큰 생성 시작");
        Claims claims = Jwts.claims().setSubject(email); // body에 식별자(id)로서 이메일 넣음
        claims.put("roles", roles);
        Date now = new Date();
        String token = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + jwtProperties.getAccessExpirationTime()))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
        log.info("[createAccessToken] 토큰 생성 완료");

        return token;
    }

    public Authentication getAuthentication(String token) {
        log.info("[getAuthentication] 토큰 인증 정보 조회 시작");
        String email = this.getEmailFromToken(token);
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
        log.info("[getAuthentication] 토큰 인증 정보 조회 완료");

        return new UsernamePasswordAuthenticationToken(userDetails,"",userDetails.getAuthorities());
    }

    public String getEmailFromToken(String token) {
        log.info("[getEmailFromToken] 토큰에서 이메일(식별자) 추출 시작");
        try {
            String email = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();  // subject에 email을 넣어뒀다고 가정

            log.info("[getEmailFromToken] 토큰에서 이메일(식별자) 추출 성공");
            return email;
        } catch (Exception e) {
            throw new JwtNotFoundEmailException("토큰에서 이메일을 추출할 수 없습니다.");
        }
    }


    public String resolveToken(HttpServletRequest request) {
        log.info("[resolveToken] 요청에서 헤더 추출 시작");
        String token = request.getHeader("X-AUTH_TOKEN");
        log.info("[resolveToken] 요청에서 헤더 추출 성공");
        return token;
    }

    public void validateToken(String token) {
        try {
            log.info("[validateToken] 토큰 유효성/만료여부 검증 시작");

            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token); //parseClaimsJws : 서명검증(위조여부) + 구조검증(jwt형식여부) + 만료검증 하므로 따로 로직 작성 필요없음
            log.info("[validateToken] 토큰 유효성/만료여부 검증 완료");

        } catch (ExpiredJwtException e) {
            throw new JwtExpiredException("토큰이 만료되었습니다.");
        } catch (JwtException | IllegalArgumentException e) {
            throw new JwtNotValidException("유효하지 않은 토큰입니다.");
        }
    }



    //    public String createRefreshToken() {
//        Date now = new Date();
//        return Jwts.builder()
//                .setIssuedAt(now)
//                .setExpiration(new Date(now.getTime() + REFRESH_TOKEN_EXPIRE_TIME))
//                .signWith(key, SignatureAlgorithm.HS256)
//                .compact();
//    }
//
//    public String reissueAccessToken(String refreshToken, String email, List<String> roles) {
//        if (validateToken(refreshToken)) {
//            return createAccessToken(email, roles);
//        }
//        throw new RuntimeException("리프레시 토큰이 유효하지 않습니다.");
//    }


}