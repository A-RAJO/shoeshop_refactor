package com.github.chore.exception;


import com.github.chore.web.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 예외 함수 커스텀 모음
/**
 * Exception 타입 to ResponseEntity<ResponseDTO<?>> 타입
 * 응답 형식 통일 ResponseEntity<ResponseDTO<?>>
 * 일반 클래스 : ResponseHelper
 * 예외 클래스 : GlobalExceptionHandler
 * */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<ResponseDTO<?>> handleDuplicateException(DuplicateException ex) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(ResponseDTO.fail(409, ex.getMessage()));
    }


    @ExceptionHandler(JwtNotValidException.class)
    public ResponseEntity<ResponseDTO<?>> JwtNotVaildException(JwtNotValidException jnve) {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(ResponseDTO.fail(401, jnve.getMessage()));
    }

    @ExceptionHandler(JwtExpiredException.class)
    public ResponseEntity<ResponseDTO<?>> JwtExpiredException(JwtExpiredException jee) {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(ResponseDTO.fail(401, jee.getMessage()));
    }
    @ExceptionHandler(JwtNotFoundEmailException.class)
    public ResponseEntity<ResponseDTO<?>> JwtNotFoundEmailException(JwtNotFoundEmailException jnfe){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ResponseDTO.fail(404,jnfe.getMessage()));
    }
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ResponseDTO<?>> UserNotFoundException(UserNotFoundException unf){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ResponseDTO.fail(404,unf.getMessage()));
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDTO<?>> handleAll(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ResponseDTO.fail(500, "서버 오류", ex.getMessage()));
    }

}
