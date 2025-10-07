package com.github.chore.web.dto;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseHelper { // ResponseEntity + ResponseDTO 조합 정리

    // ResponseEntity.메서드명(HTTP 상태 코드, 헤더, 바디 포함 가능)
    // ResponseEntity.status(HttpStatus status).header("X-Custom-Header", "value").body(responseDTO).build();

    public <T> ResponseEntity<ResponseDTO<T>> ok(T data) {
        return ResponseEntity.ok(ResponseDTO.success(data));
    }

    public <T> ResponseEntity<ResponseDTO<T>> ok(T data, String message) {
        return ResponseEntity.ok(ResponseDTO.success(data, message));
    }

    public <T> ResponseEntity<ResponseDTO<T>> fail(int status, String message, T data) {
        return ResponseEntity.status(status).body(ResponseDTO.fail(status, message, data));
    }

    public <T> ResponseEntity<ResponseDTO<T>> fail(String message, T data) {
        return ResponseEntity.status(400).body(ResponseDTO.fail(400, message, data));
    }
}

