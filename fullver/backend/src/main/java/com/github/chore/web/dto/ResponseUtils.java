package com.github.chore.web.dto;

import lombok.Builder;
import org.springframework.http.ResponseEntity;

public final class ResponseUtils { // 단순 메세지 전달용으로만 필요해서 상태 저장 필요없음, helper에서 utils로 클래스명 변겯

    // 인스턴스화 방지
    private ResponseUtils() {}

    // 200 OK - 메시지만
    public static ResponseEntity<ResponseDTO<?>> ok(String message) {
        return ResponseEntity.ok(ResponseDTO.success(message));
    }

    // 200 OK - 메시지 + 데이터
    public static ResponseEntity<ResponseDTO<?>> ok(String message, Object data) {
        return ResponseEntity.ok(ResponseDTO.success(message, data));
    }


    // 실패 응답 (상태코드 + 메시지)
    // 기본 상태코드 400으로 처리
    public static ResponseEntity<ResponseDTO<?>> fail(String message) {
        return fail(400, message);
    }

    // 실패 응답 (상태코드 + 메시지)
    public static ResponseEntity<ResponseDTO<?>> fail(int status, String message) {
        return ResponseEntity
                .status(status)
                .body(ResponseDTO.fail(status, message));
    }

    // 실패 응답 (상태코드 + 메시지 + 데이터)
    public static ResponseEntity<ResponseDTO<?>> fail(int status, String message, Object data) {
        return ResponseEntity
                .status(status)
                .body(ResponseDTO.fail(status, message, data));
    }
}
