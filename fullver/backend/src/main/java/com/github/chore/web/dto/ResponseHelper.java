package com.github.chore.web.dto;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseHelper { // ResponseEntity + ResponseDTO 조합 정리

    // ResponseEntity.메서드명(HTTP 상태 코드, 헤더, 바디 포함 가능)
    // ResponseEntity.status(HttpStatus status).header("X-Custom-Header", "value").body(responseDTO).build();

    public ResponseEntity<ResponseDTO<?>> ok(String message) {
        return ResponseEntity.ok(ResponseDTO.success(message));
    }

    public ResponseEntity<ResponseDTO<?>> ok(String message, Object data) {
        return ResponseEntity.ok(ResponseDTO.success(message,data));
    }

    public ResponseEntity<ResponseDTO<?>> fail(int status, String message) {
        return ResponseEntity.status(status).body(ResponseDTO.fail(status, message));
    }
    public ResponseEntity<ResponseDTO<?>> fail(int status, String message, Exception e) {
        return ResponseEntity.status(status).body(ResponseDTO.fail(status, message));
    }

    public ResponseEntity<ResponseDTO<?>> fail(int status, String message, Object data) {
        return ResponseEntity.status(status).body(ResponseDTO.fail(status, message, data));
    }




}

